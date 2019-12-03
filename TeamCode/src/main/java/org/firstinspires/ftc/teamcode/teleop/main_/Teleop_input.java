package org.firstinspires.ftc.teamcode.teleop.main_;

import org.firstinspires.ftc.teamcode.Definitions;

public class Teleop_input {

    Definitions definitions = new Definitions();
    Motor_Actions motor_actions = new Motor_Actions();
    public void teleop_input(boolean gamepadq) {


        if (gamepadq) {

            if (definitions.gamepad1.dpad_up) {
                motor_actions.intakeMotor(0.5);
            } else if (definitions.gamepad1.dpad_down) {
                motor_actions.intakeMotor(-0.5);
            } else {
                motor_actions.intakeMotor(0);

            }

            if (definitions.gamepad1.dpad_left) {
                motor_actions.liftArm(-0.5);
            } else if (definitions.gamepad1.dpad_right) {
                motor_actions.liftArm(0.5);
            } else {
                motor_actions.liftArm(0);
            }


            if (definitions.gamepad1.x) {

                definitions.claw_1.setPosition(1);
                definitions.claw_2.setPosition(0);

            } else if (definitions.gamepad1.y) {

                definitions.claw_1.setPosition(0);
                definitions.claw_2.setPosition(1);

            }
        } else {
            if (definitions.gamepad2.dpad_up) {
                motor_actions.intakeMotor(0.5);
            } else if (definitions.gamepad2.dpad_down) {
                motor_actions.intakeMotor(-0.5);
            } else {
                motor_actions. intakeMotor(0);

            }

            if (definitions.gamepad2.dpad_left) {
                motor_actions.liftArm(-0.5);
            } else if (definitions.gamepad2.dpad_right) {
                motor_actions.liftArm(0.5);
            } else {
                motor_actions.liftArm(0);
            }

            if (definitions.gamepad2.x) {

                definitions.claw_1.setPosition(1);
                definitions.claw_2.setPosition(0);

            } else if (definitions.gamepad2.y) {

                definitions.claw_1.setPosition(0);
                definitions.claw_2.setPosition(1);

            }


        }

    }

}
