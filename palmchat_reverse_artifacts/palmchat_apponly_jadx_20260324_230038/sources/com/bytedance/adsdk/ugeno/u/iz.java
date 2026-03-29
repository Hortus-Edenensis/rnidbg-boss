package com.bytedance.adsdk.ugeno.u;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz {
    private com.bytedance.adsdk.ugeno.nr.fx b;
    private Context fx;
    private List<u> nr;
    private List<fx> u;

    public iz(Context context, com.bytedance.adsdk.ugeno.nr.fx fxVar, List<fx> list) {
        this.b = fxVar;
        this.fx = context;
        this.u = list;
        b();
    }

    private void b() {
        this.nr = new ArrayList();
        List<fx> list = this.u;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.u.size(); i++) {
            fx fxVar = this.u.get(i);
            if (fxVar != null) {
                this.nr.add(new u(this.fx, this.b, fxVar));
            }
        }
    }

    public void fx() {
        List<u> list = this.nr;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (u uVar : this.nr) {
            if (uVar != null) {
                uVar.fx();
            }
        }
    }

    public void nr() {
        List<u> list = this.nr;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (u uVar : this.nr) {
            if (uVar != null) {
                uVar.u();
            }
        }
    }

    public void u() {
        List<u> list = this.nr;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (u uVar : this.nr) {
            if (uVar != null) {
                uVar.b();
            }
        }
    }

    public void nr(Canvas canvas) {
        List<u> list = this.nr;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (u uVar : this.nr) {
            if (uVar != null) {
                uVar.nr(canvas);
            }
        }
    }

    public void u(Canvas canvas) {
        List<u> list = this.nr;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (u uVar : this.nr) {
            if (uVar != null) {
                uVar.u(canvas);
            }
        }
    }

    public void u(int i, int i2) {
        List<u> list = this.nr;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (u uVar : this.nr) {
            if (uVar != null) {
                uVar.u(i, i2);
            }
        }
    }

    public u u(String str) {
        List<u> list = this.nr;
        if (list != null && !list.isEmpty()) {
            for (u uVar : this.nr) {
                if (uVar != null && TextUtils.equals(uVar.pn(), str)) {
                    return uVar;
                }
            }
        }
        return null;
    }
}
