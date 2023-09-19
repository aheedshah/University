/*
-----------------------Table of Contents--------------------
1. Declaring Variables
    1.1 Game Character and scrolling variables
    1.2 Game Character's Mechanisms variables
    1.3 Environment-related variables 
    1.4 Sound Effects variables
    1.5 Game Mechanism variables
    
2. Preloading my Music and Sound effects

3. Functions
    3.1 The Setup Function
    3.2 The Draw Function
    3.3 The Start Game function
    3.4 The Game Score Function
    3.5 The Draw Lives Function which draws the lives available
    3.6 The Key Pressed Function
    3.7 The Key Released Function

4. Drawing the Game Characters
    4.1 The Game Character
    4.2 The Enemy

5. Drawing Game Environment
    5.1 Clouds 
    5.2 Mountains
    5.3 Trees
    5.4 Canyons
    5.5 Sun
    5.6 Rings
    5.7 Bags
    5.8 Apples
    5.9 Flagpole
    5.10 Platforms
    
6. Check interaction of Game Character with:
    6.1 Canyons
    6.2 Rings
    6.3 Bags
    6.4 Apples
    6.5 Flagpole
*/

//-------------------1. Declaring Variables------------------------
//1.1 Game Character and scrolling variables 
let gameChar_x;
let gameChar_y;
let floorPos_y;
let scrollPos;
let gameChar_world_x;

//1.2 Game Character's Mechanisms variables
let isLeft;
let isRight;
let isFalling;
let isPlummeting;

//1.3 Environment-related variables
let trees_x;
let tree;
let clouds;
let mountains;
let sun;
let apple;
let bag;
let ring;
let canyon;
let platforms;

//1.4 Sound effects variables
let jumpSound;
let forest;
let walking;
let ringSound;
let appleSound;
let bagSound;
let dyingSound;

//Declaring variables to keep the sound repeating
let forestIsLooping;
let rightIsLooping;
let leftIsLooping;

//1.5 Game Mechanism variables
//Declaring the score counter
let game_score = 0;

//Declaring the flagpole
let flagpole;

//Declaring the lives variable
let lives;

//Declaring my Enemies
let enemies;


//--------2. Preloading my Music and Sound effects-------------
function preload()
{
    soundFormats('wav');
    
    //loading my sounds
    //The forest sound
    forest = loadSound('/assets/forest.wav');
    forest.setVolume(0.3);
    //The Footsteps
    walking = loadSound('/assets/footsteps.wav');
    walking.setVolume(0.1);
    //The Jumping sound
    jumpSound = loadSound('/assets/Jumping.wav');
    jumpSound.setVolume(0.1);
    //The Collectable Sound
    ringSound = loadSound('/assets/collect.wav')
    ringSound.setVolume(0.2);
    //The Apple Bite Sound
    appleSound = loadSound('/assets/apple.wav');
    appleSound.setVolume(0.2);
    //The Bag Zip Sound
    bagSound = loadSound('/assets/bag.wav');
    bagSound.setVolume(0.2);
    //Falling down the Canyon Sound
    dyingSound = loadSound('/assets/canyon.wav');
    dyingSound.setVolume(0.5);
}

//--------------------3. Functions------------------------------
//3.1 The Setup Function
function setup()
{
    //Creating canvas and initialising floorpos_y
	createCanvas(1024, 576);
	floorPos_y = height * 3/4;
    //Initialising the lives
    lives = 4;
    //Calling startGame()
    startGame();
}

