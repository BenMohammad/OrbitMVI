package com.benmohammad.orbitmvi.presentation.ui

import android.content.res.Resources
import com.benmohammad.orbitmvi.R
import com.benmohammad.orbitmvi.domain.todo.Todo
import com.benmohammad.orbitmvi.presentation.TodoScreenAction
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.viewholder_todo_item.view.*

data class ToDoItem(
    private val resources: Resources,
    private val clickListener: (Any) -> Unit,
    private val todo: Todo
): Item() {

    override fun getId() = todo.id.toLong()

    override fun getLayout() = R.layout.viewholder_todo_item



    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.containerView) {
            setOnClickListener {
                clickListener(TodoScreenAction.TodoSelected(todo.userId))
            }

            setOnLongClickListener {
                clickListener(TodoScreenAction.TodoUserSelected(todo.userId))
                true
            }

            todoId.text = resources.getString(R.string.todo_id, todo.id)
            userId.text = resources.getString(R.string.todo_user_id, todo.userId)
            todoTitle.text = todo.title
        }
    }
}