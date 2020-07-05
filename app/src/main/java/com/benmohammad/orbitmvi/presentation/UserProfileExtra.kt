package com.benmohammad.orbitmvi.presentation

import com.benmohammad.orbitmvi.domain.user.UserProfileSwitchesStatus

data class UserProfileExtra(
    val userProfileSwitchStatus: UserProfileSwitchesStatus,
    val userId: Int
)