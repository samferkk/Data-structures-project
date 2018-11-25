/**
 * This class is the main class of the "Campus of Kings" application.
 * "Campus of Kings" is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all. It should really be extended to make it more
 * interesting!
 * 
 * This game class creates and initializes all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 * 
 * @author Maria Jump, Jake Reilley
 * @version 2015.02.01
 */

public class Game {
    /** The world where the game takes place. */
    private World world;
    /** This is the counter for the score. */
    private int score;
    /** THis is the turn counter. */
    private int turns;
    /** This feild store the player being controlled. */
    private Player currentPlayer;

    /**
     * Create the game and initialize its internal map.
     */
    public Game() {
        world = new World();
        // set the starting room
        currentPlayer = new Player(world.getRoom("Tutorial Room 001"));
        score = 0;
        turns = 0;
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main game loop. Here we repeatedly read commands and
        // execute them until the game is over.
        boolean wantToQuit = false;
        while (!wantToQuit) {
            Command command = Reader.getCommand();
            wantToQuit = processCommand(command);
            turns++;
            // other stuff that needs to happen every turn can be added here.
        }
        Writer.println("You have earned " + score + " points in " + turns + " turns.");
        printGoodbye();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helper methods for processing the commands

    /**
     * Given a command, process (that is: execute) the command.
     * 
     * @param command
     *            The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            Writer.println("I don't know what you mean...");
        } else {
            CommandEnum commandEnum = command.getCommandWord(); 
            switch (commandEnum) {
                case BACK:
                goBack();
                break;

                case GO:
                goRoom(command);
                break;

                case HELP:
                help();
                break;

                case INVENTORY:
                inventory();
                break;

                case LOOK:
                look();
                break;

                case TAKE:
                take(command);
                break;

                case QUIT:
                wantToQuit = quit(command);
                break;

                default :
                Writer.println(command.toString() + " is not implemented yet!");
                break;
            }

        }
        return wantToQuit;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helper methods for implementing all of the commands.
    // It helps if you organize these in alphabetical order.

    /**
     * Method for handling the back command.
     */

    /**
     * This is the method for handling the back command.
     */
    private void goBack() {
        if(currentPlayer.getPreviousPlayerRoom() == null) {
            Writer.println("You can not go back!");
        }
        else {
            currentPlayer.setCurrentPlayerRoom(currentPlayer.getPreviousPlayerRoom());
            look();
        }
    }

    /**
     * This is the method for handling the drop method.
     * @param command is the command issued.
     */
    private void drop(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("Which Item?");
        }
        else {
            String item = command.getRestOfLine();
            Item testItem = currentPlayer.getItem(item);
            if (testItem == null) {
                Writer.println("You do not have this item.");
            }
            else {
                currentPlayer.getCurrentPlayerRoom().addItem(currentPlayer.removeItem(testItem.getName()));
                Writer.println("You dropped the item");
            }
        }
    }

