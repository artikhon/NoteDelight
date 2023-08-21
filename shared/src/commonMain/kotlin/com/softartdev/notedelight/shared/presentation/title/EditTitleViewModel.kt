package com.softartdev.notedelight.shared.presentation.title

import com.softartdev.notedelight.shared.base.BaseViewModel
import com.softartdev.notedelight.shared.data.NoteUseCase


class EditTitleViewModel (
        private val noteUseCase: NoteUseCase
) : BaseViewModel<EditTitleResult>() {

    override val loadingResult: EditTitleResult = EditTitleResult.Loading

    fun loadTitle(noteId: Long) = launch {
        val note = noteUseCase.loadNote(noteId)
        EditTitleResult.Loaded(note.title)
    }

    fun editTitle(id: Long, newTitle: String) = launch {
        val (noteId, noteTitle) = id to newTitle.trim()
        when {
            noteTitle.isEmpty() -> EditTitleResult.EmptyTitleError
            else -> {
                noteUseCase.updateTitle(noteId, noteTitle)
                noteUseCase.titleChannel.send(noteTitle)
                EditTitleResult.Success
            }
        }
    }

    override fun errorResult(throwable: Throwable) = EditTitleResult.Error(throwable.message)
}
