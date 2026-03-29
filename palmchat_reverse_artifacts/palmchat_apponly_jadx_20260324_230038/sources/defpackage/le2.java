package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.zenmen.palmchat.circle.ui.CircleDetailActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import defpackage.bo2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class le2 extends bo2 {
    public le2(FrameworkBaseActivity frameworkBaseActivity, bo2.a aVar) {
        super(frameworkBaseActivity, aVar);
    }

    public static boolean b(String str) {
        Uri uri = Uri.parse(str);
        if (uri == null) {
            return false;
        }
        try {
            String queryParameter = uri.getQueryParameter("type");
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return "roomShare".equals(queryParameter);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // defpackage.bo2
    public void a(String str) {
        Uri uri = Uri.parse(str);
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("roomId");
            if (!TextUtils.isEmpty(queryParameter)) {
                Intent intent = new Intent(this.b, (Class<?>) CircleDetailActivity.class);
                intent.putExtra(j70.f18338a, queryParameter);
                intent.putExtra("key_apply_group_source", 8);
                this.b.startActivity(intent);
                bo2.a aVar = this.f1790a;
                if (aVar != null) {
                    aVar.onFinish(true);
                    return;
                }
                return;
            }
        }
        bo2.a aVar2 = this.f1790a;
        if (aVar2 != null) {
            aVar2.onFinish(false);
        }
    }
}
