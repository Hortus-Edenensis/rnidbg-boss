package com.bytedance.sdk.openadsdk.core.l.b;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.x;
import com.kuaishou.weapon.p0.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l {
    public static void u(Activity activity, final String[] strArr, final iz izVar) {
        boolean z;
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarBq;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else {
                    if (g.j.equalsIgnoreCase(strArr[i])) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
            if (z && (bVarBq = com.bytedance.sdk.openadsdk.core.n.o().bq()) != null && izVar != null && !bVarBq.pn()) {
                izVar.u(g.j);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && com.bytedance.sdk.openadsdk.core.n.u.fx(activity) < 23) {
            if (izVar != null) {
                izVar.u();
                return;
            }
            return;
        }
        if (strArr == null || strArr.length <= 0) {
            if (izVar != null) {
                izVar.u();
                return;
            }
            return;
        }
        long jHashCode = activity.hashCode();
        for (String str : strArr) {
            jHashCode += (long) str.hashCode();
        }
        if (activity.getApplicationInfo().targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && strArr.length == 1) {
            String str2 = strArr[0];
            if (TextUtils.equals(str2, g.i) || TextUtils.equals(str2, g.j)) {
                if (izVar != null) {
                    izVar.u(str2);
                }
                com.bytedance.sdk.openadsdk.core.qq.s.u().u(false, new String[]{str2});
                return;
            }
        }
        com.bytedance.sdk.openadsdk.core.y.x.u(String.valueOf(jHashCode), strArr, new x.u() { // from class: com.bytedance.sdk.openadsdk.core.l.b.l.1
            @Override // com.bytedance.sdk.openadsdk.core.y.x.u
            public void onDenied(String str3) {
                iz izVar2 = izVar;
                if (izVar2 != null) {
                    izVar2.u(str3);
                }
                com.bytedance.sdk.openadsdk.core.qq.s.u().u(false, new String[]{str3});
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.x.u
            public void onGranted() {
                iz izVar2 = izVar;
                if (izVar2 != null) {
                    izVar2.u();
                }
                com.bytedance.sdk.openadsdk.core.qq.s.u().u(true, strArr);
            }
        });
    }

    public static boolean u(Context context, String str) {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx;
        if (g.j.equalsIgnoreCase(str) && (bVarSx = com.bytedance.sdk.openadsdk.core.n.o().sx()) != null && !bVarSx.pn()) {
            return false;
        }
        if (context == null) {
            context = dw.getContext();
        }
        return com.bytedance.sdk.openadsdk.core.h.pn.u().u(context, str);
    }
}
