package com.bytedance.sdk.component.fx.nr.u.fx;

import com.bytedance.sdk.component.fx.nr.bg;
import com.bytedance.sdk.component.fx.nr.z;
import java.net.Proxy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private static boolean nr(z zVar, Proxy.Type type) {
        return !zVar.n() && type == Proxy.Type.HTTP;
    }

    public static String u(z zVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(zVar.nr());
        sb.append(' ');
        if (nr(zVar, type)) {
            sb.append(zVar.u());
        } else {
            sb.append(u(zVar.u()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    public static String u(bg bgVar) {
        String strA = bgVar.a();
        try {
            String strT = bgVar.t();
            if (strT != null) {
                return strA + '?' + strT;
            }
        } catch (OutOfMemoryError unused) {
        }
        return strA;
    }
}
