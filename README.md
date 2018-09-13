# GoFish Procedure

"Welcome to Gofish Game!"

- [x] 52 cards in an array

- [ ] (play or exitt?)-->bool exit (mainMenu class)
- [ ] (game finished?) -->bool winner

while (exist == false){
- [x] gamereset() 
- [x] shuffle()
- [x] drawACard()
- [x] you and computer get 7 cards-->drawACard()*7
- [x] total number of cards is always 52
- game play
- [x] sort cards and get rid of duplicates to display

while (winner == false){
- [x] sort cards and get rid of duplicates to display
- [ ] askRank()-->display what card of rank is needed -->player knows what ranks to ask --> returns the needed rank (in progress)
- [ ] choose() -->make computer to choose a rank to ask
- [ ] goFish() --> don't have the card--> draw a card
- [ ] exchange() --> have the card --> give out the card 
- [ ] getScore() --> 1 credit for having 4 cards with the same rank
- [ ] winner() --> who gets more completed deck

}

- game finish 
- [ ] call the mainMenu class again

}

"Thanks for playing!"


# Classes:
0. Card class
- [x] rank
- [x] suit
- [x] getters & setters

1. Game class
- [ ] logic
- [ ] loop running the game, keeping track of turns, etc
- [ ] the deck
- [ ] settings
- [ ] menu
       
2. Player Class:
- [ ] hand vector
- [ ] "set" field for groups of 4 
- [ ] keeping track of possible guesses
        
3. Opponent extends Player class:
- [ ] "smart" or "dumb" field
- [ ] guess logic
         
         
