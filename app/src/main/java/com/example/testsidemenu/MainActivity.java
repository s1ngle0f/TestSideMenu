package com.example.testsidemenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.testsidemenu.db.LocalDatabase;
import com.example.testsidemenu.db.model.AnyInfo;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    LocalDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Toast.makeText(MainActivity.this, "Page: " + item.getTitle() + String.valueOf(item.getItemId()), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
        );

        if(database == null){
            database = Room.databaseBuilder(this, LocalDatabase.class, "for_example")
                    .allowMainThreadQueries()
                    .build();
        }
//        database.anyInfoDao().insert(
//            new AnyInfo(
//                    "BlaBla1"
//            )
//        );
        List<AnyInfo> infos = database.anyInfoDao().getAllAnyInfo();
        for (AnyInfo info : infos) {
            Log.d("DB_INFO", info.toString());
        }
    }
}