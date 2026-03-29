package com.tencent.turingfd.sdk.ams.ad;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Peach {
    public static Eridanus a(Eridanus eridanus, byte[] bArr) {
        Object objA;
        if (bArr == null || bArr.length == 0) {
            Log.w("TuringDebug", "u1");
            return eridanus;
        }
        byte[] bArrA = Cstatic.a(bArr, Cstatic.a());
        if (bArrA == null || bArrA.length == 0) {
            Log.w("TuringDebug", "u2");
            return eridanus;
        }
        byte[] bArrB = Cnative.b(bArrA);
        if (bArrB == null || bArrB.length == 0) {
            Log.w("TuringDebug", "u3");
            return eridanus;
        }
        Bennet bennet = new Bennet();
        new HashMap();
        HashMap map = new HashMap();
        bennet.f10661a = (short) 3;
        bennet.d = 3;
        if (bArrB.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            Dorado dorado = new Dorado(bArrB, 4);
            dorado.b = "UTF-8";
            bennet.a(dorado);
            dorado.f10691a = ByteBuffer.wrap(bennet.g);
            if (Papaya.f10731a == null) {
                HashMap<String, byte[]> map2 = new HashMap<>();
                Papaya.f10731a = map2;
                map2.put("", new byte[0]);
            }
            HashMap mapA = dorado.a((Map) Papaya.f10731a, 0, false);
            try {
                if (!mapA.containsKey("resp")) {
                    objA = null;
                } else if (map.containsKey("resp")) {
                    objA = map.get("resp");
                } else {
                    byte[] bArr2 = (byte[]) mapA.get("resp");
                    try {
                        Dorado dorado2 = new Dorado();
                        dorado2.f10691a = ByteBuffer.wrap(bArr2);
                        dorado2.b = "UTF-8";
                        objA = dorado2.a(eridanus, 0, true);
                        if (objA != null) {
                            map.put("resp", objA);
                        }
                    } catch (Exception e) {
                        throw new Exception(e);
                    }
                }
                return (Eridanus) objA;
            } catch (Throwable th) {
                Log.w("TuringDebug", th);
                return eridanus;
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
