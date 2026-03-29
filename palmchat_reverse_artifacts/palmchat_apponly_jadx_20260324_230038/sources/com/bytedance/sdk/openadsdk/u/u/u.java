package com.bytedance.sdk.openadsdk.u.u;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.y.qq;
import com.bytedance.sdk.openadsdk.k.b;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import defpackage.qh4;
import defpackage.rh4;
import defpackage.sh4;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f5434a = null;
    private static volatile String iz = "";
    private static volatile u u;
    private final String b;
    private volatile boolean fx;
    private volatile int n;
    private rh4 nr;
    private volatile String pn;
    private final AtomicBoolean x = new AtomicBoolean(false);

    private u(String str) {
        this.n = 99999;
        String strC = n.o().c();
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
        if (bVarSx != null) {
            if (!bVarSx.fx() || !bVarSx.b() || !bVarSx.pn()) {
                this.n = MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET;
            }
            if (d.fx >= 4600 && !bVarSx.iz()) {
                this.n = MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET;
            }
        }
        this.pn = null;
        this.b = strC;
        this.fx = pn(str);
    }

    private static u b(String str) {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u(str);
                }
            }
        }
        return u;
    }

    private boolean pn(String str) {
        try {
            Context context = dw.getContext();
            qh4.a aVar = new qh4.a("1371", this.b, "THYFfhd167Y/Etj/JFI+OYhGnAsIhCvIXKQbbKuslfRMO6XQmCuZImqOyljyF6dQ900Hy8ecQzUcHu72ks7Xvvncqt7BZjf4VSth/OzZbJlDJqtayy2lcb5mqCQUzE5fIvFXAZkyxl+SRzGnzUojBcyqITZ3bGRvteMi+qu/15oKM3BWY0IDJ9Ry5FUGfzt+FyCqvZI8PFQNAzvZXcWHlJoRXydZUjUbtEy/AFUvusIO1HDx", this.n);
            aVar.d(new PglITokenObserver() { // from class: com.bytedance.sdk.openadsdk.u.u.u.1
                @Override // com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver
                public void onTokenLoaded(String str2) {
                    String unused = u.iz = str2;
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.fx.b.u().k(str2);
                }
            });
            if (!n.o().n()) {
                aVar.h("kOA1", "1");
            } else if (!n.o().t()) {
                aVar.l(str);
            }
            if (!n.o().pn()) {
                aVar.h("kS1", "1");
            }
            if (!n.o().l()) {
                aVar.h("kDisableBlueToothCollection", "1");
            }
            if (!n.o().s()) {
                aVar.h("kDisableIpCollection", "1");
            }
            com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
            if (bVarSx != null && !bVarSx.nr()) {
                aVar.h("kDisableAppListCollection", "1");
                aVar.h("kDisableImeListCollection", "1");
            }
            sh4.b(context, aVar.k(this.pn).j(1).i());
            sh4.c("1371");
            fx();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static u u() {
        return u;
    }

    public void nr(String str) {
        if (this.fx) {
            fx();
            rh4 rh4Var = this.nr;
            if (rh4Var != null) {
                rh4Var.b(str);
            }
        }
    }

    private void fx() {
        if (this.nr == null) {
            this.nr = sh4.a("1371");
        }
    }

    public void u(String str) {
        if (this.fx) {
            fx();
            if (TextUtils.isEmpty(str) || str.equals(this.pn) || this.nr == null) {
                return;
            }
            this.pn = str;
            this.nr.c(str);
        }
    }

    public static String nr() {
        if (TextUtils.isEmpty(iz)) {
            iz = com.bytedance.sdk.openadsdk.core.fx.b.u().dw();
        }
        return iz;
    }

    public Map<String, String> u(String str, byte[] bArr) {
        if (!this.fx) {
            return new HashMap();
        }
        fx();
        rh4 rh4Var = this.nr;
        if (rh4Var != null) {
            return rh4Var.a(str, bArr);
        }
        return new HashMap();
    }

    public static void u(b bVar) {
        f5434a = bVar;
        u(true);
    }

    public static u u(boolean z) {
        if (n.o().jk()) {
            if (f5434a != null) {
                if (u == null) {
                    return b(qq.fx(f5434a));
                }
                return u;
            }
            if (z) {
                return b("error");
            }
            return null;
        }
        return b(null);
    }
}
