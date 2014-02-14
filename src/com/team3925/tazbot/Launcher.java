package com.team3925.tazbot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;

public class Launcher implements Module {

    private final Relay tailspike;
    private final DigitalInput tailbtn;
    private final Victor motora, motorb;
    private final Joystick stick;
    
    private final byte IDLE = 0, WAITOFF = 1, WAITON = 2;
    private byte state = 0;
    
    public Launcher(Joystick stick) {
        this.stick = stick;
        this.tailspike = new Relay(Config.TURTLE_SPIKE);
        this.tailbtn = new DigitalInput(Config.TURTLE_SWITCH);
        this.motora = new Victor(Config.LAUNCH_JAG_A);
        this.motorb = new Victor(Config.LAUNCH_JAG_B);
    }
    
    public void init() {
        state = IDLE;
    }
    
    public void update() {
        
        if (stick.getRawAxis(Config.SPIN_AXIS) < -.5) {
            motora.set(-1);
            motorb.set(-1);
        } else {
            motora.set(0);
            motorb.set(0);
        }
        
        switch (state) {
            case IDLE:
                tailspike.set(Relay.Value.kOff);
                if (stick.getRawButton(Config.TURTLE_BTN)) {
                    nextState();
                }
                break;
                
            case WAITOFF:
                tailspike.set(Relay.Value.kForward);
                if (!tailbtn.get()) {
                    nextState();
                }
                break;
                
            case WAITON:
                tailspike.set(Relay.Value.kForward);
                if (tailbtn.get()) {
                    nextState();
                }
                break;
                
            default:
                state = IDLE;
        }
    }
    
    private void nextState() {
        state += 1;
        state %= 3;
    }
    
    public void disable() {
        
    }
    
}
