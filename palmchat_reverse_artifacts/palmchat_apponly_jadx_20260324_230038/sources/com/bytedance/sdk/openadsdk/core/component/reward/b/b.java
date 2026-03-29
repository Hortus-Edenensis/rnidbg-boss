package com.bytedance.sdk.openadsdk.core.component.reward.b;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static int u(bc bcVar) {
        if (fx.u(bcVar)) {
            return fx.nr(bcVar);
        }
        if (jk.u(bcVar)) {
            return jk.nr(bcVar);
        }
        if (t.u(bcVar)) {
            return t.nr(bcVar);
        }
        if (x.u(bcVar)) {
            return x.nr(bcVar);
        }
        if (pn.u(bcVar)) {
            return pn.nr(bcVar);
        }
        if (iz.u(bcVar)) {
            return iz.nr(bcVar);
        }
        if (n.u(bcVar)) {
            return n.nr(bcVar);
        }
        if (l.u(bcVar)) {
            return l.nr(bcVar);
        }
        return -1;
    }

    public static u u(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar) {
        if (a.u(tTBaseVideoActivity, bcVar)) {
            return new a(tTBaseVideoActivity, bcVar);
        }
        if (jk.u(bcVar)) {
            return new jk(tTBaseVideoActivity, bcVar);
        }
        if (fx.u(bcVar)) {
            return new fx(tTBaseVideoActivity, bcVar);
        }
        if (t.u(bcVar)) {
            return new t(tTBaseVideoActivity, bcVar);
        }
        if (x.u(bcVar)) {
            return new x(tTBaseVideoActivity, bcVar);
        }
        if (pn.u(bcVar)) {
            return new pn(tTBaseVideoActivity, bcVar);
        }
        if (iz.u(bcVar)) {
            return new iz(tTBaseVideoActivity, bcVar);
        }
        if (n.u(bcVar)) {
            return new n(tTBaseVideoActivity, bcVar);
        }
        if (l.u(bcVar)) {
            return new l(tTBaseVideoActivity, bcVar);
        }
        return null;
    }
}
