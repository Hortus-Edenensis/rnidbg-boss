package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class HomeWrapper extends BaseWrapper {
    public HomeWrapper(Map<String, Object> map) {
        super(map);
    }

    public static HomeWrapper wrapper(Map<String, Object> map) {
        return new HomeWrapper(map);
    }

    public String getModule() {
        try {
            return (String) get("m");
        } catch (ag unused) {
            return "";
        }
    }

    public int getPageKey() {
        try {
            return getInt("pk");
        } catch (ag unused) {
            return 0;
        }
    }

    public HomeWrapper setModule(String str) {
        return (HomeWrapper) set("m", str);
    }

    public HomeWrapper setPageKey(int i) {
        return (HomeWrapper) set("pk", Integer.valueOf(i));
    }
}
