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

import org.firstinspires.ftc.teamcode.Definitions;
import org.firstinspires.ftc.teamcode.Drive_Funcs.Drive_Calculate;
import org.firstinspires.ftc.teamcode.motor_funcs.SendMtrData;
import org.firstinspires.ftc.teamcode.motor_funcs.SetMotorDefinitions;
import org.firstinspires.ftc.teamcode.servos.Init_Servos;
import org.firstinspires.ftc.teamcode.telementry_data.SendTelementry;
import org.firstinspires.ftc.teamcode.teleop.main_.Teleop_input;


@TeleOp(name="One Person Drive", group="Main")

    public class One_Person_Drive extends OpMode {


    //Declare Function Calls
    Drive_Calculate drive_caclulate = new Drive_Calculate();
    Definitions definitions = new Definitions();
    SendMtrData sendMtrData = new SendMtrData();
    SetMotorDefinitions setMotorDefinitions = new SetMotorDefinitions();
    Teleop_input teleop_input = new Teleop_input();
    SendTelementry sendTelementry = new SendTelementry();
    Init_Servos init_servos = new Init_Servos();


    //Opmode Specific Variables for configuration
//False is gamepad 1, while True is gamepad 2

    boolean drivePad = false;
    boolean lifter = true;
    boolean suction = true;
    boolean servos = true;


    public void init() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        //Functions To Initialize Robot
            setMotorDefinitions.hardwareMapBind();
          setMotorDefinitions.defineMotors();
          init_servos.init_servos();

          //Below Code is for moving which parts need to be moved during Initialization;






            // Wait for the game to start (driver presses PLAY)
        definitions.runtime.reset();
        }



            public void loop() {
                //Run the inputs
                teleop_input.teleop_input(true);

                //Calculate the motor inputs:
               drive_caclulate.drive_caclulate();

               //Send the data to the motors;
               sendMtrData.sendMtrData();

                // Show the elapsed game time and wheel power.
                sendTelementry.sendTelementery();

            }
}














