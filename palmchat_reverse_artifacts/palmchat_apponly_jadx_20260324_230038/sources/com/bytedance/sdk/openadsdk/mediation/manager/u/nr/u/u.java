package com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> u;

    private SparseArray<Object> u() {
        com.bytedance.sdk.openadsdk.my.b bVarU = com.bytedance.sdk.openadsdk.my.b.u();
        bVarU.u(271006, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Map<String, String>>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return u.this.getCustomData();
            }
        }));
        bVarU.u(271007, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getSdkName();
            }
        }));
        bVarU.u(271008, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getCustomSdkName();
            }
        }));
        bVarU.u(271009, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getSlotId();
            }
        }));
        bVarU.u(271010, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getLevelTag();
            }
        }));
        bVarU.u(271011, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getEcpm();
            }
        }));
        bVarU.u(271012, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(u.this.getReqBiddingType());
            }
        }));
        bVarU.u(271013, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getErrorMsg();
            }
        }));
        bVarU.u(271014, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.16
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getRequestId();
            }
        }));
        bVarU.u(271015, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getRitType();
            }
        }));
        bVarU.u(271016, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getSegmentId();
            }
        }));
        bVarU.u(271017, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getChannel();
            }
        }));
        bVarU.u(271018, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getSubChannel();
            }
        }));
        bVarU.u(271019, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getAbTestId();
            }
        }));
        bVarU.u(271020, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getScenarioId();
            }
        }));
        bVarU.u(271051, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return u.this.getSubRitType();
            }
        }));
        return bVarU.nr();
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public abstract String getAbTestId();

    public abstract String getChannel();

    public abstract Map<String, String> getCustomData();

    public abstract String getCustomSdkName();

    public abstract String getEcpm();

    public abstract String getErrorMsg();

    public abstract String getLevelTag();

    public abstract int getReqBiddingType();

    public abstract String getRequestId();

    public abstract String getRitType();

    public abstract String getScenarioId();

    public abstract String getSdkName();

    public abstract String getSegmentId();

    public abstract String getSlotId();

    public abstract String getSubChannel();

    public abstract String getSubRitType();

    public SparseArray<Object> values() {
        SparseArray<Object> sparseArray = this.u;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayU = u();
        this.u = sparseArrayU;
        return sparseArrayU;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        pluginValueSetA.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            return null;
        }
        return values();
    }
}
