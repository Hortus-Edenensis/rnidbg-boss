package com.zenmen.palmchat.conversations.threadsnew;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.conversations.threadsnew.adapter.ConversationAdapter;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.mine.view.LoopTextView;
import defpackage.ac1;
import defpackage.gu;
import defpackage.hc2;
import defpackage.ve;
import defpackage.zn6;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SeeMeViewHolder extends BaseRecyclerViewHolder<ConversationAdapter.e> {
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public TextView i;
    public TextView j;
    public LoopTextView k;
    public TextView l;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements LoopTextView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConversationAdapter.e f13782a;

        public a(ConversationAdapter.e eVar) {
            this.f13782a = eVar;
        }

        @Override // com.zenmen.palmchat.mine.view.LoopTextView.d
        public void a() {
            SeeMeViewHolder.v(SeeMeViewHolder.this.m(), this.f13782a.f13814a.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConversationAdapter.e f13783a;

        public b(ConversationAdapter.e eVar) {
            this.f13783a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SeeMeViewHolder.v(SeeMeViewHolder.this.m(), this.f13783a.f13814a.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConversationAdapter.e f13784a;

        public c(ConversationAdapter.e eVar) {
            this.f13784a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SeeMeViewHolder.v(SeeMeViewHolder.this.m(), this.f13784a.f13814a.d);
        }
    }

    public SeeMeViewHolder(Context context) {
        super(context, R.layout.list_item_threads_list_seeme);
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f = (ImageView) this.itemView.findViewById(R.id.avatar1);
        this.g = (ImageView) this.itemView.findViewById(R.id.avatar2);
        this.h = (ImageView) this.itemView.findViewById(R.id.avatar3);
        this.i = (TextView) this.itemView.findViewById(R.id.seeme_total);
        this.j = (TextView) this.itemView.findViewById(R.id.main_text);
        this.k = (LoopTextView) this.itemView.findViewById(R.id.desc);
        this.l = (TextView) this.itemView.findViewById(R.id.to_view);
        this.k.setText(14.0f, 0, Color.parseColor("#999999"), 8388627);
        this.k.setTextStillTime(3000L);
        this.k.setAnimTime(300L);
        this.k.enableAutoScroll(true);
        this.k.fixAnimConflict(true);
    }

    public static void u(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put("report_type", z ? "view" : "click");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("pagenewslist_seeme", null, jSONObject.toString());
    }

    public static void v(Context context, String str) {
        u(false);
        if (!TextUtils.isEmpty(str) && (context instanceof FrameworkBaseActivity)) {
            if (!str.contains("://")) {
                str = "zenxin://activity?page=a0052&pkgId=" + str;
            }
            ve.s((FrameworkBaseActivity) context, str, false);
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void o(ConversationAdapter.e eVar, int i) {
        String str;
        int size = eVar.b.c.size();
        if (size <= 0) {
            hc2.a(m()).load("").placeholder(R.drawable.default_portrait_new).transform(new gu(5, 2)).into(this.f);
            this.g.setVisibility(8);
            this.h.setVisibility(8);
        } else if (size == 1 || eVar.f13814a.g == 0) {
            hc2.a(m()).load(eVar.b.c.get(0).f13811a).placeholder(R.drawable.default_portrait_new).transform(new gu(5, 2)).into(this.f);
            this.g.setVisibility(8);
            this.h.setVisibility(8);
        } else if (size == 2) {
            hc2.a(m()).load(eVar.b.c.get(0).f13811a).placeholder(R.drawable.default_portrait_new).transform(new gu(5, 2)).into(this.f);
            hc2.a(m()).load(eVar.b.c.get(1).f13811a).placeholder(R.drawable.default_portrait_new).transform(new gu(5, 2)).into(this.g);
            this.g.setVisibility(0);
            this.h.setVisibility(8);
        } else {
            hc2.a(m()).load(eVar.b.c.get(0).f13811a).placeholder(R.drawable.default_portrait_new).transform(new gu(5, 2)).into(this.f);
            hc2.a(m()).load(eVar.b.c.get(1).f13811a).placeholder(R.drawable.default_portrait_new).transform(new gu(5, 2)).into(this.g);
            hc2.a(m()).load(eVar.b.c.get(2).f13811a).placeholder(R.drawable.default_portrait_new).transform(new gu(5, 2)).into(this.h);
            this.g.setVisibility(0);
            this.h.setVisibility(0);
        }
        long j = eVar.b.d;
        TextView textView = this.i;
        if (j > 99) {
            str = "99+";
        } else {
            str = j + "";
        }
        textView.setText(str);
        this.j.setText(eVar.b.f13810a);
        ArrayList<String> arrayList = new ArrayList<>(eVar.b.b);
        int size2 = arrayList.size();
        if (size2 <= 0) {
            this.k.setTextList(arrayList);
            this.k.setCurrentText(" ");
        } else if (size2 == 1) {
            this.k.setTextList(new ArrayList<>());
            this.k.setCurrentText(arrayList.get(0));
        } else {
            this.k.setTextList(arrayList);
            this.k.setCurrentText(arrayList.get(0));
        }
        this.k.setOnItemClickListener(new a(eVar));
        this.l.setText(eVar.f13814a.h);
        this.l.setOnClickListener(new b(eVar));
        this.itemView.setOnClickListener(new c(eVar));
    }
}
