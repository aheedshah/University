Two questions: 

**Question 1: MiniList collection:**

Produce a simplified collection type called MyMiniList. MyMiniList will work in a similar way to ArrayList. Internally, it will use an array, you will have to reorganise and grow the array as the MiniList is updated through use of its methods.

**Question 2: Multithreaded pi estimation:**

In the class PiEstimation is a simple algorithm that makes an estimate of Pi. 
The algorithm works by throwing theoretical darts at a dart board like the one in the drawing below, 
darts that hit the board fall within the quarter circle darts that miss are outside it. 

The dartboard has a height and width of 1, this makes our calculations easier. We throw a dart by generating a random x and y coordinate for the dart between 0 and 1. 

A dart is said to hit the board if the distance from the origin is less than 1, we can calculate this using pythagorus (x2+y2 = dist2).

If we take the proportion of darts that hit the board (divide the number of hits by the total number of darts thrown) and multiply by 4 we get a surpassingly accurate estimate for Pi.
