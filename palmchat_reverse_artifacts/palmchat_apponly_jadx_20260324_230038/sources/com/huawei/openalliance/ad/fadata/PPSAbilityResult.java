package com.huawei.openalliance.ad.fadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class PPSAbilityResult {
    private ArrayList<PPSAbilityData> abilityDatas;
    private String intentSn;

    public String Code() {
        return this.intentSn;
    }

    public ArrayList<PPSAbilityData> V() {
        return this.abilityDatas;
    }

    public void Code(String str) {
        this.intentSn = str;
    }

    public void Code(ArrayList<PPSAbilityData> arrayList) {
        this.abilityDatas = arrayList;
    }
}
