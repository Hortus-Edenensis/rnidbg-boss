package com.zenmen.square.fragment;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.bean.GuideObjBean;
import com.zenmen.square.bean.PopupMsgListBean;
import com.zenmen.square.bean.SquareShareFeedBean;
import com.zenmen.square.comment.emoji.adapter.BaseRecyclerAdapter;
import com.zenmen.square.comment.emoji.adapter.RecyclerViewHolder;
import com.zenmen.square.ui.widget.LocationSelectDialog;
import defpackage.ai5;
import defpackage.b05;
import defpackage.hc2;
import defpackage.l50;
import defpackage.me1;
import defpackage.mj5;
import defpackage.sd3;
import defpackage.xp5;
import defpackage.zk5;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareUserGuideChoseDialog extends LXBottomSheetDialog {
    public LocationSelectDialog h;
    public TextView i;
    public TextView j;
    public TextView k;
    public LinearLayout l;
    public LocationEx m;
    public int n;
    public List<PopupMsgListBean> o;
    public List<PopupMsgListBean> p;
    public BaseRecyclerAdapter q;
    public EditText r;
    public int s;
    public boolean t;
    public int u;
    public GuideObjBean v;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("posttext", SquareUserGuideChoseDialog.this.r.getText().toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements LocationSelectDialog.h {
        public b() {
        }

        @Override // com.zenmen.square.ui.widget.LocationSelectDialog.h
        public void a(LocationSelectDialog.k kVar) {
            SquareUserGuideChoseDialog squareUserGuideChoseDialog;
            TextView textView;
            SquareUserGuideChoseDialog squareUserGuideChoseDialog2 = SquareUserGuideChoseDialog.this;
            LocationEx locationEx = kVar.f16538a;
            squareUserGuideChoseDialog2.m = locationEx;
            if (locationEx != null && !TextUtils.isEmpty(locationEx.getName()) && (textView = (squareUserGuideChoseDialog = SquareUserGuideChoseDialog.this).i) != null) {
                textView.setText(squareUserGuideChoseDialog.m.getName());
            }
            SquareUserGuideChoseDialog.this.F();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareUserGuideChoseDialog.this.n++;
            zn6.c("postguide_popup_choosechange", "click");
            int iCeil = (int) Math.ceil(((double) SquareUserGuideChoseDialog.this.o.size()) / 4.0d);
            SquareUserGuideChoseDialog squareUserGuideChoseDialog = SquareUserGuideChoseDialog.this;
            if (squareUserGuideChoseDialog.n > iCeil - 1) {
                squareUserGuideChoseDialog.n = 0;
            }
            b05.d("换到第几页===》" + SquareUserGuideChoseDialog.this.n);
            ArrayList arrayList = new ArrayList();
            SquareUserGuideChoseDialog squareUserGuideChoseDialog2 = SquareUserGuideChoseDialog.this;
            if (squareUserGuideChoseDialog2.o != null) {
                int i = squareUserGuideChoseDialog2.n * 4;
                while (true) {
                    SquareUserGuideChoseDialog squareUserGuideChoseDialog3 = SquareUserGuideChoseDialog.this;
                    if (i >= (squareUserGuideChoseDialog3.n * 4) + 4 || i >= squareUserGuideChoseDialog3.o.size()) {
                        break;
                    }
                    arrayList.add(SquareUserGuideChoseDialog.this.o.get(i));
                    i++;
                }
                SquareUserGuideChoseDialog.this.q.c(arrayList);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareUserGuideChoseDialog.this.D();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends BaseRecyclerAdapter<PopupMsgListBean> {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f16351a;

            public a(int i) {
                this.f16351a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareUserGuideChoseDialog.this.s = this.f16351a;
                zn6.c("postguide_popup_choose", "click");
                SquareUserGuideChoseDialog.this.F();
            }
        }

        public e(Context context, int i, List list) {
            super(context, i, list);
        }

        @Override // com.zenmen.square.comment.emoji.adapter.BaseRecyclerAdapter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void b(RecyclerViewHolder recyclerViewHolder, int i, PopupMsgListBean popupMsgListBean) {
            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) recyclerViewHolder.m(R$id.img);
            effectiveShapeView.changeShapeType(3);
            effectiveShapeView.setDegreeForRoundRectangle(me1.b(d(), 8), me1.b(d(), 8));
            effectiveShapeView.setBorderWidth(me1.a(d(), 2.5f));
            if (popupMsgListBean.isSelected) {
                effectiveShapeView.setBorderColor(Color.parseColor("#14CD64"));
            } else {
                effectiveShapeView.setBorderColor(0);
            }
            hc2.a(d()).load(popupMsgListBean.pic).into(effectiveShapeView);
            effectiveShapeView.setOnClickListener(new a(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareUserGuideChoseDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            SquareUserGuideChoseDialog.this.E();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return keyEvent != null && keyEvent.getKeyCode() == 66;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnFocusChangeListener {
        public i() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                b05.d("onFocusChange---->true");
                zn6.c("postguide_popup_inputbox", "click");
            }
        }
    }

    public SquareUserGuideChoseDialog(@NonNull Context context, LocationEx locationEx, List<PopupMsgListBean> list, GuideObjBean guideObjBean) {
        super(context);
        this.n = 0;
        this.p = new ArrayList();
        this.s = 0;
        this.t = true;
        this.u = 0;
        this.m = locationEx;
        this.v = guideObjBean;
        list = list == null ? new ArrayList<>() : list;
        this.o = list;
        this.n = 0;
        this.p.clear();
        if (this.o != null) {
            for (int i2 = this.n * 4; i2 < (this.n * 4) + 4 && i2 < this.o.size(); i2++) {
                this.p.add(list.get(i2));
            }
        }
    }

    public void C() {
        new sd3(getContext()).k(String.format("纯文字内容要求不少于%d个字", Integer.valueOf(ai5.k().m().b()))).P("知道了").h(true).e().show();
    }

    public final void D() {
        zn6.c("postguide_popup_location", "click");
        LocationSelectDialog locationSelectDialog = this.h;
        if (locationSelectDialog == null || !locationSelectDialog.isShowing()) {
            LocationSelectDialog locationSelectDialog2 = new LocationSelectDialog(getContext(), false, this.m, new b(), LocationScene.PUBLISH_SQUARE);
            this.h = locationSelectDialog2;
            locationSelectDialog2.show();
            zn6.c("postguide_popup_location_list", "view");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
    
        if (defpackage.zk5.g(r3, r3.getHint(), r6.u, null, false) < defpackage.ai5.k().m().b()) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008d, code lost:
    
        if (defpackage.zk5.g(r3, r3.getText(), r6.u, null, false) < defpackage.ai5.k().m().b()) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E() {
        String string;
        EditText editText = this.r;
        if (editText == null || editText.getText() == null) {
            return;
        }
        zn6.j("postguide_popup_post", "click", new a());
        if (!TextUtils.isEmpty(this.r.getText().toString())) {
            string = this.r.getText().toString();
            if (this.r.getText() != null) {
                EditText editText2 = this.r;
            }
            C();
            return;
        }
        if (this.r.getHint() != null) {
            string = this.r.getHint().toString();
            if (this.r.getText() != null) {
                EditText editText3 = this.r;
            }
            C();
            return;
        }
        string = "";
        SquareShareFeedBean squareShareFeedBean = new SquareShareFeedBean();
        squareShareFeedBean.content = string;
        squareShareFeedBean.location = this.m;
        squareShareFeedBean.feedType = 1;
        squareShareFeedBean.isSqureUserGuideChose = true;
        mj5.r().B(squareShareFeedBean);
        dismiss();
    }

    public final void F() {
        int i2 = (this.n * 4) + this.s;
        String str = this.o.get(i2).content;
        LocationEx locationEx = this.m;
        if (locationEx != null && !TextUtils.isEmpty(locationEx.getName()) && this.r != null && !TextUtils.isEmpty(str)) {
            this.r.setHint(String.format(str, this.m.getName().replace("·", "")));
        }
        int i3 = 0;
        while (i3 < this.o.size()) {
            this.o.get(i3).isSelected = i3 == i2;
            i3++;
        }
        this.q.notifyDataSetChanged();
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R$layout.dialog_square_user_guide_chose, (ViewGroup) null);
        this.k = (TextView) viewGroup.findViewById(R$id.title);
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R$id.recyclerView);
        this.i = (TextView) viewGroup.findViewById(R$id.location);
        this.l = (LinearLayout) viewGroup.findViewById(R$id.location_rl);
        this.r = (EditText) viewGroup.findViewById(R$id.content);
        this.j = (TextView) viewGroup.findViewById(R$id.publish_btn);
        GuideObjBean guideObjBean = this.v;
        if (guideObjBean != null && !TextUtils.isEmpty(guideObjBean.popupTitle)) {
            this.k.setText(this.v.popupTitle);
        }
        this.u = ai5.k().m().a();
        b05.d("maxLength=" + this.u);
        viewGroup.findViewById(R$id.change_next).setOnClickListener(new c());
        this.l.setOnClickListener(new d());
        LocationEx locationEx = this.m;
        if (locationEx != null && !TextUtils.isEmpty(locationEx.getName())) {
            this.i.setText(this.m.getName());
        }
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        e eVar = new e(getContext(), R$layout.dialog_square_user_guide_chose_item, this.p);
        this.q = eVar;
        recyclerView.setAdapter(eVar);
        if (this.p.size() >= 1) {
            F();
        }
        viewGroup.findViewById(R$id.close).setOnClickListener(new f());
        this.j.setOnClickListener(new g());
        this.r.setOnEditorActionListener(new h());
        xp5.a(this.r);
        this.r.setOnFocusChangeListener(new i());
        this.r.addTextChangedListener(new j());
        return viewGroup;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements TextWatcher {
        public j() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SquareUserGuideChoseDialog squareUserGuideChoseDialog = SquareUserGuideChoseDialog.this;
            zk5.g(squareUserGuideChoseDialog.r, charSequence, squareUserGuideChoseDialog.u, null, false);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
