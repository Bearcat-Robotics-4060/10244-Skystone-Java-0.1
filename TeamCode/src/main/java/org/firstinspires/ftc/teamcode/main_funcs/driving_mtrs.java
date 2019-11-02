package org.firstinspires.ftc.teamcode.main_funcs;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.teleop.One_Person_Drive;


public class driving_mtrs {
    //Importing vars from other classes
    misc_func misc_func = new misc_func();
    One_Person_Drive one_person_drive = new One_Person_Drive();
    calc_drive calc_drive = new calc_drive();


    //This class with deal with the control of motors, including defining them.

        //Define Motor Vars + Elapsed Time
        //Motors
        public ElapsedTime runtime = new ElapsedTime();
    public DcMotor left_mtr = null;
    public DcMotor right_mtr = null;
    public DcMotor r_lift = null;
    public DcMotor l_lift = null;
    public DcMotor intake_mtr = null;

    public void defineMotors(){


        misc_func.motor_init(left_mtr, true);
        misc_func.motor_init(right_mtr, false);
        misc_func.motor_init(r_lift, true);
        misc_func.motor_init(l_lift, true);
        misc_func.motor_init(intake_mtr, true);

    }



    public void setSpecificMotor(DcMotor motorSpec, double power, int time) {
        motorSpec.setPower(power);
        misc_func.pause(time);
    }

    public void liftArm(double power) {
        l_lift.setPower(power);
        r_lift.setPower(power);
    }

    public void intakeMotor(double power) {
        intake_mtr.setPower(power);
    }

    public void sendMtrData() {
        left_mtr.setPower(calc_drive.leftPower);
        right_mtr.setPower(calc_drive.rightPower);
    }

    public void teleop_input() {
        if (one_person_drive.gamepad1.dpad_up) {
            intakeMotor(0.5);
        } else if (one_person_drive.gamepad1.dpad_down) {
            intakeMotor(-0.5);
        } else {
            intakeMotor(0);

        }

        if (one_person_drive.gamepad1.dpad_left) {
            liftArm(-0.5);
        } else if (one_person_drive.gamepad1.dpad_right) {
            liftArm(0.5);
        } else {
            liftArm(0);
        }

    }
}
