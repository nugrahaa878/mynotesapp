package com.nugrahaa.mynotesapp.helper

import android.database.Cursor
import android.provider.ContactsContract
import com.nugrahaa.mynotesapp.db.DatabaseContract
import com.nugrahaa.mynotesapp.entity.Note

object MappingHelper {

    fun mapCursorToArrayist(notesCursor: Cursor?): ArrayList<Note> {
        val notesList = ArrayList<Note>()

        notesCursor?.apply {
            while(moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
                val title = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
                val description = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
                notesList.add(Note(id, title, description, date))
            }
        }

        return notesList
    }
}