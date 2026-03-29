package cn.fly.verify.pure.entity;

import cn.fly.verify.f;
import cn.fly.verify.fu;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class PreVerifyResult extends a {
    public String channel;
    private final long expireAt;
    private final String operator;
    private final String securityPhone;
    private final UiElement uiElement;

    public PreVerifyResult(String str, String str2) {
        this.operator = str2;
        this.securityPhone = str;
        this.uiElement = genUiElement(str2);
        this.expireAt = setExpireAt();
    }

    private long setExpireAt() {
        return System.currentTimeMillis() + 3600000;
    }

    public String getChannel() {
        return this.channel;
    }

    public long getExpireAt() {
        return this.expireAt;
    }

    public String getOperator() {
        return this.operator;
    }

    public String getSecurityPhone() {
        return this.securityPhone;
    }

    public UiElement getUiElement() {
        return this.uiElement;
    }

    @Override // cn.fly.verify.pure.entity.a
    public String toJson() {
        try {
            fu fuVar = new fu();
            HashMap map = new HashMap();
            map.put("operator", this.operator);
            map.put("securityPhone", this.securityPhone);
            map.put("uiElement", fuVar.a(this.uiElement.toJson()));
            return fuVar.a(map);
        } catch (Throwable th) {
            f.a().a(th, "[FlyVerify][%s][%s] ==>%s", this.tag, "toJson", "Error parse entity to json");
            return "";
        }
    }

    public PreVerifyResult(String str, String str2, long j, String str3) {
        this.operator = str2;
        this.securityPhone = str;
        this.expireAt = j;
        this.uiElement = genUiElement(str2);
        this.channel = str3;
    }
}
