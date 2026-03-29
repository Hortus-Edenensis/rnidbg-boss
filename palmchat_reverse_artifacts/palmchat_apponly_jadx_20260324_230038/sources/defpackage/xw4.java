package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.google.protobuf.InvalidProtocolBufferException;
import com.lantern.core.business.ParamHelper;
import com.lantern.core.network.NetEngine;
import com.lantern.core.network.utils.NECallback;
import com.lantern.core.protobuf.config.CommandsResponseBean;
import com.lantern.core.protobuf.config.RequestBeanOuterClass;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class xw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22068a = "xw4";

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements NECallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public pl0 f22069a;

        public a(pl0 pl0Var) {
            this.f22069a = pl0Var;
        }

        @Override // com.lantern.core.network.utils.NECallback
        public void run(int i, String str, Object obj) {
            if (i != 1) {
                pl0 pl0Var = this.f22069a;
                if (pl0Var != null) {
                    pl0Var.onFailed();
                    return;
                }
                return;
            }
            try {
                CommandsResponseBean.Commands from = CommandsResponseBean.Commands.parseFrom((byte[]) obj);
                ArrayList arrayList = new ArrayList();
                boolean zEquals = "1".equals(from.getAll());
                for (int i2 = 0; i2 < from.getCommandCount(); i2++) {
                    CommandsResponseBean.Command command = from.getCommand(i2);
                    if (command != null) {
                        try {
                            arrayList.add(new cm0(command.getEventId(), Integer.parseInt(TextUtils.isEmpty(command.getLevel()) ? String.valueOf(3) : command.getLevel()), Long.parseLong(TextUtils.isEmpty(command.getAvailableTime()) ? "0L" : command.getAvailableTime()), Integer.parseInt(TextUtils.isEmpty(command.getLimit()) ? "-1" : command.getLimit())));
                        } catch (Exception e) {
                            Log.e(xw4.f22068a, "RequestCallback run: ", e);
                        }
                    }
                }
                pl0 pl0Var2 = this.f22069a;
                if (pl0Var2 != null) {
                    pl0Var2.a(Integer.parseInt(from.getVersion()), zEquals, arrayList);
                }
            } catch (InvalidProtocolBufferException e2) {
                Log.e(xw4.f22068a, "RequestCallback run: ", e2);
                pl0 pl0Var3 = this.f22069a;
                if (pl0Var3 != null) {
                    pl0Var3.onFailed();
                }
            } catch (Exception e3) {
                Log.e(xw4.f22068a, "RequestCallback run: ", e3);
                pl0 pl0Var4 = this.f22069a;
                if (pl0Var4 != null) {
                    pl0Var4.onFailed();
                }
            }
        }
    }

    public static void b(int i, pl0 pl0Var) {
        NetEngine netEngine = NetEngine.getInstance();
        RequestBeanOuterClass.RequestBean.Builder builderNewBuilder = RequestBeanOuterClass.RequestBean.newBuilder();
        builderNewBuilder.setVersion(String.valueOf(i));
        netEngine.httpPost(ParamHelper.getConfigUrl(), ParamHelper.getConfigPid(), builderNewBuilder.build().toByteArray(), new a(pl0Var));
    }
}
