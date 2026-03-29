package defpackage;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class yw4 {
    private aw cacheConfig;

    public aw getCacheConfig() {
        return this.cacheConfig;
    }

    public abstract void onFail(Exception exc);

    public abstract void onSuccess(JSONObject jSONObject, yy2 yy2Var);

    public yw4 setCacheConfig(aw awVar) {
        this.cacheConfig = awVar;
        return this;
    }

    public boolean toastOnFail() {
        return false;
    }
}
