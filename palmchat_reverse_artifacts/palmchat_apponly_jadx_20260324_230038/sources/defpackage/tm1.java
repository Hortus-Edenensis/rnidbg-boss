package defpackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.webplatform.WebModuleActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class tm1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile tm1 f21022a;

    public static tm1 a() {
        if (f21022a == null) {
            synchronized (tm1.class) {
                if (f21022a == null) {
                    f21022a = new tm1();
                }
            }
        }
        return f21022a;
    }

    public boolean b() {
        return true;
    }

    public boolean c(Context context, boolean z, boolean z2) {
        boolean z3 = false;
        try {
            String strD = rp3.f().d(context, "lx-recommendedList");
            if (TextUtils.isEmpty(strD)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("?showNoTip=");
            sb.append((z && io0.r()) ? "1" : "0");
            String string = sb.toString();
            Intent intent = new Intent(context, (Class<?>) WebModuleActivity.class);
            intent.putExtra("web_url", strD);
            intent.putExtra("extra_url_extension", string);
            intent.putExtra("app_id", "lx-recommendedList");
            intent.putExtra("extra_hide_menu", true);
            intent.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, z2);
            intent.putExtra("extra_status_bar_color", context.getResources().getColor(R.color.status_bar_color));
            context.startActivity(intent);
            if (z) {
                try {
                    io0.a();
                } catch (Exception e) {
                    e = e;
                    z3 = true;
                }
            }
            return true;
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        return z3;
    }
}
