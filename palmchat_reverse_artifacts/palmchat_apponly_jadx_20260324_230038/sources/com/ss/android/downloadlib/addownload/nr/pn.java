package com.ss.android.downloadlib.addownload.nr;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn implements com.ss.android.downloadad.api.u.u {
    public DownloadController b;
    public DownloadEventConfig fx;
    public DownloadModel nr;
    public com.ss.android.downloadad.api.u.nr pn;
    public long u;

    public pn() {
    }

    @Override // com.ss.android.downloadad.api.u.u
    public String a() {
        return this.fx.getRefer();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public String b() {
        return this.nr.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public int bg() {
        return 0;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public int bq() {
        return this.fx.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public DownloadEventConfig c() {
        return this.fx;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public DownloadModel dw() {
        return this.nr;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public boolean fx() {
        return this.nr.isAd();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public String iz() {
        if (this.nr.getDeepLink() != null) {
            return this.nr.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public String jk() {
        return this.fx.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public Object k() {
        return this.fx.getExtraEventObject();
    }

    public boolean kj() {
        if (qq()) {
            return false;
        }
        if (!this.nr.isAd()) {
            return this.nr instanceof AdDownloadModel;
        }
        DownloadModel downloadModel = this.nr;
        return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.fx instanceof AdDownloadEventConfig) && (this.b instanceof AdDownloadController);
    }

    @Override // com.ss.android.downloadad.api.u.u
    public long l() {
        return this.nr.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public boolean mv() {
        return this.fx.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public JSONObject my() {
        return this.fx.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public int n() {
        if (this.b.getDownloadMode() == 2) {
            return 2;
        }
        return this.nr.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public long nr() {
        return this.nr.getId();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public boolean o() {
        return this.b.enableNewActivity();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public String pn() {
        return this.nr.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public DownloadController q() {
        return this.b;
    }

    public boolean qq() {
        DownloadModel downloadModel;
        if (this.u == 0 || (downloadModel = this.nr) == null || this.fx == null || this.b == null) {
            return true;
        }
        return downloadModel.isAd() && this.u <= 0;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public List<String> s() {
        return this.nr.getClickTrackUrl();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public JSONObject sx() {
        return this.nr.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public JSONObject t() {
        return this.fx.getParamsJson();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public String u() {
        return this.nr.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public JSONObject x() {
        return this.nr.getExtra();
    }

    public pn(long j, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.u = j;
        this.nr = downloadModel;
        this.fx = downloadEventConfig;
        this.b = downloadController;
    }
}
