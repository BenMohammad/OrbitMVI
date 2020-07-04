package com.benmohammad.orbitmvi.domain.todo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String
): Parcelable