package com.bytedance.sdk.openadsdk.core.y;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.openadsdk.core.gi.u.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bg {

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();

        void u(com.bytedance.sdk.openadsdk.core.gi.u.nr nrVar, com.bytedance.sdk.component.iz.my myVar);
    }

    public static void u(com.bytedance.sdk.openadsdk.mv.nr nrVar, int i, int i2, final u uVar, String str, int i3, com.bytedance.sdk.component.iz.bq bqVar, boolean z) {
        com.bytedance.sdk.component.utils.k.nr("splashLoadAd", " getImageBytes url ".concat(String.valueOf(nrVar)));
        com.bytedance.sdk.openadsdk.core.gi.pn.u().fx().u(nrVar, new u.nr() { // from class: com.bytedance.sdk.openadsdk.core.y.bg.1
            @Override // com.bytedance.sdk.openadsdk.core.gi.u.u.nr
            public void u(com.bytedance.sdk.component.iz.my myVar, com.bytedance.sdk.openadsdk.core.gi.u.nr nrVar2) {
                u uVar2;
                if (nrVar2.b() && (uVar2 = uVar) != null) {
                    uVar2.u(nrVar2, myVar);
                    return;
                }
                u uVar3 = uVar;
                if (uVar3 != null) {
                    uVar3.u();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.gi.u.u.nr
            public void u(int i4, String str2, Throwable th) {
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.u();
                }
            }
        }, i, i2, str, i3, bqVar, z);
    }

    public static Drawable u(byte[] bArr, int i) {
        if (bArr != null && bArr.length > 0) {
            try {
                return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            } catch (Throwable unused) {
                return new ColorDrawable(0);
            }
        }
        return new ColorDrawable(0);
    }
}
