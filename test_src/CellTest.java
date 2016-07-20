import static org.junit.Assert.*;

import java.awt.Font;
import java.awt.event.ActionListener;

import org.junit.Test;


public class CellTest {
	private Cell cell;
	
	//Test constructor - Font
	//The font setting should be same as Font("Courier", Font.PLAIN, 12)
	@Test
	public void testCellFont() {
		cell = new Cell();
		
		cell.getActionListeners().toString();
		Font font = cell.getFont();
		Font fontExp = new Font("Courier", Font.PLAIN, 12);
		
		assertEquals(fontExp, font);
	}

	//Test constructor - ActionListener
	//The ActionListener should be set successfully as CellButtonListener
	@Test
	public void testCellListener() {
		cell = new Cell();
		
		ActionListener listener = cell.getActionListeners()[0];
		String listenerString = listener.toString();
		
		assertTrue(listenerString.contains("CellButtonListener"));
	}
}
