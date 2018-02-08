package com.kristal.cloudmessaging

import android.content.Intent
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * Created by Dwi_Ari on 11/3/17.
 */

class FirebaseCloudMessagingIdService : FirebaseInstanceIdService() {
    override fun onTokenRefresh() {
        super.onTokenRefresh()

        FirebaseInstanceId.getInstance().token?.apply {
            Log.d(TAG, "Refreshed token: " + this)
            sendTokenToServer(this)
        }
    }

    override fun handleIntent(p0: Intent?) {
        super.handleIntent(p0)
    }

    fun sendTokenToServer(token: String?) {

    }

    companion object {
        val TAG = FirebaseCloudMessagingIdService::class.java.simpleName
    }
}
