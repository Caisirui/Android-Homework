package com.example.kt43;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

/**
 * Created by cai on 2016/1/21.
 */
public class ClockView extends View{
    private int width;
    private int height;
    private Paint mPaintLine;
    private Paint mPaintCircle;
    private Paint mPaintHour;
    private Paint mPaintMinute;
    private Paint mPaintSec;
    private Paint mPaintText;
    private Calendar mCalendar;
    public static final int NEED_INVALIDATE = 0X23;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case NEED_INVALIDATE:
                    mCalendar = Calendar.getInstance();
                    invalidate();//告诉UI主线程重新绘制
                    handler.sendEmptyMessageDelayed(NEED_INVALIDATE,1000);
                    break;
                default:
                    break;
            }
        }
    };

    public ClockView(Context context, AttributeSet attrs){
        super(context,attrs);
        mCalendar = Calendar.getInstance();
        mPaintLine = new Paint();
        mPaintLine.setColor(Color.BLUE);
        mPaintLine.setStrokeWidth(10);

        mPaintCircle = new Paint();
        mPaintCircle.setColor(Color.GREEN);//设置颜色
        mPaintCircle.setStrokeWidth(10);//设置线宽
        mPaintCircle.setAntiAlias(true);//设置是否抗锯齿
        mPaintCircle.setStyle(Paint.Style.STROKE);//设置绘制风格

        mPaintText = new Paint();
        mPaintText.setColor(Color.BLUE);
        mPaintText.setStrokeWidth(10);
        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setTextSize(40);

        mPaintHour = new Paint();
        mPaintHour.setStrokeWidth(20);
        mPaintHour.setColor(Color.BLUE);

        mPaintMinute = new Paint();
        mPaintMinute.setStrokeWidth(15);
        mPaintMinute.setColor(Color.BLUE);

        mPaintSec = new Paint();
        mPaintSec.setStrokeWidth(10);
        mPaintSec.setColor(Color.BLUE);
        //handler.sendEmptyMessage(NEED_INVALIDATE);//向handler发送一个消息，让它开启重绘
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    protected void onDraw(Canvas canvas){
        mCalendar = Calendar.getInstance();
        super.onDraw(canvas);
        int minute = mCalendar.get(Calendar.MINUTE);//得到当前分钟数
        int hour = mCalendar.get(Calendar.HOUR);//得到当前小时数
        int sec = mCalendar.get(Calendar.SECOND);//得到当前秒数

        float minuteDegree = minute/60f*360;//得到分针旋转的角度
        canvas.save();
        canvas.rotate(minuteDegree, width / 2, height / 2);
        canvas.drawLine(width / 2, height / 2 - 250, width / 2, height / 2 + 40, mPaintMinute);
        canvas.restore();

        float hourDegree = (hour*60+minute)/12f/60*360;//得到时钟旋转的角度
        canvas.save();
        canvas.rotate(hourDegree, width / 2, height / 2);
        canvas.drawLine(width / 2, height / 2 - 200, width / 2, height / 2 + 30, mPaintHour);
        canvas.restore();

        float secDegree = sec/60f*360;//得到秒针旋转的角度
        canvas.save();
        canvas.rotate(secDegree,width/2,height/2);
        canvas.drawLine(width/2,height/2-300,width/2,height/2+40,mPaintSec);
        canvas.restore();
    }
}
