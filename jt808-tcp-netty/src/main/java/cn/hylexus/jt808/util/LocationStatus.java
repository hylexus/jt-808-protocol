/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hylexus.jt808.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MingDi
 */
public class LocationStatus {

  private static final String ACC = "ACC";  // 0 acc on, 1. acc off
  private static final String GPS_ON = "GPS_ON";  // 0. on, 1. off
  private static final String LATITUDE = "南北纬"; // 0. nouth, 1. south
  private static final String LONGTITUTE = "东西经";  // 0. east, 1. west
  private static final String SERVICING = "运营"; // 0：运营状态；1：停运状态
  private static final String ENCRYPTED = "经纬度保密插件";  //0. encrypted
  private static final String LOAD = "载客状态";  //00：空车；01：半载；10：保留；11：满载
  private static final String FEUL = "车辆油路";  // 车辆油路正常；1：车辆油路断开
  private static final String ELECTRIC = "车辆电路";   //0：车辆电路正常；1：车辆电路断开
  private static final String DOOR_LOCK = "车门锁";  //   0：车门解锁；1：车门加锁
  private static final String DOOR_FRONT = "前门";  //0：门1 关；1：门1 开（前门）
  private static final String DOOR_MID = "中门";  //0：门2 关；1：门2 开（中门）
  private static final String DOOR_BACK = "后门";  //0：门3 关；1：门3 开（后门）
  private static final String DOOR_DRIVER = "驾驶席门";  //  0：门4 关；1：门4 开（驾驶席门）
  private static final String DOOR_CUSTOM = "自定义门";  //0：门3 关；1：门3 开（自定义）
  private static final String GPS_SATELLITE = "使用GPS 卫星进行定位";  // 未0. 使用GPS 卫星进行定位
  private static final String GPS_GNSS = "使用北斗卫星进行定位"; //  0：未使用北斗卫星进行定位；1：使用北斗卫星进行定位
  private static final String GPS_GLONASS = "使用GLONASS卫星进行定位";   // 0：未使用GLONASS 卫星进行定位；1：使用GLONASS 卫星进行定位
  private static final String GPS_GALILEO = "使用Galileo卫星进行定位";   // 0：未使用Galileo 卫星进行定位；1：使用Galileo 卫星进行定位
  private static final String RESERVED = "保留";
  
  public static final Map<Integer, String> STATUS;
  static {
    STATUS = new HashMap<Integer, String>();
    STATUS.put(0, ACC);
    STATUS.put(1, GPS_ON);
    STATUS.put(2, LATITUDE);
    STATUS.put(3, LONGTITUTE);
    STATUS.put(4, SERVICING);
    STATUS.put(5, ENCRYPTED);
    STATUS.put(6, RESERVED);
    STATUS.put(7, RESERVED);
    STATUS.put(8,  LOAD);
    STATUS.put(9,  LOAD);
    STATUS.put(10, FEUL);
    STATUS.put(11, ELECTRIC);
    STATUS.put(12, DOOR_LOCK);
    STATUS.put(13, DOOR_FRONT);
    STATUS.put(14, DOOR_MID);
    STATUS.put(15, DOOR_BACK);
    STATUS.put(16, DOOR_DRIVER);
    STATUS.put(17, DOOR_CUSTOM);
    STATUS.put(18, GPS_SATELLITE);
    STATUS.put(19, GPS_GNSS);
    STATUS.put(20, GPS_GLONASS);
    STATUS.put(21, GPS_GALILEO);
    STATUS.put(22, RESERVED);
    STATUS.put(23, RESERVED);
    STATUS.put(24, RESERVED);
    STATUS.put(25, RESERVED);
    STATUS.put(26, RESERVED);
    STATUS.put(27, RESERVED);
    STATUS.put(28, RESERVED);
    STATUS.put(29, RESERVED);
    STATUS.put(30, RESERVED);
    STATUS.put(31, RESERVED);
    
  }
}
