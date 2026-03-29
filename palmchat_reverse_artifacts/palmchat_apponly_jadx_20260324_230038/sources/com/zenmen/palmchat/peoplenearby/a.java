package com.zenmen.palmchat.peoplenearby;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.peoplenearby.PeopleNearbyActivity;
import com.zenmen.palmchat.peoplenearby.ad.BlurringView;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.ColorTextView;
import com.zenmen.palmchat.widget.PinnedSectionListView;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.jg4;
import defpackage.jo6;
import defpackage.jr2;
import defpackage.ma3;
import defpackage.rl0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a extends BaseAdapter implements PeopleNearbyActivity.z, PinnedSectionListView.e {
    public static int q = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutInflater f14973a;
    public Context c;
    public int d;
    public ArrayList<String> j;
    public jg4 k;
    public List<PeopleNearbyVo> b = new ArrayList();
    public boolean e = false;
    public int f = 0;
    public int g = 1;
    public int h = 2;
    public int i = 5;
    public List<String> l = new ArrayList();
    public List<BlurringView> m = new ArrayList();
    public AtomicBoolean n = new AtomicBoolean(false);
    public int[] o = {300, 3000, 8000, 15000, ErrorCode.REASON_RD_TEXT, 10000000};
    public String[] p = {"100米以内", "1公里以内", "5公里以内", "10公里以内", "20公里以内", "20公里以外"};

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < a.this.m.size(); i++) {
                try {
                    ((BlurringView) a.this.m.get(i)).postInvalidate();
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PeopleNearbyVo f14976a;
        public final /* synthetic */ int b;

        public c(PeopleNearbyVo peopleNearbyVo, int i) {
            this.f14976a = peopleNearbyVo;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.k != null) {
                a.this.k.j0(view, this.f14976a, this.b, a.this.h);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f14977a;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f14978a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public ImageView f;
        public SocialPortraitView g;
        public LinearLayout h;
        public ColorTextView i;
        public ImageView j;
        public FrameLayout k;
        public Button l;
        public RelativeLayout m;
        public LinearLayout n;
        public BlurringView o;

        public e() {
        }
    }

    public a(Context context) {
        this.j = null;
        this.c = context;
        this.f14973a = LayoutInflater.from(context);
        this.j = j();
    }

    @Override // com.zenmen.palmchat.peoplenearby.PeopleNearbyActivity.z
    public void a(ArrayList<PeopleNearbyVo> arrayList, int i) {
        this.b.clear();
        this.d = i;
        if (arrayList != null) {
            this.b = m(arrayList);
        }
        ma3.f("updateData notifyDataSetChanged mData size = " + this.b.size());
        notifyDataSetChanged();
    }

    public final void g(String str) {
        if (TextUtils.isEmpty(str) || !this.l.contains(str) || this.n.get()) {
            return;
        }
        this.n.set(true);
        new Handler(Looper.getMainLooper()).postDelayed(new b(), com.igexin.push.config.c.j);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.b.get(i).isRewardAd() ? this.g : this.b.get(i).isUnlockAdTip() ? q : this.b.get(i).getDistanceHint() != null ? this.f : this.h;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        e eVar;
        int i2;
        View viewInflate = view;
        int itemViewType = getItemViewType(i);
        if (viewInflate != null && (view.getTag() instanceof e)) {
            itemViewType = this.h;
        }
        PeopleNearbyVo peopleNearbyVo = this.b.get(i);
        if (itemViewType == this.f) {
            if (viewInflate == null) {
                viewInflate = this.f14973a.inflate(R.layout.list_item_nearby_ui3_hint, (ViewGroup) null);
            }
            ((TextView) viewInflate.findViewById(R.id.distance)).setText(this.b.get(i).getDistanceHint());
            return viewInflate;
        }
        if (itemViewType == this.g) {
            View viewInflate2 = viewInflate == null ? this.f14973a.inflate(R.layout.list_item_nearby_ui3_reward_ad, (ViewGroup) null) : viewInflate;
            ((TextView) viewInflate2.findViewById(R.id.text)).setText(com.zenmen.palmchat.peoplenearby.ad.d.c());
            return viewInflate2;
        }
        if (itemViewType == q) {
            return h(viewInflate, peopleNearbyVo, i);
        }
        boolean zIsUnlockAd = peopleNearbyVo.isUnlockAd();
        boolean zIsShowUnlockBtn = peopleNearbyVo.isShowUnlockBtn();
        if (viewInflate == null) {
            viewInflate = LayoutInflater.from(this.c).inflate(R.layout.list_item_nearby_ui3, (ViewGroup) null);
            eVar = new e();
            eVar.n = (LinearLayout) viewInflate.findViewById(R.id.item_content);
            eVar.f14978a = (TextView) viewInflate.findViewById(R.id.nick_name);
            eVar.b = (TextView) viewInflate.findViewById(R.id.signature);
            eVar.f = (ImageView) viewInflate.findViewById(R.id.gender);
            eVar.c = (TextView) viewInflate.findViewById(R.id.is_friends);
            eVar.h = (LinearLayout) viewInflate.findViewById(R.id.gender_area);
            eVar.g = (SocialPortraitView) viewInflate.findViewById(R.id.portrait);
            eVar.i = (ColorTextView) viewInflate.findViewById(R.id.label);
            eVar.j = (ImageView) viewInflate.findViewById(R.id.car_image);
            eVar.k = (FrameLayout) viewInflate.findViewById(R.id.layout_nearby_unlock_ad);
            eVar.l = (Button) viewInflate.findViewById(R.id.nearby_unlock_ad);
            eVar.m = (RelativeLayout) viewInflate.findViewById(R.id.blurring_view);
            o(eVar);
            viewInflate.setTag(eVar);
        } else {
            eVar = (e) view.getTag();
        }
        View view2 = viewInflate;
        e eVar2 = eVar;
        q(eVar2, peopleNearbyVo, zIsUnlockAd, zIsShowUnlockBtn, i);
        eVar2.g.changeShapeType(1);
        eVar2.g.setDegreeForRoundRectangle(13, 13);
        String iconURL = peopleNearbyVo.getIconURL();
        String signature = peopleNearbyVo.getSignature();
        int timeDifference = peopleNearbyVo.getTimeDifference();
        String tags = peopleNearbyVo.getTags();
        String sex = peopleNearbyVo.getSex();
        if (sex == null) {
            sex = "";
        }
        String age = peopleNearbyVo.getAge();
        String labels = peopleNearbyVo.getLabels();
        if (this.e) {
            TextView textView = eVar2.e;
            if (textView != null) {
                if (timeDifference < 3600) {
                    textView.setText(this.c.getResources().getString(R.string.nearby_minutes, Integer.valueOf(Math.max(timeDifference / 60, 1))));
                } else {
                    textView.setText(this.c.getResources().getString(R.string.nearby_hours, Integer.valueOf(timeDifference / 3600)));
                }
            }
            if (eVar2.d != null) {
                if (TextUtils.isEmpty(age)) {
                    eVar2.d.setVisibility(8);
                } else {
                    eVar2.d.setVisibility(0);
                    eVar2.d.setText(age);
                }
            }
        }
        if (this.e) {
            eVar2.f.setVisibility(0);
            if (sex.equals("0")) {
                eVar2.h.setBackgroundResource(R.drawable.shape_nearby_male);
                eVar2.f.setImageResource(R.drawable.nearby_gender_male_new_ui3);
            } else if (sex.equals("1")) {
                eVar2.h.setBackgroundResource(R.drawable.shape_nearby_female);
                eVar2.f.setImageResource(R.drawable.nearby_gender_female_new_ui3);
            } else {
                eVar2.h.setBackgroundResource(R.drawable.shape_nearby_all);
                eVar2.f.setImageResource(R.drawable.nearby_gender_all);
            }
        } else if (this.d == 2) {
            eVar2.f.setVisibility(0);
            if (sex.equals("0")) {
                eVar2.f.setImageResource(R.drawable.nearby_gender_male_new_ui3);
            } else if (sex.equals("1")) {
                eVar2.f.setImageResource(R.drawable.nearby_gender_female_new_ui3);
            } else {
                eVar2.f.setVisibility(8);
            }
        } else {
            eVar2.f.setVisibility(8);
        }
        if (!this.e) {
            if (peopleNearbyVo.getFriendType() == 0) {
                ContactInfoItem contactInfoItemL = bo0.r().l(peopleNearbyVo.getUid());
                if (contactInfoItemL != null) {
                    if (TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                        eVar2.f14978a.setText(peopleNearbyVo.getNickName());
                    } else {
                        eVar2.f14978a.setText(contactInfoItemL.getRemarkName());
                    }
                } else if (TextUtils.isEmpty(peopleNearbyVo.getRemarkName())) {
                    eVar2.f14978a.setText(peopleNearbyVo.getNickName());
                } else {
                    eVar2.f14978a.setText(peopleNearbyVo.getRemarkName());
                }
                if (peopleNearbyVo.getUid() == null || !peopleNearbyVo.getUid().equals(AccountUtils.p(AppContext.getContext()))) {
                    eVar2.c.setVisibility(0);
                } else {
                    eVar2.c.setVisibility(8);
                }
                i2 = 8;
            } else {
                eVar2.f14978a.setText(peopleNearbyVo.getNickName());
                i2 = 8;
                eVar2.c.setVisibility(8);
            }
            if (TextUtils.isEmpty(signature)) {
                eVar2.b.setVisibility(i2);
            } else {
                eVar2.b.setVisibility(0);
                eVar2.b.setText(signature);
            }
        } else if (peopleNearbyVo.getFriendType() == 0) {
            if (peopleNearbyVo.getUid() == null || !peopleNearbyVo.getUid().equals(AccountUtils.p(AppContext.getContext()))) {
                eVar2.c.setVisibility(0);
            } else {
                eVar2.c.setVisibility(8);
            }
            eVar2.b.setTextColor(this.c.getResources().getColor(R.color.nearby_signature));
            eVar2.b.setText(signature);
        } else {
            if (TextUtils.isEmpty(tags)) {
                eVar2.b.setTextColor(this.c.getResources().getColor(R.color.nearby_signature));
                eVar2.b.setText(signature);
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(tags);
                    if (jSONArray.length() > 0) {
                        String strOptString = jSONArray.optString(0);
                        if (TextUtils.isEmpty(strOptString)) {
                            eVar2.b.setTextColor(this.c.getResources().getColor(R.color.nearby_signature));
                            eVar2.b.setText(signature);
                        } else {
                            eVar2.b.setTextColor(this.c.getResources().getColor(R.color.nearby_tags));
                            eVar2.b.setText(strOptString);
                        }
                    } else {
                        eVar2.b.setTextColor(this.c.getResources().getColor(R.color.nearby_signature));
                        eVar2.b.setText(signature);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    eVar2.b.setTextColor(this.c.getResources().getColor(R.color.nearby_signature));
                    eVar2.b.setText(signature);
                }
            }
            eVar2.c.setVisibility(8);
        }
        if (zIsUnlockAd && !TextUtils.isEmpty(iconURL) && !this.l.contains(iconURL)) {
            this.l.add(iconURL);
        }
        gr2.j().i(iconURL, eVar2.g, bq6.s(), new C1093a());
        if (com.zenmen.palmchat.peoplenearby.ad.e.B() && zIsUnlockAd) {
            eVar2.i.setVisibility(8);
        } else {
            l(eVar2, labels);
        }
        if (TextUtils.isEmpty(peopleNearbyVo.getCarImageUrl()) || !jo6.v()) {
            eVar2.j.setVisibility(8);
        } else {
            eVar2.j.setVisibility(0);
            gr2.j().h(peopleNearbyVo.getCarImageUrl(), eVar2.j, bq6.b());
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.i + 1;
    }

    public final View h(View view, PeopleNearbyVo peopleNearbyVo, int i) {
        d dVar;
        if (view == null) {
            view = this.f14973a.inflate(R.layout.list_item_nearby_ad_unlock_tip, (ViewGroup) null);
            dVar = new d();
            dVar.f14977a = (TextView) view.findViewById(R.id.ad_unlock_text);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        dVar.f14977a.setText(com.zenmen.palmchat.peoplenearby.ad.e.h());
        return view;
    }

    public int i(long j) {
        int i = 0;
        while (true) {
            if (i >= this.o.length || j < r1[i]) {
                break;
            }
            i++;
        }
        return i;
    }

    public ArrayList<String> j() {
        ArrayList<String> arrayList = new ArrayList<>();
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY);
        if (dynamicConfig != null && dynamicConfig.isEnable()) {
            String extra = dynamicConfig.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    JSONArray jSONArray = new JSONObject(extra).getJSONArray("sectionTitle");
                    if (jSONArray != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            Log.i("rxx", string);
                            arrayList.add(string);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    @Override // com.zenmen.palmchat.widget.PinnedSectionListView.e
    public boolean k(int i) {
        return i == this.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(e eVar, String str) {
        String strTrim;
        String strTrim2;
        JSONArray jSONArray;
        String str2 = "";
        try {
            jSONArray = new JSONArray(str);
        } catch (Exception e2) {
            e = e2;
            strTrim = "";
        }
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(0);
            strTrim = jSONObject.optString("text").trim();
            try {
                strTrim2 = jSONObject.optString("backgroundColor").trim();
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                strTrim2 = "";
            }
            str2 = strTrim;
            if (TextUtils.isEmpty(str2)) {
                eVar.i.setVisibility(8);
                LogUtil.d("logad", "label hide: ,nickName:" + ((Object) eVar.f14978a.getText()));
                return;
            }
            eVar.i.setVisibility(0);
            if (str2.length() > 4) {
                eVar.i.setText(str2.substring(0, 4));
            } else {
                eVar.i.setText(str2);
            }
            if (TextUtils.isEmpty(strTrim2) || !Pattern.matches("^#[0-9a-fA-F]{6}$", strTrim2)) {
                eVar.i.setCtvBackgroundColor(Color.parseColor("#00000000"));
            } else {
                eVar.i.setCtvBackgroundColor(Color.parseColor(strTrim2));
            }
            LogUtil.d("logad", "label show: ,nickName:" + ((Object) eVar.f14978a.getText()) + ", labelName:" + str2);
            return;
        }
        strTrim2 = "";
        if (TextUtils.isEmpty(str2)) {
        }
        e.printStackTrace();
        strTrim2 = "";
        str2 = strTrim;
        if (TextUtils.isEmpty(str2)) {
        }
    }

    public ArrayList<PeopleNearbyVo> m(ArrayList<PeopleNearbyVo> arrayList) {
        int length = this.o.length;
        ArrayList<PeopleNearbyVo> arrayList2 = new ArrayList<>();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PeopleNearbyVo peopleNearbyVo = arrayList.get(i3);
            if (peopleNearbyVo.isRewardAd()) {
                arrayList2.add(peopleNearbyVo);
            } else {
                int i4 = i(peopleNearbyVo.getDistance());
                if (i4 > length) {
                    PeopleNearbyVo peopleNearbyVo2 = new PeopleNearbyVo();
                    peopleNearbyVo2.setDistanceHint(this.p[i4]);
                    arrayList2.add(peopleNearbyVo2);
                    arrayList2.add(peopleNearbyVo);
                    peopleNearbyVo.setDistanceHintFlag(i);
                } else if (i4 == length) {
                    arrayList2.add(peopleNearbyVo);
                } else {
                    PeopleNearbyVo peopleNearbyVo3 = new PeopleNearbyVo();
                    String str = this.p[i4];
                    if (this.j.size() > i2) {
                        str = str + this.j.get(i2);
                    }
                    peopleNearbyVo3.setDistanceHint(str);
                    peopleNearbyVo3.setDistanceHintFlag(i2);
                    arrayList2.add(peopleNearbyVo3);
                    arrayList2.add(peopleNearbyVo);
                    peopleNearbyVo.setDistanceHintFlag(i2);
                    i = i2;
                    i2++;
                }
                length = i4;
            }
        }
        return arrayList2;
    }

    public final void o(e eVar) {
        if (eVar == null || eVar.n == null || eVar.m == null) {
            return;
        }
        BlurringView blurringView = new BlurringView(AppContext.getContext());
        blurringView.setBlurredView(eVar.n);
        eVar.m.addView(blurringView);
        eVar.o = blurringView;
        this.m.add(blurringView);
    }

    public void p(jg4 jg4Var) {
        this.k = jg4Var;
    }

    public final void q(e eVar, PeopleNearbyVo peopleNearbyVo, boolean z, boolean z2, int i) {
        if (eVar == null || peopleNearbyVo == null) {
            return;
        }
        if (!z) {
            eVar.k.setVisibility(8);
            eVar.m.setVisibility(8);
            return;
        }
        c cVar = new c(peopleNearbyVo, i);
        try {
            BlurringView blurringView = eVar.o;
            if (blurringView != null) {
                blurringView.postInvalidate();
            }
        } catch (Exception unused) {
        }
        eVar.m.setVisibility(0);
        eVar.k.setVisibility(0);
        if (z2) {
            eVar.l.setVisibility(0);
        } else {
            eVar.l.setVisibility(8);
        }
        eVar.k.setOnClickListener(cVar);
        eVar.l.setOnClickListener(cVar);
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.peoplenearby.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1093a implements jr2 {
        public C1093a() {
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            a.this.g(str);
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }

    @Override // com.zenmen.palmchat.widget.PinnedSectionListView.e
    public void d(View view, int i, long j) {
    }

    @Override // com.zenmen.palmchat.widget.PinnedSectionListView.e
    public void n(View view, int i, long j) {
    }
}
