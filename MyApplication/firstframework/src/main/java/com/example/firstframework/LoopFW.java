package com.example.firstframework;

import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class LoopFW extends SurfaceView implements Runnable {

    private final float FPS = 60;
    private final float SECOND = 1000000000;
    private final float UPDATE_TIME = SECOND/FPS;
    private boolean running = false;
    //TODO
    private float updates = 0;
    private float drawing = 0;


    Thread gameThread = null;
    CoreFW coreFW;
    Bitmap frameBuffer;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Rect rect;

    public LoopFW (CoreFW coreFW, Bitmap frameBuffer) {
        super(coreFW);
        this.frameBuffer = frameBuffer;
        this.coreFW = coreFW;
        this.surfaceHolder = getHolder();
        rect = new Rect();
        canvas = new Canvas();

    }

    @Override
    public void run() {

        float lasTime = System.nanoTime();
        float delta = 0;

        while (running) {
            float nowTime = System.nanoTime();
            float elapsedTime = nowTime - lasTime;
            lasTime = nowTime;
            delta += elapsedTime / UPDATE_TIME;
            if(delta>1) {
                updateGame();
                drawingGame();
                delta--;
            }
        }

    }

    public void startGames () {
        if (running) {
            return;
        }
        running=true;
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void stopGame () {
        if (!running) {
            return;
        }
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void updateGame () {
        updates++;
        coreFW.getCurrentScene().update();
    }

    private void drawingGame () {
        drawing++;
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.getClipBounds(rect);
            canvas.drawBitmap(frameBuffer,null,rect,null);
            coreFW.getCurrentScene().drawing();
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

}
