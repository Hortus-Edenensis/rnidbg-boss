package com.baidu.mapauto.auth.net;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f3859a;
    public String b;
    public String c;
    public Exception d = null;

    public final String toString() {
        StringBuilder sbA = com.baidu.mapauto.auth.a.a("NetBodyStringResponse{httpCode=");
        sbA.append(this.f3859a);
        sbA.append(", httpMessage='");
        sbA.append(this.b);
        sbA.append('\'');
        sbA.append(", body='");
        sbA.append(this.c);
        sbA.append('\'');
        sbA.append(", httpException=");
        sbA.append(this.d);
        sbA.append('}');
        return sbA.toString();
    }
}
