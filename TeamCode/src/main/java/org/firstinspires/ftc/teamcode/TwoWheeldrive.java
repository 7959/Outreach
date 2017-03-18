package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cIrSeekerSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Robi on 3/6/2017.
 */
@TeleOp(name = "Thingy2")
public class TwoWheeldrive extends OpMode {
    DcMotor Right;
    DcMotor Left;
    public void init(){
        Right = hardwareMap.dcMotor.get("Right");
        Left = hardwareMap.dcMotor.get("Left");
        Right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Right.setDirection(DcMotorSimple.Direction.FORWARD);
        Left.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void loop(){
        Right.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x);
        Left.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x);
    }
}
