package org.firstinspires.ftc.teamcode.main_funcs;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


public class driving_mtrs {
//Importing vars from other classes
    misc_func othr = new misc_func();



    //This class with deal with the control of motors, including defining them.


    //Defining motors.

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor left_mtr = null;
    private DcMotor right_mtr = null;
    private DcMotor r_lift = null;
    private DcMotor l_lift = null;
    private DcMotor intake_mtr = null;

    public void map_motors()

    {

    }


    public void setSpecificMotor(DcMotor motorSpec, double power, int time) {
        motorSpec.setPower(power);
        othr.pause(time);
    }

    public void liftArm(double power) {
        
    }

}
