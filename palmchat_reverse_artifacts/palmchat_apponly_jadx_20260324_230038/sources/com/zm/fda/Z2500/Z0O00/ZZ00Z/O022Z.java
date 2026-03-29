package com.zm.fda.Z2500.Z0O00.ZZ00Z;

import android.os.Build;
import com.lantern.auth.server.WkParams;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O022Z {
    public static final String m = "/proc/version";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16687a = Build.DEVICE;
    public String b = Build.MODEL;
    public String c = Build.PRODUCT;
    public String d = Build.BOARD;
    public String e = Build.VERSION.RELEASE;
    public int f = Build.VERSION.SDK_INT;
    public String g = Build.BRAND;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;

    public O022Z() {
        try {
            this.h = a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.i = Build.VERSION.INCREMENTAL;
        this.j = Build.DISPLAY;
        this.k = Build.TYPE;
        this.l = Build.MANUFACTURER;
    }

    public static String a() {
        try {
            return a(b(m));
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    public static String b(String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str), 256);
        try {
            return bufferedReader.readLine();
        } finally {
            bufferedReader.close();
        }
    }

    public static String a(String str) {
        Matcher matcher = Pattern.compile("Linux version (\\S+) \\((\\S+?)\\) (?:\\(gcc.+? \\)) (#\\d+) (?:.*?)?((Sun|Mon|Tue|Wed|Thu|Fri|Sat).+)").matcher(str);
        if (!matcher.matches() || matcher.groupCount() < 4) {
            return "Unavailable";
        }
        return matcher.group(1) + "\n" + matcher.group(2) + " " + matcher.group(3) + "\n" + matcher.group(4);
    }

    public void a(JSONObject jSONObject) {
        try {
            String str = this.f16687a;
            if (str != null) {
                jSONObject.put("device", str);
            }
            String str2 = this.b;
            if (str2 != null) {
                jSONObject.put(WkParams.MODEL, str2);
            }
            String str3 = this.c;
            if (str3 != null) {
                jSONObject.put("product", str3);
            }
            String str4 = this.d;
            if (str4 != null) {
                jSONObject.put("board", str4);
            }
            String str5 = this.e;
            if (str5 != null) {
                jSONObject.put("firmware", str5);
            }
            jSONObject.put("sdk_int", this.f);
            String str6 = this.h;
            if (str6 != null) {
                jSONObject.put("kernel", str6);
            }
            String str7 = this.i;
            if (str7 != null) {
                jSONObject.put("buildIncremental", str7);
            }
            String str8 = this.j;
            if (str8 != null) {
                jSONObject.put("buildDisplay", str8);
            }
            String str9 = this.k;
            if (str9 != null) {
                jSONObject.put("buildType", str9);
            }
            String str10 = this.l;
            if (str10 != null) {
                jSONObject.put("manufacture", str10);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
