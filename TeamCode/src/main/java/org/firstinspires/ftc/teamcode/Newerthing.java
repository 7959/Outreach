package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Newthing;
/**
 * Created by Robi on 3/17/2017.
 */
@TeleOp(name = "Thingy")
public class Newerthing extends LinearOpMode {
    public Newthing thing;
    public void runOpMode(){
        Newthing.initthing();
        waitForStart();
        while(opModeIsActive()){
            if(Newthing.hippylippykitty.dpad_left){
                Newthing.pivy(1, -1);
            } else if(Newthing.hippylippykitty.dpad_right){
                Newthing.pivy(1, -1);
            } else {
                Newthing.cooki();
            }
        }
    }
}
