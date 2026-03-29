package com.xiaomi.push.service;

import com.xiaomi.push.gs;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class au {
    public static gs a(gs gsVar) {
        Map<String, String> map;
        if (gsVar != null && (map = gsVar.f574b) != null) {
            map.remove("score_info");
        }
        return gsVar;
    }
}