//3.2 The Draw Function
function draw()
{
    //The Sky
	background(100, 155, 255);
    //The Ground
	noStroke();
	fill(0,155,0);
	rect(0, floorPos_y, width, height/4);
    
    //Push to Start the Translation
    push();
    translate(scrollPos,0);
	// Drawing clouds.
    drawClouds();

	// Drawing mountains.
    drawMountains();

	// Drawing trees.
    drawTrees();
    
    // Drawing the flagpole
    drawFlagpole();
    
	// Draw canyons.
    for(let i = 0; i<canyon.length; i++)
    {
        checkCanyon(canyon[i]);
        drawCanyon(canyon[i]);
    }

	// Draw collectable items.
    //The Sun
    for(let i = 0; i < sun.length; i++)
    {
        drawSun(sun[i]);
    }
    
    //The Apples
    for(let i = 0; i < apple.length; i++)
    {
        if(apple[i].isFound == false)
        {
            drawApple(apple[i]);
            checkApple(apple[i])
        }
    } 
    //The bags
    for(let i = 0; i < bag.length; i++)
    {
        if(bag[i].isFound == false)
        {
            drawBag(bag[i]);
            checkBag(bag[i]);
        }
    }
    //The rings
    for(let i=0; i < ring.length; i++)
    {
        if(ring[i].isFound == false)
        {
            drawRing(ring[i]);
            checkRing(ring[i]);
        }
    }
    
    //Drawing enemies on the screen
    for(let i = 0; i < enemies.length; i++)
    {
        enemies[i].update();
        enemies[i].draw();
        if(enemies[i].hasCollided(gameChar_world_x, gameChar_y))
        {
            startGame();
            break;
        }
    }
    
    //Drawing platforms
    for(let i = 0; i < platforms.length; i++)
    {
        platforms[i].draw();
    }
    
    //Drawing Flagpole
    for(let i = 0; i < flagpole.length; i++)
    {
        flagpole[i].draw();
        //Conditional to see if the game character has reached the flagpole
        if(flagpole[i].hasReached(gameChar_world_x, gameChar_y))
        {
            reachedFlagpole();
        }
    }
    
    //Adding some text to the screen
    fill(0);
    text('Wrong way! Head to the right!', -300, height/2);
    text('You really should go back', -650, 350);
    text('This is enemy territory', -650, 290);
    text("So, you think you're an explorer. Is that it?", -1200, 350);
    text("I'm warning you. Don't go this way", -1700, 350);
    text("So, you have chosen...", -2400, 350);
    text("DEATH!!!", -3100, 350);
    
    //Pop to stop the translation
    pop();
    
    //Drawing the game character
	drawGameChar();
    
    //Drawing Game Character lives on the screen
    drawLives(lives);
    
    //Adding the Game score
    gameScore();
    
    //A conditional to say game over when lives are finished
    if(lives<1)
    {
        gameChar_y = floorPos_y;
        isLeft = false;
        isRight = false;
        isPlummeting = false;
        text('Game over. Press space to try again.', width/2, height/2);
        return
    }

	// Logic to make the game character move or the background scroll.
	if(isLeft)
	{
		if(gameChar_x > width * 0.2)
		{
			gameChar_x -= 5;
		}
		else
		{
			scrollPos += 5;
		}
	}

	if(isRight)
	{
		if(gameChar_x < width * 0.8)
		{
			gameChar_x  += 5;
		}
		else
		{
			scrollPos -= 5; // negative for moving against the background
		}
	}

	// Logic to make the game character rise and fall.
    //Adding Gravity
    if(gameChar_y < floorPos_y)
    {
        //Creating a local variable for checking the platform
        let inContact = false;
        
        //Checking if game character is on a platform
        for(let i = 0; i < platforms.length; i++)
        {
            if(platforms[i].checkContact(gameChar_world_x, gameChar_y) == true)
            {
                inContact = true;
                break;
            }
        }
        if(inContact == false)
        {
            gameChar_y+=2;
            isFalling = true;
        }
        else
        {
            isFalling = false;
        }
    }
    
    else
    {
        isFalling = false;
    }

	// Update real position of gameChar for collision detection.
	gameChar_world_x = gameChar_x - scrollPos;
    
    //Condition to make the character plummet    
    if(isPlummeting == true)
    {
        gameChar_y+=5;
    }
    
    //Checking if the game Character has fallen and then calling startGame()
    if(isPlummeting == true && gameChar_y>height && lives>0)
    {
        startGame();
    }
}

