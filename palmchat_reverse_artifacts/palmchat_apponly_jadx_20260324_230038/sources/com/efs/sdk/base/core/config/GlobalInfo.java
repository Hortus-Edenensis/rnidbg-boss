package com.efs.sdk.base.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import com.efs.sdk.base.core.a.a;
import com.efs.sdk.base.core.util.c;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.lantern.auth.server.WkParams;
import com.umeng.umcrash.UMCrash;
import com.wifi.ad.core.config.DeviceInfoUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class GlobalInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f5567a = new ConcurrentHashMap();

    public final void a(String str, Object obj) {
        if (obj != null) {
            this.f5567a.put(str, obj);
        }
    }

    public final Object b(String str, Object obj) {
        Object obj2 = this.f5567a.get(str);
        return (obj2 != null || this.f5567a.containsKey(str)) ? obj2 : obj;
    }

    public Map<String, Object> getGlobalInfoMap() {
        HashMap map = new HashMap(this.f5567a);
        a.a();
        map.put("ctime", Long.valueOf(a.b() / 1000));
        a.a();
        map.put("w_tm", Long.valueOf(a.b() / 1000));
        return map;
    }

    public List<AbsSection> getGlobalSectionList(String str) {
        ArrayList arrayList = new ArrayList();
        KVSection kVSection = new KVSection("global_head");
        KVSection kVSectionPut = kVSection.put("type", str).put("appid", this.f5567a.get("appid")).put("wid", this.f5567a.get("wid")).put("pid", this.f5567a.get("pid")).put("pkg", this.f5567a.get("pkg")).put("ver", this.f5567a.get("ver")).put(RedirectRespWrapper.KEY_VERCODE, this.f5567a.get(RedirectRespWrapper.KEY_VERCODE)).put("ps", this.f5567a.get("ps")).put("stime", this.f5567a.get("stime"));
        a.a();
        KVSection kVSectionPut2 = kVSectionPut.put("ctime", Long.valueOf(a.b() / 1000));
        a.a();
        kVSectionPut2.put("w_tm", Long.valueOf(a.b() / 1000)).put(HiAnalyticsConstant.BI_KEY_SDK_VER, this.f5567a.get(HiAnalyticsConstant.BI_KEY_SDK_VER));
        String strValueOf = String.valueOf(b(DeviceInfoUtil.UID_TAG, ""));
        if (!TextUtils.isEmpty(strValueOf)) {
            kVSection.put(DeviceInfoUtil.UID_TAG, strValueOf);
        }
        arrayList.add(kVSection);
        KVSection kVSection2 = new KVSection("device_info");
        kVSection2.put(WkParams.LANG, this.f5567a.get(WkParams.LANG)).put("brand", this.f5567a.get("brand")).put(WkParams.MODEL, this.f5567a.get(WkParams.MODEL)).put("build_model", this.f5567a.get("build_model")).put("rom", this.f5567a.get("rom")).put(com.umeng.ccg.a.x, this.f5567a.get(com.umeng.ccg.a.x)).put("dsp_h", this.f5567a.get("dsp_h")).put("dsp_w", this.f5567a.get("dsp_w")).put("tzone", this.f5567a.get("tzone")).put(TKDownloadReason.KSAD_TK_NET, this.f5567a.get(TKDownloadReason.KSAD_TK_NET)).put("fr", this.f5567a.get("fr"));
        try {
            if (this.f5567a.containsKey(UMCrash.KEY_HEADER_ACCESS)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS, this.f5567a.get(UMCrash.KEY_HEADER_ACCESS));
            }
            if (this.f5567a.containsKey(UMCrash.KEY_HEADER_ACCESS_SUBTYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, this.f5567a.get(UMCrash.KEY_HEADER_ACCESS_SUBTYPE));
            }
            if (this.f5567a.containsKey(UMCrash.KEY_HEADER_NETWORK_TYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_NETWORK_TYPE, this.f5567a.get(UMCrash.KEY_HEADER_NETWORK_TYPE));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        arrayList.add(kVSection2);
        return arrayList;
    }

    public String getUUID(Context context) {
        String strValueOf = String.valueOf(b("wid", ""));
        if (!TextUtils.isEmpty(strValueOf)) {
            return strValueOf;
        }
        String strA = c.a(context);
        a("wid", strA);
        return strA;
    }
}
