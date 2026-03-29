package com.zenmen.palmchat.maintab.msgTopEntrance;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.voiceroom.adapter.RcyHolder;
import com.zenmen.palmchat.voiceroom.adapter.RcySAdapter;
import defpackage.az2;
import defpackage.hc2;
import defpackage.ir5;
import defpackage.is3;
import defpackage.l50;
import defpackage.me1;
import defpackage.ry5;
import defpackage.ts0;
import defpackage.ve;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MsgTopEntranceView extends FrameLayout {
    private RcySAdapter<FuncItem, RcyHolder> adapter;
    private List<FuncItem> currentShowList;
    private RecyclerView listView;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RcySAdapter<FuncItem, RcyHolder> {
        public a(Context context, int i) {
            super(context, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(FuncItem funcItem, int i, View view) {
            if (l50.a()) {
                return;
            }
            HashMap map = new HashMap();
            map.put(az.at, funcItem.source);
            zn6.i("msg_zone_click", map);
            if (!ve.d(funcItem.sourceurl)) {
                ry5.a(" 未找到对应功能，请检查是否是最新版本");
            } else {
                ve.s((Activity) MsgTopEntranceView.this.getContext(), funcItem.sourceurl, false);
                MsgTopEntranceView.this.updateViewOnClick(funcItem, i);
            }
        }

        @Override // com.zenmen.palmchat.voiceroom.adapter.RcySAdapter
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(RcyHolder rcyHolder, final FuncItem funcItem, final int i) {
            ImageView imageView = (ImageView) rcyHolder.l(R.id.icon);
            int iB = me1.b(MsgTopEntranceView.this.getContext(), 3);
            int iB2 = me1.b(MsgTopEntranceView.this.getContext(), 3);
            int iB3 = me1.b(MsgTopEntranceView.this.getContext(), 162);
            int i2 = funcItem.style;
            if (i2 == -100) {
                iB3 = me1.g() - me1.b(MsgTopEntranceView.this.getContext(), 32);
                iB = me1.b(MsgTopEntranceView.this.getContext(), 16);
                iB2 = me1.b(MsgTopEntranceView.this.getContext(), 16);
            } else if (i2 == 1) {
                iB3 = me1.b(MsgTopEntranceView.this.getContext(), 162);
            } else if (i2 == 2) {
                iB3 = me1.b(MsgTopEntranceView.this.getContext(), 134);
            }
            if (i == 0) {
                iB = me1.b(MsgTopEntranceView.this.getContext(), 16);
            } else if (i == MsgTopEntranceView.this.adapter.getData().size() - 1) {
                iB2 = me1.b(MsgTopEntranceView.this.getContext(), 16);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = iB3;
                layoutParams.setMargins(iB, 0, iB2, 0);
                imageView.setLayoutParams(layoutParams);
            }
            String iconUrl = funcItem.getIconUrl();
            int iA = FuncDefaultResHelper.a(funcItem.source, funcItem.style);
            if (TextUtils.isEmpty(iconUrl) || !iconUrl.endsWith(".gif")) {
                hc2.a(MsgTopEntranceView.this.getContext()).load(iconUrl).placeholder(iA).error(iA).into(imageView);
            } else {
                hc2.a(MsgTopEntranceView.this.getContext()).asGif().load(iconUrl).placeholder(iA).error(iA).into(imageView);
            }
            rcyHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: js3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f18492a.k(funcItem, i, view);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f14622a;

        public b(List list) {
            this.f14622a = list;
            put(az.at, list);
        }
    }

    public MsgTopEntranceView(@NonNull Context context) {
        this(context, null);
    }

    private boolean checkAndShow() {
        List<FuncItem> listC = is3.b().c();
        boolean z = false;
        if (listC != null && listC.size() > 0 && !TeenagersModeManager.a().d()) {
            setVisibility(0);
            z = true;
            updateListView(listC, true);
        }
        if (!z) {
            setVisibility(8);
        }
        return z;
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.layout_msg_top_entrance, this);
        this.listView = (RecyclerView) findViewById(R.id.listView);
        a aVar = new a(getContext(), R.layout.layout_msg_top_entrance_item);
        this.adapter = aVar;
        this.listView.setAdapter(aVar);
        this.listView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    }

    private void updateListView(List<FuncItem> list, boolean z) {
        if (list != null) {
            if (!this.currentShowList.equals(list)) {
                this.currentShowList.clear();
                this.currentShowList.addAll(list);
                this.adapter.g(list, true);
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                Iterator<FuncItem> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().source);
                }
                zn6.j("msg_zone_show", "view", new b(arrayList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewOnClick(FuncItem funcItem, int i) {
        if (i >= 2) {
            int iB = (int) (ir5.b() / 86400000);
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            if (sPUtil.c(scene, "key_msg_top_entrance_has_clicked_today" + iB, false)) {
                return;
            }
            sPUtil.v(scene, "key_msg_top_entrance_has_clicked_today" + iB, Boolean.TRUE);
            is3.b().f(funcItem);
            updateListView(is3.b().c(), false);
            this.listView.scrollToPosition(0);
            LocalSavedConfig localSavedConfig = new LocalSavedConfig();
            if (ts0.o().s() != null) {
                localSavedConfig.originConfig = ts0.o().s().toString();
            }
            localSavedConfig.currentConfig = is3.b().c();
            sPUtil.v(scene, "key_msg_top_entrance_local_state", az2.c(localSavedConfig));
        }
    }

    public boolean updateView(boolean z) {
        if (!z) {
            return checkAndShow();
        }
        setVisibility(8);
        return false;
    }

    public MsgTopEntranceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MsgTopEntranceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.adapter = null;
        this.currentShowList = new ArrayList();
        initView(context);
    }
}
