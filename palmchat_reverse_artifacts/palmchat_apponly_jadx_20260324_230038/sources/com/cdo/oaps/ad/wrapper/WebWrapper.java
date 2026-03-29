package com.cdo.oaps.ad.wrapper;

import android.net.Uri;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class WebWrapper extends BaseWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5464a = "wtic";

    public WebWrapper(Map<String, Object> map) {
        super(map);
    }

    public static WebWrapper wrapper(Map<String, Object> map) {
        return new WebWrapper(map);
    }

    public String getHybrid() {
        try {
            return Uri.decode((String) get(OapsKey.KEY_HYBRID));
        } catch (ag unused) {
            return "";
        }
    }

    public String getTitle() {
        try {
            return (String) get("t");
        } catch (ag unused) {
            return "";
        }
    }

    public String getUrl() {
        try {
            return Uri.decode((String) get("u"));
        } catch (ag unused) {
            return "";
        }
    }

    public int getWebTitleIconColor() {
        try {
            return getInt(f5464a);
        } catch (ag unused) {
            return 0;
        }
    }

    public WebWrapper setHybrid(String str) {
        return (WebWrapper) set(OapsKey.KEY_HYBRID, Uri.encode(str));
    }

    public WebWrapper setTitle(String str) {
        return (WebWrapper) set("t", str);
    }

    public WebWrapper setUrl(String str) {
        return (WebWrapper) set("u", Uri.encode(str));
    }

    public WebWrapper setWebTitleIconColor(int i) {
        return (WebWrapper) set(f5464a, Integer.valueOf(i));
    }
}
