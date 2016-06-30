
My java project : the game *Filler*
================================




Objective and rules:
--------------------

It is a single or multiplayer game, each turn a player choose a color.
Once the color is choosed the player conqueer all the token around him which bear the same color. 

*The first to conqueer more than half of the board win the game.*

 - One player can not choose an other player color. 
 - The game does not allow more than 4 player including IA
 
Screen to choose the number of player:

![Selection of the number of player](http://i.imgur.com/0qoFJxj.jpg)

Screenshot of the game:

![Screenshot of the game working](http://i.imgur.com/XvsYFLk.jpg)

A finished game:

![A finished game](http://i.imgur.com/owv14Fk.jpg)


How to run the game
-------------------
Download the source with your IDE, and ewecute the class Main 

You have two constructor to choose from :

    Game game = new Game();
by using this method a game with a GUI asking you the number of player and the number of IA as well as the size of the board.

If you prefer to write thos parameter you can use this method :

    Game game = new Game(20,1,1,false);

 
List of the parameter:

 1. Size of the board
 2. Number of players
 3. Number of IA
 4. If you want a GUI

 

Library used
------------

The only third party software used was the [StdDraw Library](http://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html) which allowed me to create quickly and simply the GUI. 

But for my next project i will use swing which would allow me to build a snappier UI.
