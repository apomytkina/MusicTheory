package com.example.musictheory.account.LoginScreen.registration

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.example.musictheory.R
import com.example.musictheory.account.LoginScreen.PersonalAccountFragments
import com.example.musictheory.account.LoginScreen.viewmodel.PersonalAccountViewModel
import com.example.musictheory.databinding.FragmentStudentRegistrationBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class StudentRegistrationFragment : Fragment() {

    private val personalAccountViewModel: PersonalAccountViewModel
            by hiltNavGraphViewModels<PersonalAccountViewModel>(R.id.nested_personal_account)


    private var _binding: FragmentStudentRegistrationBinding? = null
    private val binding get() = _binding!!

    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var mailEditText: EditText

    private lateinit var registerButton: Button

    lateinit var mGoogleSignInClient: GoogleSignInClient

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn
                .getSignedInAccountFromIntent(result.data)
            handleSignInResult(task)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentRegistrationBinding.inflate(inflater, container, false)
        val view = binding.root

        loginEditText = binding.loginEt
        passwordEditText = binding.passwordEt
        mailEditText = binding.mailEt
        registerButton = binding.registerButton

        registerButton.setOnClickListener {
        }

        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this.activity, gso)

        val account = GoogleSignIn.getLastSignedInAccount(context)
        updateUI(account)

        binding.signInButton.setOnClickListener {
            signIn()
        }

        return view
    }

    private fun updateUI(account: GoogleSignInAccount?) {
        personalAccountViewModel.setRegister(PersonalAccountFragments.REGISTRATION)
//        if (account != null) {
//            Toast.makeText(
//                context,
//                "Не авторизован",
//                Toast.LENGTH_SHORT
//            ).show()
//        } else {
//            Toast.makeText(
//                context,
//                "Авторизован",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
    }

    private fun signIn() {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent

        startForResult.launch(signInIntent)
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val idToken = account.idToken
            // Signed in successfully, show authenticated UI.
            updateUI(account)
            Toast.makeText(
                context,
                "Токен: ${idToken ?: "null token"}",
                Toast.LENGTH_SHORT
            ).show()
            Toast.makeText(
                context,
                account?.email ?: "null email",
                Toast.LENGTH_SHORT
            ).show()
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
//            Toast.makeText(context,
//                "signInResult:failed code=" + e.statusCode, Toast.LENGTH_SHORT).show()
            updateUI(null)
        }
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
