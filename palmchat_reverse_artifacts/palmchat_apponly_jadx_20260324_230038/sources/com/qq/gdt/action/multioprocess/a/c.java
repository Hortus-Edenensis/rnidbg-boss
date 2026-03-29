package com.qq.gdt.action.multioprocess.a;

import android.content.Context;
import android.text.TextUtils;
import com.qq.gdt.action.d;
import com.qq.gdt.action.j.o;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c implements b {
    @Override // com.qq.gdt.action.multioprocess.a.b
    public String a() {
        String str = null;
        try {
            o.a("ReadConfigChannelId execute", new Object[0]);
            Context contextG = d.a().g();
            if (contextG == null) {
                o.a("ReadConfigChannelId context  is null", new Object[0]);
                com.qq.gdt.action.h.a.a(41039);
                return null;
            }
            String str2 = contextG.getPackageManager().getApplicationInfo(contextG.getPackageName(), 128).metaData.get("gdt_action_channel_id") + "";
            try {
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
                com.qq.gdt.action.h.a.a(41040);
                return null;
            } catch (Throwable th) {
                th = th;
                str = str2;
                o.a("ReadConfigChannelId", th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
