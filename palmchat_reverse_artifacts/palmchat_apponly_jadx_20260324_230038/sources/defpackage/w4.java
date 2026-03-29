package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import cn.wh.auth.OnCallBack;
import cn.wh.auth.WAuthService;
import cn.wh.auth.bean.Result;
import cn.wh.auth.bean.WParams;
import com.afollestad.materialdialogs.MaterialDialog;
import com.lantern.auth.openapi.LoginInfo;
import com.lantern.auth.openapi.SMSInfo;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.groupchat.dao.GroupModifyResultVo;
import com.zenmen.palmchat.settings.pr.PrAuthenActivity;
import com.zenmen.palmchat.utils.captcha.CaptchaManager;
import com.zenmen.palmchat.utils.captcha.CaptchaResult;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class w4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static MaterialDialog f21604a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f21605a;

        public a(Runnable runnable) {
            this.f21605a = runnable;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            this.f21605a.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21606a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Dialog d;

        public b(Activity activity, boolean z, int i, Dialog dialog) {
            this.f21606a = activity;
            this.b = z;
            this.c = i;
            this.d = dialog;
        }

        @Override // java.lang.Runnable
        public void run() {
            Dialog dialog;
            Activity activity = this.f21606a;
            if (activity != null) {
                if (!hx3.m(activity)) {
                    w4.H(this.f21606a, this.c, this.b);
                    return;
                }
                ArrayList<String> arrayListT = w4.t(com.zenmen.palmchat.c.b());
                boolean z = false;
                if (arrayListT != null && (arrayListT.size() != 1 || !com.zenmen.palmchat.c.b().getPackageName().equals(arrayListT.get(0)))) {
                    z = true;
                }
                LogUtil.d("AccountPrAuthenManager", "AccountPrAuthenManager checkPrAuthen perInstall " + z);
                if (!z) {
                    w4.H(this.f21606a, this.c, this.b);
                    return;
                }
                boolean zK = w4.k(arrayListT);
                LogUtil.d("AccountPrAuthenManager", "AccountPrAuthenManager checkPrAuthen authInstall " + zK + " isPrAuthen " + this.b);
                if (zK || this.b) {
                    w4.H(this.f21606a, this.c, this.b);
                    return;
                }
                w4.E(this.f21606a);
                if (this.c != 1 || (dialog = this.d) == null) {
                    return;
                }
                dialog.dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21607a;

        public c(Activity activity) {
            this.f21607a = activity;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            LogUtil.d("AccountPrAuthenManager", "AccountPrAuthenManager showNotInstallDialog onNegative ");
            w4.f21604a.dismiss();
            w4.f21604a = null;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            LogUtil.d("AccountPrAuthenManager", "AccountPrAuthenManager showNotInstallDialog onPositive ");
            w4.f21604a.dismiss();
            w4.f21604a = null;
            w4.F(this.f21607a);
            w4.p("Accountset_PRCauthentication");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f21608a;

        public d(FragmentActivity fragmentActivity) {
            this.f21608a = fragmentActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f21608a != null) {
                ArrayList<String> arrayListT = w4.t(com.zenmen.palmchat.c.b());
                boolean z = false;
                if (arrayListT != null && (arrayListT.size() != 1 || !com.zenmen.palmchat.c.b().getPackageName().equals(arrayListT.get(0)))) {
                    z = true;
                }
                LogUtil.d("AccountPrAuthenManager", "loginPrClick checkPrAuthen perInstall " + z);
                if (!z) {
                    w4.G(this.f21608a);
                } else if (!w4.k(arrayListT)) {
                    w4.E(this.f21608a);
                } else {
                    LogUtil.d("AccountPrAuthenManager", "loginPrClick checkPrAuthen app 已经安装");
                    w4.G(this.f21608a);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements OnCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21609a;
        public final /* synthetic */ Activity b;

        public e(String str, Activity activity) {
            this.f21609a = str;
            this.b = activity;
        }

        @Override // cn.wh.auth.OnCallBack
        public void onResult(Result result) {
            String resultCode = result.getResultCode();
            LogUtil.d("AccountPrAuthenManager", "loginPrClick startLoginAuthApp onResult resultCode " + resultCode + " resultDesc " + result.getResultDesc());
            if (!"C0000000".equals(resultCode)) {
                w4.l();
                if ("C0412002".equals(resultCode)) {
                    w4.E(this.b);
                    return;
                }
                return;
            }
            String idCardAuthData = result.getResultData().getIdCardAuthData();
            String certPwdData = result.getResultData().getCertPwdData();
            LogUtil.d("AccountPrAuthenManager", "loginPrClick startLoginAuthApp onResult idCardAuthData " + idCardAuthData + " certPwdData " + certPwdData);
            if (TextUtils.isEmpty(idCardAuthData) || TextUtils.isEmpty(certPwdData)) {
                w4.l();
            } else {
                w4.A(this.f21609a, certPwdData, idCardAuthData, this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends go2<LXBaseNetBean<JSONObject>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21610a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public f(String str, String str2, String str3) {
            this.f21610a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            sw4 sw4VarA = mh.a(nl0.n + "/one/ax/auth.login.by.nnc.pre");
            sw4VarA.f20862a.put("bizSeq", this.f21610a);
            sw4VarA.f20862a.put("certPwdData", this.b);
            sw4VarA.f20862a.put("idCardAuthData", this.c);
            return sw4VarA;
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [T, org.json.JSONObject] */
        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<JSONObject> lXBaseNetBean, Exception exc) {
            ds0.a().b(new x4(x4.g));
            LogUtil.i("AccountPrAuthenManager", "loginPrClick postAuthen info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean == null) {
                w4.l();
                return;
            }
            int i = lXBaseNetBean.resultCode;
            if (i == -11) {
                LogUtil.i("AccountPrAuthenManager", "loginPrClick postLoginAuthen 认证成功但手机号未绑定，开始绑定手机号");
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("bizSeq", this.f21610a);
                    jSONObject.put("certPwData", this.b);
                    jSONObject.put("idCardAuthData", this.c);
                    w4.n(jSONObject);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            if (i == -10) {
                LogUtil.i("AccountPrAuthenManager", "loginPrClick postLoginAuthen 服务端返回失败");
                w4.l();
            } else if (i != 201) {
                LogUtil.i("AccountPrAuthenManager", "loginPrClick postLoginAuthen 认证成功且手机号有，直接登录");
                if (lXBaseNetBean.originData != null) {
                    LXBaseNetBean lXBaseNetBean2 = new LXBaseNetBean();
                    lXBaseNetBean2.data = lXBaseNetBean.originData.optJSONObject("data");
                    lXBaseNetBean2.resultCode = lXBaseNetBean.resultCode;
                    w4.m(lXBaseNetBean2);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements nx4<LXBaseNetBean<JSONObject>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21611a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ nx4 d;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements CaptchaManager.a {
            public a() {
            }

            @Override // com.zenmen.palmchat.utils.captcha.CaptchaManager.a
            public void a(int i, CaptchaResult captchaResult) {
                if (captchaResult != null) {
                    g gVar = g.this;
                    na3.a(w4.u(gVar.c, gVar.b), captchaResult, g.this.d);
                }
            }
        }

        public g(Activity activity, String str, String str2, nx4 nx4Var) {
            this.f21611a = activity;
            this.b = str;
            this.c = str2;
            this.d = nx4Var;
        }

        @Override // defpackage.nx4
        public void a(LXBaseNetBean<JSONObject> lXBaseNetBean) {
            if (lXBaseNetBean != null && nz.c(lXBaseNetBean.resultCode)) {
                CaptchaManager.c(this.f21611a, new mz(lXBaseNetBean.data, null, this.b, true), new a());
                return;
            }
            nx4 nx4Var = this.d;
            if (nx4Var != null) {
                nx4Var.a(lXBaseNetBean);
            }
        }
    }

    public static void A(String str, String str2, String str3, Activity activity) {
        LogUtil.i("AccountPrAuthenManager", "loginPrClick postLoginAuthen start ");
        ds0.a().b(new x4(x4.h));
        zw4.e(new f(str, str2, str3));
    }

    public static void B(Activity activity, int i, Dialog dialog, boolean z) {
        D(activity, z, new b(activity, z, i, dialog));
    }

    public static void C(Activity activity, GroupModifyResultVo groupModifyResultVo, al4 al4Var) {
        LogUtil.d("AccountPrAuthenManager", "AccountPrAuthenManager realNameDialog start activity " + activity + " result " + groupModifyResultVo);
        if (activity != null) {
            new cl4(activity, groupModifyResultVo, al4Var).show();
        }
    }

    public static void D(Activity activity, boolean z, Runnable runnable) {
        if (z) {
            runnable.run();
        } else {
            new sd3(activity).U("温馨提示").k("您即将离开连信APP，跳转至国家网络身份认证APP进行身份认证").P("确定").L("取消").f(new a(runnable)).h(true).e().show();
        }
    }

    public static void E(Activity activity) {
        LogUtil.i("AccountPrAuthenManager", "loginPrClick showNotInstallDialog activity " + activity);
        if (activity == null || activity.isFinishing()) {
            LogUtil.d("AccountPrAuthenManager", "AccountPrAuthenManager showNotInstallDialog activity error ");
            return;
        }
        LogUtil.d("AccountPrAuthenManager", "AccountPrAuthenManager showNotInstallDialog start ");
        MaterialDialog materialDialog = f21604a;
        if (materialDialog != null && materialDialog.isShowing()) {
            f21604a.dismiss();
        }
        f21604a = null;
        MaterialDialog materialDialogE = new sd3(activity).h(false).k("你还未安装《国家网络身份认证》APP，即将离开连信APP，前往应用市场下载").P("确认").L("取消").f(new c(activity)).e();
        f21604a = materialDialogE;
        materialDialogE.show();
    }

    public static void F(Activity activity) {
        LogUtil.d("AccountPrAuthenManager", "AccountPrAuthenManager startDownAuthApp start 开始跳转到应用市场 ");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=cn.cyberIdentity.certification"));
            intent.addFlags(268435456);
            activity.startActivity(intent);
        } catch (Exception unused) {
            z(activity, "https://cdnrefresh.ctdidcii.cn/w1/WHClient_H5/Install/UL.html");
        }
    }

    public static void G(Activity activity) {
        LogUtil.i("AccountPrAuthenManager", "loginPrClick startLoginAuthApp start ");
        String strO = o();
        new WAuthService(activity, new WParams("00000304", "0001", strO, 1, "")).getAuthResult(new e(strO, activity));
        LogUtil.d("AccountPrAuthenManager", "startAuthApp start app");
    }

    public static void H(Activity activity, int i, boolean z) {
        try {
            Intent intent = new Intent(activity, (Class<?>) PrAuthenActivity.class);
            intent.putExtra("authen_from", i);
            intent.putExtra("authen_status", z);
            activity.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static boolean k(ArrayList<String> arrayList) {
        return arrayList != null && arrayList.size() > 0 && arrayList.contains("cn.cyberIdentity.certification");
    }

    public static void l() {
        LogUtil.i("AccountPrAuthenManager", "loginPrClick authLoginFailed end ");
        Toast.makeText(AppContext.getContext(), "授权登录失败", 0).show();
    }

    public static void m(LXBaseNetBean<JSONObject> lXBaseNetBean) {
        x4 x4Var = new x4(x4.f);
        x4Var.d = lXBaseNetBean;
        ds0.a().b(x4Var);
    }

    public static void n(JSONObject jSONObject) {
        x4 x4Var = new x4(x4.i);
        x4Var.c = jSONObject;
        ds0.a().b(x4Var);
    }

    public static String o() {
        return rb3.c(Long.toString(System.currentTimeMillis()) + UUID.randomUUID());
    }

    public static void p(String str) {
        zn6.d(str, null, new JSONObject().toString());
    }

    public static void q() {
        zn6.d("lx_client_bindphonenumber", null, new JSONObject().toString());
    }

    public static void r() {
        zn6.d("lx_client_bindphonenumber_nextclick", null, new JSONObject().toString());
    }

    public static void s() {
        zn6.d("lx_client_login_clickPRC", null, new JSONObject().toString());
    }

    public static ArrayList<String> t(Context context) {
        if (!w("android.permission.QUERY_ALL_PACKAGES", context)) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(128)) {
                int i = packageInfo.applicationInfo.flags;
                if ((i & 128) != 0 || (i & 1) == 0) {
                    arrayList.add(packageInfo.packageName);
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static SMSInfo u(String str, String str2) {
        SMSInfo sMSInfo = new SMSInfo();
        sMSInfo.countryCode = str;
        sMSInfo.phoneNum = str2;
        sMSInfo.scope = "BASE,USERINFO,PUSH,MOBILE";
        sMSInfo.typeLength = String.valueOf(cl6.f());
        sMSInfo.isPrLogin = true;
        return sMSInfo;
    }

    public static void v(Activity activity, String str, String str2, nx4<LXBaseNetBean<JSONObject>> nx4Var) {
        na3.a(u(str, str2), null, new g(activity, str2, str, nx4Var));
    }

    public static boolean w(String str, Context context) {
        return Build.VERSION.SDK_INT < 23 || context == null || context.checkSelfPermission(str) == 0;
    }

    public static void x(String str, String str2, String str3, String str4, String str5, String str6, nx4<LXBaseNetBean<JSONObject>> nx4Var) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.smsCode = str3;
        loginInfo.countryCode = str;
        loginInfo.phoneNum = str2;
        loginInfo.scope = "BASE,USERINFO,PUSH,MOBILE";
        loginInfo.isPrLogin = true;
        loginInfo.bizSeq = str4;
        loginInfo.idCardAuthData = str6;
        loginInfo.certPwData = str5;
        na3.b(loginInfo, nx4Var);
    }

    public static void y(FragmentActivity fragmentActivity) {
        LogUtil.i("AccountPrAuthenManager", "loginPrClick AccountPrAuthenManager activity " + fragmentActivity);
        D(fragmentActivity, false, new d(fragmentActivity));
    }

    public static void z(Context context, String str) {
        try {
            LogUtil.d("AccountPrAuthenManager", "AccountPrAuthenManager openCordovaWebActivity start url " + str);
            Intent intent = new Intent();
            intent.setClass(context, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", str);
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }
}
