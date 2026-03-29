package com.zm.adxsdk.tools;

import android.util.Log;
import com.zm.adxsdk.tools.defective.ui.SlotDetailActivity;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;
import com.zm.fissionsdk.api.interfaces.IFissionNative;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class s implements IFissionLoadManager.NativeLoadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlotDetailActivity f16612a;

    public s(SlotDetailActivity slotDetailActivity) {
        this.f16612a = slotDetailActivity;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.FissionLoadListener
    public final void onError(int i, String str) {
        SlotDetailActivity slotDetailActivity = this.f16612a;
        slotDetailActivity.p = false;
        slotDetailActivity.a("请求失败，错误信息：" + str);
        Log.e("SlotDetailActivity", "code:" + i + " , msg:" + str);
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionLoadManager.FissionLoadListener
    public final void onLoad(List<IFissionNative> list) {
        String str;
        this.f16612a.p = false;
        if (list == null || list.isEmpty()) {
            this.f16612a.a("请求成功，返回广告对象为空");
            Log.e("SlotDetailActivity", "onLoad but list is empty");
            return;
        }
        IFissionNative iFissionNative = list.get(0);
        SlotDetailActivity slotDetailActivity = this.f16612a;
        slotDetailActivity.getClass();
        Log.e("SlotDetailActivity", "onNativeLoaded Success");
        if (iFissionNative == null) {
            Log.e("SlotDetailActivity", "onNativeLoaded fissionNative is null");
            str = "广告请求成功，广告对象为空";
        } else {
            slotDetailActivity.a("广告请求成功");
            if (iFissionNative.getExpressView(slotDetailActivity) == null) {
                slotDetailActivity.a("获取信息流模版广告View");
                Log.e("SlotDetailActivity", "onNativeLoaded expressView is null");
                return;
            } else {
                Log.e("SlotDetailActivity", "onNativeLoaded expressView is not null");
                str = "没有获取信息流模版广告View";
            }
        }
        slotDetailActivity.a(str);
    }
}
