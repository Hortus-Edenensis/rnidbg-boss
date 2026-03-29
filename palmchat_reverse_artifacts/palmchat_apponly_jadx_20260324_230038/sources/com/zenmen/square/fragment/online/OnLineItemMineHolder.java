package com.zenmen.square.fragment.online;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.widget.LightingAnimationView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import defpackage.hc2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OnLineItemMineHolder extends OnLineItemBaseHolder {
    public OnLineMineLightLayout k;
    public LightingAnimationView l;

    public OnLineItemMineHolder(@NonNull View view, Activity activity) {
        super(view, activity);
        this.k = (OnLineMineLightLayout) view.findViewById(R$id.mine_light_layout);
        LightingAnimationView lightingAnimationView = (LightingAnimationView) view.findViewById(R$id.mine_light_anim);
        this.l = lightingAnimationView;
        lightingAnimationView.setRemoveCancelAnim(true);
    }

    public void l(OnLineItemData onLineItemData) {
        if (onLineItemData != null) {
            this.d = onLineItemData;
            if (TextUtils.isEmpty(onLineItemData.avatar)) {
                this.g.setImageResource(R$drawable.default_portrait);
            } else {
                hc2.a(this.e).load(this.d.avatar).error(R$drawable.default_portrait).into(this.g);
            }
            if (TextUtils.isEmpty(this.d.url)) {
                this.h.setImageResource(R$drawable.online_status_msg_bg);
            } else {
                hc2.a(this.e).load(this.d.url).error(R$drawable.online_status_msg_bg).into(this.h);
            }
            if (TextUtils.isEmpty(this.d.content)) {
                this.i.setText("来个人陪我聊聊天");
            } else {
                this.i.setText(this.d.content);
            }
            OnLineItemData onLineItemData2 = this.d;
            if (onLineItemData2.hasMineAnim) {
                return;
            }
            this.k.setMineLightAnimView(this.l, onLineItemData2);
        }
    }
}
