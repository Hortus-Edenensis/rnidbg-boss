package com.zenmen.square.mvp.holder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.WaveViewNew;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.superexposee.squaretab.SuperExposeSquareBean;
import com.zenmen.square.superexposee.squaretab.SuperExposeSquareRequestInfo;
import defpackage.ac1;
import defpackage.bj5;
import defpackage.dn0;
import defpackage.fk2;
import defpackage.gr2;
import defpackage.je1;
import defpackage.l50;
import defpackage.me1;
import defpackage.n5;
import defpackage.v4;
import defpackage.zn5;
import defpackage.zn6;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SuperExposeSquareHolder extends BaseViewHolder {
    public Activity f;
    public int g;
    public RecyclerView h;
    public TextView i;
    public a j;
    public je1 k;
    public HashMap<String, String> l;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RecyclerView.Adapter<b> {
        public List<SuperExposeSquareBean> e = null;

        /* JADX INFO: renamed from: com.zenmen.square.mvp.holder.SuperExposeSquareHolder$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class ViewOnClickListenerC1160a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f16452a;

            public ViewOnClickListenerC1160a(b bVar) {
                this.f16452a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l50.a()) {
                    return;
                }
                a.this.g(this.f16452a.getLayoutPosition());
            }
        }

        public a() {
        }

        public void b(b bVar) {
            SuperExposeSquareBean superExposeSquareBean;
            if (l50.a()) {
                return;
            }
            int layoutPosition = bVar.getLayoutPosition();
            List<SuperExposeSquareBean> list = this.e;
            if (list == null || list.size() <= layoutPosition || (superExposeSquareBean = this.e.get(layoutPosition)) == null || TextUtils.isEmpty(superExposeSquareBean.uid)) {
                return;
            }
            SuperExposeSquareHolder superExposeSquareHolder = SuperExposeSquareHolder.this;
            superExposeSquareHolder.r("boost_square_promotion_buttonClick", v4.e(superExposeSquareHolder.f));
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            contactInfoItem.setUid(superExposeSquareBean.uid);
            contactInfoItem.setIconURL(superExposeSquareBean.avatar);
            contactInfoItem.setNickName(superExposeSquareBean.nickname);
            contactInfoItem.setSourceType(60);
            contactInfoItem.setBizType(bj5.b().a().u(superExposeSquareBean.getChatBizType()));
            bj5.b().a().j(SuperExposeSquareHolder.this.f, contactInfoItem, 1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<SuperExposeSquareBean> list = this.e;
            if (list != null) {
                bVar.l(list.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View viewInflate = LayoutInflater.from(SuperExposeSquareHolder.this.f).inflate(R$layout.super_expose_square_tab_item, viewGroup, false);
            b bVar = SuperExposeSquareHolder.this.new b(viewInflate, this);
            viewInflate.setOnClickListener(new ViewOnClickListenerC1160a(bVar));
            return bVar;
        }

        public void f(List<SuperExposeSquareBean> list) {
            this.e = list;
        }

        public final void g(int i) {
            SuperExposeSquareBean superExposeSquareBean;
            List<SuperExposeSquareBean> list = this.e;
            if (list == null || list.size() <= i || (superExposeSquareBean = this.e.get(i)) == null || TextUtils.isEmpty(superExposeSquareBean.uid)) {
                return;
            }
            SuperExposeSquareHolder superExposeSquareHolder = SuperExposeSquareHolder.this;
            superExposeSquareHolder.r("boost_square_promotion_profileClick", v4.e(superExposeSquareHolder.f));
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            Bundle bundle = new Bundle();
            fk2.a aVar = new fk2.a();
            contactInfoItem.setUid(superExposeSquareBean.uid);
            contactInfoItem.setIconURL(superExposeSquareBean.avatar);
            contactInfoItem.setNickName(superExposeSquareBean.nickname);
            contactInfoItem.setSourceType(60);
            contactInfoItem.setBizType(bj5.b().a().u(superExposeSquareBean.getChatBizType()));
            bundle.putInt("from", 79);
            bundle.putParcelable("user_item_info", contactInfoItem);
            aVar.b(bundle);
            Intent intentA = n5.a(SuperExposeSquareHolder.this.f, aVar);
            intentA.putExtra("superExposeMsgTabItem", 1);
            if (!(SuperExposeSquareHolder.this.f instanceof Activity)) {
                intentA.addFlags(268435456);
            }
            SuperExposeSquareHolder.this.f.startActivity(intentA);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<SuperExposeSquareBean> list = this.e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.ViewHolder {
        public EffectiveShapeView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;
        public View i;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SuperExposeSquareHolder f16453a;
            public final /* synthetic */ a b;

            public a(SuperExposeSquareHolder superExposeSquareHolder, a aVar) {
                this.f16453a = superExposeSquareHolder;
                this.b = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.b.b(b.this);
            }
        }

        public b(@NonNull View view, a aVar) {
            super(view);
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) view.findViewById(R$id.super_expose_square_header_icon);
            this.d = effectiveShapeView;
            effectiveShapeView.setBorderWidth(me1.b(SuperExposeSquareHolder.this.f, 1));
            this.d.setBorderColor(Color.parseColor("#FFFFFF"));
            ((WaveViewNew) view.findViewById(R$id.wave_views)).start();
            this.e = (TextView) view.findViewById(R$id.super_expose_msg_tab_c_item_status_title);
            this.i = view.findViewById(R$id.super_expose_msg_tab_item_status_title_layout);
            this.f = (TextView) view.findViewById(R$id.super_expose_square_tab_name_title);
            this.g = (TextView) view.findViewById(R$id.super_expose_square_config1);
            this.h = (TextView) view.findViewById(R$id.super_expose_square_config2);
            this.f.setOnClickListener(new a(SuperExposeSquareHolder.this, aVar));
        }

        public void l(SuperExposeSquareBean superExposeSquareBean) {
            if (superExposeSquareBean == null) {
                return;
            }
            String str = superExposeSquareBean.avatar;
            if (!TextUtils.isEmpty(str) && this.d != null) {
                gr2.j().h(str, this.d, SuperExposeSquareHolder.this.k);
            }
            String str2 = superExposeSquareBean.tagName;
            if (TextUtils.isEmpty(str2)) {
                View view = this.i;
                if (view != null) {
                    view.setVisibility(8);
                }
            } else {
                View view2 = this.i;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                TextView textView = this.e;
                if (textView != null) {
                    textView.setText(str2);
                }
            }
            String str3 = superExposeSquareBean.nickname;
            if (!TextUtils.isEmpty(str3)) {
                this.g.setText(str3);
            }
            String str4 = superExposeSquareBean.squareText;
            if (!TextUtils.isEmpty(str4)) {
                this.h.setText(str4);
            }
            String str5 = superExposeSquareBean.squareButtonText;
            if (TextUtils.isEmpty(str5)) {
                return;
            }
            this.f.setText(str5);
        }
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void l(BaseBean baseBean, int i) {
        String str;
        ContactInfoItem contactInfoItemA;
        List<SuperExposeSquareBean> list;
        this.g = i;
        if (baseBean instanceof SquareFeed) {
            SquareFeed squareFeed = (SquareFeed) baseBean;
            SuperExposeSquareRequestInfo superExposeSquareRequestInfo = squareFeed.superExposeSquareInfo;
            if (superExposeSquareRequestInfo == null || (list = superExposeSquareRequestInfo.dataList) == null || list.size() <= 0) {
                str = "";
            } else {
                str = "";
                for (int i2 = 0; i2 < superExposeSquareRequestInfo.dataList.size(); i2++) {
                    str = str + superExposeSquareRequestInfo.dataList.get(i2).uid;
                    if (i2 != superExposeSquareRequestInfo.dataList.size() - 1) {
                        str = str + ",";
                    }
                }
            }
            if (!this.l.containsKey(str)) {
                this.l.put(str, "");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EventParams.KEY_CT_SDK_POSITION, zn5.f22460a);
                    jSONObject.put("showuid", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                zn6.g("boost_square_promotion_show", jSONObject);
            }
            if (superExposeSquareRequestInfo != null) {
                if (this.i == null) {
                    this.i = (TextView) this.itemView.findViewById(R$id.super_expose_square_title_text);
                }
                String strE = v4.e(c.b());
                this.i.setText((TextUtils.isEmpty(strE) || (contactInfoItemA = dn0.a(strE)) == null || contactInfoItemA.getGender() != 1) ? "她们正在找人聊天" : "他们正在找人聊天");
                List<SuperExposeSquareBean> list2 = squareFeed.superExposeSquareInfo.dataList;
                if (list2 != null) {
                    if (this.j == null) {
                        this.j = new a();
                    }
                    this.j.f(list2);
                    if (this.h != null) {
                        this.j.notifyDataSetChanged();
                        return;
                    }
                    this.h = (RecyclerView) this.itemView.findViewById(R$id.super_expose_square_recycler);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f);
                    linearLayoutManager.setOrientation(1);
                    this.h.setLayoutManager(linearLayoutManager);
                    this.h.setAdapter(this.j);
                }
            }
        }
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ((ViewGroup) this.itemView).addView(LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.super_expose_layout_square_view, (ViewGroup) this.itemView, false));
    }

    public final void r(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, str2);
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(EventParams.KEY_CT_SDK_POSITION, zn5.f22460a);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.g(str, jSONObject);
    }
}
