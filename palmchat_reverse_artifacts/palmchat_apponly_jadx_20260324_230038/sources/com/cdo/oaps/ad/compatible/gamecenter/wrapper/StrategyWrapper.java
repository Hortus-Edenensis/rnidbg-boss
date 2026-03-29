package com.cdo.oaps.ad.compatible.gamecenter.wrapper;

import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.wrapper.IDWrapper;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class StrategyWrapper extends IDWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f5450a;

    public StrategyWrapper(Map<String, Object> map) {
        super(map);
        this.f5450a = "tab";
    }

    public static StrategyWrapper wrapper(Map<String, Object> map) {
        return new StrategyWrapper(map);
    }

    public int getTab() {
        try {
            return getInt("tab");
        } catch (ag | NumberFormatException unused) {
            return -1;
        }
    }

    public StrategyWrapper setTab(int i) {
        return (StrategyWrapper) set("tab", Integer.valueOf(i));
    }
}
