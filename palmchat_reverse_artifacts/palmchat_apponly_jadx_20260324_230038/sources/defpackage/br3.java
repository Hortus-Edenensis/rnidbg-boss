package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.fk2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class br3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f1807a = -1;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements fk2 {
        @Override // defpackage.fk2
        public Intent a(Context context, fk2.a aVar) {
            fk2.a aVar2 = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("main_tab", "tab_square");
            bundle.putString("square_tab", "momentsTitle");
            aVar2.b(bundle);
            return n5.b(AppContext.getContext(), aVar2);
        }
    }

    public static int a() {
        g();
        return f1807a;
    }

    public static boolean b() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.MOMENTS_EDIT_TIPS);
        if (dynamicConfig != null) {
            return dynamicConfig.isEnable();
        }
        return false;
    }

    public static void c() {
        LogUtil.d("logbadge", "onAppForeground");
        g();
        if (f1807a > 0) {
            h(0);
            ch.s().t0();
            LogUtil.d("logbadge", "onAppForeground: clear");
        }
    }

    public static void d() {
        LogUtil.d("logbadge", "onMomentsMessage");
        f();
    }

    public static void e() {
        LogUtil.d("logbadge", "onNewMoments");
        f();
    }

    public static void f() {
        LogUtil.d("logbadge", "plusBadge: bg=" + AppContext.getContext().isBackground());
        if (AppContext.getContext().isBackground()) {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.MOMENTS;
            long jI = sPUtil.i(scene, k86.a("moments_badge_plus_time"), 0L);
            if (cg4.b(jI, System.currentTimeMillis())) {
                LogUtil.d("logbadge", "plusBadge: has plus before, time=" + jI);
                return;
            }
            g();
            h(f1807a + 1);
            sPUtil.t(scene, k86.a("moments_badge_plus_time"), Long.valueOf(System.currentTimeMillis()));
            ch.s().t0();
            LogUtil.d("logbadge", "plusBadge: count=" + f1807a);
            LogUtil.uploadInfoImmediate("M125", null, null, null);
        }
    }

    public static void g() {
        if (f1807a < 0) {
            f1807a = SPUtil.f14322a.f(SPUtil.SCENE.MOMENTS, k86.a("moments_badge_count"), 0);
        }
    }

    public static void h(int i) {
        f1807a = i;
        SPUtil.f14322a.t(SPUtil.SCENE.MOMENTS, k86.a("moments_badge_count"), Integer.valueOf(f1807a));
    }
}
