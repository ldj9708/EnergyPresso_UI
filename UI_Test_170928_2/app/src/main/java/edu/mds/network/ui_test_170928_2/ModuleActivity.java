package edu.mds.network.ui_test_170928_2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vgg on 2017-09-28.
 */

public class ModuleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);


        Intent i = getIntent();
        Toast.makeText(this, i.getStringExtra("name")+"  "+i.getStringExtra("type"), Toast.LENGTH_SHORT).show();

        //------------------------------------------------------------------------------------------
        TextView module_data = (TextView) findViewById(R.id.module_status);

        module_data.setText("name\t: " + i.getStringExtra("name"));
        module_data.append("\ntype\t: " + i.getStringExtra("type"));
        module_data.setGravity(Gravity.START);
        //------------------------------------------------------------------------------------------
        Button but_up = (Button) this.findViewById(R.id.module_update);
        Button but_del = (Button) this.findViewById(R.id.module_delete);

        but_up.setOnClickListener(but_upListener);
        but_del.setOnClickListener(but_delListener);
        //------------------------------------------------------------------------------------------
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        //------------------------------------------------------------------------------------------
        TextView module_name = (TextView) findViewById(R.id.module_name);
        module_name.setTextSize(30);
        module_name.setText("name\t:" + i.getStringExtra("name") + '\n' +
                "type\t: " + i.getStringExtra("type"));
        //------------------------------------------------------------------------------------------
        ImageView module_icon = (ImageView) findViewById(R.id.module_icon);
        if(i.getStringExtra("type").equals("type0")) {
            module_icon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_menu_manage));
        }else if(i.getStringExtra("type").equals("type1")){
            module_icon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_menu_camera));
        }else if(i.getStringExtra("type").equals("type3")){
            module_icon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_menu_send));
        }else if(i.getStringExtra("type").equals("type5")){
            module_icon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_menu_manage));
        }else{
            module_icon.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
        }
        //------------------------------------------------------------------------------------------
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    View.OnClickListener but_upListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //
            TextView module_data = (TextView) findViewById(R.id.module_status);

            module_data.append("\nneed Updata");
        }
    };

    View.OnClickListener but_delListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            TextView module_data = (TextView) findViewById(R.id.module_status);

            module_data.append("\ndelete module");
        }
    };

}
