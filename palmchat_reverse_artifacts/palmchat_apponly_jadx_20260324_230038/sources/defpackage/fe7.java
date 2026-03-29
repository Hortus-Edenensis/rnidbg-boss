package defpackage;

import android.content.Context;
import com.baidu.platform.comapi.map.MapController;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fe7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17521a;
    public HashMap<String, Long> b;
    public int c = 50;
    public int d = 100;

    public fe7(Context context) {
        this.b = null;
        this.f17521a = context;
        this.b = e();
        d();
    }

    public void a() throws Throwable {
        HashMap<String, Long> map = this.b;
        Long lRemove = map.remove("time");
        if (lRemove == null) {
            n37.a();
            n37.b("NPTH_CATCH", new RuntimeException("err times, no time"));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lRemove);
        sb.append('\n');
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(' ');
            sb.append(entry.getValue());
            sb.append('\n');
        }
        try {
            re7.j(wi7.z(this.f17521a), sb.toString(), false);
        } catch (IOException unused) {
        }
    }

    public final void b(File file) {
        File fileX = wi7.x(this.f17521a);
        file.renameTo(new File(fileX, String.valueOf(System.currentTimeMillis())));
        String[] list = fileX.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            new File(fileX, list[0]).delete();
        }
    }

    public boolean c(String str) {
        if (str == null) {
            str = MapController.DEFAULT_LAYER_TAG;
        }
        return nj7.b(this.b, str, 1L).longValue() < ((long) this.c) && nj7.b(this.b, "all", 1L).longValue() < ((long) this.d);
    }

    public final void d() {
        this.c = nv6.a(this.c, "custom_event_settings", "npth_simple_setting", "crash_limit_issue");
        this.d = nv6.a(this.d, "custom_event_settings", "npth_simple_setting", "crash_limit_all");
    }

    public final HashMap<String, Long> e() {
        JSONArray jSONArrayU;
        File fileZ = wi7.z(this.f17521a);
        HashMap<String, Long> map = new HashMap<>();
        map.put("time", Long.valueOf(System.currentTimeMillis()));
        try {
            jSONArrayU = re7.u(fileZ.getAbsolutePath());
        } catch (IOException unused) {
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
        }
        if (gg7.f(jSONArrayU)) {
            return map;
        }
        Long lDecode = Long.decode(jSONArrayU.optString(0, null));
        if (System.currentTimeMillis() - lDecode.longValue() > 86400000) {
            b(fileZ);
            return map;
        }
        map.put("time", lDecode);
        for (int i = 1; i < jSONArrayU.length(); i++) {
            String[] strArrSplit = jSONArrayU.optString(i, "").split(" ");
            if (strArrSplit.length == 2) {
                map.put(strArrSplit[0], Long.decode(strArrSplit[1]));
            }
        }
        return map;
    }
}
