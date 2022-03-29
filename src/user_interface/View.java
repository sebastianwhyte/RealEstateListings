package user_interface;

import javafx.scene.Group;

/*
 * 
 * @author Sebastian Whyte
 * @version 03/22/2022
 *
 */

public abstract class View extends Group
{
	// Instance variables
	private String myClassName;
	
	
	// ---------------------------------------------------------- 
	
	public View(String classname)
	{
		myClassName = classname; 
	}
	
	public abstract void updateState(String key, Object value);

}
