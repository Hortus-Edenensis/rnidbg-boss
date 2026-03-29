package defpackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.ad.constant.x;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.peoplenearby.PeopleNearbyActivity;
import com.zenmen.palmchat.peoplenearby.PeopleNearbyVo;
import com.zenmen.palmchat.peoplenearby.ad.PeopleNearbyAdLoadMore;
import com.zenmen.palmchat.peoplenearby.ad.e;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.ui.widget.FindMapEntryView;
import com.zenmen.square.util.conf.MapFinderConfig;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ig4 {
    public int A;
    public FindMapEntryView B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f18159a;
    public ImageView b;
    public View c;
    public View d;
    public ImageView e;
    public RelativeLayout f;
    public RelativeLayout g;
    public RelativeLayout h;
    public TextView i;
    public TextView j;
    public ImageView k;
    public ImageView l;
    public ListView m;
    public LinearLayout n;
    public TextView o;
    public LinearLayout p;
    public TextView q;
    public View r;
    public LinearLayout s;
    public RelativeLayout t;
    public TextView u;
    public ImageView v;
    public boolean w = false;
    public String x = "3113";
    public LinearLayout y;
    public PeopleNearbyActivity z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18160a;

        public a(String str) {
            this.f18160a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap map = new HashMap();
            map.put("text", this.f18160a);
            zn6.i("pageoldnearby_mapfinder_topentry", map);
            ig4.this.B.checkPermissionAndJump(6, 0, 0);
            ig4.this.h.setVisibility(8);
        }
    }

    public ig4(PeopleNearbyActivity peopleNearbyActivity) {
        this.z = peopleNearbyActivity;
        this.y = (LinearLayout) peopleNearbyActivity.findViewById(R.id.location_fail);
        this.f18159a = (TextView) peopleNearbyActivity.findViewById(R.id.peoplenearby_new_greet);
        this.f = (RelativeLayout) peopleNearbyActivity.findViewById(R.id.nearby_greeting_area);
        this.b = (ImageView) peopleNearbyActivity.findViewById(R.id.nearby_img);
        this.c = peopleNearbyActivity.findViewById(R.id.peoplenearby_message_end);
        this.d = peopleNearbyActivity.findViewById(R.id.new_greet_area);
        this.e = (ImageView) peopleNearbyActivity.findViewById(R.id.car_view);
        this.g = (RelativeLayout) peopleNearbyActivity.findViewById(R.id.more_friends_area);
        this.h = (RelativeLayout) peopleNearbyActivity.findViewById(R.id.nearby_map_find_area);
        this.i = (TextView) peopleNearbyActivity.findViewById(R.id.nearby_map_find_txt);
        this.j = (TextView) peopleNearbyActivity.findViewById(R.id.nearby_more_friends_tip);
        this.k = (ImageView) peopleNearbyActivity.findViewById(R.id.nearby_more_friends_left_ic);
        this.l = (ImageView) peopleNearbyActivity.findViewById(R.id.nearby_more_friends_right_ic);
        this.B = (FindMapEntryView) peopleNearbyActivity.findViewById(R.id.rl_find_map_entry);
        n();
        String strD = rl0.h().c().d();
        if (!TextUtils.isEmpty(strD)) {
            this.j.setText(strD);
        }
        String str = vm0.v0;
        String str2 = vm0.w0;
        if (!TextUtils.isEmpty(str)) {
            gr2.j().h(str, this.k, bq6.e());
        }
        if (!TextUtils.isEmpty(str2)) {
            gr2.j().h(str2, this.l, bq6.f());
        }
        LinearLayout linearLayout = (LinearLayout) peopleNearbyActivity.findViewById(R.id.get_neearby_fail);
        this.n = linearLayout;
        linearLayout.setVisibility(8);
        this.o = (TextView) peopleNearbyActivity.findViewById(R.id.loc_fail_tv);
        this.y.setVisibility(8);
        r();
        p();
        r75.o(AppContext.getContext(), k86.a("is_first_enter_nearby"), false);
    }

    public static void h(Context context, PeopleNearbyVo peopleNearbyVo, boolean z) {
        Intent intent = new Intent();
        intent.setClass(context, m66.c());
        intent.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, z);
        intent.putExtra("user_item_info", peopleNearbyVo);
        intent.putExtra("from", 11);
        String strP = AccountUtils.p(AppContext.getContext());
        if (peopleNearbyVo == null || peopleNearbyVo.getUid() == null || peopleNearbyVo.getUid().equals(strP)) {
            LogUtil.uploadInfoImmediate(strP, "312", "1", null, null);
        } else {
            LogUtil.uploadInfoImmediate(strP, "313", "1", null, peopleNearbyVo.getSex().equals("1") ? "1" : "2");
            if (peopleNearbyVo.getFriendType() == 1) {
                long distance = peopleNearbyVo.getDistance();
                if (distance <= 1000) {
                    intent.putExtra("distance", context.getResources().getString(R.string.nearby_meters, Long.valueOf((distance / 100) + 1)));
                } else {
                    intent.putExtra("distance", context.getResources().getString(R.string.nearby_kilometers, Long.valueOf(distance / 1000)));
                }
            }
        }
        intent.addFlags(67108864);
        context.startActivity(intent);
    }

    public final void c() {
        ListView listView = this.m;
        if (listView == null || this.w) {
            return;
        }
        listView.addFooterView(this.r, null, false);
        this.w = true;
    }

    public final String d() {
        ContactInfoItem contactInfoItemA;
        String strE = v4.e(c.b());
        return (TextUtils.isEmpty(strE) || (contactInfoItemA = dn0.a(strE)) == null) ? "" : contactInfoItemA.getAge();
    }

    public HashMap<String, String> e(LocationEx locationEx, int i, int i2, int i3) {
        bl6 bl6Var = new bl6(this.z);
        bl6Var.a();
        String strB = bl6Var.b();
        if (strB != null) {
            strB = strB.replaceAll("\"", "");
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("longitude", String.valueOf(locationEx.getLongitude()));
        map.put("latitude", String.valueOf(locationEx.getLatitude()));
        map.put("localCityCode", locationEx.getCityCode());
        map.put("age", d());
        map.put("clientType", "gcj02");
        map.put("gender", String.valueOf(i));
        map.put("sex", String.valueOf(i2));
        map.put("ssid", strB);
        map.put("sdid", ac1.v());
        if (i3 != 0) {
            map.put("fromType", String.valueOf(i3));
        }
        return map;
    }

    public HashMap<String, Object> f(LocationEx locationEx, int i, int i2, int i3, boolean z) {
        bl6 bl6Var = new bl6(this.z);
        bl6Var.a();
        String strB = bl6Var.b();
        if (strB != null) {
            strB = strB.replaceAll("\"", "");
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("longitude", String.valueOf(locationEx.getLongitude()));
        map.put("latitude", String.valueOf(locationEx.getLatitude()));
        map.put("localCityCode", locationEx.getCityCode());
        map.put("age", d());
        map.put("clientType", "gcj02");
        map.put("gender", String.valueOf(i));
        map.put("sex", String.valueOf(i2));
        map.put("ssid", strB);
        map.put("sdid", ac1.v());
        if (i3 != 0) {
            map.put("fromType", String.valueOf(i3));
        }
        map.put("inspireVideoFeature", Boolean.valueOf(z));
        return map;
    }

    public void g(ListView listView) {
        this.m = listView;
        View viewInflate = LayoutInflater.from(this.z).inflate(R.layout.list_nearby_footer_view, (ViewGroup) null);
        this.r = viewInflate;
        this.p = (LinearLayout) viewInflate.findViewById(R.id.loading);
        this.q = (TextView) this.r.findViewById(R.id.footer_textview);
        this.s = (LinearLayout) this.r.findViewById(R.id.footer_normal);
        this.t = (RelativeLayout) this.r.findViewById(R.id.footer_reward);
        this.u = (TextView) this.r.findViewById(R.id.footer_reward_text);
        this.v = (ImageView) this.r.findViewById(R.id.footer_reward_img);
        this.t.setVisibility(8);
        this.r.setVisibility(8);
        c();
    }

    public final String i(int i) {
        if (i == 0) {
            this.x = "3112";
        } else if (i == 1) {
            this.x = "3111";
        } else if (i == 2) {
            this.x = "3113";
        }
        return this.x;
    }

    public void j() {
        ListView listView = this.m;
        if (listView == null) {
            return;
        }
        listView.removeFooterView(this.r);
        this.w = false;
    }

    public void k(int i) {
        this.A = i;
    }

    public void l(boolean z, int i, int i2, int i3, boolean z2) {
        String strP = AccountUtils.p(AppContext.getContext());
        if (i2 != 0 || i3 != 0) {
            this.n.setVisibility(8);
            o(false, !z2, false, true, PeopleNearbyAdLoadMore.Status.DISABLE, 0, false);
        } else {
            if (!z) {
                this.n.setVisibility(8);
                LogUtil.uploadInfoImmediate(strP, i(i), "1", "1", null);
                return;
            }
            if (this.z.B2() != null) {
                this.o.setText(R.string.nearby_no_one_using);
            } else {
                this.o.setText(R.string.nearby_unable_load);
            }
            this.n.setVisibility(0);
            LogUtil.uploadInfoImmediate(strP, i(i), "1", "2", null);
        }
    }

    public void m() {
        c();
        ImageView imageView = this.v;
        if (imageView != null) {
            if (this.A == 1) {
                imageView.setImageResource(R.drawable.ic_people_nearby_boy);
            } else {
                imageView.setImageResource(R.drawable.ic_people_nearby_girl);
            }
        }
        this.r.setVisibility(0);
        this.s.setVisibility(8);
        this.t.setVisibility(0);
    }

    public final void n() {
        if (!uj5.a()) {
            this.B.setVisibility(8);
            return;
        }
        MapFinderConfig.MainEntry mainEntry = gi5.g().main_circleentry;
        if (mainEntry != null && !mainEntry.oldnearby_showstate) {
            this.B.setVisibility(8);
            return;
        }
        zn6.b("map_finder");
        this.B.setVisibility(0);
        this.B.triggleBubbleShow();
    }

    public void o(boolean z, boolean z2, boolean z3, boolean z4, PeopleNearbyAdLoadMore.Status status, int i, boolean z5) {
        ma3.f("showPullUpFooter = " + z5 + "  :::: show = " + z2);
        if (z5) {
            m();
            return;
        }
        if (z2) {
            c();
            this.r.setVisibility(0);
            this.s.setVisibility(0);
            this.t.setVisibility(8);
        } else {
            j();
        }
        if (z) {
            z3 = false;
        }
        if (z3) {
            this.p.setVisibility(0);
            this.q.setVisibility(8);
            return;
        }
        this.p.setVisibility(8);
        this.q.setVisibility(0);
        if (z4) {
            this.q.setText(R.string.nearby_network);
            return;
        }
        if (z) {
            this.q.setText(String.format(e.f(), Integer.valueOf(i)));
            return;
        }
        if (status == PeopleNearbyAdLoadMore.Status.LIMITED_COUNT) {
            this.q.setText(R.string.nearby_limited_count);
        } else if (status == PeopleNearbyAdLoadMore.Status.LIMITED_INTERVAL) {
            this.q.setText(this.z.getString(R.string.nearby_limited_interval, Integer.valueOf(e.m())));
        } else {
            this.q.setText(R.string.nearby_fewer_than);
        }
    }

    public void p() {
        int iM = tn0.i().m();
        String strN = tn0.i().n();
        if (iM <= 0) {
            this.f.setVisibility(8);
            MapFinderConfig.OldNearbyEntry oldNearbyEntry = gi5.g().pageoldnearby_topentry;
            if (oldNearbyEntry == null || !oldNearbyEntry.showstate || !uj5.a() || this.B.getVisibility() == 8) {
                return;
            }
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.SQUARE;
            if (Math.abs(sPUtil.i(scene, "key_map_finder_entry_old_entry_time", 0L) - ir5.b()) >= ((long) oldNearbyEntry.fre) * 1000) {
                sPUtil.t(scene, "key_map_finder_entry_old_entry_time", Long.valueOf(ir5.b()));
                this.g.setVisibility(8);
                this.h.setVisibility(0);
                Collections.shuffle(oldNearbyEntry.text);
                String str = oldNearbyEntry.text.get(0);
                this.i.setText(str);
                this.h.setOnClickListener(new a(str));
                return;
            }
            return;
        }
        this.h.setVisibility(8);
        this.g.setVisibility(8);
        this.f.setVisibility(0);
        int i = 1;
        this.f18159a.setText(this.z.getString(R.string.nearby_new_greet, Integer.valueOf(iM)));
        if (strN != null) {
            gr2.j().h(strN, this.b, bq6.s());
        }
        if (TextUtils.isEmpty(tn0.i().k()) || !jo6.u()) {
            this.c.setVisibility(0);
            this.d.setBackgroundResource(R.drawable.shape_black_nearby_greet);
            this.e.setVisibility(8);
            i = 2;
        } else {
            this.c.setVisibility(4);
            if (tn0.i().j() != 1) {
                this.d.setBackgroundResource(R.drawable.people_nearby_greeting_background_with_car_male);
            } else {
                this.d.setBackgroundResource(R.drawable.people_nearby_greeting_background_with_car_female);
            }
            this.e.setVisibility(0);
            gr2.j().h(tn0.i().k(), this.e, bq6.b());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(x.cw, i);
            LogUtil.uploadInfoImmediate("fjdrzj007", null, null, null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void q(boolean z) {
        TextView textView = this.u;
        if (textView != null) {
            if (z) {
                textView.setText(e.i());
            } else {
                textView.setText(e.j());
            }
        }
    }

    public void r() {
        if (ac1.C()) {
            this.g.setVisibility(8);
            return;
        }
        if (nl0.g()) {
            if (this.h.getVisibility() == 0 || this.f.getVisibility() == 0) {
                this.g.setVisibility(8);
                return;
            }
            if (tn0.i().m() > 0) {
                this.g.setVisibility(8);
            } else if (bo0.r().j() > 20 || AppContext.getContext().getTrayPreferences().a(k86.n(), false)) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
            }
        }
    }
}
