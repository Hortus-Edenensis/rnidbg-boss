package com.bytedance.sdk.openadsdk.core.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.n;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static AtomicBoolean u;

    public static int b() {
        return d.nr ? 1 : 0;
    }

    public static boolean fx() {
        int i = d.u;
        return false;
    }

    public static boolean iz() {
        return pn() && n.o().ja();
    }

    public static boolean n() {
        return false;
    }

    public static boolean nr() {
        return pn() && !com.bytedance.sdk.openadsdk.core.fx.fx.u().n() && u();
    }

    public static boolean pn() {
        return d.nr;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean u() {
        boolean z;
        try {
            AtomicBoolean atomicBoolean = u;
            if (atomicBoolean != null) {
                return atomicBoolean.get();
            }
            File file = new File(com.bytedance.sdk.openadsdk.api.plugin.nr.u(dw.getContext()).getParent(), "/pangle_p/com.byted.pangle");
            file.getAbsolutePath();
            if (file.exists()) {
                final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
                file.listFiles();
                File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.b.u.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        if (file2 == null) {
                            return false;
                        }
                        try {
                            int i = d.fx;
                            Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                            String strGroup = matcher.find() ? matcher.group() : "";
                            return (TextUtils.isEmpty(strGroup) ? 0 : Integer.parseInt(strGroup.substring(8))) > i;
                        } catch (Exception unused) {
                            return file2.getName().matches(sb.toString());
                        }
                    }
                });
                z = (fileArrListFiles == null || fileArrListFiles.length == 0) ? false : true;
            }
            u(z);
            return z;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean x() {
        return com.bytedance.sdk.openadsdk.core.fx.fx.u().a();
    }

    public static void u(boolean z) {
        if (u == null) {
            u = new AtomicBoolean();
        }
        u.set(z);
        n.o().my();
    }
}
