package com.bytedance.sdk.openadsdk.core.y;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.s;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private static com.bytedance.sdk.openadsdk.core.s nr;
    private static final Map<String, u> u = DesugarCollections.synchronizedMap(new HashMap());

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void onDenied(String str);

        void onGranted();
    }

    private static u nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return u.remove(str);
    }

    public static void u(String str, String[] strArr, u uVar) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        u(str, uVar);
        TTDelegateActivity.u(str, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.s nr() {
        if (nr == null) {
            nr = s.u.u(com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u(com.bytedance.sdk.openadsdk.core.dw.getContext()).u(4));
        }
        return nr;
    }

    public static void u(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
            com.bytedance.sdk.component.jk.x.fx().execute(new com.bytedance.sdk.component.jk.a("handleYes", 5) { // from class: com.bytedance.sdk.openadsdk.core.y.x.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        x.nr().nr(str, (String) null);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        u uVarNr = nr(str);
        if (uVarNr == null) {
            return;
        }
        uVarNr.onGranted();
    }

    public static void u(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
            com.bytedance.sdk.component.jk.x.fx().execute(new com.bytedance.sdk.component.jk.a("handleNo", 5) { // from class: com.bytedance.sdk.openadsdk.core.y.x.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        x.nr().nr(str, str2);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        u uVarNr = nr(str);
        if (uVarNr == null) {
            return;
        }
        uVarNr.onDenied(str2);
    }

    private static void u(final String str, final u uVar) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("addListener") { // from class: com.bytedance.sdk.openadsdk.core.y.x.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.component.utils.k.nr("MultiProcess", "getListenerManager().registerPermissionListener...");
                        x.nr().u(str, new com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.nr(uVar));
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.k.nr("MultiProcess", th.toString());
                    }
                }
            }, 5);
        } else {
            u.put(str, uVar);
        }
    }
}
