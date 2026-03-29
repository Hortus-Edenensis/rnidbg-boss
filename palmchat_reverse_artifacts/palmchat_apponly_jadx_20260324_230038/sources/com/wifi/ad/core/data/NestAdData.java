package com.wifi.ad.core.data;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTClientBidding;
import com.heytap.mcssdk.constant.b;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.model.AdnName;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.wifi.ad.core.R;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import com.wifi.ad.core.config.adx.model.WkAdMutliPrice;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.listener.InnerRewardShowListener;
import com.wifi.ad.core.listener.PopShowListener;
import com.wifi.ad.core.listener.SPTimeOutListener;
import com.wifi.ad.core.listener.SplashShowListener;
import com.wifi.ad.core.spstrategy.SPMaterialModel;
import com.wifi.ad.core.spstrategy.SPPriceEventManager;
import com.wifi.ad.core.strategy.AbsStrategy;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.adsdk.utils.LxAdConst;
import com.zm.fissionsdk.api.interfaces.IFission;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0014Ý\u0003Þ\u0003ß\u0003à\u0003á\u0003â\u0003ã\u0003ä\u0003å\u0003æ\u0003B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010Ì\u0003\u001a\u00020+2\t\u0010Í\u0003\u001a\u0004\u0018\u00010%H\u0096\u0002J\u0007\u0010Î\u0003\u001a\u00020\u001cJ\u0012\u0010Ï\u0003\u001a\u0004\u0018\u00010%2\u0007\u0010Ð\u0003\u001a\u00020\u0004J\"\u0010Ñ\u0003\u001a\u00030Ò\u00032\u0007\u0010Ó\u0003\u001a\u00020+2\u0007\u0010Ô\u0003\u001a\u00020\u001cH\u0000¢\u0006\u0003\bÕ\u0003J\u0010\u0010Ö\u0003\u001a\u00030Ò\u0003H\u0000¢\u0006\u0003\b×\u0003J\u001a\u0010Ø\u0003\u001a\u00030Ò\u00032\u0007\u0010Ð\u0003\u001a\u00020\u00042\u0007\u0010Ù\u0003\u001a\u00020%J\u0007\u0010Ú\u0003\u001a\u00020+J\u0007\u0010Û\u0003\u001a\u00020\u0004J\t\u0010Ü\u0003\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010@\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010F\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\u001c\u0010I\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010'\"\u0004\bK\u0010)R\u001c\u0010L\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010'\"\u0004\bN\u0010)R\u001c\u0010O\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010'\"\u0004\bQ\u0010)R\u001c\u0010R\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\u001c\u0010U\u001a\u0004\u0018\u00010VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001c\u0010[\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR\u001c\u0010^\u001a\u0004\u0018\u00010_X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u001e\"\u0004\bk\u0010 R\u001a\u0010l\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u001e\"\u0004\bn\u0010 R\u001c\u0010o\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0006\"\u0004\bq\u0010\bR\u001c\u0010r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0006\"\u0004\bt\u0010\bR\u001a\u0010u\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u001e\"\u0004\bw\u0010 R\u001c\u0010x\u001a\u0004\u0018\u00010yX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001d\u0010~\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\u0006\"\u0005\b\u0080\u0001\u0010\bR\u001f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0006\"\u0005\b\u0083\u0001\u0010\bR\u001d\u0010\u0084\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u001e\"\u0005\b\u0086\u0001\u0010 R\u001d\u0010\u0087\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010\u001e\"\u0005\b\u0089\u0001\u0010 R\u001d\u0010\u008a\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u001e\"\u0005\b\u008c\u0001\u0010 R\u001f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010\u0006\"\u0005\b\u008f\u0001\u0010\bR\u001d\u0010\u0090\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\u001e\"\u0005\b\u0092\u0001\u0010 R\u001d\u0010\u0093\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u001e\"\u0005\b\u0095\u0001\u0010 R\u001f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\u0006\"\u0005\b\u0098\u0001\u0010\bR \u0010\u0099\u0001\u001a\u00030\u009a\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001d\u0010\u009f\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010\u001e\"\u0005\b¡\u0001\u0010 R\u001d\u0010¢\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010\u0006\"\u0005\b¤\u0001\u0010\bR\"\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R\u001d\u0010«\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010\u001e\"\u0005\b\u00ad\u0001\u0010 R\u001d\u0010®\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010\u001e\"\u0005\b°\u0001\u0010 R\u001f\u0010±\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010\u0006\"\u0005\b³\u0001\u0010\bR)\u0010´\u0001\u001a\f\u0012\u0005\u0012\u00030¶\u0001\u0018\u00010µ\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R\u001d\u0010»\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0001\u0010\u001e\"\u0005\b½\u0001\u0010 R=\u0010¾\u0001\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c0¿\u0001j\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c`À\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R \u0010Å\u0001\u001a\u00030Æ\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R\u001f\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0001\u0010\u0006\"\u0005\bÍ\u0001\u0010\bR\u001d\u0010Î\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÏ\u0001\u0010\u001e\"\u0005\bÐ\u0001\u0010 R \u0010Ñ\u0001\u001a\u00030Ò\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R\u001d\u0010×\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bØ\u0001\u0010\u001e\"\u0005\bÙ\u0001\u0010 R.\u0010Ú\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020%\u0018\u00010Û\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÜ\u0001\u0010Ý\u0001\"\u0006\bÞ\u0001\u0010ß\u0001R\u001d\u0010à\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bá\u0001\u0010\u001e\"\u0005\bâ\u0001\u0010 R\u001d\u0010ã\u0001\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bä\u0001\u0010f\"\u0005\bå\u0001\u0010hR\u001d\u0010æ\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bç\u0001\u0010\u001e\"\u0005\bè\u0001\u0010 R\u001f\u0010é\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bê\u0001\u0010\u0006\"\u0005\bë\u0001\u0010\bR\u001f\u0010ì\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bí\u0001\u0010\u0006\"\u0005\bî\u0001\u0010\bR\"\u0010ï\u0001\u001a\u0005\u0018\u00010ð\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bñ\u0001\u0010ò\u0001\"\u0006\bó\u0001\u0010ô\u0001R\u001d\u0010õ\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bö\u0001\u0010\u001e\"\u0005\b÷\u0001\u0010 R\u001d\u0010ø\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bù\u0001\u0010\u001e\"\u0005\bú\u0001\u0010 R\u001d\u0010û\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bü\u0001\u0010\u0006\"\u0005\bý\u0001\u0010\bR\u001d\u0010þ\u0001\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bþ\u0001\u0010f\"\u0005\bÿ\u0001\u0010hR\u001d\u0010\u0080\u0002\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0002\u0010f\"\u0005\b\u0081\u0002\u0010hR\u001d\u0010\u0082\u0002\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0002\u0010f\"\u0005\b\u0083\u0002\u0010hR \u0010\u0084\u0002\u001a\u00030Ò\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0002\u0010Ô\u0001\"\u0006\b\u0086\u0002\u0010Ö\u0001R\"\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0088\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002\"\u0006\b\u008b\u0002\u0010\u008c\u0002R\u001d\u0010\u008d\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0002\u0010\u001e\"\u0005\b\u008f\u0002\u0010 R\u001d\u0010\u0090\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0002\u0010\u001e\"\u0005\b\u0092\u0002\u0010 R\u001d\u0010\u0093\u0002\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0002\u0010f\"\u0005\b\u0095\u0002\u0010hR(\u0010\u0096\u0002\u001a\u000b\u0012\u0004\u0012\u000202\u0018\u00010\u0097\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0002\u0010¸\u0001\"\u0006\b\u0099\u0002\u0010º\u0001R\"\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u009b\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002\"\u0006\b\u009e\u0002\u0010\u009f\u0002R\u001f\u0010 \u0002\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0002\u0010\u0006\"\u0005\b¢\u0002\u0010\bR\u001d\u0010£\u0002\u001a\u00020+X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0002\u0010f\"\u0005\b¥\u0002\u0010hR\u001f\u0010¦\u0002\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0002\u00104\"\u0005\b¨\u0002\u00106R\u001f\u0010©\u0002\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0002\u00104\"\u0005\b«\u0002\u00106R\u001f\u0010¬\u0002\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0002\u00104\"\u0005\b®\u0002\u00106R!\u0010¯\u0002\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b°\u0002\u0010\u001e\"\u0005\b±\u0002\u0010 R\u001d\u0010²\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b³\u0002\u0010\u001e\"\u0005\b´\u0002\u0010 R\"\u0010µ\u0002\u001a\u0005\u0018\u00010¶\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b·\u0002\u0010¸\u0002\"\u0006\b¹\u0002\u0010º\u0002R\u001d\u0010»\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0002\u0010\u001e\"\u0005\b½\u0002\u0010 R\u001d\u0010¾\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0002\u0010\u001e\"\u0005\bÀ\u0002\u0010 R\u001d\u0010Á\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÂ\u0002\u0010\u001e\"\u0005\bÃ\u0002\u0010 R\u001d\u0010Ä\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÅ\u0002\u0010\u001e\"\u0005\bÆ\u0002\u0010 R\u001d\u0010Ç\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÈ\u0002\u0010\u001e\"\u0005\bÉ\u0002\u0010 R\u001d\u0010Ê\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bË\u0002\u0010\u001e\"\u0005\bÌ\u0002\u0010 R\u001d\u0010Í\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÎ\u0002\u0010\u001e\"\u0005\bÏ\u0002\u0010 R\u001d\u0010Ð\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0002\u0010\u001e\"\u0005\bÒ\u0002\u0010 R\u001f\u0010Ó\u0002\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÔ\u0002\u0010\u0006\"\u0005\bÕ\u0002\u0010\bR\u001f\u0010Ö\u0002\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b×\u0002\u0010\u0006\"\u0005\bØ\u0002\u0010\bR\"\u0010Ù\u0002\u001a\u0005\u0018\u00010Ú\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÛ\u0002\u0010Ü\u0002\"\u0006\bÝ\u0002\u0010Þ\u0002R\u001d\u0010ß\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bà\u0002\u0010\u001e\"\u0005\bá\u0002\u0010 R\u001f\u0010â\u0002\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bã\u0002\u0010\u0006\"\u0005\bä\u0002\u0010\bR\u001d\u0010å\u0002\u001a\u00020\u001cX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bæ\u0002\u0010\u001e\"\u0005\bç\u0002\u0010 R\"\u0010è\u0002\u001a\u0005\u0018\u00010é\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bê\u0002\u0010ë\u0002\"\u0006\bì\u0002\u0010í\u0002R\u001d\u0010î\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bï\u0002\u0010\u001e\"\u0005\bð\u0002\u0010 R\u001d\u0010ñ\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bò\u0002\u0010\u001e\"\u0005\bó\u0002\u0010 R\u001d\u0010ô\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bõ\u0002\u0010\u001e\"\u0005\bö\u0002\u0010 R\u001d\u0010÷\u0002\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bø\u0002\u0010\u001e\"\u0005\bù\u0002\u0010 R\u001f\u0010ú\u0002\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bû\u0002\u0010\u0006\"\u0005\bü\u0002\u0010\bR\u001f\u0010ý\u0002\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bþ\u0002\u0010\u0006\"\u0005\bÿ\u0002\u0010\bR\u001f\u0010\u0080\u0003\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0003\u00104\"\u0005\b\u0082\u0003\u00106R\u001f\u0010\u0083\u0003\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0003\u00104\"\u0005\b\u0085\u0003\u00106R\"\u0010\u0086\u0003\u001a\u0005\u0018\u00010\u0087\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0003\u0010\u0089\u0003\"\u0006\b\u008a\u0003\u0010\u008b\u0003R\u001f\u0010\u008c\u0003\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0003\u00104\"\u0005\b\u008e\u0003\u00106R\u001f\u0010\u008f\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0003\u0010\u0006\"\u0005\b\u0091\u0003\u0010\bR\u001f\u0010\u0092\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0003\u0010\u0006\"\u0005\b\u0094\u0003\u0010\bR\"\u0010\u0095\u0003\u001a\u0005\u0018\u00010\u0096\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0003\u0010\u0098\u0003\"\u0006\b\u0099\u0003\u0010\u009a\u0003R\u001f\u0010\u009b\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0003\u0010\u0006\"\u0005\b\u009d\u0003\u0010\bR-\u0010\u009e\u0003\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020%0¿\u0001j\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020%`À\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u009f\u0003\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0003\u0010\u001e\"\u0005\b¡\u0003\u0010 R\"\u0010¢\u0003\u001a\u0005\u0018\u00010£\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¤\u0003\u0010¥\u0003\"\u0006\b¦\u0003\u0010§\u0003R \u0010¨\u0003\u001a\u00030\u009a\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0003\u0010\u009c\u0001\"\u0006\bª\u0003\u0010\u009e\u0001R \u0010«\u0003\u001a\u00030¬\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u00ad\u0003\u0010®\u0003\"\u0006\b¯\u0003\u0010°\u0003R\u001f\u0010±\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0003\u0010\u0006\"\u0005\b³\u0003\u0010\bR\u001f\u0010´\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0003\u0010\u0006\"\u0005\b¶\u0003\u0010\bR\"\u0010·\u0003\u001a\u0005\u0018\u00010¸\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¹\u0003\u0010º\u0003\"\u0006\b»\u0003\u0010¼\u0003R\u001d\u0010½\u0003\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¾\u0003\u0010f\"\u0005\b¿\u0003\u0010hR\u001d\u0010À\u0003\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÁ\u0003\u0010\u001e\"\u0005\bÂ\u0003\u0010 R\u001d\u0010Ã\u0003\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÄ\u0003\u0010f\"\u0005\bÅ\u0003\u0010hR\u001d\u0010Æ\u0003\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÇ\u0003\u0010\u001e\"\u0005\bÈ\u0003\u0010 R!\u0010É\u0003\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u0012\n\u0002\u00100\u001a\u0005\bÊ\u0003\u0010-\"\u0005\bË\u0003\u0010/¨\u0006ç\u0003"}, d2 = {"Lcom/wifi/ad/core/data/NestAdData;", "Lcom/wifi/ad/core/data/AbsAdData;", "()V", "adAppDeveloperName", "", "getAdAppDeveloperName", "()Ljava/lang/String;", "setAdAppDeveloperName", "(Ljava/lang/String;)V", "adAppFunctionDescUrl", "getAdAppFunctionDescUrl", "setAdAppFunctionDescUrl", "adAppName", "getAdAppName", "setAdAppName", "adAppPermissionsUrl", "getAdAppPermissionsUrl", "setAdAppPermissionsUrl", "adAppPrivacyUrl", "getAdAppPrivacyUrl", "setAdAppPrivacyUrl", "adAppVersion", "getAdAppVersion", "setAdAppVersion", "adCode", "getAdCode", "setAdCode", "adCost", "", "getAdCost", "()I", "setAdCost", "(I)V", "adCostType", "getAdCostType", "setAdCostType", "adData", "", "getAdData", "()Ljava/lang/Object;", "setAdData", "(Ljava/lang/Object;)V", "adDispatchEd", "", "getAdDispatchEd", "()Ljava/lang/Boolean;", "setAdDispatchEd", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "adDownTextView", "Landroid/view/View;", "getAdDownTextView", "()Landroid/view/View;", "setAdDownTextView", "(Landroid/view/View;)V", "adId", "getAdId", "setAdId", "adInteractionListener", "Lcom/wifi/ad/core/data/NestAdData$AdInteractionListener;", "getAdInteractionListener", "()Lcom/wifi/ad/core/data/NestAdData$AdInteractionListener;", "setAdInteractionListener", "(Lcom/wifi/ad/core/data/NestAdData$AdInteractionListener;)V", "adLevel", "getAdLevel", "()Ljava/lang/Integer;", "setAdLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "adLevelName", "getAdLevelName", "setAdLevelName", "adLoadedListener1", "getAdLoadedListener1", "setAdLoadedListener1", "adLoadedListener2", "getAdLoadedListener2", "setAdLoadedListener2", "adLoadedListener3", "getAdLoadedListener3", "setAdLoadedListener3", "adName", "getAdName", "setAdName", "adParams", "Lcom/wifi/ad/core/config/AdParams;", "getAdParams", "()Lcom/wifi/ad/core/config/AdParams;", "setAdParams", "(Lcom/wifi/ad/core/config/AdParams;)V", "adRealLevelName", "getAdRealLevelName", "setAdRealLevelName", "adRenderListener", "Lcom/wifi/ad/core/data/NestAdData$AdRenderListener;", "getAdRenderListener", "()Lcom/wifi/ad/core/data/NestAdData$AdRenderListener;", "setAdRenderListener", "(Lcom/wifi/ad/core/data/NestAdData$AdRenderListener;)V", "adSPStrategy", "getAdSPStrategy", "()Z", "setAdSPStrategy", "(Z)V", "adScene", "getAdScene", "setAdScene", "adStrategyOptimizeSwitch", "getAdStrategyOptimizeSwitch", "setAdStrategyOptimizeSwitch", "adType", "getAdType", "setAdType", LxAdConst.EventKeyParams.KEY_PARAM_ADUNITID, "getAdUnitId", "setAdUnitId", "adxType", "getAdxType", "setAdxType", "appDownloadListener", "Lcom/wifi/ad/core/data/NestAdData$AppDownloadListener;", "getAppDownloadListener", "()Lcom/wifi/ad/core/data/NestAdData$AppDownloadListener;", "setAppDownloadListener", "(Lcom/wifi/ad/core/data/NestAdData$AppDownloadListener;)V", "appId", "getAppId", "setAppId", b.z, "getAppKey", "setAppKey", "blockAd", "getBlockAd", "setBlockAd", "cacheCount", "getCacheCount", "setCacheCount", "cacheSec", "getCacheSec", "setCacheSec", "cfgfrom", "getCfgfrom", "setCfgfrom", "changeAdBtnColorTime", "getChangeAdBtnColorTime", "setChangeAdBtnColorTime", EventParams.KEY_CHANGETYPE, "getChangeType", "setChangeType", "createRequestId", "getCreateRequestId", "setCreateRequestId", "csjSplashSkipEd", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCsjSplashSkipEd", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setCsjSplashSkipEd", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "curGroupNum", "getCurGroupNum", "setCurGroupNum", "discountInfo", "getDiscountInfo", "setDiscountInfo", "dislikeListener", "Lcom/wifi/ad/core/data/NestAdData$DislikeListener;", "getDislikeListener", "()Lcom/wifi/ad/core/data/NestAdData$DislikeListener;", "setDislikeListener", "(Lcom/wifi/ad/core/data/NestAdData$DislikeListener;)V", "downloadStatus", "getDownloadStatus", "setDownloadStatus", "dspId", "getDspId", "setDspId", "dspName", "getDspName", "setDspName", "ecpmLevelMap", "", "Lcom/wifi/ad/core/config/adx/model/WkAdMutliPrice;", "getEcpmLevelMap", "()Ljava/util/List;", "setEcpmLevelMap", "(Ljava/util/List;)V", "ecpmLowPrice", "getEcpmLowPrice", "setEcpmLowPrice", "ecpmMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getEcpmMap", "()Ljava/util/HashMap;", "setEcpmMap", "(Ljava/util/HashMap;)V", "ecpmRatio", "", "getEcpmRatio", "()F", "setEcpmRatio", "(F)V", "failedMsg", "getFailedMsg", "setFailedMsg", "fixed_interval_extra", "getFixed_interval_extra", "setFixed_interval_extra", "freezeLastTime", "", "getFreezeLastTime", "()J", "setFreezeLastTime", "(J)V", "freezetime", "getFreezetime", "setFreezetime", "fsRewardMap", "", "getFsRewardMap", "()Ljava/util/Map;", "setFsRewardMap", "(Ljava/util/Map;)V", "groupId", "getGroupId", "setGroupId", "hasReportExpose", "getHasReportExpose", "setHasReportExpose", "highPrioritySwitch", "getHighPrioritySwitch", "setHighPrioritySwitch", "hwDownBtnTag", "getHwDownBtnTag", "setHwDownBtnTag", "indentityid", "getIndentityid", "setIndentityid", "interactSettings", "Lorg/json/JSONObject;", "getInteractSettings", "()Lorg/json/JSONObject;", "setInteractSettings", "(Lorg/json/JSONObject;)V", "interactiveStatus", "getInteractiveStatus", "setInteractiveStatus", "interactiveType", "getInteractiveType", "setInteractiveType", EventParams.KEY_INVENTORYID, "getInventoryId", "setInventoryId", "isGroupMode", "setGroupMode", "isNativeAd", "setNativeAd", "isRewardVerify", "setRewardVerify", "loadAdTime", "getLoadAdTime", "setLoadAdTime", "materialModel", "Lcom/wifi/ad/core/spstrategy/SPMaterialModel;", "getMaterialModel", "()Lcom/wifi/ad/core/spstrategy/SPMaterialModel;", "setMaterialModel", "(Lcom/wifi/ad/core/spstrategy/SPMaterialModel;)V", "nativeAdImgHeight", "getNativeAdImgHeight", "setNativeAdImgHeight", "nativeAdImgWidth", "getNativeAdImgWidth", "setNativeAdImgWidth", "nativeDownClickDone", "getNativeDownClickDone", "setNativeDownClickDone", "nativeDownClickViews", "", "getNativeDownClickViews", "setNativeDownClickViews", "nativeView", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "getNativeView", "()Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "setNativeView", "(Lcom/wifi/ad/core/custom/flow/BaseNativeView;)V", "nestSid", "getNestSid", "setNestSid", "notificationSent", "getNotificationSent$core_release", "setNotificationSent$core_release", "oppoDescView", "getOppoDescView", "setOppoDescView", "oppoPermissionsView", "getOppoPermissionsView", "setOppoPermissionsView", "oppoPrivacyView", "getOppoPrivacyView", "setOppoPrivacyView", "pauseIcon", "getPauseIcon", "setPauseIcon", "popRequestTime", "getPopRequestTime", "setPopRequestTime", "popshowListener", "Lcom/wifi/ad/core/listener/PopShowListener;", "getPopshowListener", "()Lcom/wifi/ad/core/listener/PopShowListener;", "setPopshowListener", "(Lcom/wifi/ad/core/listener/PopShowListener;)V", EventParams.KEY_CT_SDK_POSITION, "getPosition", "setPosition", "preRequest", "getPreRequest", "setPreRequest", "priceResponse", "getPriceResponse", "setPriceResponse", "priceSwitch", "getPriceSwitch", "setPriceSwitch", "primeRitSwitch", "getPrimeRitSwitch", "setPrimeRitSwitch", "ratio", "getRatio", "setRatio", "renderStyle", "getRenderStyle", "setRenderStyle", "requestFailReason", "getRequestFailReason", "setRequestFailReason", "requestId", "getRequestId", "setRequestId", "respbtnwd", "getRespbtnwd", "setRespbtnwd", "rewardShowListener", "Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "getRewardShowListener", "()Lcom/wifi/ad/core/listener/InnerRewardShowListener;", "setRewardShowListener", "(Lcom/wifi/ad/core/listener/InnerRewardShowListener;)V", "roundResId", "getRoundResId", "setRoundResId", "sdkFrom", "getSdkFrom", "setSdkFrom", "secondAdCost", "getSecondAdCost$core_release", "setSecondAdCost$core_release", "sensitiveInfo", "Lcom/wifi/ad/core/entity/SensitiveInfo;", "getSensitiveInfo", "()Lcom/wifi/ad/core/entity/SensitiveInfo;", "setSensitiveInfo", "(Lcom/wifi/ad/core/entity/SensitiveInfo;)V", "shakeSwitch", "getShakeSwitch", "setShakeSwitch", "shakeSwitchLxad", "getShakeSwitchLxad", "setShakeSwitchLxad", "showAdButtonTime", "getShowAdButtonTime", "setShowAdButtonTime", "showAdCardTime", "getShowAdCardTime", "setShowAdCardTime", "showbtnwd", "getShowbtnwd", "setShowbtnwd", "sourceId", "getSourceId", "setSourceId", "splashBottomArea", "getSplashBottomArea", "setSplashBottomArea", "splashHuaweiView", "getSplashHuaweiView", "setSplashHuaweiView", "splashShowListener", "Lcom/wifi/ad/core/listener/SplashShowListener;", "getSplashShowListener", "()Lcom/wifi/ad/core/listener/SplashShowListener;", "setSplashShowListener", "(Lcom/wifi/ad/core/listener/SplashShowListener;)V", "splashView", "getSplashView", "setSplashView", "startegyTaiChi", "getStartegyTaiChi", "setStartegyTaiChi", "strategyId", "getStrategyId", "setStrategyId", "strategyListener", "Lcom/wifi/ad/core/strategy/AbsStrategy;", "getStrategyListener", "()Lcom/wifi/ad/core/strategy/AbsStrategy;", "setStrategyListener", "(Lcom/wifi/ad/core/strategy/AbsStrategy;)V", "strategyVer", "getStrategyVer", "setStrategyVer", "tags", "timeOut", "getTimeOut", "setTimeOut", "timeOutListener", "Lcom/wifi/ad/core/listener/SPTimeOutListener;", "getTimeOutListener", "()Lcom/wifi/ad/core/listener/SPTimeOutListener;", "setTimeOutListener", "(Lcom/wifi/ad/core/listener/SPTimeOutListener;)V", "timeOutOrResEd", "getTimeOutOrResEd", "setTimeOutOrResEd", "timeoutRunnable", "Ljava/lang/Runnable;", "getTimeoutRunnable", "()Ljava/lang/Runnable;", "setTimeoutRunnable", "(Ljava/lang/Runnable;)V", "timing", "getTiming", "setTiming", "useRequestId", "getUseRequestId", "setUseRequestId", "videoAdListener", "Lcom/wifi/ad/core/data/NestAdData$VideoAdListener;", "getVideoAdListener", "()Lcom/wifi/ad/core/data/NestAdData$VideoAdListener;", "setVideoAdListener", "(Lcom/wifi/ad/core/data/NestAdData$VideoAdListener;)V", "videoCached", "getVideoCached", "setVideoCached", "whiteAd", "getWhiteAd", "setWhiteAd", "winner", "getWinner", "setWinner", "wipeScreenExtra", "getWipeScreenExtra", "setWipeScreenExtra", "zhiboAd", "getZhiboAd", "setZhiboAd", "equals", AdnName.OTHER, "getAdLogoResId", "getTag", "key", "sendLossNotification", "", WkAdConfigModel.TAG_TIMEOUT, "maxPrice", "sendLossNotification$core_release", "sendWinNotification", "sendWinNotification$core_release", "setTag", "tag", "supportAdLogo", "toJsonString", "toString", "AdCostType", "AdInteractionListener", "AdMode", "AdRenderListener", "AppDownloadListener", "DislikeListener", "DownAppType", "DownloadStatus", "InteractionType", "VideoAdListener", "core_release"}, k = 1, mv = {1, 1, 16})
public final class NestAdData extends AbsAdData {
    private String adAppDeveloperName;
    private String adAppFunctionDescUrl;
    private String adAppName;
    private String adAppPermissionsUrl;
    private String adAppPrivacyUrl;
    private String adAppVersion;
    private String adCode;
    private int adCost;
    private int adCostType;
    private Object adData;
    private Boolean adDispatchEd;
    private View adDownTextView;
    private String adId;
    private AdInteractionListener adInteractionListener;
    private Integer adLevel;
    private String adLevelName;
    private Object adLoadedListener1;
    private Object adLoadedListener2;
    private Object adLoadedListener3;
    private String adName;
    private AdParams adParams;
    private String adRealLevelName;
    private AdRenderListener adRenderListener;
    private boolean adSPStrategy;
    private int adScene;
    private int adStrategyOptimizeSwitch;
    private String adType;
    private String adUnitId;
    private int adxType;
    private AppDownloadListener appDownloadListener;
    private String appId;
    private String appKey;
    private int blockAd;
    private int cacheCount;
    private int cacheSec;
    private String cfgfrom;
    private int changeAdBtnColorTime;
    private int changeType;
    private String createRequestId;
    private int curGroupNum;
    private String discountInfo;
    private DislikeListener dislikeListener;
    private int downloadStatus;
    private int dspId;
    private String dspName;
    private List<WkAdMutliPrice> ecpmLevelMap;
    private int ecpmLowPrice;
    private float ecpmRatio;
    private String failedMsg;
    private int fixed_interval_extra;
    private long freezeLastTime;
    private int freezetime;
    private Map<String, ? extends Object> fsRewardMap;
    private int groupId;
    private boolean hasReportExpose;
    private int highPrioritySwitch;
    private String hwDownBtnTag;
    private String indentityid;
    private JSONObject interactSettings;
    private int interactiveStatus;
    private int interactiveType;
    private boolean isGroupMode;
    private boolean isNativeAd;
    private boolean isRewardVerify;
    private long loadAdTime;
    private SPMaterialModel materialModel;
    private int nativeAdImgHeight;
    private int nativeAdImgWidth;
    private boolean nativeDownClickDone;
    private List<View> nativeDownClickViews;
    private BaseNativeView nativeView;
    private String nestSid;
    private boolean notificationSent;
    private View oppoDescView;
    private View oppoPermissionsView;
    private View oppoPrivacyView;

    @DrawableRes
    private int pauseIcon;
    private int popRequestTime;
    private PopShowListener popshowListener;
    private int position;
    private int preRequest;
    private int priceResponse;
    private int priceSwitch;
    private int primeRitSwitch;
    private int ratio;
    private int renderStyle;
    private int requestFailReason;
    private String requestId;
    private String respbtnwd;
    private InnerRewardShowListener rewardShowListener;
    private int roundResId;
    private String sdkFrom;
    private int secondAdCost;
    private SensitiveInfo sensitiveInfo;
    private int shakeSwitch;
    private int shakeSwitchLxad;
    private int showAdButtonTime;
    private int showAdCardTime;
    private String showbtnwd;
    private String sourceId;
    private View splashBottomArea;
    private View splashHuaweiView;
    private SplashShowListener splashShowListener;
    private View splashView;
    private String startegyTaiChi;
    private String strategyId;
    private AbsStrategy strategyListener;
    private String strategyVer;
    private final HashMap<String, Object> tags;
    private int timeOut;
    private SPTimeOutListener timeOutListener;
    private AtomicBoolean timeOutOrResEd;
    private Runnable timeoutRunnable;
    private String timing;
    private String useRequestId;
    private VideoAdListener videoAdListener;
    private boolean videoCached;
    private int whiteAd;
    private boolean winner;
    private int wipeScreenExtra;
    private Boolean zhiboAd;
    private AtomicBoolean csjSplashSkipEd = new AtomicBoolean(false);
    private String inventoryId = "";
    private HashMap<String, Integer> ecpmMap = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wifi/ad/core/data/NestAdData$AdCostType;", "", "()V", "ADCOSTTYPE_BIDING", "", "getADCOSTTYPE_BIDING", "()I", "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class AdCostType {
        public static final AdCostType INSTANCE = new AdCostType();
        private static final int ADCOSTTYPE_BIDING = 4;

        private AdCostType() {
        }

        public final int getADCOSTTYPE_BIDING() {
            return ADCOSTTYPE_BIDING;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/wifi/ad/core/data/NestAdData$AdInteractionListener;", "", "onAdClicked", "", "adData", "Lcom/wifi/ad/core/data/NestAdData;", "onAdExposed", "core_release"}, k = 1, mv = {1, 1, 16})
    public interface AdInteractionListener {
        void onAdClicked(@NonNull NestAdData adData);

        void onAdExposed(@NonNull NestAdData adData);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/wifi/ad/core/data/NestAdData$AdMode;", "", "()V", "BIG_PIC", "", "GROUP_PIC", "ONE_PIC", GrsBaseInfo.CountryCodeSource.UNKNOWN, "VIDEO", "VIDEO_VERTICAL", "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class AdMode {
        public static final int BIG_PIC = 1;
        public static final int GROUP_PIC = 3;
        public static final AdMode INSTANCE = new AdMode();
        public static final int ONE_PIC = 2;
        public static final int UNKNOWN = 0;
        public static final int VIDEO = 4;
        public static final int VIDEO_VERTICAL = 5;

        private AdMode() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u0005H&J\u001c\u0010\u000b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/wifi/ad/core/data/NestAdData$AdRenderListener;", "", "onRenderFail", "", "providerType", "", "adData", "Lcom/wifi/ad/core/data/NestAdData;", "errorCode", "", "message", "onRenderSuccess", "core_release"}, k = 1, mv = {1, 1, 16})
    public interface AdRenderListener {
        void onRenderFail(@NonNull String providerType, @NonNull NestAdData adData, @NonNull int errorCode, @NonNull String message);

        void onRenderSuccess(@NonNull String providerType, @NonNull NestAdData adData);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/wifi/ad/core/data/NestAdData$AppDownloadListener;", "", "onDownloadComplete", "", "adData", "Lcom/wifi/ad/core/data/NestAdData;", "onDownloadFailed", "onDownloadInstalled", "onDownloadPause", "onDownloadProgress", "progress", "", "onDownloadStart", "core_release"}, k = 1, mv = {1, 1, 16})
    public interface AppDownloadListener {
        void onDownloadComplete(@NonNull NestAdData adData);

        void onDownloadFailed(@NonNull NestAdData adData);

        void onDownloadInstalled(@NonNull NestAdData adData);

        void onDownloadPause(@NonNull NestAdData adData);

        void onDownloadProgress(@NonNull NestAdData adData, int progress);

        void onDownloadStart(@NonNull NestAdData adData);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wifi/ad/core/data/NestAdData$DislikeListener;", "", "onDislikeClicked", "", "adData", "Lcom/wifi/ad/core/data/NestAdData;", "core_release"}, k = 1, mv = {1, 1, 16})
    public interface DislikeListener {
        void onDislikeClicked(@NonNull NestAdData adData);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/wifi/ad/core/data/NestAdData$DownAppType;", "", "()V", "TYPE_APP_DOWNLOAD", "", "TYPE_APP_NORMAL", "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class DownAppType {
        public static final DownAppType INSTANCE = new DownAppType();
        public static final int TYPE_APP_DOWNLOAD = 1;
        public static final int TYPE_APP_NORMAL = 2;

        private DownAppType() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/wifi/ad/core/data/NestAdData$DownloadStatus;", "", "()V", "DOWNLOADED", "", "DOWNLOADING", "FAILED", "IDLE", "INSTALLED", "PAUSED", "STARTED", "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class DownloadStatus {
        public static final int DOWNLOADED = 4;
        public static final int DOWNLOADING = 3;
        public static final int FAILED = 6;
        public static final int IDLE = 0;
        public static final int INSTALLED = 5;
        public static final DownloadStatus INSTANCE = new DownloadStatus();
        public static final int PAUSED = 2;
        public static final int STARTED = 1;

        private DownloadStatus() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/wifi/ad/core/data/NestAdData$InteractionType;", "", "()V", "TYPE_DEEPLINK", "", "TYPE_DOWNLOAD", "TYPE_H5", "TYPE_PHONE", GrsBaseInfo.CountryCodeSource.UNKNOWN, "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class InteractionType {
        public static final InteractionType INSTANCE = new InteractionType();
        public static final int TYPE_DEEPLINK = 3;
        public static final int TYPE_DOWNLOAD = 1;
        public static final int TYPE_H5 = 2;
        public static final int TYPE_PHONE = 4;
        public static final int UNKNOWN = 0;

        private InteractionType() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/wifi/ad/core/data/NestAdData$VideoAdListener;", "", "onVideoComplete", "", "adData", "Lcom/wifi/ad/core/data/NestAdData;", "onVideoError", "onVideoPause", "onVideoStart", "core_release"}, k = 1, mv = {1, 1, 16})
    public interface VideoAdListener {
        void onVideoComplete(@NonNull NestAdData adData);

        void onVideoError(@NonNull NestAdData adData);

        void onVideoPause(@NonNull NestAdData adData);

        void onVideoStart(@NonNull NestAdData adData);
    }

    public NestAdData() {
        Boolean bool = Boolean.FALSE;
        this.zhiboAd = bool;
        this.adDispatchEd = bool;
        this.roundResId = -1;
        this.timeoutRunnable = new Runnable() { // from class: com.wifi.ad.core.data.NestAdData$timeoutRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                if (this.this$0.getTimeOutOrResEd().get()) {
                    return;
                }
                this.this$0.getTimeOutOrResEd().set(true);
                if (this.this$0.getTimeOutListener() != null) {
                    SPTimeOutListener timeOutListener = this.this$0.getTimeOutListener();
                    if (timeOutListener == null) {
                        Intrinsics.throwNpe();
                    }
                    timeOutListener.onResult(this.this$0);
                }
            }
        };
        this.timeOutOrResEd = new AtomicBoolean(false);
        this.priceSwitch = 1;
        this.ecpmRatio = 1.0f;
        this.showAdButtonTime = 5;
        this.changeAdBtnColorTime = 2;
        this.showAdCardTime = 2;
        this.discountInfo = "";
        this.tags = new HashMap<>();
    }

    public boolean equals(Object other) {
        if (other instanceof NestAdData) {
            if (SPPriceEventManager.INSTANCE.allow45488()) {
                if (!TextUtils.isEmpty(this.adCode)) {
                    NestAdData nestAdData = (NestAdData) other;
                    if (!TextUtils.isEmpty(nestAdData.adCode) && !TextUtils.isEmpty(this.createRequestId) && !TextUtils.isEmpty(nestAdData.createRequestId)) {
                        return StringsKt__StringsJVMKt.equals$default(this.adCode, nestAdData.adCode, false, 2, null) && StringsKt__StringsJVMKt.equals$default(this.createRequestId, nestAdData.createRequestId, false, 2, null);
                    }
                }
            } else if (!TextUtils.isEmpty(this.adCode)) {
                NestAdData nestAdData2 = (NestAdData) other;
                if (!TextUtils.isEmpty(nestAdData2.adCode)) {
                    return StringsKt__StringsJVMKt.equals$default(this.adCode, nestAdData2.adCode, false, 2, null);
                }
            }
        }
        return super.equals(other);
    }

    public final String getAdAppDeveloperName() {
        return this.adAppDeveloperName;
    }

    public final String getAdAppFunctionDescUrl() {
        return this.adAppFunctionDescUrl;
    }

    public final String getAdAppName() {
        return this.adAppName;
    }

    public final String getAdAppPermissionsUrl() {
        return this.adAppPermissionsUrl;
    }

    public final String getAdAppPrivacyUrl() {
        return this.adAppPrivacyUrl;
    }

    public final String getAdAppVersion() {
        return this.adAppVersion;
    }

    public final String getAdCode() {
        return this.adCode;
    }

    public final int getAdCost() {
        return this.adCost;
    }

    public final int getAdCostType() {
        return this.adCostType;
    }

    public final Object getAdData() {
        return this.adData;
    }

    public final Boolean getAdDispatchEd() {
        return this.adDispatchEd;
    }

    public final View getAdDownTextView() {
        return this.adDownTextView;
    }

    public final String getAdId() {
        return this.adId;
    }

    public final AdInteractionListener getAdInteractionListener() {
        return this.adInteractionListener;
    }

    public final Integer getAdLevel() {
        return this.adLevel;
    }

    public final String getAdLevelName() {
        return this.adLevelName;
    }

    public final Object getAdLoadedListener1() {
        return this.adLoadedListener1;
    }

    public final Object getAdLoadedListener2() {
        return this.adLoadedListener2;
    }

    public final Object getAdLoadedListener3() {
        return this.adLoadedListener3;
    }

    public final int getAdLogoResId() {
        return Intrinsics.areEqual(this.adType, SDKAlias.GDT.getType()) ? R.drawable.icon_gdt_logo : Intrinsics.areEqual(this.adType, SDKAlias.CSJ.getType()) ? R.drawable.icon_csj_logo : Intrinsics.areEqual(this.adType, SDKAlias.KS.getType()) ? R.drawable.icon_ks_logo : Intrinsics.areEqual(this.adType, SDKAlias.OPPO.getType()) ? R.drawable.icon_oppo_logo : Intrinsics.areEqual(this.adType, SDKAlias.HUAWEI.getType()) ? R.drawable.icon_huawei_logo : Intrinsics.areEqual(this.adType, SDKAlias.FEISUO.getType()) ? R.drawable.icon_feisuo_logo : Intrinsics.areEqual(this.adType, SDKAlias.LXAD.getType()) ? R.drawable.icon_lxad_logo : R.drawable.adsdk_generic_transparent;
    }

    public final String getAdName() {
        return this.adName;
    }

    public final AdParams getAdParams() {
        return this.adParams;
    }

    public final String getAdRealLevelName() {
        return this.adRealLevelName;
    }

    public final AdRenderListener getAdRenderListener() {
        return this.adRenderListener;
    }

    public final boolean getAdSPStrategy() {
        return this.adSPStrategy;
    }

    public final int getAdScene() {
        return this.adScene;
    }

    public final int getAdStrategyOptimizeSwitch() {
        return this.adStrategyOptimizeSwitch;
    }

    public final String getAdType() {
        return this.adType;
    }

    public final String getAdUnitId() {
        return this.adUnitId;
    }

    public final int getAdxType() {
        return this.adxType;
    }

    public final AppDownloadListener getAppDownloadListener() {
        return this.appDownloadListener;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final int getBlockAd() {
        return this.blockAd;
    }

    public final int getCacheCount() {
        return this.cacheCount;
    }

    public final int getCacheSec() {
        return this.cacheSec;
    }

    public final String getCfgfrom() {
        return this.cfgfrom;
    }

    public final int getChangeAdBtnColorTime() {
        return this.changeAdBtnColorTime;
    }

    public final int getChangeType() {
        return this.changeType;
    }

    public final String getCreateRequestId() {
        return this.createRequestId;
    }

    public final AtomicBoolean getCsjSplashSkipEd() {
        return this.csjSplashSkipEd;
    }

    public final int getCurGroupNum() {
        return this.curGroupNum;
    }

    public final String getDiscountInfo() {
        return this.discountInfo;
    }

    public final DislikeListener getDislikeListener() {
        return this.dislikeListener;
    }

    public final int getDownloadStatus() {
        return this.downloadStatus;
    }

    public final int getDspId() {
        return this.dspId;
    }

    public final String getDspName() {
        return this.dspName;
    }

    public final List<WkAdMutliPrice> getEcpmLevelMap() {
        return this.ecpmLevelMap;
    }

    public final int getEcpmLowPrice() {
        return this.ecpmLowPrice;
    }

    public final HashMap<String, Integer> getEcpmMap() {
        return this.ecpmMap;
    }

    public final float getEcpmRatio() {
        return this.ecpmRatio;
    }

    public final String getFailedMsg() {
        return this.failedMsg;
    }

    public final int getFixed_interval_extra() {
        return this.fixed_interval_extra;
    }

    public final long getFreezeLastTime() {
        return this.freezeLastTime;
    }

    public final int getFreezetime() {
        return this.freezetime;
    }

    public final Map<String, Object> getFsRewardMap() {
        return this.fsRewardMap;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final boolean getHasReportExpose() {
        return this.hasReportExpose;
    }

    public final int getHighPrioritySwitch() {
        return this.highPrioritySwitch;
    }

    public final String getHwDownBtnTag() {
        return this.hwDownBtnTag;
    }

    public final String getIndentityid() {
        return this.indentityid;
    }

    public final JSONObject getInteractSettings() {
        return this.interactSettings;
    }

    public final int getInteractiveStatus() {
        return this.interactiveStatus;
    }

    public final int getInteractiveType() {
        return this.interactiveType;
    }

    public final String getInventoryId() {
        return this.inventoryId;
    }

    public final long getLoadAdTime() {
        return this.loadAdTime;
    }

    public final SPMaterialModel getMaterialModel() {
        return this.materialModel;
    }

    public final int getNativeAdImgHeight() {
        return this.nativeAdImgHeight;
    }

    public final int getNativeAdImgWidth() {
        return this.nativeAdImgWidth;
    }

    public final boolean getNativeDownClickDone() {
        return this.nativeDownClickDone;
    }

    public final List<View> getNativeDownClickViews() {
        return this.nativeDownClickViews;
    }

    public final BaseNativeView getNativeView() {
        return this.nativeView;
    }

    public final String getNestSid() {
        return this.nestSid;
    }

    /* JADX INFO: renamed from: getNotificationSent$core_release, reason: from getter */
    public final boolean getNotificationSent() {
        return this.notificationSent;
    }

    public final View getOppoDescView() {
        return this.oppoDescView;
    }

    public final View getOppoPermissionsView() {
        return this.oppoPermissionsView;
    }

    public final View getOppoPrivacyView() {
        return this.oppoPrivacyView;
    }

    public final int getPauseIcon() {
        return this.pauseIcon;
    }

    public final int getPopRequestTime() {
        return this.popRequestTime;
    }

    public final PopShowListener getPopshowListener() {
        return this.popshowListener;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getPreRequest() {
        return this.preRequest;
    }

    public final int getPriceResponse() {
        return this.priceResponse;
    }

    public final int getPriceSwitch() {
        return this.priceSwitch;
    }

    public final int getPrimeRitSwitch() {
        return this.primeRitSwitch;
    }

    public final int getRatio() {
        return this.ratio;
    }

    public final int getRenderStyle() {
        return this.renderStyle;
    }

    public final int getRequestFailReason() {
        return this.requestFailReason;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getRespbtnwd() {
        return this.respbtnwd;
    }

    public final InnerRewardShowListener getRewardShowListener() {
        return this.rewardShowListener;
    }

    public final int getRoundResId() {
        return this.roundResId;
    }

    public final String getSdkFrom() {
        return this.sdkFrom;
    }

    /* JADX INFO: renamed from: getSecondAdCost$core_release, reason: from getter */
    public final int getSecondAdCost() {
        return this.secondAdCost;
    }

    public final SensitiveInfo getSensitiveInfo() {
        return this.sensitiveInfo;
    }

    public final int getShakeSwitch() {
        return this.shakeSwitch;
    }

    public final int getShakeSwitchLxad() {
        return this.shakeSwitchLxad;
    }

    public final int getShowAdButtonTime() {
        return this.showAdButtonTime;
    }

    public final int getShowAdCardTime() {
        return this.showAdCardTime;
    }

    public final String getShowbtnwd() {
        return this.showbtnwd;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final View getSplashBottomArea() {
        return this.splashBottomArea;
    }

    public final View getSplashHuaweiView() {
        return this.splashHuaweiView;
    }

    public final SplashShowListener getSplashShowListener() {
        return this.splashShowListener;
    }

    public final View getSplashView() {
        return this.splashView;
    }

    public final String getStartegyTaiChi() {
        return this.startegyTaiChi;
    }

    public final String getStrategyId() {
        return this.strategyId;
    }

    public final AbsStrategy getStrategyListener() {
        return this.strategyListener;
    }

    public final String getStrategyVer() {
        return this.strategyVer;
    }

    public final Object getTag(String key) {
        return this.tags.get(key);
    }

    public final int getTimeOut() {
        return this.timeOut;
    }

    public final SPTimeOutListener getTimeOutListener() {
        return this.timeOutListener;
    }

    public final AtomicBoolean getTimeOutOrResEd() {
        return this.timeOutOrResEd;
    }

    public final Runnable getTimeoutRunnable() {
        return this.timeoutRunnable;
    }

    public final String getTiming() {
        return this.timing;
    }

    public final String getUseRequestId() {
        return this.useRequestId;
    }

    public final VideoAdListener getVideoAdListener() {
        return this.videoAdListener;
    }

    public final boolean getVideoCached() {
        return this.videoCached;
    }

    public final int getWhiteAd() {
        return this.whiteAd;
    }

    public final boolean getWinner() {
        return this.winner;
    }

    public final int getWipeScreenExtra() {
        return this.wipeScreenExtra;
    }

    public final Boolean getZhiboAd() {
        return this.zhiboAd;
    }

    /* JADX INFO: renamed from: isGroupMode, reason: from getter */
    public final boolean getIsGroupMode() {
        return this.isGroupMode;
    }

    /* JADX INFO: renamed from: isNativeAd, reason: from getter */
    public final boolean getIsNativeAd() {
        return this.isNativeAd;
    }

    /* JADX INFO: renamed from: isRewardVerify, reason: from getter */
    public final boolean getIsRewardVerify() {
        return this.isRewardVerify;
    }

    public final void sendLossNotification$core_release(boolean timeout, int maxPrice) {
        if (this.notificationSent) {
            return;
        }
        String str = "======send loss notification for " + this;
        if (timeout) {
            maxPrice = 0;
        }
        if (!Intrinsics.areEqual(this.adType, SDKAlias.GDT.getType())) {
            if (!Intrinsics.areEqual(this.adType, SDKAlias.CSJ.getType())) {
                if (Intrinsics.areEqual(this.adType, SDKAlias.FEISUO.getType())) {
                    Object obj = this.adData;
                    if (obj instanceof IFission) {
                        if (obj == null) {
                            throw new TypeCastException("null cannot be cast to non-null type com.zm.fissionsdk.api.interfaces.IFission");
                        }
                        ((IFission) obj).onBidFail(String.valueOf(maxPrice), "");
                        this.notificationSent = true;
                        return;
                    }
                    return;
                }
                return;
            }
            String str2 = timeout ? "2" : "102";
            Object obj2 = this.adData;
            if (obj2 instanceof TTClientBidding) {
                if (obj2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.sdk.openadsdk.TTClientBidding");
                }
                TTClientBidding tTClientBidding = (TTClientBidding) obj2;
                WifiLog.d(str);
                if (!timeout) {
                    tTClientBidding.setPrice(Double.valueOf(maxPrice));
                }
                tTClientBidding.loss(Double.valueOf(maxPrice), str2, null);
                this.notificationSent = true;
                return;
            }
            return;
        }
        Object obj3 = this.adData;
        if (obj3 instanceof LiteAbstractAD) {
            if (obj3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.LiteAbstractAD<*>");
            }
            LiteAbstractAD liteAbstractAD = (LiteAbstractAD) obj3;
            if (liteAbstractAD.getECPM() > 0) {
                WifiLog.d(str);
                liteAbstractAD.sendLossNotification(maxPrice, 1, "");
                this.notificationSent = true;
                return;
            }
            return;
        }
        if (obj3 instanceof NativeUnifiedADData) {
            if (obj3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.nativ.NativeUnifiedADData");
            }
            NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) obj3;
            if (nativeUnifiedADData.getECPM() > 0) {
                WifiLog.d(str);
                nativeUnifiedADData.sendLossNotification(maxPrice, 1, "");
                this.notificationSent = true;
                return;
            }
            return;
        }
        if (obj3 instanceof NativeExpressADView) {
            if (obj3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.nativ.NativeExpressADView");
            }
            NativeExpressADView nativeExpressADView = (NativeExpressADView) obj3;
            if (nativeExpressADView.getECPM() > 0) {
                WifiLog.d(str);
                nativeExpressADView.sendLossNotification(maxPrice, 1, "");
                this.notificationSent = true;
            }
        }
    }

    public final void sendWinNotification$core_release() {
        if (this.notificationSent) {
            return;
        }
        String str = "======send win notification for " + this;
        if (Intrinsics.areEqual(this.adType, SDKAlias.GDT.getType())) {
            Object obj = this.adData;
            if (obj instanceof LiteAbstractAD) {
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.LiteAbstractAD<*>");
                }
                LiteAbstractAD liteAbstractAD = (LiteAbstractAD) obj;
                if (liteAbstractAD.getECPM() > 0) {
                    WifiLog.d(str);
                    liteAbstractAD.sendWinNotification(this.adCost);
                    this.notificationSent = true;
                    return;
                }
                return;
            }
            if (obj instanceof NativeUnifiedADData) {
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.nativ.NativeUnifiedADData");
                }
                NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) obj;
                if (nativeUnifiedADData.getECPM() > 0) {
                    WifiLog.d(str);
                    nativeUnifiedADData.sendWinNotification(this.adCost);
                    this.notificationSent = true;
                    return;
                }
                return;
            }
            if (obj instanceof NativeExpressADView) {
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.nativ.NativeExpressADView");
                }
                NativeExpressADView nativeExpressADView = (NativeExpressADView) obj;
                if (nativeExpressADView.getECPM() > 0) {
                    WifiLog.d(str);
                    nativeExpressADView.sendWinNotification(this.adCost);
                    this.notificationSent = true;
                    return;
                }
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(this.adType, SDKAlias.KS.getType())) {
            if (!Intrinsics.areEqual(this.adType, SDKAlias.CSJ.getType())) {
                if (Intrinsics.areEqual(this.adType, SDKAlias.FEISUO.getType())) {
                    Object obj2 = this.adData;
                    if (obj2 instanceof IFission) {
                        if (obj2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type com.zm.fissionsdk.api.interfaces.IFission");
                        }
                        ((IFission) obj2).onBidSuccess(String.valueOf(this.adCost));
                        this.notificationSent = true;
                        return;
                    }
                    return;
                }
                return;
            }
            Object obj3 = this.adData;
            if (obj3 instanceof TTClientBidding) {
                if (obj3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.sdk.openadsdk.TTClientBidding");
                }
                TTClientBidding tTClientBidding = (TTClientBidding) obj3;
                WifiLog.d(str);
                tTClientBidding.setPrice(Double.valueOf(this.adCost));
                tTClientBidding.win(Double.valueOf(this.adCost));
                this.notificationSent = true;
                return;
            }
            return;
        }
        Object obj4 = this.adData;
        if (obj4 instanceof KsNativeAd) {
            if (obj4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.kwad.sdk.api.KsNativeAd");
            }
            KsNativeAd ksNativeAd = (KsNativeAd) obj4;
            if (ksNativeAd.getECPM() > 0) {
                WifiLog.d(str);
                ksNativeAd.setBidEcpm(this.adCost);
                this.notificationSent = true;
                return;
            }
            return;
        }
        if (obj4 instanceof KsDrawAd) {
            if (obj4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.kwad.sdk.api.KsDrawAd");
            }
            KsDrawAd ksDrawAd = (KsDrawAd) obj4;
            if (ksDrawAd.getECPM() > 0) {
                WifiLog.d(str);
                ksDrawAd.setBidEcpm(this.adCost);
                this.notificationSent = true;
                return;
            }
            return;
        }
        if (obj4 instanceof KsFeedAd) {
            if (obj4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.kwad.sdk.api.KsFeedAd");
            }
            KsFeedAd ksFeedAd = (KsFeedAd) obj4;
            if (ksFeedAd.getECPM() > 0) {
                WifiLog.d(str);
                ksFeedAd.setBidEcpm(this.adCost);
                this.notificationSent = true;
                return;
            }
            return;
        }
        if (obj4 instanceof KsRewardVideoAd) {
            if (obj4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.kwad.sdk.api.KsRewardVideoAd");
            }
            KsRewardVideoAd ksRewardVideoAd = (KsRewardVideoAd) obj4;
            if (ksRewardVideoAd.getECPM() > 0) {
                WifiLog.d(str);
                ksRewardVideoAd.setBidEcpm(this.adCost);
                this.notificationSent = true;
                return;
            }
            return;
        }
        if (obj4 instanceof KsInterstitialAd) {
            if (obj4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.kwad.sdk.api.KsInterstitialAd");
            }
            KsInterstitialAd ksInterstitialAd = (KsInterstitialAd) obj4;
            if (ksInterstitialAd.getECPM() > 0) {
                WifiLog.d(str);
                ksInterstitialAd.setBidEcpm(this.adCost);
                this.notificationSent = true;
            }
        }
    }

    public final void setAdAppDeveloperName(String str) {
        this.adAppDeveloperName = str;
    }

    public final void setAdAppFunctionDescUrl(String str) {
        this.adAppFunctionDescUrl = str;
    }

    public final void setAdAppName(String str) {
        this.adAppName = str;
    }

    public final void setAdAppPermissionsUrl(String str) {
        this.adAppPermissionsUrl = str;
    }

    public final void setAdAppPrivacyUrl(String str) {
        this.adAppPrivacyUrl = str;
    }

    public final void setAdAppVersion(String str) {
        this.adAppVersion = str;
    }

    public final void setAdCode(String str) {
        this.adCode = str;
    }

    public final void setAdCost(int i) {
        this.adCost = i;
    }

    public final void setAdCostType(int i) {
        this.adCostType = i;
    }

    public final void setAdData(Object obj) {
        this.adData = obj;
    }

    public final void setAdDispatchEd(Boolean bool) {
        this.adDispatchEd = bool;
    }

    public final void setAdDownTextView(View view) {
        this.adDownTextView = view;
    }

    public final void setAdId(String str) {
        this.adId = str;
    }

    public final void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        this.adInteractionListener = adInteractionListener;
    }

    public final void setAdLevel(Integer num) {
        this.adLevel = num;
    }

    public final void setAdLevelName(String str) {
        this.adLevelName = str;
    }

    public final void setAdLoadedListener1(Object obj) {
        this.adLoadedListener1 = obj;
    }

    public final void setAdLoadedListener2(Object obj) {
        this.adLoadedListener2 = obj;
    }

    public final void setAdLoadedListener3(Object obj) {
        this.adLoadedListener3 = obj;
    }

    public final void setAdName(String str) {
        this.adName = str;
    }

    public final void setAdParams(AdParams adParams) {
        this.adParams = adParams;
    }

    public final void setAdRealLevelName(String str) {
        this.adRealLevelName = str;
    }

    public final void setAdRenderListener(AdRenderListener adRenderListener) {
        this.adRenderListener = adRenderListener;
    }

    public final void setAdSPStrategy(boolean z) {
        this.adSPStrategy = z;
    }

    public final void setAdScene(int i) {
        this.adScene = i;
    }

    public final void setAdStrategyOptimizeSwitch(int i) {
        this.adStrategyOptimizeSwitch = i;
    }

    public final void setAdType(String str) {
        this.adType = str;
    }

    public final void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public final void setAdxType(int i) {
        this.adxType = i;
    }

    public final void setAppDownloadListener(AppDownloadListener appDownloadListener) {
        this.appDownloadListener = appDownloadListener;
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setAppKey(String str) {
        this.appKey = str;
    }

    public final void setBlockAd(int i) {
        this.blockAd = i;
    }

    public final void setCacheCount(int i) {
        this.cacheCount = i;
    }

    public final void setCacheSec(int i) {
        this.cacheSec = i;
    }

    public final void setCfgfrom(String str) {
        this.cfgfrom = str;
    }

    public final void setChangeAdBtnColorTime(int i) {
        this.changeAdBtnColorTime = i;
    }

    public final void setChangeType(int i) {
        this.changeType = i;
    }

    public final void setCreateRequestId(String str) {
        this.createRequestId = str;
    }

    public final void setCsjSplashSkipEd(AtomicBoolean atomicBoolean) {
        this.csjSplashSkipEd = atomicBoolean;
    }

    public final void setCurGroupNum(int i) {
        this.curGroupNum = i;
    }

    public final void setDiscountInfo(String str) {
        this.discountInfo = str;
    }

    public final void setDislikeListener(DislikeListener dislikeListener) {
        this.dislikeListener = dislikeListener;
    }

    public final void setDownloadStatus(int i) {
        this.downloadStatus = i;
    }

    public final void setDspId(int i) {
        this.dspId = i;
    }

    public final void setDspName(String str) {
        this.dspName = str;
    }

    public final void setEcpmLevelMap(List<WkAdMutliPrice> list) {
        this.ecpmLevelMap = list;
    }

    public final void setEcpmLowPrice(int i) {
        this.ecpmLowPrice = i;
    }

    public final void setEcpmMap(HashMap<String, Integer> map) {
        this.ecpmMap = map;
    }

    public final void setEcpmRatio(float f) {
        this.ecpmRatio = f;
    }

    public final void setFailedMsg(String str) {
        this.failedMsg = str;
    }

    public final void setFixed_interval_extra(int i) {
        this.fixed_interval_extra = i;
    }

    public final void setFreezeLastTime(long j) {
        this.freezeLastTime = j;
    }

    public final void setFreezetime(int i) {
        this.freezetime = i;
    }

    public final void setFsRewardMap(Map<String, ? extends Object> map) {
        this.fsRewardMap = map;
    }

    public final void setGroupId(int i) {
        this.groupId = i;
    }

    public final void setGroupMode(boolean z) {
        this.isGroupMode = z;
    }

    public final void setHasReportExpose(boolean z) {
        this.hasReportExpose = z;
    }

    public final void setHighPrioritySwitch(int i) {
        this.highPrioritySwitch = i;
    }

    public final void setHwDownBtnTag(String str) {
        this.hwDownBtnTag = str;
    }

    public final void setIndentityid(String str) {
        this.indentityid = str;
    }

    public final void setInteractSettings(JSONObject jSONObject) {
        this.interactSettings = jSONObject;
    }

    public final void setInteractiveStatus(int i) {
        this.interactiveStatus = i;
    }

    public final void setInteractiveType(int i) {
        this.interactiveType = i;
    }

    public final void setInventoryId(String str) {
        this.inventoryId = str;
    }

    public final void setLoadAdTime(long j) {
        this.loadAdTime = j;
    }

    public final void setMaterialModel(SPMaterialModel sPMaterialModel) {
        this.materialModel = sPMaterialModel;
    }

    public final void setNativeAd(boolean z) {
        this.isNativeAd = z;
    }

    public final void setNativeAdImgHeight(int i) {
        this.nativeAdImgHeight = i;
    }

    public final void setNativeAdImgWidth(int i) {
        this.nativeAdImgWidth = i;
    }

    public final void setNativeDownClickDone(boolean z) {
        this.nativeDownClickDone = z;
    }

    public final void setNativeDownClickViews(List<View> list) {
        this.nativeDownClickViews = list;
    }

    public final void setNativeView(BaseNativeView baseNativeView) {
        this.nativeView = baseNativeView;
    }

    public final void setNestSid(String str) {
        this.nestSid = str;
    }

    public final void setNotificationSent$core_release(boolean z) {
        this.notificationSent = z;
    }

    public final void setOppoDescView(View view) {
        this.oppoDescView = view;
    }

    public final void setOppoPermissionsView(View view) {
        this.oppoPermissionsView = view;
    }

    public final void setOppoPrivacyView(View view) {
        this.oppoPrivacyView = view;
    }

    public final void setPauseIcon(int i) {
        this.pauseIcon = i;
    }

    public final void setPopRequestTime(int i) {
        this.popRequestTime = i;
    }

    public final void setPopshowListener(PopShowListener popShowListener) {
        this.popshowListener = popShowListener;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setPreRequest(int i) {
        this.preRequest = i;
    }

    public final void setPriceResponse(int i) {
        this.priceResponse = i;
    }

    public final void setPriceSwitch(int i) {
        this.priceSwitch = i;
    }

    public final void setPrimeRitSwitch(int i) {
        this.primeRitSwitch = i;
    }

    public final void setRatio(int i) {
        this.ratio = i;
    }

    public final void setRenderStyle(int i) {
        this.renderStyle = i;
    }

    public final void setRequestFailReason(int i) {
        this.requestFailReason = i;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final void setRespbtnwd(String str) {
        this.respbtnwd = str;
    }

    public final void setRewardShowListener(InnerRewardShowListener innerRewardShowListener) {
        this.rewardShowListener = innerRewardShowListener;
    }

    public final void setRewardVerify(boolean z) {
        this.isRewardVerify = z;
    }

    public final void setRoundResId(int i) {
        this.roundResId = i;
    }

    public final void setSdkFrom(String str) {
        this.sdkFrom = str;
    }

    public final void setSecondAdCost$core_release(int i) {
        this.secondAdCost = i;
    }

    public final void setSensitiveInfo(SensitiveInfo sensitiveInfo) {
        this.sensitiveInfo = sensitiveInfo;
    }

    public final void setShakeSwitch(int i) {
        this.shakeSwitch = i;
    }

    public final void setShakeSwitchLxad(int i) {
        this.shakeSwitchLxad = i;
    }

    public final void setShowAdButtonTime(int i) {
        this.showAdButtonTime = i;
    }

    public final void setShowAdCardTime(int i) {
        this.showAdCardTime = i;
    }

    public final void setShowbtnwd(String str) {
        this.showbtnwd = str;
    }

    public final void setSourceId(String str) {
        this.sourceId = str;
    }

    public final void setSplashBottomArea(View view) {
        this.splashBottomArea = view;
    }

    public final void setSplashHuaweiView(View view) {
        this.splashHuaweiView = view;
    }

    public final void setSplashShowListener(SplashShowListener splashShowListener) {
        this.splashShowListener = splashShowListener;
    }

    public final void setSplashView(View view) {
        this.splashView = view;
    }

    public final void setStartegyTaiChi(String str) {
        this.startegyTaiChi = str;
    }

    public final void setStrategyId(String str) {
        this.strategyId = str;
    }

    public final void setStrategyListener(AbsStrategy absStrategy) {
        this.strategyListener = absStrategy;
    }

    public final void setStrategyVer(String str) {
        this.strategyVer = str;
    }

    public final void setTag(String key, Object tag) {
        this.tags.put(key, tag);
    }

    public final void setTimeOut(int i) {
        this.timeOut = i;
    }

    public final void setTimeOutListener(SPTimeOutListener sPTimeOutListener) {
        this.timeOutListener = sPTimeOutListener;
    }

    public final void setTimeOutOrResEd(AtomicBoolean atomicBoolean) {
        this.timeOutOrResEd = atomicBoolean;
    }

    public final void setTimeoutRunnable(Runnable runnable) {
        this.timeoutRunnable = runnable;
    }

    public final void setTiming(String str) {
        this.timing = str;
    }

    public final void setUseRequestId(String str) {
        this.useRequestId = str;
    }

    public final void setVideoAdListener(VideoAdListener videoAdListener) {
        this.videoAdListener = videoAdListener;
    }

    public final void setVideoCached(boolean z) {
        this.videoCached = z;
    }

    public final void setWhiteAd(int i) {
        this.whiteAd = i;
    }

    public final void setWinner(boolean z) {
        this.winner = z;
    }

    public final void setWipeScreenExtra(int i) {
        this.wipeScreenExtra = i;
    }

    public final void setZhiboAd(Boolean bool) {
        this.zhiboAd = bool;
    }

    public final boolean supportAdLogo() {
        return Intrinsics.areEqual(this.adType, SDKAlias.GDT.getType()) || Intrinsics.areEqual(this.adType, SDKAlias.CSJ.getType()) || Intrinsics.areEqual(this.adType, SDKAlias.KS.getType()) || Intrinsics.areEqual(this.adType, SDKAlias.LXAD.getType()) || Intrinsics.areEqual(this.adType, SDKAlias.OPPO.getType()) || Intrinsics.areEqual(this.adType, SDKAlias.HUAWEI.getType()) || Intrinsics.areEqual(this.adType, SDKAlias.BEIZI.getType()) || Intrinsics.areEqual(this.adType, SDKAlias.FEISUO.getType());
    }

    public final String toJsonString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adCode", this.adCode);
        jSONObject.put("adLevelName", this.adLevelName);
        jSONObject.put("adRealLevelName", this.adRealLevelName);
        jSONObject.put("adLevel", this.adLevel);
        jSONObject.put("adType", this.adType);
        jSONObject.put("adCost", this.adCost);
        jSONObject.put("failedMsg", this.failedMsg);
        jSONObject.put("dspName", this.dspName);
        jSONObject.put("sdkFrom", this.sdkFrom);
        jSONObject.put("nestSid", this.nestSid);
        jSONObject.put("adAppName", this.adAppName);
        jSONObject.put("adAppDeveloperName", this.adAppDeveloperName);
        jSONObject.put("adAppVersion", this.adAppVersion);
        jSONObject.put("adAppPermissionsUrl", this.adAppPermissionsUrl);
        jSONObject.put("adAppPrivacyUrl", this.adAppPrivacyUrl);
        jSONObject.put("hasReportExpose", this.hasReportExpose);
        String string = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "resObject.toString()");
        return string;
    }

    public String toString() {
        return "NestAdData(adCode=" + this.adCode + ", adLevelName=" + this.adLevelName + ", adRealLevelName=" + this.adRealLevelName + ", adLevel=" + this.adLevel + ", adType=" + this.adType + ", adData=" + this.adData + ", adCost=" + this.adCost + ", secondAdCost=" + this.secondAdCost + ", failedMsg=" + this.failedMsg + ", dspName=" + this.dspName + ", sdkFrom=" + this.sdkFrom + ", appId=" + this.appId + ", nestSid=" + this.nestSid + ", showAdButtonTime=" + this.showAdButtonTime + ", changeAdBtnColorTime=" + this.changeAdBtnColorTime + ", showAdCardTime=" + this.showAdCardTime + ", position=" + this.position + ", pauseIcon=" + this.pauseIcon + ", renderStyle=" + this.renderStyle + ", hasReportExpose=" + this.hasReportExpose + ')';
    }
}
