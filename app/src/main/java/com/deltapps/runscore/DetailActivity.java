package com.deltapps.runscore;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Calendar;


public class DetailActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView user1 = (TextView)findViewById(R.id.user1);
        TextView user2 = (TextView)findViewById(R.id.user2);
        TextView time1 = (TextView)findViewById(R.id.time_user1);
        TextView time2 = (TextView)findViewById(R.id.time_user2);
        TextView average_rate_user1 = (TextView)findViewById(R.id.average_rate_user1);
        TextView average_rate_user2 = (TextView)findViewById(R.id.average_rate_user2);
        TextView score_user1 = (TextView)findViewById(R.id.score_user1);
        TextView score_user2 = (TextView)findViewById(R.id.score_user2);

        int position = getIntent().getIntExtra("position", 0);

        Race race = HistorialActivity.racesList.get(position);
        Calendar c = Calendar.getInstance();

        user1.setText(race.getUsername(true));
        user2.setText(race.getUsername(false));
        c.setTimeInMillis(race.getDuration(true));
        if (c.get(Calendar.MINUTE) < 10 && c.get(Calendar.SECOND) < 10)
            time1.setText("0" + c.get(Calendar.HOUR) + ":" + "0" + c.get(Calendar.MINUTE) + ":" +
                            "0" + c.get(Calendar.SECOND));
        else if (c.get(Calendar.MINUTE) < 10 && c.get(Calendar.SECOND) >=10)
            time1.setText("0" + c.get(Calendar.HOUR) + ":" + "0" + c.get(Calendar.MINUTE) + ":" +
                            c.get(Calendar.SECOND));
        else if (c.get(Calendar.MINUTE) >=10 && c.get(Calendar.SECOND) < 10)
            time1.setText("0" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + "0" +
                            c.get(Calendar.SECOND));
        else
            time1.setText("0" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" +
                    c.get(Calendar.SECOND));
        c.setTimeInMillis(race.getDuration(false));
        if (c.get(Calendar.MINUTE) < 10 && c.get(Calendar.SECOND) < 10)
            time2.setText("0" + c.get(Calendar.HOUR) + ":" + "0" + c.get(Calendar.MINUTE) + ":" +
                    "0" + c.get(Calendar.SECOND));
        else if (c.get(Calendar.MINUTE) < 10 && c.get(Calendar.SECOND) >=10)
            time2.setText("0" + c.get(Calendar.HOUR) + ":" + "0" + c.get(Calendar.MINUTE) + ":" +
                    c.get(Calendar.SECOND));
        else if (c.get(Calendar.MINUTE) >=10 && c.get(Calendar.SECOND) < 10)
            time2.setText("0" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + "0" +
                    c.get(Calendar.SECOND));
        else
            time2.setText("0" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" +
                    c.get(Calendar.SECOND));

        average_rate_user1.setText(String.valueOf(race.getAvgPace(true)));
        average_rate_user2.setText(String.valueOf(race.getAvgPace(false)));

        score_user1.setText(String.valueOf(race.getScore(true)));
        score_user2.setText(String.valueOf(race.getScore(false)));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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
