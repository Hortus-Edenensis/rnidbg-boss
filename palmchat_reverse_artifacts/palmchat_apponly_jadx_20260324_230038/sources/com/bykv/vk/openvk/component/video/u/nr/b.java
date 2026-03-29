package com.bykv.vk.openvk.component.video.u.nr;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bykv.vk.openvk.component.video.u.nr.u.fx;
import com.bytedance.sdk.component.utils.k;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static volatile Integer b = null;
    public static volatile int fx = 3;
    public static volatile boolean iz;
    private static volatile com.bykv.vk.openvk.component.video.u.nr.nr.fx jk;
    static volatile boolean n;
    static volatile com.bykv.vk.openvk.component.video.u.nr.u.fx nr;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context t;
    static volatile com.bykv.vk.openvk.component.video.u.nr.u.nr u;
    public static final boolean pn = k.fx();
    static volatile boolean x = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile int f4970a = 0;

    public static Context getContext() {
        return t;
    }

    public static com.bykv.vk.openvk.component.video.u.nr.u.nr nr() {
        return u;
    }

    public static void u(boolean z) {
        n = z;
    }

    public static void u(int i) {
        f4970a = i;
    }

    public static void u(com.bykv.vk.openvk.component.video.u.nr.u.fx fxVar, Context context) {
        if (fxVar != null && context != null) {
            t = context.getApplicationContext();
            if (nr != null) {
                return;
            }
            com.bykv.vk.openvk.component.video.u.nr.u.nr nrVar = u;
            if (nrVar != null && nrVar.u.getAbsolutePath().equals(fxVar.u.getAbsolutePath())) {
                throw new IllegalArgumentException("DiskLruCache and DiskCache can't use the same dir");
            }
            nr = fxVar;
            jk = com.bykv.vk.openvk.component.video.u.nr.nr.fx.u(context);
            nr.u(new fx.u() { // from class: com.bykv.vk.openvk.component.video.u.nr.b.1
                @Override // com.bykv.vk.openvk.component.video.u.nr.u.fx.u
                public void u(String str) {
                    int i = b.fx;
                }

                @Override // com.bykv.vk.openvk.component.video.u.nr.u.fx.u
                public void u(Set<String> set) {
                    b.jk.u(set, 0);
                }
            });
            fx fxVarU = fx.u();
            fxVarU.u(fxVar);
            fxVarU.u(jk);
            return;
        }
        throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
    }

    public static com.bykv.vk.openvk.component.video.u.nr.u.fx u() {
        return nr;
    }
}
