package com.example.biometric

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // verifica se pode usar a biometria
        if (BiometricHelper.isBiometricAvailable(this)) {

            // Thread da aplicação
            val executor = ContextCompat.getMainExecutor(this)
            // Logica a ser executada ao interagir com a biomtria
            val bio = BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    val s = ""
                    super.onAuthenticationSucceeded(result)
                }
            })

            // Dados Parte visual da biometria
            val info = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Titulo")
                .setSubtitle("Sub titulo")
                .setDescription("descrição")
                .setNegativeButtonText("Cancelar")
                .build()

            bio.authenticate(info)
        }
    }
}