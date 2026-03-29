package cn.fly.verify;

import android.util.Base64;
import cn.fly.verify.fl;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class fk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2351a = bq.a("004Vedehejed");
    private static final ThreadPoolExecutor b = new ThreadPoolExecutor(3, 20, 60, TimeUnit.SECONDS, new LinkedBlockingDeque());
    private BigInteger c;
    private BigInteger d;
    private fw e;
    private fl f;
    private fl.a g;
    private ThreadPoolExecutor h;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public fk(int i, String str, String str2) {
        this(i, str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(fh fhVar) throws Throwable {
        List<String> listA = a(fhVar, bq.a("014HhlfeFfjgfjTilgdSgf1ff,ji"));
        if (listA == null || listA.size() <= 0) {
            return -1L;
        }
        return Long.parseLong(listA.get(0));
    }

    private Object b(String str) throws Throwable {
        if (str == null) {
            HashMap map = new HashMap();
            map.put(bq.a("006VgiEjej]ehgi"), -1);
            map.put(bq.a("005gWekekfeek"), "RS is empty");
            throw new a(fv.a(map));
        }
        HashMap mapA = fv.a(str.trim());
        if (!mapA.isEmpty()) {
            Object obj = mapA.get(bq.a("003@ekJg:gi"));
            return obj == null ? mapA.get(bq.a("004RedEeje")) : obj;
        }
        HashMap map2 = new HashMap();
        map2.put(bq.a("006)giAjej0ehgi"), -1);
        map2.put(bq.a("005gZekekfeek"), "RS is empty");
        throw new a(fv.a(map2));
    }

    public fk(int i, String str, String str2, fl.a aVar) {
        this.e = new fw(i);
        this.c = new BigInteger(str, 16);
        this.d = new BigInteger(str2, 16);
        this.f = new fl();
        if (aVar != null) {
            this.g = aVar;
        } else {
            fl.a aVar2 = new fl.a();
            this.g = aVar2;
            aVar2.f2355a = 30000;
            aVar2.b = 5000;
        }
        this.h = b;
    }

    public <T> T b(boolean z, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z2) throws Throwable {
        return (T) a(z, map, a(map2), str, true, false, z2);
    }

    private fj a(final byte[] bArr, final String[] strArr, final boolean z) {
        return new fj() { // from class: cn.fly.verify.fk.1
            @Override // cn.fly.verify.fj
            public void a(fh fhVar) throws Throwable {
                InputStream inputStreamB;
                ByteArrayOutputStream byteArrayOutputStream;
                int iA = fhVar.a();
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                try {
                    inputStreamB = iA == 200 ? fhVar.b() : fhVar.c();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamB = null;
                }
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int i = inputStreamB.read(bArr2);
                        if (i == -1) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr2, 0, i);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (iA != 200) {
                        HashMap mapA = fv.a(new String(byteArray, "utf-8"));
                        mapA.put(bq.a("010ijjk'fkGjejEehgi"), Integer.valueOf(iA));
                        throw new a(fv.a(mapA));
                    }
                    if (z) {
                        long jA = fk.this.a(fhVar);
                        if (jA == -1 || jA != byteArray.length) {
                            HashMap map = new HashMap();
                            map.put(bq.a("010ijjk?fk jej@ehgi"), Integer.valueOf(iA));
                            map.put(bq.a("0061giQjej?ehgi"), -2);
                            map.put(bq.a("005g7ekekfeek"), "Illegal content length");
                            throw new a(fv.a(map));
                        }
                        strArr[0] = fk.this.a(bArr, byteArray);
                    } else {
                        strArr[0] = new String(byteArray, "utf-8");
                    }
                    eg.a(byteArrayOutputStream, inputStreamB);
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    eg.a(byteArrayOutputStream2, inputStreamB);
                    throw th;
                }
            }
        };
    }

    public <T> T a(HashMap<String, Object> map, String str, boolean z) throws Throwable {
        return (T) a((HashMap<String, String>) null, map, str, z);
    }

    public <T> T a(HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z) throws Throwable {
        return (T) a(true, map, map2, str, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T a(boolean z, HashMap<String, String> map, String str, String str2, boolean z2, boolean z3, boolean z4) throws Throwable {
        byte[] bArrC = eg.c();
        byte[] bArrA = a(bArrC, str, z2);
        String[] strArr = new String[1];
        fj fjVarA = a(bArrC, strArr, z4);
        if (z3) {
            String strEncodeToString = Base64.encodeToString(bArrA, 2);
            HashMap<String, String> mapA = a(z, map, str, strEncodeToString.getBytes("utf-8").length);
            fo foVar = new fo();
            foVar.a(strEncodeToString);
            en.a().a(">>>  request(" + str2 + "): " + str + "\nheader = " + mapA.toString(), new Object[0]);
            this.f.a(str2, mapA, foVar, -1, fjVarA, this.g);
        } else {
            HashMap<String, String> mapA2 = a(z, map, str, -1);
            en.a().a(">>>  request(" + str2 + "): " + str + "\nheader = " + mapA2.toString(), new Object[0]);
            this.f.a(str2, bArrA, mapA2, -1, fjVarA, this.g);
        }
        if (strArr[0] == 0) {
            return null;
        }
        en.a().a(">>> response(" + str2 + "): " + strArr[0], new Object[0]);
        return z4 ? (T) b(strArr[0]) : (T) strArr[0];
    }

    public <T> T a(boolean z, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z2) throws Throwable {
        return (T) a(z, map, a(map2), str, z2, true, true);
    }

    public static String a(String str) {
        return eg.b(str);
    }

    private String a(HashMap<String, Object> map) {
        if (map == null) {
            return "{}";
        }
        String strA = fv.a((HashMap) map);
        return strA.length() == 0 ? "{}" : strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(byte[] bArr, byte[] bArr2) throws Throwable {
        return new String(fr.b(bArr, Base64.decode(bArr2, 2)), "utf-8");
    }

    public static HashMap<String, String> a() throws Throwable {
        HashMap<String, String> map = new HashMap<>();
        map.put(bq.a("003^em!g*el"), ef.a());
        map.put(bq.a("0136fhgiCg%ekilfjed=gfj?ej'j>el"), bu.c());
        map.put(bq.a("004 egfeejed"), er.a(ax.g()).d().ai());
        return map;
    }

    private HashMap<String, String> a(String str, int i) throws Throwable {
        HashMap<String, String> mapA = a();
        mapA.put(bq.a("004^giejff<f"), fr.b(str + ax.e()));
        mapA.put(bq.a("014Ahlfe'fjgfjYilgd[gfUffHji"), String.valueOf(i));
        return mapA;
    }

    private HashMap<String, String> a(boolean z, HashMap<String, String> map, String str, int i) throws Throwable {
        HashMap<String, String> mapA = z ? i > 0 ? a(str, i) : a() : null;
        if (mapA == null) {
            mapA = new HashMap<>();
        }
        if (map != null) {
            mapA.putAll(map);
        }
        return mapA;
    }

    private List<String> a(fh fhVar, String str) throws Throwable {
        Map<String, List<String>> mapD = fhVar.d();
        if (mapD == null || mapD.isEmpty()) {
            return null;
        }
        for (String str2 : mapD.keySet()) {
            if (str2 != null && str2.equals(str)) {
                return mapD.get(str2);
            }
        }
        return null;
    }

    private byte[] a(byte[] bArr, String str, boolean z) throws Throwable {
        byte[] bytes;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        GZIPOutputStream gZIPOutputStream;
        Closeable closeable = null;
        if (z) {
            try {
                byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(gZIPOutputStream);
                        try {
                            bufferedOutputStream.write(str.getBytes("utf-8"));
                            bufferedOutputStream.flush();
                            eg.a(bufferedOutputStream, gZIPOutputStream, byteArrayOutputStream2);
                            bytes = byteArrayOutputStream2.toByteArray();
                        } catch (Throwable th) {
                            th = th;
                            closeable = bufferedOutputStream;
                            eg.a(closeable, gZIPOutputStream, byteArrayOutputStream2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    gZIPOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream2 = null;
                gZIPOutputStream = null;
            }
        } else {
            bytes = str.getBytes("utf-8");
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    byte[] bArrA = this.e.a(bArr, this.c, this.d);
                    dataOutputStream.writeInt(bArrA.length);
                    dataOutputStream.write(bArrA);
                    byte[] bArrA2 = fr.a(bArr, bytes);
                    dataOutputStream.writeInt(bArrA2.length);
                    dataOutputStream.write(bArrA2);
                    dataOutputStream.flush();
                    eg.a(dataOutputStream, byteArrayOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th5) {
                    th = th5;
                    closeable = dataOutputStream;
                    eg.a(closeable, byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            byteArrayOutputStream = null;
        }
    }
}
