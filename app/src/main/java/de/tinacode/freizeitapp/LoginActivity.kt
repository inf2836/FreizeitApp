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

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_password = findViewById<EditText>(R.id.et_login_password)
        val email = findViewById<TextView>(R.id.et_login_email)
        val password = findViewById<TextView>(R.id.et_login_password)

        btn_login.setOnClickListener {

            when {
                TextUtils.isEmpty(email.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this,
                        "Please enter a email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(password.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this,
                        "Please enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {

                    val email: String = email.text.toString().trim { it <= ' ' }
                    val password = password.text.toString().trim { it <= ' ' }

                    // Login using firebase
                    FirebaseAuth.getInstance()
                        .signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->

                            //if the Login is successfully done
                            if (task.isSuccessful) {

                               // val firebaseUser: FirebaseUser = task.result!!.user!!
                                Toast.makeText(
                                    this,
                                    "you are logged successfully.",
                                    Toast.LENGTH_SHORT
                                ).show()

                                val intent = Intent(this, MainActivity::class.java)
                                intent.putExtra("user", FirebaseAuth.getInstance().currentUser!!.uid)
                                intent.putExtra("email", email)
                                startActivity(intent)
                                finish()
                            } else {

                                // if the login was not successful, show errors

                                Toast.makeText(
                                    this,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()


                            }

                        }

                }
            }



            //if (password.text.equals("1234"))
         /*   val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user", email.text.toString())
            intent.putExtra("email", password.text.toString())
            startActivity(intent)
            finish()*/
        }

        val register = findViewById<TextView>(R.id.tv_register)
        register.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }
}