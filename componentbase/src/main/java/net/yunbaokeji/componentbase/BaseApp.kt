package net.yunbaokeji.componentbase

import android.app.Application

abstract class BaseApp :Application(){

    //   组件模块的初始化
   abstract fun initModuleApp(a:Application)

    //   组件模块初始化之后的，数据初始化
    abstract fun initModuleData(a: Application)
}