//3.3 The Start Game Function
function startGame()
{
    //The Game Character's starting points
    gameChar_x = width/2;
    gameChar_y = floorPos_y;
    
    //Playing the music of the forest in the background on a loop
    if(!forestIsLooping)
    {
        forest.loop();
        forestIsLooping = true;
    }
    else
    {
        forest.stop();
        forestIsLooping = false;
    }

	// Variable to control the background scrolling.
	scrollPos = 0;

	// Variable to store the real position of the gameChar in the game world. Needed for collision detection.
	gameChar_world_x = gameChar_x - scrollPos;

	// Boolean variables to control the movement of the game character.
	isLeft = false;
	isRight = false;
	isFalling = false;
	isPlummeting = false;
    sampleIsLooping = false;

	// Initialising arrays of scenery objects.
    
    //Initialising Trees
    trees_x = [];
    tree = {y: 435, scale: 0.8}
    
    //Adding random trees
    for(let i = 0; i<100; i++)
    {
        trees_x.push(round(random(-10000, 10000)));
    }
    
    //Initialising Clouds
    
    clouds = []
    for(let i=0; i<40; i++)
    {
        let x = random(-10000,10000);
        let y = random(0, 200);
        let s = random(0.7,1.5);
        clouds.push({x: x , y: y, scale: s});
    }
    
    //Initialising Mountains
    mountains = []
    
    //Adding random mountains
    for(let i=0; i<20; i++)
    {
        let x = random(-10000,10000);
        let s = random(0.7,1.5)
        mountains.push({x: x , y: 434, scale: s});
    }
    
    //Initialising Collectibles
    //Initialising the Sun
    sun = [{x: 53, y: 84, scale: 1}]
    
    //Initialising the Apple
    apple = 
    [
        {x: -600, y: 423, scale: 1, isFound: false},
        {x: -400, y: 423, scale: 1, isFound: false},
        {x: -200, y: 423, scale: 1, isFound: false},
        {x: 0, y: 423, scale: 1, isFound: false},
        {x: 200, y: 423, scale: 1, isFound: false},
        {x: 400, y: 423, scale: 1, isFound: false},
        {x: 600, y: 423, scale: 1, isFound: false},
        {x: 870, y: 380, scale: 1, isFound: false},
        {x: 1000, y: 423, scale: 1, isFound: false},
        {x: 1200, y: 423, scale: 1, isFound: false},
        {x: 2050, y: 250, scale: 1, isFound: false}
    ]

    //Initialising the bag
    bag = 
    [
        {x: -700, y: 400, scale: 0.7, isFound: false},
        {x: -450, y: 400, scale: 0.7, isFound: false},
        {x: -300, y: 400, scale: 0.7, isFound: false},
        {x: -50, y: 400, scale: 0.7, isFound: false},
        {x: 100, y: 400, scale: 0.7, isFound: false},
        {x: 400, y: 400, scale: 0.7, isFound: false},
        {x: 550, y: 400, scale: 0.7, isFound: false},
        {x: 1150, y: 400, scale: 0.7, isFound: false},
        {x: 1350, y: 400, scale: 0.7, isFound: false},
        {x: 1600, y: 400, scale: 0.7, isFound: false},
        {x: 1840, y: 270, scale: 0.7, isFound: false}
    ]

    //Initialising the ring
    ring = 
    [
        {x: -850, y: 420, scale: 0.6, isFound: false},
        {x: -650, y: 420, scale: 0.6, isFound: false},
        {x: -450, y: 420, scale: 0.6, isFound: false},
        {x: -250, y: 420, scale: 0.6, isFound: false},
        {x: -50, y: 420, scale: 0.6, isFound: false},
        {x: 150, y: 420, scale: 0.6, isFound: false},
        {x: 450, y: 420, scale: 0.6, isFound: false}, 
        {x: 750, y: 420, scale: 0.6, isFound: false},
        {x: 670, y: 370, scale: 0.6, isFound: false},
        {x: 1200, y: 420, scale: 0.6, isFound: false},
        {x: 1680, y: 355, scale: 0.6, isFound: false}
    ]
    
    //Initialising the canyon
    canyon = 
    [
        {x: -2000, y: 578, width: 100},
        {x: -1600, y: 578, width: 100},
        {x: -1300, y: 578, width: 100},
        {x: -1000, y: 578, width: 100},
        {x: -600, y: 578, width: 100},
        {x: -200, y: 578, width: 100},
        {x: 200, y: 578, width: 100},
        {x: 600, y: 578, width: 100},
        {x: 800, y: 578, width: 100},
        {x: 1000, y: 578, width: 100},
        {x: 1400, y: 578, width: 100}
    ]
    
    ///Decrementing Lives by 1 when character falls
    lives--;
    
    //Getting the game score to start from 0 everytime you die
    game_score = 0;
    
        
    //Creating an empty array for platforms
    platforms = [];
    
    //Adding new platforms by pushing them into the platforms array
    platforms.push(drawPlatform(1650, floorPos_y - 70, 70));
    platforms.push(drawPlatform(1830, floorPos_y - 120, 70));
    platforms.push(drawPlatform(2010, floorPos_y - 170, 90));
    
    //Creating an empty array for flagpole
    flagpole = [];
    
    //Adding a flagpole at the end of the game
    flagpole.push(drawFlagpole(2500, 432, 10, -170))
    
    //Creating an empty array for enemies
    enemies = [];
    
    //Pushing new things to the enemies array
    enemies.push(new Enemy(0, floorPos_y, 200));
    enemies.push(new Enemy(1150, floorPos_y, 250));
    enemies.push(new Enemy(1700, floorPos_y, 50));
    enemies.push(new Enemy(1750, floorPos_y, 50));
    enemies.push(new Enemy(1800, floorPos_y, 50));
    enemies.push(new Enemy(1850, floorPos_y, 50));
    enemies.push(new Enemy(1900, floorPos_y, 50));
    enemies.push(new Enemy(1950, floorPos_y, 50));
    enemies.push(new Enemy(2000, floorPos_y, 50));
    enemies.push(new Enemy(2050, floorPos_y, 50));
    enemies.push(new Enemy(2100, floorPos_y, 50));
    enemies.push(new Enemy(2150, floorPos_y, 50));
    enemies.push(new Enemy(2200, floorPos_y, 50));
    enemies.push(new Enemy(2250, floorPos_y, 50));
    enemies.push(new Enemy(2300, floorPos_y, 50));
    enemies.push(new Enemy(-3100, floorPos_y, 5));
    enemies.push(new Enemy(-3150, floorPos_y, 5));
    enemies.push(new Enemy(-3200, floorPos_y, 5));
    enemies.push(new Enemy(-3250, floorPos_y, 5));
    enemies.push(new Enemy(-3300, floorPos_y, 5));
    enemies.push(new Enemy(-3350, floorPos_y, 5));
    enemies.push(new Enemy(-3400, floorPos_y, 5));
    enemies.push(new Enemy(-3450, floorPos_y, 5));
    enemies.push(new Enemy(-3500, floorPos_y, 5));
    enemies.push(new Enemy(-3550, floorPos_y, 5));
    enemies.push(new Enemy(-3600, floorPos_y, 5));
    enemies.push(new Enemy(-3650, floorPos_y, 5));
    enemies.push(new Enemy(-3700, floorPos_y, 5));
    enemies.push(new Enemy(-3750, floorPos_y, 5));
    enemies.push(new Enemy(-3800, floorPos_y, 5));
    
}

