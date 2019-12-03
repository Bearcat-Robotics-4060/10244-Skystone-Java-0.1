package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Definitions extends OpMode {
//Setting all non-opmode specific variables.
    public double leftPower;
    public double rightPower;

    public ElapsedTime runtime = new ElapsedTime();
    public DcMotor left_mtr = null;
    public DcMotor right_mtr = null;
    public DcMotor r_lift = null;
    public DcMotor l_lift = null;
    public DcMotor intake_mtr = null;

    public double joy1x = gamepad1.left_stick_x;
    public double joy1y = gamepad1.left_stick_y;

    public Servo claw_1 = null;
    public Servo claw_2 = null;

    public void init()

    {
    }

    public void loop()
    {
    }
}
