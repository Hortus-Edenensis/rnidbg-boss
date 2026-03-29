package defpackage;

import android.content.Context;
import android.content.Intent;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.guide.HuaweiBootAndBackgroundGuideActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class n86 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19459a = tj2.a();

    public static int a() {
        ol2 ol2VarB = sb1.b(AppContext.getContext());
        return (ol2VarB == null || !ol2VarB.hasBackGround()) ? 0 : 1;
    }

    public static String b(String str, String str2, String str3) {
        return String.format(f19459a + "manufacturer=%s&language=%s&code=%s", str, str2, str3);
    }

    public static void c(Context context, Intent intent) {
        if (intent != null) {
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void d(Context context) {
        ol2 ol2VarB = sb1.b(context);
        if (ol2VarB == null) {
            return;
        }
        if (!ol2VarB.hasBackGround()) {
            sy5.e(context, R.string.already_get_background_permission, 0);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) HuaweiBootAndBackgroundGuideActivity.class);
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
