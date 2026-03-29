package com.bytedance.sdk.openadsdk.api.plugin.u;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.plugin.a;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements Function<SparseArray<Object>, Object> {
    private static volatile u u;

    public static u u() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u();
                }
            }
        }
        return u;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    private Plugin u(ValueSet valueSet) {
        if (valueSet == null) {
            return null;
        }
        String strStringValue = valueSet.stringValue(0);
        if (TextUtils.isEmpty(strStringValue)) {
            return null;
        }
        return Zeus.getPlugin(strStringValue);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ab  */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object apply(SparseArray<Object> sparseArray) {
        String strU;
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetA = wc7.k(sparseArray).a();
        int iIntValue = valueSetA.intValue(-99999987);
        if (iIntValue != -99999986) {
            if (iIntValue != 13) {
                switch (iIntValue) {
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        String strStringValue = valueSetA.stringValue(0);
                        if (TextUtils.isEmpty(strStringValue)) {
                            strU = "";
                        } else {
                            strU = a.u(strStringValue);
                            if (TextUtils.isEmpty(strU)) {
                                strU = a.nr(strStringValue);
                            }
                        }
                        if (TextUtils.isEmpty(strU)) {
                        }
                        break;
                    default:
                        switch (iIntValue) {
                            case 100:
                                Zeus.unInstallPlugin(valueSetA.stringValue(0));
                                break;
                            case 101:
                                a.u(TTAppContextHolder.getContext());
                                Plugin pluginU = u(valueSetA);
                                if (pluginU != null) {
                                }
                                break;
                            case 102:
                                Plugin pluginU2 = u(valueSetA);
                                if (pluginU2 != null) {
                                }
                                break;
                            case 103:
                                Plugin pluginU3 = u(valueSetA);
                                if (pluginU3 != null) {
                                }
                                break;
                            case 106:
                                TTPluginListener tTPluginListener = (TTPluginListener) valueSetA.objectValue(0, TTPluginListener.class);
                                if (tTPluginListener != null) {
                                    a.u(TTAppContextHolder.getContext()).nr(tTPluginListener);
                                }
                                break;
                        }
                        break;
                }
                return null;
            }
            Plugin pluginU4 = u(valueSetA);
            if (pluginU4 != null) {
                return pluginU4.getJsonConfig();
            }
        }
        return wc7.b().f(10000, 4).a().sparseArray();
    }
}
