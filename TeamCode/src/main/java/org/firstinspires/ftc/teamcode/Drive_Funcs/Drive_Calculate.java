package org.firstinspires.ftc.teamcode.Drive_Funcs;

//import org.firstinspires.ftc.teamcode.teleop.One_Person_Drive;

import org.firstinspires.ftc.teamcode.Definitions;

public class Drive_Calculate {

    Definitions definitions = new Definitions();

    public void drive_caclulate(){




        definitions.leftPower = definitions.joy1y - definitions.joy1x;
        definitions.rightPower = definitions.joy1y + definitions.joy1x;



    }






}
