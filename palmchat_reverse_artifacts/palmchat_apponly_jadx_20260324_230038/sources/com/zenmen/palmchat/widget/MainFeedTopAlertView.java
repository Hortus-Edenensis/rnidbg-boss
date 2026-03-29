package com.zenmen.palmchat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.constants.ErrorCode;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.mvp.model.bean.MediaForChatCard;
import com.zenmen.square.mvp.model.bean.SquareFeedForChatCard;
import defpackage.a46;
import defpackage.az2;
import defpackage.bj5;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.dn0;
import defpackage.fo0;
import defpackage.go0;
import defpackage.gr2;
import defpackage.l50;
import defpackage.rn;
import defpackage.ry5;
import defpackage.zn6;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MainFeedTopAlertView extends LinearLayout implements View.OnClickListener {
    private TextView btnView;
    private int containerOffset;
    private JSONObject contentObj;
    private long fromUid;
    private boolean hasClick;
    private EffectiveShapeView headView;
    private Runnable hideRunnable;
    LinearLayout imgContainer;
    private TextView nickNameView;
    private TextView subTextView;
    private int translationY;
    private rn visibleCallback;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainFeedTopAlertView.this.hide(300L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            MainFeedTopAlertView.this.setVisibility(8);
            MainFeedTopAlertView.this.notifyVisibleChanged();
            if (MainFeedTopAlertView.this.hasClick) {
                MainFeedTopAlertView.this.processActionUrl();
                MainFeedTopAlertView.this.hasClick = false;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements fo0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f15987a;

        public c(JSONObject jSONObject) {
            this.f15987a = jSONObject;
        }

        @Override // defpackage.fo0
        public void onResponse(int i, String str) {
            if (i != 0) {
                ry5.a("获取用户信息失败");
            } else {
                MainFeedTopAlertView.this.jumpToChat((ContactInfoItem) az2.a(str, ContactInfoItem.class), this.f15987a.toString());
            }
        }
    }

    public MainFeedTopAlertView(Context context) {
        this(context, null);
    }

    private void doEventReport(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bizAction", "feed_topalert");
            jSONObject.put("fromid", this.fromUid);
            jSONObject.put("type", "feednotice");
            jSONObject.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d(str, null, jSONObject.toString());
    }

    private void fillImages(LinearLayout linearLayout, List<MediaForChatCard> list) {
        if (list == null) {
            linearLayout.removeAllViews();
            return;
        }
        int iB = a46.b(linearLayout.getContext(), 4.0f);
        int iB2 = a46.b(linearLayout.getContext(), 32.0f);
        int iB3 = a46.b(linearLayout.getContext(), 4.0f);
        linearLayout.removeAllViews();
        int i = 0;
        for (MediaForChatCard mediaForChatCard : list) {
            i++;
            int i2 = (iB2 + iB3) * i;
            LogUtil.d("ContactAlert", "totalLength " + i2 + " offSet " + this.containerOffset);
            if (i2 > this.containerOffset) {
                return;
            }
            EffectiveShapeView effectiveShapeView = new EffectiveShapeView(linearLayout.getContext());
            effectiveShapeView.changeShapeType(3);
            effectiveShapeView.setDegreeForRoundRectangle(iB3, iB3);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iB2, iB2);
            layoutParams.rightMargin = iB;
            linearLayout.addView(effectiveShapeView, layoutParams);
            gr2.j().g(mediaForChatCard.thumbUrl, effectiveShapeView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide(long j) {
        removeCallbacks(this.hideRunnable);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "translationY", 0.0f, this.translationY);
        objectAnimatorOfFloat.setDuration(j);
        objectAnimatorOfFloat.start();
        objectAnimatorOfFloat.addListener(new b());
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_main_top_alert, (ViewGroup) this, true);
        this.headView = (EffectiveShapeView) findViewById(R.id.iv_head_icon);
        this.nickNameView = (TextView) findViewById(R.id.tv_nickname);
        this.subTextView = (TextView) findViewById(R.id.tv_subtext);
        this.btnView = (TextView) findViewById(R.id.btn_action);
        this.imgContainer = (LinearLayout) findViewById(R.id.ll_thumb_container);
        this.translationY = -a46.b(getContext(), 118.0f);
        this.containerOffset = a46.m(getContext()).x - a46.b(getContext(), 217.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToChat(ContactInfoItem contactInfoItem, String str) {
        if (!contactInfoItem.getIsStranger()) {
            bj5.b().a().g((Activity) getContext(), contactInfoItem, str, -1);
            return;
        }
        contactInfoItem.setSourceType(60);
        contactInfoItem.setBizType(ErrorCode.EXPRESS_RENDER_FAIL);
        bj5.b().a().r((Activity) getContext(), contactInfoItem, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyVisibleChanged() {
        rn rnVar = this.visibleCallback;
        if (rnVar != null) {
            rnVar.run(1, null, Integer.valueOf(getVisibility()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processActionUrl() {
        JSONObject jSONObjectOptJSONObject = this.contentObj.optJSONObject(MediationConstant.RIT_TYPE_FEED);
        if (jSONObjectOptJSONObject == null) {
            ry5.a("获取用户信息失败");
            return;
        }
        SquareFeedForChatCard squareFeedForChatCard = (SquareFeedForChatCard) az2.a(jSONObjectOptJSONObject.toString(), SquareFeedForChatCard.class);
        ContactInfoItem contactInfoItemB = dn0.b(squareFeedForChatCard.exid);
        if (contactInfoItemB == null) {
            go0.h(null, squareFeedForChatCard.exid, new c(jSONObjectOptJSONObject));
        } else {
            jumpToChat(contactInfoItemB, jSONObjectOptJSONObject.toString());
        }
    }

    private void show() {
        setTranslationY(this.translationY);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "translationY", getTranslationY(), 0.0f);
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.start();
        setVisibility(0);
        notifyVisibleChanged();
        doEventReport("lx_client_app_2p31");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (l50.a()) {
            return;
        }
        if (view == this.btnView) {
            doEventReport("lx_client_app_2p33");
        } else if (view == this) {
            doEventReport("lx_client_app_2p32");
        }
        this.hasClick = true;
        hide(100L);
    }

    public void setContentObject(JSONObject jSONObject) {
        this.contentObj = jSONObject;
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString(DeviceInfoUtil.UID_TAG);
        String strOptString2 = this.contentObj.optString("nickname");
        ContactInfoItem contactInfoItemL = bo0.r().l(strOptString);
        if (contactInfoItemL != null) {
            strOptString2 = contactInfoItemL.getNameForShow();
        }
        String strOptString3 = this.contentObj.optString("headIconUrl");
        String strOptString4 = this.contentObj.optString("text");
        String strOptString5 = this.contentObj.optString("button");
        this.contentObj.optString("buttonActionUrl");
        this.contentObj.optString("panelActionUrl");
        this.contentObj.optString("bizAction");
        int iOptInt = this.contentObj.optInt("showtime", 5);
        this.fromUid = this.contentObj.optLong(DeviceInfoUtil.UID_TAG);
        SquareFeedForChatCard squareFeedForChatCard = (SquareFeedForChatCard) az2.a(this.contentObj.optJSONObject(MediationConstant.RIT_TYPE_FEED).toString(), SquareFeedForChatCard.class);
        gr2.j().h(strOptString3, this.headView, bq6.s());
        this.nickNameView.setText(strOptString2);
        this.subTextView.setText(strOptString4);
        this.btnView.setText(strOptString5);
        this.btnView.setOnClickListener(this);
        setOnClickListener(this);
        fillImages(this.imgContainer, squareFeedForChatCard.mediaList);
        show();
        removeCallbacks(this.hideRunnable);
        postDelayed(this.hideRunnable, ((long) iOptInt) * 1000);
    }

    public void setVisibleCallback(rn rnVar) {
        this.visibleCallback = rnVar;
    }

    public MainFeedTopAlertView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainFeedTopAlertView(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public MainFeedTopAlertView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.translationY = 0;
        this.containerOffset = 0;
        this.hideRunnable = new a();
        initView();
    }
}
