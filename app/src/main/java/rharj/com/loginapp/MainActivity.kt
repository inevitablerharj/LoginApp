package rharj.com.loginapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var username : EditText? = null
    var password : EditText? = null
    var login : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeControls()
    }

    fun initializeControls(){
            username = findViewById(R.id.username)
            password = findViewById(R.id.password)
            login = findViewById(R.id.button)
            login!!.setOnClickListener{
                val name = username!!.text.toString()
                val pass = password!!.text.toString()
                if(validateControls(this@MainActivity,name,pass)){
                    Toast.makeText(this@MainActivity,"Details are correct",Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun validateControls(context : Context, username : String, password : String) : Boolean{
        if(TextUtils.isEmpty(username)){
            Toast.makeText(context,"Please provide your username",Toast.LENGTH_SHORT).show()
            return false
        }else if(TextUtils.isEmpty(password)){
            Toast.makeText(context,"Please provide your password",Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}
