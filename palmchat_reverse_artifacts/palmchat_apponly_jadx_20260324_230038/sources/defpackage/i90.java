package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.greet.CircleGreetView;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class i90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CircleGreetView f18125a;
    public h90 b = new h90();
    public Context c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (i90.this.f18125a != null) {
                i90.this.f18125a.onLoadingStatusReset();
            }
            if (baseResponse != null && baseResponse.getResultCode() == 0) {
                if (i90.this.f18125a != null) {
                    i90.this.f18125a.onGreetSuccess();
                    i90.this.f18125a.setGreetBtnClicked(true);
                    return;
                }
                return;
            }
            if (i90.this.f18125a != null) {
                i90.this.f18125a.showErrorToast((baseResponse == null || TextUtils.isEmpty(baseResponse.getErrorMsg())) ? i90.this.c.getString(R.string.send_failed) : baseResponse.getErrorMsg());
                if (baseResponse == null || baseResponse.getResultCode() != 5306) {
                    return;
                }
                i90.this.f18125a.setGreetBtnClicked(true);
            }
        }
    }

    public i90(Context context) {
        this.c = context;
    }

    public void c(CircleGreetView circleGreetView) {
        this.f18125a = circleGreetView;
    }

    public ContactInfoItem d(HashMap<String, ContactInfoItem> map, GroupInfoItem groupInfoItem, String str) {
        ContactInfoItem contactInfoItem = map != null ? map.get(str) : null;
        ContactInfoItem contactInfoItemL = bo0.r().l(str);
        if (contactInfoItem != null) {
            if (contactInfoItemL == null || contactInfoItemL.getIconURL() == null) {
                return contactInfoItem;
            }
            contactInfoItem.setIconURL(contactInfoItemL.getIconURL());
            return contactInfoItem;
        }
        if (contactInfoItemL != null) {
            return contactInfoItemL;
        }
        ContactInfoItem contactInfoItem2 = new ContactInfoItem();
        contactInfoItem2.setUid(str);
        return contactInfoItem2;
    }

    public void e(String str, String str2, String str3, String str4) {
        this.b.a(str, str2, str3, str4, new a());
    }
}
