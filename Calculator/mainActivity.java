package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Stack;
public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonEqual,decimal,clear,div, mul, add, sub;
    TextView text1;
    int result=0;
    Stack<Character> op =new Stack<Character>();
    Stack<Integer> num=new Stack<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView) findViewById(R.id.text1);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        add =  findViewById(R.id.add);
        sub =  findViewById(R.id.sub);
        mul =  findViewById(R.id.mul);
        div =  findViewById(R.id.div);
        clear =  findViewById(R.id.clear);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"0");
            }});
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"1");
            }});
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"2");}});
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"3");
          }});
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"4");
           }});
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"5");
            }});
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"6");
            }});
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"7");
            }});
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"8");
            }});
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"9");
            }});
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"+");
            }});
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"-"); }});
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"x");
            }});
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(text1.getText()+"÷");
            }});
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("");
                result=0;
            }});
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char []element=new char[100];
                String s =   text1.getText().toString();
                for (int i=0;i<s.length();i++)
                    element[i] = s.charAt(i);
                for (int j = 0; j < element.length; j++){
                    if (element[j] >= '0'&& element[j] <= '9') {
                        num.push(Integer.parseInt(String.valueOf(element[j])));
                    }
                    else if (element[j] == '+' || element[j] == '-' || element[j] == 'x' || element[j] == '÷') {
                        while (!op.empty() && precedence(element[j], op.peek()))
                            num.push(cal(op.pop(), num.pop(), num.pop()));
                        op.push(element[j]);
                    }
                }
              while(!op.empty())
                    num.push(cal(op.pop(),num.pop(),num.pop()));
               result=num.pop();
               String s1 = String.valueOf(result);
               text1.setText(s1);
            }
        });}
    public boolean precedence(char newOp,char topOp){
        if ((newOp == 'x' || newOp == '÷') && (topOp == '+' || topOp == '-'))
            return false;
        else
            return true;}
    int cal(char op,int a,int b){
        switch (op){
            case '+':return a+b;
            case '-':return b-a;
            case 'x':return a*b;
            case '÷':return b/a;}
        return 0;}}
