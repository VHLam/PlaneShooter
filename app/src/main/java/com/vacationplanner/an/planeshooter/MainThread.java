package com.vacationplanner.an.planeshooter;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by An on 8/21/2015.
 */
public class MainThread extends Thread{
    private static final String TAG=MainThread.class.getSimpleName();
    private boolean running;
    public void setRunning(boolean running)
    {
        this.running=running;
    }
    private final static int MAX_FPS=60;
    private final static int MAX_FRAME_SKIPS=5;
    private final static int FRAME_PERIOD=1000/MAX_FPS;
    public void run()
    {
        Canvas canvas;
        Log.d(TAG, "Starting game loop");
        long beginTime;
        long timeDiff;
        int sleepTime;
        int frameSkipped;
        sleepTime=0;
        while(running && !interrupted())
        {
            canvas=null;
            try{
                canvas=this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder)
                {
                    if(canvas!=null)
                    {
                        beginTime=System.currentTimeMillis();
                        frameSkipped=0;
                        this.gamePanel.update(canvas);
                        this.gamePanel.render(canvas);
                        timeDiff= System.currentTimeMillis() - beginTime;
                        sleepTime=(int)(FRAME_PERIOD - timeDiff);
                        if(sleepTime>0)
                        {
                            try{
                                Thread.sleep(sleepTime);
                            } catch (InterruptedException e) {
                            }
                        }
                        while(sleepTime<0 && frameSkipped<MAX_FRAME_SKIPS)
                        {
                            this.gamePanel.update(canvas);
                            sleepTime+=FRAME_PERIOD;
                            frameSkipped++;
                        }
                    }
                    else
                    {
                        interrupt();
                    }
                }
            } finally
            {
                if(canvas!=null)
                {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            //update game state
            //render state to screen
        }
    }
    private SurfaceHolder surfaceHolder;
    private MainGamePanel gamePanel;
    public MainThread(SurfaceHolder surfaceHolder,MainGamePanel gamePanel){
        super();
        this.surfaceHolder=surfaceHolder;
        this.gamePanel=gamePanel;
    }

}
