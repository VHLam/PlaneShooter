package com.vacationplanner.an.planeshooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by An on 8/23/2015.
 */
public class Bullet{
    private int x;
    private int y;
    private int tx;
    private int ty;
    private int sx;
    private int sy;
    private int damage;
    private int speed;
    private Bitmap bitmap;
    private boolean visible;
    private int width;
    private int height;
    public Bullet(Bitmap bitmap,int x,int y,boolean visible,int damage,int speed,int width,int height)
    {
        this.bitmap=bitmap;
        this.x=x;
        this.damage=damage;
        this.y=y;
        this.speed= speed;
        this.visible=visible;
        this.width=width;
        this.height=height;
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
    public void setTarget(int tx,int ty){
        this.tx=tx;
        this.ty=ty;

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
        if(Math.abs(x-tx)>speed && Math.abs(y-ty)>speed)
        {
            double dx=tx-this.x;
            double dy=ty-this.y;
            double distance=  Math.sqrt(dx*dx+dy*dy);
            dx/=distance;
            dy/=distance;
            this.x+=dx*speed;
            this.y+=dy*speed;
        }
        else
        {
            this.y+=speed;
        }
        if(x>=width || y>=height||x<=0 ||y<=0)
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
