package com.bytedance.sdk.openadsdk.core.ugeno.webview;

import android.content.Context;
import android.util.SparseArray;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.adsdk.ugeno.fx.s;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.bg.b;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.l.fx.jk;
import com.bytedance.sdk.openadsdk.core.s.iz;
import com.bytedance.sdk.openadsdk.core.widget.u.fx;
import com.bytedance.sdk.openadsdk.core.widget.u.nr;
import com.bytedance.sdk.openadsdk.core.y.c;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.xg;
import com.bytedance.sdk.openadsdk.gi.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class PageWebView extends FrameLayout implements b {
    private static final SparseArray<WeakReference<DownloadListener>> u = new SparseArray<>();
    private bc b;
    private Context fx;
    private s iz;
    private SSWebView nr;
    private ja pn;

    public PageWebView(@NonNull Context context) {
        super(context);
        this.fx = context;
        SSWebView sSWebView = new SSWebView(context);
        this.nr = sSWebView;
        sSWebView.setMaterialMeta(xg.u(this.b));
        addView(this.nr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(JSONObject jSONObject) {
        WeakReference<DownloadListener> weakReference;
        nr.u(this.fx).u(false).nr(false).u(this.nr);
        SSWebView sSWebView = this.nr;
        if (sSWebView != null) {
            c.u(sSWebView, d.fx, bc.b(this.b));
        }
        this.nr.setMixedContentMode(0);
        if (jSONObject == null || (weakReference = u.get(jSONObject.hashCode())) == null || weakReference.get() == null) {
            return;
        }
        this.nr.setDownloadListener(weakReference.get());
    }

    public void nr(final JSONObject jSONObject) {
        x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.webview.PageWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PageWebView.this.fx(jSONObject);
            }
        });
    }

    public void setMeta(bc bcVar) {
        this.b = bcVar;
        SSWebView sSWebView = this.nr;
        if (sSWebView != null) {
            sSWebView.setMaterialMeta(xg.u(bcVar));
        }
    }

    public void setUGenContext(s sVar) {
        this.iz = sVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.b
    public void u(boolean z, JSONArray jSONArray) {
    }

    public static void u(JSONObject jSONObject, DownloadListener downloadListener) {
        if (downloadListener == null || jSONObject == null) {
            return;
        }
        u.put(jSONObject.hashCode(), new WeakReference<>(downloadListener));
    }

    public static void u(JSONObject jSONObject) {
        if (jSONObject != null) {
            u.remove(jSONObject.hashCode());
        }
    }

    public void u() {
        Map<String, Object> mapNr;
        if (this.nr == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.b);
        this.pn = new ja(this.fx);
        s sVar = this.iz;
        if (sVar != null && (mapNr = sVar.nr()) != null && mapNr.containsKey("key_reward_page")) {
            Object obj = mapNr.get("key_reward_page");
            if (obj instanceof Map) {
                this.pn.u((Map<String, Object>) obj);
            }
        }
        this.pn.nr(this.nr).u(this.b).fx(arrayList).nr(this.b.lk()).b(this.b.ap()).fx(7).u(jp.nr(this.b)).pn(jp.sx(this.b)).u(this.nr).u(true).nr(jk.u(this.b)).u((b) this);
        this.nr.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.u.b(this.fx, this.pn, this.b.lk(), new iz(this.b, this.nr), null));
        this.nr.setWebChromeClient(new fx(this.pn));
    }

    public void u(String str) {
        SSWebView sSWebView = this.nr;
        if (sSWebView != null) {
            sSWebView.loadUrl(str);
        }
    }
}
