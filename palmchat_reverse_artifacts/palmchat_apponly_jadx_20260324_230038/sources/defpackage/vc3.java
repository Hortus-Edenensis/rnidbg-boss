package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.activity.find.separation.MapSeparationModel;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class vc3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21404a = "20连信豆/次";
    public static String b = "60连信豆/24小时";
    public static String c = "30连信豆";

    public static String a() {
        return t66.h().e("LX-50141", "A");
    }

    public static boolean b() {
        return !"A".equals(t66.h().e("LX-66344", "A"));
    }

    public static boolean c() {
        return !"A".contains(a());
    }

    public static void d(MapSeparationModel mapSeparationModel) {
        if (mapSeparationModel != null) {
            String str = mapSeparationModel.unlockBtnTitle;
            if (!TextUtils.isEmpty(str)) {
                f21404a = str;
            }
            String str2 = mapSeparationModel.clonedBtnTitle;
            if (!TextUtils.isEmpty(str2)) {
                b = str2;
            }
            String str3 = mapSeparationModel.unlockJourneyBtnTitle;
            if (!TextUtils.isEmpty(str3)) {
                c = str3;
            }
            LogUtil.d("", "setChargeData unlockBtnTitle " + f21404a + " clonedBtnTitle " + b + " unlockJourneyBtnTitle " + c);
        }
    }
}
