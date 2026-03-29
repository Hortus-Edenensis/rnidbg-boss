package defpackage;

import android.text.TextUtils;
import com.huawei.hms.ads.dynamicloader.b;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class av3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, zu3> f1578a = new HashMap<>();
    public static HashMap<String, Boolean> b = new HashMap<>();

    public static void c(String str, String str2) {
        LogUtil.d("LxAdSdk", "LXadDown deleteDownApp pkgName " + str2 + " pkgUrl " + str);
        if (!TextUtils.isEmpty(str)) {
            if (b.containsKey(str)) {
                b.remove(str);
            }
            dt0.k(AppContext.getContext()).d(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (f1578a.containsKey(str2)) {
            f1578a.remove(str2);
        }
        String filepathByPkg = LxAdDLManager.getInstance(AppContext.getContext()).getFilepathByPkg(str2);
        if (TextUtils.isEmpty(filepathByPkg)) {
            return;
        }
        File file = new File(filepathByPkg);
        if (file.exists()) {
            LogUtil.d("LxAdSdk", "LXadDown deleteDownApp pkgName " + str2 + " file.delete() done");
            file.delete();
        }
    }

    public static String d(String str) {
        return str + "_downAllSize";
    }

    public static boolean e(String str) {
        return !TextUtils.isEmpty(str) && f1578a.containsKey(str);
    }

    public static void f(String str) {
        try {
            if (f1578a.containsKey(str)) {
                zu3 zu3Var = f1578a.get(str);
                dt0.k(AppContext.getContext()).e(zu3Var.f22516a, zu3Var.b, zu3Var.d, zu3Var.f);
            }
        } catch (Exception unused) {
        }
    }

    public static void g(String str, String str2, String str3, JSONObject jSONObject) {
        try {
            if (dt0.k(AppContext.getContext()).m(str)) {
                LogUtil.d("LxAdSdk", "LXadDown startDlAd isDownloading " + str3 + " downUrl " + str);
                LxAdDLManager.getInstance(AppContext.getContext()).onResumeDl(str3);
                return;
            }
            zu3 zu3Var = new zu3();
            zu3Var.b = str2;
            zu3Var.c = str3;
            zu3Var.f22516a = str;
            zu3Var.e = jSONObject;
            a aVar = new a(str3, jSONObject, str);
            zu3Var.f = aVar;
            String str4 = str3 + b.b;
            zu3Var.d = str4;
            f1578a.put(str3, zu3Var);
            dt0.k(AppContext.getContext()).e(str, str2, str4, aVar);
        } catch (Exception unused) {
        }
    }

    public static void h(String str) {
        dt0.k(AppContext.getContext()).h(str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements il2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1579a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;

        public a(String str, JSONObject jSONObject, String str2) {
            this.f1579a = str;
            this.b = jSONObject;
            this.c = str2;
        }

        @Override // defpackage.il2
        public void onError(int i, String str) {
            LogUtil.d("LxAdSdk", "LXadDown onError pkgName " + this.f1579a + " error " + str);
            LxAdDLManager.getInstance(AppContext.getContext()).onDownError(this.c, this.f1579a, i, str, true);
        }

        @Override // defpackage.il2
        public void onFinish(File file) {
            int iF = SPUtil.f14322a.f(SPUtil.SCENE.AD, av3.d(this.f1579a), 10000);
            LogUtil.d("LxAdSdk", "LXadDown onFinish pkgName " + this.f1579a + " file " + file + " allSize " + iF);
            if (iF == -1) {
                LxAdDLManager.getInstance(AppContext.getContext()).onDownError(this.c, this.f1579a, -10001, "onFinish error", true);
            } else {
                LxAdDLManager.getInstance(AppContext.getContext()).onFinishDownAd(this.c, this.f1579a, file);
            }
        }

        @Override // defpackage.il2
        public void onProgress(int i) {
            LxAdDLManager.getInstance(AppContext.getContext()).updateDownAdProcess(this.f1579a, (int) ((i * 100.0f) / SPUtil.f14322a.f(SPUtil.SCENE.AD, av3.d(this.f1579a), 10000)));
        }

        @Override // defpackage.il2
        public void onStart(String str, String str2, int i) {
            LogUtil.d("LxAdSdk", "LXadDown onStart pkgName " + this.f1579a + " realUrl " + str2 + " fileName " + str + " fileLength " + i);
            if (av3.b.containsKey(str2)) {
                LxAdDLManager.getInstance(AppContext.getContext()).onResumeDl(this.f1579a);
            } else {
                SPUtil.f14322a.t(SPUtil.SCENE.AD, av3.d(this.f1579a), Integer.valueOf(i));
                LxAdDLManager.getInstance(AppContext.getContext()).onStartDownAd(this.f1579a, str, i, this.b);
            }
            av3.b.put(str2, Boolean.TRUE);
        }

        @Override // defpackage.il2
        public void onStop(int i) {
            LogUtil.d("LxAdSdk", "LXadDown onStop pkgName " + this.f1579a + " progress " + i);
            LxAdDLManager.getInstance(AppContext.getContext()).onStopDl(this.f1579a);
        }

        @Override // defpackage.il2
        public void onPrepare() {
        }
    }
}
