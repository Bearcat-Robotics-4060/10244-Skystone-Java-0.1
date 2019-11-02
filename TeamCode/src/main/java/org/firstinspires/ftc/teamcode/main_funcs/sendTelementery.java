package org.firstinspires.ftc.teamcode.main_funcs;

import org.firstinspires.ftc.teamcode.teleop.One_Person_Drive;

public class sendTelementery {
    One_Person_Drive one_person_drive = new One_Person_Drive();
    calc_drive calc_drive = new calc_drive();
    driving_mtrs driving_mtrs = new driving_mtrs();
    servos_all servos_all = new servos_all();

    public void sendregData() {
        one_person_drive.telemetry.addData("Status", "Run Time: " + driving_mtrs.runtime.toString());
        one_person_drive.telemetry.addData("Joysticks", "left_x (%.2f), left_y (%.2f)", one_person_drive.gamepad1.left_stick_x, one_person_drive.gamepad1.left_stick_y);
        one_person_drive.telemetry.addData("Motors", "left (%.2f), right (%.2f)", calc_drive.leftPower, calc_drive.rightPower);
        one_person_drive.telemetry.addData("Left, Right Lift Power", "left (%.2f), right (%.2f)", driving_mtrs.l_lift.getPower(), driving_mtrs.r_lift.getPower());
        one_person_drive.telemetry.addData("Claw_1 PoS", "%.2f", servos_all.claw_1.getPosition());
        one_person_drive.telemetry.addData("Claw_2 PoS", "%.2f", servos_all.claw_2.getPosition());
//Send Telementry Data To The Phone
        one_person_drive.telemetry.update();
    }


}
