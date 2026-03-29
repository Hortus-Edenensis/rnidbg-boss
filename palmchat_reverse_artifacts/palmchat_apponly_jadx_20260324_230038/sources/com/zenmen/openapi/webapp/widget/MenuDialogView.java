package com.zenmen.openapi.webapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zenmen.openapi.comm.widget.LxDialogView;
import com.zenmen.openapi.webapp.widget.MenuItemView;
import com.zenmen.palmchat.R;
import defpackage.a46;
import defpackage.fa3;
import defpackage.gr2;
import defpackage.h84;
import defpackage.ka3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MenuDialogView extends LxDialogView implements View.OnClickListener {
    public static final int EVENT_ID_ADD_FLOAT = 7;
    public static final int EVENT_ID_CANCEL = 6;
    public static final int EVENT_ID_COPY = 2;
    public static final int EVENT_ID_DETAIL = 5;
    public static final int EVENT_ID_FEEDBACK = 4;
    public static final int EVENT_ID_REFRESH = 3;
    public static final int EVENT_ID_SHARE = 1;
    public static final int EVENT_ID_SHARE_APP = 8;
    private static List<MenuItemView.a> menuItems = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12051a;

        static {
            int[] iArr = new int[MenuItemView.Function.values().length];
            f12051a = iArr;
            try {
                iArr[MenuItemView.Function.COPY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12051a[MenuItemView.Function.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12051a[MenuItemView.Function.REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12051a[MenuItemView.Function.FEEDBACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12051a[MenuItemView.Function.ADD_FLOAT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12051a[MenuItemView.Function.MOMENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements LxDialogView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ka3.b f12052a;
    }

    static {
        MenuItemView.a aVar = new MenuItemView.a(R.drawable.lx_webapp_menu_share, "发送给朋友", MenuItemView.Function.SHARE);
        MenuItemView.a aVar2 = new MenuItemView.a(R.drawable.lx_webapp_menu_copy, "复制链接", MenuItemView.Function.COPY);
        MenuItemView.a aVar3 = new MenuItemView.a(R.drawable.lx_webapp_menu_refresh, "刷新", MenuItemView.Function.REFRESH);
        MenuItemView.a aVar4 = new MenuItemView.a(R.drawable.lx_webapp_menu_feedback, "反馈与投诉", MenuItemView.Function.FEEDBACK);
        MenuItemView.a aVar5 = new MenuItemView.a(R.drawable.lx_webapp_menu_float, "浮窗", MenuItemView.Function.ADD_FLOAT);
        MenuItemView.a aVar6 = new MenuItemView.a(R.drawable.lx_webapp_menu_moment, "分享到好友圈", MenuItemView.Function.MOMENT);
        menuItems.add(aVar5);
        menuItems.add(aVar);
        menuItems.add(aVar6);
        menuItems.add(aVar2);
        menuItems.add(aVar3);
        menuItems.add(aVar4);
    }

    public MenuDialogView(Context context) {
        this(context, null);
    }

    private void sendClickEvent(int i, Object obj) {
        fa3 fa3Var = this.mCallback;
        if (fa3Var != null) {
            fa3Var.onEvent(i, obj);
        }
    }

    public void initView(b bVar) {
        super.initView((LxDialogView.a) bVar);
        View viewFindViewById = findViewById(R.id.rl_webapp_info);
        viewFindViewById.setOnClickListener(this);
        if (bVar.f12052a != null) {
            gr2.j().h(bVar.f12052a.c, (ImageView) findViewById(R.id.iv_webapp_appicon), a46.j(getContext(), 10.0f, 0));
            ((TextView) findViewById(R.id.tv_webapp_appname)).setText(bVar.f12052a.b);
        } else {
            viewFindViewById.setVisibility(8);
        }
        findViewById(R.id.btn_webapp_menu_cancel).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_webapp_function_bar);
        for (MenuItemView.a aVar : menuItems) {
            if (aVar.b != MenuItemView.Function.MOMENT || h84.c()) {
                MenuItemView menuItemView = new MenuItemView(getContext());
                menuItemView.updateItem(aVar);
                linearLayout.addView(menuItemView);
                menuItemView.setOnClickListener(this);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!(view instanceof MenuItemView)) {
            if (view.getId() != R.id.rl_webapp_info && view.getId() == R.id.btn_webapp_menu_cancel) {
                sendClickEvent(6, null);
                return;
            }
            return;
        }
        switch (a.f12051a[((MenuItemView) view).getFunction().ordinal()]) {
            case 1:
                sendClickEvent(2, null);
                break;
            case 2:
                sendClickEvent(1, null);
                break;
            case 3:
                sendClickEvent(3, null);
                break;
            case 4:
                sendClickEvent(4, null);
                break;
            case 5:
                sendClickEvent(7, null);
                break;
            case 6:
                sendClickEvent(8, null);
                break;
        }
    }

    public MenuDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MenuDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
