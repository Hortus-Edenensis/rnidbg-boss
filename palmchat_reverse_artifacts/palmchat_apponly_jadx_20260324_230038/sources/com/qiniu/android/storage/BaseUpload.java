package com.qiniu.android.storage;

import com.oplus.tblplayer.Constants;
import com.qiniu.android.common.Zone;
import com.qiniu.android.common.ZoneInfo;
import com.qiniu.android.common.ZonesInfo;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.metrics.UploadTaskMetrics;
import com.qiniu.android.http.request.IUploadRegion;
import com.qiniu.android.http.serverRegion.UploadDomainRegion;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
abstract class BaseUpload implements Runnable {
    protected static final String UploadUpTypeForm = "form";
    protected static final String UploadUpTypeResumableV1 = "resumable_v1";
    protected static final String UploadUpTypeResumableV2 = "resumable_v2";
    protected final UpTaskCompletionHandler completionHandler;
    protected final Configuration config;
    private int currentRegionIndex;
    private UploadRegionRequestMetrics currentRegionRequestMetrics;
    protected final byte[] data;
    protected final String fileName;
    protected final String key;
    private UploadTaskMetrics metrics;
    protected final UploadOptions option;
    protected final Recorder recorder;
    protected final String recorderKey;
    private ArrayList<IUploadRegion> regions;
    protected final UpToken token;
    protected final UploadSource uploadSource;

    /* JADX INFO: compiled from: SearchBox */
    public interface UpTaskCompletionHandler {
        void complete(ResponseInfo responseInfo, String str, UploadTaskMetrics uploadTaskMetrics, JSONObject jSONObject);
    }

    private BaseUpload(UploadSource uploadSource, byte[] bArr, String str, String str2, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, Recorder recorder, String str3, UpTaskCompletionHandler upTaskCompletionHandler) {
        this.uploadSource = uploadSource;
        this.data = bArr;
        this.fileName = str == null ? Constants.STRING_VALUE_UNSET : str;
        this.key = str2;
        this.token = upToken;
        this.option = uploadOptions == null ? UploadOptions.defaultOptions() : uploadOptions;
        this.config = configuration;
        this.recorder = recorder;
        this.recorderKey = str3;
        this.completionHandler = upTaskCompletionHandler;
        initData();
    }

    private boolean setupRegions() {
        Zone zone;
        ZonesInfo zonesInfo;
        ArrayList<ZoneInfo> arrayList;
        Configuration configuration = this.config;
        if (configuration == null || (zone = configuration.zone) == null || (zonesInfo = zone.getZonesInfo(this.token)) == null || (arrayList = zonesInfo.zonesInfo) == null || arrayList.size() == 0) {
            return false;
        }
        ArrayList<ZoneInfo> arrayList2 = zonesInfo.zonesInfo;
        ArrayList<IUploadRegion> arrayList3 = new ArrayList<>();
        for (ZoneInfo zoneInfo : arrayList2) {
            UploadDomainRegion uploadDomainRegion = new UploadDomainRegion();
            uploadDomainRegion.setupRegionData(zoneInfo);
            if (uploadDomainRegion.isValid()) {
                arrayList3.add(uploadDomainRegion);
            }
        }
        this.regions = arrayList3;
        this.metrics.regions = arrayList3;
        return arrayList3.size() > 0;
    }

    public void addRegionRequestMetricsOfOneFlow(UploadRegionRequestMetrics uploadRegionRequestMetrics) {
        if (uploadRegionRequestMetrics == null) {
            return;
        }
        UploadRegionRequestMetrics uploadRegionRequestMetrics2 = this.currentRegionRequestMetrics;
        if (uploadRegionRequestMetrics2 == null) {
            this.currentRegionRequestMetrics = uploadRegionRequestMetrics;
        } else {
            uploadRegionRequestMetrics2.addMetrics(uploadRegionRequestMetrics);
        }
    }

    public void completeAction(ResponseInfo responseInfo, JSONObject jSONObject) {
        UploadTaskMetrics uploadTaskMetrics;
        UploadTaskMetrics uploadTaskMetrics2 = this.metrics;
        if (uploadTaskMetrics2 != null) {
            uploadTaskMetrics2.end();
        }
        UploadRegionRequestMetrics uploadRegionRequestMetrics = this.currentRegionRequestMetrics;
        if (uploadRegionRequestMetrics != null) {
            uploadRegionRequestMetrics.end();
        }
        UploadRegionRequestMetrics uploadRegionRequestMetrics2 = this.currentRegionRequestMetrics;
        if (uploadRegionRequestMetrics2 != null && (uploadTaskMetrics = this.metrics) != null) {
            uploadTaskMetrics.addMetrics(uploadRegionRequestMetrics2);
        }
        UpTaskCompletionHandler upTaskCompletionHandler = this.completionHandler;
        if (upTaskCompletionHandler != null) {
            upTaskCompletionHandler.complete(responseInfo, this.key, this.metrics, jSONObject);
        }
    }

