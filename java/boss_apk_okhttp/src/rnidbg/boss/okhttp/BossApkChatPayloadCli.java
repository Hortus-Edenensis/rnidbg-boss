package rnidbg.boss.okhttp;

import com.hpbr.bosszhipin.module.contacts.entity.ChatBean;
import com.hpbr.bosszhipin.module.contacts.entity.protobuf.ChatMessageBean;
import com.hpbr.bosszhipin.module.contacts.entity.protobuf.ChatMessageBodyBean;
import com.hpbr.bosszhipin.module.contacts.entity.protobuf.ChatProtocol;
import com.hpbr.bosszhipin.module.contacts.entity.protobuf.ChatUserBean;
import com.hpbr.bosszhipin.module.contacts.service.ChatBeanFactory;
import com.hpbr.bosszhipin.module.contacts.manager.i;
import com.hpbr.bosszhipin.data.manager.r;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Locale;
import message.handler.d;

public final class BossApkChatPayloadCli {
    private static final int CHAT_PROTOCOL_TYPE_MESSAGE = 1;
    private static final int CHAT_MESSAGE_TYPE_TEXT = 1;
    private static final int CHAT_MESSAGE_TEMPLATE_TEXT = 1;
    private static final int CHAT_MESSAGE_STATUS_SENT = 2;
    private static final String CHAT_PROTOCOL_VERSION = "1.4";
    private static final String SERIALIZER_MODE_SERIALIZER = "serializer";
    private static final String SERIALIZER_MODE_PATCHED = "patched";
    private static final String SERIALIZER_MODE_MANUAL = "manual";

    private BossApkChatPayloadCli() {}

