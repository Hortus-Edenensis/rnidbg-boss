package com.qiniu.android.http.metrics;

import com.qiniu.android.http.request.IUploadRegion;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UploadTaskMetrics extends UploadMetrics {
    public ArrayList<IUploadRegion> regions;
    private UploadRegionRequestMetrics ucQueryMetrics;
    private String upType;
    private List<String> metricsKeys = new CopyOnWriteArrayList();
    private Map<String, UploadRegionRequestMetrics> metricsInfo = new ConcurrentHashMap();

    public UploadTaskMetrics(String str) {
        this.upType = str;
    }

    public void addMetrics(UploadRegionRequestMetrics uploadRegionRequestMetrics) {
        IUploadRegion iUploadRegion;
        if (uploadRegionRequestMetrics == null || (iUploadRegion = uploadRegionRequestMetrics.region) == null || iUploadRegion.getZoneInfo() == null || uploadRegionRequestMetrics.region.getZoneInfo().regionId == null) {
            return;
        }
        String str = uploadRegionRequestMetrics.region.getZoneInfo().regionId;
        UploadRegionRequestMetrics uploadRegionRequestMetrics2 = this.metricsInfo.get(str);
        if (uploadRegionRequestMetrics2 != null) {
            uploadRegionRequestMetrics2.addMetrics(uploadRegionRequestMetrics);
        } else {
            this.metricsKeys.add(str);
            this.metricsInfo.put(str, uploadRegionRequestMetrics);
        }
    }

    public Long bytesSend() {
        Iterator<String> it = this.metricsInfo.keySet().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            UploadRegionRequestMetrics uploadRegionRequestMetrics = this.metricsInfo.get(it.next());
            if (uploadRegionRequestMetrics != null) {
                jLongValue += uploadRegionRequestMetrics.bytesSend().longValue();
            }
        }
        return Long.valueOf(jLongValue);
    }

    public UploadRegionRequestMetrics getUcQueryMetrics() {
        return this.ucQueryMetrics;
    }

    public String getUpType() {
        return this.upType;
    }

    public UploadRegionRequestMetrics lastMetrics() {
        int size = this.metricsKeys.size();
        if (size < 1) {
            return null;
        }
        return this.metricsInfo.get(this.metricsKeys.get(size - 1));
    }

    public Long regionCount() {
        IUploadRegion iUploadRegion;
        Iterator<String> it = this.metricsInfo.keySet().iterator();
        long j = 0;
        while (it.hasNext()) {
            UploadRegionRequestMetrics uploadRegionRequestMetrics = this.metricsInfo.get(it.next());
            if (uploadRegionRequestMetrics != null && (iUploadRegion = uploadRegionRequestMetrics.region) != null && iUploadRegion.getZoneInfo() != null && !uploadRegionRequestMetrics.region.getZoneInfo().regionId.equals("unknown")) {
                j++;
            }
        }
        return Long.valueOf(j);
    }

    public Long requestCount() {
        Iterator<String> it = this.metricsInfo.keySet().iterator();
        long jIntValue = 0;
        while (it.hasNext()) {
            UploadRegionRequestMetrics uploadRegionRequestMetrics = this.metricsInfo.get(it.next());
            if (uploadRegionRequestMetrics != null) {
                jIntValue += (long) uploadRegionRequestMetrics.requestCount().intValue();
            }
        }
        return Long.valueOf(jIntValue);
    }

    public void setUcQueryMetrics(UploadRegionRequestMetrics uploadRegionRequestMetrics) {
        this.ucQueryMetrics = uploadRegionRequestMetrics;
        addMetrics(uploadRegionRequestMetrics);
    }
}
