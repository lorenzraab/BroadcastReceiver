package com.example.fragezeichen.broad;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.widget.Toast;



public class Caster extends AppCompatActivity {
    private BroadcastReceiver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caster);
        receiver=new Screen_ON();
        IntentFilter filter =new IntentFilter(Intent.ACTION_SCREEN_ON  );
        this.registerReceiver(receiver, filter);

    }


    private class Screen_ON extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            Toast.makeText(context, "Wendy, I'm home.", Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public void onDestroy() {
        this.unregisterReceiver(receiver);
        receiver=null;
        super.onDestroy();
    }
}
