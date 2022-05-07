package com.example.kotlinproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinproject.model.Member
import com.example.kotlinproject.model.User

class MainActivity : AppCompatActivity() {
    lateinit var t_home: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        t_home = findViewById(R.id.t_home)
        val open = findViewById<Button>(R.id.open_detail)
        open.setOnClickListener {
            val user = User("Otabek", 21)
            openDetailActivity(user)
        }
    }

    var detailL = registerForActivityResult(
        StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val date = result.data
            val text = date!!.getSerializableExtra("member") as Member?
            t_home.text = text.toString()
        }
    }

    fun openDetailActivity(user: User?) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("user", user)
        detailL.launch(intent)
    }
}