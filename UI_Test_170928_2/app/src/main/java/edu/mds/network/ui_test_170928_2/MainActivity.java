package edu.mds.network.ui_test_170928_2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<Module> module_list = new ArrayList<Module>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //------------------------------------------------------------------------------------------
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //------------------------------------------------------------------------------------------
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //------------------------------------------------------------------------------------------
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //------------------------------------------------------------------------------------------
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //------------------------------------------------------------------------------------------ total data slot
        /*
        // total 정보 표시 슬롯
        ImageView total_icon_module = (ImageView) findViewById(R.id.total_icon_module);
        ImageView total_icon_type = (ImageView) findViewById(R.id.total_icon_type);
        TextView total_text_module = (TextView) findViewById(R.id.total_text_module);
        TextView total_text_type = (TextView) findViewById(R.id.total_text_type);

        total_icon_module.setImageResource(R.mipmap.ic_launcher);
        total_icon_type.setImageResource(R.drawable.ic_menu_camera);
        total_text_module.setText("total generation" + 1000 + " W");
        total_text_type.setText("Server Condition");
        */
        //------------------------------------------------------------------------------------------ module data list
        ListView listview ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.mod_list);
        listview.setAdapter(adapter);

        // 모듈(Icon), 타입(Icon), 이름(String), 타입(String)
        /*
        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_menu_camera),
                ContextCompat.getDrawable(this, R.drawable.ic_menu_gallery),
                "Box", "Account Box Black 36dp") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_menu_send),
                ContextCompat.getDrawable(this, R.drawable.ic_menu_manage),
                "Circle", "Account Circle Black 36dp") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_menu_share),
                ContextCompat.getDrawable(this, R.drawable.ic_menu_slideshow),
                "Ind", "Assignment Ind Black 36dp") ;
        */
        //Module("name","type","version")
        module_list.add(new Module("total","type0","1.00"));
        module_list.add(new Module("module1","type1","1.03"));
        module_list.add(new Module("module2","type3","1.04"));
        module_list.add(new Module("module3","type3","1.10"));
        module_list.add(new Module("module4","type5","2.01"));

        for(int position = 0 ; position < module_list.size() ; position++){
            Drawable module_icon;
            if(module_list.get(position).type == "type0") {
                module_icon = ContextCompat.getDrawable(this, R.drawable.ic_menu_manage);
            }else if(module_list.get(position).type == "type1"){
                module_icon = ContextCompat.getDrawable(this, R.drawable.ic_menu_camera);
            }else if(module_list.get(position).type == "type3"){
                module_icon = ContextCompat.getDrawable(this, R.drawable.ic_menu_send);
            }else if(module_list.get(position).type == "type5"){
                module_icon = ContextCompat.getDrawable(this, R.drawable.ic_menu_manage);
            }else{
                module_icon = ContextCompat.getDrawable(this, R.mipmap.ic_launcher);
            }
            adapter.addItem(module_icon,module_icon,
                    module_list.get(position).name, module_list.get(position).type);
        }


        //------------------------------------------------------------------------------------------
        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id) {
                    // get item
                    ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                    //Drawable icon_module = item.geticon_module() ;
                    //Drawable icon_type = item.geticon_type() ;

                    String text_module = item.gettext_module() ;
                    String text_type = item.gettext_type() ;

                    // TODO : use item data.
                    //Toast.makeText(MainActivity.this, text_module, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent();
                    i.setClass(MainActivity.this, ModuleActivity.class);
                    i.putExtra("name", text_module);
                    i.putExtra("type", text_type);
                    startActivity(i);
                }
        }) ;

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Toast.makeText(MainActivity.this, "nav_camera", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(MainActivity.this, "nav_gallery", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(MainActivity.this, "nav_slideshow", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_share) {
            Toast.makeText(MainActivity.this, "nav_share", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_send) {
            Toast.makeText(MainActivity.this, "nav_send", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}