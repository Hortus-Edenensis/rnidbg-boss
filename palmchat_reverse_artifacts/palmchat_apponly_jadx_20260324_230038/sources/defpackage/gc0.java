package defpackage;

import android.content.Context;
import android.content.Intent;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.circle.bean.CircleRecommendItem;
import com.zenmen.palmchat.circle.ui.CircleDetailActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class gc0 {
    public static void a(Context context, CircleRecommendItem circleRecommendItem, int i) {
        if (context == null || circleRecommendItem == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ChatterActivity.class);
        intent.putExtra("chat_item", circleRecommendItem.copyForGroupInfoItem());
        intent.putExtra("chat_need_back_to_main", false);
        intent.putExtra("fromType", i);
        context.startActivity(intent);
    }

    public static void b(Context context, String str, int i) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) CircleDetailActivity.class);
        intent.putExtra(j70.f18338a, str);
        intent.putExtra("key_apply_group_source", i);
        context.startActivity(intent);
    }
}
