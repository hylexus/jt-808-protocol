package cn.hylexus.jt808.vo;

import java.net.SocketAddress;

import io.netty.channel.Channel;

public class Session {

	private String id;
	private String terminalPhone;
	private Channel channel = null;
	private boolean isAuthenticated = false;
	// 消息流水号 word(16) 按发送顺序从 0 开始循环累加
	private int currentFlowId = 0;
	// private ChannelGroup channelGroup = new
	// DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	// 客户端上次的连接时间，该值改变的情况:
	// 1. terminal --> server 心跳包
	// 2. terminal --> server 数据包
	private long lastCommunicateTimeStamp = 0l;

	public Session() {
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getTerminalPhone() {
		return terminalPhone;
	}

	public void setTerminalPhone(String terminalPhone) {
		this.terminalPhone = terminalPhone;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public static String buildId(Channel channel) {
		return channel.id().asLongText();
	}

	public static Session buildSession(Channel channel) {
		return buildSession(channel, null);
	}

	public static Session buildSession(Channel channel, String phone) {
		Session session = new Session();
		session.setChannel(channel);
		session.setId(buildId(channel));
		session.setTerminalPhone(phone);
		session.setLastCommunicateTimeStamp(System.currentTimeMillis());
		return session;
	}

	public long getLastCommunicateTimeStamp() {
		return lastCommunicateTimeStamp;
	}

	public void setLastCommunicateTimeStamp(long lastCommunicateTimeStamp) {
		this.lastCommunicateTimeStamp = lastCommunicateTimeStamp;
	}

	public SocketAddress getRemoteAddr() {
		System.out.println(this.channel.remoteAddress().getClass());

		return this.channel.remoteAddress();
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", terminalPhone=" + terminalPhone + ", channel=" + channel + "]";
	}

	public synchronized int currentFlowId() {
		if (currentFlowId >= 0xffff)
			currentFlowId = 0;
		return currentFlowId++;
	}

}