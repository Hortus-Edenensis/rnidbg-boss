package defpackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b65 {
    public static b65 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f1657a = new ArrayList();

    public b65() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SERVICE_ACCOUNT_CFG);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            this.f1657a.add("88888004");
            this.f1657a.add("88888005");
        } else {
            LogUtil.d("ServiceAccountOnTeenagesMode", "config = " + dynamicConfig.getExtra());
            if (!TextUtils.isEmpty(dynamicConfig.getExtra())) {
                try {
                    JSONArray jSONArray = new JSONObject(dynamicConfig.getExtra()).getJSONArray(DeviceInfoUtil.UID_TAG);
                    if (jSONArray != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            this.f1657a.add(jSONArray.getString(i));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        this.f1657a.add("88888027");
    }

    public static b65 a() {
        if (b == null) {
            synchronized (b65.class) {
                if (b == null) {
                    b = new b65();
                }
            }
        }
        return b;
    }

    public static void c() {
        Toast toastMakeText = Toast.makeText(AppContext.getContext(), "", 0);
        toastMakeText.setGravity(17, 0, 0);
        toastMakeText.setView(LayoutInflater.from(AppContext.getContext()).inflate(R.layout.custom_toast, (ViewGroup) null));
        toastMakeText.show();
    }

    public boolean b(String str) {
        LogUtil.d("ServiceAccountOnTeenagesMode", "isServieAccountAndNotInWhiteList uid = " + str + ", isTeenageModeOpen = " + TeenagersModeManager.a().d() + ", isServiceAccount = " + a65.f(str) + ", isInWhiteList = " + this.f1657a.contains(str));
        return TeenagersModeManager.a().d() && a65.f(str) && !this.f1657a.contains(str);
    }
}
