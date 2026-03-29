package com.zenmen.palmchat.conversations.recallbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.conversations.recallbar.bean.RecallBarBean;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.gr2;
import defpackage.hr2;
import defpackage.rt4;
import defpackage.ve;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RecallBar extends FrameLayout implements View.OnClickListener {
    private RecallBarBean bean;
    protected Context mContext;
    private TextView mGuideBtn;
    private ImageView mGuideClose;
    private EffectiveShapeView mGuideIcon;
    private TextView mGuideText;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("type", Integer.valueOf(RecallBar.this.bean.getType()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("type", Integer.valueOf(RecallBar.this.bean.getType()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("type", Integer.valueOf(RecallBar.this.bean.getType()));
        }
    }

    public RecallBar(@NonNull Context context) {
        super(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        View viewInflate = View.inflate(context, R.layout.layout_threads_recall_bar, this);
        this.mGuideIcon = (EffectiveShapeView) viewInflate.findViewById(R.id.guide_icon);
        this.mGuideText = (TextView) viewInflate.findViewById(R.id.guide_text);
        this.mGuideBtn = (TextView) viewInflate.findViewById(R.id.guide_btn);
        this.mGuideClose = (ImageView) viewInflate.findViewById(R.id.guide_close);
        this.mGuideBtn.setOnClickListener(this);
        this.mGuideClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bean == null) {
            return;
        }
        if (view.getId() == R.id.guide_btn) {
            try {
                ve.s((FrameworkBaseActivity) getContext(), this.bean.getActionUrl(), false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("recallbar_2", new b());
        } else if (view.getId() == R.id.guide_close) {
            LogUtil.uploadInfoImmediate("recallbar_3", new c());
        }
        rt4.b().e();
        setVisibility(8);
    }

    public void update() {
        RecallBarBean recallBarBeanC = rt4.b().c();
        this.bean = recallBarBeanC;
        if (recallBarBeanC == null || recallBarBeanC.isExpire() || TeenagersModeManager.a().d()) {
            setVisibility(8);
            return;
        }
        this.mGuideText.setText(this.bean.getText());
        this.mGuideBtn.setText(this.bean.getButton());
        gr2.j().h(this.bean.getIcon(), this.mGuideIcon, hr2.i());
        if (getVisibility() != 0) {
            setVisibility(0);
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.circle_bottom_dialog_in));
            LogUtil.uploadInfoImmediate("recallbar_1", new a());
        }
    }

    public RecallBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init(context, attributeSet);
    }

    public RecallBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init(context, attributeSet);
    }
}
