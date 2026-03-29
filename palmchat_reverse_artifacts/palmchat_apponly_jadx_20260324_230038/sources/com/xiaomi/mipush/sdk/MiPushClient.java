package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bq;
import com.igexin.sdk.PushConsts;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C1401r;
import com.xiaomi.push.ae;
import com.xiaomi.push.an;
import com.xiaomi.push.au;
import com.xiaomi.push.bb;
import com.xiaomi.push.cx;
import com.xiaomi.push.dg;
import com.xiaomi.push.dh;
import com.xiaomi.push.dq;
import com.xiaomi.push.dr;
import com.xiaomi.push.ds;
import com.xiaomi.push.ed;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.gt;
import com.xiaomi.push.gz;
import com.xiaomi.push.he;
import com.xiaomi.push.hf;
import com.xiaomi.push.hj;
import com.xiaomi.push.hl;
import com.xiaomi.push.hn;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import j$.util.DesugarTimeZone;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    /* JADX INFO: compiled from: SearchBox */
    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public void setResultCode(long j) {
            this.resultCode = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Deprecated
    public static abstract class MiPushClientCallback {
        private String category;

        public String getCategory() {
            return this.category;
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void setCategory(String str) {
            this.category = str;
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class TokenResult {
        private String token = null;
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        public void setResultCode(long j) {
            this.resultCode = j;
        }

        public void setToken(String str) {
            this.token = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        return TextUtils.equals(getAcceptTime(context), str + "," + str2);
    }

    public static long accountSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_" + str, -1L);
    }

    public static synchronized void addAcceptTime(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + "," + str2);
        com.xiaomi.push.p.a(editorEdit);
    }

    public static synchronized void addAccount(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
    }

    public static synchronized void addAlias(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putLong("last_pull_notification", System.currentTimeMillis());
        com.xiaomi.push.p.a(editorEdit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putLong("last_reg_request", System.currentTimeMillis());
        com.xiaomi.push.p.a(editorEdit);
    }

    public static synchronized void addTopic(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
    }

    public static long aliasSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_" + str, -1L);
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.4
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo packageInfo;
                try {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str) && (packageInfo = context.getPackageManager().getPackageInfo(str, 4)) != null) {
                            MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
                        }
                    }
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException("param " + str + " is not nullable");
    }

    public static void clearExtras(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    private static void clearExtrasForInitialize(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        Iterator<String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            editorEdit.remove("alias_" + it.next());
        }
        Iterator<String> it2 = getAllUserAccount(context).iterator();
        while (it2.hasNext()) {
            editorEdit.remove("account_" + it2.next());
        }
        Iterator<String> it3 = getAllTopic(context).iterator();
        while (it3.hasNext()) {
            editorEdit.remove("topic_" + it3.next());
        }
        editorEdit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
        editorEdit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        u.a(context).f();
    }

    public static void clearNotification(Context context, int i) {
        u.a(context).a(i);
    }

    public static void disablePush(Context context) {
        u.a(context).a(true);
    }

    public static void enablePush(Context context) {
        u.a(context).a(false);
    }

    public static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (b.m99a(context).m108c()) {
            return b.m99a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return com.xiaomi.push.j.m654b();
    }

    public static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_FCM);
    }

    public static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_HUAWEI);
    }

    public static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_COS);
    }

    public static boolean getOpenVIVOPush(Context context) {
        return e.a(context).b(d.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (b.m99a(context).m108c()) {
            return b.m99a(context).m107c();
        }
        return null;
    }

    private static void initEventPerfLogic(final Context context) {
        ds.a(new ds.a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
            @Override // com.xiaomi.push.ds.a
            public void uploader(Context context2, gj gjVar) {
                MiTinyDataClient.upload(context2, gjVar);
            }
        });
        Config configA = ds.a(context);
        com.xiaomi.clientreport.manager.a.a(context).a(BuildConfig.VERSION_NAME);
        ClientReportClient.init(context, configA, new dq(context), new dr(context));
        a.a(context);
        k.a(context, configA);
        ah.a(context).a(new ah.a(100, "perf event job update") { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
            @Override // com.xiaomi.push.service.ah.a
            public void onCallback() {
                ds.m382a(context);
            }
        });
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(p.a(sContext).a(v.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(p.a(sContext).a(v.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        p pVarA = p.a(sContext);
        v vVar = v.UPLOAD_HUAWEI_TOKEN;
        if ("syncing".equals(pVarA.a(vVar))) {
            u.a(sContext).a((String) null, vVar, d.ASSEMBLE_PUSH_HUAWEI, "init");
        }
        if ("syncing".equals(p.a(sContext).a(v.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        p pVarA2 = p.a(sContext);
        v vVar2 = v.UPLOAD_COS_TOKEN;
        if ("syncing".equals(pVarA2.a(vVar2))) {
            u.a(sContext).a((String) null, vVar2, d.ASSEMBLE_PUSH_COS, "init");
        }
        p pVarA3 = p.a(sContext);
        v vVar3 = v.UPLOAD_FTOS_TOKEN;
        if ("syncing".equals(pVarA3.a(vVar3))) {
            u.a(context).a((String) null, vVar3, d.ASSEMBLE_PUSH_FTOS, "init");
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    public static void reInitialize(Context context, gt gtVar) {
        com.xiaomi.channel.commonutils.logger.b.e("re-register reason: " + gtVar);
        String strA = bb.a(6);
        String strM100a = b.m99a(context).m100a();
        String strB = b.m99a(context).b();
        b.m99a(context).m101a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        b.m99a(context).a(Constants.a());
        b.m99a(context).a(strM100a, strB, strA);
        hf hfVar = new hf();
        hfVar.a(aj.b());
        hfVar.b(strM100a);
        hfVar.e(strB);
        hfVar.f(strA);
        hfVar.d(context.getPackageName());
        hfVar.c(com.xiaomi.push.g.m475a(context, context.getPackageName()));
        hfVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        hfVar.h(BuildConfig.VERSION_NAME);
        hfVar.a(BuildConfig.VERSION_CODE);
        hfVar.a(gtVar);
        int iA = com.xiaomi.push.i.a();
        if (iA >= 0) {
            hfVar.c(iA);
        }
        u.a(context).a(hfVar, false);
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            intentFilter.addCategory("android.intent.category.DEFAULT");
            com.xiaomi.push.m.a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter, 2);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m74a("dynamic register network status receiver failed:" + th);
        }
        au.m170a(sContext);
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
    }

    public static synchronized void removeAcceptTime(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
        com.xiaomi.push.p.a(editorEdit);
    }

    public static synchronized void removeAccount(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + str).commit();
    }

    public static synchronized void removeAlias(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + str).commit();
    }

    public static synchronized void removeAllAccounts(Context context) {
        Iterator<String> it = getAllUserAccount(context).iterator();
        while (it.hasNext()) {
            removeAccount(context, it.next());
        }
    }

    public static synchronized void removeAllAliases(Context context) {
        Iterator<String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            removeAlias(context, it.next());
        }
    }

    public static synchronized void removeAllTopics(Context context) {
        Iterator<String> it = getAllTopic(context).iterator();
        while (it.hasNext()) {
            removeTopic(context, it.next());
        }
    }

    public static synchronized void removeTopic(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + str).commit();
    }

    public static void removeWindow(Context context) {
        u.a(context).m150e();
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (b.m99a(context).m106b()) {
            gp gpVar = z ? gp.APP_SLEEP : gp.APP_WAKEUP;
            he heVar = new he();
            heVar.b(b.m99a(context).m100a());
            heVar.c(gpVar.f535a);
            heVar.d(context.getPackageName());
            heVar.a(aj.a());
            heVar.a(false);
            u.a(context).a(heVar, gf.Notification, false, (gs) null, false);
        }
    }

    public static void reportIgnoreRegMessageClicked(Context context, String str, gs gsVar, String str2, String str3) {
        he heVar = new he();
        if (TextUtils.isEmpty(str3)) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        }
        heVar.b(str3);
        heVar.c("bar:click");
        heVar.a(str);
        heVar.a(false);
        u.a(context).a(heVar, gf.Notification, false, true, gsVar, true, str2, str3);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (ah.a(sContext).a(gk.DataCollectionSwitch.a(), getDefaultSwitch())) {
            dg.a().a(new i(context));
            ae.a(sContext).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                @Override // java.lang.Runnable
                public void run() {
                    dh.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        ae.a(sContext).a(new o(sContext), ah.a(sContext).a(gk.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = ((DesugarTimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
        long j = ((((long) ((i * 60) + i2)) + rawOffset) + 1440) % 1440;
        long j2 = ((((long) ((i3 * 60) + i4)) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i), Integer.valueOf(i2)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i4)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, ed.COMMAND_SET_ACCEPT_TIME.f362a, (ArrayList<String>) arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, ed.COMMAND_SET_ACCEPT_TIME.f362a, 0L, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ed.COMMAND_SET_ACCEPT_TIME.f362a, arrayList2, 0L, null, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ed.COMMAND_SET_ALIAS.f362a, str, str2);
    }

    public static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        ed edVar = ed.COMMAND_SET_ALIAS;
        if (edVar.f362a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(edVar.f362a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (ed.COMMAND_UNSET_ALIAS.f362a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            com.xiaomi.channel.commonutils.logger.b.m74a("Don't cancel alias for " + bb.a(arrayList.toString(), 3) + " is unseted");
            return;
        }
        ed edVar2 = ed.COMMAND_SET_ACCOUNT;
        if (edVar2.f362a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < 3600000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(edVar2.f362a, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (!ed.COMMAND_UNSET_ACCOUNT.f362a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
            setCommand(context, str, (ArrayList<String>) arrayList, str3);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("Don't cancel account for " + bb.a(arrayList.toString(), 3) + " is unseted");
    }

    public static void setLocalNotificationType(Context context, int i) {
        u.a(context).b(i & (-1));
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ed.COMMAND_SET_ACCOUNT.f362a, str, str2);
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return u.a(context).m144a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(b.m99a(context).m100a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ed.COMMAND_SUBSCRIBE_TOPIC.f362a, arrayList, 0L, null, null, null));
            return;
        }
        hj hjVar = new hj();
        String strA = aj.a();
        hjVar.a(strA);
        hjVar.b(b.m99a(context).m100a());
        hjVar.c(str);
        hjVar.d(context.getPackageName());
        hjVar.e(str2);
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ed.COMMAND_SUBSCRIBE_TOPIC + ", " + strA);
        u.a(context).a(hjVar, gf.Subscription, (gs) null);
    }

    public static void syncAssembleFCMPushToken(Context context) {
        u.a(context).a((String) null, v.UPLOAD_FCM_TOKEN, d.ASSEMBLE_PUSH_FCM, "");
    }

    public static long topicSubscribedTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1L);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken(null);
            tokenResult.getToken();
            tokenResult.setResultCode(0L);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void unregisterPush(Context context) {
        f.c(context);
        ah.a(context).a();
        if (b.m99a(context).m106b()) {
            hl hlVar = new hl();
            hlVar.a(aj.a());
            hlVar.b(b.m99a(context).m100a());
            hlVar.c(b.m99a(context).m107c());
            hlVar.e(b.m99a(context).b());
            hlVar.d(context.getPackageName());
            u.a(context).a(hlVar);
            PushMessageHandler.a();
            PushMessageHandler.b();
            b.m99a(context).m105b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, ed.COMMAND_UNSET_ALIAS.f362a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, ed.COMMAND_UNSET_ACCOUNT.f362a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (b.m99a(context).m106b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.channel.commonutils.logger.b.m74a("Don't cancel subscribe for " + bb.a(str, 3) + " is unsubscribed");
                return;
            }
            hn hnVar = new hn();
            String strA = aj.a();
            hnVar.a(strA);
            hnVar.b(b.m99a(context).m100a());
            hnVar.c(str);
            hnVar.d(context.getPackageName());
            hnVar.e(str2);
            com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ed.COMMAND_UNSUBSCRIBE_TOPIC + ", " + strA);
            u.a(context).a(hnVar, gf.UnSubscription, (gs) null);
        }
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.xiaomi.push.j.m656d()) {
                    return;
                }
                if (com.xiaomi.push.i.c(MiPushClient.sContext) != null || an.a(MiPushClient.sContext).mo161a()) {
                    he heVar = new he();
                    heVar.b(b.m99a(MiPushClient.sContext).m100a());
                    heVar.c(gp.ClientInfoUpdate.f535a);
                    heVar.a(aj.a());
                    heVar.a(new HashMap());
                    String strC = com.xiaomi.push.i.c(MiPushClient.sContext);
                    String str = "";
                    if (!TextUtils.isEmpty(strC)) {
                        str = "" + bb.a(strC);
                    }
                    String strE = com.xiaomi.push.i.e(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strE)) {
                        str = str + "," + strE;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        heVar.m569a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                    }
                    an.a(MiPushClient.sContext).a(heVar.m569a());
                    int iA = com.xiaomi.push.i.a();
                    if (iA >= 0) {
                        heVar.m569a().put("space_id", Integer.toString(iA));
                    }
                    u.a(MiPushClient.sContext).a(heVar, gf.Notification, false, (gs) null);
                }
            }
        }).start();
    }

    public static void clearNotification(Context context, String str, String str2) {
        u.a(context).a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        try {
            com.xiaomi.channel.commonutils.logger.b.a(context.getApplicationContext());
            com.xiaomi.channel.commonutils.logger.b.e("sdk_version = 5_9_9-C");
            an.a(context).a();
            cx.a(context);
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.a(iCallbackResult);
            }
            if (C1401r.m663a(sContext)) {
                m.a(sContext);
            }
            boolean z = b.m99a(sContext).a() != Constants.a();
            if (!z && !shouldSendRegRequest(sContext)) {
                u.a(sContext).m141a();
                com.xiaomi.channel.commonutils.logger.b.m74a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (z || !b.m99a(sContext).a(str, str2) || b.m99a(sContext).m111f()) {
                String strA = bb.a(6);
                b.m99a(sContext).m101a();
                b.m99a(sContext).a(Constants.a());
                b.m99a(sContext).a(str, str2, strA);
                MiTinyDataClient.a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                clearExtras(sContext);
                clearNotification(context);
                hf hfVar = new hf();
                hfVar.a(aj.b());
                hfVar.b(str);
                hfVar.e(str2);
                hfVar.d(sContext.getPackageName());
                hfVar.f(strA);
                Context context2 = sContext;
                hfVar.c(com.xiaomi.push.g.m475a(context2, context2.getPackageName()));
                Context context3 = sContext;
                hfVar.b(com.xiaomi.push.g.a(context3, context3.getPackageName()));
                hfVar.h(BuildConfig.VERSION_NAME);
                hfVar.a(BuildConfig.VERSION_CODE);
                hfVar.a(gt.Init);
                if (!TextUtils.isEmpty(str3)) {
                    hfVar.g(str3);
                }
                if (!com.xiaomi.push.j.m656d()) {
                    String strD = com.xiaomi.push.i.d(sContext);
                    if (!TextUtils.isEmpty(strD)) {
                        hfVar.i(bb.a(strD) + "," + com.xiaomi.push.i.f(sContext));
                    }
                }
                int iA = com.xiaomi.push.i.a();
                if (iA >= 0) {
                    hfVar.c(iA);
                }
                u.a(sContext).a(hfVar, z);
                sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            } else {
                if (1 == PushMessageHelper.getPushMode(sContext)) {
                    checkNotNull(miPushClientCallback, bq.f.L);
                    miPushClientCallback.onInitializeResult(0L, null, b.m99a(sContext).m107c());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(b.m99a(sContext).m107c());
                    PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ed.COMMAND_REGISTER.f362a, arrayList, 0L, null, null, null));
                }
                u.a(sContext).m141a();
                if (b.m99a(sContext).m103a()) {
                    he heVar = new he();
                    heVar.b(b.m99a(sContext).m100a());
                    heVar.c(gp.ClientInfoUpdate.f535a);
                    heVar.a(aj.a());
                    HashMap map = new HashMap();
                    heVar.f674a = map;
                    Context context4 = sContext;
                    map.put("app_version", com.xiaomi.push.g.m475a(context4, context4.getPackageName()));
                    Map<String, String> map2 = heVar.f674a;
                    Context context5 = sContext;
                    map2.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(context5, context5.getPackageName())));
                    heVar.f674a.put("push_sdk_vn", BuildConfig.VERSION_NAME);
                    heVar.f674a.put("push_sdk_vc", Integer.toString(BuildConfig.VERSION_CODE));
                    String strE = b.m99a(sContext).e();
                    if (!TextUtils.isEmpty(strE)) {
                        heVar.f674a.put(DeviceInfoUtil.DEVICEID_TAG, strE);
                    }
                    u.a(sContext).a(heVar, gf.Notification, false, (gs) null);
                    u.a(sContext).m142a(sContext);
                }
                if (!com.xiaomi.push.l.m658a(sContext, "update_devId", false)) {
                    updateImeiOrOaid();
                    com.xiaomi.push.l.a(sContext, "update_devId", true);
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    he heVar2 = new he();
                    heVar2.b(b.m99a(sContext).m100a());
                    heVar2.c(gp.PullOfflineMessage.f535a);
                    heVar2.a(aj.a());
                    heVar2.a(false);
                    u.a(sContext).a(heVar2, gf.Notification, false, (gs) null, false);
                    addPullNotificationTime(sContext);
                }
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleDataCollectionJobs(sContext);
            initEventPerfLogic(sContext);
            w.a(sContext);
            if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                if (Logger.getUserLogger() != null) {
                    Logger.setLogger(sContext, Logger.getUserLogger());
                }
                com.xiaomi.channel.commonutils.logger.b.a(2);
            }
            operateSyncAction(context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, null);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        gs gsVar = new gs();
        gsVar.a(miPushMessage.getMessageId());
        gsVar.b(miPushMessage.getTopic());
        gsVar.d(miPushMessage.getDescription());
        gsVar.c(miPushMessage.getTitle());
        gsVar.c(miPushMessage.getNotifyId());
        gsVar.a(miPushMessage.getNotifyType());
        gsVar.b(miPushMessage.getPassThrough());
        gsVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), gsVar, null);
    }

    public static void clearNotification(Context context) {
        u.a(context).a(-1);
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, "context");
        checkNotNull(str, com.heytap.mcssdk.constant.b.u);
        checkNotNull(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        C1401r.a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        e.a(sContext).a(pushConfiguration);
        ae.a(context2).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
            @Override // java.lang.Runnable
            public void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, null, str3, iCallbackResult);
            }
        });
    }

    public static void reportMessageClicked(Context context, String str, gs gsVar, String str2) {
        he heVar = new he();
        if (TextUtils.isEmpty(str2)) {
            if (b.m99a(context).m106b()) {
                heVar.b(b.m99a(context).m100a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                return;
            }
        } else {
            heVar.b(str2);
        }
        heVar.c("bar:click");
        heVar.a(str);
        heVar.a(false);
        u.a(context).a(heVar, gf.Notification, false, gsVar);
    }

    public static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(b.m99a(context).m100a())) {
            return;
        }
        gz gzVar = new gz();
        String strA = aj.a();
        gzVar.a(strA);
        gzVar.b(b.m99a(context).m100a());
        gzVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            gzVar.m544a(it.next());
        }
        gzVar.e(str2);
        gzVar.d(context.getPackageName());
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + str + ", " + strA);
        u.a(context).a(gzVar, gf.Command, (gs) null);
    }

    @Deprecated
    public static void syncAssembleCOSPushToken(Context context) {
    }

    @Deprecated
    public static void syncAssembleFTOSPushToken(Context context) {
    }

    @Deprecated
    public static void syncAssemblePushToken(Context context) {
    }
}
