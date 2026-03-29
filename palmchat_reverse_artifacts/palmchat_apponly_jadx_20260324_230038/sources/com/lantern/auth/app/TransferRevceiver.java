package com.lantern.auth.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.lantern.auth.provider.ClientLoginManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TransferRevceiver {
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.lantern.auth.app.TransferRevceiver.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                ClientLoginManager.funDC(FunDC.ID_AUTH_1086, "fail", TransferRevceiver.this.mSid);
                return;
            }
            String str = action.equals(ClientLoginManager.WK_LOGIN_GET_CODE_ACTION) ? "code" : action.equals(ClientLoginManager.WK_LOGIN_GET_CODE_MOBILE) ? "mobile" : "";
            intent.setAction(action + ".sub");
            context.sendBroadcast(intent);
            ClientLoginManager.funDC(FunDC.ID_AUTH_1087, str, TransferRevceiver.this.mSid);
        }
    };
    private String mSid;

    public void registTransferReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter(ClientLoginManager.WK_LOGIN_GET_CODE_MOBILE);
        intentFilter.addAction(ClientLoginManager.WK_LOGIN_GET_CODE_ACTION);
        context.getApplicationContext().registerReceiver(this.mReceiver, intentFilter);
    }

    public void updateSid(String str) {
        this.mSid = str;
    }
}
