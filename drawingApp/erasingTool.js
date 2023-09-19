/*This tool will basically erase things you have drawn in the
canvas in the form of a line with stroke weight of 20. What I 
have done is use a P5 function called erase(), whose documentation 
you can look for at: https://p5js.org/reference/#/p5/erase*/
function ErasingTool() {
    //Setting the name and icon for my tool
    this.name = "erasingTool";
    this.icon = "assets/eraser.jpg";

    /*We'll start to remove the things drawn in the canvas in the form of 
    a line. We will need to define previous mouse values. These values below 
    store the locations from the last frame as we haven't started erasing yet.*/
    var previousMouseX = -1;
    var previousMouseY = -1;

    //Calling the draw function which will remove things drawn
    //on the canvas
    this.draw = function() {
        let val = slider.value();
        //If the mouse is pressed, the following code will be implemented
        if(mouseIsPressed) {
            //Checking if the previousX and previousY are -1 and setting them
            //to the current mouseX and mouseY
            if(previousMouseX == -1) {
                previousMouseX = mouseX;
                previousMouseY = mouseY;
            }
            //Finally, drawing the lines using the erase function.
            else {
                /*Here, we will be drawing lines with a radius of spread which
                has been defined before.*/
                push();
				strokeWeight(val);
                erase();
                line(previousMouseX, previousMouseY, mouseX, mouseY);
                noErase();
                previousMouseX = mouseX;
                previousMouseY = mouseY;
                pop();
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