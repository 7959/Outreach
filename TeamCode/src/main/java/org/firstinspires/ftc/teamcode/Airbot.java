package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Robi on 3/18/2017.
 */
@TeleOp(name = "PewPew Airplane")
public class Airbot extends LinearOpMode {
    boolean on;
    boolean poop;
    DcMotor lL;
    DcMotor lR;
    DcMotor fL;
    DcMotor fR;
    DcMotor bL;
    DcMotor bR;

    public void runOpMode() {
        lL = hardwareMap.dcMotor.get("Right Launcher");
        lR = hardwareMap.dcMotor.get("Left Launcher");
        lL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        lR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        lR.setDirection(DcMotorSimple.Direction.FORWARD);
        lL.setDirection(DcMotorSimple.Direction.REVERSE);
        fL = hardwareMap.dcMotor.get("Front Left");
        fR = hardwareMap.dcMotor.get("Front Right");
        bL = hardwareMap.dcMotor.get("Back Left");
        bR = hardwareMap.dcMotor.get("Back Right");
        fL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        bL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        fL.setDirection(DcMotorSimple.Direction.REVERSE);
        bR.setDirection(DcMotorSimple.Direction.REVERSE);
        bL.setDirection(DcMotorSimple.Direction.FORWARD);
        fR.setDirection(DcMotorSimple.Direction.FORWARD);
        waitForStart();
        while(opModeIsActive()){
            fR.setPower(gamepad1.left_stick_y -  gamepad1.left_stick_x);
            bR.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x);
            fL.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x);
            bL.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x);

            if(on){
                lR.setPower(1);
                lL.setPower(1);
            } else if(gamepad1.right_trigger > 0) {
                lR.setPower(1);
                lL.setPower(1);
            } else {
                lR.setPower(gamepad1.right_stick_y);
                lL.setPower(gamepad1.right_stick_y);
            }
            if(gamepad1.a && !poop){
                sleep(250);

                poop = true;
                on = !on;
            } else poop = false;
        }
        }

    }
