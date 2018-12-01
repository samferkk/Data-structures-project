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
        currentPlayer = new Player(world.getRoom("Lobby"));
        score = 0;
        turns = 0;
        this.fillShoppingList();

    }

    /**
     * This method will be used to add items to the shopping list of the player.
     */
    private void fillShoppingList() {
        currentPlayer.addListItem("Cat in The Hat");
        currentPlayer.addListItem("Soap");
        currentPlayer.addListItem("Tennis ball");
        currentPlayer.addListItem("Box of chocolate");
        currentPlayer.addListItem("Wool Socks");
        currentPlayer.addListItem("Basketball");
        currentPlayer.addListItem("Spider-man action figure");
        currentPlayer.addListItem("Brown jacket");
        currentPlayer.addListItem("Lamp");
        currentPlayer.addListItem("Hand Saw");
        currentPlayer.addListItem("Hammer");
        currentPlayer.addListItem("Pet Cemetary");
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

                case CROSS:
                cross();
                break;

                case DROP:
                drop(command);
                break;

                case READ:
                read();
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

                case LEAVE:
                wantToQuit = leave(command);
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
     * This method willl handle reading the shopping list.
     */
    private void read() {
        Writer.println("Your current item to get is:");
        Writer.println(currentPlayer.readList());
    }
    
    /**
     * This method will Cross off the top entry as long as the item in is the player inventory.
     */
    private void cross() {
        String testItem = currentPlayer.readList();
        if(currentPlayer.hasItem(testItem)){
            Writer.println("Crossing off " + testItem + " from list");
            currentPlayer.removeListItem();
        }
        else{
            Writer.println("You do not have " + testItem + " in your inventory.");
            Writer.println("Cannot cross off item");
        }
    }
    
    /**
     * This method will have player leave the mall.
     * It will check that the shopping list is empty.
     * @param a command to be passed to the quit method.
     * @return a boolean of wheater the player is quitting or not.
     */
    private boolean leave(Command command) {
        boolean wantToQuit = false;
        if(currentPlayer.isListEmpty() != false) {
            wantToQuit = quit(command);
        }
        else{
            Writer.println("You can not leave you have not gotten everything yet.");
        }
        return wantToQuit;
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
     * Prints out the location information.
     */
    private void look(){
        this.printLocationInformation();
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
