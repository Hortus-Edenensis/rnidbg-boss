package defpackage;

import android.content.Context;
import android.content.Intent;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.webplatform.WebModuleActivity;
import com.zenmen.palmchat.webplatform.miniPrograms.Package;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class eg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile eg2 f17295a;

    public static eg2 a() {
        if (f17295a == null) {
            synchronized (eg2.class) {
                if (f17295a == null) {
                    f17295a = new eg2();
                }
            }
        }
        return f17295a;
    }

    public boolean b(Context context) {
        try {
            Intent intent = new Intent(context, (Class<?>) WebModuleActivity.class);
            intent.putExtra("extra_type", 3);
            intent.putExtra("app_id", "hihv3");
            intent.putExtra("extra_hide_menu", true);
            intent.putExtra("extra_status_bar_color", context.getResources().getColor(R.color.status_bar_color));
            Package r3 = new Package();
            r3.pkgId = "hihv3";
            r3.version = 0;
            intent.putExtra("extra_package", r3);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
