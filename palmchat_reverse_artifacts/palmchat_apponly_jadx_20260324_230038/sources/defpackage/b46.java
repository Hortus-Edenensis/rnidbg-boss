package defpackage;

import com.kuaishou.weapon.p0.t;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b46 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f1647a = {"m", "s", "t", "h", "g", "c", "f", "x", RXScreenCaptureService.KEY_WIDTH, t.f7496a};
    public static Map<String, String> b = new HashMap();

    static {
        for (int i = 0; i < f1647a.length; i++) {
            b.put("" + i, f1647a[i]);
            b.put(f1647a[i], "" + i);
        }
    }

    public static final long a(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(b.get("" + c));
        }
        try {
            return Long.parseLong(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static final String b(long j) {
        StringBuilder sb = new StringBuilder();
        for (char c : String.valueOf(j).toCharArray()) {
            sb.append(b.get("" + c));
        }
        return sb.toString();
    }
}
