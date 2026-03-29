package com.ss.android.downloadad.api.u;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.l;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10582a;
    private long ay;
    public final AtomicBoolean b;
    private String bc;
    private int bf;
    private String bg;
    private String bq;
    private long c;
    private int cj;
    private long d;
    private boolean dw;
    private String eh;
    private boolean f;
    public final AtomicBoolean fx;
    private boolean gc;
    private boolean ge;
    private int gi;
    private long h;
    private long iz;
    private int ja;
    private String jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private boolean f10583jp;
    private long ju;
    private int k;
    private boolean kj;
    private boolean kw;
    private String l;
    private boolean lf;
    private boolean m;
    private boolean mh;
    private long mk;
    private String mv;
    private int my;
    private String n;
    private boolean nb;
    protected boolean nr;
    private int o;
    private boolean oa;
    private String ob;
    private transient boolean p;
    private boolean pb;
    public final AtomicBoolean pn;
    private JSONObject q;
    private int qq;
    private long rh;
    private boolean rv;
    private int s;
    private long su;
    private String sx;
    private String t;

    @AdBaseConstants.FunnelType
    private int tk;
    private boolean tm;
    protected boolean u;
    private long v;
    private boolean w;
    private long wi;
    private String wq;
    private long x;
    private String xg;
    private String xw;
    private boolean y;
    private boolean yd;
    private int z;
    private boolean za;

    private nr() {
        this.f10582a = 1;
        this.dw = true;
        this.kj = false;
        this.z = 0;
        this.gi = 0;
        this.pb = false;
        this.m = false;
        this.f10583jp = true;
        this.y = true;
        this.u = true;
        this.nr = true;
        this.fx = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.pn = new AtomicBoolean(false);
        this.tk = 1;
        this.mh = true;
        this.mk = -1L;
    }

    public void a(int i) {
        this.tk = i;
    }

    public String ay() {
        return this.xg;
    }

    public void b(int i) {
        this.bf = i;
    }

    public long bc() {
        return this.mk;
    }

    public String bf() {
        return this.wq;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public int bg() {
        return this.qq;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public int bq() {
        return -1;
    }

    public void c(boolean z) {
        this.ge = z;
    }

    public boolean cj() {
        return this.nb;
    }

    public long d() {
        long j = this.d;
        return j == 0 ? this.c : j;
    }

    public void dw(boolean z) {
        this.nr = z;
    }

    public boolean eh() {
        return this.p;
    }

    public String f() {
        return this.ob;
    }

    public void fx(long j) {
        this.rh = j;
    }

    public boolean gc() {
        return this.f;
    }

    public AdDownloadEventConfig ge() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.bc).setRefer(this.xw).setIsEnableV3Event(this.oa).build();
    }

    public synchronized void gi() {
        this.gi++;
    }

    public long h() {
        return this.h;
    }

    public void iz(long j) {
        if (j > 0) {
            this.c = j;
        }
    }

    public int ja() {
        return this.bf;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public String jk() {
        return this.bc;
    }

    public int jp() {
        return this.cj;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public Object k() {
        return null;
    }

    public synchronized void kj() {
        this.z++;
    }

    public boolean kw() {
        return this.ge;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public long l() {
        return this.x;
    }

    public boolean lf() {
        return this.kw;
    }

    public String m() {
        return this.sx;
    }

    public long mh() {
        return this.su;
    }

    public boolean mk() {
        return this.tm;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public boolean mv() {
        return this.oa;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public JSONObject my() {
        return null;
    }

    public void n(int i) {
        this.cj = i;
    }

    public boolean nb() {
        return this.za;
    }

    public void nr(int i) {
        this.gi = i;
    }

    public void o(boolean z) {
        this.yd = z;
    }

    public int oa() {
        return this.k;
    }

    public AdDownloadController ob() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.kj).setLinkMode(this.k).setDownloadMode(this.my).setEnableShowComplianceDialog(this.mh).setEnableAH(this.u).setEnableAM(this.nr).build();
    }

    public boolean p() {
        return this.rv;
    }

    public long pb() {
        return this.c;
    }

    public void pn(long j) {
        this.x = j;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public DownloadController q() {
        return ob();
    }

    public int qq() {
        return this.z;
    }

    public int rh() {
        return this.ja;
    }

    public AdDownloadModel rv() {
        return new AdDownloadModel.Builder().setAdId(this.iz).setExtraValue(this.x).setLogExtra(this.n).setPackageName(this.jk).setExtra(this.q).setIsAd(this.dw).setVersionCode(this.o).setVersionName(this.sx).setDownloadUrl(this.t).setModelType(this.s).setMimeType(this.xg).setAppName(this.bg).setAppIcon(this.bq).setTaskKey(this.ob).setDeepLink(new DeepLink(this.l, this.mv, null)).build();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public List<String> s() {
        return null;
    }

    public long su() {
        return this.wi;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public JSONObject sx() {
        return null;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public JSONObject t() {
        return null;
    }

    public boolean tk() {
        return this.w;
    }

    public JSONObject tm() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.iz);
            jSONObject.put("mExtValue", this.x);
            jSONObject.put("mLogExtra", this.n);
            jSONObject.put("mDownloadStatus", this.f10582a);
            jSONObject.put("mPackageName", this.jk);
            jSONObject.put("mIsAd", this.dw);
            jSONObject.put("mTimeStamp", this.c);
            jSONObject.put("mExtras", this.q);
            jSONObject.put("mVersionCode", this.o);
            jSONObject.put("mVersionName", this.sx);
            jSONObject.put("mDownloadId", this.qq);
            jSONObject.put("mIsV3Event", this.oa);
            jSONObject.put("mScene", this.cj);
            jSONObject.put("mEventTag", this.bc);
            jSONObject.put("mEventRefer", this.xw);
            jSONObject.put("mDownloadUrl", this.t);
            jSONObject.put("mEnableBackDialog", this.kj);
            jSONObject.put("hasSendInstallFinish", this.fx.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.b.get());
            jSONObject.put("hasDoRebootMarketInstallFinishCheck", this.pn.get());
            jSONObject.put("mLastFailedErrCode", this.bf);
            jSONObject.put("mLastFailedErrMsg", this.wq);
            jSONObject.put("mOpenUrl", this.l);
            jSONObject.put("mLinkMode", this.k);
            jSONObject.put("mDownloadMode", this.my);
            jSONObject.put("mModelType", this.s);
            jSONObject.put("mAppName", this.bg);
            jSONObject.put("mAppIcon", this.bq);
            jSONObject.put("mDownloadFailedTimes", this.z);
            long j = this.d;
            if (j == 0) {
                j = this.c;
            }
            jSONObject.put("mRecentDownloadResumeTime", j);
            jSONObject.put("mClickPauseTimes", this.gi);
            jSONObject.put("mJumpInstallTime", this.h);
            jSONObject.put("mCancelInstallTime", this.rh);
            jSONObject.put("mLastFailedResumeCount", this.ja);
            jSONObject.put("mIsUpdateDownload", this.pb);
            jSONObject.put("mOriginMimeType", this.xg);
            jSONObject.put("mIsPatchApplyHandled", this.m);
            jSONObject.put("downloadFinishReason", this.eh);
            jSONObject.put("clickDownloadTime", this.wi);
            jSONObject.put("clickDownloadSize", this.su);
            jSONObject.put("installAfterCleanSpace", this.w);
            jSONObject.put("funnelType", this.tk);
            jSONObject.put("webUrl", this.mv);
            jSONObject.put("enableShowComplianceDialog", this.mh);
            jSONObject.put("isAutoDownloadOnCardShow", this.yd);
            int i = 1;
            jSONObject.put("enable_new_activity", this.f10583jp ? 1 : 0);
            jSONObject.put("enable_pause", this.y ? 1 : 0);
            jSONObject.put("enable_ah", this.u ? 1 : 0);
            if (!this.nr) {
                i = 0;
            }
            jSONObject.put("enable_am", i);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.ge));
            jSONObject.put("task_key", this.ob);
            jSONObject.putOpt("market_install_finish_check_start_timestamp", Long.valueOf(this.ju));
            jSONObject.putOpt("download_pause_timestamp", Long.valueOf(this.ay));
            jSONObject.putOpt("download_finish_timestamp", Long.valueOf(this.v));
        } catch (Exception e) {
            l.bq().u(e, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    public void u(int i) {
        this.z = i;
    }

    public boolean v() {
        return this.m;
    }

    public String w() {
        return this.eh;
    }

    public boolean wi() {
        return this.gc;
    }

    public int wq() {
        return this.f10582a;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public JSONObject x() {
        return this.q;
    }

    public int xg() {
        return this.o;
    }

    public String xw() {
        return this.bg;
    }

    public boolean y() {
        return this.kj;
    }

    public boolean yd() {
        return this.pb;
    }

    public int z() {
        return this.gi;
    }

    public long za() {
        return this.ju;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public String a() {
        return this.xw;
    }

    public void b(long j) {
        this.iz = j;
    }

    public void bg(boolean z) {
        this.y = z;
    }

    public void bq(boolean z) {
        this.u = z;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public DownloadEventConfig c() {
        return ge();
    }

    @Override // com.ss.android.downloadad.api.u.u
    public DownloadModel dw() {
        return rv();
    }

    public void fx(int i) {
        this.ja = i;
    }

    public void iz(int i) {
        this.o = i;
    }

    public void jk(String str) {
        this.bg = str;
    }

    public void k(boolean z) {
        this.rv = z;
    }

    public void l(int i) {
        this.s = i;
    }

    public void mv(String str) {
        this.xg = str;
    }

    public void my(boolean z) {
        this.mh = z;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public int n() {
        return this.tk;
    }

    public void nr(long j) {
        this.h = j;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public boolean o() {
        return this.f10583jp;
    }

    public void pn(int i) {
        this.f10582a = i;
    }

    public void s(boolean z) {
        this.tm = z;
    }

    public void sx(boolean z) {
        this.f10583jp = z;
    }

    public void t(String str) {
        this.bq = str;
    }

    public void u(long j) {
        this.d = j;
    }

    public void x(int i) {
        this.qq = i;
    }

    public void a(String str) {
        this.l = str;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public String b() {
        return this.n;
    }

    public void fx(String str) {
        this.n = str;
    }

    public void iz(String str) {
        this.bc = str;
    }

    public void jk(int i) {
        this.k = i;
    }

    public void l(String str) {
        this.eh = str;
    }

    public void mv(boolean z) {
        this.f = z;
    }

    public void n(String str) {
        this.t = str;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public long nr() {
        return this.iz;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public String pn() {
        return this.jk;
    }

    public void s(String str) {
        this.ob = str;
    }

    public void t(int i) {
        this.my = i;
    }

    public void u(String str) {
        this.wq = str;
    }

    public void x(String str) {
        this.xw = str;
    }

    public void a(long j) {
        this.su = j;
    }

    public void b(String str) {
        this.sx = str;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public boolean fx() {
        return this.dw;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public String iz() {
        return this.l;
    }

    public void jk(boolean z) {
        this.p = z;
    }

    public void l(boolean z) {
        this.za = z;
    }

    public void n(long j) {
        this.wi = j;
    }

    public void nr(String str) {
        this.jk = str;
    }

    public void pn(String str) {
        this.mv = str;
    }

    public void t(boolean z) {
        this.kw = z;
    }

    public void u(boolean z) {
        this.dw = z;
    }

    public void x(long j) {
        this.mk = j;
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void b(boolean z) {
        this.lf = z;
    }

    public void fx(boolean z) {
        this.kj = z;
    }

    public void iz(boolean z) {
        this.w = z;
    }

    public void jk(long j) {
        this.ju = j;
    }

    public void l(long j) {
        this.v = j;
    }

    public void n(boolean z) {
        this.pb = z;
    }

    public void nr(boolean z) {
        this.oa = z;
    }

    public void pn(boolean z) {
        this.nb = z;
    }

    public void t(long j) {
        this.ay = j;
    }

    public void u(JSONObject jSONObject) {
        this.q = jSONObject;
    }

    public void x(boolean z) {
        this.gc = z;
    }

    public static nr nr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        nr nrVar = new nr();
        try {
            nrVar.b(com.ss.android.download.api.fx.nr.u(jSONObject, "mId"));
            nrVar.pn(com.ss.android.download.api.fx.nr.u(jSONObject, "mExtValue"));
            nrVar.fx(jSONObject.optString("mLogExtra"));
            nrVar.pn(jSONObject.optInt("mDownloadStatus"));
            nrVar.nr(jSONObject.optString("mPackageName"));
            boolean z = true;
            nrVar.u(jSONObject.optBoolean("mIsAd", true));
            nrVar.iz(com.ss.android.download.api.fx.nr.u(jSONObject, "mTimeStamp"));
            nrVar.iz(jSONObject.optInt("mVersionCode"));
            nrVar.b(jSONObject.optString("mVersionName"));
            nrVar.x(jSONObject.optInt("mDownloadId"));
            nrVar.nr(jSONObject.optBoolean("mIsV3Event"));
            nrVar.n(jSONObject.optInt("mScene"));
            nrVar.iz(jSONObject.optString("mEventTag"));
            nrVar.x(jSONObject.optString("mEventRefer"));
            nrVar.n(jSONObject.optString("mDownloadUrl"));
            nrVar.fx(jSONObject.optBoolean("mEnableBackDialog"));
            nrVar.fx.set(jSONObject.optBoolean("hasSendInstallFinish"));
            nrVar.b.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            nrVar.pn.set(jSONObject.optBoolean("hasDoRebootMarketInstallFinishCheck"));
            nrVar.b(jSONObject.optInt("mLastFailedErrCode"));
            nrVar.u(jSONObject.optString("mLastFailedErrMsg"));
            nrVar.a(jSONObject.optString("mOpenUrl"));
            nrVar.jk(jSONObject.optInt("mLinkMode"));
            nrVar.t(jSONObject.optInt("mDownloadMode"));
            nrVar.l(jSONObject.optInt("mModelType"));
            nrVar.jk(jSONObject.optString("mAppName"));
            nrVar.t(jSONObject.optString("mAppIcon"));
            nrVar.u(jSONObject.optInt("mDownloadFailedTimes", 0));
            nrVar.u(com.ss.android.download.api.fx.nr.u(jSONObject, "mRecentDownloadResumeTime"));
            nrVar.nr(jSONObject.optInt("mClickPauseTimes"));
            nrVar.nr(com.ss.android.download.api.fx.nr.u(jSONObject, "mJumpInstallTime"));
            nrVar.fx(com.ss.android.download.api.fx.nr.u(jSONObject, "mCancelInstallTime"));
            nrVar.fx(jSONObject.optInt("mLastFailedResumeCount"));
            nrVar.l(jSONObject.optString("downloadFinishReason"));
            nrVar.a(jSONObject.optLong("clickDownloadSize"));
            nrVar.n(jSONObject.optLong("clickDownloadTime"));
            nrVar.n(jSONObject.optBoolean("mIsUpdateDownload"));
            nrVar.mv(jSONObject.optString("mOriginMimeType"));
            nrVar.a(jSONObject.optBoolean("mIsPatchApplyHandled"));
            nrVar.iz(jSONObject.optBoolean("installAfterCleanSpace"));
            nrVar.a(jSONObject.optInt("funnelType", 1));
            nrVar.pn(jSONObject.optString("webUrl"));
            nrVar.my(jSONObject.optBoolean("enableShowComplianceDialog", true));
            nrVar.o(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            nrVar.sx(jSONObject.optInt("enable_new_activity", 1) == 1);
            nrVar.bg(jSONObject.optInt("enable_pause", 1) == 1);
            nrVar.bq(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            nrVar.dw(z);
            nrVar.u(jSONObject.optJSONObject("mExtras"));
            nrVar.c(jSONObject.optBoolean("intent_jump_browser_success"));
            nrVar.s(jSONObject.optString("task_key"));
            nrVar.jk(jSONObject.optLong("market_install_finish_check_start_timestamp"));
            nrVar.t(jSONObject.optLong("download_pause_timestamp", 0L));
            nrVar.l(jSONObject.optLong("download_finish_timestamp", 0L));
        } catch (Exception e) {
            l.bq().u(e, "NativeDownloadModel fromJson");
        }
        return nrVar;
    }

    @Override // com.ss.android.downloadad.api.u.u
    public String u() {
        return this.t;
    }

    public nr(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public nr(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i) {
        this.f10582a = 1;
        this.dw = true;
        this.kj = false;
        this.z = 0;
        this.gi = 0;
        this.pb = false;
        this.m = false;
        this.f10583jp = true;
        this.y = true;
        this.u = true;
        this.nr = true;
        this.fx = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.pn = new AtomicBoolean(false);
        this.tk = 1;
        this.mh = true;
        this.mk = -1L;
        this.iz = downloadModel.getId();
        this.x = downloadModel.getExtraValue();
        this.n = downloadModel.getLogExtra();
        this.jk = downloadModel.getPackageName();
        this.q = downloadModel.getExtra();
        this.dw = downloadModel.isAd();
        this.o = downloadModel.getVersionCode();
        this.sx = downloadModel.getVersionName();
        this.t = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.l = downloadModel.getDeepLink().getOpenUrl();
            this.mv = downloadModel.getDeepLink().getWebUrl();
        }
        this.s = downloadModel.getModelType();
        this.bg = downloadModel.getName();
        this.bq = downloadModel.getAppIcon();
        this.xg = downloadModel.getMimeType();
        this.bc = downloadEventConfig.getClickButtonTag();
        this.xw = downloadEventConfig.getRefer();
        this.oa = downloadEventConfig.isEnableV3Event();
        this.kj = downloadController.isEnableBackDialog();
        this.k = downloadController.getLinkMode();
        this.my = downloadController.getDownloadMode();
        this.mh = downloadController.enableShowComplianceDialog();
        this.yd = downloadController.isAutoDownloadOnCardShow();
        this.f10583jp = downloadController.enableNewActivity();
        this.u = downloadController.enableAH();
        this.nr = downloadController.enableAM();
        this.qq = i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.c = jCurrentTimeMillis;
        this.d = jCurrentTimeMillis;
        this.m = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.ob = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }
}
