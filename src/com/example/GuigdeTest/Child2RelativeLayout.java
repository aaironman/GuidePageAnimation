package com.example.GuigdeTest;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

/**
 * Created with IntelliJ IDEA.
 * User: zhengdianfang
 * Date: 14-7-13
 * Time: 下午2:41
 * Note:
 */
public class Child2RelativeLayout extends RelativeLayout implements CustomScrollView.AnimationObserver{

    private int child1;
    private int child2;

    private View child1View;
    private View child2View;
    private boolean isCanUpAnimation = true;
    private boolean isCanDownAnimation = false;

    public Child2RelativeLayout(Context context) {
        super(context);
    }

    public Child2RelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ChildRelativeLayout, 0, 0);

        init(a);
        a.recycle();
    }

    public Child2RelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ChildRelativeLayout, defStyle, 0);
        init(a);
        a.recycle();
    }

    private void init(TypedArray a){
        child1 = a.getResourceId(R.styleable.ChildRelativeLayout_child1, 0);
        child2 = a.getResourceId(R.styleable.ChildRelativeLayout_child2, 0);
    }

    @Override
    protected void onFinishInflate() {
        if (child1 > 0){
            child1View = findViewById(child1);
            child1View.setVisibility(View.INVISIBLE);
        }
        if (child2 > 0){
            child2View = findViewById(child2);
            child2View.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void move(int t, int oldt) {
        if (t > oldt){
            int top = getTop() - t + getHeight() * 2;
            if (top < MyActivity.height && isCanUpAnimation){
                Log.d("MyActivity", "up");
                if (null != child1View){
                    Animation animation1 = AnimationUtils.loadAnimation(getContext(), R.anim.transcation_right_in);
                    animation1.setAnimationListener(new UpAnimationLiseter());
                    child1View.startAnimation(animation1);
                }

                if (null != child2View){
                    Animation animation2 = AnimationUtils.loadAnimation(getContext(), R.anim.transcation_left_in);
                    animation2.setAnimationListener(new UpAnimationLiseter());
                    child2View.startAnimation(animation2);
                }
            }
        } else {
            int top = getTop() - t + getHeight() * 2;
            if (top > MyActivity.height && isCanDownAnimation){
                Log.d("MyActivity", "down");
                if (null != child1View ){
                    Animation animation1 = AnimationUtils.loadAnimation(getContext(), R.anim.transcation_right_out);
                    animation1.setAnimationListener(new DownAnimationLiseter());
                    child1View.startAnimation(animation1);
                }

                if (null != child2View){

                    Animation animation2 = AnimationUtils.loadAnimation(getContext(), R.anim.transcation_left_out);
                    animation2.setAnimationListener(new DownAnimationLiseter());
                    child2View.startAnimation(animation2);
                }
            }
        }
    }

    private class UpAnimationLiseter implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation) {
            isCanUpAnimation = false;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
             isCanDownAnimation = true;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

    private class DownAnimationLiseter implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation) {
            isCanDownAnimation = false;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            isCanUpAnimation = true;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

}
