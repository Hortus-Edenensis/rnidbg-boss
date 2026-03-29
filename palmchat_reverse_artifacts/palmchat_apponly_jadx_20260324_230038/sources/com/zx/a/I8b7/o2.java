package com.zx.a.I8b7;

import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f16839a;
    public final List<n0> b;
    public final SSLSocketFactory c;
    public final HostnameVerifier d;
    public final boolean e;
    public final int f;
    public final int g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        public SSLSocketFactory c;
        public final List<n0> b = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x f16840a = new x();
        public boolean e = true;
        public int f = 7000;
        public int g = 7000;
        public HostnameVerifier d = n2.f16832a;
    }

    public o2(a aVar) {
        this.f16839a = aVar.f16840a;
        List<n0> listA = c2.a(aVar.b);
        this.b = listA;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        if (listA.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + listA);
        }
    }
}
