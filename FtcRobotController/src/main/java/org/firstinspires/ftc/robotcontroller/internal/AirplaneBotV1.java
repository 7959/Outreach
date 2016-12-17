package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Joseph on 12/15/2016.
 */

@TeleOp(name = "V1",group = "Airplane Robot")
public class AirplaneBotV1 extends OpMode {
    private class Left {
        private DcMotor front;
        private DcMotor back;
        public void init() {
            front = hardwareMap.dcMotor.get("Front Left");
            back = hardwareMap.dcMotor.get("Back Left");
            front.setDirection(DcMotorSimple.Direction.FORWARD);
            back.setDirection(DcMotorSimple.Direction.FORWARD);
            front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            front.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            back.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        public void setPower(double speed) {
            front.setPower(speed);
            back.setPower(speed);
        }
    }
    private class Right {
        private DcMotor front;
        private DcMotor back;
        public void init() {
            front = hardwareMap.dcMotor.get("Front Right");
            back = hardwareMap.dcMotor.get("Back Right");
            front.setDirection(DcMotorSimple.Direction.REVERSE);
            back.setDirection(DcMotorSimple.Direction.REVERSE);
            front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            front.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            back.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        public void setPower(double speed) {
            front.setPower(speed);
            back.setPower(speed);
        }
    }

    private Left left;
    private Right right;

    public void init() {
        left.init();
        right.init();
    }
    public void loop() {
        left.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x);
        right.setPower(-gamepad1.left_stick_y - gamepad1.left_stick_x);
    }
}
