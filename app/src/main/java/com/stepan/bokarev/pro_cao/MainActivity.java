package com.stepan.bokarev.pro_cao;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import androidx.core.view.GravityCompat;

import android.view.MenuItem;


import com.google.android.material.navigation.NavigationView;


import static com.stepan.bokarev.pro_cao.Constants.a0;
import static com.stepan.bokarev.pro_cao.Constants.a1;
import static com.stepan.bokarev.pro_cao.Constants.a10;
import static com.stepan.bokarev.pro_cao.Constants.a11;
import static com.stepan.bokarev.pro_cao.Constants.a12;
import static com.stepan.bokarev.pro_cao.Constants.a13;
import static com.stepan.bokarev.pro_cao.Constants.a14;
import static com.stepan.bokarev.pro_cao.Constants.a15;
import static com.stepan.bokarev.pro_cao.Constants.a16;
import static com.stepan.bokarev.pro_cao.Constants.a17;
import static com.stepan.bokarev.pro_cao.Constants.a18;
import static com.stepan.bokarev.pro_cao.Constants.a19;
import static com.stepan.bokarev.pro_cao.Constants.a2;
import static com.stepan.bokarev.pro_cao.Constants.a20;
import static com.stepan.bokarev.pro_cao.Constants.a21;
import static com.stepan.bokarev.pro_cao.Constants.a22;
import static com.stepan.bokarev.pro_cao.Constants.a23;
import static com.stepan.bokarev.pro_cao.Constants.a24;
import static com.stepan.bokarev.pro_cao.Constants.a25;
import static com.stepan.bokarev.pro_cao.Constants.a26;
import static com.stepan.bokarev.pro_cao.Constants.a27;
import static com.stepan.bokarev.pro_cao.Constants.a28;
import static com.stepan.bokarev.pro_cao.Constants.a3;
import static com.stepan.bokarev.pro_cao.Constants.a4;
import static com.stepan.bokarev.pro_cao.Constants.a5;
import static com.stepan.bokarev.pro_cao.Constants.a6;
import static com.stepan.bokarev.pro_cao.Constants.a7;
import static com.stepan.bokarev.pro_cao.Constants.a8;
import static com.stepan.bokarev.pro_cao.Constants.a9;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static String fragmentIs = a0;
    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Fragment fragment = new Home();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();


        // setApplicationNotification("Оглянитесь во круг! Вы рядос с: Дворец спорта Динамо");

    }

    public void setSupportActionBar(Toolbar toolbar) {
        toolbar.setTitle("PRO Ховрино");
    }

    /*  public  void setApplicationNotification(String name) {
          Calendar c = new GregorianCalendar();
  
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
          Date date = null;
          try {
              date = sdf.parse("2019.3.05 16:00");
  
          } catch (ParseException e) {
              e.printStackTrace();
          }
          long mills = date.getTime();
          Resources res = this.getResources();
          NotificationCompat.Builder builder =
                  new NotificationCompat.Builder(this)
                          .setSmallIcon(android.R.drawable.ic_dialog_email)
                          .setContentTitle("Внимание")
                          .setContentText(name);
  
  
          builder.setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.hovrino));
          builder.setAutoCancel(true); // автоматически закрыть уведомление после нажатия
  
          builder.setWhen(mills);
          builder.setShowWhen(false);
          Notification notification = builder.build();
  
          notification.defaults = Notification.DEFAULT_ALL;
  
          NotificationManager notificationManager =
                  (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
          notificationManager.notify(1, notification);
  
  
  
      }*/
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                backPress();
            }
            //super.onBackPressed();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void backPress() {
        Fragment fragment = null;
        if (fragmentIs.equals(a0)) {
            super.onBackPressed();
        } else if (fragmentIs.equals(a1)) {
            fragment = new ListPlace();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a2)) {
            fragment = new Home();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a3)) {
            // home
            fragmentIs = a0;
        } else if (fragmentIs.equals(a4)) {
            fragment = new ListPlace();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a5)) {
            fragment = new ListPlace();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a6)) {
            fragment = new ListPlace();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a7)) {
            fragment = new ListPlace();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a8)) {
            fragment = new ListPlace();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a9)) {
            fragment = new ListPlace();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a10)) {
            fragment = new ListPlace();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a11)) {
            fragment = new ListPlace();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a12)) {
            fragment = new ListPlace();
            fragmentIs = a12;
        } else if (fragmentIs.equals(a13)) {
            fragment = new Tour();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a14)) {
            fragment = new Xram2();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a15)) {
            fragment = new Lavochkina();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a16)) {
            fragment = new Tour();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a17)) {
            fragment = new Tour();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a18)) {
            fragment = new MetroToMetro();
        } else if (fragmentIs.equals(a19)) {
            fragment = new HouseLebedi();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a20)) {
            fragment = new HeroPanfilovchev();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a21)) {
            fragment = new Hospital();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a22)) {
            fragment = new Tour();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a23)) {
            fragment = new FamileTour();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a24)) {
            fragment = new ParkTour();
            fragmentIs = a0;
        } else if (fragmentIs.equals(a25)) {
            fragment = new CSKA();
            fragmentIs = a0;
        }else if (fragmentIs.equals(a26)) {
            fragment = new Xrams();
            fragmentIs = a0;
        }else if (fragmentIs.equals(a27)) {
            fragment = new Tour();
            fragmentIs = a0;
        }
        else if (fragmentIs.equals(a28)) {
            fragment = new Tour();
            fragmentIs = a0;
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;

        int id = item.getItemId();
        if (id == R.id.nav_tour) {
            fragment = new Tour();
        } else if (id == R.id.nav_place) {
            fragment = new ListPlace();
        } else if (id == R.id.nav_home) {
            fragment = new Home();
        } else if (id == R.id.nav_oblako) {
            fragment = new Oblako();
        }
        if (fragment != null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            // Выделяем выбранный пункт меню в шторке
            item.setChecked(true);
            // Выводим выбранный пункт в заголовке
            toolbar.setTitle(item.getTitle());

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);


        }
        return true;

    }
}

