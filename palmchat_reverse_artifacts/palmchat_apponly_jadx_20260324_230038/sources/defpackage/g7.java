package defpackage;

import android.content.Context;
import android.content.Intent;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import defpackage.bo2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class g7 extends bo2 {
    public Context c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17673a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            this.f17673a = context;
            this.b = str;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            n71.e(this.f17673a, this.b, false);
            g7.this.f1790a.onFinish(false);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            try {
                ContactInfoItem contactInfoItemP = l92.p(jSONObject);
                if (contactInfoItemP != null) {
                    g7 g7Var = g7.this;
                    g7Var.e(g7Var.c, contactInfoItemP);
                } else {
                    n71.e(this.f17673a, this.b, false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            g7.this.f1790a.onFinish(true);
        }
    }

    public g7(FrameworkBaseActivity frameworkBaseActivity, bo2.a aVar) {
        super(frameworkBaseActivity, aVar);
        this.c = frameworkBaseActivity;
    }

    @Override // defpackage.bo2
    public void a(String str) {
        d(this.c, str);
    }

    public final void d(Context context, String str) {
        com.zenmen.palmchat.QRCodeScan.a.b(context, str, new a(context, str));
    }

    public final void e(Context context, ContactInfoItem contactInfoItem) {
        Intent intent = new Intent(context, (Class<?>) m66.c());
        intent.putExtra("user_item_info", contactInfoItem);
        intent.putExtra("from", 4);
        context.startActivity(intent);
    }
}
