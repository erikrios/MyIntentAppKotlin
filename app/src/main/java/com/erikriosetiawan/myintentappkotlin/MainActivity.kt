package com.erikriosetiawan.myintentappkotlin

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.erikriosetiawan.myintentappkotlin.model.Mahasiswa

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveActivityData: Button
    private lateinit var btnMoveActivityObject: Button
    private lateinit var btnDialNumber: Button
    private lateinit var btnMoveActivityResult: Button
    private lateinit var tvActivityResult: TextView

    companion object {
        const val REQUEST_CODE = 100
        const val RESULT_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivityData = findViewById(R.id.btn_move_activity_data)
        btnMoveActivityObject = findViewById(R.id.btn_move_activity_object)
        btnDialNumber = findViewById(R.id.btn_dial_number)
        btnMoveActivityResult = findViewById(R.id.btn_move_activity_result)
        tvActivityResult = findViewById(R.id.tv_activity_result)

        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityData.setOnClickListener(this)
        btnMoveActivityObject.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
        btnMoveActivityResult.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {
                val moveDataIntent = Intent(this@MainActivity, MoveActivity::class.java)
                moveDataIntent.putExtra(MoveActivity.DATA_KEY_INTENT, MoveActivity.DATA_VALUE_INTENT)
                moveDataIntent.putExtra(MoveActivity.DATA_KEY_NAME, "Erik Rio Setiawan")
                moveDataIntent.putExtra(MoveActivity.DATA_KEY_AGE, 21)
                startActivity(moveDataIntent)
            }
            R.id.btn_move_activity_object -> {
                val mahasiswa = Mahasiswa("Erik Rio Setiawan", 18532968, "Teknik Informatika")
                val dataObjectIntent = Intent(this@MainActivity, MoveActivity::class.java)
                dataObjectIntent.putExtra(MoveActivity.DATA_KEY_INTENT, MoveActivity.DATA_OBJECT_INTENT)
                dataObjectIntent.putExtra(MoveActivity.DATA_KEY_OBJECT, mahasiswa)
                startActivity(dataObjectIntent)
            }
            R.id.btn_dial_number -> {
                val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:083854050592"))
                startActivity(dialIntent)
            }
            R.id.btn_move_activity_result -> {
                val resultIntent = Intent(this@MainActivity, ResultActivity::class.java)
                startActivityForResult(resultIntent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CODE) {
                val name = data!!.getStringExtra(ResultActivity.KEY_NAME)
                val job = data.getStringExtra(ResultActivity.KEY_JOB)
                val myDesc = "My name is $name and I'm a $job"
                tvActivityResult.text = myDesc
            }
        }
    }
}
