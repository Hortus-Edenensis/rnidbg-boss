package org.apache.cordova.jssdk.general;

import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ds0;
import defpackage.fg6;
import defpackage.lb3;
import defpackage.v93;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class VipPlugin extends SubPlugin {
    private static final int PAY_FAILED = 3;
    private static final int PAY_SUCCESS_IS_NOT_VIP = 2;
    private static final int PAY_SUCCESS_IS_VIP = 1;
    private int retryCheckCount = 0;
    private String scene;

    private void checkVipStatus() {
        fg6.k(this.mCordovaInterface.getActivity().getApplicationContext(), new fg6.b() { // from class: org.apache.cordova.jssdk.general.VipPlugin.1
            @Override // fg6.b
            public void onFail(Exception exc) {
                LogUtil.e("getVip", "error=" + exc.getMessage());
                VipPlugin.this.retryCheckVipStatus();
            }

            @Override // fg6.b
            public void onSuccess(int i) {
                if (i < 0) {
                    VipPlugin.this.retryCheckVipStatus();
                } else {
                    ds0.a().b(new lb3(1, VipPlugin.this.scene));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryCheckVipStatus() {
        int i = this.retryCheckCount + 1;
        this.retryCheckCount = i;
        if (i <= 5) {
            checkVipStatus();
        } else {
            ds0.a().b(new lb3(2, this.scene));
        }
    }

    @Override // defpackage.ib3
    public void exec(String str, JSONObject jSONObject, v93 v93Var) {
        if (Action.ACTION_CHECK_VIP_STATUS.equals(str)) {
            this.scene = jSONObject.optString("scene");
            checkVipStatus();
            v93Var.a(makeDefaultSucMsg());
            jSONObject.has("from");
        }
    }
}
