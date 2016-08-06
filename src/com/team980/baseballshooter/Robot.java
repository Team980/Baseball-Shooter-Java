
package com.team980.baseballshooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Robot extends IterativeRobot {
	
	private RobotDrive robotDrive;
	private Joystick driveStick;

	
	public Robot() {
		robotDrive = new RobotDrive(Parameters.leftSideMotorChannel, Parameters.rightSideMotorChannel);
		driveStick = new Joystick(Parameters.driveJsChannel);
	}
		
    public void robotInit() {
    	
    }
    
    public void autonomousInit() {
    
    }

    public void autonomousPeriodic() {
    
    }

    public void teleopPeriodic() {
    	
    	if (driveStick.getRawButton(Parameters.jsTriggerButton) && driveStick.getRawButton(Parameters.jsFailsafeButton)) {
    		//Fire the cannon!
    	}
    	
        robotDrive.arcadeDrive(driveStick, Joystick.AxisType.kY.value, driveStick, Joystick.AxisType.kZ.value);
    }
    
    public void testPeriodic() {
    
    }
    
}
