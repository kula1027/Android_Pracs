package com.example.administrator.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015-07-24.
 */
public class PaintView extends View {
    private Paint paint;
    private ArrayList<Point> arrPoint;
    private PaintData pd;

    public PaintView(Context context) {
        super(context);
        PaintInitiate();
    }
    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        PaintInitiate();
    }
    public PaintView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        PaintInitiate();
    }

    private void PaintInitiate() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        arrPoint = new ArrayList<Point>();

        pd = new PaintData();
    }

    public void SetPaintColor(int clr){
        pd.setColor(clr);
    }
    public void SetThickness(float thickness){pd.setThickness(thickness * 0.1f + 4);}

    public void onDraw(Canvas canvas){
        canvas.drawColor(Color.WHITE);

        for(int loop = 1; loop < arrPoint.size(); loop++){
            paint.setColor(arrPoint.get(loop).getColor());
            paint.setStrokeWidth(arrPoint.get(loop).getThickness());
            if(arrPoint.get(loop).isEmpty() || arrPoint.get(loop-1).isEmpty())continue;
            canvas.drawLine(arrPoint.get(loop - 1).getX(), arrPoint.get(loop - 1).getY(),
                    arrPoint.get(loop).getX(), arrPoint.get(loop).getY(), paint);
        }
    }

    public boolean onTouchEvent(MotionEvent evt){
        if(evt.getAction() == MotionEvent.ACTION_DOWN) {
            arrPoint.add(new Point(evt.getX(), evt.getY(), pd.getThickness(), pd.getColor()));
            return true;
        }
        if(evt.getAction() == MotionEvent.ACTION_MOVE) {
            arrPoint.add(new Point(evt.getX(), evt.getY(), pd.getThickness(), pd.getColor()));
            invalidate();
            return true;
        }
        if(evt.getAction() == MotionEvent.ACTION_UP){
            arrPoint.add(new Point());
        }
        return false;
    }
}