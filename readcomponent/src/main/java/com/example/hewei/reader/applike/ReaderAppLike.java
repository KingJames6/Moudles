package com.example.hewei.reader.applike;

import com.example.hewei.componentservice.readbook.ReadBookService;
import com.example.hewei.reader.serviceimpl.ReadBookServiceImpl;
import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
import com.luojilab.component.componentlib.exceptions.UiRouterException;
import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.router.ui.UIRouter;

/**
 * 管理组件的生命周期
 */
public class ReaderAppLike implements IApplicationLike {
    Router router = Router.getInstance();
    UIRouter uiRouter = UIRouter.getInstance();

    @Override
    public void onCreate() {  //组件安装
        uiRouter.registerUI("reader");
        router.addService(ReadBookService.class.getSimpleName(), new ReadBookServiceImpl());
    }

    @Override
    public void onStop() {   //组件卸载
        uiRouter.unregisterUI("reader");
        router.removeService(ReadBookService.class.getSimpleName());
    }
}
