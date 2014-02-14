package com.team3925.tazbot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Drive implements Module {

    private final RobotDrive drive;
    private final Joystick stick;
    
    public Drive(Joystick stick) {
        this.stick = stick;
        this.drive = new RobotDrive(Config.LEFT_JAG_A, Config.LEFT_JAG_B,
                Config.RIGHT_JAG_A, Config.RIGHT_JAG_B);
    }
    
    public void init() {
        
    }
    
    public void update() {
        drive.arcadeDrive(stick.getRawAxis(Config.FWD_AXIS), stick.getRawAxis(Config.TURN_AXIS));
    }
    
    public void disable() {
        
    }
    
}
