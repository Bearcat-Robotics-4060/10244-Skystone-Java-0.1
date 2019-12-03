package org.firstinspires.ftc.teamcode.motor_funcs;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Definitions;

public class SetMotorDefinitions extends OpMode {

    Definitions definitions = new Definitions();

    public void init() {


    }

    public void loop()
    {
    }

    public void hardwareMapBind() {
        definitions.left_mtr = hardwareMap.get(DcMotor.class, "left_mtr");

        definitions.right_mtr = hardwareMap.get(DcMotor.class, "right_mtr");

        definitions.r_lift = hardwareMap.get(DcMotor.class, "r_lift");

        definitions.l_lift = hardwareMap.get(DcMotor.class, "l_lift");

        definitions.intake_mtr = hardwareMap.get(DcMotor.class, "intake_mtr");

    }

    public void defineMotors() {
        motor_init(definitions.left_mtr, true);
        motor_init(definitions.right_mtr, false);
        motor_init(definitions.r_lift, true);
        motor_init(definitions.l_lift, false);
        motor_init(definitions.intake_mtr, true);

    }


    public void motor_init(DcMotor mtr_, boolean _dir) {


        if (_dir == true) {
            mtr_.setDirection(DcMotor.Direction.FORWARD);
        } else {
            mtr_.setDirection(DcMotor.Direction.REVERSE);
        }
        mtr_.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mtr_.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mtr_.setPower(0);

    }
}