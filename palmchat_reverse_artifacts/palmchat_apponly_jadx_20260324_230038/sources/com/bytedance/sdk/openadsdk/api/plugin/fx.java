package com.bytedance.sdk.openadsdk.api.plugin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.plugin.a;
import com.bytedance.sdk.openadsdk.api.plugin.n;
import defpackage.wc7;
import java.io.File;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class fx {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile fx fx;
    private static final String nr;
    private static final String u;
    private final Context b;
    private n.u iz;
    private final Function<SparseArray<Object>, Object> pn = new a.fx();
    private volatile boolean x;

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        sb.append("next");
        u = sb.toString();
        nr = str + "tmp";
    }

    private fx(Context context) {
        this.b = context;
    }

    private File fx() {
        return new File(u(), u);
    }

    private File nr() {
        return new File(u(), nr);
    }

    public static fx u(Context context) {
        if (fx == null) {
            synchronized (fx.class) {
                if (fx == null) {
                    fx = new fx(context);
                }
            }
        }
        return fx;
    }

    public void u(List<n.u> list) {
        if (list != null && !list.isEmpty()) {
            n.u uVar = list.get(0);
            this.iz = uVar;
            if (TextUtils.isEmpty(uVar.fx)) {
                return;
            }
            String str = this.iz.u + "-" + this.iz.nr + "-" + this.iz.iz + "-" + this.iz.x + com.huawei.hms.ads.dynamicloader.b.b;
            File fileFx = fx();
            File file = new File(fileFx, str);
            if (file.exists()) {
                pn.u("plugin_download", "plugin file already exists");
                com.bytedance.sdk.openadsdk.api.iz.nr("FileDownloadTask", "Plugin file already exists.");
                this.iz.f5194a = file.getAbsolutePath();
                n.u uVar2 = this.iz;
                uVar2.jk = uVar2.nr < 7232;
                u(true, uVar2.u, uVar2.toString());
                return;
            }
            File fileNr = nr();
            if (!fileFx.exists()) {
                fileFx.mkdirs();
            }
            if (!fileNr.exists()) {
                fileNr.mkdirs();
            }
            u(this.iz.fx, fileFx.getAbsolutePath(), fileNr.getAbsolutePath(), str);
            return;
        }
        pn.u("plugin_download", "plugin is empty");
    }

    private void u(String str, String str2, String str3, String str4) {
        if (this.x) {
            com.bytedance.sdk.openadsdk.api.iz.nr("FileDownloadTask", "Downloading...");
            return;
        }
        this.x = true;
        try {
            File file = new File(str2 + "/" + str4);
            if (file.exists()) {
                file.delete();
            }
            com.bytedance.sdk.openadsdk.api.plugin.nr.fx.u().u(str, str2, str4, new EventListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.fx.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i, Result result) {
                    fx.this.x = false;
                    if (i != 0) {
                        String strMessage = result.message();
                        pn.u("plugin_download", "download failed: ".concat(String.valueOf(strMessage)));
                        com.bytedance.sdk.openadsdk.api.iz.pn("FileDownloadTask", "Download failed. ".concat(String.valueOf(strMessage)));
                        fx fxVar = fx.this;
                        fxVar.u(false, fxVar.iz.u, fx.this.iz.toString());
                        return null;
                    }
                    pn.u("plugin_download", "download success");
                    fx.this.iz.f5194a = result.message();
                    com.bytedance.sdk.openadsdk.api.iz.nr("FileDownloadTask", "Download end." + fx.this.iz.f5194a);
                    fx.this.iz.jk = fx.this.iz.nr < 7232;
                    fx fxVar2 = fx.this;
                    fxVar2.u(true, fxVar2.iz.u, fx.this.iz.toString());
                    return null;
                }
            });
            pn.u("plugin_download", "start download");
            com.bytedance.sdk.openadsdk.api.iz.nr("FileDownloadTask", "Download start.");
        } catch (Throwable th) {
            pn.u("plugin_download", "download error: ".concat(String.valueOf(th)));
            com.bytedance.sdk.openadsdk.api.iz.pn("FileDownloadTask", "Download file error: ".concat(String.valueOf(th)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z, String str, String str2) {
        ValueSet valueSetA = wc7.b().f(-999900, z ? 0 : 1004).j(-999903, z).h(-999902, wc7.b().i(2, str2).i(3, str).a().sparseArray()).a();
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 1);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(-99999979, valueSetA.sparseArray());
        this.pn.apply(sparseArray);
    }

    private File u() {
        return nr.u(this.b, "tt_pangle_bykv_file", 0);
    }
}