//3.4 The Game Score Function
function gameScore()
{
    //Adding the Game Score
    fill(0);
    textSize(20);
    text(game_score, 900, 40); //The Game Score
    text('Total Game Score: ', 730, 40);//The text
}

//3.5 The Draw Lives Function which draws the lives available
function drawLives(t_lives)
{
    push();
    fill(0);
    textSize(20);
    text('Lives', 810, 70);
    fill(255, 0, 0);
    noStroke();
    for (i = 0; i < lives; i++) 
    {
        fill(255, 0, 0);        
        triangle(880 + (30 * i), 68.5, 
                 875 + (30 * i), 62.5, 
                 885 + (30 * i), 62.5);
        arc(877.5 + (30 * i), 61.8, 5, 5, PI, 0);
        arc(882.5 + (30 * i), 61.8, 5, 5, PI, 0);
    }
    pop();
}

//3.6 The Key Pressed Function
function keyPressed()
{
    //Making the character stop moving when it has fallen over the canyon
    if(isPlummeting == true)
    {
        return 
    }
    
    // Making the character go left
    if(keyCode == 65 || keyCode == 37)
    {
        isLeft = true;
        //Making the walking sound play on loop
        if(!leftIsLooping)
        {
            walking.loop();
            leftIsLooping = true;
        }
        else
        {
            walking.stop();
            leftIsLooping = false;
        }
    }
    
    // Making the character go Right
    if(keyCode == 68 || keyCode == 39)
    {
        isRight = true;
        //Making the walking sound play on loop
        if(!rightIsLooping)
        {
            walking.loop();
            rightIsLooping = true;
        }
        else
        {
            walking.stop();
            rightIsLooping = false;
        }
    }
    
    //Making the Character Jump
    if((keyCode == 87 || keyCode == 38) && isFalling == false)
    {
        gameChar_y -= 100;
        isFalling = true;
        //Making the Jump Sound play
        jumpSound.play();
    }
    
    //Making the character fall immediately to the ground when spacebar or the downward arrow is pressed
    if(keyCode == 32 || keyCode == 40)
    {
        gameChar_y = floorPos_y;
    }
    
    //Making the game restart if the spacebar is pressed when lives are 0
    if(keyCode == 32 && lives < 1)
    {
        lives = 4;
        startGame();
    }
    
    //Making the game restart if the spacebar is pressed when game is won
    for(let i = 0; i<flagpole.length; i++)
    {
        if(flagpole[i].hasReached(gameChar_world_x, gameChar_y) == true &&
           keyCode == 32)
        {
            game_score = 0;
            lives = 4;
            startGame();
        }
    }
}

//3.7 The Key Released Function
function keyReleased()
{
    //Making the Game Character stop when key is released
    
    //Left
    if(keyCode == 65 || keyCode == 37)
    {
        isLeft = false;
        walking.pause();
    }
    
    //Right
    if(keyCode == 68 || keyCode == 39)
    {
        isRight = false;
        walking.pause();
    } 
    
    //Jumping
    if(keyCode == 87 || keyCode == 38)
    {
        isFalling = false;
    }

}

//-----------------4. Drawing the Game Characters------------------

