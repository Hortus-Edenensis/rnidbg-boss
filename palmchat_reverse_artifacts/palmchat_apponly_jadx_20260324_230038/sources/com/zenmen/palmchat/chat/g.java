package com.zenmen.palmchat.chat;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.AdditionItem;
import com.zenmen.palmchat.Vo.LabelItem;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.NoticeBarStyle;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.Vo.RichMsgExVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.AutoResizeImageView;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.az2;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.by5;
import defpackage.cy5;
import defpackage.f33;
import defpackage.gr2;
import defpackage.h50;
import defpackage.jo6;
import defpackage.me1;
import defpackage.me3;
import defpackage.pu1;
import defpackage.rl0;
import defpackage.v10;
import defpackage.vl1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class g {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterAdapter.h f12848a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ int c;

        public a(ChatterAdapter.h hVar, MessageVo messageVo, int i) {
            this.f12848a = hVar;
            this.b = messageVo;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatterAdapter.h hVar = this.f12848a;
            if (hVar != null) {
                hVar.H(this.b, Integer.valueOf(this.c));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterAdapter.h f12849a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ int c;

        public b(ChatterAdapter.h hVar, MessageVo messageVo, int i) {
            this.f12849a = hVar;
            this.b = messageVo;
            this.c = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ChatterAdapter.h hVar = this.f12849a;
            if (hVar == null) {
                return true;
            }
            hVar.m(this.b, Integer.valueOf(this.c));
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterAdapter.h f12850a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ int c;

        public c(ChatterAdapter.h hVar, MessageVo messageVo, int i) {
            this.f12850a = hVar;
            this.b = messageVo;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatterAdapter.h hVar = this.f12850a;
            if (hVar != null) {
                hVar.H(this.b, Integer.valueOf(this.c));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterAdapter.h f12851a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ int c;

        public d(ChatterAdapter.h hVar, MessageVo messageVo, int i) {
            this.f12851a = hVar;
            this.b = messageVo;
            this.c = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ChatterAdapter.h hVar = this.f12851a;
            if (hVar == null) {
                return true;
            }
            hVar.m(this.b, Integer.valueOf(this.c));
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterAdapter.h f12852a;
        public final /* synthetic */ MessageVo b;

        public e(ChatterAdapter.h hVar, MessageVo messageVo) {
            this.f12852a = hVar;
            this.b = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatterAdapter.h hVar = this.f12852a;
            if (hVar != null) {
                hVar.H(this.b, 0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterAdapter.h f12853a;
        public final /* synthetic */ MessageVo b;

        public f(ChatterAdapter.h hVar, MessageVo messageVo) {
            this.f12853a = hVar;
            this.b = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ChatterAdapter.h hVar = this.f12853a;
            if (hVar == null) {
                return true;
            }
            hVar.m(this.b, null);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.chat.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC0993g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterAdapter.h f12854a;
        public final /* synthetic */ MessageVo b;

        public ViewOnClickListenerC0993g(ChatterAdapter.h hVar, MessageVo messageVo) {
            this.f12854a = hVar;
            this.b = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatterAdapter.h hVar = this.f12854a;
            if (hVar != null) {
                hVar.H(this.b, null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterAdapter.h f12855a;
        public final /* synthetic */ MessageVo b;

        public h(ChatterAdapter.h hVar, MessageVo messageVo) {
            this.f12855a = hVar;
            this.b = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ChatterAdapter.h hVar = this.f12855a;
            if (hVar == null) {
                return true;
            }
            hVar.m(this.b, null);
            return true;
        }
    }

    public static void a(Context context, RichMsgExVo richMsgExVo, MessageVo messageVo, h50 h50Var, @Nullable ChatterAdapter.h hVar, int i) {
        ArrayList<RichMsgExItemVo> arrayList;
        if (richMsgExVo != null && (arrayList = richMsgExVo.items) != null && arrayList.size() > 0) {
            d(context, richMsgExVo, messageVo, hVar, m(context, messageVo, richMsgExVo, h50Var), i);
            h50Var.U.setOnClickListener(new e(hVar, messageVo));
            h50Var.U.setOnLongClickListener(new f(hVar, messageVo));
        } else {
            h50Var.m0.removeAllViews();
            h50Var.v0 = null;
            h50Var.U.setOnClickListener(new ViewOnClickListenerC0993g(hVar, messageVo));
            h50Var.U.setOnLongClickListener(new h(hVar, messageVo));
        }
    }

    public static void b(Context context, MessageVo messageVo, h50 h50Var, @Nullable ChatterAdapter.h hVar, @Nullable List<String> list) {
        c(context, messageVo, h50Var, hVar, list, 1);
    }

    public static void c(Context context, MessageVo messageVo, h50 h50Var, @Nullable ChatterAdapter.h hVar, @Nullable List<String> list, int i) {
        int i2;
        int i3;
        RichMsgExVo richMsgExVoH = h(messageVo);
        boolean z = i != 2 && t(messageVo, richMsgExVoH);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) h50Var.l0.getLayoutParams();
        if (z) {
            layoutParams.setMargins(0, 0, 0, 0);
            h50Var.i.setVisibility(0);
            if (richMsgExVoH != null) {
                if (messageVo.isSend) {
                    layoutParams.setMargins(0, 0, (int) context.getResources().getDimension(R.dimen.text_size_8), 0);
                } else {
                    layoutParams.setMargins((int) context.getResources().getDimension(R.dimen.text_size_8), 0, 0, 0);
                }
                ArrayList<RichMsgExItemVo> arrayList = richMsgExVoH.items;
                if (arrayList != null && arrayList.size() == 1 && o(messageVo, richMsgExVoH.items.get(0)) == 7) {
                    w(h50Var.l0, messageVo.isSend, -2);
                } else {
                    ArrayList<RichMsgExItemVo> arrayList2 = richMsgExVoH.items;
                    if (arrayList2 != null && arrayList2.size() == 1 && o(messageVo, richMsgExVoH.items.get(0)) == 11) {
                        w(h50Var.l0, messageVo.isSend, me1.b(context, 170));
                    } else {
                        ArrayList<RichMsgExItemVo> arrayList3 = richMsgExVoH.items;
                        if (arrayList3 != null && arrayList3.size() == 1 && (o(messageVo, richMsgExVoH.items.get(0)) == 14 || o(messageVo, richMsgExVoH.items.get(0)) == 15)) {
                            w(h50Var.l0, messageVo.isSend, me1.b(context, 170));
                        } else {
                            w(h50Var.l0, messageVo.isSend, me1.g() - (((int) context.getResources().getDimension(R.dimen.chat_conetnt_margin_left_or_full)) * 2));
                        }
                    }
                }
            } else {
                w(h50Var.l0, messageVo.isSend, me1.b(context, 90));
            }
        } else {
            int iB = me1.b(context, 5);
            layoutParams.setMargins(iB, 0, iB, 0);
            h50Var.i.setVisibility(8);
            w(h50Var.l0, messageVo.isSend, -1);
        }
        if (z) {
            if (messageVo.isSend) {
                if (v10.a()) {
                    h50Var.U.setBackgroundResource(R.drawable.selector_message_file_right_item_background_2);
                } else {
                    h50Var.U.setBackgroundResource(R.drawable.selector_message_file_right_item_background);
                }
            } else if (v10.a()) {
                h50Var.U.setBackgroundResource(R.drawable.selector_message_file_left_item_background_2);
            } else {
                h50Var.U.setBackgroundResource(R.drawable.selector_message_file_left_item_background);
            }
        } else if (v10.a()) {
            h50Var.U.setBackgroundResource(R.drawable.selector_richmsg_item_background_2);
        } else {
            h50Var.U.setBackgroundResource(R.drawable.selector_richmsg_item_background);
        }
        a(context, richMsgExVoH, messageVo, h50Var, hVar, i);
        if (richMsgExVoH != null) {
            AdditionItem additionItem = richMsgExVoH.header;
            if (additionItem == null || TextUtils.isEmpty(additionItem.name)) {
                h50Var.n0.setVisibility(8);
            } else {
                h50Var.n0.setVisibility(0);
                h50Var.o0.setText(richMsgExVoH.header.name);
                gr2.j().h(richMsgExVoH.header.icon, h50Var.p0, bq6.s());
            }
            AdditionItem additionItem2 = richMsgExVoH.footer;
            if (additionItem2 == null || TextUtils.isEmpty(additionItem2.name)) {
                h50Var.q0.setVisibility(8);
            } else {
                h50Var.q0.setVisibility(0);
                h50Var.r0.setText(richMsgExVoH.footer.name);
            }
            AdditionItem additionItem3 = richMsgExVoH.source;
            if (additionItem3 == null || TextUtils.isEmpty(additionItem3.name)) {
                h50Var.s0.setVisibility(8);
            } else {
                h50Var.s0.setVisibility(0);
                h50Var.t0.setText(richMsgExVoH.source.name);
                ArrayList<RichMsgExItemVo> arrayList4 = richMsgExVoH.items;
                RichMsgExItemVo richMsgExItemVo = (arrayList4 == null || arrayList4.size() <= 0) ? null : richMsgExVoH.items.get(0);
                if (richMsgExItemVo == null || !((i3 = richMsgExItemVo.showType) == 6 || i3 == 15)) {
                    gr2.j().h(richMsgExVoH.source.icon, h50Var.u0, bq6.l());
                } else {
                    gr2.j().h(richMsgExVoH.source.icon, h50Var.u0, bq6.q());
                }
                if (richMsgExItemVo == null || !((i2 = richMsgExItemVo.showType) == 11 || i2 == 14)) {
                    h50Var.s0.setClickable(false);
                } else {
                    h50Var.s0.setClickable(true);
                }
            }
        } else {
            h50Var.n0.setVisibility(8);
            h50Var.q0.setVisibility(0);
            h50Var.r0.setText(R.string.message_type_link);
            h50Var.s0.setVisibility(8);
        }
        v(messageVo, richMsgExVoH, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:304:0x0964  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x097f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(Context context, RichMsgExVo richMsgExVo, MessageVo messageVo, ChatterAdapter.h hVar, ArrayList<ViewGroup> arrayList, int i) {
        ChatterAdapter.h hVar2;
        int i2;
        int i3;
        int iF;
        int iF2;
        View viewFindViewById;
        int i4;
        int i5;
        ChatterAdapter.h hVar3 = hVar;
        ArrayList<RichMsgExItemVo> arrayList2 = richMsgExVo.items;
        int i6 = 0;
        while (i6 < arrayList2.size()) {
            RichMsgExItemVo richMsgExItemVo = arrayList2.get(i6);
            ViewGroup viewGroup = arrayList.size() > i6 ? arrayList.get(i6) : null;
            int iO = o(messageVo, richMsgExItemVo);
            if (viewGroup != null) {
                if (iO >= 0 && iO <= 4) {
                    TextView textView = (TextView) viewGroup.findViewById(R.id.title);
                    TextView textView2 = (TextView) viewGroup.findViewById(R.id.digest);
                    TextView textView3 = (TextView) viewGroup.findViewById(R.id.time);
                    ImageView imageView = (ImageView) viewGroup.findViewById(R.id.icon);
                    if (iO == 0 && !TextUtils.isEmpty(messageVo.extention) && messageVo.extention.equals("message_type_link_illegal")) {
                        textView.setText(R.string.rich_message_title_illegal);
                        textView2.setText(R.string.rich_message_digest_illegal);
                        gr2.j().h(null, imageView, bq6.l());
                    } else {
                        if (textView != null) {
                            textView.setText(richMsgExItemVo.title);
                        }
                        if (textView2 != null) {
                            textView2.setText(richMsgExItemVo.digest);
                        }
                        if (textView3 != null) {
                            textView3.setText(by5.e(richMsgExItemVo.pubTime, context));
                        }
                        if (imageView != null) {
                            gr2.j().h(richMsgExItemVo.cover, imageView, bq6.l());
                        }
                    }
                    if (iO == 3) {
                        if (richMsgExItemVo.pubTime > 0) {
                            i4 = 0;
                            textView3.setVisibility(0);
                            i5 = 8;
                        } else {
                            i4 = 0;
                            i5 = 8;
                            textView3.setVisibility(8);
                        }
                        if (TextUtils.isEmpty(richMsgExItemVo.digest)) {
                            textView2.setVisibility(i5);
                        } else {
                            textView2.setVisibility(i4);
                        }
                        TextView textView4 = (TextView) viewGroup.findViewById(R.id.readNum);
                        if (textView4 != null) {
                            if (bo0.r().j() <= 0 || richMsgExItemVo.readNum <= 0 || !jo6.d("LX-19235")) {
                                textView4.setVisibility(8);
                            } else {
                                textView4.setVisibility(0);
                                textView4.setText(context.getString(R.string.text_contact_count_read, Integer.valueOf(richMsgExItemVo.readNum)));
                            }
                        }
                    }
                    if (iO == 2 && (viewFindViewById = viewGroup.findViewById(R.id.tag)) != null) {
                        if (r(richMsgExItemVo)) {
                            viewFindViewById.setVisibility(0);
                        } else {
                            viewFindViewById.setVisibility(8);
                        }
                    }
                    if (richMsgExItemVo.showType == 0) {
                        View viewFindViewById2 = viewGroup.findViewById(R.id.commentLayout);
                        View viewFindViewById3 = viewGroup.findViewById(R.id.extraLayout);
                        int i7 = richMsgExItemVo.subType;
                        if (i7 == 1 || i7 == 4) {
                            viewFindViewById2.setVisibility(8);
                            viewFindViewById3.setVisibility(0);
                            TextView textView5 = (TextView) viewGroup.findViewById(R.id.extraTitle);
                            TextView textView6 = (TextView) viewGroup.findViewById(R.id.extraDigest);
                            ImageView imageView2 = (ImageView) viewGroup.findViewById(R.id.extraIcon);
                            textView5.setText(richMsgExItemVo.title);
                            textView6.setText(richMsgExItemVo.digest);
                            gr2.j().h(richMsgExItemVo.cover, imageView2, bq6.l());
                        } else {
                            viewFindViewById2.setVisibility(0);
                            viewFindViewById3.setVisibility(8);
                            if (i7 == 2 || i7 == 3) {
                                textView.setMaxLines(1);
                            } else {
                                textView.setMaxLines(2);
                            }
                        }
                        View viewFindViewById4 = viewGroup.findViewById(R.id.link_parse_layout);
                        int iH = f33.f().h(messageVo.data3);
                        if (iH == 0 || iH == -2) {
                            viewFindViewById4.setVisibility(8);
                            textView.setVisibility(0);
                        } else {
                            viewFindViewById4.setVisibility(0);
                            textView.setVisibility(8);
                        }
                    }
                } else if (iO == 5) {
                    ImageView imageView3 = (ImageView) viewGroup.findViewById(R.id.header_icon);
                    if (imageView3 != null) {
                        if (TextUtils.isEmpty(richMsgExItemVo.icon)) {
                            imageView3.setVisibility(8);
                        } else {
                            imageView3.setVisibility(0);
                            gr2.j().h(richMsgExItemVo.icon, imageView3, bq6.l());
                        }
                    }
                    TextView textView7 = (TextView) viewGroup.findViewById(R.id.header_text);
                    if (textView7 != null) {
                        textView7.setText(richMsgExItemVo.title);
                    }
                    TextView textView8 = (TextView) viewGroup.findViewById(R.id.label);
                    if (textView8 != null) {
                        textView8.setText(richMsgExItemVo.label);
                    }
                    TextView textView9 = (TextView) viewGroup.findViewById(R.id.amount);
                    if (textView9 != null) {
                        textView9.setText(richMsgExItemVo.amount);
                    }
                    View viewFindViewById5 = viewGroup.findViewById(R.id.sepView);
                    if (viewFindViewById5 != null) {
                        if (richMsgExItemVo.line) {
                            viewFindViewById5.setVisibility(0);
                        } else {
                            viewFindViewById5.setVisibility(8);
                        }
                    }
                    LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.labelLayout);
                    linearLayout.removeAllViews();
                    ArrayList<LabelItem> arrayList3 = richMsgExItemVo.list;
                    if (arrayList3 == null || arrayList3.size() <= 0) {
                        linearLayout.setVisibility(8);
                    } else {
                        for (LabelItem labelItem : richMsgExItemVo.list) {
                            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.item_richmsg_content_pay_label_item, (ViewGroup) null);
                            ((TextView) viewGroup2.findViewById(R.id.label)).setText(labelItem.label);
                            ((TextView) viewGroup2.findViewById(R.id.content)).setText(labelItem.text);
                            linearLayout.addView(viewGroup2);
                        }
                        linearLayout.setVisibility(0);
                    }
                } else if (iO == 6) {
                    ((TextView) viewGroup.findViewById(R.id.appName)).setText(richMsgExItemVo.appName);
                    ImageView imageView4 = (ImageView) viewGroup.findViewById(R.id.appIcon);
                    if (imageView4 != null) {
                        gr2.j().h(richMsgExItemVo.appIcon, imageView4, bq6.l());
                    }
                    ((TextView) viewGroup.findViewById(R.id.title)).setText(richMsgExItemVo.title);
                    ImageView imageView5 = (ImageView) viewGroup.findViewById(R.id.cover);
                    ViewGroup.LayoutParams layoutParams = imageView5.getLayoutParams();
                    int i8 = layoutParams.width;
                    if (i8 > 0 && (iF2 = (i8 * me1.f()) / me1.g()) != layoutParams.height) {
                        layoutParams.height = iF2;
                        imageView5.setLayoutParams(layoutParams);
                    }
                    gr2.j().h(pu1.a(me3.a(richMsgExItemVo.cover, richMsgExItemVo.acode)), imageView5, bq6.p());
                } else if (iO == 11) {
                    ((TextView) viewGroup.findViewById(R.id.appName)).setText(richMsgExItemVo.appName);
                    EffectiveShapeView effectiveShapeView = (EffectiveShapeView) viewGroup.findViewById(R.id.appIcon);
                    effectiveShapeView.setBorderWidth(me1.a(context, 0.5f));
                    effectiveShapeView.setBorderColor(-3355444);
                    gr2.j().h(richMsgExItemVo.appIcon, effectiveShapeView, bq6.l());
                    ((TextView) viewGroup.findViewById(R.id.title)).setText(richMsgExItemVo.title);
                    ImageView imageView6 = (ImageView) viewGroup.findViewById(R.id.cover);
                    if (i == 2) {
                        imageView6.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }
                    String strA = me3.a(richMsgExItemVo.cover, richMsgExItemVo.acode);
                    if (imageView6 != null) {
                        gr2.j().h(pu1.a(strA), imageView6, bq6.p());
                    }
                } else if (iO == 7) {
                    AutoResizeImageView autoResizeImageView = (AutoResizeImageView) viewGroup.findViewById(R.id.image);
                    View viewFindViewById6 = viewGroup.findViewById(R.id.image_click_area);
                    if (messageVo.isSend) {
                        autoResizeImageView.setLeftOrRight(1);
                        viewFindViewById6.setBackgroundResource(R.drawable.selector_message_mask_right_item_background);
                    } else {
                        autoResizeImageView.setLeftOrRight(0);
                        viewFindViewById6.setBackgroundResource(R.drawable.selector_message_mask_left_item_background);
                    }
                    autoResizeImageView.setRatio(j(richMsgExItemVo));
                    gr2.j().h(richMsgExItemVo.cover, autoResizeImageView, bq6.l());
                    viewFindViewById6.setOnClickListener(new a(hVar3, messageVo, i6));
                    viewFindViewById6.setOnLongClickListener(new b(hVar3, messageVo, i6));
                } else {
                    if (iO == 8) {
                        View viewFindViewById7 = viewGroup.findViewById(R.id.moments_with_pic_area);
                        viewGroup.findViewById(R.id.moments_no_pic_area).setVisibility(8);
                        viewFindViewById7.setVisibility(0);
                        ImageView imageView7 = (ImageView) viewGroup.findViewById(R.id.moments_large_cover);
                        ImageView imageView8 = (ImageView) viewGroup.findViewById(R.id.moments_photos_small);
                        TextView textView10 = (TextView) viewGroup.findViewById(R.id.moments_nickname);
                        TextView textView11 = (TextView) viewGroup.findViewById(R.id.moments_publish_time);
                        TextView textView12 = (TextView) viewGroup.findViewById(R.id.moments_pic_index);
                        ImageView imageView9 = (ImageView) viewGroup.findViewById(R.id.moments_video_ic);
                        TextView textView13 = (TextView) viewGroup.findViewById(R.id.moments_publish_content);
                        if (imageView7 != null) {
                            i3 = i6;
                            gr2.j().h(richMsgExItemVo.cover, imageView7, bq6.a());
                        } else {
                            i3 = i6;
                        }
                        RichMsgExItemVo.FeedEx feedEx = richMsgExItemVo.feedEx;
                        if (feedEx != null) {
                            if (!TextUtils.isEmpty(feedEx.nickname)) {
                                textView10.setText(feedEx.nickname);
                            }
                            if (!TextUtils.isEmpty(feedEx.headIconUrl)) {
                                gr2.j().h(feedEx.headIconUrl, imageView8, bq6.l());
                            }
                            imageView9.setVisibility(feedEx.type == 3 ? 0 : 8);
                            textView12.setVisibility(feedEx.type == 2 ? 0 : 8);
                        }
                        if (richMsgExItemVo.feedEx == null || "88888003".equals(messageVo.from)) {
                            textView11.setVisibility(0);
                            textView11.setText("·" + cy5.c(richMsgExItemVo.pubTime));
                        } else {
                            textView11.setVisibility(8);
                        }
                        textView12.setText("1/" + richMsgExItemVo.showTag);
                        try {
                            if (Integer.valueOf(richMsgExItemVo.showTag).intValue() <= 1) {
                                textView12.setVisibility(8);
                            }
                        } catch (Exception unused) {
                        }
                        if (richMsgExItemVo.feedEx != null && !"88888003".equals(messageVo.from)) {
                            textView12.setVisibility(8);
                        }
                        textView13.setText(!"88888003".equals(messageVo.from) ? vl1.c(richMsgExItemVo.title, AppContext.getContext(), me1.b(com.zenmen.palmchat.c.b(), 14)) : !TextUtils.isEmpty(richMsgExItemVo.digest) ? vl1.c(richMsgExItemVo.digest, AppContext.getContext(), me1.b(com.zenmen.palmchat.c.b(), 14)) : "发布了一条新动态");
                    } else {
                        i3 = i6;
                        if (iO == 9) {
                            View viewFindViewById8 = viewGroup.findViewById(R.id.moments_with_pic_area);
                            viewGroup.findViewById(R.id.moments_no_pic_area).setVisibility(0);
                            viewFindViewById8.setVisibility(8);
                            ImageView imageView10 = (ImageView) viewGroup.findViewById(R.id.moments_text_photo);
                            TextView textView14 = (TextView) viewGroup.findViewById(R.id.moments_text_name_content);
                            TextView textView15 = (TextView) viewGroup.findViewById(R.id.moments_text_publish_time);
                            if (richMsgExItemVo.feedEx == null || "88888003".equals(messageVo.from)) {
                                textView15.setVisibility(0);
                                textView15.setText(cy5.c(richMsgExItemVo.pubTime));
                            } else {
                                textView15.setVisibility(8);
                            }
                            TextView textView16 = (TextView) viewGroup.findViewById(R.id.moments_text_share_url);
                            TextView textView17 = (TextView) viewGroup.findViewById(R.id.moments_text_publish_content);
                            RichMsgExItemVo.FeedEx feedEx2 = richMsgExItemVo.feedEx;
                            if (feedEx2 != null) {
                                if (!TextUtils.isEmpty(feedEx2.nickname)) {
                                    textView14.setText(feedEx2.nickname);
                                }
                                if (!TextUtils.isEmpty(feedEx2.headIconUrl)) {
                                    gr2.j().h(feedEx2.headIconUrl, imageView10, bq6.l());
                                }
                                if ("88888003".equals(messageVo.from)) {
                                    textView17.setVisibility(8);
                                    if (feedEx2.type != 4) {
                                        if (!TextUtils.isEmpty(richMsgExItemVo.digest)) {
                                            textView14.setText(vl1.c(feedEx2.nickname + ": " + richMsgExItemVo.digest, AppContext.getContext(), me1.b(com.zenmen.palmchat.c.b(), 14)));
                                        }
                                        textView16.setVisibility(8);
                                    } else if (TextUtils.isEmpty(richMsgExItemVo.digest)) {
                                        textView14.setText(feedEx2.nickname + ": [分享链接]");
                                        textView16.setVisibility(8);
                                    } else {
                                        textView16.setVisibility(0);
                                        textView16.setText("[分享链接]");
                                        SpannableString spannableStringC = vl1.c(feedEx2.nickname + ": " + richMsgExItemVo.digest, AppContext.getContext(), me1.b(com.zenmen.palmchat.c.b(), 14));
                                        textView14.setMaxLines(1);
                                        textView14.setText(spannableStringC);
                                    }
                                } else {
                                    textView17.setVisibility(0);
                                    textView16.setVisibility(8);
                                    if (TextUtils.isEmpty(richMsgExItemVo.title)) {
                                        textView17.setText("发布了一条新动态");
                                    } else {
                                        textView17.setText(vl1.c(richMsgExItemVo.title, AppContext.getContext(), me1.b(com.zenmen.palmchat.c.b(), 14)));
                                    }
                                }
                            }
                        } else if (iO == 10) {
                            TextView textView18 = (TextView) viewGroup.findViewById(R.id.title);
                            if (textView18 != null) {
                                textView18.setText(richMsgExItemVo.title);
                            }
                            TextView textView19 = (TextView) viewGroup.findViewById(R.id.time);
                            if (textView19 != null) {
                                textView19.setText(by5.h(richMsgExItemVo.pubTime));
                            }
                            LinearLayout linearLayout2 = (LinearLayout) viewGroup.findViewById(R.id.labelLayout);
                            linearLayout2.removeAllViews();
                            ArrayList<LabelItem> arrayList4 = richMsgExItemVo.list;
                            if (arrayList4 == null || arrayList4.size() <= 0) {
                                linearLayout2.setVisibility(8);
                            } else {
                                for (LabelItem labelItem2 : richMsgExItemVo.list) {
                                    if (!TextUtils.isEmpty(labelItem2.label) && !TextUtils.isEmpty(labelItem2.text)) {
                                        ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.item_richmsg_content_list_item, (ViewGroup) null);
                                        ((TextView) viewGroup3.findViewById(R.id.label)).setText(labelItem2.label);
                                        ((TextView) viewGroup3.findViewById(R.id.content)).setText(labelItem2.text);
                                        linearLayout2.addView(viewGroup3);
                                    }
                                }
                                linearLayout2.setVisibility(0);
                            }
                        } else if (iO == 12) {
                            TextView textView20 = (TextView) viewGroup.findViewById(R.id.title);
                            TextView textView21 = (TextView) viewGroup.findViewById(R.id.digest);
                            TextView textView22 = (TextView) viewGroup.findViewById(R.id.time);
                            ImageView imageView11 = (ImageView) viewGroup.findViewById(R.id.icon);
                            if (textView20 != null) {
                                textView20.setText(richMsgExItemVo.title);
                            }
                            if (textView21 != null) {
                                textView21.setText(richMsgExItemVo.digest);
                            }
                            if (textView22 != null) {
                                textView22.setText(by5.e(richMsgExItemVo.pubTime, context));
                            }
                            if (imageView11 != null) {
                                gr2.j().h(richMsgExItemVo.cover, imageView11, bq6.l());
                            }
                            View viewFindViewById9 = viewGroup.findViewById(R.id.commentLayout);
                            View viewFindViewById10 = viewGroup.findViewById(R.id.extraLayout);
                            int i9 = richMsgExItemVo.subType;
                            viewFindViewById9.setVisibility(0);
                            viewFindViewById10.setVisibility(8);
                            if (i9 == 2 || i9 == 3) {
                                textView20.setMaxLines(1);
                            } else {
                                textView20.setMaxLines(2);
                            }
                            View viewFindViewById11 = viewGroup.findViewById(R.id.link_parse_layout);
                            int iH2 = f33.f().h(messageVo.data3);
                            if (iH2 == 0 || iH2 == -2) {
                                viewFindViewById11.setVisibility(8);
                                textView20.setVisibility(0);
                            } else {
                                viewFindViewById11.setVisibility(0);
                                textView20.setVisibility(8);
                            }
                        } else if (iO == 14) {
                            ((TextView) viewGroup.findViewById(R.id.appName)).setText(richMsgExItemVo.appName);
                            EffectiveShapeView effectiveShapeView2 = (EffectiveShapeView) viewGroup.findViewById(R.id.appIcon);
                            effectiveShapeView2.setBorderWidth(me1.a(context, 0.5f));
                            effectiveShapeView2.setBorderColor(-3355444);
                            gr2.j().h(richMsgExItemVo.appIcon, effectiveShapeView2, bq6.l());
                            ((TextView) viewGroup.findViewById(R.id.title)).setText(richMsgExItemVo.title);
                            ImageView imageView12 = (ImageView) viewGroup.findViewById(R.id.cover);
                            String strA2 = me3.a(richMsgExItemVo.cover, richMsgExItemVo.acode);
                            if (imageView12 != null) {
                                gr2.j().h(pu1.a(strA2), imageView12, bq6.p());
                            }
                        } else {
                            if (iO == 13) {
                                TextView textView23 = (TextView) viewGroup.findViewById(R.id.title);
                                TextView textView24 = (TextView) viewGroup.findViewById(R.id.digest);
                                TextView textView25 = (TextView) viewGroup.findViewById(R.id.time);
                                ImageView imageView13 = (ImageView) viewGroup.findViewById(R.id.icon);
                                if (textView23 != null) {
                                    textView23.setText(richMsgExItemVo.title);
                                }
                                if (textView24 != null) {
                                    textView24.setText(richMsgExItemVo.digest);
                                }
                                if (textView25 != null) {
                                    textView25.setText(by5.e(richMsgExItemVo.pubTime, context));
                                }
                                if (imageView13 != null) {
                                    gr2.j().h(richMsgExItemVo.cover, imageView13, bq6.l());
                                }
                                View viewFindViewById12 = viewGroup.findViewById(R.id.commentLayout);
                                View viewFindViewById13 = viewGroup.findViewById(R.id.extraLayout);
                                viewFindViewById12.setVisibility(8);
                                viewFindViewById13.setVisibility(0);
                                TextView textView26 = (TextView) viewGroup.findViewById(R.id.extraTitle);
                                TextView textView27 = (TextView) viewGroup.findViewById(R.id.extraDigest);
                                ImageView imageView14 = (ImageView) viewGroup.findViewById(R.id.extraIcon);
                                textView26.setText(richMsgExItemVo.title);
                                textView27.setText(richMsgExItemVo.digest);
                                gr2.j().h(richMsgExItemVo.cover, imageView14, bq6.l());
                                View viewFindViewById14 = viewGroup.findViewById(R.id.link_parse_layout);
                                int iH3 = f33.f().h(messageVo.data3);
                                if (iH3 == 0 || iH3 == -2) {
                                    viewFindViewById14.setVisibility(8);
                                    textView23.setVisibility(0);
                                } else {
                                    viewFindViewById14.setVisibility(0);
                                    textView23.setVisibility(8);
                                }
                            } else if (iO == 15) {
                                ((TextView) viewGroup.findViewById(R.id.appName)).setText(richMsgExItemVo.appName);
                                ImageView imageView15 = (ImageView) viewGroup.findViewById(R.id.appIcon);
                                if (imageView15 != null) {
                                    gr2.j().h(richMsgExItemVo.appIcon, imageView15, bq6.l());
                                }
                                ((TextView) viewGroup.findViewById(R.id.title)).setText(richMsgExItemVo.title);
                                ImageView imageView16 = (ImageView) viewGroup.findViewById(R.id.cover);
                                ViewGroup.LayoutParams layoutParams2 = imageView16.getLayoutParams();
                                int i10 = layoutParams2.width;
                                if (i10 > 0 && (iF = (i10 * me1.f()) / me1.g()) != layoutParams2.height) {
                                    layoutParams2.height = iF;
                                    imageView16.setLayoutParams(layoutParams2);
                                }
                                gr2.j().h(pu1.a(me3.a(richMsgExItemVo.cover, richMsgExItemVo.acode)), imageView16, bq6.p());
                            }
                            if (arrayList2.size() > 1) {
                                hVar2 = hVar;
                                i2 = i3;
                                viewGroup.setOnClickListener(new c(hVar2, messageVo, i2));
                                viewGroup.setOnLongClickListener(new d(hVar2, messageVo, i2));
                                viewGroup.setBackgroundResource(R.drawable.selector_richmsg_subitem_background);
                            } else {
                                hVar2 = hVar;
                                i2 = i3;
                                viewGroup.setBackgroundColor(context.getResources().getColor(R.color.color_trans));
                            }
                        }
                    }
                    if (arrayList2.size() > 1) {
                    }
                }
                i3 = i6;
                if (arrayList2.size() > 1) {
                }
            } else {
                hVar2 = hVar3;
                i2 = i6;
            }
            i6 = i2 + 1;
            hVar3 = hVar2;
        }
    }

    public static String e(RichMsgExItemVo richMsgExItemVo, int i) {
        if (richMsgExItemVo == null) {
            return AppContext.getContext().getResources().getString(R.string.message_type_link);
        }
        if (i == 5) {
            return AppContext.getContext().getResources().getString(R.string.message_type_miniprogram);
        }
        return richMsgExItemVo.title + "\n" + richMsgExItemVo.url;
    }

    public static NoticeBarStyle f(String str) {
        RichMsgVo richMsgVo;
        if (str == null || (richMsgVo = (RichMsgVo) az2.a(str, RichMsgVo.class)) == null) {
            return null;
        }
        return richMsgVo.noticeBar;
    }

    public static RichMsgExVo g(String str) {
        RichMsgVo richMsgVo;
        if (str == null || (richMsgVo = (RichMsgVo) az2.a(str, RichMsgVo.class)) == null) {
            return null;
        }
        return richMsgVo.appMsg;
    }

    public static RichMsgExVo h(MessageVo messageVo) {
        String str;
        if (messageVo == null) {
            return null;
        }
        RichMsgVo richMsgVo = (!s(l(messageVo)) || (str = messageVo.data1) == null) ? null : (RichMsgVo) az2.a(str, RichMsgVo.class);
        if (richMsgVo != null) {
            return richMsgVo.appMsg;
        }
        return null;
    }

    public static String i(String str, String str2, String str3, String str4) {
        ArrayList<RichMsgExItemVo> arrayList;
        RichMsgExItemVo richMsgExItemVo;
        String str5;
        int i;
        if (!TextUtils.isEmpty(str) && str.equals("message_type_link_illegal")) {
            return AppContext.getContext().getString(R.string.message_prefix_link) + AppContext.getContext().getString(R.string.rich_message_title_illegal);
        }
        RichMsgExVo richMsgExVoG = g(str2);
        if (richMsgExVoG == null || (arrayList = richMsgExVoG.items) == null || arrayList.size() <= 0 || (richMsgExItemVo = richMsgExVoG.items.get(0)) == null) {
            return str3;
        }
        int iIntValue = 1;
        if (richMsgExVoG.items.size() != 1 || ((i = richMsgExItemVo.showType) != 0 && i != 6 && i != 11 && i != 14)) {
            int i2 = richMsgExItemVo.showType;
            if (i2 != 8 && i2 != 9) {
                str5 = richMsgExItemVo.title;
            } else if (richMsgExItemVo.feedEx != null) {
                String str6 = richMsgExItemVo.digest;
                if ("88888003".equals(str4)) {
                    String str7 = richMsgExItemVo.feedEx.nickname;
                    if (TextUtils.isEmpty(str6)) {
                        str5 = str7 + ": 发布了一条新动态";
                    } else {
                        str5 = str7 + ": " + str6;
                    }
                } else {
                    int i3 = richMsgExItemVo.feedEx.type;
                    if (i3 == 1) {
                        str5 = "最近发表: " + ((Object) vl1.c(str6, AppContext.getContext(), me1.b(com.zenmen.palmchat.c.b(), 14)));
                    } else if (i3 == 2) {
                        try {
                            iIntValue = Integer.valueOf(richMsgExItemVo.showTag).intValue();
                        } catch (Exception unused) {
                        }
                        if (TextUtils.isEmpty(str6)) {
                            str5 = "最近分享了" + iIntValue + "张图片";
                        } else {
                            str5 = "最近发表: (" + iIntValue + "图) " + ((Object) vl1.c(str6, AppContext.getContext(), me1.b(com.zenmen.palmchat.c.b(), 14)));
                        }
                    } else if (i3 != 3) {
                        str5 = "最近分享了一个内容";
                    } else if (TextUtils.isEmpty(str6)) {
                        str5 = "最近分享了1段视频";
                    } else {
                        str5 = "最近发表: (视频) " + ((Object) vl1.c(str6, AppContext.getContext(), me1.b(com.zenmen.palmchat.c.b(), 14)));
                    }
                }
            } else {
                str5 = null;
            }
        } else if (i == 11 || i == 14) {
            str5 = AppContext.getContext().getString(R.string.message_prefix_link_smallvideo) + richMsgExItemVo.title;
        } else {
            int i4 = richMsgExItemVo.subType;
            if (i4 == 1) {
                str5 = AppContext.getContext().getString(R.string.message_prefix_link_smallvideo_namecard) + richMsgExItemVo.title;
            } else if (i4 == 2 || i4 == 3) {
                str5 = AppContext.getContext().getString(R.string.message_prefix_link_smallvideo) + richMsgExItemVo.title;
            } else {
                str5 = AppContext.getContext().getString(R.string.message_prefix_link) + richMsgExItemVo.title;
            }
        }
        return str5;
    }

    public static float j(RichMsgExItemVo richMsgExItemVo) {
        int i;
        int i2;
        if (richMsgExItemVo == null || (i = richMsgExItemVo.width) == 0 || (i2 = richMsgExItemVo.height) == 0) {
            return 1.0f;
        }
        return i / i2;
    }

    public static boolean k() {
        return rl0.h().e().d();
    }

    public static int l(MessageVo messageVo) {
        if (messageVo == null) {
            return 2;
        }
        try {
            if (TextUtils.isEmpty(messageVo.data2)) {
                return 2;
            }
            return Integer.parseInt(messageVo.data2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 2;
        }
    }

    public static ArrayList<ViewGroup> m(Context context, MessageVo messageVo, RichMsgExVo richMsgExVo, h50 h50Var) {
        ViewGroup viewGroup;
        ArrayList<RichMsgExItemVo> arrayList = richMsgExVo.items;
        String strP = p(messageVo, arrayList);
        LogUtil.i("bindSubView", "richMsgSubViewSignature =" + strP + " holder.richMsgSubViewSignature=" + h50Var.v0 + " childviewCount =" + h50Var.m0.getChildCount());
        ArrayList<ViewGroup> arrayList2 = new ArrayList<>();
        if (strP.equals(h50Var.v0)) {
            int childCount = h50Var.m0.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = h50Var.m0.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    arrayList2.add((ViewGroup) childAt);
                }
            }
        } else {
            h50Var.m0.removeAllViews();
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
            int i2 = 0;
            while (i2 < arrayList.size()) {
                boolean z = i2 != arrayList.size() - 1;
                RichMsgExItemVo richMsgExItemVo = arrayList.get(i2);
                LinearLayout linearLayout = h50Var.m0;
                int iO = o(messageVo, richMsgExItemVo);
                switch (iO) {
                    case 0:
                    case 12:
                    case 13:
                        viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.item_richmsg_content_style1, (ViewGroup) null);
                        break;
                    case 1:
                        viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.item_richmsg_content_style2, (ViewGroup) null);
                        break;
                    case 2:
                        viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.item_richmsg_content_style3, (ViewGroup) null);
                        break;
                    case 3:
                        viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.item_richmsg_content_style4, (ViewGroup) null);
                        break;
                    case 4:
                        viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.item_richmsg_content_style5, (ViewGroup) null);
                        break;
                    case 5:
                        viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.item_richmsg_content_style_pay, (ViewGroup) null);
                        break;
                    case 6:
                        viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.item_richmsg_content_style_miniapp, (ViewGroup) null);
                        break;
                    case 7:
                        viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.item_richmsg_content_style_imgurl, (ViewGroup) null);
                        break;
                    case 8:
                    case 9:
                        viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.item_richmsg_content_style_friend_moments, (ViewGroup) null);
                        break;
                    case 10:
                        viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.item_richmsg_content_style_list, (ViewGroup) null);
                        break;
                    case 11:
                    case 14:
                        viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.item_richmsg_content_style_smallvideo, (ViewGroup) null);
                        break;
                    case 15:
                        viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.item_richmsg_content_style_open_sapp, (ViewGroup) null);
                        break;
                    default:
                        viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.item_richmsg_content_style3, (ViewGroup) null);
                        break;
                }
                if (viewGroup != null) {
                    linearLayout.addView(viewGroup, iO == 6 ? new LinearLayout.LayoutParams(-1, me1.b(context, 240)) : new LinearLayout.LayoutParams(-1, -2));
                    if (z) {
                        View view = new View(context);
                        view.setBackgroundColor(context.getResources().getColor(R.color.gap_line_color));
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
                        int iB = me1.b(context, 8);
                        layoutParams.setMargins(iB, 0, iB, 0);
                        linearLayout.addView(view, layoutParams);
                    }
                    arrayList2.add(viewGroup);
                }
                i2++;
            }
        }
        h50Var.v0 = strP;
        return arrayList2;
    }

    public static int n(MessageVo messageVo) {
        ArrayList<RichMsgExItemVo> arrayList;
        RichMsgExVo richMsgExVoH = h(messageVo);
        if (richMsgExVoH == null || (arrayList = richMsgExVoH.items) == null || arrayList.size() == 0) {
            return -1;
        }
        return o(messageVo, richMsgExVoH.items.get(0));
    }

    public static int o(MessageVo messageVo, RichMsgExItemVo richMsgExItemVo) {
        int i = richMsgExItemVo.showType;
        return (i < 0 || i > 15) ? l(messageVo) == 2 ? 2 : 6 : i;
    }

    public static String p(MessageVo messageVo, ArrayList<RichMsgExItemVo> arrayList) {
        if (arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<RichMsgExItemVo> it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append(o(messageVo, it.next()));
        }
        return sb.toString();
    }

    public static boolean q(RichMsgExVo richMsgExVo) {
        ArrayList<RichMsgExItemVo> arrayList;
        if (richMsgExVo != null && (arrayList = richMsgExVo.items) != null && arrayList.size() == 1) {
            RichMsgExItemVo richMsgExItemVo = richMsgExVo.items.get(0);
            if (richMsgExItemVo.showType == 11 && richMsgExItemVo.matchParent) {
                return true;
            }
        }
        return false;
    }

    public static boolean r(RichMsgExItemVo richMsgExItemVo) {
        String str;
        String[] strArrSplit;
        if (richMsgExItemVo == null || (str = richMsgExItemVo.showTag) == null || (strArrSplit = str.split(",")) == null) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (str2.equals("ads")) {
                return true;
            }
        }
        return false;
    }

    public static boolean s(int i) {
        return i == 2 || i == 3 || i == 5;
    }

    public static boolean t(MessageVo messageVo, RichMsgExVo richMsgExVo) {
        if (richMsgExVo == null) {
            return true;
        }
        ArrayList<RichMsgExItemVo> arrayList = richMsgExVo.items;
        if (arrayList != null && arrayList.size() == 1) {
            int iO = o(messageVo, richMsgExVo.items.get(0));
            if (iO == 0 || iO == 6 || iO == 7) {
                return true;
            }
            if ((iO == 11 && !q(richMsgExVo)) || iO == 12 || iO == 14 || iO == 15 || iO == 13) {
                return true;
            }
        }
        return false;
    }

    public static void u(String str, String str2, int i, String str3) {
        RichMsgExVo richMsgExVoG;
        ArrayList<RichMsgExItemVo> arrayList;
        RichMsgExItemVo richMsgExItemVo;
        if (i != 28 || "88888003".equals(str) || (richMsgExVoG = g(str3)) == null || (arrayList = richMsgExVoG.items) == null || arrayList.size() <= 0 || (richMsgExItemVo = richMsgExVoG.items.get(0)) == null) {
            return;
        }
        int i2 = richMsgExItemVo.showType;
        if (i2 == 8 || i2 == 9) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mid", str2);
                jSONObject.put("showType", richMsgExItemVo.showType);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("M121", null, null, jSONObject.toString());
        }
    }

    public static void v(MessageVo messageVo, RichMsgExVo richMsgExVo, @Nullable List<String> list) {
        ArrayList<RichMsgExItemVo> arrayList;
        RichMsgExItemVo richMsgExItemVo;
        if (messageVo == null || richMsgExVo == null || list == null) {
            return;
        }
        String str = messageVo.mid;
        if (TextUtils.isEmpty(str) || list.contains(str) || "88888003".equals(messageVo.from) || (arrayList = richMsgExVo.items) == null || arrayList.size() <= 0 || (richMsgExItemVo = richMsgExVo.items.get(0)) == null) {
            return;
        }
        int i = richMsgExItemVo.showType;
        if (i == 8 || i == 9) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mid", str);
                jSONObject.put("showType", richMsgExItemVo.showType);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("M123", null, null, jSONObject.toString());
            list.add(str);
        }
    }

    public static void w(View view, boolean z, int i) {
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = i;
            if (z) {
                layoutParams.addRule(0, R.id.portrait);
                layoutParams.addRule(1, 0);
            } else if (i == -1) {
                layoutParams.addRule(0, R.id.multi_choice);
                layoutParams.addRule(1, R.id.portrait);
            } else {
                layoutParams.addRule(0, 0);
                layoutParams.addRule(1, R.id.portrait);
            }
        }
    }

    public static boolean x(String str, String str2) {
        RichMsgExVo richMsgExVoG;
        ArrayList<RichMsgExItemVo> arrayList;
        RichMsgExItemVo richMsgExItemVo;
        if ("88888003".equals(str2) || !rl0.h().i().i() || (richMsgExVoG = g(str)) == null || (arrayList = richMsgExVoG.items) == null || arrayList.size() <= 0 || (richMsgExItemVo = richMsgExVoG.items.get(0)) == null) {
            return true;
        }
        int i = richMsgExItemVo.showType;
        return (i == 8 || i == 9) ? false : true;
    }
}
