package cn.wh.auth;

import android.app.Activity;
import cn.wh.auth.bean.WParams;
import com.fort.andJni.JniLib1716343241;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class WAuthService extends WAuth {
    private int flag;

    public WAuthService(Activity activity, WParams wParams) {
        super(activity, wParams);
        this.flag = -1;
    }

    private void callback() {
        JniLib1716343241.cV(this, 7);
    }

    public static String getVersion() {
        return (String) JniLib1716343241.cL(8);
    }

    @Deprecated
    public void getAuthFromIntent() {
        JniLib1716343241.cV(this, 6);
    }

    @Override // cn.wh.auth.WAuth, cn.wh.auth.AuthService
    public void getAuthResult(OnCallBack onCallBack) {
        super.getAuthResult(onCallBack);
    }

    public WAuthService setIntentFlag(int i) {
        this.flag = i;
        return this;
    }
}
