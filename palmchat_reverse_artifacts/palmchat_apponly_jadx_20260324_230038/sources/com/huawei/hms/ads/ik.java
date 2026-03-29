package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ik extends ih<lu> implements iw {

    /* JADX INFO: renamed from: com.huawei.hms.ads.ik$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String Code;

        public AnonymousClass1(String str) {
            this.Code = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.huawei.openalliance.ad.constant.be.E, this.Code);
                com.huawei.openalliance.ad.ipc.g.V(ik.this.V).Code(com.huawei.openalliance.ad.constant.s.i, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.ik.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        final String data = callResult.getData();
                        if (TextUtils.isEmpty(data) || !data.startsWith(com.huawei.openalliance.ad.constant.ce.CONTENT.toString())) {
                            return;
                        }
                        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ik.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((lu) ik.this.I()).Code(data);
                            }
                        });
                    }
                }, String.class);
            } catch (JSONException unused) {
                fh.Code("PPSVideoViewPresenter", "check video cache jsonEx");
                com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ik.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((lu) ik.this.I()).Code(AnonymousClass1.this.Code);
                    }
                });
            }
        }
    }

    public ik(Context context, lu luVar) {
        super(context, luVar);
    }

    @Override // com.huawei.hms.ads.iw
    public void Code(long j, long j2, long j3) {
        long j4 = 0;
        if (j == 0 || j >= j3) {
            return;
        }
        long j5 = j3 - j;
        if (j2 != 0 && j2 < j3) {
            j4 = j3 - j2;
        }
        db.Code(this.V, this.Code, j5, j4);
    }

    @Override // com.huawei.hms.ads.iw
    public void F() {
        jk.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.aj.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.ih
    public void V(String str) {
        ((lu) I()).B();
        fh.V("PPSVideoViewPresenter", "onMaterialLoaded - begin to load video");
        if (TextUtils.isEmpty(str) || !str.startsWith(com.huawei.openalliance.ad.constant.ce.CONTENT.toString())) {
            fh.V("PPSVideoViewPresenter", "check if video cached.");
            com.huawei.openalliance.ad.utils.i.I(new AnonymousClass1(str));
        } else {
            fh.V("PPSVideoViewPresenter", "video is cached.");
            ((lu) I()).Code(str);
        }
    }

    @Override // com.huawei.hms.ads.iw
    public void Code(long j, long j2, long j3, long j4) {
        jk.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.aj.Z, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf((int) j3), Integer.valueOf((int) j4));
    }

    @Override // com.huawei.hms.ads.iw
    public void Code(boolean z) {
        AdEventReport adEventReportCode = jk.Code(this.Code);
        adEventReportCode.I(z);
        com.huawei.openalliance.ad.ipc.g.V(this.V).Code(com.huawei.openalliance.ad.constant.s.j, com.huawei.openalliance.ad.utils.ad.V(adEventReportCode), null, null);
    }
}
