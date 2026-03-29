package com.opos.cmn.lockscreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import com.opos.cmn.an.transactivity.api.TransActivity;
import com.opos.cmn.an.transactivity.api.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    public static void a(Context context, b bVar, ResultReceiver resultReceiver) {
        try {
            if (bVar == null) {
                com.opos.cmn.an.f.a.b("TransActivityTool", "startTransActivity failed, transLifeCallback cannot be null");
                return;
            }
            Intent intent = new Intent(context, (Class<?>) TransActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            intent.putExtra("extra_key_trans_life_callback", bVar);
            intent.putExtra("extra_key_extra_callback", resultReceiver);
            context.startActivity(intent);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("TransActivityTool", "startTransActivity failed", e);
        }
    }
}
