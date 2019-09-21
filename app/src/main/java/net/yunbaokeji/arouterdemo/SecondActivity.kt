package net.yunbaokeji.arouterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_second.*

@Route(path = "/yunbao/second")
class SecondActivity : AppCompatActivity() {
    @Autowired
    @JvmField
    var title: String = ""

    @JvmField
    @Autowired(name = "boy")
    var gender: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        ARouter.getInstance().inject(this)
        val titleString = intent.extras?.getString("title")
        tv_title.text = titleString + "$title  性别为男$gender"

//      点击了这个网页链接之后，根据“yunbao://third.com(scheme://host)”跳转到ThirdActivity，
//      然后在这个Activity利用ARouter 根据path = test/activity1跳转到FourthActivity
        webview.loadDataWithBaseURL(null, reference, "text/html", "UTF-8", null)
    }

    companion object {
        const val reference =
            """<a href="yunbao://third.com/test/activity1?name=alex&age=18&boy=true">yunbao://third.com/test/activity1?name=alex&age=18&boy=true</a></p>"""
    }
}
