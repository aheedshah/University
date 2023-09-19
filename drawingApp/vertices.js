//Declaring my global variables
let editButton;
let finishButton;
let editMode = false;
let currentShape = [];

function Vertices() {
    //Adding name and icon
    this.name = "vertices";
    this.icon = "assets/vertices.gif";

    //This is part of my setup function
    
    loadPixels();
    
    editButton = createButton('Edit Shape');
    editButton.position(200, 700)
    editButton.mousePressed(function() {
        if(editMode) {
            editMode = false;
            editButton.html("Edit Shape");
        }
        else {
            editMode = true;
            editButton.html("Add Vertices");
        }
    });
    
    finishButton = createButton('Finish Shape');
    finishButton.position(300, 700);
    finishButton.mousePressed(function() {
        editMode = false;
        draw();
        loadPixels();
        currentShape = [];
    });

    this.draw = function() {
        noFill();
        updatePixels();
        if(this.mousePressOnCanvas(c) && mouseIsPressed) {
            if(!editMode) {
                currentShape.push({
                x: mouseX, 
                y: mouseY
                });
            }
            else {
                for(let i = 0; i<currentShape.length; i++) {
                    if(dist(currentShape[i].x, currentShape[i].y, mouseX, mouseY)<15) {
                        currentShape[i].x = mouseX;
                        currentShape[i].y = mouseY
                    }
                }
            }
        }
        
        beginShape();
        for(let i = 0; i< currentShape.length; i++) {
            vertex(currentShape[i].x, currentShape[i].y);
            if(editMode) {
                fill('red');
                ellipse(currentShape[i].x, currentShape[i].y, 10);
                noFill();
            }
        }
        endShape();
    }

    this.mousePressOnCanvas = function(canvas) {
        if(mouseX > canvas.elt.offsetLeft && mouseX < (canvas.elt.offsetLeft + canvas.width) &&
        mouseY > canvas.elt.offsetTop && mouseY < (canvas.elt.offsetTop + canvas.height)) {
            return true;
        }
        return false;
    }
}