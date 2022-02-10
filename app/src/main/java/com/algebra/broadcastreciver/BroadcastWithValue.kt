package com.algebra.broadcastreciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

const val BCAST_ACTION = "com.algebra.broadcastreciver.BroadcastWithValue"
const val BCAST_ATTR   = "com.algebra.broadcastreciver.BroadcastWithValue.Extra"

class BroadcastWithValue : BroadcastReceiver() {

    val TAG = "BroadcastWithValue"

    override fun onReceive( context : Context, intent : Intent ) {

        Log.i( TAG, "BroadcastWithValue zaprimio poruku" )

        if( intent.action==BCAST_ACTION ) {
            val extra = intent.getStringExtra( BCAST_ATTR )
            Toast
                .makeText( context, "Received data from broadcast: $extra", Toast.LENGTH_SHORT )
                .show( )
        }
    }
}