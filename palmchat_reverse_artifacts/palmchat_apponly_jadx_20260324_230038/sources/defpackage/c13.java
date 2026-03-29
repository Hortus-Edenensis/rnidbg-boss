package defpackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.AdditionItem;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.Vo.RichMsgExVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.chat.g;
import com.zenmen.palmchat.webplatform.miniPrograms.Package;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c13 implements nn2 {
    @Override // defpackage.nn2
    public void a(Context context, fx4 fx4Var) {
        if (fx4Var == null || fx4Var.f17619a != 0) {
            return;
        }
        d(context, fx4Var);
    }

    @Override // defpackage.nn2
    public void b(int i) {
        f46.k(ch.s().u(), i, null);
    }

    public final MessageVo c(fx4 fx4Var) {
        Package r2;
        MessageVo messageVo = new MessageVo();
        messageVo.mid = xn3.a();
        messageVo.time = ir5.b();
        messageVo.contactRelate = AccountUtils.p(AppContext.getContext());
        messageVo.from = AccountUtils.p(AppContext.getContext());
        messageVo.to = AccountUtils.p(AppContext.getContext());
        messageVo.mimeType = 28;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.attachStatus = 2;
        Object obj = fx4Var.e;
        if (obj != null) {
            r2 = (Package) obj;
        } else {
            r2 = new Package();
            r2.pkgId = MapController.DEFAULT_LAYER_TAG;
            r2.name = "defaultName";
        }
        RichMsgExVo richMsgExVo = new RichMsgExVo();
        richMsgExVo.items = new ArrayList<>();
        RichMsgExItemVo richMsgExItemVo = new RichMsgExItemVo();
        richMsgExItemVo.showType = 6;
        String str = "zenxin://activity?page=a0050&pkgId=" + r2.pkgId;
        if (!TextUtils.isEmpty(fx4Var.c)) {
            try {
                str = str + "&urlExtra=" + URLEncoder.encode(fx4Var.c, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        richMsgExItemVo.url = str;
        richMsgExItemVo.cover = fx4Var.b;
        String str2 = r2.name;
        if (!TextUtils.isEmpty(fx4Var.d)) {
            str2 = fx4Var.d;
        }
        richMsgExItemVo.title = str2;
        richMsgExItemVo.digest = "";
        richMsgExItemVo.appIcon = r2.icon;
        richMsgExItemVo.appName = r2.name;
        richMsgExVo.items.add(richMsgExItemVo);
        AdditionItem additionItem = new AdditionItem();
        additionItem.icon = "https://cdnpalmchat.youni.im/static/resource/imgs/7cdecc3b8d454cbd9343323fc4e2f16c.png";
        additionItem.name = "小应用";
        additionItem.id = r2.pkgId;
        richMsgExVo.source = additionItem;
        RichMsgVo richMsgVo = new RichMsgVo();
        richMsgVo.appMsg = richMsgExVo;
        messageVo.data1 = az2.c(richMsgVo);
        int i = g.k() ? 3 : 2;
        messageVo.data2 = String.valueOf(i);
        messageVo.text = g.e(richMsgExItemVo, i);
        return messageVo;
    }

    public final void d(Context context, fx4 fx4Var) {
        MessageVo messageVoC = c(fx4Var);
        Intent intent = new Intent();
        intent.setClass(context, SendMessageActivity.class);
        intent.putExtra("message_vo", messageVoC);
        context.startActivity(intent);
    }
}
