package com.opos.mobad.f;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.heytap.msp.opos.sv.api.params.ErrorCode;
import com.opos.mobad.ad.c;
import com.opos.mobad.ad.h;
import com.opos.mobad.c.a.d;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {
    private Handler c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<Integer, com.opos.mobad.ad.c> f8886a = new HashMap<>();
    private HashMap<Integer, Boolean> b = new HashMap<>();
    private boolean d = false;

    public int a(int i) {
        if (!this.b.containsKey(Integer.valueOf(i))) {
            return 2;
        }
        if (com.opos.mobad.c.b.a().a(i)) {
            return this.b.get(Integer.valueOf(i)).booleanValue() ? 0 : 1;
        }
        return 3;
    }

    public com.opos.mobad.ad.c b(int i) {
        return this.f8886a.get(Integer.valueOf(i));
    }

    public synchronized c.a a(Context context, Integer num, com.opos.mobad.ad.c cVar) {
        if (this.f8886a.containsKey(num)) {
            return new c.a(true, "");
        }
        c.a aVarA = cVar.a(context);
        if (aVarA == null) {
            com.opos.cmn.an.f.a.c("AdCreatorController", "creator check null:" + num);
            return new c.a(false, ErrorCode.ERROR_MSG_UNKNOWN_ERROR);
        }
        if (aVarA.f8521a) {
            this.f8886a.put(num, cVar);
            this.b.put(num, Boolean.FALSE);
            return aVarA;
        }
        com.opos.cmn.an.f.a.d("AdCreatorController", "error:" + aVarA.b);
        return aVarA;
    }

    public synchronized void b() {
        Iterator<Integer> it = this.f8886a.keySet().iterator();
        while (it.hasNext()) {
            this.f8886a.get(it.next()).b();
        }
    }

    private void a(Context context) {
        if (this.c != null) {
            return;
        }
        synchronized (this) {
            if (this.c == null) {
                this.c = new Handler(context.getMainLooper());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, com.opos.mobad.c.a.d dVar, boolean z) {
        com.opos.cmn.an.f.a.b("DispatchController", "initCreatorIfNeed done");
        com.opos.cmn.an.f.a.a("AdCreatorController", "init creator size:" + this.f8886a.size() + ".CreateMap:" + this.f8886a.toString());
        String packageName = context.getApplicationInfo().name;
        if (TextUtils.isEmpty(packageName)) {
            packageName = context.getPackageName();
        }
        boolean z2 = true;
        for (Integer num : this.f8886a.keySet()) {
            String strB = dVar.b(num.intValue());
            String strC = dVar.c(num.intValue());
            String strD = dVar.d(num.intValue());
            com.opos.mobad.ad.c cVar = this.f8886a.get(num);
            com.opos.cmn.an.f.a.a("AdCreatorController", "init creator channelAppId:" + strB + "," + strD);
            if (TextUtils.isEmpty(strB) || !com.opos.mobad.c.b.a().a(num.intValue()) || a(num.intValue(), strB)) {
                z2 = false;
            } else {
                this.b.put(num, Boolean.TRUE);
                cVar.a(context, strB, packageName, strC, z, new h() { // from class: com.opos.mobad.f.b.2
                    @Override // com.opos.mobad.ad.h
                    public void onFailed(String str) {
                        com.opos.cmn.an.f.a.b("AdCreatorController", "init channel fail:" + str);
                    }

                    @Override // com.opos.mobad.ad.h
                    public void onSuccess() {
                        com.opos.cmn.an.f.a.b("AdCreatorController", "init channel success:");
                    }
                });
            }
        }
        this.d = z2;
    }

    public void a(final Context context, final com.opos.mobad.c.a.d dVar, final boolean z) {
        com.opos.cmn.an.f.a.b("DispatchController", "initCreatorIfNeed");
        if (context.getMainLooper().getThread() == Thread.currentThread()) {
            b(context, dVar, z);
        } else {
            a(context);
            this.c.post(new Runnable() { // from class: com.opos.mobad.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.b(context, dVar, z);
                }
            });
        }
    }

    public boolean a() {
        return this.f8886a.containsKey(Integer.valueOf(d.a.f8585a));
    }

    private boolean a(int i, String str) {
        if (i == d.a.c && !TextUtils.isEmpty(str)) {
            return "1200431650".equals(str);
        }
        return false;
    }
}
