import java.util.HashMap;
import java.util.Set;

/**
 * This class is part of the "Campus of Kings" application. "Campus of Kings" is a
 * very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game. It is
 * used to recognize commands as they are typed in.
 * 
 * @author Maria Jump
 * @version 2015.02.01
 */

public class CommandWords {
    /** A constant array that holds all valid command words. */
    private static HashMap<String, CommandEnum> validCommands;

    /**
     * Static block to initialize the fields of CommandWords.
     */
    static {
        validCommands = new HashMap<String, CommandEnum>(); 
        for (CommandEnum command : CommandEnum.values()) {
            validCommands.put(command.getName(), command);
        }
    }

    /**
     * Check whether a given String is a valid command word.
     * 
     * @param aString The string to determine whether it is a valid command.
     * @return true if a given string is a valid command, false if it isn't.
     */
    public static boolean isCommand(String aString) {
        boolean valid = false;

        if (validCommands.containsKey(aString)) {
            valid = true;
        }
        
        // if we get here, the string was not found in the commands
        return valid;
    }

    /**
     * Returns a list of the availible commands, of the forms;
     *       Your command words are:
     *            look go quit help
     *            
     *@return A string containing the list of availble commands.
     */
    public static String getCommandString() {
        String commandString = "";
        Set<String> commandKeys = validCommands.keySet();
        for (String command : commandKeys) {
            commandString += command + " ";
        }
        return commandString;
    }
    
    /**
     * Converts a String into and CommandEnum Object.
     * 
     * @param theString The String conatining the word.
     * @return The CommandEnum object representing the commamf, or null if the command does not exist.
     */
    public static CommandEnum getCommand(String theString) {
        CommandEnum theChoosenOne = null;
        if(CommandWords.isCommand(theString)) {
            theChoosenOne = validCommands.get(theString);
        }
        return theChoosenOne;
    }
}
