package game.shivam.com.agame;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EasyGame extends AppCompatActivity implements View.OnClickListener{

    int number=6;
    Button a[][]=new Button[number][number];
    int aa[][]=new int[number][number];
    char bb[][]=new char[number][number];
    int turn=0;

    Resources rs;
    int dcol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_game);

        rs= this.getResources();
        dcol= rs.getColor(R.color.blockBack);

        a[0][0]= (Button) findViewById(R.id.a1);
        a[0][1]= (Button) findViewById(R.id.a2);
        a[0][2]= (Button) findViewById(R.id.a3);
        a[0][3]= (Button) findViewById(R.id.a4);
        a[0][4]= (Button) findViewById(R.id.a5);
        a[0][5]= (Button) findViewById(R.id.a6);


        a[1][0]= (Button) findViewById(R.id.b1);
        a[1][1]= (Button) findViewById(R.id.b2);
        a[1][2]= (Button) findViewById(R.id.b3);
        a[1][3]= (Button) findViewById(R.id.b4);
        a[1][4]= (Button) findViewById(R.id.b5);
        a[1][5]= (Button) findViewById(R.id.b6);

        a[2][0]= (Button) findViewById(R.id.c1);
        a[2][1]= (Button) findViewById(R.id.c2);
        a[2][2]= (Button) findViewById(R.id.c3);
        a[2][3]= (Button) findViewById(R.id.c4);
        a[2][4]= (Button) findViewById(R.id.c5);
        a[2][5]= (Button) findViewById(R.id.c6);

        a[3][0]= (Button) findViewById(R.id.d1);
        a[3][1]= (Button) findViewById(R.id.d2);
        a[3][2]= (Button) findViewById(R.id.d3);
        a[3][3]= (Button) findViewById(R.id.d4);
        a[3][4]= (Button) findViewById(R.id.d5);
        a[3][5]= (Button) findViewById(R.id.d6);

        a[4][0]= (Button) findViewById(R.id.e1);
        a[4][1]= (Button) findViewById(R.id.e2);
        a[4][2]= (Button) findViewById(R.id.e3);
        a[4][3]= (Button) findViewById(R.id.e4);
        a[4][4]= (Button) findViewById(R.id.e5);
        a[4][5]= (Button) findViewById(R.id.e6);

        a[5][0]= (Button) findViewById(R.id.f1);
        a[5][1]= (Button) findViewById(R.id.f2);
        a[5][2]= (Button) findViewById(R.id.f3);
        a[5][3]= (Button) findViewById(R.id.f4);
        a[5][4]= (Button) findViewById(R.id.f5);
        a[5][5]= (Button) findViewById(R.id.f6);




        a[0][0].setOnClickListener(this);
        for(int y=0;y<number;y++){
            for(int z=0;z<number;z++){
                a[y][z].setOnClickListener(this);
                aa[y][z]=0;
                bb[y][z]='n';
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mf= this.getMenuInflater();
        mf.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String s=item.getTitle().toString();
        display(s);
        return super.onOptionsItemSelected(item);
    }





    char fsource='g';

    @Override
    public void onClick(View view) {
        Button b= (Button) view;

        for(int i=0;i<number;i++){
            for(int k=0;k<number;k++){
                if(b==a[i][k]){
                    try{
                        turn++;
                        chal(i,k,fsource,false);
                        isWon();
                        fsource=(fsource=='g')?'r':'g';
                    }catch (Exception e){display(e+"");}
                }
            }
        }
    }

    //a=button
    //aa=number
    //bb=char
    //pos= 3(Center), 2(Edge), 1(Corner)

    private void chal(int i,int j,char source,boolean isRec) throws Exception{

        int pos=3;
        if((i==0&&j==0)||(i==number-1&&j==number-1)||(i==0&&j==number-1)||(i==number-1&&j==0)){
            pos=1;
        }
        else if (i==0||i==number-1||j==0||j==number-1){
            pos=2;
        }

        if(!isRec){
            if(bb[i][j]=='n'){
                aa[i][j]=1;
                bb[i][j]=source;
                a[i][j].setText(aa[i][j]+"");
                int bcol= (source=='g')? Color.GREEN:Color.RED;
                a[i][j].setBackgroundColor(bcol);
            }
            else {
                if(bb[i][j]!=source){
                    display("Invalid move");
                    fsource=(fsource=='g')?'r':'g';
                    turn--;
                }
                else {
                    if(aa[i][j]<pos){
                        aa[i][j]+=1;
                        a[i][j].setText(aa[i][j]+"");
                    }
                    else {
                        aa[i][j]=0;
                        bb[i][j]='n';
                        a[i][j].setText("");
                        a[i][j].setBackgroundColor(dcol);
                        try{chal(i-1,j,source,true);}catch (Exception e){}
                        try{chal(i+1,j,source,true);}catch (Exception e){}
                        try{chal(i,j-1,source,true);}catch (Exception e){}
                        try{chal(i,j+1,source,true);}catch (Exception e){}
                    }
                }
            }
        }
        else {//isRes==true
            if(bb[i][j]=='n'){
                aa[i][j]=1;
                bb[i][j]=source;
                a[i][j].setText(aa[i][j]+"");
                int bcol= (source=='g')?Color.GREEN:Color.RED;
                a[i][j].setBackgroundColor(bcol);
            }
            else {
                bb[i][j]=source;
                if(aa[i][j]<pos){
                    aa[i][j]+=1;
                    a[i][j].setText(aa[i][j]+"");
                    int bcol=(source=='g')?Color.GREEN:Color.RED;
                    a[i][j].setBackgroundColor(bcol);
                }
                else {
                    aa[i][j]=0;
                    bb[i][j]='n';
                    a[i][j].setText("");
                    a[i][j].setBackgroundColor(dcol);
                    try{chal(i-1,j,source,true);}catch (Exception e){}
                    try{chal(i+1,j,source,true);}catch (Exception e){}
                    try{chal(i,j-1,source,true);}catch (Exception e){}
                    try{chal(i,j+1,source,true);}catch (Exception e){}
                }
            }
        }



    }//chal END



    private void isWon(){
        boolean gWon=true;
        boolean rWon=true;
        if(turn>2){
            for(int i=0;i<number;i++) {
                for (int k = 0; k < number; k++) {
                    if (bb[i][k] == 'r') {
                        gWon = false;
                    } else if (bb[i][k] == 'g') {
                        rWon = false;
                    }
                }
            }
            if(gWon){
                display("Green Won");
                Intent i= new Intent(this, Winner.class);
                i.putExtra("who","green");
                i.putExtra("turn",turn);
                this.startActivity(i);
            }
            else if(rWon){
                display("Red Won");
                Intent i= new Intent(this, Winner.class);
                i.putExtra("which","easy");
                i.putExtra("who","red");
                i.putExtra("turn",turn);
                this.startActivity(i);
            }
        }
    }//isWon END


    private void display(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}//class END
