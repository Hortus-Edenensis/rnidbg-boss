package com.vivo.push.util;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f11297a = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static volatile ah c;
    private CopyOnWriteArrayList<a> d = new CopyOnWriteArrayList<>();
    private String e;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f11298a;
        private long b;

        public a(long j, long j2) {
            this.f11298a = j;
            this.b = j2;
        }

        public final long a() {
            return this.f11298a;
        }

        public final long b() {
            return this.b;
        }
    }

    private ah() {
    }

    public static synchronized ah a() {
        if (c == null) {
            c = new ah();
        }
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(String str) {
        long time;
        long j;
        long time2;
        String str2;
        Date date;
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2;
        String str3 = " ";
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        char c2 = 0;
        if (TextUtils.isEmpty(str)) {
            t.c("WindowPeriodManager", "invalid period");
        } else if (TextUtils.equals(str, this.e)) {
            t.c("WindowPeriodManager", "has already updated");
        } else {
            this.e = str;
            this.d.clear();
            Date date2 = new Date();
            long jA = af.a();
            String[] strArrSplit = str.split(com.huawei.openalliance.ad.constant.x.aQ);
            int length = strArrSplit.length;
            int i = 0;
            while (i < length) {
                String[] strArrSplit2 = strArrSplit[i].split("-");
                if (strArrSplit2.length == 2) {
                    try {
                        simpleDateFormat = b;
                        StringBuilder sb = new StringBuilder();
                        simpleDateFormat2 = f11297a;
                        sb.append(simpleDateFormat2.format(date2));
                        sb.append(str3);
                        sb.append(strArrSplit2[c2]);
                        time = simpleDateFormat.parse(sb.toString()).getTime();
                    } catch (Exception e) {
                        e = e;
                        time = -1;
                    }
                    try {
                        time2 = simpleDateFormat.parse(simpleDateFormat2.format(date2) + str3 + strArrSplit2[1]).getTime();
                        j = time;
                    } catch (Exception e2) {
                        e = e2;
                        t.a("WindowPeriodManager", "parse window period failed." + e.getMessage());
                        j = time;
                        time2 = -1;
                    }
                    if (jA <= 0 || j <= 0 || time2 <= 0 || j >= time2) {
                        str2 = str3;
                        date = date2;
                    } else {
                        str2 = str3;
                        date = date2;
                        this.d.add(new a(j - jA, time2 - jA));
                        t.c("WindowPeriodManager", "set window period to [" + strArrSplit2[0] + ", " + strArrSplit2[1] + "]");
                    }
                }
                i++;
                str3 = str2;
                date2 = date;
                c2 = 0;
            }
        }
        if (ag.a(this.d)) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - af.a();
        for (a aVar : this.d) {
            if (jCurrentTimeMillis >= aVar.a() && jCurrentTimeMillis <= aVar.b()) {
                return true;
            }
        }
        return false;
    }
}
