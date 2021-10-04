package com.ramich.ToDoList.controllers;

import com.ramich.ToDoList.entities.Note;
import com.ramich.ToDoList.entities.User;
import com.ramich.ToDoList.services.NoteService;
import com.ramich.ToDoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Note> notes = noteService.findNotesByUserId(user.getId());
        model.addAttribute("notes", notes);
        model.addAttribute("note", new Note());
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

    @GetMapping("/{id}")
    public String deleteNote(@PathVariable("id") int id){
        noteService.deleteNote(id);
        return "redirect:/notes";
    }

    @PostMapping("/{id}")
    public String setDone(@PathVariable("id") int id,
                          @ModelAttribute(value = "done") boolean done){
        Note note = noteService.findNote(id);
        note.setDone(done);
        noteService.updateNote(id, note);
        return "redirect:/notes";
    }
}
