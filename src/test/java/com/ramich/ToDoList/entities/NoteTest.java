package com.ramich.ToDoList.entities;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NoteTest {

    private Note note;
    private Note note2;
    private Note note3;

    @Before
    public void setUp() {
        note = new Note(1, "test1", false);
        note2 = new Note(1, "test1", false);
        note3 = new Note(2, "test2", true);
    }

    @Test
    public void checkFields(){
        assertEquals(1, note.getId());
        assertEquals("test1", note.getText());
        assertFalse(note.isDone());
    }

    @Test
    public void equalsNotes(){
        assertEquals(note, note2);
    }

    @Test
    public void notEqualsNotes(){
        assertNotEquals(note, note3);
    }
}