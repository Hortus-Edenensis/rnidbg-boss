package com.cdo.oaps.ad.compatible.gamecenter.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.wrapper.IDWrapper;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ActiveWrapper extends IDWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f5449a;

    public ActiveWrapper(Map<String, Object> map) {
        super(map);
        this.f5449a = OapsKey.KEY_ACTIVE_CODE;
    }

    public static ActiveWrapper wrapper(Map<String, Object> map) {
        return new ActiveWrapper(map);
    }

    public int getActiveCode() {
        try {
            return getInt(OapsKey.KEY_ACTIVE_CODE);
        } catch (ag | NumberFormatException unused) {
            return -1;
        }
    }

    public ActiveWrapper setActiveCode(int i) {
        return (ActiveWrapper) set(OapsKey.KEY_ACTIVE_CODE, Integer.valueOf(i));
    }
}
