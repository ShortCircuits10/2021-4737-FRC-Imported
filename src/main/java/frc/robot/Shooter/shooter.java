/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import frc.robot.Shooter.commands.DisableShooter;

public class shooter extends SubsystemBase {
  /**
   * Creates a new shooter.
   */

  public WPI_TalonSRX shootermotor;

  public shooter() {
      shootermotor = new WPI_TalonSRX(RobotMap.SHOOTER_MOTOR);
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed (double speed) {
    shootermotor.set(speed);
  }

  public void initDefaultCommand () {
    setDefaultCommand(new DisableShooter());
  }
}
