package com.example.fragment_test2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_register.*
import org.json.JSONException
import org.json.JSONObject

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        join_btn.setOnClickListener {

            if (edit_id.text.toString() == null || edit_pass.text.toString() == null ||
                edit_name.text.toString() == null || edit_age.text.toString() == null ||
                edit_email.text.toString() == null || edit_id.text.toString().equals("") ||
                edit_pass.text.toString().equals("") || edit_email.text.toString().equals("") ||
                edit_age.text.toString().equals("") || edit_name.text.toString().equals("")
            ) {
                Toast.makeText(applicationContext, "입력 안 된 사항이 있습니다.", Toast.LENGTH_SHORT).show()


            } else {
                var userID = edit_id.text.toString()
                var userPass = edit_pass.text.toString()
                var userName = edit_name.text.toString()
                var userAge = edit_age.text.toString()

                val responseListener: Response.Listener<String> = Response.Listener { response ->
                    try {
                        val jsonObject = JSONObject(response)
                        val success = jsonObject.getBoolean("success")

                        if (success) {
                            Toast.makeText(applicationContext, "회원등록 성공", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(applicationContext, "회원등록 실패", Toast.LENGTH_SHORT).show()
                            return@Listener
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }

                }


                //서버로 Volley를 이용해서 요청을 함
                val registRequest =
                    RegisterRequest(userID, userPass, userName, userAge.toInt(), responseListener)
                val queue = Volley.newRequestQueue(this@RegisterActivity)
                queue.add(registRequest)

            }
        }


    }
}
