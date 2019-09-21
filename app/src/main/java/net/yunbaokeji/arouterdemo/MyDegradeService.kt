package net.yunbaokeji.arouterdemo

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.DegradeService

// 降级策略其实就是在跳转过程中，如果出现错误的话，可以进行处理跳转。 方法有两种，一个是处理单个跳转，一个是全局的跳转处理。
//path里面的内容可以任意，注意两个斜杠就行
@Route(path = "/aaa/bbb")
class MyDegradeService :DegradeService{
    override fun onLost(context: Context?, postcard: Postcard?) {
        Toast.makeText(context,"不好意思，路径没找到 ${postcard?.path}",Toast.LENGTH_SHORT).show()
    }

    override fun init(context: Context?) {
        Log.e("@ @","全局降级策略的初始化过程")
    }

}