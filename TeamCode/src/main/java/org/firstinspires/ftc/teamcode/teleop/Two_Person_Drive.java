///* Copyright (c) 2017 FIRST. All rights reserved.
// *
// * Redistribution and use in source and binary forms, with or without modification,
// * are permitted (subject to the limitations in the disclaimer below) provided that
// * the following conditions are met:
// *
// * Redistributions of source code must retain the above copyright notice, this list
// * of conditions and the following disclaimer.
// *
// * Redistributions in binary form must reproduce the above copyright notice, this
// * list of conditions and the following disclaimer in the documentation and/or
// * other materials provided with the distribution.
// *
// * Neither the name of FIRST nor the names of its contributors may be used to endorse or
// * promote products derived from this software without specific prior written permission.
// *
// * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
// * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
// * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
// * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
// * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
// * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
// * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
// */
//
//package org.firstinspires.ftc.teamcode.teleop;
//
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//
//import org.firstinspires.ftc.teamcode.main_funcs.calc_drive;
//
//
//@TeleOp(name="Two Person Drive", group="Main")
//
//public class Two_Person_Drive extends OpMode {
//    //Set class and method for permenant use.
//
//    //Declare Function Calls
//
//    moving_parts moving_parts = new moving_parts();
//    calc_drive  calc_drive = new calc_drive();
//
//
////False is gamepad 1, while True is gamepad 2
//
//    boolean drivePad = false;
//    boolean lifter = true;
//    boolean suction = true;
//    boolean servos = true;
//
//
//
//
//    public void init() {
//        telemetry.addData("Status", "Initialized");
//        telemetry.update();
//        //Functions To Initialize Robot
//
//        moving_parts.defineMotors();
//        moving_parts.init_servos();
//
//
//
//
//        // Wait for the game to start (driver presses PLAY)
//        moving_parts.runtime.reset();
//    }
//
//
//
//    public void loop() {
//
//        //Call driving motors method
//        calc_drive.drive_caclulate();
//        moving_parts.teleop_input(drivePad);
//        moving_parts.teleop_input(servos);
//        moving_parts.sendMtrData();
//
//
//        // Show the elapsed game time and wheel power.
//        telemetry.addData("Status", "Run Time: " + moving_parts.runtime.toString());
//        telemetry.addData("Joysticks", "left_x (%.2f), left_y (%.2f)", gamepad1.left_stick_x, gamepad1.left_stick_y);
//        telemetry.addData("Motors", "left (%.2f), right (%.2f)", calc_drive.leftPower, calc_drive.rightPower);
//        telemetry.addData("Left, Right Lift Power", "left (%.2f), right (%.2f)", moving_parts.l_lift.getPower(), moving_parts.r_lift.getPower());
//        telemetry.addData("Claw_1 PoS", "%.2f", moving_parts.claw_1.getPosition());
//        telemetry.addData("Claw_2 PoS", "%.2f", moving_parts.claw_2.getPosition());
//        //Send Telemetry Data To The Phone
//        telemetry.update();
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
