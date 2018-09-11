
public class Player {
	//enum PlayerType { x, y };
	//PlayerType type;
	char type;
	int hintIndex;
	int hints[][];
	public Player(char t){
		type = t;
		hints = new int[25][2];
		hintIndex = 0;
	}
	void addHint(int i, int j){
		hints[hintIndex][0] = i;
		hints[hintIndex][1] = j;
		hintIndex++;
	}
	int getHintIndex(){
		return hintIndex;
	}
}
