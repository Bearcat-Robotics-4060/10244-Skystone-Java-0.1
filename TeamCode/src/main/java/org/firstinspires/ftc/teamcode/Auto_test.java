package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.Servo;
        import com.qualcomm.robotcore.util.ElapsedTime;
        import com.qualcomm.robotcore.util.Range;


@Autonomous(name="Auto_Test", group="Main")

public class Auto_test extends OpMode {
    //Declare OpMode members.


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


        left_mtr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_mtr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm_mtr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left_mtr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_mtr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm_mtr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


            public void loop () {

            // Initialize Variables for storing the calculated motor power.
            double leftPower;
            double rightPower;
            double armPower = 0;


            // Send calculated power to wheels
            //left_mtr.setPower(leftPower);
            //right_mtr.setPower(rightPower);
            arm_mtr.setPower(armPower);


            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            //  telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.addData("ArmMotorPower", "%.2f", armPower);
            telemetry.addData("Claw_1 PoS", "%.2f", claw_1.getPosition());
            telemetry.addData("Claw_2 PoS", "%.2f", claw_2.getPosition());
//Send Telementry Data To The Phone
            telemetry.update();

            //Function called when stop button is pressed on the phone.
        }

            public void stop() {
            left_mtr.setPower(0);
            right_mtr.setPower(0);
            arm_mtr.setPower(0);
        }
        }





