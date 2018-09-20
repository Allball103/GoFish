# GoFish.java

"Welcome to Gofish Game!"

- [x] 52 cards in an array
- [x] (play or exit?)-->bool exit (mainMenu class)
- [ ] (game finished?) -->bool winner

- game play

while (exist == false){
- [x] gamereset() 
- [x] shuffle()
- [x] drawACard()
- [x] you and computer get 7 cards-->drawACard()*7*2
- [x] total number of cards is always 52
- [ ] level()-->smart or stupid computer?

while (winner == false){
- [x] sort()-->sort cards and get rid of duplicates to display
- [ ] winner() --> who gets more completed deck

}

- game finish 
- [x] call the mainMenu class again

}

"Thanks for playing!"


# Classes:
1. Card class
- [x] rank
- [x] suit
- [x] getters & setters
2. Player class
- [x] sort()-->sort cards and get rid of duplicates to display
- [x] askRank()-->display what card of rank is needed -->player knows what ranks to ask --> returns the needed rank (in progress)
- [x] choose() -->make computer to choose a rank to ask
- [x] goFish() --> don't have the card--> draw a card
- [x] exchange() --> have the card --> give out the card 
- [ ] getScore() --> 1 credit for having 4 cards with the same rank, adds them to a "set" array
3. Computer class (extends Player)
- [ ] askRank() -->modified for computer class - needs update for "Smart" version 
- [x] choose() --> modified for computer class



         
