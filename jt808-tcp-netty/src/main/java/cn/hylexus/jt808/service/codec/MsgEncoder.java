package cn.hylexus.jt808.service.codec;

import java.util.Arrays;

import cn.hylexus.jt808.common.TPMSConsts;
import cn.hylexus.jt808.util.BitOperator;
import cn.hylexus.jt808.util.JT808ProtocolUtils;
import cn.hylexus.jt808.vo.PackageData;
import cn.hylexus.jt808.vo.Session;
import cn.hylexus.jt808.vo.req.TerminalRegisterMsg;
import cn.hylexus.jt808.vo.resp.ServerCommonRespMsgBody;
import cn.hylexus.jt808.vo.resp.TerminalRegisterMsgRespBody;

public class MsgEncoder {
	private BitOperator bitOperator;
	private JT808ProtocolUtils jt808ProtocolUtils;

	public MsgEncoder() {
		this.bitOperator = new BitOperator();
		this.jt808ProtocolUtils = new JT808ProtocolUtils();
	}

	public byte[] encode4TerminalRegisterResp(TerminalRegisterMsg req, TerminalRegisterMsgRespBody respMsgBody,
			int flowId) throws Exception {
		// 消息体字节数组
		byte[] msgBody = null;
		// 鉴权码(STRING) 只有在成功后才有该字段
		if (respMsgBody.getReplyCode() == TerminalRegisterMsgRespBody.success) {
			msgBody = this.bitOperator.concatAll(Arrays.asList(//
					bitOperator.integerTo2Bytes(respMsgBody.getReplyFlowId()), // 流水号(2)
					new byte[] { respMsgBody.getReplyCode() }, // 结果
					respMsgBody.getReplyToken().getBytes(TPMSConsts.string_charset)// 鉴权码(STRING)
			));
		} else {
			msgBody = this.bitOperator.concatAll(Arrays.asList(//
					bitOperator.integerTo2Bytes(respMsgBody.getReplyFlowId()), // 流水号(2)
					new byte[] { respMsgBody.getReplyCode() }// 错误代码
			));
		}

		// 消息头
		int msgBodyProps = this.jt808ProtocolUtils.generateMsgBodyProps(msgBody.length, 0b000, false, 0);
		byte[] msgHeader = this.jt808ProtocolUtils.generateMsgHeader(req.getMsgHeader().getTerminalPhone(),
				TPMSConsts.cmd_terminal_register_resp, msgBody, msgBodyProps, flowId);
		byte[] headerAndBody = this.bitOperator.concatAll(msgHeader, msgBody);

		// 校验码
		int checkSum = this.bitOperator.getCheckSum4JT808(headerAndBody, 0, headerAndBody.length);
		// 连接并且转义
		return this.doEncode(headerAndBody, checkSum);
	}

	// public byte[] encode4ServerCommonRespMsg(TerminalAuthenticationMsg req,
	// ServerCommonRespMsgBody respMsgBody, int flowId) throws Exception {
	public byte[] encode4ServerCommonRespMsg(PackageData req, ServerCommonRespMsgBody respMsgBody, int flowId)
			throws Exception {
		byte[] msgBody = this.bitOperator.concatAll(Arrays.asList(//
				bitOperator.integerTo2Bytes(respMsgBody.getReplyFlowId()), // 应答流水号
				bitOperator.integerTo2Bytes(respMsgBody.getReplyId()), // 应答ID,对应的终端消息的ID
				new byte[] { respMsgBody.getReplyCode() }// 结果
		));

		// 消息头
		int msgBodyProps = this.jt808ProtocolUtils.generateMsgBodyProps(msgBody.length, 0b000, false, 0);
		byte[] msgHeader = this.jt808ProtocolUtils.generateMsgHeader(req.getMsgHeader().getTerminalPhone(),
				TPMSConsts.cmd_common_resp, msgBody, msgBodyProps, flowId);
		byte[] headerAndBody = this.bitOperator.concatAll(msgHeader, msgBody);
		// 校验码
		int checkSum = this.bitOperator.getCheckSum4JT808(headerAndBody, 0, headerAndBody.length);
		// 连接并且转义
		return this.doEncode(headerAndBody, checkSum);
	}

	public byte[] encode4ParamSetting(byte[] msgBodyBytes, Session session) throws Exception {
		// 消息头
		int msgBodyProps = this.jt808ProtocolUtils.generateMsgBodyProps(msgBodyBytes.length, 0b000, false, 0);
		byte[] msgHeader = this.jt808ProtocolUtils.generateMsgHeader(session.getTerminalPhone(),
				TPMSConsts.cmd_terminal_param_settings, msgBodyBytes, msgBodyProps, session.currentFlowId());
		// 连接消息头和消息体
		byte[] headerAndBody = this.bitOperator.concatAll(msgHeader, msgBodyBytes);
		// 校验码
		int checkSum = this.bitOperator.getCheckSum4JT808(headerAndBody, 0, headerAndBody.length);
		// 连接并且转义
		return this.doEncode(headerAndBody, checkSum);
	}

	private byte[] doEncode(byte[] headerAndBody, int checkSum) throws Exception {
		byte[] noEscapedBytes = this.bitOperator.concatAll(Arrays.asList(//
				new byte[] { TPMSConsts.pkg_delimiter }, // 0x7e
				headerAndBody, // 消息头+ 消息体
				bitOperator.integerTo1Bytes(checkSum), // 校验码
				new byte[] { TPMSConsts.pkg_delimiter }// 0x7e
		));
		// 转义
		return jt808ProtocolUtils.doEscape4Send(noEscapedBytes, 1, noEscapedBytes.length - 2);
	}
}
