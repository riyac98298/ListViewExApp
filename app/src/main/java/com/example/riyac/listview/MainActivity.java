package com.example.riyac.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
ListView listView;
    String arr[]={"First","Second", "Third", "Fourth", "Fifth"};
    int arr2[]={R.drawable.candle, R.drawable.candle1, R.drawable.candle2, R.drawable.candle3, R.drawable.candle4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);

        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();

        for (int i=0; i<5; i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();
           // hashMap.put(arr[i] , arr2[i]+"");
            hashMap.put("name", arr[i]);
            hashMap.put("image", arr2[i]+"");
            arrayList.add(hashMap);
        }
        String[] from={"name", "image"};
        int[] to={R.id.textView, R.id.imageView};
        CustomSimpleAdapter customSimpleAdapter=new CustomSimpleAdapter(getApplicationContext(), arrayList, R.layout.listitems, from, to);
        listView.setAdapter(customSimpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), arr[i], Toast.LENGTH_LONG).show();
            }
        });
    }
}
