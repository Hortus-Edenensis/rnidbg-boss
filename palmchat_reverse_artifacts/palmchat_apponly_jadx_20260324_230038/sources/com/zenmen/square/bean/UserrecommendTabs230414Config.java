package com.zenmen.square.bean;

import androidx.annotation.Keep;
import com.zenmen.square.bean.UserrecommendTabs230414Config;
import defpackage.az2;
import defpackage.b05;
import defpackage.q05;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class UserrecommendTabs230414Config {
    public Mapfinder mapfinder = new Mapfinder();

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Mapfinder {
        public boolean show_Switch = false;
    }

    public static UserrecommendTabs230414Config getUserrecommendTabs230414Config() {
        UserrecommendTabs230414Config userrecommendTabs230414Config = null;
        try {
            final JSONObject jSONObjectF = q05.f("userrecommend_tabs_230414");
            if (jSONObjectF != null) {
                b05.c(new b05.a() { // from class: a76
                    @Override // b05.a
                    public final Object getValue() {
                        return UserrecommendTabs230414Config.lambda$getUserrecommendTabs230414Config$0(jSONObjectF);
                    }
                });
                userrecommendTabs230414Config = (UserrecommendTabs230414Config) az2.a(jSONObjectF.toString(), UserrecommendTabs230414Config.class);
            }
        } catch (Exception e) {
            b05.c(new b05.a() { // from class: b76
                @Override // b05.a
                public final Object getValue() {
                    return UserrecommendTabs230414Config.lambda$getUserrecommendTabs230414Config$1(e);
                }
            });
        }
        if (userrecommendTabs230414Config == null) {
            userrecommendTabs230414Config = new UserrecommendTabs230414Config();
        }
        if (userrecommendTabs230414Config.mapfinder == null) {
            userrecommendTabs230414Config.mapfinder = new Mapfinder();
        }
        return userrecommendTabs230414Config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getUserrecommendTabs230414Config$0(JSONObject jSONObject) {
        return "读取的配置是===>" + jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getUserrecommendTabs230414Config$1(Exception exc) {
        return "读取userrecommend_tabs_230414配置异常: " + exc.getMessage();
    }
}
