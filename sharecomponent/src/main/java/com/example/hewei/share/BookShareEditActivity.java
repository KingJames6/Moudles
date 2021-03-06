package com.example.hewei.share;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hewei.basicres.BaseActivity;
import com.example.hewei.componentservice.share.bean.Author;
import com.example.hewei.share.bean.BookShareBean;
import com.example.hewei.share.core.AbsShareBean;
import com.luojilab.component.componentlib.service.AutowiredService;
import com.luojilab.router.facade.annotation.Autowired;
import com.luojilab.router.facade.annotation.RouteNode;

@RouteNode(path = "/share/edit/book", desc = "分享书籍-内容编辑页面")
public class BookShareEditActivity extends BaseActivity {

    @Autowired
    String bookName;

    @Autowired
    Author author;



    private TextView tvShareTitle;
    private TextView tvShareBook;
    private TextView tvAuthor;
    private TextView tvCounty;
    private EditText etShareReason;
    private Button btnShareQQ;
    private Button btnShareWechat;

    private final static int RESULT_CODE = 8888;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        AutowiredService.Factory.getSingletonImpl().autowire(this);
        setContentView(R.layout.share_activity_share);

        tvShareTitle = findViewById(R.id.share_title);
        tvShareBook = findViewById(R.id.share_tv_tag);
        tvAuthor = findViewById(R.id.share_tv_author);
        tvCounty = findViewById(R.id.share_tv_county);
        etShareReason = findViewById(R.id.share_et_reason);
        btnShareQQ = findViewById(R.id.share_btn_qq);
        btnShareWechat = findViewById(R.id.share_btn_wechat);

        tvShareTitle.setText("Book");

        if (bookName != null) {
            tvShareBook.setText(bookName);
        }

        if (author != null) {
            tvAuthor.setText(author.getName());
            tvCounty.setText(author.getCounty());
        }

        btnShareQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callShare(AbsShareBean.Via.QQ);
            }
        });

        btnShareWechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callShare(AbsShareBean.Via.WECHAT);
            }
        });

        Intent intent = new Intent();
        intent.putExtra("result", "Share Success");
        setResult(RESULT_CODE, intent);
    }

    private void callShare(@AbsShareBean.Via int via) {
        BookShareBean bookShareBean = new BookShareBean(via,
                tvShareBook.getText().toString(),
                tvAuthor.getText().toString(),
                tvCounty.getText().toString(),
                etShareReason.getText().toString());
    }
}
