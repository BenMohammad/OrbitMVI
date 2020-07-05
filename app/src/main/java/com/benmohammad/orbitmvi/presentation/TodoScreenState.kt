package com.benmohammad.orbitmvi.presentation

import android.os.Parcelable
import com.benmohammad.orbitmvi.domain.todo.Todo
import com.benmohammad.orbitmvi.domain.user.UserProfile
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TodoScreenState(
    val screenState: ScreenState = ScreenState.Loading,
    val todoList: List<Todo>? = null,
    val todoSelectedId: Int? = null,
    val userProfile: UserProfile? = null

) : Parcelable

enum class ScreenState {
    Loading,
    Ready,
    Error
}