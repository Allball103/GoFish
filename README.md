# GoFish Procedure

52 cards in an array

(play or exist?)-->bool exist

while (exist == false){

- game start--> game reset: shaffle()
- you and computer get 7 cards
- game play
- game finish
- get exist from user

}

"Thanks for playing!"


# Classes:
1. Game class
- logic
- loop running the game, keeping track of turns, etc
- the deck
- settings
- menu
       
2. Player Class:
- Responsible for:
- hand vector
- "set" field for groups of 4 
- keeping track of possible guesses
        
3. Opponent extends Player class:
- Responsible for:
- "smart" or "dumb" field
- guess logic
         
         
