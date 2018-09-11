
public class Game {
	boolean gameOver;
	
	public Game(){
		gameOver = false;
	}
	
	public void play(){
		PlayingGrid Grid = new PlayingGrid();
		Grid.printGrid();
		Player one = new Player('x');
		Player two = new Player('y');
		//ArrayList<Player> listPlayers = new ArrayList<Player>();
		//list.add(one);
		int i = 0;
		while (!gameOver){
			//...
			//i++
			// i = i % lengthOfList;
			//currPlayer = listPlayers[i];
			Grid.playerInput(one);
			int hintI = one.getHintIndex();
			for (int k = 0; k < hintI; k++){
				gameOver = Grid.checkWin(one, k);
				if (gameOver){
					break;
				}
			}
			Grid.printGrid();
			if (gameOver){
				break;
			}
			Grid.playerInput(two);
			hintI = two.getHintIndex();
			for (int k = 0; k < hintI; k++){
				gameOver = Grid.checkWin(two, k);
				if (gameOver){
					break;
				}
			}
			Grid.printGrid();
		}
	}
}
