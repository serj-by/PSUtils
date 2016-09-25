package com.probosoft.PSUtils;

public class PSVector2D {
	public float x;
	public float y;
	
	public PSVector2D ()
	{
		x = 0;
		y = 0;
	}
	
	public PSVector2D (float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	public static PSVector2D add (PSVector2D v1, PSVector2D v2)
	{
		return new PSVector2D(v1.x+v2.x, v1.y+v2.y);
	}

	public void add (PSVector2D v1)
	{
		this.x += v1.x;
		this.y += v1.y;
	}
}
