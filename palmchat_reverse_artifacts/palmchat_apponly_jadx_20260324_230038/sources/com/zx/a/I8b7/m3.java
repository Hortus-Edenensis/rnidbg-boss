package com.zx.a.I8b7;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.gdt.action.ActionUtils;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zx.a.I8b7.h1;
import com.zx.a.I8b7.l2;
import com.zx.a.I8b7.o2;
import com.zx.a.I8b7.r2;
import com.zx.a.I8b7.y;
import j$.util.concurrent.ConcurrentHashMap;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class m3 {
    public static String A = null;
    public static String B = null;
    public static String C = null;
    public static String D = null;
    public static String E = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f16830a = null;
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = null;
    public static String f = "";
    public static String g = "";
    public static String h = null;
    public static String i = null;
    public static String j = "{}";
    public static boolean p;
    public static SecretKey v;
    public static IvParameterSpec w;
    public static String x;
    public static String y;
    public static String z;
    public static volatile JSONArray k = new JSONArray();
    public static String l = "{}";
    public static String m = "";
    public static int n = 0;
    public static String o = "ANDROID-V3";
    public static HashMap<String, String> q = new HashMap<>();
    public static int r = 1;
    public static int s = 1;
    public static int t = -1;
    public static long u = 0;
    public static JSONObject F = new JSONObject();
    public static volatile boolean G = false;
    public static final Set<String> H = Collections.newSetFromMap(new ConcurrentHashMap());
    public static final Set<String> I = Collections.newSetFromMap(new ConcurrentHashMap());
    public static Bundle J = null;

    public static void a(Context context) throws Exception {
        Context applicationContext = context.getApplicationContext();
        f16830a = applicationContext;
        g = applicationContext.getPackageName();
        x1.d(f16830a);
        f = x1.a(f16830a);
        StringBuilder sbA = f3.a("initAppId: ");
        sbA.append(f);
        r2.a(sbA.toString());
        b(f16830a);
        if (TextUtils.isEmpty(h)) {
            b();
        } else {
            String strA = p.a(w3.b() + Build.MODEL, "SHA256");
            String[] strArrSplit = h.split("-");
            if (strArrSplit.length < 2) {
                StringBuilder sbA2 = f3.a("ZXID 检测到老版本LID:");
                sbA2.append(h);
                r.a(sbA2.toString());
                h += "-" + strA;
                l2 l2Var = l2.a.f16824a;
                u3 u3Var = l2Var.f16823a;
                String str = h;
                u3Var.getClass();
                if (!TextUtils.equals(str, h)) {
                    h = str;
                    l2Var.f16823a.a(0, str, true);
                }
                StringBuilder sbA3 = f3.a("ZXID 兼容老版本LID后重新生成LID:");
                sbA3.append(h);
                r.a(sbA3.toString());
            } else if (TextUtils.equals(strA, strArrSplit[1])) {
                r.a("ZXID LID校验通过!");
            } else {
                u3 u3Var2 = l2.a.f16824a.f16823a;
                if (u3Var2.b == null) {
                    u3Var2.b = u3Var2.d();
                }
                try {
                    SQLiteDatabase sQLiteDatabase = u3Var2.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("key in(");
                    sb.append("0,1,3,4,6,11,12,15,21,22,23," + MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD + ",24,25,26,19,13,14");
                    sb.append(")");
                    sQLiteDatabase.delete("zx_table", sb.toString(), null);
                    h = "";
                    i = "";
                    j = "";
                    l = "{}";
                    n = 0;
                    o = "ANDROID-V3";
                    p = false;
                    x = "";
                    y = "";
                    z = "";
                    D = "";
                    r = 1;
                    A = "";
                    r2.a("ZXID清理数据成功");
                } catch (Exception e2) {
                    StringBuilder sbA4 = f3.a("清理本地数据error:");
                    sbA4.append(e2.getMessage());
                    r2.b(sbA4.toString());
                }
                b();
                r.a("ZXID LID校验不通过");
            }
        }
        o2 o2Var = i0.f16810a;
        try {
            o2.a aVar = new o2.a();
            aVar.b.add(new s0(r2.a.f16855a.f16854a, 5));
            aVar.b.add(new g0());
            SSLSocketFactory sSLSocketFactoryC = i0.c();
            if (sSLSocketFactoryC == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            aVar.c = sSLSocketFactoryC;
            i0.f16810a = new o2(aVar);
        } catch (Throwable th) {
            r2.a(th);
            th.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|2|155|3|(1:5)|6|151|7|(2:(8:14|147|15|201|(2:43|44)|(2:200|(3:199|47|(3:198|49|(2:197|(2:196|(2:195|(2:194|(3:190|55|(3:189|57|(3:188|59|(14:187|SW:61|106|149|107|(1:109)|110|157|111|(1:113)(1:115)|(4:141|117|(1:119)|(1:233))|143|123|(2:125|232)(6:126|(1:128)|129|(1:131)|132|234))(3:170|83|215))(3:169|84|214))(3:168|85|213))(6:167|86|145|87|193|(3:192|89|211)(3:191|90|210)))(3:166|94|209))(3:165|95|208))(3:164|96|207))(3:163|97|206))(3:162|98|205))(3:161|99|204))(3:160|100|203)|202|12)|159)|(0)|110|157|111|(0)(0)|(0)|143|123|(0)(0)|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0370 A[DONT_GENERATE, PHI: r4
      0x0370: PHI (r4v2 android.database.Cursor) = (r4v1 android.database.Cursor), (r4v5 android.database.Cursor) binds: [B:108:0x036e, B:104:0x0367] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03ad A[Catch: all -> 0x03e2, TryCatch #1 {all -> 0x03e2, blocks: (B:123:0x03a4, B:126:0x03ad, B:128:0x03b6, B:129:0x03b9, B:131:0x03bd, B:132:0x03c0), top: B:143:0x03a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x038f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context) {
        h1 h1Var;
        boolean z2;
        f16830a = context.getApplicationContext();
        u3 u3Var = l2.a.f16824a.f16823a;
        a(u3Var);
        u3Var.getClass();
        boolean z3 = false;
        Cursor cursorQuery = null;
        try {
            if (u3Var.b == null) {
                u3Var.b = u3Var.b();
            }
            try {
                cursorQuery = u3Var.b().query("zx_table", new String[]{"key", ActionUtils.PAYMENT_AMOUNT}, null, null, null, null, null);
            } catch (Exception e2) {
                r2.b("query ex = " + e2.toString());
            }
        } catch (Throwable th) {
            try {
                r2.a(th);
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        try {
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("key"));
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                        if ((!TextUtils.isEmpty(string) && i2 == 11) || i2 == 12 || i2 == 0 || i2 == 1 || i2 == 16 || i2 == 63 || i2 == 30 || i2 == 28 || i2 == 15 || i2 == 21 || i2 == 22 || i2 == 23 || i2 == 321 || i2 == 18 || i2 == 13 || i2 == 19) {
                            string = new String(p.a("AES/CBC/PKCS5Padding", v, w, Base64.decode(string, 0)), StandardCharsets.UTF_8);
                        }
                        if (i2 == 0) {
                            h = string;
                            r2.a("read lid = " + h);
                        } else if (i2 == 1) {
                            i = string;
                            r2.a("read zid = " + i);
                        } else if (i2 == 3) {
                            n = Integer.parseInt(string);
                            r2.a("read syncId = " + n);
                        } else if (i2 == 4) {
                            o = string;
                            r2.a("read configVersion = " + o);
                        } else if (i2 == 28) {
                            m = string;
                            r2.a("read lastReportExtList = " + m);
                        } else if (i2 == 30) {
                            l = string;
                        } else if (i2 == 63) {
                            k = new JSONArray(string);
                            r2.a("read reqBZ = " + k);
                        } else if (i2 == 321) {
                            r2.a("read err = " + string);
                            y yVar = y.b.f16887a;
                            yVar.getClass();
                            try {
                                if (!TextUtils.isEmpty(string)) {
                                    yVar.b = yVar.a(new JSONArray(string), yVar.b, 10);
                                }
                            } catch (JSONException e3) {
                                r2.a(e3);
                            }
                        } else if (i2 == 6) {
                            p = Boolean.parseBoolean(string);
                            r2.a("read isInitialized = " + p);
                        } else if (i2 == 7) {
                            t = Integer.parseInt(string);
                            r2.a("read permission = " + t);
                        } else {
                            if (i2 != 8) {
                                switch (i2) {
                                    case 11:
                                        x = string;
                                        r2.a("read fieldConfigJSON = " + x);
                                        continue;
                                    case 12:
                                        y = string;
                                        r2.a("read reportConfigJSON = " + y);
                                        continue;
                                    case 13:
                                        D = string;
                                        r2.a("read localLv1JSON = " + D);
                                        continue;
                                    case 14:
                                        r = Integer.parseInt(string);
                                        continue;
                                    case 15:
                                        z = string;
                                        r2.a("read cryptoConfigJSON = " + z);
                                        continue;
                                    case 16:
                                        j = string;
                                        continue;
                                    default:
                                        switch (i2) {
                                            case 18:
                                                F = new JSONObject(string);
                                                continue;
                                            case 19:
                                                C = string;
                                                r2.a("read invokeConfigJSON = " + C);
                                                c();
                                                continue;
                                            case 20:
                                                s = Integer.parseInt(string);
                                                r2.a("read allowPermissionDialog = " + s);
                                                continue;
                                            case 21:
                                                A = string;
                                                r2.a("read appConfigJSON = " + A);
                                                continue;
                                            case 22:
                                                B = string;
                                                r2.a("read commonConfigJSON = " + B);
                                                continue;
                                            case 23:
                                                r2.a("read events = " + string);
                                                y yVar2 = y.b.f16887a;
                                                yVar2.getClass();
                                                try {
                                                    if (!TextUtils.isEmpty(string)) {
                                                        yVar2.f16885a = yVar2.a(new JSONArray(string), yVar2.f16885a, 100);
                                                    }
                                                } catch (JSONException e4) {
                                                    r2.a(e4);
                                                }
                                                break;
                                        }
                                        break;
                                }
                                r2.a(th);
                                G = true;
                                h1Var = h1.b.f16802a;
                                h1Var.getClass();
                                z2 = !new JSONObject(l).has("zxc2");
                                if (!z2) {
                                    try {
                                        if (new JSONObject(l).has("zxc3")) {
                                            z3 = true;
                                        }
                                    } catch (Throwable unused) {
                                    }
                                    if (!z3) {
                                        return;
                                    }
                                }
                                if (h1Var.e.getAndSet(true)) {
                                    r2.a("zx rt start");
                                    Timer timer = h1Var.f16799a;
                                    if (timer != null) {
                                        timer.cancel();
                                    }
                                    TimerTask timerTask = h1Var.b;
                                    if (timerTask != null) {
                                        timerTask.cancel();
                                    }
                                    long jA = h1Var.a();
                                    h1Var.a(jA);
                                    h1Var.b();
                                    h1Var.f16799a = new Timer();
                                    g1 g1Var = new g1(h1Var, jA);
                                    h1Var.b = g1Var;
                                    h1Var.f16799a.schedule(g1Var, 0L, 1000L);
                                    return;
                                }
                                return;
                            }
                            u = Long.parseLong(string);
                            r2.a("read lastRequestTime = " + u);
                        }
                    } catch (Throwable th2) {
                        r2.b("ZXTable解密失败,Key:" + i2 + ",error:" + th2.getMessage());
                    }
                }
            }
            if (h1Var.e.getAndSet(true)) {
            }
        } catch (Throwable th3) {
            r2.a(th3);
            return;
        }
        if (cursorQuery != null) {
        }
        G = true;
        h1Var = h1.b.f16802a;
        h1Var.getClass();
        if (!new JSONObject(l).has("zxc2")) {
        }
        if (!z2) {
        }
    }

    public static void c() {
        try {
            if (C != null) {
                JSONObject jSONObject = new JSONObject(C);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(UMModuleRegister.INNER);
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("external");
                if (jSONArrayOptJSONArray != null) {
                    Set<String> set = H;
                    set.clear();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        set.add(jSONArrayOptJSONArray.getString(i2));
                    }
                }
                if (jSONArrayOptJSONArray2 != null) {
                    Set<String> set2 = I;
                    set2.clear();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                        set2.add(jSONArrayOptJSONArray2.getString(i3));
                    }
                }
            }
        } catch (JSONException e2) {
            r2.a(e2);
        }
    }

    public static void a(u3 u3Var) {
        if (w == null) {
            IvParameterSpec ivParameterSpecG = u3Var.g();
            w = ivParameterSpecG;
            if (ivParameterSpecG == null) {
                byte[] bArrGenerateSeed = new SecureRandom().generateSeed(16);
                String str = new String(Base64.encode(bArrGenerateSeed, 0), StandardCharsets.UTF_8);
                u3Var.a(10, str + "", false);
                r2.a("ZXID saveIvParameter ivStr:" + str);
                w = new IvParameterSpec(bArrGenerateSeed);
            }
        }
        if (v == null) {
            SecretKey secretKeyI = u3Var.i();
            v = secretKeyI;
            if (secretKeyI == null) {
                try {
                    SecureRandom secureRandom = p.f16841a;
                    KeyGenerator keyGenerator = KeyGenerator.getInstance(EncryptUtils.AES_ENCRYPT_ALGORITHM);
                    keyGenerator.init(128);
                    SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
                    v = secretKeyGenerateKey;
                    u3Var.a(secretKeyGenerateKey.getEncoded());
                } catch (NoSuchAlgorithmException e2) {
                    r2.a(e2);
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void b() {
        String str = UUID.randomUUID().toString().replaceAll("-", "") + "-" + p.a(w3.b() + Build.MODEL, "SHA256");
        l2 l2Var = l2.a.f16824a;
        l2Var.f16823a.getClass();
        if (!TextUtils.equals(str, h)) {
            h = str;
            l2Var.f16823a.a(0, str, true);
        }
        r.a("ZXID 生成LID:" + str);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] strArrSplit = str.split("-");
        return strArrSplit.length == 2 ? strArrSplit[0] : str;
    }

    public static String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bt.af, i);
            jSONObject.put("ext", j);
        } catch (JSONException e2) {
            r2.a(e2);
        }
        return jSONObject.toString();
    }
}
