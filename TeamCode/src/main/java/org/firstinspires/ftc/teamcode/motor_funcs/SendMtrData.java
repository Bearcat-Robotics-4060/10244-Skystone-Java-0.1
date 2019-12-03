package org.firstinspires.ftc.teamcode.motor_funcs;

import org.firstinspires.ftc.teamcode.Definitions;

public class SendMtrData {
    Definitions definitions = new Definitions();

    public void sendMtrData() {
        definitions.left_mtr.setPower(definitions.leftPower);
        definitions.right_mtr.setPower(definitions.rightPower);
    }
}
