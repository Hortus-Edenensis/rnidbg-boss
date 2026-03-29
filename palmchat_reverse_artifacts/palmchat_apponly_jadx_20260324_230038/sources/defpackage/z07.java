package defpackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.igexin.push.core.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class z07 {
    public static yc7 a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(b(str));
            yc7 yc7Var = new yc7();
            yc7Var.e(jSONObject.optString("url"));
            yc7Var.f(jSONObject.optJSONObject("body"));
            yc7Var.c(jSONObject.optString("dump_file"));
            yc7Var.g(jSONObject.optBoolean("encrypt", false));
            return yc7Var;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(String str) throws IOException {
        return e(str, null);
    }

    public static String c(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) {
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
            g(file2, jSONObject2.toString(), false);
        } catch (IOException | JSONException unused) {
        }
        return file2.getAbsolutePath();
    }

    public static String d(File file, String str, String str2, JSONObject jSONObject, boolean z) {
        return c(file, str, str2, jSONObject, null, z);
    }

    public static String e(String str, String str2) throws Throwable {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        xe7.a(bufferedReader2);
                        return sb.toString();
                    }
                    sb.append(line);
                    if (str2 != null) {
                        sb.append(str2);
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    xe7.a(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void f(Context context, String str, String str2) throws Throwable {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append(" ");
            if (str == null) {
                str = b.m;
            }
            sb.append(str);
            sb.append(" ");
            if (str2 == null) {
                str2 = b.m;
            }
            sb.append(str2);
            sb.append("\n");
            g(vh7.b(context), sb.toString(), true);
        } catch (IOException unused) {
        }
    }

    public static void g(@NonNull File file, @NonNull String str, boolean z) throws Throwable {
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
                xe7.a(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                xe7.a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean h(File file) {
        return file.exists() && file.delete();
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.delete();
    }
}
