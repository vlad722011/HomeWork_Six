package com.example.Homework_Six.service;


import com.example.Homework_Six.model.PersonalNote;
import com.example.Homework_Six.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;



    public PersonalNote addNote(PersonalNote note) {
        return noteRepository.save(note);
    }

    public List<PersonalNote> getAllNotes(){
        return noteRepository.findAll();
    }

    public Optional<PersonalNote> getNoteById(Long id){
        return noteRepository.findById(id);
    }


    public void deleteNote(Long id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException();
        }
    }


    public PersonalNote updateNote(Long id, PersonalNote note) {
        PersonalNote updateNote = getNoteById(id).orElse(null);
        if (updateNote != null) {
            if (note.getTitle() != null) {
                updateNote.setTitle(note.getTitle());
            }
            if (note.getDescription() != null) {
                updateNote.setDescription(note.getDescription());
            }
            return noteRepository.save(updateNote);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
