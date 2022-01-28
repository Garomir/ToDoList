package com.ramich.ToDoList.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ramich.ToDoList.entities.Note;
import com.ramich.ToDoList.entities.Notes;
import com.ramich.ToDoList.entities.User;
import com.ramich.ToDoList.repos.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService{

    private NoteRepo noteRepo;

    @Autowired
    public void setNoteRepo(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    @Override
    public Note addNote(Note note) {
        return noteRepo.save(note);
    }

    @Override
    public void deleteNote(int id) {
        noteRepo.deleteById(id);
    }

    @Override
    public Optional<Note> findNote(int id) {
        return noteRepo.findById(id);
    }

    @Override
    public List<Note> findAllNotes() {
        return noteRepo.findAll();
    }

    @Override
    public Note updateNote(int id, Note note) {
        Optional<Note> note1 = noteRepo.findById(id);
        if (note1.isEmpty()){
            throw new EntityNotFoundException("Такой записи не существует");
        }
        Note updated = note1.get();
        updated.setText(note.getText());
        updated.setDone(note.isDone());
        return noteRepo.save(updated);
    }

    @Override
    public List<Note> findNotesByUserId(int userId) {
        return noteRepo.findNotesByUserId(userId);
    }

    @Override
    public int getNewIdForNote() {
        int result;
        if (noteRepo.getCountOfNotes() == 0){
            result = 1;
        } else {
            result = noteRepo.getMaxValueForId() + 1;
        }
        return result;
    }

    @Override
    public void saveNotesFromXml(String xml, User user) {
        List<Note> notes = parseXml(xml);
        for (Note n : notes) {
            if (n.getId() == 344) {
                //проверка есть ли в бд такой id
                Optional<Note> note = findNote(344);
                if (note.isPresent()){
                    System.out.println("Запись с id: 344 уже существует");
                } else {
                    //если нету, то сохраняю
                    n.setUser(user);
                    addNote(n);
                }
            }else {
                n.setUser(user);
                n.setId(getNewIdForNote());
                addNote(n);
            }
        }
    }

    @Override
    public List<Note> parseXml(String xml){
        //Заменяю угловые скобки на ковычки в тексте одной из заметок, т.к. с ними вылетает исключение
        String newXml = xml.replace("<<Инфотех>>", "\"Инфотех\"");
        ObjectMapper xmlMapper = new XmlMapper();
        Notes notes = null;
        try {
            //маппинг заметок из xml на объект notes
            notes = xmlMapper.readValue(newXml, Notes.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assert notes != null;
        return notes.getNote();
    }
}
