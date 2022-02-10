package com.algebra.broadcastreciver

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.math.absoluteValue
import kotlin.random.Random

const val CHANNEL_ID          = "MY_CHANNEL"
const val NOTIFICATION_ACTION = "com.algebra.broadcastreciver.NotificationReceiver"

class NotificationReceiver : BroadcastReceiver( ) {

    val TAG = "NotificationReceiver"

    override fun onReceive( context : Context, intent : Intent ) {


        createNotificationChannel( context )

        var builder = NotificationCompat.Builder( context, CHANNEL_ID )
                            .setSmallIcon( R.drawable.ic_launcher_foreground )
                            .setContentTitle( "You got Broadcast" )
                            .setContentText( "This is content" )
                            .setPriority( NotificationCompat.PRIORITY_DEFAULT )

        with( NotificationManagerCompat.from( context ) ) {
            notify( Random.nextInt( ).absoluteValue, builder.build( ) )
        }
    }

    private fun createNotificationChannel( context : Context ) {
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
            val name = "My Channel Name"
            val descriptionText = "Description"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel( CHANNEL_ID, name, importance ).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                context.getSystemService( Context.NOTIFICATION_SERVICE )  as NotificationManager
            notificationManager.createNotificationChannel( channel )
        }
    }
}