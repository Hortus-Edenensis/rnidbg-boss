package defpackage;

import android.text.TextUtils;
import android.util.Base64;
import com.lantern.auth.server.WkParams;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.webplatform.networkinformation.NetworkManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class kw2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<String> f18840a = new ArrayList();
    public static List<String> b = new ArrayList();
    public static List<String> c = new ArrayList();
    public static List<String> d = new ArrayList();
    public static List<String> e = new ArrayList();
    public static List<String> f = new ArrayList();

    static {
        if (TextUtils.isEmpty("")) {
            return;
        }
        for (String str : new String(Base64.decode("", 2)).split(Constants.WAVE_SEPARATOR)) {
            String[] strArrSplit = str.split("-");
            if (strArrSplit[0].equals(WkParams.IMEI)) {
                f18840a.addAll(Arrays.asList(strArrSplit[1].split("\\|")));
            } else if (strArrSplit[0].equals("iccid")) {
                b.addAll(Arrays.asList(strArrSplit[1].split("\\|")));
            } else if (strArrSplit[0].equals("imsi")) {
                c.addAll(Arrays.asList(strArrSplit[1].split("\\|")));
            } else if (strArrSplit[0].equals("meid")) {
                d.addAll(Arrays.asList(strArrSplit[1].split("\\|")));
            } else if (strArrSplit[0].equals(NetworkManager.GSM)) {
                e.addAll(Arrays.asList(strArrSplit[1].split("\\|")));
            }
        }
        f.addAll(e);
        f.addAll(f18840a);
        f.addAll(c);
        f.addAll(b);
        f.addAll(d);
    }

    public static String a(int i, int i2) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? (i == 4 && i2 < e.size()) ? e.get(i2) : "" : i2 >= b.size() ? "" : b.get(i2) : i2 >= d.size() ? "" : d.get(i2) : i2 >= c.size() ? "" : c.get(i2) : i2 >= f18840a.size() ? "" : f18840a.get(i2);
    }
}
