package com.huawei.openalliance.ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jl;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.w;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.k;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.bl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c extends BroadcastReceiver {
    private eh F;
    private Context S;

    public c(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.S = applicationContext;
        this.F = eh.Code(applicationContext);
    }

    private void V(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("splash_skip_area");
        String strOptString = jSONObject.optString(be.J);
        if (fh.Code()) {
            fh.Code("ExLinkedSplashReceiver", "splashSkipArea=%s", Integer.valueOf(iOptInt));
            fh.Code("ExLinkedSplashReceiver", "globalSwitch=%s", bl.Code(strOptString));
        }
        eh ehVar = this.F;
        if (ehVar != null) {
            ehVar.C(iOptInt);
            this.F.I(strOptString);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        Log.d("ExLinkedSplashReceiver", "onReceive.");
        if (intent == null) {
            return;
        }
        try {
            if (x.bv.equals(intent.getAction())) {
                fh.V("ExLinkedSplashReceiver", "receiver exlinkedsplash action");
                Long lValueOf = Long.valueOf(intent.getLongExtra(w.ab, 0L));
                int intExtra = intent.getIntExtra(w.ac, 0);
                String stringExtra = intent.getStringExtra(w.ad);
                String stringExtra2 = intent.getStringExtra("linked_content_slotId");
                String stringExtra3 = intent.getStringExtra("unique_id");
                int intExtra2 = intent.getIntExtra(w.ae, 0);
                fh.Code("ExLinkedSplashReceiver", "ExLinkedSplashReceiver, startTime: %s, showTime: %s, contentId: %s", lValueOf, Integer.valueOf(intExtra), stringExtra);
                context.removeStickyBroadcast(intent);
                eh ehVar = this.F;
                if (ehVar != null) {
                    ehVar.V(lValueOf.longValue());
                    this.F.Z(intExtra);
                    this.F.V(stringExtra);
                    this.F.B(intExtra2);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("content_id", stringExtra);
                jSONObject.put("package_name", this.S.getPackageName());
                jSONObject.put(be.H, false);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    jSONObject.put("slotid", stringExtra2);
                }
                if (!TextUtils.isEmpty(stringExtra3)) {
                    jSONObject.put("unique_id", stringExtra3);
                }
                com.huawei.openalliance.ad.ipc.d.Code(context).Code("reqLinkedVideo", jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.c.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != 200) {
                            fh.I("ExLinkedSplashReceiver", "call reqExLinked failed");
                            c.this.Code();
                            return;
                        }
                        fh.V("ExLinkedSplashReceiver", "reqExLinkedVideo success");
                        try {
                            final AdContentData adContentDataCode = c.this.Code(new JSONObject(callResult.getData()));
                            if (adContentDataCode != null) {
                                adContentDataCode.C(true);
                                final k kVarCode = jl.Code(adContentDataCode);
                                kVarCode.Code(true);
                                final com.huawei.openalliance.ad.inter.listeners.f fVarC = g.Code(context).C();
                                if (fVarC != null) {
                                    com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.inter.c.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            String strR;
                                            String strD;
                                            boolean zCode = fVarC.Code(kVarCode);
                                            fh.V("ExLinkedSplashReceiver", "onReceive, isCanDisplay: %s", Boolean.valueOf(zCode));
                                            if (zCode) {
                                                return;
                                            }
                                            fh.I("ExLinkedSplashReceiver", "isCanDisplay false, start show normal splash. ");
                                            c.this.Code();
                                            k kVar = kVarCode;
                                            if (kVar != null) {
                                                strD = kVar.d();
                                                strR = kVarCode.r();
                                            } else {
                                                strR = null;
                                                strD = null;
                                            }
                                            db.Code(context, strR, strD, 0L, adContentDataCode, "82");
                                        }
                                    });
                                    return;
                                }
                                fh.I("ExLinkedSplashReceiver", "exSplashCallback is null");
                            } else {
                                fh.I("ExLinkedSplashReceiver", "content is null");
                            }
                            c.this.Code();
                        } catch (JSONException unused) {
                            fh.I("ExLinkedSplashReceiver", "reqLinkedVideo onRemoteCallResult JSONException ");
                        }
                    }
                }, String.class);
            }
        } catch (JSONException unused) {
            fh.I("ExLinkedSplashReceiver", "reqExLinkedVideo JSONException");
            Code();
        } catch (Throwable th) {
            fh.I("ExLinkedSplashReceiver", "reqLinkedVideo exception: %s", th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdContentData Code(JSONObject jSONObject) {
        String strOptString;
        AdContentData adContentData;
        AdContentData adContentData2 = null;
        try {
            strOptString = jSONObject.optString("contentRecord");
            adContentData = (AdContentData) ad.V(strOptString, AdContentData.class, new Class[0]);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (fh.Code()) {
                fh.Code("ExLinkedSplashReceiver", " adContent content=%s", bl.Code(strOptString));
            }
            if (adContentData == null) {
                return adContentData;
            }
            V(jSONObject);
            return adContentData;
        } catch (Throwable th2) {
            th = th2;
            adContentData2 = adContentData;
            fh.I("ExLinkedSplashReceiver", "handleResponse exception: %s", th.getClass().getSimpleName());
            return adContentData2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code() {
        com.huawei.openalliance.ad.ipc.d.Code(this.S).Code("showSplash", null, null, null);
    }
}
