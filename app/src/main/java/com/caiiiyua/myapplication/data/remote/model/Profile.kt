package com.caiiiyua.myapplication.data.remote.model

import java.util.*


/**
 * Created by pp on 22/02/18.
 */
data class Profile(
        val name: Name,
        val email: String,
        val hexColor: String,
        val dateOfBirth: Date,
        val bio: String?,
        val avatar: String?
)