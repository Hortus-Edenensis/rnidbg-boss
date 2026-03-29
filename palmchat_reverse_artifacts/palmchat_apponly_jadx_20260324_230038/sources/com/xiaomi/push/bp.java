package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.bw;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11450a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private WeakReference<Context> f164a;

    public bp(String str, WeakReference<Context> weakReference) {
        this.f11450a = str;
        this.f164a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f164a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (ca.a(this.f11450a) <= bo.f162a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        bs bsVarA = bs.a(this.f11450a);
        br brVarA = br.a(this.f11450a);
        bsVarA.a(brVarA);
        brVarA.a(bq.a(context, this.f11450a, 1000));
        bw.a(context).a((bw.a) bsVarA);
    }
}
