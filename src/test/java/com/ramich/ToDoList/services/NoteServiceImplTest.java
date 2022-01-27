package com.ramich.ToDoList.services;

import com.ramich.ToDoList.entities.Note;
import com.ramich.ToDoList.entities.User;
import com.ramich.ToDoList.repos.NoteRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceImplTest {

    private List<Note> notes = null;

    private final String xml = "<notes xmlns=\"urn://test-todo-list.org\">\n" +
            "    <note>\n" +
            "          <text>Написать резюме</text>\n" +
            "    </note>\n" +
            "    <note>\n" +
            "          <text>Договориться о собеседовании</text>\n" +
            "    </note>\n" +
            "    <note id=\"344\" done=\"true\">\n" +
            "          <text>Устроиться на работу в <<Инфотех>></text>\n" +
            "    </note>\n" +
            "</notes>";

    @Mock
    private NoteRepo noteRepo;
    @InjectMocks
    private NoteServiceImpl noteService;

    @Before
    public void setUp() {
        //notes = noteService.parseXml(xml);
    }

    @Test
    public void testXml(){
        Mockito.when(noteRepo.findById(344)).thenReturn(null);
        Mockito.when(noteRepo.getCountOfNotes()).thenReturn(2);
        Mockito.when(noteRepo.getMaxValueForId()).thenReturn(2);
        Mockito.when(noteRepo.save(Mockito.any())).thenReturn(notes.add(Mockito.any()));
        noteService.saveNotesFromXml(xml, new User());
        assertEquals(3, notes.size());
        assertEquals(344, notes.get(2).getId());
    }
}