// Global variables that will store the toolbox colour palette
// and the helper functions.
var toolbox = null;
var colourP = null;
var helpers = null;
let c; // For canvas' object
let d; // For Pixel Density
let img; // For Load image
let button; //For Load Image
let colorPicker; //For Colour Wheel

function setup() {
	//create a canvas to fill the content div from index.html
	canvasContainer = select('#content');
	c = createCanvas(canvasContainer.size().width, canvasContainer.size().height);
	d = pixelDensity();
	c.parent("content");
	//Creating a Colour Picker button
	colorPicker = createColorPicker('#000000');
	colorPicker.position(60, 700);

	//create helper functions and the colour palette
	helpers = new HelperFunctions();

	//create a toolbox for storing the tools
	toolbox = new Toolbox();

	toolboxes();

	background(255);

	//Creating a file input for my loadImage button
	button = createFileInput(handleFile);
	button.position(325, 7);
}


function toolboxes() {
	//add the tools to the toolbox.
	toolbox.addTool(new FreehandTool());
	toolbox.addTool(new LineToTool());
	toolbox.addTool(new SprayCanTool());
	toolbox.addTool(new MirrorDrawTool());

	toolbox.addTool(new RectangleDrawTool());
	toolbox.addTool(new EllipseDrawTool());
	toolbox.addTool(new ErasingTool());
	toolbox.addTool(new StarTrail());
	toolbox.addTool(new Vertices());
	toolbox.addTool(new FloodFill());
	toolbox.addTool(new BlurTool());
}

function draw() {
	//call the draw function from the selected tool.
	//hasOwnProperty is a javascript function that tests
	//if an object contains a particular method or property
	//if there isn't a draw method the app will alert the user
	if (toolbox.selectedTool.hasOwnProperty("draw")) {
		toolbox.selectedTool.draw();
	} else {
		alert("it doesn't look like your tool has a draw method!");
	}

	//For loadImage
	if(img) {
		push();
		translate(0,0,-2);
		image(img, 0, 0, width, height);
		pop();
	}

	//Setting the fill and stroke to the colour wheel's pick
	fill(colorPicker.color());
  	stroke(colorPicker.color())
}

//For loadImage
function handleFile(file) {
	if (file.type === 'image') {
	  img = loadImage(file.data);
	//   img.hide();
	} else {
	  img = null;
	}
}