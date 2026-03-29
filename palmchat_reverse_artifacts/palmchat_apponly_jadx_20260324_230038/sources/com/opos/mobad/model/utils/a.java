package com.opos.mobad.model.utils;

import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    public static MaterialData a(AdItemData adItemData) {
        if (adItemData == null) {
            return null;
        }
        try {
            List<MaterialData> listI = adItemData.i();
            if (listI == null || listI.isEmpty()) {
                return null;
            }
            for (int i = 0; i < listI.size(); i++) {
                MaterialData materialData = listI.get(i);
                if (materialData != null) {
                    return materialData;
                }
            }
            return null;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AdItemDataUtils", "getFirstMaterialData() fail", e);
            return null;
        }
    }
}
