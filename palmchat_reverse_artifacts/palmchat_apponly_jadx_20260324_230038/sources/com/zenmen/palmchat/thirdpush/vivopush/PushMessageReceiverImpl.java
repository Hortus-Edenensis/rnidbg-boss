package com.zenmen.palmchat.thirdpush.vivopush;

import android.content.Context;
import android.util.Log;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PushMessageReceiverImpl extends OpenClientPushMessageReceiver {
    public static final String TAG = "PushMessageReceiverImpl";

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage) {
        Log.d(TAG, "通知点击 msgId " + uPSNotificationMessage.getMsgId() + " ;customContent=" + uPSNotificationMessage.getSkipContent());
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(Context context, String str) {
        Log.d(TAG, "onReceiveRegId regId = " + str);
    }
}
