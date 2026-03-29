package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.live.EcBackUpWebView;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.bq;
import com.kwad.sdk.api.model.AdnName;
import com.qq.gdt.action.ActionUtils;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class h implements Function<SparseArray<Object>, Object> {
    private final PluginValueSet u = ll7.b().g(11, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.core.h.1
        @Override // java.util.function.Supplier
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public Integer get() {
            return Integer.valueOf(n.o().ay());
        }
    })).h(12, "7.2.3.2").a();

    private void fx(Object obj) {
        if (obj instanceof Function) {
            Function function = (Function) obj;
            if (u(function, "qa_common_tool")) {
                com.bytedance.sdk.openadsdk.gi.u.fx.u((Function<SparseArray<Object>, Object>) function);
                com.bytedance.sdk.openadsdk.my.b bVarU = com.bytedance.sdk.openadsdk.my.b.u();
                bVarU.u(10002).u(Void.class);
                bVarU.u(20002, com.bytedance.sdk.openadsdk.gi.u.fx.u());
                function.apply(bVarU.nr());
            }
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public void nr(Object obj) {
        if ((d.x() || jp.a().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.bytedance.sdk.openadsdk.core.bc.u.u.fx(obj);
        }
    }

    public void u(Object obj) {
        if (n.o().su()) {
            fx(obj);
        }
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            if (bundle.containsKey(PluginConstants.KEY_PL_CONFIG_INFO)) {
                n.o().u(bundle.getBundle(PluginConstants.KEY_PL_CONFIG_INFO));
                if (n.o().wq().length() == 0 || com.bytedance.sdk.openadsdk.core.y.my.nr()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.ja.u.u.u().nr();
                return;
            }
            return;
        }
        if ((obj instanceof Function) && !com.bytedance.sdk.openadsdk.core.bc.u.u.nr(obj)) {
            u((Function<SparseArray<Object>, Object>) obj);
            return;
        }
        if (obj instanceof PluginValueSet) {
            PluginValueSet pluginValueSet = (PluginValueSet) obj;
            try {
                if (pluginValueSet.intValue(0) == 1) {
                    u((ClassLoader) pluginValueSet.objectValue(2, ClassLoader.class), pluginValueSet.stringValue(1));
                }
            } catch (Throwable unused) {
            }
        }
        if ((d.x() || jp.a().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.bytedance.sdk.openadsdk.core.bc.u.u.u(obj);
        }
        if (obj instanceof TTAdInteractionListener) {
            n.o().y().apply(com.bytedance.sdk.openadsdk.my.b.u().u(162).u(0, new com.bytedance.sdk.openadsdk.core.y.wq().u(bq.f.s, obj)).u(Void.class).nr());
        }
    }

    private boolean u(Function function, String str) {
        com.bytedance.sdk.openadsdk.my.b bVarU = com.bytedance.sdk.openadsdk.my.b.u();
        bVarU.u(10004).u(String.class);
        return str.equals(function.apply(bVarU.nr()));
    }

    private void u(ClassLoader classLoader, String str) throws Throwable {
        ZipFile zipFile;
        getClass().getClassLoader();
        if (classLoader == null || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(d.u(str, com.bytedance.sdk.openadsdk.gi.l.fx(str)), "apk/base-1.apk");
        String strSubstring = null;
        if (file.exists() && file.canRead()) {
            try {
                zipFile = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                    while (true) {
                        if (!enumerationEntries.hasMoreElements()) {
                            break;
                        }
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement.getName().startsWith("ats")) {
                            strSubstring = zipEntryNextElement.getName().substring(3);
                            break;
                        }
                    }
                    if (strSubstring != null) {
                        Constructor<?> declaredConstructor = classLoader.loadClass(strSubstring).getDeclaredConstructor(new Class[0]);
                        declaredConstructor.setAccessible(true);
                        new com.bytedance.sdk.openadsdk.ats.fx().apply(declaredConstructor.newInstance(new Object[0]));
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("class", strSubstring);
                        jSONObject.put("pkg", str);
                        com.bytedance.sdk.openadsdk.core.qq.s.u().u("ats_reg", jSONObject, th);
                    } finally {
                        com.bytedance.sdk.component.iz.fx.fx.nr.u(zipFile);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                zipFile = null;
            }
        } else {
            com.bytedance.sdk.openadsdk.core.qq.s.u().u("ats_reg", (JSONObject) null, (Throwable) null);
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
            int iIntValue = pluginValueSetA.intValue(-99999987);
            if (iIntValue == -99999986) {
                PluginValueSet pluginValueSet = this.u;
                if (pluginValueSet != null) {
                    return pluginValueSet.sparseArray();
                }
            } else {
                if (iIntValue == -999800) {
                    return new rh((Context) pluginValueSetA.objectValue(-998000, Context.class));
                }
                if (iIntValue == 16) {
                    n.o().u(pluginValueSetA.booleanValue(17, false), (SparseArray<Object>) pluginValueSetA.objectValue(21, SparseArray.class));
                    return null;
                }
                if (iIntValue == 19) {
                    Bundle bundle = (Bundle) pluginValueSetA.objectValue(20, Bundle.class);
                    if (bundle != null) {
                        int i = bundle.getInt("event_id", -1);
                        int i2 = bundle.getInt("event_type", -1);
                        String string = bundle.getString("package_name");
                        String strFx = com.bytedance.sdk.component.utils.u.fx(bundle.getString("event_token"));
                        com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar = new com.bytedance.sdk.openadsdk.core.l.fx.nr.u();
                        try {
                            JSONObject jSONObject = new JSONObject(strFx);
                            uVar.iz(jSONObject.optString("tag"));
                            uVar.x(jSONObject.optString(ActionUtils.PAYMENT_AMOUNT));
                            uVar.b(jSONObject.optString("log_extra"));
                            uVar.a(jSONObject.optString(WfConstant.EXTRA_KEY_DOWNLOAD_URL));
                            uVar.n(jSONObject.optString("save_path"));
                        } catch (JSONException unused) {
                        }
                        uVar.u(i);
                        uVar.fx(string);
                        return com.bytedance.sdk.openadsdk.core.l.b.k.u(uVar, i2);
                    }
                    return new Bundle();
                }
                if (iIntValue == 999801) {
                    return this;
                }
                switch (iIntValue) {
                    case 1:
                        u(pluginValueSetA.intValue(11));
                        break;
                    case 2:
                        return u(ll7.k(pluginValueSetA).a(), pluginValueSetA.booleanValue(13), pluginValueSetA.intValue(14));
                    case 3:
                        u((Context) pluginValueSetA.objectValue(7, Context.class));
                        break;
                    case 4:
                        u(pluginValueSetA.objectValue(8, Object.class));
                        break;
                    case 5:
                        nr(pluginValueSetA.objectValue(8, Function.class));
                        break;
                    case 6:
                        return u((Class) pluginValueSetA.objectValue(9, Class.class), (Bundle) pluginValueSetA.objectValue(10, Bundle.class));
                    default:
                        return null;
                }
            }
        }
        return null;
    }

    private void u(Function<SparseArray<Object>, Object> function) {
        if (function != null && ll7.j(com.bytedance.sdk.openadsdk.my.fx.u(function)).a().intValue(10000) == 1 && d.x()) {
            com.bytedance.sdk.openadsdk.core.live.nr.u().u(function);
        }
    }

    /* JADX WARN: Type inference failed for: r8v13, types: [T, java.util.HashMap, java.util.Map] */
    public <T> T u(Class<T> cls, Bundle bundle) {
        boolean z = false;
        int i = bundle != null ? bundle.getInt("type") : 0;
        if (com.bytedance.sdk.openadsdk.core.bc.u.nr.u(cls, bundle)) {
            return (T) com.bytedance.sdk.openadsdk.core.bc.u.nr.u(com.bytedance.sdk.openadsdk.core.multipro.iz.u(dw.getContext()), cls, bundle);
        }
        if (cls != SparseArray.class && (cls == null || !"com.bytedance.sdk.openadsdk.AdConfig".equals(cls.getName()))) {
            if (!com.bytedance.sdk.openadsdk.my.fx.b.nr(d.fx) && i == 1 && cls == ITTDownloadVisitor.class) {
                return (T) com.bytedance.sdk.openadsdk.core.l.u.jk.create();
            }
            if (cls == Bundle.class) {
                if (bundle == null) {
                    return null;
                }
                int i2 = bundle.getInt("action", 0);
                if (i2 == 0) {
                    n.o().u(bundle.getString("plugin_pkg_name"), bundle.getString(PluginConstants.KEY_PLUGIN_VERSION));
                } else if (i2 == 1) {
                    com.bytedance.sdk.openadsdk.core.qq.s.u().nr(bundle.getString("event_name"), bundle.getString("event_extra"));
                } else if (i2 == 2) {
                    u();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(MediationConstant.RIT_TYPE_SPLASH, 0);
                        jSONObject.put("reward", 0);
                        jSONObject.put("brand", 0);
                        jSONObject.put(AdnName.OTHER, 0);
                        com.bykv.vk.openvk.component.video.u.u.u(jSONObject);
                        com.bytedance.sdk.openadsdk.gi.jk.u(0).pn();
                        com.bykv.vk.openvk.component.video.u.u.u(dw.nr().jf());
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.k.u(th.getMessage());
                    }
                } else if (i2 == 3) {
                    com.bytedance.sdk.component.jk.x.u(-1);
                }
            } else if (cls == ExecutorService.class) {
                if (bundle != null) {
                    int i3 = bundle.getInt("action", 0);
                    if (i3 == 1) {
                        return (T) com.bytedance.sdk.component.jk.t.nr.jk();
                    }
                    if (i3 == 2) {
                        return (T) com.bytedance.sdk.component.jk.t.nr.a();
                    }
                    if (i3 != 3) {
                        return (T) com.bytedance.sdk.component.jk.t.nr.mv();
                    }
                    return (T) com.bytedance.sdk.component.jk.t.nr.l();
                }
            } else if (cls == Handler.class) {
                if (bundle != null && bundle.getInt("action", 0) == 1) {
                    return (T) com.bytedance.sdk.component.utils.jk.u();
                }
            } else {
                if (cls == View.class) {
                    return (T) new EcBackUpWebView(dw.getContext());
                }
                if (cls == Map.class) {
                    ?? r8 = (T) new HashMap();
                    if (bundle != null && bundle.getString("extra_name").equals("use_mediation_map")) {
                        if (AdSdkInitializerHolder.isSdkInitSuccess() && dw.nr().j() && AdSdkInitializerHolder.hasDispatchAdSdkInitializer()) {
                            z = true;
                        }
                        r8.put("use_mediation_map", Boolean.valueOf(z));
                    }
                    return r8;
                }
                if (cls == Function.class && bundle != null && bundle.getInt("action", 0) == 4) {
                    return (T) com.bytedance.sdk.openadsdk.tools.fx.u();
                }
            }
        } else if (bundle != null && !bundle.keySet().isEmpty()) {
            if (bundle.containsKey("is_paid")) {
                n.o().pn(bundle.getBoolean("is_paid"));
            }
            if (bundle.containsKey("extra_data")) {
                n.o().x(bundle.getString("extra_data"));
            }
            if (bundle.containsKey("keywords")) {
                n.o().n(bundle.getString("keywords"));
            }
            if (bundle.containsKey("quit_work")) {
                n.o().u(bundle.getBoolean("quit_work", false), (SparseArray<Object>) null);
            }
        }
        return null;
    }

    public void u(Context context) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarBq = n.o().bq();
        if (bVarBq != null) {
            boolean zU = bVarBq.u();
            boolean zFx = bVarBq.fx();
            boolean zPn = bVarBq.pn();
            if (!zU && !zFx && !zPn) {
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 2);
        com.bytedance.sdk.component.utils.nr.u(context, intent, null);
    }

    public String u(PluginValueSet pluginValueSet, boolean z, int i) {
        if (pluginValueSet == null || dw.u() == null) {
            return null;
        }
        return dw.u().u(new com.bytedance.sdk.openadsdk.my.fx.fx.nr(pluginValueSet.sparseArray()), z, i);
    }

    public void u(int i) {
        if (i != n.o().ay()) {
            n.o().pn(i);
            Intent intent = new Intent();
            intent.setAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            intent.putExtra("theme_status_change", i);
            dw.getContext().sendBroadcast(intent, jp.z());
        }
    }

    public void u() {
        com.bytedance.sdk.openadsdk.core.y.bf.u("open_ad_sdk_union_meta_cache_kv").clear();
        com.bytedance.sdk.openadsdk.core.y.bf.u("tt_materialMeta").clear();
        com.bytedance.sdk.openadsdk.core.y.bf.u("tt_splash").clear();
    }
}
