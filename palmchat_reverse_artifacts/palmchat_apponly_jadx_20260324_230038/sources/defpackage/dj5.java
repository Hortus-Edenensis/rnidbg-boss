package defpackage;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class dj5 {
    public static String a() {
        JSONObject config = vs0.a().getConfig("albumscreen");
        return config != null ? config.optString("intro", "回忆仅显示由设备真实拍摄的内容") : "回忆仅显示由设备真实拍摄的内容";
    }

    public static int b() {
        JSONObject config = vs0.a().getConfig("albumscreen");
        if (config != null) {
            return config.optInt("shootingmachine", 1);
        }
        return 1;
    }

    public static int c() {
        JSONObject config = vs0.a().getConfig("albumscreen");
        if (config != null) {
            return config.optInt("folder", 1);
        }
        return 1;
    }

    public static int d() {
        JSONObject config = vs0.a().getConfig("albumscreen");
        if (config != null) {
            return config.optInt("location", 1);
        }
        return 1;
    }

    public static int e() {
        JSONObject config = vs0.a().getConfig("albumscreen");
        if (config != null) {
            return config.optInt("shootingtime", 1);
        }
        return 1;
    }
}
