/*This tool will create ellipses with the colour chosen*/
function EllipseDrawTool() {
    //Setting the name and icon for my Ellipse Object
    this.name = "ellipseDraw";
    this.icon = "assets/ellipse.png";

    /*Just like we have drawn a rectangle before, in its separate JS file, we'll draw 
    a ellipse from the previous mouse location to the current mouse location. 
    These values below store the locations from the last frame as we 
    haven't started drawing yet.*/
    var previousMouseX = -1;
    var previousMouseY = -1;
    fill(0);

    //Calling the draw function. This is what creates our ellipse
    this.draw = function() {
        //If the mouse is pressed, this code will be implemented
        if(mouseIsPressed) {
            //Checking if the previousX and previousY are -1 and setting them
            //to the current mouseX and mouseY
            if(previousMouseX == -1) {
                previousMouseX = mouseX;
                previousMouseY = mouseY;
            }
            //Finally, we will be drawing an ellipse from previousX and 
            //previousY to the current mouse location
            else {
                /*As ellipse's last two arguments are width and height, I have
                to use the difference between previousMouse positions and the 
                current mouse positions. 
                */
                ellipse(previousMouseX, previousMouseY, mouseX-previousMouseX, mouseY-previousMouseY);
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