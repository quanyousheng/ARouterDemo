package net.yunbaokeji.componentbase

import net.yunbaokeji.componentbase.service.ILoginService

class EmptyLoginService : ILoginService {
    override fun isLogin(): Boolean = false

    override fun getUserId(): String? = null

}