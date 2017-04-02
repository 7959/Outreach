package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Robi on 3/28/2017.
 */
@Autonomous(name = "Sta")
public class FollowIR extends LinearOpMode {
    DcMotor l;
    DcMotor r;

    public void runOpMode() {
        r = hardwareMap.dcMotor.get("Right");
        l = Map.dcMotor.get("Left");
    }


    public boolean leftbeac(){
    }
}
