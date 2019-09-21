package net.yunbaokeji

import android.app.Application
import android.util.Log
import net.yunbaokeji.componentbase.BaseApp

import net.yunbaokeji.componentbase.ServiceFactory
import net.yunbaokeji.login.LoginService

class LoginApp : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        Log.e("@@","LoginApp的初始化")
        initModuleApp(this)
        initModuleData(this)
    }

    override fun initModuleApp(application: Application) {
        ServiceFactory.loginService = LoginService()
    }

    override fun initModuleData(application: Application) {
        Log.e("@@","LoginApp的initModuleData初始化")
    }
}
