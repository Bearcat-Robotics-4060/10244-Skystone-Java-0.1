package org.firstinspires.ftc.teamcode.servos;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Definitions;

public class Init_Servos extends OpMode {
Definitions definitions = new Definitions();

public void init() {

}

public void loop() {

}

    public void init_servos() {
        //Servos
        definitions.claw_1 = hardwareMap.get(Servo.class, "claw_1");
        definitions.claw_2 = hardwareMap.get(Servo.class, "claw_2");

    }
}
