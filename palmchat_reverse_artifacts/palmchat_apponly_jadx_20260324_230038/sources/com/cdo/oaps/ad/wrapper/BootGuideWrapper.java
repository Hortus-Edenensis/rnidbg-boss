package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BootGuideWrapper extends BaseWrapper {
    public BootGuideWrapper(Map<String, Object> map) {
        super(map);
    }

    public static BootGuideWrapper wrapper(Map<String, Object> map) {
        return new BootGuideWrapper(map);
    }

    public String getAction() {
        try {
            return (String) get("action");
        } catch (ag unused) {
            return "";
        }
    }

    public String getPkgName() {
        try {
            return (String) get("pkg");
        } catch (ag unused) {
            return "";
        }
    }

    public BootGuideWrapper setAction(String str) {
        return (BootGuideWrapper) set("action", str);
    }

    public BootGuideWrapper setPkgName(String str) {
        return (BootGuideWrapper) set("pkg", str);
    }
}
