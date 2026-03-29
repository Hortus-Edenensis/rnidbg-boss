package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.commonutils.b.c;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3977a = "c";
    private AsyncHttpClient b;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HttpClient.ProtoResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3978a;
        final /* synthetic */ String b;
        final /* synthetic */ InterfaceC0087c c;

        public a(Context context, String str, InterfaceC0087c interfaceC0087c) {
            this.f3978a = context;
            this.b = str;
            this.c = interfaceC0087c;
        }

        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        public void onFailed(HttpClient.HttpStateError httpStateError) {
            String strA = c.this.a(this.f3978a, this.b);
            if (!c.this.b(strA)) {
                strA = null;
            }
            InterfaceC0087c interfaceC0087c = this.c;
            if (interfaceC0087c != null) {
                interfaceC0087c.onCustomMapStyleLoadFailed(httpStateError.ordinal(), httpStateError.name(), strA);
            }
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap failed error = " + httpStateError.ordinal());
            }
        }

        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        public void onSuccess(String str) {
            c.this.a(this.f3978a, str, this.b, this.c);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap result = " + str);
            }
        }
    }

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.map.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0087c {
        void onCustomMapStyleLoadFailed(int i, String str, String str2);

        void onCustomMapStyleLoadSuccess(boolean z, String str);

        void onPreLoadLastCustomMapStyle(String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f3980a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    private c() {
        this.b = new AsyncHttpClient();
    }

    private void b(Context context, String str, String str2, InterfaceC0087c interfaceC0087c) {
        this.b.get(str, new a(context, str2, interfaceC0087c));
    }

    private String b(Context context, String str) {
        if (!b(a(context, str))) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray(a(context));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String strOptString = ((JSONObject) jSONArray.opt(i)).optString(str);
                if (!TextUtils.isEmpty(strOptString)) {
                    return strOptString;
                }
            }
            return "";
        } catch (JSONException unused) {
            return "";
        }
    }

    public static c a() {
        return d.f3980a;
    }

    public void a(Context context, String str, InterfaceC0087c interfaceC0087c) {
        a(context, str, true, interfaceC0087c);
    }

    private void a(Context context, String str, boolean z, InterfaceC0087c interfaceC0087c) {
        String strA = a(context, str);
        if (!b(strA)) {
            strA = null;
        }
        if (interfaceC0087c != null) {
            interfaceC0087c.onPreLoadLastCustomMapStyle(strA);
        }
        if (!NetworkUtil.isNetworkAvailable(context)) {
            if (interfaceC0087c != null) {
                HttpClient.HttpStateError httpStateError = HttpClient.HttpStateError.NETWORK_ERROR;
                interfaceC0087c.onCustomMapStyleLoadFailed(httpStateError.ordinal(), httpStateError.name(), strA);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA2 = a(context, str, z);
        if (TextUtils.isEmpty(strA2)) {
            Log.e(f3977a, "build request url failed");
        } else {
            b(context, strA2, str, interfaceC0087c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3979a;
        final /* synthetic */ String b;
        final /* synthetic */ InterfaceC0087c c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        public b(Context context, String str, InterfaceC0087c interfaceC0087c, String str2, String str3) {
            this.f3979a = context;
            this.b = str;
            this.c = interfaceC0087c;
            this.d = str2;
            this.e = str3;
        }

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.b.c.d
        public void a(File file) throws Throwable {
            boolean zA = c.this.a(this.f3979a, file, this.b);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap loadStyleFile success ret = " + zA);
            }
            if (zA) {
                c.this.a(this.f3979a, this.b, this.d);
                if (this.c != null) {
                    this.c.onCustomMapStyleLoadSuccess(true, c.this.b(this.e) ? this.e : null);
                    return;
                }
                return;
            }
            InterfaceC0087c interfaceC0087c = this.c;
            if (interfaceC0087c != null) {
                interfaceC0087c.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "UnZipStyleFile onFailed", null);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.b.c.d
        public void a() {
            InterfaceC0087c interfaceC0087c = this.c;
            if (interfaceC0087c != null) {
                interfaceC0087c.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "loadStyleFile onFailed", null);
            }
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap loadStyleFile failed");
            }
        }
    }

    private String a(Context context, String str, boolean z) {
        if (context == null) {
            return "";
        }
        String strB = b(context, str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MapBundleKey.MapObjKey.OBJ_STYLE_ID, str);
        if (z) {
            linkedHashMap.put("type", "publish");
        } else {
            linkedHashMap.put("type", "edit");
        }
        linkedHashMap.put("md5", strB);
        linkedHashMap.put("token", SyncSysInfo.getAuthToken());
        String str2 = a(linkedHashMap) + SyncSysInfo.getPhoneInfo();
        return a("api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/custom/v2/getjsonstyle") + Constants.STRING_VALUE_UNSET + (str2 + "&sign=" + AppMD5.getSignMD5String(str2));
    }

    private String a(Map<String, String> map) {
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : map.keySet()) {
            String strEncodeUrlParamsValue = AppMD5.encodeUrlParamsValue(map.get(str));
            if (i == 0) {
                sb.append(str);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(strEncodeUrlParamsValue);
            } else {
                sb.append(ContainerUtils.FIELD_DELIMITER);
                sb.append(str);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(strEncodeUrlParamsValue);
            }
            i++;
        }
        return sb.toString();
    }

    private String a(String str) {
        if (HttpClient.isHttpsEnable) {
            return "https://" + str;
        }
        return "http://" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, InterfaceC0087c interfaceC0087c) {
        String strA = a(context, str2);
        String str3 = b(strA) ? strA : null;
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0087c != null) {
                HttpClient.HttpStateError httpStateError = HttpClient.HttpStateError.SERVER_ERROR;
                interfaceC0087c.onCustomMapStyleLoadFailed(httpStateError.ordinal(), httpStateError.name(), str3);
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("status");
            String strOptString = jSONObject.optString("message");
            if (!a(iOptInt, strA)) {
                if (interfaceC0087c != null) {
                    interfaceC0087c.onCustomMapStyleLoadSuccess(false, str3);
                }
            } else {
                if (iOptInt != 0) {
                    if (interfaceC0087c != null) {
                        interfaceC0087c.onCustomMapStyleLoadFailed(iOptInt, strOptString, str3);
                        return;
                    }
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                    a(context, jSONObjectOptJSONObject.optString("pb_url", ""), str2, jSONObjectOptJSONObject.optString("md5", ""), interfaceC0087c);
                } else if (interfaceC0087c != null) {
                    interfaceC0087c.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.SERVER_ERROR.ordinal(), "custom style data is null", str3);
                }
            }
        } catch (JSONException unused) {
            if (interfaceC0087c != null) {
                interfaceC0087c.onCustomMapStyleLoadFailed(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "parse response result failed", str3);
            }
        }
    }

    private boolean a(int i, String str) {
        return (103 == i && b(str)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + "sc_sty_" + str + ".sty";
    }

    private void a(Context context, String str, String str2, String str3, InterfaceC0087c interfaceC0087c) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        String strA = a(str);
        String strA2 = a(context, str2);
        new com.baidu.mapsdkplatform.comapi.commonutils.b.c().a(strA, context.getFilesDir().getAbsolutePath(), str2 + ".zip", 2, new b(context, str2, interfaceC0087c, str3, strA2));
    }

    private String a(Context context) throws Throwable {
        BufferedReader bufferedReader = null;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir().getAbsolutePath(), "ver.cfg");
        if (!file.exists()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line != null) {
                            sb.append(line);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                return sb.toString();
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2) throws Throwable {
        JSONArray jSONArray;
        PrintWriter printWriter;
        if (context == null) {
            return;
        }
        File file = new File(context.getFilesDir().getAbsolutePath(), "ver.cfg");
        String strA = a(context);
        PrintWriter printWriter2 = null;
        try {
            try {
                if (TextUtils.isEmpty(strA)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(strA);
                }
                int length = jSONArray.length();
                if (length == 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, str2);
                    jSONArray.put(jSONObject);
                } else {
                    int i = 0;
                    JSONObject jSONObject2 = null;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        }
                        jSONObject2 = (JSONObject) jSONArray.opt(i);
                        if (jSONObject2 != null && jSONObject2.has(str)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i != -1 && jSONObject2 != null) {
                        jSONObject2.put(str, str2);
                        jSONArray.put(i, jSONObject2);
                    } else {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(str, str2);
                        jSONArray.put(jSONObject3);
                    }
                }
                printWriter = new PrintWriter(new FileWriter(file.getAbsoluteFile()));
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            printWriter.write(jSONArray.toString());
            printWriter.close();
        } catch (Exception e2) {
            e = e2;
            printWriter2 = printWriter;
            e.printStackTrace();
            if (printWriter2 != null) {
                printWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, File file, String str) throws Throwable {
        ZipFile zipFile;
        if (file == null || context == null) {
            return false;
        }
        ZipFile zipFile2 = null;
        try {
            try {
                try {
                    zipFile = new ZipFile(file.getAbsoluteFile());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            } catch (IllegalStateException e3) {
                e = e3;
            } catch (NullPointerException e4) {
                e = e4;
            } catch (SecurityException e5) {
                e = e5;
            } catch (ZipException e6) {
                e = e6;
            } catch (Exception unused) {
            }
        } catch (IOException e7) {
            Log.e(f3977a, "Close zipFile failed", e7);
        }
        try {
            ZipEntry entry = zipFile.getEntry(str + ".sty");
            if (entry == null) {
                try {
                    zipFile.close();
                } catch (IOException e8) {
                    Log.e(f3977a, "Close zipFile failed", e8);
                }
                return false;
            }
            boolean zA = a(zipFile.getInputStream(entry), new FileOutputStream(new File(a(context, str))));
            file.delete();
            try {
                zipFile.close();
            } catch (IOException e9) {
                Log.e(f3977a, "Close zipFile failed", e9);
            }
            return zA;
        } catch (FileNotFoundException e10) {
            e = e10;
            zipFile2 = zipFile;
            Log.e(f3977a, "unzip style file FileNotFoundException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (IOException e11) {
            e = e11;
            zipFile2 = zipFile;
            Log.e(f3977a, "unzip style file IOException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (IllegalStateException e12) {
            e = e12;
            zipFile2 = zipFile;
            Log.e(f3977a, "unzip style file IllegalStateException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (NullPointerException e13) {
            e = e13;
            zipFile2 = zipFile;
            Log.e(f3977a, "unzip style file NullPointerException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (SecurityException e14) {
            e = e14;
            zipFile2 = zipFile;
            Log.e(f3977a, "unzip style file SecurityException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (ZipException e15) {
            e = e15;
            zipFile2 = zipFile;
            Log.e(f3977a, "unzip style file ZipException", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (Exception unused2) {
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException e16) {
                    Log.e(f3977a, "Close zipFile failed", e16);
                }
            }
            throw th;
        }
    }

    private boolean a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException, NullPointerException {
        if (inputStream == null || fileOutputStream == null) {
            return false;
        }
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i);
            } finally {
            }
        }
        fileOutputStream.flush();
        try {
            inputStream.close();
        } catch (IOException e) {
            Log.e(f3977a, "Close InputStream error", e);
        }
        try {
            fileOutputStream.close();
            return true;
        } catch (IOException e2) {
            Log.e(f3977a, "Close OutputStream error", e2);
            return true;
        }
    }
}
