package com.example.administrator.drawing;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;


public class MainActivity extends Activity {
    SurfView surfView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        surfView = new SurfView(this);
        setContentView(surfView);

        Init_Dialog();
    }

    private void Init_Dialog(){
        final LinearLayout linear = (LinearLayout) View.inflate(this, R.layout.param, null);

        new AlertDialog.Builder(this)
                .setTitle("인수 입력")
                .setView(linear)
                .setPositiveButton("Set Value", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dl, int btnNum) {
                        Dialog dialog = (Dialog)dl;

                        EditText a  = (EditText)dialog.findViewById(R.id.aaa);
                        EditText b  = (EditText)dialog.findViewById(R.id.bbb);

                        surfView.param_a = Integer.parseInt(a.getText().toString());
                        surfView.param_b = Integer.parseInt(b.getText().toString());
                        surfView.ThreadStart();
                    }
                })
                .setNegativeButton("Default Value", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dl, int btnNum) {
                        surfView.ThreadStart();
                    }
                })
                .setCancelable(false)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
