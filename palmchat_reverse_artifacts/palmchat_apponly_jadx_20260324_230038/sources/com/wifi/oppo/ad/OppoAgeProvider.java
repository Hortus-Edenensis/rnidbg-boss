package com.wifi.oppo.ad;

import com.heytap.msp.mobad.api.ClassifyByAgeProvider;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class OppoAgeProvider extends ClassifyByAgeProvider {
    private String ageProvide;

    public OppoAgeProvider(String str) {
        this.ageProvide = str;
    }

    @Override // com.heytap.msp.mobad.api.ClassifyByAgeProvider
    public String getClassifyByAge() {
        return this.ageProvide;
    }
}
