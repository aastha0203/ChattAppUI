package com.example.uigossip.data




import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.uigossip.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val id: Int = 0,
    val name: String = "",
    @DrawableRes val icon: Int = R.drawable.baseline_person_24
) : Parcelable

val personList = listOf(
    Person(

        1,
        "Yash",
        R.drawable.baseline_person_24
    ),
    Person(
        2,
        "Anugya",
        R.drawable.baseline_person_24
    ),
    Person(
        3,
        "Riddhi",
        R.drawable.baseline_person_24
    ),
    Person(
        4,
        "Aditi",
        R.drawable.baseline_person_24
    ),
    Person(
        5,
        "Shiwangita",
        R.drawable.baseline_person_24
    ),
    Person(
        6,
        "Isha",
        R.drawable.baseline_person_24
    ),
    Person(
        7,
        "Avni",
        R.drawable.baseline_person_24
    ),
    Person(
        8,
        "Roshini",
        R.drawable.baseline_person_24
    ),
    Person(
        9,
        "Kriti",
        R.drawable.baseline_person_24
    ),
    Person(
        10,
        "Ashutosh",
        R.drawable.baseline_person_24
    ),
)