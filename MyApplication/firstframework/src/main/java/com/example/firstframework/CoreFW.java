package com.example.firstframework;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CoreFW extends AppCompatActivity {

    private final float FRAME_BUFFER_WIDTH = 800;
    private final float FRAME_BUFFER_HEIGHT = 600;

    private LoopFW loopFW;
    private GraphicsFW graphicsFW;
    private TouchListenerFw touchListenerFw;

    private Display display;
    private Point sizeDisplay;
    private Bitmap frameBuffer;
    private SceneFW sceneFW;
    private float sceneWidth;
    private float sceneHeight;

    private boolean stateOnPause;
    private boolean stateOnResume;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        sizeDisplay = new Point();
        display = getWindowManager().getDefaultDisplay();
        display.getSize(sizeDisplay);

        frameBuffer = Bitmap.createBitmap((int)FRAME_BUFFER_WIDTH,(int)FRAME_BUFFER_HEIGHT,Bitmap.Config.ARGB_8888);
        sceneWidth = FRAME_BUFFER_WIDTH/sizeDisplay.x;
        sceneHeight = FRAME_BUFFER_HEIGHT/sizeDisplay.y;

        loopFW = new LoopFW(this,frameBuffer);
        graphicsFW = new GraphicsFW(getAssets(),frameBuffer);
        touchListenerFw = new TouchListenerFw(loopFW,sceneWidth,sceneHeight);

        sceneFW = getStartScene();

        stateOnPause=false;
        stateOnResume=false;

        setContentView(loopFW);
    }

    public CoreFW() {
    }

    public void onResume () {
        super.onResume();
        sceneFW.resume();
        loopFW.startGames();
    }

    public void onPause () {
        super.onPause();
        sceneFW.pause();
        loopFW.stopGame();
        stateOnPause=true;
        if (isFinishing()) {
            sceneFW.dispose();
        }
    }

    public GraphicsFW getGraphicsFW () {
        return  graphicsFW;
    }

    public TouchListenerFw getTouchListenerFw () {
        return touchListenerFw;
    }

    public void setScene (SceneFW scene) {
        if (scene==null) {
            throw new IllegalArgumentException("Failed to load scene");
        }
        this.sceneFW.pause();
        this.sceneFW.dispose();
        sceneFW.resume();
        sceneFW.update();
        this.sceneFW = scene;
    }

    public SceneFW getCurrentScene () {
        return sceneFW;
    }

    public SceneFW getStartScene () {
        return sceneFW;
    }


}
