package com.benmohammad.orbitmvi.domain.user

sealed class UserProfileStatus {

    data class Result(val userProfile: UserProfile): UserProfileStatus()

    object Loading : UserProfileStatus()

    data class Failure(val error: Throwable): UserProfileStatus()
}