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
 * Classe principal responsavel pela interface do usuario
 * @author pablo
 */
public class Mars {
    
    // Variaveis utilizadas em todos os metodos desta classe, uma para acessar o controlador e outra para coletar as informacoes digitadas pelo usuario
    private static RoverController roverController;
    private static Scanner input;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Variavel para armazenar a opcao do menu escolhida pelo usuario
        int option;
        // Variaveis para armazenar os objetos Rovers
        Rover rover1, rover2;
        // Instanciando a variavel para coletar as entradas do usuario
        input = new Scanner(System.in);
        // Instanciando a variavel do controlador
        roverController = new RoverController();
        
        System.out.println("Mars Rovers");
        
        // Gerando o menu e repetindo as opcoes ate que o usuario escolha uma opcao valida
        do {
            System.out.println("1- Run an automated test");
            System.out.println("2- Launch rovers on a plateau on Mars");
            System.out.println("3- Exit");
            System.out.println("Choose an option (1-3): ");
            option = input.nextInt();
        } while (option < 1 || option > 3);
        
        // Insere as entradas automaticamente para teste automatizado
        if(option == 1) {
            String testData = "5 5"
                + "\n1 2 N"
                + "\nLMLMLMLMM"
                + "\n3 3 E"
                + "\nMMRMMRMRRM";
            System.setIn(new ByteArrayInputStream(testData.getBytes()));
            input = new Scanner(System.in);
        }
        // Finaliza o programa, caso tenha sido a opcao escolhida pelo usuario
        else
            if(option == 3)
                System.exit(0);
        
        // Solicita ao usuario as informacoes do tamanho da matriz (plateau on Mars)
        System.out.println("Enter the upper-right coordinates of the plateau: ");
        roverController.setPlateau_x(input.nextInt());
        roverController.setPlateau_y(input.nextInt());
        
        // Chama o metodo para obter as informacoes de lancamento do Rover
        rover1 = deployRover();
        // Chama o metodo para obter as instrucoes de exploracao do Rover
        rover1 = setInstructions(rover1);
        
        rover2 = deployRover();
        rover2 = setInstructions(rover2);
        
        // Exibi a posicao e orientacao final de ambos Rovers
        System.out.println(getRoverPosition(rover1) + "\n" + getRoverPosition(rover2));
    }
    
    // Metodo criado para otimizacao e reutilizacao de codigo. Este metodo solicita e recebe do usuario a posicao e orientacao do Rover
    private static Rover deployRover() {
        int position_x, position_y;
        char heading;
        
        System.out.println("Enter the rover's position: ");
        position_x = input.nextInt();
        position_y = input.nextInt();
        heading = Character.toUpperCase(input.next().charAt(0));
        
        return roverController.deployRover(position_x, position_y, heading);
    }
    
    // Metodo criado para otimizacao e reutilizacao de codigo. Este metodo solicita e recebe do usuario as instrucoes para exploracao do Rover
    private static Rover setInstructions(Rover rover) {
        char[] instructions;
        
        System.out.println("Enter the rover instructions: ");
        instructions = input.next().toCharArray();
        
        // For para ler cada caracter e executar o comando que este representa
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
                // caso o usuario entre um caracter que nao representa um comando o programa e finalizado
                default:
                    System.out.println("Houston, we've Had a Problem!");
                    System.exit(0);
                    break;
            }
        }
        
        return rover;
    }
    
    // Metodo criado para otimizacao e reutilizacao de codigo. Este metodo retorna uma String com a posicao e orientacao atual do Rover
    private static String getRoverPosition(Rover rover) {
        return roverController.getRoverPosition(rover);
    }
}