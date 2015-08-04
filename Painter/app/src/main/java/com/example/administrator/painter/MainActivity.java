package com.example.administrator.painter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends Activity {
    private View optionView;
    private PaintView paintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initate();
    }

    private void Initate() {
        paintView = (PaintView)findViewById(R.id.paintView);
        optionView = findViewById(R.id.optionView);

        findViewById(R.id.paintbtn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                optionView.setVisibility(View.GONE);
                paintView.setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.optionbtn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                optionView.setVisibility(View.VISIBLE);
                paintView.setVisibility(View.GONE);
            }
        });

        SeekBar seekBar = (SeekBar)findViewById(R.id.thickBar);
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // TODO Auto-generated method stub
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // TODO Auto-generated method stub
                    }
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        paintView.SetThickness(progress);
                    }
                }
        );

        ColorBtnInit();
    }

    Button.OnClickListener clrBtnListener = new Button.OnClickListener() {
        public void onClick(View v){
            switch (v.getId()){
                case R.id.blackbtn:
                    paintView.SetPaintColor(Color.BLACK);
                    break;
                case R.id.bluebtn:
                    paintView.SetPaintColor(Color.BLUE);
                    break;
                case R.id.orangebtn:
                    paintView.SetPaintColor(0xffffa500);
                    break;
                case R.id.whitebtn:
                    paintView.SetPaintColor(Color.WHITE);
                    break;
                case R.id.yellowbtn:
                    paintView.SetPaintColor(Color.YELLOW);
                    break;
                case R.id.redbtn:
                    paintView.SetPaintColor(Color.RED);
                    break;
                case R.id.greenbtn:
                    paintView.SetPaintColor(Color.GREEN);
                    break;
            }
        }
    };

    private void ColorBtnInit(){
        findViewById(R.id.blackbtn).setOnClickListener(clrBtnListener);
        findViewById(R.id.whitebtn).setOnClickListener(clrBtnListener);
        findViewById(R.id.bluebtn).setOnClickListener(clrBtnListener);
        findViewById(R.id.greenbtn).setOnClickListener(clrBtnListener);
        findViewById(R.id.orangebtn).setOnClickListener(clrBtnListener);
        findViewById(R.id.yellowbtn).setOnClickListener(clrBtnListener);
        findViewById(R.id.redbtn).setOnClickListener(clrBtnListener);
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
