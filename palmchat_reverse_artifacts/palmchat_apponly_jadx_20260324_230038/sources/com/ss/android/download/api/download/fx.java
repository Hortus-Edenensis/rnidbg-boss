package com.ss.android.download.api.download;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class fx implements DownloadEventConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10576a;
    private String b;
    private String fx;
    private String iz;
    private String jk;
    private boolean k;
    private Object l;
    private boolean mv;
    private String my;
    private String n;
    private boolean nr;
    private String o;
    private String pn;
    private boolean s;
    private String t;
    private String u;
    private String x;

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f10577a;
        private String b;
        private String fx;
        private String iz;
        private String jk;
        private boolean k;
        private Object l;
        private boolean mv;
        private String my;
        private String n;
        private boolean nr;
        private String o;
        private String pn;
        private boolean s;
        private String t;
        private String u;
        private String x;

        public fx u() {
            return new fx(this);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.u;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.iz;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.x;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.fx;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.pn;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.b;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.l;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.o;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.jk;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.nr;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.mv;
    }

    public fx() {
    }

    private fx(u uVar) {
        this.u = uVar.u;
        this.nr = uVar.nr;
        this.fx = uVar.fx;
        this.b = uVar.b;
        this.pn = uVar.pn;
        this.iz = uVar.iz;
        this.x = uVar.x;
        this.n = uVar.n;
        this.f10576a = uVar.f10577a;
        this.jk = uVar.jk;
        this.t = uVar.t;
        this.l = uVar.l;
        this.mv = uVar.mv;
        this.s = uVar.s;
        this.k = uVar.k;
        this.my = uVar.my;
        this.o = uVar.o;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }
}