    public static void main(String[] args) {
        try {
            RequestSpec spec = RequestSpec.parse(args);
            BuildOutput manualOutput = buildManual(spec);
            BuildOutput factoryOutput = null;
            String factoryError = null;
            BuildOutput serializerOutput = null;
            String serializerError = null;
            if (!SERIALIZER_MODE_MANUAL.equals(spec.serializerMode)) {
                try {
                    factoryOutput = buildWithApkFactory(spec);
                } catch (Throwable factoryFailure) {
                    factoryError = factoryFailure.toString();
                    if (factoryFailure.getMessage() != null
                            && !factoryFailure.getMessage().isEmpty()) {
                        factoryError = factoryFailure.getMessage();
                    }
                }
                try {
                    serializerOutput = buildWithApkSerializer(spec);
                } catch (Throwable serializerFailure) {
                    serializerError = serializerFailure.toString();
                    if (serializerFailure.getMessage() != null
                            && !serializerFailure.getMessage().isEmpty()) {
                        serializerError = serializerFailure.getMessage();
                    }
                }
            }
            BuildOutput selected =
                    selectBestOutput(spec, manualOutput, factoryOutput, serializerOutput);
            ChatProtocol.TechwolfChatProtocol protocol = selected.protocol;
            String serializedSecurityId = extractSecurityId(protocol);
            System.out.println(
                    "{"
                            + "\"ok\":true,"
                            + "\"engine\":\"boss_apk_chat_payload\","
                            + "\"serializer_mode\":"
                            + jsonString(spec.serializerMode)
                            + ",\"selected_builder\":"
                            + jsonString(selected.builder)
                            + ",\"serializer\":\"module.contacts.manager.i.F().a(chatBean) with manual fallback\","
                            + "\"payload_base64\":"
                            + jsonString(Base64.getEncoder().encodeToString(selected.payload))
                            + ",\"payload_hex\":"
                            + jsonString(toHex(selected.payload))
                            + ",\"payload_size\":"
                            + selected.payload.length
                            + ",\"protocol_type\":"
                            + protocol.getType()
                            + ",\"protocol_version\":"
                            + jsonString(protocol.getVersion())
                            + ",\"client_temp_message_id\":"
                            + spec.clientTempMessageId
                            + ",\"timestamp_ms\":"
                            + spec.timestampMs
                            + ",\"serialized_security_id\":"
                            + jsonString(serializedSecurityId)
                            + ",\"spec_security_id\":"
                            + jsonString(spec.securityId)
                            + ",\"payload_compare\":{"
                            + "\"equal\":"
                            + ((factoryOutput != null
                                            && Arrays.equals(factoryOutput.payload, manualOutput.payload))
                                    || (serializerOutput != null
                                            && Arrays.equals(serializerOutput.payload, manualOutput.payload)))
                            + ",\"factory_matches_serializer\":"
                            + (factoryOutput != null
                                    && serializerOutput != null
                                    && Arrays.equals(factoryOutput.payload, serializerOutput.payload))
                            + ",\"factory_available\":"
                            + (factoryOutput != null)
                            + ",\"factory_error\":"
                            + jsonString(factoryError)
                            + ",\"factory_payload_size\":"
                            + (factoryOutput != null ? factoryOutput.payload.length : 0)
                            + ",\"factory_security_id\":"
                            + jsonString(
                                    factoryOutput != null
                                            ? extractSecurityId(factoryOutput.protocol)
                                            : "")
                            + ",\"serializer_available\":"
                            + (serializerOutput != null)
                            + ",\"serializer_error\":"
                            + jsonString(serializerError)
                            + ",\"serializer_payload_size\":"
                            + (serializerOutput != null ? serializerOutput.payload.length : 0)
                            + ",\"manual_payload_size\":"
                            + manualOutput.payload.length
                            + ",\"serializer_security_id\":"
                            + jsonString(
                                    serializerOutput != null
                                            ? extractSecurityId(serializerOutput.protocol)
                                            : "")
                            + ",\"manual_security_id\":"
                            + jsonString(extractSecurityId(manualOutput.protocol))
                            + "}"
                            + ",\"payload_variants\":{"
                            + "\"selected\":"
                            + buildOutputJson(selected)
                            + ",\"factory\":"
                            + (factoryOutput != null ? buildOutputJson(factoryOutput) : "null")
                            + ",\"serializer\":"
                            + (serializerOutput != null ? buildOutputJson(serializerOutput) : "null")
                            + ",\"manual\":"
                            + buildOutputJson(manualOutput)
                            + "}"
                            + ",\"biz_type\":"
                            + spec.bizType
                            + ",\"quote_id\":"
                            + spec.quoteId
                            + ",\"task_id\":"
                            + spec.taskId
                            + "}");
        } catch (Throwable error) {
            String message = error.toString();
            if (error.getMessage() != null && !error.getMessage().isEmpty()) {
                message = error.getMessage();
            }
            System.out.println(
                    "{"
                            + "\"ok\":false,"
                            + "\"engine\":\"boss_apk_chat_payload\","
                            + "\"error\":"
                            + jsonString(message)
                            + ",\"error_type\":"
                            + jsonString(error.getClass().getName())
                            + "}");
        }
    }

    private static String buildOutputJson(BuildOutput output) {
        return "{"
                + "\"builder\":"
                + jsonString(output.builder)
                + ",\"payload_base64\":"
                + jsonString(Base64.getEncoder().encodeToString(output.payload))
                + ",\"payload_hex\":"
                + jsonString(toHex(output.payload))
                + ",\"payload_size\":"
                + output.payload.length
                + ",\"protocol_type\":"
                + output.protocol.getType()
                + ",\"protocol_version\":"
                + jsonString(output.protocol.getVersion())
                + ",\"serialized_security_id\":"
                + jsonString(extractSecurityId(output.protocol))
                + "}";
    }

