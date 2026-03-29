package com.opos.mobad.service.e;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.biz.monitor.MonitorEvent;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.opos.mobad.provider.monitor.a f9233a;

    /* JADX INFO: Access modifiers changed from: private */
    public static com.opos.mobad.provider.monitor.a b(Context context) {
        com.opos.mobad.provider.monitor.a aVar = f9233a;
        if (aVar == null) {
            synchronized (c.class) {
                aVar = f9233a;
                if (aVar == null) {
                    aVar = new com.opos.mobad.provider.monitor.a(context.getApplicationContext());
                    f9233a = aVar;
                }
            }
        }
        return aVar;
    }

    public static final b a() {
        return new b();
    }

    private static final void b(final Context context, final List<String> list, final MonitorEvent monitorEvent) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.c.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    try {
                        c.b(context).a((String) it.next(), monitorEvent);
                    } catch (Exception unused) {
                        com.opos.cmn.an.f.a.b("", "monitor fail");
                    }
                }
            }
        });
    }

    public static final String a(Context context, String str, b bVar) {
        return (context == null || TextUtils.isEmpty(str) || bVar == null) ? str : bVar.a(context, str);
    }

    public static final void a(Context context, List<String> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        b(context, list, null);
    }

    public static final void a(Context context, List<String> list, MonitorEvent monitorEvent) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        b(context, list, monitorEvent);
    }
}
