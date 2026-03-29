package com.zenmen.square.moments.holder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$dimen;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.moments.PersonalMomentsFragment;
import defpackage.a46;
import defpackage.cy5;
import defpackage.gr2;
import defpackage.hr2;
import defpackage.je1;
import defpackage.k86;
import defpackage.kl5;
import defpackage.tf6;
import defpackage.tq3;
import defpackage.vl1;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PersonalMomentsViewHolder extends BaseRecyclerViewHolder<Feed> {
    public static String G = "MomentsBaseViewHolder";
    public static je1 H;
    public int A;
    public LayoutInflater B;
    public Context C;
    public PersonalMomentsFragment.g E;
    public View.OnClickListener F;
    public TextView f;
    public TextView g;
    public TextView h;
    public View i;
    public View j;
    public View k;
    public View l;
    public LinearLayout m;
    public TextView n;
    public TextView o;
    public ImageView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public ImageView t;
    public ImageView u;
    public ImageView v;
    public int w;
    public Feed x;
    public List<Feed> y;
    public boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalMomentsViewHolder.this.E.a((Feed) view.getTag(R$id.albuminfo_data_tag_id));
        }
    }

    public PersonalMomentsViewHolder(Context context, ViewGroup viewGroup, int i, int i2) {
        super(context, viewGroup, i);
        this.z = false;
        this.F = new a();
        A(this.itemView);
        this.C = context;
        this.B = ((Activity) context).getLayoutInflater();
        this.A = i2;
        this.g = (TextView) r(this.g, R$id.album_header_date);
        this.h = (TextView) r(this.h, R$id.album_header_month);
        this.f = (TextView) r(this.f, R$id.header_top_year);
        this.v = (ImageView) r(this.v, R$id.send_fail_ic);
        this.k = r(this.k, R$id.higher_margin);
        this.l = r(this.l, R$id.short_margin);
        this.i = r(this.i, R$id.album_click_area);
        this.j = r(this.j, R$id.moment_imng_empty);
        this.m = (LinearLayout) r(this.m, R$id.album_img_area);
        this.n = (TextView) r(this.n, R$id.album_img_content);
        this.o = (TextView) r(this.o, R$id.album_img_count);
        this.p = (ImageView) r(this.p, R$id.album_web);
        this.q = (TextView) r(this.q, R$id.album_web_content);
        this.r = (TextView) r(this.r, R$id.album_web_title);
        this.s = (TextView) r(this.s, R$id.album_only_text_tv);
        this.t = (ImageView) r(this.t, R$id.video_cover);
        this.u = (ImageView) r(this.u, R$id.video_icon);
    }

    public static je1 v() {
        if (H == null) {
            je1.a aVarQ = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565);
            int i = R$drawable.icon_default_thumbnail;
            H = aVarQ.B(i).A(i).z(i).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        }
        return H;
    }

    public void B(boolean z) {
        this.z = z;
    }

    public void C(List<Feed> list) {
        this.y = list;
    }

    public final void D(Feed feed, int i) {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        Long createDt = feed.getCreateDt();
        if (i != 0) {
            lValueOf = this.y.get(i - 1).getCreateDt();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(lValueOf.longValue());
        int i2 = calendar.get(1);
        int i3 = calendar.get(2);
        int i4 = calendar.get(6);
        calendar.setTimeInMillis(createDt.longValue());
        int i5 = calendar.get(1);
        int i6 = calendar.get(2);
        int i7 = calendar.get(6);
        try {
            if (i2 == i5 && i4 == i7 && i != 0) {
                this.g.setVisibility(8);
                this.h.setVisibility(8);
                this.l.setVisibility(0);
                this.k.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.l.setVisibility(8);
                this.k.setVisibility(0);
                if (feed.getCreateDt() != null) {
                    if (cy5.j(createDt.longValue())) {
                        if (i == 0) {
                            this.g.setText("今天");
                        } else {
                            this.g.setVisibility(8);
                        }
                    } else if (cy5.l(createDt.longValue()) && i3 == i6) {
                        this.g.setText("昨天");
                    } else {
                        this.g.setText(s(createDt.longValue()));
                        this.h.setVisibility(0);
                        this.h.setText(t(createDt.longValue()));
                    }
                }
            }
            if (i2 != i5) {
                this.f.setVisibility(0);
                this.f.setText(u(createDt.longValue()));
                this.l.setVisibility(8);
                this.k.setVisibility(8);
            } else {
                this.f.setVisibility(8);
            }
        } catch (Exception unused) {
            this.g.setVisibility(8);
            this.l.setVisibility(0);
            this.k.setVisibility(8);
        }
        if (i == 0 && i2 == i5) {
            this.l.setVisibility(8);
            this.k.setVisibility(0);
        }
    }

    public void E(PersonalMomentsFragment.g gVar) {
        this.E = gVar;
    }

    public final View r(View view, int i) {
        View view2;
        return (i <= 0 || (view2 = this.itemView) == null || view != null) ? view : view2.findViewById(i);
    }

    public Spannable s(long j) {
        Date date = new Date();
        try {
            date.setTime(j);
        } catch (Exception unused) {
        }
        SpannableString spannableString = new SpannableString(new SimpleDateFormat("dd").format(date));
        spannableString.setSpan(new AbsoluteSizeSpan(this.C.getResources().getDimensionPixelSize(R$dimen.friend_album_date_font)), 2, spannableString.length(), 33);
        return spannableString;
    }

    public String t(long j) {
        Date date = new Date();
        try {
            date.setTime(j);
        } catch (Exception unused) {
        }
        return new SimpleDateFormat("M月").format(date);
    }

    public String u(long j) {
        Date date = new Date();
        try {
            date.setTime(j);
        } catch (Exception unused) {
        }
        return new SimpleDateFormat("yyyy年").format(date);
    }

    public final String w(Media media) {
        LogUtil.d(G, "getThumbUrl url = " + media.localThumbPath + ",midUrl = " + media.midUrl + ", url = " + media.url);
        if (media.localThumbPath != null && new File(media.localThumbPath).exists()) {
            return media.localThumbPath;
        }
        String str = media.midUrl;
        return str != null ? str : media.url;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void o(Feed feed, int i) {
        if (feed == null) {
            Log.e(G, "data is null");
            return;
        }
        this.x = feed;
        this.w = i;
        z(feed, i);
        View view = this.i;
        if (view != null) {
            view.setOnClickListener(this.F);
            this.i.setTag(R$id.albuminfo_data_tag_id, feed);
        }
        y(feed, i, n());
    }

    public final void z(Feed feed, int i) {
        Media media;
        int size;
        this.A = feed.getFeedType();
        D(feed, i);
        int iB = a46.b(this.C, 80.0f);
        int iB2 = a46.b(this.C, 80.0f);
        int i2 = this.A;
        if (i2 != 2) {
            if (i2 == -1) {
                this.g.setText("今天");
                LinearLayout linearLayout = this.m;
                if (linearLayout != null) {
                    linearLayout.removeAllViews();
                    this.B.inflate(R$layout.personal_moments_cover_count1, this.m);
                    ((ImageView) this.m.findViewById(R$id.count1_img)).setImageResource(R$drawable.ic_feed_publish);
                    return;
                }
                return;
            }
            if (i2 == 4 || i2 == 7) {
                if (this.v != null) {
                    if (feed.getStatus() == tq3.h) {
                        this.v.setVisibility(0);
                    } else {
                        this.v.setVisibility(8);
                    }
                }
                if (this.q != null) {
                    tf6.a(kl5.c(feed.getContent()) ? 0 : 8, this.q);
                    this.q.setText(vl1.c(feed.getContent(), c.b(), vl1.i));
                }
                if (this.r == null || feed.getMediaList() == null || feed.getMediaList().size() <= 0 || (media = feed.getMediaList().get(0)) == null) {
                    return;
                }
                String str = media.thumbUrl;
                String str2 = media.title;
                gr2.j().h(str, this.p, this.z ? hr2.d(1.0f, 15) : hr2.e());
                this.r.setText(str2);
                return;
            }
            if (i2 == 1) {
                if (this.v != null) {
                    if (feed.getStatus() == tq3.h) {
                        this.v.setVisibility(0);
                    } else {
                        this.v.setVisibility(8);
                    }
                }
                if (this.s != null) {
                    this.s.setText(vl1.c(feed.getContent(), c.b(), vl1.i));
                    return;
                }
                return;
            }
            if (i2 == 3 || i2 == 6) {
                LogUtil.d(G, "mViewType = " + this.A);
                if (this.v != null) {
                    if (feed.getStatus() == tq3.h) {
                        this.v.setVisibility(0);
                    } else {
                        this.v.setVisibility(8);
                    }
                }
                if (this.t != null && feed.getMediaList() != null && feed.getMediaList().size() > 0) {
                    je1 je1VarF = this.z ? hr2.f(1.0f, 15) : v();
                    String strW = w(feed.getMediaList().get(0));
                    if (this.A == 3) {
                        strW = a46.g(iB, iB2, k86.p(strW));
                    }
                    gr2.j().h(strW, this.t, je1VarF);
                }
                if (this.n != null) {
                    SpannableString spannableStringC = vl1.c(feed.getContent(), c.b(), vl1.i);
                    if (TextUtils.isEmpty(spannableStringC)) {
                        this.n.setVisibility(8);
                        return;
                    } else {
                        this.n.setText(spannableStringC);
                        this.n.setVisibility(0);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (this.v != null) {
            if (feed.getStatus() == tq3.h) {
                this.v.setVisibility(0);
            } else {
                this.v.setVisibility(8);
            }
        }
        LinearLayout linearLayout2 = this.m;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
            if (feed.getMediaList() != null && feed.getMediaList().size() > 0) {
                je1 je1VarF2 = this.z ? hr2.f(1.0f, 15) : hr2.g();
                if (feed.getMediaList().size() == 1) {
                    String str3 = !TextUtils.isEmpty(feed.getMediaList().get(0).localPath) ? feed.getMediaList().get(0).localPath : feed.getMediaList().get(0).thumbUrl;
                    this.B.inflate(R$layout.personal_moments_cover_count1, this.m);
                    gr2.j().h(a46.g(iB, iB2, k86.p(str3)), (ImageView) this.m.findViewById(R$id.count1_img), je1VarF2);
                } else if (feed.getMediaList().size() == 2) {
                    String str4 = feed.getMediaList().get(0).localPath;
                    String str5 = feed.getMediaList().get(1).localPath;
                    if (TextUtils.isEmpty(str4)) {
                        str4 = feed.getMediaList().get(0).thumbUrl;
                    }
                    if (TextUtils.isEmpty(str5)) {
                        str5 = feed.getMediaList().get(1).thumbUrl;
                    }
                    this.B.inflate(R$layout.personal_moments_cover_count2, this.m);
                    ImageView imageView = (ImageView) this.m.findViewById(R$id.count2_img1);
                    ImageView imageView2 = (ImageView) this.m.findViewById(R$id.count2_img2);
                    gr2.j().h(a46.g(iB, iB2, k86.p(str4)), imageView, je1VarF2);
                    gr2.j().h(a46.g(iB, iB2, k86.p(str5)), imageView2, je1VarF2);
                } else if (feed.getMediaList().size() == 3) {
                    String str6 = feed.getMediaList().get(0).localPath;
                    String str7 = feed.getMediaList().get(1).localPath;
                    String str8 = feed.getMediaList().get(2).localPath;
                    if (TextUtils.isEmpty(str6)) {
                        str6 = feed.getMediaList().get(0).thumbUrl;
                    }
                    if (TextUtils.isEmpty(str7)) {
                        str7 = feed.getMediaList().get(1).thumbUrl;
                    }
                    if (TextUtils.isEmpty(str8)) {
                        str8 = feed.getMediaList().get(2).thumbUrl;
                    }
                    this.B.inflate(R$layout.personal_moments_cover_count3, this.m);
                    ImageView imageView3 = (ImageView) this.m.findViewById(R$id.count3_img1);
                    ImageView imageView4 = (ImageView) this.m.findViewById(R$id.count3_img2);
                    ImageView imageView5 = (ImageView) this.m.findViewById(R$id.count3_img3);
                    gr2.j().h(a46.g(iB, iB2, k86.p(str6)), imageView3, je1VarF2);
                    gr2.j().h(a46.g(iB, iB2, k86.p(str7)), imageView4, je1VarF2);
                    gr2.j().h(a46.g(iB, iB2, k86.p(str8)), imageView5, je1VarF2);
                } else {
                    String str9 = feed.getMediaList().get(0).localPath;
                    String str10 = feed.getMediaList().get(1).localPath;
                    String str11 = feed.getMediaList().get(2).localPath;
                    String str12 = feed.getMediaList().get(3).localPath;
                    if (TextUtils.isEmpty(str9)) {
                        str9 = feed.getMediaList().get(0).thumbUrl;
                    }
                    if (TextUtils.isEmpty(str10)) {
                        str10 = feed.getMediaList().get(1).thumbUrl;
                    }
                    if (TextUtils.isEmpty(str11)) {
                        str11 = feed.getMediaList().get(2).thumbUrl;
                    }
                    if (TextUtils.isEmpty(str12)) {
                        str12 = feed.getMediaList().get(3).thumbUrl;
                    }
                    this.B.inflate(R$layout.personal_moments_cover_count4, this.m);
                    ImageView imageView6 = (ImageView) this.m.findViewById(R$id.count4_img1);
                    ImageView imageView7 = (ImageView) this.m.findViewById(R$id.count4_img2);
                    ImageView imageView8 = (ImageView) this.m.findViewById(R$id.count4_img3);
                    ImageView imageView9 = (ImageView) this.m.findViewById(R$id.count4_img4);
                    gr2.j().h(a46.g(iB, iB2, k86.p(str9)), imageView6, je1VarF2);
                    gr2.j().h(a46.g(iB, iB2, k86.p(str10)), imageView7, je1VarF2);
                    gr2.j().h(a46.g(iB, iB2, k86.p(str11)), imageView8, je1VarF2);
                    gr2.j().h(a46.g(iB, iB2, k86.p(str12)), imageView9, je1VarF2);
                }
            }
            if (this.o != null) {
                size = feed.getMediaList() != null ? feed.getMediaList().size() : 0;
                if (size == 1) {
                    this.o.setVisibility(8);
                } else {
                    this.o.setVisibility(0);
                    this.o.setText("共" + String.valueOf(size) + "张");
                }
            } else {
                size = 0;
            }
            if (this.n != null) {
                SpannableString spannableStringC2 = vl1.c(feed.getContent(), c.b(), vl1.i);
                boolean zIsEmpty = TextUtils.isEmpty(spannableStringC2);
                if (zIsEmpty) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setText(spannableStringC2);
                    this.n.setVisibility(0);
                }
                View view = this.j;
                if (view != null) {
                    if (!zIsEmpty || (zIsEmpty && size > 1)) {
                        view.setVisibility(0);
                    } else {
                        view.setVisibility(8);
                    }
                }
            }
        }
    }

    public void A(@NonNull View view) {
    }

    public void y(@NonNull Feed feed, int i, int i2) {
    }
}
