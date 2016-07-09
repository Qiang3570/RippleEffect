package com.johnny.rippleeffect;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.johnny.rippleeffect.view.LayoutRipple;
import com.nineoldandroids.view.ViewHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*布局Layout*/
        LayoutRipple layoutRipple1 = (LayoutRipple) findViewById(R.id.itemButtons1);
        setOriginRiple1(layoutRipple1);
        layoutRipple1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(MainActivity.this,"move而不move", Toast.LENGTH_SHORT).show();
            }
        });
        /*布局Layout*/
        LayoutRipple layoutRipple2 = (LayoutRipple) findViewById(R.id.itemButtons2);
        setOriginRiple2(layoutRipple2);
        layoutRipple2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(MainActivity.this,"随move而move", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setOriginRiple1(final LayoutRipple layoutRipple){
        layoutRipple.post(new Runnable() {
            @Override
            public void run() {
                View v = layoutRipple.getChildAt(0);
                /*设置不随触摸点移动初始值（如果设置了此参数就要固定起始点的初始值，通过调用以下两个方法来实现：setxRippleOrigin of setyRippleOrigin）*/
                layoutRipple.setCustomLocation(false);
                layoutRipple.setxRippleOrigin(ViewHelper.getX(v)+v.getWidth()/2);
                layoutRipple.setyRippleOrigin(ViewHelper.getY(v)+v.getHeight()/2);
                layoutRipple.setRippleColor(Color.parseColor("#81B649"));/*设置颜色*/
                layoutRipple.setRippleSize(1000);/*设置触摸时的大小（不设置的话默认是5，相当于手指触摸触碰到的所有点）值越大，显示越小*/
                layoutRipple.setRippleSpeed(30);/*设置速度*/
            }
        });
    }

    private void setOriginRiple2(final LayoutRipple layoutRipple){
        layoutRipple.post(new Runnable() {
            @Override
            public void run() {
                /*默认起始点是随着move而move的*/
                View v = layoutRipple.getChildAt(0);
                layoutRipple.setRippleColor(Color.parseColor("#81B649"));/*设置颜色*/
                layoutRipple.setRippleSize(10);/*设置触摸时的大小（不设置的话默认是5，相当于手指触摸触碰到的所有点）值越大，显示越小*/
                layoutRipple.setRippleSpeed(30);/*设置速度*/
            }
        });
    }
}
