package net.yunbaokeji.arouterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter

// URL跳转中间页
class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

//      通过在manifest配置scheme://host，获取Uri（intent.data）将该页面当成中间过渡页跳转到目标path所指向的页面
        ARouter.getInstance().build(intent.data).navigation(this, object : NavigationCallback {
            override fun onLost(postcard: Postcard?) {
                Log.e("eee", "onLost")
            }

            override fun onFound(postcard: Postcard?) {
                Log.e("eee", "onFound")
            }

            override fun onInterrupt(postcard: Postcard?) {
                Log.e("eee", "onInterrupt")
            }

            override fun onArrival(postcard: Postcard?) {
                Log.e("eee", "onArrival")
                finish()
            }

        })
    }
}
