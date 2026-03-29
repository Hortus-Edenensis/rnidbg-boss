package com.getui.gtc.i.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.getui.gtc.BuildConfig;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.http.MediaType;
import com.getui.gtc.base.http.MultipartBody;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.RequestBody;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.e.c;
import com.igexin.push.f.b.d;
import com.igexin.sdk.PushManager;
import com.lantern.auth.server.WkParams;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f5796a = new AtomicBoolean(false);

    private static File a() {
        return new File(CommonUtil.getExternalFilesDir(GtcProvider.context()), GtcProvider.context().getPackageName() + "-online.properties");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File b(File file) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        GZIPOutputStream gZIPOutputStream;
        if (!file.exists()) {
            return null;
        }
        File file2 = new File(file + ".zip");
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i != -1) {
                                gZIPOutputStream.write(bArr, 0, i);
                            } else {
                                try {
                                    break;
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        }
                        gZIPOutputStream.close();
                        fileOutputStream.close();
                        fileInputStream.close();
                        return file2;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            if (gZIPOutputStream != null) {
                                try {
                                } catch (Throwable th3) {
                                    return null;
                                }
                            }
                            return null;
                        } finally {
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (Throwable th32) {
                                    th32.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    gZIPOutputStream = null;
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                gZIPOutputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
            fileInputStream = null;
            gZIPOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context) {
        String str = "";
        try {
            Object objInvoke = PushManager.class.getDeclaredMethod("getClientid", Context.class).invoke(PushManager.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), context);
            if (objInvoke != null) {
                str = (String) objInvoke;
            }
        } catch (Throwable th) {
            a.a("reflect cid", th);
        }
        a.a("reflect cid:".concat(str));
        return str;
    }

    private static JSONObject a(String str) {
        JSONObject jSONObjectA;
        int i;
        boolean z;
        try {
            a.a("update file log config:".concat(String.valueOf(str)));
            jSONObjectA = c.a.f5766a.f5765a.a();
            i = 0;
            z = jSONObjectA != null && jSONObjectA.length() > 0;
        } catch (Throwable th) {
            a.c(th);
        }
        if (TextUtils.isEmpty(str)) {
            if (z) {
                a().delete();
                c.a.f5766a.f5765a.a((JSONObject) null);
                a.a("file log clear old config and properties");
            }
            return null;
        }
        if (z && jSONObjectA.optString("dycConfig").equals(str)) {
            a.a("file log same config");
            return jSONObjectA;
        }
        c.a.f5766a.f5765a.a((JSONObject) null);
        a().delete();
        a.a("file log clear old config and properties");
        String[] strArrSplit = str.split("\\|");
        if (strArrSplit.length < 8) {
            throw new IllegalStateException("file log dyc error");
        }
        JSONObject jSONObject = new JSONObject();
        String[] strArrSplit2 = strArrSplit[0].split(",");
        String str2 = com.getui.gtc.c.b.d;
        int length = strArrSplit2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            String str3 = strArrSplit2[i2];
            if (!TextUtils.isEmpty(str3) && str3.equals(str2)) {
                jSONObject.put("gtcid", str2);
                break;
            }
            i2++;
        }
        String[] strArrSplit3 = strArrSplit[1].split(",");
        String strB = b(GtcProvider.context());
        int length2 = strArrSplit3.length;
        while (true) {
            if (i >= length2) {
                break;
            }
            String str4 = strArrSplit3[i];
            if (!TextUtils.isEmpty(str4) && str4.equals(strB)) {
                jSONObject.put("cid", strB);
                break;
            }
            i++;
        }
        if (!jSONObject.has("gtcid") && !jSONObject.has("cid")) {
            a.a("file upload not match cur user");
            return null;
        }
        long time = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(strArrSplit[2]).getTime();
        long j = Long.parseLong(strArrSplit[3]);
        if (j <= 0) {
            a.a("file upload interval=" + j + " not valid");
        }
        jSONObject.put("allowMobile", "1".equals(strArrSplit[6]));
        jSONObject.put("startTime", time);
        jSONObject.put("interval", j);
        jSONObject.put("suffixes", strArrSplit[4]);
        jSONObject.put("enableKeys", strArrSplit[5]);
        jSONObject.put("url", strArrSplit[7]);
        if (a(jSONObject)) {
            jSONObject.put("lastModified", a().lastModified());
        }
        jSONObject.put("dycConfig", str);
        c.a.f5766a.f5765a.a(jSONObject);
        a.a("save file log dyc to db: " + jSONObject.toString());
        return jSONObject;
    }

    public static void a(Map<String, String> map) {
        try {
            if (f5796a.getAndSet(true)) {
                return;
            }
            final JSONObject jSONObjectA = a(map != null ? map.get("sdk.gtc.fileLog.upload") : null);
            if (jSONObjectA != null && jSONObjectA.length() != 0) {
                final long jOptLong = jSONObjectA.optLong("startTime");
                String strOptString = jSONObjectA.optString("gtcid");
                String strOptString2 = jSONObjectA.optString("cid");
                final long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis >= jOptLong && jCurrentTimeMillis <= d.b + jOptLong) {
                    if ((!TextUtils.isEmpty(strOptString) && strOptString.equals(com.getui.gtc.c.b.d)) || (!TextUtils.isEmpty(strOptString2) && strOptString2.equals(b(GtcProvider.context())))) {
                        if (CommonUtil.isAppDebugEnable()) {
                            a.b("file log upload is debug, disallow");
                            return;
                        }
                        boolean zOptBoolean = jSONObjectA.optBoolean("allowMobile");
                        if (!a(zOptBoolean)) {
                            a.b("file log upload network is not allowed, allowMobile:".concat(String.valueOf(zOptBoolean)));
                            return;
                        }
                        File fileA = a();
                        long jOptLong2 = jSONObjectA.optLong("lastModified");
                        if (jOptLong2 == 0 || jOptLong2 != fileA.lastModified()) {
                            if (!a(jSONObjectA)) {
                                return;
                            }
                            jSONObjectA.put("lastModified", fileA.lastModified());
                            c.a.f5766a.f5765a.a(jSONObjectA);
                        }
                        if (jCurrentTimeMillis - jSONObjectA.optLong("reportTime") < jSONObjectA.optLong("interval") * 1000) {
                            a.c("file log report time not expired");
                            return;
                        }
                        Thread thread = new Thread(new Runnable() { // from class: com.getui.gtc.i.c.b.1
                            /* JADX WARN: Removed duplicated region for block: B:114:0x02f0 A[Catch: all -> 0x0306, TryCatch #3 {all -> 0x0306, blocks: (B:111:0x02e7, B:112:0x02ea, B:114:0x02f0, B:115:0x0303, B:69:0x0250, B:71:0x0259, B:92:0x02a3, B:94:0x02a9), top: B:138:0x02e7 }] */
                            /* JADX WARN: Removed duplicated region for block: B:138:0x02e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void run() {
                                String str;
                                String[] strArr;
                                File file;
                                SimpleDateFormat simpleDateFormat;
                                String str2;
                                SimpleDateFormat simpleDateFormat2;
                                File file2;
                                File file3;
                                String str3;
                                String str4;
                                File file4;
                                File file5;
                                String str5;
                                File fileB;
                                String str6 = "-";
                                try {
                                    String[] strArrSplit = jSONObjectA.optString("suffixes").split(",");
                                    File externalFilesDir = CommonUtil.getExternalFilesDir(GtcProvider.context());
                                    String packageName = GtcProvider.context().getPackageName();
                                    SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                                    SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                                    String str7 = "";
                                    try {
                                        str7 = com.getui.gtc.i.d.a.a(packageName).versionName;
                                    } catch (Throwable th) {
                                        a.b(th);
                                    }
                                    int length = strArrSplit.length;
                                    boolean z = false;
                                    int i = 0;
                                    while (i < length) {
                                        String str8 = strArrSplit[i];
                                        boolean z2 = z;
                                        int i2 = length;
                                        int i3 = i;
                                        long j = jCurrentTimeMillis;
                                        int i4 = 7;
                                        while (j > jOptLong && i4 > 0) {
                                            int i5 = i4 - 1;
                                            try {
                                                str4 = simpleDateFormat3.format(new Date(j));
                                                strArr = strArrSplit;
                                                try {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(packageName);
                                                    sb.append(str6);
                                                    sb.append(str8);
                                                    sb.append(str6);
                                                    sb.append(str4);
                                                    str = str6;
                                                    try {
                                                        sb.append(".log");
                                                        file4 = new File(externalFilesDir, sb.toString());
                                                        try {
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            file = externalFilesDir;
                                                        }
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        file = externalFilesDir;
                                                        simpleDateFormat = simpleDateFormat3;
                                                        str2 = str8;
                                                        simpleDateFormat2 = simpleDateFormat4;
                                                        file2 = null;
                                                        file3 = null;
                                                        try {
                                                            a.a("file log upload http error", th);
                                                            if (j != jCurrentTimeMillis) {
                                                            }
                                                            j -= 86400000;
                                                            simpleDateFormat4 = simpleDateFormat2;
                                                            i4 = i5;
                                                            strArrSplit = strArr;
                                                            str6 = str;
                                                            externalFilesDir = file;
                                                            simpleDateFormat3 = simpleDateFormat;
                                                            str8 = str2;
                                                        } finally {
                                                            if (file2 != null) {
                                                                try {
                                                                    file2.delete();
                                                                } catch (Throwable unused) {
                                                                }
                                                            }
                                                            if (j != jCurrentTimeMillis) {
                                                                file3.delete();
                                                                a.a("file log upload delete old log file, fileName:" + file3.getName());
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    str = str6;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                                str = str6;
                                                strArr = strArrSplit;
                                            }
                                            if (!file4.exists() || !file4.isFile()) {
                                                file = externalFilesDir;
                                                simpleDateFormat = simpleDateFormat3;
                                                str2 = str8;
                                                simpleDateFormat2 = simpleDateFormat4;
                                                try {
                                                    a.a("file log not exists :" + file4.getName());
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    file3 = file4;
                                                    file2 = null;
                                                    a.a("file log upload http error", th);
                                                    if (j != jCurrentTimeMillis) {
                                                    }
                                                    j -= 86400000;
                                                    simpleDateFormat4 = simpleDateFormat2;
                                                    i4 = i5;
                                                    strArrSplit = strArr;
                                                    str6 = str;
                                                    externalFilesDir = file;
                                                    simpleDateFormat3 = simpleDateFormat;
                                                    str8 = str2;
                                                }
                                                if (j != jCurrentTimeMillis) {
                                                    file4.delete();
                                                    str3 = "file log upload delete old log file, fileName:" + file4.getName();
                                                    a.a(str3);
                                                }
                                                j -= 86400000;
                                                simpleDateFormat4 = simpleDateFormat2;
                                                i4 = i5;
                                                strArrSplit = strArr;
                                                str6 = str;
                                                externalFilesDir = file;
                                                simpleDateFormat3 = simpleDateFormat;
                                                str8 = str2;
                                            } else if (file4.length() > 52428800) {
                                                try {
                                                    StringBuilder sb2 = new StringBuilder("file log is too large,length=");
                                                    file5 = externalFilesDir;
                                                    try {
                                                        sb2.append(file4.length());
                                                        a.b(sb2.toString());
                                                        try {
                                                            if (j != jCurrentTimeMillis) {
                                                                file4.delete();
                                                                str5 = "file log upload delete old log file, fileName:" + file4.getName();
                                                                a.a(str5);
                                                            }
                                                        } catch (Throwable unused2) {
                                                        }
                                                        j -= 86400000;
                                                        externalFilesDir = file5;
                                                        i4 = i5;
                                                        strArrSplit = strArr;
                                                        str6 = str;
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        file = file5;
                                                        simpleDateFormat = simpleDateFormat3;
                                                        str2 = str8;
                                                        file3 = file4;
                                                        file2 = null;
                                                        simpleDateFormat2 = simpleDateFormat4;
                                                        a.a("file log upload http error", th);
                                                        if (j != jCurrentTimeMillis) {
                                                        }
                                                        j -= 86400000;
                                                        simpleDateFormat4 = simpleDateFormat2;
                                                        i4 = i5;
                                                        strArrSplit = strArr;
                                                        str6 = str;
                                                        externalFilesDir = file;
                                                        simpleDateFormat3 = simpleDateFormat;
                                                        str8 = str2;
                                                    }
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    file5 = externalFilesDir;
                                                }
                                            } else {
                                                file5 = externalFilesDir;
                                                try {
                                                    fileB = b.b(file4);
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    file = file5;
                                                    simpleDateFormat = simpleDateFormat3;
                                                    str2 = str8;
                                                    simpleDateFormat2 = simpleDateFormat4;
                                                    file3 = file4;
                                                    file2 = null;
                                                    a.a("file log upload http error", th);
                                                    if (file2 != null) {
                                                        try {
                                                            file2.delete();
                                                        } catch (Throwable unused3) {
                                                        }
                                                    }
                                                    if (j != jCurrentTimeMillis) {
                                                        file3.delete();
                                                        str3 = "file log upload delete old log file, fileName:" + file3.getName();
                                                        a.a(str3);
                                                    }
                                                    j -= 86400000;
                                                    simpleDateFormat4 = simpleDateFormat2;
                                                    i4 = i5;
                                                    strArrSplit = strArr;
                                                    str6 = str;
                                                    externalFilesDir = file;
                                                    simpleDateFormat3 = simpleDateFormat;
                                                    str8 = str2;
                                                }
                                                if (fileB == null) {
                                                    try {
                                                        a.b("file log to zip error,fileName:" + file4.getName());
                                                        if (fileB != null) {
                                                            fileB.delete();
                                                        }
                                                        if (j != jCurrentTimeMillis) {
                                                            file4.delete();
                                                            str5 = "file log upload delete old log file, fileName:" + file4.getName();
                                                            a.a(str5);
                                                        }
                                                        j -= 86400000;
                                                        externalFilesDir = file5;
                                                        i4 = i5;
                                                        strArrSplit = strArr;
                                                        str6 = str;
                                                    } catch (Throwable th10) {
                                                        th = th10;
                                                        file = file5;
                                                        simpleDateFormat = simpleDateFormat3;
                                                        str2 = str8;
                                                        file3 = file4;
                                                        file2 = fileB;
                                                        simpleDateFormat2 = simpleDateFormat4;
                                                        a.a("file log upload http error", th);
                                                        if (j != jCurrentTimeMillis) {
                                                        }
                                                        j -= 86400000;
                                                        simpleDateFormat4 = simpleDateFormat2;
                                                        i4 = i5;
                                                        strArrSplit = strArr;
                                                        str6 = str;
                                                        externalFilesDir = file;
                                                        simpleDateFormat3 = simpleDateFormat;
                                                        str8 = str2;
                                                    }
                                                } else {
                                                    try {
                                                        MultipartBody.Builder builder = new MultipartBody.Builder();
                                                        file = file5;
                                                        try {
                                                            builder.setType(MultipartBody.FORM);
                                                            JSONObject jSONObject = new JSONObject();
                                                            simpleDateFormat = simpleDateFormat3;
                                                            str2 = str8;
                                                            try {
                                                                jSONObject.put("gtcid", com.getui.gtc.c.b.d);
                                                                jSONObject.put("cid", b.b(GtcProvider.context()));
                                                                jSONObject.put("gtcVersion", BuildConfig.VERSION_NAME);
                                                                jSONObject.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, simpleDateFormat4.format(new Date()));
                                                                jSONObject.put("createDate", str4);
                                                                simpleDateFormat2 = simpleDateFormat4;
                                                                try {
                                                                    jSONObject.put("lastModified", file4.lastModified());
                                                                    jSONObject.put("versionName", str7);
                                                                    jSONObject.put("packageName", packageName);
                                                                    jSONObject.put("brand", Build.BRAND);
                                                                    jSONObject.put(WkParams.MODEL, Build.MODEL);
                                                                    int i6 = Build.VERSION.SDK_INT;
                                                                    jSONObject.put("abi", Arrays.toString(Build.SUPPORTED_ABIS));
                                                                    jSONObject.put("androidVersion", i6);
                                                                    builder.addFormDataPart("content", jSONObject.toString());
                                                                    builder.addFormDataPart("packageName", packageName);
                                                                    builder.addFormDataPart("logFile", fileB.getName(), RequestBody.create(MediaType.get("application/octet-stream"), fileB));
                                                                    a.a("file log upload result:" + com.getui.gtc.h.d.f5789a.newCall(new Request.Builder().url(jSONObjectA.getString("url")).method("POST").logFlags(1).body(builder.build()).build()).execute().body().string() + ", logFile:" + file4.getName());
                                                                    if (!z2) {
                                                                        try {
                                                                            jSONObjectA.put("reportTime", jCurrentTimeMillis);
                                                                            c.a.f5766a.f5765a.a(jSONObjectA);
                                                                            a.a("file log update report time");
                                                                            z2 = true;
                                                                        } catch (Throwable th11) {
                                                                            th = th11;
                                                                            file3 = file4;
                                                                            z2 = true;
                                                                            file2 = fileB;
                                                                            a.a("file log upload http error", th);
                                                                            if (j != jCurrentTimeMillis) {
                                                                            }
                                                                            j -= 86400000;
                                                                            simpleDateFormat4 = simpleDateFormat2;
                                                                            i4 = i5;
                                                                            strArrSplit = strArr;
                                                                            str6 = str;
                                                                            externalFilesDir = file;
                                                                            simpleDateFormat3 = simpleDateFormat;
                                                                            str8 = str2;
                                                                        }
                                                                    }
                                                                    fileB.delete();
                                                                } catch (Throwable th12) {
                                                                    th = th12;
                                                                    file3 = file4;
                                                                    file2 = fileB;
                                                                    a.a("file log upload http error", th);
                                                                    if (j != jCurrentTimeMillis) {
                                                                    }
                                                                    j -= 86400000;
                                                                    simpleDateFormat4 = simpleDateFormat2;
                                                                    i4 = i5;
                                                                    strArrSplit = strArr;
                                                                    str6 = str;
                                                                    externalFilesDir = file;
                                                                    simpleDateFormat3 = simpleDateFormat;
                                                                    str8 = str2;
                                                                }
                                                            } catch (Throwable th13) {
                                                                th = th13;
                                                                simpleDateFormat2 = simpleDateFormat4;
                                                                file3 = file4;
                                                                file2 = fileB;
                                                                a.a("file log upload http error", th);
                                                                if (j != jCurrentTimeMillis) {
                                                                }
                                                                j -= 86400000;
                                                                simpleDateFormat4 = simpleDateFormat2;
                                                                i4 = i5;
                                                                strArrSplit = strArr;
                                                                str6 = str;
                                                                externalFilesDir = file;
                                                                simpleDateFormat3 = simpleDateFormat;
                                                                str8 = str2;
                                                            }
                                                        } catch (Throwable th14) {
                                                            th = th14;
                                                            simpleDateFormat = simpleDateFormat3;
                                                            str2 = str8;
                                                            simpleDateFormat2 = simpleDateFormat4;
                                                            file3 = file4;
                                                            file2 = fileB;
                                                            a.a("file log upload http error", th);
                                                            if (j != jCurrentTimeMillis) {
                                                            }
                                                            j -= 86400000;
                                                            simpleDateFormat4 = simpleDateFormat2;
                                                            i4 = i5;
                                                            strArrSplit = strArr;
                                                            str6 = str;
                                                            externalFilesDir = file;
                                                            simpleDateFormat3 = simpleDateFormat;
                                                            str8 = str2;
                                                        }
                                                    } catch (Throwable th15) {
                                                        th = th15;
                                                        file = file5;
                                                    }
                                                    if (j != jCurrentTimeMillis) {
                                                        file4.delete();
                                                        str3 = "file log upload delete old log file, fileName:" + file4.getName();
                                                        a.a(str3);
                                                    }
                                                    j -= 86400000;
                                                    simpleDateFormat4 = simpleDateFormat2;
                                                    i4 = i5;
                                                    strArrSplit = strArr;
                                                    str6 = str;
                                                    externalFilesDir = file;
                                                    simpleDateFormat3 = simpleDateFormat;
                                                    str8 = str2;
                                                }
                                            }
                                        }
                                        i = i3 + 1;
                                        simpleDateFormat4 = simpleDateFormat4;
                                        z = z2;
                                        length = i2;
                                        strArrSplit = strArrSplit;
                                        str6 = str6;
                                        externalFilesDir = externalFilesDir;
                                        simpleDateFormat3 = simpleDateFormat3;
                                    }
                                } catch (Throwable th16) {
                                    a.a("file log upload unknown error", th16);
                                }
                            }
                        });
                        thread.setName("GTC_fileLogUploadThread");
                        thread.start();
                        return;
                    }
                    a().delete();
                    a.a("file log upload gtcid or cid changed");
                    return;
                }
                a.a("current time is not in file log upload time range");
                a().delete();
                return;
            }
            a.a("file log upload no dyc config in db");
        } catch (Throwable th) {
            a.c(th);
        }
    }

    private static boolean a(JSONObject jSONObject) {
        FileOutputStream fileOutputStream = null;
        try {
            long jOptLong = jSONObject.optLong("startTime");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis >= jOptLong && jCurrentTimeMillis <= jOptLong + d.b) {
                String[] strArrSplit = jSONObject.optString("enableKeys").split(",");
                StringBuilder sb = new StringBuilder();
                for (String str : strArrSplit) {
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                        sb.append('=');
                        sb.append("true\n");
                    }
                }
                if (sb.length() == 0) {
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a(), false);
                try {
                    fileOutputStream2.write(sb.toString().getBytes());
                    fileOutputStream2.flush();
                    a.a("file log write enableKeys success.");
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (Throwable th) {
                        a.c(th);
                        return true;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        a.c(th);
                        return false;
                    } finally {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                a.c(th3);
                            }
                        }
                    }
                }
            }
            a.a("current time is not in file log upload time range");
            return false;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static boolean a(boolean z) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) GtcProvider.context().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            if (!z) {
                if (activeNetworkInfo.getType() != 1) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