    public IUploadRegion getCurrentRegion() {
        IUploadRegion iUploadRegion;
        if (this.regions == null) {
            return null;
        }
        synchronized (this) {
            iUploadRegion = this.currentRegionIndex < this.regions.size() ? this.regions.get(this.currentRegionIndex) : null;
        }
        return iUploadRegion;
    }

    public UploadRegionRequestMetrics getCurrentRegionRequestMetrics() {
        return this.currentRegionRequestMetrics;
    }

    public IUploadRegion getTargetRegion() {
        ArrayList<IUploadRegion> arrayList = this.regions;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return this.regions.get(0);
    }

    public abstract String getUpType();

    public void initData() {
        this.currentRegionIndex = 0;
        this.metrics = new UploadTaskMetrics(getUpType());
    }

    public void insertRegionAtFirst(IUploadRegion iUploadRegion) {
        boolean z;
        if (iUploadRegion == null) {
            return;
        }
        Iterator<IUploadRegion> it = this.regions.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (iUploadRegion.isEqual(it.next())) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        this.regions.add(0, iUploadRegion);
    }

    public int prepareToUpload() {
        return !setupRegions() ? -1 : 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.metrics.start();
        this.config.zone.preQuery(this.token, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.BaseUpload.1
            @Override // com.qiniu.android.common.Zone.QueryHandler
            public void complete(int i, ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics) {
                BaseUpload.this.metrics.setUcQueryMetrics(uploadRegionRequestMetrics);
                if (i != 0) {
                    BaseUpload.this.completeAction(responseInfo, responseInfo.response);
                    return;
                }
                int iPrepareToUpload = BaseUpload.this.prepareToUpload();
                if (iPrepareToUpload == 0) {
                    BaseUpload.this.startToUpload();
                } else {
                    BaseUpload.this.completeAction(ResponseInfo.errorInfo(iPrepareToUpload, null), null);
                }
            }
        });
    }

    public void startToUpload() {
        UploadRegionRequestMetrics uploadRegionRequestMetrics = new UploadRegionRequestMetrics(getCurrentRegion());
        this.currentRegionRequestMetrics = uploadRegionRequestMetrics;
        uploadRegionRequestMetrics.start();
    }

    public boolean switchRegion() {
        boolean z = false;
        if (this.regions == null) {
            return false;
        }
        synchronized (this) {
            int i = this.currentRegionIndex + 1;
            if (i < this.regions.size()) {
                this.currentRegionIndex = i;
                z = true;
            }
        }
        return z;
    }

    public boolean switchRegionAndUpload() {
        UploadRegionRequestMetrics uploadRegionRequestMetrics = this.currentRegionRequestMetrics;
        if (uploadRegionRequestMetrics != null) {
            uploadRegionRequestMetrics.end();
            this.metrics.addMetrics(this.currentRegionRequestMetrics);
            this.currentRegionRequestMetrics = null;
        }
        boolean zSwitchRegion = switchRegion();
        if (zSwitchRegion) {
            startToUpload();
        }
        return zSwitchRegion;
    }

    public boolean switchRegionAndUploadIfNeededWithErrorResponse(ResponseInfo responseInfo) {
        return responseInfo != null && !responseInfo.isOK() && responseInfo.couldRetry() && this.config.allowBackupHost && switchRegionAndUpload();
    }

    public BaseUpload(UploadSource uploadSource, String str, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, Recorder recorder, String str2, UpTaskCompletionHandler upTaskCompletionHandler) {
        this(uploadSource, null, uploadSource.getFileName(), str, upToken, uploadOptions, configuration, recorder, str2, upTaskCompletionHandler);
    }

    public BaseUpload(byte[] bArr, String str, String str2, UpToken upToken, UploadOptions uploadOptions, Configuration configuration, UpTaskCompletionHandler upTaskCompletionHandler) {
        this(null, bArr, str2, str, upToken, uploadOptions, configuration, null, null, upTaskCompletionHandler);
    }
}
