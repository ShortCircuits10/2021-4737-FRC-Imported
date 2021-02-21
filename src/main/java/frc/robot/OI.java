/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import frc.libs.Gamepad;
import frc.libs.XboxController;

import frc.robot.Intake.commands.ReverseIntake;
import frc.robot.Intake.commands.TeleOpBallIntake;
import frc.robot.Intake.commands.TeleOpIntake;
import edu.wpi.first.wpilibj2.command.button.Trigger;
//import frc.robot.Intake.IntakeSub;
import frc.robot.Intake.commands.TeleOpElevator;
import frc.robot.Intake.commands.ReverseBallIntake;
import frc.robot.Intake.commands.ReverseElevator;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // public Joystick stick = new Joystick(0);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  public XboxController driver;
  public XboxController operator;
  public OI(){
    driver = new XboxController(0);
    operator = new XboxController(2);


    operator.A.whileHeld(new ReverseBallIntake());
    operator.Y.whileHeld(new ReverseIntake());
    operator.X.whileHeld(new ReverseElevator());
   
    new Trigger() {
      public boolean get() {
        if (Robot.INTAKE == null)
          return false;
        return (operator.RT.get() != 0 || operator.LT.get() != 0);
      }
    }.whenActive(new TeleOpIntake());

    new Trigger() {
      public boolean get() {
        if (Robot.INTAKE == null)
          return false;
        return (operator.LS.X.get() != 0);
      }
    }.whenActive(new TeleOpBallIntake());

    new Trigger() {
      public boolean get() {
        if (Robot.INTAKE == null)
          return false;
        return (operator.RS.X.get() != 0);
      }
    }.whenActive(new TeleOpElevator());




  }

}
  

