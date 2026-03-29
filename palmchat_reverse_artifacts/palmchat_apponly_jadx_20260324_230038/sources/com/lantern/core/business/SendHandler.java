package com.lantern.core.business;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.protobuf.InvalidProtocolBufferException;
import com.lantern.core.business.SendHandler;
import com.lantern.core.database.DataStoreManager;
import com.lantern.core.log.MyLog;
import com.lantern.core.network.NEPublicMangers;
import com.lantern.core.network.NetEngine;
import com.lantern.core.network.utils.NECallback;
import com.lantern.core.protobuf.ProtobufRequestBeanOuterClass;
import com.lantern.core.protobuf.event.EventOuterClass;
import com.lantern.core.protobuf.event.EventRequestOuterClass;
import defpackage.dn1;
import defpackage.rn1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SendHandler {
    private static final int MESSAGE_SEND_EVENT = 0;
    private static final int MESSAGE_SEND_ONCE = 1;
    private final Context mContext;
    private final DataStoreManager mDBManager;
    private final List<String> mSuccessKey = new ArrayList();
    private final MyHandler myHandler;
    private volatile boolean sending;

    /* JADX INFO: compiled from: SearchBox */
    public class MyHandler extends Handler {
        public MyHandler(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x004b A[Catch: Exception -> 0x0063, NullPointerException -> 0x007b, InvalidProtocolBufferException -> 0x0093, TryCatch #3 {InvalidProtocolBufferException -> 0x0093, NullPointerException -> 0x007b, Exception -> 0x0063, blocks: (B:3:0x0019, B:5:0x0031, B:7:0x0039, B:9:0x0043, B:12:0x004b, B:13:0x005a), top: B:40:0x0019 }] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[Catch: Exception -> 0x0063, NullPointerException -> 0x007b, InvalidProtocolBufferException -> 0x0093, TRY_LEAVE, TryCatch #3 {InvalidProtocolBufferException -> 0x0093, NullPointerException -> 0x007b, Exception -> 0x0063, blocks: (B:3:0x0019, B:5:0x0031, B:7:0x0039, B:9:0x0043, B:12:0x004b, B:13:0x005a), top: B:40:0x0019 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private EventOuterClass.Event.Builder event2Buf(Event event) {
            boolean z;
            IPubParams iPubParams;
            EventOuterClass.Event.Builder builderNewBuilder = EventOuterClass.Event.newBuilder();
            builderNewBuilder.setEventId(event.getEventId());
            ProtobufRequestBeanOuterClass.ProtobufRequestBean protobufRequestBeanBuild = ProtobufRequestBeanOuterClass.ProtobufRequestBean.newBuilder().build();
            try {
                ProtobufRequestBeanOuterClass.ProtobufRequestBean.Builder builder = ProtobufRequestBeanOuterClass.ProtobufRequestBean.parseFrom(event.getPubParams()).toBuilder();
                if (!TextUtils.isEmpty(builder.getDhid()) || (iPubParams = NEPublicMangers.getInstance().mPubParams) == null) {
                    z = false;
                    protobufRequestBeanBuild = !z ? ProtobufRequestBeanOuterClass.ProtobufRequestBean.parseFrom(builder.build().toByteArray()) : ProtobufRequestBeanOuterClass.ProtobufRequestBean.parseFrom(event.getPubParams());
                } else {
                    String dhid = iPubParams.getDHID();
                    if (!TextUtils.isEmpty(dhid)) {
                        builder.setDhid(dhid);
                        z = true;
                    }
                    if (!z) {
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                Log.e("CX_EVENT", "Send Handler exception, ex:" + e.getMessage());
            } catch (NullPointerException e2) {
                Log.e("CX_EVENT", "Send Handler exception, ex:" + e2.getMessage());
            } catch (Exception e3) {
                Log.e("CX_EVENT", "Send Handler exception, ex:" + e3.getMessage());
            }
            builderNewBuilder.setCommonParameters(protobufRequestBeanBuild);
            builderNewBuilder.setMsg(event.getExtra() == null ? "" : event.getExtra());
            builderNewBuilder.setSource(event.getSource() != null ? event.getSource() : "");
            builderNewBuilder.setForeOrBack(event.getState());
            EventOuterClass.Event.Taichi taichiBuild = EventOuterClass.Event.Taichi.newBuilder().build();
            try {
                taichiBuild = EventOuterClass.Event.Taichi.parseFrom(event.getTaiChi());
            } catch (InvalidProtocolBufferException e4) {
                Log.e("CX_EVENT", "Send Handler exception, ex:" + e4.getMessage());
            } catch (Exception e5) {
                Log.e("CX_EVENT", "Send Handler exception, ex:" + e5.getMessage());
            }
            builderNewBuilder.setTaichi(taichiBuild);
            return builderNewBuilder;
        }

        private String getUrlByLevel(int i) {
            return i != 1 ? i != 2 ? i != 3 ? ParamHelper.getOnceEventUrl() : ParamHelper.getOfflineEventUrl() : ParamHelper.getWifiEventUrl() : ParamHelper.getInstEventUrl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$send$0(List list, int i, String str, Object obj) {
            if (i != 1) {
                MyLog.send("", "send failed, events:" + listtoString(list));
                SendHandler.this.sending = false;
                return;
            }
            MyLog.send("", "send success, events:" + listtoString(list) + ", prepare to delete.");
            boolean zRemoveListData = SendHandler.this.mDBManager.removeListData(list);
            for (int i2 = 0; i2 < list.size(); i2++) {
                SendHandler.this.mSuccessKey.add(((Event) list.get(i2)).getEventId() + ((Event) list.get(i2)).getSaveDateTime());
            }
            MyLog.send("", "delete sucess, events:" + listtoString(list));
            SendHandler.this.sending = false;
            if (zRemoveListData) {
                SendHandler.this.resume();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$sendImd$1(Event event, int i, String str, Object obj) {
            if (i == 1) {
                MyLog.send("", "event = " + event + " send immediately success.");
                return;
            }
            MyLog.send("", "event = " + event + " send immediately fail.");
        }

        private String listtoString(List<Event> list) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('[');
            for (int i = 0; i < list.size(); i++) {
                Event event = list.get(i);
                stringBuffer.append(event.getEventId());
                stringBuffer.append("-" + event.getSaveDateTime());
                if (i == list.size() - 1) {
                    stringBuffer.append(']');
                } else {
                    stringBuffer.append(',');
                }
            }
            return stringBuffer.toString();
        }

        private void send(final List<Event> list, String str) {
            SendHandler.this.sending = true;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                if (!SendHandler.this.mSuccessKey.contains(list.get(i).getEventId() + list.get(i).getSaveDateTime())) {
                    arrayList.add(list.get(i));
                }
            }
            if (arrayList.size() == 0) {
                SendHandler.this.sending = false;
                return;
            }
            EventRequestOuterClass.EventRequest.Builder builderNewBuilder = EventRequestOuterClass.EventRequest.newBuilder();
            builderNewBuilder.setEventCount(arrayList.size());
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                builderNewBuilder.addEvents(event2Buf(arrayList.get(i2)));
            }
            MyLog.send("", "prepare to send events:" + listtoString(arrayList));
            NetEngine.getInstance().httpPost(str, ParamHelper.getEventPid(), builderNewBuilder.build().toByteArray(), new NECallback() { // from class: com.lantern.core.business.a
                @Override // com.lantern.core.network.utils.NECallback
                public final void run(int i3, String str2, Object obj) {
                    this.f7528a.lambda$send$0(list, i3, str2, obj);
                }
            });
        }

        private void sendImd(final Event event, String str) {
            EventRequestOuterClass.EventRequest.Builder builderNewBuilder = EventRequestOuterClass.EventRequest.newBuilder();
            builderNewBuilder.setEventCount(1);
            builderNewBuilder.addEvents(event2Buf(event));
            MyLog.send("", "prepare to send immediately event = " + event);
            NetEngine.getInstance().httpPost(str, ParamHelper.getEventPid(), builderNewBuilder.build().toByteArray(), new NECallback() { // from class: com.lantern.core.business.b
                @Override // com.lantern.core.network.utils.NECallback
                public final void run(int i, String str2, Object obj) {
                    SendHandler.MyHandler.lambda$sendImd$1(event, i, str2, obj);
                }
            });
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int iA;
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                Object obj = message.obj;
                if (obj instanceof Event) {
                    Event event = (Event) obj;
                    sendImd(event, getUrlByLevel(event.getLevel()));
                    return;
                }
                return;
            }
            if (SendHandler.this.sending || (iA = rn1.a(SendHandler.this.mContext)) == -1) {
                return;
            }
            Log.i("CX_EVENT", "SendHandler MESSAGE_SEND_EVENT use Advance Event!");
            List<Event> events = SendHandler.this.mDBManager.getEvents(ParamHelper.getAdvancedPresetEventList());
            if (events != null && events.size() > 0) {
                send(events, getUrlByLevel(1));
                return;
            }
            IPubParams iPubParams = NEPublicMangers.getInstance().mPubParams;
            if (iPubParams == null || TextUtils.isEmpty(iPubParams.getDHID())) {
                return;
            }
            for (int i2 = 0; i2 < dn1.f17085a.size(); i2++) {
                int iIntValue = dn1.f17085a.get(i2).intValue();
                if (iIntValue != 1 && iA != 1) {
                    return;
                }
                List<Event> topCountDataByLevel = SendHandler.this.mDBManager.getTopCountDataByLevel(iIntValue, 100);
                if (topCountDataByLevel != null && topCountDataByLevel.size() != 0) {
                    String urlByLevel = getUrlByLevel(iIntValue);
                    MyLog.send("", "Level = " + iIntValue + ", Url = " + urlByLevel + ", prepare to send.");
                    send(topCountDataByLevel, urlByLevel);
                    return;
                }
            }
        }
    }

    public SendHandler(Context context, DataStoreManager dataStoreManager) {
        this.mContext = context;
        this.mDBManager = dataStoreManager;
        HandlerThread handlerThread = new HandlerThread(SendHandler.class.getName(), 10);
        handlerThread.start();
        this.myHandler = new MyHandler(handlerThread.getLooper());
    }

    public void resume() {
        if (this.sending || this.myHandler.hasMessages(0)) {
            return;
        }
        Message messageObtainMessage = this.myHandler.obtainMessage();
        messageObtainMessage.what = 0;
        this.myHandler.sendMessage(messageObtainMessage);
    }

    public void sendOnce(Event event) {
        Message messageObtainMessage = this.myHandler.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = event;
        this.myHandler.sendMessage(messageObtainMessage);
    }
}
