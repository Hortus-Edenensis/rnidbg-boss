package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.gson.reflect.TypeToken;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.framework.modulebadge.ModuleBadgeManager;
import com.zenmen.palmchat.sync.AlertVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class sa3 {
    public static volatile sa3 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<AlertVo> f20694a;
    public HashMap<ModuleBadgeManager.Module, Integer> b = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<ModuleBadgeManager.Module, Integer> {
        public a() {
            put(ModuleBadgeManager.Module.NEARBYGROUP, 2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends TypeToken<List<AlertVo>> {
        public b() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements com.zenmen.palmchat.framework.modulebadge.a {
        @Override // com.zenmen.palmchat.framework.modulebadge.a
        public void a(ModuleBadgeManager.Module module, ModuleBadgeManager.a aVar) {
            sa3.b().g(module, aVar);
        }

        @Override // com.zenmen.palmchat.framework.modulebadge.a
        public ModuleBadgeManager.a b(ModuleBadgeManager.Module module) {
            return sa3.b().c(module);
        }
    }

    public sa3() {
        this.f20694a = new ArrayList<>();
        String string = d(AppContext.getContext()).getString(e(), "");
        if (!TextUtils.isEmpty(string)) {
            this.f20694a = (ArrayList) az2.b(string, new b().getType());
        }
        LogUtil.i("LxModuleBadgeOperator", "LxModuleBadgeOperator int " + string + " currentAlertVo=" + this.f20694a.size());
    }

    public static sa3 b() {
        if (c == null) {
            synchronized (sa3.class) {
                if (c == null) {
                    c = new sa3();
                }
            }
        }
        return c;
    }

    public static SharedPreferences d(Context context) {
        return context.getSharedPreferences("sp_local_alert", 0);
    }

    public final AlertVo a(ModuleBadgeManager.Module module) {
        Integer num;
        if (module != null && (num = this.b.get(module)) != null) {
            for (AlertVo alertVo : this.f20694a) {
                if (alertVo.nid == num.intValue()) {
                    return alertVo;
                }
            }
        }
        return null;
    }

    public ModuleBadgeManager.a c(ModuleBadgeManager.Module module) {
        AlertVo alertVoA = a(module);
        ModuleBadgeManager.a aVar = new ModuleBadgeManager.a();
        aVar.f13979a = f(alertVoA);
        return aVar;
    }

    public final String e() {
        return k86.a("key_alerts_info");
    }

    public final int f(AlertVo alertVo) {
        if (alertVo != null && !TextUtils.isEmpty(alertVo.text)) {
            try {
                return Integer.parseInt(alertVo.text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void g(ModuleBadgeManager.Module module, ModuleBadgeManager.a aVar) {
        AlertVo alertVoA = a(module);
        if (alertVoA != null) {
            alertVoA.text = String.valueOf(aVar.f13979a);
            h();
        }
    }

    public final void h() {
        String strC = az2.c(this.f20694a);
        LogUtil.i("LxModuleBadgeOperator", "updateLocalStorage " + strC);
        d(AppContext.getContext()).edit().putString(e(), strC).apply();
        Intent intent = new Intent();
        intent.setAction(mo3.j);
        LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
    }
}
