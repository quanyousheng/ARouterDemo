package net.yunbaokeji.componentbase.service

interface ILoginService {
    fun isLogin(): Boolean

    fun getUserId(): String?
}