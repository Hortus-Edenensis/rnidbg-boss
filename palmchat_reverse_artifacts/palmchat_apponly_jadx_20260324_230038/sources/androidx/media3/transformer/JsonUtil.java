package androidx.media3.transformer;

import android.os.Build;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.transformer.ExportResult;
import com.google.common.collect.ImmutableList;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.lantern.auth.server.WkParams;
import defpackage.o46;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class JsonUtil {
    private JsonUtil() {
    }

    @Nullable
    public static JSONObject exceptionAsJsonObject(@Nullable Exception exc) throws JSONException {
        if (exc == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("message", exc.getMessage());
        jSONObject.put("type", exc.getClass());
        if (exc instanceof ExportException) {
            jSONObject.put("errorCode", ((ExportException) exc).errorCode);
        }
        jSONObject.put("stackTrace", Log.getThrowableString(exc));
        return jSONObject;
    }

    public static JSONObject exportResultAsJsonObject(ExportResult exportResult) throws JSONException {
        JSONObject jSONObjectPutOpt = new JSONObject().putOpt("audioEncoderName", exportResult.audioEncoderName).putOpt("colorInfo", exportResult.colorInfo).putOpt("videoEncoderName", exportResult.videoEncoderName).putOpt("testException", exceptionAsJsonObject(exportResult.exportException));
        if (!exportResult.processedInputs.isEmpty()) {
            jSONObjectPutOpt.put("processedInputs", processedInputsAsJsonArray(exportResult.processedInputs));
        }
        int i = exportResult.averageAudioBitrate;
        if (i != -2147483647) {
            jSONObjectPutOpt.put("averageAudioBitrate", i);
        }
        int i2 = exportResult.averageVideoBitrate;
        if (i2 != -2147483647) {
            jSONObjectPutOpt.put("averageVideoBitrate", i2);
        }
        int i3 = exportResult.channelCount;
        if (i3 != -1) {
            jSONObjectPutOpt.put("channelCount", i3);
        }
        long j = exportResult.durationMs;
        if (j != -9223372036854775807L) {
            jSONObjectPutOpt.put("durationMs", j);
        }
        long j2 = exportResult.fileSizeBytes;
        if (j2 != -1) {
            jSONObjectPutOpt.put("fileSizeBytes", j2);
        }
        int i4 = exportResult.height;
        if (i4 != -1) {
            jSONObjectPutOpt.put("height", i4);
        }
        int i5 = exportResult.sampleRate;
        if (i5 != -2147483647) {
            jSONObjectPutOpt.put("sampleRate", i5);
        }
        int i6 = exportResult.videoFrameCount;
        if (i6 > 0) {
            jSONObjectPutOpt.put("videoFrameCount", i6);
        }
        int i7 = exportResult.width;
        if (i7 != -1) {
            jSONObjectPutOpt.put("width", i7);
        }
        return jSONObjectPutOpt;
    }

    public static JSONObject getDeviceDetailsAsJsonObject() throws JSONException {
        return new JSONObject().put("manufacturer", Build.MANUFACTURER).put(WkParams.MODEL, Build.MODEL).put("sdkVersion", Build.VERSION.SDK_INT).put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, Build.FINGERPRINT);
    }

    public static JSONArray processedInputsAsJsonArray(ImmutableList<ExportResult.ProcessedInput> immutableList) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        o46<ExportResult.ProcessedInput> it = immutableList.iterator();
        while (it.hasNext()) {
            ExportResult.ProcessedInput next = it.next();
            JSONObject jSONObject = new JSONObject();
            MediaItem.LocalConfiguration localConfiguration = next.mediaItem.localConfiguration;
            if (localConfiguration != null) {
                jSONObject.put("mediaItemUri", localConfiguration.uri);
            }
            jSONObject.putOpt("audioDecoderName", next.audioDecoderName);
            jSONObject.putOpt("videoDecoderName", next.videoDecoderName);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
