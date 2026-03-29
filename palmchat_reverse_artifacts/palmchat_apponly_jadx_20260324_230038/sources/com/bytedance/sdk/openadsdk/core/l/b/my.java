package com.bytedance.sdk.openadsdk.core.l.b;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.l.b.fx;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.huawei.hms.ads.ex;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.bq;
import com.ss.android.download.api.config.DownloadMarketInterceptor;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import defpackage.ll7;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class my extends com.bytedance.sdk.openadsdk.core.bc.b {
    private static volatile my u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f5329a;
    private final Context nr;
    private Map<Integer, AdDownloadModel.Builder> fx = new ConcurrentHashMap();
    private Map<Integer, AdDownloadModel> b = new ConcurrentHashMap();
    private Map<Integer, AdDownloadController.Builder> pn = new ConcurrentHashMap();
    private Map<Integer, AdDownloadController> iz = new ConcurrentHashMap();
    private Map<Integer, AdDownloadEventConfig.Builder> x = new ConcurrentHashMap();
    private Map<Integer, AdDownloadEventConfig> n = new ConcurrentHashMap();

    private my(Context context) {
        this.nr = context;
    }

    private IDownloadButtonClickListener a(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        return null;
    }

    private DownloadEventConfig b(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    private AdDownloadController df(int i) {
        return this.iz.get(Integer.valueOf(i));
    }

    private void dj(int i) {
        this.fx.remove(Integer.valueOf(i));
        this.b.remove(Integer.valueOf(i));
        this.pn.remove(Integer.valueOf(i));
        this.iz.remove(Integer.valueOf(i));
        this.x.remove(Integer.valueOf(i));
        this.n.remove(Integer.valueOf(i));
    }

    private AdDownloadModel ex(int i) {
        return this.b.get(Integer.valueOf(i));
    }

    private static boolean fx() {
        Field declaredField;
        try {
            try {
                declaredField = com.ss.android.downloadlib.b.class.getDeclaredField("nr");
                declaredField.setAccessible(true);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            Field declaredField2 = com.ss.android.downloadlib.b.class.getDeclaredField("u");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(null);
            if (obj instanceof Integer) {
                int iIntValue = ((Integer) obj).intValue();
                return iIntValue > 107000925 || (iIntValue <= 4061200 && iIntValue > 3000000);
            }
        }
        return declaredField.get(null) instanceof Integer;
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private int hs(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return 0;
        }
        return adDownloadControllerDf.getDownloadMode();
    }

    private com.bytedance.sdk.openadsdk.my.fx.u.u iz(Object obj) {
        if (obj instanceof Function) {
            return new com.bytedance.sdk.openadsdk.my.fx.u.u(obj);
        }
        return null;
    }

    private int ki(int i) {
        return i + 1;
    }

    private OnItemClickListener n(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        return null;
    }

    private Function<SparseArray<Object>, Object> nr() {
        Function<SparseArray<Object>, Object> function = this.f5329a;
        if (function != null) {
            return function;
        }
        if (!com.bytedance.sdk.openadsdk.my.fx.b.nr(d.fx)) {
            return null;
        }
        this.f5329a = com.bytedance.sdk.openadsdk.core.n.o().iz(3);
        HashMap map = new HashMap();
        map.put("n", com.bytedance.sdk.openadsdk.core.n.o().y());
        this.f5329a.apply(com.bytedance.sdk.openadsdk.my.b.u().u(159).u(Map.class).u(0, map).nr());
        return this.f5329a;
    }

    private DownloadController pn(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    private AdDownloadModel.Builder tr(int i) {
        return this.fx.get(Integer.valueOf(i));
    }

    public static my u(Context context) {
        if (u == null) {
            synchronized (my.class) {
                if (u == null) {
                    u = new my(context);
                }
            }
        }
        return u;
    }

    private DownloadMarketInterceptor x(Object obj) {
        if (obj instanceof DownloadMarketInterceptor) {
            return (DownloadMarketInterceptor) obj;
        }
        return null;
    }

    private AdDownloadEventConfig zq(int i) {
        return this.n.get(Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return i == -99999986 ? (T) u().sparseArray() : (T) call(i, pluginValueSet, cls);
    }

    public void ay(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return;
        }
        adDownloadModelEx.forceWifi();
    }

    public String bc(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? "" : adDownloadModelEx.getName();
    }

    public long bf(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return 0L;
        }
        return adDownloadModelEx.getId();
    }

    public String bg(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        return adDownloadEventConfigZq == null ? "" : adDownloadEventConfigZq.getClickItemTag();
    }

    public String bq(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        return adDownloadEventConfigZq == null ? "" : adDownloadEventConfigZq.getClickLabel();
    }

    public String c(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        return adDownloadEventConfigZq == null ? "" : adDownloadEventConfigZq.getClickPauseLabel();
    }

    public <T> T call(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i != 20) {
            return (T) u(cls, i, (pluginValueSet == null || pluginValueSet.objectValue(0, Map.class) == null) ? new HashMap<>() : (Map) pluginValueSet.objectValue(0, Map.class));
        }
        u((Bundle) pluginValueSet.objectValue(0, Bundle.class));
        return null;
    }

    public boolean cj(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return true;
        }
        return adDownloadModelEx.isShowNotification();
    }

    public boolean d(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return true;
        }
        return adDownloadEventConfigZq.isEnableClickEvent();
    }

    public String dc(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? "" : adDownloadModelEx.getStartToast();
    }

    public String dw(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        return adDownloadEventConfigZq == null ? "" : adDownloadEventConfigZq.getClickStartLabel();
    }

    public void eh(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return;
        }
        adDownloadModelEx.forceHideToast();
    }

    public String f(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? "" : adDownloadModelEx.getPackageName();
    }

    public int gc(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return 0;
        }
        return adDownloadModelEx.getVersionCode();
    }

    public JSONObject ge(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.getExtra();
    }

    public int gi(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return 0;
        }
        return adDownloadEventConfigZq.getDownloadScene();
    }

    public boolean h(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return false;
        }
        return adDownloadEventConfigZq.isEnableV3Event();
    }

    public boolean i(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return false;
        }
        return adDownloadModelEx.distinctDir();
    }

    public JSONObject ja(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return null;
        }
        return adDownloadEventConfigZq.getParamsJson();
    }

    public Object jk(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return null;
        }
        return adDownloadControllerDf.getExtraObject();
    }

    public List<String> jp(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.getBackupUrls();
    }

    public com.ss.android.download.api.model.b ju(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.getQuickAppModel();
    }

    public boolean jw(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? com.ss.android.download.api.fx.nr.u(com.ss.android.socialbase.downloader.n.u.u(v(i)), xw(i)) : adDownloadModelEx.shouldDownloadWithPatchApply();
    }

    public boolean k(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return false;
        }
        return adDownloadControllerDf.enableAM();
    }

    public String kj(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        return adDownloadEventConfigZq == null ? "" : adDownloadEventConfigZq.getStorageDenyLabel();
    }

    public String kw(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? "" : adDownloadModelEx.getLogExtra();
    }

    public boolean l(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return false;
        }
        return adDownloadControllerDf.isAutoDownloadOnCardShow();
    }

    public void lf(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return;
        }
        adDownloadModelEx.forceHideNotification();
    }

    public String m(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? "" : adDownloadModelEx.getDownloadUrl();
    }

    public String mh(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? "" : adDownloadModelEx.getFilePath();
    }

    public String mk(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? "" : adDownloadModelEx.getVersionName();
    }

    public boolean mv(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return false;
        }
        return adDownloadControllerDf.enableNewActivity();
    }

    public boolean my(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return false;
        }
        return adDownloadControllerDf.enableOppoAutoDownload();
    }

    public boolean nb(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return false;
        }
        return adDownloadModelEx.needIndependentProcess();
    }

    public String o(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        return adDownloadEventConfigZq == null ? "" : adDownloadEventConfigZq.getRefer();
    }

    public Map<String, String> oa(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.getHeaders();
    }

    public int ob(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return 0;
        }
        return adDownloadModelEx.getModelType();
    }

    public boolean p(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return true;
        }
        return adDownloadModelEx.isAd();
    }

    public long pb(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return 0L;
        }
        return adDownloadModelEx.getExpectFileLength();
    }

    public String q(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        return adDownloadEventConfigZq == null ? "" : adDownloadEventConfigZq.getClickPauseLabel();
    }

    public boolean qe(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return true;
        }
        return adDownloadModelEx.enablePause();
    }

    public String qq(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        return adDownloadEventConfigZq == null ? "" : adDownloadEventConfigZq.getClickInstallLabel();
    }

    public int rg(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return 1;
        }
        return adDownloadModelEx.getFunnelType();
    }

    public JSONObject rh(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return null;
        }
        return adDownloadEventConfigZq.getExtraJson();
    }

    public List<String> rv(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.getClickTrackUrl();
    }

    public boolean s(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return false;
        }
        return adDownloadControllerDf.enableAH();
    }

    public boolean sf(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return true;
        }
        return adDownloadModelEx.isAutoInstall();
    }

    public boolean su(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return false;
        }
        return adDownloadModelEx.isInExternalPublicDir();
    }

    public String sx(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        return adDownloadEventConfigZq == null ? "" : adDownloadEventConfigZq.getClickButtonTag();
    }

    public boolean t(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return false;
        }
        return adDownloadControllerDf.enableShowComplianceDialog();
    }

    public boolean tk(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return false;
        }
        return adDownloadModelEx.isNeedWifi();
    }

    public DeepLink tm(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.getDeepLink();
    }

    public String ua(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? "" : adDownloadModelEx.getStartToast();
    }

    public int uq(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return 2;
        }
        return adDownloadModelEx.getExecutorGroup();
    }

    public JSONObject v(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.getDownloadSettings();
    }

    public boolean w(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return true;
        }
        return adDownloadModelEx.isShowToast();
    }

    public boolean wi(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return false;
        }
        return adDownloadModelEx.isInExternalPublicDir();
    }

    public String wq(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? "" : adDownloadModelEx.getMd5();
    }

    public long xg(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return 0L;
        }
        return adDownloadModelEx.getExtraValue();
    }

    public String xw(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? "" : adDownloadModelEx.getMimeType();
    }

    public String y(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? "" : adDownloadModelEx.getNotificationJumpUrl();
    }

    public String yd(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? "" : adDownloadModelEx.getFileName();
    }

    public Object z(int i) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return null;
        }
        return adDownloadEventConfigZq.getExtraEventObject();
    }

    public String za(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        return adDownloadModelEx == null ? "" : adDownloadModelEx.getAppIcon();
    }

    public boolean zx(int i) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return false;
        }
        return adDownloadModelEx.autoInstallWithoutNotification();
    }

    private void b(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get("clickButtonTag");
        String str2 = (String) map.get("clickItemTag");
        String str3 = (String) map.get("clickStartLabel");
        String str4 = (String) map.get("clickContinueLabel");
        String str5 = (String) map.get("clickPauseLabel");
        String str6 = (String) map.get("storageDenyLabel");
        String str7 = (String) map.get("clickInstallLabel");
        boolean zBooleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get("extraEventObject");
        AdDownloadEventConfig.Builder isEnableV3Event = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickStartLabel(str3).setClickContinueLabel(str4).setClickPauseLabel(str5).setStorageDenyLabel(str6).setClickInstallLabel(str7).setIsEnableClickEvent(zBooleanValue).setIsEnableV3Event(zBooleanValue2);
        this.x.put(Integer.valueOf(i), isEnableV3Event);
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.n.put(Integer.valueOf(i), isEnableV3Event.build());
    }

    private void iz(int i, int i2) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return;
        }
        adDownloadControllerDf.setDownloadMode(i2);
    }

    private void pn(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get("clickButtonTag");
        String str2 = (String) map.get("clickItemTag");
        String str3 = (String) map.get("clickLabel");
        int iIntValue = ((Integer) map.get(WfConstant.EVENT_KEY_DOWNLOAD_SCENE)).intValue();
        String str4 = (String) map.get("refer");
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        JSONObject jSONObject2 = (JSONObject) map.get("paramsJson");
        String str5 = (String) map.get("clickStartLabel");
        String str6 = (String) map.get("clickContinueLabel");
        String str7 = (String) map.get("clickPauseLabel");
        String str8 = (String) map.get("storageDenyLabel");
        String str9 = (String) map.get("clickInstallLabel");
        boolean zBooleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject3 = (JSONObject) map.get("extraEventObject");
        AdDownloadEventConfig.Builder paramsJson = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickLabel(str3).setClickStartLabel(str5).setClickContinueLabel(str6).setClickPauseLabel(str7).setStorageDenyLabel(str8).setClickInstallLabel(str9).setIsEnableClickEvent(zBooleanValue).setDownloadScene(iIntValue).setIsEnableV3Event(zBooleanValue2).setRefer(str4).setExtraJson(jSONObject).setParamsJson(jSONObject2);
        this.x.put(Integer.valueOf(i), paramsJson);
        if (jSONObject3 != null) {
            paramsJson.setExtraEventObject(jSONObject3);
        }
        this.n.put(Integer.valueOf(i), paramsJson.build());
    }

    public JSONObject a(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return null;
        }
        return adDownloadControllerDf.getExtraJson();
    }

    public AdDownloadModel jk(int i, String str) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setPackageName(str);
    }

    public AdDownloadModel k(int i, String str) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setFilePath(str);
    }

    public AdDownloadModel l(int i, String str) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setDownloadUrl(str);
    }

    public AdDownloadModel mv(int i, String str) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setNotificationJumpUrl(str);
    }

    public AdDownloadModel my(int i, String str) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setFileName(str);
    }

    public int n(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return 0;
        }
        return adDownloadControllerDf.getInterceptFlag();
    }

    public AdDownloadModel o(int i, String str) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setVersionName(str);
    }

    public AdDownloadModel s(int i, String str) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setMimeType(str);
    }

    public AdDownloadModel t(int i, String str) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setAppIcon(str);
    }

    public boolean x(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return false;
        }
        return adDownloadControllerDf.shouldUseNewWebView();
    }

    public AdDownloadModel a(int i, String str) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setLogExtra(str);
    }

    public int iz(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return 1;
        }
        return adDownloadControllerDf.getDowloadChunkCount();
    }

    public void n(int i, String str) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return;
        }
        adDownloadModelEx.setSdkMonitorScene(str);
    }

    public void x(int i, String str) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return;
        }
        adDownloadModelEx.setStartToast(str);
    }

    private void iz(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long jLongValue = ((Long) map.get("expectFileLength")).longValue();
        String str = (String) map.get("md5");
        long jLongValue2 = ((Long) map.get("extraValue")).longValue();
        boolean zBooleanValue = ((Boolean) map.get("isAd")).booleanValue();
        int iIntValue = ((Integer) map.get("modelType")).intValue();
        List<String> list = (List) map.get("clickTrackUrl");
        List<String> list2 = (List) map.get("backupUrls");
        String str2 = (String) map.get("notificationJumpUrl");
        String str3 = (String) map.get("mimeType");
        Map<String, String> map2 = (Map) map.get("headers");
        boolean zBooleanValue2 = ((Boolean) map.get("isShowToast")).booleanValue();
        boolean zBooleanValue3 = ((Boolean) map.get("needWifi")).booleanValue();
        String str4 = (String) map.get("fileName");
        int iIntValue2 = ((Integer) map.get(az.aW)).intValue();
        String str5 = (String) map.get("versionName");
        String str6 = (String) map.get("quickAppModelOpenUrl");
        com.ss.android.download.api.model.b bVarU = new b.u().u(str6).nr((String) map.get("quickAppModelExtraData")).u();
        int iIntValue3 = ((Integer) map.get("executorGroup")).intValue();
        String str7 = (String) map.get("startToast");
        String str8 = (String) map.get("sdkMonitorScene");
        boolean zBooleanValue4 = ((Boolean) map.get("autoInstall")).booleanValue();
        boolean zBooleanValue5 = ((Boolean) map.get("distinctDir")).booleanValue();
        boolean zBooleanValue6 = ((Boolean) map.get("enablePause")).booleanValue();
        long jLongValue3 = ((Long) map.get("id")).longValue();
        String str9 = (String) map.get("appIcon");
        boolean zBooleanValue7 = ((Boolean) map.get("isShowNotification")).booleanValue();
        boolean zBooleanValue8 = ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue();
        String str10 = (String) map.get("logExtra");
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        JSONObject jSONObject2 = (JSONObject) map.get("downloadSettings");
        String str11 = (String) map.get("filePath");
        String str12 = (String) map.get("downloadUrl");
        String str13 = (String) map.get(WfConstant.EVENT_KEY_APP_NAME);
        String str14 = (String) map.get("packageName");
        boolean zBooleanValue9 = ((Boolean) map.get("isNeedIndependentProcess")).booleanValue();
        String str15 = (String) map.get("openUrl");
        String str16 = (String) map.get("webTitle");
        String str17 = (String) map.get("webUrl");
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setExpectFileLength(jLongValue).setMd5(str).setId(jLongValue3).setExtraValue(jLongValue2).setIsAd(zBooleanValue).setModelType(iIntValue).setLogExtra(str10).setAppIcon(str9).setBackupUrls(list2).setNotificationJumpUrl(str2).setClickTrackUrl(list).setMimeType(str3).setHeaders(map2).setIsShowToast(zBooleanValue2).setIsShowNotification(zBooleanValue7).setNeedWifi(zBooleanValue3).setFileName(str4).setVersionCode(iIntValue2).setVersionName(str5).setQuickAppModel(bVarU).setAutoInstallWithoutNotification(zBooleanValue8).setExecutorGroup(iIntValue3).setStartToast(str7).setSdkMonitorScene(str8).setAutoInstall(zBooleanValue4).setDistinctDir(zBooleanValue5).setEnablePause(zBooleanValue6).setExtra(jSONObject).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.core.l.b.my.2
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str18, String str19) {
                return my.this.u(str18, str19);
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str11)) {
            fileUriProvider.setFilePath(str11);
        }
        if (!TextUtils.isEmpty(str12)) {
            fileUriProvider.setDownloadUrl(str12);
        }
        if (!TextUtils.isEmpty(str13)) {
            fileUriProvider.setAppName(str13);
        }
        if (!TextUtils.isEmpty(str14)) {
            fileUriProvider.setPackageName(str14);
        }
        fileUriProvider.setNeedIndependentProcess(zBooleanValue9);
        fileUriProvider.setDeepLink(u(jLongValue3, str15, str16, str17));
        this.fx.put(Integer.valueOf(i), fileUriProvider);
        this.b.put(Integer.valueOf(i), fileUriProvider.build());
    }

    public AdDownloadModel a(int i, boolean z) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setAutoInstallWithoutNotification(z);
    }

    public AdDownloadModel n(int i, boolean z) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setNeedIndependentProcess(z);
    }

    public <T> T u(Class<T> cls, int i, Map<String, Object> map) {
        Object obj = map.get("hashCode");
        int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        DownloadModel downloadModelEx = ex(iIntValue);
        switch (i) {
            case 3:
                k.u(((Integer) map.get("hid")).intValue());
                break;
            case 4:
                k.nr().u(downloadModelEx == null ? (String) map.get("downloadUrl") : downloadModelEx.getDownloadUrl(), iIntValue);
                dj(iIntValue);
                break;
            case 5:
                if (downloadModelEx == null) {
                    downloadModelEx = fx(map.get("downloadModel"));
                }
                k.nr().u(this.nr, iIntValue, nr(map.get("downloadStatusChangeListener")), downloadModelEx);
                break;
            case 6:
                break;
            case 7:
                k.fx();
                break;
            case 8:
                k.nr().u(downloadModelEx == null ? (String) map.get("downloadUrl") : downloadModelEx.getDownloadUrl(), ((Boolean) map.get("force")).booleanValue());
                break;
            case 9:
                k.u(((Integer) map.get("hid")).intValue(), (fx.u) map.get("onEventLogHandler"));
                break;
            case 10:
                k.u((String) map.get("downloadPath"));
                break;
            case 12:
                Uri uri = (Uri) map.get(ContentProviderManager.PROVIDER_URI);
                if (downloadModelEx == null) {
                    downloadModelEx = fx(map.get("downloadModel"));
                }
                DownloadModel downloadModel = downloadModelEx;
                DownloadEventConfig downloadEventConfigZq = zq(iIntValue);
                if (downloadEventConfigZq == null) {
                    downloadEventConfigZq = b(map.get("downloadEventConfig"));
                }
                DownloadEventConfig downloadEventConfig = downloadEventConfigZq;
                DownloadController downloadControllerDf = df(iIntValue);
                if (downloadControllerDf == null) {
                    downloadControllerDf = pn(map.get("downloadController"));
                }
                DownloadController downloadController = downloadControllerDf;
                IDownloadButtonClickListener iDownloadButtonClickListenerA = a(map.get("downloadButtonClickListener"));
                if (!u(iDownloadButtonClickListenerA)) {
                }
                break;
            case 13:
                boolean zBooleanValue = ((Boolean) map.get("isDisableDialog")).booleanValue();
                String str = (String) map.get("userAgent");
                if (downloadModelEx == null) {
                    downloadModelEx = fx(map.get("downloadModel"));
                }
                DownloadModel downloadModel2 = downloadModelEx;
                DownloadEventConfig downloadEventConfigZq2 = zq(iIntValue);
                if (downloadEventConfigZq2 == null) {
                    downloadEventConfigZq2 = b(map.get("downloadEventConfig"));
                }
                DownloadEventConfig downloadEventConfig2 = downloadEventConfigZq2;
                DownloadController downloadControllerDf2 = df(iIntValue);
                if (downloadControllerDf2 == null) {
                    downloadControllerDf2 = pn(map.get("downloadController"));
                }
                DownloadController downloadController2 = downloadControllerDf2;
                DownloadStatusChangeListener downloadStatusChangeListenerNr = nr(map.get("downloadStatusChangeListener"));
                IDownloadButtonClickListener iDownloadButtonClickListenerA2 = a(map.get("downloadButtonClickListener"));
                if (u(iDownloadButtonClickListenerA2)) {
                    k.nr().pn().u(this.nr, str, zBooleanValue, downloadModel2, downloadEventConfig2, downloadController2, downloadStatusChangeListenerNr, iIntValue, iDownloadButtonClickListenerA2);
                } else {
                    k.nr().pn().u(this.nr, str, zBooleanValue, downloadModel2, downloadEventConfig2, downloadController2, downloadStatusChangeListenerNr, iIntValue);
                }
                break;
            case 14:
                break;
            case 16:
                String downloadUrl = downloadModelEx == null ? (String) map.get("downloadUrl") : downloadModelEx.getDownloadUrl();
                long jLongValue = downloadModelEx == null ? ((Long) map.get("id")).longValue() : downloadModelEx.getId();
                int iIntValue2 = ((Integer) map.get("action_type_button")).intValue();
                DownloadEventConfig downloadEventConfigZq3 = zq(iIntValue);
                if (downloadEventConfigZq3 == null) {
                    downloadEventConfigZq3 = b(map.get("downloadEventConfig"));
                }
                DownloadEventConfig downloadEventConfig3 = downloadEventConfigZq3;
                AdDownloadController adDownloadControllerDf = df(iIntValue);
                k.nr().u(downloadUrl, jLongValue, iIntValue2, downloadEventConfig3, adDownloadControllerDf == null ? pn(map.get("downloadController")) : adDownloadControllerDf);
                break;
            case 17:
                String downloadUrl2 = downloadModelEx == null ? (String) map.get("downloadUrl") : downloadModelEx.getDownloadUrl();
                long jLongValue2 = ((Long) map.get("id")).longValue();
                int iIntValue3 = ((Integer) map.get("action_type_button")).intValue();
                DownloadEventConfig downloadEventConfigZq4 = zq(iIntValue);
                if (downloadEventConfigZq4 == null) {
                    downloadEventConfigZq4 = b(map.get("downloadEventConfig"));
                }
                DownloadEventConfig downloadEventConfig4 = downloadEventConfigZq4;
                DownloadController downloadControllerDf3 = df(iIntValue);
                if (downloadControllerDf3 == null) {
                    downloadControllerDf3 = pn(map.get("downloadController"));
                }
                k.nr().u(downloadUrl2, jLongValue2, iIntValue3, downloadEventConfig4, downloadControllerDf3, n(map.get("itemClickListener")), a(map.get("downloadButtonClickListener")));
                break;
            case 18:
                T t = (T) Boolean.valueOf(k.nr().pn().u(downloadModelEx == null ? ((Long) map.get("id")).longValue() : downloadModelEx.getId(), iIntValue));
                dj(iIntValue);
                break;
            case 19:
                break;
            case 23:
                if (((Boolean) map.get("mateIsEmpty")).booleanValue()) {
                    AdDownloadModel.Builder builder = new AdDownloadModel.Builder();
                    this.fx.put(Integer.valueOf(iIntValue), builder);
                    this.b.put(Integer.valueOf(iIntValue), builder.build());
                } else {
                    nr(iIntValue, map);
                }
                break;
            case 24:
                u(iIntValue, (String) map.get("appIcon"), (String) map.get(WfConstant.EVENT_KEY_APP_NAME), (String) map.get("packageName"));
                break;
            case 25:
                u(iIntValue, ((Integer) map.get("autoOpen")).intValue(), ((Integer) map.get("downloadMode")).intValue(), ((Boolean) map.get("isHaveDownloadSdkConfig")).booleanValue(), ((Boolean) map.get("isEnableAH")).booleanValue(), ((Boolean) map.get("isEnableAM")).booleanValue());
                break;
            case 26:
                iz(iIntValue, ((Integer) map.get("downloadMode")).intValue());
                break;
            case 28:
                u(iIntValue, ((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue(), x(map.get("downloadMarketInterceptor")));
                break;
            case 29:
                b(iIntValue, map);
                break;
            case 30:
                nr(iIntValue, ((Integer) map.get(WfConstant.EVENT_KEY_DOWNLOAD_SCENE)).intValue());
                break;
            case 31:
                pn(iIntValue, ((Boolean) map.get("isShowToast")).booleanValue());
                break;
            case 32:
                fx(iIntValue, map);
                break;
            case 44:
                u(iIntValue, ((Integer) map.get("linkMode")).intValue());
                break;
            case 46:
                u(iIntValue, ((Boolean) map.get("enableShowComplianceDialog")).booleanValue());
                break;
            case 49:
                nr(iIntValue, ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue());
                break;
            case 50:
                fx(iIntValue, ((Boolean) map.get("enableNewActivity")).booleanValue());
                break;
            case 53:
                u(iIntValue, map.get("extraObject"));
                break;
            case 54:
                u(iIntValue, (JSONObject) map.get("extraJson"));
                break;
            case 56:
                pn(iIntValue, map);
                break;
            case 72:
                nr(iIntValue, map.get("extraEventObject"));
                break;
            case 73:
                u(iIntValue, (String) map.get("clickButtonTag"));
                break;
            case 74:
                nr(iIntValue, (JSONObject) map.get("eventConfigExtraJson"));
                break;
            case 75:
                fx(iIntValue, (JSONObject) map.get("paramsJson"));
                break;
            case 76:
                nr(iIntValue, (String) map.get("clickItemTag"));
                break;
            case 78:
                fx(iIntValue, (String) map.get("refer"));
                break;
            case 79:
                b(iIntValue, (String) map.get("quickAppEventTag"));
                break;
            case 80:
                iz(iIntValue, map);
                break;
            case 98:
                ay(iIntValue);
                break;
            case 100:
                eh(iIntValue);
                break;
            case 101:
                lf(iIntValue);
                break;
            case 123:
                pn(iIntValue, (String) map.get("md5"));
                break;
            case 124:
                u(iIntValue, ((Long) map.get("expectFileLength")).longValue());
                break;
            case 125:
                b(iIntValue, ((Boolean) map.get("needWifi")).booleanValue());
                break;
            case 127:
                nr(iIntValue, ((Long) map.get("extraValue")).longValue());
                break;
            case 128:
                iz(iIntValue, (String) map.get(WfConstant.EVENT_KEY_APP_NAME));
                break;
            case 129:
                b(iIntValue, (JSONObject) map.get("extraJson"));
                break;
            case 130:
                x(iIntValue, (String) map.get("startToast"));
                break;
            case 131:
                n(iIntValue, (String) map.get("sdkMonitorScene"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA /* 132 */:
                fx(iIntValue, ((Long) map.get("id")).longValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START /* 133 */:
                iz(iIntValue, ((Boolean) map.get("isAd")).booleanValue());
                break;
            case 134:
                fx(iIntValue, ((Integer) map.get("modelType")).intValue());
                break;
            case 135:
                a(iIntValue, (String) map.get("logExtra"));
                break;
            case 136:
                jk(iIntValue, (String) map.get("packageName"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME /* 137 */:
                t(iIntValue, (String) map.get("appIcon"));
                break;
            case 139:
                u(iIntValue, (List<String>) map.get("clickTrackUrl"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID /* 140 */:
                l(iIntValue, (String) map.get("downloadUrl"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID /* 141 */:
                nr(iIntValue, (List<String>) map.get("backupUrls"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO /* 142 */:
                mv(iIntValue, (String) map.get("notificationJumpUrl"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE /* 143 */:
                s(iIntValue, (String) map.get("mimeType"));
                break;
            case 144:
                u(iIntValue, (Map<String, String>) map.get("headers"));
                break;
            case 145:
                x(iIntValue, ((Boolean) map.get("isShowNotification")).booleanValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK /* 146 */:
                k(iIntValue, (String) map.get("filePath"));
                break;
            case 147:
                my(iIntValue, (String) map.get("fileName"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK /* 148 */:
                n(iIntValue, ((Boolean) map.get("isNeedIndependentProcess")).booleanValue());
                break;
            case 149:
                b(iIntValue, ((Integer) map.get(az.aW)).intValue());
                break;
            case 150:
                o(iIntValue, (String) map.get("versionName"));
                break;
            case 151:
                u(iIntValue, new b.u().u((String) map.get("quickAppModelOpenUrl")).nr((String) map.get("quickAppModelExtraData")).u());
                break;
            case 152:
                a(iIntValue, ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue());
                break;
            case 153:
                pn(iIntValue, ((Integer) map.get("funnelType")).intValue());
                break;
            case 154:
                u(iIntValue, x(map.get("downloadMarketInterceptor")));
                break;
            case 157:
                Object obj2 = map.get("s");
                if (obj2 instanceof Service) {
                    com.ss.android.socialbase.downloader.downloader.fx.u((Context) obj2);
                }
                break;
            case 158:
                Object obj3 = map.get("i");
                map.get("c");
                if (obj3 instanceof Intent) {
                    Intent intent = (Intent) obj3;
                    if (TextUtils.equals(intent.getAction(), "com.csj.install")) {
                        u(intent);
                    } else {
                        intent.setComponent(new ComponentName(com.ss.android.socialbase.downloader.downloader.fx.oa(), (Class<?>) DownloadHandlerService.class));
                        com.ss.android.socialbase.downloader.downloader.fx.oa().startService(intent);
                    }
                }
                break;
            case 160:
                u(map);
                break;
            case 162:
                Object obj4 = map.get(bq.f.s);
                if (obj4 instanceof TTAdInteractionListener) {
                    k.u((TTAdInteractionListener) obj4);
                }
                break;
        }
        return null;
    }

    public AdDownloadModel x(int i, boolean z) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setIsShowNotification(z);
    }

    private DownloadModel fx(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    private void fx(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int iIntValue = ((Integer) map.get("linkMode")).intValue();
        int iIntValue2 = ((Integer) map.get("downloadMode")).intValue();
        boolean zBooleanValue = ((Boolean) map.get("isEnableBackDialog")).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get("isAddToDownloadManage")).booleanValue();
        map.get("extraOperation");
        boolean zBooleanValue3 = ((Boolean) map.get("shouldUseNewWebView")).booleanValue();
        int iIntValue3 = ((Integer) map.get("interceptFlag")).intValue();
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        Object obj = map.get("extraObject");
        boolean zBooleanValue4 = ((Boolean) map.get("enableShowComplianceDialog")).booleanValue();
        boolean zBooleanValue5 = ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue();
        boolean zBooleanValue6 = ((Boolean) map.get("enableNewActivity")).booleanValue();
        boolean zBooleanValue7 = ((Boolean) map.get("isEnableAH")).booleanValue();
        boolean zBooleanValue8 = ((Boolean) map.get("isEnableAM")).booleanValue();
        AdDownloadController.Builder enableOppoAutoDownload = new AdDownloadController.Builder().setLinkMode(iIntValue).setDownloadMode(iIntValue2).setIsEnableBackDialog(zBooleanValue).setIsAddToDownloadManage(zBooleanValue2).setShouldUseNewWebView(zBooleanValue3).setInterceptFlag(iIntValue3).setExtraJson(jSONObject).setExtraObject(obj).setEnableShowComplianceDialog(zBooleanValue4).setIsAutoDownloadOnCardShow(zBooleanValue5).setEnableNewActivity(zBooleanValue6).setEnableAH(zBooleanValue7).setEnableAM(zBooleanValue8).setEnableOppoAutoDownload(((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue());
        this.pn.put(Integer.valueOf(i), enableOppoAutoDownload);
        this.iz.put(Integer.valueOf(i), enableOppoAutoDownload.build());
    }

    private DownloadStatusChangeListener nr(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        return null;
    }

    private void nr(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        AdDownloadModel.Builder builderU = u(((Long) map.get("id")).longValue(), (String) map.get("appIcon"), ((Boolean) map.get("isShowNotification")).booleanValue(), ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue(), (String) map.get("logExtra"), (JSONObject) map.get("extraJson"), (JSONObject) map.get("downloadSettings"), (String) map.get("filePath"), (String) map.get("downloadUrl"), (String) map.get(WfConstant.EVENT_KEY_APP_NAME), (String) map.get("packageName"), ((Boolean) map.get("isNeedIndependentProcess")).booleanValue(), (String) map.get("openUrl"), (String) map.get("webTitle"), (String) map.get("webUrl"));
        this.fx.put(Integer.valueOf(i), builderU);
        this.b.put(Integer.valueOf(i), builderU.build());
    }

    public Object b(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return null;
        }
        return adDownloadControllerDf.getExtraClickOperation();
    }

    public void b(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return;
        }
        adDownloadEventConfigZq.setQuickAppEventTag(str);
    }

    public void b(int i, boolean z) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return;
        }
        adDownloadModelEx.setNeedWifi(z);
    }

    public void b(int i, JSONObject jSONObject) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return;
        }
        adDownloadModelEx.setExtra(jSONObject);
    }

    public boolean nr(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return false;
        }
        return adDownloadControllerDf.isEnableBackDialog();
    }

    public AdDownloadModel b(int i, int i2) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setVersionCode(i2);
    }

    public void nr(int i, boolean z) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return;
        }
        adDownloadControllerDf.setIsAutoDownloadOnCardShow(z);
    }

    public void nr(int i, Object obj) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return;
        }
        adDownloadEventConfigZq.setExtraEventObject(obj);
    }

    public boolean pn(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return false;
        }
        return adDownloadControllerDf.isEnableMultipleDownload();
    }

    public void nr(int i, JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return;
        }
        adDownloadEventConfigZq.setExtraJson(jSONObject);
    }

    public void pn(int i, String str) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return;
        }
        adDownloadModelEx.setMd5(str);
    }

    public void nr(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return;
        }
        adDownloadEventConfigZq.setClickItemTag(str);
    }

    public void pn(int i, boolean z) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return;
        }
        adDownloadModelEx.setIsShowToast(z);
    }

    public void nr(int i, int i2) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return;
        }
        adDownloadEventConfigZq.setDownloadScene(i2);
    }

    public AdDownloadModel pn(int i, int i2) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setFunnelType(i2);
    }

    public boolean fx(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return false;
        }
        return adDownloadControllerDf.isAddToDownloadManage();
    }

    public void nr(int i, long j) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return;
        }
        adDownloadModelEx.setExtraValue(j);
    }

    public void fx(int i, boolean z) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (this.iz == null) {
            return;
        }
        adDownloadControllerDf.setEnableNewActivity(z);
    }

    public AdDownloadModel nr(int i, List<String> list) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setBackupUrls(list);
    }

    public void fx(int i, JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return;
        }
        adDownloadEventConfigZq.setParamsJson(jSONObject);
    }

    public void fx(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return;
        }
        adDownloadEventConfigZq.setRefer(str);
    }

    public AdDownloadModel fx(int i, long j) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setId(j);
    }

    public AdDownloadModel fx(int i, int i2) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setModelType(i2);
    }

    public void iz(int i, String str) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return;
        }
        adDownloadModelEx.setAppName(str);
    }

    public AdDownloadModel iz(int i, boolean z) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setIsAd(z);
    }

    private void u(Intent intent) {
        String str;
        String str2;
        intent.getAction();
        int intExtra = intent.getIntExtra("extra_click_download_ids", -1);
        intent.getIntExtra("extra_click_download_type", -1);
        intent.getStringExtra("extra_tag");
        String stringExtra = intent.getStringExtra("extra_value");
        String stringExtra2 = intent.getStringExtra("extra_log_extra");
        String stringExtra3 = intent.getStringExtra("extra_package_name");
        boolean zFx = jp.fx(this.nr, stringExtra3);
        NotificationManager notificationManager = (NotificationManager) this.nr.getSystemService("notification");
        com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar = new com.bytedance.sdk.openadsdk.core.l.fx.nr.u();
        uVar.x(stringExtra);
        uVar.b(stringExtra2);
        uVar.fx(stringExtra3);
        str = "success";
        if (zFx) {
            com.ss.android.downloadlib.x.a.u(stringExtra3);
            str2 = "open";
        } else {
            str = com.ss.android.socialbase.appdownloader.b.u(this.nr, intExtra) ? "success" : "failure";
            str2 = az.ah;
        }
        com.bytedance.sdk.openadsdk.core.l.pn.u("notification", uVar, str2, "click_other", null, str);
        notificationManager.cancel(ki(intExtra));
    }

    private void u(int i, DownloadMarketInterceptor downloadMarketInterceptor) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return;
        }
        adDownloadControllerDf.setDownloadMarketInterceptor(downloadMarketInterceptor);
    }

    private static boolean u(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            return false;
        }
        if (TextUtils.equals("main", UMModuleRegister.INNER)) {
            return fx();
        }
        return true;
    }

    public void u(Bundle bundle) {
        k.u(this.nr);
        nr();
    }

    private AdDownloadModel.Builder u(long j, String str, boolean z, boolean z2, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z3, String str7, String str8, String str9) {
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(j).setAppIcon(str).setIsShowNotification(z).setAutoInstallWithoutNotification(z2).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.core.l.b.my.1
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str10, String str11) {
                return my.this.u(str10, str11);
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str3)) {
            fileUriProvider.setFilePath(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            fileUriProvider.setDownloadUrl(str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            fileUriProvider.setAppName(str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            fileUriProvider.setPackageName(str6);
        }
        fileUriProvider.setNeedIndependentProcess(z3);
        fileUriProvider.setDeepLink(u(j, str7, str8, str9));
        return fileUriProvider;
    }

    private void u(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> functionNr = nr();
        if (functionNr == null) {
            com.bytedance.sdk.component.utils.k.nr("xgc_dl", ex.V);
            return;
        }
        Map map2 = (Map) functionNr.apply(com.bytedance.sdk.openadsdk.my.b.u().u(161).u(Map.class).u(0, map).nr());
        if (map2 != null) {
            Notification notification = (Notification) map2.get("notification");
            NotificationManager notificationManager = (NotificationManager) dw.getContext().getSystemService("notification");
            Object obj = map.get("install_download_id");
            notificationManager.notify(ki(obj != null ? ((Integer) obj).intValue() : 0), notification);
        }
    }

    public Map<String, Object> u(Object obj) {
        HashMap map = new HashMap();
        map.put("params", obj);
        Function<SparseArray<Object>, Object> functionNr = nr();
        if (functionNr == null) {
            return null;
        }
        return (Map) functionNr.apply(com.bytedance.sdk.openadsdk.my.b.u().u(156).u(Map.class).u(0, map).nr());
    }

    public Uri u(String str, String str2) {
        HashMap map = new HashMap();
        map.put("custom_authority", str);
        map.put("custom_file_path", str2);
        Function<SparseArray<Object>, Object> functionNr = nr();
        if (functionNr == null) {
            return null;
        }
        return (Uri) functionNr.apply(com.bytedance.sdk.openadsdk.my.b.u().u(155).u(Uri.class).u(0, map).nr());
    }

    private DeepLink u(long j, String str, String str2, String str3) {
        DeepLink deepLink = new DeepLink();
        deepLink.setId(j);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    private void u(int i, String str, String str2, String str3) {
        AdDownloadModel.Builder builderTr = tr(i);
        if (builderTr == null) {
            return;
        }
        this.b.put(Integer.valueOf(i), builderTr.setAppIcon(str).setAppName(str2).setPackageName(str3).build());
    }

    private void u(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(i2).setDownloadMode(i3).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.pn.put(Integer.valueOf(i), isAddToDownloadManage);
        if (z) {
            isAddToDownloadManage.setEnableAH(z2);
            isAddToDownloadManage.setEnableAM(z3);
        }
        this.iz.put(Integer.valueOf(i), isAddToDownloadManage.build());
    }

    public int u(int i) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return 0;
        }
        return adDownloadControllerDf.getLinkMode();
    }

    public void u(int i, int i2) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return;
        }
        adDownloadControllerDf.setLinkMode(i2);
    }

    public void u(int i, boolean z) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return;
        }
        adDownloadControllerDf.setEnableShowComplianceDialog(z);
    }

    public void u(int i, Object obj) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return;
        }
        adDownloadControllerDf.setExtraObject(obj);
    }

    public void u(int i, JSONObject jSONObject) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return;
        }
        adDownloadControllerDf.setExtraJson(jSONObject);
    }

    private void u(int i, boolean z, DownloadMarketInterceptor downloadMarketInterceptor) {
        AdDownloadController adDownloadControllerDf = df(i);
        if (adDownloadControllerDf == null) {
            return;
        }
        try {
            adDownloadControllerDf.setDownloadMarketInterceptor(downloadMarketInterceptor);
            adDownloadControllerDf.setEnableOppoAutoDownload(z);
        } catch (Throwable unused) {
        }
    }

    public void u(int i, String str) {
        AdDownloadEventConfig adDownloadEventConfigZq = zq(i);
        if (adDownloadEventConfigZq == null) {
            return;
        }
        adDownloadEventConfigZq.setClickButtonTag(str);
    }

    public void u(int i, long j) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return;
        }
        adDownloadModelEx.setExpectFileLength(j);
    }

    public AdDownloadModel u(int i, List<String> list) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setClickTrackUrl(list);
    }

    public AdDownloadModel u(int i, Map<String, String> map) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setHeaders(map);
    }

    public AdDownloadModel u(int i, com.ss.android.download.api.model.b bVar) {
        AdDownloadModel adDownloadModelEx = ex(i);
        if (adDownloadModelEx == null) {
            return null;
        }
        return adDownloadModelEx.setQuickAppModel(bVar);
    }

    public PluginValueSet u() {
        return ll7.b().h(0, k.u).g(1, Boolean.valueOf(k.nr)).f(10000, 3).a();
    }
}
