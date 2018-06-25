
/* This version of the script has no way to stop the animation once it starts. */
  /** Start the animation of a given named object **/
function startObj(id) {
     document.animObj[id].start();
}

function startAll() {
	for (objId in document.animObj) {
		startObj(objId);
	}
}

function stop(id) {
	document.animObj[id].stop();
}

function stopAll(id){
	for (objId in document.animObj) {
		stop(objId);
	}
}


/* Function to get an element from its name **/
function getElement(elementName) {
    var element = document.getElementById(elementName);
    return element;
}

function getLeft(objID) {
	return parseInt( getElement(objID).style.left );
}

function getTop(objID) {
	return parseInt( getElement(objID).style.top );
}

/* Function to move an object by a given number of pixels **/
function moveObj(objID, dx, dy ) {
    var obj = getElement(objID);

    // Style elements are always Strings (unfortunately).
    var newLeft = parseInt(obj.style.left) + dx;
    var newTop = parseInt(obj.style.top) + dy;

    // update the style properties (with the appropriate units)
    obj.style.left = newLeft;
    obj.style.top = newTop;
}


/* This is really a "class" so we can build animator "objects".  The structure
 * of this animator function is almost IDENTICAL to the "rectangle" example. */
function animator(objID, dx, dy, delay) {
	
    var animator = this;
	animator.bAnimating = false;
	
	animator.maxSize = 500;
	
	animator.revX = function() {
		dx *= -1;
	}
	
	
    // Start the animator       
    animator.start = function(direction) {
		animator.bAnimating = true;
        animator.animate(direction);
    };
	
	
	// Stop the animator       
    animator.stop = function() {
		animator.bAnimating = false;
    };
	


    // Upon googling this seemed like the "cleanest" code to control objects 
    animator.animate = function(direction) {
		
		if (animator.bAnimating) {
			
			switch(direction) {
				case "left":
					if(getLeft(objID) === 0) 
						direction = "right";
					 else
						moveObj(objID, -1, 0);
					break;
				case "right":
					if(getLeft(objID) === animator.maxSize)
						direction = "left";
					else
						moveObj(objID, 1, 0);
					break;
				case "up":
					if (getTop (objID) === 0)
						direction = "down";
					else
						moveObj(objID, 0, -1);
					break;
				case "down":
					if (getTop (objID)== animator.maxSize)
						direction = "up";
					else
						moveObj(objID, 0, 1);
					break;
			}
			
          setTimeout(function() {
			animator.animate(direction)
		  }, delay)
		}
    };
}
