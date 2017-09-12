This program was made by Zhixue (Mary) Wang, Zhifei (Kary) Wang, and Leo Yao.
This program and its accompanying README was created on May 18, 2015.

This program is about an adventure in a dungeon, where the hero tries to avoid traps and slay monsters along the way in order to pass floors and reach the end of the dungeon 
to obtain “eternal glory”. The objective of each floor is to pass by reaching the stairs. This may involve avoiding invisible traps, fighting monsters, pressing buttons to 
remove walls, etc. During this, the player also tries to make sure their heart count stays as high as possible (by avoiding monsters or increasing character stats). This game
is designed for anyone would enjoy strategy games with an element of action. Players should be prepared to be frustrated with the invisible traps and enjoy slaying endless
monsters. Some features that this game possesses are said frustrating traps, wonderful music, mysterious buttons, monsters, instruction screens, and much more throughout 
the multiple floors. Hint: it is helpful to not give up as there is always a way to pass the floor.

To move our hero, use the "WASD" key to move up, left, down, and right respectively. Use either mouse button to click on a button when the hero is next it. This may result 
in a wall being added, removed, or even health being lost at all depending on which button you clicked and how many times you clicked it. Our hero falls into invisible traps 
while running and loses hearts when it comes into contact with a monster. To change our character's amount of hearts, press the button next to the stat to increment 
(heart count is incremented by one heart each time) on the stat screen which appears after passing a level. Use the mouse to click on buttons, arrows, signs, and tombstones 
to change screens.

CLASS LIST: 
Dungeon 
            (Class that contains the main method)                                                                          
Main Screen 
            (Class that represents the start screen with start, return to floor, go to death screen, and instruction options to choose from)                                                                                           
DeathScreen 
            (Class that represents the death screen which contains the number of deaths and options to return to menu or level)		                                                                                                                                                       
Floor	
            (Class that represents a floor)                                                              
Floor1
            (Subclass that extends Floor and represents the first floor with the main character, traps, monster, and the stairs to the next level)                                                                
Floor2
            (Subclass that extends Floor and represents the second floor which has an addition of a button)                                                                                                                        
Floor3
            (Subclass that extends Floor and represents the third floor which has an addition of another button with a different function as well as a wall)                                         
Floor4
            (Subclass that extends Floor and represents the fourth floor which has an addition of another button with another function)                                                                      
Floor5
            (Subclass that extends Floor and represents the fifth floor which has an addition of another button with another function as well as more walls)                                    
Floor6
	    (Subclass that extends Floor and represents the sixth floor which has an addition of multiple monsters and a second set of stairs)
Character
            (Abstract class that represents the characters in the game)			                  
Main Character 
            (Subclass that extends Characters and represents the player-controlled character) 
Monster
            (Subclass that extends Character and represents a monster)	                                                                                                              
Trap 
            (Class that represents the traps)                                          
UserLocation
	    (Class that represents the location of the the user)                                                  
UserInterface
            (Class that represents the layout of the JPanels)					   
Button
            (Class that represents the buttons)			
BlueButton
	    (Class that represents the blue button)                                            
RedButton
	    (Class that represents the red button)                                                     
GreenButton
	    (Class that represents the green button)                                               
PlusButton
	    (Class that represents the button used to increment stats)                                          
ArrowButton
	    (Class that represents the button used to go to the next level on the stat screen and to return to the main screen after winning)      
Wall
	    (Class that represents the wall that blocks the stairs)                                                
Stairs
	    (Class that represents the stairs that allow the user to go to the next level)              
InstructionsScreen
	    (Class that represents the screen where more detailed, user-friendly instructions are provided)                                                                                                                                   
StatsScreen
	    (Class that represents the screen where the user may choose to increase the character’s stats before going to the next level)                                                                       
Heart
	    (Class that represents the hearts that represent the character’s health)                       
EndScreen
	    (Class that represents the congratulations screen that shows upon the finish of the last floor)                                                                                                                                                  
MovingImage
	    (Class that represents all moving images)                              
HintCharacter
	    (Class that represents the character that gives sometimes helpful -sometimes not- hints to the user)
Screen
	    (Interface for all screens that adds the UI)                                  
EasySound2
        (Class for the music taken from online sources)

Leo: 
Dungeon
UserInterface
UserLocation
Screen
Character
Monster
Moving Image (taken from Mr. Shelby then altered)

Kary: 
Floor
HintCharacter
Stairs
Wall
Trap
Button
PlusButton
GreenButton
RedButton
BlueButton
ArrowButton
EasySound2

Mary: 
MainScreen
InstructionsScreen
StatsScreen
DeathScreen
EndScreen
MainCharacter
Heart

Shared by Leo, Mary and mainly Kary:	
Floor1
Floor2
Floor3
Floor4
Floor5
Floor6