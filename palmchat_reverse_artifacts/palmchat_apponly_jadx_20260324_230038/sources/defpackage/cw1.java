package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.zenmen.find.bean.LoadCountBean;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.find.trip.FindMapTripNearbyPage;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cw1 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f16929a;
    public View b;
    public TextView c;
    public TextView d;
    public TextView e;
    public LoadCountBean.MarkerBean f;
    public ImageView g;
    public ImageView h;
    public TextView i;
    public TextView j;
    public View k;
    public TextView l;
    public Activity m;
    public TextView n;
    public TextView o;
    public TextView p;
    public int q;
    public View r;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            cw1.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            cw1.this.g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ew1.f0(cw1.this.f, cw1.this.m);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements RequestListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16933a;

        public d(String str) {
            this.f16933a = str;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target target, boolean z) {
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onResourceReady(Object obj, Object obj2, Target target, DataSource dataSource, boolean z) {
            LogUtil.d("FindMapTripManager", "FindMapOtherTripDialog onResourceReady resource " + obj);
            if (!(obj instanceof BitmapDrawable)) {
                return false;
            }
            ew1.T(this.f16933a, ((BitmapDrawable) obj).getBitmap());
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ew1.f0(cw1.this.f, cw1.this.m);
        }
    }

    public cw1(Context context, LoadCountBean.MarkerBean markerBean, int i) {
        super(context, R.style.tripFullScreenDialog);
        this.f16929a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = null;
        setCanceledOnTouchOutside(false);
        ds0.a().c(this);
        this.q = i;
        this.f = markerBean;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.map_other_trip_dialog, (ViewGroup) null);
        this.f16929a = viewGroup;
        if (context instanceof Activity) {
            this.m = (Activity) context;
        }
        if (this.q == 2) {
            viewGroup.setBackgroundColor(Color.parseColor("#b4000000"));
        }
        LogUtil.d("FindMapTripManager", "FindMapOtherTripDialog clickFrom " + this.q);
    }

    public final void d(LoadCountBean.MarkerBean markerBean) {
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Activity activity = this.m;
        if (activity instanceof FindMapTripNearbyPage) {
            ((FindMapTripNearbyPage) activity).F1();
        }
        try {
            ds0.a().d(this);
        } catch (Exception unused) {
        }
    }

    public final void e(LoadCountBean.MarkerBean markerBean) {
        hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(this.f.avatar)).placeholder(R.drawable.default_portrait).into(this.g);
        this.k.setVisibility(8);
        this.l.setVisibility(0);
        this.l.postDelayed(new e(), 200L);
    }

    public final void f() {
        View viewFindViewById = this.f16929a.findViewById(R.id.trip_release_info_time_close);
        this.b = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        this.c = (TextView) this.f16929a.findViewById(R.id.trip_map_mine_time_title);
        this.d = (TextView) this.f16929a.findViewById(R.id.trip_map_mine_location_title);
        this.r = this.f16929a.findViewById(R.id.trip_map_mine_time_layout);
        this.e = (TextView) this.f16929a.findViewById(R.id.trip_map_mine_tag_title);
        this.g = (ImageView) this.f16929a.findViewById(R.id.trip_other_icon_img);
        this.h = (ImageView) this.f16929a.findViewById(R.id.trip_other_gender_img);
        this.i = (TextView) this.f16929a.findViewById(R.id.trip_map_other_name);
        this.j = (TextView) this.f16929a.findViewById(R.id.trip_map_other_age);
        this.k = this.f16929a.findViewById(R.id.trip_map_other_chat_button);
        this.n = (TextView) this.f16929a.findViewById(R.id.trip_map_other_chat_pay);
        this.p = (TextView) this.f16929a.findViewById(R.id.trip_other_title_name);
        if (vc3.b()) {
            this.n.setText("(" + vc3.c + ")");
        } else if (!TextUtils.isEmpty(ew1.g)) {
            this.n.setText("(" + ew1.g + ")");
        }
        this.k.setOnClickListener(new b());
        this.o = (TextView) findViewById(R.id.trip_other_desc_title);
        if (!TextUtils.isEmpty(ew1.e)) {
            this.o.setText(ew1.e);
        }
        TextView textView = (TextView) this.f16929a.findViewById(R.id.trip_map_other_success_chat);
        this.l = textView;
        textView.setOnClickListener(new c());
        if (this.f != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f.uid);
            String str = "";
            sb.append("");
            boolean zH = ew1.h(sb.toString(), this.f.scheduleOrderId);
            if (!TextUtils.isEmpty(this.f.avatar)) {
                String str2 = this.f.uid + "";
                if (this.q == 1 && ew1.w(str2) == null) {
                    hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(this.f.avatar)).addListener(new d(str2)).preload();
                }
                if (zH) {
                    ew1.j(this.f.avatar, this.g);
                } else {
                    hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(this.f.avatar)).placeholder(R.drawable.default_portrait).into(this.g);
                }
            }
            int i = this.f.gender;
            if (i == 0) {
                this.h.setImageResource(R.drawable.map_sex_male);
            } else if (i == 1) {
                this.p.setText("她的行程计划");
            }
            if (!TextUtils.isEmpty(this.f.nickname)) {
                this.i.setText(this.f.nickname);
            }
            if (ew1.h0()) {
                TextView textView2 = (TextView) this.f16929a.findViewById(R.id.trip_map_mine_new_time_title);
                textView2.setVisibility(0);
                String createShow = this.f.getCreateShow();
                textView2.setText(createShow + " · 发布了行程");
                LogUtil.d("TripNearByTag", "FindMapOther timeNewTitle show resultTime " + createShow + " markerBean.scheduleMomentTsV2 " + this.f.scheduleMomentTsV2);
                long j = this.f.scheduleMomentTsV2;
                if (j > 0) {
                    this.c.setText(ew1.E(j));
                    this.r.setVisibility(0);
                } else {
                    this.r.setVisibility(8);
                }
            } else {
                String tripTime = this.f.getTripTime();
                if (!TextUtils.isEmpty(tripTime)) {
                    this.c.setText(tripTime);
                }
            }
            if (!TextUtils.isEmpty(this.f.scheduleAddress)) {
                this.d.setText(this.f.scheduleAddress);
            }
            String tripTag = this.f.getTripTag();
            if (!TextUtils.isEmpty(tripTag)) {
                this.e.setText(tripTag);
            }
            if (this.f.age > 0) {
                str = this.f.age + "岁";
            }
            if (this.f.jobCode > 0) {
                String strH = hs1.e().h(this.f.jobCode);
                if (!TextUtils.isEmpty(strH)) {
                    str = str + "·" + strH;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                this.j.setText(str);
            }
            if (zH) {
                this.l.setVisibility(8);
                this.k.setVisibility(0);
            } else {
                this.l.setVisibility(0);
                this.k.setVisibility(8);
            }
        }
    }

    public final void g() {
        zn6.b("page_mapfinder_itinerary_detail_unlock");
        ew1.e0(getContext(), this.f);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f16929a);
        f();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Activity activity = this.m;
        if (activity instanceof FindMapTripNearbyPage) {
            ((FindMapTripNearbyPage) activity).G1();
        }
        zn6.b("page_mapfinder_itinerary_detail");
    }

    @qm5
    public void tripEvent(qw1 qw1Var) {
        if (qw1Var != null) {
            int i = qw1Var.f20336a;
            if (i == 1) {
                e(qw1Var.e);
            } else if (i == 3) {
                d(qw1Var.e);
            }
        }
    }
}
