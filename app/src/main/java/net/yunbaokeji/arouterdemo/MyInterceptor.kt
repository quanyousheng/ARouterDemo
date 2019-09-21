package net.yunbaokeji.arouterdemo

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

//AActivity跳到BActivity，如果有拦截器，就可以把这个过程拦截下来，做一些处理(禁止跳转、修改参数)。
//添加拦截器的方法是利用Interceptor注解，实现IInterceptor接口。
@Interceptor(name = "测试", priority = 2)
class MyInterceptor : IInterceptor {

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        if (postcard?.path == "/yunbao/second") {
            postcard.withBoolean("boy", true)
        }
        callback?.onContinue(postcard)

        //终止跳转
        //callback.onInterrupt(null)
        //抛出异常
        // callback.onInterrupt(RuntimeException("我觉得有点异常"))
        // onContinue和onInterrupt至少需要调用其中一种，否则不会继续路由
    }

    override fun init(context: Context?) {
        Log.e("@ @", "跳转拦截器初始化在sdk加载时，且只加载一次")
    }
}