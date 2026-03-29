package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.lantern.core.business.ParamHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class xl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<cm0> f21996a = new ArrayList();

    static {
        Log.i("CX_EVENT", "ConfigService Default Configs init!");
        List<String> presetEventList = ParamHelper.getPresetEventList();
        if (presetEventList.isEmpty()) {
            return;
        }
        for (String str : presetEventList) {
            if (!TextUtils.isEmpty(str)) {
                f21996a.add(new cm0(str, 1, 2147483647L));
            }
        }
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        Log.i("CX_EVENT", "ConfigService insert Default Event!");
        int i = 0;
        while (true) {
            try {
                List<cm0> list = f21996a;
                if (i >= list.size()) {
                    return;
                }
                Log.i("CX_EVENT", "ConfigService loadDefaultConfig insert, result:" + ul0.b(context).d(list.get(i)));
                i++;
            } catch (Exception e) {
                Log.i("CX_EVENT", "ConfigService loadDefaultConfig, e:" + e.getMessage());
                return;
            }
        }
    }
}
