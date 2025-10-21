class CommandWords {
    // A constant array that holds all valid command words
    private static final String[] validCommands = { "go", "quit", "help", "look" };

    /**
     * Constructor - initializes the command words.
     * Currently does nothing.
     */
    public CommandWords() {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word.
     * Return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString) {
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].equals(aString)) {
                return true;
            }
        }
        // If we get here, the string was not found in the valid commands
        return false;
    }
}
