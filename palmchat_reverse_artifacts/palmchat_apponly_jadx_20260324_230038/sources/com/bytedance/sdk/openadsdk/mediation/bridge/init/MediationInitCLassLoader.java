package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.api.iz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import com.bytedance.sdk.openadsdk.mediation.u.u;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationInitCLassLoader extends u {
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> void u(ValueSet valueSet) {
        Class<?> cls;
        MediationInitConfig mediationInitConfigCreate = MediationInitConfig.create(valueSet);
        try {
            if (!mediationInitConfigCreate.isCustom() || mediationInitConfigCreate.getCustomInitConfigValueSet() == null) {
                String adapterManagerClassName = mediationInitConfigCreate.getAdapterManagerClassName();
                String aDNName = mediationInitConfigCreate.getADNName();
                Function<SparseArray<Object>, Object> adapterManager = (adapterManagerClassName == null || aDNName == null) ? false : AdnManagerConfig.initAdnManager(adapterManagerClassName, aDNName) ? AdnManagerConfig.getAdapterManager(aDNName) : null;
                if (adapterManager != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 10000);
                    sparseArray.put(-99999985, Object.class);
                    u(adapterManager.apply(sparseArray), valueSet);
                    return;
                }
                cls = Class.forName(mediationInitConfigCreate.getClassName());
            } else {
                cls = Class.forName(mediationInitConfigCreate.getCustomInitConfigValueSet().stringValue(8536));
            }
            u(cls.newInstance(), valueSet);
        } catch (ClassNotFoundException e) {
            e = e;
            iz.u(e);
            if (0 != 0) {
                iz.pn(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
            }
        } catch (NoClassDefFoundError e2) {
            e = e2;
            iz.u(e);
            if (0 != 0) {
            }
        } catch (Throwable th) {
            iz.u(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.u.u
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i != 8100) {
            return null;
        }
        u(valueSet);
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.u.u
    public SparseArray<Object> get() {
        return null;
    }

    private void u(Object obj, ValueSet valueSet) {
        if (obj instanceof Function) {
            Function function = (Function) obj;
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, TTAppContextHolder.getContext());
            sparseArray.put(8424, valueSet == null ? null : valueSet.sparseArray());
            sparseArray.put(-99999987, 8240);
            sparseArray.put(-99999985, Void.class);
            function.apply(sparseArray);
        }
    }
}
