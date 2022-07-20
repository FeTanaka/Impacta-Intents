package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding?.root

        setContentView(root)


        binding?.activity1Button?.setOnClickListener {
            val intent: Intent = Intent(
                this,
                SecondaryActivity::class.java
            )
            startActivity(intent)
        }
    }
}