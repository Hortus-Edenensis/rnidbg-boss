package com.zenmen.palmchat.paidservices.superexpose.msgtab.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.model.SuperExposeMsgTabInfo;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.model.SuperExposeMsgTagCItemModel;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.LightingAnimationView;
import defpackage.a46;
import defpackage.ac1;
import defpackage.b05;
import defpackage.bj5;
import defpackage.bo5;
import defpackage.bq6;
import defpackage.fk2;
import defpackage.gk4;
import defpackage.gr2;
import defpackage.hs3;
import defpackage.is3;
import defpackage.l50;
import defpackage.me1;
import defpackage.n5;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MsgTabUiViewC extends MsgTabBaseUiView {
    HashSet<String> displayedPositions;
    private int lastVisiblePosition;
    private ArrayList<SuperExposeMsgTagCItemModel> mAllItemModels;
    private View mIconBg;
    private View mIconLayout;
    private TextView mIconNameView;
    private View mIconSdBg;
    private View mIconSdLayout;
    private TextView mIconShowTitleView;
    private int mItemWidthX;
    private h mMsgTabCAdapter;
    private RecyclerView mRecyclerView;
    private int mRvScrollX;
    private boolean mScrollXEvent;
    private boolean mShowIcon;
    SuperExposeMsgTabInfo msgTabInfo;
    private final String titleShow_0;
    private final String titleShow_1;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            MsgTabUiViewC msgTabUiViewC = MsgTabUiViewC.this;
            if (msgTabUiViewC.mCurStatus == 1) {
                bo5 bo5Var = msgTabUiViewC.mMsgTabCallBack;
                if (bo5Var != null) {
                    bo5Var.d(32, 1);
                    return;
                }
                return;
            }
            bo5 bo5Var2 = msgTabUiViewC.mMsgTabCallBack;
            if (bo5Var2 != null) {
                bo5Var2.c(32);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            MsgTabUiViewC.this.mRvScrollX += i;
            if (MsgTabUiViewC.this.mRvScrollX > MsgTabUiViewC.this.mItemWidthX) {
                MsgTabUiViewC msgTabUiViewC = MsgTabUiViewC.this;
                msgTabUiViewC.reportSlide((msgTabUiViewC.mRvScrollX / MsgTabUiViewC.this.mItemWidthX) + MsgTabUiViewC.this.lastVisiblePosition);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MsgTabUiViewC.this.recordVisibleItems();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14861a;
        public final /* synthetic */ int b;

        public e(String str, int i) {
            this.f14861a = str;
            this.b = i;
            put("requestId", MsgTabUiViewC.this.msgTabInfo.requestId);
            put(EventParams.KEY_CT_SDK_POSITION, 3);
            put("show_uid", str);
            put("useCache", Integer.valueOf(MsgTabUiViewC.this.msgTabInfo.useCache));
            put("initialRequestId", MsgTabUiViewC.this.msgTabInfo.initialRequestId);
            put("show_position", Integer.valueOf(i));
            put("realUserType", Integer.valueOf(MsgTabUiViewC.this.mMsgTabCAdapter.b().get(i).type));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14862a;
        public final /* synthetic */ int b;

        public f(String str, int i) {
            this.f14862a = str;
            this.b = i;
            put("requestId", MsgTabUiViewC.this.msgTabInfo.requestId);
            put(EventParams.KEY_CT_SDK_POSITION, 3);
            put("show_uid", str);
            put("useCache", Integer.valueOf(MsgTabUiViewC.this.msgTabInfo.useCache));
            put("initialRequestId", MsgTabUiViewC.this.msgTabInfo.initialRequestId);
            put("show_position", Integer.valueOf(i));
            put("realUserType", Integer.valueOf(MsgTabUiViewC.this.mMsgTabCAdapter.b().get(i).type));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f14863a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;

        public g(float f, float f2, float f3, float f4) {
            this.f14863a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x003d A[PHI: r0 r3
          0x003d: PHI (r0v6 float) = (r0v3 float), (r0v4 float) binds: [B:8:0x003b, B:14:0x0052] A[DONT_GENERATE, DONT_INLINE]
          0x003d: PHI (r3v3 float) = (r3v1 float), (r3v2 float) binds: [B:8:0x003b, B:14:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            LogUtil.d("", "startScaleAnimation scaleAnim scale1 " + animatedValue);
            if (animatedValue instanceof Float) {
                float fFloatValue = ((Float) animatedValue).floatValue();
                float f = this.f14863a;
                float f2 = 1.0f;
                if (fFloatValue <= f) {
                    f2 = 1.0f + ((fFloatValue / f) * 0.2f);
                } else {
                    float f3 = this.b;
                    if (fFloatValue <= f3) {
                        f2 = 1.2f - (((fFloatValue - f) / (f3 - f)) * 0.2f);
                    } else {
                        f = this.c;
                        if (fFloatValue <= f) {
                            fFloatValue -= f3;
                            f -= f3;
                            f2 = 1.0f + ((fFloatValue / f) * 0.2f);
                        } else {
                            f3 = this.d;
                            if (fFloatValue <= f3) {
                            }
                        }
                    }
                }
                MsgTabUiViewC.this.mIconSdLayout.setScaleX(f2);
                MsgTabUiViewC.this.mIconSdLayout.setScaleY(f2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends RecyclerView.Adapter<i> {
        public List<SuperExposeMsgTagCItemModel> e;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f14864a;

            public a(i iVar) {
                this.f14864a = iVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l50.a()) {
                    return;
                }
                int layoutPosition = this.f14864a.getLayoutPosition();
                LogUtil.d("SuperExposeMsgTab", "itemView onClick position:" + layoutPosition);
                h.this.h(layoutPosition);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, String> {
            public b() {
                put(EventParams.KEY_GROUP, gk4.b());
            }
        }

        public h(List<SuperExposeMsgTagCItemModel> list) {
            this.e = list;
        }

        public List<SuperExposeMsgTagCItemModel> b() {
            return this.e;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull i iVar, int i) {
            List<SuperExposeMsgTagCItemModel> list = this.e;
            if (list != null) {
                iVar.l(list.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LogUtil.d("SuperExposeMsgTab", "MsgTabCAdapter onCreateViewHolder viewType:" + i);
            View viewInflate = LayoutInflater.from(MsgTabUiViewC.this.mContext).inflate(R.layout.super_expose_msg_tab_c_item, viewGroup, false);
            if (is3.b().e()) {
                viewInflate.setBackgroundColor(0);
            }
            i iVar = MsgTabUiViewC.this.new i(viewInflate);
            viewInflate.setOnClickListener(new a(iVar));
            return iVar;
        }

        public final void f(String str, String str2, int i, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(DeviceInfoUtil.UID_TAG, str2);
                jSONObject.put("deviceId", ac1.h);
                jSONObject.put("profileType", i);
                jSONObject.put("realUserType", i2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.g(str, jSONObject);
        }

        public void g(List<SuperExposeMsgTagCItemModel> list) {
            MsgTabUiViewC.this.mScrollXEvent = false;
            this.e = list;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<SuperExposeMsgTagCItemModel> list = this.e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public final void h(int i) {
            SuperExposeMsgTagCItemModel superExposeMsgTagCItemModel;
            List<SuperExposeMsgTagCItemModel> list = this.e;
            if (list == null || list.size() <= i || (superExposeMsgTagCItemModel = this.e.get(i)) == null || TextUtils.isEmpty(superExposeMsgTagCItemModel.uid)) {
                return;
            }
            f("boost_message_promotion_othersProfileClick", AccountUtils.p(MsgTabUiViewC.this.mContext), !TextUtils.isEmpty(superExposeMsgTagCItemModel.tagName) ? 2 : 1, superExposeMsgTagCItemModel.type);
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            Bundle bundle = new Bundle();
            fk2.a aVar = new fk2.a();
            contactInfoItem.setUid(superExposeMsgTagCItemModel.uid);
            contactInfoItem.setIconURL(superExposeMsgTagCItemModel.avatar);
            contactInfoItem.setNickName(superExposeMsgTagCItemModel.nickname);
            contactInfoItem.setSourceType(60);
            int iU = bj5.b().a().u(superExposeMsgTagCItemModel.getChatBizType(1));
            contactInfoItem.setBizType(iU);
            if (iU == 5051) {
                bundle.putInt("from", 89);
                zn6.h("msg_sign_task", "click", new b());
            } else {
                bundle.putInt("from", 79);
            }
            bundle.putParcelable("user_item_info", contactInfoItem);
            aVar.b(bundle);
            Intent intentA = n5.a(MsgTabUiViewC.this.mContext, aVar);
            intentA.putExtra("superExposeMsgTabItem", 1);
            if (!(MsgTabUiViewC.this.mContext instanceof Activity)) {
                intentA.addFlags(268435456);
            }
            MsgTabUiViewC.this.mContext.startActivity(intentA);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends RecyclerView.ViewHolder {
        public EffectiveShapeView d;
        public TextView e;
        public TextView f;
        public View g;
        public LightingAnimationView h;
        public boolean i;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, String> {
            public a() {
                put(EventParams.KEY_GROUP, gk4.b());
            }
        }

        public i(@NonNull View view) {
            super(view);
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = false;
            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) view.findViewById(R.id.header_icon);
            this.d = effectiveShapeView;
            effectiveShapeView.setBorderWidth(me1.b(MsgTabUiViewC.this.mContext, 1));
            this.d.setBorderColor(Color.parseColor("#FFFFFF"));
            EffectiveShapeView effectiveShapeView2 = (EffectiveShapeView) view.findViewById(R.id.header_icon_green_bg);
            effectiveShapeView2.setBorderWidth(me1.b(MsgTabUiViewC.this.mContext, 1));
            effectiveShapeView2.setBorderColor(Color.parseColor("#14CD64"));
            this.e = (TextView) view.findViewById(R.id.super_expose_msg_tab_c_item_status_title);
            this.g = view.findViewById(R.id.super_expose_msg_tab_c_item_status_title_all);
            this.f = (TextView) view.findViewById(R.id.super_expose_msg_tab_c_item_name_title);
            this.f = (TextView) view.findViewById(R.id.super_expose_msg_tab_c_item_name_title);
            this.h = (LightingAnimationView) view.findViewById(R.id.anim_view);
        }

        public void l(SuperExposeMsgTagCItemModel superExposeMsgTagCItemModel) {
            if (superExposeMsgTagCItemModel == null) {
                return;
            }
            if (this.d != null) {
                String str = superExposeMsgTagCItemModel.avatar;
                if (TextUtils.isEmpty(str)) {
                    this.d.setImageResource(R.drawable.default_portrait);
                } else {
                    gr2.j().h(str, this.d, bq6.s());
                }
            }
            if (this.g != null) {
                String str2 = superExposeMsgTagCItemModel.tagName;
                if (TextUtils.isEmpty(str2)) {
                    this.g.setVisibility(8);
                } else {
                    this.g.setVisibility(0);
                    TextView textView = this.e;
                    if (textView != null) {
                        textView.setText(str2);
                    }
                }
            }
            if (this.f != null) {
                String str3 = superExposeMsgTagCItemModel.nickname;
                if (TextUtils.isEmpty(str3)) {
                    this.f.setVisibility(8);
                    this.f.setText("");
                } else {
                    this.f.setVisibility(0);
                    this.f.setText(str3);
                }
            }
            if (superExposeMsgTagCItemModel.type != 21 || this.i) {
                return;
            }
            this.i = true;
            zn6.h("msg_sign_task", "view", new a());
        }
    }

    public MsgTabUiViewC(Context context, int i2, boolean z) {
        super(context);
        this.titleShow_1 = "曝光中";
        this.titleShow_0 = "点我曝光";
        this.mRecyclerView = null;
        this.mMsgTabCAdapter = null;
        this.mAllItemModels = null;
        this.mIconShowTitleView = null;
        this.mIconNameView = null;
        this.mShowIcon = true;
        this.mIconLayout = null;
        this.mIconBg = null;
        this.mRvScrollX = 0;
        this.mItemWidthX = 0;
        this.mScrollXEvent = false;
        this.mIconSdBg = null;
        this.mIconSdLayout = null;
        this.lastVisiblePosition = 0;
        this.displayedPositions = new HashSet<>();
        this.mCurStatus = i2;
        this.mShowIcon = z;
        this.mItemWidthX = a46.b(getContext(), 52.0f);
    }

    private void checkStatusView() {
        if (this.mShowIcon) {
            this.mIconLayout.setVisibility(0);
        } else {
            this.mIconLayout.setVisibility(8);
        }
        checkSDViewByStatus(this.mCurStatus);
        if (this.mCurStatus == 1) {
            TextView textView = this.mIconShowTitleView;
            if (textView != null) {
                textView.setText("曝光中");
            }
            View view = this.mIconBg;
            if (view != null && view.getVisibility() == 0) {
                this.mIconBg.setVisibility(8);
            }
            View view2 = this.mIconSdBg;
            if (view2 != null && view2.getVisibility() == 8) {
                this.mIconSdBg.setVisibility(0);
            }
            startRefreshStatus(true);
            return;
        }
        View view3 = this.mIconBg;
        if (view3 != null && view3.getVisibility() == 8) {
            this.mIconBg.setVisibility(0);
        }
        TextView textView2 = this.mIconShowTitleView;
        if (textView2 != null) {
            textView2.setText("点我曝光");
        }
        View view4 = this.mIconSdBg;
        if (view4 != null && view4.getVisibility() == 0) {
            this.mIconSdBg.setVisibility(8);
        }
        destroyTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordVisibleItems() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        if (linearLayoutManager == null || this.msgTabInfo == null) {
            return;
        }
        this.lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
        for (int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= this.lastVisiblePosition; iFindFirstVisibleItemPosition++) {
            b05.d("初始化显示第" + iFindFirstVisibleItemPosition + "个");
            if (iFindFirstVisibleItemPosition < this.mMsgTabCAdapter.b().size() && iFindFirstVisibleItemPosition >= 0 && this.mMsgTabCAdapter.b().size() > 0) {
                String str = this.mMsgTabCAdapter.b().get(iFindFirstVisibleItemPosition).uid;
                String str2 = str + "_" + this.msgTabInfo.requestId;
                if (!this.displayedPositions.contains(str2)) {
                    this.displayedPositions.add(str2);
                    b05.d("上传数据:" + str2);
                    zn6.j("boost_buyer_show_seen", null, new e(str, iFindFirstVisibleItemPosition));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSlide(int i2) {
        if (i2 < this.mMsgTabCAdapter.b().size() && this.msgTabInfo != null) {
            b05.d("当前显示第：" + i2);
            String str = this.mMsgTabCAdapter.b().get(i2).uid;
            String str2 = str + "_" + this.msgTabInfo.requestId;
            if (!this.displayedPositions.contains(str2)) {
                this.displayedPositions.add(str2);
                b05.d("上传数据:" + str2);
                zn6.j("boost_buyer_show_seen", null, new f(str, i2));
            }
        }
        if (this.mScrollXEvent) {
            return;
        }
        this.mScrollXEvent = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(this.mContext));
            jSONObject.put("deviceId", ac1.h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.g("boost_message_promotion_slide", jSONObject);
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public int getRootLayout() {
        return R.layout.super_expose_msg_tab_ui_c;
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void initItemView(bo5 bo5Var) {
        super.initItemView(bo5Var);
        if (is3.b().e()) {
            findViewById(R.id.contentRootLayout).setBackgroundColor(0);
        }
        this.mIconView.setBorderWidth(me1.b(this.mContext, 1));
        this.mIconView.setBorderColor(Color.parseColor("#FFFFFF"));
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) findViewById(R.id.header_icon_green_bg);
        effectiveShapeView.setBorderWidth(me1.b(this.mContext, 1));
        effectiveShapeView.setBorderColor(Color.parseColor("#14CD64"));
        this.mIconLayout = findViewById(R.id.super_icon_layout);
        this.mIconNameView = (TextView) findViewById(R.id.super_icon_title_name);
        this.mIconShowTitleView = (TextView) findViewById(R.id.super_icon_show_title);
        this.mIconBg = findViewById(R.id.header_bg);
        this.mIconSdLayout = findViewById(R.id.super_expose_msg_tab_c_title_layout);
        this.mIconSdBg = findViewById(R.id.super_expose_msg_tab_c_sd_bg);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.msg_tab_c_recycler);
        this.mIconLayout.setOnClickListener(new a());
        checkStatusView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.setOrientation(0);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        h hVar = new h(this.mAllItemModels);
        this.mMsgTabCAdapter = hVar;
        this.mRecyclerView.setAdapter(hVar);
        this.mRecyclerView.addOnScrollListener(new b());
        this.mRecyclerView.post(new c());
        this.mMsgTabCAdapter.registerAdapterDataObserver(new d());
    }

    public void setCurStatus(int i2) {
        this.mCurStatus = i2;
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void setData(SuperExposeMsgTabInfo superExposeMsgTabInfo, SuperExposeInfo superExposeInfo, boolean z, boolean z2) {
        ArrayList<SuperExposeMsgTagCItemModel> arrayList;
        h hVar;
        ContactInfoItem contactInfoItem;
        super.setData(superExposeMsgTabInfo, superExposeInfo, z, z2);
        this.msgTabInfo = superExposeMsgTabInfo;
        if (this.mIconNameView != null && (contactInfoItem = this.mContactInfoItem) != null) {
            String nickName = contactInfoItem.getNickName();
            if (!TextUtils.isEmpty(nickName)) {
                this.mIconNameView.setText(nickName);
            }
        }
        if (superExposeInfo == null || superExposeInfo.status != 1) {
            this.mCurStatus = -1;
        } else {
            this.mCurStatus = 1;
        }
        checkStatusView();
        if (superExposeMsgTabInfo == null || (arrayList = superExposeMsgTabInfo.dataList) == null || arrayList.size() <= 0 || (hVar = this.mMsgTabCAdapter) == null) {
            return;
        }
        hVar.g(superExposeMsgTabInfo.dataList);
    }

    public void setShowIcon(boolean z) {
        this.mShowIcon = z;
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void setSuperNumLayoutShow() {
        super.setSuperNumLayoutShow();
        LogUtil.d("", "MsgTabTaijiModelManager setSuperNumLayoutShow mShowCount " + hs3.c);
        if (hs3.c > 0) {
            View view = this.mSuperNumLayout;
            if (view != null) {
                view.setVisibility(0);
            }
            TextView textView = this.mSuperNumTextView;
            if (textView != null) {
                textView.setText(hs3.c + "人");
            }
        }
    }

    public void startScaleAnimation() {
        if (this.mIconSdLayout != null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.4f);
            valueAnimatorOfFloat.setDuration((long) 600.0f);
            valueAnimatorOfFloat.addUpdateListener(new g(0.1f, 0.2f, 0.3f, 0.4f));
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.start();
        }
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void visibleShow(boolean z) {
        super.visibleShow(z);
        b05.d("visibleShow===>isShow===>" + z);
        if (z) {
            startRefreshStatus(true);
        } else {
            destroyTime();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends RecyclerView.AdapterDataObserver {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b05.d("dataChanged");
            MsgTabUiViewC.this.recordVisibleItems();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            b05.d("dataChanged");
            MsgTabUiViewC.this.recordVisibleItems();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            b05.d("dataChanged");
            MsgTabUiViewC.this.recordVisibleItems();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            b05.d("dataChanged");
            MsgTabUiViewC.this.recordVisibleItems();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            b05.d("dataChanged");
            MsgTabUiViewC.this.recordVisibleItems();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            super.onItemRangeChanged(i, i2, obj);
            b05.d("dataChanged");
            MsgTabUiViewC.this.recordVisibleItems();
        }
    }
}
