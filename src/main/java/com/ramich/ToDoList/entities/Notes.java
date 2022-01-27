package com.ramich.ToDoList.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "notes")
public class Notes {

    @JacksonXmlElementWrapper(localName = "note", useWrapping = false)
    private List<Note> note;

    public Notes() {
    }

    public Notes(List<Note> note) {
        this.note = note;
    }

    public List<Note> getNote() {
        return note;
    }

    public void setNote(List<Note> note) {
        this.note = note;
    }
}
