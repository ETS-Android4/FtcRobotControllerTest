package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

//LinearOp mode runs through the "runOpMode()" method once when "init" is pressed
@Autonomous(name = "LinearAutoDemo", group = "Auto")
public class LinearAuto extends LinearOpMode {
    //Here the motor is being defined
    DcMotor motor;

    //This is being run when "init" is pressed
    @Override
    public void runOpMode() {
        //This obtains the motor
        motor = hardwareMap.get(DcMotor.class, "motor");

        //Sets the motor to break when no power is supplied
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //This waits for the start or "play" button to be pressed
        waitForStart();

        //This sets the motor to half power
        motor.setPower(0.5);

        //This try catch will attempt to wait 1 second but will instead do nothing if interupted
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //This will stop the motor
        motor.setPower(0);
    }
}
