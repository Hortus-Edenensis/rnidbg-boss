package com.beizi.fusion.d.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.d.a.b;
import com.beizi.fusion.d.b.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.beizi.fusion.d.b.c f4628a;
    ServiceConnection b = new ServiceConnection() { // from class: com.beizi.fusion.d.a.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.f4628a = new c.a.C0135a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private Context c;

    public d(Context context) {
        this.c = context;
    }

    public void a(b.a aVar) {
        com.beizi.fusion.d.b.c cVar;
        this.c.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (!this.c.bindService(intent, this.b, 1) || (cVar = this.f4628a) == null) {
            return;
        }
        String strA = cVar.a();
        if (aVar != null) {
            aVar.a(strA);
        }
    }
}
