package hello.jcw27.washington.edu.quizdroid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.AlarmManager.RTC_WAKEUP;


public class Preferences extends ActionBarActivity {
    private PendingIntent pendingIntent;
    EditText url;
    EditText duration;
    int interval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        url = (EditText) findViewById(R.id.url);
        duration = (EditText) findViewById(R.id.duration);

        final Intent alarmIntent = new Intent(Preferences.this, AlarmReceiver.class);
        Button button = (Button) findViewById(R.id.button);
        Button home = (Button) findViewById(R.id.home);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(url.getText().toString().length() > 0 && url.getText().toString().length() > 0){
                    int number = Integer.parseInt(duration.getText().toString());
                    if(number > 0){
                        String number_and_message = url.getText().toString();
                        interval = 1000 * 60 * number;

                        alarmIntent.putExtra("message", number_and_message);
                        pendingIntent = PendingIntent.getBroadcast(Preferences.this, 0, alarmIntent, 0);
                        start();
                    }
                }
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Preferences.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void start() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        manager.setInexactRepeating(RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
    }

    public void cancel() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);
        pendingIntent.cancel();
        Toast.makeText(this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
    }

    public void onDestroy(){
        cancel();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
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
