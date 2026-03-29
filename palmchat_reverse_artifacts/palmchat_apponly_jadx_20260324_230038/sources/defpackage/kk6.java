package defpackage;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.zenmen.openapi.webapp.WebAppManager;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class kk6 extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public za3 f18714a;

    @Override // defpackage.zn2
    public void a(String str, za3 za3Var) {
        if (!so6.a().c()) {
            sy5.f(c.b(), "未安装微信", 0).g();
            za3Var.onPayBack(-2, "未安装微信", null);
        } else if (so6.a().b().getWXAppSupportAPI() >= 570425345) {
            c(str, za3Var);
        } else {
            sy5.f(c.b(), "微信版本过低,请升级后支付", 0).g();
            za3Var.onPayBack(-2, "微信版本过低,请升级后支付", null);
        }
    }

    public final void c(String str, za3 za3Var) {
        this.f18714a = za3Var;
        try {
            JSONObject jSONObject = new JSONObject(str);
            LogUtil.d("WechatPay", "origin data:" + str);
            PayReq payReq = new PayReq();
            payReq.appId = jSONObject.optString("appid", "");
            payReq.partnerId = jSONObject.optString("partnerId", "");
            payReq.prepayId = jSONObject.optString("prepayId", "");
            payReq.packageValue = jSONObject.optString("package", "");
            payReq.nonceStr = jSONObject.optString("nonceStr", "");
            payReq.timeStamp = jSONObject.optString("timestamp", "");
            String strOptString = jSONObject.optString("sign", "");
            payReq.sign = strOptString;
            LogUtil.d("WechatPay", String.format("build wechatpay req appId:%s partnerId:%s prepayId:%s packageValue:%s nonceStr:%s timeStamp:%s sign:%s", payReq.appId, payReq.partnerId, payReq.prepayId, payReq.packageValue, payReq.nonceStr, payReq.timeStamp, strOptString));
            WebAppManager.getInstance().setPayFromSdp(false);
            d();
            if (so6.a().b().sendReq(payReq)) {
                return;
            }
            za3Var.onPayBack(-2, "订单信息错误", null);
            e();
        } catch (Exception e) {
            e.printStackTrace();
            za3Var.onPayBack(-2, "订单信息错误", null);
        }
    }

    public final void d() {
        try {
            an1.c().p(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void e() {
        try {
            an1.c().r(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void receivePayResult(BaseResp baseResp) {
        e();
        int i = baseResp.errCode;
        int i2 = 0;
        if (i != 0) {
            if (i == -1) {
                i2 = -2;
            } else if (i == -2) {
                i2 = -3;
            }
        }
        this.f18714a.onPayBack(i2, b(i2), null);
    }

    @Override // defpackage.t0, defpackage.zn2
    public void release() {
        e();
    }
}
