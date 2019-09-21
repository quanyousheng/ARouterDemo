package net.yunbaokeji.arouterdemo

import android.app.Service
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.facade.model.RouteMeta.build
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*
import net.yunbaokeji.componentbase.ServiceFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            ARouter.getInstance()
                .build("/login/login")
                .navigation(this)
        }
        btn_share.setOnClickListener {
            if (ServiceFactory.loginService!!.isLogin()) {
                ARouter.getInstance()
                    .build("/share/share")
                    .withString("id", ServiceFactory.loginService!!.getUserId())
                    .navigation(this)
            } else {
                Log.e("@@", "登录后才能分享")
            }
        }
    }

    //  ARouter通过path进行页面跳转
    fun jumpTo(view: View) {
        ARouter.getInstance()
            .build(Uri.parse("/yunbao/second"))
//            .build("/yunbao/second")
            .withString("title", "andy ,u are the best")
            .navigation(this)
    }
}
