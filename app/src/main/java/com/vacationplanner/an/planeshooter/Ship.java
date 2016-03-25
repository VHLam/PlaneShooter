package com.vacationplanner.an.planeshooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by An on 8/21/2015.
 */
public class Ship {
    private int x;
    private boolean visible;
    private int y;
    private Bitmap bitmap;
    private int Velocity;
    private int Health;
    public Ship(Bitmap bitmap,int x,int y,int Velocity,int Health)
    {
        this.bitmap=bitmap;
        this.x=x;
        this.y=y;
        this.Velocity=Velocity;
        this.Health=Health;
    }
    public void setVisible(boolean visible){this.visible=visible;}
    public boolean getVisible(){return this.visible;}
    public int getHealth()
    {
        return Health;
    }
    public void setHealth(int health)
    {
        this.Health=health;
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
