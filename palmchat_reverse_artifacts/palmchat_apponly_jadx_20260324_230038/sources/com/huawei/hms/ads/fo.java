package com.huawei.hms.ads;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class fo {
    private static final String Code = "HA";
    private String C;
    private String I;
    private int S;
    private String V;
    private int Z;
    private long B = 0;
    private final StringBuilder F = new StringBuilder();

    public fo(String str, int i, String str2) {
        this.V = null;
        this.I = Code;
        this.Z = 0;
        this.V = str;
        this.Z = i;
        if (str2 != null) {
            this.I = str2;
        }
        I();
    }

    private fo I() {
        this.B = System.currentTimeMillis();
        this.C = Thread.currentThread().getName();
        this.S = Process.myPid();
        return this;
    }

    public <T> fo Code(T t) {
        this.F.append(t);
        return this;
    }

    public String V() {
        StringBuilder sb = new StringBuilder();
        V(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Code(sb);
        V(sb);
        return sb.toString();
    }

    private StringBuilder V(StringBuilder sb) {
        sb.append(' ');
        sb.append((CharSequence) this.F);
        return sb;
    }

    public fo Code(Throwable th) {
        if (th != null) {
            Code('\n').Code(Log.getStackTraceString(th));
        }
        return this;
    }

    public String Code() {
        StringBuilder sb = new StringBuilder();
        Code(sb);
        return sb.toString();
    }

    private StringBuilder Code(StringBuilder sb) {
        SimpleDateFormat simpleDateFormatCode = com.huawei.openalliance.ad.utils.z.Code("yyyy-MM-dd HH:mm:ss.SSS");
        sb.append('[');
        sb.append(simpleDateFormatCode.format(Long.valueOf(this.B)));
        String strCode = fl.Code(this.Z);
        sb.append(' ');
        sb.append(strCode);
        sb.append('/');
        sb.append(this.V);
        sb.append('/');
        sb.append(this.I);
        sb.append(' ');
        sb.append(this.S);
        sb.append(':');
        sb.append(this.C);
        sb.append(']');
        return sb;
    }
}
