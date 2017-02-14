package cn.hylexus.jt808.vo.req;

import java.util.Arrays;

import cn.hylexus.jt808.common.TPMSConsts;
import cn.hylexus.jt808.vo.PackageData;

/**
 * 终端鉴权消息
 * 
 * @author hylexus
 *
 */
public class TerminalAuthenticationMsg extends PackageData {
	private String authCode;

	public TerminalAuthenticationMsg() {
	}

	public TerminalAuthenticationMsg(PackageData packageData) {
		this();
		this.channel = packageData.getChannel();
		this.checkSum = packageData.getCheckSum();
		this.msgBodyBytes = packageData.getMsgBodyBytes();
		this.msgHeader = packageData.getMsgHeader();
		this.authCode = new String(packageData.getMsgBodyBytes(), TPMSConsts.string_charset);
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAuthCode() {
		return authCode;
	}

	@Override
	public String toString() {
		return "TerminalAuthenticationMsg [authCode=" + authCode + ", msgHeader=" + msgHeader + ", msgBodyBytes="
				+ Arrays.toString(msgBodyBytes) + ", checkSum=" + checkSum + ", channel=" + channel + "]";
	}

}
