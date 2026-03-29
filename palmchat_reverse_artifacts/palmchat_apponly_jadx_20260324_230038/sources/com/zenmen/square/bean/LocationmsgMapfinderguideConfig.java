package com.zenmen.square.bean;

import androidx.annotation.Keep;
import com.zenmen.square.bean.LocationmsgMapfinderguideConfig;
import defpackage.az2;
import defpackage.b05;
import defpackage.q05;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class LocationmsgMapfinderguideConfig {
    public LocationDetail location_detail = new LocationDetail();

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class LocationDetail {
        public boolean top_banner_switch = false;
        public boolean down_button_switch = false;
    }

    public static LocationmsgMapfinderguideConfig getLocationmsgMapfinderguideConfig() {
        LocationmsgMapfinderguideConfig locationmsgMapfinderguideConfig = null;
        try {
            final JSONObject jSONObjectF = q05.f("locationmsg_mapfinderguide");
            if (jSONObjectF != null) {
                b05.c(new b05.a() { // from class: r53
                    @Override // b05.a
                    public final Object getValue() {
                        return LocationmsgMapfinderguideConfig.lambda$getLocationmsgMapfinderguideConfig$0(jSONObjectF);
                    }
                });
                locationmsgMapfinderguideConfig = (LocationmsgMapfinderguideConfig) az2.a(jSONObjectF.toString(), LocationmsgMapfinderguideConfig.class);
            }
        } catch (Exception e) {
            b05.c(new b05.a() { // from class: s53
                @Override // b05.a
                public final Object getValue() {
                    return LocationmsgMapfinderguideConfig.lambda$getLocationmsgMapfinderguideConfig$1(e);
                }
            });
        }
        if (locationmsgMapfinderguideConfig == null) {
            locationmsgMapfinderguideConfig = new LocationmsgMapfinderguideConfig();
        }
        if (locationmsgMapfinderguideConfig.location_detail == null) {
            locationmsgMapfinderguideConfig.location_detail = new LocationDetail();
        }
        return locationmsgMapfinderguideConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getLocationmsgMapfinderguideConfig$0(JSONObject jSONObject) {
        return "读取的配置是===>" + jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getLocationmsgMapfinderguideConfig$1(Exception exc) {
        return "读取locationmsg_mapfinderguide配置异常: " + exc.getMessage();
    }
}
