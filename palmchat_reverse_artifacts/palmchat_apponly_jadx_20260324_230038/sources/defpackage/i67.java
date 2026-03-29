package defpackage;

import com.cdadata.sdk.api.ZMDataSDKManager;
import com.kuaishou.weapon.p0.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class i67 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i67 f18116a;

    public static i67 a() {
        if (f18116a == null) {
            synchronized (i67.class) {
                if (f18116a == null) {
                    f18116a = new i67();
                }
            }
        }
        return f18116a;
    }

    public byte[] b(byte[] bArr) {
        return (t.k.equals(ZMDataSDKManager.getInstance().zmConfigOptions.securityType) ? new y57() : new b57()).a(bArr);
    }
}
