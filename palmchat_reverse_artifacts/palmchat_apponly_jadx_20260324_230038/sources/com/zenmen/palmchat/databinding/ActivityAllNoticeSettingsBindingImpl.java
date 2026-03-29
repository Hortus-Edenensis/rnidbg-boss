package com.zenmen.palmchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ActivityAllNoticeSettingsBindingImpl extends ActivityAllNoticeSettingsBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts N = null;

    @Nullable
    public static final SparseIntArray O;

    @NonNull
    public final LinearLayout L;
    public long M;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        O = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.chat_notification_row, 2);
        sparseIntArray.put(R.id.chat_notification_title, 3);
        sparseIntArray.put(R.id.chat_notification_subtitle, 4);
        sparseIntArray.put(R.id.friendGreetNotifyLayout, 5);
        sparseIntArray.put(R.id.friendGreetNotifyCheckbox, 6);
        sparseIntArray.put(R.id.strangerGreetNotifyLayout, 7);
        sparseIntArray.put(R.id.strangerGreetNotifyCheckbox, 8);
        sparseIntArray.put(R.id.groupChatNotifyLayout, 9);
        sparseIntArray.put(R.id.groupChatNotifyCheckbox, 10);
        sparseIntArray.put(R.id.official_notification_row, 11);
        sparseIntArray.put(R.id.official_notification_title, 12);
        sparseIntArray.put(R.id.official_notification_subtitle, 13);
        sparseIntArray.put(R.id.officialAnnouncementNotifyLayout, 14);
        sparseIntArray.put(R.id.officialAnnouncementNotifyCheckbox, 15);
        sparseIntArray.put(R.id.interaction_notification_row, 16);
        sparseIntArray.put(R.id.interaction_notification_title, 17);
        sparseIntArray.put(R.id.interaction_notification_subtitle, 18);
        sparseIntArray.put(R.id.friendRequestNotifyLayout, 19);
        sparseIntArray.put(R.id.friendRequestNotifyCheckbox, 20);
        sparseIntArray.put(R.id.dynamicLikeNotifyLayout, 21);
        sparseIntArray.put(R.id.dynamicLikeNotifyCheckbox, 22);
        sparseIntArray.put(R.id.dynamicCommentNotifyLayout, 23);
        sparseIntArray.put(R.id.dynamicCommentNotifyCheckbox, 24);
        sparseIntArray.put(R.id.subscription_notification_row, 25);
        sparseIntArray.put(R.id.subscription_notification_title, 26);
        sparseIntArray.put(R.id.subscription_notification_subtitle, 27);
        sparseIntArray.put(R.id.specialFollowNotifyLayout, 28);
        sparseIntArray.put(R.id.specialFollowNotifyCheckbox, 29);
        sparseIntArray.put(R.id.other_notification_row, 30);
        sparseIntArray.put(R.id.other_notification_title, 31);
        sparseIntArray.put(R.id.other_notification_subtitle, 32);
        sparseIntArray.put(R.id.nearbyUserRecommendNotifyLayout, 33);
        sparseIntArray.put(R.id.nearbyUserRecommendNotifyCheckbox, 34);
        sparseIntArray.put(R.id.otherMarketingNotifyLayout, 35);
        sparseIntArray.put(R.id.otherMarketingNotifyCheckbox, 36);
    }

    public ActivityAllNoticeSettingsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 37, N, O));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.M = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.M != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.M = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public ActivityAllNoticeSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (TextView) objArr[4], (TextView) objArr[3], (CheckBox) objArr[24], (LinearLayout) objArr[23], (CheckBox) objArr[22], (LinearLayout) objArr[21], (CheckBox) objArr[6], (LinearLayout) objArr[5], (CheckBox) objArr[20], (LinearLayout) objArr[19], (CheckBox) objArr[10], (LinearLayout) objArr[9], (LinearLayout) objArr[16], (TextView) objArr[18], (TextView) objArr[17], (CheckBox) objArr[34], (LinearLayout) objArr[33], (CheckBox) objArr[15], (LinearLayout) objArr[14], (LinearLayout) objArr[11], (TextView) objArr[13], (TextView) objArr[12], (CheckBox) objArr[36], (LinearLayout) objArr[35], (LinearLayout) objArr[30], (TextView) objArr[32], (TextView) objArr[31], (CheckBox) objArr[29], (LinearLayout) objArr[28], (CheckBox) objArr[8], (LinearLayout) objArr[7], (LinearLayout) objArr[25], (TextView) objArr[27], (TextView) objArr[26], (View) objArr[1]);
        this.M = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.L = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
