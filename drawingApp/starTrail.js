/*What this tool does is create a trail of stars which have
been created in the draw function of this function */
//I took help from this link: https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwj85frt57nvAhWJUBUIHVcFBRcQFjABegQIAxAD&url=https%3A%2F%2Feditor.p5js.org%2Fmaxremfort%2Fsketches%2FhqxwqoF-w&usg=AOvVaw1P1EdlK4z6aAvrk8yGRerc
function StarTrail() {
    //Setting the name and icon for the star object
    this.name = "starTrail";
    this.icon = "assets/star.png"

    fill(0);
    
    //Calling the draw function which creates a star trail
    this.draw = function() {
        this.mouseClicked();
    }
    this.drawStar = function(x, y) {
        if(x&&y) {
            beginShape();
            vertex(mouseX, mouseY);
            vertex(mouseX-80, mouseY);
            vertex(mouseX-110, mouseY-85);
            vertex(mouseX-150, mouseY);
            vertex(mouseX-230, mouseY);
            vertex(mouseX-165, mouseY+55);
            vertex(mouseX-190, mouseY+125);
            vertex(mouseX-115, mouseY+85);
            vertex(mouseX-40, mouseY+125);
            vertex(mouseX-65, mouseY+55);
            endShape(CLOSE);
       }
    }
    this.mouseClicked = function() {
        if(mouseIsPressed) {
            this.drawStar(true, true);
        }
    }
}