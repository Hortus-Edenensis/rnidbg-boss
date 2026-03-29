package com.zenmen.palmchat.adapter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.location.LocationConst;
import com.ss.android.ttvecamera.BuildConfig;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.ContactExtBean;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.widget.LXPortraitView;
import com.zenmen.square.mvp.model.bean.NearByBean;
import com.zenmen.square.ui.widget.NearByFeedContainer;
import defpackage.bj5;
import defpackage.fg6;
import defpackage.hs1;
import defpackage.q05;
import defpackage.ro2;
import defpackage.sy5;
import defpackage.v8;
import defpackage.z66;
import defpackage.zn6;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserRecommendRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<NearByBean> e;
    public Context f;
    public View g;

    /* JADX INFO: compiled from: SearchBox */
    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(@NonNull View view) {
            super(view);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public LXPortraitView d;
        public ImageView e;
        public ImageView f;
        public TextView g;
        public TextView h;
        public TextView i;
        public TextView j;
        public TextView k;
        public TextView l;
        public LeftDrawableText m;
        public NearByFeedContainer n;
        public View o;

        public MyViewHolder(@NonNull View view) {
            super(view);
            this.d = (LXPortraitView) view.findViewById(R.id.head_img);
            this.e = (ImageView) view.findViewById(R.id.sex_image);
            this.g = (TextView) view.findViewById(R.id.nickname);
            this.h = (TextView) view.findViewById(R.id.profile);
            this.i = (TextView) view.findViewById(R.id.desc);
            this.j = (TextView) view.findViewById(R.id.distance);
            this.k = (TextView) view.findViewById(R.id.status);
            this.f = (ImageView) view.findViewById(R.id.iv_vip);
            this.m = (LeftDrawableText) view.findViewById(R.id.btn_say_hi);
            this.l = (TextView) view.findViewById(R.id.tv_official);
            this.o = view.findViewById(R.id.feed_list_layout);
            this.n = (NearByFeedContainer) view.findViewById(R.id.ll_feed_pic_container);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NearByBean f12467a;

        /* JADX INFO: renamed from: com.zenmen.palmchat.adapter.UserRecommendRecycleAdapter$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0968a implements ro2.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FrameworkBaseActivity f12468a;

            public C0968a(FrameworkBaseActivity frameworkBaseActivity) {
                this.f12468a = frameworkBaseActivity;
            }

            @Override // ro2.b
            public void a(ContactInfoItem contactInfoItem) {
                FrameworkBaseActivity frameworkBaseActivity = this.f12468a;
                if (frameworkBaseActivity != null) {
                    frameworkBaseActivity.hideBaseProgressBar();
                }
                if (contactInfoItem != null) {
                    a aVar = a.this;
                    UserRecommendRecycleAdapter userRecommendRecycleAdapter = UserRecommendRecycleAdapter.this;
                    NearByBean nearByBean = aVar.f12467a;
                    userRecommendRecycleAdapter.g(contactInfoItem, nearByBean.imprId, nearByBean);
                }
            }

            @Override // ro2.b
            public void onError(String str) {
                FrameworkBaseActivity frameworkBaseActivity = this.f12468a;
                if (frameworkBaseActivity != null) {
                    frameworkBaseActivity.hideBaseProgressBar();
                }
                Application applicationB = c.b();
                if (applicationB != null) {
                    sy5.f(applicationB, applicationB.getString(R.string.get_user_info_failed), 0).g();
                }
            }
        }

        public a(NearByBean nearByBean) {
            this.f12467a = nearByBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrameworkBaseActivity frameworkBaseActivity = (FrameworkBaseActivity) UserRecommendRecycleAdapter.this.f;
            if (frameworkBaseActivity != null) {
                frameworkBaseActivity.showBaseProgressBar("", false);
            }
            bj5.b().a().q(this.f12467a.exid, new C0968a(frameworkBaseActivity));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NearByBean f12469a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("tuid", b.this.f12469a.exid);
                put("gender", Integer.valueOf(b.this.f12469a.gender));
                NearByBean.Extra extra = b.this.f12469a.extra;
                if (extra != null) {
                    put("introtype", Integer.valueOf(extra.type));
                }
                put("distance", Long.valueOf(b.this.f12469a.distance));
                put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, b.this.f12469a.onlineStatusCode == 1 ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
                put("page", Integer.valueOf(b.this.f12469a.page));
                put("order", Integer.valueOf(b.this.f12469a.pos));
                put("impr_id", b.this.f12469a.imprId);
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.adapter.UserRecommendRecycleAdapter$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0969b implements ro2.b {
            public C0969b() {
            }

            @Override // ro2.b
            public void a(ContactInfoItem contactInfoItem) {
                if (contactInfoItem == null) {
                    b bVar = b.this;
                    UserRecommendRecycleAdapter.this.e(bVar.f12469a, 86, 5032);
                    return;
                }
                b bVar2 = b.this;
                if (UserRecommendRecycleAdapter.this.f(contactInfoItem, bVar2.f12469a)) {
                    b bVar3 = b.this;
                    UserRecommendRecycleAdapter.this.e(bVar3.f12469a, 105, 5063);
                } else {
                    b bVar4 = b.this;
                    UserRecommendRecycleAdapter.this.e(bVar4.f12469a, 86, 5032);
                }
            }

            @Override // ro2.b
            public void onError(String str) {
                b bVar = b.this;
                UserRecommendRecycleAdapter.this.e(bVar.f12469a, 86, 5032);
            }
        }

        public b(NearByBean nearByBean) {
            this.f12469a = nearByBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.j("pagemsg_newfrd_recommend_contentclick", "click", new a());
            if (v8.h()) {
                bj5.b().a().q(this.f12469a.exid, new C0969b());
            } else {
                UserRecommendRecycleAdapter.this.e(this.f12469a, 86, 5032);
            }
        }
    }

    public UserRecommendRecycleAdapter(List<NearByBean> list, Context context, View view) {
        this.e = list;
        this.f = context;
        this.g = view;
    }

    public final void e(NearByBean nearByBean, int i, int i2) {
        z66.f("", nearByBean.exid, nearByBean.gender, 60, i2, i, this.f);
    }

    public final boolean f(ContactInfoItem contactInfoItem, NearByBean nearByBean) {
        if (contactInfoItem == null || !v8.C(contactInfoItem.getUid())) {
            return nearByBean != null && nearByBean.isAiChat();
        }
        return true;
    }

    public final void g(ContactInfoItem contactInfoItem, String str, NearByBean nearByBean) {
        ContactInfoItem contactInfoItemM792clone = contactInfoItem.m792clone();
        contactInfoItemM792clone.setSourceType(60);
        contactInfoItemM792clone.setBizType(5032);
        if (v8.h() && f(contactInfoItem, nearByBean)) {
            contactInfoItemM792clone.setBizType(5063);
        }
        if (contactInfoItemM792clone.getIsStranger()) {
            bj5.b().a().r((Activity) this.f, contactInfoItemM792clone, str);
        } else {
            bj5.b().a().B((Activity) this.f, contactInfoItemM792clone, "");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<NearByBean> list = this.e;
        if (list == null) {
            return 1;
        }
        return 1 + list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    public void h(TextView textView, NearByBean nearByBean) {
        if (nearByBean == null || textView == null) {
            return;
        }
        if (nearByBean.official) {
            textView.setTextColor(this.f.getResources().getColor(R.color.Gg));
        } else {
            textView.setTextColor(fg6.n(this.f, fg6.h(nearByBean.userExt)));
        }
        textView.setText(nearByBean.nickname);
    }

    public void i(TextView textView, NearByBean nearByBean) {
        StringBuilder sb = new StringBuilder();
        int i = nearByBean.age;
        if (i > 0) {
            sb.append(i);
            sb.append("岁");
        }
        if (!TextUtils.isEmpty(nearByBean.city)) {
            if (sb.length() > 0) {
                sb.append(" · ");
            }
            sb.append(nearByBean.city);
        }
        if (nearByBean.jobCode > 0) {
            String strH = hs1.e().h(nearByBean.jobCode);
            if (!TextUtils.isEmpty(strH) && !"请选择职业".equals(strH)) {
                if (sb.length() > 0) {
                    sb.append(" · ");
                }
                sb.append(strH);
            }
        }
        textView.setText(sb);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        List<NearByBean.FeedSimpleInfo> list;
        ContactExtBean contactExtBeanM;
        if (getItemViewType(i) == 1) {
            MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
            NearByBean nearByBean = this.e.get(i - 1);
            h(myViewHolder.g, nearByBean);
            q05.A(nearByBean.gender, myViewHolder.e);
            if (TextUtils.isEmpty(nearByBean.userExt) || (contactExtBeanM = q05.m(nearByBean.userExt)) == null) {
                myViewHolder.d.setAvatarView(nearByBean.avatar, null);
            } else {
                myViewHolder.d.setAvatarView(nearByBean.avatar, contactExtBeanM.getAmulet());
            }
            q05.E(myViewHolder.f, nearByBean.userExt);
            i(myViewHolder.h, nearByBean);
            TextView textView = myViewHolder.i;
            NearByBean.Extra extra = nearByBean.extra;
            if (extra == null || (str = extra.desc) == null) {
                str = "";
            }
            textView.setText(str);
            q05.x(myViewHolder.j, nearByBean.distance);
            q05.z(nearByBean.onlineStatusCode, nearByBean.onlineStatusDesc, myViewHolder.k);
            myViewHolder.l.setVisibility(nearByBean.official ? 0 : 8);
            myViewHolder.m.setOnClickListener(new a(nearByBean));
            NearByBean.Extra extra2 = nearByBean.extra;
            if (extra2 == null || (list = extra2.feedList) == null || list.size() <= 0) {
                myViewHolder.i.setVisibility(0);
            } else {
                myViewHolder.i.setVisibility(8);
            }
            myViewHolder.n.setFeedThumbnail(nearByBean);
            myViewHolder.o.setVisibility(nearByBean.extra.type == 1 ? 0 : 8);
            if (nearByBean.userType == 18) {
                myViewHolder.k.setTextColor(this.f.getResources().getColor(R.color.lite_black));
                myViewHolder.j.setTextColor(Color.parseColor("#333333"));
                myViewHolder.k.setBackgroundResource(R.drawable.bg_nearby_distance_left);
                myViewHolder.j.setBackgroundResource(R.drawable.bg_nearby_distance_right);
            } else {
                if (nearByBean.onlineStatusCode == 1) {
                    myViewHolder.k.setTextColor(this.f.getResources().getColor(R.color.Aa));
                } else {
                    myViewHolder.k.setTextColor(this.f.getResources().getColor(R.color.Gd));
                }
                myViewHolder.j.setBackgroundResource(0);
                myViewHolder.k.setBackgroundResource(0);
            }
            myViewHolder.itemView.setOnClickListener(new b(nearByBean));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return i == 0 ? new HeaderViewHolder(this.g) : new MyViewHolder(LayoutInflater.from(this.f).inflate(R.layout.user_recommend_recycleview_item, viewGroup, false));
    }
}
