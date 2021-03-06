package com.openxu.chart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.openxu.chart.adapter.CommandRecyclerAdapter;
import com.openxu.chart.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        datas = new ArrayList<>();
        datas.add("南丁格尔玫瑰图");
        datas.add("饼状图");
        datas.add("进度环形图");
        datas.add("纵向柱状图");
        datas.add("横向柱状图");

        recyclerView.setAdapter(new CommandRecyclerAdapter<String>(this, R.layout.list_item, datas) {
            @Override
            public void convert(ViewHolder holder, String str) {
                holder.setText(R.id.tv_name, str);
            }
            @Override
            public void onItemClick(String str, int position) {
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this, RoseActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, PieActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, ProgressPieActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, VerticalBarActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, HorizontalBarActivity.class));
                        break;
                }
            }

        });

    }
}
