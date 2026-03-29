package defpackage;

import android.text.TextUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.msgTopEntrance.FuncConfig;
import com.zenmen.palmchat.maintab.msgTopEntrance.FuncItem;
import com.zenmen.palmchat.maintab.msgTopEntrance.LocalSavedConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class is3 {
    public static volatile is3 b = null;
    public static boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<FuncItem> f18252a = null;

    public static is3 b() {
        if (b == null) {
            synchronized (is3.class) {
                if (b == null) {
                    b = new is3();
                }
            }
        }
        return b;
    }

    public void a() {
        this.f18252a = null;
        LogUtil.i("MsgTopEntranceManager", "clear");
    }

    public List<FuncItem> c() {
        if (this.f18252a == null) {
            this.f18252a = d();
        }
        LogUtil.i("MsgTopEntranceManager", "getListForShow" + az2.c(this.f18252a));
        return this.f18252a;
    }

    public final List<FuncItem> d() {
        String str;
        List<FuncItem> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObjectS = ts0.o().s();
            LogUtil.i("MsgTopEntranceManager", "getConfigImp jsonObject=" + jSONObjectS);
            if (jSONObjectS == null) {
                return arrayList;
            }
            String strE = t66.h().e("LX-64245", "A");
            LogUtil.i("MsgTopEntranceManager", "getConfigImp pandaV=" + strE);
            if (c) {
                strE = WkAdxAdConfigMg.DSP_NAME_BAIDU;
            }
            JSONObject jSONObjectOptJSONObject = jSONObjectS.optJSONObject(strE);
            if (jSONObjectOptJSONObject == null) {
                return arrayList;
            }
            LogUtil.i("MsgTopEntranceManager", "getConfigImp config=" + jSONObjectOptJSONObject);
            FuncConfig funcConfig = (FuncConfig) az2.a(jSONObjectOptJSONObject.toString(), FuncConfig.class);
            if (funcConfig == null) {
                return arrayList;
            }
            ContactInfoItem contactInfoItemF = v4.f();
            boolean z = true;
            if (contactInfoItemF != null && contactInfoItemF.getGender() != 1) {
                z = false;
            }
            List<FuncItem> list = z ? funcConfig.female : funcConfig.male;
            if (list == null) {
                return arrayList;
            }
            List<FuncItem> fixList = FuncItem.getFixList(list);
            if (fixList == null) {
                return arrayList;
            }
            try {
                String strP = SPUtil.f14322a.p(SPUtil.SCENE.APP_COMMON, "key_msg_top_entrance_local_state", "");
                if (!TextUtils.isEmpty(strP)) {
                    LogUtil.i("MsgTopEntranceManager", "getConfigImp savedInfo=" + strP);
                    LocalSavedConfig localSavedConfig = (LocalSavedConfig) az2.a(strP, LocalSavedConfig.class);
                    if (localSavedConfig != null && (str = localSavedConfig.originConfig) != null && str.equals(jSONObjectS.toString()) && localSavedConfig.canUse(fixList)) {
                        LogUtil.i("MsgTopEntranceManager", "getConfigImp user savedInfo success");
                        return localSavedConfig.currentConfig;
                    }
                }
                return fixList;
            } catch (Exception e) {
                e = e;
                arrayList = fixList;
            }
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        LogUtil.i("MsgTopEntranceManager", "getConfigImp ", e);
        return arrayList;
    }

    public boolean e() {
        List<FuncItem> listC = c();
        return listC != null && listC.size() > 0;
    }

    public void f(FuncItem funcItem) {
        LogUtil.i("MsgTopEntranceManager", "onItemClick start" + az2.c(this.f18252a));
        List<FuncItem> list = this.f18252a;
        if (list != null) {
            list.remove(funcItem);
            this.f18252a.add(1, funcItem);
        }
        LogUtil.i("MsgTopEntranceManager", "onItemClick end" + az2.c(this.f18252a));
    }
}
