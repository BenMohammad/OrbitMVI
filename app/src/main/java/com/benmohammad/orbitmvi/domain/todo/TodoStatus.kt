package com.benmohammad.orbitmvi.domain.todo

sealed class TodoStatus {

    data class Result(val todoList: List<Todo>): TodoStatus()

    object Loading : TodoStatus()

    data class Failure(val error: Throwable): TodoStatus()
}