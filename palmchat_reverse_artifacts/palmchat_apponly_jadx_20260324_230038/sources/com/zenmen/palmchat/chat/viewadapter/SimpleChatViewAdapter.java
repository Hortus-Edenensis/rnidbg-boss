package com.zenmen.palmchat.chat.viewadapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.ss.android.ttvecamera.TECameraSettings;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ChatBubbleVo;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.az2;
import defpackage.b65;
import defpackage.hc2;
import defpackage.mb4;
import defpackage.me1;
import defpackage.o40;
import defpackage.p40;
import defpackage.x36;
import defpackage.y56;
import defpackage.yx3;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class SimpleChatViewAdapter implements o40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChatItem f12922a;
    public int b;
    public ChatterAdapter.h c;
    public ContactInfoItem d;
    public LayoutInflater e;
    public Context f;
    public int g;
    public p40 h;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends CustomTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12923a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ b c;
        public final /* synthetic */ ChatBubbleVo d;

        public a(View view, MessageVo messageVo, b bVar, ChatBubbleVo chatBubbleVo) {
            this.f12923a = view;
            this.b = messageVo;
            this.c = bVar;
            this.d = chatBubbleVo;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
            Context context;
            int i;
            Object tag = this.f12923a.getTag(R.id.tag_bubble);
            if ((tag instanceof String) && TextUtils.equals((String) tag, this.b.mid)) {
                View view = this.f12923a;
                if (this.b.isSend) {
                    context = SimpleChatViewAdapter.this.f;
                    i = R.drawable.selector_message_right_item_background_bubble;
                } else {
                    context = SimpleChatViewAdapter.this.f;
                    i = R.drawable.selector_message_left_item_background_bubble;
                }
                view.setBackground(AppCompatResources.getDrawable(context, i));
                this.c.onReset();
            }
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
            Context context;
            int i;
            Object tag = this.f12923a.getTag(R.id.tag_bubble);
            if ((tag instanceof String) && TextUtils.equals((String) tag, this.b.mid)) {
                View view = this.f12923a;
                if (this.b.isSend) {
                    context = SimpleChatViewAdapter.this.f;
                    i = R.drawable.selector_message_right_item_background_bubble;
                } else {
                    context = SimpleChatViewAdapter.this.f;
                    i = R.drawable.selector_message_left_item_background_bubble;
                }
                view.setBackground(AppCompatResources.getDrawable(context, i));
                this.c.onReset();
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }

        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            Resources resources;
            int i;
            Object tag = this.f12923a.getTag(R.id.tag_bubble);
            if ((tag instanceof String) && TextUtils.equals((String) tag, this.b.mid) && bitmap != null) {
                bitmap.setDensity(TECameraSettings.FPS_480);
                this.f12923a.setBackground(new yx3(SimpleChatViewAdapter.this.f.getResources(), bitmap).a(1).b(1).c());
                if (this.b.isSend) {
                    resources = SimpleChatViewAdapter.this.f.getResources();
                    i = R.color.text_color_send;
                } else {
                    resources = SimpleChatViewAdapter.this.f.getResources();
                    i = R.color.Gb;
                }
                int color = resources.getColor(i);
                try {
                    color = Color.parseColor(this.d.bubbleTextColor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f12923a.setPadding(me1.b(SimpleChatViewAdapter.this.f, 23), me1.b(SimpleChatViewAdapter.this.f, 17), me1.b(SimpleChatViewAdapter.this.f, 23), me1.b(SimpleChatViewAdapter.this.f, 17));
                this.c.a(color);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(int i);

        void onReset();
    }

    @Override // defpackage.o40
    public void d(int i) {
        this.b = i;
    }

    @Override // defpackage.o40
    public void e(ChatterAdapter.h hVar) {
        this.c = hVar;
    }

    @Override // defpackage.o40
    public void f(Context context, ChatItem chatItem) {
        this.f = context;
        k(chatItem);
        this.e = LayoutInflater.from(context);
    }

    @Override // defpackage.o40
    public void g(int i) {
        this.g = i - a();
    }

    @Override // defpackage.o40
    public void h(p40 p40Var) {
        this.h = p40Var;
    }

    @Override // defpackage.o40
    public void i(ContactInfoItem contactInfoItem) {
        this.d = contactInfoItem;
    }

    @Override // defpackage.o40
    public final int j(boolean z, int i, MessageVo messageVo) {
        int iM = m(z, i, messageVo);
        return iM != -1 ? iM + this.g : iM;
    }

    @Override // defpackage.o40
    public void k(ChatItem chatItem) {
        this.f12922a = chatItem;
    }

    public int n() {
        return this.b;
    }

    public ChatItem o() {
        return this.f12922a;
    }

    public ContactInfoItem p() {
        return this.d;
    }

    public ChatterAdapter.h q() {
        return this.c;
    }

    public p40 r() {
        return this.h;
    }

    public String s(String str) {
        return !TextUtils.isEmpty(str) ? str.replace("\n", "<br>") : str;
    }

    public void t(MessageVo messageVo, TextView textView) {
        boolean z;
        try {
            JSONObject jSONObject = new JSONObject(messageVo.extention);
            if (!mb4.k(jSONObject.optString("actionTypes"))) {
                textView.setText(messageVo.text);
                textView.getPaint().setFlags(0);
                textView.setTextColor(this.f.getResources().getColor(R.color.Gd));
                textView.setOnClickListener(null);
                textView.getPaint().setAntiAlias(true);
                return;
            }
            boolean zContains = jSONObject.getString("actionBody").contains("a0105");
            Spanned spannedFromHtml = Html.fromHtml(s(jSONObject.getString("actionBody")));
            URLSpan[] uRLSpanArr = (URLSpan[]) spannedFromHtml.getSpans(0, spannedFromHtml.length(), URLSpan.class);
            if (uRLSpanArr != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
                if (uRLSpanArr.length > 0) {
                    ArrayList<BaseActionSpan> arrayList = new ArrayList();
                    Map<String, y56> mapA = new x36(s(jSONObject.getString("actionBody"))).a();
                    int length = uRLSpanArr.length;
                    int i = 0;
                    while (i < length) {
                        URLSpan uRLSpan = uRLSpanArr[i];
                        if (zContains) {
                            z = zContains;
                            arrayList.add(new BaseActionSpan(uRLSpan.getURL(), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), this.f.getResources().getColor(R.color.color_message_link_videocall), mapA.get(uRLSpan.getURL())));
                        } else {
                            z = zContains;
                            arrayList.add(new BaseActionSpan(uRLSpan.getURL(), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), mapA.get(uRLSpan.getURL())));
                        }
                        i++;
                        zContains = z;
                    }
                    spannableStringBuilder.clearSpans();
                    for (BaseActionSpan baseActionSpan : arrayList) {
                        spannableStringBuilder.setSpan(baseActionSpan, baseActionSpan.start, baseActionSpan.end, 33);
                    }
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                textView.setText(spannableStringBuilder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void u(MessageVo messageVo, View view, View view2, b bVar) {
        v(messageVo, view, view2, bVar, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(MessageVo messageVo, View view, View view2, b bVar, boolean z) {
        Context context;
        int i;
        ChatBubbleVo chatBubbleVo;
        boolean z2 = false;
        if (!TextUtils.isEmpty(messageVo.extention) && !z) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(messageVo.extention).optJSONObject("chatBubble");
                if (jSONObjectOptJSONObject != null && (chatBubbleVo = (ChatBubbleVo) az2.a(jSONObjectOptJSONObject.toString(), ChatBubbleVo.class)) != null && chatBubbleVo.bubbleType == 1) {
                    boolean z3 = messageVo.isSend;
                    if (!z3 || chatBubbleVo.send == null) {
                        if (!z3) {
                            if (chatBubbleVo.rev != null) {
                                try {
                                    String str = (z3 ? chatBubbleVo.send : chatBubbleVo.rev).bubbleUrl;
                                    view.setTag(R.id.tag_bubble, messageVo.mid);
                                    hc2.a(this.f).asBitmap().diskCacheStrategy(DiskCacheStrategy.DATA).override(Integer.MIN_VALUE).load(str).into(new a(view, messageVo, bVar, chatBubbleVo));
                                    z2 = true;
                                } catch (JSONException e) {
                                    e = e;
                                    z2 = true;
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
        }
        if (z2) {
            return;
        }
        bVar.onReset();
        if (z && !messageVo.isSend) {
            view.setBackground(AppCompatResources.getDrawable(this.f, R.drawable.selector_message_left_item_background_bubble_nochat));
            return;
        }
        if (messageVo.isSend) {
            context = this.f;
            i = R.drawable.selector_message_right_item_background_bubble;
        } else {
            context = this.f;
            i = R.drawable.selector_message_left_item_background_bubble;
        }
        view.setBackground(AppCompatResources.getDrawable(context, i));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class BaseActionSpan extends URLSpan {
        private String contactRelate;
        public int end;
        private int mColor;
        public y56 mProperty;
        private String mUrl;
        public int start;

        public BaseActionSpan(String str, int i, int i2, y56 y56Var) {
            super(str);
            this.mColor = -1;
            this.mUrl = str;
            this.start = i;
            this.end = i2;
            this.mProperty = y56Var;
            onShow();
        }

        private Integer getFontColor() {
            y56 y56Var = this.mProperty;
            if (y56Var != null && !TextUtils.isEmpty(y56Var.h())) {
                try {
                    return Integer.valueOf(Color.parseColor(this.mProperty.h()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        private void onShow() {
            ChatterAdapter.g gVarH;
            if (this.mUrl == null || SimpleChatViewAdapter.this.r() == null || (gVarH = SimpleChatViewAdapter.this.r().h()) == null) {
                return;
            }
            gVarH.W0(this.mUrl);
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            Pair<Integer, ContentValues> pairG;
            if ("onLongClick".equals(view.getTag())) {
                view.setTag(null);
                return;
            }
            if (TextUtils.isEmpty(this.mUrl) || (pairG = mb4.g(this.mUrl)) == null) {
                return;
            }
            if (this.contactRelate != null && b65.a().b(this.contactRelate)) {
                b65.c();
                return;
            }
            ChatterAdapter.g gVarH = SimpleChatViewAdapter.this.r().h();
            if (gVarH != null) {
                gVarH.b1(this.mUrl, ((Integer) pairG.first).intValue(), (ContentValues) pairG.second, this.mProperty);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            Integer fontColor = getFontColor();
            if (fontColor != null) {
                textPaint.setColor(fontColor.intValue());
                return;
            }
            int i = this.mColor;
            if (-1 != i) {
                textPaint.setColor(i);
            } else {
                textPaint.setColor(SimpleChatViewAdapter.this.f.getResources().getColor(R.color.text_color_secretary));
            }
        }

        public BaseActionSpan(String str, int i, int i2, int i3, y56 y56Var) {
            super(str);
            this.mUrl = str;
            this.start = i;
            this.end = i2;
            this.mColor = i3;
            this.mProperty = y56Var;
            onShow();
        }

        public BaseActionSpan(String str, int i, int i2, int i3, y56 y56Var, String str2) {
            super(str);
            this.mUrl = str;
            this.start = i;
            this.end = i2;
            this.mColor = i3;
            this.mProperty = y56Var;
            this.contactRelate = str2;
            onShow();
        }
    }
}
