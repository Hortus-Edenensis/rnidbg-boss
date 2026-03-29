package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.iz;
import com.bytedance.sdk.openadsdk.fx.b;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.my.u.u.k;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fx implements Function<SparseArray<Object>, Object> {
    private static final fx u = new fx();
    private volatile C0311fx b;
    private Map<String, String> fx;
    private volatile Function<SparseArray<Object>, Object> nr;
    private volatile ILiveInitCallback pn;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.live.fx$fx, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public final class C0311fx implements TTPluginListener {
        String nr;
        int u;

        private C0311fx() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public Bundle config() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public void onPluginListener(int i, ClassLoader classLoader, Resources resources, Bundle bundle) {
            u(i, classLoader, resources, bundle, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public String packageName() {
            return "com.byted.live.lite";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(int i, ClassLoader classLoader, Resources resources, Bundle bundle, boolean z) {
            this.u = i;
            if (fx.this.nr != null) {
                fx.this.nr.apply(wc7.b().f(0, i).h(1, classLoader).h(2, resources).h(3, bundle).h(4, fx.this.u(z)).f(-99999987, 3).a().sparseArray());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(int i, String str, boolean z) {
            this.u = i;
            this.nr = str;
            if (fx.this.nr != null) {
                wc7 wc7VarF = wc7.b().f(0, i);
                if (str != null) {
                    wc7VarF.i(1, str);
                }
                wc7VarF.h(2, fx.this.u(z)).f(-99999987, 2);
                fx.this.nr.apply(wc7VarF.a().sparseArray());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class nr implements ILiveInitCallback {
        private nr() {
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFailed(String str) {
            iz.u("TTLiveSDkBridge", "onLiveInitFailed! ", str);
            if (fx.this.b != null) {
                fx.this.b.u(-3, str, false);
            }
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFinish() {
            iz.nr("TTLiveSDkBridge", "onLiveInitFinish!");
            com.bytedance.sdk.openadsdk.live.nr.u();
            if (fx.this.b != null) {
                fx.this.b.u(2, null, false);
            }
            fx.this.fx = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u implements Function<SparseArray<Object>, Object> {
        private ILiveAdCustomConfig u;

        public u(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.u = iLiveAdCustomConfig;
        }

        @Override // java.util.function.Function
        public /* synthetic */ Function andThen(Function function) {
            return Function$CC.$default$andThen(this, function);
        }

        public /* synthetic */ Function compose(Function function) {
            return Function$CC.$default$compose(this, function);
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
            if (iIntValue == -99999986) {
                return wc7.b().f(10000, 1).a().sparseArray();
            }
            if (iIntValue == 0) {
                return Integer.valueOf(this.u.openLR((String) sparseArray.get(0)));
            }
            if (iIntValue == 1) {
                return this.u.convertToEnterFromMerge(((Integer) sparseArray.get(0)).intValue());
            }
            if (iIntValue == 2) {
                return this.u.convertToEnterMethod(((Integer) sparseArray.get(0)).intValue(), ((Boolean) sparseArray.get(1)).booleanValue());
            }
            if (iIntValue == 3) {
                return this.u.invoke(((Integer) sparseArray.get(0)).intValue(), (Bundle) sparseArray.get(1));
            }
            if (iIntValue == 4) {
                this.u.onEventV3((String) sparseArray.get(0), (JSONObject) sparseArray.get(1));
                return null;
            }
            if (iIntValue != 5) {
                return null;
            }
            return this.u;
        }
    }

    private fx() {
    }

    private Function<SparseArray<Object>, Object> b(Map map) {
        return k.u(map.get("c_control"));
    }

    private void fx(Map map) {
        ILiveHostContextParam.Builder builderAddHostInitExtra = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get("app_name"))).setChannel(String.valueOf(map.get("channel"))).setECHostAppId(String.valueOf(map.get("ec_host_appid"))).setPartner(String.valueOf(map.get("partner"))).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.fx.1
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return MediationConstant.ADN_PANGLE;
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                if (fx.this.nr == null) {
                    return null;
                }
                return fx.this.nr.apply(wc7.b().i(0, str).h(1, map2).f(-99999987, 0).a().sparseArray());
            }
        }).setPartnerSecret("p_secret").setHostPermission(new com.bytedance.sdk.openadsdk.live.u.u(b(map))).setHostActionParam(new com.bytedance.sdk.openadsdk.live.u.nr(this.nr)).addHostInitExtra(nr(map));
        Map<String, String> map2 = this.fx;
        if (map2 != null) {
            builderAddHostInitExtra.addHostInitExtra(map2);
        }
        if (this.pn == null) {
            this.pn = new nr();
        }
        if (TTAppContextHolder.getContext() instanceof Application) {
            builderAddHostInitExtra.setContext((Application) TTAppContextHolder.getContext());
        }
        boolean zBooleanValue = Boolean.valueOf(String.valueOf(map.get("sub_process"))).booleanValue();
        iz.u("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: ", Boolean.valueOf(com.bytedance.sdk.openadsdk.live.nr.u(TTAppContextHolder.getContext(), String.valueOf(map.get("g_appid")), builderAddHostInitExtra, this.pn, zBooleanValue)), " subProcess=", Boolean.valueOf(zBooleanValue));
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    private Boolean iz(Map<String, Object> map) {
        try {
            String str = (String) map.get("scheme_uri");
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get("context"));
            Uri uri = Uri.parse(str);
            if (uri != null && context != null) {
                return Boolean.valueOf(com.bytedance.sdk.openadsdk.live.nr.u(context, uri));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            u("handleLiveScheme", th);
            iz.nr("TTLiveSDkBridge", th);
            return Boolean.FALSE;
        }
    }

    private Object pn(Map<String, Object> map) {
        String str;
        try {
            str = (String) map.get("expand_method_name");
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                Object[] objArr = (Object[]) map.get("expand_method_param");
                if (objArr == null) {
                    return liveRoomService.callExpandMethod(str, new Object[0]);
                }
                for (int i = 0; i < objArr.length; i++) {
                    Object obj = objArr[i];
                    if (obj instanceof Function) {
                        objArr[i] = new com.bytedance.sdk.openadsdk.live.u((Function) obj);
                    }
                }
                return liveRoomService.callExpandMethod(str, objArr);
            } catch (Throwable th) {
                th = th;
                u("invokeLiveExpandMethod-".concat(String.valueOf(str)), th);
                iz.nr("TTLiveSDkBridge", th);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    private Map<String, String> nr(Map map) {
        Object obj = map.get("live_tob_init_extra");
        return obj instanceof Map ? (Map) obj : new HashMap();
    }

    public static fx u() {
        return u;
    }

    public static Function<SparseArray<Object>, Object> u(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new u(iLiveAdCustomConfig);
    }

    public void u(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.fx = map;
    }

    public <T> T u(int i, Map<String, Object> map) {
        if (i == 0) {
            if (!com.bytedance.sdk.openadsdk.live.nr.u(getContext(map.get("context")), u(map.get("bundle")))) {
                return (T) 2;
            }
            return (T) 0;
        }
        if (i == 7) {
            return (T) pn(map);
        }
        if (i != 8) {
            return null;
        }
        return (T) iz(map);
    }

    private Bundle u(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }

    public static void u(String str, Throwable th) {
        try {
            TTAdManager adManager = TTAdSdk.getAdManager();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", str);
            if (th != null) {
                jSONObject.put("msg", Log.getStackTraceString(th));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("event_name", "exception");
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
        } catch (Exception e) {
            iz.nr("TTLiveSDkBridge", e);
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetA = wc7.k(sparseArray).a();
        int iIntValue = valueSetA.intValue(-99999987);
        if (iIntValue == -99999986) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(10000, 2);
            return sparseArray2;
        }
        if (iIntValue == 5) {
            fx((Map) valueSetA.objectValue(0, Map.class));
            return null;
        }
        if (iIntValue != 9) {
            return u(iIntValue, (Map<String, Object>) valueSetA.objectValue(0, Map.class));
        }
        this.nr = k.u(valueSetA.objectValue(0, Object.class));
        if (this.b != null) {
            if (this.b.u == 2 || this.b.u == -3) {
                this.b.u(this.b.u, this.b.nr, true);
            } else if (this.b.u != 0) {
                this.b.u(this.b.u, null, null, null, true);
            }
        } else {
            this.b = new C0311fx();
            Function<SparseArray<Object>, Object> functionU = k.u(b.u().apply(wc7.c(2).f(0, 4).f(-99999987, 10).a().sparseArray()));
            ValueSet valueSetA2 = wc7.c(2).f(-99999987, 106).h(0, this.b).a();
            if (functionU != null) {
                functionU.apply(valueSetA2.sparseArray());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map u(boolean z) {
        HashMap map = new HashMap();
        map.put("onlyUpdateState", Boolean.valueOf(z));
        return map;
    }
}
