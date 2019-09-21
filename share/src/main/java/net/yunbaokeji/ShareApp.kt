package net.yunbaokeji

import android.app.Application
import android.util.Log
import net.yunbaokeji.componentbase.BaseApp

class ShareApp :BaseApp(){

    override fun onCreate() {
        super.onCreate()
        Log.e("@@","ShareApp的初始化")
        initModuleApp(this)
        initModuleData(this)
    }

    override fun initModuleApp(a: Application) {
        Log.e("@@","ShareApp initModuleApp")
    }

    override fun initModuleData(a: Application) {
        Log.e("@@","ShareApp initModuleData")
    }

}