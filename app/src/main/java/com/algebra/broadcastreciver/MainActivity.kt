package com.algebra.broadcastreciver

import android.content.BroadcastReceiver
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        register( )
    }

    private fun register( ) {
        val br : BroadcastReceiver = BroadcastWithValue( )
        val filter = IntentFilter( BCAST_ACTION )
        registerReceiver( br, filter )

        registerReceiver( NotificationReceiver( ), IntentFilter( NOTIFICATION_ACTION ) )

    }
}