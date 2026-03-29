package com.wifi.ad.core;

import android.content.Context;
import android.graphics.Point;
import com.igexin.push.core.b;
import com.wifi.WkInitManager;
import com.wifi.ad.core.SdkPrivilegeController;
import com.wifi.ad.core.callback.AdRequestCallBack;
import com.wifi.ad.core.callback.CsjInitCallBack;
import com.wifi.ad.core.callback.LXReqHttpCallBack;
import com.wifi.ad.core.callback.RealLocationCallBack;
import com.wifi.ad.core.config.AdSDKConfigUtil;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.config.SDKConfig;
import com.wifi.ad.core.config.adx.all.WkAdxAllAdConfigMg;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.helper.AdHelperDrawVideo;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.helper.AdHelperReward;
import com.wifi.ad.core.helper.AdHelperSplash;
import com.wifi.ad.core.imageloader.DefaultImageLoader;
import com.wifi.ad.core.imageloader.IImageLoader;
import com.wifi.ad.core.listener.IAdSensitiveTaker;
import com.wifi.ad.core.monitor.WkAdConfigManager;
import com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigManager;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.AbstractReporter;
import com.wifi.ad.core.sensitive.NestInfoSupplier;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.spstrategy.all.SPAdAllConfigMg;
import com.wifi.ad.core.utils.AdRandomUtil;
import com.wifi.ad.core.utils.Async;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.adsdk.download.LxAdDLManager;
import com.wifi.beizi.ad.NestBeiziManager;
import com.wifi.csj.ad.NestCsjManager;
import com.wifi.feisuo.ad.NestFeiSuoManager;
import com.wifi.gdt.ad.NestGdtManager;
import com.wifi.huawei.ad.NestHuaweiManager;
import com.wifi.ks.ad.NestKsManager;
import com.wifi.lxad.ad.NestLxAdManager;
import com.wifi.oppo.ad.NestOppoManager;
import com.wifi.self.ad.NestWifiManager;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.apache.cordova.jssdk.general.Action;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u009c\u0001\u001a\u00020\u00002\u0014\u0010\u009d\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020'0\u009e\u0001\"\u00020'¢\u0006\u0003\u0010\u009f\u0001J\b\u0010 \u0001\u001a\u00030¡\u0001J\b\u0010¢\u0001\u001a\u00030£\u0001J\b\u0010¤\u0001\u001a\u00030¥\u0001J\b\u0010¦\u0001\u001a\u00030§\u0001J\u0012\u0010¨\u0001\u001a\u00030©\u00012\b\u0010ª\u0001\u001a\u00030«\u0001J\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0004J\n\u0010\u00ad\u0001\u001a\u00030¡\u0001H\u0007J\u0007\u0010®\u0001\u001a\u00020FJ\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u0004J$\u0010°\u0001\u001a\u0004\u0018\u00010\u00012\f\u0010±\u0001\u001a\u0007\u0012\u0002\b\u00030²\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010´\u0001\u001a\u00030©\u00012\b\u0010µ\u0001\u001a\u00030¶\u0001J'\u0010·\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u009d\u0001\u001a\u00020'2\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010¸\u0001\u001a\u00020\u0004H\u0002J\u0013\u0010¹\u0001\u001a\u00020\u001a2\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0002J-\u0010º\u0001\u001a\u00020\u00042\u0007\u0010\u009d\u0001\u001a\u00020'2\b\u0010µ\u0001\u001a\u00030¶\u00012\u0006\u0010G\u001a\u00020H2\u0007\u0010¸\u0001\u001a\u00020\u0004H\u0002J'\u0010»\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u009d\u0001\u001a\u00020'2\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010¸\u0001\u001a\u00020\u0004H\u0002J%\u0010¼\u0001\u001a\u00020\u00042\u0007\u0010\u009d\u0001\u001a\u00020'2\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010¸\u0001\u001a\u00020\u0004H\u0002J%\u0010½\u0001\u001a\u00020\u00042\u0007\u0010\u009d\u0001\u001a\u00020'2\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010¸\u0001\u001a\u00020\u0004H\u0002J%\u0010¾\u0001\u001a\u00020\u00042\u0007\u0010\u009d\u0001\u001a\u00020'2\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010¸\u0001\u001a\u00020\u0004H\u0002J'\u0010¿\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u009d\u0001\u001a\u00020'2\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010¸\u0001\u001a\u00020\u0004H\u0002J'\u0010À\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u009d\u0001\u001a\u00020'2\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010¸\u0001\u001a\u00020\u0004H\u0002J\u001d\u0010Á\u0001\u001a\u00030©\u00012\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010¸\u0001\u001a\u00020\u0004H\u0002J\u0012\u0010Â\u0001\u001a\u00030©\u00012\b\u0010µ\u0001\u001a\u00030¶\u0001J\u0014\u0010Ã\u0001\u001a\u00030©\u00012\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0002J\u0011\u0010Ä\u0001\u001a\u00030©\u00012\u0007\u0010Å\u0001\u001a\u00020\u0004J%\u0010Æ\u0001\u001a\u00020\u00042\u0007\u0010\u009d\u0001\u001a\u00020'2\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010¸\u0001\u001a\u00020\u0004H\u0002J8\u0010Ç\u0001\u001a\u00030©\u00012\u000e\u0010È\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010²\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010\u009d\u0001\u001a\u00020'H\u0002J@\u0010É\u0001\u001a\u00030©\u00012\u000e\u0010Ê\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010²\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010µ\u0001\u001a\u00030¶\u00012\u0006\u0010G\u001a\u00020H2\u0007\u0010\u009d\u0001\u001a\u00020'H\u0002J8\u0010Ë\u0001\u001a\u00030©\u00012\u000e\u0010Ì\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010²\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010\u009d\u0001\u001a\u00020'H\u0002J8\u0010Í\u0001\u001a\u00030©\u00012\u000e\u0010Î\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010²\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010\u009d\u0001\u001a\u00020'H\u0002J8\u0010Ï\u0001\u001a\u00030©\u00012\u000e\u0010Ð\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010²\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010\u009d\u0001\u001a\u00020'H\u0002J8\u0010Ñ\u0001\u001a\u00030©\u00012\u000e\u0010Ò\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010²\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010\u009d\u0001\u001a\u00020'H\u0002J8\u0010Ó\u0001\u001a\u00030©\u00012\u000e\u0010Ô\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010²\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010\u009d\u0001\u001a\u00020'H\u0002J8\u0010Õ\u0001\u001a\u00030©\u00012\u000e\u0010Ö\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010²\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010\u009d\u0001\u001a\u00020'H\u0002J\u0007\u0010×\u0001\u001a\u00020\u001aJ\b\u0010Ø\u0001\u001a\u00030©\u0001J\u0013\u0010Ù\u0001\u001a\u00030©\u00012\u0007\u0010Ú\u0001\u001a\u00020\u0004H\u0002J\u0014\u0010Û\u0001\u001a\u00030©\u00012\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0002J\u0014\u0010Ü\u0001\u001a\u00030©\u00012\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0002J\u0014\u0010Ý\u0001\u001a\u00030©\u00012\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0002J\u0014\u0010Þ\u0001\u001a\u00030©\u00012\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0002J\u000f\u0010ß\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010à\u0001\u001a\u00020\u00002\u0007\u0010á\u0001\u001a\u00020\\J\u0010\u0010â\u0001\u001a\u00020\u00002\u0007\u0010ã\u0001\u001a\u00020\u0004J\u001b\u0010ä\u0001\u001a\u00030©\u00012\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010å\u0001\u001a\u00020\u001aJ\u0010\u0010æ\u0001\u001a\u00020\u00002\u0007\u0010Ú\u0001\u001a\u00020\u0004J\u0010\u0010ç\u0001\u001a\u00020\u00002\u0007\u0010á\u0001\u001a\u00020HJ\u001c\u0010è\u0001\u001a\u00020\u00002\t\b\u0002\u0010é\u0001\u001a\u00020\u001a2\b\b\u0002\u0010P\u001a\u00020\u001aJ\u000f\u0010ê\u0001\u001a\u00020\u00002\u0006\u0010s\u001a\u00020tJ\u0010\u0010ë\u0001\u001a\u00020\u00002\u0007\u0010ì\u0001\u001a\u00020FJ\u0010\u0010í\u0001\u001a\u00020\u00002\u0007\u0010á\u0001\u001a\u00020:J\u0010\u0010î\u0001\u001a\u00020\u00002\u0007\u0010á\u0001\u001a\u00020bJ\u0010\u0010ï\u0001\u001a\u00020\u00002\u0007\u0010ð\u0001\u001a\u00020\u001aJ\u0013\u0010ñ\u0001\u001a\u00020\u00002\n\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u0001J\u0010\u0010ô\u0001\u001a\u00020\u00002\u0007\u0010õ\u0001\u001a\u00020\u001aJ\u0010\u0010ö\u0001\u001a\u00020\u00002\u0007\u0010÷\u0001\u001a\u00020\u0004J\u001c\u0010ø\u0001\u001a\u00030©\u00012\u0007\u0010ù\u0001\u001a\u00020\u001a2\u0007\u0010ú\u0001\u001a\u00020\u0004H\u0002J\u0011\u0010û\u0001\u001a\u00030©\u00012\u0007\u0010ù\u0001\u001a\u00020\u001aJ\u0013\u0010ü\u0001\u001a\u00030©\u00012\u0007\u0010ù\u0001\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001a\u0010+\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR\u001a\u0010.\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001a\u00106\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001eR\u001a\u00109\u001a\u00020:X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001c\"\u0004\bA\u0010\u001eR\u001a\u0010B\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001c\"\u0004\bD\u0010\u001eR\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u00020HX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001e\u0010N\u001a\u00020\u001a2\u0006\u0010M\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u001cR\u000e\u0010O\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001c\"\u0004\bQ\u0010\u001eR\u001a\u0010R\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u001c\"\u0004\bT\u0010\u001eR\u001a\u0010U\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u001c\"\u0004\bW\u0010\u001eR\u001a\u0010X\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u00100\"\u0004\bZ\u00102R\u001c\u0010[\u001a\u0004\u0018\u00010\\X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001c\u0010a\u001a\u0004\u0018\u00010bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001a\u0010g\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u001c\"\u0004\bi\u0010\u001eR\u001a\u0010j\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u001c\"\u0004\bl\u0010\u001eR\u001a\u0010m\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u001c\"\u0004\bo\u0010\u001eR\u001a\u0010p\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u001c\"\u0004\br\u0010\u001eR\u001a\u0010s\u001a\u00020tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR7\u0010y\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020{0zj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020{`|X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u001d\u0010\u0081\u0001\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u001c\"\u0005\b\u0083\u0001\u0010\u001eR\u001d\u0010\u0084\u0001\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u001c\"\u0005\b\u0086\u0001\u0010\u001eR\u001d\u0010\u0087\u0001\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010\u001c\"\u0005\b\u0089\u0001\u0010\u001eR\u001d\u0010\u008a\u0001\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u001c\"\u0005\b\u008c\u0001\u0010\u001eR\u001f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u00100\"\u0005\b\u008f\u0001\u00102R\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\"\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001¨\u0006ý\u0001"}, d2 = {"Lcom/wifi/ad/core/WifiNestAd;", "", "()V", "BD_CLASSPATH", "", "BEIZI_CLASSPATH", "CSJ_CLASSPATH", "FEISUO_CLASSPATH", "GDT_CLASSPATH", "HUAWEI_CLASSPATH", "KS_CLASSPATH", "LXAD_CLASSPATH", "OPPO_CLASSPATH", "QUMENG_CLASSPATH", "SDK_SHENHE_BACK_DOOR_KEY", "SDK_SHENHE_SP_NAME", "WIFI_CLASSPATH", "adConfigTais", "appIds", "", "Lcom/wifi/ad/core/SDKAlias;", "getAppIds", "()Ljava/util/Map;", "setAppIds", "(Ljava/util/Map;)V", "backDoorResult", "", "getBackDoorResult", "()Z", "setBackDoorResult", "(Z)V", "bdInit", "getBdInit", "setBdInit", "beiziInit", "getBeiziInit", "setBeiziInit", "configs", "", "Lcom/wifi/ad/core/config/SDKConfig;", "csjInit", "getCsjInit", "setCsjInit", "feisuoInit", "getFeisuoInit", "setFeisuoInit", "feisuochannel", "getFeisuochannel", "()Ljava/lang/String;", "setFeisuochannel", "(Ljava/lang/String;)V", "feisuotoken", "getFeisuotoken", "setFeisuotoken", "gdtInit", "getGdtInit", "setGdtInit", "getLocationCallBack", "Lcom/wifi/ad/core/callback/RealLocationCallBack;", "getGetLocationCallBack", "()Lcom/wifi/ad/core/callback/RealLocationCallBack;", "setGetLocationCallBack", "(Lcom/wifi/ad/core/callback/RealLocationCallBack;)V", "heguiTai", "getHeguiTai", "setHeguiTai", "hwInit", "getHwInit", "setHwInit", "imageloader", "Lcom/wifi/ad/core/imageloader/IImageLoader;", "initCallBack", "Lcom/wifi/ad/core/callback/CsjInitCallBack;", "getInitCallBack", "()Lcom/wifi/ad/core/callback/CsjInitCallBack;", "setInitCallBack", "(Lcom/wifi/ad/core/callback/CsjInitCallBack;)V", "<set-?>", "isCatchThirdInfo", "isDebug", "isDebugUrl", "setDebugUrl", "ksInit", "getKsInit", "setKsInit", "lxAdInit", "getLxAdInit", "setLxAdInit", "lxadtoken", "getLxadtoken", "setLxadtoken", "mAdRequestCallBack", "Lcom/wifi/ad/core/callback/AdRequestCallBack;", "getMAdRequestCallBack", "()Lcom/wifi/ad/core/callback/AdRequestCallBack;", "setMAdRequestCallBack", "(Lcom/wifi/ad/core/callback/AdRequestCallBack;)V", "mLxRequestCallBack", "Lcom/wifi/ad/core/callback/LXReqHttpCallBack;", "getMLxRequestCallBack", "()Lcom/wifi/ad/core/callback/LXReqHttpCallBack;", "setMLxRequestCallBack", "(Lcom/wifi/ad/core/callback/LXReqHttpCallBack;)V", "mPersonalizedAd", "getMPersonalizedAd", "setMPersonalizedAd", "newRequestUrl", "getNewRequestUrl", "setNewRequestUrl", "oppoInit", "getOppoInit", "setOppoInit", "qumengInit", "getQumengInit", "setQumengInit", "reporter", "Lcom/wifi/ad/core/reporter/AbstractReporter;", "getReporter", "()Lcom/wifi/ad/core/reporter/AbstractReporter;", "setReporter", "(Lcom/wifi/ad/core/reporter/AbstractReporter;)V", "sdkPrivilegeControllerS", "Ljava/util/HashMap;", "Lcom/wifi/ad/core/SdkPrivilegeController;", "Lkotlin/collections/HashMap;", "getSdkPrivilegeControllerS", "()Ljava/util/HashMap;", "setSdkPrivilegeControllerS", "(Ljava/util/HashMap;)V", "switch315", "getSwitch315", "setSwitch315", "switch58414", "getSwitch58414", "setSwitch58414", "switch70647", "getSwitch70647", "setSwitch70647", "switch77583", "getSwitch77583", "setSwitch77583", "taiChikeys", "getTaiChikeys$core_release", "setTaiChikeys$core_release", "wmPoint", "Landroid/graphics/Point;", "getWmPoint", "()Landroid/graphics/Point;", "setWmPoint", "(Landroid/graphics/Point;)V", "wxMiniProgramListener", "Lcom/wifi/ad/core/WxMiniProgramListener;", "getWxMiniProgramListener", "()Lcom/wifi/ad/core/WxMiniProgramListener;", "setWxMiniProgramListener", "(Lcom/wifi/ad/core/WxMiniProgramListener;)V", "addAdConfigs", "sdkConfig", "", "([Lcom/wifi/ad/core/config/SDKConfig;)Lcom/wifi/ad/core/WifiNestAd;", "createAdDrawVideo", "Lcom/wifi/ad/core/helper/AdHelperDrawVideo;", "createAdFeed", "Lcom/wifi/ad/core/helper/AdHelperFeed;", "createRewardAd", "Lcom/wifi/ad/core/helper/AdHelperReward;", "createSplashAd", "Lcom/wifi/ad/core/helper/AdHelperSplash;", "eventShenHeShow", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "getAdConfigTais", "getDrawVideoAd", "getImageLoader", "getTaiChikeys", "getVersion", "clazz", "Ljava/lang/Class;", "instance", "init", "context", "Landroid/content/Context;", "initBZ", "fromName", "initBackDoorBoolean", "initCsj", "initFS", "initGdt", "initHuawei", "initKs", "initLxAd", "initOppo", "initSDK", "initSDKActivity", "initSDKApp", "initSdkPrivilege", "curSdkConfigValue", "initWifi", "invokeBz", "bdClazz", "invokeCsj", "csjClazz", "invokeFs", "fsClazz", "invokeGdt", "gdtClazz", "invokeHw", "hwClazz", "invokeKs", "ksClazz", "invokeLxAd", "lxadClazz", "invokeOppo", "oppoClazz", "isDrawVideoNewStyleEnable", "onDestroy", "parseConfig", b.Y, "requestAdxAllConfig", "requestAllSpConfig", "requestConfig", "requestWhiteListConfig", "setAdConfigTais", "setAdRequestCallBack", "callBack", "setAdSDKConfig", "adSDKConfig", "setBackDoor", "result", "setConfig", "setCsjInitCallBack", "setDebug", "isDebugLog", "setEventReporter", "setImageLoader", "imageLoader", "setLoactionCallBack", "setLxRequestCallBack", "setPersonalizedAd", "personalizedAd", "setSupplier", "supplier", "Lcom/wifi/ad/core/sensitive/NestInfoSupplier;", "setSwitchAd315", "switch", "setTaiChiKeys", "keys", "updateInvokeSDKPersonAd", "enablePersonal", "sdkName", "updatePersonAd", "updateSDKPersonAd", "core_release"}, k = 1, mv = {1, 1, 16})
public final class WifiNestAd {
    private static final String BD_CLASSPATH = "com.wifi.baidu.ad.NestBdManager";
    private static final String BEIZI_CLASSPATH = "com.wifi.beizi.ad.NestBeiziManager";
    private static final String CSJ_CLASSPATH = "com.wifi.csj.ad.NestCsjManager";
    private static final String FEISUO_CLASSPATH = "com.wifi.feisuo.ad.NestFeiSuoManager";
    private static final String GDT_CLASSPATH = "com.wifi.gdt.ad.NestGdtManager";
    private static final String HUAWEI_CLASSPATH = "com.wifi.huawei.ad.NestHuaweiManager";
    private static final String KS_CLASSPATH = "com.wifi.ks.ad.NestKsManager";
    private static final String LXAD_CLASSPATH = "com.wifi.lxad.ad.NestLxAdManager";
    private static final String OPPO_CLASSPATH = "com.wifi.oppo.ad.NestOppoManager";
    private static final String QUMENG_CLASSPATH = "com.wifi.qumeng.ad.NestQuMengManager";
    private static final String WIFI_CLASSPATH = "com.wifi.self.ad.NestWifiManager";
    public static Map<SDKAlias, String> appIds;
    private static boolean backDoorResult;
    private static boolean bdInit;
    private static boolean beiziInit;
    private static boolean csjInit;
    private static boolean feisuoInit;
    private static boolean gdtInit;
    public static RealLocationCallBack getLocationCallBack;
    private static boolean heguiTai;
    private static boolean hwInit;
    private static IImageLoader imageloader;
    public static CsjInitCallBack initCallBack;
    private static boolean isDebug;
    private static boolean isDebugUrl;
    private static boolean ksInit;
    private static boolean lxAdInit;
    private static AdRequestCallBack mAdRequestCallBack;
    private static LXReqHttpCallBack mLxRequestCallBack;
    private static boolean newRequestUrl;
    private static boolean oppoInit;
    private static boolean qumengInit;
    public static AbstractReporter reporter;
    private static boolean switch315;
    private static boolean switch58414;
    private static boolean switch70647;
    private static boolean switch77583;
    private static String taiChikeys;
    private static Point wmPoint;
    private static WxMiniProgramListener wxMiniProgramListener;
    public static final WifiNestAd INSTANCE = new WifiNestAd();
    private static boolean isCatchThirdInfo = true;
    private static String lxadtoken = "";
    private static String feisuotoken = "";
    private static String feisuochannel = "";
    private static List<SDKConfig> configs = new ArrayList();
    private static String adConfigTais = "";
    private static HashMap<String, SdkPrivilegeController> sdkPrivilegeControllerS = new HashMap<>();
    private static boolean mPersonalizedAd = true;
    private static final String SDK_SHENHE_SP_NAME = "ad_sdk_shenhe_backdoor_name_sp";
    private static final String SDK_SHENHE_BACK_DOOR_KEY = "ad_sdk_back_door_key";

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SDKAlias.values().length];
            $EnumSwitchMapping$0 = iArr;
            SDKAlias sDKAlias = SDKAlias.CSJ;
            iArr[sDKAlias.ordinal()] = 1;
            SDKAlias sDKAlias2 = SDKAlias.OPPO;
            iArr[sDKAlias2.ordinal()] = 2;
            SDKAlias sDKAlias3 = SDKAlias.KS;
            iArr[sDKAlias3.ordinal()] = 3;
            SDKAlias sDKAlias4 = SDKAlias.WIFI;
            iArr[sDKAlias4.ordinal()] = 4;
            SDKAlias sDKAlias5 = SDKAlias.GDT;
            iArr[sDKAlias5.ordinal()] = 5;
            SDKAlias sDKAlias6 = SDKAlias.HUAWEI;
            iArr[sDKAlias6.ordinal()] = 6;
            SDKAlias sDKAlias7 = SDKAlias.BEIZI;
            iArr[sDKAlias7.ordinal()] = 7;
            SDKAlias sDKAlias8 = SDKAlias.FEISUO;
            iArr[sDKAlias8.ordinal()] = 8;
            SDKAlias sDKAlias9 = SDKAlias.LXAD;
            iArr[sDKAlias9.ordinal()] = 9;
            int[] iArr2 = new int[SDKAlias.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[sDKAlias.ordinal()] = 1;
            iArr2[sDKAlias2.ordinal()] = 2;
            iArr2[sDKAlias6.ordinal()] = 3;
            iArr2[sDKAlias3.ordinal()] = 4;
            iArr2[sDKAlias4.ordinal()] = 5;
            iArr2[sDKAlias5.ordinal()] = 6;
            iArr2[sDKAlias7.ordinal()] = 7;
            iArr2[sDKAlias8.ordinal()] = 8;
            iArr2[sDKAlias9.ordinal()] = 9;
        }
    }

    private WifiNestAd() {
    }

    private final Object getVersion(Class<?> clazz, Object instance) {
        Method declaredMethod;
        if (clazz != null) {
            try {
                declaredMethod = clazz.getDeclaredMethod("getVersion", new Class[0]);
            } catch (Exception unused) {
                return "";
            }
        } else {
            declaredMethod = null;
        }
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
        }
        if (declaredMethod != null) {
            return declaredMethod.invoke(instance, new Object[0]);
        }
        return null;
    }

    private final String initBZ(final SDKConfig sdkConfig, final Context context, String fromName) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        WkInitManager wkInitManager = WkInitManager.INSTANCE;
        if (!wkInitManager.allowInitSDK(fromName, "beizi")) {
            WifiLog.d("initAd initBZ not allow fromName " + fromName);
            return "";
        }
        if (!sdkConfig.getAllowInit()) {
            WifiLog.d("initAd initBZ allowInit not");
            return "";
        }
        WifiLog.d("initAd initBZ allow fromName " + fromName);
        NestBeiziManager nestBeiziManager = NestBeiziManager.INSTANCE;
        final Class<NestBeiziManager> cls = NestBeiziManager.class;
        Constructor declaredConstructor = NestBeiziManager.class.getDeclaredConstructor(new Class[0]);
        if (declaredConstructor != null) {
            declaredConstructor.setAccessible(true);
        }
        final Object objNewInstance = declaredConstructor != null ? declaredConstructor.newInstance(new Object[0]) : null;
        Field declaredField = NestBeiziManager.class.getDeclaredField("debug");
        if (declaredField != null) {
            declaredField.setAccessible(true);
        }
        if (declaredField != null) {
            declaredField.set(objNewInstance, Boolean.valueOf(isDebug));
        }
        if (wkInitManager.allowSdkTimeDelay()) {
            WifiLog.d("WkInitManager initBZ start WkInitManager.beiziDelayTime " + wkInitManager.getBeiziDelayTime());
            if (wkInitManager.getBeiziDelayTime() >= 0) {
                wkInitManager.getMainHandler().postDelayed(new Runnable() { // from class: com.wifi.ad.core.WifiNestAd.initBZ.1
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalAccessException, InvocationTargetException {
                        WifiNestAd.INSTANCE.invokeBz(cls, objNewInstance, context, sdkConfig);
                    }
                }, wkInitManager.getBeiziDelayTime());
            } else {
                if (((int) wkInitManager.getBeiziDelayTime()) != 0) {
                    return "";
                }
                invokeBz(NestBeiziManager.class, objNewInstance, context, sdkConfig);
            }
        } else {
            invokeBz(NestBeiziManager.class, objNewInstance, context, sdkConfig);
        }
        WifiLog.d("init WkInitManager initBZ SDK debug = " + isDebug + "  appId = " + sdkConfig.getAppId());
        Intrinsics.checkExpressionValueIsNotNull(NestBeiziManager.class, "bdClazz");
        Object version = getVersion(NestBeiziManager.class, objNewInstance);
        if (version != null) {
            return (String) version;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    private final boolean initBackDoorBoolean(Context context) {
        boolean z = false;
        if (context != null) {
            try {
                z = context.getSharedPreferences(SDK_SHENHE_SP_NAME, 0).getBoolean(SDK_SHENHE_BACK_DOOR_KEY, false);
                backDoorResult = z;
            } catch (Exception unused) {
            }
        }
        WifiLog.d("initBackDoorBoolean backDoorResult " + backDoorResult);
        return z;
    }

    private final String initCsj(final SDKConfig sdkConfig, final Context context, final CsjInitCallBack initCallBack2, String fromName) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        WkInitManager wkInitManager = WkInitManager.INSTANCE;
        if (!wkInitManager.allowInitSDK(fromName, "csj")) {
            WifiLog.d("initAd initCsj not allow fromName " + fromName);
            return "";
        }
        if (!sdkConfig.getAllowInit()) {
            WifiLog.d("initAd initCsj allowInit not");
            return "";
        }
        WifiLog.d("initAd initCsj allow fromName " + fromName);
        NestCsjManager nestCsjManager = NestCsjManager.INSTANCE;
        final Class<NestCsjManager> cls = NestCsjManager.class;
        Constructor declaredConstructor = NestCsjManager.class.getDeclaredConstructor(new Class[0]);
        if (declaredConstructor != null) {
            declaredConstructor.setAccessible(true);
        }
        Object objNewInstance = declaredConstructor != null ? declaredConstructor.newInstance(new Object[0]) : null;
        Field declaredField = NestCsjManager.class.getDeclaredField("debug");
        if (declaredField != null) {
            declaredField.setAccessible(true);
        }
        if (declaredField != null) {
            declaredField.set(objNewInstance, Boolean.valueOf(isDebug));
        }
        Field declaredField2 = NestCsjManager.class.getDeclaredField("asyncInit");
        if (declaredField2 != null) {
            declaredField2.setAccessible(true);
        }
        if (declaredField2 != null) {
            declaredField2.set(objNewInstance, Boolean.valueOf(sdkConfig.getAsyncInit()));
        }
        if (wkInitManager.allowSdkTimeDelay()) {
            WifiLog.d("WkInitManager initCsj start WkInitManager.csjDelayTime " + wkInitManager.getCsjDelayTime());
            if (wkInitManager.getCsjDelayTime() > 0) {
                final Object obj = objNewInstance;
                wkInitManager.getMainHandler().postDelayed(new Runnable() { // from class: com.wifi.ad.core.WifiNestAd.initCsj.1
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalAccessException, InvocationTargetException {
                        WifiNestAd.INSTANCE.invokeCsj(cls, obj, context, initCallBack2, sdkConfig);
                    }
                }, wkInitManager.getCsjDelayTime());
            } else {
                if (((int) wkInitManager.getCsjDelayTime()) != 0) {
                    return "";
                }
                invokeCsj(NestCsjManager.class, objNewInstance, context, initCallBack2, sdkConfig);
            }
        } else {
            invokeCsj(NestCsjManager.class, objNewInstance, context, initCallBack2, sdkConfig);
        }
        WifiLog.d("init WkInitManager CSJ SDK debug = " + isDebug + " oaid = " + NestInfoTaker.INSTANCE.getOaId() + " appId = " + sdkConfig.getAppId() + " asyncInit = " + sdkConfig.getAsyncInit());
        Intrinsics.checkExpressionValueIsNotNull(NestCsjManager.class, "csjClazz");
        Object version = getVersion(NestCsjManager.class, objNewInstance);
        if (version != null) {
            return (String) version;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    private final String initFS(final SDKConfig sdkConfig, final Context context, String fromName) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        WkInitManager wkInitManager = WkInitManager.INSTANCE;
        if (!wkInitManager.allowInitSDK(fromName, "feisuo")) {
            WifiLog.d("initAd initFS not allow fromName " + fromName);
            return "";
        }
        if (!sdkConfig.getAllowInit()) {
            WifiLog.d("initAd initFS allowInit not");
            return "";
        }
        WifiLog.d("initAd initFS allow fromName " + fromName);
        NestFeiSuoManager nestFeiSuoManager = NestFeiSuoManager.INSTANCE;
        final Class<NestFeiSuoManager> cls = NestFeiSuoManager.class;
        Constructor declaredConstructor = NestFeiSuoManager.class.getDeclaredConstructor(new Class[0]);
        if (declaredConstructor != null) {
            declaredConstructor.setAccessible(true);
        }
        final Object objNewInstance = declaredConstructor != null ? declaredConstructor.newInstance(new Object[0]) : null;
        Field declaredField = NestFeiSuoManager.class.getDeclaredField("debug");
        if (declaredField != null) {
            declaredField.setAccessible(true);
        }
        if (declaredField != null) {
            declaredField.set(objNewInstance, Boolean.valueOf(isDebug));
        }
        if (wkInitManager.allowSdkTimeDelay()) {
            WifiLog.d("WkInitManager initFS start WkInitManager.fsDelayTime " + wkInitManager.getFsDelayTime());
            if (wkInitManager.getFsDelayTime() >= 0) {
                new Thread(new Runnable() { // from class: com.wifi.ad.core.WifiNestAd.initFS.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            Thread.sleep(WkInitManager.INSTANCE.getFsDelayTime());
                            WifiNestAd.INSTANCE.invokeFs(cls, objNewInstance, context, sdkConfig);
                        } catch (Exception unused) {
                        }
                    }
                }).start();
            } else {
                if (((int) wkInitManager.getFsDelayTime()) != 0) {
                    return "";
                }
                invokeFs(NestFeiSuoManager.class, objNewInstance, context, sdkConfig);
            }
        } else {
            invokeFs(NestFeiSuoManager.class, objNewInstance, context, sdkConfig);
        }
        WifiLog.d("init WkInitManager initFS SDK debug = " + isDebug + "  appId = " + sdkConfig.getAppId());
        Intrinsics.checkExpressionValueIsNotNull(NestFeiSuoManager.class, "fsClazz");
        Object version = getVersion(NestFeiSuoManager.class, objNewInstance);
        if (version != null) {
            return (String) version;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    private final String initGdt(final SDKConfig sdkConfig, final Context context, String fromName) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        WkInitManager wkInitManager = WkInitManager.INSTANCE;
        if (!wkInitManager.allowInitSDK(fromName, "gdt")) {
            WifiLog.d("initAd initGdt not allow fromName " + fromName);
            return "";
        }
        if (!sdkConfig.getAllowInit()) {
            WifiLog.d("initAd initGdt allowInit not");
            return "";
        }
        WifiLog.d("initAd initGdt allow fromName " + fromName);
        NestGdtManager nestGdtManager = NestGdtManager.INSTANCE;
        final Class<NestGdtManager> cls = NestGdtManager.class;
        Constructor declaredConstructor = NestGdtManager.class.getDeclaredConstructor(new Class[0]);
        if (declaredConstructor != null) {
            declaredConstructor.setAccessible(true);
        }
        final Object objNewInstance = declaredConstructor != null ? declaredConstructor.newInstance(new Object[0]) : null;
        Field declaredField = NestGdtManager.class.getDeclaredField("debug");
        if (declaredField != null) {
            declaredField.setAccessible(true);
        }
        if (declaredField != null) {
            declaredField.set(objNewInstance, Boolean.valueOf(isDebug));
        }
        if (wkInitManager.allowSdkTimeDelay()) {
            WifiLog.d("WkInitManager initGdt start WkInitManager.gdtDelayTime " + wkInitManager.getGdtDelayTime());
            if (wkInitManager.getGdtDelayTime() >= 0) {
                wkInitManager.getMainHandler().postDelayed(new Runnable() { // from class: com.wifi.ad.core.WifiNestAd.initGdt.1
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalAccessException, InvocationTargetException {
                        WifiNestAd.INSTANCE.invokeGdt(cls, objNewInstance, context, sdkConfig);
                    }
                }, wkInitManager.getGdtDelayTime());
            } else {
                if (((int) wkInitManager.getGdtDelayTime()) != 0) {
                    return "";
                }
                invokeGdt(NestGdtManager.class, objNewInstance, context, sdkConfig);
            }
        } else {
            invokeGdt(NestGdtManager.class, objNewInstance, context, sdkConfig);
        }
        WifiLog.d("init WkInitManager GDT SDK debug = " + isDebug + "  appId = " + sdkConfig.getAppId());
        Intrinsics.checkExpressionValueIsNotNull(NestGdtManager.class, "gdtClazz");
        Object version = getVersion(NestGdtManager.class, objNewInstance);
        if (version != null) {
            return (String) version;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    private final String initHuawei(final SDKConfig sdkConfig, final Context context, String fromName) {
        WkInitManager wkInitManager = WkInitManager.INSTANCE;
        if (!wkInitManager.allowInitSDK(fromName, "huawei")) {
            WifiLog.d("initAd initHuawei not allow fromName " + fromName);
            return "";
        }
        if (!sdkConfig.getAllowInit()) {
            WifiLog.d("initAd initHuawei allowInit not");
            return "";
        }
        try {
            WifiLog.d("HWAD initAd initHuawei allow fromName " + fromName + " HUAWEI_CLASSPATH com.wifi.huawei.ad.NestHuaweiManager");
            final Class<NestHuaweiManager> cls = NestHuaweiManager.class;
            NestHuaweiManager nestHuaweiManager = NestHuaweiManager.INSTANCE;
            Constructor declaredConstructor = NestHuaweiManager.class.getDeclaredConstructor(new Class[0]);
            if (declaredConstructor != null) {
                declaredConstructor.setAccessible(true);
            }
            final Object objNewInstance = declaredConstructor != null ? declaredConstructor.newInstance(new Object[0]) : null;
            Field declaredField = NestHuaweiManager.class.getDeclaredField("debug");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            if (declaredField != null) {
                declaredField.set(objNewInstance, Boolean.valueOf(isDebug));
            }
            if (wkInitManager.allowSdkTimeDelay()) {
                WifiLog.d("WkInitManager initHuawei start WkInitManager.huaweiDelayTime " + wkInitManager.getHuaweiDelayTime());
                if (wkInitManager.getHuaweiDelayTime() >= 0) {
                    wkInitManager.getMainHandler().postDelayed(new Runnable() { // from class: com.wifi.ad.core.WifiNestAd.initHuawei.1
                        @Override // java.lang.Runnable
                        public final void run() throws IllegalAccessException, InvocationTargetException {
                            WifiNestAd.INSTANCE.invokeHw(cls, objNewInstance, context, sdkConfig);
                        }
                    }, wkInitManager.getHuaweiDelayTime());
                } else {
                    if (((int) wkInitManager.getHuaweiDelayTime()) != 0) {
                        return "";
                    }
                    invokeHw(NestHuaweiManager.class, objNewInstance, context, sdkConfig);
                }
            } else {
                invokeHw(NestHuaweiManager.class, objNewInstance, context, sdkConfig);
            }
            WifiLog.d("HWAD init WkInitManager HW SDK debug = " + isDebug + " oaid = " + NestInfoTaker.INSTANCE.getOaId() + " appId = " + sdkConfig.getAppId() + ' ');
            Intrinsics.checkExpressionValueIsNotNull(NestHuaweiManager.class, "hwClazz");
            Object version = getVersion(NestHuaweiManager.class, objNewInstance);
            if (version != null) {
                return (String) version;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e) {
            WifiLog.d("HWAD init HW Exception = " + e + ' ');
            return "";
        }
    }

    private final String initKs(final SDKConfig sdkConfig, final Context context, String fromName) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        WkInitManager wkInitManager = WkInitManager.INSTANCE;
        if (!wkInitManager.allowInitSDK(fromName, "ks")) {
            WifiLog.d("initAd initKs not allow fromName " + fromName);
            return "";
        }
        if (!sdkConfig.getAllowInit()) {
            WifiLog.d("initAd initKs allowInit not");
            return "";
        }
        WifiLog.d("initAd initKs allow fromName " + fromName);
        NestKsManager nestKsManager = NestKsManager.INSTANCE;
        final Class<NestKsManager> cls = NestKsManager.class;
        Constructor declaredConstructor = NestKsManager.class.getDeclaredConstructor(new Class[0]);
        if (declaredConstructor != null) {
            declaredConstructor.setAccessible(true);
        }
        final Object objNewInstance = declaredConstructor != null ? declaredConstructor.newInstance(new Object[0]) : null;
        Field declaredField = NestKsManager.class.getDeclaredField("debug");
        if (declaredField != null) {
            declaredField.setAccessible(true);
        }
        if (declaredField != null) {
            declaredField.set(objNewInstance, Boolean.valueOf(isDebug));
        }
        if (wkInitManager.allowSdkTimeDelay()) {
            WifiLog.d("WkInitManager initKs start WkInitManager.ksDelayTime " + wkInitManager.getKsDelayTime());
            if (wkInitManager.getKsDelayTime() >= 0) {
                wkInitManager.getMainHandler().postDelayed(new Runnable() { // from class: com.wifi.ad.core.WifiNestAd.initKs.1
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalAccessException, InvocationTargetException {
                        WifiNestAd.INSTANCE.invokeKs(cls, objNewInstance, context, sdkConfig);
                    }
                }, wkInitManager.getKsDelayTime());
            } else {
                if (((int) wkInitManager.getKsDelayTime()) != 0) {
                    return "";
                }
                invokeKs(NestKsManager.class, objNewInstance, context, sdkConfig);
            }
        } else {
            invokeKs(NestKsManager.class, objNewInstance, context, sdkConfig);
        }
        WifiLog.d("init WkInitManager KS SDK debug = " + isDebug + " oaid = " + NestInfoTaker.INSTANCE.getOaId() + " appId = " + sdkConfig.getAppId());
        Intrinsics.checkExpressionValueIsNotNull(NestKsManager.class, "ksClazz");
        Object version = getVersion(NestKsManager.class, objNewInstance);
        if (version != null) {
            return (String) version;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    private final String initLxAd(final SDKConfig sdkConfig, final Context context, String fromName) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        WkInitManager wkInitManager = WkInitManager.INSTANCE;
        if (!wkInitManager.allowInitSDK(fromName, "lxad")) {
            WifiLog.d("initAd initLxAd not allow fromName " + fromName);
            return "";
        }
        if (!sdkConfig.getAllowInit()) {
            WifiLog.d("initAd initLxAd allowInit not");
            return "";
        }
        WifiLog.d("initAd initLxAd allow fromName " + fromName);
        NestLxAdManager nestLxAdManager = NestLxAdManager.INSTANCE;
        final Class<NestLxAdManager> cls = NestLxAdManager.class;
        Constructor declaredConstructor = NestLxAdManager.class.getDeclaredConstructor(new Class[0]);
        if (declaredConstructor != null) {
            declaredConstructor.setAccessible(true);
        }
        final Object objNewInstance = declaredConstructor != null ? declaredConstructor.newInstance(new Object[0]) : null;
        Field declaredField = NestLxAdManager.class.getDeclaredField("debug");
        if (declaredField != null) {
            declaredField.setAccessible(true);
        }
        if (declaredField != null) {
            declaredField.set(objNewInstance, Boolean.valueOf(isDebug));
        }
        Field declaredField2 = NestLxAdManager.class.getDeclaredField("debugUrl");
        if (declaredField2 != null) {
            declaredField2.setAccessible(true);
        }
        if (declaredField2 != null) {
            declaredField2.set(objNewInstance, Boolean.valueOf(isDebugUrl));
        }
        Field declaredField3 = NestLxAdManager.class.getDeclaredField("reporter");
        if (declaredField3 != null) {
            declaredField3.setAccessible(true);
        }
        if (declaredField3 != null) {
            AbstractReporter abstractReporter = reporter;
            if (abstractReporter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reporter");
            }
            declaredField3.set(objNewInstance, abstractReporter);
        }
        Field declaredField4 = NestLxAdManager.class.getDeclaredField(Action.ACTION_GET_LOCATION);
        if (declaredField4 != null) {
            declaredField4.setAccessible(true);
        }
        if (declaredField4 != null) {
            RealLocationCallBack realLocationCallBack = getLocationCallBack;
            if (realLocationCallBack == null) {
                Intrinsics.throwUninitializedPropertyAccessException("getLocationCallBack");
            }
            declaredField4.set(objNewInstance, realLocationCallBack);
        }
        if (wkInitManager.allowSdkTimeDelay()) {
            WifiLog.d("WkInitManager initLxAd start WkInitManager.lxadDelayTime " + wkInitManager.getLxadDelayTime());
            if (wkInitManager.getLxadDelayTime() >= 0) {
                new Thread(new Runnable() { // from class: com.wifi.ad.core.WifiNestAd.initLxAd.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            Thread.sleep(WkInitManager.INSTANCE.getLxadDelayTime());
                            WifiNestAd.INSTANCE.invokeLxAd(cls, objNewInstance, context, sdkConfig);
                        } catch (Exception unused) {
                        }
                    }
                }).start();
            } else {
                if (((int) wkInitManager.getLxadDelayTime()) != 0) {
                    return "";
                }
                invokeLxAd(NestLxAdManager.class, objNewInstance, context, sdkConfig);
            }
        } else {
            invokeLxAd(NestLxAdManager.class, objNewInstance, context, sdkConfig);
        }
        WifiLog.d("init WkInitManager lxadClazz SDK debug = " + isDebug + "  appId = " + sdkConfig.getAppId());
        Intrinsics.checkExpressionValueIsNotNull(NestLxAdManager.class, "lxadClazz");
        Object version = getVersion(NestLxAdManager.class, objNewInstance);
        if (version != null) {
            return (String) version;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    private final String initOppo(final SDKConfig sdkConfig, final Context context, String fromName) {
        WkInitManager wkInitManager = WkInitManager.INSTANCE;
        if (!wkInitManager.allowInitSDK(fromName, "oppo")) {
            WifiLog.d("initAd initOppoAd not allow fromName " + fromName);
            return "";
        }
        if (!sdkConfig.getAllowInit()) {
            WifiLog.d("initAd initOppoAd allowInit not");
            return "";
        }
        try {
            WifiLog.d("initAd initOppoAd allow fromName " + fromName);
            final Class<NestOppoManager> cls = NestOppoManager.class;
            NestOppoManager nestOppoManager = NestOppoManager.INSTANCE;
            Constructor declaredConstructor = NestOppoManager.class.getDeclaredConstructor(new Class[0]);
            if (declaredConstructor != null) {
                declaredConstructor.setAccessible(true);
            }
            final Object objNewInstance = declaredConstructor != null ? declaredConstructor.newInstance(new Object[0]) : null;
            Field declaredField = NestOppoManager.class.getDeclaredField("debug");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            if (declaredField != null) {
                declaredField.set(objNewInstance, Boolean.valueOf(isDebug));
            }
            if (wkInitManager.allowSdkTimeDelay()) {
                WifiLog.d("WkInitManager initOppoAd start WkInitManager.oppoDelayTime " + wkInitManager.getOppoDelayTime());
                if (wkInitManager.getOppoDelayTime() >= 0) {
                    wkInitManager.getMainHandler().postDelayed(new Runnable() { // from class: com.wifi.ad.core.WifiNestAd.initOppo.1
                        @Override // java.lang.Runnable
                        public final void run() throws IllegalAccessException, InvocationTargetException {
                            WifiNestAd.INSTANCE.invokeOppo(cls, objNewInstance, context, sdkConfig);
                        }
                    }, wkInitManager.getOppoDelayTime());
                } else {
                    if (((int) wkInitManager.getOppoDelayTime()) != 0) {
                        return "";
                    }
                    invokeOppo(NestOppoManager.class, objNewInstance, context, sdkConfig);
                }
            } else {
                invokeOppo(NestOppoManager.class, objNewInstance, context, sdkConfig);
            }
            WifiLog.d("init WkInitManager OPPOAd SDK debug = " + isDebug + " oaid = " + NestInfoTaker.INSTANCE.getOaId() + " appId = " + sdkConfig.getAppId() + ' ');
            Intrinsics.checkExpressionValueIsNotNull(NestOppoManager.class, "oppoClazz");
            Object version = getVersion(NestOppoManager.class, objNewInstance);
            if (version != null) {
                return (String) version;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
            return "";
        }
    }

    private final void initSDK(Context context, String fromName) {
        WifiLog.d("initSDK");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AbstractReporter abstractReporter = reporter;
        if (abstractReporter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reporter");
        }
        EventParams eventParamsBuild = new EventParams.Builder().build();
        Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder().build()");
        abstractReporter.onEvent(WifiNestConst.EventKey.UNIFIEDAD_SDK_INIT, eventParamsBuild, linkedHashMap);
        appIds = new LinkedHashMap();
        EventParams.Builder builder = new EventParams.Builder();
        try {
            for (SDKConfig sDKConfig : configs) {
                SDKAlias alias = sDKConfig.getAlias();
                String appId = sDKConfig.getAppId();
                if (alias != null) {
                    try {
                        switch (WhenMappings.$EnumSwitchMapping$1[alias.ordinal()]) {
                            case 1:
                                Map<SDKAlias, String> map = appIds;
                                if (map == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("appIds");
                                }
                                map.put(alias, appId);
                                WifiNestAd wifiNestAd = INSTANCE;
                                CsjInitCallBack csjInitCallBack = initCallBack;
                                if (csjInitCallBack == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("initCallBack");
                                }
                                builder.setCsjVersion(wifiNestAd.initCsj(sDKConfig, context, csjInitCallBack, fromName));
                                break;
                            case 2:
                                Map<SDKAlias, String> map2 = appIds;
                                if (map2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("appIds");
                                }
                                map2.put(alias, appId);
                                builder.setOppoVersion(INSTANCE.initOppo(sDKConfig, context, fromName));
                                break;
                            case 3:
                                Map<SDKAlias, String> map3 = appIds;
                                if (map3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("appIds");
                                }
                                map3.put(alias, appId);
                                builder.setHuaweiVersion(INSTANCE.initHuawei(sDKConfig, context, fromName));
                                break;
                            case 4:
                                Map<SDKAlias, String> map4 = appIds;
                                if (map4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("appIds");
                                }
                                map4.put(alias, appId);
                                builder.setKsVersion(INSTANCE.initKs(sDKConfig, context, fromName));
                                break;
                            case 5:
                                Map<SDKAlias, String> map5 = appIds;
                                if (map5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("appIds");
                                }
                                if (appId == null) {
                                    IAdSensitiveTaker taker = sDKConfig.getTaker();
                                    appId = taker != null ? taker.getAppId() : null;
                                }
                                map5.put(alias, appId);
                                builder.setWifiVersion(INSTANCE.initWifi(sDKConfig, context, fromName));
                                break;
                            case 6:
                                Map<SDKAlias, String> map6 = appIds;
                                if (map6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("appIds");
                                }
                                map6.put(alias, appId);
                                builder.setGdtVersion(INSTANCE.initGdt(sDKConfig, context, fromName));
                                break;
                            case 7:
                                Map<SDKAlias, String> map7 = appIds;
                                if (map7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("appIds");
                                }
                                map7.put(alias, appId);
                                builder.setBeiziVersion(INSTANCE.initBZ(sDKConfig, context, fromName));
                                break;
                            case 8:
                                Map<SDKAlias, String> map8 = appIds;
                                if (map8 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("appIds");
                                }
                                map8.put(alias, appId);
                                builder.setFeisuoVersion(INSTANCE.initFS(sDKConfig, context, fromName));
                                break;
                            case 9:
                                Map<SDKAlias, String> map9 = appIds;
                                if (map9 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("appIds");
                                }
                                map9.put(alias, appId);
                                builder.setLxAdVersion(INSTANCE.initLxAd(sDKConfig, context, fromName));
                                break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception unused) {
        }
        builder.setNestVersion(NestSdkVersion.INSTANCE.getVersion(context));
        AbstractReporter abstractReporter2 = reporter;
        if (abstractReporter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reporter");
        }
        EventParams eventParamsBuild2 = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild2, "sdkVersionParams.build()");
        abstractReporter2.onEvent(WifiNestConst.EventKey.NESTAD_VERSION, eventParamsBuild2, linkedHashMap);
    }

    private final void initSDKApp(Context context) {
        WifiLog.d("initAd WifiNestAd initSDKApp");
        initSDK(context, WkInitManager.key_initApp);
    }

    private final String initWifi(SDKConfig sdkConfig, Context context, String fromName) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        NestWifiManager nestWifiManager = NestWifiManager.INSTANCE;
        Constructor declaredConstructor = NestWifiManager.class.getDeclaredConstructor(new Class[0]);
        if (declaredConstructor != null) {
            declaredConstructor.setAccessible(true);
        }
        Object objNewInstance = declaredConstructor != null ? declaredConstructor.newInstance(new Object[0]) : null;
        Field declaredField = NestWifiManager.class.getDeclaredField("debug");
        if (declaredField != null) {
            declaredField.setAccessible(true);
        }
        if (declaredField != null) {
            declaredField.set(objNewInstance, Boolean.valueOf(isDebug));
        }
        Field declaredField2 = NestWifiManager.class.getDeclaredField("debugUrl");
        if (declaredField2 != null) {
            declaredField2.setAccessible(true);
        }
        if (declaredField2 != null) {
            declaredField2.set(objNewInstance, Boolean.valueOf(isDebugUrl));
        }
        Method declaredMethod = NestWifiManager.class.getDeclaredMethod("init", Context.class, String.class, IAdSensitiveTaker.class);
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
        }
        if (declaredMethod != null) {
            declaredMethod.invoke(objNewInstance, context, SDKAlias.WIFI.getType(), sdkConfig.getTaker());
        }
        WifiLog.d("init WIFI SDK debug = " + isDebug + " debugUrl = " + isDebugUrl + " oaid = " + NestInfoTaker.INSTANCE.getOaId());
        Intrinsics.checkExpressionValueIsNotNull(NestWifiManager.class, "wifiClazz");
        Object version = getVersion(NestWifiManager.class, objNewInstance);
        if (version != null) {
            return (String) version;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeBz(Class<?> bdClazz, Object instance, Context context, SDKConfig sdkConfig) throws IllegalAccessException, InvocationTargetException {
        Method declaredMethod = bdClazz != null ? bdClazz.getDeclaredMethod("init", Context.class, String.class, String.class, String.class) : null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
        }
        if (declaredMethod != null) {
            declaredMethod.invoke(instance, context, SDKAlias.BEIZI.getType(), sdkConfig.getAppId(), "beizi");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeCsj(Class<?> csjClazz, Object instance, Context context, CsjInitCallBack initCallBack2, SDKConfig sdkConfig) throws IllegalAccessException, InvocationTargetException {
        Method declaredMethod = csjClazz != null ? csjClazz.getDeclaredMethod("init", Context.class, String.class, String.class, String.class, CsjInitCallBack.class) : null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
        }
        if (declaredMethod != null) {
            declaredMethod.invoke(instance, context, SDKAlias.CSJ.getType(), sdkConfig.getAppId(), "csj", initCallBack2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeFs(Class<?> fsClazz, Object instance, Context context, SDKConfig sdkConfig) throws IllegalAccessException, InvocationTargetException {
        Method declaredMethod = fsClazz != null ? fsClazz.getDeclaredMethod("init", Context.class, String.class, String.class, String.class) : null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
        }
        if (declaredMethod != null) {
            declaredMethod.invoke(instance, context, SDKAlias.FEISUO.getType(), sdkConfig.getAppId(), "feisuo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeGdt(Class<?> gdtClazz, Object instance, Context context, SDKConfig sdkConfig) throws IllegalAccessException, InvocationTargetException {
        Method declaredMethod = gdtClazz != null ? gdtClazz.getDeclaredMethod("init", Context.class, String.class, String.class) : null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
        }
        if (declaredMethod != null) {
            declaredMethod.invoke(instance, context, SDKAlias.GDT.getType(), sdkConfig.getAppId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeHw(Class<?> hwClazz, Object instance, Context context, SDKConfig sdkConfig) throws IllegalAccessException, InvocationTargetException {
        Method declaredMethod = hwClazz != null ? hwClazz.getDeclaredMethod("init", Context.class, String.class, String.class, String.class) : null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
        }
        if (declaredMethod != null) {
            declaredMethod.invoke(instance, context, SDKAlias.HUAWEI.getType(), sdkConfig.getAppId(), "huawei");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeKs(Class<?> ksClazz, Object instance, Context context, SDKConfig sdkConfig) throws IllegalAccessException, InvocationTargetException {
        Method declaredMethod = ksClazz != null ? ksClazz.getDeclaredMethod("init", Context.class, String.class, String.class, String.class) : null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
        }
        if (declaredMethod != null) {
            declaredMethod.invoke(instance, context, SDKAlias.KS.getType(), sdkConfig.getAppId(), "ks");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeLxAd(Class<?> lxadClazz, Object instance, Context context, SDKConfig sdkConfig) throws IllegalAccessException, InvocationTargetException {
        Method declaredMethod = lxadClazz != null ? lxadClazz.getDeclaredMethod("init", Context.class, String.class, String.class, String.class) : null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
        }
        if (declaredMethod != null) {
            declaredMethod.invoke(instance, context, SDKAlias.LXAD.getType(), sdkConfig.getAppId(), "lxad");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeOppo(Class<?> oppoClazz, Object instance, Context context, SDKConfig sdkConfig) throws IllegalAccessException, InvocationTargetException {
        Method declaredMethod = oppoClazz != null ? oppoClazz.getDeclaredMethod("init", Context.class, String.class, String.class, String.class) : null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
        }
        if (declaredMethod != null) {
            declaredMethod.invoke(instance, context, SDKAlias.OPPO.getType(), sdkConfig.getAppId(), "oppo");
        }
    }

    private final void parseConfig(String config) {
        if (config == null || config.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(config);
            isDebug = jSONObject.optBoolean("nest_debug_mode", false);
            isDebugUrl = jSONObject.optBoolean("nest_debug_url_mode", false);
            isCatchThirdInfo = jSONObject.optBoolean("nest_catch_third_sdk_info", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestAdxAllConfig(Context context) {
        new WkAdxAllAdConfigMg(context).requestAdxAllConfig("lxf48f512f7d6a47c2", adConfigTais);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestAllSpConfig(Context context) {
        String str = taiChikeys;
        if (str != null) {
            if (str == null) {
                Intrinsics.throwNpe();
            }
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "LX-29267", false, 2, (Object) null)) {
                new SPAdAllConfigMg(context).requestConfig(adConfigTais, "lxf48f512f7d6a47c2");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestConfig(Context context) {
        new WkAdConfigManager(context).requestConfig(0, AdRandomUtil.INSTANCE.getRequestId(), "", "lxf48f512f7d6a47c2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestWhiteListConfig(Context context) {
        new WkWhiteAdConfigManager(context).requestConfig(0, AdRandomUtil.INSTANCE.getRequestId(), "");
    }

    public static /* synthetic */ WifiNestAd setDebug$default(WifiNestAd wifiNestAd, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return wifiNestAd.setDebug(z, z2);
    }

    private final void updateInvokeSDKPersonAd(boolean enablePersonal, String sdkName) {
        WifiLog.d("updateSDKPersonAd");
        try {
            Class<?> cls = Class.forName(sdkName);
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (declaredConstructor != null) {
                declaredConstructor.setAccessible(true);
            }
            Object objNewInstance = declaredConstructor != null ? declaredConstructor.newInstance(new Object[0]) : null;
            Method declaredMethod = cls.getDeclaredMethod("updatePersonAd", Boolean.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
            }
            if (declaredMethod != null) {
                declaredMethod.invoke(objNewInstance, Boolean.valueOf(enablePersonal));
            }
        } catch (Exception e) {
            WifiLog.d("updateSDKPersonAd Exception " + e);
        }
    }

    private final void updateSDKPersonAd(boolean enablePersonal) {
        try {
            Iterator<T> it = configs.iterator();
            while (it.hasNext()) {
                SDKAlias alias = ((SDKConfig) it.next()).getAlias();
                String str = "";
                if (alias != null) {
                    switch (WhenMappings.$EnumSwitchMapping$0[alias.ordinal()]) {
                        case 1:
                            str = CSJ_CLASSPATH;
                            break;
                        case 2:
                            str = OPPO_CLASSPATH;
                            break;
                        case 3:
                            str = KS_CLASSPATH;
                            break;
                        case 4:
                            str = WIFI_CLASSPATH;
                            break;
                        case 5:
                            str = GDT_CLASSPATH;
                            break;
                        case 6:
                            str = HUAWEI_CLASSPATH;
                            break;
                        case 7:
                            str = BEIZI_CLASSPATH;
                            break;
                        case 8:
                            str = FEISUO_CLASSPATH;
                            break;
                        case 9:
                            str = LXAD_CLASSPATH;
                            break;
                    }
                }
                INSTANCE.updateInvokeSDKPersonAd(enablePersonal, str);
            }
        } catch (Exception unused) {
        }
    }

    public final WifiNestAd addAdConfigs(SDKConfig... sdkConfig) {
        for (SDKConfig sDKConfig : sdkConfig) {
            configs.add(sDKConfig);
        }
        return this;
    }

    public final AdHelperDrawVideo createAdDrawVideo() {
        return AdHelperDrawVideo.INSTANCE;
    }

    public final AdHelperFeed createAdFeed() {
        return AdHelperFeed.INSTANCE;
    }

    public final AdHelperReward createRewardAd() {
        return AdHelperReward.INSTANCE;
    }

    public final AdHelperSplash createSplashAd() {
        return AdHelperSplash.INSTANCE;
    }

    public final void eventShenHeShow(NestAdData nestAdData) {
        try {
            WifiLog.d("eventShenHeShow backDoorResult " + backDoorResult);
            if (backDoorResult) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("requestId", nestAdData.getRequestId());
                jSONObject.put("dspname", nestAdData.getDspName());
                jSONObject.put("srcid", nestAdData.getAdCode());
                jSONObject.put("scene", nestAdData.getAdScene());
                if (nestAdData.getSensitiveInfo() != null) {
                    SensitiveInfo sensitiveInfo = nestAdData.getSensitiveInfo();
                    jSONObject.put("title", sensitiveInfo != null ? sensitiveInfo.getTitle() : null);
                    SensitiveInfo sensitiveInfo2 = nestAdData.getSensitiveInfo();
                    jSONObject.put(LxAdDLManager.ITEM_DESC, sensitiveInfo2 != null ? sensitiveInfo2.getDesc() : null);
                    SensitiveInfo sensitiveInfo3 = nestAdData.getSensitiveInfo();
                    jSONObject.put(WfConstant.EVENT_KEY_APP_NAME, sensitiveInfo3 != null ? sensitiveInfo3.getAppName() : null);
                    SensitiveInfo sensitiveInfo4 = nestAdData.getSensitiveInfo();
                    jSONObject.put("shenheId", sensitiveInfo4 != null ? sensitiveInfo4.getShenheSdkId() : null);
                }
                WifiLog.d("eventShenHeShow backDoor result true jsonObject " + jSONObject);
                AbstractReporter abstractReporter = reporter;
                if (abstractReporter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("reporter");
                }
                if (abstractReporter != null) {
                    String string = jSONObject.toString();
                    Intrinsics.checkExpressionValueIsNotNull(string, "jsonObject.toString()");
                    abstractReporter.onEvent("nest_ad_sdk_shenhe_id", string);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final String getAdConfigTais() {
        return adConfigTais;
    }

    public final Map<SDKAlias, String> getAppIds() {
        Map<SDKAlias, String> map = appIds;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appIds");
        }
        return map;
    }

    public final boolean getBackDoorResult() {
        return backDoorResult;
    }

    public final boolean getBdInit() {
        return bdInit;
    }

    public final boolean getBeiziInit() {
        return beiziInit;
    }

    public final boolean getCsjInit() {
        return csjInit;
    }

    @Deprecated(message = "this function is deprecated!", replaceWith = @ReplaceWith(expression = "createAdDrawVideo()", imports = {}))
    public final AdHelperDrawVideo getDrawVideoAd() {
        return AdHelperDrawVideo.INSTANCE;
    }

    public final boolean getFeisuoInit() {
        return feisuoInit;
    }

    public final String getFeisuochannel() {
        return feisuochannel;
    }

    public final String getFeisuotoken() {
        return feisuotoken;
    }

    public final boolean getGdtInit() {
        return gdtInit;
    }

    public final RealLocationCallBack getGetLocationCallBack() {
        RealLocationCallBack realLocationCallBack = getLocationCallBack;
        if (realLocationCallBack == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getLocationCallBack");
        }
        return realLocationCallBack;
    }

    public final boolean getHeguiTai() {
        return heguiTai;
    }

    public final boolean getHwInit() {
        return hwInit;
    }

    public final IImageLoader getImageLoader() {
        IImageLoader iImageLoader = imageloader;
        if (iImageLoader == null) {
            Intrinsics.throwNpe();
        }
        return iImageLoader;
    }

    public final CsjInitCallBack getInitCallBack() {
        CsjInitCallBack csjInitCallBack = initCallBack;
        if (csjInitCallBack == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initCallBack");
        }
        return csjInitCallBack;
    }

    public final boolean getKsInit() {
        return ksInit;
    }

    public final boolean getLxAdInit() {
        return lxAdInit;
    }

    public final String getLxadtoken() {
        return lxadtoken;
    }

    public final AdRequestCallBack getMAdRequestCallBack() {
        return mAdRequestCallBack;
    }

    public final LXReqHttpCallBack getMLxRequestCallBack() {
        return mLxRequestCallBack;
    }

    public final boolean getMPersonalizedAd() {
        return mPersonalizedAd;
    }

    public final boolean getNewRequestUrl() {
        return newRequestUrl;
    }

    public final boolean getOppoInit() {
        return oppoInit;
    }

    public final boolean getQumengInit() {
        return qumengInit;
    }

    public final AbstractReporter getReporter() {
        AbstractReporter abstractReporter = reporter;
        if (abstractReporter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reporter");
        }
        return abstractReporter;
    }

    public final HashMap<String, SdkPrivilegeController> getSdkPrivilegeControllerS() {
        return sdkPrivilegeControllerS;
    }

    public final boolean getSwitch315() {
        return switch315;
    }

    public final boolean getSwitch58414() {
        return switch58414;
    }

    public final boolean getSwitch70647() {
        return switch70647;
    }

    public final boolean getSwitch77583() {
        return switch77583;
    }

    public final String getTaiChikeys() {
        return taiChikeys;
    }

    public final String getTaiChikeys$core_release() {
        return taiChikeys;
    }

    public final Point getWmPoint() {
        return wmPoint;
    }

    public final WxMiniProgramListener getWxMiniProgramListener() {
        return wxMiniProgramListener;
    }

    public final void init(final Context context) {
        if (configs.isEmpty()) {
            throw new NullPointerException("you should use addAdConfigs() method first to add config");
        }
        AbstractReporter abstractReporter = reporter;
        if (abstractReporter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reporter");
        }
        if (abstractReporter == null) {
            throw new NullPointerException(" you should setEventReporter in order to catch event data ");
        }
        CsjInitCallBack csjInitCallBack = initCallBack;
        if (csjInitCallBack == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initCallBack");
        }
        if (csjInitCallBack == null) {
            throw new NullPointerException(" you should setInitCallBack in order to callback init result ");
        }
        if (imageloader == null) {
            imageloader = new DefaultImageLoader();
        }
        initSDKApp(context);
        Async.INSTANCE.getCache().execute(new Runnable() { // from class: com.wifi.ad.core.WifiNestAd.init.1
            @Override // java.lang.Runnable
            public final void run() {
                WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
                wifiNestAd.requestConfig(context);
                wifiNestAd.requestWhiteListConfig(context);
                wifiNestAd.requestAdxAllConfig(context);
                wifiNestAd.requestAllSpConfig(context);
            }
        });
        initBackDoorBoolean(context);
    }

    public final void initSDKActivity(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("initAd WifiNestAd initSDKApp WkInitManager.initActivity ");
        WkInitManager wkInitManager = WkInitManager.INSTANCE;
        sb.append(wkInitManager.getInitActivity());
        WifiLog.d(sb.toString());
        if (wkInitManager.getInitActivity()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initAd WifiNestAd initSDKActivity configs ");
            sb2.append(configs);
            sb2.append(" reporter ");
            AbstractReporter abstractReporter = reporter;
            if (abstractReporter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reporter");
            }
            sb2.append(abstractReporter);
            sb2.append(" initCallBack ");
            CsjInitCallBack csjInitCallBack = initCallBack;
            if (csjInitCallBack == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initCallBack");
            }
            sb2.append(csjInitCallBack);
            sb2.append(' ');
            WifiLog.d(sb2.toString());
            if (configs.isEmpty()) {
                return;
            }
            AbstractReporter abstractReporter2 = reporter;
            if (abstractReporter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reporter");
            }
            if (abstractReporter2 == null) {
                return;
            }
            CsjInitCallBack csjInitCallBack2 = initCallBack;
            if (csjInitCallBack2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initCallBack");
            }
            if (csjInitCallBack2 == null) {
                return;
            }
            if (imageloader == null) {
                imageloader = new DefaultImageLoader();
            }
            initSDK(context, WkInitManager.key_initActivity);
        }
    }

    public final void initSdkPrivilege(String curSdkConfigValue) {
        try {
            JSONObject jSONObject = new JSONObject(curSdkConfigValue);
            SdkPrivilegeController.Companion companion = SdkPrivilegeController.INSTANCE;
            String[] strArr = {companion.getSDK_CSJ(), companion.getSDK_BD(), companion.getSDK_KS(), companion.getSDK_GDT(), companion.getSDK_OPPO(), companion.getSDK_HUAWEI(), companion.getSDK_BEIZI(), companion.getSDK_QUMENG(), companion.getSDK_LXAD(), companion.getSDK_FEISUO()};
            for (int i = 0; i < 10; i++) {
                String str = strArr[i];
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
                if (jSONObjectOptJSONObject != null) {
                    SdkPrivilegeController sdkPrivilegeController = new SdkPrivilegeController();
                    SdkPrivilegeController.Companion companion2 = SdkPrivilegeController.INSTANCE;
                    sdkPrivilegeController.setCanUseLocation(jSONObjectOptJSONObject.optBoolean(companion2.getTAG_LOCATION()));
                    sdkPrivilegeController.setCanUsePhoneState(jSONObjectOptJSONObject.optBoolean(companion2.getTAG_PHONESTATE()));
                    sdkPrivilegeController.setCanUseWifiState(jSONObjectOptJSONObject.optBoolean(companion2.getTAG_WIFISTATAE()));
                    sdkPrivilegeController.setCanUseWriteExternal(jSONObjectOptJSONObject.optBoolean(companion2.getTAG_WRITEEXTERNAL()));
                    sdkPrivilegeController.setCanUseNetworkState(jSONObjectOptJSONObject.optBoolean(companion2.getTAG_NETWORKSTATE()));
                    sdkPrivilegeController.setCanUseInstalledPackages(jSONObjectOptJSONObject.optBoolean(companion2.getTAG_INSTALLPACKAGES()));
                    sdkPrivilegeController.setCanUseAndroidId(jSONObjectOptJSONObject.optBoolean(companion2.getTAG_ANDROIDID()));
                    sdkPrivilegeController.setCanUsePermissionRecordAudio(jSONObjectOptJSONObject.optBoolean(companion2.getTAG_RECORDAUDIO()));
                    sdkPrivilegeController.setCanUseMacAddress(jSONObjectOptJSONObject.optBoolean(companion2.getTAG_MACADDRESS()));
                    sdkPrivilegeController.setCanUseDeviceId(jSONObjectOptJSONObject.optBoolean(companion2.getTAG_DEVICEID()));
                    sdkPrivilegeController.setCanUseOaid(jSONObjectOptJSONObject.optBoolean(companion2.getTAG_OAID()));
                    sdkPrivilegeController.setCanUseGaid(jSONObjectOptJSONObject.optBoolean(companion2.getTAG_GAID()));
                    sdkPrivilegeController.setCanUseStoragePermission(jSONObjectOptJSONObject.optBoolean(companion2.getTAG_SRTORAGEPERMISSION()));
                    WifiLog.d("sdkPrivilegeController initSdkPrivilege sdkName " + str + ' ' + sdkPrivilegeController);
                    sdkPrivilegeControllerS.put(str, sdkPrivilegeController);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final boolean isCatchThirdInfo() {
        return isCatchThirdInfo;
    }

    public final boolean isDebugUrl() {
        return isDebugUrl;
    }

    public final boolean isDrawVideoNewStyleEnable() {
        WifiNestAd wifiNestAd = INSTANCE;
        if (wifiNestAd.getTaiChikeys() == null) {
            return false;
        }
        String taiChikeys2 = wifiNestAd.getTaiChikeys();
        if (taiChikeys2 == null) {
            Intrinsics.throwNpe();
        }
        return StringsKt__StringsKt.contains$default((CharSequence) taiChikeys2, (CharSequence) "LX-44356", false, 2, (Object) null);
    }

    public final void onDestroy() {
        try {
            if (lxAdInit) {
                NestLxAdManager nestLxAdManager = NestLxAdManager.INSTANCE;
                Constructor declaredConstructor = NestLxAdManager.class.getDeclaredConstructor(new Class[0]);
                if (declaredConstructor != null) {
                    declaredConstructor.setAccessible(true);
                }
                Object objNewInstance = declaredConstructor != null ? declaredConstructor.newInstance(new Object[0]) : null;
                Method declaredMethod = NestLxAdManager.class.getDeclaredMethod("onDestroyAll", String.class);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                }
                if (declaredMethod != null) {
                    declaredMethod.invoke(objNewInstance, "lxAdInit");
                }
            }
        } catch (Exception unused) {
        }
    }

    public final WifiNestAd setAdConfigTais(String adConfigTais2) {
        adConfigTais = adConfigTais2;
        return this;
    }

    public final WifiNestAd setAdRequestCallBack(AdRequestCallBack callBack) {
        mAdRequestCallBack = callBack;
        return this;
    }

    public final WifiNestAd setAdSDKConfig(String adSDKConfig) {
        AdSDKConfigUtil.INSTANCE.initAllConfig(adSDKConfig);
        return this;
    }

    public final void setAppIds(Map<SDKAlias, String> map) {
        appIds = map;
    }

    public final void setBackDoor(Context context, boolean result) {
        try {
            context.getSharedPreferences(SDK_SHENHE_SP_NAME, 0).edit().putBoolean(SDK_SHENHE_BACK_DOOR_KEY, result).apply();
            backDoorResult = result;
            WifiLog.d("setBackDoor apply result " + result);
        } catch (Exception unused) {
        }
    }

    public final void setBackDoorResult(boolean z) {
        backDoorResult = z;
    }

    public final void setBdInit(boolean z) {
        bdInit = z;
    }

    public final void setBeiziInit(boolean z) {
        beiziInit = z;
    }

    public final WifiNestAd setConfig(String config) {
        parseConfig(config);
        WifiLog.setDebugMode(isDebug);
        return this;
    }

    public final void setCsjInit(boolean z) {
        csjInit = z;
    }

    public final WifiNestAd setCsjInitCallBack(CsjInitCallBack callBack) {
        initCallBack = callBack;
        return this;
    }

    public final WifiNestAd setDebug(boolean isDebugLog, boolean isDebugUrl2) {
        isDebug = isDebugLog;
        isDebugUrl = isDebugUrl2;
        WifiLog.setDebugMode(isDebugLog);
        return this;
    }

    public final void setDebugUrl(boolean z) {
        isDebugUrl = z;
    }

    public final WifiNestAd setEventReporter(AbstractReporter reporter2) {
        reporter = reporter2;
        return this;
    }

    public final void setFeisuoInit(boolean z) {
        feisuoInit = z;
    }

    public final void setFeisuochannel(String str) {
        feisuochannel = str;
    }

    public final void setFeisuotoken(String str) {
        feisuotoken = str;
    }

    public final void setGdtInit(boolean z) {
        gdtInit = z;
    }

    public final void setGetLocationCallBack(RealLocationCallBack realLocationCallBack) {
        getLocationCallBack = realLocationCallBack;
    }

    public final void setHeguiTai(boolean z) {
        heguiTai = z;
    }

    public final void setHwInit(boolean z) {
        hwInit = z;
    }

    public final WifiNestAd setImageLoader(IImageLoader imageLoader) {
        imageloader = imageLoader;
        return this;
    }

    public final void setInitCallBack(CsjInitCallBack csjInitCallBack) {
        initCallBack = csjInitCallBack;
    }

    public final void setKsInit(boolean z) {
        ksInit = z;
    }

    public final WifiNestAd setLoactionCallBack(RealLocationCallBack callBack) {
        getLocationCallBack = callBack;
        return this;
    }

    public final void setLxAdInit(boolean z) {
        lxAdInit = z;
    }

    public final WifiNestAd setLxRequestCallBack(LXReqHttpCallBack callBack) {
        mLxRequestCallBack = callBack;
        return this;
    }

    public final void setLxadtoken(String str) {
        lxadtoken = str;
    }

    public final void setMAdRequestCallBack(AdRequestCallBack adRequestCallBack) {
        mAdRequestCallBack = adRequestCallBack;
    }

    public final void setMLxRequestCallBack(LXReqHttpCallBack lXReqHttpCallBack) {
        mLxRequestCallBack = lXReqHttpCallBack;
    }

    public final void setMPersonalizedAd(boolean z) {
        mPersonalizedAd = z;
    }

    public final void setNewRequestUrl(boolean z) {
        newRequestUrl = z;
    }

    public final void setOppoInit(boolean z) {
        oppoInit = z;
    }

    public final WifiNestAd setPersonalizedAd(boolean personalizedAd) {
        mPersonalizedAd = personalizedAd;
        return this;
    }

    public final void setQumengInit(boolean z) {
        qumengInit = z;
    }

    public final void setReporter(AbstractReporter abstractReporter) {
        reporter = abstractReporter;
    }

    public final void setSdkPrivilegeControllerS(HashMap<String, SdkPrivilegeController> map) {
        sdkPrivilegeControllerS = map;
    }

    public final WifiNestAd setSupplier(NestInfoSupplier supplier) {
        NestInfoTaker.INSTANCE.init(supplier);
        return this;
    }

    public final void setSwitch315(boolean z) {
        switch315 = z;
    }

    public final void setSwitch58414(boolean z) {
        switch58414 = z;
    }

    public final void setSwitch70647(boolean z) {
        switch70647 = z;
    }

    public final void setSwitch77583(boolean z) {
        switch77583 = z;
    }

    public final WifiNestAd setSwitchAd315(boolean z) {
        switch315 = z;
        return this;
    }

    public final WifiNestAd setTaiChiKeys(String keys) {
        taiChikeys = keys;
        return this;
    }

    public final void setTaiChikeys$core_release(String str) {
        taiChikeys = str;
    }

    public final void setWmPoint(Point point) {
        wmPoint = point;
    }

    public final void setWxMiniProgramListener(WxMiniProgramListener wxMiniProgramListener2) {
        wxMiniProgramListener = wxMiniProgramListener2;
    }

    public final void updatePersonAd(boolean enablePersonal) {
        if (configs.isEmpty()) {
            throw new NullPointerException("you should use addAdConfigs() method first to add config");
        }
        AbstractReporter abstractReporter = reporter;
        if (abstractReporter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reporter");
        }
        if (abstractReporter == null) {
            throw new NullPointerException(" you should setEventReporter in order to catch event data ");
        }
        CsjInitCallBack csjInitCallBack = initCallBack;
        if (csjInitCallBack == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initCallBack");
        }
        if (csjInitCallBack == null) {
            throw new NullPointerException(" you should setInitCallBack in order to callback init result ");
        }
        if (imageloader == null) {
            imageloader = new DefaultImageLoader();
        }
        updateSDKPersonAd(enablePersonal);
    }
}
