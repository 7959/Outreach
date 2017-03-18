package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robi on 3/17/2017.
 */

public class Newthing{
    public static HardwareMap Mappymcdoodle = null;
    public static Gamepad hippylippykitty;
        public static DcMotor Rifty;
        public static DcMotor Longey;
        public static void initthing()  {
            Rifty = Mappymcdoodle.dcMotor.get("Right");
            Longey = Mappymcdoodle.dcMotor.get("Left");
            Rifty.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            Longey.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            Rifty.setDirection(DcMotorSimple.Direction.FORWARD);
            Longey.setDirection(DcMotorSimple.Direction.REVERSE);
            Longey.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            Rifty.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        public static void pivy(double r ,double l){
            Rifty.setPower(r);
            Longey.setPower(l);
        }
        public static void cooki(){
            Rifty.setPower(hippylippykitty.left_stick_y + hippylippykitty.right_stick_x);
            Longey.setPower(hippylippykitty.left_stick_y - hippylippykitty.right_stick_x);
        }
}
