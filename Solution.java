import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int noOfGames = scan.nextInt();
        for(int gameNumber = 0 ; gameNumber < noOfGames; gameNumber++) {

            int arraySize = scan.nextInt();
            int jumpSize = scan.nextInt();

            int[] game = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                game[i] = scan.nextInt();
            }

            if(solveGame(game, jumpSize, 0, new int[arraySize])){ //Starting at the 0 position
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        scan.close();
    }


    private static boolean solveGame(int[] game, int jumpSize, int currentPosition, int[] jumpedPositions) {


        if (currentPosition < 0) { // checking for going beyond the first position
            return false;
        }
        else if(jumpedPositions[currentPosition] == 1){ // checking whether the current position has already been jumped / walked to
            return false;
        }
        else if(game[currentPosition] == 1){ // checking whether the current position holds value 1
            return false;
        }
        else if (currentPosition + 1 >= game.length || currentPosition + jumpSize >= game.length) { //checking whether the next walk or jump takes past the length of the array
            return true;
        }

        jumpedPositions[currentPosition] = 1; // maintaining an array to mark already jumped / walked to positions


        if(solveGame(game, jumpSize, currentPosition + jumpSize, jumpedPositions)){
            return true;
        }

        if(solveGame(game, jumpSize, currentPosition + 1, jumpedPositions)){
            return true;
        }

        if(solveGame(game, jumpSize, currentPosition - 1, jumpedPositions)){
            return true;
        }


        return false;

    }
}

