package org.firstinspires.ftc.teamcode.telementry_data;

import org.firstinspires.ftc.teamcode.Definitions;

public class SendTelementry {
    Definitions definitions = new Definitions();

    public void sendTelementery() {
        definitions.telemetry.addData("Status", "Run Time: " + definitions.runtime.toString());
        definitions.telemetry.addData("Joysticks", "left_x (%.2f), left_y (%.2f)", definitions.gamepad1.left_stick_x, definitions.gamepad1.left_stick_y);
        definitions.telemetry.addData("Motors", "left (%.2f), right (%.2f)", definitions.leftPower, definitions.rightPower);
        definitions.telemetry.addData("Left, Right Lift Power", "left (%.2f), right (%.2f)", definitions.l_lift.getPower(), definitions.r_lift.getPower());
        //definitions.telemetry.addData("Claw_1 PoS", "%.2f", claw_1.getPosition());
        //definitions.telemetry.addData("Claw_2 PoS", "%.2f", claw_2.getPosition());
        //Send Telemetry Data To The Phone
        definitions.telemetry.update();
    }
}
