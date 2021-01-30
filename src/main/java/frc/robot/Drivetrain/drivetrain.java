// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Drivetrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */

  public WPI_TalonSRX frontleftMotor;
  public WPI_TalonSRX frontrightMotor;
  public WPI_TalonSRX rightbackMotor;
  public WPI_TalonSRX leftbackMotor;

  public drivetrain() {

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
