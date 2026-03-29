package defpackage;

import android.app.Activity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.R$string;
import defpackage.ro2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class n40 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ro2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameworkBaseActivity f19432a;

        public a(FrameworkBaseActivity frameworkBaseActivity) {
            this.f19432a = frameworkBaseActivity;
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            FrameworkBaseActivity frameworkBaseActivity = this.f19432a;
            if (frameworkBaseActivity != null) {
                frameworkBaseActivity.hideBaseProgressBar();
            }
            if (contactInfoItem != null) {
                n40.b(contactInfoItem, this.f19432a);
            }
        }

        @Override // ro2.b
        public void onError(String str) {
            FrameworkBaseActivity frameworkBaseActivity = this.f19432a;
            if (frameworkBaseActivity != null) {
                frameworkBaseActivity.hideBaseProgressBar();
                FrameworkBaseActivity frameworkBaseActivity2 = this.f19432a;
                sy5.f(frameworkBaseActivity2, frameworkBaseActivity2.getString(R$string.get_user_info_failed), 0).g();
            }
        }
    }

    public static void a(ContactInfoItem contactInfoItem, String str, FrameworkBaseActivity frameworkBaseActivity) {
        if (contactInfoItem != null) {
            b(contactInfoItem, frameworkBaseActivity);
            return;
        }
        if (frameworkBaseActivity != null) {
            frameworkBaseActivity.showBaseProgressBar("", false);
        }
        bj5.b().a().q(str, new a(frameworkBaseActivity));
    }

    public static void b(ContactInfoItem contactInfoItem, Activity activity) {
        if (contactInfoItem.getIsStranger()) {
            bj5.b().a().r(activity, contactInfoItem, "");
        } else {
            bj5.b().a().B(activity, contactInfoItem, "");
        }
    }
}
