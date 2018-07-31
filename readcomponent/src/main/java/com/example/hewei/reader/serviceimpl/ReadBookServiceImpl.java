package com.example.hewei.reader.serviceimpl;


import android.support.v4.app.Fragment;

import com.example.hewei.componentservice.readbook.ReadBookService;
import com.example.hewei.reader.ReaderFragment;

public class ReadBookServiceImpl implements ReadBookService {
    @Override
    public Fragment getReadBookFragment() {
        return new ReaderFragment();
    }
}
