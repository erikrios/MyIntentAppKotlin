package com.erikriosetiawan.myintentappkotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mahasiswa(val name: String, val nim: Int, val prodi: String): Parcelable