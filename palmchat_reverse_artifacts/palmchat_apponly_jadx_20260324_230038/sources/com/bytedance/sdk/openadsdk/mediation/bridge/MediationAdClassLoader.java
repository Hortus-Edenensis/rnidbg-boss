package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.iz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.AdnManagerConfig;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import com.bytedance.sdk.openadsdk.mediation.u.u;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationAdClassLoader extends u implements Bridge {
    private static volatile MediationAdClassLoader u;

    private MediationAdClassLoader() {
    }

    public static MediationAdClassLoader getInstance() {
        if (u == null) {
            synchronized (MediationAdClassLoader.class) {
                u = new MediationAdClassLoader();
            }
        }
        return u;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Boolean u(String str, String str2) {
        try {
            Class.forName(str2);
            return Boolean.TRUE;
        } catch (Throwable th) {
            iz.u(th);
            try {
                Class.forName(str);
                return Boolean.TRUE;
            } catch (ClassNotFoundException e) {
                e = e;
                iz.u(e);
                if (u(str)) {
                    iz.pn(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                }
                return Boolean.FALSE;
            } catch (NoClassDefFoundError e2) {
                e = e2;
                iz.u(e);
                if (u(str)) {
                }
                return Boolean.FALSE;
            } catch (Throwable th2) {
                iz.u(th2);
                return Boolean.FALSE;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.u.u
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8106) {
            u(MediationLoaderConfig.create(valueSet), valueSet);
        } else if (i == 8229) {
            return (T) u(valueSet.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, null), valueSet.stringValue(8560, null));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8106) {
            u(MediationLoaderConfig.create(valueSet), valueSet);
            return null;
        }
        if (i == 8229) {
            return (T) u(valueSet.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow), valueSet.stringValue(8560));
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.u.u
    public SparseArray<Object> get() {
        ValueSet valueSetValues = values();
        if (valueSetValues != null) {
            return valueSetValues.sparseArray();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(MediationLoaderConfig mediationLoaderConfig, ValueSet valueSet) {
        try {
            Function<SparseArray<Object>, Object> adapterManager = AdnManagerConfig.getAdapterManager(mediationLoaderConfig.getADNName());
            if (adapterManager != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, Integer.valueOf(mediationLoaderConfig.getManagerLoaderType()));
                sparseArray.put(-99999985, Object.class);
                u(adapterManager.apply(sparseArray), valueSet);
                return;
            }
            u(Class.forName(mediationLoaderConfig.getClassName()).newInstance(), valueSet);
        } catch (ClassNotFoundException e) {
            e = e;
            iz.u(e);
            if (u(null)) {
                return;
            }
            iz.pn(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
        } catch (IllegalAccessException e2) {
            e = e2;
            e.printStackTrace();
        } catch (InstantiationException e3) {
            e = e3;
            e.printStackTrace();
        } catch (NoClassDefFoundError e4) {
            e = e4;
            iz.u(e);
            if (u(null)) {
            }
        }
    }

    private void u(Object obj, ValueSet valueSet) {
        SparseArray<Object> sparseArray = valueSet.sparseArray();
        if (obj instanceof Function) {
            Function function = (Function) obj;
            SparseArray sparseArray2 = new SparseArray();
            SparseArray<Object> sparseArray3 = null;
            sparseArray2.put(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, (Context) u.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold), Context.class, null));
            Object objObjectValue = u.objectValue(sparseArray.get(8424), Object.class, null);
            if (objObjectValue instanceof ValueSet) {
                sparseArray3 = ((ValueSet) objObjectValue).sparseArray();
            } else if (objObjectValue instanceof SparseArray) {
                sparseArray3 = (SparseArray) objObjectValue;
            }
            if (sparseArray3 != null) {
                sparseArray2.put(8424, sparseArray3);
            } else {
                sparseArray2.put(8424, sparseArray);
            }
            sparseArray2.put(-99999987, 8241);
            sparseArray2.put(-99999985, Void.class);
            function.apply(sparseArray2);
        }
    }

    private boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("com.bytedance.msdk.adapter.");
    }
}
