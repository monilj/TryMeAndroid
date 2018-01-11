package com.example.monilj.tryme;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private View windowView;
    private Button tryMeButton;
    private int [] colors;
    private SeekBar seekBar;
    private TextView resultTextView;
    private ToggleButton toggleButton;
    private TextView resultView;
    private CheckBox momCheckBox;
    private CheckBox dadCheckBox;
    private CheckBox grandapaCheckBox;
    private TextView showTextView;
    private Button showButton;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colors = new int[]{Color.CYAN,Color.BLACK,Color.BLUE,Color.DKGRAY,Color.LTGRAY,Color.MAGENTA,Color.GREEN,Color.YELLOW};
        windowView = findViewById(R.id.windowViewId);

        tryMeButton = (Button) findViewById(R.id.tryMeButton);
        tryMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random= new Random();
                int randomNum = random.nextInt(colors.length);
                windowView.setBackgroundColor(colors[randomNum]);

//                Log.d("TEST","TAP");

            }
        });

        resultTextView = (TextView) findViewById(R.id.resultIds);
        seekBar = (SeekBar) findViewById(R.id.seekBarId);
        resultTextView.setText("Pain level : " +seekBar.getProgress() +"/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                resultTextView.setTextColor(Color.GRAY);
                resultTextView.setText("Pain level : " +seekBar.getProgress() +"/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            if(seekBar.getProgress() >= 7){
                resultTextView.setTextColor(Color.RED);
            }

            }
        });

        resultView = (TextView) findViewById(R.id.pickAboolTextView);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButtonID);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //toggel is enable
                    resultView.setVisibility(View.VISIBLE);
                }
                else{
                    //toggel is disable
                    resultView.setVisibility(View.INVISIBLE);
                }
            }
        });
        momCheckBox = (CheckBox) findViewById(R.id.momId);
        dadCheckBox = (CheckBox) findViewById(R.id.dadId);
        grandapaCheckBox = (CheckBox) findViewById(R.id.grandpadaId);
        showTextView = (TextView) findViewById(R.id.resultDisplayId);
        showButton = (Button) findViewById(R.id.showButtonID);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(momCheckBox.getText().toString() + " Status is: " + momCheckBox.isChecked() +"\n");
                stringBuilder.append(dadCheckBox.getText().toString()+ " Status is: " +dadCheckBox.isChecked()+"\n");
                stringBuilder.append(grandapaCheckBox.getText().toString()+ " Status is: " +grandapaCheckBox.isChecked()+"\n");
                showTextView.setText(stringBuilder);

            }
        });



    }
}
