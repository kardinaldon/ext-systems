package com.network_project.net.greet;

import com.network_project.net.Greetable;

public class MorningGreet extends Greetable {

    @Override
    public String buildResponse(String userName) {
        return "Good morning," + userName;
    }
}
