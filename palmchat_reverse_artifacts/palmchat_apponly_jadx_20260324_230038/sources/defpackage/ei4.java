package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.palmchat.photoview.PhotoViewActivity;
import com.zenmen.palmchat.publish.PublishActivity;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ei4 {
    public static ArrayList<FeedBean> a(ArrayList<MediaItem> arrayList) {
        ArrayList<FeedBean> arrayList2 = new ArrayList<>();
        for (MediaItem mediaItem : arrayList) {
            FeedBean feedBean = new FeedBean();
            feedBean.setFeedId(0L);
            feedBean.setMediaItem(mediaItem);
            feedBean.setWidth(Integer.toString(PublishActivity.U1(mediaItem.localThumbPath)[0]));
            feedBean.setHeight(Integer.toString(PublishActivity.U1(mediaItem.localThumbPath)[1]));
            arrayList2.add(feedBean);
        }
        return arrayList2;
    }

    public static Intent b(Context context, Feed feed, Long l, String str, String str2, int i, ContactInfoItem contactInfoItem) {
        return nq3.a().b(context, feed, l, str, str2, i, contactInfoItem);
    }

    public static Intent c(Feed feed, Long l, String str, int i, ContactInfoItem contactInfoItem, int i2) {
        Intent intent = new Intent();
        intent.setAction("com.zenmen.square.MOMENTS_HALF");
        intent.setPackage(k86.u());
        if (feed != null) {
            intent.putExtra("extra_feed", feed);
        }
        intent.putExtra("extra_feed_id", l);
        intent.putExtra("extra_feed_uid", str);
        intent.putExtra("extra_from", i);
        if (contactInfoItem != null) {
            intent.putExtra("user_detail_contact_info", contactInfoItem);
        }
        intent.putExtra("feed_type", i2);
        return intent;
    }

    public static void d(Context context, Feed feed, Long l, String str, ContactInfoItem contactInfoItem, int i, int i2) {
        context.startActivity(c(feed, l, str, i, contactInfoItem, i2));
    }

    public static void e(Activity activity, Feed feed, ArrayList<FeedBean> arrayList, int i, int i2, long j, String str, int i3) {
        Intent intentB = b(activity, feed, Long.valueOf(j), str, "from_only_preview", i3, null);
        intentB.putExtra("selectIndex", i);
        intentB.putParcelableArrayListExtra("extra_key_feeds", arrayList);
        activity.startActivityForResult(intentB, i2);
    }

    public static void f(Activity activity, ArrayList<FeedBean> arrayList, int i) {
        Intent intent = new Intent(activity, (Class<?>) PhotoViewActivity.class);
        intent.putExtra("selectIndex", i);
        intent.putParcelableArrayListExtra("extra_key_feeds", arrayList);
        intent.putExtra("KEY_FROM", "from_publish_share");
        activity.startActivity(intent);
    }

    public static void g(Activity activity, ArrayList<FeedBean> arrayList, int i, int i2) {
        Intent intent = new Intent(activity, (Class<?>) PhotoViewActivity.class);
        intent.putExtra("selectIndex", i);
        intent.putParcelableArrayListExtra("extra_key_feeds", arrayList);
        intent.putExtra("KEY_FROM", "from_publish_preview");
        activity.startActivityForResult(intent, i2);
    }

    public static void h(Activity activity, ArrayList<FeedBean> arrayList, int i, int i2) {
        Intent intent = new Intent(activity, (Class<?>) PhotoViewActivity.class);
        intent.putExtra("selectIndex", i);
        intent.putParcelableArrayListExtra("extra_key_feeds", arrayList);
        intent.putExtra("KEY_FROM", "from_square_publish_preview");
        activity.startActivityForResult(intent, i2);
    }

    public static void i(Activity activity, ArrayList<FeedBean> arrayList, int i, Rect rect, int i2, Feed feed, int i3) {
        Intent intentB = b(activity, feed, Long.valueOf(feed.getId()), feed.getUid(), "from_only_preview", i3, null);
        intentB.putParcelableArrayListExtra("extra_key_feeds", arrayList);
        intentB.putExtra("extra_key_transition_rect", rect);
        intentB.putExtra("extra_key_video_position", i2);
        activity.startActivityForResult(intentB, i);
        activity.overridePendingTransition(0, 0);
    }

    public static void j(Activity activity, ArrayList<FeedBean> arrayList, int i, Feed feed, int i2) {
        Intent intentB = b(activity, feed, Long.valueOf(feed.getId()), feed.getUid(), "from_only_preview", i2, null);
        intentB.putParcelableArrayListExtra("extra_key_feeds", arrayList);
        activity.startActivityForResult(intentB, i);
    }

    public static void k(Activity activity, ArrayList<FeedBean> arrayList, int i) {
        Intent intent = new Intent(activity, (Class<?>) PhotoViewActivity.class);
        intent.putParcelableArrayListExtra("extra_key_feeds", arrayList);
        intent.putExtra("KEY_FROM", "from_publish_video_only_preview");
        activity.startActivityForResult(intent, i);
    }
}
