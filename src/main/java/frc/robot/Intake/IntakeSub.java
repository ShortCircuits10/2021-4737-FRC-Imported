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
 // public DoubleSolenoid rightintakeSolenoid;

  public static WPI_TalonSRX intakemotor;
 // public static WPI_TalonSRX intakemotor2;


  public IntakeSub() {
    leftintakesSolenoid = new DoubleSolenoid(RobotMap.INTAKESOLENOID_FOWARDCHANNEL, RobotMap.INTAKESOLENOID_REVERSECHANNEL);
    //rightintakeSolenoid = new DoubleSolenoid(RobotMap.BOTTOMSOLENOID_FORWARDCHANNEL, RobotMap.BOTTOMSOLENOID_REVERSECHANNEL);
    
    intakemotor = new WPI_TalonSRX(RobotMap.INTAKE_MOTOR);
   // intakemotor2 = new WPI_TalonSRX(RobotMap.INTAKE_MOTOR2);
  }

  public void setSpeed(double speed){
    intakemotor.set(speed);
    //intakemotor2.set(speed);
  }

  public void extend() {
    leftintakesSolenoid.set(Value.kForward);
    //rightintakeSolenoid.set(Value.kForward);
  }

  public void retract(){
    leftintakesSolenoid.set(Value.kReverse);
    //rightintakeSolenoid.set(Value.kReverse);
  }

  public void disablePneumatics(){
    leftintakesSolenoid.set(Value.kOff);
    //rightintakeSolenoid.set(Value.kOff);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void initDefaultCommand(){
    setDefaultCommand(new DisableIntake());
  }
}
