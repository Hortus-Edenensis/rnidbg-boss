package com.zenmen.palmchat.chat.viewadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.LineHeightSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ChatPay;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.NoChatVo;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.config.ChatWordsizeConfig;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.database.ThreadBizExtHelper;
import defpackage.a46;
import defpackage.a65;
import defpackage.bq6;
import defpackage.c92;
import defpackage.gr2;
import defpackage.h50;
import defpackage.if6;
import defpackage.m40;
import defpackage.me1;
import defpackage.v10;
import defpackage.vl1;
import defpackage.x20;
import defpackage.x36;
import defpackage.y56;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DefaultChatViewAdapter extends SimpleChatViewAdapter {
    public ChatWordsizeConfig i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements SimpleChatViewAdapter.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h50 f12918a;
        public final /* synthetic */ MessageVo b;

        public a(h50 h50Var, MessageVo messageVo) {
            this.f12918a = h50Var;
            this.b = messageVo;
        }

        @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter.b
        public void a(int i) {
            this.f12918a.t.setTextColor(i);
        }

        @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter.b
        public void onReset() {
            Resources resources;
            int i;
            TextView textView = this.f12918a.t;
            if (this.b.isSend) {
                resources = DefaultChatViewAdapter.this.f.getResources();
                i = R.color.text_color_send;
            } else {
                resources = DefaultChatViewAdapter.this.f.getResources();
                i = R.color.Gb;
            }
            textView.setTextColor(resources.getColor(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h50 f12919a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ int c;

        public b(h50 h50Var, MessageVo messageVo, int i) {
            this.f12919a = h50Var;
            this.b = messageVo;
            this.c = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            this.f12919a.t.setTag("onLongClick");
            ChatterAdapter.h hVarX = DefaultChatViewAdapter.this.x();
            if (hVarX != null) {
                MessageVo messageVoM791clone = this.b.m791clone();
                if (1 == this.c) {
                    messageVoM791clone.text = a65.b(messageVoM791clone.text);
                }
                hVarX.m(messageVoM791clone, null);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends c92.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12920a;
        public final /* synthetic */ int b;

        public c(MessageVo messageVo, int i) {
            this.f12920a = messageVo;
            this.b = i;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            ChatterAdapter.h hVarX = DefaultChatViewAdapter.this.x();
            if (hVarX != null) {
                MessageVo messageVoM791clone = this.f12920a.m791clone();
                if (1 == this.b) {
                    messageVoM791clone.text = a65.b(messageVoM791clone.text);
                }
                hVarX.o1(messageVoM791clone);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements LineHeightSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12921a;

        public d(int i) {
            this.f12921a = i;
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            Spanned spanned = (Spanned) charSequence;
            spanned.getSpanStart(this);
            spanned.getSpanEnd(this);
            int i5 = fontMetricsInt.ascent;
            int i6 = this.f12921a;
            fontMetricsInt.ascent = i5 - (i6 / 2);
            fontMetricsInt.top -= i6 / 2;
            fontMetricsInt.descent += i6 / 2;
            fontMetricsInt.bottom += i6 / 2;
        }
    }

    @Override // defpackage.o40
    public int a() {
        return 0;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        return w(messageVo.isSend);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return h50.g(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 2;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        y(messageVo, (h50) t);
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter
    public String s(String str) {
        return !TextUtils.isEmpty(str) ? str.replace("\n", "<br>") : str;
    }

    public View w(boolean z) {
        View viewInflate = this.e.inflate(z ? R.layout.list_item_chat_right_text : R.layout.list_item_chat_left_text, (ViewGroup) null);
        if (v10.a()) {
            viewInflate.findViewById(R.id.message).setBackgroundResource(z ? R.drawable.selector_message_right_item_background_2 : R.drawable.selector_message_left_item_background_2);
        }
        return viewInflate;
    }

    public ChatterAdapter.h x() {
        return r().o();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0311 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0178  */
    @SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void y(MessageVo messageVo, h50 h50Var) {
        int iOptInt;
        int iOptInt2;
        int i;
        int i2;
        String strOptString;
        boolean z;
        Map<String, y56> mapA;
        URLSpan[] uRLSpanArr;
        int iIntValue;
        int i3;
        String strOptString2;
        String str;
        String strOptString3;
        JSONObject jSONObjectOptJSONObject;
        View view;
        TextView textView;
        String strA = "";
        try {
            if (TextUtils.isEmpty(messageVo.data2)) {
                strOptString = "";
                iOptInt = 0;
                iOptInt2 = 0;
            } else {
                JSONObject jSONObject = new JSONObject(messageVo.data2);
                iOptInt = jSONObject.optInt("linkFlag");
                try {
                    iOptInt2 = jSONObject.optInt("linkFlag2");
                    try {
                        strOptString = jSONObject.optString("richText");
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                        i = iOptInt;
                        i2 = iOptInt2;
                        strOptString = "";
                    }
                } catch (JSONException e2) {
                    e = e2;
                    iOptInt2 = 0;
                    e.printStackTrace();
                    i = iOptInt;
                    i2 = iOptInt2;
                    strOptString = "";
                    if (!messageVo.isSend) {
                    }
                    if (noChatVoA == null) {
                    }
                    if (z) {
                    }
                    if (z) {
                    }
                    v(messageVo, h50Var.t, h50Var.i, new a(h50Var, messageVo), z);
                    SpannableString spannableStringC = vl1.c(messageVo.text, this.f, vl1.c);
                    if (this.i == null) {
                    }
                    h50Var.t.setTextSize(this.i.getPlatform().getAndroid());
                    h50Var.t.setText(spannableStringC);
                    h50Var.t.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    h50Var.t.setCompoundDrawablePadding(0);
                    h50Var.t.setMaxWidth(me1.g() - me1.b(h50Var.t.getContext(), 124));
                    if (1 != i) {
                        if (1 != i) {
                        }
                        Spanned spannedFromHtml = Html.fromHtml(s(strA));
                        uRLSpanArr = (URLSpan[]) spannedFromHtml.getSpans(0, spannedFromHtml.length(), URLSpan.class);
                        if (uRLSpanArr != null) {
                        }
                    }
                    String str2 = null;
                    h50Var.t.setOnClickListener(null);
                    h50Var.t.setOnLongClickListener(new b(h50Var, messageVo, i));
                    ChatPay chatPayInfo = messageVo.getChatPayInfo();
                    if (messageVo.isSend) {
                    }
                    if (TextUtils.isEmpty(messageVo.extention)) {
                    }
                    if (TextUtils.isEmpty(str)) {
                        h50Var.s0.setVisibility(i3);
                    }
                    c92.a(h50Var.t, new c(messageVo, i));
                    view = h50Var.f;
                    if (view == null) {
                    }
                }
            }
            i = iOptInt;
            i2 = iOptInt2;
        } catch (JSONException e3) {
            e = e3;
            iOptInt = 0;
        }
        NoChatVo noChatVoA = !messageVo.isSend ? null : ThreadBizExtHelper.a(messageVo.extention);
        z = noChatVoA == null && !TextUtils.isEmpty(noChatVoA.topText);
        boolean z2 = !z && noChatVoA.style == 0;
        if (z) {
            View view2 = h50Var.H0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            TextView textView2 = h50Var.G0;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            View view3 = h50Var.J0;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            TextView textView3 = h50Var.I0;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        } else {
            int i4 = noChatVoA.style;
            if (i4 == 1) {
                View view4 = h50Var.j;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
                View view5 = h50Var.H0;
                if (view5 != null) {
                    view5.setVisibility(8);
                }
                TextView textView4 = h50Var.G0;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
                TextView textView5 = h50Var.I0;
                if (textView5 != null) {
                    textView5.setVisibility(0);
                    h50Var.I0.setText(noChatVoA.realContent);
                }
                View view6 = h50Var.J0;
                if (view6 != null) {
                    view6.setVisibility(8);
                }
            } else if (i4 == 2) {
                View view7 = h50Var.H0;
                if (view7 != null) {
                    view7.setVisibility(8);
                }
                TextView textView6 = h50Var.G0;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    h50Var.G0.setText(noChatVoA.topText);
                }
                TextView textView7 = h50Var.I0;
                if (textView7 != null) {
                    textView7.setVisibility(8);
                }
                View view8 = h50Var.J0;
                if (view8 != null) {
                    view8.setVisibility(0);
                }
            } else {
                View view9 = h50Var.H0;
                if (view9 != null) {
                    view9.setVisibility(0);
                }
                TextView textView8 = h50Var.G0;
                if (textView8 != null) {
                    textView8.setVisibility(0);
                    h50Var.G0.setText(noChatVoA.topText);
                }
                TextView textView9 = h50Var.I0;
                if (textView9 != null) {
                    textView9.setVisibility(8);
                }
                View view10 = h50Var.J0;
                if (view10 != null) {
                    view10.setVisibility(0);
                }
            }
        }
        v(messageVo, h50Var.t, h50Var.i, new a(h50Var, messageVo), z2);
        SpannableString spannableStringC2 = vl1.c(messageVo.text, this.f, vl1.c);
        if (this.i == null) {
            this.i = ChatWordsizeConfig.getChatWordsizeConfig();
        }
        h50Var.t.setTextSize(this.i.getPlatform().getAndroid());
        h50Var.t.setText(spannableStringC2);
        h50Var.t.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        h50Var.t.setCompoundDrawablePadding(0);
        h50Var.t.setMaxWidth(me1.g() - me1.b(h50Var.t.getContext(), 124));
        if (1 != i || 1 == i2) {
            if (1 != i) {
                mapA = new x36(s(messageVo.text)).a();
                strA = x20.a(this, o(), messageVo, mapA);
            } else if (1 == i2) {
                strA = strOptString;
                mapA = new x36(s(strOptString)).a();
            } else {
                mapA = null;
            }
            Spanned spannedFromHtml2 = Html.fromHtml(s(strA));
            uRLSpanArr = (URLSpan[]) spannedFromHtml2.getSpans(0, spannedFromHtml2.length(), URLSpan.class);
            if (uRLSpanArr != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml2);
                if (uRLSpanArr.length > 0) {
                    ArrayList<ActionSpan> arrayList = new ArrayList();
                    int i5 = 0;
                    for (int length = uRLSpanArr.length; i5 < length; length = length) {
                        URLSpan uRLSpan = uRLSpanArr[i5];
                        ArrayList arrayList2 = arrayList;
                        arrayList2.add(new ActionSpan(uRLSpan.getURL(), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), this.f.getResources().getColor(R.color.text_color_secretary), mapA.get(uRLSpan.getURL())));
                        i5++;
                        arrayList = arrayList2;
                    }
                    spannableStringBuilder.clearSpans();
                    for (ActionSpan actionSpan : arrayList) {
                        if (!TextUtils.isEmpty(actionSpan.mProperty.j())) {
                            try {
                                iIntValue = Integer.valueOf(actionSpan.mProperty.j()).intValue();
                            } catch (Exception unused) {
                                iIntValue = 0;
                            }
                            spannableStringBuilder.setSpan(new d(a46.b(h50Var.t.getContext(), iIntValue)), actionSpan.start, actionSpan.end, 33);
                        }
                        spannableStringBuilder.setSpan(actionSpan, actionSpan.start, actionSpan.end, 33);
                    }
                    h50Var.t.setMovementMethod(LinkMovementMethod.getInstance());
                }
                h50Var.t.setText(spannableStringBuilder);
            }
        } else {
            h50Var.t.setTag(m40.e(messageVo.from));
            com.zenmen.palmchat.utils.urlspan.a.c(h50Var.t, 15, x(), messageVo.isSend);
        }
        String str22 = null;
        h50Var.t.setOnClickListener(null);
        h50Var.t.setOnLongClickListener(new b(h50Var, messageVo, i));
        ChatPay chatPayInfo2 = messageVo.getChatPayInfo();
        if (messageVo.isSend) {
            i3 = 8;
            if (h50Var.o != null) {
                if (chatPayInfo2 == null || TextUtils.isEmpty(chatPayInfo2.getLXDForShow())) {
                    h50Var.o.setVisibility(8);
                    h50Var.n.setVisibility(8);
                } else {
                    h50Var.o.setVisibility(0);
                    h50Var.n.setVisibility(0);
                    h50Var.o.setText(chatPayInfo2.getLXDForShow());
                }
            }
        } else if (h50Var.p == null) {
            i3 = 8;
            if (h50Var.g != null && (textView = h50Var.q) != null) {
                if (messageVo.status == 3) {
                    textView.setVisibility(i3);
                } else if (chatPayInfo2 == null || !chatPayInfo2.isPayFailedWithoutMoney()) {
                    h50Var.g.setVisibility(0);
                    h50Var.q.setVisibility(i3);
                } else {
                    h50Var.g.setVisibility(i3);
                    h50Var.q.setVisibility(0);
                }
            }
        } else if (chatPayInfo2 == null || !chatPayInfo2.isCLKPay()) {
            i3 = 8;
            h50Var.p.setVisibility(8);
            if (h50Var.g != null) {
                if (messageVo.status == 3) {
                }
            }
        } else {
            h50Var.p.setVisibility(0);
            i3 = 8;
            if (h50Var.g != null) {
            }
        }
        if (TextUtils.isEmpty(messageVo.extention)) {
            try {
                JSONObject jSONObjectOptJSONObject2 = new JSONObject(messageVo.extention).optJSONObject("appMsg");
                if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(az.at)) == null) {
                    strOptString3 = null;
                    str = null;
                } else {
                    strOptString2 = jSONObjectOptJSONObject.optString("name");
                    try {
                        strOptString3 = jSONObjectOptJSONObject.optString("icon");
                        str = strOptString2;
                    } catch (JSONException e4) {
                        e = e4;
                        e.printStackTrace();
                        str = strOptString2;
                    }
                }
                str22 = strOptString3;
            } catch (JSONException e5) {
                e = e5;
                strOptString2 = null;
            }
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str) || TextUtils.isEmpty(str22)) {
            h50Var.s0.setVisibility(i3);
        } else {
            h50Var.t0.setText(str);
            gr2.j().h(str22, h50Var.u0, bq6.l());
            h50Var.s0.setVisibility(0);
        }
        c92.a(h50Var.t, new c(messageVo, i));
        view = h50Var.f;
        if (view == null) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ActionSpan extends SimpleChatViewAdapter.BaseActionSpan {
        public ActionSpan(String str, int i, int i2, y56 y56Var) {
            super(str, i, i2, y56Var);
        }

        public ActionSpan(String str, int i, int i2, int i3, y56 y56Var) {
            super(str, i, i2, i3, y56Var);
        }

        public ActionSpan(String str, int i, int i2, int i3, y56 y56Var, String str2) {
            super(str, i, i2, i3, y56Var, str2);
        }
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        return z ? 1 : 0;
    }
}
