package com.huawei.hms.ads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.SafeIntent;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class am extends ah {
    private static a B = null;
    private static final String Z = "JsbFeedBackClick";

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        private AdContentData I;
        private FeedbackInfo V;
        private RemoteCallResultCallback<String> Z;

        public a(FeedbackInfo feedbackInfo, AdContentData adContentData, RemoteCallResultCallback<String> remoteCallResultCallback) {
            this.V = feedbackInfo;
            this.I = adContentData;
            this.Z = remoteCallResultCallback;
        }

        private void Code(Context context) {
            if (context == null) {
                fh.I(am.Z, "context is null");
                return;
            }
            ah.Code(this.Z, am.this.Code, 1000, 1, true);
            fh.Code(am.Z, "no submit, unregister receiver");
            context.unregisterReceiver(am.B);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = new SafeIntent(intent).getAction();
            if (com.huawei.openalliance.ad.utils.bc.Code(action)) {
                return;
            }
            fh.V(am.Z, "complain action %s", action);
            if (action.equals(com.huawei.openalliance.ad.constant.x.dF + this.I.L())) {
                Code(context, this.I, this.V);
                return;
            }
            if (action.equals(com.huawei.openalliance.ad.constant.x.dG + this.I.L())) {
                Code(context);
            }
        }

        private void Code(Context context, AdContentData adContentData, FeedbackInfo feedbackInfo) {
            if (context == null) {
                fh.I(am.Z, "context is null");
                return;
            }
            am.V(context, adContentData, 3, feedbackInfo);
            ah.Code(this.Z, am.this.Code, 1000, 0, true);
            fh.Code(am.Z, "submit success, unregister receiver");
            context.unregisterReceiver(am.B);
        }
    }

    public am() {
        super(ak.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a Code(Context context, AdContentData adContentData, FeedbackInfo feedbackInfo, RemoteCallResultCallback<String> remoteCallResultCallback) {
        a aVar = new a(feedbackInfo, adContentData, remoteCallResultCallback);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.huawei.openalliance.ad.constant.x.dF + adContentData.L());
        intentFilter.addAction(com.huawei.openalliance.ad.constant.x.dG + adContentData.L());
        com.huawei.openalliance.ad.utils.z.Code(context, aVar, intentFilter, com.huawei.openalliance.ad.utils.z.i(context.getApplicationContext()), null);
        return aVar;
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code(Z, "start");
        final JSONObject jSONObject = new JSONObject(str);
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.am.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                RemoteCallResultCallback remoteCallResultCallback2;
                String str2;
                int i;
                int iOptInt = jSONObject.optInt(com.huawei.openalliance.ad.constant.az.aL, -111111);
                if (adContentData != null) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.huawei.openalliance.ad.constant.az.aM);
                    FeedbackInfo feedbackInfo = (FeedbackInfo) com.huawei.openalliance.ad.utils.ad.V(jSONObjectOptJSONObject.toString(), FeedbackInfo.class, new Class[0]);
                    if (feedbackInfo == null) {
                        return;
                    }
                    Long lValueOf = Long.valueOf(com.huawei.openalliance.ad.utils.bc.Code(jSONObjectOptJSONObject.optString("id"), -111111L));
                    if (lValueOf.longValue() != -111111) {
                        feedbackInfo.Code(lValueOf.longValue());
                        if (iOptInt == 3) {
                            fh.Code(am.Z, "register receiver");
                            a unused = am.B = am.this.Code(context, adContentData, feedbackInfo, (RemoteCallResultCallback<String>) remoteCallResultCallback);
                            Code(context, adContentData, feedbackInfo);
                            return;
                        } else {
                            am.V(context, adContentData, iOptInt, feedbackInfo);
                            remoteCallResultCallback2 = remoteCallResultCallback;
                            str2 = am.this.Code;
                            i = 1000;
                        }
                    } else {
                        fh.V(am.Z, "invalid id");
                        remoteCallResultCallback2 = remoteCallResultCallback;
                        str2 = am.this.Code;
                        i = 4001;
                    }
                } else {
                    fh.Code(am.Z, "ad not exist");
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = am.this.Code;
                    i = 3002;
                }
                ah.Code(remoteCallResultCallback2, str2, i, null, true);
            }

            private boolean Code(Context context2, AdContentData adContentData, FeedbackInfo feedbackInfo) {
                fh.V(am.Z, "click complain");
                if (feedbackInfo == null || context2 == null || adContentData == null) {
                    return false;
                }
                try {
                    SafeIntent safeIntent = new SafeIntent(new Intent());
                    safeIntent.putExtra("package_name", context2.getPackageName());
                    safeIntent.putExtra("slotid", adContentData.L());
                    safeIntent.putExtra("content_id", adContentData.a());
                    safeIntent.putExtra("apiVer", adContentData.aF());
                    safeIntent.putExtra("templateId", adContentData.aE());
                    safeIntent.putExtra(com.huawei.openalliance.ad.constant.be.aB, feedbackInfo.Code());
                    fh.V(am.Z, "jumpToComplain, adContentData.uniqueId: %s", adContentData.aa());
                    safeIntent.putExtra("unique_id", adContentData.aa());
                    safeIntent.setAction(com.huawei.openalliance.ad.constant.x.cY);
                    safeIntent.setPackage(com.huawei.openalliance.ad.utils.z.Z(context2));
                    if (!(context2 instanceof Activity)) {
                        safeIntent.addFlags(268435456);
                    }
                    com.huawei.openalliance.ad.utils.bg.Code(context2, safeIntent);
                } catch (Throwable th) {
                    fh.I(am.Z, "start ac failed: %s", th.getClass().getSimpleName());
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(final Context context, AdContentData adContentData, int i, FeedbackInfo feedbackInfo) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(feedbackInfo);
            if (i == 1) {
                com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.am.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, R.string.hiad_feedback_reduce_such_content, 0).show();
                    }
                });
                jk.Code(context, adContentData, arrayList, 1);
                return;
            }
            int i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    fh.Code(Z, "invalid feedback type");
                    return;
                }
                com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.am.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, R.string.hiad_feedback_reduce_such_content, 0).show();
                    }
                });
            } else {
                com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.am.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, R.string.hiad_feedback_had_feedback, 0).show();
                    }
                });
            }
            jk.Code(context, adContentData, arrayList, i2);
        } catch (Throwable th) {
            fh.I(Z, "itemClickAction error: %s", th.getClass().getSimpleName());
        }
    }
}
