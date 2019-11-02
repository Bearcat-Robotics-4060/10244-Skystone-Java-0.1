package org.firstinspires.ftc.teamcode.main_funcs;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.teleop.One_Person_Drive;


public class driving_mtrs {
    //Importing vars from other classes
    misc_func misc_func = new misc_func();
    One_Person_Drive one_person_drive = new One_Person_Drive();
    calc_drive calc_drive = new calc_drive();


    //This class with deal with the control of motors, including defining them.


    //Defining motors.
    public void map_motors() {

    }


    public void setSpecificMotor(DcMotor motorSpec, double power, int time) {
        motorSpec.setPower(power);
        misc_func.pause(time);
    }

    public void liftArm(double power) {
        one_person_drive.l_lift.setPower(power);
        one_person_drive.r_lift.setPower(power);
    }

    public void intakeMotor(double power) {
        one_person_drive.intake_mtr.setPower(power);
    }

    public void sendMtrData() {
        one_person_drive.left_mtr.setPower(calc_drive.leftPower);
        one_person_drive.right_mtr.setPower(calc_drive.rightPower);
    }
}
