package com.lantern.daemon.dp3;

import android.app.Service;
import android.content.Context;
import com.lantern.daemon.dp3.utils.BroadcastReceiverA;
import com.lantern.daemon.dp3.utils.BroadcastReceiverF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AssistFA implements BroadcastReceiverF.IAssist {
    public AssistFA(Service service) {
    }

    @Override // com.lantern.daemon.dp3.utils.BroadcastReceiverF.IAssist
    public void onReceive(Context context) {
        BroadcastReceiverA.send(context, context.getPackageName(), AssistProcessService.class.getName());
    }
}
