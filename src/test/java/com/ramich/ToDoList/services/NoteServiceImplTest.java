package com.ramich.ToDoList.services;

import com.ramich.ToDoList.entities.Note;
import com.ramich.ToDoList.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-integrationtest.properties")
@Sql(value = {"/create-tables-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-tables-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class NoteServiceImplTest {

    @Autowired
    private NoteServiceImpl noteService;

    @Autowired
    private UserServiceImpl userService;

    @Test //тест парсинга xml в List<Note>
    public void parseXmlTest() {
        String xml = "<notes xmlns=\"urn://test-todo-list.org\">\n" +
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

        List<Note> notes = noteService.parseXml(xml);
        for (Note n : notes) {
            System.out.println(n.getId() + ", " + n.getText() + ", " + n.isDone() + ", " + n.getUser());
        }
        assertEquals(3, notes.size());
    }

    @Test //тест сохранения одной заметки в бд
    public void saveNoteTest(){
        Note note = new Note(344, "Устроиться на работу в \"Инфотех\"", true);
        User user = new User();
        user.setUsername("Ramil");
        user.setPassword("Ramil");
        User savedUser = userService.saveUser(user);
        note.setUser(savedUser);
        Note savedNote = noteService.addNote(note);
        assertEquals(344, savedNote.getId());
    }

    @Test //тест парсинга xml в List<Note> и сохранения их в бд
    public void parseAndSaveNotesTest() {
        String xml = "<notes xmlns=\"urn://test-todo-list.org\">\n" +
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

        User user = new User();
        user.setUsername("Ramil");
        user.setPassword("Ramil");
        User savedUser = userService.saveUser(user);

        noteService.saveNotesFromXml(xml, savedUser);
        List<Note> notes = noteService.findNotesByUserId(savedUser.getId());

        assertEquals(3, notes.size());
        assertEquals("Устроиться на работу в \"Инфотех\"", notes.get(2).getText());
        assertEquals(344, notes.get(2).getId());
    }
}