//4.1 The Game Character
function drawGameChar()
{
	// draw game character
    
    //the game character
	if(isLeft && isFalling)
	{
        //The Face
        push();
        fill(255, 255, 0);
        stroke(0);
        arc(gameChar_x, gameChar_y - 41, 35, 35, 5.2 * QUARTER_PI, 3.6* QUARTER_PI);
        noStroke();
        fill(255);
        fill(0);
        ellipse(gameChar_x, gameChar_y-52, 5, 5);
        pop();

        //The legs
        push();
        stroke(0);
        line(gameChar_x-6, gameChar_y-23, gameChar_x-6, gameChar_y-10);//Left leg
        line(gameChar_x+6, gameChar_y-23, gameChar_x+6, gameChar_y-10);//Right Leg
        line(gameChar_x-6, gameChar_y-10, gameChar_x, gameChar_y-7);//Left Foot
        line(gameChar_x+6, gameChar_y-10, gameChar_x+10, gameChar_y-7);//Right Foot
        pop();

        //Antennaes
        push();
        stroke(0);
        line(gameChar_x+5, gameChar_y-57, gameChar_x+18, gameChar_y-63);
        line(gameChar_x+5, gameChar_y-57, gameChar_x+11, gameChar_y-67);
        fill(255, 0, 0);
        ellipse(gameChar_x+10, gameChar_y-66, 5, 5);
        ellipse(gameChar_x+17, gameChar_y-63, 5, 5);
        pop();
	}
	else if(isRight && isFalling)
	{
        //The Face
        push();
        fill(255, 255, 0);
        stroke(0);
        arc(gameChar_x, gameChar_y-41, 35, 35, 0.4* QUARTER_PI, 1.7 * PI)
        noStroke();
        fill(255);
        pop();

        //The Eye
        push();
        fill(0);
        ellipse(gameChar_x, gameChar_y-51, 5, 5);
        pop();

        //The legs
        push();
        stroke(0);
        line(gameChar_x-6, gameChar_y-23, gameChar_x-6, gameChar_y-10);//Left leg
        line(gameChar_x+6, gameChar_y-23, gameChar_x+6, gameChar_y-10);//Right Leg
        line(gameChar_x-6, gameChar_y-10, gameChar_x-14, gameChar_y-7);//Left Foot
        line(gameChar_x+6, gameChar_y-10, gameChar_x, gameChar_y-7);//Right Foot
        pop();

        //The Antennae
        push();
        stroke(0);
        line(gameChar_x-4, gameChar_y-57, gameChar_x-17, gameChar_y-65);//More left
        line(gameChar_x-4, gameChar_y-57, gameChar_x-10, gameChar_y-69);//Slight Left 
        fill(255, 0, 0);
        ellipse(gameChar_x-17, gameChar_y-66, 5, 5);//More left
        ellipse(gameChar_x-9, gameChar_y-69, 5, 5);//Sligh Left
        pop();
    }
	else if(isLeft)
	{
        //The Face
        push();
        fill(255, 255, 0);
        stroke(0);
        arc(gameChar_x, gameChar_y - 41, 35, 35, PI + QUARTER_PI, PI);
        noStroke();
        fill(255);
        fill(0);
        ellipse(gameChar_x, gameChar_y-52, 5, 5);
        pop();

        //The legs
        push();
        stroke(0);
        line(gameChar_x-6, gameChar_y-23, gameChar_x-6, gameChar_y-1);//Left leg
        line(gameChar_x+6, gameChar_y-23, gameChar_x+6, gameChar_y-1);//Right Leg
        line(gameChar_x-6, gameChar_y, gameChar_x-13, gameChar_y);//Left Foot
        line(gameChar_x+6, gameChar_y, gameChar_x, gameChar_y);//Right Foot
        pop();

        //Antennaes
        push();
        stroke(0);
        line(gameChar_x+5, gameChar_y-57, gameChar_x+18, gameChar_y-63);//More Right
        line(gameChar_x+5, gameChar_y-57, gameChar_x+11, gameChar_y-67);//Slight Right
        fill(238, 130, 238);
        ellipse(gameChar_x+10, gameChar_y-66, 5, 5);//Slight Right
        ellipse(gameChar_x+17, gameChar_y-63, 5, 5);// More Right
        pop();
    }
	else if(isRight)
	{
        //The Face
        push();
        fill(255, 255, 0);
        stroke(0);
        arc(gameChar_x, gameChar_y - 41, 35, 35, 0, PI + QUARTER_PI * 3);
        noStroke();
        fill(255);
        pop();

        //The Eye
        push();
        fill(0);
        ellipse(gameChar_x, gameChar_y-51, 5, 5);
        pop();

        //The legs
        push();
        stroke(0);
        line(gameChar_x-6, gameChar_y-23, gameChar_x-6, gameChar_y-1);//Left Leg
        line(gameChar_x+6, gameChar_y-23, gameChar_x+6, gameChar_y-1);//Right Leg
        line(gameChar_x-6, gameChar_y-1, gameChar_x, gameChar_y-1);//Left Foot
        line(gameChar_x+6, gameChar_y-1, gameChar_x+13, gameChar_y-1);//Right Foot
        pop();

        //The Antennae
        push();
        stroke(0);
        line(gameChar_x-4, gameChar_y-57, gameChar_x-17, gameChar_y-65);//More Left
        line(gameChar_x-4, gameChar_y-57, gameChar_x-10, gameChar_y-69);//Slight Left
        fill(238, 130, 238);
        ellipse(gameChar_x-17, gameChar_y-66, 5, 5);//More Left 
        ellipse(gameChar_x-9, gameChar_y-69, 5, 5);//Slight Left
        pop();
    

	}
	else if(isFalling || isPlummeting)
	{
        //The Face of the Character
        push();
        stroke(0);
        fill(255, 255, 0);
        ellipse(gameChar_x, gameChar_y-40, 35, 35);
        stroke(255, 182, 193); //Colour of the lips
        pop();
        //The Mouth
        push();
        fill(250, 218, 221);
        ellipse(gameChar_x, gameChar_y-38, 20, 15);
        stroke(0);
        line(gameChar_x-9, gameChar_y-38, gameChar_x+9, gameChar_y-38);
        pop();
        //The Eyes
        push();
        fill(0);
        ellipse(gameChar_x+7, gameChar_y-50, 5, 3);//Right
        ellipse(gameChar_x-7, gameChar_y-50, 5, 3);//Left
        pop();
        //The legs
        push();
        stroke(0);
        line(gameChar_x-6, gameChar_y-23, gameChar_x-6, gameChar_y-5);//Left
        line(gameChar_x+6, gameChar_y-23, gameChar_x+6, gameChar_y-5);//Right
        pop();

        //The Antennas 
        push();
        stroke(0);
        line(gameChar_x-4, gameChar_y-58, gameChar_x-10, gameChar_y-65);//Left
        line(gameChar_x+4, gameChar_y-58, gameChar_x+10, gameChar_y-65);//Right
        fill(255, 0, 0);
        ellipse(gameChar_x-10, gameChar_y-65, 5, 5);//Left
        ellipse(gameChar_x+10, gameChar_y-65, 5, 5);//Right
        pop();

        //Arms
        push();
        stroke(0);
        line(gameChar_x-18, gameChar_y-36, gameChar_x-23, gameChar_y-50);//Left Arm
        line(gameChar_x+18, gameChar_y-36, gameChar_x+23, gameChar_y-50);//Right Arm
        pop();
    }
	else
	{
        //The Face of the Character
        push();
        stroke(0);
        fill(255, 255, 0);
        ellipse(gameChar_x, gameChar_y-35, 35, 35);
        stroke(255, 182, 193); //Colour of the lips
        pop();
        //The Mouth
        push();
        fill(255);
        ellipse(gameChar_x, gameChar_y-33, 26, 10);
        stroke(0);
        line(gameChar_x-12, gameChar_y-33, gameChar_x+12, gameChar_y-33);
        pop();
        //The Eyes
        push();
        fill(0);
        ellipse(gameChar_x+7, gameChar_y-45, 5, 5);//Right
        ellipse(gameChar_x-7, gameChar_y-45, 5, 5);//Left
        pop();
        //The legs
        push();
        stroke(0);
        line(gameChar_x-6, gameChar_y-18, gameChar_x-6, gameChar_y);//Left Leg
        line(gameChar_x+6, gameChar_y-18, gameChar_x+6, gameChar_y);//Right Leg
        pop();

        //The Antennas 
        push();
        stroke(0);
        line(gameChar_x-6, gameChar_y-53, gameChar_x-6, gameChar_y-64);//Left
        line(gameChar_x+6, gameChar_y-53, gameChar_x+6, gameChar_y-64);//Right
        fill(238, 130, 238);
        ellipse(gameChar_x-6, gameChar_y-64, 5, 5);//Left 
        ellipse(gameChar_x+6, gameChar_y-64, 5, 5);//Right
        pop();

        //Arms
        stroke(0);
        line(gameChar_x-18, gameChar_y-36, gameChar_x-18, gameChar_y-20);//Left Arm
        line(gameChar_x+18, gameChar_y-36, gameChar_x+18, gameChar_y-20);//Right Arm
    }
}

