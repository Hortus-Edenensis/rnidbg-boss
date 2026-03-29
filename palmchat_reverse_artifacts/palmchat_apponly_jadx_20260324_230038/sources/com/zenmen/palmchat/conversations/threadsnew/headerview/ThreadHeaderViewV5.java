package com.zenmen.palmchat.conversations.threadsnew.headerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.NetUnavailableActivity;
import com.zenmen.palmchat.maintab.msgTopEntrance.MsgTopEntranceView;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.ch;
import defpackage.en0;
import defpackage.hw5;
import defpackage.jo6;
import defpackage.k86;
import defpackage.nl0;
import defpackage.on0;
import defpackage.qw5;
import defpackage.r75;
import defpackage.t66;
import defpackage.xh4;
import defpackage.y24;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadHeaderViewV5 extends LinearLayout {
    private static final long DELETE_CONTACT_CARD_INTERNAL = 86400000;
    private static final int STATE_CARD = 4;
    private static final int STATE_COMMON_GUIDE_ENTRANCE = 32;
    private static final int STATE_DEFAULT = 0;
    private static final int STATE_NOTICE = 1;
    private static final int STATE_NOTIFICATIONGUIDE = 16;
    private static final int STATE_TOP_ENTRANCE = 64;
    private static final int STATE_UPLOAD = 2;
    private static final int STATE_VENUS_ROOM = 8;
    private static final String TAG = "ThreadHeaderViewV5";
    private static final long UPLOAD_CONTACT_DIALOG_INTERNAL = 43200000;
    private Activity activity;
    private int currentTabIndex;
    private en0 mCard;
    public CardViewV5 mCardView;
    private d mListener;
    private View mNetworkView;
    private View mNewNgLayout;
    private View mNgLayout;
    private hw5 mNotice;
    public ThreadCardNoticeView mNoticeView;
    private int mShowState;
    private SharedPreferences mSp;
    private TextView mTvNetwork;
    private View mUploadContactsView;
    private MsgTopEntranceView msgTopEntranceView;
    private y24 notificationGuideEntranceHelper;
    private qw5 threadGuideBannerHelper;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ch.s().r0();
            ThreadHeaderViewV5.this.getContext().startActivity(new Intent(ThreadHeaderViewV5.this.getContext(), (Class<?>) NetUnavailableActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadHeaderViewV5.this.mSp.edit().putLong(k86.B(), System.currentTimeMillis()).apply();
            ThreadHeaderViewV5.this.update(false);
            if (!AppContext.getContext().getTrayPreferences().a(k86.n(), false)) {
                AppContext.getContext().getTrayPreferences().i(k86.n(), true);
            }
            ThreadHeaderViewV5.this.getContext().startActivity(on0.a("upload_contact_from_thread"));
            LogUtil.uploadInfoImmediate("24", null, null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ThreadHeaderViewV5.this.mListener != null) {
                ThreadHeaderViewV5.this.mListener.d(ThreadHeaderViewV5.this.getHeight(), 0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();

        void b(en0 en0Var);

        void c(en0 en0Var);

        void d(int i, int i2);

        void e(en0 en0Var);
    }

    public ThreadHeaderViewV5(@NonNull Context context) {
        this(context, null);
    }

    private void disable(int i) {
        this.mShowState = (~i) & this.mShowState;
    }

    private void enable(int i) {
        this.mShowState = i | this.mShowState;
    }

    private void initViews() {
        this.mSp = PreferenceManager.getDefaultSharedPreferences(getContext());
        View viewInflate = View.inflate(getContext(), R.layout.thread_fragment_list_header_v5, this);
        this.mNetworkView = viewInflate.findViewById(R.id.lyt_net_status);
        this.mTvNetwork = (TextView) viewInflate.findViewById(R.id.net_status_tv);
        this.mNetworkView.setOnClickListener(new a());
        this.mNetworkView.setVisibility(8);
        CardViewV5 cardViewV5 = (CardViewV5) viewInflate.findViewById(R.id.card_view);
        this.mCardView = cardViewV5;
        cardViewV5.setVisibility(8);
        ThreadCardNoticeView threadCardNoticeView = (ThreadCardNoticeView) viewInflate.findViewById(R.id.notice_view);
        this.mNoticeView = threadCardNoticeView;
        threadCardNoticeView.setVisibility(8);
        View viewFindViewById = viewInflate.findViewById(R.id.upload_contacts_layout);
        this.mUploadContactsView = viewFindViewById;
        viewFindViewById.setOnClickListener(new b());
        this.mNgLayout = viewInflate.findViewById(R.id.ng_layout);
        this.mNewNgLayout = viewInflate.findViewById(R.id.new_ng_layout);
        if (jo6.D()) {
            this.notificationGuideEntranceHelper = new y24(this.activity, this.mNewNgLayout, viewInflate.findViewById(R.id.power_layout), true);
        } else {
            this.notificationGuideEntranceHelper = new y24(this.activity, this.mNgLayout, viewInflate.findViewById(R.id.power_layout));
        }
        this.threadGuideBannerHelper = new qw5(this.activity, viewInflate);
        this.msgTopEntranceView = (MsgTopEntranceView) viewInflate.findViewById(R.id.msgTopEntranceView);
    }

    private boolean isContactCardInDeleteTime() {
        return Math.abs(r75.h(AppContext.getContext(), k86.a("sp_recommend_contact_card_delet_time")) - System.currentTimeMillis()) < 86400000;
    }

    private boolean isHave(int i) {
        return (this.mShowState & i) == i;
    }

    private void updateAISleepGuideBanner(boolean z) {
        if (z) {
            return;
        }
        boolean z2 = true;
        boolean z3 = isHave(1) || isHave(2) || isHave(4) || isHave(8) || isHave(16) || isHave(64);
        boolean z4 = t66.h().f("LX-62188", false) && t66.h().f("LX-64245", false);
        qw5 qw5Var = this.threadGuideBannerHelper;
        if (!z3 && !z4 && this.currentTabIndex == 0) {
            z2 = false;
        }
        if (qw5Var.e(z2)) {
            enable(32);
        } else {
            disable(32);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean updateGalleryCard() {
        boolean z;
        en0 en0Var;
        String str = TAG;
        LogUtil.i(str, "isContactCardInDeleteTime:" + isContactCardInDeleteTime());
        if (isContactCardInDeleteTime()) {
            this.mCard = null;
        }
        LogUtil.i(str, "updateGalleryCard");
        disable(4);
        if (isHave(8) || isHave(1) || isHave(2) || this.currentTabIndex != 0) {
            if (this.mCardView.hasCards()) {
                this.mCardView.updateCard(null);
            }
            this.mCardView.setVisibility(8);
            return false;
        }
        en0 card = this.mCardView.getCard();
        if (card != null) {
            try {
            } catch (NullPointerException unused) {
                LogUtil.e("NullPointerException", "card params is null!!!");
            }
            if (this.mCard == null || !card.b().d().equals(this.mCard.b().d())) {
                z = false;
            } else if (card.a() == this.mCard.a()) {
                z = true;
            }
        }
        if (this.mCard != null) {
            en0Var = new en0();
            en0Var.d(this.mCard.a());
            if (this.mCard.b() != null) {
                xh4 xh4Var = new xh4();
                xh4Var.g(this.mCard.b().c());
                xh4Var.h(this.mCard.b().d());
                xh4Var.f(this.mCard.b().b());
                xh4Var.e(this.mCard.b().a());
                en0Var.e(xh4Var);
                en0Var.f(en0Var.c());
            }
        } else {
            en0Var = null;
        }
        this.mCardView.updateCard(this.mCard);
        if (this.mCard == null || isContactCardInDeleteTime() || this.mCard.a() == 0 || this.mCard.a() == 3) {
            this.mCardView.setVisibility(8);
            return false;
        }
        enable(4);
        this.mCardView.setVisibility(0);
        if (en0Var == null || en0Var.b() == null || en0Var.b().c() >= 100) {
            if (!z) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("fuid", this.mCard.b().b().fromUid);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                LogUtil.onImmediateClickEvent("card_disR", null, jSONObject.toString());
            }
        } else if (!z) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("fuid", this.mCard.b().b().fromUid);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            LogUtil.onImmediateClickEvent("card_disA", null, jSONObject2.toString());
        }
        return true;
    }

    private void updateNoticeView() {
        disable(1);
        if (isHave(8)) {
            this.mNoticeView.setVisibility(8);
            return;
        }
        hw5 hw5Var = this.mNotice;
        if (hw5Var == null || this.currentTabIndex != 0) {
            this.mNoticeView.showNotice(null);
        } else if (this.mNoticeView.showNotice(hw5Var)) {
            enable(1);
        }
    }

    private void updateNotificationGuideBanner(boolean z) {
        boolean z2 = true;
        if (!isHave(1) && !isHave(2) && !isHave(4) && !isHave(8) && this.currentTabIndex == 0) {
            z2 = false;
        }
        if (this.notificationGuideEntranceHelper.m(z2, z)) {
            enable(16);
        } else {
            disable(16);
        }
    }

    private void updateTopEntrance(boolean z) {
        if (z) {
            return;
        }
        if (!isHave(1) && !isHave(2) && !isHave(4) && !isHave(8)) {
            isHave(16);
        }
        if (this.msgTopEntranceView.updateView(this.currentTabIndex != 0)) {
            enable(64);
        } else {
            disable(64);
        }
    }

    private void updateUploadContactBanner() {
        disable(2);
        if (ac1.C() || this.currentTabIndex != 0) {
            this.mUploadContactsView.setVisibility(8);
            return;
        }
        if (!nl0.g()) {
            this.mUploadContactsView.setVisibility(8);
        } else if (isHave(1) || isHave(8)) {
            this.mUploadContactsView.setVisibility(8);
        } else {
            this.mUploadContactsView.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(null);
    }

    public void onTabSelected(int i) {
        this.currentTabIndex = i;
        update(false);
    }

    public void refresh() {
        post(new c());
    }

    public void setOnOperateListener(d dVar) {
        this.mListener = dVar;
        this.mCardView.setOnCardListener(dVar);
        this.mNoticeView.setClickListener(dVar);
    }

    public void update(boolean z) {
        updateNetworkState();
        updateNoticeView();
        updateUploadContactBanner();
        updateGalleryCard();
        updateNotificationGuideBanner(z);
        updateTopEntrance(z);
        updateAISleepGuideBanner(z);
    }

    public void updateContactCard(en0 en0Var) {
        if (this.mCard == null && en0Var == null) {
            return;
        }
        this.mCard = en0Var;
        update(false);
    }

    public void updateNetworkState() {
        if ((ch.s().t() == 1 || ch.s().y() == 1) && (ch.s().t() == 1 || !ch.s().E())) {
            this.mNetworkView.setVisibility(8);
            return;
        }
        if (ch.s().F() || this.currentTabIndex != 0) {
            this.mNetworkView.setVisibility(8);
            return;
        }
        if (ch.s().E()) {
            this.mTvNetwork.setText(R.string.net_status_unavailable_connect);
        } else {
            this.mTvNetwork.setText(R.string.net_status_unavailable);
        }
        this.mNetworkView.setVisibility(0);
    }

    public void updateNotice(hw5 hw5Var, boolean z) {
        if (this.mNotice == null && hw5Var == null && !z) {
            return;
        }
        this.mNotice = hw5Var;
        update(false);
    }

    public ThreadHeaderViewV5(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadHeaderViewV5(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentTabIndex = 0;
        this.mShowState = 0;
        this.activity = (Activity) context;
        initViews();
    }
}
