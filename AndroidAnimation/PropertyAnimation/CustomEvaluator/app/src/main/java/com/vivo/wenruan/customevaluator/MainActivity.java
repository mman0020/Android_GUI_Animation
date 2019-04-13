package com.vivo.wenruan.customevaluator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btn_ani);

        final PositionView positionView = (PositionView) findViewById(R.id.position_view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionView.startPropertyAni();
            }
        });
//        positionView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                positionView.startPropertyAni();
//            }
//        });
    }
}
