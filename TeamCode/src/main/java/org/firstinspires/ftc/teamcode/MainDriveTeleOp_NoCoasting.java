/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="Two Person Drive NOOASTING", group="Main")

public class MainDriveTeleOp_NoCoasting extends OpMode {

    // Declare OpMode members.


    //Motors
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor liftMotor = null;
    private DcMotor armMotor = null;

    //Servos
    //   private Servo colorArm = null;
    private Servo armMid = null;
    private Servo clawHand = null;
    private Servo baseArm = null;

    private Double LeftValue;
    private Double RightValue;

    private float leftPos = leftDrive.getCurrentPosition();
    private float rightPos = rightDrive.getCurrentPosition();
    private float armPos = armMotor.getCurrentPosition();
    private float liftPos = liftMotor.getCurrentPosition();


    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).

        //Motors
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        //Servos
        armMid = hardwareMap.get(Servo.class, "armMid");
        clawHand = hardwareMap.get(Servo.class, "clawHand");
        baseArm = hardwareMap.get(Servo.class, "baseArm");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        liftMotor.setDirection(DcMotor.Direction.FORWARD);
        armMotor.setDirection(DcMotor.Direction.FORWARD);

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        armMotor.setPower(0);
        liftMotor.setPower(0);


        // Wait for the game to start (driver presses PLAY)
        runtime.reset();
    }


    // run until the end of the match (driver presses STOP)
    public void loop() {

        // Setup a variable for each drive wheel to save power level for telemetry
        double leftPower;
        double rightPower;

        //Motors
        double drive = gamepad1.left_stick_y;
        double turn = -gamepad1.right_stick_x;
        leftPower = Range.clip(drive + turn, -1, 1);
        rightPower = Range.clip(drive - turn, -1, 1);


        if (gamepad2.left_stick_y < 0.1 || gamepad2.left_stick_y > -0.1) {
            liftMotor.setPower(gamepad2.left_stick_y);
        }

        else if (!gamepad2.dpad_down || !gamepad2.dpad_up) {
            liftMotor.setPower(0);
        }
        if (gamepad2.left_bumper) {
            armMotor.setPower(-0.5);
        } else if (gamepad2.right_bumper) {
            armMotor.setPower(1);
        } else if (!gamepad2.left_bumper || !gamepad2.right_bumper) {
            armMotor.setPower(0.0);
        }


        //Servos
        LeftValue = 0.0;
        RightValue = 0.0;


        if (gamepad2.x) {

            clawHand.setPosition(0);

        } else if (gamepad2.y) {
            clawHand.setPosition(1.0);
        } else if (gamepad2.a) {
            armMid.setPosition(0);
        } else if (gamepad2.b) {
            armMid.setPosition(1);
        }

        // Send calculated power to wheels
        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);


        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
        telemetry.addData("Left POS", "(%.2f)", leftPos);
        telemetry.addData("Right POS", "(%.2f)", rightPos);
        telemetry.addData("Lift POS", "(%.2f)", liftPos);
        telemetry.addData("Arm  POS", "(%.2f)", armPos);

        telemetry.update();
    }

        public void stop() {
            leftDrive.setPower(0);
            rightDrive.setPower(0);
            liftMotor.setPower(0);
            armMotor.setPower(0);
            armMid.setPosition(0.5);
            clawHand.setPosition(0.5);
            baseArm.setPosition(0.5);
        }
}