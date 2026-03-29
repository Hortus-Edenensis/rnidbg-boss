package com.opos.acs.st.entity;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.opos.acs.st.utils.f;
import com.opos.cmn.biz.requeststatistic.StatisticEvent;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    public static StatisticEvent a(Map map) {
        if (map != null) {
            long jLongValue = -1;
            try {
                try {
                    if (map.get("ret") != null && !"".equals((String) map.get("ret"))) {
                        jLongValue = Long.valueOf((String) map.get("ret")).longValue();
                    }
                } catch (Exception e) {
                    f.b("ErrorTag", "", e);
                }
                return new StatisticEvent.Builder((String) map.get("evtId"), (String) map.get("url"), jLongValue, map.get("rt") == null ? 0L : ((Long) map.get("rt")).longValue(), map.get("mt") == null ? 0L : ((Long) map.get("mt")).longValue(), (String) map.get("chn")).setCurrentTime(map.get("ct") == null ? System.currentTimeMillis() : ((Long) map.get("ct")).longValue()).setExt((String) map.get("ext")).setNet((String) map.get(TKDownloadReason.KSAD_TK_NET)).setSdkVersion("3013000").build();
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
