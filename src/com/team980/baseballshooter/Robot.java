
package com.team980.baseballshooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;

public class Robot extends IterativeRobot {
	
	private RobotDrive robotDrive;
	private Joystick driveStick;
	
	private Relay solenoidRelay;

	
	public Robot() {
		robotDrive = new RobotDrive(Parameters.leftSideMotorChannel, Parameters.rightSideMotorChannel);
		driveStick = new Joystick(Parameters.driveJsChannel);
		
		solenoidRelay = new Relay(Parameters.solenoidRelayChannel);
	}
		
    public void robotInit() {
    	
    }
    
    public void autonomousInit() {
    
    }

    public void autonomousPeriodic() {
    
    }

    public void teleopPeriodic() {
    	
    	if (driveStick.getRawButton(Parameters.jsTriggerButton) && driveStick.getRawButton(Parameters.jsFailsafeButton)) {
    		solenoidRelay.set(Relay.Value.kForward); //FIRE THE SOLENOID
    	} else {
    		solenoidRelay.set(Relay.Value.kOff); //DON'T FIRE THE SOLENOID
    	}
    	
        //robotDrive.arcadeDrive(driveStick, Joystick.AxisType.kY.value, driveStick, Joystick.AxisType.kZ.value);
    }
    
    public void testPeriodic() {
    
    }
    
}
