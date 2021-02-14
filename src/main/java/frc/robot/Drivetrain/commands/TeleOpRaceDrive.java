/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drivetrain.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.Drivetrain.drivetrain;
import frc.libs.JerkLimitedTalonSRXController;

public class TeleOpRaceDrive extends CommandBase {
  /**
   * Creates a new TeleOpRaceDrive.
   */
  public TeleOpRaceDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.DRIVETRAIN);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Robot.DRIVETRAIN.setBrakeMode();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
		boolean slow = Robot.OI.driver.getButton("LB").get();
		boolean slowAccel = Robot.OI.driver.getButton("RB").get();
		boolean disableAccel = Robot.OI.driver.getButton("A").get();
		if (slowAccel) {
			Robot.DRIVETRAIN.setAccelerationLimit(RobotMap.DRIVE_MAX_ACCEL_SLOW);
		} else {
			Robot.DRIVETRAIN.setAccelerationLimit(RobotMap.DRIVE_MAX_ACCEL);
		}
		if (disableAccel) {
			Robot.DRIVETRAIN.setAccelerationLimit(RobotMap.DRIVE_MAX_SCALE);
		}

		double throttle = (Robot.OI.driver.getAxis("RT").get() - Robot.OI.driver.getAxis("LT").get())

				* (slow ? RobotMap.DRIVE_SLOW_SCALE : 1);

		double steer = Robot.OI.driver.getThumbstick("LS").X.get() * (slow ? RobotMap.DRIVE_SLOW_SCALE : 1);
    
		

		//Robot.DRIVETRAIN.arcadeDrive(throttle, steer);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
