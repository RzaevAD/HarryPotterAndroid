package com.loftblog.hogwardtslibrary.ui.hat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.loftblog.hogwardtslibrary.R
import com.loftblog.hogwardtslibrary.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_hat.*

class HatActivity : AppCompatActivity() {
    private lateinit var hatViewModel: HatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hat)
        hatViewModel = ViewModelProviders.of(this).get(HatViewModel::class.java)

        textWelcomeUserName.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                hatViewModel.applyUserName(name = s.toString())
            }

        })

        btnWelcomeSelect.setOnClickListener {
            hatViewModel.getFacultyName()
        }

        btnWelcomeSelect.setOnClickListener {
            if (btnWelcomeSelect.text == getString(R.string.welcome_next)) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                hatViewModel.getFacultyName()
            }
        }

        setupFaculty(viewModel = hatViewModel)
        setupLoading(viewModel = hatViewModel)
    }

    private fun setupFaculty(viewModel: HatViewModel) {
        viewModel.facultyName.observe(this, Observer { facultyName->
            if (facultyName.isNotEmpty()) {
                textWelcomeSelected.text = getString(R.string.welcome_selected)
                    .replace("[faculty_name]", facultyName)
                textWelcomeSelected.visibility = View.VISIBLE
                textWelcomeSelected.isEnabled = false
                btnWelcomeSelect.text = getString(R.string.welcome_next)
            }
        })
    }

    private fun setupLoading(viewModel: HatViewModel) {
        viewModel.isLoading.observe(this, Observer{ isLoading ->
            textWelcomeUserName.isEnabled = !isLoading
            btnWelcomeSelect.isEnabled = !isLoading

            if (isLoading) {
                btnWelcomeSelect.text = getString(R.string.welcome_selecting)
            }
        })
    }
}