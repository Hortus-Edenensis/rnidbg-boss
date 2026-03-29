package defpackage;

import com.lantern.auth.app.WkConstants;
import com.lantern.auth.openapi.SMSInfo;
import com.lantern.auth.server.WkParams;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.utils.captcha.CaptchaResult;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class o92 extends b73<LXBaseNetBean<JSONObject>> {
    public SMSInfo c;
    public CaptchaResult d;

    public o92(SMSInfo sMSInfo, CaptchaResult captchaResult) {
        this.c = sMSInfo;
        this.d = captchaResult;
        if (sMSInfo.isPrLogin) {
            this.b = nl0.n + WkConstants.LxLoginConst.API_PR_LOGIN_SMS;
            return;
        }
        this.b = nl0.n + WkConstants.LxLoginConst.API_SEND_SMS;
    }

    @Override // defpackage.b73
    public LXBaseNetBean a(LXBaseNetBean lXBaseNetBean) {
        return lXBaseNetBean == null ? new LXBaseNetBean() : lXBaseNetBean;
    }

    @Override // defpackage.ho2
    public sw4 getRequestArgs() {
        sw4 sw4VarA = mh.a(this.b + "?requestId=" + this.f1660a);
        sw4VarA.f20862a.put("mobile", this.c.phoneNum);
        sw4VarA.f20862a.put(WkParams.COUNTRYCODE, this.c.countryCode);
        nz.a(sw4VarA.f20862a, this.d);
        sw4VarA.f20862a.put("paramNum", Integer.valueOf(cl6.f()));
        return sw4VarA;
    }
}
