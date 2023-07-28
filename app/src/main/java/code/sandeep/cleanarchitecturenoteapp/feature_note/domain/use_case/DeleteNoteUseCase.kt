package code.sandeep.cleanarchitecturenoteapp.feature_note.domain.use_case

import code.sandeep.cleanarchitecturenoteapp.feature_note.domain.model.Note
import code.sandeep.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}