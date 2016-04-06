package cn.efunding.fund.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import cn.efunding.fund.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int bar_title = R.string.bar_home_title;
    private int [] footer_images = {R.drawable.home_selected,R.drawable.activity,R.drawable.me,R.drawable.help};

    private PullToRefreshListView plv;
    private ArrayAdapter<String> data;

    private AdapterView views;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        initBar();
        initFooter();
        plv = (PullToRefreshListView) findViewById(R.id.lv);
        List<String> list = new ArrayList<String>();
        data = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list);
        plv.setAdapter(data);

        plv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {

                new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... params) {

                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {

                        data.add("wangzhe");
                        data.add("zhanglong");
                        plv.onRefreshComplete();
                    }
                }.execute();
            }
        });


    }

    private void initBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        TextView tv = (TextView) findViewById(R.id.bar_title);
        tv.setText(bar_title);
        tv.setTextColor(getResources().getColor(R.color.fund_white));
        Button btn = (Button) findViewById(R.id.btn_back_main);
        toolbar.removeView(btn);
        setSupportActionBar(toolbar);
    }

    private void initFooter(){
        ImageButton home = (ImageButton) findViewById(R.id.btn_home);
        home.setImageResource(footer_images[0]);
        home.setOnClickListener(this);

        ImageButton activity = (ImageButton) findViewById(R.id.btn_activity);
        activity.setImageResource(footer_images[1]);
        activity.setOnClickListener(this);

        ImageButton me = (ImageButton) findViewById(R.id.btn_me);
        me.setImageResource(footer_images[2]);
        me.setOnClickListener(this);

        ImageButton help = (ImageButton) findViewById(R.id.btn_help);
        help.setImageResource(footer_images[3]);
        help.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_message:
                startActivity(new Intent(MainActivity.this, MessageActivity.class));
                //finish();
                overridePendingTransition(R.animator.in_from_right_500,R.animator.out_to_left);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_home:
                break;
            case R.id.btn_activity:
                startActivity(new Intent(MainActivity.this, ActivityActivity.class));
                //finish();
                overridePendingTransition(R.animator.in_from_right,R.animator.out_to_left);

                break;
            case R.id.btn_me:
                startActivity(new Intent(MainActivity.this, MeActivity.class));
                //finish();
                overridePendingTransition(R.animator.in_from_right,R.animator.out_to_left);
                break;
            case R.id.btn_help:
                startActivity(new Intent(MainActivity.this, HelpActivity.class));
                //finish();
                overridePendingTransition(R.animator.in_from_right,R.animator.out_to_left);
                break;
        }
    }
}
