package com.ramich.ToDoList.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ramich.ToDoList.entities.Note;
import com.ramich.ToDoList.entities.Notes;
import com.ramich.ToDoList.entities.Role;
import com.ramich.ToDoList.entities.User;
import com.ramich.ToDoList.services.NoteService;
import com.ramich.ToDoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/notes")
public class NotesController {

    private NoteService noteService;

    private UserService userService;

    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String notesPage(Model model, Principal principal){
        User user = userService.findByUsername(principal.getName());
        Role role = user.getRoles().stream().findFirst().orElseThrow();
        List<Note> notes = noteService.findNotesByUserId(user.getId());
        model.addAttribute("notes", notes);
        model.addAttribute("role", role.getName());
        model.addAttribute("note", new Note());
        //model.addAttribute("xmlnotes", new Note());
        model.addAttribute("username", principal.getName());
        return "notes";
    }

    @PostMapping
    public String addNote(@ModelAttribute(value = "note") Note note, Principal principal){
        User user = userService.findByUsername(principal.getName());
        note.setUser(user);
        Note note1 = noteService.addNote(note);
        return "redirect:/notes";
    }

    @PostMapping(value = "/xml"/*, produces = MediaType.APPLICATION_XML_VALUE*/)
    public String addXmlNotes(@RequestParam String xmlnotes, Principal principal){
        User user = userService.findByUsername(principal.getName());

        ObjectMapper xmlMapper = new XmlMapper();
        Notes notes = null;
        try {
            notes = xmlMapper.readValue(xmlnotes, Notes.class);
            for (Note n : notes.getNote()) {
                if (n.getId() == 344) {
                    n.setId(344);
                }
                n.setUser(user);
                noteService.addNote(n);
                //System.out.println(n.getText() + ", " + n.isDone() + ", " + n.getId());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "redirect:/notes";
    }

    @GetMapping("/{id}")
    public String deleteNote(@PathVariable("id") int id){
        noteService.deleteNote(id);
        return "redirect:/notes";
    }

    @PostMapping("/{id}")
    public String setDone(@PathVariable("id") int id,
                          @ModelAttribute(value = "done") String done){
        Note note = noteService.findNote(id);
        if (done.equals("on")){
            note.setDone(true);
        } else {
            note.setDone(false);
        }
        noteService.updateNote(id, note);
        return "redirect:/notes";
    }
}
