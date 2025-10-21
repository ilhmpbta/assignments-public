import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text-based adventure game.
 * This parser reads user input and tries to interpret it as an "Adventure" command.
 * Every time it is called, it reads a line from the terminal and tries to interpret the line as a two-word command.
 * It returns the command as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */
class Parser {
    private CommandWords commands; // Holds all valid command words

    public Parser() {
        commands = new CommandWords(); // Initialize command words
    }

    /**
     * This method reads a line of input, tokenizes it, and tries to interpret it as a command.
     * It returns a Command object representing the parsed command.
     */
    public Command getCommand() {
        String inputLine = "";  // Will hold the full input line
        String word1 = null;
        String word2 = null;

        System.out.print("> "); // Print prompt

        // Create BufferedReader to read from the console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine(); // Read user input
        } catch (java.io.IOException exc) {
            System.out.println("There was an error during reading: " + exc.getMessage());
        }

        // Tokenize the input line into words
        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        // If there's a first word, store it in word1
        if (tokenizer.hasMoreTokens()) {
            word1 = tokenizer.nextToken();
        }

        // If there's a second word, store it in word2
        if (tokenizer.hasMoreTokens()) {
            word2 = tokenizer.nextToken();
        }

        // Create the Command object based on whether the command word is valid
        if (commands.isCommand(word1)) {
            return new Command(word1, word2); // Valid command
        } else {
            return new Command(null, word2); // Invalid command (unknown command)
        }
    }
}
