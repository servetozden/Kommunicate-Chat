package com.example.kommunicatechat.notification;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import io.kommunicate.Kommunicate;

public class KommunicateService extends FirebaseMessagingService {

    private static final String TAG = "KmSampleFCMService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i(TAG, "FCM notification processing...");

        if (Kommunicate.isKmNotification(this, remoteMessage.getData())) {
            return;
        }
        super.onMessageReceived(remoteMessage);
    }

    @Override
    public void onNewToken(String registrationId) {
        super.onNewToken(registrationId);

        Log.i(TAG, "Found Registration Id:" + registrationId);

        Kommunicate.updateDeviceToken(this, registrationId);
    }
}