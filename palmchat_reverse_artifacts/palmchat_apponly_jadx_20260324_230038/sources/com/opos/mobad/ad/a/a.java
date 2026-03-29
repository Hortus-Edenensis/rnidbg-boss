package com.opos.mobad.ad.a;

import com.lantern.auth.app.FunDC;
import com.oplus.tblplayer.processor.util.EffectConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8519a;
    public final int b;

    /* JADX INFO: renamed from: com.opos.mobad.ad.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0715a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8520a = FunDC.ID_AUTH_1080;
        private int b = EffectConstants.ROTATION_DEGREES_180;

        public C0715a a(int i) {
            this.f8520a = i;
            return this;
        }

        public C0715a b(int i) {
            this.b = i;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    public a(C0715a c0715a) {
        this.f8519a = c0715a.f8520a;
        this.b = c0715a.b;
    }
}
