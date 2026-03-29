package com.baidu.mshield.x0.k;

import android.content.Context;
import android.content.Intent;
import com.baidu.mshield.x0.c.c;
import com.baidu.mshield.x0.d.b;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x0.j.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: com.baidu.mshield.x0.k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0100a implements a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f4071a;

        public C0100a(Context context) {
            this.f4071a = context;
        }

        @Override // com.baidu.mshield.x0.j.a.b
        public void a(int i) {
            b.a(this.f4071a, (com.baidu.mshield.x0.l.a) null);
            com.baidu.mshield.x0.c.a.a(this.f4071a);
        }
    }

    public static void a(Context context, Intent intent) {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str) {
        byte b;
        if (str == null) {
            return;
        }
        try {
            com.baidu.mshield.b.c.a.b("secac=" + str);
            int iHashCode = str.hashCode();
            if (iHashCode != 1083937949) {
                b = (iHashCode == 1278732294 && str.equals("com.baidu.mshield.x0.detect.app.fr")) ? (byte) 1 : (byte) -1;
            } else if (str.equals("com.baidu.mshield.x0.timer.pp.action")) {
                b = 0;
            }
            if (b == 0) {
                a(context);
            } else {
                if (b != 1) {
                    return;
                }
                c.a(context);
                b.c(context);
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void a(Context context) {
        try {
            com.baidu.mshield.x0.j.a.a(context).a((a.b) new C0100a(context), true);
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
