package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

//This auto mode will keep looping through the "loop()" method after start or the "play" button is pressed
@Autonomous(name = "AutoDemo", group = "Auto")
public class Auto extends OpMode {

    //This declares the motor
    DcMotor motor;

    //Here is a flag to keep track of whether it has been run once
    boolean complete;

    @Override
    public void init() {
        //Obtains the motor
        motor = hardwareMap.get(DcMotor.class, "motor");

        //Sets the motor to break when no power
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Sets the value of completion to false
        complete = false;
    }

    @Override
    public void loop() {
        //Checks if task has been executed once
        if (!complete) {
            //Sets motor to half power
            motor.setPower(0.5);

            //Attempts to wait 1 second but will do nothing if interrupted
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Stops the motor
            motor.setPower(0);

            //Sets the value of compete to true so this segment will no longer run
            complete = true;
        }
    }
}