    private static BuildOutput buildManual(RequestSpec spec) {
        ChatProtocol.TechwolfUser.Builder fromUser = ChatProtocol.TechwolfUser.newBuilder();
        fromUser.setUid(spec.senderUid);
        fromUser.setSource(spec.senderSource);
        if (!isBlank(spec.senderName)) {
            fromUser.setName(spec.senderName);
        }

        ChatProtocol.TechwolfUser.Builder toUser = ChatProtocol.TechwolfUser.newBuilder();
        toUser.setUid(spec.friendUid);
        toUser.setSource(spec.friendSource);
        if (!isBlank(spec.friendName)) {
            toUser.setName(spec.friendName);
        }

        ChatProtocol.TechwolfMessageBody.Builder body = ChatProtocol.TechwolfMessageBody.newBuilder();
        body.setType(CHAT_MESSAGE_TYPE_TEXT);
        body.setTemplateId(CHAT_MESSAGE_TEMPLATE_TEXT);
        if (!isBlank(spec.text)) {
            body.setText(spec.text);
        }
        if (!isBlank(spec.extend)) {
            body.setExtend(spec.extend);
        }

        ChatProtocol.TechwolfMessage.Builder message = ChatProtocol.TechwolfMessage.newBuilder();
        message.setFrom(fromUser);
        message.setTo(toUser);
        if (!isBlank(spec.bizId)) {
            message.setBizId(spec.bizId);
        }
        message.setQuoteId(spec.quoteId);
        message.setBizType(spec.bizType);
        message.setType(CHAT_PROTOCOL_TYPE_MESSAGE);
        message.setMid(spec.clientTempMessageId);
        message.setTime(spec.timestampMs);
        message.setBody(body);
        message.setPushText("");
        message.setTaskId(spec.taskId);
        message.setOffline(false);
        message.setCmid(spec.clientTempMessageId);
        message.setStatus(CHAT_MESSAGE_STATUS_SENT);
        message.setUncount(0);
        if (!isBlank(spec.securityId)) {
            message.setSecurityId(spec.securityId);
        }

        ChatProtocol.TechwolfChatProtocol.Builder protocol = ChatProtocol.TechwolfChatProtocol.newBuilder();
        protocol.setType(CHAT_PROTOCOL_TYPE_MESSAGE);
        protocol.setVersion(CHAT_PROTOCOL_VERSION);
        protocol.addMessages(message);
        ChatProtocol.TechwolfChatProtocol built = protocol.build();
        return new BuildOutput("manual_builder", built, built.toByteArray());
    }

    private static BuildOutput buildWithApkFactory(RequestSpec spec) {
        r.configureRuntimeUser(spec.senderUid, spec.senderRole, spec.senderName);
        d chatContext = new d();
        chatContext.c = spec.friendUid;
        chatContext.b = spec.friendName;

        ChatBean chatBean = ChatBeanFactory.getInstance().createText(chatContext, spec.text, spec.friendSource);
        if (chatBean == null) {
            throw new IllegalStateException("ChatBeanFactory.createText returned null");
        }
        if (chatBean.message == null) {
            throw new IllegalStateException("ChatBeanFactory.createText produced no message");
        }

        chatBean.clientTempMessageId = spec.clientTempMessageId;
        chatBean.time = spec.timestampMs;
        chatBean.messageSendTime = spec.timestampMs;
        chatBean.fromUserId = spec.senderUid;
        chatBean.toUserId = spec.friendUid;

        ChatMessageBean message = chatBean.message;
        message.clientTempMessageId = spec.clientTempMessageId;
        message.time = spec.timestampMs;
        message.taskId = spec.taskId;
        message.quoteId = spec.quoteId;
        message.bizId = spec.bizId;
        message.bizType = spec.bizType;
        message.pushText = "";
        message.status = CHAT_MESSAGE_STATUS_SENT;
        message.unCount = 0;
        message.securityId = spec.securityId;
        if (message.fromUser != null) {
            message.fromUser.id = spec.senderUid;
            message.fromUser.name = spec.senderName;
            message.fromUser.friendSource = spec.senderSource;
        }
        if (message.toUser != null) {
            message.toUser.id = spec.friendUid;
            message.toUser.name = spec.friendName;
            message.toUser.friendSource = spec.friendSource;
        }
        if (message.messageBody != null) {
            message.messageBody.text = spec.text;
            message.messageBody.extend = spec.extend;
        }

        ChatProtocol.TechwolfChatProtocol protocol = i.F().a(chatBean);
        if (protocol == null) {
            throw new IllegalStateException("ChatBeanFactory serializer returned null payload");
        }
        return new BuildOutput("apk_chat_bean_factory", protocol, protocol.toByteArray());
    }

