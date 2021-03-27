package ru.geekbrains.applicationnotesma.domain;

import java.util.List;

public interface NotesRepository {
    List<Note> getNotes();
}
