package defpackage;

import android.os.Bundle;
import com.zenmen.square.mvp.model.bean.SquareFeed;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ub4 {
    public static ut1 a(int i, Bundle bundle, SquareFeed squareFeed) {
        return (i == 1 || (i == 74 && !squareFeed.ifFriend)) ? new vb4(i, "square.new.scroll.list.v1", bundle) : i == 73 ? new vb4(i, "square.lbs.scroll.list.v1", bundle) : (i == 47 || i == 6) ? new vb4(i, "square.rec.scroll.list.v1", bundle) : i == 5 ? new wb4(i, "square.queryScrollFeedByTag.v8", bundle) : (i == 7 || i == 16) ? new wb4(i, "square.timeline.scroll.list.v1", bundle) : (i == 74 && squareFeed.ifFriend) ? new wb4(i, "square.friend.feed.scroll.list.v8", bundle) : d(i);
    }

    public static wq3 b(int i, Bundle bundle) {
        return i == 20 ? new sb4(i, "feeds.outbox.immersive.list.v1", bundle) : c(i);
    }

    public static ud5 c(int i) {
        return new ud5(i);
    }

    public static wd5 d(int i) {
        return new wd5(i);
    }
}
