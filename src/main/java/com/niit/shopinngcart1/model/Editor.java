package com.niit.shopinngcart1.model;

import java.beans.PropertyEditorSupport;

public class Editor extends PropertyEditorSupport
{ 

	public void setAsText(String mobilenumber) throws IllegalArgumentException
	{ 
		if(mobilenumber.contains("+91"))
		{
			
		
		setValue(mobilenumber);
		
		
	}
		else
		{
			mobilenumber=("+91")+mobilenumber;
			
			setValue(mobilenumber);
		}
	}
	


}
