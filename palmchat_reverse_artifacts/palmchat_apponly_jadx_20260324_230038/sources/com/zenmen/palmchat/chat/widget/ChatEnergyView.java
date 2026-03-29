package com.zenmen.palmchat.chat.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.widget.SocialActiveWeekValuesV1Bean;
import com.zenmen.palmchat.databinding.LayoutChatEnergyViewBinding;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import defpackage.go2;
import defpackage.p05;
import defpackage.q05;
import defpackage.sw4;
import defpackage.zw4;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ChatEnergyView extends FrameLayout {
    private LayoutChatEnergyViewBinding binding;
    private Context context;
    private ContactInfoItem currentContactInfoItem;
    private int currentEnergyValue;
    private boolean hasReportedShow;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f12985a;

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.widget.ChatEnergyView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1006a extends HashMap<String, Object> {
            public C1006a() {
                put("show_profile", ChatEnergyView.this.currentContactInfoItem.getUid());
            }
        }

        public a(Context context) {
            this.f12985a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("chat_topprofile_energy_click", 2, new C1006a());
            Context context = this.f12985a;
            if (context instanceof ChatterActivity) {
                ((ChatterActivity) context).z3().i(ChatEnergyView.this.currentContactInfoItem);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<SocialActiveWeekValuesV1Bean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12987a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ boolean c;

        public b(String str, HashMap map, boolean z) {
            this.f12987a = str;
            this.b = map;
            this.c = z;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f12987a, this.b).f(this.c);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SocialActiveWeekValuesV1Bean> lXBaseNetBean, Exception exc) {
            SocialActiveWeekValuesV1Bean socialActiveWeekValuesV1Bean;
            if (q05.o((Activity) ChatEnergyView.this.context)) {
                return;
            }
            if (!z || lXBaseNetBean == null || (socialActiveWeekValuesV1Bean = lXBaseNetBean.data) == null) {
                ChatEnergyView.this.setVisibility(8);
                return;
            }
            SocialActiveWeekValuesV1Bean socialActiveWeekValuesV1Bean2 = socialActiveWeekValuesV1Bean;
            if (!socialActiveWeekValuesV1Bean2.showStatus) {
                ChatEnergyView.this.setVisibility(8);
                return;
            }
            int progressPercentage = socialActiveWeekValuesV1Bean2.getProgressPercentage();
            if (progressPercentage == 0) {
                ChatEnergyView.this.setVisibility(8);
            } else {
                ChatEnergyView.this.setVisibility(0);
                ChatEnergyView.this.setEnergyPercentage(progressPercentage);
            }
        }
    }

    public ChatEnergyView(@NonNull Context context) {
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
        LayoutChatEnergyViewBinding layoutChatEnergyViewBinding = (LayoutChatEnergyViewBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_chat_energy_view, this, true);
        this.binding = layoutChatEnergyViewBinding;
        layoutChatEnergyViewBinding.d.setOnClickListener(new a(context));
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setEnergyPercentage$0(int i) {
        LayoutChatEnergyViewBinding layoutChatEnergyViewBinding;
        ConstraintLayout constraintLayout;
        if (q05.o((Activity) this.context) || (layoutChatEnergyViewBinding = this.binding) == null || (constraintLayout = layoutChatEnergyViewBinding.c) == null) {
            return;
        }
        int width = constraintLayout.getWidth();
        if (width <= 0) {
            width = dpToPx(this.context, 94);
        }
        int iMax = Math.max(dpToPx(this.context, 1), (int) ((i * width) / 100.0f));
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.binding.f13903a.getLayoutParams();
        if (iMax >= dpToPx(this.context, 30)) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = iMax;
            layoutParams.startToStart = 0;
            layoutParams.endToEnd = -1;
            this.binding.f13903a.setTextColor(Color.parseColor("#FCF2EB"));
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = width;
            layoutParams.startToStart = 0;
            layoutParams.endToEnd = 0;
            this.binding.f13903a.setTextColor(Color.parseColor("#FF9642"));
        }
        this.binding.f13903a.setGravity(17);
        this.binding.f13903a.setLayoutParams(layoutParams);
    }

    private void reportChatTopProfileEnergyShow() {
        if (this.currentContactInfoItem == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("show_profile", this.currentContactInfoItem.getUid());
        map.put("energy_value", Integer.valueOf(this.currentEnergyValue));
        q05.a("chat_topprofile_energy_show", 1, map);
    }

    public void apiSocialActiveWeekValuesV1(String str) {
        String str2 = q05.c() + "/social.active.user.week.values.v1";
        HashMap map = new HashMap();
        map.put("fuid", str);
        zw4.e(new b(str2, map, false));
    }

    public void setContactInfo(ContactInfoItem contactInfoItem) {
        if (this.binding == null || TextUtils.isEmpty(contactInfoItem.getUid())) {
            return;
        }
        if (!p05.b()) {
            setVisibility(8);
            return;
        }
        this.currentContactInfoItem = contactInfoItem;
        this.hasReportedShow = false;
        apiSocialActiveWeekValuesV1(contactInfoItem.getUid());
    }

    public void setEnergyPercentage(final int i) {
        LayoutChatEnergyViewBinding layoutChatEnergyViewBinding = this.binding;
        if (layoutChatEnergyViewBinding == null) {
            return;
        }
        this.currentEnergyValue = i;
        layoutChatEnergyViewBinding.f13903a.setText(i + "%");
        if (this.currentContactInfoItem != null && !this.hasReportedShow) {
            reportChatTopProfileEnergyShow();
            this.hasReportedShow = true;
        }
        this.binding.b.setProgress(i);
        this.binding.c.post(new Runnable() { // from class: f20
            @Override // java.lang.Runnable
            public final void run() {
                this.f17414a.lambda$setEnergyPercentage$0(i);
            }
        });
    }

    public ChatEnergyView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatEnergyView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentEnergyValue = 0;
        this.hasReportedShow = false;
        this.context = context;
        init(context);
    }
}
