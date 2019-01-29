package com.example.tojuzone.eudomania.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.tojuzone.eudomania.CategoriesFragment;
import com.example.tojuzone.eudomania.DashboardFragment;
import com.example.tojuzone.eudomania.MessageFragment;
import com.example.tojuzone.eudomania.R;

public class DashboardActivity extends AppCompatActivity {

    private DashboardFragment dashboardFragment;
    private CategoriesFragment categoriesFragment;
    private MessageFragment messageFragment;

    private NavigationView drawerNavigation;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        setTitle("Dashboard");

        drawerNavigation = findViewById(R.id.drawer_navigation);

        dashboardFragment = new DashboardFragment();
        categoriesFragment = new CategoriesFragment();
        messageFragment = new MessageFragment();

        setFragment(dashboardFragment);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.aside_dashboard:
                        setFragment(dashboardFragment);
                        setTitle("Dashboard");
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                        return true;
                    case R.id.aside_categories:
                        setFragment(categoriesFragment);
                        setTitle("Categories");
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                        return true;
                    case R.id.aside_message:
                        setFragment(messageFragment);
                        setTitle("Message");
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                        return true;
                    case R.id.aside_logout:
                        logout();
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                        return true;
                    default:
                        return false;
                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setFragment (Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.dash_frame, fragment);
        fragmentTransaction.commit();

    }

    public void logout () {
        Toast.makeText(this, "Login out", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }


}
