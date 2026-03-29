package defpackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class zt5 {
    public static String a() {
        String strOptString;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.TEENGAERSMODE);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            strOptString = null;
        } else {
            try {
                strOptString = new JSONObject(dynamicConfig.getExtra()).optString("subtitle1");
            } catch (Exception e) {
                e.printStackTrace();
                strOptString = null;
            }
        }
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.teenagers_mode_subtitle1) : strOptString;
    }

    public static String b() {
        String strOptString;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.TEENGAERSMODE);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            strOptString = null;
        } else {
            try {
                strOptString = new JSONObject(dynamicConfig.getExtra()).optString("subtitle2");
            } catch (Exception e) {
                e.printStackTrace();
                strOptString = null;
            }
        }
        return TextUtils.isEmpty(strOptString) ? AppContext.getContext().getString(R.string.teenagers_mode_subtitle2) : strOptString;
    }

    public static void c() {
        Toast toastMakeText = Toast.makeText(AppContext.getContext(), "", 0);
        toastMakeText.setGravity(17, 0, 0);
        toastMakeText.setView(LayoutInflater.from(AppContext.getContext()).inflate(R.layout.custom_toast, (ViewGroup) null));
        toastMakeText.show();
    }
}
