package com.benmohammad.orbitmvi.network

import com.benmohammad.orbitmvi.domain.todo.Todo
import io.reactivex.Single

interface TodoService {

    fun getTodo(): Single<List<Todo>>
}