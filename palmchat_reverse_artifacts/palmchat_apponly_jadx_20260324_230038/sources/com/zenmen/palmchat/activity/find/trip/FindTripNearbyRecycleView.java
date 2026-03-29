package com.zenmen.palmchat.activity.find.trip;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.find.bean.LoadCountBean;
import com.zenmen.listui.list.BaseRecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import defpackage.bj5;
import defpackage.cw1;
import defpackage.cy5;
import defpackage.ew1;
import defpackage.hc2;
import defpackage.k86;
import defpackage.l50;
import defpackage.rw1;
import defpackage.vc3;
import defpackage.y5;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FindTripNearbyRecycleView extends BaseRecyclerView {
    private String chatText;
    private Activity mAct;
    private Context mContext;
    private String nameTag;
    private a recordAdapter;
    private List<rw1> showData;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BaseRecyclerViewAdapter<rw1> {
        public a(@NonNull Context context, @NonNull List<rw1> list) {
            super(context, list);
        }

        @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
        public int g(int i) {
            return 0;
        }

        @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
        public BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i) {
            if (i == 0) {
                return FindTripNearbyRecycleView.this.new b(viewGroup.getContext(), viewGroup, R.layout.layout_map_trip_nearby_view);
            }
            return null;
        }

        @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public int i(int i, @NonNull rw1 rw1Var) {
            return 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BaseRecyclerViewHolder<rw1> {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rw1 f12269a;

            public a(rw1 rw1Var) {
                this.f12269a = rw1Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l50.a()) {
                    return;
                }
                b.this.s(this.f12269a);
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.activity.find.trip.FindTripNearbyRecycleView$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class ViewOnClickListenerC0958b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rw1 f12270a;

            public ViewOnClickListenerC0958b(rw1 rw1Var) {
                this.f12270a = rw1Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l50.a()) {
                    return;
                }
                b.this.s(this.f12270a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LoadCountBean.MarkerBean f12271a;

            public c(LoadCountBean.MarkerBean markerBean) {
                this.f12271a = markerBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l50.a()) {
                    return;
                }
                ew1.l0();
                ew1.e0(b.this.m(), this.f12271a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LoadCountBean.MarkerBean f12272a;

            public d(LoadCountBean.MarkerBean markerBean) {
                this.f12272a = markerBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l50.a()) {
                    return;
                }
                ew1.k0();
                ew1.f0(this.f12272a, FindTripNearbyRecycleView.this.mAct);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class e implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rw1 f12273a;

            public e(rw1 rw1Var) {
                this.f12273a = rw1Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l50.a()) {
                    return;
                }
                b.this.s(this.f12273a);
            }
        }

        public b(Context context, ViewGroup viewGroup, int i) {
            super(context, viewGroup, i);
        }

        public final void s(rw1 rw1Var) {
            if ("allTag".equals(FindTripNearbyRecycleView.this.nameTag)) {
                ew1.n0(1);
            } else {
                ew1.n0(2);
            }
            new cw1(FindTripNearbyRecycleView.this.mAct, rw1Var.a(), 2).show();
        }

        @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void o(rw1 rw1Var, int i) {
            try {
                LoadCountBean.MarkerBean markerBeanA = rw1Var.a();
                ImageView imageView = (ImageView) l(R.id.trip_holder_icon_img);
                imageView.setOnClickListener(new a(rw1Var));
                String str = markerBeanA.avatar;
                boolean zN = bj5.b().a().n(markerBeanA.uid + "", markerBeanA.scheduleOrderId);
                if (TextUtils.isEmpty(str)) {
                    imageView.setImageResource(R.drawable.default_portrait);
                } else if (zN) {
                    imageView.setImageResource(R.drawable.default_portrait);
                    hc2.a(FindTripNearbyRecycleView.this.mContext).load(k86.p(str)).placeholder(R.drawable.default_portrait).transform(new y5(10, 1)).into(imageView);
                } else {
                    hc2.a(FindTripNearbyRecycleView.this.mContext).load(str).placeholder(R.drawable.default_portrait).into(imageView);
                }
                TextView textView = (TextView) l(R.id.square_holder_trip_nick_name);
                textView.setOnClickListener(new ViewOnClickListenerC0958b(rw1Var));
                if (TextUtils.isEmpty(markerBeanA.nickname)) {
                    textView.setText("一只小透明");
                } else {
                    textView.setText(markerBeanA.nickname);
                }
                ImageView imageView2 = (ImageView) l(R.id.square_holder_trip_gender_icon);
                if (markerBeanA.gender == 1) {
                    imageView2.setImageResource(R.drawable.light_type_female_bg);
                } else {
                    imageView2.setImageResource(R.drawable.light_type_male_bg);
                }
                TextView textView2 = (TextView) l(R.id.square_holder_trip_desc);
                long j = markerBeanA.createTime;
                if (j > 0) {
                    textView2.setText(cy5.g(j) + " · 发布了行程");
                } else {
                    textView2.setText("10分钟之前 · 发布了行程");
                }
                View viewL = l(R.id.layout_feed_meet);
                View viewL2 = l(R.id.trip_map_other_chat_button);
                if (zN) {
                    viewL2.setVisibility(0);
                    viewL.setVisibility(8);
                    TextView textView3 = (TextView) l(R.id.trip_map_other_chat_text);
                    TextView textView4 = (TextView) l(R.id.trip_map_other_chat_pay);
                    textView3.setText(FindTripNearbyRecycleView.this.chatText);
                    if (vc3.b()) {
                        textView4.setText("(" + vc3.c + ")");
                    } else if (!TextUtils.isEmpty(ew1.g)) {
                        textView4.setText("(" + ew1.g + ")");
                    }
                    viewL2.setOnClickListener(new c(markerBeanA));
                } else {
                    viewL2.setVisibility(8);
                    viewL.setVisibility(0);
                    viewL.setOnClickListener(new d(markerBeanA));
                }
                l(R.id.square_trip_info_layout).setOnClickListener(new e(rw1Var));
                View viewL3 = l(R.id.trip_map_mine_time_layout);
                if (markerBeanA.scheduleMomentTsV2 > 0) {
                    viewL3.setVisibility(0);
                    ((TextView) l(R.id.trip_map_mine_time_title)).setText(ew1.E(markerBeanA.scheduleMomentTsV2));
                } else {
                    viewL3.setVisibility(8);
                }
                TextView textView5 = (TextView) l(R.id.trip_map_mine_distance_title);
                if (TextUtils.isEmpty(markerBeanA.distanceMi)) {
                    textView5.setText("");
                } else {
                    textView5.setText(markerBeanA.distanceMi + "km");
                }
                TextView textView6 = (TextView) l(R.id.trip_map_mine_location_title);
                String str2 = markerBeanA.scheduleAddress;
                if (TextUtils.isEmpty(str2)) {
                    textView6.setText("盛大天地");
                } else {
                    textView6.setText(str2);
                }
                TextView textView7 = (TextView) l(R.id.trip_map_mine_tag_title);
                String tripTag = markerBeanA.getTripTag();
                if (TextUtils.isEmpty(tripTag)) {
                    textView7.setText("约逛街");
                } else {
                    textView7.setText(tripTag);
                }
            } catch (Exception unused) {
            }
        }
    }

    public FindTripNearbyRecycleView(@NonNull Context context) {
        super(context);
        this.mContext = null;
        this.nameTag = "";
        this.showData = new ArrayList();
        this.recordAdapter = null;
        this.chatText = "";
        this.mAct = null;
        initView();
    }

    private void initView() {
        this.mContext = getContext();
    }

    public void addNewData(LoadCountBean.MarkerBean markerBean) {
        if (markerBean != null) {
            rw1 rw1Var = new rw1();
            rw1Var.b(markerBean);
            if (this.recordAdapter.f() != null) {
                this.recordAdapter.f().add(0, rw1Var);
                this.recordAdapter.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        List<rw1> list = this.showData;
        if (list != null) {
            list.clear();
        }
        this.mAct = null;
    }

    public void removeErrorData(LoadCountBean.MarkerBean markerBean) {
        rw1 rw1Var;
        if (markerBean != null) {
            int i = 0;
            while (true) {
                if (i >= this.showData.size()) {
                    rw1Var = null;
                    break;
                } else {
                    if (this.showData.get(i).a() == markerBean) {
                        rw1Var = this.showData.get(i);
                        break;
                    }
                    i++;
                }
            }
            if (rw1Var == null || this.recordAdapter.f() == null || !this.recordAdapter.f().contains(rw1Var)) {
                return;
            }
            this.recordAdapter.f().remove(rw1Var);
            this.recordAdapter.notifyDataSetChanged();
        }
    }

    public void setData(List<LoadCountBean.MarkerBean> list, String str, String str2, Activity activity) {
        this.chatText = str;
        this.nameTag = str2;
        this.mAct = activity;
        if (list != null) {
            int size = list.size();
            if (size > 200) {
                size = 200;
            }
            for (int i = 0; i < size; i++) {
                rw1 rw1Var = new rw1();
                rw1Var.b(list.get(i));
                this.showData.add(rw1Var);
            }
            a aVar = new a(this.mContext, new ArrayList());
            this.recordAdapter = aVar;
            setAdapter(aVar);
            this.recordAdapter.q(this.showData);
        }
    }

    public void updateData() {
        this.recordAdapter.notifyDataSetChanged();
    }

    public FindTripNearbyRecycleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.nameTag = "";
        this.showData = new ArrayList();
        this.recordAdapter = null;
        this.chatText = "";
        this.mAct = null;
        initView();
    }

    public FindTripNearbyRecycleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.nameTag = "";
        this.showData = new ArrayList();
        this.recordAdapter = null;
        this.chatText = "";
        this.mAct = null;
        initView();
    }
}
