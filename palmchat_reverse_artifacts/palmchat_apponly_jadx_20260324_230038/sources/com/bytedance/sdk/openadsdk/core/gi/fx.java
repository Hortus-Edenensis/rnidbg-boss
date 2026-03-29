package com.bytedance.sdk.openadsdk.core.gi;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements qq<Bitmap> {
    private com.bytedance.sdk.openadsdk.core.qq.u.nr nr;
    private boolean u;

    public fx(boolean z) {
        this.u = z;
        if (z) {
            this.nr = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr();
        }
    }

    public void b(String str) {
        com.bytedance.sdk.openadsdk.core.qq.u.nr nrVar;
        if (!this.u || (nrVar = this.nr) == null) {
            return;
        }
        nrVar.n(str);
    }

    public void fx(String str) {
        com.bytedance.sdk.openadsdk.core.qq.u.nr nrVar;
        if (!this.u || (nrVar = this.nr) == null) {
            return;
        }
        nrVar.b(str);
    }

    public void nr(String str) {
        com.bytedance.sdk.openadsdk.core.qq.u.nr nrVar;
        if (!this.u || (nrVar = this.nr) == null) {
            return;
        }
        nrVar.iz(str);
    }

    @Override // com.bytedance.sdk.component.iz.qq
    public void onFailed(int i, String str, Throwable th) {
        com.bytedance.sdk.openadsdk.core.qq.u.nr nrVar;
        if (!this.u || (nrVar = this.nr) == null) {
            return;
        }
        nrVar.nr(201).x(x.u(201));
        s.u().u(this.nr);
    }

    @Override // com.bytedance.sdk.component.iz.qq
    public void onSuccess(my<Bitmap> myVar) {
        if (!this.u || this.nr == null) {
            return;
        }
        if (myVar == null || myVar.getResult() == null) {
            this.nr.nr(202).x(x.u(202));
            s.u().u(this.nr);
        }
    }

    public void u(String str) {
        com.bytedance.sdk.openadsdk.core.qq.u.nr nrVar;
        if (!this.u || (nrVar = this.nr) == null) {
            return;
        }
        nrVar.fx(str);
    }

    public void u(int i) {
        com.bytedance.sdk.openadsdk.core.qq.u.nr nrVar;
        if (!this.u || (nrVar = this.nr) == null) {
            return;
        }
        nrVar.u(i);
    }
}
