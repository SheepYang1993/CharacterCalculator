package com.sheepyang.rpcalculator.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sheepyang.rpcalculator.R;

import java.io.UnsupportedEncodingException;

public class ResultActivity extends AppCompatActivity {
    private TextView tvName;
    private TextView tvSex;
    private TextView tvScore;
    private TextView tvDescription ;
    private String strName = "无名人士";
    private Integer intSex;
    private byte[] bytes = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initView();
        initData();
    }

    private void initData() {
        if (getIntent() != null) {
            if (getIntent().getStringExtra("name") != null) {
                strName = getIntent().getStringExtra("name");
            }
            tvName.setText("姓名: "+ strName);

            intSex = getIntent().getIntExtra("sex",0);
            switch(intSex) {
                case R.id.rbMale:
                    tvSex.setText("性别: 男");
                    try {
                        bytes = strName.getBytes("gbk");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.rbFeMale:
                    tvSex.setText("性别: 女");
                    try {
                        bytes = strName.getBytes("utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.rbLadyboy:
                    tvSex.setText("性别: 人妖");
                    try {
                        bytes = strName.getBytes("iso-8859-1");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    tvSex.setText("未知性别");
                    break;
            }

        }
        calculateRP();
    }

    private void initView() {
        tvName = (TextView) findViewById(R.id.tvName);
        tvSex = (TextView) findViewById(R.id.tvSex);
        tvScore = (TextView) findViewById(R.id.tvScore);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
    }

    private void calculateRP() {
        int total = 0;
        for (byte b: bytes) {
            int number = b&0xFF;
            total += number;
        }
        int score = Math.abs(total)%100;
        tvScore.setText("得分: " + String.valueOf(score) + " 分");
        if (score >= 90) {
            tvDescription.setText("评价:无价之宝。虽然说它可能无法给你带来可计算可估摸的金钱，这些钱会实实在在地摆在你的面前。但是在你的心中，你看不见摸不着的人品，却是一个无价之宝。有时候自己做了好事，可能并没有图到点儿实实在在的东西。但是它对你对别人甚至对社会的影响，却可能达到不可估量的地步。你的人品不是值钱的货，因为它是无价的，用钱是买不到的。");
        } else if (score >= 80) {
            tvDescription.setText("评价:价值百万。高尚是高尚者的通行证，卑鄙是卑鄙这的墓志铭，你觉得自己并不高尚也不卑鄙，你只是有一些现实而已。当一个人没有金钱、英俊的外貌，人品将会让之加不少的分。当有钱并具备一切外在的条件，人品更是超过其他人的有力法码。拥有良好品德的人，才能得到领导的悉心栽培、提拔;拥有良好品德的人，才能赢得人们的尊重。你的人品价值百万，这点不必怀疑。只是你需要做的是如何将它发挥实际作用，给你带来金钱上的收获。");
        } else if (score >= 70) {
            tvDescription.setText("评价:值个月薪。你是一个比较实在的人，不喜欢夸张与夸大，生活图个脚踏实地，并不图个大富大贵，只求可以每天有饭吃有觉睡有房子住有家人疼就可以了。所以你的人品价值你也不是特别看重。为了月薪，你也会把自己给卖出去。生活嘛，就是要糊口。生活很艰难，自己普通小民不得不低头。至少自己还算是有技能的，只要每个月都有工资领，那么将拥有人品的自己卖给公司单位，也没有什么吧。");
        } else if (score >= 60) {
            tvDescription.setText("评价:值三五。人品这个东西，在你看来，并不是一文不值，有的人的人品还是很值钱的，甚至可以说用钱难买。但是你自己的人品，虽然不是那么值钱，毕竟你也是一个小人物，平凡人，登不了什么大台面，但至少，也是值点儿小钱的。三五文只是一种形容，形容你只是一个平凡的人，人品好的情况下做的好人好事，也是值那么一丢丢的。这一丢丢的钱虽然很少，但是聚少成多，凑起来，却也很可观。");
        } else if (score >= 50) {
            tvDescription.setText("评价:一文不值。实在没有发现自己的人品有为自己带来什么价值。大概你也认为自己的人品是一文不值的吧。所以你也懒得再相信什么人品了，平时可能会冷漠一点，会注重自我一些，这些都不过是在“好心被当成傻冒，换来的是耻笑和冰冷，好心有的时候会变成伤心”之后才领悟过来的真理。反正自己吃饭穿衣也不是靠人品的，而是拼的努力与实力，所以，在你看来，它不值钱也无所谓。");
        } else {
            tvDescription.setText("评价:倒贴钱财。都说好人品值万金，但现在最可悲的是好人品也不值啥钱，这些倒没啥，毕竟也没有真的失去什么。糟糕的是，有时候自己的好人品还会让自己倒贴钱出去。这可真的是相当极其郁闷的事情。比如自己太善良，借了钱给人家，但人家死活就赖账不还你。有时候你还会被人骗去钱。人家一文不值的人品，至少没有失去啥，搁你这，可就是倒贴钱出去了。不管怎么样，还是要长点儿心吧。");
        }
    }

    public void back(View v) {
        finish();
    }
}
