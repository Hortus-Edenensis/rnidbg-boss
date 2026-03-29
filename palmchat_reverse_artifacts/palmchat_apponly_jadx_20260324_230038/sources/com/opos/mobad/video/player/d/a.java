package com.opos.mobad.video.player.d;

import android.app.Activity;
import android.os.Bundle;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    public static com.opos.mobad.template.a a(Activity activity, AdItemData adItemData, MaterialData materialData, Bundle bundle, a.InterfaceC0778a interfaceC0778a) {
        com.opos.mobad.template.a aVarA = com.opos.mobad.ui.c.b.a().a(activity, adItemData, materialData, bundle, interfaceC0778a);
        if (aVarA != null) {
            return aVarA instanceof com.opos.mobad.ui.c.a ? aVarA : new b(activity, adItemData, aVarA);
        }
        return null;
    }
}
