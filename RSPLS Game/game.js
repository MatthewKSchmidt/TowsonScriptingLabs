// An object for storing information about the game
let gameInfo = {};

let winMatrix = { ROCK: ["SCIS", "LZRD"],
				  PAPR: ["SPOK", "ROCK"],
				  SCIS: ["PAPR", "LZRD"],
				  LZRD: ["PAPR", "SPOK"],
				  SPOK: ["SCIS", "ROCK"] };
				  


// All the TOKENS in the game. NOTE: This can be populated "automatically" with a little more code
// (as shown further below), but there is nothing really "wrong" with hard-coding the values twice;
// this just makes the program somewhat more difficult to maintain, since renaming/adding/changing
// game "tokens" must then be handled in multiple locations.
let tokens = ["ROCK","SPOK","PAPR","SCIS","LZRD"];


// Instead of a separate array (as above), this will work in *most* modern Javascript
// implementations to build a list of tokens directly from the winMatrix.
//
// (SEE: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/keys)
//
// let tokens = Object.keys(winMatrix);



// A function to quickly get an HTML (DOM) object from its ID.  (Uses the "Arrow Function" syntax
// only as an illustration of how you can implement short functions in a concise manner.
//
// (SEE: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions)
let get = name => document.getElementById(name);


// Called on "onload" from the document body.
function initGame() {
	var playButons = get("PLAY_BUTTONS");
	playButons.hidden = true;
}

// Called when the user clicks the button which starts the game.
function startGame() {
    var rtp = get("ROUNDS_TO_PLAY");
	var playButons = get("PLAY_BUTTONS");

	playButons.hidden = false;

	gameInfo.rtp = parseInt(rtp.value);
	gameInfo.rRemaning = gameInfo.rtp;
	gameInfo.humanWins = 0;
}


// Called when the user makes a "game token" selection.
function userChoice(buttonObj) {
    // Assign values for easier use later on in the function.
	let humanChoice = buttonObj.id;
	let compChoice = getCompChoice();
	let winner = getWinner(humanChoice, compChoice);

	// TODO: Remove DEBUGGING alert.
    // Using the "back-quote" allows for "BASH like" strings.
    alert(`DEBUGGING:\nYou: ${humanChoice}\nComp: ${compChoice}\nWinner: ${winner}`);


	// Decrement the number of rounds remaining.
    gameInfo.rRemaning--;

    // If no more rounds, then end the game.
	if (gameInfo.rRemaning < 1) {
		get("PLAY_BUTTONS").hidden = true;
       
        //TODO: Handle the end of the game in more sophisticated manner.
        alert("DEBUG: Game Over" + `\n Winner: ${winner}`);
	}
}



// Gets the winner based on the two player choices.
// 0 for tie, 1 for human, -1 for computer.
function getWinner(hChoice, cChoice) {
    // TIE
	
	if (hChoice === cChoice) 
		return alert("Tie Game!");

    // Did the human win or loose?
	let bHumanWinner = winMatrix[hChoice].includes(cChoice);

	if (bHumanWinner) {
		return "Human";
	} else {
		return "Computer";
	}
}


// Get a random token for the computers choice.
function getCompChoice() {
	var tokenNum = getRandomInt(0,5);
	return tokens[tokenNum];
}


// From: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math/random
function getRandomInt(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min)) + min; //The maximum is exclusive and the minimum is inclusive
}

//vim:wm=2:tw=100
