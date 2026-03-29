package com.bytedance.sdk.openadsdk.core.bq.u;

import android.text.TextUtils;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class xg extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    public final com.bytedance.sdk.openadsdk.core.ja u;

    public xg(com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.u = jaVar;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("sendLog", (com.bytedance.sdk.component.u.pn<?, ?>) new xg(jaVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        long j;
        JSONObject jSONObjectMv;
        com.bytedance.sdk.openadsdk.core.dw.b bVar;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extJson");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString(com.huawei.openalliance.ad.constant.x.cw);
                    String strOptString2 = jSONObjectOptJSONObject.optString("tag");
                    String strOptString3 = jSONObjectOptJSONObject.optString("label");
                    if (!this.u.iz(strOptString3)) {
                        jSONObject2.put("code", 1);
                        jSONObject2.put("msg", "is not reportclickother");
                        return jSONObject2;
                    }
                    if (com.bytedance.sdk.openadsdk.core.kj.wq.nr(this.u.n()) && TextUtils.equals(strOptString3, FFmpegMediaMetadataRetriever.METADATA_KEY_TRACK)) {
                        jSONObject2.put("code", 1);
                        jSONObject2.put("msg", "track is not send");
                        return jSONObject2;
                    }
                    long j2 = 0;
                    try {
                        j = Long.parseLong(jSONObjectOptJSONObject.optString(ActionUtils.PAYMENT_AMOUNT));
                    } catch (Exception unused) {
                        j = 0;
                    }
                    try {
                        j2 = Long.parseLong(jSONObjectOptJSONObject.optString("ext_value"));
                    } catch (Exception unused2) {
                    }
                    long j3 = j2;
                    JSONObject jSONObject3 = new JSONObject();
                    String strOptString4 = jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_EXTRA);
                    if (!TextUtils.isEmpty(strOptString4)) {
                        try {
                            jSONObject3 = new JSONObject(strOptString4);
                        } catch (Exception unused3) {
                        }
                    }
                    this.u.u(strOptString3, jSONObject3);
                    if ("click".equals(strOptString3)) {
                        jSONObjectMv = this.u.mv(jSONObject3);
                        WeakReference<com.bytedance.sdk.openadsdk.core.dw.b> weakReferenceJk = this.u.jk();
                        if (weakReferenceJk != null && (bVar = weakReferenceJk.get()) != null) {
                            bVar.nr();
                        }
                    } else {
                        jSONObjectMv = jSONObject3;
                    }
                    com.bytedance.sdk.openadsdk.core.s.b.u(strOptString, this.u.u(strOptString2, strOptString3), strOptString3, j, j3, jSONObjectMv);
                    jSONObject2.put("code", 0);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("msg", "extJson is null");
                }
            } else {
                jSONObject2.put("code", 1);
                jSONObject2.put("msg", "params is null");
            }
        } catch (Throwable th) {
            jSONObject2.put("code", 1);
            jSONObject2.put("msg", "exception: " + th.getMessage());
        }
        return jSONObject2;
    }
}
