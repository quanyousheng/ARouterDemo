package net.yunbaokeji.arouterdemo

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import net.yunbaokeji.componentbase.BaseApp

class MyApp : BaseApp() {

    override fun onCreate() {
        super.onCreate()
        Log.e("@@", "MyApp的初始化")
//      ARouter初始化
        if (BuildConfig.DEBUG) { // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()    // 打印日志
            ARouter.openDebug()  // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)
        initModuleApp(this)
        initModuleData(this)
    }

    override fun initModuleApp(application: Application) {
        for (className in classNames){
            val clazz=Class.forName(className)
            val app= clazz.newInstance() as BaseApp
            app.initModuleApp(this)
        }
    }

    override fun initModuleData(application: Application) {
        for (className in classNames){
            val clazz=Class.forName(className)
            val app= clazz.newInstance() as BaseApp
            app.initModuleData(this)
        }
    }

    companion object {
        const val loginClassName = "net.yunbaokeji.LoginApp"
        const val shareClassName = "net.yunbaokeji.ShareApp"
        val classNames = arrayOf(loginClassName, shareClassName)
    }
}