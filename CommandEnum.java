
/**
 * This is an enum class that will store the different commands that will be used in the game.
 *
 * @author William Jacob Reilley
 * @version 2018
 */
public enum CommandEnum {
    /**
     * Back command.
     */
    BACK("back"),
    /**
     * Cross off command.
     */
    CROSS("cross"),
    /**
     * This is the drop command.
     */
    DROP("drop"),
    /**
     * Read command.
     */
    READ("read"),
    /**
     * Go command.
     */
    GO("go"),
    /**
     * Help command.
     */
    HELP("help"),
    /**
     * Inventory command.
     */
    INVENTORY("inventory"),
    /**
     * Leave command
     */
    LEAVE("leave"),
    /**
     * Look command.
     */
    LOOK("look"),
    /**
     * Take command.
     */
    TAKE("take"),
    /**
     * Quit command.
     */
    QUIT("quit");
    /**
     * This is a feild for storing what the user will enter.
     */
    private String commandName;
    
    /**
     * This is the constructor for the enums.
     * @param nameValue is a string for the name of the Command.
     */
    private CommandEnum(String nameValue){
        commandName = nameValue;
    }
    
    /**
     * This is an accessor for the name of the enum.
     * 
     * @return a streing of the name.
     */
    public String getName() {
        return commandName;
    }
}
