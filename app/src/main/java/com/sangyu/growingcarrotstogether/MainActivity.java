package com.sangyu.growingcarrotstogether;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sangyu.growingcarrotstogether.Service.Blocks;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView tv_score;

    private Button bt_up;
    private Button bt_down;
    private Button bt_left;
    private Button bt_right;
    private Button bt_start;


    private TextView tv_11;
    private TextView tv_12;
    private TextView tv_13;
    private TextView tv_14;
    private TextView tv_21;
    private TextView tv_22;
    private TextView tv_23;
    private TextView tv_24;
    private TextView tv_31;
    private TextView tv_32;
    private TextView tv_33;
    private TextView tv_34;
    private TextView tv_41;
    private TextView tv_42;
    private TextView tv_43;
    private TextView tv_44;
    private int score = 0;

    private Blocks myblocks = new Blocks();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView_ById();
        bt_start.setOnClickListener(this);
        bt_up.setOnClickListener(this);
        bt_down.setOnClickListener(this);
        bt_left.setOnClickListener(this);
        bt_right.setOnClickListener(this);
    }

    private void findView_ById() {
        tv_score = findViewById(R.id.tv_score);

        bt_start = findViewById(R.id.bt_start);
        bt_up = findViewById(R.id.bt_up);
        bt_down = findViewById(R.id.bt_down);
        bt_left = findViewById(R.id.bt_left);
        bt_right = findViewById(R.id.bt_right);

        tv_11 = findViewById(R.id.tv_11);
        tv_12 = findViewById(R.id.tv_12);
        tv_13 = findViewById(R.id.tv_13);
        tv_14 = findViewById(R.id.tv_14);
        tv_21 = findViewById(R.id.tv_21);
        tv_22 = findViewById(R.id.tv_22);
        tv_23 = findViewById(R.id.tv_23);
        tv_24 = findViewById(R.id.tv_24);
        tv_31 = findViewById(R.id.tv_31);
        tv_32 = findViewById(R.id.tv_32);
        tv_33 = findViewById(R.id.tv_33);
        tv_34 = findViewById(R.id.tv_34);
        tv_41 = findViewById(R.id.tv_41);
        tv_42 = findViewById(R.id.tv_42);
        tv_43 = findViewById(R.id.tv_43);
        tv_44 = findViewById(R.id.tv_44);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.bt_start:
                myblocks.clearBlocks();
                score = 0;
                break;
            case R.id.bt_up:
                myblocks.updateBlocks(1);
                score+=10;
                break;
            case R.id.bt_down:
                myblocks.updateBlocks(2);
                score+=10;
                break;
            case R.id.bt_left:
                myblocks.updateBlocks(3);
                score+=10;
                break;
            case R.id.bt_right:
                myblocks.updateBlocks(4);
                score+=10;
                break;
        }
        int [][] cubes = myblocks.getCubes();
        print_cubes(cubes);
    }
    private void print_cubes(int[][] cubes) {
        tv_score.setText(String.valueOf(score));
        tv_11.setText(String.valueOf(cubes[0][0]));
        tv_12.setText(String.valueOf(cubes[0][1]));
        tv_13.setText(String.valueOf(cubes[0][2]));
        tv_14.setText(String.valueOf(cubes[0][3]));
        tv_21.setText(String.valueOf(cubes[1][0]));
        tv_22.setText(String.valueOf(cubes[1][1]));
        tv_23.setText(String.valueOf(cubes[1][2]));
        tv_24.setText(String.valueOf(cubes[1][3]));
        tv_31.setText(String.valueOf(cubes[2][0]));
        tv_32.setText(String.valueOf(cubes[2][1]));
        tv_33.setText(String.valueOf(cubes[2][2]));
        tv_34.setText(String.valueOf(cubes[2][3]));
        tv_41.setText(String.valueOf(cubes[3][0]));
        tv_42.setText(String.valueOf(cubes[3][1]));
        tv_43.setText(String.valueOf(cubes[3][2]));
        tv_44.setText(String.valueOf(cubes[3][3]));
    }
}
