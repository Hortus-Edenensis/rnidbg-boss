package com.airbnb.lottie.model.content;

import defpackage.fd;
import defpackage.kd;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class Mask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaskMode f2518a;
    public final kd b;
    public final fd c;
    public final boolean d;

    /* JADX INFO: compiled from: SearchBox */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, kd kdVar, fd fdVar, boolean z) {
        this.f2518a = maskMode;
        this.b = kdVar;
        this.c = fdVar;
        this.d = z;
    }

    public MaskMode a() {
        return this.f2518a;
    }

    public kd b() {
        return this.b;
    }

    public fd c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }
}
