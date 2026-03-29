package defpackage;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.maintab.skin.vo.NavigationBar;
import com.zenmen.palmchat.maintab.skin.vo.SkinConfig;
import com.zenmen.palmchat.maintab.skin.vo.SkinTab;
import com.zenmen.palmchat.maintab.skin.vo.SkinTabItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.je1;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class pe5 {
    public static volatile pe5 c;
    public static je1 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SkinConfig f20003a;
    public Boolean b = null;

    public pe5() {
        d = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
    }

    public static pe5 a() {
        if (c == null) {
            synchronized (pe5.class) {
                if (c == null) {
                    c = new pe5();
                }
            }
        }
        return c;
    }

    public final SkinConfig b() {
        return this.f20003a;
    }

    public Pair<String, String> c(TabItem tabItem) {
        SkinTabItem next;
        List<SkinTabItem> list;
        if (!f()) {
            return null;
        }
        SkinTab skinTab = b().tab;
        if (skinTab == null || (list = skinTab.list) == null || list.size() <= 0) {
            next = null;
        } else {
            Iterator<SkinTabItem> it = skinTab.list.iterator();
            while (it.hasNext()) {
                next = it.next();
                String str = next.tag;
                if (str != null && str.equals(tabItem.tag)) {
                    break;
                }
            }
            next = null;
        }
        if (next == null || TextUtils.isEmpty(next.selectedIconAddr) || TextUtils.isEmpty(next.unSelectedIconAddr)) {
            return null;
        }
        return new Pair<>(next.unSelectedIconAddr, next.selectedIconAddr);
    }

    public String d() {
        if (!f() || b().tab == null) {
            return null;
        }
        return b().tab.selectedFontColor;
    }

    public String e() {
        if (!f() || b().tab == null) {
            return null;
        }
        return b().tab.unSelectedFontColor;
    }

    public final boolean f() {
        if (this.b == null) {
            this.b = Boolean.valueOf(g());
        }
        return this.b.booleanValue();
    }

    public final boolean g() {
        String str;
        boolean z = false;
        if (b() != null) {
            long j = b().startDate * 1000;
            long j2 = b().endDate * 1000;
            long jB = ir5.b();
            if (j < jB && jB < j2) {
                SkinConfig skinConfigB = b();
                NavigationBar navigationBar = skinConfigB.navigationBar;
                if (navigationBar == null || (str = navigationBar.imageAddr3X) == null) {
                    z = true;
                } else {
                    File fileB = sd1.b(str);
                    if (fileB == null || !fileB.exists() || fileB.length() <= 0) {
                        LogUtil.i("SkinManager", "isEnableImp cache fail");
                        gr2.j().k(skinConfigB.navigationBar.imageAddr3X, d, new a());
                    } else {
                        LogUtil.i("SkinManager", "isEnableImp cache ok");
                        z = true;
                    }
                }
            }
        }
        LogUtil.i("SkinManager", "isEnableImp" + z);
        return z;
    }

    public void h() {
        this.f20003a = ec3.j().k();
        this.b = null;
    }

    public void i(Window window, ImageView imageView, TextView textView) {
        NavigationBar navigationBar;
        String str;
        if (!f() || b().navigationBar == null) {
            return;
        }
        SkinConfig skinConfigB = b();
        if (imageView != null && skinConfigB.navigationBar.imageAddr3X != null) {
            gr2.j().h(skinConfigB.navigationBar.imageAddr3X, imageView, d);
        }
        if (textView != null && (navigationBar = skinConfigB.navigationBar) != null && (str = navigationBar.titleColor) != null) {
            textView.setTextColor(Color.parseColor(str));
        }
        me1.o(window, skinConfigB.navigationBar.showDarkStatusBar());
    }

    public void j(Menu menu) {
        SkinConfig skinConfigB;
        NavigationBar navigationBar;
        if (!f() || menu == null || menu.size() <= 0 || (navigationBar = (skinConfigB = b()).navigationBar) == null || navigationBar.titleColor == null) {
            return;
        }
        for (int i = 0; i < menu.size(); i++) {
            qe5.b(menu.getItem(i), Color.parseColor(skinConfigB.navigationBar.iconClickedColor), Color.parseColor(skinConfigB.navigationBar.iconColor));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements jr2 {
        public a() {
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            LogUtil.i("SkinManager", "isEnableImp cache onLoadingComplete");
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }
}
