package defpackage;

import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.openapi.impl.OAAccountUtils;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class d92 extends wr<om, Void, qt5> {
    public d92(pt5<qt5> pt5Var) {
        super(pt5Var, d92.class.getSimpleName());
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public qt5 doInBackground(om... omVarArr) throws Throwable {
        om omVar = omVarArr[0];
        Map<String, String> mapA = m44.a();
        o44 userProfile = OAAccountUtils.getUserProfile(mapA.get(DeviceInfoUtil.UID_TAG));
        mapA.put("scope", omVar.b);
        qt5 qt5VarA = qt5.a(wn.i(n44.c(), ja5.c("getOauthKey", mapA, omVar.f19789a, omVar.d)), d92.class.getSimpleName());
        if (qt5VarA.f20322a == 1) {
            try {
                qt5VarA.c.put(LxAdDLManager.ITEM_ICONURL, userProfile.a());
                qt5VarA.c.put("nickname", userProfile.c());
                qt5VarA.c.put("mobile", userProfile.b());
                return qt5VarA;
            } catch (Throwable unused) {
                qt5VarA.f20322a = 0;
                qt5VarA.b = "get local account failed";
            }
        }
        return qt5VarA;
    }
}
