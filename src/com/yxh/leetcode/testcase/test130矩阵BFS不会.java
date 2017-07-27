package com.yxh.leetcode.testcase;

import java.util.LinkedList;

/*
 * Surrounded Regions leetcode java
题目：

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

题解：
这道题是说一个O周围都是X那么这个O就得变成X。
那么就可以发现四周这一圈如果有O肯定不能四周都被X包围，同时这个O也将会是潜在的内部的O的缺口，
让内部的O不能都被X覆盖。
因此，思路就是先对四周的O进行特殊处理，用BFS走，
把所有这个O连接的O（包括这个O）都涂成#。
这样子，对于原来的棋盘来说，
没有变成#的O就是四周没有被O污染的，
四周都是X，那么对其变成X。
而所有#就是那些原来是O但是不是四周都被X包围的，把它们再还原成O。
 */
public class test130矩阵BFS不会 {
	public static void solve(char[][] board) {
	    if(board==null || board.length<=1 || board[0].length<=1)
	        return;
	    
	    //第一行和最后一行进行fill
	    for(int i=0;i<board[0].length;i++){       //边上才有可能包不上  所以从边上向里传染
	        fill(board,0,i);
	        fill(board,board.length-1,i);
	    }
	    
	    printMatrx(board);
	    System.out.println("----------------------------------");
	    
	    
	    //第一列和最后一列进行fill
	    for(int i=0;i<board.length;i++){          //边上才有可能包不上  所以从边上向里传染
	        fill(board,i,0);
	        fill(board,i,board[0].length-1);
	    }
	    
	    printMatrx(board);
	    System.out.println("----------------------------------");
	    
	    //对于当前格子中，所有O变成X（说明符合要求，没有被变成#),所有#变成O
	    for(int i=0;i<board.length;i++){
	        for(int j=0;j<board[0].length;j++){
	            if(board[i][j]=='O')
	                board[i][j]='X';
	            else if(board[i][j]=='#')
	                board[i][j]='O';                
	        }
	    }
	    
	    printMatrx(board);
	    System.out.println("----------------------------------");
	}

	private static void fill(char[][] board, int i, int j){
	    if(board[i][j]!='O')
	        return;
	    board[i][j] = '#';  
	    //利用BFS
	    LinkedList<Integer> queue = new LinkedList<Integer>();
	    //先将矩阵的横纵坐标编码
	    int code = i*board[0].length+j;   //当前'O' 在矩阵里面的位置   按行算
	    queue.add(code);
	    while(!queue.isEmpty()){    //O都传染成#
	        code = queue.poll();
	        int row = code/board[0].length;//从code中还原横坐标
	        int col = code%board[0].length;//从code中还原纵坐标
	        
	        if(row>=1 && board[row-1][col]=='O'){//当前元素上边是否为0
	            queue.add((row-1)*board[0].length + col);
	            board[row-1][col]='#';
	        }
	        
	        if(row<=board.length-2 && board[row+1][col]=='O'){//当前元素下面是否为0
	            queue.add((row+1)*board[0].length + col);
	            board[row+1][col]='#';
	        }
	        
	        if(col>=1 && board[row][col-1]=='O'){//当前元素左边是否为0
	            queue.add(row*board[0].length + col-1);
	            board[row][col-1]='#';
	        }
	        
	        if(col<=board[0].length-2 && board[row][col+1]=='O'){//当前元素右边是否为0
	            queue.add(row*board[0].length + col+1);
	            board[row][col+1]='#';
	        }            
	    }
	}
	
	static void printMatrx(char[][] board){
		for(int i=0;i<board.length;i++){  //多少行
			System.out.println(board[i]);
			
		}
	}
	
	
	public static void main(String[] args) {
		
		char[][] sample = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
		//printMatrx(sample);
		solve(sample);
	}
}
