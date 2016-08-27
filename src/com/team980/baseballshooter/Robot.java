
package com.team980.baseballshooter;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	private RobotDrive robotDrive;
	
	private Joystick driveStick;
	
	private Relay winchRelay;
	private Relay solenoidRelay;
	
	//private Encoder leftDriveEnc;
	//private Encoder rightDriveEnc;
	
	public Robot() {
		robotDrive = new RobotDrive(Parameters.leftDriveMotorChannel, Parameters.rightDriveMotorChannel);
		
		driveStick = new Joystick(Parameters.driveJsChannel);
		
		winchRelay = new Relay(Parameters.winchRelayChannel);
		solenoidRelay = new Relay(Parameters.solenoidRelayChannel);
		
		//leftDriveEnc = new Encoder(Parameters.leftDriveEncA, Parameters.leftDriveEncB);
		//leftDriveEnc.setDistancePerPulse(2*Constants.pi*(Constants.wheelRadius/Constants.inchesInFeet)/Parameters.driveEncoderCounts); TODO figure out the calculations for this
		//leftDriveEnc.setReverseDirection(Parameters.leftDriveEncInv);
		//rightDriveEnc = new Encoder(Parameters.rightDriveEncA, Parameters.rightDriveEncB);
		//rightDriveEnc.setDistancePerPulse(2*Constants.pi*(Constants.wheelRadius/Constants.inchesInFeet)/Parameters.driveEncoderCounts); TODO crunch the numbers
		//rightDriveEnc.setReverseDirection(Parameters.rightDriveEncInv);
	}
		
    public void robotInit() {
    	//leftDriveEnc.reset();
    	//rightDriveEnc.reset();
    }
    
    public void autonomousInit() {
    
    }

    public void autonomousPeriodic() {
    	
    	/*double currentDistLeft = leftDriveEnc.getDistance();
    	double currentDistRight = rightDriveEnc.getDistance();
    	
    	if (currentDistLeft > Parameters.autoDistance &&
    			currentDistRight > Parameters.autoDistance) {
    		robotDrive.setLeftRightMotorOutputs(0, 0); //stops the robot
    	} else {
    		robotDrive.setLeftRightMotorOutputs(Parameters.leftMotorMultiplier * Parameters.autoSpeed, 
    				Parameters.rightMotorMultiplier * Parameters.autoSpeed);
    	}
    	
    	SmartDashboard.putNumber("Current Distance - Left", currentDistLeft);
    	SmartDashboard.putNumber("Current Distance - Right", currentDistRight);*/
    }

    public void teleopPeriodic() {
    	
    	if (driveStick.getRawButton(Parameters.driveJsWinchPullButton)) {
    		//Pull the winch
    		winchRelay.set(Relay.Value.kForward);
    		//System.out.println("Relay FORWARD");
    	} else if (driveStick.getRawButton(Parameters.driveJsWinchReleaseButton)) {
    		//Release the winch
    		winchRelay.set(Relay.Value.kReverse);
    		//System.out.println("Relay REVERSE");
    	} else {
    		//Do nothing with the winch
    		winchRelay.set(Relay.Value.kOff);
    	}
    	
    	if (driveStick.getRawButton(Parameters.driveJsTriggerButton) && driveStick.getRawButton(Parameters.driveJsFailsafeButton)) {
    		//Fire the baseball!
    		solenoidRelay.set(Relay.Value.kForward);
    		//System.out.println("FIRE THE CANNON");
    	} else {
    		//Don't fire
    		solenoidRelay.set(Relay.Value.kOff);
    	}
    	
        robotDrive.arcadeDrive(driveStick, Joystick.AxisType.kY.value, driveStick, Joystick.AxisType.kZ.value);
    }
    
    public void testPeriodic() {
    
    }
    
}
