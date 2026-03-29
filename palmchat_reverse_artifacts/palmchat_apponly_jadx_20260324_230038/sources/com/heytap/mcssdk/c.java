package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.mcssdk.utils.d;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c {
    public static void a(Context context, Intent intent, IDataMessageCallBackService iDataMessageCallBackService) {
        String str;
        if (context == null) {
            str = "context is null , please check param of parseIntent()";
        } else if (intent == null) {
            str = "intent is null , please check param of parseIntent()";
        } else if (iDataMessageCallBackService == null) {
            str = "callback is null , please check param of parseIntent()";
        } else {
            if (Utils.isSupportPushByClient(context)) {
                List<BaseMode> listA = com.heytap.mcssdk.e.c.a(context, intent);
                if (listA == null) {
                    return;
                }
                for (BaseMode baseMode : listA) {
                    if (baseMode != null) {
                        for (com.heytap.mcssdk.f.c cVar : PushService.getInstance().getProcessors()) {
                            if (cVar != null) {
                                cVar.a(context, baseMode, iDataMessageCallBackService);
                            }
                        }
                    }
                }
                return;
            }
            str = "push is null ,please check system has push";
        }
        d.e(str);
    }
}
