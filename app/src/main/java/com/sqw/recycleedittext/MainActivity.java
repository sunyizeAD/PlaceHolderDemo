package com.sqw.recycleedittext;

import android.os.Handler;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int i = 0;
    private ArrayList<Integer> list = new ArrayList();
    private Placeholder placeholder;
    private ConstraintLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        placeholder = findViewById(R.id.placeholder);
        root = findViewById(R.id.root);
        findViewById(R.id.tv1).setOnClickListener(this);
        findViewById(R.id.tv2).setOnClickListener(this);
        findViewById(R.id.tv3).setOnClickListener(this);

        list.add(R.id.tv1);
        list.add(R.id.tv2);
        list.add(R.id.tv3);
        placeholder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeholder.setContentId(list.get(i%3));
                i++;
            }
        });


    }
    @Override
    public void onClick(View view) {
        TransitionManager.beginDelayedTransition(root);
        placeholder.setContentId(view.getId());
    }
}
