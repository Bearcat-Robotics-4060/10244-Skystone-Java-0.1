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


@TeleOp(name="One Person Drive", group="Main")

public class MainDriveTeleOp_NoCoasting extends OpMode {

    // Declare OpMode members.


    //Motors
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor left_mtr = null;
    private DcMotor right_mtr = null;
    private DcMotor arm_mtr = null;


    //Servos
    //   private Servo colorArm = null;
    private Servo claw_1 = null;
    private Servo claw_2 = null;
    
    // private float leftPos = left_mtr.getCurrentPosition();
    // private float rightPos = right_mtr.getCurrentPosition();
    // private float armPos = arm_mtr.getCurrentPosition();


    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).

        //Motors
        left_mtr = hardwareMap.get(DcMotor.class, "left_mtr");
        right_mtr = hardwareMap.get(DcMotor.class, "right_mtr");
        arm_mtr = hardwareMap.get(DcMotor.class, "arm_mtr");
        //Servos
        claw_1 = hardwareMap.get(Servo.class, "claw_1");
        claw_2 = hardwareMap.get(Servo.class, "claw_2");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        left_mtr.setDirection(DcMotor.Direction.FORWARD);
        right_mtr.setDirection(DcMotor.Direction.REVERSE);
        arm_mtr.setDirection(DcMotor.Direction.FORWARD);

        left_mtr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_mtr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm_mtr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        left_mtr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_mtr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm_mtr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        left_mtr.setPower(0);
        right_mtr.setPower(0);
        arm_mtr.setPower(0);


        // Wait for the game to start (driver presses PLAY)
        runtime.reset();
    }


    // The driving code (Autonomous To be!)
    public void loop() {

        // Initialize Variables for storing the calculated motor power.
        double leftPower;
        double rightPower;
        double armPower = 0;

        //Motor mapping to sticks

        double drive_frd_bck = gamepad1.left_stick_y;
        double turn_left_right = -gamepad1.right_stick_x;
        //Original Clunky Driving Code
  //      leftPower = Range.clip(drive_frd_bck + turn_left_right, -1, 1);
  //      rightPower = Range.clip(drive_frd_bck - turn_left_right, -1, 1);


        //New Driving Code For Testing
        leftPower = drive_frd_bck - turn_left_right;
        rightPower = drive_frd_bck + turn_left_right;

        //To control the arm with DPad controls.

        if (gamepad1.dpad_up) {
           armPower = (0.5);
        }
        else if (gamepad1.dpad_down) {
            armPower = (-0.5);
        }

        //To control the claw with X and Y
        if (gamepad1.x) {

            claw_1.setPosition(1);
            claw_2.setPosition(0);

        } else if (gamepad1.y) {

            claw_1.setPosition(0);
            claw_2.setPosition(1);

        }

        // Send calculated power to wheels
        left_mtr.setPower(leftPower);
        right_mtr.setPower(rightPower);
        arm_mtr.setPower(armPower);


        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
        telemetry.addData("ArmMotorPower", "%.2f", armPower);
        telemetry.addData("Claw_1 PoS", "%.2f", claw_1.getPosition());
        telemetry.addData("Claw_2 PoS", "%.2f", claw_2.getPosition());
//Send Telementry Data To The Phone
        telemetry.update();
    }
//Function called when stop button is pressed on the phone.
        public void stop() {
            left_mtr.setPower(0);
            right_mtr.setPower(0);
            arm_mtr.setPower(0);
            }
}