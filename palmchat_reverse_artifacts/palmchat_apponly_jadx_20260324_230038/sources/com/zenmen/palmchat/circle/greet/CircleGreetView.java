package com.zenmen.palmchat.circle.greet;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.circle.bean.CircleGreetMember;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.g90;
import defpackage.gr2;
import defpackage.i90;
import defpackage.le1;
import defpackage.n90;
import defpackage.o90;
import defpackage.sy5;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleGreetView extends LinearLayout {
    private static int GREET_STATUS_ALREADY = 1;
    private static int GREET_STATUS_NOT_YET = 0;
    private static final String KEY_CIRCLE_GROUP_SAY_HI = "key_circle_group_say_hi6";
    private static final int MAX_MEM_SHOW = 4;
    private static final String TAG = "com.zenmen.palmchat.circle.greet.CircleGreetView";
    private final int IMG_DIAMETER;
    private final int IMG_MARGIN;
    private final int TIPS_HOR;
    private final int TIPS_VER;
    private CircleGreetMember circleGreetItem;
    private String clickMeKey;
    private ViewGroup container;
    private ImageView greetClickMe;
    private TextView greetCommit;
    private ViewGroup greetCommitRl;
    private GifImageView greetHiGif;
    private HashMap<String, n90> greetMap;
    private TextView greetTitle;
    private ViewGroup greetUserContainer;
    private GroupInfoItem groupInfoItem;
    private HashMap<String, ContactInfoItem> groupMemberCache;
    private ChatterAdapter.h listener;
    private HashSet<String> loadingIds;
    private i90 presenter;
    private MessageVo vo;

    public CircleGreetView(Context context) {
        this(context, null);
    }

    private void addCountTipsView(List<CircleGreetMember.Member> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.IMG_MARGIN, 0, 0, 0);
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        int i = this.TIPS_HOR;
        int i2 = this.TIPS_VER;
        textView.setPadding(i, i2, i, i2);
        textView.setBackgroundResource(R.drawable.circle_greet_count_bg);
        textView.setTextSize(12.0f);
        textView.setTextColor(Color.parseColor("#999999"));
        textView.setText(getResources().getString(R.string.circle_greet_count, Integer.valueOf(list.size())));
        textView.setOnClickListener(new View.OnClickListener() { // from class: k90
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18600a.lambda$addCountTipsView$3(view);
            }
        });
        this.greetUserContainer.addView(textView);
    }

    private void addGreetMemberView() {
        addPortraitView(this.circleGreetItem.greetMembers);
        addCountTipsView(this.circleGreetItem.greetMembers);
    }

    private void addHiGif() {
        if (this.greetHiGif.getVisibility() == 8) {
            try {
                this.greetHiGif.setVisibility(0);
                this.greetHiGif.setImageDrawable(new a(getResources().getAssets(), "greet_hi.gif"));
            } catch (IOException e) {
                LogUtil.e(TAG, e);
                this.greetHiGif.setVisibility(8);
            }
        }
    }

    private void addPortraitView(final List<CircleGreetMember.Member> list) {
        n90 n90Var;
        this.greetUserContainer.removeAllViews();
        int iMin = Math.min(4, list.size());
        this.greetUserContainer.setVisibility(iMin > 0 ? 0 : 8);
        Collections.reverse(list);
        final int i = 0;
        while (i < iMin) {
            EffectiveShapeView effectiveShapeView = new EffectiveShapeView(getContext());
            effectiveShapeView.setOnClickListener(new View.OnClickListener() { // from class: j90
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f18352a.lambda$addPortraitView$2(list, i, view);
                }
            });
            effectiveShapeView.changeShapeType(1);
            int i2 = this.IMG_DIAMETER;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
            layoutParams.setMargins(i > 0 ? this.IMG_MARGIN : 0, 0, 0, 0);
            effectiveShapeView.setLayoutParams(layoutParams);
            this.greetUserContainer.addView(effectiveShapeView);
            gr2.j().h(getHeadUrl(list.get(i)), effectiveShapeView, bq6.s());
            HashMap<String, n90> map = this.greetMap;
            if (map != null && map.get(this.vo.mid) != null && (n90Var = this.greetMap.get(this.vo.mid)) != null && !n90Var.c) {
                g90.d(this.vo, this.groupInfoItem);
                n90Var.c = true;
            }
            i++;
        }
    }

    private String getHeadUrl(CircleGreetMember.Member member) {
        ContactInfoItem contactInfoItemD = this.presenter.d(this.groupMemberCache, this.groupInfoItem, member.uid);
        return contactInfoItemD != null ? contactInfoItemD.getIconURL() : "";
    }

    private void greetToNewComer() {
        this.presenter.e(this.groupInfoItem.getGroupId(), AccountUtils.p(getContext()), DomainHelper.q(this.vo.from), this.vo.mid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addCountTipsView$3(View view) {
        g90.e(this.vo, this.groupInfoItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addPortraitView$2(List list, int i, View view) {
        if (this.listener != null) {
            ContactInfoItem contactInfoItem = this.groupMemberCache.get(((CircleGreetMember.Member) list.get(i)).uid);
            if (contactInfoItem == null) {
                contactInfoItem = new ContactInfoItem();
                contactInfoItem.setUid(((CircleGreetMember.Member) list.get(i)).uid);
            }
            g90.c(this.vo, this.groupInfoItem, contactInfoItem.getUid());
            this.listener.q0(contactInfoItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        if (this.greetCommitRl.isSelected()) {
            g90.a(this.vo, this.groupInfoItem, "2");
            return;
        }
        Object tag = this.greetCommitRl.getTag();
        if (tag instanceof HashSet) {
            this.loadingIds = (HashSet) tag;
        }
        if (this.loadingIds.contains(this.vo.mid)) {
            return;
        }
        SPUtil.f14322a.m(SPUtil.SCENE.CIRCLE).edit().putBoolean(this.clickMeKey, true).apply();
        if (TextUtils.equals(AccountUtils.p(getContext()), DomainHelper.q(this.vo.from))) {
            o90.b(this.groupInfoItem.getGroupId(), 0);
        }
        greetToNewComer();
        g90.a(this.vo, this.groupInfoItem, "1");
        this.loadingIds.add(this.vo.mid);
        this.greetCommitRl.setTag(this.loadingIds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$1(View view) {
        ChatterAdapter.h hVar = this.listener;
        if (hVar == null) {
            return false;
        }
        hVar.m(this.vo, null);
        return false;
    }

    private void waitForGreet() {
        setGreetBtnClicked(false);
        this.greetTitle.setText(this.vo.text);
        this.greetUserContainer.removeAllViews();
        addHiGif();
    }

    public void onGreetSuccess() {
        this.greetHiGif.setVisibility(8);
        ChatterAdapter.h hVar = this.listener;
        if (hVar != null) {
            hVar.H(this.vo, null);
        }
    }

    public void onLoadingStatusReset() {
        Object tag = this.greetCommitRl.getTag();
        if (tag instanceof HashSet) {
            this.loadingIds = (HashSet) tag;
        }
        this.loadingIds.remove(this.vo.mid);
        this.greetCommitRl.setTag(this.loadingIds);
    }

    public void setChatItemListener(ChatterAdapter.h hVar) {
        this.listener = hVar;
    }

    public void setContractInfo(HashMap<String, ContactInfoItem> map) {
        this.groupMemberCache = map;
    }

    public void setGreetBtnClicked(boolean z) {
        Resources resources;
        int i;
        this.greetCommitRl.setSelected(z);
        this.greetCommit.setText(z ? R.string.circle_greet_already : R.string.circle_greet_not_yet);
        TextView textView = this.greetCommit;
        if (z) {
            resources = getResources();
            i = R.color.Ge;
        } else {
            resources = getResources();
            i = R.color.white;
        }
        textView.setTextColor(resources.getColor(i));
    }

    public void showErrorToast(String str) {
        sy5.f(getContext(), str, 0).g();
    }

    public void showGreetStatusByDB() {
        CircleGreetMember circleGreetMember = (CircleGreetMember) new Gson().fromJson(this.vo.data1, CircleGreetMember.class);
        if (circleGreetMember == null) {
            throw new JsonSyntaxException("");
        }
        this.circleGreetItem = circleGreetMember;
        setGreetBtnClicked(circleGreetMember.isGreeted == GREET_STATUS_ALREADY);
        addGreetMemberView();
        if (circleGreetMember.isGreeted == GREET_STATUS_NOT_YET) {
            addHiGif();
        } else {
            this.greetHiGif.setVisibility(8);
        }
    }

    public void update(MessageVo messageVo, GroupInfoItem groupInfoItem, HashMap<String, n90> map) throws JsonSyntaxException {
        this.vo = messageVo;
        this.groupInfoItem = groupInfoItem;
        this.greetMap = map;
        n90 n90Var = map.get(messageVo.mid);
        if (map.get(messageVo.mid) == null) {
            n90Var = new n90();
        }
        String str = messageVo.mid;
        n90Var.f19462a = str;
        map.put(str, n90Var);
        if (map.get(messageVo.mid) != null && !n90Var.b) {
            g90.b(messageVo, groupInfoItem);
            n90Var.b = true;
        }
        this.greetTitle.setText(messageVo.text);
        if (TextUtils.isEmpty(messageVo.data1)) {
            waitForGreet();
        } else {
            showGreetStatusByDB();
        }
    }

    public CircleGreetView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleGreetView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.loadingIds = new HashSet<>();
        this.IMG_MARGIN = le1.a(getContext(), 6.0f);
        this.IMG_DIAMETER = le1.a(getContext(), 24.0f);
        this.TIPS_HOR = le1.a(getContext(), 14.0f);
        this.TIPS_VER = le1.a(getContext(), 4.0f);
        View viewInflate = View.inflate(getContext(), R.layout.list_item_greet, this);
        this.greetTitle = (TextView) viewInflate.findViewById(R.id.greet_title);
        this.greetCommitRl = (ViewGroup) viewInflate.findViewById(R.id.greet_commit_rl);
        this.greetClickMe = (ImageView) viewInflate.findViewById(R.id.greet_click_me);
        this.greetHiGif = (GifImageView) viewInflate.findViewById(R.id.greet_hi_gif);
        this.container = (ViewGroup) viewInflate.findViewById(R.id.container);
        this.greetCommit = (TextView) viewInflate.findViewById(R.id.greet_commit);
        this.greetCommitRl.setOnClickListener(new View.OnClickListener() { // from class: l90
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18931a.lambda$new$0(view);
            }
        });
        this.container.setOnLongClickListener(new View.OnLongClickListener() { // from class: m90
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f19165a.lambda$new$1(view);
            }
        });
        this.greetUserContainer = (ViewGroup) viewInflate.findViewById(R.id.greet_grouper_ll);
        i90 i90Var = new i90(getContext());
        this.presenter = i90Var;
        i90Var.c(this);
        this.clickMeKey = KEY_CIRCLE_GROUP_SAY_HI + AccountUtils.p(AppContext.getContext());
    }
}
