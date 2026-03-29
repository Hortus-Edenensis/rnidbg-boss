package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.wifi.adsdk.entity.LxAdAbsItem;
import com.zenmen.palmchat.ad.ShakeView;
import com.zenmen.palmchat.ad.compliance.AdComInfoLayoutBase;
import com.zenmen.palmchat.ad.nest.nativead.ui.square.NestSquareAdPager;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.framework.R$string;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class rv3 extends jv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[][] f20583a = {new float[]{208.0f, 117.0f}, new float[]{208.0f, 138.0f}, new float[]{135.0f, 240.0f}};
    public static je1 b = null;
    public static je1 c = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20584a;
        public final /* synthetic */ NestAdData b;

        public a(Context context, NestAdData nestAdData) {
            this.f20584a = context;
            this.b = nestAdData;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (isViewFromObject(childAt, obj)) {
                    viewGroup.removeView(childAt);
                    return;
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View viewInflate = LayoutInflater.from(this.f20584a).inflate(R$layout.nest_square_generic_list_item_ad_group_item, (ViewGroup) null, false);
            List<String> imageList = this.b.getImageList();
            String str = imageList.get(i % imageList.size());
            gr2 gr2VarJ = gr2.j();
            if (str == null) {
                str = "";
            }
            gr2VarJ.h(str, (ImageView) viewInflate.findViewById(R$id.ad_img), rv3.c);
            viewGroup.addView(viewInflate);
            return viewInflate;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20585a;

        public b(int i) {
            this.f20585a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l6.k(this.f20585a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ on2 f20586a;
        public final /* synthetic */ hv3 b;
        public final /* synthetic */ NestAdData c;

        public c(on2 on2Var, hv3 hv3Var, NestAdData nestAdData) {
            this.f20586a = on2Var;
            this.b = hv3Var;
            this.c = nestAdData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            on2 on2Var = this.f20586a;
            if (on2Var != null) {
                on2Var.a(this.b.h(), this.b.f());
            }
            NestAdData nestAdData = this.c;
            if (nestAdData == null || !(nestAdData.getAdData() instanceof LxAdAbsItem)) {
                return;
            }
            ((LxAdAbsItem) this.c.getAdData()).adRemoveDone();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements NestAdData.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ on2 f20587a;

        public d(on2 on2Var) {
            this.f20587a = on2Var;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            on2 on2Var = this.f20587a;
            if (on2Var != null) {
                on2Var.onAdClicked(nestAdData);
            }
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            on2 on2Var = this.f20587a;
            if (on2Var != null) {
                on2Var.onAdExposed(nestAdData);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02ff A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x032d A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0342 A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0348 A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03c6 A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03cc A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03d5 A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0406 A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0452 A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x045c A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04ad A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x023e A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0270 A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0298 A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02bc A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02f4 A[Catch: Exception -> 0x04be, TryCatch #0 {Exception -> 0x04be, blocks: (B:3:0x0006, B:7:0x0020, B:10:0x002c, B:13:0x0035, B:16:0x003e, B:18:0x004a, B:22:0x0053, B:24:0x0077, B:26:0x008c, B:28:0x009c, B:97:0x02f4, B:98:0x02f7, B:100:0x02ff, B:101:0x0307, B:104:0x0316, B:106:0x032d, B:107:0x032f, B:109:0x0342, B:111:0x038b, B:115:0x0397, B:117:0x03c6, B:119:0x03d1, B:121:0x03d5, B:122:0x03dd, B:124:0x03ea, B:126:0x03f4, B:127:0x03f8, B:129:0x0406, B:130:0x0408, B:135:0x0452, B:138:0x045c, B:142:0x0465, B:144:0x0485, B:146:0x0490, B:147:0x0499, B:153:0x04a5, B:155:0x04b1, B:154:0x04ad, B:118:0x03cc, B:110:0x0348, B:27:0x0099, B:29:0x00e3, B:31:0x00ef, B:33:0x00ff, B:37:0x011d, B:38:0x0124, B:40:0x0129, B:42:0x013b, B:45:0x014c, B:44:0x0143, B:48:0x0156, B:50:0x0186, B:53:0x0194, B:68:0x01d3, B:70:0x01db, B:73:0x01f2, B:75:0x0203, B:77:0x023e, B:79:0x0249, B:81:0x0251, B:91:0x0286, B:93:0x0298, B:95:0x02df, B:94:0x02bc, B:85:0x0260, B:87:0x0270, B:90:0x0281, B:32:0x00fc), top: B:162:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(ViewGroup viewGroup, iv3 iv3Var, Context context) {
        hv3 hv3Var;
        c6 c6VarE;
        int i;
        int i2;
        View view;
        View view2;
        boolean z;
        TextView textView;
        View viewFindViewById;
        View view3;
        View viewFindViewById2;
        View view4;
        int i3;
        int i4;
        String adIcon;
        String adAppName;
        String title;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        int i5;
        try {
            LogUtil.d("", "NativeType NestNativeUiSquare bindAdView adViewGroup " + viewGroup);
            if (viewGroup == null || iv3Var == null || context == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            NestAdData nestAdDataA = iv3Var.a();
            if (nestAdDataA == null) {
                return;
            }
            bv3 bv3VarB = iv3Var.b();
            if ((bv3VarB instanceof hv3) && (c6VarE = (hv3Var = (hv3) bv3VarB).e()) != null) {
                on2 on2VarA = hv3Var.a();
                List<String> imageList = nestAdDataA.getImageList();
                int i6 = 0;
                boolean z2 = imageList != null && imageList.size() > 1;
                LogUtil.d("", "NativeType NestNativeUiSquare bindAdView start isGroupMode " + z2);
                View viewFindViewById3 = viewGroup.findViewById(R$id.ad_main_group);
                View viewFindViewById4 = viewGroup.findViewById(R$id.ad_main_normal);
                if (z2) {
                    int i7 = R$id.ad_down_yaoyiyao_layout_group;
                    arrayList.add(viewGroup.findViewById(i7));
                    viewFindViewById = viewGroup.findViewById(R$id.ad_yaoyiyao_group);
                    if (ShakeView.shakeEnabled(nestAdDataA)) {
                        viewFindViewById.setVisibility(0);
                        jv3.j(viewGroup.findViewById(R$id.yy_shake_bg_group));
                    } else {
                        viewFindViewById.setVisibility(8);
                    }
                    viewFindViewById3.setVisibility(0);
                    viewFindViewById4.setVisibility(8);
                    nestAdDataA.setHwDownBtnTag("huawei_download_btn_group");
                    NestSquareAdPager nestSquareAdPager = (NestSquareAdPager) viewGroup.findViewById(R$id.ad_pager);
                    arrayList.add(nestSquareAdPager);
                    nestSquareAdPager.setAdapter(new a(context, nestAdDataA));
                    nestSquareAdPager.setCurrentItem(0);
                    nestSquareAdPager.beginAutoScroll();
                    ((ImageView) viewGroup.findViewById(R$id.ad_logo_group)).setImageResource(nestAdDataA.getAdLogoResId());
                    textView = (TextView) viewGroup.findViewById(R$id.ad_action_group);
                    viewFindViewById2 = viewGroup.findViewById(i7);
                    arrayList.add(textView);
                    z = z2;
                    view3 = viewFindViewById2;
                } else {
                    View viewFindViewById5 = viewGroup.findViewById(R$id.ad_yaoyiyao);
                    if (ShakeView.shakeEnabled(nestAdDataA)) {
                        viewFindViewById5.setVisibility(0);
                        jv3.j(viewGroup.findViewById(R$id.yy_shake_bg));
                    } else {
                        viewFindViewById5.setVisibility(8);
                    }
                    viewFindViewById3.setVisibility(8);
                    viewFindViewById4.setVisibility(0);
                    nestAdDataA.setHwDownBtnTag("huawei_download_btn");
                    float nativeAdImgWidth = nestAdDataA.getNativeAdImgWidth();
                    float nativeAdImgHeight = nestAdDataA.getNativeAdImgHeight();
                    if (nativeAdImgWidth <= 0.0f || nativeAdImgHeight <= 0.0f) {
                        i = 0;
                        i2 = 0;
                    } else {
                        float f = nativeAdImgWidth / nativeAdImgHeight;
                        Float fValueOf = null;
                        int i8 = 0;
                        int i9 = 0;
                        i2 = 0;
                        while (true) {
                            float[][] fArr = f20583a;
                            if (i8 >= fArr.length) {
                                break;
                            }
                            float[] fArr2 = fArr[i8];
                            float fAbs = Math.abs((fArr2[0] / fArr2[1]) - f);
                            if (fValueOf == null || fAbs < fValueOf.floatValue()) {
                                fValueOf = Float.valueOf(fAbs);
                                i9 = i8;
                                i2 = i9;
                            }
                            i8++;
                        }
                        i = i9;
                    }
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById4.getLayoutParams();
                    float[][] fArr3 = f20583a;
                    layoutParams.width = me1.a(context, fArr3[i][0]);
                    layoutParams.height = me1.a(context, fArr3[i][1]);
                    int i10 = R$id.ad_down_yaoyiyao_layout;
                    View viewFindViewById6 = viewGroup.findViewById(i10);
                    if (nestAdDataA.getZhiboAd().booleanValue()) {
                        View viewFindViewById7 = viewGroup.findViewById(R$id.zhibo_layout);
                        View viewFindViewById8 = viewGroup.findViewById(i10);
                        if (viewFindViewById7 == null || viewFindViewById8 == null) {
                            view4 = viewFindViewById6;
                        } else {
                            viewFindViewById7.setVisibility(0);
                            viewFindViewById8.setVisibility(8);
                            arrayList.add(viewFindViewById7);
                            view4 = viewFindViewById7;
                        }
                        try {
                            view2 = view4;
                            try {
                                view = viewFindViewById6;
                                try {
                                    Glide.with(viewGroup.getContext()).asGif().load2(Integer.valueOf(R$drawable.zhibo_gif_img_bg)).into((ImageView) viewGroup.findViewById(R$id.zhibo_gif_img));
                                } catch (Exception unused) {
                                }
                            } catch (Exception unused2) {
                                view = viewFindViewById6;
                                if (i == 2) {
                                }
                                layoutParams.width = me1.b(context, i3);
                                layoutParams.height = me1.b(context, i4);
                                viewFindViewById4.setLayoutParams(layoutParams);
                                arrayList.add(viewGroup.findViewById(R$id.ad_main_normal));
                                FrameLayout frameLayout3 = (FrameLayout) viewGroup.findViewById(R$id.ad_video);
                                arrayList.add(frameLayout3);
                                frameLayout3.removeAllViews();
                                EffectiveShapeView effectiveShapeView = (EffectiveShapeView) viewGroup.findViewById(R$id.ad_img);
                                arrayList.add(effectiveShapeView);
                                ImageView imageView = (ImageView) viewGroup.findViewById(R$id.ad_logo_normal);
                                ImageView imageView2 = (ImageView) viewGroup.findViewById(R$id.ad_logo_normal_169);
                                if (jv3.h(nestAdDataA)) {
                                }
                                View viewFindViewById9 = viewGroup.findViewById(R$id.ad_normal_space);
                                View viewFindViewById10 = viewGroup.findViewById(R$id.ad_down_button_layout_normal);
                                if (i != 2) {
                                }
                                textView = (TextView) viewGroup.findViewById(R$id.ad_action_normal);
                                arrayList.add(textView);
                                viewFindViewById = viewFindViewById5;
                                i6 = i2;
                                view3 = view2;
                                viewFindViewById2 = view;
                                if (viewFindViewById2 != null) {
                                }
                                adIcon = nestAdDataA.getAdIcon();
                                if (b == null) {
                                }
                                ImageView imageView3 = (ImageView) viewGroup.findViewById(R$id.ad_app_icon);
                                gr2 gr2VarJ = gr2.j();
                                if (adIcon == null) {
                                }
                                gr2VarJ.h(adIcon, imageView3, b);
                                adAppName = nestAdDataA.getAdAppName();
                                TextView textView2 = (TextView) viewGroup.findViewById(R$id.ad_app_name);
                                if (TextUtils.isEmpty(adAppName)) {
                                }
                                textView2.setText(adAppName);
                                TextView textView3 = (TextView) viewGroup.findViewById(R$id.ad_infor);
                                if (TextUtils.isEmpty(c6VarE.h)) {
                                }
                                if (hv3Var.g() != hv3.h) {
                                }
                                l6.l(i);
                                viewGroup.findViewById(R$id.vip_entrance).setOnClickListener(new b(i));
                                viewGroup.findViewById(R$id.ad_drop).setOnClickListener(new c(on2VarA, hv3Var, nestAdDataA));
                                TextView textView4 = (TextView) viewGroup.findViewById(R$id.ad_sign);
                                if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
                                }
                                if (c == null) {
                                }
                                jv3.b(nestAdDataA, textView, viewFindViewById);
                                title = nestAdDataA.getTitle();
                                if (!TextUtils.isEmpty(title)) {
                                    title = nestAdDataA.getDescription();
                                }
                                TextView textView5 = (TextView) viewGroup.findViewById(R$id.ad_title);
                                if (TextUtils.isEmpty(title)) {
                                }
                                textView5.setText(title);
                                arrayList.add(textView5);
                                nestAdDataA.setAdInteractionListener(new d(on2VarA));
                                jv3.f(viewGroup.findViewById(R$id.ad_discount_info_layout), (TextView) viewGroup.findViewById(R$id.ad_discount_info_textview), nestAdDataA);
                                jv3.e(nestAdDataA, (AdComInfoLayoutBase) viewGroup.findViewById(R$id.ad_com_info_layout));
                                frameLayout = (FrameLayout) viewGroup.findViewById(R$id.interactive_type_layout);
                                frameLayout2 = (FrameLayout) viewGroup.findViewById(R$id.interactive_type_all_layout);
                                if (nestAdDataA.getInteractionType().intValue() != 1) {
                                }
                                if (frameLayout2 == null) {
                                }
                                if (frameLayout != null) {
                                }
                                if (!z) {
                                }
                                jv3.k(nestAdDataA, viewGroup, view3, arrayList, viewGroup.getContext());
                                LogUtil.d("", "NativeType NestNativeUiSquare bindAdView end ");
                            }
                        } catch (Exception unused3) {
                            view2 = view4;
                        }
                        if (i == 2) {
                            if (viewFindViewById7 != null && (viewFindViewById7.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                                ((FrameLayout.LayoutParams) viewFindViewById7.getLayoutParams()).bottomMargin = me1.b(context, 60);
                            }
                            i3 = 250;
                            i4 = 170;
                        } else {
                            i3 = EffectConstants.ROTATION_DEGREES_180;
                            i4 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
                        }
                        layoutParams.width = me1.b(context, i3);
                        layoutParams.height = me1.b(context, i4);
                    } else {
                        view = viewFindViewById6;
                        view2 = view;
                    }
                    viewFindViewById4.setLayoutParams(layoutParams);
                    arrayList.add(viewGroup.findViewById(R$id.ad_main_normal));
                    FrameLayout frameLayout32 = (FrameLayout) viewGroup.findViewById(R$id.ad_video);
                    arrayList.add(frameLayout32);
                    frameLayout32.removeAllViews();
                    EffectiveShapeView effectiveShapeView2 = (EffectiveShapeView) viewGroup.findViewById(R$id.ad_img);
                    arrayList.add(effectiveShapeView2);
                    ImageView imageView4 = (ImageView) viewGroup.findViewById(R$id.ad_logo_normal);
                    ImageView imageView22 = (ImageView) viewGroup.findViewById(R$id.ad_logo_normal_169);
                    if (jv3.h(nestAdDataA)) {
                        z = z2;
                        effectiveShapeView2.setVisibility(0);
                        String strD = jv3.d(nestAdDataA);
                        gr2 gr2VarJ2 = gr2.j();
                        if (strD == null) {
                            strD = "";
                        }
                        gr2VarJ2.h(strD, effectiveShapeView2, c);
                    } else {
                        effectiveShapeView2.setVisibility(8);
                        View adView = nestAdDataA.getAdView();
                        if (adView != null) {
                            ViewParent parent = adView.getParent();
                            boolean z3 = parent instanceof ViewGroup;
                            if (z3) {
                                z = z2;
                                ((ViewGroup) parent).removeView(adView);
                            } else {
                                z = z2;
                            }
                            if (parent == null || z3) {
                                frameLayout32.addView(adView, new ViewGroup.LayoutParams(-1, -1));
                                AdDownViVoConfig.checkVideoViewClick(nestAdDataA, frameLayout32);
                            }
                        } else {
                            z = z2;
                        }
                    }
                    View viewFindViewById92 = viewGroup.findViewById(R$id.ad_normal_space);
                    View viewFindViewById102 = viewGroup.findViewById(R$id.ad_down_button_layout_normal);
                    if (i != 2) {
                        imageView22.setVisibility(0);
                        imageView22.setImageResource(nestAdDataA.getAdLogoResId());
                        imageView4.setVisibility(8);
                        viewFindViewById92.setVisibility(8);
                        viewFindViewById102.setPadding(0, me1.b(context, 9), me1.b(context, 0), me1.b(context, 5));
                    } else {
                        imageView4.setVisibility(0);
                        viewFindViewById92.setVisibility(0);
                        imageView22.setVisibility(8);
                        imageView4.setImageResource(nestAdDataA.getAdLogoResId());
                        viewFindViewById102.setPadding(0, me1.b(context, 9), me1.b(context, 8), me1.b(context, 5));
                    }
                    textView = (TextView) viewGroup.findViewById(R$id.ad_action_normal);
                    arrayList.add(textView);
                    viewFindViewById = viewFindViewById5;
                    i6 = i2;
                    view3 = view2;
                    viewFindViewById2 = view;
                }
                if (viewFindViewById2 != null) {
                    arrayList.add(viewFindViewById2);
                }
                adIcon = nestAdDataA.getAdIcon();
                if (b == null) {
                    b = a46.i(R$drawable.default_portrait);
                }
                ImageView imageView32 = (ImageView) viewGroup.findViewById(R$id.ad_app_icon);
                gr2 gr2VarJ3 = gr2.j();
                if (adIcon == null) {
                    adIcon = "";
                }
                gr2VarJ3.h(adIcon, imageView32, b);
                adAppName = nestAdDataA.getAdAppName();
                TextView textView22 = (TextView) viewGroup.findViewById(R$id.ad_app_name);
                if (TextUtils.isEmpty(adAppName)) {
                    adAppName = c6VarE.f;
                }
                textView22.setText(adAppName);
                TextView textView32 = (TextView) viewGroup.findViewById(R$id.ad_infor);
                if (TextUtils.isEmpty(c6VarE.h)) {
                    textView32.setVisibility(0);
                    textView32.setText(q(q(c6VarE.h, ContainerUtils.FIELD_DELIMITER, p(c6VarE.i, c6VarE.j) + ""), "$", p(c6VarE.k, c6VarE.l) + ""));
                } else {
                    textView32.setVisibility(8);
                }
                int i11 = hv3Var.g() != hv3.h ? 38 : 0;
                l6.l(i11);
                viewGroup.findViewById(R$id.vip_entrance).setOnClickListener(new b(i11));
                viewGroup.findViewById(R$id.ad_drop).setOnClickListener(new c(on2VarA, hv3Var, nestAdDataA));
                TextView textView42 = (TextView) viewGroup.findViewById(R$id.ad_sign);
                if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
                    textView42.setText(R$string.common_ad);
                } else {
                    textView42.setText(R$string.personalize_ad);
                }
                if (c == null) {
                    c = a46.i(R$drawable.nest_bg_feed_item_loading);
                }
                jv3.b(nestAdDataA, textView, viewFindViewById);
                title = nestAdDataA.getTitle();
                if (!TextUtils.isEmpty(title) && title.equals(nestAdDataA.getAdAppName())) {
                    title = nestAdDataA.getDescription();
                }
                TextView textView52 = (TextView) viewGroup.findViewById(R$id.ad_title);
                if (TextUtils.isEmpty(title)) {
                    title = c6VarE.g;
                }
                textView52.setText(title);
                arrayList.add(textView52);
                nestAdDataA.setAdInteractionListener(new d(on2VarA));
                jv3.f(viewGroup.findViewById(R$id.ad_discount_info_layout), (TextView) viewGroup.findViewById(R$id.ad_discount_info_textview), nestAdDataA);
                jv3.e(nestAdDataA, (AdComInfoLayoutBase) viewGroup.findViewById(R$id.ad_com_info_layout));
                frameLayout = (FrameLayout) viewGroup.findViewById(R$id.interactive_type_layout);
                frameLayout2 = (FrameLayout) viewGroup.findViewById(R$id.interactive_type_all_layout);
                boolean z4 = nestAdDataA.getInteractionType().intValue() != 1;
                if (frameLayout2 == null) {
                    i5 = 8;
                    frameLayout2.setVisibility(8);
                } else {
                    i5 = 8;
                }
                if (frameLayout != null) {
                    frameLayout.setVisibility(i5);
                }
                if (!z) {
                    nestAdDataA.setInteractiveType(0);
                } else if (frameLayout != null && frameLayout2 != null) {
                    frameLayout.setVisibility(i5);
                    frameLayout2.setVisibility(i5);
                    int interactiveStatus = nestAdDataA.getInteractiveStatus();
                    LogUtil.d("", "NativeType NestNativeUiSquare adData interactiveStatus " + interactiveStatus);
                    if (interactiveStatus == 0) {
                        WkInteractiveManager.addInteractiveView(frameLayout, nestAdDataA, i6, z4, 1003);
                        if (frameLayout.getVisibility() == 0) {
                            frameLayout2.setVisibility(0);
                            nestAdDataA.setInteractiveStatus(1);
                        } else {
                            nestAdDataA.setInteractiveStatus(-1);
                        }
                    } else if (interactiveStatus != -1 && interactiveStatus == 1) {
                        frameLayout.setVisibility(0);
                        frameLayout2.setVisibility(0);
                    }
                }
                jv3.k(nestAdDataA, viewGroup, view3, arrayList, viewGroup.getContext());
                LogUtil.d("", "NativeType NestNativeUiSquare bindAdView end ");
            }
        } catch (Exception e) {
            LogUtil.d("", "NativeType NestNativeUiSquare bindAdView Exception " + e.toString());
        }
    }

    public static View o(iv3 iv3Var, Context context) {
        View viewInflate = null;
        if (iv3Var != null && context != null) {
            viewInflate = LayoutInflater.from(context).inflate(R$layout.nest_square_generic_list_item_ad2, (ViewGroup) null, false);
        }
        LogUtil.d("", "NativeType NestNativeUiSquare createAdView adView " + viewInflate);
        return viewInflate;
    }

    public static int p(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    public static String q(String str, String str2, String str3) {
        if (str2.equals("")) {
            throw new IllegalArgumentException("Old pattern must have content.");
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf < 0) {
                stringBuffer.append(str.substring(length));
                return stringBuffer.toString();
            }
            stringBuffer.append(str.substring(length, iIndexOf));
            stringBuffer.append(str3);
            length = str2.length() + iIndexOf;
        }
    }
}
