package www.xiaaix.com.dialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] single_list={"男","女","保密","程序员"};
    String[] multi_list={"篮球","足球","乒乓球","棒球"};
    String[] item_list={"项目经理","测试","程序员","CTO","运维","产品经理"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();
    }

    private void initEvent(){
        findViewById(R.id.confirm_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmDialog();
            }
        });
        findViewById(R.id.single_Dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSingleDialog();
            }
        });
        findViewById(R.id.multi_Dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMultiDialog();
            }
        });
        findViewById(R.id.list_Dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showListDialog();
            }
        });
        findViewById(R.id.my_Dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyDialog();
            }
        });
    }
    private void showConfirmDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("确认对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("确认对话框");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"点击了确定按钮",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"点击了取消按钮",Toast.LENGTH_LONG).show();

            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();

    }
    private void showSingleDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("性别");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(single_list, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str=single_list[which];
                Toast.makeText(MainActivity.this,"这个人是"+str+"!",Toast.LENGTH_SHORT).show();

            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    private void showMultiDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("爱好");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMultiChoiceItems(multi_list, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,"我喜欢上了"+multi_list[which]+"!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"我不喜欢"+multi_list[which]+"!",Toast.LENGTH_SHORT).show();

                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    private void showListDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("部门列表");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(item_list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"我动了"+item_list[which]+"!",Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    private void showMyDialog(){
        LayoutInflater inflater=LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.dialoglayout,null);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("自定义对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setView(view);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
