package com.example.hewei.componentservice.readbook;

import android.support.v4.app.Fragment;

/**
 * 在公共组件里定义接口,每个组件暴露自己提供的公共服务
 * 通过公共组件 + router调用
 */
public interface ReadBookService {
    Fragment getReadBookFragment();
}
