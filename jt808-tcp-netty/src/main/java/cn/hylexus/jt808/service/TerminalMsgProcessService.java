package cn.hylexus.jt808.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import cn.hylexus.jt808.server.SessionManager;
import cn.hylexus.jt808.service.codec.MsgEncoder;
import cn.hylexus.jt808.vo.PackageData;
import cn.hylexus.jt808.vo.PackageData.MsgHeader;
import cn.hylexus.jt808.vo.Session;
import cn.hylexus.jt808.vo.req.TerminalAuthenticationMsg;
import cn.hylexus.jt808.vo.req.TerminalRegisterMsg;
import cn.hylexus.jt808.vo.resp.ServerCommonRespMsgBody;
import cn.hylexus.jt808.vo.resp.TerminalRegisterMsgRespBody;

public class TerminalMsgProcessService extends BaseMsgProcessService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private final Logger weblog = LoggerFactory.getLogger("weblog");
	private MsgEncoder msgEncoder;
	private SessionManager sessionManager;

	public TerminalMsgProcessService() {
		this.msgEncoder = new MsgEncoder();
		this.sessionManager = SessionManager.getInstance();
	}

	public void processRegisterMsg(TerminalRegisterMsg msg) throws Exception {
		log.debug("终端注册:{}", JSON.toJSONString(msg, true));
		weblog.info("终端注册:{}", JSON.toJSONString(msg, true));

		final String sessionId = Session.buildId(msg.getChannel());
		Session session = sessionManager.findBySessionId(sessionId);
		if (session == null) {
			session = Session.buildSession(msg.getChannel(), msg.getMsgHeader().getTerminalPhone());
		}
		session.setAuthenticated(true);
		session.setTerminalPhone(msg.getMsgHeader().getTerminalPhone());
		sessionManager.put(session.getId(), session);

		TerminalRegisterMsgRespBody respMsgBody = new TerminalRegisterMsgRespBody();
		respMsgBody.setReplyCode(TerminalRegisterMsgRespBody.success);
		respMsgBody.setReplyFlowId(msg.getMsgHeader().getFlowId());
		// TODO 鉴权码暂时写死
		respMsgBody.setReplyToken("123");
		int flowId = super.getFlowId(msg.getChannel());
		byte[] bs = this.msgEncoder.encode4TerminalRegisterResp(msg, respMsgBody, flowId);

		super.send2Client(msg.getChannel(), bs);
	}

	public void processAuthMsg(TerminalAuthenticationMsg msg) throws Exception {
		// TODO 暂时每次鉴权都成功

		log.debug("终端鉴权:{}", JSON.toJSONString(msg, true));
		weblog.info("终端鉴权:{}", JSON.toJSONString(msg, true));

		final String sessionId = Session.buildId(msg.getChannel());
		Session session = sessionManager.findBySessionId(sessionId);
		if (session == null) {
			session = Session.buildSession(msg.getChannel(), msg.getMsgHeader().getTerminalPhone());
		}
		session.setAuthenticated(true);
		session.setTerminalPhone(msg.getMsgHeader().getTerminalPhone());
		sessionManager.put(session.getId(), session);

		ServerCommonRespMsgBody respMsgBody = new ServerCommonRespMsgBody();
		respMsgBody.setReplyCode(ServerCommonRespMsgBody.success);
		respMsgBody.setReplyFlowId(msg.getMsgHeader().getFlowId());
		respMsgBody.setReplyId(msg.getMsgHeader().getMsgId());
		int flowId = super.getFlowId(msg.getChannel());
		byte[] bs = this.msgEncoder.encode4ServerCommonRespMsg(msg, respMsgBody, flowId);
		super.send2Client(msg.getChannel(), bs);
	}

	public void processTerminalHeartBeatMsg(PackageData req) throws Exception {
		log.debug("心跳信息:{}", JSON.toJSONString(req, true));
		final MsgHeader reqHeader = req.getMsgHeader();
		ServerCommonRespMsgBody respMsgBody = new ServerCommonRespMsgBody(reqHeader.getFlowId(), reqHeader.getMsgId(),
				ServerCommonRespMsgBody.success);
		int flowId = super.getFlowId(req.getChannel());
		byte[] bs = this.msgEncoder.encode4ServerCommonRespMsg(req, respMsgBody, flowId);
		super.send2Client(req.getChannel(), bs);
	}

	public void processTerminalLogoutMsg(PackageData req) throws Exception {
		log.info("终端注销:{}", JSON.toJSONString(req, true));
		final MsgHeader reqHeader = req.getMsgHeader();
		ServerCommonRespMsgBody respMsgBody = new ServerCommonRespMsgBody(reqHeader.getFlowId(), reqHeader.getMsgId(),
				ServerCommonRespMsgBody.success);
		int flowId = super.getFlowId(req.getChannel());
		byte[] bs = this.msgEncoder.encode4ServerCommonRespMsg(req, respMsgBody, flowId);
		super.send2Client(req.getChannel(), bs);
	}

}
