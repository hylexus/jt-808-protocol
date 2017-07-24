/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hylexus.jt808.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MingDi
 */
public class AlarmTypes {
  public static final String URGENT = "URGENT ALARM";
  public static final String OVERSPEED = "OVER SPEED";
  public static final String FATIGUE = "疲劳驾驶";
  public static final String DANGER = "DANGER";
  public static final String GNSS_MODULE_ISSUE = "GNSS 模块发生故障";
  public static final String GNSS_WIRE_DISCONNECTED = "GNSS 天线未接或被剪断";
  public static final String GNSS_SHORT_CURCIT = "GNSS 天线短路";
  public static final String LOW_VOLTAGE="终端主电源欠压";
  public static final String NO_POWER="终端主电源掉电";
  public static final String LCD = "终端LCD 或显示器故障";
  public static final String TTS_ISSUE = "TTS 模块故障";
  public static final String CAMERA_ISSUE = "摄像头故障";
  public static final String IC_ISSUE = "道路运输证IC 卡模块故障";
  
  public static final String OVERSPEED_WARNING = "超速预警";
  public static final String FATIGUE_WARNING = "疲劳驾驶预警";
  public static final String EXCEED_DRIVING_TIME = "当天累计驾驶超时";
  public static final String PARKING_OVERTIME = "超时停车";
  public static final String ZONE = "进出区域";
  public static final String ROUTE = "进出路线";
  public static final String ROUTE_DRIVING_TIMELIMIT = "路段行驶时间不足/过长";
  public static final String OFF_TRACK = "路线偏离报警";
  public static final String VSS = "车辆VSS 故障";
  public static final String FUEL = "车辆油量异常";
  public static final String STOLEN = "车辆被盗";
  public static final String STARTUP = "车辆非法点火";
  public static final String MOVED = "碰撞预警";
  public static final String CRACKED_WARNING = "侧翻预警";
  public static final String ROLLOVER_WARNING = "侧翻预警";
  public static final String DOOR_WARNING = "侧翻预警";
  
  private static final String RESEVED_WORD = "保留";
  public static final Map<Integer, String> ALARMS;
  static {
    ALARMS= new HashMap<>();
    ALARMS.put(0,URGENT);
    ALARMS.put(1,OVERSPEED);
    ALARMS.put(2,FATIGUE);
    ALARMS.put(3,DANGER);
    ALARMS.put(4,GNSS_MODULE_ISSUE);
    ALARMS.put(5,GNSS_WIRE_DISCONNECTED);
    ALARMS.put(6,GNSS_SHORT_CURCIT);
    ALARMS.put(7,LOW_VOLTAGE);
    ALARMS.put(8,NO_POWER);
    ALARMS.put(9,LCD);
    ALARMS.put(10,TTS_ISSUE);
    ALARMS.put(11,CAMERA_ISSUE);
    ALARMS.put(12,IC_ISSUE);
    ALARMS.put(13,OVERSPEED_WARNING);
    ALARMS.put(14,FATIGUE_WARNING);
    ALARMS.put(15,RESEVED_WORD);
    ALARMS.put(16,RESEVED_WORD);
    ALARMS.put(17,RESEVED_WORD);
    ALARMS.put(18,EXCEED_DRIVING_TIME);
    ALARMS.put(19,PARKING_OVERTIME);
    ALARMS.put(20,ZONE);
    ALARMS.put(21,ROUTE);
    ALARMS.put(22,ROUTE_DRIVING_TIMELIMIT);
    ALARMS.put(23,OFF_TRACK);
    ALARMS.put(24,VSS);
    ALARMS.put(25,FUEL);
    ALARMS.put(26,STOLEN);
    ALARMS.put(27,STARTUP);
    ALARMS.put(28,MOVED);
    ALARMS.put(29,CRACKED_WARNING);
    ALARMS.put(30,ROLLOVER_WARNING);
    ALARMS.put(31,DOOR_WARNING);
    
    
    
  }
  
}
