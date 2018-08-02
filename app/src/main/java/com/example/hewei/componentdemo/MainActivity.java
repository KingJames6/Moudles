package com.example.hewei.componentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hewei.componentservice.readbook.ReadBookService;
import com.luojilab.component.componentlib.router.Router;

public class MainActivity extends AppCompatActivity {

    Fragment fragment;
    FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showFragment() {
        if(fragment != null) {
            ft = fragment.getFragmentManager().beginTransaction();
            ft.remove(fragment).commitAllowingStateLoss();
        }


        Router router = Router.getInstance();
        if (router.getService(ReadBookService.class.getSimpleName()) != null) {
            ReadBookService service = (ReadBookService) router.getService(ReadBookService.class.getSimpleName());
            fragment = service.getReadBookFragment();
            ft= fragment.getFragmentManager().beginTransaction();
            ft.add(R.id.tab_content,fragment).commitAllowingStateLoss();
        }
    }


}
