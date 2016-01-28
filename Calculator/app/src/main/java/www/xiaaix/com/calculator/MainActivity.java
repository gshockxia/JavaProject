package www.xiaaix.com.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_zero;//0数字按钮
    Button btn_one;//1数字按钮
    Button btn_two;//2数字按钮
    Button btn_three;//3数字按钮
    Button btn_four;//4数字按钮
    Button btn_five;//5数字按钮
    Button btn_six;//6数字按钮
    Button btn_seven;//7数字按钮
    Button btn_eight;//8数字按钮
    Button btn_nine;//9数字按钮
    Button btn_point;//.数字按钮
    Button btn_clear;//清除数字按钮
    Button btn_del;//del数字按钮
    Button btn_plus;//+数字按钮
    Button btn_minus;//-数字按钮
    Button btn_multiply;//x数字按钮
    Button btn_divide;//除号数字按钮
    Button btn_equal;//=数字按钮
    EditText et_input;//显示输入的内容
    boolean clear_flag;//清空标识

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btn_zero=(Button)findViewById(R.id.btn_zero);
        btn_one=(Button)findViewById(R.id.btn_one);
        btn_two=(Button)findViewById(R.id.btn_two);
        btn_three=(Button)findViewById(R.id.btn_three);
        btn_four=(Button)findViewById(R.id.btn_four);
        btn_five=(Button)findViewById(R.id.btn_five);
        btn_six=(Button)findViewById(R.id.btn_six);
        btn_seven=(Button)findViewById(R.id.btn_seven);
        btn_eight=(Button)findViewById(R.id.btn_eight);
        btn_nine=(Button)findViewById(R.id.btn_nine);
        btn_point=(Button)findViewById(R.id.btn_point);
        btn_plus=(Button)findViewById(R.id.btn_plus);
        btn_minus=(Button)findViewById(R.id.btn_minus);
        btn_divide=(Button)findViewById(R.id.btn_divide);
        btn_multiply=(Button)findViewById(R.id.btn_multiply);
        btn_clear=(Button)findViewById(R.id.btn_clear);
        btn_del=(Button)findViewById(R.id.btn_del);
        btn_equal=(Button)findViewById(R.id.btn_equal);
        et_input=(EditText)findViewById(R.id.et_input);



        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        et_input.setOnClickListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String str=et_input.getText().toString();
        switch (v.getId()){
            case R.id.btn_zero:
            case R.id.btn_one:
            case R.id.btn_two:
            case R.id.btn_three:
            case R.id.btn_four:
            case R.id.btn_five:
            case R.id.btn_six:
            case R.id.btn_seven:
            case R.id.btn_eight:
            case R.id.btn_nine:
            case R.id.btn_point:

                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+((Button)v).getText());
                break;
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                if(clear_flag){
                    clear_flag=false;
                    et_input.setText("");
                }
                et_input.setText(str+" "+((Button)v).getText()+" ");
                break;
            case R.id.btn_clear:
                clear_flag=false;
                str="";
                et_input.setText("");
                break;
            case R.id.btn_del:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }else if(str!=null&&!str.equals("")){
                    et_input.setText(str.substring(0,str.length()-1));
                }
                break;
            case R.id.btn_equal:
                getResult();
                break;

            default:
                break;
        }

    }

    private void getResult(){
        String exp=et_input.getText().toString();
        if(exp==null){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        if (clear_flag){
            clear_flag=false;
            return;
        }
        clear_flag=true;
        double result=0;
        String s1=exp.substring(0,exp.indexOf(" "));//运算符前面的字符串
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);//截取到的运算符
        String s2=exp.substring(exp.indexOf(" ")+3);
        if(!s1.equals("")&&!s2.equals("")){
            double d1=Double.parseDouble(s1);
            double d2=Double.parseDouble(s2);

            if(op.equals("+")){
                result=d1+d2;

            }else if(op.equals("-")){
                result=d1-d2;

            }else if(op.equals("×")){
                result=d1*d2;

            }else if(op.equals("÷")){
                if(d2==0){
                    result=0;
                }else{
                    result=d1/d2;
                }

            }
            if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")){
                int r=(int)result;
                et_input.setText(r+"");
            }else {
                et_input.setText(result+"");
            }
        }else if(!s1.equals("")&&s2.equals("")){
            et_input.setText(exp);
        }else if(s1.equals("")&&!s2.equals("")){
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                result=0+d2;

            }else if(op.equals("-")){
                result=0-d2;

            }else if(op.equals("×")){
                result=0;

            }else if(op.equals("÷")){

                    result=0;

            }
            if(!s2.contains(".")){
                int r=(int)result;
                et_input.setText(r+"");
            }else {
                et_input.setText(result+"");
            }
        }else {
            et_input.setText("");
        }
    }
}
