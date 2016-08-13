package game.shivam.com.agame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class GameCat extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    String level=null;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_cat);

        rg= (RadioGroup) findViewById(R.id.level);
        rg.setOnCheckedChangeListener(this);



    }




    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int idd= i;
        switch (idd){
            case R.id.easy:
                level="easy";
                break;
            case R.id.medium:
                level="medium";
                break;
            case R.id.difficult:
                level="difficult";
                break;
        }
        display("You selected "+level+" level.");
    }

    public void conti(View view){
        if(level==null){
            display("Please select an option");
        }
        else {
            Intent i=null;
            switch (level){
                case "easy":
                    i= new Intent(this, EasyGame.class);
                    break;
                case "medium":
                    i= new Intent(this, MediumGame.class);
                    break;
                case "difficult":
                    i= new Intent(this, NewGame.class);
                    break;
            }
            this.startActivity(i);
        }
    }


    private void display(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
