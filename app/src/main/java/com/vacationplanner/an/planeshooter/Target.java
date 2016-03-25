package com.vacationplanner.an.planeshooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by An on 8/22/2015.
 */
public class Target {
    private int x;
    private int y;
    private Bitmap bitmap;
    private int Velocity;
    public Target(Bitmap bitmap,int x,int y)
    {
        this.bitmap=bitmap;
        this.x=x;
        this.y=y;
        this.Velocity=20;
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
        this.Velocity=speed;
    }
    public int getSpeed()
    {
        return this.Velocity;
    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(bitmap,x-bitmap.getWidth()/2,y-bitmap.getHeight()/2,null);
    }
    public void update(int ex, int ey)
    {
        if(Math.abs(ex-this.x)>this.Velocity || Math.abs(ey-this.y)>this.Velocity)
        {
            double dx=ex-this.x;
            double dy=ey-this.y;
            double distance=  Math.sqrt(dx*dx+dy*dy);
            dx/=distance;
            dy/=distance;
            this.x+=dx*Velocity;
            this.y+=dy*Velocity;
        }
    }
}
