/**
 * 
 */
package com.isesalud.support;

import java.io.Serializable;

@SuppressWarnings("serial")
public final class QueryHint implements Serializable
{
	private final int firstResult;
	private final int maxResults;

	/**
	 */
	public QueryHint(int firstResult, int maxResults)
	{
		this.firstResult = firstResult;
		this.maxResults = maxResults;
	}

	/**
	 */
	public QueryHint()
	{
		this(0, 20);
	}

	/**
	 */
	public final int getFirstResult()
	{
		return firstResult;
	}

	/**
	 */
	public final int getMaxResults()
	{
		return maxResults;
	}
}
