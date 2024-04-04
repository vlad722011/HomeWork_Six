package com.example.Homework_Six.repository;

import com.example.Homework_Six.model.PersonalNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<PersonalNote, Long> {
}