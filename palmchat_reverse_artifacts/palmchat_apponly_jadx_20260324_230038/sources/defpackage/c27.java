package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.lantern.core.configuration.ConfigOpenHelper;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c27 extends r87 {
    public static SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd");
    public static String c = ",";

    public c27(Context context) {
        this(context.getApplicationContext(), "wfc_config_info", 0);
    }

    public int h() {
        int iF;
        synchronized (c27.class) {
            iF = f("wake_type");
        }
        return iF;
    }

    public void i(int i) {
        synchronized (c27.class) {
            a("wake_type", i);
        }
    }

    public void j(long j) {
        b("request_ts", j);
    }

    public void k(String str) {
        c("wake_from", str);
    }

    public String l() {
        return e("wake_from");
    }

    public void m(int i) {
        a("config_version", i);
    }

    public void n(String str) {
        c(ConfigOpenHelper.DB_TABLE, str);
    }

    public int o() {
        return f("config_version");
    }

    public void p(int i) {
        a("config_request_duration", i);
    }

    public String q() {
        return e(ConfigOpenHelper.DB_TABLE);
    }

    public void r(int i) {
        a("config_request_number", i);
    }

    public int s() {
        return d("config_request_duration", 6);
    }

    public void t(int i) {
        StringBuffer stringBuffer = new StringBuffer(b.format(new Date()));
        stringBuffer.append(c);
        stringBuffer.append(i);
        c("request_number", stringBuffer.toString());
    }

    public int u() {
        return d("config_request_number", 1);
    }

    public long v() {
        return g("request_ts");
    }

    public int w() {
        String strE = e("request_number");
        if (!TextUtils.isEmpty(strE) && strE.contains(c)) {
            try {
                String[] strArrSplit = strE.split(c);
                String str = strArrSplit[0];
                int iIntValue = Integer.valueOf(strArrSplit[1]).intValue();
                if (b.format(new Date()).equalsIgnoreCase(str)) {
                    return iIntValue;
                }
                t(1);
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public c27(Context context, String str, int i) {
        super(context, str, i);
    }
}
