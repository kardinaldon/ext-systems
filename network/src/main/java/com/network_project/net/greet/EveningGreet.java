package com.network_project.net.greet;

import com.network_project.net.Greetable;

public class EveningGreet extends Greetable {
    @Override
    public String buildResponse(String userName) {
        return "Good evening," + userName;
    }
}
