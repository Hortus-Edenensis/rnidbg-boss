package cn.fly.verify.pure.entity;

import cn.fly.verify.f;
import cn.fly.verify.fu;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class UiElement extends a {
    private String privacyName;
    private String privacyUrl;
    private String slogan;

    public String getPrivacyName() {
        return this.privacyName;
    }

    public String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public String getSlogan() {
        return this.slogan;
    }

    public void setPrivacyName(String str) {
        this.privacyName = str;
    }

    public void setPrivacyUrl(String str) {
        this.privacyUrl = str;
    }

    public void setSlogan(String str) {
        this.slogan = str;
    }

    @Override // cn.fly.verify.pure.entity.a
    public String toJson() {
        try {
            fu fuVar = new fu();
            HashMap map = new HashMap();
            map.put("privacyName", this.privacyName);
            map.put("privacyUrl", this.privacyUrl);
            map.put("slogan", this.slogan);
            return fuVar.a(map);
        } catch (Throwable th) {
            f.a().a(th, "[FlyVerify][%s][%s] ==>%s", this.tag, "toJson", "Error parse entity to json");
            return "";
        }
    }
}
