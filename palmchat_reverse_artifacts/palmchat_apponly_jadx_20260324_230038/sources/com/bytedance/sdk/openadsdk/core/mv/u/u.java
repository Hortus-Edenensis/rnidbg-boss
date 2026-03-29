package com.bytedance.sdk.openadsdk.core.mv.u;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.interact.k;
import com.bytedance.sdk.component.adexpress.nr.t;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.kj.q;
import com.bytedance.sdk.openadsdk.core.l.fx.fx.iz;
import com.bytedance.sdk.openadsdk.core.nr.b;
import com.bytedance.sdk.openadsdk.core.nr.fx;
import com.bytedance.sdk.openadsdk.core.y.pb;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends b implements com.bytedance.sdk.component.adexpress.dynamic.pn.u, fx {
    private WeakReference<ViewGroup> b;
    private bc fx;
    private View jk;
    private int l;
    private boolean nr;
    private volatile boolean pn;
    private k t;
    private t u;

    public u(bc bcVar, WeakReference<ViewGroup> weakReference) {
        super(null);
        this.pn = false;
        this.l = Integer.MIN_VALUE;
        this.fx = bcVar;
        this.b = weakReference;
    }

    private JSONObject b(View view) {
        return new JSONObject();
    }

    private void fx(View view) {
        try {
            u(view, ((Integer) view.getTag()).intValue());
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.k.nr("DynamicClickListener", e2.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.pn.u
    public void nr(View view) {
        this.x.u(view);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.pn.u
    public void u(t tVar) {
        this.u = tVar;
    }

    private void nr() {
        WeakReference<ViewGroup> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null || !pb.u(this.b.get())) {
            return;
        }
        this.l = 1;
        fx(this.jk);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.pn.u
    public void u(boolean z, k kVar) {
        this.pn = true;
        this.nr = z;
        this.t = kVar;
        WeakReference<ViewGroup> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        pb.u(this.b, this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.pn.u
    public void u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.l = jSONObject.optInt("convertActionType", Integer.MIN_VALUE);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.pn.u
    public void u(View view) {
        this.x.nr(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.b
    public void u(View view, jk jkVar) {
        this.jk = view;
        if (this.pn) {
            this.pn = false;
        } else {
            fx(view);
        }
    }

    private void u(View view, int i) {
        CharSequence text;
        if (this.u != null) {
            if (this.nr && this.fx != null) {
                iz.b = true;
            }
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            View viewN = this.x.n();
            if (viewN != null) {
                int[] iArrU = y.u(viewN);
                if (iArrU != null) {
                    iArr = iArrU;
                }
                int[] iArrFx = y.fx(viewN);
                if (iArrFx != null) {
                    iArr2 = iArrFx;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null && text.toString().contains("下载")) {
                    jSONObject.put("is_compliant_download", true);
                }
                jSONObject.putOpt("convertActionType", Integer.valueOf(this.l));
            } catch (Throwable unused) {
            }
            this.u.u(view, i, new q.u().b(this.x.my()).fx(this.x.o()).nr(this.x.sx()).u(this.x.bg()).nr(this.x.s()).u(this.x.k()).u(iArr[0]).nr(iArr[1]).fx(iArr2[0]).b(iArr2[1]).u(b(view)).fx(String.valueOf(i)).nr(String.valueOf(view.getTag(2097610714))).u(String.valueOf(view.getTag(2097610715))).b(String.valueOf(view.getTag(2097610713))).u(this.x.x()).u(jSONObject).u(this.x.l()).u());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.fx
    public void u() {
        nr();
        this.pn = false;
        k kVar = this.t;
        if (kVar != null) {
            kVar.pn();
        }
    }
}
