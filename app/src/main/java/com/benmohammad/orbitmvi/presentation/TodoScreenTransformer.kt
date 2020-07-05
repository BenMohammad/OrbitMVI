package com.benmohammad.orbitmvi.presentation

import com.benmohammad.orbitmvi.domain.todo.GetTodoUseCase
import com.benmohammad.orbitmvi.domain.user.GetUserProfileSwitchesUseCase
import com.benmohammad.orbitmvi.domain.user.GetUserProfileUseCase
import com.benmohammad.orbitmvi.domain.user.UserProfileSwitchesStatus
import io.reactivex.Observable

class TodoScreenTransformer(
    private val todoUseCase: GetTodoUseCase,
    private val getUserProfileSwitchesUseCase: GetUserProfileSwitchesUseCase,
    private val getUserProfileUseCase: GetUserProfileUseCase
) {

    internal fun loadTodos(actions: Observable<Any>) = actions.switchMap { todoUseCase.getTodoList() }

    internal fun loadUserProfileSwitches(actions: Observable<TodoScreenAction.TodoUserSelected>) =
        actions.switchMap { event ->
            getUserProfileSwitchesUseCase.getUserProfileSwitches()
                .map { UserProfileExtra(it, event.userId) }
        }

    internal fun loadUserProfile(actions: Observable<UserProfileExtra>) =
        actions.filter { it.userProfileSwitchStatus is UserProfileSwitchesStatus.Result }
            .map { getUserProfileUseCase.getUserProfile(it.userId)}

}