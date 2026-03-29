package com.opos.mobad.model.utils;

import android.text.TextUtils;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {
    public static MaterialFileData a(MaterialData materialData) {
        if (materialData == null) {
            return null;
        }
        try {
            List<MaterialFileData> listH = materialData.h();
            if (listH == null || listH.isEmpty()) {
                return null;
            }
            for (int i = 0; i < listH.size(); i++) {
                MaterialFileData materialFileData = listH.get(i);
                if (materialFileData != null && !TextUtils.isEmpty(materialFileData.a())) {
                    return materialFileData;
                }
            }
            return null;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("MaterialDataUtils", "getFirstIconFile() fail", e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(AdItemData adItemData, MaterialData materialData) {
        boolean z;
        try {
            boolean zA = com.opos.mobad.o.c.a();
            boolean z2 = (materialData == null || TextUtils.isEmpty(materialData.ai()) || materialData.aj() <= 0) ? false : true;
            if (adItemData != null) {
                z = adItemData.w() != 0;
            }
            return z2 && z && zA;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("MaterialDataUtils", "isTrialGame() fail", e);
            return false;
        }
    }
}
