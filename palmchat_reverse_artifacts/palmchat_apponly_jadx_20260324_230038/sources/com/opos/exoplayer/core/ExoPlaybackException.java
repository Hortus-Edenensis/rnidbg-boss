package com.opos.exoplayer.core;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ExoPlaybackException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8082a;
    public final int b;
    private String c;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private ExoPlaybackException(int i, String str, Throwable th, int i2) {
        super(str, th);
        this.f8082a = i;
        this.b = i2;
    }

    public static ExoPlaybackException a(IOException iOException) {
        return new ExoPlaybackException(0, null, iOException, -1);
    }

    public static ExoPlaybackException b(Exception exc, int i) {
        return new ExoPlaybackException(3, null, exc, i);
    }

    public static ExoPlaybackException a(Exception exc, int i) {
        return new ExoPlaybackException(1, null, exc, i);
    }

    public static ExoPlaybackException a(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, null, runtimeException, -1);
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }
}
