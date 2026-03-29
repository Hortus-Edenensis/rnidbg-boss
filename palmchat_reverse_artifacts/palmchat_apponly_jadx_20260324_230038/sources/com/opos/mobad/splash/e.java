package com.opos.mobad.splash;

import android.content.Context;
import android.view.View;
import com.opos.mobad.splash.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {
    public static final com.opos.mobad.template.e a(f.a aVar, Context context, final com.opos.mobad.ad.g.e eVar) {
        return (!f.a(aVar) || eVar == null || eVar.getSplashSkipView() == null || eVar.getSkipClickViews().size() <= 0) ? new com.opos.mobad.template.i.a(context) : new com.opos.mobad.template.i.b(eVar.getSkipClickViews()) { // from class: com.opos.mobad.splash.e.1
            @Override // com.opos.mobad.template.e
            public View a() {
                return eVar.getSplashSkipView();
            }

            @Override // com.opos.mobad.template.e
            public void a(int i) {
                eVar.onSkipCountDown(i);
            }
        };
    }
}
