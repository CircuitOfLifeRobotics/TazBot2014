package com.team3925.tazbot;


import edu.wpi.first.wpilibj.IterativeRobot;

public class TazBot extends IterativeRobot {
    
    private XboxController xbox;
    private Module drive, tilt, launcher;
    
    public void robotInit() {
        xbox = new XboxController(1);
        drive = new Drive(xbox);
        tilt = new Tilt(xbox);
        launcher = new Launcher(xbox);
    }

    public void teleopInit() {
        drive.init();
        tilt.init();
        launcher.init();
    }
    
    public void teleopPeriodic() {
        drive.update();
        tilt.update();
        launcher.update();
    }
    
    public void disabledInit() {
        drive.disable();
        tilt.disable();
        launcher.disable();
    }
    
}
