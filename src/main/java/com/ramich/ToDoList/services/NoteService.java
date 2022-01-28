package com.ramich.ToDoList.services;

import com.ramich.ToDoList.entities.Note;
import com.ramich.ToDoList.entities.User;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    Note addNote(Note note);
    void deleteNote(int id);
    Optional<Note> findNote(int id);
    List<Note> findAllNotes();
    Note updateNote(int id, Note note);
    List<Note> findNotesByUserId(int userId);
    int getNewIdForNote();
    void saveNotesFromXml(String xml, User user);
    public List<Note> parseXml(String xml);
}
