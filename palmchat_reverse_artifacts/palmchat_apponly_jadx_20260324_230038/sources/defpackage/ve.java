package defpackage;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import com.google.gson.reflect.TypeToken;
import com.huawei.openalliance.ad.constant.az;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.dn;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.find.ConditionHelper;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.NoticeBarExt;
import com.zenmen.palmchat.Vo.NoticeBarStyle;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.MCheckPermissionActivity;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.InputFragment;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.chat.gift.ShowChatGiftPanelEvent;
import com.zenmen.palmchat.circle.app.assitant.CircleAssitantActivity;
import com.zenmen.palmchat.circle.ui.CircleAuthActivity;
import com.zenmen.palmchat.circle.ui.CircleChooseSearchFunActivity;
import com.zenmen.palmchat.circle.ui.CircleDetailActivity;
import com.zenmen.palmchat.circle.ui.CircleEditDetailActivity;
import com.zenmen.palmchat.circle.ui.CircleFindActivity;
import com.zenmen.palmchat.circle.ui.CircleNameModifyActivity;
import com.zenmen.palmchat.circle.ui.CircleNoteActivity;
import com.zenmen.palmchat.circle.ui.CircleNoteDetailActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.NewContactActivity;
import com.zenmen.palmchat.contacts.recommend.EnhanceRecommendActivity;
import com.zenmen.palmchat.contacts.userdetail.UserFeedActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.giftkit.a;
import com.zenmen.palmchat.groupchat.GroupCateSelectActivity;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.mine.track.TrackHomeActivity;
import com.zenmen.palmchat.paidservices.superexpose.SuperExposeHomeActivity;
import com.zenmen.palmchat.settings.ChargingSettingsActivity;
import com.zenmen.palmchat.settings.PersonalInfoActivity;
import com.zenmen.palmchat.settings.about.AboutActivity;
import com.zenmen.palmchat.settings.cert.CertGuideActivity;
import com.zenmen.palmchat.settings.cert.a;
import com.zenmen.palmchat.settings.portrait.PortraitAlbumActivity;
import com.zenmen.palmchat.smallvideo.EnterScene;
import com.zenmen.palmchat.smallvideo.SmallVideoEntranceController;
import com.zenmen.palmchat.smallvideo.VideoSDKPushReceiver;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.update.UpdateManager;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.utils.traceroutePing.NetDetectActivity;
import com.zenmen.palmchat.webplatform.TransparentLyWebActivity;
import com.zenmen.palmchat.webplatform.WebModuleActivity;
import com.zenmen.palmchat.webplatform.miniPrograms.Package;
import com.zenmen.square.MediaViewActivity;
import com.zenmen.square.NestTagFeedsActivity;
import com.zenmen.square.NestTopicFeedsActivity;
import com.zenmen.square.SquareMessageActivity;
import com.zenmen.square.activity.SquareCircleActivity;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.tag.bean.SquareTagBean;
import defpackage.fk2;
import defpackage.rp2;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f21413a = new a();
    public static boolean b = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashSet<String> {
        public a() {
            add("a0000");
            add("a0001");
            add("a0002");
            add("a0003");
            add("a0004");
            add("a0005");
            add("a0008");
            add("a0010");
            add("a00010");
            add("a0100");
            add("a0102");
            add("a0103");
            add("a0104");
            add("a0105");
            add("a0040");
            add("a0041");
            add("a0042");
            add("a0045");
            add("a00451");
            add("a0046");
            add("a0050");
            add("a0051");
            add("a0052");
            add("a0061");
            add("a0062");
            add("a0063");
            add("a0043");
            add("a0101");
            add("a0200");
            add("a0064");
            add("a0065");
            add("a0011");
            add("a0012");
            add("a0013");
            add("a00320");
            add("a0201");
            add("a0202");
            add("a0203");
            add("a0211");
            add("a0083");
            add("a0085");
            add("a0086");
            add("a0087");
            add("a0088");
            add("a0089");
            add("a0090");
            add("a0091");
            add("a100");
            add("a0207");
            add("a0204");
            add("a0205");
            add("a0206");
            add("a0208");
            add("a0260");
            add("a0301");
            add("a0302");
            add("a0066");
            add("a0303");
            add("a0304");
            add("a0305");
            add("a0306");
            add("a0308");
            add("a0401");
            add("a0402");
            add("a0403");
            add("a0515");
            add("a0404");
            add("a0405");
            add("a0406");
            add("a0407");
            add("a0408");
            add("a0409");
            add("a0410");
            add("a0412");
            add("a0413");
            add("a0414");
            add("a0450");
            add("a0451");
            add("a0460");
            add("a0461");
            add("a0462");
            add("a0500");
            add("a10086");
            add("a10087");
            add("a0092");
            add("a0520");
            add("a0510");
            add("a0511");
            add("a0512");
            add("a0513");
            add("a0514");
            add("a0516");
            add("a0521");
            add("a0642");
            add("a0620");
            add("a0621");
            add("a0624");
            add("a0623");
            add("a0628");
            add("a0630");
            add("a0631");
            add("a0640");
            add("a0641");
            add("a0629");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContentValues f21416a;
        public final /* synthetic */ Activity b;

        public c(ContentValues contentValues, Activity activity) {
            this.f21416a = contentValues;
            this.b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            String asString = this.f21416a.getAsString(DeviceInfoUtil.UID_TAG);
            String asString2 = this.f21416a.getAsString(bd.h);
            if (asString == null || TextUtils.isEmpty(asString)) {
                return;
            }
            ContactInfoItem contactInfoItemL = bo0.r().l(asString);
            if (contactInfoItemL != null && !contactInfoItemL.getIsStranger()) {
                Intent intent = new Intent();
                intent.setClass(this.b, ChatterActivity.class);
                intent.putExtra("chat_item", contactInfoItemL);
                k86.X(intent);
                this.b.startActivity(intent);
                return;
            }
            try {
                if (new f7(null, null).o(new ContactRequestArgs.Builder().e(new Pair<>(asString, asString2)).i(String.valueOf(0)).j(String.valueOf(0)).a()) != null) {
                    iq5.j(true, new String[0]);
                    Thread.sleep(600L);
                }
                if (TextUtils.isEmpty(asString)) {
                    return;
                }
                ContactInfoItem contactInfoItemL2 = bo0.r().l(asString);
                if (contactInfoItemL2 == null || contactInfoItemL2.getIsStranger()) {
                    sy5.h(this.b, "未能成功接入客服，请稍后再试", 1);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.setClass(this.b, ChatterActivity.class);
                intent2.putExtra("chat_item", contactInfoItemL2);
                k86.X(intent2);
                this.b.startActivity(intent2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21417a;
        public final /* synthetic */ String b;

        public d(Activity activity, String str) {
            this.f21417a = activity;
            this.b = str;
            put(DeviceInfoUtil.UID_TAG, v4.e(activity));
            put("chatuid", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21418a;
        public final /* synthetic */ String b;
        public final /* synthetic */ NoticeBarStyle c;

        public e(String str, String str2, NoticeBarStyle noticeBarStyle) {
            NoticeBarExt noticeBarExt;
            this.f21418a = str;
            this.b = str2;
            this.c = noticeBarStyle;
            put("wid", str);
            put("wineFeedId", str2);
            if (noticeBarStyle != null) {
                put("mid", noticeBarStyle.mid);
            }
            if (noticeBarStyle == null || (noticeBarExt = noticeBarStyle.ext) == null) {
                return;
            }
            put("scene_from", noticeBarExt.sceneFrom);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoticeBarStyle f21419a;

        public f(NoticeBarStyle noticeBarStyle) {
            this.f21419a = noticeBarStyle;
            put("from", "friend");
            put("mid", noticeBarStyle.mid);
            NoticeBarExt noticeBarExt = noticeBarStyle.ext;
            if (noticeBarExt != null) {
                put("fromUid", noticeBarExt.fromUid);
                put("sourceType", noticeBarStyle.ext.sourceType);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements ei5<BaseNetBean<SquareFeed>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeed f21420a;
        public final /* synthetic */ FrameworkBaseActivity b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Context d;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean<SquareFeed>> {
            public a() {
            }
        }

        public g(SquareFeed squareFeed, FrameworkBaseActivity frameworkBaseActivity, int i, Context context) {
            this.f21420a = squareFeed;
            this.b = frameworkBaseActivity;
            this.c = i;
            this.d = context;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("feedId", Long.valueOf(this.f21420a.id));
            map.put("feedExid", this.f21420a.exid);
            LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(86400000L);
            if (locationExI != null) {
                map.put("cityCode", locationExI.getCityCode());
                map.put("longitude", locationExI.getLongitude() + "");
                map.put("latitude", locationExI.getLatitude() + "");
            }
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean<SquareFeed> handle(JSONObject jSONObject) {
            BaseNetBean<SquareFeed> baseNetBeanCreateDefault = BaseNetBean.createDefault(jSONObject, new a().getType());
            if (baseNetBeanCreateDefault.isSuccess()) {
                ContactInfoItem contactInfoItemB = !TextUtils.isEmpty(this.f21420a.exid) ? dn0.b(this.f21420a.exid) : null;
                String nameForShow = contactInfoItemB != null ? contactInfoItemB.getNameForShow() : null;
                if (!TextUtils.isEmpty(nameForShow)) {
                    baseNetBeanCreateDefault.data.nickname = nameForShow;
                }
            }
            return baseNetBeanCreateDefault;
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean<SquareFeed> baseNetBean) {
            SquareFeed squareFeed;
            FrameworkBaseActivity frameworkBaseActivity = this.b;
            if (frameworkBaseActivity != null) {
                frameworkBaseActivity.hideSimpleProgressBar();
            }
            if (baseNetBean.isSuccess() && (squareFeed = baseNetBean.data) != null) {
                MediaViewActivity.B1(this.c, this.d, squareFeed, false);
                return;
            }
            FrameworkBaseActivity frameworkBaseActivity2 = this.b;
            if (frameworkBaseActivity2 == null || frameworkBaseActivity2.isFinishing() || this.b.isDestroyed() || TextUtils.isEmpty(baseNetBean.getErrMsg())) {
                return;
            }
            ry5.a(baseNetBean.getErrMsg());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements a.InterfaceC1055a {
        @Override // com.zenmen.palmchat.giftkit.a.InterfaceC1055a
        public void a(boolean z) {
            ve.b = false;
            com.zenmen.palmchat.giftkit.b.j().q();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f21422a;

        public i(ChatItem chatItem) {
            this.f21422a = chatItem;
            put("roomId", chatItem.getChatId());
        }
    }

    public static void A(Activity activity, String str, String str2, Boolean bool, String str3, boolean z, ChatItem chatItem) {
        B(activity, str, str2, bool, str3, z, chatItem, Boolean.FALSE);
    }

    public static void B(Activity activity, String str, String str2, Boolean bool, String str3, boolean z, ChatItem chatItem, Boolean bool2) {
        Serializable serializableValueOf = null;
        if (TextUtils.isEmpty(str)) {
            v(null);
            return;
        }
        String strD = rp3.f().d(activity, str);
        if (!il5.l(str) && "task".equals(str) && vi6.c().b() != null && (vi6.c().b() instanceof WebModuleActivity) && !vi6.c().b().isFinishing()) {
            ((WebModuleActivity) vi6.c().b()).finish();
        }
        if (z && "group-redpack".equals(str) && chatItem != null) {
            LogUtil.uploadInfoImmediate("qhb805", new i(chatItem));
        }
        if (bool != null && bool.booleanValue()) {
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            Intent intent = new Intent(activity, (Class<?>) TransparentLyWebActivity.class);
            intent.putExtra("web_url", strD);
            intent.putExtra("extra_url_extension", str2);
            intent.putExtra("app_id", str);
            intent.putExtra("extra_hide_menu", true);
            activity.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(activity, (Class<?>) WebModuleActivity.class);
        Package r0 = new Package();
        r0.pkgId = str;
        r0.version = 0;
        intent2.putExtra("extra_package", r0);
        intent2.putExtra("extra_type", 3);
        intent2.putExtra("extra_url_extension", str2);
        intent2.putExtra("app_id", str);
        intent2.putExtra("extra_hide_menu", true);
        intent2.putExtra("extra_use_light_status_bar", bool2 != null ? bool2.booleanValue() : false);
        if (!TextUtils.isEmpty(str3)) {
            try {
                serializableValueOf = Integer.valueOf(Color.parseColor(str3));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (serializableValueOf != null) {
            intent2.putExtra("extra_status_bar_color", serializableValueOf);
        } else {
            intent2.putExtra("extra_status_bar_color", activity.getResources().getColor(R.color.status_bar_color));
        }
        activity.startActivity(intent2);
    }

    public static Bundle C(ContentValues contentValues) {
        Bundle bundle = new Bundle();
        if (contentValues == null) {
            return bundle;
        }
        for (String str : contentValues.keySet()) {
            bundle.putString(str, contentValues.getAsString(str));
        }
        return bundle;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean D(Activity activity, ContentValues contentValues, ChatItem chatItem) {
        boolean zBooleanValue;
        String asString;
        String asString2;
        String asString3;
        NoticeBarStyle noticeBarStyle;
        String asString4;
        Object obj;
        String strC;
        NoticeBarExt noticeBarExt;
        Pair<Integer, ContentValues> pairG;
        Object obj2;
        String asString5 = contentValues.getAsString("page");
        Boolean asBoolean = contentValues.getAsBoolean("fromThirdPush");
        zBooleanValue = asBoolean == null ? false : asBoolean.booleanValue();
        asString5.hashCode();
        switch (asString5) {
            case "a0085":
                try {
                    asString = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
                    asString2 = contentValues.getAsString("wid");
                    asString3 = contentValues.getAsString("noticeBar");
                    noticeBarStyle = !TextUtils.isEmpty(asString3) ? (NoticeBarStyle) az2.a(asString3, NoticeBarStyle.class) : null;
                    asString4 = contentValues.getAsString("wineFeedId");
                    LogUtil.d("AppBuildInSchemeManager", "from: " + asString + " " + asString2 + " " + asString4);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (!"88888003".equals(asString)) {
                    if (!dd6.c() || !"88888027".equals(asString) || TextUtils.isEmpty(asString2) || TextUtils.isEmpty(asString4)) {
                        if (!a65.f(asString) || noticeBarStyle == null || noticeBarStyle.openType != 1 || !d(noticeBarStyle.url)) {
                            return d73.a(activity, asString);
                        }
                        Pair<Integer, ContentValues> pairG2 = mb4.g(noticeBarStyle.url);
                        if (pairG2 != null && (obj = pairG2.second) != null) {
                            ((ContentValues) obj).put("fromThirdPush", Boolean.valueOf(zBooleanValue));
                            ((ContentValues) pairG2.second).put("fromLoginRouter", Boolean.TRUE);
                            if (chatItem != null && !TextUtils.isEmpty(chatItem.getChatId())) {
                                ((ContentValues) pairG2.second).put("fromChatId", chatItem.getChatId());
                            }
                            return r(activity, pairG2, noticeBarStyle.url);
                        }
                    } else if (af6.c()) {
                        b65.c();
                    } else {
                        NoticeBarStyle fromString = NoticeBarStyle.parseFromString(asString3);
                        if (fromString == null || (noticeBarExt = fromString.ext) == null) {
                            strC = null;
                        } else {
                            if (TextUtils.isEmpty(noticeBarExt.pushId)) {
                                fromString.ext.pushId = fromString.mid;
                            }
                            strC = az2.c(fromString.ext);
                        }
                        LogUtil.uploadInfoImmediate("msj-cli-sp", new e(asString2, asString4, fromString));
                        SmallVideoEntranceController.l(activity, asString4, EnterScene.PUSH, strC);
                    }
                    return false;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, true);
                n5.f(activity, bundle);
                return true;
            case "a0086":
                String asString6 = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
                if (!"88888003".equals(asString6)) {
                    String asString7 = contentValues.getAsString("noticeBar");
                    Log.e(VideoSDKPushReceiver.TAG, "push noticebarExt=" + asString7);
                    NoticeBarStyle fromString2 = NoticeBarStyle.parseFromString(asString7);
                    if (fromString2 == null) {
                        return false;
                    }
                    if (d73.c(activity, fromString2.url)) {
                        try {
                            xa3.c("click", fromString2.ext.appId, fromString2.requestId, zBooleanValue ? "vendor" : "self");
                        } catch (Exception e3) {
                            ma3.c(e3);
                        }
                    } else {
                        int i2 = fromString2.type;
                        if (i2 != 124) {
                            if (i2 == 10) {
                                LogUtil.uploadInfoImmediate("009", new f(fromString2));
                                return false;
                            }
                            if ((!MediationConstant.RIT_TYPE_FEED.equals(asString6) && fromString2.openType != 1) || (pairG = mb4.g(fromString2.url)) == null || (obj2 = pairG.second) == null) {
                                return false;
                            }
                            ((ContentValues) obj2).put("fromThirdPush", Boolean.valueOf(zBooleanValue));
                            ((ContentValues) pairG.second).put("fromLoginRouter", Boolean.TRUE);
                            if (chatItem != null && !TextUtils.isEmpty(chatItem.getChatId())) {
                                ((ContentValues) pairG.second).put("fromChatId", chatItem.getChatId());
                            }
                            return r(activity, pairG, fromString2.url);
                        }
                        if (af6.c()) {
                            b65.c();
                            return false;
                        }
                        SmallVideoEntranceController.m(activity, fromString2);
                    }
                    break;
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, true);
                    n5.f(activity, bundle2);
                }
                return true;
            case "a0087":
                EnhanceRecommendActivity.J1(activity);
                return true;
            case "a0088":
                fu5.z(contentValues.getAsString(DeviceInfoUtil.UID_TAG), 60, true, new String[0]);
                return true;
            case "a0089":
                fu5.z(contentValues.getAsString(DeviceInfoUtil.UID_TAG), 61, true, new String[0]);
                return true;
            case "a0090":
                String asString8 = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
                if (!d73.a(activity, asString8)) {
                    fu5.y(asString8, 44, 64, true);
                }
                return true;
            case "a0091":
                String asString9 = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
                if (!d73.a(activity, asString9)) {
                    fu5.y(asString9, 46, 65, true);
                }
                return true;
            default:
                return true;
        }
    }

    public static boolean d(String str) {
        Pair<Integer, ContentValues> pairG = mb4.g(str);
        if (pairG == null) {
            return false;
        }
        int iIntValue = ((Integer) pairG.first).intValue();
        ContentValues contentValues = (ContentValues) pairG.second;
        if (iIntValue == 3) {
            String asString = contentValues.getAsString("page");
            if (asString == null || !f21413a.contains(asString)) {
                return false;
            }
        } else if (iIntValue != -1 && iIntValue != 10) {
            return false;
        }
        return true;
    }

    public static void e(Context context) {
        Intent intent = new Intent(context, (Class<?>) CertGuideActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void f(Context context, ContentValues contentValues) {
        String asString = contentValues.getAsString("page");
        SquareFeed squareFeed = new SquareFeed();
        squareFeed.id = contentValues.getAsLong("feedId").longValue();
        squareFeed.uid = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
        Integer asInteger = contentValues.getAsInteger("feedType");
        squareFeed.feedType = 2;
        if (asInteger != null && asInteger.intValue() != 0) {
            squareFeed.feedType = asInteger.intValue();
        } else if ("a0412".equals(asString)) {
            squareFeed.feedType = 1;
        }
        squareFeed.exid = contentValues.getAsString(bd.h);
        Integer asInteger2 = contentValues.getAsInteger("from");
        int iIntValue = (asInteger2 == null || asInteger2.intValue() == 0) ? 43 : asInteger2.intValue();
        if (squareFeed.feedType == 2 && iIntValue == 8) {
            FrameworkBaseActivity frameworkBaseActivity = (FrameworkBaseActivity) context;
            if (frameworkBaseActivity != null) {
                frameworkBaseActivity.showSimpleProgressBar();
            }
            bi5.p("square.feed.get.v9", new g(squareFeed, frameworkBaseActivity, iIntValue, context));
            return;
        }
        String asString2 = contentValues.getAsString(FrameworkBaseActivity.PARAMS_INTENT_FINISH_FORWARD_URL);
        ArrayList arrayList = new ArrayList();
        arrayList.add(squareFeed);
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(asString2)) {
            try {
                asString2 = URLDecoder.decode(asString2, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            bundle.putString(FrameworkBaseActivity.PARAMS_INTENT_FINISH_FORWARD_URL, asString2);
        }
        MediaViewActivity.C1(iIntValue, arrayList, context, bundle);
    }

    public static void g(Context context, String str) {
        fk2.a aVar = new fk2.a();
        Bundle bundle = new Bundle();
        bundle.putString("main_tab", "tab_square");
        bundle.putString("square_tab", str);
        bundle.putInt("from", 43);
        aVar.b(bundle);
        context.startActivity(n5.b(context, aVar));
    }

    public static void h(Context context, String str, boolean z, int i2, Integer num) {
        int iIntValue;
        fk2.a aVar = new fk2.a();
        Bundle bundle = new Bundle();
        bundle.putString("main_tab", "tab_find_friend");
        if (TextUtils.isEmpty(str)) {
            str = (z && dw1.l()) ? "mapfinder" : "nearbyrecommend";
            iIntValue = num == null ? 43 : num.intValue();
        } else {
            iIntValue = 81;
        }
        bundle.putString("find_friend_tab", str);
        bundle.putBoolean("find_friend_open_map", z);
        bundle.putInt("from", iIntValue);
        bundle.putInt("find_friend_popType_map", i2);
        aVar.b(bundle);
        context.startActivity(n5.b(context, aVar));
    }

    public static boolean i() {
        return a46.o() && a46.q();
    }

    public static void j(Activity activity, ContentValues contentValues) {
        String asString = contentValues.getAsString(bd.h);
        String asString2 = contentValues.getAsString("domain");
        Integer asInteger = contentValues.getAsInteger("bizType");
        ap3.n(activity, asString, (TextUtils.isEmpty(asString2) || asInteger == null) ? 5000 : DomainHelper.h(asString2, asInteger.intValue()), contentValues.getAsString("msg"));
    }

    public static boolean k(Activity activity, RichMsgExItemVo richMsgExItemVo, ContentValues contentValues, String str, ChatItem chatItem) {
        return l(activity, richMsgExItemVo, contentValues, str, chatItem, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean l(final Activity activity, RichMsgExItemVo richMsgExItemVo, final ContentValues contentValues, String str, ChatItem chatItem, String str2) {
        byte b2;
        Intent intent;
        Object obj;
        LogUtil.i("AppBuildInSchemeManager", "jumpActivity " + contentValues);
        String asString = contentValues.getAsString("page");
        Boolean asBoolean = contentValues.getAsBoolean("fromThirdPush");
        boolean zBooleanValue = asBoolean == null ? false : asBoolean.booleanValue();
        Boolean asBoolean2 = contentValues.getAsBoolean("fromLoginRouter");
        boolean zBooleanValue2 = asBoolean2 == null ? false : asBoolean2.booleanValue();
        if (asString == null) {
            return false;
        }
        switch (asString.hashCode()) {
            case -1472132978:
                b2 = asString.equals("a00010") ? (byte) 0 : (byte) -1;
                break;
            case -1472130064:
                if (asString.equals("a00320")) {
                    b2 = 1;
                    break;
                }
                break;
            case -1472129009:
                if (asString.equals("a00451")) {
                    b2 = 2;
                    break;
                }
                break;
            case -1471209234:
                if (asString.equals("a10086")) {
                    b2 = 3;
                    break;
                }
                break;
            case -1471209233:
                if (asString.equals("a10087")) {
                    b2 = 4;
                    break;
                }
                break;
            case 2938352:
                if (asString.equals("a100")) {
                    b2 = 5;
                    break;
                }
                break;
            case 91059169:
                if (asString.equals("a0000")) {
                    b2 = 6;
                    break;
                }
                break;
            case 91059170:
                if (asString.equals("a0001")) {
                    b2 = 7;
                    break;
                }
                break;
            case 91059171:
                if (asString.equals("a0002")) {
                    b2 = 8;
                    break;
                }
                break;
            case 91059172:
                if (asString.equals("a0003")) {
                    b2 = 9;
                    break;
                }
                break;
            case 91059173:
                if (asString.equals("a0004")) {
                    b2 = 10;
                    break;
                }
                break;
            case 91059174:
                if (asString.equals("a0005")) {
                    b2 = 11;
                    break;
                }
                break;
            case 91059177:
                if (asString.equals("a0008")) {
                    b2 = 12;
                    break;
                }
                break;
            case 91059200:
                if (asString.equals("a0010")) {
                    b2 = dn.k;
                    break;
                }
                break;
            case 91059201:
                if (asString.equals("a0011")) {
                    b2 = dn.l;
                    break;
                }
                break;
            case 91059202:
                if (asString.equals("a0012")) {
                    b2 = 15;
                    break;
                }
                break;
            case 91059203:
                if (asString.equals("a0013")) {
                    b2 = 16;
                    break;
                }
                break;
            case 91059293:
                if (asString.equals("a0040")) {
                    b2 = 17;
                    break;
                }
                break;
            case 91059294:
                if (asString.equals("a0041")) {
                    b2 = 18;
                    break;
                }
                break;
            case 91059295:
                if (asString.equals("a0042")) {
                    b2 = 19;
                    break;
                }
                break;
            case 91059296:
                if (asString.equals("a0043")) {
                    b2 = 20;
                    break;
                }
                break;
            case 91059298:
                if (asString.equals("a0045")) {
                    b2 = 21;
                    break;
                }
                break;
            case 91059299:
                if (asString.equals("a0046")) {
                    b2 = 22;
                    break;
                }
                break;
            case 91059324:
                if (asString.equals("a0050")) {
                    b2 = 23;
                    break;
                }
                break;
            case 91059325:
                if (asString.equals("a0051")) {
                    b2 = 24;
                    break;
                }
                break;
            case 91059326:
                if (asString.equals("a0052")) {
                    b2 = 25;
                    break;
                }
                break;
            case 91059356:
                if (asString.equals("a0061")) {
                    b2 = 26;
                    break;
                }
                break;
            case 91059357:
                if (asString.equals("a0062")) {
                    b2 = 27;
                    break;
                }
                break;
            case 91059358:
                if (asString.equals("a0063")) {
                    b2 = 28;
                    break;
                }
                break;
            case 91059359:
                if (asString.equals("a0064")) {
                    b2 = 29;
                    break;
                }
                break;
            case 91059360:
                if (asString.equals("a0065")) {
                    b2 = 30;
                    break;
                }
                break;
            case 91059361:
                if (asString.equals("a0066")) {
                    b2 = TELogUtils.DEBUG_LEVEL_V;
                    break;
                }
                break;
            case 91059420:
                if (asString.equals("a0083")) {
                    b2 = 32;
                    break;
                }
                break;
            case 91059422:
                if (asString.equals("a0085")) {
                    b2 = 33;
                    break;
                }
                break;
            case 91059423:
                if (asString.equals("a0086")) {
                    b2 = 34;
                    break;
                }
                break;
            case 91059424:
                if (asString.equals("a0087")) {
                    b2 = 35;
                    break;
                }
                break;
            case 91059425:
                if (asString.equals("a0088")) {
                    b2 = 36;
                    break;
                }
                break;
            case 91059426:
                if (asString.equals("a0089")) {
                    b2 = 37;
                    break;
                }
                break;
            case 91059448:
                if (asString.equals("a0090")) {
                    b2 = 38;
                    break;
                }
                break;
            case 91059450:
                if (asString.equals("a0092")) {
                    b2 = 39;
                    break;
                }
                break;
            case 91060130:
                if (asString.equals("a0100")) {
                    b2 = 40;
                    break;
                }
                break;
            case 91060131:
                if (asString.equals("a0101")) {
                    b2 = 41;
                    break;
                }
                break;
            case 91060132:
                if (asString.equals("a0102")) {
                    b2 = 42;
                    break;
                }
                break;
            case 91060133:
                if (asString.equals("a0103")) {
                    b2 = 43;
                    break;
                }
                break;
            case 91060134:
                if (asString.equals("a0104")) {
                    b2 = 44;
                    break;
                }
                break;
            case 91060135:
                if (asString.equals("a0105")) {
                    b2 = 45;
                    break;
                }
                break;
            case 91061092:
                if (asString.equals("a0201")) {
                    b2 = 46;
                    break;
                }
                break;
            case 91061093:
                if (asString.equals("a0202")) {
                    b2 = 47;
                    break;
                }
                break;
            case 91061094:
                if (asString.equals("a0203")) {
                    b2 = 48;
                    break;
                }
                break;
            case 91061095:
                if (asString.equals("a0204")) {
                    b2 = 49;
                    break;
                }
                break;
            case 91061096:
                if (asString.equals("a0205")) {
                    b2 = 50;
                    break;
                }
                break;
            case 91061097:
                if (asString.equals("a0206")) {
                    b2 = 51;
                    break;
                }
                break;
            case 91061098:
                if (asString.equals("a0207")) {
                    b2 = 52;
                    break;
                }
                break;
            case 91061099:
                if (asString.equals("a0208")) {
                    b2 = 53;
                    break;
                }
                break;
            case 91061123:
                if (asString.equals("a0211")) {
                    b2 = 54;
                    break;
                }
                break;
            case 91062053:
                if (asString.equals("a0301")) {
                    b2 = 55;
                    break;
                }
                break;
            case 91062054:
                if (asString.equals("a0302")) {
                    b2 = 56;
                    break;
                }
                break;
            case 91062055:
                if (asString.equals("a0303")) {
                    b2 = 57;
                    break;
                }
                break;
            case 91062056:
                if (asString.equals("a0304")) {
                    b2 = 58;
                    break;
                }
                break;
            case 91062057:
                if (asString.equals("a0305")) {
                    b2 = 59;
                    break;
                }
                break;
            case 91062058:
                if (asString.equals("a0306")) {
                    b2 = 60;
                    break;
                }
                break;
            case 91062060:
                if (asString.equals("a0308")) {
                    b2 = Base64.padSymbol;
                    break;
                }
                break;
            case 91063014:
                if (asString.equals("a0401")) {
                    b2 = 62;
                    break;
                }
                break;
            case 91063015:
                if (asString.equals("a0402")) {
                    b2 = Utf8.REPLACEMENT_BYTE;
                    break;
                }
                break;
            case 91063017:
                if (asString.equals("a0404")) {
                    b2 = 64;
                    break;
                }
                break;
            case 91063018:
                if (asString.equals("a0405")) {
                    b2 = 65;
                    break;
                }
                break;
            case 91063019:
                if (asString.equals("a0406")) {
                    b2 = 66;
                    break;
                }
                break;
            case 91063020:
                if (asString.equals("a0407")) {
                    b2 = 67;
                    break;
                }
                break;
            case 91063021:
                if (asString.equals("a0408")) {
                    b2 = 68;
                    break;
                }
                break;
            case 91063022:
                if (asString.equals("a0409")) {
                    b2 = 69;
                    break;
                }
                break;
            case 91063044:
                if (asString.equals("a0410")) {
                    b2 = 70;
                    break;
                }
                break;
            case 91063046:
                if (asString.equals("a0412")) {
                    b2 = 71;
                    break;
                }
                break;
            case 91063047:
                if (asString.equals("a0413")) {
                    b2 = 72;
                    break;
                }
                break;
            case 91063048:
                if (asString.equals("a0414")) {
                    b2 = 73;
                    break;
                }
                break;
            case 91063168:
                if (asString.equals("a0450")) {
                    b2 = 74;
                    break;
                }
                break;
            case 91063169:
                if (asString.equals("a0451")) {
                    b2 = 75;
                    break;
                }
                break;
            case 91063170:
                if (asString.equals("a0452")) {
                    b2 = 76;
                    break;
                }
                break;
            case 91063199:
                if (asString.equals("a0460")) {
                    b2 = 77;
                    break;
                }
                break;
            case 91063200:
                if (asString.equals("a0461")) {
                    b2 = 78;
                    break;
                }
                break;
            case 91063201:
                if (asString.equals("a0462")) {
                    b2 = 79;
                    break;
                }
                break;
            case 91063974:
                if (asString.equals("a0500")) {
                    b2 = 80;
                    break;
                }
                break;
            case 91064005:
                if (asString.equals("a0510")) {
                    b2 = 81;
                    break;
                }
                break;
            case 91064006:
                if (asString.equals("a0511")) {
                    b2 = 82;
                    break;
                }
                break;
            case 91064007:
                if (asString.equals("a0512")) {
                    b2 = 83;
                    break;
                }
                break;
            case 91064008:
                if (asString.equals("a0513")) {
                    b2 = 84;
                    break;
                }
                break;
            case 91064009:
                if (asString.equals("a0514")) {
                    b2 = 85;
                    break;
                }
                break;
            case 91064010:
                if (asString.equals("a0515")) {
                    b2 = 86;
                    break;
                }
                break;
            case 91064011:
                if (asString.equals("a0516")) {
                    b2 = 87;
                    break;
                }
                break;
            case 91064036:
                if (asString.equals("a0520")) {
                    b2 = 88;
                    break;
                }
                break;
            case 91064037:
                if (asString.equals("a0521")) {
                    b2 = 89;
                    break;
                }
                break;
            case 91064161:
                if (asString.equals("a0561")) {
                    b2 = 90;
                    break;
                }
                break;
            case 91064997:
                if (asString.equals("a0620")) {
                    b2 = 91;
                    break;
                }
                break;
            case 91064998:
                if (asString.equals("a0621")) {
                    b2 = 92;
                    break;
                }
                break;
            case 91064999:
                if (asString.equals("a0622")) {
                    b2 = 93;
                    break;
                }
                break;
            case 91065000:
                if (asString.equals("a0623")) {
                    b2 = 94;
                    break;
                }
                break;
            case 91065001:
                if (asString.equals("a0624")) {
                    b2 = 95;
                    break;
                }
                break;
            case 91065005:
                if (asString.equals("a0628")) {
                    b2 = 96;
                    break;
                }
                break;
            case 91065006:
                if (asString.equals("a0629")) {
                    b2 = 97;
                    break;
                }
                break;
            case 91065028:
                if (asString.equals("a0630")) {
                    b2 = 98;
                    break;
                }
                break;
            case 91065029:
                if (asString.equals("a0631")) {
                    b2 = 99;
                    break;
                }
                break;
            case 91065059:
                if (asString.equals("a0640")) {
                    b2 = 100;
                    break;
                }
                break;
            case 91065060:
                if (asString.equals("a0641")) {
                    b2 = 101;
                    break;
                }
                break;
            case 91065061:
                if (asString.equals("a0642")) {
                    b2 = 102;
                    break;
                }
                break;
        }
        boolean z = zBooleanValue;
        switch (b2) {
            case 0:
                boolean z2 = false;
                String asString2 = contentValues.getAsString("url");
                if (!TextUtils.isEmpty(asString2)) {
                    String asString3 = contentValues.getAsString("fullwindow");
                    String asString4 = contentValues.getAsString("cacheKey");
                    if (!TextUtils.isEmpty(asString4) && !TextUtils.isEmpty(str2)) {
                        SPUtil.f14322a.t(SPUtil.SCENE.JSAPI, asString4 + v4.e(AppContext.getContext()), str2);
                    }
                    Boolean asBoolean3 = contentValues.getAsBoolean("statusBarLight");
                    boolean zEquals = "1".equals(asString3);
                    if (asBoolean3 != null && asBoolean3.booleanValue()) {
                        z2 = true;
                    }
                    Intent intentA = tj6.a(activity, asString2, zEquals, z2);
                    intentA.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, zBooleanValue2);
                    activity.startActivity(intentA);
                }
                break;
            case 1:
                Intent intentA2 = on0.a(zBooleanValue2 ? "upload_contact_from_push" : "upload_contact_from_newcontact");
                intentA2.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, zBooleanValue2);
                activity.startActivity(intentA2);
                break;
            case 2:
            case 11:
            case 12:
            case 13:
            case 17:
            case 18:
            case 19:
            case 28:
            case 85:
            case 93:
                break;
            case 3:
                xg5.e().n(activity);
                break;
            case 4:
                com.zenmen.palmchat.miniwidget.a.f().a(activity, contentValues.getAsInteger("widgetType").intValue(), false);
                break;
            case 5:
                String asString5 = contentValues.getAsString("scheme");
                if (asString5 != null) {
                    if (zBooleanValue2) {
                        try {
                            activity.startActivity(new Intent(activity, (Class<?>) MainTabsActivity.class));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return true;
                        }
                    }
                    String strDecode = Uri.decode(asString5);
                    if (strDecode.startsWith("intent:")) {
                        try {
                            intent = Intent.getIntent(strDecode);
                        } catch (URISyntaxException e3) {
                            e3.printStackTrace();
                            intent = null;
                        }
                    } else {
                        intent = null;
                    }
                    if (intent == null) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse(asString5));
                    }
                    activity.startActivity(intent);
                }
                break;
            case 6:
                Intent intent2 = new Intent(activity, (Class<?>) MainTabsActivity.class);
                intent2.putExtra("new_intent_position", "tab_msg");
                k86.Y(intent2);
                activity.startActivity(intent2);
                break;
            case 7:
                if (TeenagersModeManager.a().d()) {
                    b65.c();
                } else {
                    Intent intentC = st2.c();
                    intentC.putExtra("fromType", zBooleanValue2 ? 8 : 7);
                    intentC.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, zBooleanValue2);
                    activity.startActivity(intentC);
                }
                break;
            case 8:
                String asString6 = contentValues.getAsString(az.at);
                Integer asInteger = contentValues.getAsInteger("from");
                Intent intent3 = new Intent(activity, (Class<?>) PersonalInfoActivity.class);
                if (asInteger != null) {
                    intent3.putExtra("extra_from", asInteger.intValue());
                }
                intent3.putExtra("extra_source", asString6);
                intent3.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, zBooleanValue2);
                activity.startActivity(intent3);
                break;
            case 9:
                UpdateManager.G().Z();
                break;
            case 10:
                if (nx3.a("key_new_feedback")) {
                    nx3.e("key_new_feedback");
                }
                Intent intent4 = new Intent();
                intent4.setClass(activity, CordovaWebActivity.class);
                Bundle bundle = new Bundle();
                intent4.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, zBooleanValue2);
                bundle.putString("web_url", AboutActivity.B);
                bundle.putBoolean("web_show_right_menu", false);
                bundle.putInt("BackgroundColor", -1);
                intent4.putExtras(bundle);
                activity.startActivity(intent4);
                break;
            case 14:
                LogUtil.uploadInfoImmediate("hgrz112", "1", null, null);
                if (activity instanceof FrameworkBaseActivity) {
                    ((FrameworkBaseActivity) activity).showBaseProgressBar();
                }
                com.zenmen.palmchat.settings.cert.a.a().b(new b(activity));
                break;
            case 15:
                LogUtil.uploadInfoImmediate("hgrz200", "1", "1", null);
                if (chatItem != null && (chatItem instanceof GroupInfoItem)) {
                    GroupInfoItem groupInfoItem = (GroupInfoItem) chatItem;
                    if (groupInfoItem.getGroupOwner().equals(AccountUtils.p(AppContext.getContext()))) {
                        Intent intent5 = new Intent();
                        intent5.setClass(activity, GroupCateSelectActivity.class);
                        intent5.putExtra("extra_groupid", groupInfoItem.getGroupId());
                        intent5.putExtra("extra_from", 2);
                        activity.startActivity(intent5);
                    }
                    break;
                }
                break;
            case 16:
                Intent intent6 = new Intent(AppContext.getContext(), (Class<?>) GroupChatInitActivity.class);
                intent6.putExtra("from_type", 3);
                activity.startActivity(intent6);
                break;
            case 20:
                Intent intent7 = new Intent();
                intent7.setClass(activity, CordovaWebActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("web_url", tj2.s());
                bundle2.putBoolean("web_show_right_menu", false);
                bundle2.putInt("BackgroundColor", -1);
                intent7.putExtras(bundle2);
                activity.startActivity(intent7);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(az.at, 2);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("H2", null, null, jSONObject.toString());
                break;
            case 21:
                String asString7 = contentValues.getAsString("url");
                if (asString7 == null || !(asString7.contains("wallet-h5/index2_new.html") || asString7.contains("wallet-h5/index2.html"))) {
                    nb3.i(activity, contentValues);
                } else {
                    nb3.j(activity);
                }
                break;
            case 22:
                if (chatItem != null) {
                    if (contentValues.containsKey("is1v1ConsumeReport") && contentValues.getAsBoolean("is1v1ConsumeReport").booleanValue()) {
                        CordovaWebActivity.v2(activity, 311, 0, chatItem, 999);
                    } else {
                        CordovaWebActivity.u2(activity, chatItem.getChatType() == 1, 311, chatItem, 999);
                    }
                }
                break;
            case 23:
            case 24:
                String asString8 = contentValues.getAsString("urlExtra");
                String asString9 = contentValues.getAsString("pkgId");
                if (TextUtils.isEmpty(asString9)) {
                    v(contentValues);
                } else {
                    z(activity, richMsgExItemVo, asString9, asString8);
                }
                break;
            case 25:
                y(activity, contentValues, true, chatItem);
                break;
            case 26:
                Intent intent8 = new Intent(activity, (Class<?>) m66.c());
                ContactInfoItem contactInfoItem = new ContactInfoItem();
                contactInfoItem.setUid(AccountUtils.p(activity));
                intent8.putExtra("user_item_info", contactInfoItem);
                intent8.putExtra("from", 5);
                activity.startActivity(intent8);
                break;
            case 27:
                SquareCircleActivity.A1(activity);
                break;
            case 29:
            case 30:
                if (activity instanceof ChatterActivity) {
                    ((ChatterActivity) activity).r4(contentValues);
                }
                break;
            case 31:
                int iIntValue = contentValues.getAsInteger("type").intValue();
                String asString10 = contentValues.getAsString(az.at);
                Intent intent9 = new Intent(activity, (Class<?>) PersonalInfoActivity.class);
                intent9.putExtra("extra_type", iIntValue);
                intent9.putExtra("extra_source", asString10);
                activity.startActivity(intent9);
                break;
            case 32:
                NoticeBarStyle fromString = NoticeBarStyle.parseFromString(contentValues.getAsString("noticeBar"));
                if (fromString == null || fromString.openType != 1) {
                    d73.b(activity);
                } else {
                    Pair<Integer, ContentValues> pairG = mb4.g(fromString.url);
                    if (pairG == null || (obj = pairG.second) == null) {
                        d73.b(activity);
                    } else {
                        ((ContentValues) obj).put("fromThirdPush", Boolean.valueOf(z));
                        ((ContentValues) pairG.second).put("fromLoginRouter", Boolean.valueOf(zBooleanValue2));
                        if (chatItem != null && !TextUtils.isEmpty(chatItem.getChatId())) {
                            ((ContentValues) pairG.second).put("fromChatId", chatItem.getChatId());
                        }
                    }
                }
                break;
            case 33:
                if (!zBooleanValue2) {
                    String asString11 = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
                    if (!TextUtils.isEmpty(asString11)) {
                        ContactInfoItem contactInfoItemL = bo0.r().l(asString11);
                        if (contactInfoItemL == null || contactInfoItemL.getIsStranger()) {
                            sy5.f(activity, activity.getString(R.string.chat_toast_add_friend), 1).g();
                        } else {
                            Intent intent10 = new Intent();
                            intent10.setClass(activity, ChatterActivity.class);
                            intent10.putExtra("chat_item", contactInfoItemL);
                            k86.X(intent10);
                            activity.startActivity(intent10);
                        }
                    }
                }
                break;
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
                break;
            case 39:
                String asString12 = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
                String asString13 = contentValues.getAsString("domain");
                Integer asInteger2 = contentValues.getAsInteger("showGift");
                Integer asInteger3 = contentValues.getAsInteger("showSendGift");
                Integer asInteger4 = contentValues.getAsInteger("from");
                String asString14 = contentValues.getAsString("roomId");
                Integer asInteger5 = contentValues.getAsInteger("joinChatmate");
                if (!TextUtils.isEmpty(asString12) && !TextUtils.isEmpty(asString13)) {
                    DomainHelper.Domains[] domainsArrValues = DomainHelper.Domains.values();
                    int length = domainsArrValues.length;
                    int i2 = 0;
                    while (i2 < length) {
                        int i3 = length;
                        DomainHelper.Domains domains = domainsArrValues[i2];
                        DomainHelper.Domains[] domainsArr = domainsArrValues;
                        if (domains.domain.equals(asString13) || domains.domain.contains(asString13)) {
                            ThreadChatItem threadChatItemF = nw5.f(asString12);
                            if (asInteger2 != null && asInteger2.intValue() == 1) {
                                InputFragment.b1 = true;
                            }
                            if (threadChatItemF == null || !threadChatItemF.isContactReady) {
                                int iIntValue2 = domains.bizType;
                                if (DomainHelper.Domains.DOMAIN_PRIVATE == domains && contentValues.containsKey("bizType")) {
                                    iIntValue2 = contentValues.getAsInteger("bizType").intValue() + 5000;
                                }
                                String[] strArr = {contentValues.getAsString(LxAdDLManager.ITEM_ICONURL), contentValues.getAsString("nickname")};
                                int i4 = 0;
                                for (int i5 = 2; i4 < i5; i5 = 2) {
                                    if (!TextUtils.isEmpty(strArr[i4])) {
                                        strArr[i4] = Uri.decode(strArr[i4]);
                                    }
                                    i4++;
                                }
                                try {
                                    JSONObject jSONObject2 = new JSONObject();
                                    if (asInteger3 != null) {
                                        jSONObject2.put("showSendGift", asInteger3.intValue());
                                    }
                                    if (asInteger4 != null) {
                                        jSONObject2.put("from", asInteger4.intValue());
                                    }
                                    if (asInteger5 != null) {
                                        jSONObject2.put("joinChatmate", asInteger5.intValue());
                                    }
                                    if (asString14 != null) {
                                        jSONObject2.put("roommateId", asString14);
                                    }
                                    strArr[2] = jSONObject2.toString();
                                    break;
                                } catch (Exception unused) {
                                }
                                fu5.z(asString12, iIntValue2, zBooleanValue2, strArr);
                            } else {
                                ChatItem chatItemConvert2ContactOrGroupChatInfo = threadChatItemF.convert2ContactOrGroupChatInfo();
                                Intent intent11 = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
                                if (chatItemConvert2ContactOrGroupChatInfo instanceof ContactInfoItem) {
                                    intent11.setExtrasClassLoader(ContactInfoItem.class.getClassLoader());
                                } else if (chatItemConvert2ContactOrGroupChatInfo instanceof GroupInfoItem) {
                                    intent11.setExtrasClassLoader(GroupInfoItem.class.getClassLoader());
                                }
                                intent11.putExtra("chat_item", chatItemConvert2ContactOrGroupChatInfo);
                                intent11.putExtra("thread_biz_type", chatItemConvert2ContactOrGroupChatInfo.getBizType());
                                intent11.putExtra("chat_back_to_greet", false);
                                intent11.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, zBooleanValue2);
                                if (asInteger3 != null && asInteger3.intValue() == 1) {
                                    intent11.putExtra("chat_mate_need_send_gift", 1);
                                }
                                if (asInteger4 != null) {
                                    intent11.putExtra("chat_mate_activity_from", asInteger4.intValue());
                                }
                                if (asInteger5 != null && asInteger5.intValue() == 1 && !TextUtils.isEmpty(asString14)) {
                                    o30.C(asString12, asString14, 1);
                                    o30.C(v4.e(AppContext.getContext()), asString14, 2);
                                }
                                k86.X(intent11);
                                activity.startActivity(intent11);
                            }
                        } else {
                            i2++;
                            domainsArrValues = domainsArr;
                            length = i3;
                        }
                        break;
                    }
                    break;
                }
                break;
            case 40:
                n86.d(activity);
                break;
            case 41:
                wg4.a(activity).e();
                break;
            case 42:
                v66.b().e();
                LogUtil.uploadInfoImmediate("801", "1", null, null);
                break;
            case 43:
            case 44:
                if (activity instanceof ChatterActivity) {
                    r75.p(AppContext.getContext(), k86.a("sp_has_used_videocall_guidence"), 3);
                    ((ChatterActivity) activity).v3().Q3();
                    ta6.a();
                    fg6.b("click", fg6.j(AppContext.getContext()) ? 1 : 0, fg6.d(AppContext.getContext()) ? 1 : 0, 4);
                }
                break;
            case 45:
                r75.p(AppContext.getContext(), k86.a("sp_has_used_videocall_guidence"), 3);
                ua6.d(activity);
                break;
            case 46:
                if (activity instanceof ChatterActivity) {
                    ((ChatterActivity) activity).q4(contentValues);
                }
                break;
            case 47:
                if (activity instanceof ChatterActivity) {
                    ((ChatterActivity) activity).s4(contentValues);
                }
                break;
            case 48:
                activity.startActivity(NewContactActivity.h.b(activity));
                break;
            case 49:
                String asString15 = contentValues.getAsString("groupid");
                Intent intent12 = new Intent();
                intent12.setClass(activity, CircleEditDetailActivity.class);
                intent12.putExtra(j70.f18338a, asString15);
                activity.startActivity(intent12);
                break;
            case 50:
                String asString16 = contentValues.getAsString("groupid");
                Intent intent13 = new Intent();
                intent13.setClass(activity, CircleNoteActivity.class);
                intent13.putExtra(j70.f18338a, asString16);
                activity.startActivity(intent13);
                break;
            case 51:
                String asString17 = contentValues.getAsString("groupid");
                Intent intent14 = new Intent();
                intent14.setClass(activity, CircleAssitantActivity.class);
                intent14.putExtra(j70.f18338a, asString17);
                activity.startActivity(intent14);
                break;
            case 52:
                String asString18 = contentValues.getAsString("groupid");
                Intent intent15 = new Intent();
                intent15.setClass(activity, CircleAuthActivity.class);
                intent15.putExtra(j70.f18338a, asString18);
                activity.startActivity(intent15);
                break;
            case 53:
                String asString19 = contentValues.getAsString("rid");
                long jIntValue = contentValues.getAsInteger("noticeId").intValue();
                Intent intent16 = new Intent();
                intent16.setClass(activity, CircleNoteDetailActivity.class);
                intent16.putExtra(j70.f18338a, asString19);
                intent16.putExtra(j70.g, jIntValue);
                activity.startActivity(intent16);
                break;
            case 54:
                if (zBooleanValue2) {
                    FrameworkBaseActivity.g.c(false);
                }
                String asString20 = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
                Integer asInteger6 = contentValues.getAsInteger("sourceType");
                Integer asInteger7 = contentValues.getAsInteger("canChat");
                String asString21 = contentValues.getAsString("rid");
                String asString22 = contentValues.getAsString("domain");
                Integer asInteger8 = contentValues.getAsInteger("bizType");
                int iH = (TextUtils.isEmpty(asString22) || asInteger8 == null) ? -1 : DomainHelper.h(asString22, asInteger8.intValue());
                int iIntValue3 = asInteger6 != null ? asInteger6.intValue() : -1;
                Intent intent17 = new Intent(activity, (Class<?>) m66.c());
                ContactInfoItem contactInfoItem2 = new ContactInfoItem();
                contactInfoItem2.setUid(asString20);
                contactInfoItem2.setSourceType(iIntValue3);
                if (iH > 0) {
                    contactInfoItem2.setBizType(iH);
                }
                if (TextUtils.isEmpty(asString21)) {
                    intent17.putExtra("from", zBooleanValue2 ? 36 : 5);
                } else {
                    intent17.putExtra("from", zBooleanValue2 ? 36 : 7);
                    intent17.putExtra("rid", asString21);
                }
                intent17.putExtra("user_item_info", contactInfoItem2);
                intent17.putExtra("extra_can_chat", asInteger7 != null && asInteger7.intValue() == 1);
                if (asInteger8 != null && asInteger8.intValue() == 5053) {
                    intent17.putExtra("extra_can_chat", false);
                }
                intent17.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, zBooleanValue2);
                if (iH > 0) {
                    intent17.putExtra("thread_biz_type", iH);
                }
                if (asInteger7 != null && asInteger7.intValue() == 1) {
                    intent17.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB_INEDX, "tab_find_friend");
                }
                intent17.addFlags(335544320);
                activity.startActivity(intent17);
                break;
            case 55:
                String asString23 = contentValues.getAsString("groupid");
                Intent intent18 = new Intent();
                intent18.setClass(activity, CircleChooseSearchFunActivity.class);
                intent18.putExtra("groupId", asString23);
                intent18.putExtra("fromtype", "1");
                activity.startActivity(intent18);
                break;
            case 56:
                String asString24 = contentValues.getAsString("groupid");
                Integer asInteger9 = contentValues.getAsInteger("groupsource");
                Intent intent19 = new Intent(activity, (Class<?>) CircleDetailActivity.class);
                intent19.putExtra(j70.f18338a, asString24);
                if (asInteger9 == null || asInteger9.intValue() == 0) {
                    asInteger9 = 9;
                }
                intent19.putExtra("key_apply_group_source", asInteger9);
                activity.startActivity(intent19);
                break;
            case 57:
                if (!(activity instanceof FrameworkBaseActivity)) {
                    ry5.a("暂不支持该功能");
                    break;
                } else {
                    String asString25 = contentValues.getAsString("couponId");
                    String asString26 = contentValues.getAsString(RedirectRespWrapper.KEY_VERCODE);
                    if (!TextUtils.isEmpty(asString25) && !TextUtils.isEmpty(asString26)) {
                        new h70((FrameworkBaseActivity) activity).h(asString25, asString26);
                        break;
                    }
                }
                break;
            case 58:
                c70.R().K(contentValues.getAsString("groupid"), new dv0() { // from class: te
                    @Override // defpackage.dv0
                    public final void onResponse(Object obj2) {
                        ve.m(contentValues, activity, (GroupInfoItem) obj2);
                    }
                });
                break;
            case 59:
                CircleFindActivity.R1(activity, contentValues.getAsInteger(az.at) == null ? -1 : contentValues.getAsInteger(az.at).intValue());
                break;
            case 60:
                c70.R().K(contentValues.getAsString("groupid"), new dv0() { // from class: ue
                    @Override // defpackage.dv0
                    public final void onResponse(Object obj2) {
                        ve.n(activity, (GroupInfoItem) obj2);
                    }
                });
                break;
            case 61:
                String asString27 = contentValues.getAsString("feedId");
                String asString28 = contentValues.getAsString("from");
                if (!TextUtils.isEmpty(asString27)) {
                    SmallVideoEntranceController.l(activity, asString27, EnterScene.fromScene(asString28), null);
                }
                break;
            case 62:
            case 63:
                Intent intent20 = new Intent(activity, (Class<?>) SquareMessageActivity.class);
                intent20.putExtra("key_page", asString);
                intent20.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, zBooleanValue2);
                activity.startActivity(intent20);
                break;
            case 64:
                g(activity, "recommendTitle");
                break;
            case 65:
                g(activity, "momentsTitle");
                break;
            case 66:
                Boolean asBoolean4 = contentValues.getAsBoolean("directEnter");
                Boolean asBoolean5 = contentValues.getAsBoolean("openMap");
                Integer asInteger10 = contentValues.getAsInteger("popType");
                String asString29 = contentValues.getAsString("subTabName");
                Integer asInteger11 = contentValues.getAsInteger("from");
                if (asBoolean4 == null || !asBoolean4.booleanValue() || asBoolean5 == null || !asBoolean5.booleanValue()) {
                    b05.d("directEnter==null||directEnter=false");
                    h(activity, asString29, asBoolean5 != null ? asBoolean5.booleanValue() : false, asInteger10 != null ? asInteger10.intValue() : 0, asInteger11);
                } else {
                    b05.d("directEnter!=null&&directEnter=true");
                    Integer num = 7;
                    if (i()) {
                        bj5.b().a().i(activity, ConditionHelper.getInstance().getDriftInfo().location, false, 0, asInteger10 != null ? asInteger10.intValue() : 0, false, num.intValue());
                    } else {
                        MCheckPermissionActivity.D1(activity, ConditionHelper.getInstance().getDriftInfo().location, false, false, 0, asInteger10 != null ? asInteger10.intValue() : 0, num.intValue());
                    }
                }
                break;
            case 67:
                NestTopicFeedsActivity.G1(activity, contentValues.getAsLong("topicId").longValue(), 43);
                break;
            case 68:
            case 71:
                f(activity, contentValues);
                break;
            case 69:
                int iIntValue4 = contentValues.getAsInteger("tagId").intValue();
                String asString30 = contentValues.getAsString(bd.h);
                SquareTagBean squareTagBean = new SquareTagBean();
                squareTagBean.setName("");
                squareTagBean.setId(iIntValue4);
                ContactInfoItem contactInfoItem3 = new ContactInfoItem();
                contactInfoItem3.setExid(asString30);
                NestTagFeedsActivity.L1(activity, contactInfoItem3, squareTagBean, 43);
                break;
            case 70:
                bj5.b().a().c0(activity, 43, null, null, null, true);
                break;
            case 72:
                g(activity, "nearbyFeedTitle");
                break;
            case 73:
                g(activity, "friendFeedTitle");
                break;
            case 74:
                x20.e(activity, chatItem);
                break;
            case 75:
                x20.f(activity, chatItem);
                break;
            case 76:
                x20.g(activity, chatItem);
                break;
            case 77:
                ez2.a("服务已关闭");
                break;
            case 78:
                ez2.a("服务已关闭");
                break;
            case 79:
                ez2.a("服务已关闭");
                break;
            case 80:
                ds0.a().b(new ShowChatGiftPanelEvent(null, null));
                break;
            case 81:
                String asString31 = contentValues.getAsString("tab");
                fk2.a aVar = new fk2.a();
                Bundle bundle3 = new Bundle();
                bundle3.putString("main_tab", asString31);
                aVar.b(bundle3);
                activity.startActivity(n5.b(activity, aVar));
                break;
            case 82:
                e(activity);
                break;
            case 83:
                PortraitAlbumActivity.f2(activity, C(contentValues));
                break;
            case 84:
                activity.startActivity(new Intent(activity, (Class<?>) ChargingSettingsActivity.class));
                break;
            case 86:
                qq2.i(activity);
                break;
            case 87:
                u(activity, contentValues.getAsInteger("scene").intValue(), contentValues.getAsInteger("from").intValue());
                break;
            case 88:
                u93.e(new c(contentValues, activity));
                break;
            case 89:
                int iIntValue5 = contentValues.getAsInteger("scene").intValue();
                int iIntValue6 = contentValues.getAsInteger("from").intValue();
                if (SAppUtil.g.b() && iIntValue6 == 39) {
                    SuperExposeHomeActivity.C1(activity, SuperExposeHomeActivity.FROM.DEEPLINK);
                } else {
                    com.zenmen.palmchat.paidservices.superexpose.a.b().h(activity, iIntValue5, iIntValue6, true);
                }
                break;
            case 90:
                av4.k(activity, contentValues.getAsInteger("scene").intValue(), contentValues.getAsInteger("from").intValue(), true);
                break;
            case 91:
                int iIntValue7 = contentValues.getAsInteger("fromsource").intValue();
                int iIntValue8 = contentValues.getAsInteger("pageIndex").intValue();
                Integer asInteger12 = contentValues.getAsInteger("itemId");
                if (asInteger12 == null) {
                    asInteger12 = -1;
                }
                LogUtil.i("PortraitDecorManager", "A0620 " + iIntValue7 + " " + iIntValue8);
                rk4.d(activity, iIntValue7, null, iIntValue8, asInteger12.intValue(), -1);
                break;
            case 92:
                String asString32 = contentValues.getAsString(DeviceInfoUtil.UID_TAG);
                String asString33 = contentValues.getAsString(bd.h);
                String asString34 = contentValues.getAsString("nickname");
                if (asString32 != null) {
                    ContactInfoItem contactInfoItemL2 = bo0.r().l(asString32);
                    if (contactInfoItemL2 == null) {
                        contactInfoItemL2 = new ContactInfoItem();
                        contactInfoItemL2.setUid(asString32);
                        contactInfoItemL2.setExid(asString33);
                        contactInfoItemL2.setNickName(asString34);
                        contactInfoItemL2.setFriendType(1);
                    }
                    UserFeedActivity.C1(activity, contactInfoItemL2);
                }
                break;
            case 94:
                Integer asInteger13 = contentValues.getAsInteger("from");
                lh6.V().i0(activity, asInteger13 != null ? asInteger13.intValue() : 0, contentValues.getAsInteger("subPage"));
                break;
            case 95:
                j(activity, contentValues);
                break;
            case 96:
                if (v8.h()) {
                    Integer asInteger14 = contentValues.getAsInteger("from");
                    v8.O(activity, contentValues.getAsString("fuid"), asInteger14 != null ? asInteger14.intValue() : 0, chatItem != null ? chatItem.getBizType() : 0);
                }
                break;
            case 97:
                ContactInfoItem contactInfoItemF = v4.f();
                w4.B(activity, 0, null, (contactInfoItemF == null || contactInfoItemF.getExt() == null || contactInfoItemF.getExt().getPrcRealName() != 1) ? false : true);
                break;
            case 98:
                TrackHomeActivity.A1(activity, contentValues.getAsInteger("tab").intValue(), contentValues.getAsInteger("subtab").intValue());
                break;
            case 99:
                Integer asInteger15 = contentValues.getAsInteger("type");
                int iIntValue9 = asInteger15 != null ? asInteger15.intValue() : 0;
                try {
                    fk2.a aVar2 = new fk2.a();
                    Bundle bundle4 = new Bundle();
                    bundle4.putString("main_tab", "tab_find_friend");
                    bundle4.putString("find_friend_tab", "onlinerecommend");
                    bundle4.putInt("type", iIntValue9);
                    aVar2.b(bundle4);
                    activity.startActivity(n5.b(activity, aVar2));
                } catch (Exception unused2) {
                    return true;
                }
                break;
            case 100:
                activity.startActivity(new Intent(activity, (Class<?>) NetDetectActivity.class));
                break;
            case 101:
                q05.a("notify_chat_click", 2, new d(activity, contentValues.getAsString("toUid")));
                com.zenmen.palmchat.utils.a.E().y0(activity);
                break;
            case 102:
                SuperExposeHomeActivity.B1(activity, contentValues.getAsInteger("from").intValue());
                break;
            default:
                new sd3(activity).O(R.string.alert_dialog_ok).j(R.string.rich_message_not_support).e().show();
                break;
        }
        return false;
    }

    public static /* synthetic */ void m(ContentValues contentValues, Activity activity, GroupInfoItem groupInfoItem) {
        if (groupInfoItem == null) {
            sy5.e(activity, R.string.circle_link_no_group_mem, 0).g();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("fromType", contentValues.getAsInteger(az.at) == null ? -1 : contentValues.getAsInteger(az.at).intValue());
        intent.setClass(activity, ChatterActivity.class);
        intent.putExtra("chat_item", groupInfoItem);
        k86.X(intent);
        activity.startActivity(intent);
    }

    public static /* synthetic */ void n(Activity activity, GroupInfoItem groupInfoItem) {
        if (groupInfoItem != null) {
            CircleNameModifyActivity.K1(activity, groupInfoItem);
        } else {
            sy5.e(activity, R.string.circle_link_no_group_mem, 0).g();
        }
    }

    public static void o(Activity activity, String str, boolean z) {
        if (q(activity, str)) {
            return;
        }
        s(activity, str, z);
    }

    public static Intent p(FrameworkBaseActivity frameworkBaseActivity, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return bu3.g().e(frameworkBaseActivity, str);
        } catch (Exception e2) {
            ma3.c(e2);
            return null;
        }
    }

    public static boolean q(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent intentE = bu3.g().e(activity, str);
            if (intentE != null) {
                activity.startActivity(intentE);
                return true;
            }
        } catch (Exception e2) {
            ma3.c(e2);
        }
        return false;
    }

    public static boolean r(Activity activity, Pair<Integer, ContentValues> pair, String str) {
        ContactInfoItem contactInfoItem;
        if (pair == null) {
            pair = mb4.g(str);
        }
        boolean z = false;
        if (pair != null) {
            int iIntValue = ((Integer) pair.first).intValue();
            ContentValues contentValues = (ContentValues) pair.second;
            if (contentValues.getAsString("fromChatId") != null) {
                contactInfoItem = new ContactInfoItem();
                contactInfoItem.setUid(contentValues.getAsString("fromChatId"));
            } else {
                contactInfoItem = null;
            }
            if (iIntValue == 3) {
                return k(activity, null, contentValues, null, contactInfoItem);
            }
            if (iIntValue == -1) {
                Integer asInteger = contentValues.getAsInteger("lxWindowStyle");
                Boolean asBoolean = contentValues.getAsBoolean("showMenu");
                if (asBoolean == null) {
                    asBoolean = Boolean.FALSE;
                }
                rp2.a aVar = new rp2.a();
                aVar.l(str);
                if (asInteger != null && asInteger.intValue() == 1) {
                    z = true;
                }
                aVar.j(z);
                aVar.k(asBoolean.booleanValue());
                Intent intentA = vj6.a(activity, aVar);
                if (contactInfoItem != null) {
                    intentA.putExtra("back_jump_chatItem", contactInfoItem);
                }
                activity.startActivity(intentA);
                return true;
            }
            if (iIntValue == 10) {
                return q(activity, str);
            }
        }
        return false;
    }

    public static boolean s(Activity activity, String str, boolean z) {
        return t(activity, str, z, null);
    }

    @Deprecated
    public static boolean t(Activity activity, String str, boolean z, String str2) {
        try {
            Pair<Integer, ContentValues> pairG = mb4.g(str);
            if (pairG != null) {
                int iIntValue = ((Integer) pairG.first).intValue();
                ContentValues contentValues = (ContentValues) pairG.second;
                if (iIntValue == 3) {
                    return l(activity, null, contentValues, null, null, str2);
                }
                if (iIntValue == -1) {
                    Integer asInteger = contentValues.getAsInteger("lxWindowStyle");
                    rp2.a aVar = new rp2.a();
                    aVar.l(str);
                    aVar.j(asInteger != null && asInteger.intValue() == 1);
                    aVar.k(z);
                    activity.startActivity(vj6.a(activity, aVar));
                    return true;
                }
                if (iIntValue == 10) {
                    return q(activity, str);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static void u(Context context, int i2, int i3) {
        String strF;
        ChatItem chatItemO3;
        if (b) {
            return;
        }
        if (!hx3.m(context)) {
            ez2.a("网络好像有点问题，稍后再试");
            return;
        }
        if (!(context instanceof ChatterActivity) || (chatItemO3 = ((ChatterActivity) context).o3()) == null) {
            strF = null;
        } else {
            String str = fu5.k(chatItemO3.getBizType()).domain;
            strF = of2.f(i3, i2, chatItemO3.getChatId() + str, n20.h(chatItemO3), str, chatItemO3.getBizType());
        }
        if (strF == null) {
            strF = of2.f(i3, i2, "", 0, "", 0);
        }
        com.zenmen.palmchat.giftkit.a.a().b(context, strF, -1L, new h());
        b = true;
    }

    public static void v(ContentValues contentValues) {
        HashMap map = new HashMap();
        if (contentValues != null) {
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        Exception exc = new Exception("open mini app failed!");
        map.put("action", "OpenMiniApp");
        LogUtil.i("AppBuildInSchemeManager", LogUtil.LogType.LOG_TYPE_ANR_NEW, 3, (HashMap<String, Object>) map, exc);
    }

    public static void w(ContactInfoItem contactInfoItem, int i2, String str) {
        if (contactInfoItem != null) {
            if (dn0.a(contactInfoItem.getUid()) == null) {
                contactInfoItem.setFriendType(1);
                AppContext.getContext().getContentResolver().insert(ho0.f18003a, nn0.a(contactInfoItem));
            }
            contactInfoItem.setBizType(i2);
            MessageVo messageVoG = u0.g(contactInfoItem);
            messageVoG.mimeType = 1;
            messageVoG.text = str;
            messageVoG.setThreadBizType(AppContext.getContext(), i2);
            try {
                ch.s().u().r(messageVoG);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void x(List<ContactInfoItem> list, int i2, String str) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<ContactInfoItem> it = list.iterator();
        while (it.hasNext()) {
            w(it.next(), i2, str);
        }
    }

    public static void y(Activity activity, ContentValues contentValues, boolean z, ChatItem chatItem) {
        String asString = contentValues.getAsString("urlExtra");
        String asString2 = contentValues.getAsString("pkgId");
        Boolean asBoolean = contentValues.getAsBoolean("isTransParent");
        String asString3 = contentValues.getAsString("statusBarColor");
        Boolean asBoolean2 = contentValues.getAsBoolean("statusBarLight");
        if (asString2.equals("bubble") && rw0.b()) {
            rk4.d(activity, 15, null, 2, -1, -1);
        } else {
            B(activity, asString2, asString, asBoolean, asString3, z, chatItem, asBoolean2);
        }
    }

    public static void z(Activity activity, RichMsgExItemVo richMsgExItemVo, String str, String str2) {
        Intent intent = new Intent();
        intent.setClass(activity, WebModuleActivity.class);
        Bundle bundle = new Bundle();
        Package r2 = new Package();
        r2.pkgId = str;
        if (richMsgExItemVo != null) {
            r2.name = richMsgExItemVo.appName;
            r2.icon = richMsgExItemVo.appIcon;
        }
        bundle.putInt("extra_type", 1);
        bundle.putInt("extra_from", 4);
        bundle.putString("extra_url_extension", str2);
        bundle.putSerializable("extra_package", r2);
        bundle.putBoolean("web_show_share", true);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, 106);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21414a;

        public b(Activity activity) {
            this.f21414a = activity;
        }

        @Override // com.zenmen.palmchat.settings.cert.a.b
        public void onResult(boolean z) {
            Activity activity = this.f21414a;
            if (activity instanceof FrameworkBaseActivity) {
                ((FrameworkBaseActivity) activity).hideBaseProgressBar();
            }
            if (z) {
                sy5.e(this.f21414a, R.string.realname_check_pass, 0).g();
            } else {
                com.zenmen.palmchat.settings.cert.a.a().d(this.f21414a, new a());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements a.b {
            public a() {
            }

            @Override // com.zenmen.palmchat.settings.cert.a.b
            public void onResult(boolean z) {
            }
        }
    }
}
