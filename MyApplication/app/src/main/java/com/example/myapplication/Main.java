package com.example.myapplication;

import android.os.Bundle;
import com.example.firstframework.CoreFW;
import com.example.firstframework.SceneFW;
import com.example.myapplication.Scenes.MainMenuScene;

public class Main extends CoreFW {
    public SceneFW getStart () {
        return new MainMenuScene(this);
    }
}
