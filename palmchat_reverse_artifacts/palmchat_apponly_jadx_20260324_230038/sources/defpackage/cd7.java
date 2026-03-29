package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.nr;
import com.bytedance.u.nr.fx;
import com.huawei.hms.framework.common.ContainerUtils;
import com.uc.crashsdk.export.LogType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class cd7 {
    public static volatile boolean f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c17 f1963a;
    public final Context b;
    public volatile long c;
    public volatile boolean d = false;
    public final SharedPreferences e;

    public cd7(Context context) {
        if (context == null || !(context instanceof Application)) {
            throw new IllegalArgumentException("context must not be null or not application");
        }
        this.b = context;
        SharedPreferences sharedPreferencesNr = nr.nr(context, "anr_monitor_table", 0);
        this.e = sharedPreferencesNr;
        this.c = sharedPreferencesNr.getLong("trace_anr_happen_time", 0L);
    }

    public static void d(String str) {
        Iterator<Object> it = uh7.g().b().iterator();
        while (it.hasNext()) {
            it.next();
            fx fxVar = fx.LAUNCH;
        }
    }

    public final String a(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }

    public JSONObject b(String str, int i, String str2) throws Throwable {
        BufferedReader bufferedReader;
        int i2;
        BufferedReader bufferedReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Exception unused) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                Pattern patternCompile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                Pattern patternCompile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                Pattern patternCompile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                Pattern patternCompile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                boolean z = false;
                Object[] objArrF = f(bufferedReader, patternCompile);
                if (objArrF == null) {
                    xe7.a(bufferedReader);
                    return null;
                }
                long j = Long.parseLong(objArrF[1].toString().split("\\s")[2]);
                long time = simpleDateFormat.parse(objArrF[1].toString().split("\\s")[4] + " " + objArrF[1].toString().split("\\s")[5]).getTime();
                Object[] objArrF2 = f(bufferedReader, patternCompile3);
                if (objArrF2 == null) {
                    xe7.a(bufferedReader);
                    return null;
                }
                String str3 = objArrF2[1].toString().split("\\s")[2];
                if (j == i && str3.equalsIgnoreCase(str2)) {
                    if (this.c != 0 && Math.abs(this.c - time) < 20000) {
                        xe7.a(bufferedReader);
                        return null;
                    }
                    this.c = time;
                    SharedPreferences sharedPreferences = this.e;
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putLong("trace_anr_happen_time", this.c).apply();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("anrTime", time);
                    while (true) {
                        Object[] objArrF3 = f(bufferedReader, patternCompile2, patternCompile4);
                        if (objArrF3 != null && objArrF3[0] == patternCompile4) {
                            Matcher matcher = Pattern.compile("\".+\"").matcher(objArrF3[1].toString());
                            String strSubstring = matcher.find() ? matcher.group().substring(1, matcher.group().length() - 1) : "";
                            Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(objArrF3[1].toString());
                            if (matcher2.find()) {
                                String strGroup = matcher2.group();
                                i2 = Integer.parseInt(strGroup.substring(strGroup.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1));
                            } else {
                                i2 = -1;
                            }
                            String strA = a(bufferedReader);
                            if (i2 != -1 && !TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(strA) && strSubstring.equalsIgnoreCase("main")) {
                                jSONObject.put("mainStackFromTrace", strA);
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        xe7.a(bufferedReader);
                        return null;
                    }
                    jSONObject.put("thread_number", 1);
                    xe7.a(bufferedReader);
                    return jSONObject;
                }
                xe7.a(bufferedReader);
                return null;
            } catch (Exception unused2) {
                xe7.a(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                xe7.a(bufferedReader2);
                throw th;
            }
        }
        return null;
    }

    public void c() {
        if (this.d) {
            return;
        }
        this.f1963a = new c17(this);
        this.d = true;
    }

    public boolean e(int i, String str, int i2) {
        JSONObject jSONObjectB;
        JSONObject jSONObjectB2;
        try {
            jSONObjectB = gj7.b(f);
        } catch (Throwable unused) {
            jSONObjectB = null;
        }
        String strA = gj7.a(this.b, i2);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        try {
            cf7 cf7VarA = uh7.g().a();
            if (cf7VarA != null) {
                if (cf7VarA.u()) {
                    if (i == 200 && (jSONObjectB2 = b(str, Process.myPid(), this.b.getPackageName())) != null && jSONObjectB2.length() > 0) {
                        jSONObjectB = jSONObjectB2;
                    }
                    if (jSONObjectB != null && jSONObjectB.length() > 0) {
                        try {
                            jSONObjectB.put("pid", Process.myPid());
                            jSONObjectB.put("package", this.b.getPackageName());
                            jSONObjectB.put("is_remote_process", 0);
                            ql7 ql7Var = new ql7(new JSONObject());
                            ql7Var.n("data", jSONObjectB.toString());
                            ql7Var.n("is_anr", 1);
                            ql7Var.n("timestamp", Long.valueOf(System.currentTimeMillis()));
                            ql7Var.n("event_type", LogType.ANR_TYPE);
                            ql7Var.n("anr_time", Long.valueOf(System.currentTimeMillis()));
                            ql7Var.n("crash_time", Long.valueOf(System.currentTimeMillis()));
                            ql7Var.n("anr_info", strA);
                            fj7 fj7VarB = fj7.b();
                            fx fxVar = fx.ANR;
                            ql7 ql7VarC = fj7VarB.c(fxVar, ql7Var);
                            z07.f(this.b, fxVar.u(), null);
                            hl7.c().a(ql7VarC.d());
                            d(strA);
                        } catch (Throwable th) {
                            mf7.a(th);
                        }
                    }
                    return true;
                }
            }
        } catch (Throwable unused2) {
        }
        return false;
    }

    public final Object[] f(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null && patternArr.length > 0) {
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    for (Pattern pattern : patternArr) {
                        if (pattern.matcher(line).matches()) {
                            return new Object[]{pattern, line};
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }
}
