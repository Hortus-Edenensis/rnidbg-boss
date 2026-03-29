package cn.fly.verify;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import cn.fly.verify.fl;
import cn.fly.verify.fq;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2123a = dx.a("002Kcidj");
    private static final String b = dx.a("005NdbcbQhgc");
    private static final String c = dx.a("005Ldbcb!hTbaTc");
    private static final String d = dx.a("0162fdfchdfjfgffghfbfhdeFbBdc*a bacdbg");
    private static bw e;
    private String f;
    private Context g = ax.g();
    private TreeMap<String, Object> h;

    private bw() {
    }

    public static bw a() {
        if (e == null) {
            synchronized (bw.class) {
                if (e == null) {
                    e = new bw();
                }
            }
        }
        return e;
    }

    private String d() {
        String strE;
        boolean zA;
        TreeMap<String, Object> treeMap;
        this.h = new TreeMap<>();
        String strA = null;
        try {
            strE = e();
            zA = a(f());
        } catch (Throwable th) {
            en.a().a(th);
        }
        if (TextUtils.isEmpty(strE)) {
            treeMap = this.h;
        } else {
            en.a().a("[%s] %s", f2123a, "tk status: " + zA);
            if (!zA) {
                strA = strE;
                e.f = strA;
                return strA;
            }
            treeMap = this.h;
        }
        strA = a(treeMap);
        e.f = strA;
        return strA;
    }

    private String e() throws IOException {
        DataInputStream dataInputStream;
        FileInputStream fileInputStream;
        String utf;
        DataInputStream dataInputStream2 = null;
        try {
            File fileB = fz.b(this.g, b);
            if (!fileB.exists() || fileB.length() <= 0) {
                utf = null;
                fileInputStream = null;
            } else {
                fileInputStream = new FileInputStream(fileB);
                try {
                    dataInputStream = new DataInputStream(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    dataInputStream = null;
                }
                try {
                    utf = dataInputStream.readUTF();
                    dataInputStream2 = dataInputStream;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        en.a().a(th);
                        eg.a(dataInputStream, fileInputStream);
                        return null;
                    } catch (Throwable th3) {
                        eg.a(dataInputStream, fileInputStream);
                        throw th3;
                    }
                }
            }
            eg.a(dataInputStream2, fileInputStream);
            return utf;
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            fileInputStream = null;
        }
    }

    private HashMap<String, Object> f() {
        return a(d, fz.b(fz.b(this.g, c)));
    }

    public String b() {
        if (TextUtils.isEmpty(this.f)) {
            synchronized (bw.class) {
                if (TextUtils.isEmpty(this.f)) {
                    return d();
                }
            }
        }
        return this.f;
    }

    public String c() {
        String str = this.f;
        return TextUtils.isEmpty(str) ? e() : str;
    }

    private String a(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArrC = eg.c();
        Closeable closeable = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(gZIPOutputStream);
                    try {
                        bufferedOutputStream.write(str.getBytes("utf-8"));
                        bufferedOutputStream.flush();
                        eg.a(bufferedOutputStream, gZIPOutputStream, byteArrayOutputStream);
                        byte[] bArrA = fr.a(bArrC, byteArrayOutputStream.toByteArray());
                        byte[] bArrA2 = new fw(1024).a(bArrC, new BigInteger("ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", 16), new BigInteger("191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", 16));
                        try {
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream2);
                                try {
                                    dataOutputStream.writeInt(bArrA2.length);
                                    dataOutputStream.write(bArrA2);
                                    dataOutputStream.writeInt(bArrA.length);
                                    dataOutputStream.write(bArrA);
                                    dataOutputStream.flush();
                                    eg.a(dataOutputStream, byteArrayOutputStream2);
                                    return Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 2);
                                } catch (Throwable th) {
                                    th = th;
                                    closeable = dataOutputStream;
                                    eg.a(closeable, byteArrayOutputStream2);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream2 = null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        closeable = bufferedOutputStream;
                        eg.a(closeable, gZIPOutputStream, byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
                gZIPOutputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
        }
    }

    private void b(String str) {
        FileOutputStream fileOutputStream;
        DataOutputStream dataOutputStream = null;
        try {
            File fileB = fz.b(this.g, b);
            if (fileB != null) {
                fileOutputStream = new FileOutputStream(fileB);
                try {
                    DataOutputStream dataOutputStream2 = new DataOutputStream(fileOutputStream);
                    try {
                        dataOutputStream2.writeUTF(str);
                        dataOutputStream2.flush();
                        dataOutputStream = dataOutputStream2;
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream = dataOutputStream2;
                        try {
                            en.a().a(th);
                            eg.a(dataOutputStream, fileOutputStream);
                            return;
                        } catch (Throwable th2) {
                            eg.a(dataOutputStream, fileOutputStream);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                fileOutputStream = null;
            }
            eg.a(dataOutputStream, fileOutputStream);
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    private String a(TreeMap<String, Object> treeMap) {
        HashMap map;
        String str = null;
        if (!by.c() || treeMap == null || treeMap.isEmpty()) {
            return null;
        }
        try {
            HashMap map2 = new HashMap();
            map2.put(dx.a("007VcdEbag9cbbhbi"), treeMap.get(dx.a("007VcdEbag9cbbhbi")));
            map2.put(dx.a("005Kbdcbba@de"), treeMap.get(dx.a("005Kbdcbba@de")));
            map2.put(dx.a("0064dfbidfbb7d+bh"), treeMap.get(dx.a("0064dfbidfbb7d+bh")));
            map2.put(dx.a("008*baJd@bbbg_ad!cgba"), treeMap.get(dx.a("008*baJd@bbbg_ad!cgba")));
            map2.put(dx.a("004!babebgba"), treeMap.get(dx.a("004!babebgba")));
            HashMap<String, Object> map3 = new HashMap<>();
            map3.put(dx.a("006bhh^bjDdWbi"), ef.a());
            map3.put("m", a(fv.a(map2)));
            HashMap<String, String> map4 = new HashMap<>();
            map4.put(dx.a("013%cedf>d3bhficgba$dcg+bgIgSbi"), bu.c());
            map4.put(dx.a("004_bdcbbgba"), er.a(ax.g()).d().ai());
            fl.a aVar = new fl.a();
            aVar.f2355a = 30000;
            aVar.b = 30000;
            HashMap mapA = fv.a(new fl().b(dt.a().a("gclg") + dx.a("007j3cbIhdcGbgba"), map3, map4, aVar));
            if (!"200".equals(String.valueOf(mapA.get(dx.a("004aGcbba8d")))) || (map = (HashMap) mapA.get(dx.a("004(ba=bgb"))) == null) {
                return null;
            }
            String str2 = (String) map.get(dx.a("005g_cbbj'dc"));
            try {
                e.f = str2;
                b(str2);
                return str2;
            } catch (Throwable th) {
                th = th;
                str = str2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        en.a().c(th);
        return str;
    }

    private void b(TreeMap<String, Object> treeMap) {
        fz.a(fz.b(this.g, c), a(d, treeMap));
    }

    private HashMap<String, Object> a(String str, byte[] bArr) {
        try {
            return fv.a(fr.a(str, bArr));
        } catch (Throwable th) {
            en.a().a(th);
            return new HashMap<>();
        }
    }

    private boolean a(HashMap<String, Object> map) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final String[] strArr = new String[1];
        fq.a(ax.g()).i().a(new fq.a() { // from class: cn.fly.verify.bw.1
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                strArr[0] = bVar.i();
                countDownLatch.countDown();
            }
        });
        try {
            this.h.put(dx.a("007'cd?bag+cbbhbi"), fq.d.k());
            this.h.put(dx.a("005,bdcbba6de"), fq.d.j());
            this.h.put(dx.a("006(dfbidfbbRdGbh"), Integer.valueOf(fq.d.g()));
            countDownLatch.await(100L, TimeUnit.MILLISECONDS);
            String str = strArr[0];
            if (!TextUtils.isEmpty(str)) {
                this.h.put(dx.a("008@ba9d*bbbgZadVcgba"), str);
            }
            this.h.put(dx.a("004Bbabebgba"), dp.a((bd) null));
            String strB = fr.b(new JSONObject(this.h).toString());
            TreeMap<String, Object> treeMap = new TreeMap<>();
            treeMap.put(dx.a("010<ccEdcd_bh2be%fabafg"), strB);
            b(treeMap);
            if (map == null || map.isEmpty() || !strB.equals((String) map.get(dx.a("010 cc*dcdNbhSbeDfabafg")))) {
                return true;
            }
            en.a().a("[%s] %s", f2123a, "No changes");
            return false;
        } catch (Throwable th) {
            en.a().c(th);
            return false;
        }
    }

    private byte[] a(String str, TreeMap<String, Object> treeMap) {
        try {
            return fr.a(str, new JSONObject(treeMap).toString());
        } catch (Throwable th) {
            en.a().a(th);
            return null;
        }
    }
}
