package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.find.trip.FindMapCheckTripData;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class aw1 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f1585a;
    public View b;
    public TextView c;
    public TextView d;
    public TextView e;
    public View f;
    public View g;
    public View h;
    public FindMapCheckTripData i;
    public Context j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            aw1.this.dismiss();
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
            aw1.this.e();
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
            aw1.this.g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {
        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            ew1.g0();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            ew1.r(aw1.this.i.scheduleOrderId, aw1.this.j);
            aw1.this.dismiss();
        }
    }

    public aw1(Context context, FindMapCheckTripData findMapCheckTripData) {
        super(context, R.style.tripFullScreenDialog);
        this.f1585a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        setCanceledOnTouchOutside(false);
        this.i = findMapCheckTripData;
        this.j = context;
        this.f1585a = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.map_mine_trip_dialog, (ViewGroup) null);
    }

    public final void e() {
        zn6.b("page_mapfinder_itinerary_mydetail_cancel");
        new sd3(this.j).U("温馨提示").k("确认删除当前行程动态？").O(R.string.dialog_confirm).L("取消").f(new d()).u().e().show();
    }

    public final void f() {
        View viewFindViewById = this.f1585a.findViewById(R.id.trip_release_info_time_close);
        this.b = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        this.c = (TextView) this.f1585a.findViewById(R.id.trip_map_mine_time_title);
        this.h = this.f1585a.findViewById(R.id.trip_map_mine_time_layout);
        this.d = (TextView) this.f1585a.findViewById(R.id.trip_map_mine_location_title);
        this.e = (TextView) this.f1585a.findViewById(R.id.trip_map_mine_tag_title);
        View viewFindViewById2 = this.f1585a.findViewById(R.id.trip_map_delete_info_button);
        this.f = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new b());
        View viewFindViewById3 = this.f1585a.findViewById(R.id.trip_map_release_info_button);
        this.g = viewFindViewById3;
        viewFindViewById3.setOnClickListener(new c());
        if (this.i != null) {
            if (ew1.h0()) {
                TextView textView = (TextView) this.f1585a.findViewById(R.id.trip_map_mine_new_time_title);
                textView.setVisibility(0);
                String strB = ew1.B(this.i.createTime);
                textView.setText(strB + " · 发布了行程");
                LogUtil.d("TripNearByTag", "FindMapMine timeNewTitle show resultTime " + strB + " tripData.scheduleMomentTsV2 " + this.i.scheduleMomentTsV2);
                if (this.i.scheduleMomentTsV2 > 0) {
                    this.h.setVisibility(0);
                    this.c.setText(ew1.E(this.i.scheduleMomentTsV2));
                } else {
                    this.h.setVisibility(8);
                }
            } else {
                this.c.setText(ew1.E(this.i.scheduleMomentTs));
            }
            if (!TextUtils.isEmpty(this.i.scheduleAddress)) {
                this.d.setText(this.i.scheduleAddress);
            }
            HashMap<Integer, String> map = ew1.f;
            if (map == null || !map.containsKey(Integer.valueOf(this.i.scheduleTag))) {
                return;
            }
            this.e.setText(ew1.f.get(Integer.valueOf(this.i.scheduleTag)));
        }
    }

    public final void g() {
        zn6.b("page_mapfinder_itinerary_mydetail_reedit");
        ew1.d0(this.i.scheduleOrderId);
        dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f1585a);
        f();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        zn6.b("page_mapfinder_itinerary_mydetail");
    }
}
