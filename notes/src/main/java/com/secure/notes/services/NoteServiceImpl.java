package com.secure.notes.services;

import com.secure.notes.models.Note;
import com.secure.notes.repos.NoteRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NoteServiceImpl {

    @Autowired
    NoteRepo noteRepo;

    public Note createNote(Note note) {
        return noteRepo.save(note);
    }

    public Note createNoteForUser(String userName, String content) {
        Note note = new Note();
        note.setOwnerUserName(userName);
        note.setContent(content);
        log.info("Create Notes done");
        return noteRepo.save(note);
    }

    public Note updateNote(long id, Note note) {
        Note note1 = noteRepo.findById(id).orElseThrow();
        note1.setContent(note.getContent());
        return noteRepo.save(note1);
    }

    public Note updateNoteForUser(long id, String content, String userName) {
        Note note1 = noteRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Note not found") );
        note1.setContent(content);
        return noteRepo.save(note1);
    }

    public void deleteNote(long id)
    {
        noteRepo.deleteById(id);
    }

    public List<Note> getNotesForUser(String user) {
        List<Note> userNotes = noteRepo.findByOwnerUserName(user);
        return userNotes;
    }
}
