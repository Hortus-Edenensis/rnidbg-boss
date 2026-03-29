package com.zenmen.palmchat.gift;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.gift.bean.GiftPanelBean;
import defpackage.bo0;
import defpackage.ds0;
import defpackage.fa2;
import defpackage.fg6;
import defpackage.hc2;
import defpackage.l50;
import defpackage.sd3;
import defpackage.zn6;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GiftPanlAdapter extends RecyclerView.Adapter<b> {
    public List<GiftPanelBean> e;
    public Context f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f14058a;

        /* JADX INFO: renamed from: com.zenmen.palmchat.gift.GiftPanlAdapter$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1053a extends MaterialDialog.e {
            public C1053a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends MaterialDialog.e {
            public b() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        public a(b bVar) {
            this.f14058a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            GiftPanelBean giftPanelBean = (GiftPanelBean) GiftPanlAdapter.this.e.get(this.f14058a.getAdapterPosition());
            if (!giftPanelBean.enable) {
                new sd3(GiftPanlAdapter.this.f).k("礼物即将上线，敬请期待~").n(GravityEnum.CENTER).O(R.string.alert_dialog_i_knoW).f(new b()).e().show();
            } else if (!giftPanelBean.vip) {
                fa2 fa2Var = new fa2(1);
                fa2Var.d = 12;
                ds0.a().b(fa2Var);
            } else if (giftPanelBean.balance > 0) {
                fa2 fa2Var2 = new fa2(2, giftPanelBean.giftId);
                fa2Var2.c = 2;
                ds0.a().b(fa2Var2);
            } else {
                new sd3(GiftPanlAdapter.this.f).k("今天礼物已用完，明天送给TA吧~").n(GravityEnum.CENTER).O(R.string.alert_dialog_i_knoW).f(new C1053a()).e().show();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()));
                jSONObject.put("report_type", "click");
                jSONObject.put("giftId", giftPanelBean.giftId);
                if (contactInfoItemL != null) {
                    jSONObject.put("vip_status", fg6.g(contactInfoItemL.getExt()));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("pagechat_giftbox", null, jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.ViewHolder {
        public ImageView d;
        public ImageView e;
        public TextView f;
        public TextView g;
        public View h;

        public b(@NonNull View view) {
            super(view);
            this.h = view;
            this.d = (ImageView) view.findViewById(R.id.iv_gift_icon);
            this.e = (ImageView) view.findViewById(R.id.iv_vip);
            this.f = (TextView) view.findViewById(R.id.tv_gift_name);
            this.g = (TextView) view.findViewById(R.id.tv_gift_tip);
        }

        public void m(GiftPanelBean giftPanelBean) {
            this.f.setText(giftPanelBean.giftName);
            hc2.a(GiftPanlAdapter.this.f).load(giftPanelBean.giftPic).error(R.drawable.ic_gift_default).into(this.d);
            if (!giftPanelBean.enable || TextUtils.isEmpty(giftPanelBean.oneLocationPic)) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                hc2.a(GiftPanlAdapter.this.f).load(giftPanelBean.oneLocationPic).error(R.drawable.ic_gift_vip).into(this.e);
            }
            if (!giftPanelBean.enable) {
                this.g.setText(giftPanelBean.desc);
                return;
            }
            this.g.setText("今日剩余：" + giftPanelBean.balance);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i) {
        bVar.m(this.e.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gift_pan_layout, (ViewGroup) null));
        bVar.h.setOnClickListener(new a(bVar));
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<GiftPanelBean> list = this.e;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.e.size();
    }
}
