package com.benmohammad.orbitmvi.presentation

sealed class TodoScreenAction {

    object RetryAction : TodoScreenAction()

    data class TodoSelected(val todoId: Int): TodoScreenAction()

    data class TodoUserSelected(val userId: Int): TodoScreenAction()

    object TodoSelectedDismissed: TodoScreenAction()

    object UserSelectedDismissed: TodoScreenAction()
}