package itcast.cn.word2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] data={"a","b","c","d","e","f","g","h","i","j","s","d","d","s"};
    private List<Fruit> list;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        Fruitadapter fruitadapter=new Fruitadapter(MainActivity.this,R.layout.fruit_item,list);
        listView=findViewById(R.id.list_item);
        listView.setAdapter(fruitadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit=list.get(position);
                Toast.makeText(MainActivity.this,"你点击了"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruit() {
        list=new ArrayList<Fruit>();
        for(int i=0;i<data.length;i++) {
            Fruit f = new Fruit(data[i], R.drawable.ic_launcher_background);
            list.add(f);
        }
    }
}
