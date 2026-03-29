package com.lantern.daemon.dp3;

import android.content.Context;
import com.lantern.daemon.dp3.utils.BroadcastReceiverA;
import com.lantern.daemon.dp3.utils.BroadcastReceiverF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class Assist1FA implements BroadcastReceiverF.IAssist {
    public Assist1FA(Assist1ProcessService assist1ProcessService) {
    }

    @Override // com.lantern.daemon.dp3.utils.BroadcastReceiverF.IAssist
    public void onReceive(Context context) {
        BroadcastReceiverA.send(context, context.getPackageName(), Assist1ProcessService.class.getName());
    }
}
