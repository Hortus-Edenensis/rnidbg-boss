package defpackage;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.topic.bean.TopicListBean;
import com.zenmen.square.topic.guide.SquareTopicActivityDialog;
import com.zenmen.square.topic.view.TopicSelectWishView;
import defpackage.xj5;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class wj5 {
    public static volatile wj5 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21725a = "SquareTopicActivityHelper";
    public long b;
    public long c;
    public long d;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopicListBean.ActivityInfo f21728a;

        public b(TopicListBean.ActivityInfo activityInfo) {
            this.f21728a = activityInfo;
            put("topicId", String.valueOf(activityInfo.topicId));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements xj5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21729a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;
        public final /* synthetic */ int e;

        public c(Activity activity, long j, String str, long j2, int i) {
            this.f21729a = activity;
            this.b = j;
            this.c = str;
            this.d = j2;
            this.e = i;
        }

        @Override // xj5.d
        public void a(TopicListBean.ActivityInfo activityInfo) {
            if (this.f21729a.isFinishing()) {
                return;
            }
            List<TopicListBean.Ae> list = activityInfo.aeList;
            if (list == null || list.size() <= 0) {
                wj5.this.h(this.f21729a, this.b, this.c, null, this.e);
            } else {
                wj5.this.k(this.f21729a, this.b, this.c, this.d, activityInfo.aeMainTitle, activityInfo.aeSubTitle, activityInfo.aeList, this.e);
            }
        }

        @Override // xj5.d
        public void b() {
            if (this.f21729a.isFinishing()) {
                return;
            }
            wj5.this.h(this.f21729a, this.b, this.c, null, this.e);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21730a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ MaterialDialog e;

        public d(Activity activity, long j, String str, int i, MaterialDialog materialDialog) {
            this.f21730a = activity;
            this.b = j;
            this.c = str;
            this.d = i;
            this.e = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            wj5.this.h(this.f21730a, this.b, this.c, null, this.d);
            this.e.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements TopicSelectWishView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f21731a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ MaterialDialog f;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TopicListBean.Ae f21732a;

            public a(TopicListBean.Ae ae) {
                this.f21732a = ae;
                put("aeId", String.valueOf(ae.aeId));
            }
        }

        public e(long j, Activity activity, long j2, String str, int i, MaterialDialog materialDialog) {
            this.f21731a = j;
            this.b = activity;
            this.c = j2;
            this.d = str;
            this.e = i;
            this.f = materialDialog;
        }

        @Override // com.zenmen.square.topic.view.TopicSelectWishView.b
        public void a(TopicListBean.Ae ae) {
            wj5.this.b = this.f21731a;
            wj5.this.c = ae.aeId;
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.SQUARE;
            sPUtil.t(scene, k86.a("key_square_wished_activtyid"), Long.valueOf(wj5.this.b));
            sPUtil.t(scene, k86.a("key_square_wished_aeid"), Long.valueOf(wj5.this.c));
            zn6.h("pagediscove_middle_popwindcli", "click", new a(ae));
            wj5.this.h(this.b, this.c, this.d, ae, this.e);
            this.f.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements DialogInterface.OnCancelListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
        }
    }

    public wj5() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.SQUARE;
        this.b = sPUtil.i(scene, k86.a("key_square_wished_activtyid"), 0L);
        this.c = sPUtil.i(scene, k86.a("key_square_wished_aeid"), 0L);
        this.d = sPUtil.i(scene, k86.a("key_square_topic_popup_time"), 0L);
    }

    public static wj5 g() {
        if (e == null) {
            synchronized (wj5.class) {
                if (e == null) {
                    e = new wj5();
                }
            }
        }
        return e;
    }

    public void f() {
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        e = null;
    }

    public void h(Activity activity, long j, String str, TopicListBean.Ae ae, int i) {
        TopicListBean.Topic topic = new TopicListBean.Topic();
        topic.topicId = j;
        topic.topicName = str;
        bj5.b().a().c0(activity, i, null, topic, ae, true);
    }

    public void i(Activity activity, long j, String str, long j2, int i) {
        if (this.b != j2) {
            xj5.h().l(j2, new c(activity, j, str, j2, i));
        } else {
            if (this.c <= 0) {
                h(activity, j, str, null, i);
                return;
            }
            TopicListBean.Ae ae = new TopicListBean.Ae();
            ae.aeId = this.c;
            h(activity, j, str, ae, i);
        }
    }

    public void j(Activity activity) {
        if (cy5.k(this.d)) {
            LogUtil.d("SquareTopicActivityHelper", "mLastShowTime id today");
            return;
        }
        if (activity.isFinishing()) {
            return;
        }
        TopicListBean.ActivityInfo activityInfoG = xj5.h().g();
        if (activityInfoG == null || !activityInfoG.isValid()) {
            LogUtil.d("SquareTopicActivityHelper", "activityInfo invalid !");
            return;
        }
        SquareTopicActivityDialog.D(activity, activityInfoG, new a(activityInfoG, activity));
        this.d = System.currentTimeMillis();
        SPUtil.f14322a.t(SPUtil.SCENE.SQUARE, k86.a("key_square_topic_popup_time"), Long.valueOf(this.d));
        zn6.h("pagediscove_below_popwindshow", "view", new b(activityInfoG));
    }

    public final void k(Activity activity, long j, String str, long j2, String str2, String str3, List<TopicListBean.Ae> list, int i) {
        MaterialDialog materialDialogE = new sd3(activity).b(false).h(false).c(0).q(0.8f).o(R$layout.square_layout_dialog_select_wish, false).e();
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            ((TextView) viewJ.findViewById(R$id.tv_title)).setText(str2);
            ((TextView) viewJ.findViewById(R$id.tv_sub_title)).setText(str3);
            TopicSelectWishView topicSelectWishView = (TopicSelectWishView) viewJ.findViewById(R$id.wish);
            ((ImageView) viewJ.findViewById(R$id.img_close)).setOnClickListener(new d(activity, j, str, i, materialDialogE));
            topicSelectWishView.bind(list, new e(j2, activity, j, str, i, materialDialogE));
        }
        materialDialogE.setOnCancelListener(new f());
        materialDialogE.c(false);
        materialDialogE.show();
        zn6.c("pagediscove_middle_popwind", "view");
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements SquareTopicActivityDialog.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopicListBean.ActivityInfo f21726a;
        public final /* synthetic */ Activity b;

        /* JADX INFO: renamed from: wj5$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1285a extends HashMap<String, String> {
            public C1285a() {
                put("topicId", String.valueOf(a.this.f21726a.topicId));
            }
        }

        public a(TopicListBean.ActivityInfo activityInfo, Activity activity) {
            this.f21726a = activityInfo;
            this.b = activity;
        }

        @Override // com.zenmen.square.topic.guide.SquareTopicActivityDialog.c
        public void a(long j) {
            zn6.h("pagediscove_below_popwind", "click", new C1285a());
            wj5 wj5VarG = wj5.g();
            Activity activity = this.b;
            TopicListBean.ActivityInfo activityInfo = this.f21726a;
            wj5VarG.i(activity, activityInfo.topicId, activityInfo.topicName, activityInfo.activityId, 8);
        }

        @Override // com.zenmen.square.topic.guide.SquareTopicActivityDialog.c
        public void onCancel() {
        }
    }
}
