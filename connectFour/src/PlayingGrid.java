import java.util.Scanner;

public class PlayingGrid {
	char grid[][];
	public PlayingGrid(){
		grid = new char[6][6];
		for (int i=0; i<6; i++){
			for (int j=0; j<6; j++){
				grid[i][j] = '-';
			}
		}
	}
	public PlayingGrid(int size){
		grid = new char[size][size];
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				grid[i][j] = '-';
			}
		}
	}
	
	public void playerInput(Player player){
		int slot;
		Scanner input = new Scanner( System.in );
		boolean place = false;
		while (!place){
			System.out.println("Player " + player.type +", enter a number between 1 and " + grid.length + " drop a piece in that slot.");
			slot = input.nextInt();
			System.out.println("Dropping a piece in slot " + slot + "...");
			place = placePiece(player, slot-1);
			if (!place){
				System.out.println("there's no more room there!");
			}
		}
		input.close();
	}
	
	public boolean placePiece(Player player, int slot){
		char t = player.type;
		int i = 0;
		while (i < grid.length-1 && grid[i][slot] == '-'){
			i++;
		}
		System.out.println(i);
		if (i == 0){
			return false;
		}
		if (grid[i][slot] == '-'){
			grid[i][slot] = t;
			player.addHint(i, slot);
		}
		else{
			grid[i-1][slot] = t;
			player.addHint(i-1, slot);
		}

		return true;
	}
	
	public boolean checkWin(Player player, int k){
		//System.out.println(player.type + " " + player.hints[k][0] + " " + player.hints[k][1]);
		boolean win;
		win = checkHWin(player.type, player.hints[k][0], player.hints[k][1])
			|| checkVWin(player.type, player.hints[k][0], player.hints[k][1])
			|| checkD1Win(player.type, player.hints[k][0], player.hints[k][1])
			|| checkD2Win(player.type, player.hints[k][0], player.hints[k][1]);
		System.out.println(player.type + " piece at " + player.hints[k][0] + " " + player.hints[k][1] + " " + win);
		return win;
	}
	
	public boolean checkHWin(char t, int i, int j){
		boolean win = false;
		int count = 0;
		while (j<grid.length && grid[i][j] == t){
			count++;
			if (count == 4){
				win = true;
				break;
			}
			j++;
		}
		return win;
	}
	
	public boolean checkVWin(char t, int i, int j){
		boolean win = false;
		int count = 0;
		while (i >=0 && grid[i][j] == t){
			count++;
			if (count == 4){
				win = true;
				break;
			}
			i--;
		}
		return win;
	}
	
	public boolean checkD1Win(char t, int i, int j){
		boolean win = false;
		int count = 0;
		while (i >=0 && j <grid.length && grid[i][j] == t){
			count++;
			if (count == 4){
				win = true;
				break;
			}
			i--;
			j++;
		}
		return win;
	}
	
	public boolean checkD2Win(char t, int i, int j){
		boolean win = false;
		int count = 0;
		while (i >=0 && j>=0 && grid[i][j] == t){
			count++;
			if (count == 4){
				win = true;
				break;
			}
			i--;
			j--;
		}
		return win;
	}
	
	public void printGrid(){
		for (int i = 0; i < grid.length; i++){
			for (int j=0; j < grid.length; j++){
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}
