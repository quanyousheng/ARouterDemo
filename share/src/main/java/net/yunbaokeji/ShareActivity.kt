package net.yunbaokeji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_share.*
import net.yunbaokeji.share.R

@Route(path = "/share/share")
class ShareActivity : AppCompatActivity() {
    @JvmField
    @Autowired
    var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        ARouter.getInstance().inject(this)
        tv.text = id
    }
}
