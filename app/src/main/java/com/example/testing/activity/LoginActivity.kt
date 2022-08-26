package com.example.testing.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.testing.R
import com.example.testing.databinding.ActivityLoginBinding
import com.example.testing.utils.Utils

class LoginActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.apply {

            etPassword.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(p0: Editable?) {
                    val email = etEmail.text
                    if (email.isNotEmpty() && p0!!.isNotEmpty()) {
                        bLogIn.isEnabled = true
                    }else {
                        bLogIn.isEnabled = false
                    }
                }
            })

            bLogIn.setOnClickListener {
                val email = etEmail.text.toString().trim()
                val password = etPassword.text.toString().trim()
                if (email == (Utils.EMAIL) && password == (Utils.PASSWORD)) {
                    tvMessage.text = getString(R.string.str_success)
                }else {
                    tvMessage.text = getString(R.string.str_failure)
                }
            }
        }
    }
}