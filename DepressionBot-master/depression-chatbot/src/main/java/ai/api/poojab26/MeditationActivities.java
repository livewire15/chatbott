package ai.api.poojab26;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MeditationActivities extends AppCompatActivity {
    MediaPlayer mp;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation_activities);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Goals");
        ab.setHomeButtonEnabled(true);
        RecyclerView dataList = (RecyclerView) findViewById(R.id.rv);
        dataList.setLayoutManager(new LinearLayoutManager(this));
        String data[] = {"Activity 1", "Activity 2", "Activity 3", "Activity 4", "Activity 5", "Activity 6", "Activity 7", "Activity 8",
                "Activity 9", "Activity 10"};
        int value[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        final int songsUrl[] = {R.raw.cityofhope, R.raw.breathing, R.raw.calming, R.raw.cheerful_sound,
                R.raw.mindfulbreathe, R.raw.progressiverelax, R.raw.relaxation, R.raw.soothing_flute,
                R.raw.soothing_melody, R.raw.walking};
        MyAdapter myAdapter = new MyAdapter(data, value);
        dataList.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void onItemClick(ImageView imageView, View v, int position) {

                if (flag == 1) {
                    flag = 0;
                    Toast.makeText(MeditationActivities.this, "Song stopped", Toast.LENGTH_SHORT).show();
                    mp.pause();
                       /* mp.reset();
                        mp.release();
                        mp = null;*/
                } else {
                    mp = MediaPlayer.create(MeditationActivities.this, songsUrl[position]);
                    mp.start();
                    flag = 1;
                    Toast.makeText(MeditationActivities.this, "Song started", Toast.LENGTH_SHORT).show();
                       /* mp.setDataSource("https://cdn10.upload.solutions/44490df59396150108813fff6e9bab5c/dobov/The%20Jawaani%20Song-(Mr-Jatt.com).mp3");
                        mp.prepareAsync();
                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                mp.start();
                                flag = 1;
                                Toast.makeText(MeditationActivities.this,"Song started",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }catch(IOException e)
                {}*/
                }
            }

        });
    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu)
        {
            MenuInflater mi = getMenuInflater();
            mi.inflate(R.menu.main, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {
                case R.id.alarm:
                    Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                    startActivity(i);
            }
            return super.onOptionsItemSelected(item);
        }
    }