package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.math.MathUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText ed_name;
    private TextView tv_text,tv_name,tv_winner,tv_cmora,tv_mmora;
    private RadioButton btn_scissor,btn_stone,btn_paper;
    private Button btn_mora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //連接XML的元件
        ed_name = findViewById(R.id.ed_name);
        tv_text = findViewById(R.id.tv_test);
        tv_name = findViewById(R.id.textView2);
        tv_winner = findViewById(R.id.textView3);
        tv_mmora = findViewById(R.id.textView4);
        tv_cmora = findViewById(R.id.textView5);
        btn_scissor = findViewById(R.id.radioButton3);
        btn_stone = findViewById(R.id.radioButton2);
        btn_paper = findViewById(R.id.radioButton);
        btn_mora = findViewById(R.id.button);
        btn_mora.setOnClickListener(new TextView.OnClickListener(){
            @Override
            public void onClick(View v){
                //判斷字串是否空白
                if(ed_name.length()<1)
                    tv_text.setText("請輸入玩家姓名");
                else{
                    //顯示玩家姓名與我方出拳
                    tv_name.setText(String.format("名字\n%s",ed_name.getText().toString()));
                    if(btn_scissor.isChecked())
                        tv_mmora.setText("我方出拳\n剪刀");
                    else if(btn_stone.isChecked())
                        tv_mmora.setText("我方出拳\n石頭");
                    else
                        tv_mmora.setText("我方出拳\n布");
                    //RAMDOM()產生介於0~1不含1的的亂數,乘3產生0~2當作電腦的出拳
                    int computer = (int)(Math.random()*3);
                    if(computer==0)
                        tv_cmora.setText("電腦出拳\n剪刀");
                    else if(computer==1)
                        tv_cmora.setText("電腦出拳\n石頭");
                    else if(computer==2)
                        tv_cmora.setText("電腦出拳\n布");
                    //用判斷式判斷並顯示結果
                    if((btn_scissor.isChecked()&&computer==2)||(btn_stone.isChecked()&&computer==0)||(btn_paper.isChecked()&&computer==1)){
                        tv_winner.setText("勝利者\n"+ed_name.getText().toString());
                        tv_text.setText("恭喜你獲勝了!!!");}
                    else if ((btn_scissor.isChecked()&&computer==1)||(btn_stone.isChecked()&&computer==2)||(btn_paper.isChecked()&&computer==0)){
                        tv_winner.setText("勝利者\n電腦");
                        tv_text.setText("可惜,電腦獲勝了");
                    }
                    else{
                        tv_winner.setText("勝利者\n平手");
                        tv_text.setText("平局,請再試一次");
                    }
                }
            }
        
    });
    }
}