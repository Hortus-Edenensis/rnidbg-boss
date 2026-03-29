package cn.wh.auth;

import android.app.Activity;
import android.content.Intent;
import cn.wh.auth.bean.Result;
import cn.wh.auth.bean.WParams;
import cn.wh.auth.server.ResultRequestService;
import com.fort.andJni.JniLib1716343241;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class WAuth implements AuthService {
    final Intent intent;
    Activity mAtivity;
    OnCallBack mOnCallBack;
    final Result result;
    WParams wParams;

    /* JADX INFO: renamed from: cn.wh.auth.WAuth$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements ResultRequestService.Callback {
        final /* synthetic */ WAuth this$0;

        public AnonymousClass1(WAuth wAuth) {
            JniLib1716343241.cV(this, wAuth, 1);
        }

        @Override // cn.wh.auth.server.ResultRequestService.Callback
        public void onActivityResult(int i, int i2, Intent intent) {
            JniLib1716343241.cV(this, Integer.valueOf(i), Integer.valueOf(i2), intent, 0);
        }
    }

    public WAuth(Activity activity, WParams wParams) {
        JniLib1716343241.cV(this, activity, wParams, 4);
    }

    private void init() {
        JniLib1716343241.cV(this, 5);
    }

    @Override // cn.wh.auth.AuthService
    public void getAuthResult(OnCallBack onCallBack) {
        JniLib1716343241.cV(this, onCallBack, 2);
    }

    public String getPackageName() {
        return (String) JniLib1716343241.cL(this, 3);
    }
}
