package defpackage;

import android.text.TextUtils;
import com.android.volley.toolbox.Volley;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class w84 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21638a = "w84";

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ed5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21639a;

        public a(String str) {
            this.f21639a = str;
        }

        @Override // defpackage.ed5, defpackage.il2
        public void onError(int i, String str) {
            super.onError(i, str);
            LogUtil.i(w84.f21638a, "download onError, error msg:" + str);
        }

        @Override // defpackage.ed5, defpackage.il2
        public void onFinish(File file) {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            sPUtil.t(scene, "open_screen_image_url", this.f21639a);
            sPUtil.t(scene, "open_screen_image_path", file.getAbsolutePath());
            sPUtil.t(scene, "open_screen_image_size", Long.valueOf(file.length()));
            LogUtil.i(w84.f21638a, "download onFinish, file path:" + file.getAbsolutePath());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ed5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21640a;

        public b(String str) {
            this.f21640a = str;
        }

        @Override // defpackage.ed5, defpackage.il2
        public void onError(int i, String str) {
            super.onError(i, str);
            LogUtil.i(w84.f21638a, "download icon onError, error msg:" + str);
        }

        @Override // defpackage.ed5, defpackage.il2
        public void onFinish(File file) {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            sPUtil.t(scene, "open_screen_icon_url", this.f21640a);
            sPUtil.t(scene, "open_screen_icon_path", file.getAbsolutePath());
            sPUtil.t(scene, "open_screen_icon_size", Long.valueOf(file.length()));
            LogUtil.i(w84.f21638a, "download icon onFinish, file path:" + file.getAbsolutePath());
        }
    }

    public static boolean b(String str, long j) {
        File file = new File(str);
        return file.exists() && file.length() == j;
    }

    public static x84 c() {
        return new x84();
    }

    public static void d(String str) {
        try {
            File file = new File(pu1.s, "openScreenBottomIcon.png");
            if (file.exists()) {
                file.delete();
            }
            if (dt0.l(AppContext.getContext(), Volley.getUserAgent()).m(str)) {
                return;
            }
            dt0.l(AppContext.getContext(), Volley.getUserAgent()).e(str, pu1.s, "openScreenBottomIcon.png", new b(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(String str) {
        try {
            String strSubstring = str.substring(str.lastIndexOf(47) + 1);
            if (TextUtils.isEmpty(strSubstring)) {
                strSubstring = "openScreen.png";
            }
            File file = new File(pu1.s, strSubstring);
            if (file.exists()) {
                file.delete();
            }
            if (dt0.l(AppContext.getContext(), Volley.getUserAgent()).m(str)) {
                return;
            }
            dt0.l(AppContext.getContext(), Volley.getUserAgent()).e(str, pu1.s, strSubstring, new a(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int f() {
        int iD = q35.b().d();
        if (iD > 10000) {
            return 10000;
        }
        return iD;
    }

    public static String g() {
        try {
            String strE = q35.b().e();
            if (!q35.b().h() || TextUtils.isEmpty(strE)) {
                return "";
            }
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            String strN = sPUtil.n(scene, "open_screen_image_url", "");
            String strN2 = sPUtil.n(scene, "open_screen_image_path", "");
            long jI = sPUtil.i(scene, "open_screen_image_size", 0L);
            if (strE.equals(strN) && b(strN2, jI)) {
                return strN2;
            }
            e(strE);
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void h() {
        String strE = q35.b().e();
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        String strN = sPUtil.n(scene, "open_screen_image_url", "");
        String strN2 = sPUtil.n(scene, "open_screen_image_path", "");
        long jI = sPUtil.i(scene, "open_screen_image_size", 0L);
        if (!TextUtils.isEmpty(strE) && (!strE.equals(strN) || !b(strN2, jI))) {
            e(strE);
        }
        String strC = q35.b().c();
        String strN3 = sPUtil.n(scene, "open_screen_icon_url", "");
        String strN4 = sPUtil.n(scene, "open_screen_icon_path", "");
        long jI2 = sPUtil.i(scene, "open_screen_icon_size", 0L);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        if (strC.equals(strN3) && b(strN4, jI2)) {
            return;
        }
        d(strC);
    }
}
