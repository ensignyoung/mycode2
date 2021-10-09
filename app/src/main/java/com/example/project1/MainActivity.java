package com.example.project1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment chatFragment = new ChatFragment();
    private Fragment communityFragment = new CommunityFragment();
    private Fragment meFragment = new MeFragment();
    private Fragment newsFragment = new NewsFragment();

    private FragmentManager fragmentManager;
    private View LinearLayout1,LinearLayout2,LinearLayout3,LinearLayout4,LinearLayout5;
    private TextView textView1,textView2,textView3,textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        LinearLayout1 = findViewById(R.id.LinearLayout_News);
        LinearLayout2 = findViewById(R.id.LinearLayout_chat);
        LinearLayout3 = findViewById(R.id.LinearLayout_community);

        LinearLayout4 = findViewById(R.id.LinearLayout_me);

        LinearLayout1.setOnClickListener(this);
        LinearLayout2.setOnClickListener(this);
        LinearLayout3.setOnClickListener(this);
        LinearLayout4.setOnClickListener(this);

        initFragment();
        showFragment(0);

    }

    private void initFragment(){
        fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content,newsFragment);
        transaction.add(R.id.content,chatFragment);
        transaction.add(R.id.content,communityFragment);

        transaction.add(R.id.content,meFragment);
        transaction.commit();
    }

    public void hideFragment(FragmentTransaction transaction){
        transaction.hide(newsFragment);
        transaction.hide(chatFragment);
        transaction.hide(communityFragment);

        transaction.hide(meFragment);
    }



    private void showFragment(int i){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(newsFragment);
                LinearLayout1.setBackgroundColor(Color.rgb(0,255,0));
                LinearLayout2.setBackgroundColor(Color.rgb(0,0,0));
                LinearLayout3.setBackgroundColor(Color.rgb(0,0,0));
                LinearLayout4.setBackgroundColor(Color.rgb(0,0,0));

                break;
            case 1:
                transaction.show(chatFragment);
                LinearLayout1.setBackgroundColor(Color.rgb(0,0,0));
                LinearLayout2.setBackgroundColor(Color.rgb(0,255,0));
                LinearLayout3.setBackgroundColor(Color.rgb(0,0,0));
                LinearLayout4.setBackgroundColor(Color.rgb(0,0,0));

                break;
            case 2:
                transaction.show(communityFragment);
                LinearLayout1.setBackgroundColor(Color.rgb(0,0,0));
                LinearLayout2.setBackgroundColor(Color.rgb(0,0,0));
                LinearLayout3.setBackgroundColor(Color.rgb(0,255,0));
                LinearLayout4.setBackgroundColor(Color.rgb(0,0,0));

                break;

            case 3:
                transaction.show(meFragment);
                LinearLayout1.setBackgroundColor(Color.rgb(0,0,0));
                LinearLayout2.setBackgroundColor(Color.rgb(0,0,0));
                LinearLayout3.setBackgroundColor(Color.rgb(0,0,0));
                LinearLayout4.setBackgroundColor(Color.rgb(0,255,0));

                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.LinearLayout_News:
                showFragment(0);
                break;
            case R.id.LinearLayout_chat:
                showFragment(1);
                break;
            case R.id.LinearLayout_community:
                showFragment(2);
                break;

            case R.id.LinearLayout_me:
                showFragment(3);
                break;
            default:
                break;

        }
    }
}
