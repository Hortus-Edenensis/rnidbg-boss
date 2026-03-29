package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class j23 {
    public static long a(Feed feed) {
        if (feed.getLikesList() != null) {
            for (Comment comment : feed.getLikesList()) {
                if (TextUtils.equals(comment.getFromUid(), v4.e(c.b()))) {
                    return comment.getId().longValue();
                }
            }
        }
        return 0L;
    }

    public static boolean b(Feed feed) {
        if (feed.getLikesList() != null) {
            Iterator<Comment> it = feed.getLikesList().iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getFromUid(), v4.e(c.b()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
