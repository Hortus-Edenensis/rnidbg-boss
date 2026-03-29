package defpackage;

import android.content.Intent;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.contacts.recommend.RecommendFriendsActivity;
import org.apache.webplatform.jssdk.ContactPlugin;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class on0 {
    public static Intent a(String str) {
        Intent intent = new Intent();
        intent.putExtra(ContactPlugin.EXTRA_KEY_FROM, str);
        intent.setClass(AppContext.getContext(), RecommendFriendsActivity.class);
        return intent;
    }
}
