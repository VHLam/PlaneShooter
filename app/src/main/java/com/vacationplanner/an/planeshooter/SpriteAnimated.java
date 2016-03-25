package com.vacationplanner.an.planeshooter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;

/**
 * Created by VO HONG LAM on 22/08/2015.
 */
public class SpriteAnimated extends Activity{

    private static final String TAG = SpriteAnimated.class.getSimpleName();

    private Bitmap bitmap;
    private Rect sourceRect;
    private int frameNr;
    private int currentFrame;
    private long frameTicker;
    private int framePeriod;
    private boolean visible;
    private int n = 0;

    private int spriteWidth;
    private int spriteHeight;

    private int x;
    private int y;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void setVisible(boolean visible)
    {
        this.visible=visible;
    }
    public boolean getVisible()
    {
        return this.visible;
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

    public SpriteAnimated(Bitmap bitmap, int x, int y, int width, int height, int fps, int frameCount, boolean visible) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
        this.visible=visible;
        currentFrame = 0;
        frameNr = frameCount;
        spriteWidth = bitmap.getWidth() / frameCount;
        spriteHeight = bitmap.getHeight();
        sourceRect = new Rect(0, 0, spriteWidth, spriteHeight);
        framePeriod = 1000 / fps;
        frameTicker = 0l;
    }

    public void update(long gameTime) {
        if (gameTime > frameTicker + framePeriod) {
            frameTicker = gameTime;
            currentFrame++;
            if (currentFrame >= frameNr) {
                currentFrame = 0;
            }
            n++;
        }
        if (n == 12) {
            n=0;
            this.visible = false;
        }
        this.sourceRect.left = currentFrame * spriteWidth;
        this.sourceRect.right = this.sourceRect.left + spriteWidth;
    }

    public void draw(Canvas canvas) {
        // where to draw the sprite
        Rect destRect = new Rect(getX(), getY(), getX() + spriteWidth, getY() + spriteHeight);
        canvas.drawBitmap(bitmap, sourceRect, destRect, null);
    }

}
