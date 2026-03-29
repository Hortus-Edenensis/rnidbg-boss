package defpackage;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class h47 implements k87 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dw6 f17869a;

    public h47(dw6 dw6Var) {
        this.f17869a = dw6Var;
    }

    public static String d(String str) {
        long j;
        try {
            j = Long.parseLong(str);
        } catch (Throwable unused) {
            j = 0;
        }
        return new DecimalFormat("##.##").format(j / 1048576.0f);
    }

    public static String e(m17 m17Var) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(m17Var.c)) {
            sb.append(m17Var.c);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        }
        sb.append(f(m17Var));
        sb.append(m17Var.b);
        return sb.toString();
    }

    public static String f(m17 m17Var) {
        String key;
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> map = m17Var.f;
        if (map != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String value = null;
                try {
                    key = next.getKey();
                    try {
                        value = next.getValue();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    key = null;
                }
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    if ("RAMSize".equals(key)) {
                        value = d(value) + "GB";
                    }
                    if ("InternalFreeSpace".equals(key)) {
                        value = d(value) + "GB";
                    }
                    sb.append(key);
                    sb.append(":");
                    sb.append(value);
                    if (it.hasNext()) {
                        sb.append(", ");
                    }
                }
            }
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        }
        return sb.toString();
    }

    @Override // defpackage.k87
    public final void a(m17 m17Var) {
        dw6 dw6Var = this.f17869a;
        if (dw6Var == null || !(m17Var.b instanceof String)) {
            return;
        }
        dw6Var.b(m17Var.e, e(m17Var), m17Var.d, c());
    }

    @Override // defpackage.k87
    public final void b(m17 m17Var) {
        dw6 dw6Var = this.f17869a;
        if (dw6Var == null || !(m17Var.b instanceof String)) {
            return;
        }
        dw6Var.b(m17Var.e, e(m17Var), m17Var.d, c());
    }

    public final int c() {
        return 104;
    }
}
