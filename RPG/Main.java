package RPG;

public class Main {
    
}


/*
    Player can NOT buy an item if
        - do not have enough coins
        - backpack is or will be overweight if bought
        - backpack is is full (might be similar to the point above)

    Player starts with 45 coins
    backpack must be implemented as an object and uses a hash table implemented as sep.chaining to hold the items (weapons) bought
    max number of items backpack can hold is 30
    max weight backpack can take is 90 pounds.


    in main program ask user for a NAME for the player
    next...
    present a menu with functionality
    1. add items to the shop 
    2. delete items from the shop
    3. buy from the shop - Allows the player to buy items from the shop. Only items that are in stock (quantity > 0) should be displayed
    4. view backpack - list of all the items in the player's backpack
    5. view player - show(print)
                        - the player's name
                        - the amount of coins they have
                        - a list of all the items in their backpack
    6. exit

*/
