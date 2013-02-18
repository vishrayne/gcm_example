package com.example.gcmexampleapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;

public class GCMIntentService extends GCMBaseIntentService {

    public GCMIntentService() {
        super(Constants.SENDER_ID);
    }

    public GCMIntentService(String... senderIds) {
        super(senderIds);
    }

    @Override
    protected void onError(Context arg0, String arg1) {
        Log.i(Constants.TAG, "OnError: " + arg1);
    }

    @Override
    protected void onMessage(Context arg0, Intent message) {
        Bundle extras = message.getExtras();

        for (String key : extras.keySet()) {
            Log.d(Constants.TAG, String.format("onMessage: %s=%s", key, extras.getString(key)));
        }
    }

    @Override
    protected void onRegistered(Context arg0, String arg1) {
        Log.i(Constants.TAG, "onRegistered: " + arg1);
    }

    @Override
    protected void onUnregistered(Context arg0, String arg1) {
        Log.i(Constants.TAG, "onUnregistered: " + arg1);
    }

}
