package com.benmohammad.orbitmvi.network

import com.benmohammad.orbitmvi.domain.user.UserProfile
import com.benmohammad.orbitmvi.domain.user.UserProfileSwitches
import io.reactivex.Single

interface UserService {

    fun getUserProfileSwitches(): Single<UserProfileSwitches>

    fun getUserProfile(): Single<UserProfile>
}