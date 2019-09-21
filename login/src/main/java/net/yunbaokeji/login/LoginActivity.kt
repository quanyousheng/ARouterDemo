package net.yunbaokeji.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/login/login")
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
