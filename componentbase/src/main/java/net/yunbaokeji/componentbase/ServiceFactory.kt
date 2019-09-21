package net.yunbaokeji.componentbase

import net.yunbaokeji.componentbase.service.ILoginService

object ServiceFactory {
    var loginService: ILoginService? = null
        get() {
            if (field == null) {
                loginService = EmptyLoginService()
            }
            return field
        }

}