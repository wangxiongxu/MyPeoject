package com.wangxu.example.wnag.geeknews.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.wangxu.example.wnag.geeknews.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class VtexShuActivity extends AppCompatActivity {
    private static final String TAG = "wangxu";
    private String mUrl = "https://www.v2ex.com/";
    private ArrayList<String> title;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vtex_shu);
        title = new ArrayList<>();
        strings = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        }).start();


    }

    private void getData() {
        try {
            Document document = Jsoup.connect(mUrl).get();
            Elements s1 = document.select("div.box");
            Elements s2 = s1.select("div.cell");
            Elements select2 = s1.select("div.inner");
            //
            for (Element element : s2) {
                Elements select = element.select("table tbody tr td span.fade");
                String text = select.text();
                if (!text.equals("")) {
                    //Log.i(TAG, "getData: "+text);
                    title.add(text);
                }
                Elements select1 = element.select("table tbody tr td > a");
                for (Element element1 : select1) {
                    String text1 = element1.text();

                    if (!text1.equals("")) {
                        //if (/^[0-9]+$/.test(text1))
                        Pattern pattern = Pattern.compile("[0-9]*");
                        if (!pattern.matcher(text1).matches()) {
                            Log.i(TAG, "getData: "+element1.text());
                            strings.add(element1.text());
                        }
                    }
                }


            }
            //
            //
            for (Element element : select2) {
                Elements select = element.select("table tbody tr td span.fade");
                String text = select.text();
                if (!text.equals("")) {
                    //Log.i(TAG, "getData: "+text);
                    title.add(text);
                }
                Elements select1 = element.select("table tbody tr td > a");
                for (Element element1 : select1) {
                    String text1 = element1.text();

                    if (!text1.equals("")) {
                        //if (/^[0-9]+$/.test(text1))
                        Pattern pattern = Pattern.compile("[0-9]*");
                        if (!pattern.matcher(text1).matches()) {
                            //Log.i(TAG, "getData: "+element1.text());
                            strings.add(element1.text());
                        }

                    }

                }

            }
            //
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
