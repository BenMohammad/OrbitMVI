package com.benmohammad.orbitmvi.presentation

import com.benmohammad.orbitmvi.domain.analytics.AnalyticsManager

class TodoScreenSideEffect(
    private val analyticsManager: AnalyticsManager
) {

    internal fun trackSelectedTodo(action: TodoScreenAction.TodoSelected) =
        analyticsManager.trackAnalytics(action.todoId.toString())
}