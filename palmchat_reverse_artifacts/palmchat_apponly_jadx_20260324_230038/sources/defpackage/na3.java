package defpackage;

import com.lantern.auth.openapi.LoginInfo;
import com.lantern.auth.openapi.SMSInfo;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.utils.captcha.CaptchaResult;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class na3 {
    public static void a(SMSInfo sMSInfo, CaptchaResult captchaResult, nx4<LXBaseNetBean<JSONObject>> nx4Var) {
        u63.e(new o92(sMSInfo, captchaResult), nx4Var);
    }

    public static void b(LoginInfo loginInfo, nx4<LXBaseNetBean<JSONObject>> nx4Var) {
        u63.e(new ui0(loginInfo), nx4Var);
    }
}
