package com.example.cai.kt42;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Cai on 2016/1/17.
 */
public class ClockView extends View {

    public int format;
    public SimpleDateFormat formatter;
    public Date curDate;

    public ClockView(Context context, AttributeSet as){
        super(context, as);
        TypedArray a = context.obtainStyledAttributes(as,
                R.styleable.CV_atts);
        format=a.getInteger(R.styleable.CV_atts_timeFormat, 12);  //存在问题，无法获取，format每次都是默认值

        if(format==12){
            formatter = new SimpleDateFormat ("yyyy 年 MM 月 dd 日 hh:mm:ss a");
        }
        else if(format==24){
            formatter = new SimpleDateFormat ("yyyy 年 MM 月 dd 日 HH:mm:ss ");
        }
    }

    public void onDraw(Canvas canvas){
        //super.onDraw(canvas);
        curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        Paint mPaint = new Paint();
        mPaint.setTextSize(50);
        canvas.drawText(str,0,100,mPaint);
    }
}
