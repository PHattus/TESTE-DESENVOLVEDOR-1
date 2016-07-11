/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mars.controller;

import br.com.mars.model.Rover;

/**
 *
 * @author pablo
 */
public class RoverController {
    private int plateau_x, plateau_y;

    public int getPlateau_x() {
        return plateau_x;
    }

    public void setPlateau_x(int plateau_x) {
        this.plateau_x = plateau_x;
    }

    public int getPlateau_y() {
        return plateau_y;
    }

    public void setPlateau_y(int plateau_y) {
        this.plateau_y = plateau_y;
    }
    
    public void turnLeft(Rover rover) {
        switch(rover.getHeading()) {
            case 'N':
                rover.setHeading('W');
                break;
            case 'S':
                rover.setHeading('E');
                break;
            case 'W':
                rover.setHeading('S');
                break;
            case 'E':
                rover.setHeading('N');
                break;
        }
    }
    
    public void turnRight(Rover rover) {
        switch(rover.getHeading()) {
            case 'N':
                rover.setHeading('E');
                break;
            case 'S':
                rover.setHeading('W');
                break;
            case 'W':
                rover.setHeading('N');
                break;
            case 'E':
                rover.setHeading('S');
                break;
        }
    }
    
    public void move(Rover rover) {
        switch(rover.getHeading()) {
            case 'N':
                rover.setPosition_y(rover.getPosition_y() + 1);
                break;
            case 'S':
                rover.setPosition_y(rover.getPosition_y() - 1);
                break;
            case 'W':
                rover.setPosition_x(rover.getPosition_x() - 1);
                break;
            case 'E':
                rover.setPosition_x(rover.getPosition_x() + 1);
                break;
        }
        
        if(rover.getPosition_x() > plateau_x || rover.getPosition_y() > plateau_y || rover.getPosition_x() < 0 || rover.getPosition_y() < 0) {
            System.out.println("Mission failed! The rover is out of the plateu (" + rover.getPosition() + "), we lost contact!");
            System.exit(0);
        }
    }
    
    public Rover deployRover(int position_x, int position_y, char heading) {
        if(position_x > plateau_x || position_y > plateau_y) {
            System.out.println("Mission aborted! The rover was deployed out of the plateu on Mars and was destroyed.");
            System.exit(0);
        }
        
        if(heading != 'N' && heading != 'S' && heading != 'W' && heading != 'E') {
            System.out.println("Mission aborted! Unknown cardinal compass.");
            System.exit(0);
        }
        
        return new Rover(position_x, position_y, heading);
    }
    
    public String getRoverPosition(Rover rover) {
        return rover.getPosition();
    }
}
