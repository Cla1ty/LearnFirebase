package com.kristal.cloudmessaging

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().subscribeToTopic("news")
//        RemoteMessage()
//        FirebaseMessaging.getInstance().send()
//        FirebaseMessaging.getInstance().unsubscribeFromTopic("news")
    }

    // This snippet takes the simple approach of using the first returned Google account,
    // but you can pick any Google account on the device.
//    fun getAccount(): String? {
//        val accounts = AccountManager.get(this).getAccountsByType("com.google")
//        return if (accounts.size == 0) {
//            null
//        } else accounts[0].name
//    }

    fun send(){
        val fm = FirebaseMessaging.getInstance()
//        fm.send(RemoteMessage.Builder(SENDER_ID + "@gcm.googleapis.com")
//                .setMessageId(Integer.toString(msgId.incrementAndGet()))
//                .addData("my_message", "Hello World")
//                .addData("my_action", "SAY_HELLO")
//                .build())
    }
}
