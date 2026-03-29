package com.opos.mobad.cmn.service.pkginstall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class SystemBR extends BroadcastReceiver {
    private static final long SEND_PACKAGE_ADDED_OR_REMOVED_MSG_DELAY_TIME = 500;
    private static final Handler SYSTEM_BR_HANDLER = new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.cmn.service.pkginstall.SystemBR.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    int i = message.what;
                    if (i == 0 || 1 == i || 2 == i) {
                        d.a().a(message.what, (String) message.obj);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a(SystemBR.TAG, "", (Throwable) e);
                }
            }
        }
    };
    private static final String TAG = "SystemBR";

    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        byte b;
        if (intent != null) {
            try {
                com.opos.cmn.an.f.a.b(TAG, "onReceive intent=" + intent);
                String action = intent.getAction();
                com.opos.cmn.an.f.a.b(TAG, "action=" + action);
                if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    Handler handler = SYSTEM_BR_HANDLER;
                    Message messageObtainMessage = handler.obtainMessage();
                    String strSubstring = intent.getDataString().substring(8);
                    messageObtainMessage.obj = strSubstring;
                    int iHashCode = action.hashCode();
                    if (iHashCode != -810471698) {
                        if (iHashCode != 525384130) {
                            b = (iHashCode == 1544582882 && action.equals("android.intent.action.PACKAGE_ADDED")) ? (byte) 0 : (byte) -1;
                        } else if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                            b = 2;
                        }
                    } else if (action.equals("android.intent.action.PACKAGE_REPLACED")) {
                        b = 1;
                    }
                    if (b == 0) {
                        com.opos.cmn.an.f.a.b(TAG, "ACTION_PACKAGE_ADDED pkgName=" + strSubstring);
                        messageObtainMessage.what = 0;
                    } else {
                        if (b == 1) {
                            com.opos.cmn.an.f.a.b(TAG, "ACTION_PACKAGE_REPLACED pkgName=" + strSubstring);
                            messageObtainMessage.what = 1;
                            if (handler.hasMessages(0)) {
                                handler.removeMessages(0);
                            }
                            if (handler.hasMessages(2)) {
                                handler.removeMessages(2);
                            }
                            handler.sendMessage(messageObtainMessage);
                            return;
                        }
                        if (b != 2) {
                            return;
                        }
                        com.opos.cmn.an.f.a.b(TAG, "ACTION_PACKAGE_REMOVED pkgName=" + strSubstring);
                        messageObtainMessage.what = 2;
                    }
                    handler.sendMessageDelayed(messageObtainMessage, 500L);
                }
            } catch (Exception e) {
                try {
                    com.opos.cmn.an.f.a.a(TAG, "", (Throwable) e);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a(TAG, "", (Throwable) e2);
                }
            }
        }
    }
}
