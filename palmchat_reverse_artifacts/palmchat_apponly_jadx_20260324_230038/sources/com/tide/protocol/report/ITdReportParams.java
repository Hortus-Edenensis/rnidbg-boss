package com.tide.protocol.report;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITdReportParams {
    JSONObject toJsonObject();

    String toJsonString();

    Map<String, Object> toMap();
}
