/*
Modern Robotics IR Locator 360 Sensor Example
Created 9/4/2016 by Colton Mehlhoff of Modern Robotics using FTC SDK 2.2 Beta
Reuse permitted with credit where credit is due

Configuration:
I2cDevice on an Interface Module named "locator" at the default address of 0x1C (0x0E 7-bit)

This program can be run without a battery and Power Destitution Module.

For more information, visit http://modernroboticsinc.com/ir-locator-360.
Support is available by emailing support@modernroboticsinc.com.
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;

@TeleOp(name = "Locator I2C", group = "MRI")
public class MRI_Locator_I2C extends OpMode {

    byte[] locator1Cache; //The read will return an array of bytes. They are stored in this variable

    I2cAddr LOCATOR1ADDRESS = new I2cAddr(0x0E); //Default I2C address for MR Locator (7-bit)
    public static final int LOCATOR1_REG_START = 0x04; //Register to start reading
    public static final int LOCATOR1_READ_LENGTH = 4; //Number of byte to read

    public I2cDevice LOCATOR1;
    public I2cDeviceSynch LOCATOR1Reader;

    int heading12;
    int heading6;

    @Override
    public void init() {
        LOCATOR1 = hardwareMap.i2cDevice.get("locator");
        LOCATOR1Reader = new I2cDeviceSynchImpl(LOCATOR1, LOCATOR1ADDRESS, false);
        LOCATOR1Reader.engage();
    }

    @Override
    public void loop() {
        locator1Cache = LOCATOR1Reader.read(LOCATOR1_REG_START, LOCATOR1_READ_LENGTH);

        heading12 = (locator1Cache[0] & 0xFF) * 5;
        heading6 = (locator1Cache[2] & 0xFF) * 5;

        telemetry.addData("0 Mode", "Match mode on beacon to mode below. 1200 or 600Hz");
        telemetry.addData("1 Heading 12", heading12);
        telemetry.addData("2 Raw 12", locator1Cache[0] & 0xFF);
        telemetry.addData("3 Strength 12", locator1Cache[1] & 0xFF);
        telemetry.addData("4 Heading 6", heading6);
        telemetry.addData("5 Raw 6", locator1Cache[2] & 0xFF);
        telemetry.addData("6 Strength 6", locator1Cache[3] & 0xFF);
    }

    @Override
    public void stop() {

    }

}