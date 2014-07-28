package com.example.appmathquiz;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {

	private String operation="+";
	private int score=0,total=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
 
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
    public void newGame(View v)
    {
    	
    	Toast.makeText(this, "Starting a New Game", Toast.LENGTH_SHORT).show();
    	Intent i = new Intent(this, game.class);
    	i.putExtra("total",total);
    	i.putExtra("score",score);
    	i.putExtra("operation",operation);
    	startActivity(i);
    	
    }
    
    public void instructions(View v)
    {
    	
    	Toast.makeText(this, "Instructions", Toast.LENGTH_SHORT).show();
    	Intent i = new Intent(this, instructions.class);
    	startActivity(i);
    	
    }

    public void finish(View v)
    {
    	
    	Toast.makeText(this, "Closing the game", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
        
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     
        switch(item.getItemId())
        {
        case R.id.add: Toast.makeText(getApplicationContext(), "addition", Toast.LENGTH_SHORT).show();
        operation="+";
        break;
        case R.id.sub: Toast.makeText(getApplicationContext(), "subtraction", Toast.LENGTH_SHORT).show();
        operation="-";
        break;
        case R.id.div: Toast.makeText(getApplicationContext(), "division", Toast.LENGTH_SHORT).show();
        operation="/";
        break;
        case R.id.mul: Toast.makeText(getApplicationContext(), "multiplication", Toast.LENGTH_SHORT).show();
        operation="*";
        break;
    }
		return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void onBackPressed()
    {

    }

}
