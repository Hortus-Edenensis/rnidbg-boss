package com.bytedance.sdk.openadsdk.core.gi.u;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.iz.bq;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u(int i, String str, Throwable th);

        void u(my myVar, com.bytedance.sdk.openadsdk.core.gi.u.nr nrVar);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.gi.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0261u implements nr {
        @Override // com.bytedance.sdk.openadsdk.core.gi.u.u.nr
        public void u(int i, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.gi.u.u.nr
        public void u(my myVar, com.bytedance.sdk.openadsdk.core.gi.u.nr nrVar) {
        }
    }

    public static C0261u nr() {
        return new C0261u();
    }

    public void u() {
    }

    public void u(com.bytedance.sdk.openadsdk.mv.nr nrVar, nr nrVar2, int i, int i2, String str) {
        u(nrVar, nrVar2, i, i2, ImageView.ScaleType.CENTER_INSIDE, str);
    }

    public void u(com.bytedance.sdk.openadsdk.mv.nr nrVar, nr nrVar2, int i, int i2, String str, int i3, bq bqVar, boolean z) {
        u(nrVar, nrVar2, i, i2, ImageView.ScaleType.CENTER_INSIDE, str, i3, bqVar, z);
    }

    public void u(com.bytedance.sdk.openadsdk.mv.nr nrVar, final nr nrVar2, int i, int i2, ImageView.ScaleType scaleType, String str) {
        com.bytedance.sdk.openadsdk.n.nr.u(nrVar.u).key(nrVar.nr).width(i).height(i2).cacheDir(str).config(Bitmap.Config.RGB_565).scaleType(scaleType).requestTime(!TextUtils.isEmpty(str)).to(new qq() { // from class: com.bytedance.sdk.openadsdk.core.gi.u.u.1
            @Override // com.bytedance.sdk.component.iz.qq
            public void onFailed(int i3, String str2, Throwable th) {
                u.this.u(i3, str2, th, nrVar2);
            }

            @Override // com.bytedance.sdk.component.iz.qq
            public void onSuccess(my myVar) {
                u.this.u(myVar, nrVar2);
            }
        });
        u();
    }

    public void u(com.bytedance.sdk.openadsdk.mv.nr nrVar, final nr nrVar2, int i, int i2, ImageView.ScaleType scaleType, String str, int i3, bq bqVar, boolean z) {
        com.bytedance.sdk.openadsdk.n.nr.u(nrVar.u).key(nrVar.nr).width(i).height(i2).cacheDir(str).config(Bitmap.Config.RGB_565).scaleType(scaleType).loadSetp(bqVar).headers(z).requestTime(!TextUtils.isEmpty(str)).to(new qq() { // from class: com.bytedance.sdk.openadsdk.core.gi.u.u.2
            @Override // com.bytedance.sdk.component.iz.qq
            public void onFailed(int i4, String str2, Throwable th) {
                u.this.u(i4, str2, th, nrVar2);
            }

            @Override // com.bytedance.sdk.component.iz.qq
            public void onSuccess(my myVar) {
                u.this.u(myVar, nrVar2);
            }
        }, i3);
        u();
    }

    public void u(my myVar, nr nrVar) {
        if (nrVar != null) {
            Object result = myVar.getResult();
            int iU = u(myVar);
            if (result instanceof byte[]) {
                nrVar.u(myVar, new com.bytedance.sdk.openadsdk.core.gi.u.nr((byte[]) result, iU));
            } else if (result instanceof Bitmap) {
                nrVar.u(myVar, new com.bytedance.sdk.openadsdk.core.gi.u.nr((Bitmap) result, iU));
            } else {
                nrVar.u(0, "not bitmap or gif result!", null);
            }
        }
    }

    private int u(my myVar) {
        Map<String, String> headers = myVar.getHeaders();
        if (headers == null) {
            return 0;
        }
        try {
            String str = headers.get("image_size");
            if (str == null || !(str instanceof String)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void u(int i, String str, Throwable th, nr nrVar) {
        if (nrVar != null) {
            nrVar.u(i, str, th);
        }
    }
}
