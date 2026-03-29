package com.cdo.oaps.ad.wrapper.download;

import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.ai;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DownloadRespWrapper extends ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5466a = "dl_st";
    private static final String c = "dl_tlen";
    private static final String d = "dl_perc";
    private static final String e = "dl_sp";
    private static final String f = "dl_error_code";

    public DownloadRespWrapper(Map<String, Object> map) {
        super(map);
    }

    public static DownloadRespWrapper wrapper(Map<String, Object> map) {
        return new DownloadRespWrapper(map);
    }

    public int getErrorCode() {
        try {
            return getInt(f);
        } catch (ag unused) {
            return -1;
        }
    }

    public float getPercent() {
        try {
            return getFloat(d);
        } catch (ag unused) {
            return -1.0f;
        }
    }

    public String getPkgName() {
        try {
            return (String) get("pkg");
        } catch (ag unused) {
            return "";
        }
    }

    public long getSpeed() {
        try {
            return getLong(e);
        } catch (ag unused) {
            return -1L;
        }
    }

    public int getStatus() {
        try {
            return getInt(f5466a);
        } catch (ag unused) {
            return -1;
        }
    }

    public long getTotalLength() {
        try {
            return getLong(c);
        } catch (ag unused) {
            return -1L;
        }
    }

    public DownloadRespWrapper setErrorCode(int i) {
        return (DownloadRespWrapper) set(f, Integer.valueOf(i));
    }

    public DownloadRespWrapper setPercent(float f2) {
        return (DownloadRespWrapper) set(d, Float.valueOf(f2));
    }

    public DownloadRespWrapper setPkgName(String str) {
        return (DownloadRespWrapper) set("pkg", str);
    }

    public DownloadRespWrapper setSpeed(long j) {
        return (DownloadRespWrapper) set(e, Long.valueOf(j));
    }

    public DownloadRespWrapper setStatus(int i) {
        return (DownloadRespWrapper) set(f5466a, Integer.valueOf(i));
    }

    public DownloadRespWrapper setTotalLength(long j) {
        return (DownloadRespWrapper) set(c, Long.valueOf(j));
    }
}
