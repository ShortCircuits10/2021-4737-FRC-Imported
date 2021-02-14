// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Drivetrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import frc.robot.Drivetrain.commands.DisableTeleOpDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.libs.JerkLimitedTalonSRXController;


public class drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */

  public WPI_TalonSRX rightfrontmotor;
  public WPI_TalonSRX rightbackmotor;
  public WPI_TalonSRX leftfrontmotor;
  public WPI_TalonSRX leftbackmotor;
  public DifferentialDrive drive;

  
  private JerkLimitedTalonSRXController lSmoothDrive;
  private JerkLimitedTalonSRXController rSmoothDrive;
  private DifferentialDrive smoothDrive;

  public drivetrain() {
    rightfrontmotor = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_MOTOR);
    rightbackmotor = new WPI_TalonSRX(RobotMap.RIGHT_BACK_MOTOR);
    leftfrontmotor = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MOTOR);
    leftbackmotor = new WPI_TalonSRX(RobotMap.LEFT_BACK_MOTOR);

    drive = new DifferentialDrive(rightbackmotor, rightfrontmotor);


    smoothDrive = new DifferentialDrive(
      lSmoothDrive = new JerkLimitedTalonSRXController(leftfrontmotor, RobotMap.DRIVE_MAX_VEL, RobotMap.DRIVE_MAX_ACCEL, RobotMap.DRIVE_MAX_JERK),
      rSmoothDrive = new JerkLimitedTalonSRXController(rightfrontmotor, RobotMap.DRIVE_MAX_VEL, RobotMap.DRIVE_MAX_ACCEL, RobotMap.DRIVE_MAX_JERK));
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void arcadeDrive(double throttle, double steer){
    drive.arcadeDrive(throttle, steer);
  }

  public void setAccelerationLimit(double accelLimit) {
    lSmoothDrive.setMaxAccel(accelLimit);
    rSmoothDrive.setMaxAccel(accelLimit);
  }

  public void setBrakeMode() {
		leftfrontmotor.setNeutralMode(NeutralMode.Brake);
		leftbackmotor.setNeutralMode(NeutralMode.Brake);
		rightfrontmotor.setNeutralMode(NeutralMode.Brake);
		rightbackmotor.setNeutralMode(NeutralMode.Brake);
  }

  public void initDefaultCommand() {
    // When the robot is initialized, this command will automatically run
    setDefaultCommand(new DisableTeleOpDrive());
  }
}
