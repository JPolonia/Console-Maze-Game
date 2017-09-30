package application;

//TEst change
public class Hero extends GameObject {

	private boolean hasKey = false;
	private boolean isFree = false;
	
	public Hero(char symbol) {
		setSymbol(symbol);
	}
	
	public void addRandomLocation(GameScreen screen, Hero hero) {
		int x =0,y =0;
		boolean valid = false;
		//check if valid position
		while(!valid){
			//Generate random positions
			x = (int) (Math.random() * (screen.getScreenWidth() - 1));
			y = (int) (Math.random() * (screen.getScreenHeight() - 1));
			//Check if position is valid
			valid = screen.locationIsValid(x,y);
		}
		hero.setX(x);
		hero.setY(y);
		screen.setObjectOnLocation(hero,x,y);
	}
	
	public void moveLeft(GameScreen screen, Hero hero) {
		//CheckifvalidLocation
		hero.setX(getX() - 1);
		screen.setObjectOnLocation(hero, hero.getX(), hero.getY());
		screen.ClearScreenLocation(hero.getX() + 1, hero.getY());
	}
	
	public void moveRight(GameScreen screen, Hero hero) {
		hero.setX(getX() + 1);
		screen.setObjectOnLocation(hero, hero.getX(), hero.getY());
		screen.ClearScreenLocation(hero.getX() - 1, hero.getY());
	}
	
	public void moveUp(GameScreen screen, Hero hero) {
		hero.setY(getY() - 1);
		screen.setObjectOnLocation(hero, hero.getX(), hero.getY());
		screen.ClearScreenLocation(hero.getX(), hero.getY() + 1);
	}
	
	public void moveDown(GameScreen screen, Hero hero) {
		hero.setY(getY() + 1);
		screen.setObjectOnLocation(hero, hero.getX(), hero.getY());
		screen.ClearScreenLocation(hero.getX(), hero.getY() - 1);
	}
}
