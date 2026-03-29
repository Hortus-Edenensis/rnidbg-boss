package com.zenmen.square.tag.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.tag.adapter.SquareTagAdapter;
import com.zenmen.square.tag.bean.CommonResponse;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.tag.bean.SquareTagListBean;
import defpackage.ai5;
import defpackage.bj5;
import defpackage.tw4;
import defpackage.uo2;
import defpackage.v4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareTagSelecDialogtHelper extends FrameLayout {
    private f mCallback;
    private Scene scene;
    private int selectMax;
    private SquareTagBean selectedTag;
    private uo2 squareDao;
    private SquareTagAdapter tagAdapter;
    private TextView tagErrorView;
    private View tagProgress;
    private RecyclerView tagRecycler;

    /* JADX INFO: compiled from: SearchBox */
    public enum Scene {
        PUBLISH("publish"),
        PUBLISH_TOTAL("publish_total"),
        REGISTER("register"),
        SETTING("setting");

        private String name;

        Scene(String str) {
            this.name = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements SquareTagAdapter.b {
        public a() {
        }

        @Override // com.zenmen.square.tag.adapter.SquareTagAdapter.b
        public void a(SquareTagAdapter.a aVar, View view) {
            if (aVar == null || aVar.c() != 101 || !SquareTagSelecDialogtHelper.this.tagAdapter.j(aVar.b().getId()) || SquareTagSelecDialogtHelper.this.mCallback == null) {
                return;
            }
            SquareTagSelecDialogtHelper.this.mCallback.b(aVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareTagSelecDialogtHelper.this.load();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends tw4<CommonResponse<SquareTagListBean>> {
        public c() {
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<SquareTagListBean> commonResponse) {
            List<SquareTagBean> tagList;
            SquareTagSelecDialogtHelper.this.tagProgress.setVisibility(8);
            if (commonResponse == null || commonResponse.getData() == null) {
                tagList = null;
            } else {
                SquareTagSelecDialogtHelper.this.selectMax = commonResponse.getData().getShowTagLimit();
                SquareTagSelecDialogtHelper.this.tagAdapter.l(SquareTagSelecDialogtHelper.this.selectMax);
                tagList = commonResponse.getData().getTagList();
                ai5.k().e(tagList);
            }
            if (tagList == null || tagList.isEmpty()) {
                SquareTagSelecDialogtHelper.this.tagErrorView.setVisibility(0);
            } else {
                SquareTagSelecDialogtHelper.this.updateTags(tagList);
            }
            if (SquareTagSelecDialogtHelper.this.mCallback != null) {
                SquareTagSelecDialogtHelper.this.mCallback.a();
            }
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            SquareTagSelecDialogtHelper.this.tagProgress.setVisibility(8);
            SquareTagSelecDialogtHelper.this.tagErrorView.setVisibility(0);
            if (SquareTagSelecDialogtHelper.this.mCallback != null) {
                SquareTagSelecDialogtHelper.this.mCallback.a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends tw4<CommonResponse<List<Integer>>> {
        public d() {
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<List<Integer>> commonResponse) {
            SquareTagSelecDialogtHelper.this.tagProgress.setVisibility(8);
            List<SquareTagBean> listO = (commonResponse == null || commonResponse.getData() == null || commonResponse.getData().isEmpty()) ? null : ai5.k().o(commonResponse.getData());
            if (listO == null || listO.isEmpty()) {
                listO = ai5.k().j().getTags();
            }
            SquareTagSelecDialogtHelper.this.updateTags(listO);
            if (SquareTagSelecDialogtHelper.this.mCallback != null) {
                SquareTagSelecDialogtHelper.this.mCallback.a();
            }
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            SquareTagSelecDialogtHelper.this.tagProgress.setVisibility(8);
            SquareTagSelecDialogtHelper.this.updateTags(ai5.k().j().getTags());
            if (SquareTagSelecDialogtHelper.this.mCallback != null) {
                SquareTagSelecDialogtHelper.this.mCallback.a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16490a;

        static {
            int[] iArr = new int[Scene.values().length];
            f16490a = iArr;
            try {
                iArr[Scene.PUBLISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16490a[Scene.PUBLISH_TOTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16490a[Scene.REGISTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16490a[Scene.SETTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a();

        void b(SquareTagAdapter.a aVar);

        void c();

        Scene getScene();
    }

    public SquareTagSelecDialogtHelper(Context context) {
        super(context);
        this.selectMax = 0;
        init(null, 0);
    }

    private tw4<CommonResponse<List<Integer>>> obtainCallback() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTags(List<SquareTagBean> list) {
        ArrayList arrayList = new ArrayList();
        if (this.scene == Scene.PUBLISH) {
            Iterator<SquareTagBean> it = list.subList(0, Math.min(3, list.size())).iterator();
            while (it.hasNext()) {
                arrayList.add(this.tagAdapter.f(it.next()));
            }
            arrayList.add(this.tagAdapter.g());
        } else {
            for (SquareTagBean squareTagBean : list) {
                SquareTagAdapter.a aVarD = this.tagAdapter.d(squareTagBean);
                if (this.scene == Scene.SETTING) {
                    aVarD.f(squareTagBean.getTagShow() == 1);
                }
                arrayList.add(aVarD);
            }
        }
        if (this.selectedTag == null) {
            if (!arrayList.isEmpty()) {
                ((SquareTagAdapter.a) arrayList.get(0)).f(true);
            }
        } else if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                SquareTagAdapter.a aVar = (SquareTagAdapter.a) it2.next();
                if (aVar.b() == this.selectedTag) {
                    aVar.f(true);
                    break;
                }
            }
        }
        this.tagAdapter.m(arrayList);
        this.tagRecycler.setVisibility(0);
    }

    public void bind(f fVar) {
        this.scene = fVar.getScene();
        this.mCallback = fVar;
        LayoutInflater.from(getContext()).inflate(R$layout.square_layout_tag_dialog_select, this);
        this.tagErrorView = (TextView) findViewById(R$id.tag_error);
        this.tagProgress = findViewById(R$id.tag_loading);
        this.tagRecycler = (RecyclerView) findViewById(R$id.tag_recycler);
        this.tagRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        SquareTagAdapter squareTagAdapter = new SquareTagAdapter(getContext(), null);
        this.tagAdapter = squareTagAdapter;
        squareTagAdapter.l(this.scene == Scene.REGISTER ? 0 : 1);
        this.tagRecycler.setAdapter(this.tagAdapter);
        this.tagAdapter.k(new a());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("加载失败，点击刷新");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#04b4a2")), 5, 9, 18);
        this.tagErrorView.setText(spannableStringBuilder);
        this.tagErrorView.setOnClickListener(new b());
        this.tagProgress.setVisibility(8);
        this.tagRecycler.setVisibility(8);
        this.tagErrorView.setVisibility(8);
    }

    public int getSelectMax() {
        return this.selectMax;
    }

    public ArrayList<SquareTagBean> getSelectedBeans() {
        return this.tagAdapter.c();
    }

    public void load() {
        f fVar = this.mCallback;
        if (fVar != null) {
            fVar.c();
        }
        this.tagProgress.setVisibility(0);
        this.tagRecycler.setVisibility(8);
        this.tagErrorView.setVisibility(8);
        if (this.squareDao == null) {
            this.squareDao = bj5.b().c();
        }
        int i = e.f16490a[this.scene.ordinal()];
        if (i == 1) {
            this.squareDao.m(obtainCallback());
            return;
        }
        if (i == 2) {
            this.squareDao.i(obtainCallback());
        } else if (i == 3) {
            this.squareDao.d(obtainCallback());
        } else {
            if (i != 4) {
                return;
            }
            this.squareDao.k(v4.e(com.zenmen.palmchat.c.b()), null, 3, new c());
        }
    }

    public boolean select(SquareTagBean squareTagBean) {
        if (this.scene == Scene.PUBLISH) {
            if (this.tagAdapter.j(squareTagBean.getId())) {
                return true;
            }
            List<SquareTagAdapter.a> listA = this.tagAdapter.a();
            if (listA.size() >= 2) {
                SquareTagAdapter.a aVar = listA.get(listA.size() - 2);
                aVar.e(squareTagBean);
                aVar.f(false);
                if (this.tagAdapter.j(squareTagBean.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setSelectMax(int i) {
        this.selectMax = i;
        this.tagAdapter.l(i);
    }

    public void setSelectTag(SquareTagBean squareTagBean) {
        this.selectedTag = squareTagBean;
    }

    public SquareTagSelecDialogtHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.selectMax = 0;
        init(attributeSet, 0);
    }

    public SquareTagSelecDialogtHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.selectMax = 0;
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
    }
}
