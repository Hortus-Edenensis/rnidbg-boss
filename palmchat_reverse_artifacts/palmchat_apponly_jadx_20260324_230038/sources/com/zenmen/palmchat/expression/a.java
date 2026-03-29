package com.zenmen.palmchat.expression;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ExpressionViewPager;
import com.zenmen.palmchat.chat.InputFragment;
import com.zenmen.palmchat.expression.ExpressionPagerAdapter;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.me1;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f13945a;
    public InputFragment b;
    public ExpressionViewPager c;
    public LinearLayout d;
    public ExpressionPagerAdapter e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public boolean k;
    public boolean l;
    public g m;

    /* JADX INFO: renamed from: com.zenmen.palmchat.expression.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1046a implements View.OnClickListener {
        public ViewOnClickListenerC1046a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(a.this.c.getCurrentItem() < a.this.e.g())) {
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME104", "1", null, null);
            }
            a.this.c.setCurrentItem(0, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.c.getCurrentItem() < a.this.e.g()) {
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME105", "1", null, null);
            }
            a.this.c.setCurrentItem(2, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.c.getCurrentItem() < a.this.e.g()) {
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME105", "1", null, null);
            }
            a.this.c.setCurrentItem(1, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.c.getCurrentItem() < a.this.e.g()) {
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME105", "1", null, null);
            }
            a.this.c.setCurrentItem(3, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputFragment f13950a;

        public e(InputFragment inputFragment) {
            this.f13950a = inputFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13950a.e2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        void a(boolean z, int i);
    }

    public a(ViewGroup viewGroup, InputFragment inputFragment, g gVar, boolean z, boolean z2) {
        this.f13945a = viewGroup;
        this.b = inputFragment;
        this.m = gVar;
        this.l = z;
        this.c = (ExpressionViewPager) viewGroup.findViewById(R.id.faceViewPager);
        this.d = (LinearLayout) viewGroup.findViewById(R.id.facePagerIndicator);
        View viewFindViewById = viewGroup.findViewById(R.id.input_expression_emoji);
        this.f = viewFindViewById;
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC1046a());
        View viewFindViewById2 = viewGroup.findViewById(R.id.input_expression_favorite);
        this.g = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new b());
        View viewFindViewById3 = viewGroup.findViewById(R.id.input_expression_words);
        this.h = viewFindViewById3;
        viewFindViewById3.setOnClickListener(new c());
        View viewFindViewById4 = viewGroup.findViewById(R.id.input_expression_lby);
        this.i = viewFindViewById4;
        viewFindViewById4.setOnClickListener(new d());
        if (this.l) {
            this.g.setVisibility(8);
        }
        View viewFindViewById5 = viewGroup.findViewById(R.id.face_delete);
        this.j = viewFindViewById5;
        viewFindViewById5.setOnClickListener(new e(inputFragment));
        ExpressionPagerAdapter expressionPagerAdapter = new ExpressionPagerAdapter(inputFragment.getActivity(), inputFragment, this.c, this.l);
        this.e = expressionPagerAdapter;
        this.c.setAdapter(expressionPagerAdapter);
        this.c.setOffscreenPageLimit(4);
        this.c.addOnPageChangeListener(new f());
        k(false);
        if (this.e.n()) {
            this.h.setVisibility(0);
            this.i.setVisibility(0);
        } else {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
        }
        if (z2) {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
            this.i.setVisibility(8);
            this.c.setPagingEnabled(false);
        }
    }

    public static String e(MessageVo messageVo) {
        if (messageVo != null) {
            return messageVo.data1;
        }
        return null;
    }

    public static String f(MessageVo messageVo) {
        if (messageVo == null) {
            return null;
        }
        String str = messageVo.data3;
        if (messageVo.data4 == null) {
            return str;
        }
        try {
            String string = new JSONObject(messageVo.data4).getString("hdUrl");
            return !TextUtils.isEmpty(string) ? string : str;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public ArrayList<ExpressionObject> g() {
        return this.e.i();
    }

    public final void h(int i) {
        this.d.removeAllViews();
        if (i > 1) {
            for (int i2 = 0; i2 < i; i2++) {
                ImageView imageView = new ImageView(this.b.getActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, 0, me1.b(this.b.getActivity(), 10), 0);
                imageView.setImageResource(R.drawable.state_ball_selector);
                imageView.setLayoutParams(layoutParams);
                if (i2 == 0) {
                    imageView.setSelected(true);
                } else {
                    imageView.setSelected(false);
                }
                this.d.addView(imageView);
            }
        }
    }

    public void i(int i) {
        if (this.e.getCount() > i) {
            this.c.setCurrentItem(i, false);
        }
    }

    public void j(ArrayList<ExpressionObject> arrayList) {
        this.e.o(arrayList);
        k(true);
    }

    public final void k(boolean z) {
        g gVar;
        int currentItem = this.c.getCurrentItem();
        ExpressionPagerAdapter.ExpressionType expressionType = ExpressionPagerAdapter.ExpressionType.TYPE_EMOJI;
        ExpressionPagerAdapter expressionPagerAdapter = this.e;
        ExpressionPagerAdapter.ExpressionType expressionTypeH = expressionPagerAdapter != null ? expressionPagerAdapter.h(currentItem) : expressionType;
        boolean z2 = currentItem < this.e.g();
        if (expressionTypeH == expressionType) {
            this.f.setSelected(true);
            this.h.setSelected(false);
            this.g.setSelected(false);
            this.i.setSelected(false);
        } else if (expressionTypeH == ExpressionPagerAdapter.ExpressionType.TYPE_WORD) {
            this.f.setSelected(false);
            this.h.setSelected(true);
            this.g.setSelected(false);
            this.i.setSelected(false);
        } else if (expressionTypeH == ExpressionPagerAdapter.ExpressionType.TYPE_FAV) {
            this.f.setSelected(false);
            this.h.setSelected(false);
            this.g.setSelected(true);
            this.i.setSelected(false);
        } else {
            this.f.setSelected(false);
            this.h.setSelected(false);
            this.g.setSelected(false);
            this.i.setSelected(true);
        }
        if (!z && (gVar = this.m) != null) {
            gVar.a(z2, currentItem);
        }
        int i = ChatterActivity.P1;
        if ((i >= 0 && i < this.e.g()) != z2 || !this.k || z) {
            ExpressionPagerAdapter expressionPagerAdapter2 = this.e;
            h(z2 ? expressionPagerAdapter2.g() : expressionPagerAdapter2.j());
        }
        ChatterActivity.P1 = currentItem;
        if (!z2) {
            currentItem -= this.e.g();
        }
        for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
            View childAt = this.d.getChildAt(i2);
            if (i2 == currentItem) {
                childAt.setSelected(true);
            } else {
                childAt.setSelected(false);
            }
        }
    }

    public void l() {
        this.c.getAdapter().notifyDataSetChanged();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements ViewPager.OnPageChangeListener {
        public f() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            a.this.k = true;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.k(false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}
