package com.example.musictheory.account.student.registration

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
import com.example.musictheory.R
import com.example.musictheory.databinding.FragmentStudentRegistrationBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class StudentRegistrationFragment : Fragment() {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    fun updateUI(account: GoogleSignInAccount?) {
        if (account != null) {
            Toast.makeText(
                context,
                "Не авторизован",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(
                context,
                "Авторизован",
                Toast.LENGTH_SHORT
            ).show()
        }
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
                "Начало токена: ${idToken ?: "null token"}",
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
