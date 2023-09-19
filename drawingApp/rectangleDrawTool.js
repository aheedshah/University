/*What this tool does is basically create rectangles with the colour
you have chosen to be it's fill*/
function RectangleDrawTool() {
    //Setting the name and icon for my rectangle object
    this.name = "rectDraw";
    this.icon = "assets/rect.png";

    /*Just like we have drawn freely in the freehandTool, we'll draw 
    a rectangle from the previous mouse location to the current mouse location. 
    These values below store the locations from the last frame as we 
    haven't started drawing yet.*/
    var previousMouseX = -1;
    var previousMouseY = -1;

    fill(0);

    //Calling the draw function. This is what creates our rectangle
    this.draw = function() {
        //If the mouse is pressed, this code will be implemented
        if(mouseIsPressed) {
            //Checking if the previousX and previousY are -1 and setting them
            //to the current mouseX and mouseY
            if(previousMouseX == -1) {
                previousMouseX = mouseX;
                previousMouseY = mouseY;
            }
            //Finally, we will be drawing a rectangle from previousX and 
            //previousY to the current mouse location
            else {
                /*As the last two arguments of rect are width and height, I have
                used the difference of the current value of mouseX and previousMouseX
                to figure out what the width and height of the figure we are 
                drawing will be equal to. */
                rect(previousMouseX, previousMouseY, mouseX-previousMouseX, mouseY-previousMouseY);
            }
        }
        //When we release the mouse, we will set the previous values 
        //back to -1
        else {
            previousMouseX = -1;
            previousMouseY = -1;
        }
    }
}