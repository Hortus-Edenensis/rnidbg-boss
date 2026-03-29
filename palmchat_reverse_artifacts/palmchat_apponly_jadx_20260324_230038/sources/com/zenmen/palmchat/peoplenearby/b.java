package com.zenmen.palmchat.peoplenearby;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
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
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.peoplenearby.PeopleNearbyActivity;
import com.zenmen.palmchat.peoplenearby.ad.BlurringView;
import com.zenmen.palmchat.peoplenearby.ad.e;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.ColorTextView;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.jo6;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b extends BaseAdapter implements PeopleNearbyActivity.z {
    public Context b;
    public int c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<PeopleNearbyVo> f14989a = new ArrayList();
    public boolean d = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f14990a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public ImageView f;
        public EffectiveShapeView g;
        public LinearLayout h;
        public ColorTextView i;
        public ImageView j;
        public FrameLayout k;
        public Button l;
        public RelativeLayout m;
        public LinearLayout n;

        public a() {
        }
    }

    public b(Context context) {
        this.b = context;
    }

    @Override // com.zenmen.palmchat.peoplenearby.PeopleNearbyActivity.z
    public void a(ArrayList<PeopleNearbyVo> arrayList, int i) {
        this.f14989a.clear();
        this.c = i;
        if (arrayList != null) {
            this.f14989a.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(a aVar, String str) {
        String strTrim;
        String strTrim2;
        JSONArray jSONArray;
        String str2 = "";
        try {
            jSONArray = new JSONArray(str);
        } catch (Exception e) {
            e = e;
            strTrim = "";
        }
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(0);
            strTrim = jSONObject.optString("text").trim();
            try {
                strTrim2 = jSONObject.optString("backgroundColor").trim();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                strTrim2 = "";
            }
            str2 = strTrim;
            if (TextUtils.isEmpty(str2)) {
                aVar.i.setVisibility(8);
                LogUtil.d("logad", "label hide: ,nickName:" + ((Object) aVar.f14990a.getText()));
                return;
            }
            aVar.i.setVisibility(0);
            if (str2.length() > 4) {
                aVar.i.setText(str2.substring(0, 4));
            } else {
                aVar.i.setText(str2);
            }
            if (TextUtils.isEmpty(strTrim2) || !Pattern.matches("^#[0-9a-fA-F]{6}$", strTrim2)) {
                aVar.i.setCtvBackgroundColor(Color.parseColor("#00000000"));
            } else {
                aVar.i.setCtvBackgroundColor(Color.parseColor(strTrim2));
            }
            LogUtil.d("logad", "label show: ,nickName:" + ((Object) aVar.f14990a.getText()) + ", labelName:" + str2);
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

    public final void c(ViewGroup viewGroup, a aVar) {
        BlurringView blurringView = new BlurringView(AppContext.getContext());
        blurringView.setBlurredView(viewGroup);
        aVar.m.addView(blurringView);
    }

    public final void e(ViewGroup viewGroup, a aVar, PeopleNearbyVo peopleNearbyVo, boolean z, boolean z2, int i) {
        if (!z) {
            aVar.k.setVisibility(8);
            aVar.m.setVisibility(8);
            return;
        }
        aVar.m.setVisibility(0);
        aVar.k.setVisibility(0);
        if (z2) {
            aVar.l.setVisibility(0);
        } else {
            aVar.l.setVisibility(8);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14989a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f14989a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        int i2;
        int i3;
        getItemViewType(i);
        PeopleNearbyVo peopleNearbyVo = this.f14989a.get(i);
        boolean zIsUnlockAd = peopleNearbyVo.isUnlockAd();
        boolean zIsShowUnlockBtn = peopleNearbyVo.isShowUnlockBtn();
        if (view == null) {
            View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.list_item_nearby_ui3, (ViewGroup) null);
            aVar = new a();
            aVar.n = (LinearLayout) viewInflate.findViewById(R.id.item_content);
            aVar.f14990a = (TextView) viewInflate.findViewById(R.id.nick_name);
            aVar.b = (TextView) viewInflate.findViewById(R.id.signature);
            aVar.f = (ImageView) viewInflate.findViewById(R.id.gender);
            aVar.c = (TextView) viewInflate.findViewById(R.id.is_friends);
            aVar.h = (LinearLayout) viewInflate.findViewById(R.id.gender_area);
            aVar.g = (EffectiveShapeView) viewInflate.findViewById(R.id.portrait);
            aVar.i = (ColorTextView) viewInflate.findViewById(R.id.label);
            aVar.j = (ImageView) viewInflate.findViewById(R.id.car_image);
            aVar.k = (FrameLayout) viewInflate.findViewById(R.id.layout_nearby_unlock_ad);
            aVar.l = (Button) viewInflate.findViewById(R.id.nearby_unlock_ad);
            aVar.m = (RelativeLayout) viewInflate.findViewById(R.id.blurring_view);
            c(aVar.n, aVar);
            viewInflate.setTag(aVar);
            view2 = viewInflate;
        } else {
            aVar = (a) view.getTag();
            view2 = view;
        }
        a aVar2 = aVar;
        e(aVar2.n, aVar2, peopleNearbyVo, zIsUnlockAd, zIsShowUnlockBtn, i);
        aVar2.g.changeShapeType(3);
        aVar2.g.setDegreeForRoundRectangle(13, 13);
        String iconURL = peopleNearbyVo.getIconURL();
        String signature = peopleNearbyVo.getSignature();
        int timeDifference = peopleNearbyVo.getTimeDifference();
        String tags = peopleNearbyVo.getTags();
        String sex = peopleNearbyVo.getSex();
        String age = peopleNearbyVo.getAge();
        String labels = peopleNearbyVo.getLabels();
        if (this.d) {
            if (timeDifference < 3600) {
                aVar2.e.setText(this.b.getResources().getString(R.string.nearby_minutes, Integer.valueOf(Math.max(timeDifference / 60, 1))));
                i3 = 0;
            } else {
                i3 = 0;
                aVar2.e.setText(this.b.getResources().getString(R.string.nearby_hours, Integer.valueOf(timeDifference / 3600)));
            }
            if (TextUtils.isEmpty(age)) {
                aVar2.d.setVisibility(8);
            } else {
                aVar2.d.setVisibility(i3);
                aVar2.d.setText(age);
            }
        }
        if (this.d) {
            aVar2.f.setVisibility(0);
            if (sex.equals("0")) {
                aVar2.h.setBackgroundResource(R.drawable.shape_nearby_male);
                aVar2.f.setImageResource(R.drawable.nearby_gender_male_new_ui3);
            } else if (sex.equals("1")) {
                aVar2.h.setBackgroundResource(R.drawable.shape_nearby_female);
                aVar2.f.setImageResource(R.drawable.nearby_gender_female_new_ui3);
            } else {
                aVar2.h.setBackgroundResource(R.drawable.shape_nearby_all);
                aVar2.f.setImageResource(R.drawable.nearby_gender_all);
            }
        } else if (this.c == 2) {
            aVar2.f.setVisibility(0);
            if (sex.equals("0")) {
                aVar2.f.setImageResource(R.drawable.nearby_gender_male_new_ui3);
            } else if (sex.equals("1")) {
                aVar2.f.setImageResource(R.drawable.nearby_gender_female_new_ui3);
            } else {
                aVar2.f.setVisibility(8);
            }
        } else {
            aVar2.f.setVisibility(8);
        }
        if (!this.d) {
            if (peopleNearbyVo.getFriendType() == 0) {
                ContactInfoItem contactInfoItemL = bo0.r().l(peopleNearbyVo.getUid());
                if (contactInfoItemL != null) {
                    if (TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                        aVar2.f14990a.setText(peopleNearbyVo.getNickName());
                    } else {
                        aVar2.f14990a.setText(contactInfoItemL.getRemarkName());
                    }
                } else if (TextUtils.isEmpty(peopleNearbyVo.getRemarkName())) {
                    aVar2.f14990a.setText(peopleNearbyVo.getNickName());
                } else {
                    aVar2.f14990a.setText(peopleNearbyVo.getRemarkName());
                }
                if (peopleNearbyVo.getUid().equals(AccountUtils.p(AppContext.getContext()))) {
                    i2 = 8;
                    aVar2.c.setVisibility(8);
                } else {
                    i2 = 8;
                    aVar2.c.setVisibility(0);
                }
            } else {
                i2 = 8;
                aVar2.f14990a.setText(peopleNearbyVo.getNickName());
                aVar2.c.setVisibility(8);
            }
            if (TextUtils.isEmpty(signature)) {
                aVar2.b.setVisibility(i2);
            } else {
                aVar2.b.setVisibility(0);
                aVar2.b.setText(signature);
            }
        } else if (peopleNearbyVo.getFriendType() == 0) {
            if (peopleNearbyVo.getUid().equals(AccountUtils.p(AppContext.getContext()))) {
                aVar2.c.setVisibility(8);
            } else {
                aVar2.c.setVisibility(0);
            }
            aVar2.b.setTextColor(this.b.getResources().getColor(R.color.nearby_signature));
            aVar2.b.setText(signature);
        } else {
            if (TextUtils.isEmpty(tags)) {
                aVar2.b.setTextColor(this.b.getResources().getColor(R.color.nearby_signature));
                aVar2.b.setText(signature);
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(tags);
                    if (jSONArray.length() > 0) {
                        String strOptString = jSONArray.optString(0);
                        if (TextUtils.isEmpty(strOptString)) {
                            aVar2.b.setTextColor(this.b.getResources().getColor(R.color.nearby_signature));
                            aVar2.b.setText(signature);
                        } else {
                            aVar2.b.setTextColor(this.b.getResources().getColor(R.color.nearby_tags));
                            aVar2.b.setText(strOptString);
                        }
                    } else {
                        aVar2.b.setTextColor(this.b.getResources().getColor(R.color.nearby_signature));
                        aVar2.b.setText(signature);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    aVar2.b.setTextColor(this.b.getResources().getColor(R.color.nearby_signature));
                    aVar2.b.setText(signature);
                }
            }
            aVar2.c.setVisibility(8);
        }
        gr2.j().h(iconURL, aVar2.g, bq6.s());
        if (e.C() && zIsUnlockAd) {
            aVar2.i.setVisibility(8);
        } else {
            b(aVar2, labels);
        }
        if (TextUtils.isEmpty(peopleNearbyVo.getCarImageUrl()) || !jo6.v()) {
            aVar2.j.setVisibility(8);
        } else {
            aVar2.j.setVisibility(0);
            gr2.j().h(peopleNearbyVo.getCarImageUrl(), aVar2.j, bq6.b());
        }
        return view2;
    }
}
