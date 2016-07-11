/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mars;

import br.com.mars.controller.RoverController;
import br.com.mars.model.Rover;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class Mars {
    
    private static RoverController roverController;
    private static Scanner input;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int option;
        Rover rover1, rover2;
        input = new Scanner(System.in);
        roverController = new RoverController();
        
        System.out.println("Mars Rovers");
        
        do {
            System.out.println("1- Run an automated test");
            System.out.println("2- Launch rovers on a plateau on Mars");
            System.out.println("3- Exit");
            System.out.println("Choose an option (1-3): ");
            option = input.nextInt();
        } while (option < 1 || option > 3);
        
        if(option == 1) {
            String testData = "5 5"
                + "\n1 2 N"
                + "\nLMLMLMLMM"
                + "\n3 3 E"
                + "\nMMRMMRMRRM";
            System.setIn(new ByteArrayInputStream(testData.getBytes()));
            input = new Scanner(System.in);
        }
        else
            if(option == 3)
                System.exit(0);
        
        System.out.println("Enter the upper-right coordinates of the plateau: ");
        roverController.setPlateau_x(input.nextInt());
        roverController.setPlateau_y(input.nextInt());
        
        rover1 = deployRover();
        rover1 = setInstructions(rover1);
        
        rover2 = deployRover();
        rover2 = setInstructions(rover2);
        
        System.out.println(getRoverPosition(rover1) + "\n" + getRoverPosition(rover2));
    }
    
    private static Rover deployRover() {
        int position_x, position_y;
        char heading;
        
        System.out.println("Enter the rover's position: ");
        position_x = input.nextInt();
        position_y = input.nextInt();
        heading = Character.toUpperCase(input.next().charAt(0));
        
        return roverController.deployRover(position_x, position_y, heading);
    }
    
    private static Rover setInstructions(Rover rover) {
        char[] instructions;
        
        System.out.println("Enter the rover instructions: ");
        instructions = input.next().toCharArray();
        
        for(int i=0; i<instructions.length; i++) {
            switch(Character.toUpperCase(instructions[i])) {
                case 'M':
                    roverController.move(rover);
                    break;
                case 'R':
                    roverController.turnRight(rover);
                    break;
                case 'L':
                    roverController.turnLeft(rover);
                    break;
                default:
                    System.out.println("Houston, we've Had a Problem!");
                    System.exit(0);
                    break;
            }
        }
        
        return rover;
    }
    
    private static String getRoverPosition(Rover rover) {
        return roverController.getRoverPosition(rover);
    }
}