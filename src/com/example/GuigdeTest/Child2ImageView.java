package com.example.GuigdeTest;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created with IntelliJ IDEA.
 * User: zhengdianfang
 * Date: 14-7-13
 * Time: 下午2:41
 * Note:
 */
public class Child2ImageView extends ImageView implements CustomScrollView.AnimationObserver{
    private boolean isCanUpAnimation = true;
    private boolean isCanDownAnimation = false;

    public Child2ImageView(Context context) {
        super(context);
    }

    public Child2ImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Child2ImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public void move(int t, int oldt) {
        if (t > oldt){
            int top = getTop() - t + getHeight() ;
            if (top < MyActivity.height && isCanUpAnimation){
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.show);
                animation.setAnimationListener(new UpAnimationLiseter());
                startAnimation(animation);
            }
        } else {
            int top = getTop() - t + getHeight() ;
            if (top > MyActivity.height && isCanDownAnimation){
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.hide);
                animation.setAnimationListener(new DownAnimationLiseter());
                startAnimation(animation);

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
