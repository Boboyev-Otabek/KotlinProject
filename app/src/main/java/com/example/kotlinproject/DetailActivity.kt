package com.example.kotlinproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinproject.model.Member
import com.example.kotlinproject.model.User


class DetailActivity : AppCompatActivity() {
    val TAG = DetailActivity::class.java.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
    }

    fun initViews() {
        val text = findViewById<TextView>(R.id.detail)
        val b_exit = findViewById<Button>(R.id.b_exit)
        b_exit.setOnClickListener {
            val member:Member = Member("Ali", 31)
            back(member)
        }
        val user: User? = intent.getSerializableExtra("user") as User?
        text.setText(user.toString())
    }

    fun back(member: Member?) {
        val intent = Intent()
        intent.putExtra("member", member)
        setResult(RESULT_OK, intent)
        finish()
    }
}