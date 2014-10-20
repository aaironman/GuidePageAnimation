package com.example.GuigdeTest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created with IntelliJ IDEA.
 * User: zhengdianfang
 * Date: 14-7-13
 * Time: 下午2:41
 * Note: 自定义的ImageView 实现动ScrollView的滚动监听
 */
public class Child1ImageView extends ImageView implements CustomScrollView.AnimationObserver{


    private DisplayMetrics dm;

    private static final int STEP = 20;

    public Child1ImageView(Context context) {
        super(context);
        init(context);
    }

    public Child1ImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Child1ImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context){
         WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
         dm = new DisplayMetrics();
         windowManager.getDefaultDisplay().getMetrics(dm);

    }


    @Override
    protected void onFinishInflate() {
        //当View加载完成，后把自己移到屏幕最右端
        ViewHelper.setTranslationX(this, dm.widthPixels);
    }

    @Override
    public void move(int t, int oldt) {
        if (t > oldt){
            int top = getTop() - t + getHeight();
            Log.v("mickey", "getTop:" + getTop() + "--getHeight:" + getHeight() + "--t:" + t + "--oldt:" + oldt);
            if (top < MyActivity.height ){
                //用户向上滚动时，把自己往左移动
                ViewHelper.setTranslationX(this, ViewHelper.getTranslationX(this) - STEP);
            }
        } else {
            //用户向下滚动时，把自己往右移动
                ViewHelper.setTranslationX(this, ViewHelper.getTranslationX(this) + STEP);

        }
    }


}
