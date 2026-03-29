package defpackage;

import android.content.Intent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class rx2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20619a;
    public String b;
    public int c;
    public String d;
    public Intent e;
    public String g;
    public int h;
    public int f = 0;
    public int i = 0;

    public rx2() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f20619a;
        String str2 = ((rx2) obj).f20619a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public String toString() {
        return "JWakeTargetInfo{packageName='" + this.f20619a + "', serviceName='" + this.b + "', targetVersion=" + this.c + ", providerAuthority='" + this.d + "', activityIntent=" + this.e + ", wakeType=" + this.f + ", authenType=" + this.g + ", cmd=" + this.h + ", delaySecTime=" + this.i + '}';
    }

    public rx2(String str, String str2, int i) {
        this.f20619a = str;
        this.b = str2;
        this.c = i;
    }
}
