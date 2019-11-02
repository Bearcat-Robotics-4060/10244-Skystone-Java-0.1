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

package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.main_funcs.calc_drive;
import org.firstinspires.ftc.teamcode.main_funcs.driving_mtrs;
import org.firstinspires.ftc.teamcode.main_funcs.misc_func;
import org.firstinspires.ftc.teamcode.main_funcs.sendTelementery;


@TeleOp(name="One Person Drive", group="Main")

public class One_Person_Drive extends OpMode {
//Set class and method for permenant use.



    // Declare OpMode members.


    //Declare Function Calls
    misc_func oth_func = new misc_func();
    driving_mtrs drive = new driving_mtrs();
    calc_drive  calc_drive = new calc_drive();
    sendTelementery sendTelementery = new sendTelementery();



    //Motors
    public ElapsedTime runtime = new ElapsedTime();
    public DcMotor left_mtr = null;
    public DcMotor right_mtr = null;
    public DcMotor r_lift = null;
    public DcMotor l_lift = null;
    public DcMotor intake_mtr = null;


    //Servos
    public Servo claw_1 = null;
    public Servo claw_2 = null;

    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).

        //Motors mapping to hardware

        //Servos
        claw_1 = hardwareMap.get(Servo.class, "claw_1");
        claw_2 = hardwareMap.get(Servo.class, "claw_2");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery


        oth_func.motor_init(left_mtr, true);
        oth_func.motor_init(right_mtr, true);
        oth_func.motor_init(r_lift, true);
        oth_func.motor_init(l_lift, true);
        oth_func.motor_init(intake_mtr, true);

        // Wait for the game to start (driver presses PLAY)
        runtime.reset();
    }


    // The driving code
    public void loop() {

        //Call driving motors method
        calc_drive.drive_caclulate();


        if (gamepad1.dpad_left) {
            drive.liftArm(-0.5);
        } else if (gamepad1.dpad_right) {
            drive.liftArm(0.5);
        } else {
            drive.liftArm(0);
        }


        //To control the arm with DPad controls.

        if (gamepad1.dpad_up) {
            intake_mtr.setPower(0.5);
        } else if (gamepad1.dpad_down) {
            intake_mtr.setPower(-0.5);
        } else {
            intake_mtr.setPower(0);

        }


        //To control the claw with X and Y
        if (gamepad1.x) {

            claw_1.setPosition(1);
            claw_2.setPosition(0);

        } else if (gamepad1.y) {

            claw_1.setPosition(0);
            claw_2.setPosition(1);

        }


        // Show the elapsed game time and wheel power.
        sendTelementery.sendData();
    }
}














