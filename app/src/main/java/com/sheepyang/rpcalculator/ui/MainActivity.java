package com.sheepyang.rpcalculator.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.sheepyang.rpcalculator.R;
import com.sheepyang.rpcalculator.utils.ToastUtil;

public class MainActivity extends AppCompatActivity {
    private EditText edtName;
    private RadioGroup rgSex;
    private Integer intSex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        edtName = (EditText) findViewById(R.id.edtName);
        rgSex = (RadioGroup) findViewById(R.id.rgSex);
    }

    public void seeResult(View v) {
        if (TextUtils.isEmpty(edtName.getText().toString())) {
            ToastUtil.show(this, "请输入姓名!");
            return;
        }

        String name = edtName.getText().toString();
        switch(rgSex.getCheckedRadioButtonId()) {
            case R.id.rbMale:
                intSex = R.id.rbMale;
                break;
            case R.id.rbFeMale:
                intSex = R.id.rbFeMale;
                break;
            case R.id.rbLadyboy:
                intSex = R.id.rbLadyboy;
                break;
            default:
                break;
        }
        if (intSex == 0) {
            ToastUtil.show(this, "请选择性别!");
            return;
        }

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("sex", intSex);
        startActivity(intent);
    }
}
