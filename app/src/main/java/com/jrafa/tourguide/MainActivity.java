package com.jrafa.tourguide;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView navigationViewDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_hamburger);
        setSupportActionBar(toolbar);

        mDrawer = findViewById(R.id.drawer_layout);
        navigationViewDrawer = findViewById(R.id.nvView);
        setupDrawerContent(navigationViewDrawer);

        setFirstItemNavigationView();
    }


    private void setFirstItemNavigationView() {
        navigationViewDrawer.setCheckedItem(R.id.nav_food_fragment);
        navigationViewDrawer.getMenu().performIdentifierAction(R.id.nav_food_fragment, 0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        String titleMenu = getString(R.string.food_title);
        Fragment fragment = null;
        Class fragmentClass;

        switch (menuItem.getItemId()) {
            case R.id.nav_food_fragment:
                fragmentClass = FoodFragment.class;
                titleMenu = getString(R.string.food_title);
                break;
            case R.id.nav_culture_fragment:
                fragmentClass = CultureFragment.class;
                titleMenu = getString(R.string.culture_title);
                break;
            case R.id.nav_embassy_fragment:
                fragmentClass = EmbassyFragment.class;
                titleMenu = getString(R.string.embassy_title);
                break;
            case R.id.nav_artist_fragment:
                fragmentClass = ArtistFragment.class;
                titleMenu = getString(R.string.artist_title);
                break;

            default:
                fragmentClass = FoodFragment.class;

        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.flContent, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null).commit();

        menuItem.setChecked(true);
        setTitle(titleMenu);
        mDrawer.closeDrawers();
    }
}
