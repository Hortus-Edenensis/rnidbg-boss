package defpackage;

import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.zenmen.square.dynamiclife.DynamicSuperExposeV1Config;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class kj1 {

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static kj1 f18706a = new kj1();
    }

    public static kj1 b() {
        return b.f18706a;
    }

    public DynamicSuperExposeV1Config a() {
        String strB0 = bj5.b().a().b0("postboost_entrance");
        if (!TextUtils.isEmpty(strB0)) {
            try {
                return (DynamicSuperExposeV1Config) az2.a(strB0, DynamicSuperExposeV1Config.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean c() {
        boolean z;
        boolean zM = bj5.b().a().m();
        boolean zA = bj5.b().a().a();
        DynamicSuperExposeV1Config dynamicSuperExposeV1ConfigA = a();
        String str = dynamicSuperExposeV1ConfigA != null ? dynamicSuperExposeV1ConfigA.rccLevel : null;
        if (TextUtils.isEmpty(str)) {
            str = "10,20";
        }
        boolean z2 = false;
        if (TextUtils.isEmpty(str) || q05.e() == null) {
            z = false;
        } else {
            int riskLevel = q05.e().getRiskLevel();
            if (riskLevel != 0) {
                if (str.contains(riskLevel + "")) {
                }
            } else if (str.contains("10") || str.contains(BaseWrapper.ENTER_ID_SYSTEM_HELPER)) {
                z = true;
            }
        }
        if (zM && !zA && z) {
            z2 = true;
        }
        return Boolean.valueOf(z2);
    }

    public kj1() {
    }
}
