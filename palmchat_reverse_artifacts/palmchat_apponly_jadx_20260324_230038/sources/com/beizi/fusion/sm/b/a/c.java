package com.beizi.fusion.sm.b.a;

import android.app.KeyguardManager;
import android.content.Context;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c implements com.beizi.fusion.sm.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4673a;
    private final KeyguardManager b;

    public c(Context context) {
        this.f4673a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f4673a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            com.beizi.fusion.sm.b.e.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f4673a == null || bVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            bVar.a(new com.beizi.fusion.sm.b.d("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
            if (objInvoke != null) {
                String string = objInvoke.toString();
                com.beizi.fusion.sm.b.e.a("OAID obtain success: " + string);
                bVar.a(string);
                return;
            }
            throw new com.beizi.fusion.sm.b.d("OAID obtain failed");
        } catch (Exception e) {
            com.beizi.fusion.sm.b.e.a(e);
        }
    }
}
