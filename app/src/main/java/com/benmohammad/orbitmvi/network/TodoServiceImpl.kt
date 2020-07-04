package com.benmohammad.orbitmvi.network

import com.benmohammad.orbitmvi.domain.todo.Todo
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class TodoServiceImpl: TodoService {

    override fun getTodo(): Single<List<Todo>> {
        return Single.just(listOf(
            Todo(1, 1, "First todo"),
            Todo(2, 2, "Second todo"),
            Todo(3, 3, "Third todo"),
            Todo(4, 4, "Fourth todo"),
            Todo(5, 5, "Fifth todo"),
            Todo(6, 6, "Sixth todo")
        )).delay(2, TimeUnit.SECONDS)
    }
}