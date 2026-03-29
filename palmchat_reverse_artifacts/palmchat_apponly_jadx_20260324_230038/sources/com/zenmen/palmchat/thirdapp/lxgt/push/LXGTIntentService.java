package com.zenmen.palmchat.thirdapp.lxgt.push;

import android.content.Context;
import android.util.Log;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LXGTIntentService extends GTIntentService {
    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveClientId(Context context, String str) {
        Log.e(GTIntentService.TAG, "onReceiveClientId -> clientid = " + str);
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveMessageData(Context context, GTTransmitMessage gTTransmitMessage) {
        Log.d(GTIntentService.TAG, "receiver payload = " + new String(gTTransmitMessage.getPayload()));
        gTTransmitMessage.getTaskId();
        gTTransmitMessage.getMessageId();
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onNotificationMessageArrived(Context context, GTNotificationMessage gTNotificationMessage) {
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onNotificationMessageClicked(Context context, GTNotificationMessage gTNotificationMessage) {
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveCommandResult(Context context, GTCmdMessage gTCmdMessage) {
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveOnlineState(Context context, boolean z) {
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveServicePid(Context context, int i) {
    }
}
