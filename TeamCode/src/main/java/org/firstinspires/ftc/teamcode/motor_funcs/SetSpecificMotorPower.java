package org.firstinspires.ftc.teamcode.motor_funcs;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.main_funcs.Pause;

public class SetSpecificMotorPower {
    Pause pause = new Pause();

    public void setSpecificMotor(DcMotor motorSpec, double power, int time) {
        motorSpec.setPower(power);
        pause.pause(time);
    }
}

