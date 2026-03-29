package defpackage;

import com.lantern.auth.app.WkConstants;
import com.lantern.auth.onekey.helper.OneKeyHelper;
import com.lantern.auth.onekey.prelogin.PreLoginResult;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.utils.captcha.CaptchaResult;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class em0 extends b73<LXBaseNetBean<JSONObject>> {
    public PreLoginResult c;
    public CaptchaResult d;
    public OneKeyHelper e;

    public em0(PreLoginResult preLoginResult, CaptchaResult captchaResult, OneKeyHelper oneKeyHelper) {
        this.c = preLoginResult;
        this.d = captchaResult;
        this.e = oneKeyHelper;
        this.b = nl0.n + WkConstants.LxLoginConst.API_AUTH_AUTO;
    }

    @Override // defpackage.b73
    public LXBaseNetBean<JSONObject> a(LXBaseNetBean<JSONObject> lXBaseNetBean) {
        return lXBaseNetBean == null ? new LXBaseNetBean<>() : lXBaseNetBean;
    }

    @Override // defpackage.ho2
    public sw4 getRequestArgs() {
        sw4 sw4VarA = mh.a(this.b + "?requestId=" + this.f1660a);
        sw4VarA.f20862a.put("accessToken", this.c.mAccessToken);
        sw4VarA.f20862a.put("maskMobile", this.c.mMaskPhone);
        nz.a(sw4VarA.f20862a, this.d);
        int loginType = this.e.getLoginType();
        if (loginType == 1) {
            sw4VarA.f20862a.put("moveType", "cmcc");
        } else if (loginType == 4) {
            sw4VarA.f20862a.put("moveType", "unicomV2");
        } else if (loginType == 8) {
            sw4VarA.f20862a.put("moveType", "telecom");
            sw4VarA.f20862a.put("uniqueId", this.c.mUniqueId);
        } else if (loginType == 16) {
            sw4VarA.f20862a.put("moveType", "mob");
            sw4VarA.f20862a.put("token", this.c.mobToken);
            sw4VarA.f20862a.put("operator", this.c.operator);
        }
        sw4VarA.f20862a.put("clientId", this.e.getClientIdByType());
        return sw4VarA;
    }
}
