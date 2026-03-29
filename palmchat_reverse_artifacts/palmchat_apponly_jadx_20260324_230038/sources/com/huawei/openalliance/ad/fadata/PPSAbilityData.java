package com.huawei.openalliance.ad.fadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class PPSAbilityData {
    private List<PPSAbilityDataContent> abilityDataContent;
    private String displayForm;

    public String Code() {
        return this.displayForm;
    }

    public List<PPSAbilityDataContent> V() {
        return this.abilityDataContent;
    }

    public void Code(String str) {
        this.displayForm = str;
    }

    public void Code(List<PPSAbilityDataContent> list) {
        this.abilityDataContent = list;
    }
}