//4.2 The Enemy
function Enemy(x, y, range)
{
    this.x = x;
    this.y = y;
    this.range = range;
    this.current_x = x;
    this.incr = 1;
    
    this.draw = function()
    {
        //Making the Enemy's face
        push();
        fill(0, 0, 220);
        noStroke();
        rect(this.current_x, this.y, -30, -20);
        ellipse(this.current_x-15, this.y-20, 30);
        pop();
        //The enemy's eyes and face
        push();
        fill(0);
        noStroke();
        ellipse(this.current_x-20, this.y-25, 5);
        ellipse(this.current_x-10, this.y-25, 5);
        pop();
        push();
        stroke(255);
        noFill();
        line(this.current_x-25, this.y-10, 
             this.current_x-20, this.y-15);
        line(this.current_x-20, this.y-15, 
             this.current_x-15, this.y-10);
        line(this.current_x-15, this.y-10, 
             this.current_x-10, this.y-15);
        line(this.current_x-10, this.y-15, 
             this.current_x-5, this.y-10);
        pop();
    }
    
    this.update = function()
    {
        this.current_x += this.incr;
        
        if(gameChar_world_x < -3000)
        {
            this.current_x+=10;
            this.range = 20000;
        }
        if(this.current_x < this.x)
        {
            this.incr = 1;
        }
        else if(this.current_x > this.x + this.range)
        {
            this.incr = -1;
        }
    }
    this.hasCollided = function(gameCharacter_x, gameCharacter_y)
    {
        let d = dist(gameCharacter_x, gameCharacter_y, this.current_x, this.y);
        
        if(d<15)
        {
            return true;
        }
        
        return false;
    }
}

//------------------5. Drawing Game Environment--------------------

