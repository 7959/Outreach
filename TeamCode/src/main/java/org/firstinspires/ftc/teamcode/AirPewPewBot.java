package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cAddr;

/**
 * Created by Robi on 3/17/2017.
 */
//@TeleOp(name = "PewPew Airplane")
public class AirPewPewBot extends LinearOpMode {
    private class pew{
        private DcMotor lL;
        private DcMotor lR;
        public void Map() {
            lL = hardwareMap.dcMotor.get("Right Launcher");
            lR = hardwareMap.dcMotor.get("Left Launcher");

        }
        public void setup(){
                lL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
                lR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

                lL.setDirection(DcMotorSimple.Direction.FORWARD);
                lR.setDirection(DcMotorSimple.Direction.REVERSE);
        }

        public void power(double pow){
            lL.setPower(pow);
            lR.setPower(pow);
        }
        public void full(){
            power(1);
        }
    }
    private class Wheels{
        private DcMotor fL;
        private DcMotor fR;
        private DcMotor bL;
        private DcMotor bR;

        private void map(){
            fL = hardwareMap.dcMotor.get("Front Left");
            fR = hardwareMap.dcMotor.get("Front Right");
            bL = hardwareMap.dcMotor.get("Back Left");
            bR = hardwareMap.dcMotor.get("Back Right");
        }
        private void setup(){
                fL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                fR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

                bL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                bR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


                fL.setDirection(DcMotorSimple.Direction.REVERSE);
                bL.setDirection(DcMotorSimple.Direction.REVERSE);
                bR.setDirection(DcMotorSimple.Direction.FORWARD);
                fR.setDirection(DcMotorSimple.Direction.REVERSE);
        }
        private void control(){
            fR.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x);
            bR.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x);
            fL.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x);
            bL.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x);
        }
    }
    private Wheels go;
    private pew shooty;
    private boolean poop = false;
    private boolean on = false;
    public void runOpMode(){
        go.map();
        go.setup();
        shooty.Map();
        shooty.setup();
        waitForStart();
        while(opModeIsActive()){
            go.control();
            if(on){
                shooty.full();
            } else if(gamepad1.right_trigger > 0) {
                shooty.full();
            } else shooty.power(gamepad1.right_stick_y);
            if(gamepad1.a && !poop){
                poop = true;
                on = !on;
            } else poop = false;
        }
    }

}
