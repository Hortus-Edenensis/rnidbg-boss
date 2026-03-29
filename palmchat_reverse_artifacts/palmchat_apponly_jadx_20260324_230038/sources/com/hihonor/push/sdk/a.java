package com.hihonor.push.sdk;

import android.util.Log;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a implements k0<HonorPushDataMsg> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorMessageService f6438a;

    public a(HonorMessageService honorMessageService) {
        this.f6438a = honorMessageService;
    }

    @Override // com.hihonor.push.sdk.k0
    public void a(a1 a1Var) {
        if (!a1Var.e()) {
            boolean z = a1Var.b() instanceof JSONException;
            return;
        }
        HonorPushDataMsg honorPushDataMsg = (HonorPushDataMsg) a1Var.c();
        if (honorPushDataMsg == null) {
            Log.i("HonorMessageService", "parse remote data failed.");
            return;
        }
        Log.i("HonorMessageService", "onMessageReceived. msgId is " + honorPushDataMsg.getMsgId());
        this.f6438a.onMessageReceived(honorPushDataMsg);
    }
}
