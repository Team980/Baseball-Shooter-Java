package com.team980.baseballshooter;

public class Parameters {
	
	// --- DRIVE SYSTEM ---
	public static int leftDriveMotorChannel = 0;
	public static int rightDriveMotorChannel = 1;
	
	public static double leftMotorMultiplier = 1.0; //TODO determine these values
	public static double rightMotorMultiplier = 1.0; //TODO based on encoder tuning
	
	// --- AUTONOMOUS ---
	public static double autoDistance = 15.0; //feet
	public static double autoSpeed = 1.0;
	
	// --- RELAYS ---
	public static int winchRelayChannel = 0;
	public static int actuatorRelayChannel = 1;
	
	// --- ENCODERS --- 
	public static int leftDriveEncA = 0;
	public static int leftDriveEncB = 1;
	public static boolean leftDriveEncInv = false; //TODO
	
	public static int rightDriveEncA = 2;
	public static int rightDriveEncB = 3;
	public static boolean rightDriveEncInv = false; //TODO
	
	public static int driveEncoderCounts = -1; //TODO
	
	// --- TIMINGS ---\
	public static double actuatorStopTime = 1.5;

	// --- JOYSTICKS / DRIVER INPUTS ---
	public static int driveJsChannel = 0;
	
	public static int driveJsWinchPullButton = 3;
	public static int driveJsWinchReleaseButton = 4;
	
	public static int driveJsTriggerButton = 1;
	public static int driveJsFailsafeButton = 9;
	public static int driveJsRetractButton = 2;
	public static int driveJsEStopButton = 5; //for testing
}
