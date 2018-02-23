package com.caiiiyua.myapplication

import com.caiiiyua.myapplication.data.remote.model.Name
import com.caiiiyua.myapplication.data.remote.model.Profile
import com.caiiiyua.myapplication.data.remote.model.Ribot
import java.util.*

/**
 * Created by pp on 23/02/18.
 */
object TestDataFactory {

    @JvmStatic
    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    @JvmStatic
    fun makeRibot(uniqueSuffix: String): Ribot {
        return Ribot(makeProfile(uniqueSuffix))
    }

    @JvmStatic
    fun makeListRibots(number: Int): List<Ribot> {
        val ribots = ArrayList<Ribot>()
        for (i in 0..number.dec()) {
            ribots.add(makeRibot(i.toString()))
        }
        return ribots
    }

    @JvmStatic
    fun makeProfile(uniqueSuffix: String): Profile {
        return Profile(
                name = makeName(uniqueSuffix),
                email = "email$uniqueSuffix@ribot.co.uk",
                hexColor = "#0066FF",
                dateOfBirth = Date(),
                bio = randomUuid(),
                avatar = "http://api.ribot.io/images/" + uniqueSuffix)
    }

    @JvmStatic
    fun makeName(uniqueSuffix: String): Name {
        return Name("Name-" + uniqueSuffix, "Surname-" + uniqueSuffix)
    }
}