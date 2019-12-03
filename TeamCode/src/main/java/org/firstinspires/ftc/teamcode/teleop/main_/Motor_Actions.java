package org.firstinspires.ftc.teamcode.teleop.main_;

import org.firstinspires.ftc.teamcode.Definitions;

public class Motor_Actions {

    Definitions definitions = new Definitions();

    public void liftArm(double power) {
        definitions.l_lift.setPower(power);
        definitions.r_lift.setPower(power);
    }

    public void intakeMotor(double power) {
        definitions.intake_mtr.setPower(power);
    }


}
