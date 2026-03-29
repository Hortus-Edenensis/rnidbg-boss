package com.zenmen.palmchat.webplatform;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.ttvecamera.TECameraSettings;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.framework.httpdns.ResDownloadHttpDnsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.webplatform.a;
import com.zenmen.palmchat.webplatform.miniPrograms.Package;
import defpackage.ac1;
import defpackage.hq3;
import defpackage.it0;
import defpackage.k86;
import defpackage.pu1;
import defpackage.rb3;
import defpackage.v4;
import defpackage.vw5;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zw4;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.cordova.jssdk.RedPacketPullNewPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static final String i = "b";
    public static b j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f15920a;
    public ExecutorService b;
    public ExecutorService c;
    public ExecutorService d;
    public Set<String> e;
    public String f;
    public String g;
    public d h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15921a;
        public final /* synthetic */ String b;

        public a(String str, String str2) {
            this.f15921a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            com.zenmen.palmchat.c.b().getContentResolver().update(hq3.f18029a, contentValues, "web_id=? and uid=?", new String[]{this.f15921a, this.b});
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.webplatform.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class RunnableC1136b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f15922a;
        public String[] b;
        public CountDownLatch c;

        /* JADX INFO: renamed from: com.zenmen.palmchat.webplatform.b$b$a */
        /* JADX INFO: compiled from: SearchBox */
        public class a implements a.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Package f15923a;

            public a(Package r2) {
                this.f15923a = r2;
            }

            @Override // com.zenmen.palmchat.webplatform.a.c
            public void onFail(Exception exc) {
                Log.i(b.i, "[AutoUpdate] fail pkgId = " + this.f15923a.pkgId);
                RunnableC1136b.this.c.countDown();
            }

            @Override // com.zenmen.palmchat.webplatform.a.c
            public void onSuccess(String str, int i) {
                Log.d(b.i, "[AutoUpdate] success pkgId = " + str);
                RunnableC1136b.this.c(str);
                RunnableC1136b.this.c.countDown();
            }
        }

        public RunnableC1136b(String[] strArr, d dVar) {
            this.b = strArr;
            this.f15922a = dVar;
        }

        public final void c(String str) {
            File[] fileArrListFiles;
            File file = new File(new File(com.zenmen.palmchat.c.b().getFilesDir(), "web_modules"), str);
            if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 2) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArrListFiles) {
                try {
                    arrayList.add(Integer.valueOf(file2.getName()));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            Collections.sort(arrayList);
            for (int size = arrayList.size() - 3; size >= 0; size--) {
                b.j(str, ((Integer) arrayList.get(size)).intValue());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr = this.b;
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            HashMap map = new HashMap();
            for (String str : this.b) {
                d dVar = this.f15922a;
                if (dVar != null && dVar.canUpdateWhenNotBuiltIn()) {
                    map.put(str, 0);
                }
                try {
                    Cursor cursorQuery = com.zenmen.palmchat.c.b().getContentResolver().query(hq3.f18029a, new String[]{"version"}, "web_id=?", new String[]{str}, null);
                    if (cursorQuery != null) {
                        if (cursorQuery.moveToFirst()) {
                            map.put(str, Integer.valueOf(cursorQuery.getInt(0)));
                        }
                        cursorQuery.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str2 : map.keySet()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appId", str2);
                    jSONObject.put("version", map.get(str2));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgs", jSONArray);
                JSONObject jSONObjectL = zw4.l(com.zenmen.palmchat.webplatform.a.e, 1, jSONObject2);
                if (jSONObjectL == null || jSONObjectL.getInt("resultCode") != 0) {
                    return;
                }
                JSONArray jSONArray2 = jSONObjectL.getJSONObject("data").getJSONArray("pkgs");
                Log.d(b.i, "[AutoUpdate] count = " + jSONArray2.length());
                this.c = new CountDownLatch(jSONArray2.length());
                for (int i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                    Package r4 = new Package();
                    r4.pkgId = jSONObject3.getString("appId");
                    r4.version = jSONObject3.getInt("version");
                    r4.md5 = jSONObject3.getString("md5");
                    int iIntValue = ((Integer) map.get(r4.pkgId)).intValue();
                    if (r4.version > iIntValue) {
                        try {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("appid", r4.pkgId);
                            jSONObject4.put("version", r4.version);
                            jSONObject4.put("oldVersion", iIntValue);
                            LogUtil.uploadInfoImmediate("623", null, null, jSONObject4.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        b.n().d.submit(new f(r4, new a(r4)));
                    } else {
                        Log.i(b.i, "[AutoUpdate] not update pkgId = " + r4.pkgId);
                        this.c.countDown();
                    }
                }
                this.c.await(10L, TimeUnit.MINUTES);
                Log.i(b.i, "[AutoUpdate] finished");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JSONArray f15924a;
        public JSONArray b;
        public int c;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15925a;

            public a(String str) {
                this.f15925a = str;
                put("action", "downMinAppORnot");
                put("needDownload", Boolean.TRUE);
                put("appId", str);
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.webplatform.b$c$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1137b extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15926a;

            public C1137b(String str) {
                this.f15926a = str;
                put("action", "downMinAppORnot");
                put("needDownload", Boolean.FALSE);
                put("appId", str);
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.webplatform.b$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1138c extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f15927a;
            public final /* synthetic */ String b;

            public C1138c(long j, String str) {
                this.f15927a = j;
                this.b = str;
                put("action", "downMinApp");
                put("startDownload_time", Long.valueOf(j));
                put("endDownload_time", Long.valueOf(System.currentTimeMillis()));
                put(ActionUtils.IS_SUCCESS, Boolean.TRUE);
                put("appId", str);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15928a;

            public d(String str) {
                this.f15928a = str;
                put("action", "dynamic_resource_download");
                put("status", "fail");
                put("detail", "url=" + str);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class e extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f15929a;
            public final /* synthetic */ String b;

            public e(long j, String str) {
                this.f15929a = j;
                this.b = str;
                put("action", "downMinApp");
                put("startDownload_time", Long.valueOf(j));
                put("endDownload_time", Long.valueOf(System.currentTimeMillis()));
                put(ActionUtils.IS_SUCCESS, Boolean.FALSE);
                put("appId", str);
            }
        }

        public c(JSONArray jSONArray, JSONArray jSONArray2, int i) {
            this.f15924a = jSONArray;
            this.b = jSONArray2;
            this.c = i;
        }

        public final void a(String str) {
            File[] fileArrListFiles;
            File file = new File(new File(com.zenmen.palmchat.c.b().getFilesDir(), "web_modules"), str);
            if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 2) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArrListFiles) {
                try {
                    arrayList.add(Integer.valueOf(file2.getName()));
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            Collections.sort(arrayList);
            for (int size = arrayList.size() - 3; size >= 0; size--) {
                b.j(str, ((Integer) arrayList.get(size)).intValue());
            }
        }

        public final void b(JSONObject jSONObject) throws Exception {
            String string;
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strOptString = jSONObject.optString("appId");
            int i = this.c;
            if (i == 2) {
                Uri.Builder builderBuildUpon = Uri.parse(k86.Z(com.zenmen.palmchat.webplatform.a.b)).buildUpon();
                builderBuildUpon.appendQueryParameter("appId", strOptString);
                string = builderBuildUpon.build().toString();
            } else if (i == 3) {
                string = com.zenmen.palmchat.webplatform.a.g + "?appId=" + strOptString + "&deviceId=" + ac1.o + "&dhid=" + ac1.h;
            } else {
                string = null;
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                c(jSONObject, string, null);
                LogUtil.i(b.i, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new C1138c(jCurrentTimeMillis, strOptString), (Throwable) null);
            } catch (Exception e2) {
                it0.k().s("all ip failed");
                String str = b.i;
                LogUtil.i(str, 3, new d(string), e2);
                LogUtil.i(str, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new e(jCurrentTimeMillis, strOptString), (Throwable) null);
                throw e2;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00ec, code lost:
        
            throw new java.lang.RuntimeException("find unsafe zip file");
         */
        /* JADX WARN: Not initialized variable reg: 20, insn: 0x02b9: MOVE (r7 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]) (LINE:698), block:B:113:0x02b8 */
        /* JADX WARN: Not initialized variable reg: 20, insn: 0x0350: MOVE (r7 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]) (LINE:849), block:B:170:0x034e */
        /* JADX WARN: Removed duplicated region for block: B:173:0x0360  */
        /* JADX WARN: Removed duplicated region for block: B:208:? A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void c(JSONObject jSONObject, String str, Map<String, String> map) throws Throwable {
            Throwable th;
            HttpURLConnection httpURLConnection;
            FileOutputStream fileOutputStream;
            BufferedInputStream bufferedInputStream;
            BufferedInputStream bufferedInputStream2;
            ZipInputStream zipInputStream;
            FileOutputStream fileOutputStream2;
            int i;
            HttpURLConnection httpURLConnectionC;
            HttpURLConnection httpURLConnection2;
            String string;
            int i2;
            String absolutePath;
            int contentLength;
            BufferedInputStream bufferedInputStream3;
            byte[] bArr;
            FileOutputStream fileOutputStream3;
            File fileT;
            byte[] bArr2;
            FileOutputStream fileOutputStream4;
            try {
                try {
                    i = 0;
                    httpURLConnectionC = new ResDownloadHttpDnsHelper().c(str, null, false);
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = null;
                    fileOutputStream = fileOutputStream2;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (JSONException e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
                fileOutputStream = null;
                bufferedInputStream = null;
                bufferedInputStream2 = null;
                zipInputStream = null;
            }
            try {
                string = jSONObject.getString("appId");
                i2 = jSONObject.getInt("version");
                absolutePath = new File(com.zenmen.palmchat.c.b().getExternalCacheDir(), string + ".zip").getAbsolutePath();
                contentLength = httpURLConnectionC.getContentLength();
                bufferedInputStream3 = new BufferedInputStream(httpURLConnectionC.getInputStream(), 4096);
                try {
                    fileOutputStream = new FileOutputStream(absolutePath);
                    try {
                        bArr = new byte[2048];
                        httpURLConnection2 = httpURLConnectionC;
                    } catch (IOException e4) {
                        e = e4;
                        httpURLConnection2 = httpURLConnectionC;
                    } catch (JSONException e5) {
                        e = e5;
                        httpURLConnection2 = httpURLConnectionC;
                    } catch (Throwable th4) {
                        th = th4;
                        httpURLConnection2 = httpURLConnectionC;
                    }
                } catch (IOException e6) {
                    e = e6;
                    throw e;
                } catch (JSONException e7) {
                    e = e7;
                    throw e;
                } catch (Throwable th5) {
                    httpURLConnection2 = httpURLConnectionC;
                    bufferedInputStream2 = bufferedInputStream3;
                    th = th5;
                    fileOutputStream = null;
                }
            } catch (IOException e8) {
                e = e8;
                throw e;
            } catch (JSONException e9) {
                e = e9;
                throw e;
            } catch (Throwable th6) {
                httpURLConnection2 = httpURLConnectionC;
                th = th6;
                fileOutputStream = null;
                bufferedInputStream = null;
                bufferedInputStream2 = null;
            }
            while (true) {
                try {
                    int i3 = bufferedInputStream3.read(bArr);
                    bufferedInputStream2 = bufferedInputStream3;
                    if (i3 != -1) {
                        i += i3;
                        try {
                            fileOutputStream.write(bArr, 0, i3);
                            bufferedInputStream3 = bufferedInputStream2;
                        } catch (IOException e10) {
                            e = e10;
                        } catch (JSONException e11) {
                            e = e11;
                            throw e;
                        } catch (Throwable th7) {
                            th = th7;
                            th = th;
                            bufferedInputStream = null;
                            zipInputStream = null;
                            httpURLConnection = httpURLConnection2;
                            pu1.u(fileOutputStream);
                            pu1.u(bufferedInputStream2);
                            pu1.u(bufferedInputStream);
                            pu1.u(zipInputStream);
                            if (httpURLConnection == null) {
                            }
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException e12) {
                            e = e12;
                        } catch (JSONException e13) {
                            e = e13;
                        } catch (Throwable th8) {
                            th = th8;
                            th = th;
                        }
                    }
                } catch (IOException e14) {
                    e = e14;
                } catch (JSONException e15) {
                    e = e15;
                    throw e;
                } catch (Throwable th9) {
                    th = th9;
                    bufferedInputStream2 = bufferedInputStream3;
                    th = th;
                    bufferedInputStream = null;
                    zipInputStream = null;
                    httpURLConnection = httpURLConnection2;
                    pu1.u(fileOutputStream);
                    pu1.u(bufferedInputStream2);
                    pu1.u(bufferedInputStream);
                    pu1.u(zipInputStream);
                    if (httpURLConnection == null) {
                    }
                }
                bufferedInputStream = null;
                zipInputStream = null;
                httpURLConnection = httpURLConnection2;
                pu1.u(fileOutputStream);
                pu1.u(bufferedInputStream2);
                pu1.u(bufferedInputStream);
                pu1.u(zipInputStream);
                if (httpURLConnection == null) {
                    throw th;
                }
                httpURLConnection.disconnect();
                throw th;
            }
            fileOutputStream.flush();
            try {
                if (i != contentLength) {
                    throw new IOException(absolutePath + " download failed");
                }
                String strB = rb3.b(new File(absolutePath));
                if (TextUtils.isEmpty(strB) || !strB.equals(jSONObject.optString("md5"))) {
                    throw new IOException("md5 dismatch");
                }
                ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(absolutePath));
                try {
                    bufferedInputStream = new BufferedInputStream(zipInputStream2);
                    try {
                        try {
                            fileT = b.t(string, i2);
                            if (!fileT.exists()) {
                                try {
                                    fileT.mkdirs();
                                } catch (Throwable th10) {
                                    th = th10;
                                    zipInputStream = zipInputStream2;
                                }
                            }
                            bArr2 = new byte[512];
                        } catch (Throwable th11) {
                            th = th11;
                            zipInputStream = zipInputStream2;
                        }
                    } catch (IOException e16) {
                        e = e16;
                    } catch (JSONException e17) {
                        e = e17;
                    }
                    while (true) {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            FileOutputStream fileOutputStream5 = fileOutputStream;
                            ZipInputStream zipInputStream3 = zipInputStream2;
                            File file = new File(fileT, "package.json");
                            if (!file.exists()) {
                                throw new FileNotFoundException("package.json not found");
                            }
                            FileInputStream fileInputStream = new FileInputStream(file);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            b.w(fileInputStream, byteArrayOutputStream);
                            JSONObject jSONObject2 = new JSONObject(new String(byteArrayOutputStream.toByteArray()));
                            byteArrayOutputStream.close();
                            fileInputStream.close();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("web_name", jSONObject.optString("name"));
                            contentValues.put("web_id", string);
                            contentValues.put("version", Integer.valueOf(i2));
                            contentValues.put("package_info", jSONObject2.getJSONArray("info").toString());
                            contentValues.put("icon", jSONObject.optString("icon"));
                            contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                            contentValues.put("description", jSONObject.optString("description"));
                            contentValues.put("type", Integer.valueOf(this.c));
                            contentValues.put(DeviceInfoUtil.UID_TAG, "0");
                            int iOptInt = jSONObject2.optInt("transparent", 0);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("transparent", iOptInt);
                            if (jSONObject.has("hybrid")) {
                                jSONObject3.put("hybrid", jSONObject.optInt("hybrid"));
                            }
                            contentValues.put(BaseConstants.EVENT_LABEL_EXTRA, jSONObject3.toString());
                            ContentResolver contentResolver = com.zenmen.palmchat.c.b().getContentResolver();
                            Uri uri = hq3.f18029a;
                            Cursor cursorQuery = contentResolver.query(uri, null, "web_id=?", new String[]{string}, null);
                            if (cursorQuery != null) {
                                z = cursorQuery.getCount() > 0;
                                cursorQuery.close();
                            }
                            if (z) {
                                com.zenmen.palmchat.c.b().getContentResolver().update(uri, contentValues, "web_id=?", new String[]{string});
                            } else {
                                com.zenmen.palmchat.c.b().getContentResolver().insert(uri, contentValues);
                            }
                            a(string);
                            pu1.u(fileOutputStream5);
                            pu1.u(bufferedInputStream2);
                            pu1.u(bufferedInputStream);
                            pu1.u(zipInputStream3);
                            httpURLConnection2.disconnect();
                            return;
                        }
                        String name = nextEntry.getName();
                        if (name != null && name.contains("../")) {
                            break;
                        }
                        if (nextEntry.isDirectory()) {
                            fileOutputStream4 = fileOutputStream;
                            zipInputStream = zipInputStream2;
                            File file2 = new File(fileT, nextEntry.getName());
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                        } else {
                            zipInputStream = zipInputStream2;
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(fileT, nextEntry.getName())));
                                fileOutputStream4 = fileOutputStream;
                                while (true) {
                                    try {
                                        int i4 = bufferedInputStream.read(bArr2, 0, 512);
                                        if (i4 == -1) {
                                            break;
                                        } else {
                                            bufferedOutputStream.write(bArr2, 0, i4);
                                        }
                                    } catch (IOException e18) {
                                        e = e18;
                                    } catch (JSONException e19) {
                                        e = e19;
                                        throw e;
                                    } catch (Throwable th12) {
                                        th = th12;
                                        fileOutputStream = fileOutputStream4;
                                    }
                                }
                                bufferedOutputStream.close();
                            } catch (IOException e20) {
                                e = e20;
                            } catch (JSONException e21) {
                                e = e21;
                            } catch (Throwable th13) {
                                th = th13;
                                th = th;
                            }
                        }
                        zipInputStream2 = zipInputStream;
                        fileOutputStream = fileOutputStream4;
                        throw e;
                    }
                } catch (IOException e22) {
                    throw e22;
                } catch (JSONException e23) {
                    throw e23;
                } catch (Throwable th14) {
                    zipInputStream = zipInputStream2;
                    th = th14;
                    bufferedInputStream = null;
                }
            } catch (IOException e24) {
                e = e24;
            } catch (JSONException e25) {
                e = e25;
                throw e;
            } catch (Throwable th15) {
                th = th15;
                fileOutputStream = fileOutputStream3;
                bufferedInputStream = null;
                zipInputStream = null;
            }
            throw e;
        }

        public final void d(JSONObject jSONObject) throws JSONException {
            boolean z;
            String string = jSONObject.getString("appId");
            ContentResolver contentResolver = com.zenmen.palmchat.c.b().getContentResolver();
            Uri uri = hq3.f18029a;
            Cursor cursorQuery = contentResolver.query(uri, null, "web_id=?", new String[]{string}, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToNext()) {
                    JSONObject jSONObject2 = new JSONObject(cursorQuery.getString(cursorQuery.getColumnIndex(BaseConstants.EVENT_LABEL_EXTRA)));
                    if (jSONObject.has("hybrid")) {
                        jSONObject2.put("hybrid", jSONObject.getInt("hybrid"));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(BaseConstants.EVENT_LABEL_EXTRA, jSONObject2.toString());
                        com.zenmen.palmchat.c.b().getContentResolver().update(uri, contentValues, "web_id=?", new String[]{string});
                    }
                }
                cursorQuery.close();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
        
            if (r4 >= r9) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
        
            com.zenmen.palmchat.utils.log.LogUtil.i(com.zenmen.palmchat.webplatform.b.i, com.zenmen.palmchat.utils.log.LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new com.zenmen.palmchat.webplatform.b.c.a(r11, r5), (java.lang.Throwable) null);
            b(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
        
            r4 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
        
            if (r4 != r9) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
        
            com.zenmen.palmchat.utils.log.LogUtil.i(com.zenmen.palmchat.webplatform.b.i, com.zenmen.palmchat.utils.log.LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new com.zenmen.palmchat.webplatform.b.c.C1137b(r11, r5), (java.lang.Throwable) null);
            d(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
        
            r4.printStackTrace();
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            if (this.f15924a == null || this.b == null) {
                return;
            }
            for (int i = 0; i < this.f15924a.length(); i++) {
                try {
                    JSONObject jSONObject = this.f15924a.getJSONObject(i);
                    String string = jSONObject.getString("appId");
                    int i2 = jSONObject.getInt("version");
                    int i3 = 0;
                    while (true) {
                        if (i3 < this.b.length()) {
                            JSONObject jSONObject2 = this.b.getJSONObject(i3);
                            String string2 = jSONObject2.getString("appId");
                            int i4 = jSONObject2.getInt("version");
                            if (string.equals(string2)) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        boolean canUpdateWhenNotBuiltIn();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15930a;

        public e(String str, a.b bVar) {
            this.f15930a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentResolver contentResolver = com.zenmen.palmchat.c.b().getContentResolver();
            Uri uri = hq3.f18029a;
            Cursor cursorQuery = contentResolver.query(uri, null, "web_id=?", new String[]{this.f15930a}, null);
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 1) {
                    com.zenmen.palmchat.c.b().getContentResolver().delete(uri, "web_id=? and uid=?", new String[]{this.f15930a, v4.e(com.zenmen.palmchat.c.b())});
                } else if (cursorQuery.moveToFirst()) {
                    if (b.j(this.f15930a, cursorQuery.getInt(cursorQuery.getColumnIndex("version")))) {
                        com.zenmen.palmchat.c.b().getContentResolver().delete(uri, "web_id=?", new String[]{this.f15930a});
                    } else {
                        com.zenmen.palmchat.c.b().getContentResolver().delete(uri, "web_id=?", new String[]{this.f15930a});
                    }
                }
                cursorQuery.close();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g implements Runnable {
        public g() {
        }

        /* JADX WARN: Removed duplicated region for block: B:194:0x0376 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:198:0x036b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:200:0x03ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:206:0x0381 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:208:0x03c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:216:0x03b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:225:0x03cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:229:0x038c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:258:0x0395 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:262:? A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws Throwable {
            String[] list;
            String[] strArr;
            int i;
            Throwable th;
            FileInputStream fileInputStream;
            String str;
            int i2;
            String str2;
            String str3;
            String str4;
            String str5;
            FileInputStream fileInputStream2;
            FileOutputStream fileOutputStream;
            ByteArrayOutputStream byteArrayOutputStream;
            ByteArrayOutputStream byteArrayOutputStream2;
            FileInputStream fileInputStream3;
            int iOptInt;
            String strOptString;
            String str6;
            String str7;
            int i3;
            boolean z;
            int i4;
            ContentValues contentValues;
            JSONObject jSONObject;
            FileOutputStream fileOutputStream2;
            String str8 = "background";
            String str9 = "transparent";
            String str10 = "type";
            String str11 = RedPacketPullNewPlugin.ACTION_SCREENSHOT;
            String str12 = TECameraSettings.SCENE_MODE_LANDSCAPE;
            String str13 = "webgl";
            try {
                list = com.zenmen.palmchat.c.b().getAssets().list("web_modules");
            } catch (IOException e) {
                e.printStackTrace();
                list = null;
            }
            if (list != null) {
                int length = list.length;
                int i5 = 0;
                while (i5 < length) {
                    String str14 = list[i5];
                    if (str14.contains(".zip")) {
                        String strReplace = str14.replace(".zip", "");
                        File fileU = b.u(strReplace, -1);
                        String path = fileU.getPath();
                        boolean zExists = fileU.exists();
                        if (!zExists) {
                            b.x(str14, fileU);
                        }
                        String str15 = b.i;
                        StringBuilder sb = new StringBuilder();
                        strArr = list;
                        sb.append("loadTask moduleName= ");
                        sb.append(strReplace);
                        i = length;
                        sb.append(" initDir exist =");
                        sb.append(zExists);
                        LogUtil.i(str15, sb.toString());
                        try {
                            try {
                                fileInputStream3 = new FileInputStream(new File(path, "package.json"));
                            } catch (Exception e2) {
                                e = e2;
                                str = str12;
                                i2 = i5;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = null;
                        }
                        try {
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                        } catch (Exception e3) {
                            e = e3;
                            str = str12;
                            i2 = i5;
                            str2 = str8;
                            String str16 = str11;
                            str3 = str9;
                            str4 = str13;
                            str5 = str16;
                            fileInputStream = null;
                            fileOutputStream = null;
                            byteArrayOutputStream2 = null;
                            try {
                                LogUtil.i(b.i, "loadtask exception", e);
                                e.printStackTrace();
                                if (fileInputStream3 != null) {
                                }
                                if (byteArrayOutputStream2 != null) {
                                }
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream == null) {
                                }
                                i5 = i2 + 1;
                                str8 = str2;
                                str12 = str;
                                list = strArr;
                                length = i;
                                String str17 = str5;
                                str13 = str4;
                                str9 = str3;
                                str11 = str17;
                            } catch (Throwable th3) {
                                th = th3;
                                fileInputStream2 = fileInputStream3;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    throw th;
                                }
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileInputStream2 = fileInputStream3;
                            fileInputStream = null;
                            fileOutputStream = null;
                            byteArrayOutputStream = null;
                            if (fileInputStream2 != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                        }
                        try {
                            b.w(fileInputStream3, byteArrayOutputStream2);
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            byteArrayOutputStream2.close();
                            fileInputStream3.close();
                            JSONObject jSONObject2 = new JSONObject(new String(byteArray));
                            String string = jSONObject2.getString("name");
                            String string2 = jSONObject2.getString("id");
                            i2 = i5;
                            try {
                                int iOptInt2 = jSONObject2.optInt("version", 0);
                                String str18 = path;
                                JSONArray jSONArray = jSONObject2.getJSONArray("info");
                                int iOptInt3 = jSONObject2.optInt(str13, 0);
                                String str19 = str13;
                                try {
                                    int iOptInt4 = jSONObject2.optInt(str12, 0);
                                    String str20 = str12;
                                    try {
                                        int iOptInt5 = jSONObject2.optInt(str11, 0);
                                        String str21 = str11;
                                        try {
                                            int iOptInt6 = jSONObject2.optInt("game", 0);
                                            int iOptInt7 = jSONObject2.optInt(str10, 0);
                                            String str22 = str10;
                                            try {
                                                iOptInt = jSONObject2.optInt(str9, 0);
                                                strOptString = jSONObject2.optString(str8);
                                                File fileT = b.t(string2, iOptInt2);
                                                str6 = str8;
                                                try {
                                                    Cursor cursorQuery = com.zenmen.palmchat.c.b().getContentResolver().query(hq3.f18029a, new String[]{"version"}, "web_id=?", new String[]{string2}, null);
                                                    if (cursorQuery != null) {
                                                        try {
                                                            if (cursorQuery.moveToFirst()) {
                                                                str7 = str9;
                                                                try {
                                                                    i3 = cursorQuery.getInt(0);
                                                                    if (iOptInt2 <= i3) {
                                                                        cursorQuery.close();
                                                                        str3 = str7;
                                                                        str4 = str19;
                                                                        str = str20;
                                                                        str5 = str21;
                                                                        str10 = str22;
                                                                        str2 = str6;
                                                                    } else {
                                                                        z = true;
                                                                    }
                                                                } catch (Exception e8) {
                                                                    e = e8;
                                                                    str3 = str7;
                                                                    str4 = str19;
                                                                    str = str20;
                                                                    str5 = str21;
                                                                    str10 = str22;
                                                                    str2 = str6;
                                                                    fileInputStream = null;
                                                                    fileOutputStream = null;
                                                                    fileInputStream3 = null;
                                                                    byteArrayOutputStream2 = null;
                                                                    LogUtil.i(b.i, "loadtask exception", e);
                                                                    e.printStackTrace();
                                                                    if (fileInputStream3 != null) {
                                                                    }
                                                                    if (byteArrayOutputStream2 != null) {
                                                                    }
                                                                    if (fileInputStream != null) {
                                                                    }
                                                                    if (fileOutputStream == null) {
                                                                    }
                                                                    i5 = i2 + 1;
                                                                    str8 = str2;
                                                                    str12 = str;
                                                                    list = strArr;
                                                                    length = i;
                                                                    String str172 = str5;
                                                                    str13 = str4;
                                                                    str9 = str3;
                                                                    str11 = str172;
                                                                }
                                                            } else {
                                                                str7 = str9;
                                                                i3 = 0;
                                                                z = false;
                                                            }
                                                            cursorQuery.close();
                                                        } catch (Exception e9) {
                                                            e = e9;
                                                            str7 = str9;
                                                        }
                                                    } else {
                                                        str7 = str9;
                                                        i3 = 0;
                                                        z = false;
                                                    }
                                                    String str23 = " failed";
                                                    i4 = i3;
                                                    String str24 = "mkdirs ";
                                                    if (!fileT.exists() && !fileT.mkdirs()) {
                                                        throw new IOException("mkdirs " + fileT.getAbsolutePath() + " failed");
                                                    }
                                                    LogUtil.i(str15, "loadTask moduleName= " + strReplace + " start copy");
                                                    int i6 = 0;
                                                    while (i6 < jSONArray.length()) {
                                                        JSONArray jSONArray2 = jSONArray;
                                                        String string3 = jSONArray2.getJSONObject(i6).getString("file");
                                                        File file = new File(fileT, string3);
                                                        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                                                            throw new IOException(str24 + file.getParentFile().getAbsolutePath() + str23);
                                                        }
                                                        String str25 = str23;
                                                        String str26 = str24;
                                                        File file2 = fileT;
                                                        String str27 = str18;
                                                        fileInputStream = new FileInputStream(new File(str27, string3));
                                                        try {
                                                            fileOutputStream2 = new FileOutputStream(file);
                                                        } catch (Exception e10) {
                                                            e = e10;
                                                            str3 = str7;
                                                            str4 = str19;
                                                            str = str20;
                                                            str5 = str21;
                                                            str10 = str22;
                                                            str2 = str6;
                                                            fileOutputStream = null;
                                                            fileInputStream3 = null;
                                                            byteArrayOutputStream2 = null;
                                                            LogUtil.i(b.i, "loadtask exception", e);
                                                            e.printStackTrace();
                                                            if (fileInputStream3 != null) {
                                                            }
                                                            if (byteArrayOutputStream2 != null) {
                                                            }
                                                            if (fileInputStream != null) {
                                                            }
                                                            if (fileOutputStream == null) {
                                                            }
                                                            i5 = i2 + 1;
                                                            str8 = str2;
                                                            str12 = str;
                                                            list = strArr;
                                                            length = i;
                                                            String str1722 = str5;
                                                            str13 = str4;
                                                            str9 = str3;
                                                            str11 = str1722;
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            fileInputStream2 = null;
                                                            fileOutputStream = null;
                                                            byteArrayOutputStream = null;
                                                            if (fileInputStream2 != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            if (fileInputStream != null) {
                                                            }
                                                            if (fileOutputStream != null) {
                                                            }
                                                        }
                                                        try {
                                                            b.h(fileInputStream, fileOutputStream2);
                                                            fileOutputStream2.close();
                                                            fileInputStream.close();
                                                            i6++;
                                                            str18 = str27;
                                                            str23 = str25;
                                                            str24 = str26;
                                                            fileT = file2;
                                                            jSONArray = jSONArray2;
                                                        } catch (Exception e11) {
                                                            e = e11;
                                                            fileOutputStream = fileOutputStream2;
                                                            str3 = str7;
                                                            str4 = str19;
                                                            str = str20;
                                                            str5 = str21;
                                                            str10 = str22;
                                                            str2 = str6;
                                                            fileInputStream3 = null;
                                                            byteArrayOutputStream2 = null;
                                                            LogUtil.i(b.i, "loadtask exception", e);
                                                            e.printStackTrace();
                                                            if (fileInputStream3 != null) {
                                                            }
                                                            if (byteArrayOutputStream2 != null) {
                                                            }
                                                            if (fileInputStream != null) {
                                                            }
                                                            if (fileOutputStream == null) {
                                                            }
                                                            i5 = i2 + 1;
                                                            str8 = str2;
                                                            str12 = str;
                                                            list = strArr;
                                                            length = i;
                                                            String str17222 = str5;
                                                            str13 = str4;
                                                            str9 = str3;
                                                            str11 = str17222;
                                                        } catch (Throwable th6) {
                                                            fileOutputStream = fileOutputStream2;
                                                            fileInputStream2 = null;
                                                            byteArrayOutputStream = null;
                                                            th = th6;
                                                            if (fileInputStream2 != null) {
                                                            }
                                                            if (byteArrayOutputStream != null) {
                                                            }
                                                            if (fileInputStream != null) {
                                                            }
                                                            if (fileOutputStream != null) {
                                                            }
                                                        }
                                                    }
                                                    JSONArray jSONArray3 = jSONArray;
                                                    contentValues = new ContentValues();
                                                    contentValues.put("web_name", string);
                                                    contentValues.put("web_id", string2);
                                                    contentValues.put("version", Integer.valueOf(iOptInt2));
                                                    contentValues.put("package_info", jSONArray3.toString());
                                                    contentValues.put(DeviceInfoUtil.UID_TAG, "0");
                                                    contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                                                    jSONObject = new JSONObject();
                                                    str4 = str19;
                                                    try {
                                                        jSONObject.put(str4, iOptInt3);
                                                        str = str20;
                                                    } catch (Exception e12) {
                                                        e = e12;
                                                        str3 = str7;
                                                        str = str20;
                                                        str5 = str21;
                                                        str10 = str22;
                                                        str2 = str6;
                                                        fileInputStream = null;
                                                        fileOutputStream = null;
                                                        fileInputStream3 = null;
                                                        byteArrayOutputStream2 = null;
                                                        LogUtil.i(b.i, "loadtask exception", e);
                                                        e.printStackTrace();
                                                        if (fileInputStream3 != null) {
                                                            try {
                                                                fileInputStream3.close();
                                                            } catch (IOException e13) {
                                                                e13.printStackTrace();
                                                            }
                                                        }
                                                        if (byteArrayOutputStream2 != null) {
                                                            try {
                                                                byteArrayOutputStream2.close();
                                                            } catch (IOException e14) {
                                                                e14.printStackTrace();
                                                            }
                                                        }
                                                        if (fileInputStream != null) {
                                                            try {
                                                                fileInputStream.close();
                                                            } catch (IOException e15) {
                                                                e15.printStackTrace();
                                                            }
                                                        }
                                                        if (fileOutputStream == null) {
                                                            try {
                                                                fileOutputStream.close();
                                                            } catch (IOException e16) {
                                                                e16.printStackTrace();
                                                            }
                                                        }
                                                        i5 = i2 + 1;
                                                        str8 = str2;
                                                        str12 = str;
                                                        list = strArr;
                                                        length = i;
                                                        String str172222 = str5;
                                                        str13 = str4;
                                                        str9 = str3;
                                                        str11 = str172222;
                                                    }
                                                    try {
                                                        jSONObject.put(str, iOptInt4);
                                                        str5 = str21;
                                                        try {
                                                            jSONObject.put(str5, iOptInt5);
                                                            jSONObject.put("game", iOptInt6);
                                                            str3 = str7;
                                                        } catch (Exception e17) {
                                                            e = e17;
                                                            str3 = str7;
                                                        }
                                                    } catch (Exception e18) {
                                                        e = e18;
                                                        str3 = str7;
                                                        str5 = str21;
                                                        str10 = str22;
                                                        str2 = str6;
                                                        fileInputStream = null;
                                                        fileOutputStream = null;
                                                        fileInputStream3 = null;
                                                        byteArrayOutputStream2 = null;
                                                        LogUtil.i(b.i, "loadtask exception", e);
                                                        e.printStackTrace();
                                                        if (fileInputStream3 != null) {
                                                        }
                                                        if (byteArrayOutputStream2 != null) {
                                                        }
                                                        if (fileInputStream != null) {
                                                        }
                                                        if (fileOutputStream == null) {
                                                        }
                                                        i5 = i2 + 1;
                                                        str8 = str2;
                                                        str12 = str;
                                                        list = strArr;
                                                        length = i;
                                                        String str1722222 = str5;
                                                        str13 = str4;
                                                        str9 = str3;
                                                        str11 = str1722222;
                                                    }
                                                } catch (Exception e19) {
                                                    e = e19;
                                                    str3 = str9;
                                                }
                                            } catch (Exception e20) {
                                                e = e20;
                                                str2 = str8;
                                                str3 = str9;
                                                str4 = str19;
                                                str = str20;
                                                str5 = str21;
                                            }
                                            try {
                                                jSONObject.put(str3, iOptInt);
                                                str2 = str6;
                                            } catch (Exception e21) {
                                                e = e21;
                                                str10 = str22;
                                                str2 = str6;
                                                fileInputStream = null;
                                                fileOutputStream = null;
                                                fileInputStream3 = null;
                                                byteArrayOutputStream2 = null;
                                                LogUtil.i(b.i, "loadtask exception", e);
                                                e.printStackTrace();
                                                if (fileInputStream3 != null) {
                                                }
                                                if (byteArrayOutputStream2 != null) {
                                                }
                                                if (fileInputStream != null) {
                                                }
                                                if (fileOutputStream == null) {
                                                }
                                                i5 = i2 + 1;
                                                str8 = str2;
                                                str12 = str;
                                                list = strArr;
                                                length = i;
                                                String str17222222 = str5;
                                                str13 = str4;
                                                str9 = str3;
                                                str11 = str17222222;
                                            }
                                            try {
                                                jSONObject.put(str2, strOptString);
                                                contentValues.put(BaseConstants.EVENT_LABEL_EXTRA, jSONObject.toString());
                                                str10 = str22;
                                                try {
                                                    contentValues.put(str10, Integer.valueOf(iOptInt7));
                                                    if (z) {
                                                        com.zenmen.palmchat.c.b().getContentResolver().update(hq3.f18029a, contentValues, "web_id=?", new String[]{string2});
                                                        b.j(string2, i4);
                                                    } else {
                                                        com.zenmen.palmchat.c.b().getContentResolver().insert(hq3.f18029a, contentValues);
                                                    }
                                                } catch (Exception e22) {
                                                    e = e22;
                                                    fileInputStream = null;
                                                    fileOutputStream = null;
                                                    fileInputStream3 = null;
                                                    byteArrayOutputStream2 = null;
                                                    LogUtil.i(b.i, "loadtask exception", e);
                                                    e.printStackTrace();
                                                    if (fileInputStream3 != null) {
                                                    }
                                                    if (byteArrayOutputStream2 != null) {
                                                    }
                                                    if (fileInputStream != null) {
                                                    }
                                                    if (fileOutputStream == null) {
                                                    }
                                                }
                                            } catch (Exception e23) {
                                                e = e23;
                                                str10 = str22;
                                                fileInputStream = null;
                                                fileOutputStream = null;
                                                fileInputStream3 = null;
                                                byteArrayOutputStream2 = null;
                                                LogUtil.i(b.i, "loadtask exception", e);
                                                e.printStackTrace();
                                                if (fileInputStream3 != null) {
                                                }
                                                if (byteArrayOutputStream2 != null) {
                                                }
                                                if (fileInputStream != null) {
                                                }
                                                if (fileOutputStream == null) {
                                                }
                                                i5 = i2 + 1;
                                                str8 = str2;
                                                str12 = str;
                                                list = strArr;
                                                length = i;
                                                String str172222222 = str5;
                                                str13 = str4;
                                                str9 = str3;
                                                str11 = str172222222;
                                            }
                                        } catch (Exception e24) {
                                            e = e24;
                                            str2 = str8;
                                            str3 = str9;
                                            str4 = str19;
                                            str = str20;
                                            str5 = str21;
                                        }
                                    } catch (Exception e25) {
                                        e = e25;
                                        str2 = str8;
                                        str5 = str11;
                                        str = str20;
                                        str3 = str9;
                                        str4 = str19;
                                        fileInputStream = null;
                                        fileOutputStream = null;
                                        fileInputStream3 = null;
                                        byteArrayOutputStream2 = null;
                                        LogUtil.i(b.i, "loadtask exception", e);
                                        e.printStackTrace();
                                        if (fileInputStream3 != null) {
                                        }
                                        if (byteArrayOutputStream2 != null) {
                                        }
                                        if (fileInputStream != null) {
                                        }
                                        if (fileOutputStream == null) {
                                        }
                                        i5 = i2 + 1;
                                        str8 = str2;
                                        str12 = str;
                                        list = strArr;
                                        length = i;
                                        String str1722222222 = str5;
                                        str13 = str4;
                                        str9 = str3;
                                        str11 = str1722222222;
                                    }
                                } catch (Exception e26) {
                                    e = e26;
                                    str5 = str11;
                                    str = str12;
                                    str2 = str8;
                                }
                            } catch (Exception e27) {
                                e = e27;
                                str = str12;
                                str2 = str8;
                                String str28 = str11;
                                str3 = str9;
                                str4 = str13;
                                str5 = str28;
                                fileInputStream = null;
                                fileOutputStream = null;
                                fileInputStream3 = null;
                                byteArrayOutputStream2 = null;
                                LogUtil.i(b.i, "loadtask exception", e);
                                e.printStackTrace();
                                if (fileInputStream3 != null) {
                                }
                                if (byteArrayOutputStream2 != null) {
                                }
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream == null) {
                                }
                                i5 = i2 + 1;
                                str8 = str2;
                                str12 = str;
                                list = strArr;
                                length = i;
                                String str17222222222 = str5;
                                str13 = str4;
                                str9 = str3;
                                str11 = str17222222222;
                            }
                        } catch (Exception e28) {
                            e = e28;
                            str = str12;
                            i2 = i5;
                            str2 = str8;
                            String str29 = str11;
                            str3 = str9;
                            str4 = str13;
                            str5 = str29;
                            fileInputStream = null;
                            fileOutputStream = null;
                            LogUtil.i(b.i, "loadtask exception", e);
                            e.printStackTrace();
                            if (fileInputStream3 != null) {
                            }
                            if (byteArrayOutputStream2 != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream == null) {
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            fileInputStream2 = fileInputStream3;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            fileInputStream = null;
                            fileOutputStream = null;
                        }
                    } else {
                        str = str12;
                        strArr = list;
                        i = length;
                        i2 = i5;
                        str2 = str8;
                        String str30 = str11;
                        str3 = str9;
                        str4 = str13;
                        str5 = str30;
                    }
                    i5 = i2 + 1;
                    str8 = str2;
                    str12 = str;
                    list = strArr;
                    length = i;
                    String str172222222222 = str5;
                    str13 = str4;
                    str9 = str3;
                    str11 = str172222222222;
                }
                b.n().o(com.zenmen.palmchat.c.b());
                b.n().p(com.zenmen.palmchat.c.b());
            }
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExecutorService f15933a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends yw4 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JSONObject f15934a;

            public a(JSONObject jSONObject) {
                this.f15934a = jSONObject;
            }

            @Override // defpackage.yw4
            public void onFail(Exception exc) {
                exc.printStackTrace();
                LogUtil.d(b.i, "sync miniapp:" + exc.toString());
            }

            @Override // defpackage.yw4
            public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
                JSONObject jSONObjectOptJSONObject;
                LogUtil.d(b.i, "sync miniapp:" + yy2Var.toString());
                if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
                    return;
                }
                h.this.f15933a.submit(new c(this.f15934a.optJSONArray("pkgs"), jSONObjectOptJSONObject.optJSONArray("pkgs"), 3));
            }
        }

        public h(ExecutorService executorService) {
            this.f15933a = executorService;
        }

        public final void b(JSONObject jSONObject) {
            LogUtil.d(b.i, "local miniapp:" + jSONObject.toString());
            zw4.i(com.zenmen.palmchat.webplatform.a.f + "?dhid=" + ac1.h, 1, jSONObject, new a(jSONObject), false);
        }

        @Override // java.lang.Runnable
        public void run() {
            Cursor cursorQuery = com.zenmen.palmchat.c.b().getContentResolver().query(hq3.f18029a, new String[]{"web_id", "version"}, "type=3", null, null);
            try {
                if (cursorQuery != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        while (cursorQuery.moveToNext()) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("appId", cursorQuery.getString(0));
                            jSONObject2.put("version", cursorQuery.getInt(1));
                            jSONArray.put(jSONObject2);
                        }
                        jSONObject.put("pkgs", jSONArray);
                        b(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                cursorQuery.close();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15935a;
        public a.e b;

        public i(String str, a.e eVar) {
            this.f15935a = str;
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Cursor cursorQuery = com.zenmen.palmchat.c.b().getContentResolver().query(hq3.f18029a, null, "web_id=?", new String[]{this.f15935a}, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToNext()) {
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("version"));
                    File fileT = b.t(this.f15935a, i);
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("package_info"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(BaseConstants.EVENT_LABEL_EXTRA));
                    try {
                        JSONArray jSONArray = new JSONArray(string);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            String string3 = jSONObject.getString("file");
                            String string4 = jSONObject.getString("md5");
                            File file = new File(fileT, string3);
                            String strB = rb3.b(file);
                            if (TextUtils.isEmpty(string4) || TextUtils.isEmpty(strB) || !strB.equals(string4)) {
                                throw new IOException(file.getAbsolutePath() + " md5 verify failed");
                            }
                        }
                        a.e eVar = this.b;
                        if (eVar != null) {
                            eVar.a(this.f15935a, i, string2);
                        }
                    } catch (Exception e) {
                        a.e eVar2 = this.b;
                        if (eVar2 != null) {
                            eVar2.a(this.f15935a, i, string2);
                        }
                        e.printStackTrace();
                    }
                } else {
                    a.e eVar3 = this.b;
                    if (eVar3 != null) {
                        eVar3.onFail(new Exception("package info not in database"));
                    }
                }
                cursorQuery.close();
            }
        }
    }

    public b() {
        StringBuilder sb = new StringBuilder();
        String str = i;
        sb.append(str);
        sb.append("Single");
        this.f15920a = vw5.d(sb.toString());
        this.b = vw5.d(str + "BulkUpdate");
        this.c = vw5.d(str + "AutoUpdate");
        this.d = vw5.a(str);
        this.e = Collections.synchronizedSet(new HashSet());
    }

    public static void h(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i2);
            }
        }
    }

    public static boolean j(String str, int i2) {
        File fileT = t(str, i2);
        if (!fileT.exists()) {
            return false;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList.push(fileT);
        while (linkedList.size() > 0) {
            File file = (File) linkedList.pop();
            linkedList2.push(file);
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    linkedList.push(file2);
                } else {
                    file2.delete();
                }
            }
        }
        while (linkedList2.size() > 0) {
            ((File) linkedList2.pop()).delete();
        }
        return true;
    }

    public static String m(String str, int i2) {
        File fileT = t(str, i2);
        File file = new File(fileT, "index.html");
        if (file.exists()) {
            return "file://" + file.getAbsolutePath();
        }
        File file2 = new File(fileT, "index.htm");
        if (!file2.exists()) {
            return null;
        }
        return "file://" + file2.getAbsolutePath();
    }

    public static b n() {
        if (j == null) {
            synchronized (b.class) {
                if (j == null) {
                    j = new b();
                }
            }
        }
        return j;
    }

    public static File t(String str, int i2) {
        return new File(new File(new File(com.zenmen.palmchat.c.b().getFilesDir(), "web_modules"), str), String.valueOf(i2));
    }

    public static File u(String str, int i2) {
        return new File(new File(new File(com.zenmen.palmchat.c.b().getFilesDir(), "web_modules_init"), str), String.valueOf(i2));
    }

    public static void w(InputStream inputStream, OutputStream outputStream) throws IOException {
        h(inputStream, outputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static void x(String str, File file) throws Throwable {
        InputStream inputStreamOpen;
        ZipInputStream zipInputStream;
        BufferedInputStream bufferedInputStream;
        ?? r0 = 0;
        bufferedInputStream = null;
        bufferedInputStream = null;
        r0 = 0;
        BufferedInputStream bufferedInputStream2 = null;
        r0 = 0;
        try {
            try {
                if (!file.exists()) {
                    file.mkdirs();
                }
                inputStreamOpen = com.zenmen.palmchat.c.b().getAssets().open("web_modules/" + str);
                try {
                    zipInputStream = new ZipInputStream(inputStreamOpen);
                    try {
                        bufferedInputStream = new BufferedInputStream(zipInputStream);
                    } catch (Exception e2) {
                        e = e2;
                    }
                    try {
                        byte[] bArr = new byte[512];
                        while (true) {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry == null) {
                                String str2 = "unzipFile success moduleZip =" + str;
                                LogUtil.i(i, str2);
                                pu1.u(bufferedInputStream);
                                r0 = str2;
                                break;
                            }
                            String name = nextEntry.getName();
                            if (name != null && name.contains("../")) {
                                throw new RuntimeException("find unsafe zip file");
                            }
                            if (name == null || !name.contains("DS_Store")) {
                                if (nextEntry.isDirectory()) {
                                    File file2 = new File(file, nextEntry.getName());
                                    if (!file2.exists()) {
                                        file2.mkdirs();
                                    }
                                } else {
                                    FileOutputStream fileOutputStream = new FileOutputStream(new File(file, nextEntry.getName()));
                                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                    while (true) {
                                        int i2 = bufferedInputStream.read(bArr, 0, 512);
                                        if (i2 == -1) {
                                            break;
                                        } else {
                                            bufferedOutputStream.write(bArr, 0, i2);
                                        }
                                    }
                                    bufferedOutputStream.close();
                                    fileOutputStream.close();
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        bufferedInputStream2 = bufferedInputStream;
                        e.printStackTrace();
                        LogUtil.i(i, "unzipFile exception moduleZip =" + str, e);
                        pu1.u(bufferedInputStream2);
                        r0 = bufferedInputStream2;
                        pu1.u(zipInputStream);
                        pu1.u(inputStreamOpen);
                    } catch (Throwable th) {
                        th = th;
                        r0 = bufferedInputStream;
                        pu1.u(r0);
                        pu1.u(zipInputStream);
                        pu1.u(inputStreamOpen);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    zipInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    zipInputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e5) {
            e = e5;
            inputStreamOpen = null;
            zipInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            inputStreamOpen = null;
            zipInputStream = null;
        }
    }

    public void e(String str, JSONArray jSONArray) {
        SharedPreferences sharedPreferences = com.zenmen.palmchat.c.b().getSharedPreferences("mini_programs_pref", 0);
        String str2 = str + "_default_apps_installed";
        if (sharedPreferences.getBoolean(str2, false) || TextUtils.isEmpty(str) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(str2, true);
        editorEdit.apply();
        ContentValues[] contentValuesArr = new ContentValues[jSONArray.length()];
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                ContentValues contentValues = new ContentValues();
                contentValues.put("web_id", jSONObject.getString("appId"));
                contentValues.put("web_name", jSONObject.getString("name"));
                contentValues.put("icon", jSONObject.getString("icon"));
                contentValues.put("version", (Integer) 0);
                contentValues.put(DeviceInfoUtil.UID_TAG, str);
                contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                contentValuesArr[i2] = contentValues;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        com.zenmen.palmchat.c.b().getContentResolver().bulkInsert(hq3.f18029a, contentValuesArr);
    }

    public void f(String str) {
        this.e.add(str);
    }

    public void g(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.c.execute(new RunnableC1136b(strArr, this.h));
    }

    public void i(String str, a.b bVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f15920a.submit(new e(str, bVar));
        } else if (bVar != null) {
            bVar.onFail(new IllegalArgumentException("pkgId is empty"));
        }
    }

    public void k(Package r3, a.c cVar) {
        if (r3 != null) {
            this.f15920a.submit(new f(r3, cVar));
        } else if (cVar != null) {
            cVar.onFail(new IllegalArgumentException("pkgInfo is null"));
        }
    }

    public void l(String str, a.c cVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f15920a.submit(new f(str, cVar));
        } else if (cVar != null) {
            cVar.onFail(new IllegalArgumentException("pkgId is null"));
        }
    }

    public String o(Context context) {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.g = q(context, "jssdk_legacy");
                }
            }
        }
        return this.g;
    }

    public String p(Context context) {
        if (this.f == null) {
            synchronized (this) {
                if (this.f == null) {
                    this.f = q(context, "jssdk");
                }
            }
        }
        return this.f;
    }

    public final String q(Context context, String str) {
        Cursor cursorQuery = context.getContentResolver().query(hq3.f18029a, new String[]{"version"}, "web_id=?", new String[]{str}, null);
        String absolutePath = null;
        if (cursorQuery != null) {
            if (cursorQuery.moveToFirst()) {
                File fileT = t(str, cursorQuery.getInt(0));
                if (fileT.exists()) {
                    absolutePath = fileT.getAbsolutePath();
                } else {
                    LogUtil.log4ClientError("shouldInterceptRequest_error", null, null, true);
                }
            }
            cursorQuery.close();
        }
        if (TextUtils.isEmpty(absolutePath)) {
            absolutePath = u(str, -1).getAbsolutePath();
        }
        LogUtil.i(i, "getSDKPathImp pkgId" + str + " result = " + absolutePath);
        return absolutePath;
    }

    public void r(d dVar) {
        this.h = dVar;
        this.f15920a.submit(new g(null));
    }

    public boolean s(String str) {
        return this.e.contains(str);
    }

    public void v() {
        this.f15920a.submit(new h(this.b));
    }

    public void y(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f15920a.submit(new a(str, str2));
    }

    public void z(String str, a.e eVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f15920a.submit(new i(str, eVar));
        } else if (eVar != null) {
            eVar.onFail(new IllegalArgumentException("pkgId is empty"));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Package f15931a;
        public String b;
        public a.c c;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15932a;

            public a(String str) {
                this.f15932a = str;
                put("action", "web_module_download");
                put("status", "fail");
                put("detail", "url=" + str);
            }
        }

        public f(Package r1, a.c cVar) {
            this.f15931a = r1;
            this.c = cVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x0266, code lost:
        
            com.zenmen.palmchat.c.b().getContentResolver().update(r2, r7, "web_id=?", new java.lang.String[]{r25.f15931a.pkgId});
         */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x027e, code lost:
        
            r7.put(com.wifi.ad.core.config.DeviceInfoUtil.UID_TAG, defpackage.v4.e(com.zenmen.palmchat.c.b()));
            com.zenmen.palmchat.c.b().getContentResolver().insert(r2, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x0296, code lost:
        
            r3 = r25.f15931a;
            r2 = new android.util.Pair<>(r3.pkgId, java.lang.Integer.valueOf(r3.version));
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x02a5, code lost:
        
            defpackage.pu1.u(r13);
            defpackage.pu1.u(r12);
            defpackage.pu1.u(r10);
            defpackage.pu1.u(r18);
            r17.disconnect();
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x02b4, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x02be, code lost:
        
            throw new java.io.FileNotFoundException("package.json not found");
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x02bf, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x02c1, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x02c3, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x02c5, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x02c7, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:118:0x02c9, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x02d0, code lost:
        
            r16 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x02d2, code lost:
        
            r2 = r0;
            r16 = r16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x02dc, code lost:
        
            r2 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x02e8, code lost:
        
            r2 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00f3, code lost:
        
            throw new java.lang.RuntimeException("find unsafe zip file");
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0170, code lost:
        
            r18 = r7;
            r17 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0174, code lost:
        
            r7 = new java.io.File(r11, "package.json");
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x017f, code lost:
        
            if (r7.exists() == false) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0181, code lost:
        
            r8 = new java.io.FileInputStream(r7);
            r7 = new java.io.ByteArrayOutputStream();
            com.zenmen.palmchat.webplatform.b.w(r8, r7);
            r9 = new org.json.JSONObject(new java.lang.String(r7.toByteArray()));
            r7.close();
            r8.close();
            r7 = new android.content.ContentValues();
            r7.put("web_name", r25.f15931a.name);
            r7.put("web_id", r25.f15931a.pkgId);
            r7.put("version", java.lang.Integer.valueOf(r25.f15931a.version));
            r7.put("package_info", r9.getJSONArray("info").toString());
            r7.put("icon", r25.f15931a.icon);
            r7.put("timestamp", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            r7.put("description", r25.f15931a.description);
            r7.put("type", (java.lang.Integer) 1);
            r14 = r9.optInt("webgl", 0);
            r15 = r9.optInt(com.ss.android.ttvecamera.TECameraSettings.SCENE_MODE_LANDSCAPE, 0);
            r11 = r9.optInt(org.apache.cordova.jssdk.RedPacketPullNewPlugin.ACTION_SCREENSHOT, 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x020d, code lost:
        
            r10 = r9.optInt("game", 0);
            r8 = r9.optString("background");
            r9 = new org.json.JSONObject();
            r9.put("webgl", r14);
            r9.put(com.ss.android.ttvecamera.TECameraSettings.SCENE_MODE_LANDSCAPE, r15);
            r9.put(org.apache.cordova.jssdk.RedPacketPullNewPlugin.ACTION_SCREENSHOT, r11);
            r9.put("game", r10);
            r9.put("background", r8);
            r7.put(com.ss.android.download.api.constant.BaseConstants.EVENT_LABEL_EXTRA, r9.toString());
            r19 = com.zenmen.palmchat.c.b().getContentResolver();
            r2 = defpackage.hq3.f18029a;
            r3 = r19.query(r2, null, "web_id=?", new java.lang.String[]{r25.f15931a.pkgId}, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0254, code lost:
        
            if (r3 == null) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x025a, code lost:
        
            if (r3.getCount() <= 0) goto L96;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x025c, code lost:
        
            r9 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x025e, code lost:
        
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x025f, code lost:
        
            r3.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0263, code lost:
        
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0264, code lost:
        
            if (r9 == false) goto L101;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:194:0x03aa  */
        /* JADX WARN: Removed duplicated region for block: B:232:? A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r16v1 */
        /* JADX WARN: Type inference failed for: r16v10 */
        /* JADX WARN: Type inference failed for: r16v13 */
        /* JADX WARN: Type inference failed for: r16v14 */
        /* JADX WARN: Type inference failed for: r16v17, types: [java.util.zip.ZipEntry] */
        /* JADX WARN: Type inference failed for: r16v18 */
        /* JADX WARN: Type inference failed for: r16v19 */
        /* JADX WARN: Type inference failed for: r16v2, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r16v20 */
        /* JADX WARN: Type inference failed for: r16v7 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Pair<String, Integer> a(String str, Map<String, String> map) throws Throwable {
            Throwable th;
            FileOutputStream fileOutputStream;
            BufferedInputStream bufferedInputStream;
            boolean z;
            HttpURLConnection httpURLConnection;
            JSONException jSONException;
            IOException iOException;
            ZipInputStream zipInputStream;
            ?? r16;
            HttpURLConnection httpURLConnectionC;
            String absolutePath;
            int contentLength;
            FileOutputStream fileOutputStream2;
            byte[] bArr;
            int i;
            try {
                try {
                    httpURLConnectionC = new ResDownloadHttpDnsHelper().c(str, null, false);
                    try {
                        absolutePath = new File(com.zenmen.palmchat.c.b().getExternalCacheDir(), this.f15931a.pkgId + ".zip").getAbsolutePath();
                        contentLength = httpURLConnectionC.getContentLength();
                        bufferedInputStream = new BufferedInputStream(httpURLConnectionC.getInputStream(), 4096);
                    } catch (IOException e) {
                        iOException = e;
                        throw iOException;
                    } catch (JSONException e2) {
                        jSONException = e2;
                        throw jSONException;
                    } catch (Throwable th2) {
                        httpURLConnection = httpURLConnectionC;
                        th = th2;
                        fileOutputStream = null;
                        bufferedInputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = null;
                }
            } catch (IOException e3) {
                iOException = e3;
            } catch (JSONException e4) {
                jSONException = e4;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                bufferedInputStream = null;
                z = false;
                httpURLConnection = null;
            }
            try {
                fileOutputStream2 = new FileOutputStream(absolutePath);
                try {
                    bArr = new byte[2048];
                    i = 0;
                } catch (IOException e5) {
                    e = e5;
                } catch (JSONException e6) {
                    e = e6;
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection = httpURLConnectionC;
                }
            } catch (IOException e7) {
                iOException = e7;
            } catch (JSONException e8) {
                jSONException = e8;
                throw jSONException;
            } catch (Throwable th6) {
                httpURLConnection = httpURLConnectionC;
                th = th6;
                fileOutputStream = null;
            }
            while (true) {
                int i2 = bufferedInputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                i += i2;
                try {
                    fileOutputStream2.write(bArr, 0, i2);
                } catch (IOException e9) {
                    iOException = e9;
                } catch (JSONException e10) {
                    jSONException = e10;
                    throw jSONException;
                } catch (Throwable th7) {
                    th = th7;
                    httpURLConnection = httpURLConnectionC;
                    fileOutputStream = fileOutputStream2;
                    z = false;
                    zipInputStream = null;
                    r16 = z;
                    pu1.u(fileOutputStream);
                    pu1.u(bufferedInputStream);
                    pu1.u(r16);
                    pu1.u(zipInputStream);
                    if (httpURLConnection == null) {
                    }
                }
                iOException = e;
                throw iOException;
            }
            fileOutputStream2.flush();
            try {
                if (i != contentLength) {
                    throw new IOException(absolutePath + " download failed");
                }
                String strB = rb3.b(new File(absolutePath));
                if (TextUtils.isEmpty(strB) || !strB.equals(this.f15931a.md5)) {
                    throw new IOException("md5 dismatch");
                }
                ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(absolutePath));
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipInputStream2);
                    try {
                        Package r11 = this.f15931a;
                        File fileT = b.t(r11.pkgId, r11.version);
                        if (!fileT.exists()) {
                            try {
                                fileT.mkdirs();
                            } catch (IOException e11) {
                                throw e11;
                            } catch (JSONException e12) {
                                throw e12;
                            } catch (Throwable th8) {
                                th = th8;
                                zipInputStream = zipInputStream2;
                                httpURLConnection = httpURLConnectionC;
                                ?? r162 = bufferedInputStream2;
                                fileOutputStream = fileOutputStream2;
                                r16 = r162;
                                pu1.u(fileOutputStream);
                                pu1.u(bufferedInputStream);
                                pu1.u(r16);
                                pu1.u(zipInputStream);
                                if (httpURLConnection == null) {
                                }
                            }
                        }
                        byte[] bArr2 = new byte[512];
                        while (true) {
                            ?? nextEntry = zipInputStream2.getNextEntry();
                            if (nextEntry == 0) {
                                break;
                            }
                            try {
                                String name = nextEntry.getName();
                                if (name != null && name.contains("../")) {
                                    break;
                                }
                                if (nextEntry.isDirectory()) {
                                    zipInputStream = zipInputStream2;
                                    httpURLConnection = httpURLConnectionC;
                                    File file = new File(fileT, nextEntry.getName());
                                    if (!file.exists()) {
                                        file.mkdirs();
                                    }
                                } else {
                                    httpURLConnection = httpURLConnectionC;
                                    try {
                                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(fileT, nextEntry.getName())));
                                        zipInputStream = zipInputStream2;
                                        while (true) {
                                            try {
                                                int i3 = bufferedInputStream2.read(bArr2, 0, 512);
                                                if (i3 == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr2, 0, i3);
                                            } catch (IOException e13) {
                                                e = e13;
                                                IOException iOException2 = e;
                                                throw iOException2;
                                            } catch (JSONException e14) {
                                                e = e14;
                                                JSONException jSONException2 = e;
                                                throw jSONException2;
                                            } catch (Throwable th9) {
                                                th = th9;
                                                th = th;
                                                ?? r1622 = bufferedInputStream2;
                                                fileOutputStream = fileOutputStream2;
                                                r16 = r1622;
                                                pu1.u(fileOutputStream);
                                                pu1.u(bufferedInputStream);
                                                pu1.u(r16);
                                                pu1.u(zipInputStream);
                                                if (httpURLConnection == null) {
                                                }
                                            }
                                        }
                                        bufferedOutputStream.close();
                                    } catch (IOException e15) {
                                        e = e15;
                                    } catch (JSONException e16) {
                                        e = e16;
                                    } catch (Throwable th10) {
                                        th = th10;
                                        zipInputStream = zipInputStream2;
                                    }
                                }
                                httpURLConnectionC = httpURLConnection;
                                zipInputStream2 = zipInputStream;
                            } catch (IOException e17) {
                                e = e17;
                                httpURLConnection = httpURLConnectionC;
                            } catch (JSONException e18) {
                                e = e18;
                                httpURLConnection = httpURLConnectionC;
                            } catch (Throwable th11) {
                                th = th11;
                                zipInputStream = zipInputStream2;
                                httpURLConnection = httpURLConnectionC;
                            }
                        }
                    } catch (IOException e19) {
                        e = e19;
                        httpURLConnection = httpURLConnectionC;
                    } catch (JSONException e20) {
                        e = e20;
                        httpURLConnection = httpURLConnectionC;
                    } catch (Throwable th12) {
                        th = th12;
                        zipInputStream = zipInputStream2;
                        httpURLConnection = httpURLConnectionC;
                    }
                } catch (IOException e21) {
                    throw e21;
                } catch (JSONException e22) {
                    throw e22;
                } catch (Throwable th13) {
                    zipInputStream = zipInputStream2;
                    httpURLConnection = httpURLConnectionC;
                    th = th13;
                    fileOutputStream = fileOutputStream2;
                    r16 = 0;
                    pu1.u(fileOutputStream);
                    pu1.u(bufferedInputStream);
                    pu1.u(r16);
                    pu1.u(zipInputStream);
                    if (httpURLConnection == null) {
                    }
                }
            } catch (IOException e23) {
                e = e23;
            } catch (JSONException e24) {
                e = e24;
                jSONException = e;
                throw jSONException;
            } catch (Throwable th14) {
                th = th14;
                th = th;
                fileOutputStream = fileOutputStream2;
                z = false;
                zipInputStream = null;
                r16 = z;
                pu1.u(fileOutputStream);
                pu1.u(bufferedInputStream);
                pu1.u(r16);
                pu1.u(zipInputStream);
                if (httpURLConnection == null) {
                    throw th;
                }
                httpURLConnection.disconnect();
                throw th;
            }
            iOException = e;
            throw iOException;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            String strZ;
            try {
                strZ = k86.Z(com.zenmen.palmchat.webplatform.a.b);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                strZ = null;
            }
            if (strZ == null) {
                return;
            }
            if (this.f15931a == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appId", this.b);
                    jSONObject.put("version", 0);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("pkgs", jSONArray);
                    JSONObject jSONObjectL = zw4.l(com.zenmen.palmchat.webplatform.a.e, 1, jSONObject2);
                    if (jSONObjectL == null || jSONObjectL.getInt("resultCode") != 0) {
                        throw new Exception("sync failed");
                    }
                    JSONObject jSONObject3 = jSONObjectL.getJSONObject("data").getJSONArray("pkgs").getJSONObject(0);
                    Package r4 = new Package();
                    this.f15931a = r4;
                    r4.pkgId = this.b;
                    r4.name = jSONObject3.getString("name");
                    this.f15931a.md5 = jSONObject3.getString("md5");
                    this.f15931a.version = jSONObject3.getInt("version");
                    this.f15931a.description = jSONObject3.getString("description");
                    this.f15931a.icon = jSONObject3.getString("icon");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    a.c cVar = this.c;
                    if (cVar != null) {
                        cVar.onFail(e2);
                        return;
                    }
                    return;
                }
            }
            Uri.Builder builderBuildUpon = Uri.parse(strZ).buildUpon();
            builderBuildUpon.appendQueryParameter("appId", this.f15931a.pkgId);
            String string = builderBuildUpon.build().toString();
            Exception e3 = null;
            for (int i = 0; i < 2; i++) {
                try {
                    Pair<String, Integer> pairA = a(string, null);
                    a.c cVar2 = this.c;
                    if (cVar2 != null) {
                        cVar2.onSuccess((String) pairA.first, ((Integer) pairA.second).intValue());
                        return;
                    }
                    return;
                } catch (Exception e4) {
                    e3 = e4;
                    it0.k().s("all ip failed");
                    LogUtil.i(b.i, 3, new a(string), e3);
                }
            }
            a.c cVar3 = this.c;
            if (cVar3 != null) {
                cVar3.onFail(e3);
            }
        }

        public f(String str, a.c cVar) {
            this.b = str;
            this.c = cVar;
        }
    }
}
