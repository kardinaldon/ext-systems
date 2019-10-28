package com.example.myapplication.Scenes;

import android.graphics.Color;

import com.example.firstframework.CoreFW;
import com.example.firstframework.SceneFW;

public class GameScene extends SceneFW {

    public GameScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {

    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText("game scene",100,150,Color.GREEN,60,null);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
