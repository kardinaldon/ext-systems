package com.example.firstframework;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.io.IOException;
import java.io.InputStream;

public class GraphicsFW {

    private AssetManager assetManagerGame;
    private Bitmap frameBufferGame, textureGame;
    private Canvas canvasGame;
    private Paint paintGame;

    public GraphicsFW(AssetManager assetManagerGame, Bitmap frameBufferGame) {
        this.assetManagerGame = assetManagerGame;
        this.frameBufferGame = frameBufferGame;
        this.canvasGame = new Canvas(frameBufferGame);
        this.paintGame = new Paint();
    }

    public void clearScene (int colorRgb) {
        canvasGame.drawRGB(colorRgb,colorRgb,colorRgb);
    }

    public void drawPixel (int x, int y, int color) {
        paintGame.setColor(color);
        canvasGame.drawPoint(x,y,paintGame);

    }

    public void drawLine (int startX, int stopX, int startY, int stopY, int color) {
        paintGame.setColor(color);
        canvasGame.drawLine(startX, stopX, startY, stopY, paintGame);

    }

    public void drawText (String text, int x, int y, int color, int sizeText, Typeface fonts) {
        paintGame.setColor(color);
        paintGame.setTextSize(sizeText);
        paintGame.setTypeface(fonts);
        canvasGame.drawText(text,x,y,paintGame);
    }
    public void drawTexture (Bitmap textureGame, int x, int y) {
        canvasGame.drawBitmap(textureGame,x,y,null);
    }
    public int getWidthFrameBuffer () {
        return frameBufferGame.getWidth();
    }

    public int getHeightFrameBuffer () {
        return frameBufferGame.getHeight();
    }

    public Bitmap newTexture (String fileName) {
        InputStream inputStream = null;
        try {
            inputStream = assetManagerGame.open(fileName);
            textureGame = BitmapFactory.decodeStream(inputStream);
            if (textureGame==null) {
                throw new RuntimeException("Failed to load bitmap "+ fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return textureGame;
    }

}
