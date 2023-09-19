//Initialising my global variables
let array = []; //Creating an empty array global variable
let oldColour; //Checks the old colour of the shape
let fillColour; //Fills the shape clicked on with this colour

function FloodFill() {
    //Setting the name and icon
    this.name = "floodFill";
    this.icon = "assets/floodFill.jpg";

    noSmooth(); //Draws all geometry with jagged edges. Reference: https://p5js.org/reference/#/p5/noSmooth

    this.draw = function() {
        //If mouse is pressed, the following things happen
        if(mouseIsPressed) {
            oldColour = get(mouseX, mouseY); //We "get" the colour of where our mouse was clicked. Reference: https://p5js.org/reference/#/p5/get
            loadPixels(); //Load Pixels!
            array.push({x: mouseX, y: mouseY}); //Push the mouse x and mouse y values into the array
        }
        fillColour = colorPicker.color(); //Setting the fill colour to the colour chosen on the wheel

        /**The matching function:
         * @param {Array} z: (r, g, b, a)
         * @param {Number} x: The x co-ordinate of where the colour is being filled
         * @param {Number} y: The y co-ordinate of where the colour is being filled
         * @returns {Boolean}: true or false
         */
        this.matching = function(z, x, y) {
            //Stringify converts the value to a string
            //Reference here: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON/stringify
            return JSON.stringify(z) === JSON.stringify(get(x, y));
        }
          
        //A conditional to make the draw function stop if the array is empty
        if (!array.length) {
            return;
        }
        
        //Creating some local variables to make the conditionals below look simpler
        let p = array.pop(); //Pops the array
        let x1 = p.x; //The x co-ordinate of the popped numbers
        let y = p.y; //The y co-ordinate of the popped numbers
        
        //Decrements x by 1 each time the colour is filled
        while (x1 > 0 && this.matching(oldColour, x1 - 1, y)) {
            x1--;
        }
        
        //Some booleans which are being used below
        let pixelAbove = false;
        let pixelBelow = false;
        
        //The for loop sets a new variable x2=x1+1. We add 1 to x1 as x1 is just one lesser than the width.
        //The for loop keeps on incrementing by 1 every time until either x2 is greater than the width, or 
        // the colour is already matched
        for (let x2 = x1 + 1; x2 < width && this.matching(oldColour, x2, y); x2++) {
            //Sets the colour to be the fill colour. Reference: https://p5js.org/reference/#/p5/set
            set(x2, y, fillColour);

            //Checks if y coordinate is greater than 0 and if the y-1 coordinate matches the old colour
            if (y > 0 && pixelAbove !== this.matching(oldColour, x2, y - 1)) {
                if (!pixelAbove) {//if pixelAbove is false
                    array.push({ x: x2, y: y - 1 }); //Push x2 and y-1 into the array
                }
                pixelAbove = !pixelAbove;
            }
            //Checks if y coordinate is lesser than the height-1 and if the y+1 coordinate matching the old colour
            if (y < height - 1 && pixelBelow !== this.matching(oldColour, x2, y + 1)) {
                if (!pixelBelow) {//If pixelBelow is false
                    array.push({ x: x2, y: y + 1 }); //Push x2 and y+1 into the array
                }
                pixelBelow = !pixelBelow;
            }
        }
        updatePixels(); //Update pixels!
    }
}