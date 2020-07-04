package com.benmohammad.orbitmvi.domain.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserProfile(
    val id: Int,
    val name: String,
    val email: String
): Parcelable