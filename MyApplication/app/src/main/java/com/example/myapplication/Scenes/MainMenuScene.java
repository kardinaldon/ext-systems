package com.example.myapplication.Scenes;

import android.graphics.Color;

import com.example.firstframework.CoreFW;
import com.example.firstframework.SceneFW;
import com.example.myapplication.R;

public class MainMenuScene extends SceneFW {

    public MainMenuScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {
        if (coreFW.getTouchListenerFw().getTouchUp(20,300,100,50)) {
            coreFW.setScene(new GameScene(coreFW));
        }
    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMeny_nameGame),100,100,Color.BLUE,60,null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMeny_newGame),20,300,Color.BLUE,40,null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMeny_settings),20,350,Color.BLUE,40,null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMeny_results),20,400,Color.BLUE,40,null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMeny_exitGame),20,450,Color.BLUE,40,null);
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
