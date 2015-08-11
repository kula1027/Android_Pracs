package com.example.administrator.drawing;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2015-08-11.
 */
public class SurfView extends SurfaceView implements SurfaceHolder.Callback{
    SurfaceHolder surfaceholder;
    DrawingThread drawingThread;
    final static int Delay = 50;

    public int param_a;
    public int param_b;


    SurfView(Context context){
        super(context);

        surfaceholder = getHolder();
        surfaceholder.addCallback(this);

        param_a = 1;
        param_b = 1;
    }

    public void ThreadStart(){
        drawingThread = new DrawingThread(surfaceholder, param_a, param_b);
        drawingThread.start();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        drawingThread.flag_exit = true;
        while(true) {
            try {
                drawingThread.join();
                break;
            } catch (Exception e) {}
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
}
