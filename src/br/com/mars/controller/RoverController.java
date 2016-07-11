/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mars.controller;

import br.com.mars.model.Rover;

/**
 * Controlador responsavel por aplicar as regras de negocio e gerenciar/alimentar o objeto do tipo Rover
 * @author pablo
 */
public class RoverController {
    // Variaveis privadas de controle do tamanho da matriz (plateau on Mars)
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
    
    // Metodo para alterar a orientacao do Rover para a esquerda de acordo com sua orientacao atual
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
    
    // Metodo para alterar a orientacao do Rover para a direita de acordo com sua orientacao atual
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
    
    // Metodo para mover o Rover 1 posicao a partir de sua posicao atual e considerando sua orientacao
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
        
        // Verifica se a nova posicao do Rover esta dentro dos limites da matriz (plateau on Mars), se nao finaliza o programa
        if(rover.getPosition_x() > plateau_x || rover.getPosition_y() > plateau_y || rover.getPosition_x() < 0 || rover.getPosition_y() < 0) {
            System.out.println("Mission failed! The rover is out of the plateu (" + rover.getPosition() + "), we lost contact!");
            System.exit(0);
        }
    }
    
    // Metodo para instanciar um novo objeto do tipo Rover e definir sua posicao e orientacao na matriz (plateau on Mars)
    public Rover deployRover(int position_x, int position_y, char heading) {
        // Verifica se a posicao informada pelo usuario esta dentro dos limites da matriz (plateau on Mars), se nao finaliza o programa
        if(position_x > plateau_x || position_y > plateau_y) {
            System.out.println("Mission aborted! The rover was deployed out of the plateu on Mars and was destroyed.");
            System.exit(0);
        }
        
        // Vericia se a orientacao informada e uma das quatro aceitas pelo programa, se nao finaliza o programa
        if(heading != 'N' && heading != 'S' && heading != 'W' && heading != 'E') {
            System.out.println("Mission aborted! Unknown cardinal compass.");
            System.exit(0);
        }
        
        return new Rover(position_x, position_y, heading);
    }
    
    // Metodo para retornar a posicao e orientacao atual do rover passado como parametro
    public String getRoverPosition(Rover rover) {
        return rover.getPosition();
    }
}
