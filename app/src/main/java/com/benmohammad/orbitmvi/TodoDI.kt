package com.benmohammad.orbitmvi

import androidx.lifecycle.SavedStateHandle
import com.benmohammad.orbitmvi.domain.analytics.AnalyticsManager
import com.benmohammad.orbitmvi.domain.analytics.AnalyticsManagerImpl
import com.benmohammad.orbitmvi.domain.todo.GetTodoUseCase
import com.benmohammad.orbitmvi.domain.user.GetUserProfileSwitchesUseCase
import com.benmohammad.orbitmvi.domain.user.GetUserProfileUseCase
import com.benmohammad.orbitmvi.network.TodoService
import com.benmohammad.orbitmvi.network.TodoServiceImpl
import com.benmohammad.orbitmvi.network.UserService
import com.benmohammad.orbitmvi.network.UserServiceImpl
import com.benmohammad.orbitmvi.presentation.TodoScreenReducer
import com.benmohammad.orbitmvi.presentation.TodoScreenSideEffect
import com.benmohammad.orbitmvi.presentation.TodoScreenTransformer
import com.benmohammad.orbitmvi.presentation.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModule = module {
    single { GetTodoUseCase(get()) }
    single<TodoService> { TodoServiceImpl()}
    single<AnalyticsManager> {AnalyticsManagerImpl()}
    single<UserService> {UserServiceImpl()}
    single {GetUserProfileSwitchesUseCase(get())}
    single {GetUserProfileUseCase(get())}
}

val presentationModule = module {
    single {TodoScreenTransformer(get(), get(), get())}
    single { TodoScreenReducer() }
    single {TodoScreenSideEffect(get())}
    viewModel { (handle: SavedStateHandle) -> TodoViewModel(handle, get(), get(), get()) }
}