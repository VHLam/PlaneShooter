package com.vacationplanner.an.planeshooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by VO HONG LAM on 26/08/2015.
 */
public class HealthBar {
    private Bitmap bitmap;
    private int x;
    private int y;
    private boolean touched;
    private int speed;
    private boolean visible;
    public HealthBar(Bitmap bitmap,int x, int y,int speed,boolean visible)
    {
        this.bitmap=bitmap;
        this.x=x;
        this.y=y;
        this.speed= speed;
        this.visible=visible;
    }
    public void setVisible(boolean visible)
    {
        this.visible=visible;
    }
    public boolean getVisible()
    {
        return visible;
    }
    public Bitmap getBitmap()
    {
        return bitmap;
    }
    public void setBitmap(Bitmap bitmap)
    {
        this.bitmap=bitmap;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setX(int x)
    {
        this.x=x;
    }
    public void setY(int y)
    {
        this.y=y;
    }
    public void setSpeed(int speed)
    {
        this.speed=speed;
    }
    public int getSpeed()
    {
        return this.speed;
    }
    public boolean isTouched()
    {
        return touched;
    }
    public void setTouched(boolean touched)
    {
        this.touched=touched;
    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(bitmap,x-bitmap.getWidth()/2,y-bitmap.getHeight()/2,null);
    }
}
