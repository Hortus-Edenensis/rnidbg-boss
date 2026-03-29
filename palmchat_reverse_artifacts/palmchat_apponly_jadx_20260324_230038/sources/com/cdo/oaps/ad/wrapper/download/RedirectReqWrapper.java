package com.cdo.oaps.ad.wrapper.download;

import android.net.Uri;
import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class RedirectReqWrapper extends BaseWrapper {
    public static final String KEY_CHANNEL = "ch";
    public static final String KEY_REFER = "rf";

    public RedirectReqWrapper(Map<String, Object> map) {
        super(map);
    }

    public static RedirectReqWrapper wrapper(Map<String, Object> map) {
        return new RedirectReqWrapper(map);
    }

    public String getChannel() {
        try {
            return Uri.decode((String) get(KEY_CHANNEL));
        } catch (ag unused) {
            return "";
        }
    }

    public String getRefer() {
        try {
            return Uri.decode((String) get(KEY_REFER));
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

    public RedirectReqWrapper setChannel(String str) {
        return (RedirectReqWrapper) set(KEY_CHANNEL, Uri.encode(str));
    }

    public RedirectReqWrapper setRefer(String str) {
        return (RedirectReqWrapper) set(KEY_REFER, Uri.encode(str));
    }

    public RedirectReqWrapper setUrl(String str) {
        return (RedirectReqWrapper) set("u", Uri.encode(str));
    }
}
