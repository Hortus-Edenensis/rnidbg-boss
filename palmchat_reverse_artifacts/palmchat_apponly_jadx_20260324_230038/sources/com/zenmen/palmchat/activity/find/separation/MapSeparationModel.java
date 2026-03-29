package com.zenmen.palmchat.activity.find.separation;

import android.os.Bundle;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class MapSeparationModel {
    public boolean tipStatus;
    public int status = 0;
    public int durationSeconds = 0;
    public int bean = 0;
    public int remainSeconds = 0;
    public double longitude = 0.0d;
    public double latitude = 0.0d;
    public String address = "";
    public String expiredText = "";
    public String unlockBtnTitle = "";
    public String clonedBtnTitle = "";
    public String unlockJourneyBtnTitle = "";

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("status", this.status);
        bundle.putInt("durationSeconds", this.durationSeconds);
        bundle.putInt("bean", this.bean);
        bundle.putInt("remainSeconds", this.remainSeconds);
        bundle.putBoolean("tipStatus", this.tipStatus);
        bundle.putDouble("longitude", this.longitude);
        bundle.putDouble("latitude", this.latitude);
        bundle.putString("address", this.address);
        bundle.putString("expiredText", this.expiredText);
        bundle.putString("unlockBtnTitle", this.unlockBtnTitle);
        bundle.putString("clonedBtnTitle", this.clonedBtnTitle);
        bundle.putString("unlockJourneyBtnTitle", this.unlockJourneyBtnTitle);
        return bundle;
    }
}
