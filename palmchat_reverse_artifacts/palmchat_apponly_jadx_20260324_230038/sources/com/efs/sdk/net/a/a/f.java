package com.efs.sdk.net.a.a;

import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface f {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        String a(int i);

        String b(int i);

        int e();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b extends c {
        String b();

        String c();

        byte[] d();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c extends a {
        String a();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d extends e {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e extends a {
        String a();

        int b();
    }

    InputStream a(String str, String str2, String str3, InputStream inputStream);

    void a();

    void a(b bVar);

    void a(d dVar);

    String b();
}
