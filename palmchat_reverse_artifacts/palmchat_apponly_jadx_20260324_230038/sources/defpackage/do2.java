package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import androidx.annotation.RequiresApi;
import com.kuaishou.weapon.p0.t;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¨\u0006\u000b"}, d2 = {"Ldo2;", "", "Landroid/content/Context;", "context", "", t.l, "Landroid/net/LinkProperties;", "linkProperties", "a", "<init>", "()V", "framework_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nIPv6DetectionHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IPv6DetectionHelper.kt\ncom/zenmen/palmchat/utils/IPv6DetectionHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,55:1\n766#2:56\n857#2,2:57\n1747#2,3:59\n*S KotlinDebug\n*F\n+ 1 IPv6DetectionHelper.kt\ncom/zenmen/palmchat/utils/IPv6DetectionHelper\n*L\n36#1:56\n36#1:57,2\n42#1:59,3\n*E\n"})
public final class do2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final do2 f17103a = new do2();

    public final boolean a(LinkProperties linkProperties) {
        List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
        Intrinsics.checkNotNullExpressionValue(linkAddresses, "linkProperties.linkAddresses");
        ArrayList arrayList = new ArrayList();
        for (Object obj : linkAddresses) {
            LinkAddress linkAddress = (LinkAddress) obj;
            LogUtil.i("IPv6DetectionHelper", " linkAddresses filter=" + linkAddress.getAddress().getHostAddress());
            if (linkAddress.getAddress() instanceof Inet6Address) {
                arrayList.add(obj);
            }
        }
        boolean z = false;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                InetAddress address = ((LinkAddress) it.next()).getAddress();
                Intrinsics.checkNotNull(address, "null cannot be cast to non-null type java.net.Inet6Address");
                Inet6Address inet6Address = (Inet6Address) address;
                LogUtil.i("IPv6DetectionHelper", " inet6Address.hostAddress=" + inet6Address.getHostAddress() + " reuslt =" + ((inet6Address.isLinkLocalAddress() || inet6Address.isSiteLocalAddress()) ? false : true));
                if ((inet6Address.isLinkLocalAddress() || inet6Address.isSiteLocalAddress()) ? false : true) {
                    z = true;
                    break;
                }
            }
        }
        LogUtil.i("IPv6DetectionHelper", " hasGlobalIPv6=" + z);
        return z;
    }

    @RequiresApi(23)
    public final boolean b(Context context) {
        LinkProperties linkProperties;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) == null) {
            return false;
        }
        return a(linkProperties);
    }
}
