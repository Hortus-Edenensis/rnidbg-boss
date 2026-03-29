package com.zenmen.palmchat.framework.bridge.voicomatch;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.framework.R$styleable;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ap3;
import defpackage.az2;
import defpackage.op2;
import defpackage.sy5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MatchPropInfoCardView extends FrameLayout implements View.OnClickListener {
    private TextView btn;
    private ImageView cityCheck;
    private TextView cityDes;
    private View cityLayout;
    private TextView cityPrice;
    private TextView cityRemainCount;
    private TextView cityTitle;
    private ImageView fastCheck;
    private TextView fastDes;
    private View fastLayout;
    private TextView fastPrice;
    private TextView fastRemainCount;
    private TextView fastTitle;
    private VoiceMatchInfo info;
    private boolean isVoice;
    private VoiceMatchType mCurrentVoiceMatchType;
    private op2 onMatchClickListener;
    private int uiType;

    public MatchPropInfoCardView(@NonNull Context context) {
        this(context, null);
    }

    private void initViews() {
        View viewInflate = View.inflate(getContext(), this.uiType == 0 ? R$layout.voice_match_prop_info_layout : R$layout.voice_match_prop_info_layout_video, this);
        this.btn = (TextView) viewInflate.findViewById(R$id.btn);
        this.fastLayout = viewInflate.findViewById(R$id.fastLayout);
        this.fastPrice = (TextView) viewInflate.findViewById(R$id.fastPrice);
        this.fastRemainCount = (TextView) viewInflate.findViewById(R$id.fastRemainCount);
        this.fastDes = (TextView) viewInflate.findViewById(R$id.fastDes);
        this.fastCheck = (ImageView) viewInflate.findViewById(R$id.fastCheck);
        this.fastTitle = (TextView) viewInflate.findViewById(R$id.fast_title_tv);
        this.cityLayout = viewInflate.findViewById(R$id.cityLayout);
        this.cityPrice = (TextView) viewInflate.findViewById(R$id.cityPrice);
        this.cityRemainCount = (TextView) viewInflate.findViewById(R$id.cityRemainCount);
        this.cityDes = (TextView) viewInflate.findViewById(R$id.cityDes);
        this.cityCheck = (ImageView) viewInflate.findViewById(R$id.cityCheck);
        this.cityTitle = (TextView) viewInflate.findViewById(R$id.city_title_tv);
        this.btn.setOnClickListener(this);
        this.fastLayout.setOnClickListener(this);
        this.cityLayout.setOnClickListener(this);
    }

    private void updateMatchType() {
        String str;
        VoiceMatchType voiceMatchType = this.mCurrentVoiceMatchType;
        VoiceMatchType voiceMatchType2 = VoiceMatchType.NORMAL;
        if (voiceMatchType == voiceMatchType2) {
            ImageView imageView = this.fastCheck;
            int i = R$drawable.ic_voice_match_prop_unselect;
            imageView.setImageResource(i);
            this.cityCheck.setImageResource(i);
            SkuItem skuItem = this.info.getSkuItem(voiceMatchType2);
            if (skuItem == null || !this.isVoice) {
                str = "继续匹配";
            } else if (skuItem.remainingQuantity > 0) {
                str = "继续匹配（剩余" + skuItem.remainingQuantity + "次)";
            } else {
                str = "继续匹配（剩余" + skuItem.remainingQuantity + "次)";
            }
        } else if (voiceMatchType == VoiceMatchType.FAST) {
            this.fastCheck.setImageResource(R$drawable.ic_voice_match_prop_select);
            this.cityCheck.setImageResource(R$drawable.ic_voice_match_prop_unselect);
            str = "继续加速匹配";
        } else if (voiceMatchType == VoiceMatchType.SAME_CITY) {
            this.fastCheck.setImageResource(R$drawable.ic_voice_match_prop_unselect);
            this.cityCheck.setImageResource(R$drawable.ic_voice_match_prop_select);
            str = "继续同城匹配";
        } else {
            str = null;
        }
        this.btn.setText(str);
        if (this.uiType == 0) {
            this.btn.setTextColor(Color.parseColor("#FE7FCD"));
        } else {
            this.btn.setTextColor(Color.parseColor("#FFFFFF"));
        }
        this.btn.setEnabled(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceMatchInfo voiceMatchInfo;
        if (view == this.btn && (voiceMatchInfo = this.info) != null) {
            if (this.onMatchClickListener != null) {
                VoiceMatchType voiceMatchType = VoiceMatchType.NORMAL;
                SkuItem skuItem = voiceMatchInfo.getSkuItem(voiceMatchType);
                if (skuItem == null || skuItem.remainingQuantity > 0 || this.mCurrentVoiceMatchType != voiceMatchType || !this.isVoice) {
                    this.onMatchClickListener.a(this.mCurrentVoiceMatchType);
                    return;
                } else {
                    sy5.h(getContext(), "今日次数已用完，加速卡可获得额外次数哦～", 1);
                    return;
                }
            }
            return;
        }
        if (view == this.fastLayout) {
            VoiceMatchType voiceMatchType2 = this.mCurrentVoiceMatchType;
            VoiceMatchType voiceMatchType3 = VoiceMatchType.FAST;
            if (voiceMatchType2 == voiceMatchType3) {
                this.mCurrentVoiceMatchType = VoiceMatchType.NORMAL;
            } else {
                this.mCurrentVoiceMatchType = voiceMatchType3;
            }
            updateMatchType();
            return;
        }
        if (view == this.cityLayout) {
            VoiceMatchType voiceMatchType4 = this.mCurrentVoiceMatchType;
            VoiceMatchType voiceMatchType5 = VoiceMatchType.SAME_CITY;
            if (voiceMatchType4 == voiceMatchType5) {
                this.mCurrentVoiceMatchType = VoiceMatchType.NORMAL;
            } else {
                this.mCurrentVoiceMatchType = voiceMatchType5;
            }
            updateMatchType();
        }
    }

    public void setMatchClick(op2 op2Var) {
        this.onMatchClickListener = op2Var;
    }

    public void setVoiceType(boolean z) {
        this.isVoice = z;
    }

    public void updateUI(VoiceMatchInfo voiceMatchInfo) {
        LogUtil.i("MatchPropInfoCardView", "updateUI =" + az2.c(voiceMatchInfo));
        this.info = voiceMatchInfo;
        VoiceMatchType voiceMatchType = VoiceMatchType.SAME_CITY;
        SkuItem skuItem = voiceMatchInfo.getSkuItem(voiceMatchType);
        SkuItem skuItem2 = voiceMatchInfo.getSkuItem(VoiceMatchType.FAST);
        this.cityLayout.setVisibility(skuItem != null ? 0 : 8);
        if (skuItem != null) {
            this.cityPrice.setText(String.valueOf(skuItem.price));
            if (skuItem.remainingQuantity > 0) {
                this.cityPrice.getPaint().setFlags(this.cityPrice.getPaintFlags() | 16 | 1);
            }
            if (skuItem.remainingQuantity > 0) {
                this.cityRemainCount.setVisibility(0);
                this.cityRemainCount.setText("剩余" + skuItem.remainingQuantity + "次");
            } else {
                this.cityRemainCount.setVisibility(8);
            }
            TextView textView = this.cityTitle;
            if (textView != null) {
                textView.setText(skuItem.name);
            }
            this.cityDes.setText(skuItem.description);
        }
        if (skuItem2 != null) {
            this.fastPrice.setText(String.valueOf(skuItem2.price));
            if (skuItem2.remainingQuantity > 0) {
                this.fastPrice.getPaint().setFlags(this.fastPrice.getPaintFlags() | 16 | 1);
            }
            if (skuItem2.remainingQuantity > 0) {
                this.fastRemainCount.setVisibility(0);
                this.fastRemainCount.setText("剩余" + skuItem2.remainingQuantity + "次");
            } else {
                this.fastRemainCount.setVisibility(8);
            }
            TextView textView2 = this.fastTitle;
            if (textView2 != null) {
                textView2.setText(skuItem2.name);
            }
            this.fastDes.setText(skuItem2.description);
        }
        VoiceMatchConfig.AutoCheck autoCheck = ap3.a().T().i().autoCheck;
        if (autoCheck == null || !autoCheck.autoCheck) {
            this.mCurrentVoiceMatchType = VoiceMatchType.NORMAL;
        } else {
            this.mCurrentVoiceMatchType = VoiceMatchType.buildFromType(autoCheck.autoCheckType);
        }
        if (skuItem == null && this.mCurrentVoiceMatchType == voiceMatchType) {
            this.mCurrentVoiceMatchType = VoiceMatchType.NORMAL;
        }
        updateMatchType();
    }

    public MatchPropInfoCardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MatchPropInfoCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentVoiceMatchType = VoiceMatchType.NORMAL;
        this.isVoice = true;
        this.uiType = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MatchPropInfoCardView);
            int i2 = typedArrayObtainStyledAttributes.getInt(R$styleable.MatchPropInfoCardView_match_ui_type, 0);
            this.uiType = i2;
            this.isVoice = i2 == 0;
            typedArrayObtainStyledAttributes.recycle();
        }
        initViews();
    }
}
