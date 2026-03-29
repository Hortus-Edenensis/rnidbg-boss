package defpackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleDialogFactory;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class k80 {
    public static final String c = "k80";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GroupInfoItem f18594a;
    public String b;

    public k80(GroupInfoItem groupInfoItem) {
        this.f18594a = groupInfoItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(GroupInfoItem groupInfoItem) {
        this.f18594a = groupInfoItem;
    }

    public final void b(String str) {
        if (str == null) {
            return;
        }
        c70.R().K(str, new dv0() { // from class: j80
            @Override // defpackage.dv0
            public final void onResponse(Object obj) {
                this.f18343a.f((GroupInfoItem) obj);
            }
        });
        this.b = str;
    }

    public final boolean c() {
        LogUtil.d(c, "group-info-item initialized = " + this.f18594a);
        if (this.f18594a != null) {
            return true;
        }
        b(this.b);
        return false;
    }

    public boolean d(Context context, int i, String str) {
        String str2 = c;
        LogUtil.d(str2, "result code = " + i);
        if (!c()) {
            return false;
        }
        LogUtil.d(str2, "get group | room type = " + this.f18594a.getRoomType());
        if (i == 5084 || i == 5083) {
            if (TextUtils.isEmpty(str)) {
                str = "你已经被管理员从该群中踢出，无法在进行修改！";
            }
            return g(context, str);
        }
        if (i != 5308) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = AppContext.getContext().getString(R.string.circle_too_many_group_member_detail);
        }
        return g(context, str);
    }

    public boolean e(Context context, int i, String str, MaterialDialog.e eVar) {
        String str2 = c;
        LogUtil.d(str2, "result code = " + i);
        if (!c()) {
            return false;
        }
        LogUtil.d(str2, "get group | room type = " + this.f18594a.getRoomType());
        if (i != 5084 && i != 5083) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "你已经被管理员从该群中踢出，无法在进行修改！";
        }
        return h(context, str, eVar);
    }

    public boolean g(Context context, String str) {
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return false;
        }
        MaterialDialog materialDialogBuildDialogByContent = CircleDialogFactory.buildDialogByContent(context, str);
        LogUtil.d(c, "circle dialog show");
        materialDialogBuildDialogByContent.show();
        return true;
    }

    public final boolean h(Context context, String str, MaterialDialog.e eVar) {
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return false;
        }
        MaterialDialog materialDialogBuildDialogByContent = CircleDialogFactory.buildDialogByContent(context, str, eVar);
        LogUtil.d(c, "circle dialog show");
        materialDialogBuildDialogByContent.show();
        return true;
    }

    public k80(String str) {
        b(str);
    }
}
