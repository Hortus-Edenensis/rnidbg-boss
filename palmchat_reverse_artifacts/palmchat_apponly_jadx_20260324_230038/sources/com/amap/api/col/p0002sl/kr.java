package com.amap.api.col.p0002sl;

import com.ss.android.ttvecamera.TECameraResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class kr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2946a;
    public String b;
    public int d;
    public long e;
    public short g;
    public boolean h;
    public int c = TECameraResult.TER_CLOSE_CALLED;
    public long f = 0;

    public kr(boolean z) {
        this.h = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public kr clone() {
        kr krVar = new kr(this.h);
        krVar.f2946a = this.f2946a;
        krVar.b = this.b;
        krVar.c = this.c;
        krVar.d = this.d;
        krVar.e = this.e;
        krVar.f = this.f;
        krVar.g = this.g;
        krVar.h = this.h;
        return krVar;
    }

    public final String a() {
        return this.h + "#" + this.f2946a;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.f2946a + ", ssid='" + this.b + "', rssi=" + this.c + ", frequency=" + this.d + ", timestamp=" + this.e + ", lastUpdateUtcMills=" + this.f + ", freshness=" + ((int) this.g) + ", connected=" + this.h + '}';
    }

    public static String a(long j) {
        if (j < 0 || j > 281474976710655L) {
            return null;
        }
        return kz.a(kz.a(j), ":");
    }

    public static long a(String str) {
        long j;
        if (str == null || str.length() == 0) {
            return 0L;
        }
        int i = 0;
        long j2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long jCharAt = str.charAt(length);
            if (jCharAt < 48 || jCharAt > 57) {
                long j3 = 97;
                if (jCharAt < 97 || jCharAt > 102) {
                    j3 = 65;
                    if (jCharAt < 65 || jCharAt > 70) {
                        if (jCharAt != 58 && jCharAt != 124) {
                            return 0L;
                        }
                    }
                }
                j = (jCharAt - j3) + 10;
            } else {
                j = jCharAt - 48;
            }
            j2 += j << i;
            i += 4;
        }
        if (i != 48) {
            return 0L;
        }
        return j2;
    }
}
