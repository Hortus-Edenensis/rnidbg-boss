package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class PreDownWrapper extends IDWrapper {
    public static final int OPERATOR_TYPE_CANCEL = 1;
    public static final int OPERATOR_TYPE_START = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5461a = "type";

    public PreDownWrapper(Map<String, Object> map) {
        super(map);
    }

    public static PreDownWrapper wrapper(Map<String, Object> map) {
        return new PreDownWrapper(map);
    }

    public String getChannelPkg() {
        try {
            return (String) get(OapsKey.KEY_CHANEL_PKG);
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

    public int getType() {
        try {
            return getInt("type");
        } catch (ag unused) {
            return -1;
        }
    }

    public PreDownWrapper setChannelPkg(String str) {
        return (PreDownWrapper) set(OapsKey.KEY_CHANEL_PKG, str);
    }

    public PreDownWrapper setPkgName(String str) {
        return (PreDownWrapper) set("pkg", str);
    }

    public PreDownWrapper setType(int i) {
        return (PreDownWrapper) set("type", Integer.valueOf(i));
    }
}
