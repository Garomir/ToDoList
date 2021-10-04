package com.ramich.ToDoList.repos;

import com.ramich.ToDoList.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {
    @Query(value = "select * from notes where user_id = :userId",nativeQuery = true)
    List<Note> findNotesByUserId(@Param("userId") int userId);
}
