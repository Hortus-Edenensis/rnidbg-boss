package com.zenmen.palmchat.contacts.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.widget.a;
import com.zenmen.palmchat.databinding.LayoutUserDetailEnergyView2Binding;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.widget.LightingAnimationView;
import defpackage.go2;
import defpackage.p05;
import defpackage.q05;
import defpackage.sw4;
import defpackage.zw4;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserDetailEnergyView2 extends FrameLayout {
    private LightingAnimationView animView;
    private LayoutUserDetailEnergyView2Binding binding;
    private Context context;
    private ContactInfoItem currentContactInfoItem;
    private int currentEnergyValue;
    private EnergyTipPopupWindow energyTipPopup;
    private boolean hasRefreshedOnActivityOpen;
    private com.zenmen.palmchat.contacts.widget.a profileEnergyConfig;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13740a;

        public a(Context context) {
            this.f13740a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            UserDetailEnergyView2.this.reportProfileEnergyClick();
            SAppUtil.I(this.f13740a, SAppUtil.G(), true, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<SocialActiveWeekValuesV1Bean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13741a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ boolean c;

        public b(String str, HashMap map, boolean z) {
            this.f13741a = str;
            this.b = map;
            this.c = z;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f13741a, this.b).f(this.c);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SocialActiveWeekValuesV1Bean> lXBaseNetBean, Exception exc) {
            SocialActiveWeekValuesV1Bean socialActiveWeekValuesV1Bean;
            if (q05.o((Activity) UserDetailEnergyView2.this.context)) {
                return;
            }
            if (!z || lXBaseNetBean == null || (socialActiveWeekValuesV1Bean = lXBaseNetBean.data) == null) {
                UserDetailEnergyView2.this.setVisibility(8);
                return;
            }
            SocialActiveWeekValuesV1Bean socialActiveWeekValuesV1Bean2 = socialActiveWeekValuesV1Bean;
            if (!socialActiveWeekValuesV1Bean2.showStatus) {
                UserDetailEnergyView2.this.setVisibility(8);
                return;
            }
            UserDetailEnergyView2.this.setVisibility(0);
            int progressPercentage = socialActiveWeekValuesV1Bean2.getProgressPercentage();
            UserDetailEnergyView2.this.currentEnergyValue = progressPercentage;
            UserDetailEnergyView2.this.setEnergyPercentage(progressPercentage);
            UserDetailEnergyView2 userDetailEnergyView2 = UserDetailEnergyView2.this;
            userDetailEnergyView2.reportProfileEnergyShow(userDetailEnergyView2.currentContactInfoItem, progressPercentage);
        }
    }

    public UserDetailEnergyView2(@NonNull Context context) {
        this(context, null);
    }

    private int dpToPx(Context context, int i) {
        return Math.round(i * context.getResources().getDisplayMetrics().density);
    }

    private void init(Context context) {
        if (!p05.b()) {
            setVisibility(8);
            return;
        }
        this.binding = (LayoutUserDetailEnergyView2Binding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_user_detail_energy_view2, this, true);
        this.energyTipPopup = new EnergyTipPopupWindow(context);
        this.animView = this.binding.f13905a;
        this.profileEnergyConfig = com.zenmen.palmchat.contacts.widget.a.a();
        this.binding.g.setOnClickListener(new a(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setEnergyPercentage$0(int i) {
        LayoutUserDetailEnergyView2Binding layoutUserDetailEnergyView2Binding;
        ConstraintLayout constraintLayout;
        if (q05.o((Activity) this.context) || (layoutUserDetailEnergyView2Binding = this.binding) == null || (constraintLayout = layoutUserDetailEnergyView2Binding.f) == null) {
            return;
        }
        int width = constraintLayout.getWidth();
        if (width <= 0) {
            width = dpToPx(this.context, 80);
        }
        int iMax = Math.max(dpToPx(this.context, 1), (int) ((i * width) / 100.0f));
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.binding.b.getLayoutParams();
        if (iMax >= dpToPx(this.context, 40)) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = iMax;
            layoutParams.startToStart = 0;
            layoutParams.endToEnd = -1;
            this.binding.b.setTextColor(Color.parseColor("#FCF2EB"));
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = width;
            layoutParams.startToStart = 0;
            layoutParams.endToEnd = 0;
            this.binding.b.setTextColor(Color.parseColor("#FF9642"));
        }
        this.binding.b.setGravity(17);
        this.binding.b.setLayoutParams(layoutParams);
        startLightingAnimation();
        if (this.energyTipPopup == null || this.binding.g == null || !q05.r(this)) {
            return;
        }
        this.energyTipPopup.o(this.binding.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportProfileEnergyClick() {
        if (this.currentContactInfoItem == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("show_profile", this.currentContactInfoItem.getUid());
        map.put("energy_value", Integer.valueOf(this.currentEnergyValue));
        q05.a("profile_energy_click", 2, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportProfileEnergyShow(ContactInfoItem contactInfoItem, int i) {
        a.C1036a c1036a;
        if (contactInfoItem == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("show_profile", contactInfoItem.getUid());
        map.put("energy_value", Integer.valueOf(i));
        com.zenmen.palmchat.contacts.widget.a aVar = this.profileEnergyConfig;
        map.put("copywriting", (aVar == null || (c1036a = aVar.d) == null) ? "能量越高，曝光和打招呼机会越多" : c1036a.f13743a);
        q05.a("profile_energy_show", 1, map);
    }

    private void startLightingAnimation() {
        a.c cVar;
        a.c cVar2;
        if (this.animView != null) {
            com.zenmen.palmchat.contacts.widget.a aVar = this.profileEnergyConfig;
            int i = 2;
            int i2 = (aVar == null || (cVar2 = aVar.f13742a) == null) ? 2 : cVar2.b;
            if (aVar != null && (cVar = aVar.f13742a) != null) {
                i = cVar.f13745a;
            }
            this.binding.f13905a.setmDuration(i * 1000);
            if (i2 > 0) {
                this.binding.f13905a.startLightingAnimation(i2 - 1);
            } else {
                this.binding.f13905a.startLightingAnimation(i2);
            }
        }
    }

    private void updateViewByFriendMode(int i) {
        TextView textView;
        a.b bVar;
        TextView textView2;
        a.b bVar2;
        if (i == 0) {
            LayoutUserDetailEnergyView2Binding layoutUserDetailEnergyView2Binding = this.binding;
            if (layoutUserDetailEnergyView2Binding == null || (textView2 = layoutUserDetailEnergyView2Binding.e) == null) {
                return;
            }
            com.zenmen.palmchat.contacts.widget.a aVar = this.profileEnergyConfig;
            textView2.setText((aVar == null || (bVar2 = aVar.b) == null) ? "查看>" : bVar2.b);
            return;
        }
        LayoutUserDetailEnergyView2Binding layoutUserDetailEnergyView2Binding2 = this.binding;
        if (layoutUserDetailEnergyView2Binding2 == null || (textView = layoutUserDetailEnergyView2Binding2.e) == null) {
            return;
        }
        com.zenmen.palmchat.contacts.widget.a aVar2 = this.profileEnergyConfig;
        textView.setText((aVar2 == null || (bVar = aVar2.b) == null) ? "超越Ta>" : bVar.f13744a);
    }

    public void apiSocialActiveWeekValuesV1(String str, int i) {
        String str2 = q05.c() + "/social.active.user.week.values.v1";
        HashMap map = new HashMap();
        map.put("fuid", str);
        zw4.e(new b(str2, map, false));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EnergyTipPopupWindow energyTipPopupWindow = this.energyTipPopup;
        if (energyTipPopupWindow != null) {
            energyTipPopupWindow.j();
            this.energyTipPopup = null;
        }
    }

    public void resetRefreshState() {
        this.hasRefreshedOnActivityOpen = false;
    }

    public void setEnergyPercentage(final int i) {
        LayoutUserDetailEnergyView2Binding layoutUserDetailEnergyView2Binding = this.binding;
        if (layoutUserDetailEnergyView2Binding == null) {
            return;
        }
        if (i > 100) {
            i = 100;
        }
        layoutUserDetailEnergyView2Binding.b.setText("能量" + i + "%");
        this.binding.c.setProgress(i);
        this.binding.f.post(new Runnable() { // from class: o66
            @Override // java.lang.Runnable
            public final void run() {
                this.f19703a.lambda$setEnergyPercentage$0(i);
            }
        });
    }

    public void setUserInfo(ContactInfoItem contactInfoItem, int i) {
        if (this.binding == null || TextUtils.isEmpty(contactInfoItem.getUid())) {
            return;
        }
        if (!p05.b()) {
            setVisibility(8);
            return;
        }
        if (this.hasRefreshedOnActivityOpen) {
            return;
        }
        this.currentContactInfoItem = contactInfoItem;
        EnergyTipPopupWindow energyTipPopupWindow = this.energyTipPopup;
        if (energyTipPopupWindow != null) {
            energyTipPopupWindow.l(contactInfoItem);
        }
        updateViewByFriendMode(i);
        apiSocialActiveWeekValuesV1(contactInfoItem.getUid(), i);
        this.hasRefreshedOnActivityOpen = true;
    }

    public UserDetailEnergyView2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UserDetailEnergyView2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hasRefreshedOnActivityOpen = false;
        this.currentEnergyValue = 0;
        this.context = context;
        init(context);
    }
}
