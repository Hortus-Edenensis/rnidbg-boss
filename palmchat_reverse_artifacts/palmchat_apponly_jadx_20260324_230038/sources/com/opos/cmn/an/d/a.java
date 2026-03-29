package com.opos.cmn.an.d;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f7740a;
    private Map<String, Object> b;

    public static Bundle b(Map<String, Object> map) {
        try {
            Bundle bundle = new Bundle();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    a(bundle, entry.getKey(), entry.getValue());
                }
            }
            if (bundle.size() > 0) {
                return bundle;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public a a(Map<String, Object> map) {
        this.b = map;
        return this;
    }

    public String toString() {
        return "ActivityExtraParams{intentBundleMap=" + this.f7740a + ", optionsBundleMap=" + this.b + '}';
    }

    public Map<String, Object> a() {
        return this.f7740a;
    }

    public Map<String, Object> b() {
        return this.b;
    }

    private static void a(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Byte) {
                bundle.putByte(str, ((Byte) obj).byteValue());
                return;
            }
            if (obj instanceof Character) {
                bundle.putChar(str, ((Character) obj).charValue());
                return;
            }
            if (obj instanceof Short) {
                bundle.putShort(str, ((Short) obj).shortValue());
                return;
            }
            if (obj instanceof Float) {
                bundle.putFloat(str, ((Float) obj).floatValue());
                return;
            }
            if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
                return;
            }
            if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
                return;
            }
            if (obj instanceof Parcelable[]) {
                bundle.putParcelableArray(str, (Parcelable[]) obj);
                return;
            }
            if (obj instanceof ArrayList) {
                bundle.putParcelableArrayList(str, (ArrayList) obj);
                return;
            }
            if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
                return;
            }
            if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
                return;
            }
            if (obj instanceof short[]) {
                bundle.putShortArray(str, (short[]) obj);
                return;
            }
            if (obj instanceof char[]) {
                bundle.putCharArray(str, (char[]) obj);
                return;
            }
            if (obj instanceof float[]) {
                bundle.putFloatArray(str, (float[]) obj);
                return;
            }
            if (obj instanceof CharSequence[]) {
                bundle.putCharSequenceArray(str, (CharSequence[]) obj);
            } else if (obj instanceof Bundle) {
                bundle.putBundle(str, (Bundle) obj);
            } else if (obj instanceof Binder) {
                bundle.putBinder(str, (Binder) obj);
            }
        }
    }
}
