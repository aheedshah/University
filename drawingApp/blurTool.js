//This function keeps on blurring the canvas with each mouse click.
function BlurTool() {
    //Setting the name and icon
    this.name = "blurTool";
    this.icon = "assets/blurTool.png";

    this.draw = function() {
        //If the mouse is pressed, the following code will be implemented
        if(mouseIsPressed) {
            //Checking if the previousX and previousY are -1 and setting them
            //to the current mouseX and mouseY
            if(previousMouseX == -1) {
                previousMouseX = mouseX;
                previousMouseY = mouseY;
            }
            //Finally, using an else conditional to blur out the canvas.
            else {
                push(); //start drawing state
                filter(BLUR, 3); //Filtering the canvas to blur
                previousMouseX = mouseX;
                previousMouseY = mouseY;
                pop();//end drawing state
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