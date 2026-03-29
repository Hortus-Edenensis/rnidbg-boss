package defpackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.webplatform.WebModuleActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class kb3 {
    public static boolean a(Context context, String str, String str2, boolean z) {
        try {
            String strD = rp3.f().d(context, str);
            if (TextUtils.isEmpty(strD)) {
                return false;
            }
            Intent intent = new Intent(context, (Class<?>) WebModuleActivity.class);
            intent.putExtra("source_tab_tag", MainTabsActivity.y2());
            intent.putExtra("source_page_tag", str);
            intent.putExtra("web_url", strD);
            intent.putExtra("extra_url_extension", "?from=601");
            intent.putExtra("app_id", str);
            intent.putExtra("extra_hide_menu", true);
            intent.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, z);
            intent.putExtra("extra_status_bar_color", context.getResources().getColor(R.color.status_bar_color));
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
