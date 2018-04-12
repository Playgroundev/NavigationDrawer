package dev.brian.com.drawer_navigation;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


import com.mindorks.placeholderview.PlaceHolderView;

public class MainActivity extends AppCompatActivity {

    private PlaceHolderView mDrawerView;
    private DrawerLayout mDrawer;
    private Toolbar mToolbar;
    private PlaceHolderView mGalleryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawer = (DrawerLayout)findViewById(R.id.drawerLayout);
        mDrawerView = (PlaceHolderView) findViewById(R.id.drawerView);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mGalleryView = (PlaceHolderView)findViewById(R.id.beginning);
        setupDrawer();
    }
    private void setupDrawer(){
        mDrawerView.addView(new DrawHeader())
                .addView(new DrawerMenuItems(this.getApplicationContext()))
                .addView(new DrawerMenuItems(this.getApplicationContext()))
                .addView(new DrawerMenuItems(this.getApplicationContext()))
                .addView(new DrawerMenuItems(this.getApplicationContext()))
                .addView(new DrawerMenuItems(this.getApplicationContext()))
                .addView(new DrawerMenuItems(this.getApplicationContext()))
                .addView(new DrawerMenuItems(this.getApplicationContext()))
                .addView(new DrawerMenuItems(this.getApplicationContext()));

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.open_drawer, R.string.close_drawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


    }
    public void onButtonClick(View view){
        Intent intent = new Intent(MainActivity.this,AddMarks.class);
        startActivity(intent);
    }

}
