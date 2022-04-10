# Challenge level 1

When the user has finished typing the amount (and clicked on a button to validate the amount), the calculator
will ask the API with the desired amount and:

1. if the desired amount is possible, **display a list of the cards needed to reach that amount** (for instance, if the
   user ask for 60 € but the shop doesn't have any 60 € card but 40 € and 20 € cards, the API will return one 20 € card
   and one 40 € card);
2. if the desired amount is not possible, then the component will allow the user to choose a possible amount
   next to its value (for example, the user asks for 48 €, the component will let him choose 60 € (40+20) or 40 €).
   When the user has made a choice, it will autocorrect the typed amount and do the step **1** with the chosen amount;
3. if the desired amount is higher or lower than the possible amounts, the component will auto-correct the user
   with the possible value (for example, the user ask for 5 €, the API will return that only 20 € is possible) and
   do the step **#1** with the auto-corrected amount.

```
Montant désiré :
 _____________
|             |  
|     60      |
|_____________|

[   VALIDER   ]

Votre montant est composé des cartes suivantes :
 - 40 €
 - 20 €

```


