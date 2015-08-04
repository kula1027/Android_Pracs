package com.example.administrator.painter;

import android.graphics.Color;

/**
 * Created by Administrator on 2015-07-25.
 */
public class Point {
    private float x;
    private float y;
    private float thickness;
    private int color;
    private boolean empty;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getThickness() {
        return thickness;
    }

    public int getColor() {
        return color;
    }

    public boolean isEmpty(){
        return empty;
    }

    Point(float _x, float _y, float _thickness, int _color){
        x = _x;
        y = _y;
        thickness = _thickness;
        color = _color;
        empty = false;
    }
    Point(){
        empty = true;
    }
}
