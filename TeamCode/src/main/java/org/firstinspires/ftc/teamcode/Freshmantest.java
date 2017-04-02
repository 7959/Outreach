package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robi on 3/24/2017.
 */
@Autonomous(name = "LILY PRESS ME")
public class Freshmantest extends LinearOpMode {
    CRServo servo1;
    public void runOpMode() {
        servo1 = hardwareMap.crservo.get("Servo");
        servo1.setDirection(DcMotorSimple.Direction.FORWARD);
        waitForStart();
        while(opModeIsActive()) {
            servo1.setPower(.5);
        }
    }
}
