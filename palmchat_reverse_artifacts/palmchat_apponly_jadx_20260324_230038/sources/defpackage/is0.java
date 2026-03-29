package defpackage;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.zenmen.palmchat.framework.R$dimen;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.framework.R$style;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class is0 {
    public static final String b = "is0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PopupWindow f18245a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f18246a;
        public final /* synthetic */ e b;

        public a(ArrayList arrayList, e eVar) {
            this.f18246a = arrayList;
            this.b = eVar;
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            this.b.a(i, ((g) this.f18246a.get(i)).f18250a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f18247a;

        public b(Activity activity) {
            this.f18247a = activity;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
                return true;
            }
            is0.this.b(this.f18247a);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f18248a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Activity c;

        public c(f fVar, String str, Activity activity) {
            this.f18248a = fVar;
            this.b = str;
            this.c = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar = this.f18248a;
            if (fVar != null) {
                fVar.onItemClicked(((Integer) view.getTag()).intValue());
                if (this.b.equals("免费wifi") && ox3.a("key_wifi_fast")) {
                    ox3.e("key_wifi_fast");
                    r75.q(com.zenmen.palmchat.c.b(), "sp_click_wifi_time", ir5.b());
                }
            }
            is0.this.b(this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f18249a;

        public d(Activity activity, h hVar) {
            this.f18249a = activity;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            is0.this.a(this.f18249a, Float.valueOf(1.0f));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(int i, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void onItemClicked(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f18250a;
        public String b;
        public int c;

        public g(String str, String str2, int i) {
            this.f18250a = str;
            this.b = str2;
            this.c = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
    }

    public void a(Activity activity, Float f2) {
        Window window;
        WindowManager.LayoutParams attributes;
        if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.alpha = f2.floatValue();
        window.addFlags(2);
        window.setAttributes(attributes);
    }

    public void b(Activity activity) {
        LogUtil.i(b, "hidePopupMenu");
        PopupWindow popupWindow = this.f18245a;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.f18245a.dismiss();
        a(activity, Float.valueOf(1.0f));
    }

    public void c(Activity activity, View view, ArrayList<g> arrayList, e eVar, h hVar, boolean z) {
        a aVar = new a(arrayList, eVar);
        String[] strArr = new String[arrayList.size()];
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            strArr[i] = arrayList.get(i).b;
            iArr[i] = arrayList.get(i).c;
        }
        d(activity, view, strArr, iArr, aVar, hVar, z);
    }

    public void d(Activity activity, View view, String[] strArr, int[] iArr, f fVar, h hVar, boolean z) {
        LogUtil.i(b, "showPopupMenu");
        a(activity, Float.valueOf(0.9f));
        LinearLayout linearLayout = new LinearLayout(activity);
        this.f18245a = new PopupWindow(linearLayout, -2, -2);
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        linearLayout.setOnKeyListener(new b(activity));
        linearLayout.setOrientation(1);
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            View viewInflate = activity.getLayoutInflater().inflate(R$layout.item_popup_menu, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.thumb);
            if (iArr != null) {
                imageView.setImageResource(iArr[i]);
            } else {
                imageView.setVisibility(8);
            }
            ((TextView) viewInflate.findViewById(R$id.title)).setText(strArr[i]);
            String str = strArr[i];
            View viewFindViewById = viewInflate.findViewById(R$id.reddot);
            if (z && str.equals("免费wifi")) {
                if (ox3.a("key_wifi_fast")) {
                    viewFindViewById.setVisibility(0);
                } else {
                    viewFindViewById.setVisibility(8);
                }
            }
            viewInflate.setOnClickListener(new c(fVar, str, activity));
            viewInflate.setTag(Integer.valueOf(i));
            viewInflate.setTag(R$id.tag_first, strArr[i]);
            viewInflate.findViewById(R$id.menu_sep).setVisibility(8);
            linearLayout.addView(viewInflate);
        }
        linearLayout.setGravity(17);
        linearLayout.setBackgroundResource(R$drawable.menu_bg);
        this.f18245a.setBackgroundDrawable(new ColorDrawable(0));
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f18245a.setAnimationStyle(R$style.AnimationPopMenuDialog);
        this.f18245a.setContentView(linearLayout);
        this.f18245a.setOutsideTouchable(false);
        this.f18245a.setFocusable(true);
        this.f18245a.setOnDismissListener(new d(activity, hVar));
        if (!this.f18245a.isShowing()) {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i2 = rect.top;
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            try {
                this.f18245a.showAtLocation(view, 0, (iArr2[0] + view.getWidth()) - me1.b(activity, 2), (activity.getResources().getDimensionPixelOffset(R$dimen.title_bar_height) - me1.a(activity, 10.5f)) + i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.f18245a.update();
    }
}
