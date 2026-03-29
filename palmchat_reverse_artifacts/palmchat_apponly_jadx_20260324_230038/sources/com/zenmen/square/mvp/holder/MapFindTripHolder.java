package com.zenmen.square.mvp.holder;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.find.ConditionHelper;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.a46;
import defpackage.bj5;
import defpackage.cy5;
import defpackage.hc2;
import defpackage.k86;
import defpackage.l50;
import defpackage.ry5;
import defpackage.y5;
import defpackage.zk5;
import defpackage.zn6;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MapFindTripHolder extends BaseViewHolder {
    public ImageView f;
    public ImageView g;
    public View h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public LocationEx o;
    public SquareFeed p;
    public FrameworkBaseActivity q;
    public ImageView r;
    public String s;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.b("pagediscover_itinerary_more");
            if (MapFindTripHolder.this.q()) {
                bj5.b().a().g0(MapFindTripHolder.this.itemView.getContext(), ConditionHelper.getInstance().getDriftInfo().location, true, false, 11);
            }
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
            MapFindTripHolder.this.t();
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
            MapFindTripHolder.this.t();
        }
    }

    public MapFindTripHolder(FrameworkBaseActivity frameworkBaseActivity, View view) {
        super(view);
        this.f = null;
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
        this.r = null;
        this.s = "";
        this.q = frameworkBaseActivity;
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void l(BaseBean baseBean, int i) {
        if (baseBean instanceof SquareFeed) {
            SquareFeed squareFeed = (SquareFeed) baseBean;
            this.p = squareFeed;
            if (TextUtils.isEmpty(squareFeed.feedExt)) {
                return;
            }
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(squareFeed.feedExt).optJSONObject("nearbySchedule");
                this.s = jSONObjectOptJSONObject.optString(DeviceInfoUtil.UID_TAG);
                r();
                if (this.o == null) {
                    this.o = new LocationEx();
                }
                this.o.setLongitude(jSONObjectOptJSONObject.optDouble("longitude"));
                this.o.setLatitude(jSONObjectOptJSONObject.optDouble("latitude"));
                String strOptString = jSONObjectOptJSONObject.optString("nickname");
                if (!TextUtils.isEmpty(strOptString)) {
                    this.i.setText(strOptString);
                }
                String strOptString2 = jSONObjectOptJSONObject.optString("avatar");
                String strOptString3 = jSONObjectOptJSONObject.optString("scheduleOrderId");
                if (!TextUtils.isEmpty(strOptString2)) {
                    if (bj5.b().a().n(this.s, strOptString3)) {
                        ImageView imageView = this.f;
                        if (imageView != null) {
                            imageView.setImageResource(R$drawable.nest_blur_def_bg);
                            if (!TextUtils.isEmpty(strOptString2)) {
                                hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(strOptString2)).placeholder(R$drawable.default_portrait).transform(new y5(10, 1)).into(this.f);
                            }
                        }
                    } else {
                        hc2.b(this.q).load(strOptString2).into(this.f);
                    }
                }
                if (jSONObjectOptJSONObject.optInt("gender") == 0) {
                    this.g.setImageResource(com.zenmen.square.R$drawable.icon_sex_male);
                }
                this.r.setVisibility(8);
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("vip");
                if (jSONObjectOptJSONObject2 != null) {
                    int iOptInt = jSONObjectOptJSONObject2.optInt("status");
                    int iOptInt2 = jSONObjectOptJSONObject2.optInt("type");
                    if (iOptInt > 0) {
                        this.r.setVisibility(0);
                        if (iOptInt2 == 1) {
                            this.r.setImageResource(R$drawable.svip_icon_normal);
                        }
                    }
                }
                long jOptLong = jSONObjectOptJSONObject.optLong("publishTs");
                if (jOptLong > 0) {
                    this.j.setText(cy5.g(jOptLong) + " · 发布了行程");
                }
                int iOptInt3 = jSONObjectOptJSONObject.optInt("distanceMi");
                if (iOptInt3 > 0) {
                    this.k.setText(zk5.a(iOptInt3 / 1000.0f) + "km");
                }
                String strOptString4 = jSONObjectOptJSONObject.optString("scheduleAddress");
                if (!TextUtils.isEmpty(strOptString4)) {
                    this.n.setText(strOptString4);
                }
                String strU = bj5.b().a().U(jSONObjectOptJSONObject.optInt("scheduleTag"));
                if (!TextUtils.isEmpty(strU)) {
                    this.m.setText(strU);
                }
                if (!bj5.b().a().F()) {
                    this.h.setVisibility(0);
                    String strH = bj5.b().a().h(jSONObjectOptJSONObject.optLong("scheduleMomentTs"));
                    if (TextUtils.isEmpty(strH)) {
                        return;
                    }
                    this.l.setText(strH);
                    return;
                }
                long jOptLong2 = jSONObjectOptJSONObject.optLong("scheduleMomentTsV2", 0L);
                LogUtil.d("TripNearByTag", "FindMapTripHolder MomentTsV2 " + jOptLong2);
                if (jOptLong2 <= 0) {
                    this.h.setVisibility(8);
                    return;
                }
                this.h.setVisibility(0);
                String strH2 = bj5.b().a().h(jOptLong2);
                if (TextUtils.isEmpty(strH2)) {
                    return;
                }
                this.l.setText(strH2);
            } catch (Exception e) {
                LogUtil.d("", "bind e " + e.toString());
            }
        }
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ((ViewGroup) this.itemView).addView(LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.layout_square_map_trip_holder_view, (ViewGroup) this.itemView, false));
        s("view");
        this.itemView.findViewById(R$id.square_trip_more_layout).setOnClickListener(new a());
        this.itemView.findViewById(R$id.square_trip_info_layout).setOnClickListener(new b());
        this.itemView.findViewById(R$id.layout_feed_meet).setOnClickListener(new c());
        r();
    }

    public final boolean q() {
        if (a46.o()) {
            if (a46.q()) {
                return true;
            }
            BaseActivityPermissionDispatcher.b(this.q, BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_DRIFT_LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.FIND_FRIEND_GET_LOCATION);
            return false;
        }
        ry5.a("请打开位置服务");
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        try {
            this.q.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public final void r() {
        if (this.f == null) {
            this.f = (ImageView) this.itemView.findViewById(R$id.trip_holder_icon_img);
        }
        if (this.g == null) {
            this.g = (ImageView) this.itemView.findViewById(R$id.square_holder_trip_gender_icon);
        }
        if (this.i == null) {
            this.i = (TextView) this.itemView.findViewById(R$id.square_holder_trip_nick_name);
        }
        if (this.h == null) {
            this.h = this.itemView.findViewById(R$id.trip_map_mine_time_layout);
        }
        if (this.j == null) {
            this.j = (TextView) this.itemView.findViewById(R$id.square_holder_trip_desc);
        }
        if (this.l == null) {
            this.l = (TextView) this.itemView.findViewById(R$id.trip_map_mine_time_title);
        }
        if (this.m == null) {
            this.m = (TextView) this.itemView.findViewById(R$id.trip_map_mine_tag_title);
        }
        if (this.n == null) {
            this.n = (TextView) this.itemView.findViewById(R$id.trip_map_mine_location_title);
        }
        if (this.r == null) {
            this.r = (ImageView) this.itemView.findViewById(R$id.square_holder_trip_vip_icon);
        }
        if (this.k == null) {
            this.k = (TextView) this.itemView.findViewById(R$id.trip_map_mine_distance_title);
        }
    }

    public final void s(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", str);
            jSONObject.put("fuid", this.s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("pagediscover_itinerary", null, jSONObject.toString());
    }

    public final void t() {
        if (this.p != null) {
            s("click");
            if (q()) {
                bj5.b().a().D(this.itemView.getContext(), this.o, this.p, 10);
            }
        }
    }
}
