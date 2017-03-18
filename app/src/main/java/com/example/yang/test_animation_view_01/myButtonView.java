package com.example.yang.test_animation_view_01;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;


/**
 * Created by yang on 2017/3/18.
 */

public class myButtonView extends android.support.v7.widget.AppCompatButton {
    private int mLastX;
    private int mLastY;
    private static final String TAG="myButtonView";



    public myButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x=(int)event.getRawX();
        int y=(int)event.getRawY();
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN : {
               break;
            }
            case MotionEvent.ACTION_MOVE:{
                int deltaX=x-mLastX;
                int deltaY=y-mLastY;
                Log.i(TAG,"move: deltaX="+deltaX+"  deltaY="+deltaY);
                int translationX=(int)getTranslationX()+deltaX;
                int translationY=(int)getTranslationY()+deltaY;
                setTranslationX(translationX);
                setTranslationY(translationY);
                break;
            }
            case MotionEvent.ACTION_UP:{
                break;
            }
            default:
                break;
        }
        mLastX=x;
        mLastY=y;
        return true;
//      return super.onTouchEvent(event);
    }
}
