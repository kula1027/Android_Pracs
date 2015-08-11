package com.example.administrator.drawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

/**
 * Created by Administrator on 2015-08-11.
 */
public class DrawingThread extends Thread {
    boolean flag_exit;
    SurfaceHolder surfaceHolder;
    int rad;

    int param_a, param_b;

    DrawingThread(SurfaceHolder holder, int _param_a, int _param_b){
        flag_exit = false;
        surfaceHolder = holder;

        rad = 25;

        param_a = _param_a;
        param_b = _param_b;
    }

    public void run() {
        Canvas canvas;

        float dx = 0;
        float dy = 0;

        Paint pnt_circle = new Paint();
        pnt_circle.setColor(Color.BLACK);
        pnt_circle.setAntiAlias(true);

        Paint pnt_axis = new Paint();
        pnt_axis.setColor(Color.GRAY);
        pnt_axis.setAntiAlias(true);

        while(!flag_exit){
            dx += 6;
            dy = (float)(Math.sin(dx / 80 * param_b) * 120 * param_a);

            synchronized (surfaceHolder){
                canvas = surfaceHolder.lockCanvas();
                if(canvas == null || dx > 1000)break;
                canvas.drawColor(0xC7E6E7F9);

                canvas.drawLine(canvas.getWidth() / 6 - 20, canvas.getHeight() / 2 - 120, canvas.getWidth() / 6 + 20, canvas.getHeight() / 2 - 120, pnt_axis);
                canvas.drawLine(canvas.getWidth() / 6 - 20, canvas.getHeight() / 2 + 120, canvas.getWidth() / 6 + 20, canvas.getHeight() / 2 + 120, pnt_axis);
                canvas.drawLine(0, canvas.getHeight() / 2, canvas.getWidth(), canvas.getHeight() / 2, pnt_axis);
                canvas.drawLine(canvas.getWidth() / 6, 0, canvas.getWidth() / 6,canvas.getHeight(), pnt_axis);
                canvas.drawCircle(canvas.getWidth() / 6 + dx, canvas.getHeight() / 2 - dy, rad, pnt_circle);

                surfaceHolder.unlockCanvasAndPost(canvas);
            }
            try{Thread.sleep(SurfView.Delay);}catch (Exception e){}
        }



    }
}
