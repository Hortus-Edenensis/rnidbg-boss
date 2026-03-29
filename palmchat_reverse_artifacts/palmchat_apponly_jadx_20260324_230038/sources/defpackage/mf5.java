package defpackage;

import android.content.Context;
import android.content.Intent;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import defpackage.bo2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class mf5 extends bo2 {
    public Context c;

    public mf5(FrameworkBaseActivity frameworkBaseActivity, bo2.a aVar) {
        super(frameworkBaseActivity, aVar);
        this.c = frameworkBaseActivity;
    }

    @Override // defpackage.bo2
    public void a(String str) {
        b(this.c, str);
        this.f1790a.onFinish(true);
    }

    public final void b(Context context, String str) {
        String strSubstring = str.substring(10);
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(strSubstring);
        Intent intent = new Intent(context, (Class<?>) m66.c());
        intent.putExtra("user_item_info", contactInfoItem);
        intent.putExtra("from", 4);
        context.startActivity(intent);
    }
}
