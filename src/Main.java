import io.InputCommand;
import io.InputParser;
import services.InputCommandProcessor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Simple Expense Sharing app.!");
        while (true) {

            String inputString = scanner.nextLine();
            if(inputString.equals("EXIT"))  break;
            InputCommand inputCommand = InputParser.parseInput(inputString);
            InputCommandProcessor inputCommandProcessor = new InputCommandProcessor();
            String message = inputCommandProcessor.processInputCommand(inputCommand);
            System.out.println(message);
            System.out.println("Next Selection");
        }
        System.out.println("Thank You!");
    }
}