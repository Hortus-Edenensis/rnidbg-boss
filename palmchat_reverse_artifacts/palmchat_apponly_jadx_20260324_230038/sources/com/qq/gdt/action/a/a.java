package com.qq.gdt.action.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.qq.gdt.action.acj.odis;
import com.qq.gdt.action.j.o;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: com.qq.gdt.action.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0834a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10457a;
        private final boolean b;

        public C0834a(String str, boolean z) {
            this.f10457a = str;
            this.b = z;
        }

        public String a() {
            return this.f10457a;
        }

        public boolean b() {
            return this.b;
        }
    }

    public static void a(Context context) {
        C0834a c0834aC = c(context);
        if (c0834aC != null) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.qq.gdt.action.DeviceIdPref", 0).edit();
            editorEdit.putString("native_oaid", c0834aC.f10457a);
            editorEdit.putString("is_oaid_track_limited", String.valueOf(c0834aC.b));
            editorEdit.apply();
        }
    }

    public static C0834a b(Context context) {
        String string;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.qq.gdt.action.DeviceIdPref", 0);
        if (sharedPreferences == null || (string = sharedPreferences.getString("is_oaid_track_limited", null)) == null || string.isEmpty()) {
            return null;
        }
        return new C0834a(sharedPreferences.getString("native_oaid", null), Boolean.parseBoolean(sharedPreferences.getString("is_oaid_track_limited", null)));
    }

    private static C0834a c(Context context) {
        b bVar = new b();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(c.a(context));
        if (context.bindService(intent, bVar, 1)) {
            try {
                try {
                    odis odisVarA = odis.a.a(bVar.a());
                    C0834a c0834a = new C0834a(odisVarA.a(), odisVarA.b());
                    try {
                        context.unbindService(bVar);
                        return c0834a;
                    } catch (Throwable th) {
                        o.a("unbind " + th.getClass().getSimpleName(), new Object[0]);
                        return c0834a;
                    }
                } catch (Throwable th2) {
                    try {
                        context.unbindService(bVar);
                    } catch (Throwable th3) {
                        o.a("unbind " + th3.getClass().getSimpleName(), new Object[0]);
                    }
                    throw th2;
                }
            } catch (RemoteException unused) {
                o.a("bind hms service RemoteException", new Object[0]);
                try {
                    context.unbindService(bVar);
                } catch (Throwable th4) {
                    o.a("unbind " + th4.getClass().getSimpleName(), new Object[0]);
                }
            } catch (InterruptedException unused2) {
                o.a("bind hms service InterruptedException", new Object[0]);
                try {
                    context.unbindService(bVar);
                } catch (Throwable th5) {
                    o.a("unbind " + th5.getClass().getSimpleName(), new Object[0]);
                }
            }
        }
        return null;
    }
}
