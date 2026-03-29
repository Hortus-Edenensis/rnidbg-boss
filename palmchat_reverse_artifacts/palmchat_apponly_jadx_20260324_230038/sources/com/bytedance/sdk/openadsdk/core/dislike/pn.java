package com.bytedance.sdk.openadsdk.core.dislike;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.fx.iz;
import com.bytedance.sdk.openadsdk.core.kj;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.y.jk;
import com.bytedance.sdk.openadsdk.gi.x;
import com.bytedance.sdk.openadsdk.mv.u;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements com.bytedance.sdk.openadsdk.core.dislike.nr.u {
    private String b;
    private final b fx;
    private final WeakReference<Context> nr;
    private boolean pn;
    private final bc u;

    public pn(bc bcVar, Context context, b bVar, boolean z) {
        this.u = bcVar;
        this.nr = new WeakReference<>(context);
        this.fx = bVar;
        this.pn = z;
    }

    private String fx(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("app_name", n.o().q());
            jSONObject.putOpt("app_id", n.o().c());
            jSONObject.putOpt("os_api", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("os_version", Build.VERSION.RELEASE);
            jSONObject.putOpt("manufacturer", Build.MANUFACTURER);
            jSONObject.putOpt("did", jk.o());
            jSONObject.putOpt("sdk_version", 7232);
            jSONObject.putOpt("sdk_api_version", Integer.valueOf(d.fx));
            jSONObject.putOpt("live_sdk_version", com.bytedance.sdk.openadsdk.core.live.nr.u().x());
            jSONObject.putOpt("msg", str);
            jSONObject.putOpt("recordId", str2);
            jSONObject.putOpt("os", AnalyticsConstants.SDK_TYPE);
            jSONObject.putOpt("ad_info", this.u.yf());
            com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm = this.u.tm();
            if (nrVarTm != null) {
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(nrVarTm.bq()));
                jSONObject.putOpt("rit", nrVarTm.bg());
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(final String str) {
        x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.pn.3
            @Override // java.lang.Runnable
            public void run() {
                if (pn.this.nr.get() != null) {
                    h.u((Context) pn.this.nr.get(), str, 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(String str, String str2) throws Throwable {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext()), str);
        file.mkdirs();
        kj kjVar = (kj) dw.u();
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm = this.u.tm();
        JSONObject jSONObjectU = kjVar.u(nrVarTm, new oa(), nrVarTm.bq(), false, 6, false);
        if (jSONObjectU == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.gi.b.u(iz.u().nr(jSONObjectU.toString()).b().toString(), new File(file, "request.info"));
        HashMap map = null;
        com.bytedance.sdk.openadsdk.gi.b.u(com.bytedance.sdk.component.utils.u.u(com.bytedance.sdk.openadsdk.core.pb.n.u((com.bytedance.sdk.openadsdk.core.pb.pn) null).pn()).toString(), new File(file, "setting.info"));
        com.bytedance.sdk.openadsdk.gi.b.u(com.bytedance.sdk.component.utils.u.u(this.u.et()).toString(), new File(file, "meta.info"));
        File fileU = com.bytedance.sdk.openadsdk.gi.b.u(file, str + ".zip");
        String strFx = fx(str2, str);
        HashMap map2 = new HashMap();
        Pair<Integer, JSONObject> pairU = iz.u().u(strFx, false);
        if (pairU != null) {
            map = new HashMap();
            map2.put("deviceInfo", ((JSONObject) pairU.second).optString("message"));
            map.put("x-pglcypher", String.valueOf(pairU.first));
        }
        new com.bytedance.sdk.openadsdk.mv.u().u(this.fx.fx(), fileU, map2, new u.InterfaceC0313u() { // from class: com.bytedance.sdk.openadsdk.core.dislike.pn.5
            @Override // com.bytedance.sdk.openadsdk.mv.u.InterfaceC0313u
            public void u(String str3) {
                pn pnVar = pn.this;
                pnVar.nr(pnVar.pn ? "已复制广告ID\r\n请前往应用内上报问题" : "反馈上传成功！");
            }

            @Override // com.bytedance.sdk.openadsdk.mv.u.InterfaceC0313u
            public void u(int i, String str3) {
                pn pnVar = pn.this;
                pnVar.nr(pnVar.pn ? "反馈失败\r\n 请重新复制" : "反馈失败");
            }
        }, map);
        fileU.delete();
        com.bytedance.sdk.openadsdk.gi.b.nr(file);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.nr.u
    public boolean u(String str, Dialog dialog) {
        if (TextUtils.isEmpty(str) || this.nr.get() == null || !str.startsWith("#oncall#")) {
            return false;
        }
        return u(this.nr.get(), str, dialog);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.nr.u
    public boolean u(com.bytedance.sdk.openadsdk.my.fx.nr.iz izVar, String str, Dialog dialog) {
        com.bytedance.sdk.openadsdk.core.dislike.fx.fx fxVarU = b.u();
        if (fxVarU == null || !TextUtils.equals(izVar.u(), fxVarU.u()) || !TextUtils.equals(izVar.nr(), fxVarU.nr())) {
            return false;
        }
        izVar.nr();
        izVar.u();
        if (this.pn) {
            if (this.b != null) {
                return true;
            }
            String string = UUID.randomUUID().toString();
            this.b = string;
            u(string, str);
            u(this.b);
            return true;
        }
        return u(this.nr.get(), str, dialog);
    }

    private void u(String str) {
        try {
            Context context = this.nr.get();
            if (context == null) {
                return;
            }
            ((ClipboardManager) context.getSystemService(DataType.CLIPBOARD)).setPrimaryClip(ClipData.newPlainText(null, str));
        } catch (Throwable unused) {
        }
    }

    public boolean u(Context context, final String str, Dialog dialog) {
        try {
            if (this.b == null) {
                this.b = UUID.randomUUID().toString();
            }
            if (dialog != null) {
                dialog.dismiss();
            }
            new AlertDialog.Builder(context).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.pn.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    pn pnVar = pn.this;
                    pnVar.u(pnVar.b, str);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.pn.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setMessage(this.fx.b() + "\n\n您此次反馈的id为：" + this.b).setCancelable(true).create().show();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final String str, final String str2) {
        nr("反馈上传中，请您稍等！");
        com.bytedance.sdk.component.jk.x.nr(new a("upload_oncall") { // from class: com.bytedance.sdk.openadsdk.core.dislike.pn.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pn.this.nr(str, str2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void u(Context context, com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar, bc bcVar) {
        if (nrVar == null || bcVar == null) {
            return;
        }
        boolean zFa = dw.nr().fa();
        b bVarZq = dw.nr().zq();
        if (bVarZq == null || TextUtils.isEmpty(bVarZq.fx())) {
            return;
        }
        if (bVarZq.nr() || zFa) {
            nrVar.u(new pn(bcVar, context, bVarZq, zFa));
        }
    }
}
