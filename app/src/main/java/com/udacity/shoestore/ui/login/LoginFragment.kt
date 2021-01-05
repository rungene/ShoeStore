package com.udacity.shoestore.ui.login

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController

import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_instructions.*
import timber.log.Timber

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
                .get(LoginViewModel::class.java)
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
                inflater,R.layout.fragment_login,container,false)

        val usernameEditText = binding.username
        val passwordEditText = binding.password
        val loginButton = binding.login
        val loadingProgressBar = binding.loading





        loginViewModel.loginFormState.observe(this,
                Observer { loginFormState ->
                    if (loginFormState == null) {
                        return@Observer
                    }
                    loginButton.isEnabled = loginFormState.isDataValid
                    loginFormState.usernameError?.let {
                        usernameEditText.error = getString(it)
                    }
                    loginFormState.passwordError?.let {
                        passwordEditText.error = getString(it)
                    }
                })

        loginViewModel.loginResult.observe(this,
                Observer { loginResult ->
                    loginResult ?: return@Observer
                    loadingProgressBar.visibility = View.GONE
                    loginResult.error?.let {
                        showLoginFailed(it)
                    }
                    loginResult.success?.let {
                        updateUiWithUser(it)
                    }
                })

        val afterTextChangedListener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // ignore
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // ignore
            }

            override fun afterTextChanged(s: Editable) {
                loginViewModel.loginDataChanged(
                        usernameEditText.text.toString(),
                        passwordEditText.text.toString()
                )
            }
        }
        usernameEditText.addTextChangedListener(afterTextChangedListener)
        passwordEditText.addTextChangedListener(afterTextChangedListener)
        passwordEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                loginViewModel.login(
                        usernameEditText.text.toString(),
                        passwordEditText.text.toString()
                )
            }
            false
        }

        loginButton.setOnClickListener {
            loadingProgressBar.visibility = View.VISIBLE
            loginViewModel.login(
                    usernameEditText.text.toString(),
                    passwordEditText.text.toString()
            )
        }


       loginButton.setOnClickListener {view:View->
            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeScreen())

        }

        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome) + model.displayName
        // TODO : initiate successful logged in experience


        Timber.i("Update with user UI")


        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, welcome, Toast.LENGTH_LONG).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }
}