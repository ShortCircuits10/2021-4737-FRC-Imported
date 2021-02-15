// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.Intake.commands.DisableIntake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.Solenoid;


public class IntakeSub extends SubsystemBase {
  /** Creates a new IntakeSub. */
  public DoubleSolenoid leftintakesSolenoid;
  public static WPI_TalonSRX intakemotor;
  //public SingleSolenoid leftintakesSolenoid;

  public IntakeSub() {
    leftintakesSolenoid = new DoubleSolenoid(RobotMap.INTAKESOLENOID_FOWARDCHANNEL, RobotMap.INTAKESOLENOID_REVERSECHANNEL);
    intakemotor = new WPI_TalonSRX(RobotMap.INTAKE_MOTOR);
  }

  public void setSpeed(double speed){
  
  }

  public void extendleft() {
    leftintakesSolenoid.set(Value.kForward);
  }

  public void retractleft(){
    leftintakesSolenoid.set(Value.kReverse);
  }

  public void disablePneumatics(){
    leftintakesSolenoid.set(Value.kOff);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void initDefaultCommand(){
    setDefaultCommand(new DisableIntake());
  }
}
