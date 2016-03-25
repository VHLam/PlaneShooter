package com.vacationplanner.an.planeshooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by An on 8/22/2015.
 */
public class Enemy {
    private Bitmap bitmap;
    private int x;
    private int y;
    private boolean touched;
    private int health;
    private int Maxhealth;
    private boolean visible;
    private int speed;
    public Enemy(Bitmap bitmap,int x, int y,int health,boolean visible,int speed)
    {
        this.bitmap=bitmap;
        this.x=x;
        this.y=y;
        this.health=health;
        this.speed= speed;
        this.visible=visible;
        this.Maxhealth=health;
    }
    public int getMaxhealth() { return Maxhealth; }
    public int getHealth()
    {
        return health;
    }
    public void setHealth(int health)
    {
        this.health=health;
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
    public void update(int ex, int ey)
    {
        if(Math.abs(ex-this.x)>this.speed || Math.abs(ey-this.y)>this.speed)
        {
            double dx=ex-this.x;
            double dy=ey-this.y;
            double distance=  Math.sqrt(dx*dx+dy*dy);
            dx/=distance;
            dy/=distance;
            this.x+=dx*speed;
            this.y+=dy*speed;
        }
    }
    public void evade(int ex,int width)
    {
        int diff=width-ex;
        if(diff>ex)
        {
            update(diff/2+ex,y);
        }
        else
        {
            update(ex/2,y);
        }
    }
}
