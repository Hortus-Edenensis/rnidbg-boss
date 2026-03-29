package com.zenmen.palmchat.pullwake.pulldialog;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.igexin.push.f.h;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.CustomDialogActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.pullwake.pulldialog.DialogData;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.bo0;
import defpackage.cg4;
import defpackage.go2;
import defpackage.ir5;
import defpackage.nl0;
import defpackage.sw4;
import defpackage.vs0;
import defpackage.zn6;
import defpackage.zw4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {
    public static a c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f15061a;
    public DialogConfig b;

    /* JADX INFO: renamed from: com.zenmen.palmchat.pullwake.pulldialog.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1098a extends go2<LXBaseNetBean<DialogData>> {
        public C1098a() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            ContactInfoItem contactInfoItemS = bo0.r().s();
            map.put("sex", Integer.valueOf(contactInfoItemS != null ? contactInfoItemS.getGender() : -1));
            sw4 sw4VarB = sw4.b(1, nl0.z + "/userem.keepalive.show.v1", map);
            sw4VarB.g = true;
            return sw4VarB;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<DialogData> lXBaseNetBean, Exception exc) {
            int i;
            DialogData dialogData;
            LogUtil.i("PullDialogManager", "updateImp request end" + az2.c(lXBaseNetBean));
            if (!z || lXBaseNetBean == null || (dialogData = lXBaseNetBean.data) == null) {
                i = 3;
            } else {
                i = (dialogData.list == null || dialogData.list.size() <= 0) ? 2 : 1;
                b.d(lXBaseNetBean.data.list, true);
                b.e();
            }
            HashMap map = new HashMap();
            map.put("resultcode", String.valueOf(i));
            zn6.i("keepalive_pop_result", map);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: com.zenmen.palmchat.pullwake.pulldialog.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1099a extends TypeToken<ArrayList<DialogData.DialogItemData>> {
        }

        public static boolean a() {
            return ((float) Math.abs(SPUtil.f14322a.i(SPUtil.SCENE.APP_WAKE_UP, "key_pull_pop_show_time", 0L) - ir5.b())) > a.b().a().poprate * 8.64E7f;
        }

        public static List<DialogData.DialogItemData> b() {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_WAKE_UP;
            long jI = sPUtil.i(scene, "key_pull_pop_cache_time", 0L);
            String strN = sPUtil.n(scene, "key_pull_pop_cache_data", "");
            if (TextUtils.isEmpty(strN) || Math.abs(jI - ir5.b()) >= a.b().a().savetime * 8.64E7f) {
                return null;
            }
            return (List) az2.b(strN, new C1099a().getType());
        }

        public static boolean c() {
            return cg4.b(SPUtil.f14322a.i(SPUtil.SCENE.APP_WAKE_UP, "key_pull_pop_request_success_time", 0L), ir5.b());
        }

        public static void d(List<DialogData.DialogItemData> list, boolean z) {
            if (list == null || list.size() <= 0) {
                SPUtil.f14322a.t(SPUtil.SCENE.APP_WAKE_UP, "key_pull_pop_cache_data", "");
            } else {
                SPUtil.f14322a.t(SPUtil.SCENE.APP_WAKE_UP, "key_pull_pop_cache_data", az2.c(list));
            }
            if (z) {
                SPUtil.f14322a.t(SPUtil.SCENE.APP_WAKE_UP, "key_pull_pop_cache_time", Long.valueOf(ir5.b()));
            }
        }

        public static void e() {
            SPUtil.f14322a.t(SPUtil.SCENE.APP_WAKE_UP, "key_pull_pop_request_success_time", Long.valueOf(ir5.b()));
        }

        public static void f() {
            SPUtil.f14322a.t(SPUtil.SCENE.APP_WAKE_UP, "key_pull_pop_show_time", Long.valueOf(ir5.b()));
        }
    }

    public a() {
        ArrayList arrayList = new ArrayList();
        this.f15061a = arrayList;
        this.b = null;
        arrayList.add("com.zenmen.palmchat.daemon.WakeActivity");
        this.f15061a.add("com.zenmen.palmchat.daemon.IjkActivity");
        this.f15061a.add("com.zenmen.palmchat.daemon.OneActivity");
        this.f15061a.add("com.zenmen.palmchat.daemon.TbActivity");
        this.f15061a.add("com.zenmen.palmchat.daemon.XcvActivity");
        this.f15061a.add("com.zenmen.palmchat.daemon.YuvActivity");
        this.f15061a.add("com.wft.caller.trans.EmptyActivity");
        this.f15061a.add("com.wft.caller.trans.EnhActivity");
        this.f15061a.add("com.wft.caller.trans.TransActivity");
        this.f15061a.add(h.f7349a);
        this.f15061a.add("com.zenmen.palmchat.thirdapp.getui.WkInvokeActivity");
        this.f15061a.add("com.zenmen.palmchat.jiguang.LxJDActivity");
        this.f15061a.add("com.zenmen.palmchat.jiguang.LxJDActivity1");
        this.f15061a.add("com.zenmen.palmchat.jiguang.LxJDActivity2");
        this.f15061a.add("com.zenmen.palmchat.jiguang.LxJDActivity3");
        this.f15061a.add("com.zenmen.palmchat.jiguang.LxJDActivity4");
        this.f15061a.add("com.zenmen.palmchat.jiguang.LxJDActivity5");
        this.f15061a.add("com.zenmen.palmchat.jiguang.LxJDActivity6");
        this.f15061a.add("com.zenmen.palmchat.jiguang.LxJDActivity7");
        this.f15061a.add("com.zenmen.palmchat.jiguang.LxJDActivity8");
        this.f15061a.add("com.zenmen.palmchat.jiguang.LxJDActivity9");
        this.f15061a.add("com.mob.guard.MobTranPullUpActivity");
    }

    public static a b() {
        return c;
    }

    public DialogConfig a() {
        if (this.b == null) {
            JSONObject config = vs0.a().getConfig("keepalive_pop");
            if (config != null) {
                this.b = (DialogConfig) az2.a(config.toString(), DialogConfig.class);
            } else {
                this.b = new DialogConfig();
            }
        }
        return this.b;
    }

    public final boolean c(Activity activity) {
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= this.f15061a.size()) {
                break;
            }
            if (activity.getClass().getName().equals(this.f15061a.get(i))) {
                z = true;
                break;
            }
            i++;
        }
        LogUtil.i("PullDialogManager", "isPullUpActivity" + activity.getClass().getName() + " " + z);
        return z;
    }

    public void d(Activity activity) {
        if (c(activity)) {
            HashMap map = new HashMap();
            map.put("name", activity.getClass().getName());
            zn6.i("keepalive_pixel", map);
            int i = 1;
            if (activity.getIntent() != null && "lx-test".equals(activity.getIntent().getStringExtra("from"))) {
                DialogData.DialogItemData dialogItemData = new DialogData.DialogItemData();
                dialogItemData.nickName = "test";
                dialogItemData.title = "title";
                dialogItemData.turnUrl = "zenxin://activity?page=a0211&uid=5965665519010816&sourceType=46&canChat=1&domain=private.youni";
                f(dialogItemData);
                return;
            }
            if (a().enable && b.a()) {
                List<DialogData.DialogItemData> listB = b.b();
                if (listB == null || listB.size() <= 0) {
                    e(true);
                    i = 2;
                } else {
                    DialogData.DialogItemData dialogItemDataRemove = listB.remove(0);
                    b.d(listB, false);
                    b.f();
                    f(dialogItemDataRemove);
                }
            } else {
                i = 3;
            }
            HashMap map2 = new HashMap();
            map2.put("resultcode", String.valueOf(i));
            zn6.i("keepalive_pop_ready", map2);
        }
    }

    public void e(boolean z) {
        List<DialogData.DialogItemData> listB;
        if (a().enable) {
            boolean z2 = true;
            if (!z && (listB = b.b()) != null && listB.size() > 0) {
                z2 = false;
            }
            if (((z2 && b.c()) ? false : z2) && AccountUtils.t(AppContext.getContext())) {
                zn6.b("keepalive_pop_request");
                zw4.e(new C1098a());
            }
        }
    }

    public final void f(DialogData.DialogItemData dialogItemData) {
        LogUtil.i("PullDialogManager", "showPop" + az2.c(dialogItemData));
        Intent intent = new Intent();
        intent.setClass(AppContext.getContext(), CustomDialogActivity.class);
        intent.putExtra("EXTRA_DATA", dialogItemData);
        intent.addFlags(335544320);
        AppContext.getContext().startActivity(intent);
    }
}
