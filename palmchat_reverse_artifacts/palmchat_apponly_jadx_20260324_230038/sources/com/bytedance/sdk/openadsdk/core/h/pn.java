package com.bytedance.sdk.openadsdk.core.h;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.gi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    private static volatile pn pn = null;
    private static final String u = "pn";
    private final CopyOnWriteArraySet<String> nr = new CopyOnWriteArraySet<>();
    private final List<WeakReference<iz>> fx = new ArrayList(1);
    private final List<iz> b = new ArrayList(1);

    private pn() {
        nr();
    }

    private void fx() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = dw.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i = 0; i < strArr.length; i++) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        this.nr.add(strArr[i]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void nr() {
        fx();
    }

    public static pn u() {
        if (pn == null) {
            synchronized (pn.class) {
                if (pn == null) {
                    pn = new pn();
                }
            }
        }
        return pn;
    }

    public boolean nr(Context context, String str) {
        if (context == null) {
            return false;
        }
        return gi.my() ? fx.u(context, str) && nr.u(context, str) == 0 : nr.u(context, str) == 0;
    }

    private void nr(Activity activity, String[] strArr, iz izVar) {
        boolean zU;
        for (String str : strArr) {
            if (izVar != null) {
                try {
                    if (!this.nr.contains(str)) {
                        zU = izVar.u(str, b.NOT_FOUND);
                    } else if (nr.u(activity, str) != 0) {
                        zU = izVar.u(str, b.DENIED);
                    } else {
                        zU = izVar.u(str, b.GRANTED);
                    }
                    if (zU) {
                        break;
                    }
                } catch (Throwable unused) {
                    continue;
                }
            }
        }
        u(izVar);
    }

    private synchronized void u(String[] strArr, iz izVar) {
        if (izVar == null) {
            return;
        }
        izVar.u(strArr);
        this.b.add(izVar);
        this.fx.add(new WeakReference<>(izVar));
    }

    private List<String> fx(Activity activity, String[] strArr, iz izVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.nr.contains(str)) {
                if (!u(activity, str)) {
                    arrayList.add(str);
                } else if (izVar != null) {
                    izVar.u(str, b.GRANTED);
                }
            } else if (izVar != null) {
                izVar.u(str, b.NOT_FOUND);
            }
        }
        return arrayList;
    }

    private synchronized void u(iz izVar) {
        Iterator<WeakReference<iz>> it = this.fx.iterator();
        while (it.hasNext()) {
            WeakReference<iz> next = it.next();
            if (next.get() == izVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<iz> it2 = this.b.iterator();
        while (it2.hasNext()) {
            if (it2.next() == izVar) {
                it2.remove();
            }
        }
    }

    public boolean u(Context context, String str) {
        if (context == null) {
            return false;
        }
        return gi.my() ? fx.u(context, str) && nr.u(context, str) == 0 : nr.u(context, str) == 0;
    }

    public synchronized void u(Activity activity, String[] strArr, iz izVar) {
        if (activity == null) {
            return;
        }
        try {
            u(strArr, izVar);
            if (Build.VERSION.SDK_INT < 23) {
                nr(activity, strArr, izVar);
                return;
            }
            List<String> listFx = fx(activity, strArr, izVar);
            if (listFx.isEmpty()) {
                u(izVar);
            } else {
                nr.requestPermissions(activity, (String[]) listFx.toArray(new String[listFx.size()]), 1);
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void u(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (gi.my() && !fx.u(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            u(strArr, iArr, (String[]) null);
        } catch (Throwable unused) {
        }
    }

    private void u(String[] strArr, int[] iArr, String[] strArr2) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<iz>> it = this.fx.iterator();
            while (it.hasNext()) {
                iz izVar = it.next().get();
                while (i < length) {
                    i = (izVar == null || izVar.u(strArr[i], iArr[i])) ? 0 : i + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<iz> it2 = this.b.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable unused) {
        }
    }
}