    /**
     * This mehtod will handle examining items.
     * @param command is the command being issued.
     */
    private void examine(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("Which Item?");
        }
        else {
            String item = command.getRestOfLine();
            Item playerItem = currentPlayer.getItem(item);
            if (playerItem == null) {
                Item roomItem = currentPlayer.getCurrentPlayerRoom().getItem(item);
                if (roomItem == null) {
                    Writer.println("No such Item");
                }
                else{
                    Writer.println(roomItem.toString());
                }
            }
            else {
                Writer.println(playerItem.toString());
            }
        }
    }

    /**
     * Print out the closing message for the player.
     */
    private void printGoodbye() {
        Writer.println("I hope you weren't too bored here on the Campus of Kings!");
        Writer.println("Thank you for playing.  Good bye.");
    }

    /**
     * Try to go to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     * 
     * @param command
     *            The command to be processed.
     */
    private void goRoom(Command command) {
        Room currentRoom = currentPlayer.getCurrentPlayerRoom();
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            Writer.println("Go where?");
        } else {
            String direction = command.getRestOfLine();

            // Try to leave current.
            Door doorway = null;
            if (!direction.equals("")) {
                doorway = currentRoom.getExit(direction);
            }

            if (doorway == null) {
                Writer.println("There is no door!");
            } else {
                if(doorway.isLocked()) {
                    Writer.println("Door is locked");
                }
                else {
                    Room newRoom = doorway.getDestination();
                    currentPlayer.setCurrentPlayerRoom(newRoom);
                    score += currentPlayer.getCurrentPlayerRoom().getPoints();
                    printLocationInformation();
                    Writer.println();
                }
            }
        }
    }

    /**
     * This is the method for handling inventory.
     */
    private void inventory() {
        Writer.println(currentPlayer.getInventory());
    }

    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void help() {
        Writer.println("You are lost. You are alone. You wander");
        Writer.println("around at the university.");
        Writer.println();
        Writer.println("Your command words are:");
        Writer.println(CommandWords.getCommandString());
    }

    /**
     * Prints out the curent location and exits.
     */
    private void printLocationInformation() {
        Room currentRoom = currentPlayer.getCurrentPlayerRoom();
        Writer.println(currentRoom.toString());
    }

    /**
     * This method will be used to lock things.
     * @param command is the commadn beign processed.
     */
    private void lock(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("Lock what?");
        }
        else {
            String lockDirection = command.getRestOfLine();
            Door lockingDoor = currentPlayer.getCurrentPlayerRoom().getExit(lockDirection);
            if (lockingDoor == null) {
                Writer.println("No door");
            }
            else {
                if(lockingDoor.isLocked()) {
                    Writer.println("Door is already locked");
                }
                else if (lockingDoor.getKey() == null){
                    Writer.println("Door can not be locked");
                }
                else {
                    Writer.println("Which key?");
                    String lockingKey = Reader.getResponse();
                    Item playerKey = currentPlayer.getItem(lockingKey);
                    if (playerKey == null) {
                        Writer.println("You dont have the key.");
                    }
                    else {
                        if (!lockingKey.equals(lockingDoor.getKey())) {
                            Writer.println("Wrong Key");
                        }
                        else {
                            lockingDoor.setLocked(true);
                            Writer.println("You locked it");
                        }
                    }
                }
            }
        }
    }

    /**
     * Prints out the location information.
     */
    private void look(){
        this.printLocationInformation();
    }

    /**
     * THis method will pack items into containers.
     * @param command is the command being processed.
     */
    private void pack(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("Pack what?");
        }
        else {
            String packingItemName = command.getRestOfLine();
            Item playerItem = currentPlayer.getItem(packingItemName);
            Item roomItem = currentPlayer.getCurrentPlayerRoom().getItem(packingItemName);
            if (playerItem == null && roomItem == null) {
                Writer.println("You don't have it");
            }
            else {
                Item theItem = null;
                if (playerItem == null) {
                    theItem = roomItem;
                }
                else {
                    theItem = playerItem;
                }
                if (theItem.getWeight() > currentPlayer.MAXIMUM_WEIGHT) {
                    Writer.println("Item is too heavy.");
                }
                else {
                    Writer.println("Which container?");
                    String containerName = Reader.getResponse();
                    Item playerContainer = currentPlayer.getItem(containerName);
                    Item roomContainer = currentPlayer.getCurrentPlayerRoom().getItem(containerName);
                    Container theContainer = null;
                    if (playerContainer == null) {
                        if(roomContainer instanceof Container) {
                            theContainer = (Container)roomContainer;
                        }
                        else {
                            Writer.print("That's not a container!");
                        }
                    }
                    else {
                        if (playerContainer instanceof Container) {
                            theContainer = (Container)playerContainer;
                        }
                        else {
                            Writer.println("That's not a container!");
                        }
                    }
                    if (theContainer != null) {
                        double remainingWeight = currentPlayer.getRemainingWeight();
                        if (theItem.getWeight() > remainingWeight) {
                            Writer.println("You are carrying too much already.");
                        }
                        else {
                            theContainer.addItem(theItem);
                            if (roomItem == null) {
                                 currentPlayer.removeItem(theItem.getName());
                            }
                            else {
                                currentPlayer.getCurrentPlayerRoom().removeItem(theItem.getName());
                            }
                            Writer.println("You packed it");
                        }
                    }
                }
            }
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     *
     * @param command
     *            The command to be processed.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        boolean wantToQuit = true;
        if (command.hasSecondWord()) {
            Writer.println("Quit what?");
            wantToQuit = false;
        }
        return wantToQuit;
    }

    /**
     * Prints out the current score of the player.
     */
    private void getScore() {
        Writer.println("Current Score: " + score);
    }

    /**
     * This is the mehtod for handling the Status Command.
     * This will print out the players current turns,then score, then location.
     */
    private void getStatus() {
        getTurns();
        getScore();
        look();
    }

    /**
     * This method will handle taking and item.
     * @param command is the command being issued.
     */
    private void take(Command command) {
        if(!command.hasSecondWord()) {
            Writer.println("Take what?");
        }
        else {
            String item = command.getRestOfLine();
            Item testItem = currentPlayer.getCurrentPlayerRoom().getItem(item);
            if (testItem == null) {
                Writer.println("No such Item.");
            }
            else {
                if (!currentPlayer.addItem(testItem)){
                    if (testItem.getWeight() >= currentPlayer.MAXIMUM_WEIGHT) {
                        Writer.println("Item is too heavy to lift.");
                    }
                    else {
                        Writer.println("You are carrying too much.");
                    }
                }
                else {
                    Room room = currentPlayer.getCurrentPlayerRoom();
                    room.removeItem(testItem.getName());
                    Writer.println("You took the item.");
                }
            }
        }
    }

    /**
     * Print out the curetn number of turns the player has taken.
     */
    private void getTurns() {
        Writer.println("Current Turns: " + turns);
    }

    /**
     * This is the mehtod for unlocking doors.
     * @param command is the command to process.
     */
    private void unlock(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("Unlock what?");
        }
        else {
            String unlockDirection = command.getRestOfLine();
            Door unlockingDoor = currentPlayer.getCurrentPlayerRoom().getExit(unlockDirection);
            if (unlockingDoor == null) {
                Writer.println("There is no door");
            }
            else {
                if(!unlockingDoor.isLocked()) {
                    Writer.println("Door is not locked");
                }
                else {
                    Writer.println("Which key?");
                    String unlockingKey = Reader.getResponse();
                    Item playerKey = currentPlayer.getItem(unlockingKey);
                    if (playerKey == null) {
                        Writer.println("You dont have the key.");
                    }
                    else {
                        if (!unlockingKey.equals(unlockingDoor.getKey())) {
                            Writer.println("Wrong Key");
                        }
                        else {
                            unlockingDoor.setLocked(false);
                            Writer.println("You unlocked it");
                        }
                    }
                }
            }
        }
    }

    /**
     * This is the method for unpacking items from containers.
     * @param command is the commmand being procesed.
     */
    private void unpack(Command command) {
        if (!command.hasSecondWord()) {
            Writer.println("Unpack what?");
        }
        else {
            String unpackingContainerName = command.getRestOfLine();
            Item roomContainer = currentPlayer.getCurrentPlayerRoom().getItem(unpackingContainerName);
            Item playerContainer = currentPlayer.getItem(unpackingContainerName);
            if (playerContainer == null && roomContainer == null) {
                Writer.println("You dont see it");
            }
            else {
                Container theContainer = null;
                if (roomContainer == null) {
                    if (playerContainer instanceof Container) {
                        theContainer = (Container)playerContainer;
                    }
                }
                else{
                    if (roomContainer instanceof Container) {
                        theContainer = (Container)roomContainer;
                    }
                }
                if (theContainer == null) {
                    Writer.println("That's not a container");
                }
                else {
                    Writer.println("What item would you like to unpack?");
                    String desiredItemName = Reader.getResponse();
                    if (!theContainer.hasItem(desiredItemName)) {
                        Writer.println("You don't find it");
                    }
                    else {
                        Item testItem = theContainer.removeItem(desiredItemName);
                        if (!currentPlayer.addItem(testItem)) {
                            Writer.println("You are already carrying too much.");
                        }
                        else {
                            Writer.println("You unpacked it");
                        }
                    }
                }
            }
        }
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        Room currentRoom = currentPlayer.getCurrentPlayerRoom();
        Writer.println();
        Writer.println("Welcome to the Campus of Kings!");
        Writer.println("Campus of Kings is a new, incredibly boring adventure game.");
        Writer.println("Type 'help' if you need help.");
        Writer.println();
        printLocationInformation();
        Writer.println("");
    }

}
