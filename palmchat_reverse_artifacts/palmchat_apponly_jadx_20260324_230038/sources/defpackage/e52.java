package defpackage;

import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class e52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17215a = "GDTSdkManager";

    public static boolean a() {
        boolean zA = jo6.a("LX-22022", false);
        LogUtil.i(f17215a, "getTaichiKey " + zA);
        return zA;
    }

    public static void b() {
        boolean zA = a();
        LogUtil.i(f17215a, "updateEnable isTaichiEnable=" + zA);
        SPUtil.f14322a.t(SPUtil.SCENE.AD, k86.a("key_gdt_minetab_enable"), Boolean.valueOf(zA));
    }
}
