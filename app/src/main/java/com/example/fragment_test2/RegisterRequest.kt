package com.example.fragment_test2

import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import java.util.HashMap

class RegisterRequest(
    userID: String,
    userPassword: String,
    userName: String,
    userAge: Int,
    listener: Response.Listener<String>
) : StringRequest(Method.POST, URL, listener, null) {

    private val map: MutableMap<String, String>


    init {
        map = HashMap()
        map["userID"] = userID
        map["userPassword"] = userPassword
        map["userName"] = userName
        map["userAge"] = userAge.toString() + ""
    }

    @Throws(AuthFailureError::class)
    override fun getParams(): MutableMap<String, String> {
        return map
    }

    companion object {
        //서버 URL 설정 (PHP 파일 연동)
        private const val URL = "http://skwk55555.dothome.co.kr/Register.php"
    }


}