package defpackage;

import android.text.TextUtils;
import com.lantern.auth.app.WkConstants;
import com.lantern.auth.openapi.LoginInfo;
import com.lantern.auth.openapi.SMSInfo;
import com.lantern.auth.server.WkParams;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ui0 extends b73<LXBaseNetBean<JSONObject>> {
    public SMSInfo c;
    public boolean d;
    public String e;
    public String f;
    public String g;

    public ui0(LoginInfo loginInfo) {
        this.c = loginInfo;
        boolean z = loginInfo.isPrLogin;
        this.d = z;
        if (!z) {
            this.b = nl0.n + WkConstants.LxLoginConst.API_COMMIT_SMS;
            return;
        }
        this.b = nl0.n + WkConstants.LxLoginConst.API_PR_LOGIN_COMMIT;
        this.e = loginInfo.bizSeq;
        this.f = loginInfo.certPwData;
        this.g = loginInfo.idCardAuthData;
    }

    @Override // defpackage.b73
    public LXBaseNetBean<JSONObject> a(LXBaseNetBean<JSONObject> lXBaseNetBean) {
        return lXBaseNetBean == null ? new LXBaseNetBean<>() : lXBaseNetBean;
    }

    @Override // defpackage.ho2
    public sw4 getRequestArgs() {
        sw4 sw4VarA = mh.a(this.b + "?requestId=" + this.f1660a);
        sw4VarA.f20862a.put("mobile", this.c.phoneNum);
        sw4VarA.f20862a.put(WkParams.COUNTRYCODE, this.c.countryCode);
        sw4VarA.f20862a.put("verifyCode", ((LoginInfo) this.c).smsCode);
        if (this.d) {
            if (!TextUtils.isEmpty(this.e)) {
                sw4VarA.f20862a.put("bizSeq", this.e);
            }
            if (!TextUtils.isEmpty(this.f)) {
                sw4VarA.f20862a.put("certPwdData", this.f);
            }
            if (!TextUtils.isEmpty(this.g)) {
                sw4VarA.f20862a.put("idCardAuthData", this.g);
            }
        }
        return sw4VarA;
    }
}
