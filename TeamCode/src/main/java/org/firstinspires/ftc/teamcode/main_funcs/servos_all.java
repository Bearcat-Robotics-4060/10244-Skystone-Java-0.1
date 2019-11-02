package org.firstinspires.ftc.teamcode.main_funcs;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.teleop.One_Person_Drive;

public class servos_all {
    //Declare Function Calls
    misc_func misc_func = new misc_func();
    driving_mtrs drive = new driving_mtrs();
    calc_drive  calc_drive = new calc_drive();
    sendTelementery sendTelementery = new sendTelementery();
    One_Person_Drive one_person_drive = new One_Person_Drive();

    public Servo claw_1 = null;
    public Servo claw_2 = null;

public void init_servos() {
    //Servos
    claw_1 = one_person_drive.hardwareMap.get(Servo.class, "claw_1");
    claw_2 = one_person_drive.hardwareMap.get(Servo.class, "claw_2");

}

public void run_servos(Servo _servo, double position) {
    _servo.setPosition(position);
}

public void teleop_input() {
    if (one_person_drive.gamepad1.x) {

       claw_1.setPosition(1);
       claw_2.setPosition(0);

    } else if (one_person_drive.gamepad1.y) {

       claw_1.setPosition(0);
       claw_2.setPosition(1);

    }
}


}
