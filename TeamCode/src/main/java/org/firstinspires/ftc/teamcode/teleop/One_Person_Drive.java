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
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.main_funcs.calc_drive;
import org.firstinspires.ftc.teamcode.main_funcs.driving_mtrs;
import org.firstinspires.ftc.teamcode.main_funcs.misc_func;
import org.firstinspires.ftc.teamcode.main_funcs.sendTelementery;
import org.firstinspires.ftc.teamcode.main_funcs.servos_all;


@TeleOp(name="One Person Drive", group="Main")

    public class One_Person_Drive extends OpMode {
    //Set class and method for permenant use.

    //Declare Function Calls
        misc_func misc_func = new misc_func();
        driving_mtrs drive = new driving_mtrs();
        calc_drive  calc_drive = new calc_drive();
        sendTelementery sendTelementery = new sendTelementery();
        servos_all servos_all = new servos_all();





        public void init() {
            telemetry.addData("Status", "Initialized");
            telemetry.update();
            //Functions To Initialize Robot

            drive.defineMotors();




            // Wait for the game to start (driver presses PLAY)
            drive.runtime.reset();
        }



            public void loop() {

                //Call driving motors method
                calc_drive.drive_caclulate();
                drive.teleop_input();
                servos_all.teleop_input();
                drive.sendMtrData();


                // Show the elapsed game time and wheel power.
                sendTelementery.sendregData();
            }
}














