// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.Intake.commands.DisableIntake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


//import edu.wpi.first.wpilibj.Solenoid;


public class IntakeSub extends SubsystemBase {
  /** Creates a new IntakeSub. */
  

  public static WPI_TalonSRX intakemotor;
  public static WPI_TalonSRX ballintakemotor;
  public static WPI_TalonSRX elevatorintakemotor;


  public IntakeSub() {
  
    
    intakemotor = new WPI_TalonSRX(RobotMap.INTAKE_MOTOR);
    ballintakemotor = new WPI_TalonSRX(RobotMap.INTAKE_MOTOR2);
    elevatorintakemotor = new WPI_TalonSRX(RobotMap.INTAKE_MOTOR3);
  }

  public void setIntakeSpeed(double speed){
    intakemotor.set(speed);
    ballintakemotor.set(speed);
    elevatorintakemotor.set(speed);
  }

  public void setballintakemotorSpeed(double speed){

    ballintakemotor.set(speed);

  }

  public void setelevatorSpeed(double speed){

    elevatorintakemotor.set(speed);

  }




  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void initDefaultCommand(){
    setDefaultCommand(new DisableIntake());
  }
}
