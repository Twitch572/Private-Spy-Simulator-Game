import java.util.Stack;
/**
 * makes a menu
 * the buttons are constant 
 * the tasks will pop off when clicked on, then tasks will be pushed on at certain intervals 
 * @author William
 *
 */
public class Menu {
	private TextBox description;
	private Button[] buttons;
	private Stack<Button> tasks;
	
	public Menu(TextBox description, Button[] buttons, Stack<Button> tasks)
	{
		this.description = description;
		this.buttons = buttons;
		this.tasks = tasks;
	}

}
