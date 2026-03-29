package com.qq.gdt.action.i;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.igexin.assist.sdk.AssistPushConsts;
import com.opos.mobad.activity.VideoActivity;
import com.qq.gdt.action.d;
import com.qq.gdt.action.j.f;
import com.qq.gdt.action.j.n;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.j.v;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(List<com.qq.gdt.action.c.a> list, int i, String str, int i2);

        void a(List<com.qq.gdt.action.c.a> list, boolean z);
    }

    public static void a(List<com.qq.gdt.action.c.a> list, long j, String str, int i, String str2, int i2) {
        try {
            for (com.qq.gdt.action.c.a aVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("duration", Long.valueOf(System.currentTimeMillis() - j));
                jSONObject.putOpt("httpStatus", Integer.valueOf(i2));
                jSONObject.putOpt(VideoActivity.EXTRA_KEY_ACTION_TYPE, aVar.c());
                jSONObject.putOpt("actionTime", Long.valueOf(aVar.d()));
                jSONObject.putOpt("uniqActionId", aVar.a());
                jSONObject.putOpt("errorCode", Integer.valueOf(i));
                jSONObject.putOpt(MediationConstant.KEY_ERROR_MSG, str2);
                jSONObject.putOpt("requestCgi", str);
                com.qq.gdt.action.h.a.a(i == 0 ? 9002 : 9003, aVar, d.a().a(jSONObject));
            }
        } catch (JSONException e) {
            o.a("doDp3Report err", e);
            com.qq.gdt.action.h.a.a(9004);
        }
    }

    public static void a(final List<com.qq.gdt.action.c.a> list, final a aVar) {
        if (f.a(list)) {
            o.b("No actions need to track.");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObjectA = com.qq.gdt.action.c.a();
            JSONArray jSONArrayA = com.qq.gdt.action.c.a(list);
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("info", jSONObjectA);
            jSONObject.putOpt(AssistPushConsts.MSG_TYPE_ACTIONS, jSONArrayA);
            o.a("TrackService#track\n加密前：\n" + n.a(jSONObject.toString()), new Object[0]);
            String strA = com.qq.gdt.action.c.a(jSONObject);
            o.a("加密后：\n" + strA, new Object[0]);
            String strA2 = com.qq.gdt.action.c.a(strA);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("v", "0.1");
            jSONObject2.putOpt("id", d.a().h());
            jSONObject2.putOpt("data", strA);
            jSONObject2.putOpt("sign", strA2);
            o.a("正式请求：\n" + n.a(jSONObject2.toString()), new Object[0]);
            final String strOptString = jSONObjectA.optString("hash_imei", "");
            com.qq.gdt.action.f.b.d().a("https://api.datanexus.qq.com/data-nexus-cgi/sdk").a(jSONObject2.toString().getBytes()).b().a(new com.qq.gdt.action.f.a.c() { // from class: com.qq.gdt.action.i.c.1
                @Override // com.qq.gdt.action.f.a.a
                public void a(int i, com.qq.gdt.action.f.f fVar) {
                    c.a(list, jCurrentTimeMillis, "https://api.datanexus.qq.com/data-nexus-cgi/sdk", fVar.a(), fVar.b(), i);
                    if (i == 200 && fVar.a() == 0) {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(list, !v.a(strOptString));
                            return;
                        }
                        return;
                    }
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.a(list, fVar.a(), fVar.b(), i);
                    }
                }

                @Override // com.qq.gdt.action.f.a.a
                public void b(Throwable th) {
                    int i;
                    o.a("onFail:" + th.getMessage(), new Object[0]);
                    if (th.getMessage() != null) {
                        i = th.getMessage().contains("java.net.SocketTimeoutException") ? -2 : -1;
                        if (th.getMessage().contains("java.net.UnknownHostException")) {
                            i = -9;
                        }
                        if (th.getMessage().contains("java.net.ConnectException")) {
                            i = -4;
                        }
                        if (th.getMessage().contains("java.net.ProtocolException")) {
                            i = -5;
                        }
                        if (th.getMessage().contains("java.net.UnknownServiceException")) {
                            i = -6;
                        }
                        if (th.getMessage().equals("body null")) {
                            i = -7;
                        }
                        if (th.getMessage().contains("unexpected end of stream on com.android.okhttp")) {
                            i = -8;
                        }
                    } else {
                        i = -1;
                    }
                    c.a(list, jCurrentTimeMillis, "https://api.datanexus.qq.com/data-nexus-cgi/sdk", i, th.getMessage(), -1);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(list, i, th.getMessage(), -1);
                    }
                }
            });
        } catch (Throwable th) {
            o.c("处理行为数据请求时发生错误：" + th.getMessage());
            if (aVar != null) {
                aVar.a(list, -1, th.getMessage(), -1);
            }
        }
    }
}
