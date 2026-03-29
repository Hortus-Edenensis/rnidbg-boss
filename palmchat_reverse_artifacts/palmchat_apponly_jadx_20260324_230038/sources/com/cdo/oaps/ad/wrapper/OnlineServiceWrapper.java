package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class OnlineServiceWrapper extends BaseWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5460a = "gr";

    public OnlineServiceWrapper(Map<String, Object> map) {
        super(map);
    }

    public static OnlineServiceWrapper wrapper(Map<String, Object> map) {
        return new OnlineServiceWrapper(map);
    }

    public int getGrade() {
        try {
            return getInt(f5460a);
        } catch (ag | NumberFormatException unused) {
            return 0;
        }
    }

    public OnlineServiceWrapper setGrade(int i) {
        return (OnlineServiceWrapper) set(f5460a, Integer.valueOf(i));
    }
}
