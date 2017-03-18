package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cIrSeekerSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IrSeekerSensor;

/**
 * Created by Robi on 3/7/2017.
 */
@Autonomous(name = "2sensecool")
public class Twosensorthing extends LinearOpMode {
    DcMotor Right;
    IrSeekerSensor IR;
    boolean posleft = false;
    DcMotor Left;
    public void runOpMode() {
        Right = hardwareMap.dcMotor.get("Right");
        Left = hardwareMap.dcMotor.get("Left");
        Right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Right.setDirection(DcMotorSimple.Direction.FORWARD);
        Left.setDirection(DcMotorSimple.Direction.REVERSE);

        IR = hardwareMap.irSeekerSensor.get("IR");
        IR.setSignalDetectedThreshold(.1);
        waitForStart();
        while(opModeIsActive()){
            if(IR.signalDetected()) {
                telemetry.addData("Str", IR.getStrength());
                telemetry.addData("angle", IR.getAngle());
                telemetry.update();
            } else telemetry.addData("AHHHHH", ":(");
            if(IR.signalDetected()){
                telemetry.addData("Str", IR.getStrength());
                telemetry.addData("angle", IR.getAngle());
                telemetry.update();
                if(IR.getAngle() > 0){
                    posleft = true;
                    Right.setPower(0);
                    Left.setPower(0);
                } else {
                    posleft = false;
                    Right.setPower(0);
                    Left.setPower(0);
                }
            } else {
                telemetry.addData("AHHHHH", ":(");
                telemetry.update();
                if (posleft) {
                    Right.setPower(.25);
                    Left.setPower(-.25);
                } else {
                    Left.setPower(.25);
                    Right.setPower(-.25);
                }
            }
            }
        }
    }
