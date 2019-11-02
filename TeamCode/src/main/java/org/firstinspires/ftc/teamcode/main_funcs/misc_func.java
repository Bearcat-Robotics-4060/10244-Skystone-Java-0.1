package org.firstinspires.ftc.teamcode.main_funcs;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.teleop.One_Person_Drive;

public class misc_func {
One_Person_Drive one_person_drive = new One_Person_Drive();

    public void motor_init (DcMotor mtr_, boolean _dir){


        if (_dir == true) {
            mtr_.setDirection(DcMotor.Direction.FORWARD);
        } else {
            mtr_.setDirection(DcMotor.Direction.REVERSE);
        }
        mtr_.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mtr_.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mtr_.setPower(0);


        mtr_ = one_person_drive.hardwareMap.get(DcMotor.class, "%mtr_");

    }

    public void pause(long time) {
        long pauseTime = System.currentTimeMillis() + time;

        while (System.currentTimeMillis() < pauseTime) {

        }
    }


}

