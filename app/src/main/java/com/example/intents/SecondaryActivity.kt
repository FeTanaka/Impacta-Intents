package com.example.intents

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import com.example.intents.databinding.ActivitySecondaryBinding

class SecondaryActivity : AppCompatActivity() {

    var binding: ActivitySecondaryBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        val root = binding?.root

        setContentView(root)

        binding?.btnWebsite?.setOnClickListener {
            val uri = Uri.parse("http://www.google.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding?.btnEmail?.setOnClickListener {
            val email = "contato@impacta.com.br"
            val assunto = "Olá"
            val texto = "Boa noite"


            val intent = Intent(Intent.ACTION_SENDTO).apply {
                type = "text/plain"
                data = Uri.parse("mailto:")
            }
            intent.putExtra(Intent.EXTRA_EMAIL, email)
            intent.putExtra(Intent.EXTRA_SUBJECT, assunto)
            intent.putExtra(Intent.EXTRA_TEXT, texto)

            startActivity(intent)
        }

        binding?.btnCompartilhar?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
            }
            val mensagem = "Olá, gostaria de compartilhar com você"
            intent.putExtra(Intent.EXTRA_TEXT, mensagem)

            startActivity(intent)
        }

        binding?.btnMaps?.setOnClickListener {
            val latitude = "0"
            val longitude = "0"
            val query = "1600 Amphitheatre Parkway, CA"
            val zoomLevel = "10"
            val intent = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("geo:$latitude,$longitude?q=$query&z=$zoomLevel")
            }
            startActivity(intent)
        }

        binding?.btnCamera?.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 1)
        }

        binding?.btnLigacao?.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_CALL
                data = Uri.parse("tel:999999999")
            }
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.READ_CONTACTS
                    )
                ) {

                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        1
                    )
                }
                startActivity(intent)
            }
        }

        binding?.btnSms?.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                data = Uri.parse("smsto:999999999")
            }
            val message = "Olá, boa noite"
            intent.putExtra("sms_body", message)
            startActivity(intent)
        }

    }
}