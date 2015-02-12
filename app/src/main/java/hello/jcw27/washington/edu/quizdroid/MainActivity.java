package hello.jcw27.washington.edu.quizdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.ListView;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.content.Intent;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity  {

    List<Map<String, String>> topicsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button math = (Button) findViewById(R.id.button);
        initList();

        ListView lv = (ListView) findViewById(R.id.listView);

        SimpleAdapter simpleAdpt = new SimpleAdapter(this, topicsList, android.R.layout.simple_list_item_1, new String[] {"topics"}, new int[] {android.R.id.text1});

        lv.setAdapter(simpleAdpt);

        lv.setTextFilterEnabled(true);

        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String topic = ((TextView) view).getText().toString();
                Intent intent = new Intent(MainActivity.this, Manager.class);
                if(topic.equals("Math")){

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        intent.putExtra("topic", "math");
                        startActivity(intent);
                    }

                    finish();
                } else if(topic.equals("Physics")){
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        intent.putExtra("topic", "physics");
                        startActivity(intent);
                    }

                    finish();
                } else if(topic.equals("Marvel Super Heroes")) {
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        intent.putExtra("topic", "superhero");
                        startActivity(intent);
                    }

                }
            }
        });
    }

    private void initList(){
        topicsList.add(createTopic("topics", "Math"));
        topicsList.add(createTopic("topics", "Physics"));
        topicsList.add(createTopic("topics", "Marvel Super Heroes"));

    }

    private HashMap<String, String> createTopic(String key, String value){
        HashMap<String, String> topic = new HashMap<>();
        topic.put(key, value);
        return topic;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
