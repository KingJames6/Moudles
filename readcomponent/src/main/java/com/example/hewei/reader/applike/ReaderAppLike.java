package com.example.hewei.reader.applike;

import com.example.hewei.componentservice.readbook.ReadBookService;
import com.example.hewei.reader.serviceimpl.ReadBookServiceImpl;
import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
import com.luojilab.component.componentlib.router.Router;

public class ReaderAppLike implements IApplicationLike {
    Router router = Router.getInstance();

    @Override
    public void onCreate() {  //组件安装
        router.addService(ReadBookService.class.getSimpleName(), new ReadBookServiceImpl());
    }

    @Override
    public void onStop() {   //组件卸载
        router.removeService(ReadBookService.class.getSimpleName());
    }
}
