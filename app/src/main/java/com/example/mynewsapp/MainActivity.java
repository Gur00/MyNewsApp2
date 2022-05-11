package com.example.mynewsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerVertical;
    verticalAdapter verticalAdapter;
    List<vertical> vList = new ArrayList<>();

    RecyclerView recyclerHorizontal;
    horizontalAdapter horizontalAdapter;
    List<horizontal> hList = new ArrayList<>();

    Integer[] imageListh = {R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4, R.drawable.f5, R.drawable.f6};
    Integer[] imageListv ={R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4, R.drawable.f5, R.drawable.f6};
    String[] nameslist = {"Ukraine", "Pink-revolution", "Sri Lanka", "Jobs", "Amazon", "Covid-policy" };
    String[] description = {"Increase in Russian attack ",
            "Leni Robredo is leading the 'pink revolution in Philippines'",
            "SriLanka is facing its worst economic crisis since 1948.",
            "Hiring in the US remained strong in April, despite forecasted headwinds",
            "Amazon its taking legal actions against companies for fake negative reviews",
            "Xi Jinping sends warning to anyone who challenges China's zero-covid policy"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerHorizontal = findViewById(R.id.imageH);
        recyclerVertical = findViewById(R.id.verticalView);

        horizontalAdapter = new horizontalAdapter(hList, this);
        recyclerHorizontal.setAdapter(horizontalAdapter);
        LinearLayoutManager layoutM = new LinearLayoutManager(this);
        recyclerHorizontal.setLayoutManager(layoutM);
        layoutM.setOrientation(RecyclerView.HORIZONTAL);
        for(int i =0; i < imageListh.length; i++)
        {
            com.example.mynewsapp.horizontal horizontal = new com.example.mynewsapp.horizontal(i, imageListh[i]);
            hList.add(horizontal);
        }

        verticalAdapter = new verticalAdapter(vList, MainActivity.this.getApplicationContext(),this::onItemClick);
        recyclerVertical.setAdapter(verticalAdapter);
        recyclerVertical.setLayoutManager(new LinearLayoutManager(this));
        for(int i=0;  i<imageListv.length; i++){
            com.example.mynewsapp.vertical vertical = new com.example.mynewsapp.vertical(i, imageListv[i], nameslist[i], description[i]);
            vList.add(vertical);

        }


    }

    public void onItemClick(int position) {
        Toast.makeText(this, "you clicked a view", Toast.LENGTH_SHORT).show();
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                break;
            case 3:
                fragment = new Fragment4();
                break;
            case 4:
                fragment = new Fragment5();
                break;
            case 5:
                fragment = new Fragment6();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment).commit();
    }
}