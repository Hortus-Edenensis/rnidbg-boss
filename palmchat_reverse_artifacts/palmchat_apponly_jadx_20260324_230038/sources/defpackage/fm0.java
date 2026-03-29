package defpackage;

import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.http.HttpPostManager;
import com.lantern.auth.onekey.HelperFactory;
import com.lantern.auth.onekey.helper.OneKeyHelper;
import com.lantern.auth.onekey.prelogin.PreLoginResult;
import com.lantern.auth.util.report.OneKeyReportInfo;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.loginnew.b;
import com.zenmen.palmchat.utils.captcha.CaptchaResult;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class fm0 extends u63 {
    public PreLoginResult c;
    public OneKeyReportInfo d;
    public CaptchaResult e;
    public BLCallback f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements BLCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f17554a;

        public a(CountDownLatch countDownLatch) {
            this.f17554a = countDownLatch;
        }

        @Override // com.lantern.auth.core.BLCallback
        public void run(int i, String str, Object obj) {
            if (obj instanceof PreLoginResult) {
                fm0.this.c = (PreLoginResult) obj;
            }
            this.f17554a.countDown();
        }
    }

    public fm0(BLCallback bLCallback, PreLoginResult preLoginResult, OneKeyReportInfo oneKeyReportInfo, CaptchaResult captchaResult) {
        super(null, null);
        this.f = bLCallback;
        this.c = preLoginResult;
        this.d = oneKeyReportInfo;
        this.e = captchaResult;
    }

    public static void g(BLCallback bLCallback, PreLoginResult preLoginResult, OneKeyReportInfo oneKeyReportInfo, CaptchaResult captchaResult) {
        new fm0(bLCallback, preLoginResult, oneKeyReportInfo, captchaResult).executeOnExecutor(HttpPostManager.getExecutorPool(), new Void[0]);
    }

    @Override // defpackage.u63, android.os.AsyncTask
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LXBaseNetBean<JSONObject> doInBackground(Void... voidArr) {
        OneKeyHelper oneKeyHelperCreateHelper = HelperFactory.createHelper(this.c.mLoginType, WkSDKManager.getContext());
        if (!this.c.isValid()) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            oneKeyHelperCreateHelper.retryAccessToken(new a(countDownLatch), this.d);
            try {
                countDownLatch.await(WkSDKManager.getSdkConfig().getCMCCTimeout(), TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                BLLog.e(e);
            }
        }
        y63.h("sdk_auto_suc");
        HashMap<String, Object> mapE = x63.e(b.u().s());
        if (this.c.isValid()) {
            mapE.put("result", 1);
            this.b = new em0(this.c, this.e, oneKeyHelperCreateHelper);
            this.c.loginResult = super.doInBackground(new Void[0]);
        } else {
            mapE.put("result", 0);
            this.c.loginResult = new LXBaseNetBean<>();
            this.c.mRetCode = 0;
        }
        LogUtil.uploadInfoImmediate("lx_client_quicklogin_resp", mapE);
        zn6.j("lx_client_quicklogin_resp", null, mapE);
        return this.c.loginResult;
    }

    @Override // defpackage.u63, android.os.AsyncTask
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(LXBaseNetBean<JSONObject> lXBaseNetBean) {
        BLCallback bLCallback = this.f;
        PreLoginResult preLoginResult = this.c;
        bLCallback.run(preLoginResult.mRetCode, null, preLoginResult);
    }
}
