package com.example.puliangfu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.puliangfu.jisuanqiandroid.R;

import java.math.BigDecimal;


public class MainActivity extends Activity{

    /*
    *组件定义yfufkuygliuu
     */
    private Button b_0,b_1,b_2,b_3,b_4,b_5,b_6,b_7,b_8,b_9,b_dian,b_jia,b_jian,b_cheng,
            b_chu,b_c,b_deng,b_xiao;
    private EditText et;
    StringBuffer string = new StringBuffer("");
    //定义符号
    private String fuhao="+";
    //定义小数点，加号，减号，乘号，除号的状态为true
    private boolean flag=true;
    private boolean jiahao=true;
    private boolean jianhao=true;
    private boolean chenghao=true;
    private boolean chuhao=true;

    //显示结果
    private String result="";
    private double num1;
    private double num2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        b_0=(Button) findViewById(R.id.num0);
        b_1=(Button) findViewById(R.id.num1);
        b_2=(Button) findViewById(R.id.num2);
        b_3=(Button) findViewById(R.id.num3);
        b_4=(Button) findViewById(R.id.num4);
        b_5=(Button) findViewById(R.id.num5);
        b_6=(Button) findViewById(R.id.num6);
        b_7=(Button) findViewById(R.id.num7);
        b_8=(Button) findViewById(R.id.num8);
        b_9=(Button) findViewById(R.id.num9);
        b_dian=(Button) findViewById(R.id.dot);
        b_jia=(Button) findViewById(R.id.plus);
        b_jian=(Button) findViewById(R.id.minus);
        b_cheng=(Button) findViewById(R.id.multiply);
        b_chu=(Button) findViewById(R.id.division);
        b_c=(Button) findViewById(R.id.tonone);
        b_deng=(Button) findViewById(R.id.equ);
        b_xiao=(Button) findViewById(R.id.delete);
        et=(EditText) findViewById(R.id.rsText);
        et.setText("");

        /*
        *活动监听0-9和.9
         */
        b_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string.append("0");
                et.setText(string.toString());
            }
        });

        b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string.append("1");
                et.setText(string.toString());
            }
        });

        b_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string.append("2");
                et.setText(string.toString());
            }
        });

        b_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string.append("3");
                et.setText(string.toString());
            }
        });

        b_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string.append("4");
                et.setText(string.toString());
            }
        });

        b_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string.append("5");
                et.setText(string.toString());
            }
        });

        b_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string.append("6");
                et.setText(string.toString());
            }
        });

        b_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string.append("7");
                et.setText(string.toString());
            }
        });

        b_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string.append("8");
                et.setText(string.toString());
            }
        });

        b_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string.append("9");
                et.setText(string.toString());
            }
        });

        b_dian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    string.append(".");
                    flag = false;
                    et.setText(string.toString());
                }

            }
        });

        b_xiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (string.length()!=0){
                    char c=string.charAt(string.length()-1);
                    if(c=='.'){
                        status1();
                    }
                    if(c=='+'){
                        status1();
                    }
                    if(c=='-'){
                        status1();
                    }
                    if(c=='*'){
                        status1();
                    }
                    if(c=='÷'){
                        status1();
                    }
                }
                string.deleteCharAt(string.length()-1);
                et.setText(string.toString());
            }
        });

        /*
        为测试程序而生的计算器
         */
        b_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fuhao="+";
                flag=true;
                jiahao=true;
                jianhao=true;
                chenghao=true;
                chenghao=true;
                chuhao=true;
                string=new StringBuffer();
                result=null;
                num1=0;
                num2=0;
                et.setText("");

            }
        });

        b_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fuhao="+";
                if (jiahao&&(!(string.toString()==""))&&(!(string.toString().equals("∞")))) {
                    num1 = Double.parseDouble(string.toString());
                    string.append("+");
                    status();
                    et.setText(string.toString());
                }
            }
        });

        b_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fuhao="-";
                if (jianhao&&(!(string.toString()==""))&&(!(string.toString().equals("∞")))){
                    num1=Double.parseDouble(string.toString());
                    string.append("-");
                    status();
                    et.setText(string.toString());
                }
                if(string.toString()==""){
                    string.append("-");
                    et.setText(string.toString());
                }
            }
        });

        b_cheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fuhao="*";
                if (chenghao&&(!(string.toString()==""))&&(!(string.toString().equals("∞")))) {
                    num1 = Double.parseDouble(string.toString());
                    string.append("*");
                    status();
                    et.setText(string.toString());
                }
            }
        });

        b_chu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fuhao="÷";
                if (chuhao&&(!(string.toString()==""))&&(!(string.toString().equals("∞")))) {
                    num1 = Double.parseDouble(string.toString());
                    string.append(fuhao);
                    status();
                    et.setText(string.toString());
                }
            }
        });

        b_deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fuhao.equals("+")){
                    int i =string.indexOf(fuhao);
                    num2=Double.parseDouble(string.substring(i+1,string.length()));
                    result=yunsuan(num1 + num2);
                    et.setText(string.toString());
                    string=new StringBuffer(result);
                }

                if (fuhao.equals("-")){
                    int i =string.indexOf("-",1);
                    num2=Double.parseDouble(string.substring(i+1,string.length()));
                    result=yunsuan(num1 - num2);
                    et.setText(result);
                    string=new StringBuffer(result);
                }

                if (fuhao.equals("*")){
                    int i =string.indexOf("*");
                    num2=Double.parseDouble(string.substring(i+1,string.length()));
                    result=yunsuan(num1 * num2);
                    et.setText(result);
                    string=new StringBuffer(result);
                }

                if (fuhao.equals("÷")){
                    int i =string.indexOf("÷");
                    num2=Double.parseDouble(string.substring(i+1,string.length()));
                    if (num2==0){
                        result=String.valueOf("∞");
                        string=new StringBuffer(result);
                    }else {
                        result=String.valueOf(num1/num2);
                        string=new StringBuffer(result);
                    }
                    et.setText(result);
                }
                    jiahao=true;
                    jianhao=true;
                    chenghao=true;
                    chuhao=true;
                }


            });
    }

    private void status(){
        flag=true;
        jiahao=false;
        jianhao=false;
        chenghao=false;
        chuhao=false;
    }

    private void status1(){
        flag=true;
        jiahao=true;
        jianhao=true;
        chenghao=true;
        chuhao=true;
    }

    private String yunsuan(double num){
        BigDecimal bd = new BigDecimal(num);
        num = bd.setScale(13,BigDecimal.ROUND_HALF_UP).doubleValue();
        String result1=String.valueOf(num);
        return result1;
    }



}
