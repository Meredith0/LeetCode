/**
 * @author : Meredith
 * @date : 2019-09-13 20:00
 * @description :
 */
public class q79_exist {

    //        x-1,y
    // x,y-1   x,y    x,y+1
    //        x+1,y
    private final int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private String word;
    private char[][] board;
    private boolean[][] mark;
    private int row;
    private int col;

    public boolean exist (char[][] board, String word) {
        row = board.length;
        if (row == 0) {
            return false;
        }
        this.word = word;
        this.board = board;
        col = board[0].length;
        mark = new boolean[row][col];//标记是否走过

        //尝试从每一个点出发进行搜索
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs (int i, int j, int start) {
        //递归出口
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }

        //如果当前字母匹配
        if (board[i][j] == word.charAt(start)) {
            mark[i][j] = true;//标记为已遍历
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (validateArea(newX, newY) && !mark[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            //不匹配则回溯
            mark[i][j] = false;
        }
        return false;
    }

    //验证此位置是否溢出
    private boolean validateArea (int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public static void main(String[] args){
        char[][] board = {{'a', 'b'}};
        String word = "ba";
        q79_exist solution = new q79_exist();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);


    }
}
