package org.firstinspires.ftc.teamcode.main_funcs;

import org.firstinspires.ftc.teamcode.teleop.One_Person_Drive;

public class calc_drive {
    One_Person_Drive one_person_drive = new One_Person_Drive();
    driving_mtrs driving_mtrs = new driving_mtrs();
    misc_func misc_func = new misc_func();

    //Define vars
    public double joy1x = one_person_drive.gamepad1.left_stick_x;
    public double joy1y = one_person_drive.gamepad1.left_stick_y;
    public double leftPower;
    public double rightPower;




//Motor mapping to sticks
    //Doing the math for our smooth drive
        /*
        Here's an idea, get x and y, left motor = x - y, right motor = x + y
         There is no reason this shouldn't work smoothly.
         */


    public void drive_caclulate(){
        leftPower = joy1x - joy1y;
        rightPower = joy1x + joy1y;
    }




}
