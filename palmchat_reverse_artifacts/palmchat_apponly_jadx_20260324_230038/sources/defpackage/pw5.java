package defpackage;

import com.zenmen.palmchat.conversations.threadsnew.filter.FilterConfig;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class pw5 {
    public static FilterConfig a() {
        JSONObject config = vs0.a().getConfig("msgsubtitle");
        FilterConfig filterConfig = config != null ? (FilterConfig) az2.a(config.toString(), FilterConfig.class) : null;
        return filterConfig == null ? new FilterConfig() : filterConfig;
    }

    public static boolean b() {
        return t66.h().f("LX-59422", false);
    }
}
