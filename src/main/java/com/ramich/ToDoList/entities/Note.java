package com.ramich.ToDoList.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "notes")
public class Note {

    //@Transient, если нет необходимости в отображении какого-либо атрибута на БД,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "text")
    private String text;
    @Column(name = "done")
    private boolean done;

    public Note() {
    }

    public Note(int id, String text, boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id &&
                done == note.done &&
                Objects.equals(text, note.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, done);
    }
}
