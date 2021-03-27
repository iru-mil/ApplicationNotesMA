package ru.geekbrains.applicationnotesma.ui.notes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.geekbrains.applicationnotesma.domain.MockNotesRepository;
import ru.geekbrains.applicationnotesma.domain.Note;
import ru.geekbrains.applicationnotesma.domain.NotesRepository;

public class NotesViewModel extends ViewModel {
    private final NotesRepository notesRepository = MockNotesRepository.INSTANCE;
    private final MutableLiveData<List<Note>> notesLiveData = new MutableLiveData<>();

    public void fetchNotes() {
        notesLiveData.setValue(notesRepository.getNotes());
    }

    public LiveData<List<Note>> getNotesLiveData() {
        return notesLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
