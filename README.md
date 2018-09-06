# GoFish
Procedure

-52 cards in an array

while (exist == false){

- game start--> game reset: shaffle()
- you and computer get 7 cards
- game play
- game finish
- get exist from user

}

Classes:
  Game class
    Responsible for: 
      logic 
        loop running the game, keeping track of turns, etc.
        the deck
        settings
        menu
       
  Player Class
      Responsible for:
        hand vector
        "set" field for groups of 4 
        keeping track of possible guesses
        
  Opponent extends Player class
      Responsible for:
         "smart" or "dumb" field
         guess logic
         
         
