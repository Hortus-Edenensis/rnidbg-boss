package com.zenmen.square.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.R$color;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.square.adapter.SquareTagSummaryAdapter;
import com.zenmen.square.tag.bean.CommonResponse;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.tag.bean.SquareTagListBean;
import defpackage.ai5;
import defpackage.bj5;
import defpackage.ds0;
import defpackage.fi5;
import defpackage.kj5;
import defpackage.l50;
import defpackage.oj5;
import defpackage.qm5;
import defpackage.ro2;
import defpackage.sd3;
import defpackage.tj5;
import defpackage.tw4;
import defpackage.uo2;
import defpackage.vi5;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareTagSummaryHelper extends FrameLayout {
    public static final int DEFAULT_LIMIT = 6;
    public static final int LIMIT_INFINITE = -1;
    private ContactInfoItem contactInfoItem;
    private boolean isSelf;
    private i mCallback;
    private Scene scene;
    private int showLimit;
    private uo2 squareDao;
    private SquareTagSummaryAdapter tagAdapter;
    private List<SquareTagBean> tagBeans;
    private TextView tagEmptyTitleView;
    private View tagEmptyView;
    private TextView tagErrorView;
    private View tagProgress;
    private RecyclerView tagRecycler;

    /* JADX INFO: compiled from: SearchBox */
    public enum Scene {
        USER_DETAIL("user_detail"),
        SETTING("setting");

        private String name;

        Scene(String str) {
            this.name = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements SquareTagSummaryAdapter.b {
        public a(i iVar) {
        }

        @Override // com.zenmen.square.adapter.SquareTagSummaryAdapter.b
        public void a(SquareTagSummaryAdapter.a aVar, View view) {
            if (l50.a() || aVar == null || aVar.a() == null) {
                return;
            }
            if (SquareTagSummaryHelper.this.scene == Scene.USER_DETAIL) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tagid", aVar.a().getId());
                    jSONObject.put("feedsnum", aVar.a().getPublishCnt());
                    if (!TextUtils.isEmpty(SquareTagSummaryHelper.this.contactInfoItem.getUid())) {
                        jSONObject.put("targetUid", SquareTagSummaryHelper.this.contactInfoItem.getUid());
                    }
                    if (!TextUtils.isEmpty(SquareTagSummaryHelper.this.contactInfoItem.getExid())) {
                        jSONObject.put("targetExid", SquareTagSummaryHelper.this.contactInfoItem.getExid());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                zn6.f("pageprofil_posttag_click", "click", jSONObject);
            } else if (SquareTagSummaryHelper.this.scene == Scene.SETTING) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("tagid", aVar.a().getId());
                    jSONObject2.put("tagstatus", aVar.a().getPublishCnt() > 0 ? 1 : 2);
                    jSONObject2.put("tag_rank", aVar.a().getRank());
                    jSONObject2.put("tag_num", aVar.a().getPublishCnt());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                zn6.f("pagemy_tag", "click", jSONObject2);
            }
            if (aVar.a().getPublishCnt() >= 1) {
                aVar.a();
                throw null;
            }
            if (SquareTagSummaryHelper.this.isSelf) {
                SquareTagSummaryHelper.this.showPublishDialog(aVar.a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareTagSummaryHelper.this.load();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareTagBean f16577a;

        public d(SquareTagBean squareTagBean) {
            this.f16577a = squareTagBean;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            SquareTagSummaryHelper.this.gotoPublish(this.f16577a);
            zn6.c("pagemy_tag_release", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends tw4<CommonResponse<SquareTagListBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f16578a;

        public e(boolean z) {
            this.f16578a = z;
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<SquareTagListBean> commonResponse) {
            List<SquareTagBean> tagList;
            if (!this.f16578a) {
                SquareTagSummaryHelper.this.tagProgress.setVisibility(8);
            }
            if (commonResponse == null || commonResponse.getData() == null || commonResponse.getData().getTagList() == null || commonResponse.getData().getTagList().isEmpty()) {
                tagList = null;
            } else {
                ai5.k().e(commonResponse.getData().getTagList());
                tagList = commonResponse.getData().getTagList();
            }
            if (tagList != null && !tagList.isEmpty()) {
                SquareTagSummaryHelper.this.tagBeans = tagList;
                SquareTagSummaryHelper.this.updateRecycler();
                if (!this.f16578a) {
                    SquareTagSummaryHelper.this.tagRecycler.setVisibility(0);
                }
            } else if (!this.f16578a) {
                SquareTagSummaryHelper.this.tagEmptyView.setVisibility(0);
            }
            if (this.f16578a) {
                return;
            }
            SquareTagSummaryHelper.access$1000(SquareTagSummaryHelper.this);
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            if (this.f16578a) {
                return;
            }
            SquareTagSummaryHelper.this.tagProgress.setVisibility(8);
            SquareTagSummaryHelper.this.tagErrorView.setVisibility(0);
            SquareTagSummaryHelper.access$1000(SquareTagSummaryHelper.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareTagSummaryHelper.this.load();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareTagSummaryHelper.this.load(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareTagSummaryHelper.this.load(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface i {
        Scene getScene();
    }

    public SquareTagSummaryHelper(Context context) {
        super(context);
        this.isSelf = false;
        this.tagBeans = new ArrayList();
        this.showLimit = -1;
        init(null, 0);
    }

    public static /* synthetic */ i access$1000(SquareTagSummaryHelper squareTagSummaryHelper) {
        squareTagSummaryHelper.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoPublish(SquareTagBean squareTagBean) {
        if (getContext() instanceof Activity) {
            Scene scene = this.scene;
            bj5.b().a().c0((Activity) getContext(), scene == Scene.USER_DETAIL ? 5 : scene == Scene.SETTING ? 6 : 0, squareTagBean, null, null, true);
        }
    }

    private void init(AttributeSet attributeSet, int i2) {
        ds0.a().c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void load(boolean z) {
    }

    private void loadOnUiThread() {
        post(new f());
        postDelayed(new g(), 3000L);
    }

    private tw4<CommonResponse<SquareTagListBean>> obtainCallback(boolean z) {
        return new e(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPublishDialog(SquareTagBean squareTagBean) {
        new sd3(getContext()).k("增加生活方式需要发布动态哦～").n(GravityEnum.CENTER).P("立即发布").f(new d(squareTagBean)).h(true).e().show();
        zn6.c("pagemy_tag_pop", "view");
    }

    private void updateEmptyView() {
        SpannableStringBuilder spannableStringBuilder;
        if (this.isSelf) {
            spannableStringBuilder = new SpannableStringBuilder("完善资料即可增加生活方式哦～ 立即完善 >>");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R$color.Ga)), 15, spannableStringBuilder.length(), 18);
            this.tagEmptyTitleView.setClickable(true);
        } else {
            spannableStringBuilder = new SpannableStringBuilder("Ta还没有标记生活方式哦～");
            this.tagEmptyTitleView.setClickable(false);
        }
        this.tagEmptyTitleView.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRecycler() {
        if (this.tagAdapter == null) {
            return;
        }
        List<SquareTagBean> listSubList = this.tagBeans;
        int i2 = this.showLimit;
        if (i2 != -1) {
            listSubList = listSubList.subList(0, Math.min(i2, listSubList.size()));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<SquareTagBean> it = listSubList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.tagAdapter.b(it.next(), this.scene));
        }
        this.tagAdapter.g(arrayList);
    }

    public void bind(i iVar) {
        this.scene = iVar.getScene();
        LayoutInflater.from(getContext()).inflate(R$layout.square_layout_tag_summary, this);
        this.tagErrorView = (TextView) findViewById(R$id.tag_error);
        this.tagEmptyView = findViewById(R$id.tag_empty);
        this.tagEmptyTitleView = (TextView) findViewById(R$id.tag_empty_title);
        this.tagProgress = findViewById(R$id.tag_loading);
        this.tagRecycler = (RecyclerView) findViewById(R$id.tag_recycler);
        this.tagRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
        SquareTagSummaryAdapter squareTagSummaryAdapter = new SquareTagSummaryAdapter(getContext(), null);
        this.tagAdapter = squareTagSummaryAdapter;
        this.tagRecycler.setAdapter(squareTagSummaryAdapter);
        this.tagAdapter.f(new a(iVar));
        this.tagEmptyTitleView.setOnClickListener(new b());
        updateEmptyView();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("加载失败，点击刷新");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R$color.Ga)), 5, 9, 18);
        this.tagErrorView.setText(spannableStringBuilder);
        this.tagErrorView.setOnClickListener(new c());
        this.tagProgress.setVisibility(8);
        this.tagRecycler.setVisibility(8);
        this.tagEmptyView.setVisibility(8);
        this.tagErrorView.setVisibility(8);
    }

    public int getCount() {
        return this.tagBeans.size();
    }

    public List<SquareTagBean> getTagBeans() {
        return this.tagBeans;
    }

    public void onDestroy() {
        ds0.a().d(this);
    }

    @qm5
    public void onSquareDeleteEvent(fi5 fi5Var) {
        loadOnUiThread();
    }

    @qm5
    public void onSquarePublishEvent(kj5 kj5Var) {
        loadOnUiThread();
    }

    @qm5
    public void onSquarePushEvent(oj5 oj5Var) {
        post(new h());
    }

    @qm5
    public void onSquareTagSaveEvent(tj5 tj5Var) {
        loadOnUiThread();
    }

    public void setContactInfoItem(ContactInfoItem contactInfoItem, boolean z) {
        this.contactInfoItem = contactInfoItem;
        this.isSelf = z;
        updateEmptyView();
    }

    public void setShowLimit(int i2) {
        if (i2 == -1 || i2 >= 0) {
            this.showLimit = i2;
            updateRecycler();
        }
    }

    public void setTagVisible(List<Integer> list) {
        if (list == null) {
            return;
        }
        for (SquareTagBean squareTagBean : this.tagBeans) {
            if (list.contains(Integer.valueOf(squareTagBean.getId()))) {
                squareTagBean.setTagShow(1);
            } else {
                squareTagBean.setTagShow(2);
            }
        }
        updateRecycler();
    }

    public void load() {
        load(false);
    }

    public SquareTagSummaryHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSelf = false;
        this.tagBeans = new ArrayList();
        this.showLimit = -1;
        init(attributeSet, 0);
    }

    public SquareTagSummaryHelper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.isSelf = false;
        this.tagBeans = new ArrayList();
        this.showLimit = -1;
        init(attributeSet, i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            vi5.b().l(SquareTagSummaryHelper.this.getContext(), true, new a());
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements ro2.a {
            public a() {
            }

            @Override // ro2.a
            public void onSuccess() {
                SquareTagSummaryHelper.this.load();
            }

            @Override // ro2.a
            public void onCancel() {
            }
        }
    }
}
