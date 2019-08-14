package com.erikriosetiawan.myintentappkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.erikriosetiawan.myintentappkotlin.model.Mahasiswa

class MoveActivity : AppCompatActivity() {

    private lateinit var tvActivityData: TextView

    companion object {
        const val DATA_KEY_INTENT = "hGfak85MnA"
        const val DATA_VALUE_INTENT = "DataIntent"
        const val DATA_OBJECT_INTENT = "ObjectIntent"
        const val DATA_KEY_NAME = "uifaekjlab"
        const val DATA_KEY_AGE = "8hjnkAljig"
        const val DATA_KEY_OBJECT = "AbF32lklae"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)

        tvActivityData = findViewById(R.id.tv_activity_data)

        when (intent.getStringExtra(DATA_KEY_INTENT)) {
            DATA_VALUE_INTENT -> {
                val name = intent.getStringExtra(DATA_KEY_NAME)
                val age = intent.getIntExtra(DATA_KEY_AGE, 0)

                val myDescription = "My name is $name\nand I'm $age years old."

                tvActivityData.text = myDescription
            }
            DATA_OBJECT_INTENT -> {
                val dataMahasiswa = intent.getParcelableExtra<Mahasiswa>(DATA_KEY_OBJECT)

                val myDescription =
                    "Hello my friend, my Name is ${dataMahasiswa.name}\nMy NIM is ${dataMahasiswa.nim}\nAnd I'm studying in ${dataMahasiswa.prodi}"

                tvActivityData.text = myDescription
            }
        }
    }
}
