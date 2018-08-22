package com.example.hewei.basicres;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.luojilab.component.componentlib.service.AutowiredService;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //依赖注入
        AutowiredService.Factory.getSingletonImpl().autowire(this);
    }
}
