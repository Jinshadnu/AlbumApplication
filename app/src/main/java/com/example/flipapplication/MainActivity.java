package com.example.flipapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.aphidmobile.flip.FlipViewController;
import com.example.flipapplication.adapter.FlipViewAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FlipViewController flipViewController;
    private FlipViewAdapter adapter;
    private ArrayList<String> stringArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        ArrayList<String> notes = new ArrayList<String>();
        notes.add("Come");
        notes.add("On");
        notes.add("Flip");
        notes.add("Me");

       flipViewController = new FlipViewController(this, FlipViewController.VERTICAL);

        flipViewController = (FlipViewController)findViewById(R.id.flip_view);
        stringArrayList = new ArrayList<>();
        readDataFromAssets();
        adapter = new FlipViewAdapter(this,notes);
        flipViewController.setAdapter(adapter);
    }

    private void readDataFromAssets() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("loremipsum.txt")));
            String line;
            while ((line = reader.readLine()) != null) {
                stringArrayList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}