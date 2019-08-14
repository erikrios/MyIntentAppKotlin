package com.erikriosetiawan.myintentappkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText

class ResultActivity : AppCompatActivity() {

    companion object {
        const val KEY_NAME = "fafjln8xkh"
        const val KEY_JOB = "ab589KHlmA"
    }

    private lateinit var edtName: EditText
    private lateinit var edtJob: EditText
    private lateinit var btnSendData: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        edtName = findViewById(R.id.edt_name)
        edtJob = findViewById(R.id.edt_job)
        btnSendData = findViewById(R.id.btn_send_data)


        btnSendData.setOnClickListener {

            val name = edtName.text.toString()
            val job = edtJob.text.toString()

            var isEmptyField = false

            if (TextUtils.isEmpty(name)) {
                edtName.error = "Field ini tidak boleh kosong"
                isEmptyField = true
            }

            if (TextUtils.isEmpty(job)) {
                edtJob.error = "Field ini tidak boleh kosong"
                isEmptyField = true
            }

            if (!isEmptyField) {
                val resultIntent = Intent()
                resultIntent.putExtra(KEY_NAME, name)
                resultIntent.putExtra(KEY_JOB, job)
                setResult(MainActivity.RESULT_CODE, resultIntent)
                finish()
            }


        }

    }
}
