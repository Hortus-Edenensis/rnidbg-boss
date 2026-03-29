package defpackage;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class zp3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22475a = "ModeConfigHelper";

    public static boolean a() {
        boolean zA = aq3.a(AppContext.getContext().getTrayPreferences().b(k86.s(), 0), 1);
        LogUtil.d(f22475a, "modeConfig = " + AppContext.getContext().getTrayPreferences().b(k86.s(), 0) + "isDituiModeOpen = " + zA);
        return zA;
    }
}
