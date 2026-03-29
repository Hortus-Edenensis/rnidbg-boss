package com.nostra13.universalimageloader.core.assist;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class FailReason {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FailType f7550a;
    public final Throwable b;

    /* JADX INFO: compiled from: SearchBox */
    public enum FailType {
        NET_403,
        NET_404,
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th) {
        this.f7550a = failType;
        this.b = th;
    }

    public static boolean c(FailReason failReason) {
        return (failReason == null || failReason.b() == null || (failReason.b() != FailType.NET_404 && failReason.b() != FailType.NET_403)) ? false : true;
    }

    public Throwable a() {
        return this.b;
    }

    public FailType b() {
        return this.f7550a;
    }
}
