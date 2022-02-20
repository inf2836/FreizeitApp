package de.tinacode.freizeitapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        findViewById<TextView>(R.id.tf_login)
            .setOnClickListener {
                startActivity(Intent(this, LoginActivity::class.java))
            }

        val btnRegister = findViewById<Button>(R.id.btn_register)
        val registerMail = findViewById<EditText>(R.id.et_register_email)
        val registerPassword = findViewById<EditText>(R.id.et_register_password)

        btnRegister.setOnClickListener {

            when {
                TextUtils.isEmpty(registerMail.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this,
                        "Please enter a email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(registerPassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this,
                        "Please enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {

                    val email: String = registerMail.text.toString().trim { it <= ' ' }
                    val password = registerPassword.text.toString().trim { it <= ' ' }

                    // create a register with Email and Password
                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->

                            //if the registration is successfully done
                            if (task.isSuccessful) {
                                // Firebase registred User
                                val firebaseUser: FirebaseUser = task.result!!.user!!
                                Toast.makeText(
                                    this,
                                    "you are registred successfully.",
                                    Toast.LENGTH_SHORT
                                ).show()

                                val intent = Intent(this, MainActivity::class.java)
                                intent.putExtra("user", firebaseUser.uid)
                                intent.putExtra("email", email)
                                startActivity(intent)
                                finish()
                            } else {

                                // if the register was not successfull, show errors

                                Toast.makeText(
                                    this,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()


                            }

                        }

                }
            }


        }

    }
}