//5.1 Clouds
function drawClouds()
{
    //Clouds
    noStroke();
    fill(255);
    for(let i = 0; i<clouds.length; i++)
    {
        clouds[i].x += random();

        ellipse(clouds[i].x * clouds[i].scale, 
                clouds[i].y, 
                clouds[i].scale * 50, 
                clouds[i].scale * 50); //End of the cloud's middle part
        ellipse((clouds[i].x + 25) * clouds[i].scale, 
                clouds[i].y, 
                clouds[i].scale * 30, 
                clouds[i].scale * 30); //The cloud's right part
        ellipse((clouds[i].x - 25)  * clouds[i].scale, 
                clouds[i].y, 
                clouds[i].scale * 30, 
                clouds[i].scale * 30); //The cloud's left part
    }
}

//5.2 Mountains
function drawMountains()
{
        
    for(let i = 0; i<mountains.length; i++)
    {
        // Big mountain
        noStroke();
        fill(165, 42, 42); // Brown colour of the mountains
        triangle(mountains[i].x+81 * mountains[i].scale, 
                 mountains[i].y-2 * mountains[i].scale, 
                 mountains[i].x-80 * mountains[i].scale, 
                 mountains[i].y, 
                 mountains[i].x, 
                 mountains[i].y-254 * mountains[i].scale);
        //The Snowy top
        fill(255);
        triangle(mountains[i].x, 
                 mountains[i].y-254 * mountains[i].scale, 
                 mountains[i].x-22 * mountains[i].scale, 
                 mountains[i].y-185 * mountains[i].scale, 
                 mountains[i].x+20 * mountains[i].scale, 
                 mountains[i].y-196 * mountains[i].scale);
        
        //Small Mountain 1st
        noStroke();
        fill(233, 214, 107); // Arylide Yellow colour of the mountain
        triangle(mountains[i].x-80 * mountains[i].scale, 
                 mountains[i].y, 
                 mountains[i].x-181 * mountains[i].scale, 
                 mountains[i].y, 
                 mountains[i].x-133 * mountains[i].scale, 
                 mountains[i].y-119 * mountains[i].scale);

        // Small mountain 2nd
        noStroke();
        fill(233, 214, 107); // Arylide Yellow of the mountain
        triangle(mountains[i].x+182 * mountains[i].scale, 
                 mountains[i].y-2 * mountains[i].scale, 
                 mountains[i].x+81 * mountains[i].scale, 
                 mountains[i].y-2 * mountains[i].scale, 
                 mountains[i].x+131 * mountains[i].scale, 
                 mountains[i].y-119 * mountains[i].scale);
    }
}

//5.3 Trees
function drawTrees()
{        
    for(let i = 0; i<trees_x.length; i++)
    {
        noStroke();
        fill(165, 42, 42); //Colour of the Tree's bark
        rect(
            trees_x[i]-25 * tree.scale, 
            tree.y-3  * tree.scale, 
            50 * tree.scale, 
            -71 * tree.scale); //The Bark 
        fill(0, 128, 0); // Colour of the leaves
        ellipse(
            trees_x[i], 
            tree.y-106  * tree.scale, 
            120 * tree.scale, 
            130 * tree.scale); // The leaves

        //For the Frost Crack on the bark
        push();
        stroke(65, 43, 21);
        strokeWeight(4);
        line(
            trees_x[i]-8 * tree.scale, 
            tree.y-38 * tree.scale, 
            trees_x[i]-8 * tree.scale, 
            tree.y-15 * tree.scale);
        line(
            trees_x[i]+11 * tree.scale, 
            tree.y-35 * tree.scale, 
            trees_x[i]+11 * tree.scale, 
            tree.y-5 * tree.scale);
        pop();
    }
}

//5.4 Canyons
function drawCanyon(t_canyon)
{
    noStroke();
    fill(255, 0, 0); 
    rect(t_canyon.x, 
         t_canyon.y-145, 
         t_canyon.width+30, 
         145);
    fill(255, 165, 0); 
    triangle(t_canyon.x,
             t_canyon.y,
             t_canyon.x+65,
             t_canyon.y,
             t_canyon.x+32.5,
             t_canyon.y-46);
    triangle(t_canyon.x+65,
             t_canyon.y,
             t_canyon.x+130,
             t_canyon.y,
             t_canyon.x+97.5,
             t_canyon.y-46);
}

//5.5 Sun
function drawSun(t_sun)
{
    noStroke();
    fill(255, 255, 0); // Yellow Colour
    ellipse(t_sun.x, 
            t_sun.y, 
            100 * t_sun.scale, 
            100 * t_sun.scale);
}

