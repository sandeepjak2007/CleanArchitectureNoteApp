package code.sandeep.cleanarchitecturenoteapp.feature_note.presentation.notes

import code.sandeep.cleanarchitecturenoteapp.feature_note.domain.model.Note
import code.sandeep.cleanarchitecturenoteapp.feature_note.domain.util.NoteOrder
import code.sandeep.cleanarchitecturenoteapp.feature_note.domain.util.OrderType

data class NotesState(
    val notes:List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible:Boolean = false
)
