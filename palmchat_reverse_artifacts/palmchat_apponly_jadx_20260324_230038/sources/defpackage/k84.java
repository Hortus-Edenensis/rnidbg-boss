package defpackage;

import android.content.Intent;
import android.os.Parcelable;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.greendao.model.Media;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class k84 {
    public static Intent a(Intent intent, q84[] q84VarArr) {
        if (q84VarArr != null && q84VarArr.length != 0) {
            intent.putExtra("key_publish_type", 2);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (q84 q84Var : q84VarArr) {
                String strI = q84Var.i();
                MediaItem mediaItem = new MediaItem();
                mediaItem.fileFullPath = strI;
                arrayList.add(mediaItem);
            }
            intent.putParcelableArrayListExtra("key_publish_pictures", arrayList);
            intent.putExtra("key_publish_app_name", q84VarArr[0].c());
            intent.putExtra("key_publish_author_name", q84VarArr[0].a());
        }
        return intent;
    }

    public static Intent b(Intent intent, r84 r84Var) {
        if (r84Var == null) {
            return intent;
        }
        intent.putExtra("key_publish_type", 4);
        Media media = new Media();
        media.url = r84Var.m();
        media.thumbUrl = r84Var.j();
        media.title = r84Var.l();
        media.subTitle = r84Var.h();
        intent.putExtra("key_publish_share_media", media);
        intent.putExtra("key_publish_app_name", r84Var.c());
        intent.putExtra("key_publish_author_name", r84Var.a());
        return intent;
    }

    public static Intent c(Intent intent, v84 v84Var) {
        if (v84Var == null) {
            return intent;
        }
        intent.putExtra("key_publish_type", 6);
        intent.putExtra("key_publish_subject", v84Var.m());
        intent.putExtra("key_publish_url", v84Var.n());
        intent.putExtra("key_publish_shortcut_icon", v84Var.j());
        intent.putExtra("key_publish_wineName", v84Var.i());
        intent.putExtra("key_publish_wineHead", v84Var.h());
        intent.putExtra("key_publish_wineImageUrl", v84Var.j());
        intent.putExtra("key_publish_videoUrl", v84Var.o());
        intent.putExtra("key_publish_app_name", v84Var.c());
        intent.putExtra("key_publish_author_name", v84Var.a());
        return intent;
    }

    public static Intent d(Intent intent, z84 z84Var) {
        if (z84Var == null) {
            return intent;
        }
        intent.putExtra("key_publish_type", 1);
        intent.putExtra("key_publish_text", z84Var.i());
        intent.putExtra("key_publish_app_name", z84Var.c());
        intent.putExtra("key_publish_author_name", z84Var.a());
        return intent;
    }

    public static Intent e(Intent intent, u84 u84Var) {
        if (u84Var == null) {
            return intent;
        }
        intent.putExtra("key_publish_type", 7);
        intent.putExtra("key_publish_subject", u84Var.l());
        intent.putExtra("key_publish_url", u84Var.m());
        intent.putExtra("key_publish_shortcut_icon", u84Var.j());
        intent.putExtra("key_publish_open_link", u84Var.k());
        intent.putExtra("key_publish_wineName", u84Var.t());
        intent.putExtra("key_publish_wineHead", u84Var.s());
        intent.putExtra("key_publish_wineImageUrl", u84Var.j());
        intent.putExtra("key_publish_app_name", u84Var.c());
        intent.putExtra("key_publish_author_name", u84Var.a());
        return intent;
    }

    public static Intent f(Intent intent, b94 b94Var) {
        if (b94Var == null) {
            return intent;
        }
        intent.putExtra("key_publish_type", 4);
        intent.putExtra("key_publish_subject", b94Var.l());
        intent.putExtra("key_publish_url", b94Var.m());
        intent.putExtra("key_publish_shortcut_icon", b94Var.j());
        intent.putExtra("key_publish_shortcut_icon_data", b94Var.i());
        intent.putExtra("key_publish_app_name", b94Var.c());
        intent.putExtra("key_publish_author_name", b94Var.a());
        return intent;
    }
}
