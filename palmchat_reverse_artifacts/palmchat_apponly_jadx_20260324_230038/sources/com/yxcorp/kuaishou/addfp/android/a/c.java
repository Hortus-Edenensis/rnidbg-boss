package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.framework.common.ContainerUtils;
import com.kuaishou.weapon.p0.t;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import com.yxcorp.kuaishou.addfp.android.Orange;
import com.yxcorp.kuaishou.addfp.android.b.f;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class c {
    private static boolean d = true;
    private static int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11807a;
    private String b;
    private ReentrantLock c;

    private c() {
        this.b = "";
        this.c = new ReentrantLock();
    }

    public static c c() {
        return b.f11806a;
    }

    public String a() {
        try {
            return !TextUtils.isEmpty(this.f11807a) ? this.f11807a : "KWE_N";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_N";
        }
    }

    public void b(String str) {
        this.f11807a = str;
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str.replace(ContainerUtils.KEY_VALUE_DELIMITER, "").replace(ContainerUtils.FIELD_DELIMITER, "");
    }

    public static String b() {
        try {
            if (!d) {
                return "KWE_NPN";
            }
            if (e == 0) {
                int i = Build.VERSION.SDK_INT;
                boolean z = true;
                if (i < 33) {
                    boolean z2 = false;
                    if (i >= 29) {
                        String str = Build.MODEL;
                        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("redmi") && str.toLowerCase().contains("note 7")) {
                            z2 = true;
                        }
                        if (!Build.BRAND.equalsIgnoreCase("HONOR")) {
                            z = z2;
                        }
                    } else {
                        z = false;
                    }
                }
                if (!z) {
                    String strGSer = Orange.getInstance().gSer();
                    if (!TextUtils.isEmpty(strGSer) && !strGSer.startsWith("KWE")) {
                        return strGSer;
                    }
                }
            }
            return !TextUtils.isEmpty("") ? "" : "KWE_N";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_N";
        }
    }

    public static void a(JSONObject jSONObject) {
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if ("64".equals(next) && jSONObject.optInt(next, 1) == 0) {
                    d = false;
                }
                if ("64_level".equals(next)) {
                    e = jSONObject.optInt(next, 0);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String a(Context context, ResponseDfpCallback responseDfpCallback, boolean z) {
        long jCurrentTimeMillis;
        String eGidLocal;
        String strReplace;
        long blockCount;
        BufferedReader bufferedReader;
        long j;
        String strReplace2;
        System.currentTimeMillis();
        try {
            this.c.lock();
            if (!TextUtils.isEmpty(this.b)) {
                return this.b;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("k23", f.a(a(Build.MANUFACTURER)));
            jSONObject.put("k61", f.a(a(Build.BRAND)));
            jSONObject.put("k27", f.a(a(Build.MODEL)));
            jSONObject.put("k64", f.a(b()));
            jSONObject.put("k31", f.a(com.yxcorp.kuaishou.addfp.android.b.d.c(false)));
            jSONObject.put("k117", f.a(com.yxcorp.kuaishou.addfp.android.b.d.c(true)));
            jSONObject.put("k66", f.a(com.yxcorp.kuaishou.addfp.android.b.d.a(false)));
            jSONObject.put("k116", f.a(com.yxcorp.kuaishou.addfp.android.b.d.a(true)));
            try {
                jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            } catch (Throwable th) {
                th.printStackTrace();
                jCurrentTimeMillis = 0;
            }
            jSONObject.put("k39", f.a(Long.toString(jCurrentTimeMillis)));
            jSONObject.put("k101", Orange.getInstance().getResSoc("0"));
            jSONObject.put("k102", f.a("KWE_NPN"));
            jSONObject.put("k57", f.a(com.yxcorp.kuaishou.addfp.android.b.d.b(false)));
            jSONObject.put("k118", f.a(com.yxcorp.kuaishou.addfp.android.b.d.b(true)));
            jSONObject.put("k68", f.a(com.yxcorp.kuaishou.addfp.android.b.d.e(false)));
            jSONObject.put("k120", f.a(com.yxcorp.kuaishou.addfp.android.b.d.e(true)));
            jSONObject.put("k105", f.a(Orange.getInstance().gRdi()));
            try {
                eGidLocal = KWEGIDDFP.instance().getEGidLocal(context, c().a(), false);
                if (TextUtils.isEmpty(eGidLocal)) {
                    eGidLocal = "KWE_N";
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                eGidLocal = "KWE_PE";
            }
            jSONObject.put("k83", f.a(eGidLocal));
            jSONObject.put("k86", f.a(com.yxcorp.kuaishou.addfp.c.a.a.a(context)));
            try {
                strReplace = context.getPackageName().replace(ContainerUtils.KEY_VALUE_DELIMITER, "").replace(ContainerUtils.FIELD_DELIMITER, "");
            } catch (Throwable th3) {
                th3.printStackTrace();
                strReplace = "KWE_PE";
            }
            jSONObject.put("k3", f.a(strReplace));
            jSONObject.put("k109", f.a(Orange.getInstance().gProps()));
            jSONObject.put("k36", f.a("1.4.4.137.dea39c19"));
            jSONObject.put("k14", f.a("AD_AND"));
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            } catch (Throwable unused) {
                blockCount = 0;
            }
            jSONObject.put("k5", f.a(Long.toString(blockCount)));
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                try {
                    j = Long.parseLong(bufferedReader.readLine().split("\\s+")[1]) * 1024;
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        th.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        j = 0;
                    } finally {
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
            }
            jSONObject.put("k46", f.a(Long.toString(j)));
            try {
                strReplace2 = Build.VERSION.RELEASE.replace(ContainerUtils.KEY_VALUE_DELIMITER, "").replace(ContainerUtils.FIELD_DELIMITER, "");
            } catch (Throwable unused4) {
                strReplace2 = "KWE_PE";
            }
            jSONObject.put("k35", f.a(strReplace2));
            jSONObject.put("k110", f.a(Orange.getInstance().gKpsd()));
            jSONObject.put("k111", f.a("KWE_NPN"));
            jSONObject.put("k112", f.a(Orange.getInstance().sted(null, false)));
            jSONObject.put("k113", f.a(Orange.getInstance().gManu(context, com.yxcorp.kuaishou.addfp.c.a.a.a())));
            jSONObject.put("k115", f.a(com.yxcorp.kuaishou.addfp.android.b.d.d(true)));
            String strD = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
            if (z && !strD.equals("KWE_NPN") && strD.startsWith("KWE")) {
                if (Build.VERSION.SDK_INT >= 29) {
                    try {
                        new CountDownLatch(1).await(1000L, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                strD = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
            }
            jSONObject.put("k97", f.a(strD));
            try {
                CRC32 crc32 = new CRC32();
                for (int i = 1; i <= 120; i++) {
                    String str = t.f7496a + i;
                    if (jSONObject.has(str)) {
                        crc32.update(jSONObject.optString(str).getBytes());
                    }
                }
                jSONObject.put("k14", f.a("AD_AND:" + String.valueOf(crc32.getValue())));
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
            jSONObject.toString();
            int length = jSONObject.toString().getBytes().length;
            System.currentTimeMillis();
            byte[] magicWrapper = Orange.getInstance().getMagicWrapper(context, jSONObject.toString().getBytes(), 0);
            int length2 = magicWrapper.length;
            this.b = URLEncoder.encode(Base64.encodeToString(magicWrapper, 0), "utf-8");
        } finally {
            try {
            } finally {
            }
        }
        this.c.unlock();
        if (TextUtils.isEmpty(this.b)) {
            this.b = "KWE_N";
        }
        return this.b;
    }
}
