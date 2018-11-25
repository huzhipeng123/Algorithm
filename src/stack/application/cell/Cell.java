package stack.application.cell;

import stack.Stack;
import stack.impl.StackSLinked;

public class Cell {
	/**
	 * 单元所在行
	 */
	int x = 0;
	/**
	 * 单元所在列
	 */
	int y = 0;
	
	/**
	 * 是否访问过
	 */
	boolean visited = false;

	/**
	 * 	是墙('1')、可通路('0')或起点到终点的路径('*')
	 */
	char c = '1';
	public Cell(int x, int y, char c, boolean visited) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.visited = visited;
	}
	
	public void mazeExit(char[][] maze, int sx, int sy, int ex, int ey) {
		//创建迷宫
		Cell[][] cells = createMaze(maze);
		
		//打印迷宫
		printMaze(cells);
		
		//构造堆栈
		Stack s = new StackSLinked();
		
		//起点
		Cell startCell = cells[sx][sy];
		
		//终点
		Cell endCell = cells[ex][ey];
		
		//起点入栈
		s.push(startCell);
		
		//标记起点已被访问
		startCell.visited = true;
	
		while(!s.isEmpty()) {
			Cell current = (Cell)s.peek();
			//路径找到
			if(current == endCell) {
				while(!s.isEmpty()) {
					//沿路返回将路径上的单元设为*
					Cell cell = (Cell)s.pop();
					cell.c = '*';
					/*
					 * 堆栈中与cell相邻的单元才是路径的组成部分，除此之外，
					 * 堆栈中还有记录下来但是未继续向下探索的单元，
					 * 这些单元直接出栈
					 */
					while(!s.isEmpty() && !isAdjoinCell((Cell)s.peek(), cell)) {
						s.pop();
					}
				}
				System.out.println("找到从起点到终点的路径。");
				printMaze(cells);
				return;
			}else {					//如果当前位置不是终点
				int x = current.x;
				int y = current.y;
				int count = 0;
				//向下
				if(isVaildWayCell(cells[x+1][y])) {
					s.push(cells[x+1][y]);
					cells[x+1][y].visited = true;
					count++;
				}
				//向右
				if(isVaildWayCell(cells[x][y+1])) {
					s.push(cells[x][y+1]);
					cells[x][y+1].visited = true;
					count++;
				}
				//向上
				if(isVaildWayCell(cells[x-1][y])) {
					s.push(cells[x-1][y]);
					cells[x-1][y].visited = true;
					count++;
				}
				//向左
				if(isVaildWayCell(cells[x][y-1])) {
					s.push(cells[x][y-1]);
					cells[x][y-1].visited = true;
					count++;
				}
				//如果是死点，出栈
				if(count == 0) {
					s.pop();
				}
			}
		}
		System.out.println("没有从起点到终点的路径。");
	}

	/**
	 * 判断cell是否是路且未走过
	 * @param cell
	 * @return
	 */
	private boolean isVaildWayCell(Cell cell) {
		return cell.c == '0' && !cell.visited;
	}

	/**
	 * 判断cell1是否与cell2相邻
	 * @param cell1
	 * @param cell2
	 * @return
	 */
	private boolean isAdjoinCell(Cell cell1, Cell cell2) {
		if(cell1.x == cell2.x && Math.abs(cell1.y - cell2.y) < 2) {
			return true;
		}
		if(cell1.y == cell2.y && Math.abs(cell1.x - cell2.x) < 2) {
			return true;
		}
		return false;
	}

	/**
	 * 打印迷宫
	 * @param cells
	 */
	private void printMaze(Cell[][] cells) {
		
	}

	/**
	 * 创建迷宫
	 * @param maze
	 * @return
	 */
	private Cell[][] createMaze(char[][] maze) {
		Cell[][] cells = new Cell[maze.length][];
		for(int x = 0; x < maze.length; x++) {
			char[] row = maze[x];
			cells[x]  = new Cell[row.length];
			for(int y = 0; y < row.length; y++) {
				cells[x][y] = new Cell(x, y, maze[x][y], false);
			}
		}
		return cells;
	}
	
	
	
}

