package com.team3925.tazbot;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;

public class Tilt implements Module {

    private final Relay tiltspike;
    private final AnalogChannel tiltpot;
    private final Joystick stick;
    
    public Tilt(Joystick stick) {
        this.stick = stick;
        this.tiltspike = new Relay(Config.TILT_SPIKE);
        this.tiltpot = new AnalogChannel(Config.TILT_POT);
    }
    
    public void init() {
        
    }
    
    public void update() {
        boolean up = stick.getRawButton(Config.TILT_UP_BTN);
        boolean down = stick.getRawButton(Config.TILT_DOWN_BTN);
        
        if (up != down) {
            if (up) {
                tiltspike.set(Relay.Value.kForward);
            } else {
                tiltspike.set(Relay.Value.kReverse);
            }
        } else {
            tiltspike.set(Relay.Value.kOff);
        }
    }
    
    public void disable() {
        
    }

}
