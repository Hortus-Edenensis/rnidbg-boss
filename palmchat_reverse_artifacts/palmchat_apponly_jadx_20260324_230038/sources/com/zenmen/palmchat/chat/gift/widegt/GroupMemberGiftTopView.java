package com.zenmen.palmchat.chat.gift.widegt;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.venus.bean.MemberBean;
import com.zenmen.palmchat.venus.bean.VenusUserDetailBean;
import com.zenmen.palmchat.widget.DecorAvatarView;
import com.zenmen.palmchat.widget.UserLevelView;
import defpackage.a46;
import defpackage.dn0;
import defpackage.fg6;
import defpackage.ir;
import defpackage.ry5;
import defpackage.ss3;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GroupMemberGiftTopView extends LxRelativeLayout implements View.OnClickListener {
    public static final int BIT_INFO_ADMIN = 1;
    public static final int BIT_INFO_FAMILY = 2;
    public static final int EVENT_CLICK_AVATAR = 1;
    public static final int EVENT_CLICK_ENTER_DETAIL = 3;
    public static final int EVENT_CLICK_MORE_SETTINGS = 4;
    public static final int EVENT_CLICK_SEND_MSG = 5;
    public static final int EVENT_CLICK_TARGET_TO = 2;
    private DecorAvatarView avatarView;
    private UserLevelView charmLevel;
    private View enterDetail;
    private ContactInfoItem mItem;
    private AppCompatImageView moreSettings;
    private AppCompatTextView nickName;
    private UserLevelView richLevel;
    private AppCompatTextView sendMsgBtn;
    private LinearLayout tagContainer;
    private View targetTo;
    private AppCompatTextView tvMemberGenderAge;
    private AppCompatImageView vipIcon;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ir<BaseNetBean<VenusUserDetailBean>> {
        public a() {
        }

        @Override // defpackage.ir
        public void a(BaseNetBean<VenusUserDetailBean> baseNetBean) {
            if (baseNetBean.isSuccess()) {
                GroupMemberGiftTopView.this.updateDetailInfo(baseNetBean.data);
            } else {
                ry5.a(baseNetBean.getErrMsg());
            }
        }
    }

    public GroupMemberGiftTopView(Context context) {
        super(context);
    }

    private void loadContactDetail() {
        ss3.a(this.mItem.getUid(), new a());
    }

    private void setNormalInfo() {
        this.avatarView.setAvatarView(this.mItem.getIconURL(), null);
        this.nickName.setText(this.mItem.getNameForShow());
        int iG = fg6.g(this.mItem.getExt());
        if (fg6.q(iG)) {
            this.vipIcon.setVisibility(0);
            this.vipIcon.setImageResource(fg6.e(iG));
        } else {
            this.vipIcon.setVisibility(8);
        }
        ContactInfoItem contactInfoItemA = dn0.a(this.mItem.getUid());
        if (contactInfoItemA == null || contactInfoItemA.getIsStranger()) {
            this.sendMsgBtn.setText("打招呼");
        } else {
            this.sendMsgBtn.setText("发消息");
        }
    }

    private void updateBadge(List<MemberBean.Badge> list) {
        this.tagContainer.removeAllViews();
        if (list == null || list.size() == 0) {
            return;
        }
        int iB = a46.b(getContext(), 22.0f);
        int iB2 = a46.b(getContext(), 6.0f);
        for (MemberBean.Badge badge : list) {
            AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
            appCompatImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((badge.width * iB) / badge.height, iB);
            layoutParams.leftMargin = iB2;
            this.tagContainer.addView(appCompatImageView, layoutParams);
            a46.u(badge.url, appCompatImageView, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDetailInfo(VenusUserDetailBean venusUserDetailBean) {
        if (venusUserDetailBean == null) {
            return;
        }
        this.avatarView.setAvatarView(this.mItem.getIconURL(), venusUserDetailBean.avatarBorder);
        this.richLevel.setLevelType(1);
        this.richLevel.setLevel(venusUserDetailBean.richLevel);
        this.charmLevel.setLevelType(2);
        this.charmLevel.setLevel(venusUserDetailBean.charmLevel);
        this.richLevel.setVisibility(0);
        this.charmLevel.setVisibility(0);
        AppCompatTextView appCompatTextView = (AppCompatTextView) findViewById(R.id.tv_member_gender_age);
        this.tvMemberGenderAge = appCompatTextView;
        appCompatTextView.setVisibility(0);
        if (TextUtils.isEmpty(venusUserDetailBean.getAge())) {
            this.tvMemberGenderAge.setText("");
        } else {
            this.tvMemberGenderAge.setText(venusUserDetailBean.getAge() + " ");
        }
        this.tvMemberGenderAge.setBackgroundResource(venusUserDetailBean.getGender() == 0 ? R.drawable.bg_member_gender_age_male : R.drawable.bg_member_gender_age_female);
        this.tvMemberGenderAge.setCompoundDrawablesWithIntrinsicBounds(venusUserDetailBean.getGender() == 0 ? R.drawable.ic_member_male : R.drawable.ic_member_female, 0, 0, 0);
        if (TextUtils.isEmpty(venusUserDetailBean.getAge()) && venusUserDetailBean.getGender() == -1) {
            this.tvMemberGenderAge.setVisibility(8);
        }
        updateBadge(venusUserDetailBean.badgeList);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R.layout.view_group_member_top, this);
        AppCompatTextView appCompatTextView = (AppCompatTextView) findViewById(R.id.tv_send_msg);
        this.sendMsgBtn = appCompatTextView;
        appCompatTextView.setTag(5);
        DecorAvatarView decorAvatarView = (DecorAvatarView) findViewById(R.id.view_avatar);
        this.avatarView = decorAvatarView;
        decorAvatarView.setTag(1);
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById(R.id.iv_more);
        this.moreSettings = appCompatImageView;
        appCompatImageView.setTag(4);
        View viewFindViewById = findViewById(R.id.tv_target_to);
        this.targetTo = viewFindViewById;
        viewFindViewById.setTag(2);
        View viewFindViewById2 = findViewById(R.id.tv_enter_to);
        this.enterDetail = viewFindViewById2;
        viewFindViewById2.setTag(3);
        this.richLevel = (UserLevelView) findViewById(R.id.iv_rich_level);
        this.charmLevel = (UserLevelView) findViewById(R.id.iv_charm_level);
        this.richLevel.setVisibility(4);
        this.charmLevel.setVisibility(4);
        this.tagContainer = (LinearLayout) findViewById(R.id.tag_container);
        this.nickName = (AppCompatTextView) findViewById(R.id.tv_nickname);
        this.vipIcon = (AppCompatImageView) findViewById(R.id.iv_vip_logo);
        this.avatarView.setOnClickListener(this);
        this.moreSettings.setOnClickListener(this);
        this.targetTo.setOnClickListener(this);
        this.enterDetail.setOnClickListener(this);
        this.sendMsgBtn.setOnClickListener(this);
    }

    public String getSelectedUid() {
        ContactInfoItem contactInfoItem = this.mItem;
        if (contactInfoItem != null) {
            return contactInfoItem.getUid();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            disPatchEvent(((Integer) tag).intValue(), this.mItem);
        } else {
            disPatchEvent(0, this.mItem);
        }
    }

    public void setContactItem(ContactInfoItem contactInfoItem, int i) {
        this.mItem = contactInfoItem;
        this.moreSettings.setVisibility((i & 1) == 1 ? 0 : 8);
        this.sendMsgBtn.setVisibility((i & 2) != 2 ? 8 : 0);
        setNormalInfo();
        loadContactDetail();
    }

    public GroupMemberGiftTopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GroupMemberGiftTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public GroupMemberGiftTopView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
