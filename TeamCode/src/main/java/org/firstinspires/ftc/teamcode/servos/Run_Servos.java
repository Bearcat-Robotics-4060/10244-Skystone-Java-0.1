package org.firstinspires.ftc.teamcode.servos;

import com.qualcomm.robotcore.hardware.Servo;

public class Run_Servos {

    public void run_servos(Servo _servo, double position)
    {
        _servo.setPosition(position);
    }
}
