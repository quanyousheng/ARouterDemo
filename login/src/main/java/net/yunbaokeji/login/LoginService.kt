package net.yunbaokeji.login

import net.yunbaokeji.componentbase.service.ILoginService

class LoginService : ILoginService {
    override fun getUserId(): String? {
        return "123456"
    }

    override fun isLogin(): Boolean {
        return true
    }
}