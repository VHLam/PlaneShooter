package com.vacationplanner.an.planeshooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by An on 8/22/2015.
 */
public class Projectile {
    private int x;
    private int y;
    private int damage;
    private int speed;
    private Bitmap bitmap;
    Enemy enemy;
    private boolean visible;
    public Projectile(Bitmap bitmap,int x,int y,boolean visible,int damage,int speed)
    {
        this.bitmap=bitmap;
        this.x=x;
        this.damage=damage;
        this.y=y;
        this.speed= speed;
        this.enemy=enemy;
        this.visible=visible;
    }
    public void setVisible(boolean visible)
    {
        this.visible=visible;
    }
    public boolean getVisible()
    {
        return this.visible;
    }
    public void setSpeed(int speed)
    {
        this.speed=speed;
    }
    public int getSpeed()
    {
        return this.speed;
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
    public Bitmap getBitmap()
    {
        return bitmap;
    }
    public void setBitmap(Bitmap bitmap)
    {
        this.bitmap=bitmap;
    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(bitmap,x-bitmap.getWidth()/2,y-bitmap.getHeight()/2,null);
    }
    public void update()
    {
        y-=speed;
        if (y<=0)
        {
            visible=false;
        }
    }
    public void setDamage(int damage)
    {
        this.damage=damage;
    }
    public int getDamage()
    {
        return damage;
    }
}
