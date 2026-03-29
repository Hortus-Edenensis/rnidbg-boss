package defpackage;

import android.content.Context;
import android.content.Intent;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.square.MomentsDetailFullActivity;
import com.zenmen.square.SquareMessageActivity;
import defpackage.nq3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ar3 implements nq3.d {
    @Override // nq3.d
    public void a(Context context) {
        Intent intent = new Intent(context, (Class<?>) SquareMessageActivity.class);
        intent.putExtra("key_page", "a0403");
        context.startActivity(intent);
    }

    @Override // nq3.d
    public Intent b(Context context, Feed feed, Long l, String str, String str2, int i, ContactInfoItem contactInfoItem) {
        return MomentsDetailFullActivity.A1(context, feed, l, str, str2, i, contactInfoItem);
    }
}
