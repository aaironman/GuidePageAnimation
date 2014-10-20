package com.example.GuigdeTest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhengdianfang
 * Date: 13-7-31
 * Time: 下午4:51
 * Note:自定义的ScrollView
 */
public class CustomScrollView extends ScrollView {

    private List<AnimationObserver> animationObservers = new ArrayList<AnimationObserver>();

    public interface AnimationObserver{
        public void move(int t, int oldt);
    }

    public void addObserver(AnimationObserver observer){
       if (!animationObservers.contains(observer)){
            animationObservers.add(observer);
       }
    }

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        //当ScrollView在滚动时， 会触发此方法，所以把这里通过监听滚动的所有控件
        for (AnimationObserver observer : animationObservers){
            observer.move(t, oldt);
        }
    }
}
