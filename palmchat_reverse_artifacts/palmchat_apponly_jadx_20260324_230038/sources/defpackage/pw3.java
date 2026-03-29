package defpackage;

import com.qiniu.android.collect.ReportItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class pw3 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20120a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public a(String str, int i, String str2) {
            this.f20120a = str;
            this.b = i;
            this.c = str2;
            put("action", ReportItem.LogTypeRequest);
            put("url", str);
            put("type", Integer.valueOf(i));
            put("body", str2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20121a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object c;

        public b(String str, int i, Object obj) {
            this.f20121a = str;
            this.b = i;
            this.c = obj;
            put("action", "response");
            put("url", str);
            put("code", Integer.valueOf(i));
            put("response", obj != null ? obj.toString() : "");
        }
    }

    public static boolean a() {
        return !nl0.k();
    }

    public static void b(String str, int i, String str2) {
        LogUtil.i("NetWorkLogger", LogUtil.LogType.LOG_TYPE_BACKGROUP, 3, new a(str, i, str2), (Throwable) null);
    }

    public static void c(String str, int i, JSONObject jSONObject) {
        b(str, i, jSONObject != null ? jSONObject.toString() : null);
    }

    public static void d(String str, int i, Object obj) {
        LogUtil.i("NetWorkLogger", LogUtil.LogType.LOG_TYPE_BACKGROUP, 3, new b(str, i, obj), (Throwable) null);
    }
}
