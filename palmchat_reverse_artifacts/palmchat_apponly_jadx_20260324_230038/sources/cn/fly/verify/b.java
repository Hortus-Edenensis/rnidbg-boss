package cn.fly.verify;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Serializable {
    protected fu g = new fu();
    protected HashMap<String, Object> h = new HashMap<>();

    public b b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.h = this.g.a(str);
            } catch (Throwable th) {
                f.a().a(th, "[FlyVerify] ==>%s", "Entity analyse exception.");
            }
        }
        return this;
    }
}
