package org.firstinspires.ftc.teamcode.main_funcs;

public class Pause {
    public void pause(long time) {
        long pauseTime = System.currentTimeMillis() + time;

        while (System.currentTimeMillis() < pauseTime) {

        }
    }
}