    private static BuildOutput buildWithApkSerializer(RequestSpec spec) {
        ChatBean chatBean = new ChatBean();
        chatBean.msgType = CHAT_PROTOCOL_TYPE_MESSAGE;
        chatBean.version = CHAT_PROTOCOL_VERSION;
        chatBean.clientTempMessageId = spec.clientTempMessageId;
        chatBean.msgId = 0L;
        chatBean.sortMsgId = 0L;
        chatBean.domain = 1;
        chatBean.time = spec.timestampMs;
        chatBean.messageSendTime = spec.timestampMs;
        chatBean.status = 0;
        chatBean.myUserId = spec.senderUid;
        chatBean.fromUserId = spec.senderUid;
        chatBean.toUserId = spec.friendUid;

        ChatMessageBean message = new ChatMessageBean();
        message.fromUser = new ChatUserBean();
        message.fromUser.id = spec.senderUid;
        message.fromUser.name = spec.senderName;
        message.fromUser.friendSource = spec.senderSource;

        message.toUser = new ChatUserBean();
        message.toUser.id = spec.friendUid;
        message.toUser.name = spec.friendName;
        message.toUser.friendSource = spec.friendSource;

        message.type = CHAT_PROTOCOL_TYPE_MESSAGE;
        message.id = 0L;
        message.clientTempMessageId = spec.clientTempMessageId;
        message.time = spec.timestampMs;
        message.isOffline = false;
        message.status = CHAT_MESSAGE_STATUS_SENT;
        message.unCount = 0;
        message.pushText = "";
        message.taskId = spec.taskId;
        message.quoteId = spec.quoteId;
        message.bizId = spec.bizId;
        message.bizType = spec.bizType;
        message.securityId = spec.securityId;

        ChatMessageBodyBean body = new ChatMessageBodyBean();
        body.type = CHAT_MESSAGE_TYPE_TEXT;
        body.templateId = CHAT_MESSAGE_TEMPLATE_TEXT;
        body.title = "";
        body.text = spec.text;
        body.extend = spec.extend;
        message.messageBody = body;
        chatBean.message = message;

        ChatProtocol.TechwolfChatProtocol protocol = i.F().a(chatBean);
        if (protocol == null) {
            throw new IllegalStateException("apk serializer returned null payload");
        }
        return new BuildOutput("apk_serializer", protocol, protocol.toByteArray());
    }

    private static String extractSecurityId(ChatProtocol.TechwolfChatProtocol protocol) {
        if (protocol.getMessagesCount() == 0) {
            return "";
        }
        ChatProtocol.TechwolfMessage message = protocol.getMessages(0);
        return message.hasSecurityId() ? message.getSecurityId() : "";
    }

    private static BuildOutput selectBestOutput(
            RequestSpec spec,
            BuildOutput manualOutput,
            BuildOutput factoryOutput,
            BuildOutput serializerOutput) {
        if (SERIALIZER_MODE_MANUAL.equals(spec.serializerMode)) {
            return manualOutput;
        }
        if (SERIALIZER_MODE_PATCHED.equals(spec.serializerMode)) {
            BuildOutput patched =
                    buildWithPatchedSecurityId(spec, serializerOutput, factoryOutput);
            if (patched != null) {
                return patched;
            }
            return manualOutput;
        }
        BuildOutput[] apkCandidates = new BuildOutput[] {serializerOutput, factoryOutput};
        for (BuildOutput candidate : apkCandidates) {
            if (candidate != null && candidate.payload != null && candidate.payload.length > 0) {
                return candidate;
            }
        }
        return manualOutput;
    }

