package com.bytedance.pangle.n;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import defpackage.rf7;
import defpackage.sf7;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class k {
    public static final k u = new k(null, 0, null, null, null);

    @Nullable
    public final ArraySet<PublicKey> b;
    public final int fx;

    @Nullable
    public final int[] iz;

    @Nullable
    public final Signature[] nr;

    @Nullable
    public final Signature[] pn;

    public k(Signature[] signatureArr, int i, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.nr = signatureArr;
        this.fx = i;
        this.b = arraySet;
        this.pn = signatureArr2;
        this.iz = iArr;
    }

    public static ArraySet<PublicKey> u(Signature[] signatureArr) throws CertificateException {
        Method method;
        sf7.a();
        ArraySet<PublicKey> arraySetA = rf7.a(signatureArr.length);
        for (Signature signature : signatureArr) {
            try {
                method = Signature.class.getMethod("getPublicKey", new Class[0]);
            } catch (NoSuchMethodException e) {
                com.bytedance.sdk.openadsdk.api.iz.u(e);
                method = null;
            }
            if (method != null && method.isAccessible()) {
                try {
                    arraySetA.add((PublicKey) method.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e2) {
                    com.bytedance.sdk.openadsdk.api.iz.u(e2);
                } catch (InvocationTargetException e3) {
                    com.bytedance.sdk.openadsdk.api.iz.u(e3);
                } catch (Exception e4) {
                    com.bytedance.sdk.openadsdk.api.iz.u(e4);
                }
            }
        }
        return arraySetA;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.fx != kVar.fx || !u(this.nr, kVar.nr)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.b;
        if (arraySet != null) {
            if (!arraySet.equals(kVar.b)) {
                return false;
            }
        } else if (kVar.b != null) {
            return false;
        }
        return Arrays.equals(this.pn, kVar.pn) && Arrays.equals(this.iz, kVar.iz);
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.nr) * 31) + this.fx) * 31;
        ArraySet<PublicKey> arraySet = this.b;
        return ((((iHashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.pn)) * 31) + Arrays.hashCode(this.iz);
    }

    public k(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) throws CertificateException {
        this(signatureArr, i, u(signatureArr), signatureArr2, iArr);
    }

    public k(Signature[] signatureArr, int i) throws CertificateException {
        this(signatureArr, i, null, null);
    }

    public static boolean u(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.b.u((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.b.u((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean u(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
