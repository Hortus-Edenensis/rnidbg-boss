package defpackage;

import android.text.TextUtils;
import com.apm.lite.CrashType;
import com.apm.lite.j.e;
import com.apm.lite.nativecrash.NativeImpl;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class re7 {
    public static void A(String str, String str2) throws Throwable {
        o(str2, new File(str));
    }

    public static ev6 B(File file) {
        ev6 ev6VarA = a(new File(file, "logEventStack"), file.getName().contains("oom"));
        boolean z = false;
        for (int i = 0; i < m77.b(); i++) {
            File fileE = wi7.e(file, "." + i);
            if (fileE.exists()) {
                try {
                    ev6VarA.y(new JSONObject(z(fileE.getAbsolutePath())));
                    z = true;
                } catch (Throwable unused) {
                }
            }
        }
        ev6VarA.e(CrashHianalyticsData.CRASH_TYPE, z ? "step" : "simple");
        JSONObject jSONObjectOptJSONObject = ev6VarA.G().optJSONObject("header");
        JSONObject jSONObjectS = q37.b(x97.m(), ev6VarA.G().optLong("crash_time", 0L)).s();
        if (jSONObjectOptJSONObject == null) {
            ev6VarA.i(jSONObjectS);
        } else {
            gg7.e(jSONObjectOptJSONObject, jSONObjectS);
        }
        return ev6VarA;
    }

    public static v77 C(String str) {
        try {
            String strZ = z(str);
            if (strZ == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strZ);
            v77 v77Var = new v77();
            v77Var.b(jSONObject.optString("url"));
            v77Var.d(jSONObject.optJSONObject("body"));
            v77Var.g(jSONObject.optString("dump_file"));
            v77Var.e(jSONObject.optBoolean("encrypt", false));
            return v77Var;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static v77 D(String str) {
        try {
            JSONObject jSONObject = new JSONObject(z(str));
            v77 v77Var = new v77();
            v77Var.k(jSONObject.optString("aid"));
            v77Var.i(jSONObject.optString("did"));
            v77Var.m(jSONObject.optString("processName"));
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("alogFiles");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i));
                }
                v77Var.c(arrayList);
            }
            return v77Var;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0041: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:66), block:B:21:0x0041 */
    public static Map<String, String> E(File file) throws Throwable {
        FileInputStream fileInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                Properties properties = new Properties();
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    Set<String> setStringPropertyNames = properties.stringPropertyNames();
                    HashMap map = new HashMap();
                    for (String str : setStringPropertyNames) {
                        map.put(str, properties.getProperty(str));
                    }
                    wf7.a(fileInputStream);
                    return map;
                } catch (IOException e) {
                    e = e;
                    kj7.g(e);
                    wf7.a(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                wf7.a(closeable2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            wf7.a(closeable2);
            throw th;
        }
    }

    public static void F(File file) {
        File file2 = new File(file, "lock");
        try {
            file2.createNewFile();
            NativeImpl.doLock(file2.getAbsolutePath());
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
        }
    }

    public static boolean G(File file) {
        if (!file.isFile()) {
            file = new File(file, "lock");
        }
        if (!file.exists()) {
            return false;
        }
        try {
            int iDoLock = NativeImpl.doLock(file.getAbsolutePath());
            if (iDoLock > 0) {
                NativeImpl.unLock(iDoLock);
                return false;
            }
            if (iDoLock < 0) {
                return true;
            }
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ev6 a(File file, boolean z) {
        String str;
        String strG;
        String string;
        String str2;
        String str3;
        ev6 ev6Var = new ev6();
        str = "InvalidStack.NoStackAvailable: OOM.\n";
        if (file.exists()) {
            try {
                strG = g(file.getAbsolutePath(), "\n");
            } catch (IOException unused) {
                strG = null;
            }
            if (TextUtils.isEmpty(strG)) {
                if (!z) {
                    str = "InvalidStack.NoStackAvailable: not OOM.\n";
                }
                str3 = null;
                str2 = null;
            } else {
                String[] strArrSplit = strG.split("\n");
                ArrayList arrayList = new ArrayList();
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                boolean z2 = false;
                boolean z3 = false;
                for (String str4 : strArrSplit) {
                    if (!z2 && str4.startsWith("stack:")) {
                        z2 = true;
                    } else if (!z3 && str4.startsWith("err:")) {
                        z3 = true;
                    } else if (z3) {
                        sb2.append(str4);
                        sb2.append("\n");
                    } else if (z2) {
                        sb.append(str4);
                        sb.append("\n");
                    } else {
                        arrayList.add(str4);
                    }
                }
                String str5 = arrayList.size() >= 1 ? (String) arrayList.get(0) : null;
                String str6 = arrayList.size() >= 2 ? (String) arrayList.get(1) : null;
                String str7 = arrayList.size() >= 3 ? (String) arrayList.get(2) : null;
                String str8 = arrayList.size() >= 4 ? (String) arrayList.get(3) : null;
                if (z2 && sb.length() > 0) {
                    string = sb.toString();
                } else if (str7 != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str7);
                    sb3.append("\nCaused by: ");
                    sb3.append(z ? "InvalidStack.NoStackAvailable: OOM.\n" : "InvalidStack.NoStackAvailable: not OOM.\n");
                    string = sb3.toString();
                } else if (str6 != null) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str6);
                    sb4.append("\nCaused by: ");
                    sb4.append(z ? "InvalidStack.NoStackAvailable: OOM.\n" : "InvalidStack.NoStackAvailable: not OOM.\n");
                    string = sb4.toString();
                } else {
                    string = z ? "InvalidStack.NoStackAvailable: OOM.\n" : "InvalidStack.NoStackAvailable: not OOM.\n";
                }
                if (z3 && sb2.length() > 0) {
                    string = string + "\nCaused by: InvalidStack.CrashWhenWriteStack: Npth ERROR:\n" + ((Object) sb2);
                }
                str = string;
                str2 = str5;
                str3 = str8;
            }
        } else {
            if (!z) {
            }
            str3 = null;
            str2 = null;
        }
        ev6Var.j("data", str);
        ev6Var.j(ContentProviderManager.PLUGIN_PROCESS_NAME, str2);
        ev6Var.j("crash_thread_name", str3);
        ev6Var.j("isOOM", Boolean.valueOf(z));
        return ev6Var;
    }

    public static v77 b(File file, CrashType crashType) {
        ev6 ev6VarB = B(file);
        String name = file.getName();
        String strSubstring = name.substring(name.lastIndexOf(95) + 1);
        JSONObject jSONObjectOptJSONObject = ev6VarB.G().optJSONObject("header");
        if (jSONObjectOptJSONObject.optString("unique_key", null) == null) {
            try {
                jSONObjectOptJSONObject.put("unique_key", "android_" + x97.h().a() + "_" + strSubstring + "_" + CrashType.LAUNCH);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        v77 v77Var = new v77();
        v77Var.b(crashType == CrashType.LAUNCH ? e.v() : e.s());
        v77Var.d(ev6VarB.G());
        v77Var.e(e.i());
        return v77Var;
    }

    public static String c(File file, String str) {
        return d(file, str, -1L);
    }

    public static String d(File file, String str, long j) throws Throwable {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            if (j > 0) {
                try {
                    bufferedReader2.skip(j);
                    bufferedReader2.readLine();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    wf7.a(bufferedReader);
                    throw th;
                }
            }
            while (true) {
                String line = bufferedReader2.readLine();
                if (line == null) {
                    wf7.a(bufferedReader2);
                    return sb.toString();
                }
                if (sb.length() != 0 && str != null) {
                    sb.append(str);
                }
                sb.append(line);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String e(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str2);
            jSONObject2.put("body", jSONObject);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put("dump_file", str3);
            jSONObject2.put("encrypt", z);
            m(file2, jSONObject2, false);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return file2.getAbsolutePath();
    }

    public static String f(File file, String str, String str2, JSONObject jSONObject, boolean z) {
        return e(file, str, str2, jSONObject, null, z);
    }

    public static String g(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c(new File(str), str2);
    }

    public static JSONArray h(File file, long j) throws Throwable {
        JSONArray jSONArray = new JSONArray();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            if (j > 0) {
                try {
                    bufferedReader2.skip(j);
                    bufferedReader2.readLine();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    wf7.a(bufferedReader);
                    throw th;
                }
            }
            while (true) {
                String line = bufferedReader2.readLine();
                if (line == null) {
                    wf7.a(bufferedReader2);
                    return jSONArray;
                }
                jSONArray.put(line);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void i(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        if (file == null || file2 == null) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            file2.getParentFile().mkdirs();
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        if (i <= 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i);
                        }
                    }
                    wf7.a(fileInputStream2);
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        wf7.a(fileInputStream);
                    } catch (Throwable th) {
                        th = th;
                        wf7.a(fileInputStream);
                        wf7.a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    wf7.a(fileInputStream);
                    wf7.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        wf7.a(fileOutputStream);
    }

    public static void j(File file, String str, boolean z) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
            try {
                fileOutputStream2.write(str.getBytes());
                fileOutputStream2.flush();
                wf7.a(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                wf7.a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void k(File file, Map<String, String> map) throws Throwable {
        Properties properties;
        FileOutputStream fileOutputStream;
        if (map == null || map.isEmpty()) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                properties = new Properties();
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                properties.setProperty(entry.getKey(), entry.getValue());
            }
            properties.store(fileOutputStream, "no");
            wf7.a(fileOutputStream);
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            kj7.g(e);
            wf7.a(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            wf7.a(fileOutputStream2);
            throw th;
        }
    }

    public static void l(File file, JSONArray jSONArray, boolean z) {
        if (jSONArray == null) {
            return;
        }
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                hh7.h(jSONArray, bufferedWriter2);
                wf7.a(bufferedWriter2);
            } catch (Throwable unused) {
                bufferedWriter = bufferedWriter2;
                wf7.a(bufferedWriter);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void m(File file, JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return;
        }
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                hh7.j(jSONObject, bufferedWriter2);
                wf7.a(bufferedWriter2);
            } catch (Throwable unused) {
                bufferedWriter = bufferedWriter2;
                wf7.a(bufferedWriter);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void n(OutputStream outputStream, File... fileArr) throws Throwable {
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(outputStream);
            try {
                zipOutputStream2.putNextEntry(new ZipEntry("/"));
                for (File file : fileArr) {
                    p(zipOutputStream2, file);
                }
                wf7.a(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                wf7.a(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void o(String str, File file) throws Throwable {
        ZipOutputStream zipOutputStream = null;
        try {
            new File(str).getParentFile().mkdirs();
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(str));
            try {
                q(zipOutputStream2, file, "");
                wf7.a(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                wf7.a(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void p(ZipOutputStream zipOutputStream, File file) throws Throwable {
        if (file == null || !file.exists()) {
            return;
        }
        File[] fileArrListFiles = file.isDirectory() ? file.listFiles() : new File[]{file};
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            q(zipOutputStream, file2, file2.getName());
        }
    }

    public static void q(ZipOutputStream zipOutputStream, File file, String str) throws Throwable {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            zipOutputStream.putNextEntry(new ZipEntry(str + "/"));
            String str2 = str.length() == 0 ? "" : str + "/";
            for (int i = 0; i < fileArrListFiles.length; i++) {
                q(zipOutputStream, fileArrListFiles[i], str2 + fileArrListFiles[i].getName());
            }
            return;
        }
        zipOutputStream.putNextEntry(new ZipEntry(str));
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i2 = fileInputStream2.read(bArr);
                    if (-1 == i2) {
                        wf7.a(fileInputStream2);
                        return;
                    }
                    zipOutputStream.write(bArr, 0, i2);
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                wf7.a(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean r(File file) {
        boolean zR;
        boolean z = true;
        if (!file.exists()) {
            return true;
        }
        if (!file.canWrite()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory()) {
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        for (int i = 0; fileArrListFiles != null && i < fileArrListFiles.length; i++) {
            if (!fileArrListFiles[i].isFile()) {
                zR = r(fileArrListFiles[i]);
            } else if (fileArrListFiles[i].canWrite()) {
                zR = fileArrListFiles[i].delete();
            } else {
                z = false;
            }
            z &= zR;
        }
        return z & file.delete();
    }

    public static boolean s(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return r(new File(str));
    }

    public static boolean t(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static JSONArray u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return h(new File(str), -1L);
    }

    public static JSONArray v(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (str != null && str2 != null) {
            for (String str3 : str.split(str2)) {
                jSONArray.put(str3);
            }
        }
        return jSONArray;
    }

    public static void w(File file, JSONObject jSONObject, boolean z) {
        BufferedWriter bufferedWriter;
        if (jSONObject == null) {
            return;
        }
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter2 = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            hh7.j(jSONObject, bufferedWriter);
            wf7.a(bufferedWriter);
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            try {
                try {
                    jSONObject.put("err_write", th.toString());
                    ev6.k(jSONObject, "filters", "err_write", th.getLocalizedMessage());
                } finally {
                    wf7.a(bufferedWriter2);
                }
            } catch (JSONException unused) {
            }
            n37.a();
            n37.b("NPTH_CATCH", th);
        }
    }

    public static boolean x(File file) {
        String[] list = file.list();
        return list == null || list.length == 0;
    }

    public static String y(File file) {
        return c(file, "\n");
    }

    public static String z(String str) {
        return g(str, "\n");
    }
}
