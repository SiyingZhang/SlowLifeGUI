import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;


public class MainPanelTest {
	MainPanel panel;
	private Cell[][] cells;

	//Initialize MainPanel every time with size 15
	@Before
	public void startUp() {
		panel = new MainPanel(15);
	}
	//To test the deletion of convertToInt has no effects on getNumNeighbors
	//Initialize the cell[][] manually as all dead
	//get the number of neighbors for position (3, 4) 
	//The result should be 0
	@Test
	public void testGetNumNeighbors0() throws IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method getNumNeighborsMethod = MainPanel.class.getDeclaredMethod("getNumNeighbors", int.class, int.class);
		getNumNeighborsMethod.setAccessible(true);  //Get access to private method
		
		int returnNum = (int)getNumNeighborsMethod.invoke(panel, 2, 3);
		assertEquals(0, returnNum);
	}

	
	//To test the deletion of convertToInt has no effects on getNumNeighbors
	//Initialize the cell[][] manually: all eight cells around (2, 2) are alive
	//get the number of neighbors for position (2, 2) 
	//The result should be 8
	@Test
	public void testGetNumNeighbors8() throws NoSuchMethodException, SecurityException, 
	IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		cells = new Cell[15][15];
		for(int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				cells[i][j] = new Cell();
				if(i<3 && j<3) {
					cells[i][j].setAlive(true);
				} else {
					cells[i][j].setAlive(false);
				}
			}
		}
		
		panel.setCells(cells);
		
		Method getNumNeighborsMethod = MainPanel.class.getDeclaredMethod("getNumNeighbors", int.class, int.class);
		getNumNeighborsMethod.setAccessible(true);
		
		int returnNum = (int)getNumNeighborsMethod.invoke(panel, 1, 1);
		assertEquals(8, returnNum);
	}
	
	//To test the deletion of convertToInt has no effects on getNumNeighbors
	//Initialize the cell[][] manually: all cells with even index are alive
	//get the number of neighbors for position (2, 2) 
	//The result should be 4
	@Test
	public void testGetNumNeighbors() throws NoSuchMethodException, SecurityException, 
	IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		cells = new Cell[15][15];
		for(int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				cells[i][j] = new Cell();
				if(i%2 == 0 && j%2 == 0) {
					cells[i][j].setAlive(true);
				} else {
					cells[i][j].setAlive(false);
				}
			}
		}
		
		panel.setCells(cells);
		
		Method getNumNeighborsMethod = MainPanel.class.getDeclaredMethod("getNumNeighbors", int.class, int.class);
		getNumNeighborsMethod.setAccessible(true);
		
		int returnNum = (int)getNumNeighborsMethod.invoke(panel, 1, 1);
		assertEquals(4, returnNum);
	}

}
