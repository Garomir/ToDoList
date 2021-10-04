package com.ramich.ToDoList.services;

import com.ramich.ToDoList.entities.Note;
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
    public Note findNote(int id) {
        Optional<Note> note = noteRepo.findById(id);
        if (note.isEmpty()){
            throw new EntityNotFoundException("Такой записи не существует");
        }
        return note.get();
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
}
