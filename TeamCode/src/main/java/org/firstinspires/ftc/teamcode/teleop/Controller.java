package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "ControllerDemo", group = "TeleOp")
public class Controller extends OpMode {

    //Defines the motor
    DcMotor motor;

    //This code is run once when the "init" is pressed
    @Override
    public void init() {
        //This part obtains the motor
        motor = hardwareMap.get(DcMotor.class, "motor");

        //Sets the motor to break when there is no power
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    //This code will be run over and over again and will serve as the main logic
    @Override
    public void loop() {
        //Sets the power of the motor to how far the right trigger is pressed
        motor.setPower(gamepad1.right_trigger);

        //Here I will display the motor power to the screen
        telemetry.addData("Motor Speed: ", gamepad1.right_trigger);
    }
}
