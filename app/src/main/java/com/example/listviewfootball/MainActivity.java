package com.example.listviewfootball;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<Player> players;

    private PlayerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        adapter = new PlayerAdapter(this);
        prepare();
        addItem();

        adapter.setPlayer(players);

        ListView listView = findViewById(R.id.lv_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, players.get(i).getName(),
                        Toast.LENGTH_SHORT).show();
                Intent objectIntent = new Intent(MainActivity.this, IntentActivity.class);
                objectIntent.putExtra(IntentActivity.PLAYER_NAME, players.get(i).getName());
                objectIntent.putExtra(IntentActivity.PLAYER_DESC, players.get(i).getDescription());
                objectIntent.putExtra(IntentActivity.PLAYER_PHOTO, players.get(i).getPhoto());
                startActivity(objectIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.myProfile){
            startActivity(new Intent(this, about.class));
        }
        else {
            Toast.makeText(MainActivity.this, "Not Available", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private void addItem(){
        players = new ArrayList<>();
        for(int i = 0; i < dataName.length; i++){
            Player player = new Player();
            player.setName(dataName[i]);
            player.setDescription(dataDescription[i]);
            player.setPhoto(dataPhoto.getResourceId(i,-1));
            players.add(player);
        }

    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
}
