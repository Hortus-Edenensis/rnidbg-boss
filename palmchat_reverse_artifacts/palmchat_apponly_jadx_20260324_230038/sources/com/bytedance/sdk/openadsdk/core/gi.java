package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import android.os.Environment;
import android.os.FileObserver;
import com.kuaishou.weapon.p0.g;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class gi {
    private static nr iz;
    public static String u = Environment.DIRECTORY_DCIM;
    private static String nr = Environment.DIRECTORY_PICTURES;
    private static String fx = "Screenshots";
    private static volatile boolean b = false;
    private static volatile boolean pn = false;
    private static long x = 0;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(String str);
    }

    public static long fx() {
        return x;
    }

    private static File iz() {
        return null;
    }

    public static void nr() {
        pn = true;
        if (b) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23 || dw.getContext().checkSelfPermission(g.j) == 0) {
            com.bytedance.sdk.component.jk.x.b(new com.bytedance.sdk.component.jk.a("sso") { // from class: com.bytedance.sdk.openadsdk.core.gi.1
                @Override // java.lang.Runnable
                public void run() {
                    gi.pn();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pn() {
        File fileIz;
        if (b || (fileIz = iz()) == null) {
            return;
        }
        iz = nr.u(fileIz, new u() { // from class: com.bytedance.sdk.openadsdk.core.gi.2
            @Override // com.bytedance.sdk.openadsdk.core.gi.u
            public void u(String str) {
                long unused = gi.x = System.currentTimeMillis();
            }
        });
        b = true;
        fileIz.exists();
        nr nrVar = iz;
        if (nrVar != null) {
            nrVar.startWatching();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class nr extends FileObserver {
        private u u;

        private nr(String str, int i, u uVar) {
            super(str, i);
            this.u = uVar;
        }

        public static nr u(File file, u uVar) {
            if (file == null || uVar == null) {
                return null;
            }
            return Build.VERSION.SDK_INT >= 29 ? new nr(file, 256, uVar) : new nr(file.getAbsolutePath(), 256, uVar);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            u uVar = this.u;
            if (uVar != null) {
                uVar.u(str);
            }
        }

        private nr(File file, int i, u uVar) {
            super(file, i);
            this.u = uVar;
        }
    }

    public static void u() {
        if (!pn || b) {
            return;
        }
        try {
            nr();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.nr("ScreenShotObserver", "权限检查出错时,异常代码：" + e);
        }
    }
}
