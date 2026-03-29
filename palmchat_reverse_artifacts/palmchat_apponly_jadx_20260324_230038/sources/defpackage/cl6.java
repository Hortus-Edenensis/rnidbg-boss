package defpackage;

import android.app.Activity;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.onekey.prelogin.PreLoginResult;
import com.lantern.auth.openapi.LoginInfo;
import com.lantern.auth.openapi.OAuthApi;
import com.lantern.auth.openapi.SMSInfo;
import com.lantern.auth.openapi.WkOAuthConst;
import com.lantern.auth.util.report.AuthReport;
import com.lantern.auth.util.report.OneKeyReportInfo;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.utils.captcha.CaptchaManager;
import com.zenmen.palmchat.utils.captcha.CaptchaResult;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class cl6 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements BLCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f2011a;
        public final /* synthetic */ PreLoginResult b;
        public final /* synthetic */ BLCallback c;

        /* JADX INFO: renamed from: cl6$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0032a implements CaptchaManager.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PreLoginResult f2012a;

            public C0032a(PreLoginResult preLoginResult) {
                this.f2012a = preLoginResult;
            }

            @Override // com.zenmen.palmchat.utils.captcha.CaptchaManager.a
            public void a(int i, CaptchaResult captchaResult) {
                if (captchaResult != null) {
                    OneKeyReportInfo oneKeyReportInfo = new OneKeyReportInfo();
                    oneKeyReportInfo.mLoginType = a.this.b.mLoginType;
                    oneKeyReportInfo.mSid = UUID.randomUUID().toString();
                    oneKeyReportInfo.mScene = a.this.b.mFromSource;
                    AuthReport.doOnekeyEvent(oneKeyReportInfo, 9);
                    fm0.g(a.this.c, this.f2012a, oneKeyReportInfo, captchaResult);
                }
            }
        }

        public a(Activity activity, PreLoginResult preLoginResult, BLCallback bLCallback) {
            this.f2011a = activity;
            this.b = preLoginResult;
            this.c = bLCallback;
        }

        @Override // com.lantern.auth.core.BLCallback
        public void run(int i, String str, Object obj) {
            if (!(obj instanceof PreLoginResult)) {
                this.c.run(i, str, obj);
                return;
            }
            PreLoginResult preLoginResult = (PreLoginResult) obj;
            LXBaseNetBean<JSONObject> lXBaseNetBean = preLoginResult.loginResult;
            if (lXBaseNetBean == null || !nz.c(lXBaseNetBean.resultCode)) {
                this.c.run(i, str, obj);
            } else {
                CaptchaManager.c(this.f2011a, new mz(preLoginResult.loginResult.data, null, null, true), new C0032a(preLoginResult));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements nx4<LXBaseNetBean<JSONObject>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f2013a;
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
                    SMSInfo sMSInfo = new SMSInfo();
                    b bVar = b.this;
                    sMSInfo.countryCode = bVar.c;
                    sMSInfo.phoneNum = bVar.b;
                    sMSInfo.scope = "BASE,USERINFO,PUSH,MOBILE";
                    sMSInfo.typeLength = String.valueOf(cl6.f());
                    na3.a(sMSInfo, captchaResult, b.this.d);
                }
            }
        }

        public b(Activity activity, String str, String str2, nx4 nx4Var) {
            this.f2013a = activity;
            this.b = str;
            this.c = str2;
            this.d = nx4Var;
        }

        @Override // defpackage.nx4
        public void a(LXBaseNetBean<JSONObject> lXBaseNetBean) {
            if (lXBaseNetBean == null || !nz.c(lXBaseNetBean.resultCode)) {
                this.d.a(lXBaseNetBean);
            } else {
                CaptchaManager.c(this.f2013a, new mz(lXBaseNetBean.data, null, this.b, true), new a());
            }
        }
    }

    public static void a(Activity activity, PreLoginResult preLoginResult, BLCallback bLCallback) {
        a aVar = new a(activity, preLoginResult, bLCallback);
        OneKeyReportInfo oneKeyReportInfo = new OneKeyReportInfo();
        oneKeyReportInfo.mLoginType = preLoginResult.mLoginType;
        oneKeyReportInfo.mSid = UUID.randomUUID().toString();
        oneKeyReportInfo.mScene = preLoginResult.mFromSource;
        AuthReport.doOnekeyEvent(oneKeyReportInfo, 9);
        fm0.g(aVar, preLoginResult, oneKeyReportInfo, null);
    }

    public static void b(BLCallback bLCallback) {
        OAuthApi.preLogin(bLCallback);
    }

    public static void c(String str, String str2, BLCallback bLCallback) {
        SMSInfo sMSInfo = new SMSInfo();
        if (e73.q()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bizType", "new");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            sMSInfo.ext = jSONObject.toString();
        }
        sMSInfo.countryCode = str;
        sMSInfo.phoneNum = str2;
        sMSInfo.scope = "BASE,USERINFO,PUSH,MOBILE";
        sMSInfo.typeLength = String.valueOf(f());
        OAuthApi.getSMSCode(sMSInfo, bLCallback);
    }

    public static void d(BLCallback bLCallback) {
        OAuthApi.getSimpleProfile(e73.o() ? 3000L : 2000L, bLCallback);
    }

    public static void e(Activity activity, String str, String str2, nx4<LXBaseNetBean<JSONObject>> nx4Var) {
        b bVar = new b(activity, str2, str, nx4Var);
        SMSInfo sMSInfo = new SMSInfo();
        sMSInfo.countryCode = str;
        sMSInfo.phoneNum = str2;
        sMSInfo.scope = "BASE,USERINFO,PUSH,MOBILE";
        sMSInfo.typeLength = String.valueOf(f());
        na3.a(sMSInfo, null, bVar);
    }

    public static int f() {
        return AppContext.getContext().getResources().getInteger(R.integer.login_sms_verify_count);
    }

    public static void g(BLCallback bLCallback) {
        OAuthApi.getLoginCode(5000L, "BASE,USERINFO,PUSH,MOBILE", bLCallback);
    }

    public static boolean h() {
        return OAuthApi.getAutoLoginType(WkOAuthConst.ENTRANCE_AUTO) != 2;
    }

    public static boolean i() {
        return OAuthApi.isWkAppInstalled();
    }

    public static void j(String str, String str2, String str3, BLCallback bLCallback) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.smsCode = str3;
        loginInfo.countryCode = str;
        loginInfo.phoneNum = str2;
        loginInfo.scope = "BASE,USERINFO,PUSH,MOBILE";
        OAuthApi.loginBySMSCode(loginInfo, bLCallback);
    }

    public static void k(String str, String str2, String str3, nx4<LXBaseNetBean<JSONObject>> nx4Var) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.smsCode = str3;
        loginInfo.countryCode = str;
        loginInfo.phoneNum = str2;
        loginInfo.scope = "BASE,USERINFO,PUSH,MOBILE";
        na3.b(loginInfo, nx4Var);
    }

    public static void l() {
        OAuthApi.setPermissions(3);
    }
}
