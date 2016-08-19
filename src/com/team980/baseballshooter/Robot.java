
package com.team980.baseballshooter;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	private RobotDrive robotDrive;
	
	private Joystick driveStick;
	
	private Relay solenoidRelay;
	
	private Spark winchMotorController;
	
	private Encoder leftDriveEnc;
	private Encoder rightDriveEnc;
	
	public Robot() {
		robotDrive = new RobotDrive(Parameters.leftDriveMotorChannel, Parameters.rightDriveMotorChannel);
		
		driveStick = new Joystick(Parameters.driveJsChannel);
		
		solenoidRelay = new Relay(Parameters.solenoidRelayChannel);
		
		winchMotorController = new Spark(Parameters.winchMotorController);
		
		leftDriveEnc = new Encoder(Parameters.leftDriveEncA, Parameters.leftDriveEncB);
		//leftDriveEnc.setDistancePerPulse(2*Constants.pi*(Constants.wheelRadius/Constants.inchesInFeet)/Parameters.driveEncoderCounts); TODO figure out the calculations for this
		//leftDriveEnc.setReverseDirection(Parameters.leftDriveEncInv);
		rightDriveEnc = new Encoder(Parameters.rightDriveEncA, Parameters.rightDriveEncB);
		//rightDriveEnc.setDistancePerPulse(2*Constants.pi*(Constants.wheelRadius/Constants.inchesInFeet)/Parameters.driveEncoderCounts); TODO crunch the numbers
		//rightDriveEnc.setReverseDirection(Parameters.rightDriveEncInv);
	}
		
    public void robotInit() {
    	leftDriveEnc.reset();
    	rightDriveEnc.reset();
    }
    
    public void autonomousInit() {
    
    }

    public void autonomousPeriodic() {
    	
    	double currentDistLeft = leftDriveEnc.getDistance();
    	double currentDistRight = rightDriveEnc.getDistance();
    	
    	if (currentDistLeft > Parameters.autoDistance &&
    			currentDistRight > Parameters.autoDistance) {
    		robotDrive.setLeftRightMotorOutputs(0, 0); //stops the robot
    	} else {
    		robotDrive.setLeftRightMotorOutputs(Parameters.leftMotorMultiplier * Parameters.autoSpeed, 
    				Parameters.rightMotorMultiplier * Parameters.autoSpeed);
    	}
    	
    	SmartDashboard.putNumber("Current Distance - Left", currentDistLeft);
    	SmartDashboard.putNumber("Current Distance - Right", currentDistRight);
    }

    public void teleopPeriodic() {
    	
    	if (driveStick.getRawButton(Parameters.driveJsWinchPullButton)) {
    		//Pull the winch
    		winchMotorController.set(-1.0);
    	} else if (driveStick.getRawButton(Parameters.driveJsWinchReleaseButton)) {
    		//Release the winch
    		winchMotorController.set(1.0);
    	} else {
    		//Do nothing with the winch
    		winchMotorController.set(0.0);
    	}
    	
    	if (driveStick.getRawButton(Parameters.driveJsTriggerButton) && driveStick.getRawButton(Parameters.driveJsFailsafeButton)) {
    		//Fire the baseball!
    		solenoidRelay.set(Relay.Value.kForward);
    	} else {
    		//Don't fire
    		solenoidRelay.set(Relay.Value.kOff);
    	}
    	
        robotDrive.arcadeDrive(driveStick, Joystick.AxisType.kY.value, driveStick, Joystick.AxisType.kZ.value);
    }
    
    public void testPeriodic() {
    
    }
    
}
