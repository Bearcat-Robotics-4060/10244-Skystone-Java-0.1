package org.firstinspires.ftc.teamcode.main_funcs;

import com.qualcomm.robotcore.hardware.DcMotor;

public class misc_func {
    public void motor_init (DcMotor mtr_, boolean _dir){


        if (_dir == true) {
            mtr_.setDirection(DcMotor.Direction.FORWARD);
        } else {
            mtr_.setDirection(DcMotor.Direction.REVERSE);
        }
        mtr_.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mtr_.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mtr_.setPower(0);


    }

    public void pause(long time) {
        long pauseTime = System.currentTimeMillis() + time;

        while (System.currentTimeMillis() < pauseTime) {

        }
    }


}

