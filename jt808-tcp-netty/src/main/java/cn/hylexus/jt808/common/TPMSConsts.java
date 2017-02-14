package cn.hylexus.jt808.common;

import java.nio.charset.Charset;

public class TPMSConsts {

	public static final String string_encoding = "GBK";

	public static final Charset string_charset = Charset.forName(string_encoding);
	// 标识位
	public static final int pkg_delimiter = 0x7e;
	// 客户端发呆15分钟后,服务器主动断开连接
	public static int tcp_client_idle_minutes = 30;

	// 终端通用应答
	public static final int msg_id_terminal_common_resp = 0x0001;
	// 终端心跳
	public static final int msg_id_terminal_heart_beat = 0x0002;
	// 终端注册
	public static final int msg_id_terminal_register = 0x0100;
	// 终端注销
	public static final int msg_id_terminal_log_out = 0x0003;
	// 终端鉴权
	public static final int msg_id_terminal_authentication = 0x0102;
	// 位置信息汇报
	public static final int msg_id_terminal_location_info_upload = 0x0200;
	// 胎压数据透传
	public static final int msg_id_terminal_transmission_tyre_pressure = 0x0600;
	// 查询终端参数应答
	public static final int msg_id_terminal_param_query_resp = 0x0104;

	// 平台通用应答
	public static final int cmd_common_resp = 0x8001;
	// 终端注册应答
	public static final int cmd_terminal_register_resp = 0x8100;
	// 设置终端参数
	public static final int cmd_terminal_param_settings = 0X8103;
	// 查询终端参数
	public static final int cmd_terminal_param_query = 0x8104;

}
