package com.kristal.cloudmessaging

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Created by Dwi_Ari on 11/3/17.
 */

class FirebaseCloudMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)

        Log.d(TAG, "Received")
        if(p0 == null) return

        Log.d(TAG, "From: " + p0.from)

        p0.data?.apply {
            if(size > 0){
                Log.d(TAG, "Message data payload: " + this)

                if (/* Check if data needs to be processed by long running job */ true) {
                    // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
//                scheduleJob();
                } else {
                    // Handle message within 10 seconds
//                handleNow();
                }
            }
        }

        p0.notification?.apply {
            Log.d(TAG, "Message Notification Body: " + body)
        }
    }

    companion object {
        val TAG = FirebaseCloudMessagingService::class.java.simpleName
    }
}
