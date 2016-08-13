package game.shivam.com.agame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Winner extends AppCompatActivity {

    TextView tv;
    String which,who;
    int turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        tv= (TextView) findViewById(R.id.tv);

        Intent i= this.getIntent();
        which= i.getStringExtra("which");
        who= i.getStringExtra("who");
        turn= i.getIntExtra("turn",0);

        tv.setText(who+" Won!!");


    }


    public void playAgain(View view){
        try {
            Intent i;
            switch (which) {
                case "easy":
                    i = new Intent(this, EasyGame.class);
                    this.startActivity(i);
                    break;
                case "medium":
                    i = new Intent(this, MediumGame.class);
                    this.startActivity(i);
                    break;
                case "difficult":
                    i = new Intent(this, NewGame.class);
                    this.startActivity(i);
                    break;
            }
        }catch (Exception e){display(which+" ree"+e+"");}
    }

    public void backToMenu(View view){
        Intent i= new Intent(this, MainActivity.class);
        this.startActivity(i);
    }









    private void display(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



}//class END


