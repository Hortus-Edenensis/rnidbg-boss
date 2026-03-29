package com.opos.cmn.module.ui.b.b;

import android.animation.ObjectAnimator;
import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b extends a {
    private ObjectAnimator b;

    public b(View view) {
        super(view);
        c();
    }

    private void c() {
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f8055a, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 360.0f);
            this.b = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1000L);
            this.b.setRepeatMode(1);
            this.b.setRepeatCount(-1);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LoadingAnimCreative", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.module.ui.b.b.a
    public void a() {
        try {
            this.b.start();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LoadingAnimCreative", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.module.ui.b.b.a
    public void b() {
        try {
            this.b.cancel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LoadingAnimCreative", "", (Throwable) e);
        }
    }
}
