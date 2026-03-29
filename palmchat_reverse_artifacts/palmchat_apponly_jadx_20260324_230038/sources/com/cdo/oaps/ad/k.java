package com.cdo.oaps.ad;

import android.content.Context;
import com.cdo.oaps.ad.Launcher;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class k implements l {
    @Override // com.cdo.oaps.ad.l
    public boolean a(Context context, Map<String, Object> map) {
        return (!Launcher.Host.GC.equals(OapsWrapper.wrapper(map).getHost()) || x.a(context) >= 2.0f) ? new j().a(context, map) : v.a(context, map);
    }

    @Override // com.cdo.oaps.ad.l
    public boolean b(Context context, Map<String, Object> map) {
        if (!Launcher.Host.GC.equals(OapsWrapper.wrapper(map).getHost()) || x.a(context) >= 2.0f) {
            return new j().b(context, map);
        }
        return false;
    }
}
