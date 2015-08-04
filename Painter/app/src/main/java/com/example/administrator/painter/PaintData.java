package com.example.administrator.painter;

import android.graphics.Color;

/**
 * Created by Administrator on 2015-07-25.
 */
public class PaintData {
    private float thickness;
    private int color;

    PaintData(){
        color = Color.BLACK;
        thickness = 4;
    }

    public int getColor() {
        return color;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