    private static BuildOutput buildWithPatchedSecurityId(
            RequestSpec spec, BuildOutput serializerOutput, BuildOutput factoryOutput) {
        BuildOutput base = serializerOutput != null ? serializerOutput : factoryOutput;
        if (base == null || base.protocol == null) {
            return null;
        }
        ChatProtocol.TechwolfChatProtocol.Builder protocolBuilder = base.protocol.toBuilder();
        if (protocolBuilder.getMessagesCount() <= 0 || isBlank(spec.securityId)) {
            ChatProtocol.TechwolfChatProtocol protocol = protocolBuilder.build();
            return new BuildOutput("apk_serializer_with_security_id", protocol, protocol.toByteArray());
        }
        ChatProtocol.TechwolfMessage.Builder messageBuilder =
                protocolBuilder.getMessages(0).toBuilder();
        messageBuilder.setSecurityId(spec.securityId);
        protocolBuilder.setMessages(0, messageBuilder.build());
        ChatProtocol.TechwolfChatProtocol protocol = protocolBuilder.build();
        return new BuildOutput("apk_serializer_with_security_id", protocol, protocol.toByteArray());
    }

    private static String toHex(byte[] payload) {
        StringBuilder builder = new StringBuilder(payload.length * 2);
        for (byte value : payload) {
            builder.append(Character.forDigit((value >> 4) & 0xF, 16));
            builder.append(Character.forDigit(value & 0xF, 16));
        }
        return builder.toString();
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
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

    private static final class BuildOutput {
        final String builder;
        final ChatProtocol.TechwolfChatProtocol protocol;
        final byte[] payload;

        BuildOutput(String builder, ChatProtocol.TechwolfChatProtocol protocol, byte[] payload) {
            this.builder = builder;
            this.protocol = protocol;
            this.payload = payload;
        }
    }

    private static final class RequestSpec {
        final long senderUid;
        final String senderName;
        final int senderRole;
        final int senderSource;
        final long friendUid;
        final String friendName;
        final int friendSource;
        final String securityId;
        final String text;
        final String extend;
        final String bizId;
        final int bizType;
        final long taskId;
        final long quoteId;
        final long clientTempMessageId;
        final long timestampMs;
        final String serializerMode;

        RequestSpec(
                long senderUid,
                String senderName,
                int senderRole,
                int senderSource,
                long friendUid,
                String friendName,
                int friendSource,
                String securityId,
                String text,
                String extend,
                String bizId,
                int bizType,
                long taskId,
                long quoteId,
                long clientTempMessageId,
                long timestampMs,
                String serializerMode) {
            this.senderUid = senderUid;
            this.senderName = senderName;
            this.senderRole = senderRole;
            this.senderSource = senderSource;
            this.friendUid = friendUid;
            this.friendName = friendName;
            this.friendSource = friendSource;
            this.securityId = securityId;
            this.text = text;
            this.extend = extend;
            this.bizId = bizId;
            this.bizType = bizType;
            this.taskId = taskId;
            this.quoteId = quoteId;
            this.clientTempMessageId = clientTempMessageId;
            this.timestampMs = timestampMs;
            this.serializerMode = serializerMode;
        }

        static RequestSpec parse(String[] args) {
            Long senderUid = null;
            String senderName = "";
            int senderRole = 0;
            int senderSource = 0;
            Long friendUid = null;
            String friendName = "";
            Integer friendSource = null;
            String securityId = "";
            String text = null;
            String extend = "";
            String bizId = "";
            int bizType = 0;
            long taskId = 0L;
            long quoteId = 0L;
            Long clientTempMessageId = null;
            Long timestampMs = null;
            String serializerMode = SERIALIZER_MODE_SERIALIZER;
            for (int i = 0; i < args.length; i++) {
                String current = args[i];
                if ("--sender-uid".equals(current) && i + 1 < args.length) {
                    senderUid = Long.parseLong(args[++i]);
                } else if ("--sender-name".equals(current) && i + 1 < args.length) {
                    senderName = args[++i];
                } else if ("--sender-role".equals(current) && i + 1 < args.length) {
                    senderRole = Integer.parseInt(args[++i]);
                } else if ("--sender-source".equals(current) && i + 1 < args.length) {
                    senderSource = Integer.parseInt(args[++i]);
                } else if ("--friend-uid".equals(current) && i + 1 < args.length) {
                    friendUid = Long.parseLong(args[++i]);
                } else if ("--friend-name".equals(current) && i + 1 < args.length) {
                    friendName = args[++i];
                } else if ("--friend-source".equals(current) && i + 1 < args.length) {
                    friendSource = Integer.parseInt(args[++i]);
                } else if ("--security-id".equals(current) && i + 1 < args.length) {
                    securityId = args[++i];
                } else if ("--text".equals(current) && i + 1 < args.length) {
                    text =
                            new String(
                                    args[++i].getBytes(StandardCharsets.UTF_8),
                                    StandardCharsets.UTF_8);
                } else if ("--extend".equals(current) && i + 1 < args.length) {
                    extend = args[++i];
                } else if ("--biz-id".equals(current) && i + 1 < args.length) {
                    bizId = args[++i];
                } else if ("--biz-type".equals(current) && i + 1 < args.length) {
                    bizType = Integer.parseInt(args[++i]);
                } else if ("--task-id".equals(current) && i + 1 < args.length) {
                    taskId = Long.parseLong(args[++i]);
                } else if ("--quote-id".equals(current) && i + 1 < args.length) {
                    quoteId = Long.parseLong(args[++i]);
                } else if ("--cmid".equals(current) && i + 1 < args.length) {
                    clientTempMessageId = Long.parseLong(args[++i]);
                } else if ("--timestamp-ms".equals(current) && i + 1 < args.length) {
                    timestampMs = Long.parseLong(args[++i]);
                } else if ("--serializer-mode".equals(current) && i + 1 < args.length) {
                    serializerMode = args[++i].trim().toLowerCase(Locale.ROOT);
                } else {
                    throw new IllegalArgumentException("unsupported argument: " + current);
                }
            }
            if (!SERIALIZER_MODE_MANUAL.equals(serializerMode)
                    && !SERIALIZER_MODE_PATCHED.equals(serializerMode)
                    && !SERIALIZER_MODE_SERIALIZER.equals(serializerMode)) {
                serializerMode = SERIALIZER_MODE_SERIALIZER;
            }
            if (senderUid == null) {
                throw new IllegalArgumentException("missing --sender-uid");
            }
            if (friendUid == null) {
                throw new IllegalArgumentException("missing --friend-uid");
            }
            if (friendSource == null) {
                throw new IllegalArgumentException("missing --friend-source");
            }
            if (isBlank(text)) {
                throw new IllegalArgumentException("missing --text");
            }
            if (clientTempMessageId == null) {
                throw new IllegalArgumentException("missing --cmid");
            }
            if (timestampMs == null) {
                throw new IllegalArgumentException("missing --timestamp-ms");
            }
            return new RequestSpec(
                    senderUid,
                    senderName,
                    senderRole,
                    senderSource,
                    friendUid,
                    friendName,
                    friendSource,
                    securityId,
                    text,
                    extend,
                    bizId,
                    bizType,
                    taskId,
                    quoteId,
                    clientTempMessageId,
                    timestampMs,
                    serializerMode);
        }
    }
}
