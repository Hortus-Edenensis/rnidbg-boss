package rnidbg.boss.okhttp;

import com.hpbr.bosszhipin.module.contacts.entity.protobuf.ChatProtocol;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public final class BossApkMqttCli {
    private static final String DEFAULT_BROKER_URL = "ssl://chat.zhipin.com:443";
    private static final String DEFAULT_TOPIC = "chat";
    private static final int DEFAULT_QOS = 1;
    private static final int DEFAULT_KEEP_ALIVE = 360;
    private static final int DEFAULT_CONNECTION_TIMEOUT = 30;
    private static final int DEFAULT_WAIT_AFTER_PUBLISH_MS = 3500;
    private static final int DEFAULT_WAIT_AFTER_PRESENCE_MS = 1500;
    private static final String TLS_PROTOCOL = "TLS";
    private static final char[] CLIENT_P12_PASSWORD =
            "pJD#IW%XPWS#WPVQDVis@Z23%DH#WNZjs%dfN%D#IDPZ@hX9".toCharArray();

    private BossApkMqttCli() {}

    public static void main(String[] args) {
        Envelope envelope;
        try {
            RequestSpec spec = RequestSpec.parse(args);
            envelope = execute(spec);
        } catch (Throwable error) {
            envelope = Envelope.error(error);
        }
        System.out.println(envelope.toJson());
    }

    private static Envelope execute(RequestSpec spec) throws Exception {
        String appVersion = !isBlank(spec.appVersion) ? spec.appVersion : detectAppVersion();
        String username =
                !isBlank(spec.usernameOverride)
                        ? spec.usernameOverride
                        : spec.uid + "-" + spec.role + "-1.4-" + appVersion;
        String clientSeed = !isBlank(spec.clientSeed) ? spec.clientSeed : username;
        String clientId = sliceMd5(clientSeed);
        long timestampMs = System.currentTimeMillis();
        String password = buildPassword(spec.secretKey, timestampMs);
        boolean connected = false;
        boolean subscribed = false;
        String ackType = "";
        long ackMid = 0L;
        long ackCmid = 0L;
        String stage = "decode-payload";
        byte[] payload = Base64.getDecoder().decode(spec.payloadBase64);
        MqttClient client = null;
        InboundCollector inboundCollector = new InboundCollector();
        try {
            stage = "build-ssl-context";
            SSLSocketFactory socketFactory = buildSocketFactory(spec.apkPath);
            stage = "build-client";
            client = new MqttClient(spec.brokerUrl, clientId, new MemoryPersistence());
            client.setCallback(inboundCollector);
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setUserName(username);
            connectOptions.setPassword(password.toCharArray());
            connectOptions.setCleanSession(spec.cleanSession);
            connectOptions.setConnectionTimeout(spec.connectionTimeoutSeconds);
            connectOptions.setKeepAliveInterval(spec.keepAliveSeconds);
            connectOptions.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1);
            connectOptions.setSocketFactory(socketFactory);
            client.setTimeToWait((spec.connectionTimeoutSeconds * 1000L) + 2000L);

            stage = "connect";
            client.connect(connectOptions);
            connected = client.isConnected();
            if (spec.subscribeBeforePublish) {
                stage = "subscribe";
                client.subscribe(spec.topic, spec.qos);
                subscribed = true;
            }

            for (String prePublishBase64 : spec.prePublishPayloads) {
                if (isBlank(prePublishBase64)) {
                    continue;
                }
                stage = "publish-presence";
                MqttMessage prePublishMessage =
                        new MqttMessage(Base64.getDecoder().decode(prePublishBase64));
                prePublishMessage.setQos(spec.qos);
                prePublishMessage.setRetained(false);
                client.publish(spec.topic, prePublishMessage);
                Thread.sleep(250L);
            }
            if (spec.subscribeBeforePublish && !spec.prePublishPayloads.isEmpty()) {
                stage = "await-presence";
                inboundCollector.await(spec.waitAfterPresenceMs);
            }

            stage = "publish";
            MqttMessage message = new MqttMessage(payload);
            message.setId(spec.sequenceId);
            message.setQos(spec.qos);
            message.setRetained(false);
            MqttWireMessage publishResult = client.publish(spec.topic, message);
            if (publishResult instanceof MqttPubAck) {
                MqttPubAck pubAck = (MqttPubAck) publishResult;
                ackType = "mqtt_pub_ack";
                ackMid = pubAck.getMid();
                ackCmid = pubAck.getCmid();
            } else if (publishResult != null) {
                ackType = publishResult.getClass().getName();
            } else {
                ackType = "publish_null";
            }

            if (spec.subscribeBeforePublish && spec.waitAfterPublishMs > 0) {
                stage = "await-inbound";
                inboundCollector.await(spec.waitAfterPublishMs);
            }

            stage = "done";
            return Envelope.success(
                    spec.brokerUrl,
                    spec.topic,
                    spec.qos,
                    spec.sequenceId,
                    clientId,
                    clientSeed,
                    username,
                    appVersion,
                    payload.length,
                    timestampMs,
                    connected,
                    subscribed,
                    ackType,
                    ackMid,
                    ackCmid,
                    inboundCollector.snapshot(),
                    inboundCollector.connectionState());
        } catch (Throwable error) {
            return Envelope.failure(
                    spec.brokerUrl,
                    spec.topic,
                    spec.qos,
                    spec.sequenceId,
                    clientId,
                    clientSeed,
                    username,
                    appVersion,
                    payload.length,
                    timestampMs,
                    connected,
                    subscribed,
                    ackType,
                    ackMid,
                    ackCmid,
                    stage,
                    error,
                    inboundCollector.snapshot(),
                    inboundCollector.connectionState());
        } finally {
            try {
                if (client != null && client.isConnected()) {
                    client.disconnectForcibly(1000L, 1000L);
                }
            } catch (MqttException ignored) {
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (MqttException ignored) {
            }
        }
    }

    private static String detectAppVersion() {
        try {
            Class<?> buildConfig = Class.forName("com.hpbr.bosszhipin.BuildConfig");
            Object value = buildConfig.getField("APP_VERSION_NAME").get(null);
            if (value instanceof String && !((String) value).isEmpty()) {
                return (String) value;
            }
        } catch (Throwable ignored) {
        }
        return "14.030";
    }

    private static String buildPassword(String secretKey, long timestampMs) throws Exception {
        String timestamp = Long.toString(timestampMs);
        return sliceMd5(secretKey + timestamp) + timestamp;
    }

    private static String sliceMd5(String text) throws Exception {
        String md5 = md5(text);
        if (md5.length() < 24) {
            throw new IllegalArgumentException("md5 output shorter than expected");
        }
        return md5.substring(8, 24);
    }

    private static String md5(String text) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hash = digest.digest(text.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        StringBuilder builder = new StringBuilder(hash.length * 2);
        for (byte value : hash) {
            builder.append(Character.forDigit((value >> 4) & 0xF, 16));
            builder.append(Character.forDigit(value & 0xF, 16));
        }
        return builder.toString();
    }

    private static SSLSocketFactory buildSocketFactory(String apkPath) throws Exception {
        byte[] clientP12 = readZipEntry(apkPath, "assets/client.p12");
        byte[] serverCertificate = readZipEntry(apkPath, "assets/server.crt");

        KeyStore clientStore = KeyStore.getInstance("PKCS12");
        try (InputStream input = new ByteArrayInputStream(clientP12)) {
            clientStore.load(input, CLIENT_P12_PASSWORD);
        }

        KeyManagerFactory keyManagerFactory =
                KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(clientStore, CLIENT_P12_PASSWORD);

        KeyStore trustStore = KeyStore.getInstance("PKCS12");
        trustStore.load(null, null);
        try (InputStream input = new ByteArrayInputStream(serverCertificate)) {
            trustStore.setCertificateEntry(
                    "mqtt-server", CertificateFactory.getInstance("X.509").generateCertificate(input));
        }

        TrustManagerFactory trustManagerFactory =
                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        SSLContext sslContext = SSLContext.getInstance(TLS_PROTOCOL);
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
        return sslContext.getSocketFactory();
    }

    private static byte[] readZipEntry(String apkPath, String entryName) throws IOException {
        try (ZipFile zipFile = new ZipFile(apkPath)) {
            ZipEntry entry = zipFile.getEntry(entryName);
            if (entry == null) {
                throw new IOException("missing entry in apk: " + entryName);
            }
            try (InputStream input = zipFile.getInputStream(entry)) {
                return input.readAllBytes();
            }
        }
    }

    private static boolean parseBool(String raw, boolean defaultValue) {
        if (isBlank(raw)) {
            return defaultValue;
        }
        String normalized = raw.trim().toLowerCase(Locale.ROOT);
        if ("1".equals(normalized) || "true".equals(normalized) || "yes".equals(normalized)) {
            return true;
        }
        if ("0".equals(normalized) || "false".equals(normalized) || "no".equals(normalized)) {
            return false;
        }
        return defaultValue;
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private static final class RequestSpec {
        final String apkPath;
        final String payloadBase64;
        final String uid;
        final String role;
        final String secretKey;
        final String clientSeed;
        final String usernameOverride;
        final String appVersion;
        final String brokerUrl;
        final String topic;
        final int qos;
        final int sequenceId;
        final int keepAliveSeconds;
        final int connectionTimeoutSeconds;
        final boolean subscribeBeforePublish;
        final boolean cleanSession;
        final int waitAfterPublishMs;
        final int waitAfterPresenceMs;
        final List<String> prePublishPayloads;

        RequestSpec(
                String apkPath,
                String payloadBase64,
                String uid,
                String role,
                String secretKey,
                String clientSeed,
                String usernameOverride,
                String appVersion,
                String brokerUrl,
                String topic,
                int qos,
                int sequenceId,
                int keepAliveSeconds,
                int connectionTimeoutSeconds,
                boolean subscribeBeforePublish,
                boolean cleanSession,
                int waitAfterPublishMs,
                int waitAfterPresenceMs,
                List<String> prePublishPayloads) {
            this.apkPath = apkPath;
            this.payloadBase64 = payloadBase64;
            this.uid = uid;
            this.role = role;
            this.secretKey = secretKey;
            this.clientSeed = clientSeed;
            this.usernameOverride = usernameOverride;
            this.appVersion = appVersion;
            this.brokerUrl = brokerUrl;
            this.topic = topic;
            this.qos = qos;
            this.sequenceId = sequenceId;
            this.keepAliveSeconds = keepAliveSeconds;
            this.connectionTimeoutSeconds = connectionTimeoutSeconds;
            this.subscribeBeforePublish = subscribeBeforePublish;
            this.cleanSession = cleanSession;
            this.waitAfterPublishMs = waitAfterPublishMs;
            this.waitAfterPresenceMs = waitAfterPresenceMs;
            this.prePublishPayloads = prePublishPayloads;
        }

        static RequestSpec parse(String[] args) {
            String apkPath = null;
            String payloadBase64 = null;
            String uid = null;
            String role = null;
            String secretKey = null;
            String clientSeed = null;
            String usernameOverride = null;
            String appVersion = null;
            String brokerUrl = DEFAULT_BROKER_URL;
            String topic = DEFAULT_TOPIC;
            int qos = DEFAULT_QOS;
            int sequenceId = 1;
            int keepAliveSeconds = DEFAULT_KEEP_ALIVE;
            int connectionTimeoutSeconds = DEFAULT_CONNECTION_TIMEOUT;
            boolean subscribeBeforePublish = true;
            boolean cleanSession = true;
            int waitAfterPublishMs = DEFAULT_WAIT_AFTER_PUBLISH_MS;
            int waitAfterPresenceMs = DEFAULT_WAIT_AFTER_PRESENCE_MS;
            List<String> prePublishPayloads = new ArrayList<>();

            for (int i = 0; i < args.length; i++) {
                String current = args[i];
                if ("--apk".equals(current) && i + 1 < args.length) {
                    apkPath = args[++i];
                } else if ("--payload-base64".equals(current) && i + 1 < args.length) {
                    payloadBase64 = args[++i];
                } else if ("--uid".equals(current) && i + 1 < args.length) {
                    uid = args[++i];
                } else if ("--role".equals(current) && i + 1 < args.length) {
                    role = args[++i];
                } else if ("--secret-key".equals(current) && i + 1 < args.length) {
                    secretKey = args[++i];
                } else if ("--client-seed".equals(current) && i + 1 < args.length) {
                    clientSeed = args[++i];
                } else if ("--username".equals(current) && i + 1 < args.length) {
                    usernameOverride = args[++i];
                } else if ("--app-version".equals(current) && i + 1 < args.length) {
                    appVersion = args[++i];
                } else if ("--broker-url".equals(current) && i + 1 < args.length) {
                    brokerUrl = args[++i];
                } else if ("--topic".equals(current) && i + 1 < args.length) {
                    topic = args[++i];
                } else if ("--qos".equals(current) && i + 1 < args.length) {
                    qos = Integer.parseInt(args[++i]);
                } else if ("--sequence-id".equals(current) && i + 1 < args.length) {
                    sequenceId = Integer.parseInt(args[++i]);
                } else if ("--keep-alive".equals(current) && i + 1 < args.length) {
                    keepAliveSeconds = Integer.parseInt(args[++i]);
                } else if ("--connection-timeout".equals(current) && i + 1 < args.length) {
                    connectionTimeoutSeconds = Integer.parseInt(args[++i]);
                } else if ("--subscribe".equals(current) && i + 1 < args.length) {
                    subscribeBeforePublish = parseBool(args[++i], true);
                } else if ("--clean-session".equals(current) && i + 1 < args.length) {
                    cleanSession = parseBool(args[++i], true);
                } else if ("--wait-after-publish-ms".equals(current) && i + 1 < args.length) {
                    waitAfterPublishMs = Integer.parseInt(args[++i]);
                } else if ("--wait-after-presence-ms".equals(current) && i + 1 < args.length) {
                    waitAfterPresenceMs = Integer.parseInt(args[++i]);
                } else if ("--pre-publish-base64".equals(current) && i + 1 < args.length) {
                    prePublishPayloads.add(args[++i]);
                } else {
                    throw new IllegalArgumentException("unsupported argument: " + current);
                }
            }

            if (isBlank(apkPath)) {
                throw new IllegalArgumentException("missing --apk");
            }
            if (isBlank(payloadBase64)) {
                throw new IllegalArgumentException("missing --payload-base64");
            }
            if (isBlank(uid)) {
                throw new IllegalArgumentException("missing --uid");
            }
            if (isBlank(role)) {
                throw new IllegalArgumentException("missing --role");
            }
            if (isBlank(secretKey)) {
                throw new IllegalArgumentException("missing --secret-key");
            }
            return new RequestSpec(
                    apkPath,
                    payloadBase64,
                    uid,
                    role,
                    secretKey,
                    clientSeed,
                    usernameOverride,
                    appVersion,
                    brokerUrl,
                    topic,
                    qos,
                    sequenceId,
                    keepAliveSeconds,
                    connectionTimeoutSeconds,
                    subscribeBeforePublish,
                    cleanSession,
                    waitAfterPublishMs,
                    waitAfterPresenceMs,
                    prePublishPayloads);
        }
    }

    private static final class Envelope {
        final boolean ok;
        final String engine;
        final String brokerUrl;
        final String topic;
        final int qos;
        final int sequenceId;
        final String clientId;
        final String clientSeed;
        final String username;
        final String appVersion;
        final int payloadSize;
        final long timestampMs;
        final boolean connected;
        final boolean subscribed;
        final String publishAckType;
        final long ackMid;
        final long ackCmid;
        final String stage;
        final String error;
        final String errorType;
        final String errorCause;
        final List<InboundEvent> inboundEvents;
        final String connectionState;

        Envelope(
                boolean ok,
                String brokerUrl,
                String topic,
                int qos,
                int sequenceId,
                String clientId,
                String clientSeed,
                String username,
                String appVersion,
                int payloadSize,
                long timestampMs,
                boolean connected,
                boolean subscribed,
                String publishAckType,
                long ackMid,
                long ackCmid,
                String stage,
                String error,
                String errorType,
                String errorCause,
                List<InboundEvent> inboundEvents,
                String connectionState) {
            this.ok = ok;
            this.engine = "boss_apk_mqtt";
            this.brokerUrl = brokerUrl;
            this.topic = topic;
            this.qos = qos;
            this.sequenceId = sequenceId;
            this.clientId = clientId;
            this.clientSeed = clientSeed;
            this.username = username;
            this.appVersion = appVersion;
            this.payloadSize = payloadSize;
            this.timestampMs = timestampMs;
            this.connected = connected;
            this.subscribed = subscribed;
            this.publishAckType = publishAckType;
            this.ackMid = ackMid;
            this.ackCmid = ackCmid;
            this.stage = stage;
            this.error = error;
            this.errorType = errorType;
            this.errorCause = errorCause;
            this.inboundEvents = inboundEvents;
            this.connectionState = connectionState;
        }

        static Envelope success(
                String brokerUrl,
                String topic,
                int qos,
                int sequenceId,
                String clientId,
                String clientSeed,
                String username,
                String appVersion,
                int payloadSize,
                long timestampMs,
                boolean connected,
                boolean subscribed,
                String publishAckType,
                long ackMid,
                long ackCmid,
                List<InboundEvent> inboundEvents,
                String connectionState) {
            return new Envelope(
                    true,
                    brokerUrl,
                    topic,
                    qos,
                    sequenceId,
                    clientId,
                    clientSeed,
                    username,
                    appVersion,
                    payloadSize,
                    timestampMs,
                    connected,
                    subscribed,
                    publishAckType,
                    ackMid,
                    ackCmid,
                    "done",
                    null,
                    null,
                    null,
                    inboundEvents,
                    connectionState);
        }

        static Envelope failure(
                String brokerUrl,
                String topic,
                int qos,
                int sequenceId,
                String clientId,
                String clientSeed,
                String username,
                String appVersion,
                int payloadSize,
                long timestampMs,
                boolean connected,
                boolean subscribed,
                String publishAckType,
                long ackMid,
                long ackCmid,
                String stage,
                Throwable error,
                List<InboundEvent> inboundEvents,
                String connectionState) {
            String message = error.toString();
            if (error.getMessage() != null && !error.getMessage().isEmpty()) {
                message = error.getMessage();
            }
            Throwable cause = error.getCause();
            String errorCause = null;
            if (cause != null) {
                String causeMessage = cause.toString();
                if (cause.getMessage() != null && !cause.getMessage().isEmpty()) {
                    causeMessage = cause.getClass().getName() + ": " + cause.getMessage();
                }
                errorCause = causeMessage;
            }
            return new Envelope(
                    false,
                    brokerUrl,
                    topic,
                    qos,
                    sequenceId,
                    clientId,
                    clientSeed,
                    username,
                    appVersion,
                    payloadSize,
                    timestampMs,
                    connected,
                    subscribed,
                    publishAckType,
                    ackMid,
                    ackCmid,
                    stage,
                    message,
                    error.getClass().getName(),
                    errorCause,
                    inboundEvents,
                    connectionState);
        }

        static Envelope error(Throwable error) {
            String message = error.toString();
            if (error.getMessage() != null && !error.getMessage().isEmpty()) {
                message = error.getMessage();
            }
            return new Envelope(
                    false,
                    "",
                    "",
                    0,
                    0,
                    "",
                    "",
                    "",
                    "",
                    0,
                    0L,
                    false,
                    false,
                    "",
                    0L,
                    0L,
                    "bootstrap",
                    message,
                    error.getClass().getName(),
                    error.getCause() != null ? error.getCause().toString() : null,
                    new ArrayList<>(),
                    "");
        }

        String toJson() {
            StringBuilder json = new StringBuilder();
            json.append('{');
            json.append("\"ok\":").append(this.ok).append(',');
            json.append("\"engine\":").append(jsonString(this.engine)).append(',');
            json.append("\"broker_url\":").append(jsonString(this.brokerUrl)).append(',');
            json.append("\"topic\":").append(jsonString(this.topic)).append(',');
            json.append("\"qos\":").append(this.qos).append(',');
            json.append("\"sequence_id\":").append(this.sequenceId).append(',');
            json.append("\"client_id\":").append(jsonString(this.clientId)).append(',');
            json.append("\"client_seed\":").append(jsonString(this.clientSeed)).append(',');
            json.append("\"username\":").append(jsonString(this.username)).append(',');
            json.append("\"app_version\":").append(jsonString(this.appVersion)).append(',');
            json.append("\"payload_size\":").append(this.payloadSize).append(',');
            json.append("\"timestamp_ms\":").append(this.timestampMs).append(',');
            json.append("\"connected\":").append(this.connected).append(',');
            json.append("\"subscribed\":").append(this.subscribed).append(',');
            json.append("\"stage\":").append(jsonString(this.stage)).append(',');
            json.append("\"publish_ack_type\":").append(jsonString(this.publishAckType)).append(',');
            json.append("\"ack_mid\":").append(this.ackMid).append(',');
            json.append("\"ack_cmid\":").append(this.ackCmid);
            json.append(",\"connection_state\":").append(jsonString(this.connectionState));
            json.append(",\"inbound_event_count\":").append(this.inboundEvents.size());
            json.append(",\"business_signal\":").append(hasBusinessSignal(this.inboundEvents));
            json.append(",\"inbound_events\":").append(jsonArray(this.inboundEvents));
            if (this.error != null) {
                json.append(",\"error\":").append(jsonString(this.error));
            }
            if (this.errorType != null) {
                json.append(",\"error_type\":").append(jsonString(this.errorType));
            }
            if (this.errorCause != null) {
                json.append(",\"error_cause\":").append(jsonString(this.errorCause));
            }
            json.append('}');
            return json.toString();
        }
    }

    private static final class InboundCollector implements MqttCallbackExtended {
        private final Object monitor = new Object();
        private final List<InboundEvent> events = new CopyOnWriteArrayList<>();
        private volatile String connectionState = "";

        @Override
        public void connectComplete(boolean reconnect, String serverURI) {
            this.connectionState = reconnect ? "reconnected" : "connected";
            synchronized (this.monitor) {
                this.monitor.notifyAll();
            }
        }

        @Override
        public void connectionLost(Throwable cause) {
            String message = cause == null ? "connection_lost" : cause.toString();
            this.connectionState = message;
            synchronized (this.monitor) {
                this.monitor.notifyAll();
            }
        }

        @Override
        public void messageArrived(String topic, MqttMessage message) {
            byte[] payload = message == null ? null : message.getPayload();
            if (payload == null) {
                payload = new byte[0];
            }
            this.events.add(InboundEvent.parse(topic, payload, System.currentTimeMillis()));
            synchronized (this.monitor) {
                this.monitor.notifyAll();
            }
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken token) {
            synchronized (this.monitor) {
                this.monitor.notifyAll();
            }
        }

        void await(long timeoutMs) throws InterruptedException {
            if (timeoutMs <= 0) {
                return;
            }
            long deadline = System.currentTimeMillis() + timeoutMs;
            synchronized (this.monitor) {
                while (System.currentTimeMillis() < deadline && !hasBusinessSignal(this.events)) {
                    long remaining = deadline - System.currentTimeMillis();
                    if (remaining <= 0) {
                        break;
                    }
                    this.monitor.wait(Math.min(remaining, 250L));
                }
            }
        }

        List<InboundEvent> snapshot() {
            return new ArrayList<>(this.events);
        }

        String connectionState() {
            return this.connectionState;
        }
    }

    private static final class InboundEvent {
        final String topic;
        final long receivedAtMs;
        final int payloadSize;
        final int protocolType;
        final String protocolVersion;
        final List<InboundMessage> messages;
        final List<MessageSyncPair> messageSync;
        final String iqQuery;
        final List<KeyValue> iqResults;
        final String parseError;
        final String payloadBase64;

        InboundEvent(
                String topic,
                long receivedAtMs,
                int payloadSize,
                int protocolType,
                String protocolVersion,
                List<InboundMessage> messages,
                List<MessageSyncPair> messageSync,
                String iqQuery,
                List<KeyValue> iqResults,
                String parseError,
                String payloadBase64) {
            this.topic = topic;
            this.receivedAtMs = receivedAtMs;
            this.payloadSize = payloadSize;
            this.protocolType = protocolType;
            this.protocolVersion = protocolVersion;
            this.messages = messages;
            this.messageSync = messageSync;
            this.iqQuery = iqQuery;
            this.iqResults = iqResults;
            this.parseError = parseError;
            this.payloadBase64 = payloadBase64;
        }

        static InboundEvent parse(String topic, byte[] payload, long receivedAtMs) {
            try {
                ChatProtocol.TechwolfChatProtocol protocol =
                        ChatProtocol.TechwolfChatProtocol.parseFrom(payload);
                List<InboundMessage> messages = new ArrayList<>();
                int messageLimit = Math.min(protocol.getMessagesCount(), 3);
                for (int index = 0; index < messageLimit; index++) {
                    ChatProtocol.TechwolfMessage message = protocol.getMessages(index);
                    messages.add(
                            new InboundMessage(
                                    message.getMid(),
                                    message.getCmid(),
                                    message.getFrom().getUid(),
                                    message.getTo().getUid(),
                                    message.getBody().getText()));
                }
                List<MessageSyncPair> messageSync = new ArrayList<>();
                for (ChatProtocol.TechwolfMessageSync sync : protocol.getMessageSyncList()) {
                    messageSync.add(new MessageSyncPair(sync.getClientMid(), sync.getServerMid()));
                }
                String iqQuery = "";
                List<KeyValue> iqResults = new ArrayList<>();
                if (protocol.hasIqResponse()) {
                    ChatProtocol.TechwolfIqResponse iqResponse = protocol.getIqResponse();
                    iqQuery = iqResponse.getQuery();
                    for (ChatProtocol.TechwolfKVEntry entry : iqResponse.getResultsList()) {
                        iqResults.add(new KeyValue(entry.getKey(), entry.getValue()));
                    }
                }
                return new InboundEvent(
                        topic,
                        receivedAtMs,
                        payload.length,
                        protocol.getType(),
                        protocol.getVersion(),
                        messages,
                        messageSync,
                        iqQuery,
                        iqResults,
                        null,
                        Base64.getEncoder().encodeToString(payload));
            } catch (Throwable error) {
                String message = error.toString();
                if (error.getMessage() != null && !error.getMessage().isEmpty()) {
                    message = error.getClass().getName() + ": " + error.getMessage();
                }
                return new InboundEvent(
                        topic,
                        receivedAtMs,
                        payload.length,
                        0,
                        "",
                        new ArrayList<>(),
                        new ArrayList<>(),
                        "",
                        new ArrayList<>(),
                        message,
                        Base64.getEncoder().encodeToString(payload));
            }
        }

        boolean hasBusinessSignal() {
            return !this.messageSync.isEmpty() || "/message/pull".equals(this.iqQuery);
        }

        String toJson() {
            StringBuilder json = new StringBuilder();
            json.append('{');
            json.append("\"topic\":").append(jsonString(this.topic)).append(',');
            json.append("\"received_at_ms\":").append(this.receivedAtMs).append(',');
            json.append("\"payload_size\":").append(this.payloadSize).append(',');
            json.append("\"protocol_type\":").append(this.protocolType).append(',');
            json.append("\"protocol_version\":").append(jsonString(this.protocolVersion)).append(',');
            json.append("\"iq_query\":").append(jsonString(this.iqQuery)).append(',');
            json.append("\"message_sync\":").append(jsonArray(this.messageSync)).append(',');
            json.append("\"messages\":").append(jsonArray(this.messages)).append(',');
            json.append("\"iq_results\":").append(jsonArray(this.iqResults)).append(',');
            json.append("\"business_signal\":").append(this.hasBusinessSignal());
            if (this.parseError != null) {
                json.append(",\"parse_error\":").append(jsonString(this.parseError));
            }
            json.append(",\"payload_base64\":").append(jsonString(this.payloadBase64));
            json.append('}');
            return json.toString();
        }
    }

    private static final class InboundMessage {
        final long mid;
        final long cmid;
        final long fromUid;
        final long toUid;
        final String text;

        InboundMessage(long mid, long cmid, long fromUid, long toUid, String text) {
            this.mid = mid;
            this.cmid = cmid;
            this.fromUid = fromUid;
            this.toUid = toUid;
            this.text = text;
        }

        String toJson() {
            return "{"
                    + "\"mid\":" + this.mid
                    + ",\"cmid\":" + this.cmid
                    + ",\"from_uid\":" + this.fromUid
                    + ",\"to_uid\":" + this.toUid
                    + ",\"text\":" + jsonString(this.text)
                    + "}";
        }
    }

    private static final class MessageSyncPair {
        final long clientMid;
        final long serverMid;

        MessageSyncPair(long clientMid, long serverMid) {
            this.clientMid = clientMid;
            this.serverMid = serverMid;
        }

        String toJson() {
            return "{"
                    + "\"client_mid\":" + this.clientMid
                    + ",\"server_mid\":" + this.serverMid
                    + "}";
        }
    }

    private static final class KeyValue {
        final String key;
        final String value;

        KeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }

        String toJson() {
            return "{"
                    + "\"key\":" + jsonString(this.key)
                    + ",\"value\":" + jsonString(this.value)
                    + "}";
        }
    }

    private static boolean hasBusinessSignal(List<InboundEvent> events) {
        for (InboundEvent event : events) {
            if (event != null && event.hasBusinessSignal()) {
                return true;
            }
        }
        return false;
    }

    private static String jsonArray(List<?> values) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        boolean first = true;
        for (Object value : values) {
            if (!first) {
                builder.append(',');
            }
            first = false;
            if (value instanceof InboundEvent) {
                builder.append(((InboundEvent) value).toJson());
            } else if (value instanceof InboundMessage) {
                builder.append(((InboundMessage) value).toJson());
            } else if (value instanceof MessageSyncPair) {
                builder.append(((MessageSyncPair) value).toJson());
            } else if (value instanceof KeyValue) {
                builder.append(((KeyValue) value).toJson());
            } else if (value == null) {
                builder.append("null");
            } else {
                builder.append(jsonString(value.toString()));
            }
        }
        builder.append(']');
        return builder.toString();
    }

    private static String jsonString(String value) {
        if (value == null) {
            return "null";
        }
        StringBuilder escaped = new StringBuilder(value.length() + 16);
        escaped.append('"');
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            switch (ch) {
                case '"':
                    escaped.append("\\\"");
                    break;
                case '\\':
                    escaped.append("\\\\");
                    break;
                case '\b':
                    escaped.append("\\b");
                    break;
                case '\f':
                    escaped.append("\\f");
                    break;
                case '\n':
                    escaped.append("\\n");
                    break;
                case '\r':
                    escaped.append("\\r");
                    break;
                case '\t':
                    escaped.append("\\t");
                    break;
                default:
                    if (ch < 0x20) {
                        escaped.append(String.format(Locale.ROOT, "\\u%04x", (int) ch));
                    } else {
                        escaped.append(ch);
                    }
            }
        }
        escaped.append('"');
        return escaped.toString();
    }
}
