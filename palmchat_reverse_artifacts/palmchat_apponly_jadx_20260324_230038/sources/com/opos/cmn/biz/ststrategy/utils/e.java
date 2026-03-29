package com.opos.cmn.biz.ststrategy.utils;

import android.content.Context;
import com.huawei.hms.ads.ex;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7886a = "e";
    private static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock c = new ReentrantReadWriteLock();
    private static STConfigEntity d = null;

    public static int a(Context context, JSONObject jSONObject) throws JSONException {
        int i = 0;
        if (context != null && jSONObject != null) {
            try {
                if (jSONObject.has("data") && !jSONObject.isNull("data")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (jSONObject2.has("currTime") && !jSONObject2.isNull("currTime")) {
                        i = jSONObject2.getInt("currTime");
                    }
                }
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.c(f7886a, "", e);
            }
        }
        com.opos.cmn.an.f.a.b(f7886a, "currTime=" + i);
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[Catch: all -> 0x0072, Exception -> 0x0074, TRY_LEAVE, TryCatch #5 {Exception -> 0x0074, blocks: (B:8:0x0026, B:10:0x002c, B:12:0x004a, B:14:0x004d, B:19:0x0076), top: B:59:0x0026, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject b(Context context) {
        String str;
        JSONObject jSONObject = null;
        try {
            if (context != null) {
                try {
                    c.readLock().lock();
                    if (c(context)) {
                        String str2 = f7886a;
                        com.opos.cmn.an.f.a.b(str2, "st config file exists.");
                        FileInputStream fileInputStreamOpenFileInput = context.openFileInput(d(context));
                        try {
                            if (fileInputStreamOpenFileInput != null) {
                                try {
                                    if (fileInputStreamOpenFileInput.available() > 0) {
                                        com.opos.cmn.an.f.a.b(str2, "fileInputStream=" + fileInputStreamOpenFileInput.available());
                                        byte[] bArrA = a(fileInputStreamOpenFileInput);
                                        if (bArrA != null && bArrA.length > 0) {
                                            com.opos.cmn.an.f.a.b(str2, "bytes=" + bArrA.length);
                                            jSONObject = new JSONObject(new String(bArrA, 0, bArrA.length, "UTF-8"));
                                        }
                                    } else {
                                        com.opos.cmn.an.f.a.b(str2, "fileInputStream=null.");
                                    }
                                    if (fileInputStreamOpenFileInput != null) {
                                        try {
                                            fileInputStreamOpenFileInput.close();
                                        } catch (IOException e) {
                                            e = e;
                                            str = f7886a;
                                            com.opos.cmn.an.f.a.c(str, "", e);
                                        }
                                    }
                                } catch (Exception e2) {
                                    com.opos.cmn.an.f.a.c(f7886a, "", e2);
                                    if (fileInputStreamOpenFileInput != null) {
                                        try {
                                            fileInputStreamOpenFileInput.close();
                                        } catch (IOException e3) {
                                            e = e3;
                                            str = f7886a;
                                            com.opos.cmn.an.f.a.c(str, "", e);
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            if (fileInputStreamOpenFileInput != null) {
                                try {
                                    fileInputStreamOpenFileInput.close();
                                } catch (IOException e4) {
                                    com.opos.cmn.an.f.a.c(f7886a, "", e4);
                                }
                            }
                            throw th;
                        }
                    } else {
                        com.opos.cmn.an.f.a.a(f7886a, "st config file not exists!!!");
                    }
                } catch (FileNotFoundException e5) {
                    com.opos.cmn.an.f.a.c(f7886a, "", e5);
                }
            }
            com.opos.cmn.an.f.a.b(f7886a, "get local STConfig json=" + jSONObject);
            return jSONObject;
        } finally {
            c.readLock().unlock();
        }
    }

    public static boolean c(Context context) {
        if (context != null) {
            try {
                return new File(context.getFilesDir(), d(context)).exists();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c(f7886a, "", e);
            }
        }
        return false;
    }

    public static String d(Context context) {
        com.opos.cmn.an.f.a.b(f7886a, "getSTConfigFileName=acs_st_config_merge.ini");
        return "acs_st_config_merge.ini";
    }

    public static STConfigEntity a() {
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = b;
            reentrantReadWriteLock.readLock().lock();
            STConfigEntity sTConfigEntity = d;
            reentrantReadWriteLock.readLock().unlock();
            return sTConfigEntity;
        } catch (Throwable th) {
            b.readLock().unlock();
            throw th;
        }
    }

    public static synchronized boolean b(Context context, JSONObject jSONObject) {
        boolean zC;
        boolean zA;
        STConfigEntity sTConfigEntityA;
        String str = f7886a;
        com.opos.cmn.an.f.a.b(str, "saveOrMergeSTConfig begin");
        zC = false;
        if (context != null && jSONObject != null) {
            if (c(context)) {
                com.opos.cmn.an.f.a.b(str, "onlineJsonArray getMetaListArray");
                JSONArray jSONArrayA = c.a(context, jSONObject);
                if (jSONArrayA == null || jSONArrayA.length() <= 0) {
                    zA = false;
                } else {
                    HashSet<String> hashSetB = c.b(context, jSONObject);
                    JSONObject jSONObjectB = b(context);
                    zA = true;
                    if (jSONObjectB != null) {
                        com.opos.cmn.an.f.a.b(str, "localJsonArray getMetaListArray");
                        JSONArray jSONArrayA2 = c.a(context, jSONObjectB);
                        if (jSONArrayA2 != null && jSONArrayA2.length() > 0) {
                            zA = c.a(jSONArrayA2, jSONArrayA, hashSetB);
                        }
                    }
                }
                if (zA && (sTConfigEntityA = g.a(jSONObject)) != null) {
                    a(sTConfigEntityA);
                    zC = c(context, jSONObject);
                }
            } else {
                STConfigEntity sTConfigEntityA2 = g.a(jSONObject);
                if (sTConfigEntityA2 != null) {
                    a(sTConfigEntityA2);
                    zC = c(context, jSONObject);
                }
            }
        }
        com.opos.cmn.an.f.a.b(str, "saveOrMergeSTConfig end result:" + zC);
        return zC;
    }

    private static boolean c(Context context, JSONObject jSONObject) {
        byte[] bArrD;
        boolean zA = (context == null || jSONObject == null || (bArrD = d(context, jSONObject)) == null || bArrD.length <= 0) ? false : a(context, bArrD);
        com.opos.cmn.an.f.a.b(f7886a, "savejsonObjectSTConfig to file result: " + zA);
        return zA;
    }

    private static byte[] d(Context context, JSONObject jSONObject) {
        byte[] bytes;
        byte[] bArr = null;
        if (context != null && jSONObject != null) {
            try {
                String string = jSONObject.toString();
                if (string != null) {
                    try {
                        bytes = string.getBytes("UTF-8");
                    } catch (Exception unused) {
                        bytes = string.getBytes();
                    }
                    bArr = bytes;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c(f7886a, "", e);
            }
        }
        String str = f7886a;
        StringBuilder sb = new StringBuilder();
        sb.append("getJsonObjectBytes bytes is null ?");
        sb.append(bArr == null ? ex.Code : ex.V);
        com.opos.cmn.an.f.a.b(str, sb.toString());
        return bArr;
    }

    public static synchronized STConfigEntity a(Context context) {
        STConfigEntity sTConfigEntityA;
        if (context != null) {
            boolean z = a() == null;
            String str = f7886a;
            com.opos.cmn.an.f.a.b(str, "get stConfig Entity，is read from file=" + z);
            if (z) {
                STConfigEntity sTConfigEntityA2 = g.a(context);
                if (a() != null || sTConfigEntityA2 == null) {
                    com.opos.cmn.an.f.a.b(str, "getSTConfigEntity != null || tempSTConfigEntity == null");
                } else {
                    a(sTConfigEntityA2);
                }
            }
            sTConfigEntityA = a();
        } else {
            sTConfigEntityA = null;
        }
        return sTConfigEntityA;
    }

    public static JSONObject a(Context context, com.opos.cmn.func.a.a.e eVar) {
        InputStream inputStream;
        byte[] bArrA;
        JSONObject jSONObject = null;
        if (context != null && eVar != null && (inputStream = eVar.c) != null && (bArrA = a(inputStream)) != null && bArrA.length > 0) {
            try {
                JSONObject jSONObject2 = new JSONObject(new String(bArrA, 0, bArrA.length, "UTF-8"));
                if (jSONObject2.has("code") && !jSONObject2.isNull("code")) {
                    int i = jSONObject2.getInt("code");
                    if (i == 0) {
                        try {
                            if (jSONObject2.has("data") && !jSONObject2.isNull("data")) {
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                                if (jSONObject3.has(WkAdConfigModel.TAG_STRATEGY) && !jSONObject3.isNull(WkAdConfigModel.TAG_STRATEGY)) {
                                    JSONObject jSONObject4 = jSONObject3.getJSONObject(WkAdConfigModel.TAG_STRATEGY);
                                    if (jSONObject4.has("nxLimit") && !jSONObject4.isNull("nxLimit")) {
                                        long j = jSONObject4.getLong("nxLimit");
                                        com.opos.cmn.an.f.a.b(f7886a, "set ntLimit=" + j);
                                        d.a(context, j);
                                    }
                                    if (jSONObject4.has("dtLimit") && !jSONObject4.isNull("dtLimit")) {
                                        int i2 = jSONObject4.getInt("dtLimit");
                                        com.opos.cmn.an.f.a.b(f7886a, "set dtLimit=" + i2);
                                        d.a(context, i2);
                                    }
                                    if (jSONObject4.has("blackListLimit") && !jSONObject4.isNull("blackListLimit")) {
                                        int i3 = jSONObject4.getInt("blackListLimit");
                                        com.opos.cmn.an.f.a.b(f7886a, "set blaLimit=" + i3);
                                        d.b(context, i3);
                                    }
                                }
                            }
                            d.a(context, com.opos.cmn.biz.a.d.a(context));
                        } catch (Exception e) {
                            e = e;
                            jSONObject = jSONObject2;
                            com.opos.cmn.an.f.a.c(f7886a, "", e);
                        }
                    } else if (-3 != i) {
                        String string = jSONObject2.getString("msg");
                        String str = f7886a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("netResponseToJsonObject code=");
                        sb.append(i);
                        sb.append(",msg=");
                        if (string == null) {
                            string = "";
                        }
                        sb.append(string);
                        sb.append(",json=");
                        sb.append(jSONObject2.toString());
                        com.opos.cmn.an.f.a.b(str, sb.toString());
                    }
                    jSONObject = jSONObject2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        com.opos.cmn.an.f.a.a(f7886a, "netResponseToJsonObject result:" + jSONObject);
        return jSONObject;
    }

    private static void a(STConfigEntity sTConfigEntity) {
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = b;
            reentrantReadWriteLock.writeLock().lock();
            d = sTConfigEntity;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            b.writeLock().unlock();
            throw th;
        }
    }

    private static boolean a(Context context, byte[] bArr) {
        boolean z = false;
        if (context != null && bArr != null && bArr.length > 0) {
            FileOutputStream fileOutputStreamOpenFileOutput = null;
            try {
                try {
                    c.writeLock().lock();
                    fileOutputStreamOpenFileOutput = context.openFileOutput(d(context), 0);
                    if (fileOutputStreamOpenFileOutput != null) {
                        fileOutputStreamOpenFileOutput.write(bArr, 0, bArr.length);
                        fileOutputStreamOpenFileOutput.flush();
                        com.opos.cmn.an.f.a.b(f7886a, "fileOutputStream flush!!!");
                        z = true;
                    }
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException e) {
                            e = e;
                            com.opos.cmn.an.f.a.c(f7886a, "", e);
                        }
                    }
                } catch (Throwable th) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException e2) {
                            com.opos.cmn.an.f.a.c(f7886a, "", e2);
                        }
                    }
                    c.writeLock().unlock();
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                com.opos.cmn.an.f.a.c(f7886a, "", e3);
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e4) {
                        e = e4;
                        com.opos.cmn.an.f.a.c(f7886a, "", e);
                    }
                }
            } catch (IOException e5) {
                com.opos.cmn.an.f.a.c(f7886a, "", e5);
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e6) {
                        e = e6;
                        com.opos.cmn.an.f.a.c(f7886a, "", e);
                    }
                }
            }
            c.writeLock().unlock();
        }
        return z;
    }

    private static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (-1 == i) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c(f7886a, "", e);
            return null;
        }
    }
}
