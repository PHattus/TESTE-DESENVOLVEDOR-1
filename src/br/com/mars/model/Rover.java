/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mars.model;

/**
 *
 * @author pablo
 */
public class Rover {
    private int position_x;
    private int position_y;
    private char heading;

    public Rover(int position_x, int position_y, char heading) {
        this.position_x = position_x;
        this.position_y = position_y;
        this.heading = heading;
    }
    
    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public char getHeading() {
        return heading;
    }

    public void setHeading(char heading) {
        this.heading = heading;
    }

    @Override
    public String toString() {
        return "Rover{" + "position_x=" + position_x + ", position_y=" + position_y + ", heading=" + heading + '}';
    }
    
    public String getPosition() {
        return position_x + " " + position_y + " " + heading;
    }
}
