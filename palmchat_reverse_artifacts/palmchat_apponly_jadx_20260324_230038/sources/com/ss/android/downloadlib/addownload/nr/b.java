package com.ss.android.downloadlib.addownload.nr;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.x.mv;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private static volatile b u;
    private final LinkedList<u> nr = new LinkedList<>();
    private static final String[] fx = {"com", "android", "ss"};
    private static final int[] b = {3101, 3102, 3103, 3201, 3202, 3203};

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public final String b;
        public final String fx;
        public final int nr;
        public final long pn;
        public final String u;

        private u(String str, int i, String str2, String str3, long j) {
            this.u = str;
            this.nr = i;
            this.fx = str2 != null ? str2.toLowerCase() : null;
            this.b = str3 != null ? str3.toLowerCase() : null;
            this.pn = j;
        }
    }

    private b() {
    }

    private u fx(String str) {
        try {
            PackageManager packageManager = l.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new u(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static b u() {
        if (u == null) {
            synchronized (b.class) {
                if (u == null) {
                    u = new b();
                }
            }
        }
        return u;
    }

    public void nr(String str) {
        nr();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.nr) {
            Iterator<u> it = this.nr.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().u)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void u(String str) {
        u uVarFx;
        nr();
        if (TextUtils.isEmpty(str) || (uVarFx = fx(str)) == null) {
            return;
        }
        synchronized (this.nr) {
            this.nr.add(uVarFx);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<u, Integer> nr(com.ss.android.downloadad.api.u.nr nrVar) {
        int i;
        u next;
        if (nrVar == null) {
            return null;
        }
        try {
            nr();
            if (this.nr.isEmpty()) {
                return null;
            }
            String strXw = nrVar.xw();
            String strPn = nrVar.pn();
            String strM = nrVar.m();
            int iXg = nrVar.xg();
            int length = b.length;
            u[] uVarArr = new u[length];
            synchronized (this.nr) {
                Iterator<u> it = this.nr.iterator();
                PackageInfo packageInfoU = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    if (next.pn >= nrVar.h()) {
                        if (TextUtils.isEmpty(strXw)) {
                            if (packageInfoU == null) {
                                packageInfoU = mv.u(nrVar);
                            }
                            if (packageInfoU != null) {
                                try {
                                    strXw = (String) l.getContext().getPackageManager().getApplicationLabel(packageInfoU.applicationInfo);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(strXw) && !TextUtils.isEmpty(next.b)) {
                            strXw = strXw.toLowerCase();
                            if (strXw.equals(next.b)) {
                                uVarArr[0] = next;
                                break;
                            }
                            if (strXw.contains(next.b) || next.b.contains(strXw)) {
                                break;
                            }
                        }
                        if (TextUtils.isEmpty(strPn)) {
                            if (packageInfoU == null) {
                                packageInfoU = mv.u(nrVar);
                            }
                            if (packageInfoU != null) {
                                strPn = packageInfoU.packageName;
                            }
                        }
                        if (!TextUtils.isEmpty(strPn) && !TextUtils.isEmpty(next.u)) {
                            strPn = strPn.toLowerCase();
                            if (strPn.contains(next.u) || next.u.contains(strPn)) {
                                break;
                            }
                            if (uVarArr[3] == null) {
                                if (u(strPn, next.u)) {
                                    uVarArr[3] = next;
                                }
                            }
                        }
                        if (uVarArr[4] == null) {
                            if (TextUtils.isEmpty(strM)) {
                                if (packageInfoU == null) {
                                    packageInfoU = mv.u(nrVar);
                                }
                                if (packageInfoU != null) {
                                    strM = packageInfoU.versionName;
                                }
                            }
                            if (!TextUtils.isEmpty(strM) && !TextUtils.isEmpty(next.fx)) {
                                strM = strM.toLowerCase();
                                if (strM.equals(next.fx)) {
                                    uVarArr[4] = next;
                                }
                            }
                            if (uVarArr[5] == null) {
                                if (iXg <= 0) {
                                    if (packageInfoU == null) {
                                        packageInfoU = mv.u(nrVar);
                                    }
                                    if (packageInfoU != null) {
                                        iXg = packageInfoU.versionCode;
                                    }
                                }
                                if (iXg == next.nr) {
                                    uVarArr[5] = next;
                                }
                            }
                        }
                    }
                }
                uVarArr[2] = next;
            }
            for (i = 0; i < length; i++) {
                if (uVarArr[i] != null) {
                    return new Pair<>(uVarArr[i], Integer.valueOf(b[i]));
                }
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    public u u(com.ss.android.downloadad.api.u.nr nrVar) {
        if (nrVar == null) {
            return null;
        }
        nr();
        synchronized (this.nr) {
            for (u uVar : this.nr) {
                if (uVar.pn > nrVar.h()) {
                    return uVar;
                }
            }
            return null;
        }
    }

    private static boolean u(String str, String str2) {
        boolean z;
        try {
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            if (strArrSplit.length != 0 && strArrSplit2.length != 0) {
                int i = 0;
                int i2 = 0;
                for (String str3 : strArrSplit) {
                    String[] strArr = fx;
                    int length = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z = false;
                            break;
                        }
                        String str4 = strArr[i3];
                        if (str4.equals(str3)) {
                            if (i < strArrSplit2.length && str4.equals(strArrSplit2[i])) {
                                i++;
                            }
                            z = true;
                        } else {
                            i3++;
                        }
                    }
                    if (!z) {
                        int i4 = i2;
                        int i5 = i;
                        while (i < strArrSplit2.length) {
                            if (str3.equals(strArrSplit2[i])) {
                                if (i == i5) {
                                    i5++;
                                }
                                i4++;
                                if (i4 >= 2) {
                                    return true;
                                }
                            }
                            i++;
                        }
                        i = i5;
                        i2 = i4;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private void nr() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.nr) {
            Iterator<u> it = this.nr.iterator();
            while (it.hasNext() && jCurrentTimeMillis - it.next().pn > 1800000) {
                it.remove();
            }
        }
    }
}
