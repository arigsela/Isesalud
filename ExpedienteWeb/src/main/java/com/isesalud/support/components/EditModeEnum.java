/**
 * 
 */
package com.isesalud.support.components;

/**
 * @author Haysoos
 *
 */
public enum EditModeEnum
{
	ADDING,
	EDITING,
	NONE;

	/**
	 */
	public final Boolean getInEditionMode()
	{
		return !this.equals(NONE);
	}
}
