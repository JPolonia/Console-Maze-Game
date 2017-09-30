package application;


public class GameScreen {

	private int width, height;
	private char[][] screenMatrix;

	public GameScreen(int width, int height,char[][] screenMatrix) {
		this.width = width;
		this.height = height;
		this.screenMatrix = screenMatrix;
	}

	// Fill array with dots
	public void InitScreen() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				this.screenMatrix[i][j] = '.';
			}
		}
	}

	// Print the screen to console
	public void PrintScreen() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				System.out.print(this.screenMatrix[i][j]+ " ");
			}
			System.out.println();
		}
	}

	//Screen clear location
	public void ClearScreenLocation(int x, int y) {
		this.screenMatrix[y][x] = '.';
	}

	// Getters
	public int getScreenWidth() {
		return this.width;
	}

	public int getScreenHeight() {
		return this.height;
	}

	public char getObjectOnLocation(int x, int y) {
		return this.screenMatrix[y][x];
	}
	
	public boolean locationIsValid(int x, int y) {
		//Check if there is already an object
		if (this.screenMatrix[y][x] != ' ') return false;
		
		//Check if it is near Dragon
		if (this.screenMatrix[y][x-1] == 'D') return false;
		if (this.screenMatrix[y][x+1] == 'D') return false;
		if (this.screenMatrix[y+1][x] == 'D') return false;
		if (this.screenMatrix[y-1][x] == 'D') return false;
		
		return true;
	}

	// Setters
	public void setObjectOnLocation(GameObject object, int x, int y) {
		this.screenMatrix[y][x] = object.getSymbol();
	}
}
