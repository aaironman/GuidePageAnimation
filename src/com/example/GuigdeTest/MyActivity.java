package com.example.GuigdeTest;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

public class MyActivity extends Activity implements ViewTreeObserver.OnGlobalLayoutListener {

    private CustomScrollView customScrollView;
    private View view1;
    public static int height;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        customScrollView = (CustomScrollView) findViewById(R.id.scroll_view);

        Child1RelativeLayout part1View = (Child1RelativeLayout) findViewById(R.id.part1_view);
        Child1RelativeLayout part2View = (Child1RelativeLayout) findViewById(R.id.part2_view);
        Child1RelativeLayout part3View = (Child1RelativeLayout) findViewById(R.id.part3_view);
        Child1RelativeLayout part4View = (Child1RelativeLayout) findViewById(R.id.part4_view);
        Child1RelativeLayout part5View = (Child1RelativeLayout) findViewById(R.id.part5_view);


        Child2RelativeLayout part7View = (Child2RelativeLayout) findViewById(R.id.part7_view);
        Child2RelativeLayout part8View = (Child2RelativeLayout) findViewById(R.id.part8_view);
        Child2RelativeLayout part9View = (Child2RelativeLayout) findViewById(R.id.part9_view);
        Child2RelativeLayout part10View = (Child2RelativeLayout) findViewById(R.id.part10_view);
        Child2RelativeLayout part11View = (Child2RelativeLayout) findViewById(R.id.part11_view);
        Child2RelativeLayout part12View = (Child2RelativeLayout) findViewById(R.id.part12_view);

        Child2ImageView childImageView6 = (Child2ImageView) findViewById(R.id.part6_view);
        Child2ImageView childImageView13 = (Child2ImageView) findViewById(R.id.part13_view);


        Child1ImageView child1ImageView = (Child1ImageView) findViewById(R.id.move_guide_view1);

        customScrollView.addObserver(part1View);
        customScrollView.addObserver(part2View);
        customScrollView.addObserver(part3View);
        customScrollView.addObserver(part4View);
        customScrollView.addObserver(part5View);

        customScrollView.addObserver(part7View);
        customScrollView.addObserver(part8View);
        customScrollView.addObserver(part9View);
        customScrollView.addObserver(part10View);
        customScrollView.addObserver(part11View);
        customScrollView.addObserver(part12View);

        customScrollView.addObserver(childImageView6);
        customScrollView.addObserver(childImageView13);

       customScrollView.addObserver(child1ImageView);


        customScrollView.getViewTreeObserver().addOnGlobalLayoutListener(this);


    }



    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onGlobalLayout() {
        height = customScrollView.getHeight();
    }
}
