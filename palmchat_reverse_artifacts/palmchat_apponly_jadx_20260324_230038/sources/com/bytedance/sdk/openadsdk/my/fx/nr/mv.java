package com.bytedance.sdk.openadsdk.my.fx.nr;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class mv extends n {
    private SparseArray<Object> u;

    private SparseArray<Object> b() {
        com.bytedance.sdk.openadsdk.my.b bVarU = com.bytedance.sdk.openadsdk.my.b.u();
        bVarU.u(140001, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<l>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public l get() {
                return mv.this.s_();
            }
        }));
        bVarU.u(140002, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Bitmap get() {
                return mv.this.x();
            }
        }));
        bVarU.u(140003, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return mv.this.t_();
            }
        }));
        bVarU.u(140004, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return mv.this.a();
            }
        }));
        bVarU.u(140018, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return mv.this.jk();
            }
        }));
        bVarU.u(140005, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(mv.this.t());
            }
        }));
        bVarU.u(140006, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.16
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(mv.this.h_());
            }
        }));
        bVarU.u(140007, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.17
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(mv.this.i_());
            }
        }));
        bVarU.u(140008, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.18
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return mv.this.j_();
            }
        }));
        bVarU.u(140009, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<l>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public l get() {
                return mv.this.my();
            }
        }));
        bVarU.u(140010, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<List<l>>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public List<l> get() {
                return mv.this.o();
            }
        }));
        bVarU.u(140011, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(mv.this.sx());
            }
        }));
        bVarU.u(140012, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(mv.this.bg());
            }
        }));
        bVarU.u(140013, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<b>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public b get() {
                return mv.this.bq();
            }
        }));
        bVarU.u(140014, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<fx>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public fx get() {
                return mv.this.d();
            }
        }));
        bVarU.u(140015, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<pn>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public pn get() {
                return mv.this.c();
            }
        }));
        bVarU.u(140016, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public View get() {
                return mv.this.u();
            }
        }));
        bVarU.u(140017, com.bytedance.sdk.openadsdk.my.fx.b.u((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.my.fx.nr.mv.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return mv.this.k();
            }
        }));
        return bVarU.nr();
    }

    public abstract String a();

    public abstract int bg();

    public abstract b bq();

    public abstract pn c();

    public abstract fx d();

    public abstract void fx();

    public abstract int h_();

    public abstract int i_();

    public abstract String j_();

    public abstract String jk();

    public abstract Map<String, Object> k();

    public abstract l my();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b nr();

    public abstract void nr(Activity activity);

    public abstract void nr(Dialog dialog, Integer[] numArr);

    public abstract List<l> o();

    public abstract void q();

    public abstract l s_();

    public abstract int sx();

    public abstract int t();

    public abstract String t_();

    public abstract View u();

    public abstract x u(Activity activity);

    public abstract x u(Dialog dialog, Integer[] numArr);

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n, java.util.function.Function
    /* JADX INFO: renamed from: u */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        pluginValueSetA.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return u_();
        }
        switch (iIntValue) {
            case 140101:
                return u((Activity) pluginValueSetA.objectValue(0, Activity.class));
            case 140102:
                Dialog dialog = (Dialog) pluginValueSetA.objectValue(0, Dialog.class);
                Integer[] numArr = (Integer[]) pluginValueSetA.arrayValue(1, Integer.class);
                if (numArr == null) {
                    numArr = new Integer[0];
                }
                return u(dialog, numArr);
            case 140103:
                u((ViewGroup) pluginValueSetA.objectValue(0, ViewGroup.class), (View) pluginValueSetA.objectValue(1, View.class), new com.bytedance.sdk.openadsdk.qq.u.nr.u.u((Function) pluginValueSetA.objectValue(2, Function.class)));
                return null;
            case 140104:
                u((ViewGroup) pluginValueSetA.objectValue(0, ViewGroup.class), (List) pluginValueSetA.objectValue(1, List.class), (List) pluginValueSetA.objectValue(2, List.class), new com.bytedance.sdk.openadsdk.qq.u.nr.u.u((Function) pluginValueSetA.objectValue(3, Function.class)));
                return null;
            case 140105:
                u((ViewGroup) pluginValueSetA.objectValue(0, ViewGroup.class), (List) pluginValueSetA.objectValue(1, List.class), (List) pluginValueSetA.objectValue(2, List.class), (View) pluginValueSetA.objectValue(3, View.class), new com.bytedance.sdk.openadsdk.qq.u.nr.u.u((Function) pluginValueSetA.objectValue(4, Function.class)));
                return null;
            case 140106:
                u((ViewGroup) pluginValueSetA.objectValue(0, ViewGroup.class), (List) pluginValueSetA.objectValue(1, List.class), (List) pluginValueSetA.objectValue(2, List.class), (List) pluginValueSetA.objectValue(3, List.class), (View) pluginValueSetA.objectValue(4, View.class), new com.bytedance.sdk.openadsdk.qq.u.nr.u.u((Function) pluginValueSetA.objectValue(5, Function.class)));
                return null;
            case 140107:
                u((ViewGroup) pluginValueSetA.objectValue(0, ViewGroup.class), (List<View>) pluginValueSetA.objectValue(1, List.class), (List<View>) pluginValueSetA.objectValue(2, List.class), (List<View>) pluginValueSetA.objectValue(3, List.class), (List<View>) pluginValueSetA.objectValue(4, List.class), (View) pluginValueSetA.objectValue(5, View.class), new com.bytedance.sdk.openadsdk.qq.u.nr.u.u((Function) pluginValueSetA.objectValue(6, Function.class)));
                return null;
            case 140108:
                u(new com.bytedance.sdk.openadsdk.my.fx.u.fx((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            case 140109:
                nr((Activity) pluginValueSetA.objectValue(0, Activity.class));
                return null;
            case 140110:
                q();
                return null;
            case 140111:
                u(new com.bytedance.sdk.openadsdk.qq.u.nr.u.fx((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            case 140112:
                u((Activity) pluginValueSetA.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.bg.u.nr.u.u((Function) pluginValueSetA.objectValue(1, Function.class)));
                return null;
            case 140113:
                Dialog dialog2 = (Dialog) pluginValueSetA.objectValue(0, Dialog.class);
                Integer[] numArr2 = (Integer[]) pluginValueSetA.arrayValue(1, Integer.class);
                if (numArr2 == null) {
                    numArr2 = new Integer[0];
                }
                nr(dialog2, numArr2);
                return null;
            case 140114:
                fx();
                return null;
            case 140115:
                pluginValueSetA.objectValue(0, Activity.class);
                return null;
            case 140116:
                return nr();
            case 140117:
                u((Activity) pluginValueSetA.objectValue(0, Activity.class), (ViewGroup) pluginValueSetA.objectValue(1, ViewGroup.class), (List<View>) pluginValueSetA.objectValue(2, List.class), (List<View>) pluginValueSetA.objectValue(3, List.class), (List<View>) pluginValueSetA.objectValue(4, List.class), new com.bytedance.sdk.openadsdk.qq.u.nr.u.u((Function) pluginValueSetA.objectValue(5, Function.class)), new com.bytedance.sdk.openadsdk.mediation.ad.u.nr.u.u((Function) pluginValueSetA.objectValue(6, Function.class)));
                return null;
            case 140118:
                u((String) pluginValueSetA.objectValue(0, String.class));
                return null;
            case 140119:
                u(new com.bytedance.sdk.openadsdk.qq.u.nr.u.nr((Function) pluginValueSetA.objectValue(0, Function.class)));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract void u(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar, com.bytedance.sdk.openadsdk.mediation.ad.u.nr.u.u uVar2);

    public abstract void u(Activity activity, com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar);

    public abstract void u(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar);

    public abstract void u(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar);

    public abstract void u(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar);

    public abstract void u(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar);

    public abstract void u(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar);

    public abstract void u(com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar);

    public abstract void u(com.bytedance.sdk.openadsdk.qq.u.nr.u.fx fxVar);

    public abstract void u(com.bytedance.sdk.openadsdk.qq.u.nr.u.nr nrVar);

    public abstract void u(String str);

    public SparseArray<Object> u_() {
        SparseArray<Object> sparseArray = this.u;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayB = b();
        this.u = sparseArrayB;
        return sparseArrayB;
    }

    public abstract Bitmap x();
}
