package com.zenmen.palmchat.ad;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.data.NestAdData;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import defpackage.zn6;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ShakeView extends FrameLayout {
    private View mDesc;
    private AnimationDrawable mShakeDrawable;

    public ShakeView(Context context) {
        super(context);
        init(context);
    }

    public static void eventShakeShow(NestAdData nestAdData) {
        Object tag = nestAdData.getTag("ad_data_tag_key_event_shake_show");
        if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", nestAdData.getRequestId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("nest_sdk_shake_show", null, jSONObject.toString());
        nestAdData.setTag("ad_data_tag_key_event_shake_show", Boolean.TRUE);
    }

    private void init(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.frame_shake_view_content, (ViewGroup) null);
        addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.shake);
        imageView.setImageResource(R$drawable.frame_shake_view_shake_anim);
        this.mShakeDrawable = (AnimationDrawable) imageView.getDrawable();
        this.mDesc = viewInflate.findViewById(R$id.desc);
    }

    public static boolean shakeEnabled(NestAdData nestAdData) {
        if (nestAdData == null) {
            return false;
        }
        String adType = nestAdData.getAdType();
        if (SDKAlias.CSJ.getType().equals(adType)) {
            if (nestAdData.getShakeSwitch() == 1) {
                return true;
            }
        } else if (SDKAlias.LXAD.getType().equals(adType) && nestAdData.getShakeSwitchLxad() == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mShakeDrawable.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mShakeDrawable.stop();
    }

    public void setShowDesc(boolean z) {
        this.mDesc.setVisibility(z ? 0 : 8);
    }

    public ShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
