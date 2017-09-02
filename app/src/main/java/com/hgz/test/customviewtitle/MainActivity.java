package com.hgz.test.customviewtitle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hgz.test.customviewtitle.view.Title;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Title title = (Title) findViewById(R.id.title);
        title.setOnLeftClickListener(new Title.OnLeftClickListener() {
            @Override
            public void OnLeftClick(View view) {
                Toast.makeText(MainActivity.this, "点击了返回", Toast.LENGTH_SHORT).show();

            }
        });
        title.setOnRightClickListener(new Title.OnRightClickListener() {
            @Override
            public void OnRightClick(View view) {
                Toast.makeText(MainActivity.this, "点击了更多", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
