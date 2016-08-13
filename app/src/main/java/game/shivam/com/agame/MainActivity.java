package game.shivam.com.agame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void newGame(View view){
        Intent i= new Intent(this, GameCat.class);
        this.startActivity(i);
    }

    public void howToPlay(View view){
        Intent i= new Intent(this, GameCat.class);
        this.startActivity(i);
    }

    public void about(View view){
        Intent i= new Intent(this, NewGame.class);
        this.startActivity(i);
    }


}
