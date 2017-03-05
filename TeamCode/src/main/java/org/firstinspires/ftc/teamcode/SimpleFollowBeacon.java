package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IrSeekerSensor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cIrSeekerSensorV3;

/**
 * Created by Robi on 3/2/2017.
 */
@Autonomous(name = "Baby Bot")
public class SimpleFollowBeacon extends LinearOpMode{
    DcMotor Left;
    DcMotor Right;
    ModernRoboticsI2cIrSeekerSensorV3 IR;
    ModernRoboticsI2cGyro g;
    public void runOpMode(){
        Right = hardwareMap.dcMotor.get("Right");
        Left = hardwareMap.dcMotor.get("Left");
        IR = (ModernRoboticsI2cIrSeekerSensorV3)hardwareMap.irSeekerSensor.get("IR");
        IR.setSignalDetectedThreshold(0);
        g = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("Gyro");
        Right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Right.setDirection(DcMotorSimple.Direction.FORWARD);
        Left.setDirection(DcMotorSimple.Direction.REVERSE);
        g.calibrate();
        while(!isStopRequested() && g.isCalibrating()) {
            telemetry.addData("Let me calibrate", "please");
            telemetry.update();
        }
        telemetry.addData("Hey thanks", "kid");
        telemetry.update();
        waitForStart();
        while(opModeIsActive()){
            //////////////Basic telemetry thingy. Will tell us strength and angle
            if(IR.signalDetected()) {
                telemetry.addData("I think the strength of the beacon is", IR.getStrength());
                telemetry.addData("I think the angle is", IR.getAngle());
            }else telemetry.addData("What is the meaning of life??", "When I can't see a beacon!");
            /////////////////

            telemetry.addData("My angle", g.getIntegratedZValue());/// gyro sensor angle add on
            telemetry.update();

        }
    }
    public void anglegothing(double speed, int angle){//play with sensors beforehand before coding this
        int angledif = (angle - g.getIntegratedZValue())/100;
        double r = speed + angledif;
        double l = speed - angledif;
        if(r > 1) r = 1;
        if(r < -1) r = -1;
        if(l < -1) l = -1;
        if(l > 1) l = 1;

    }
    public void gogo(double speed){
        double dif = (IR.getAngle() / 100);
        double r = speed - dif;
        double l = speed + dif;
        Range.clip(r, -1, 1);
        Range.clip(l, -1, 1);
        Right.setPower(r);
        Left.setPower(l);
    }

}
