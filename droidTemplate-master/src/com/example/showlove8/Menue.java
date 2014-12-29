package com.example.showlove8;

//before we statrted activity with an intent 
//here we learn a new way of doing it. 

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//instead of importing Activity we do ListAc..
public class Menue extends ListActivity{
	
	String classes[] = { "StartingPoint", "" }; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//instead of saying setContentView: String is the type: classes is our string array 
		//the middle param and..list_1 is an in  just like our textView is refert to as an int that just how android does it
		//each list item is one position within our string array
		setListAdapter(new ArrayAdapter<String>(Menue.this, android.R.layout.simple_list_item_1, classes)); //array adapter takes paramaters and makes it adapter 
		
	}
	
	@Override	//l= which Listview is clicked, v = which view ..most used position = position of string array 
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String sPosition = classes[position]; // we will have a string with the possition clicked 
		Class ourClass;
		try {
			ourClass = Class.forName("com.example.showlove8." + sPosition);
			Intent ourIntent = new Intent(Menue.this, ourClass); //before "com.example.showlove8.SPLASH"
			startActivity(ourIntent); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //references the package name as a path to our class

	}



	
	
}







