package com.example.appmathquiz;

import java.util.Random;




import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class game extends Activity implements OnClickListener {

	private int total, score,n,flag=0;
	private int function;
//	private String operator;
	private Random rand=new Random();
	private TextView R1;
	private TextView R2;
	private String operation="+";
	private TextView tv, errorcode,operator;
	private Button btn1, btn2,btn3;

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.game);

	        tv = (TextView) findViewById(R.id.textView6);
	        operator=(TextView) findViewById(R.id.textView3);
	        total=getIntent().getExtras().getInt("total");
	        score=getIntent().getExtras().getInt("score");
	        operation=getIntent().getExtras().getString("operation");
			tv.setText(Integer.toString(score) + " / " + Integer.toString(total));
			
			
			R1 = (TextView) findViewById(R.id.textView2);
			R2 = (TextView) findViewById(R.id.textView7);
			
			errorcode = (TextView) findViewById(R.id.textView5);
			
			btn1 = (Button) findViewById(R.id.button1);
			btn1.setOnClickListener(this);
			btn2 = (Button) findViewById(R.id.button2);
			btn2.setOnClickListener(this);
			btn3 = (Button) findViewById(R.id.button3);
			btn3.setOnClickListener(this);
			
			//1st random value
			int rand1 =rand.nextInt(9)+1;
			R1.setText(Integer.toString(rand1));

			//2nd random value
			int rand2 =rand.nextInt(9)+1;
			R2.setText(Integer.toString(rand2));
			
			//sum of the random values generated
//			function = rand1 + rand2;
			
			//generate a random number to select a button from 3
			n=rand.nextInt(3)+1;
			
			switch(operation)
			{
			case "+":
						operator.setText("+");
						function = rand1 + rand2;
			break;
			case "-":
						operator.setText("-");
						function=rand1 - rand2;
			break;
			case "*":
						operator.setText("*");
						function=rand1 * rand2;
			break;
		    case "/":
		    			operator.setText("/");
					    function=rand1 / rand2;
		    break;

			}
			
			//random values for all 3 buttons with only 1 correct answer
			if (n==1)
			{
				
				int randbtn2 =rand.nextInt(9)+1;
				int randbtn3 =rand.nextInt(9)+1;
				
				if(function==randbtn2)
				{
					randbtn2++;
				}
				if(function==randbtn3)
				{

					randbtn3++;
				}
				if(randbtn2==randbtn3)
				{
					randbtn3++;
				}
				btn1.setText(Integer.toString(function));
				btn2.setText(Integer.toString(randbtn2));
				btn3.setText(Integer.toString(randbtn3));
				
			}				
			if (n==2)
			{
				
				int randbtn1 =rand.nextInt(9)+1;
				int randbtn3 =rand.nextInt(9)+1;
						
				if(function==randbtn1)
				{
					randbtn1++;
				}
				if(function==randbtn3)
				{

					randbtn3++;
				}
				if(randbtn1==randbtn3)
				{
					randbtn3++;
				}
				btn1.setText(Integer.toString(randbtn1));			
				btn2.setText(Integer.toString(function));			
				btn3.setText(Integer.toString(randbtn3));
			}
			if(n==3)
			{

				int randbtn1 =rand.nextInt(9)+1;
				int randbtn2 =rand.nextInt(9)+1;
		
				if(function==randbtn1)
				{
					randbtn1++;
				}
				if(function==randbtn2)
				{

					randbtn2++;
				}
				if(randbtn1==randbtn2)
				{
					randbtn2++;
				}
				btn1.setText(Integer.toString(randbtn1));
				btn2.setText(Integer.toString(randbtn2));
				btn3.setText(Integer.toString(function));
			}
			
			

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
public void onClick(View v) {
   

	switch(n) {
	
	case 1: 
		
		switch (v.getId()){
		case R.id.button1:
			errorcode.setText("correct");
//			Toast.makeText(this, "button 1 is correct", Toast.LENGTH_SHORT).show();
			newGame();
			break;
		case R.id.button2:
//			Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
			btn2.setBackgroundColor(Color.RED);
			errorcode.setText("incorrect \n try again");
			flag=1;
			break;
		case R.id.button3:
//			Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
			btn3.setBackgroundColor(Color.RED);
			errorcode.setText("incorrect \n try again");
			flag=1;
			break;
			
		}

		break;
	case 2:

		
		switch (v.getId()){
		case R.id.button1:
			btn1.setBackgroundColor(Color.RED);
			errorcode.setText("incorrect \n try again");
			flag=1;
			break;
		case R.id.button2:
			errorcode.setText("correct");
			newGame();
			break;
		case R.id.button3:
			btn3.setBackgroundColor(Color.RED);
			errorcode.setText("incorrect \n try again");
			flag=1;
			break;
		}
		break;
	case 3:

		switch (v.getId()){
		case R.id.button1:
			btn1.setBackgroundColor(Color.RED);
			errorcode.setText("incorrect \n try again");
			flag=1;
			break;
		case R.id.button2:
			btn2.setBackgroundColor(Color.RED);
			errorcode.setText("incorrect \n try again");
			flag=1;
			break;
		case R.id.button3:
			errorcode.setText("correct");
			newGame();
			break;
		}
		break;
		
	}
}

public void newGame()
{
	if(flag==0)
	{
    	Toast.makeText(this, "Next Question", Toast.LENGTH_SHORT).show();
    	Intent i = new Intent(this, game.class);
    	total=total+1;
    	score=score+1;
    	i.putExtra("total", total);
    	i.putExtra("score", score);
    	i.putExtra("operation", operation);
    	startActivity(i);
	}
	else
	{
    	Toast.makeText(this, "Next Question", Toast.LENGTH_SHORT).show();
    	Intent i = new Intent(this, game.class);
    	total=total+1;
    	i.putExtra("total", total);
    	i.putExtra("score", score);
    	i.putExtra("operation", operation);
    	startActivity(i);
    	}		    	
}

public void startOver(View v)
{
	Intent i = new Intent(this,MainActivity.class);
	startActivity(i);
}



public void finish(View v)
{
	Toast.makeText(this, "Back to Main Menu", Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(Intent.ACTION_MAIN);
    intent.addCategory(Intent.CATEGORY_HOME);
    startActivity(intent);
}

@Override
public void onBackPressed()
{

	Intent i = new Intent(this,MainActivity.class);
	startActivity(i);
}
}

