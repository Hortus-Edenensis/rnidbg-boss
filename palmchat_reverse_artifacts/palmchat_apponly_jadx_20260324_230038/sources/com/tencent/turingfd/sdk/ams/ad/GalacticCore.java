package com.tencent.turingfd.sdk.ams.ad;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import defpackage.wy6;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class GalacticCore {

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.GalacticCore$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class Cdo extends GalacticCore {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public KeyGenParameterSpec.Builder f10697a;

        public Cdo(String str, int i) {
            this.f10697a = null;
            this.f10697a = wy6.a(str, i);
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.GalacticCore
        public AlgorithmParameterSpec a() throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
            return this.f10697a.build();
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.GalacticCore
        public GalacticCore b(String... strArr) {
            this.f10697a.setSignaturePaddings(strArr);
            return this;
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.GalacticCore
        public GalacticCore a(String... strArr) {
            this.f10697a.setDigests(strArr);
            return this;
        }
    }

    public static GalacticCore a(String str, int i) {
        return Build.VERSION.SDK_INT >= 23 ? new Cdo(str, i) : new Cif(str, i);
    }

    public abstract GalacticCore a(String... strArr);

    public abstract AlgorithmParameterSpec a() throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException;

    public abstract GalacticCore b(String... strArr);

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.GalacticCore$if, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class Cif extends GalacticCore {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10698a;
        public int b;
        public String[] c;
        public String[] d;

        public Cif(String str, int i) {
            if (str == null) {
                throw new NullPointerException("keystoreAlias == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("keystoreAlias must not be empty");
            }
            this.f10698a = str;
            this.b = i;
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.GalacticCore
        public AlgorithmParameterSpec a() throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
            Class<?> cls = Class.forName("android.security.keystore.KeyGenParameterSpec");
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Boolean.TYPE;
            return (AlgorithmParameterSpec) cls.getConstructor(String.class, cls2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, cls2, String[].class, String[].class, String[].class, String[].class, cls3, cls3, cls2).newInstance(this.f10698a, -1, null, null, null, null, null, null, null, null, Integer.valueOf(this.b), this.c, null, this.d, null, Boolean.TRUE, Boolean.FALSE, -1);
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.GalacticCore
        public GalacticCore b(String... strArr) {
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.d = strArr;
            return this;
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.GalacticCore
        public GalacticCore a(String... strArr) {
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.c = strArr;
            return this;
        }
    }
}
