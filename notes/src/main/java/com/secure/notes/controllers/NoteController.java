package com.secure.notes.controllers;

import com.secure.notes.models.Note;
import com.secure.notes.services.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    NoteServiceImpl noteService;

    @PostMapping
    public Note createNoteForUser(@AuthenticationPrincipal UserDetails userDetails, @RequestBody String content) {
        return noteService.createNoteForUser(userDetails.getUsername(), content);
    }


//    public Note updateNote(long id, Note note) {
//        Note note1 = noteRepo.findById(id).orElseThrow();
//        note1.setContent(note.getContent());
//        return noteRepo.save(note1);
//    }

    @PutMapping("/{noteId}")
    public Note updateNoteForUser(@PathVariable long id, @RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
        return noteService.updateNoteForUser(id, content, userDetails.getUsername());
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable long id)
    {
        noteService.deleteNote(id);
    }

    @GetMapping
    public List<Note> getNotesForUser(@AuthenticationPrincipal UserDetails userDetails) {
        return noteService.getNotesForUser(userDetails.getUsername());
    }

}
