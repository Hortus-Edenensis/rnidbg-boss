package com.bytedance.sdk.openadsdk.core.q;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.q.u;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fx<T, F extends com.bytedance.sdk.openadsdk.core.q.u> {
    protected final Map<String, nr<T, F>> u = new ConcurrentHashMap();
    private final List<Object> nr = new CopyOnWriteArrayList();
    private Map<String, String> fx = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(com.bytedance.sdk.openadsdk.core.q.u uVar);
    }

    public String nr(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<String> it = this.fx.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            String next = it.next();
            if (!TextUtils.isEmpty(next) && str.contains(next)) {
                str2 = this.fx.get(next);
                str3 = next;
                break;
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            this.fx.remove(str3);
        }
        return str2;
    }

    public void u(String str, u uVar) {
        nr<T, F> nrVar;
        if (uVar == null || str == null || (nrVar = this.u.get(str)) == null) {
            return;
        }
        uVar.u(nrVar.getContext());
    }

    public final void u(String str, pn<? extends com.bytedance.sdk.openadsdk.core.q.u> pnVar) {
        nr<T, F> nrVar;
        if (str == null || (nrVar = this.u.get(str)) == null) {
            return;
        }
        nrVar.u(pnVar);
    }

    private void u(final nr<?, ?> nrVar) {
        if (nrVar == null) {
            return;
        }
        jk.fx().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.q.fx.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = fx.this.nr.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        });
    }

    public void u(String str, nr<T, F> nrVar) {
        if (str != null && nrVar != null) {
            this.u.put(str, nrVar);
        }
        u((nr<?, ?>) nrVar);
    }

    public nr<T, F> u(String str) {
        if (str != null) {
            return this.u.get(str);
        }
        return null;
    }

    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.fx.put(str, str2);
    }
}
