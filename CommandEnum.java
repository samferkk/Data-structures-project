
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
     * Drop command.
     */
    DROP("drop"),
    /**
     * Examine comand.
     */
    EXAMINE("examine"),
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
     * Lock command.
     */
    LOCK("lock"),
    /**
     * Look command.
     */
    LOOK("look"),
    /**
     * Pack command.
     */
    PACK("pack"),
    /**
     * Status command.
     */
    STATUS("status"),
    /**
     * The Score command.
     */
    SCORE("score"),
    /**
     * Take command.
     */
    TAKE("take"),
    /**
     * The Turns command.
     */
    TURNS("turns"),
    /**
     * Unlock command.
     */
    UNLOCK("unlock"),
    /**
     * Unpack command.
     */
    UNPACK("unpack"),
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