//5.6 Rings
function drawRing(t_ring)
{
    //The ring
    push();
    strokeWeight(3);
    fill(135, 206, 235, 0);
    stroke(192, 192, 192); // Silver colour for the ring
    ellipse(t_ring.x, 
            t_ring.y, 
            25 * t_ring.scale, 
            25 * t_ring.scale);
    pop();

    push();
    stroke(217, 235, 244);
    strokeWeight(4);
    fill(217, 235, 244); //Diamond colour
    // A jewel
    quad(t_ring.x, 
         t_ring.y-11 * t_ring.scale, 
         t_ring.x-10 * t_ring.scale, 
         t_ring.y-28 * t_ring.scale, 
         t_ring.x, 
         t_ring.y-43 * t_ring.scale, 
         t_ring.x+11 * t_ring.scale, 
         t_ring.y-28 * t_ring.scale, 
         t_ring.x * t_ring.scale, 
         t_ring.y-11 * t_ring.scale);
    pop();
}

//5.7 Bags
function drawBag(t_bag)
{
    push();
    // A Shopping Bag
    fill(173, 173, 173); //Gray Colour
    rect(
        t_bag.x, 
        t_bag.y, 
        66 * t_bag.scale, 
        52 * t_bag.scale);
    noFill();
    stroke(165, 42, 42);
    curve(
        t_bag.x+30 * t_bag.scale, 
        t_bag.y+220 * t_bag.scale, 
        t_bag.x+19 * t_bag.scale, 
        t_bag.y+2 * t_bag.scale, 
        t_bag.x+45 * t_bag.scale, 
        t_bag.y+2 * t_bag.scale, 
        t_bag.x+46 * t_bag.scale, 
        t_bag.y+220 * t_bag.scale)
    pop();
}

//5.8 Apples
function drawApple(t_apple)
{
    // An Apple
    fill(255, 0, 0);
    ellipse(t_apple.x, 
            t_apple.y, 
            26 * t_apple.scale, 
            24 * t_apple.scale);
    //The line on top of it
    push();
    stroke(2);
    fill(0, 255, 0);
    line(t_apple.x+2 * t_apple.scale,
         t_apple.y-9 * t_apple.scale, 
         t_apple.x+8 * t_apple.scale, 
         t_apple.y-25 * t_apple.scale);
    pop();
}

//5.9 Flagpole
function drawFlagpole(x, y, length, height)
{
    let p = 
    {
        x: x,
        y: y,
        length: length,
        height: height,
        draw: function()
        {
            noStroke();
            fill(0, 100, 100);
            rect(this.x, this.y, this.length, this.height);
            for(let i = 0; i < flagpole.length; i++)
            {
                if(flagpole[i].hasReached(gameChar_world_x, gameChar_y) == true)
                {
                    fill(0, 0, 255);
                    triangle(this.x, this.y-170,
                            this.x-30, this.y-150,
                            this.x, this.y-130);
                }
                else
                {
                    fill(255, 0, 0);
                    triangle(this.x, this.y-170,
                            this.x-30, this.y-150,
                            this.x, this.y-130);
                }
            }
        },
        
        hasReached: function(gameCharacter_x, gameCharacter_y)
        {
            let d = dist(gameCharacter_x, gameCharacter_y, this.x, this.y-40);
            if(d < 80)
            {
                return true;
            }
            return false;
        }
    }
    return p;
}

//5.10 Platforms
function drawPlatform(x, y, length)
{
    let p = 
    {
        x: x,
        y: y,
        length: length,
        height: height,
        draw: function()
        {
            fill(255, 255, 0);
            stroke(0);
            rect(this.x, this.y, this.length, 10);
        },
        
        checkContact: function(gameCharacter_x, gameCharacter_y)
        {
            if(gameCharacter_x > this.x && 
               gameCharacter_x < this.x + this.length)
            {
                let d = this.y - gameCharacter_y;
                if(d >= 0 && d < 5)
                {
                    return true;
                }
            }
            return false;
        }
    }
    
    return p;
}


//-------------6. Check interaction of Game Character with:-----------

//6.1 Canyons
function checkCanyon(t_canyon)
{
    if(gameChar_world_x>t_canyon.x && gameChar_world_x<t_canyon.x + t_canyon.width+30 && gameChar_y==floorPos_y)
    {
        isPlummeting = true;
        dyingSound.play();
    }
}

//6.2 Rings
function checkRing(t_ring)
{
    let d = dist(gameChar_world_x, gameChar_y, t_ring.x, t_ring.y)
    if(d < 20)
    {
        t_ring.isFound = true;
        ringSound.play();
        game_score+=50;
    }     
}

//6.3 Bags
function checkBag(t_bag)
{
    let d = dist(gameChar_world_x, gameChar_y, t_bag.x, t_bag.y);
    if(d<50)
    {
        t_bag.isFound = true;
        bagSound.play();
        game_score+=20;
    }
}

//6.4 Apples
function checkApple(t_apple)
{
    let d = dist(gameChar_world_x, gameChar_y, t_apple.x, t_apple.y);
    if(d<30)
    {
        t_apple.isFound = true;
        appleSound.play();
        game_score+=35;
    }
}

//6.5 Flagpole
function reachedFlagpole()
{
    text('You Won! Press Space to Play Again', 2300, 232);
    isLeft = false;
    isRight = false;
    isPlummeting = false;
}