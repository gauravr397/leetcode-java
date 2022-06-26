package validSodoku;

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        int SIZE = 9;

        HashSet<Character>[] rowSets = new HashSet[SIZE];
        HashSet<Character>[] colSets = new HashSet[SIZE];
        HashSet<Character>[] boxSets = new HashSet[SIZE];


        for (int i=0; i<SIZE; i++){
            rowSets[i] = new HashSet<Character>();
            colSets[i] = new HashSet<Character>();
            boxSets[i] = new HashSet<Character>();
        }

        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){

                char currChar = board[i][j];
                if (currChar == '.') continue;

                if(rowSets[i].contains(currChar)) return false;
                rowSets[i].add(currChar);

                if (colSets[j].contains(currChar)) return false;
                colSets[j].add(currChar);

                int boxIndex =  i/3 * 3 + j/3;
                if (boxSets[boxIndex].contains(currChar)) return false;
                boxSets[boxIndex].add(currChar);


            }
        }
        return true;
    }
}