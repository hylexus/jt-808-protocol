/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hylexus.jt808.processor.impl;

import cn.hylexus.jt808.dao.GPSCreateDao;
import cn.hylexus.jt808.dao.OccurenceCreateDao;
import cn.hylexus.jt808.entity.AlarmEntity;
import cn.hylexus.jt808.entity.Entity;
import cn.hylexus.jt808.entity.GPSEntity;
import cn.hylexus.jt808.entity.OccurenceEntity;
import cn.hylexus.jt808.entity.StatusEntity;
import cn.hylexus.jt808.processor.Processor;
import cn.hylexus.jt808.vo.PackageData;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MingDi
 */
public class StandardGPSUploadProcessor implements Processor {

  private String deviceId = "";

  public StandardGPSUploadProcessor(String deviceId) {
    this.deviceId = deviceId;
  }

  @Override
  public void process(PackageData data) {
    // TODO fulfill the request process
    OccurenceEntity occurence = new OccurenceEntity();
     OccurenceCreateDao ocd = (OccurenceEntity entity)->{
      //return a random id represents the db row id.
      return (long)Math.floor(Math.random()*10000);
    };
    long occId = ocd.create(occurence);
    
    ByteBuffer msg = ByteBuffer.wrap(data.getMsgBodyBytes());
    // 报警标志
    List<AlarmEntity> alarms = parseAlarm(msg.getInt(), occId);
    // 状态
    List<StatusEntity> statuses = parseStatus(msg.getInt(), occId);

    // Latitude
    double latitude = msg.getInt() / 1000000D;
    // longtitude 
    double longtitude = msg.getInt() / 1000000D;
    // altitude
    int altitude = msg.getShort();
    // speed 
    double speed = msg.getShort() / 10d;
    // bearing 方向
    double bearing = msg.getShort();
    // Trace time 
    ByteBuffer traceTime = msg.get(new byte[6]);
    // create current gps upload occurence
    occurence.setDeviceId(deviceId);
    occurence.setTraceTtime(traceTime);
   
    // create GPS location detail
    GPSEntity entity = new GPSEntity();
    entity.setAltitude(altitude);
    entity.setLatitude(latitude);
    entity.setLongtitude(longtitude);
    entity.setBearing(bearing);
    entity.setDeviceId(deviceId);
    entity.setMessageId("0");
    entity.setAltitude(altitude);
    entity.setSpeed(speed);
    entity.setOccId(occId);
    
    GPSCreateDao gcd = (GPSEntity entity1) -> {
      System.out.println("To persistent GPS data: " + entity1.toString());
      return 0;
    };
    int ret = gcd.create(entity);
  }

  private List<AlarmEntity> parseAlarm(int aInt, long occurenceId) {
    String alarms = Integer.toBinaryString(aInt);
    List<AlarmEntity> l = new ArrayList<AlarmEntity>();
    int i = 0, len = alarms.length();
    for (; i < len; i++) {
      if (alarms.charAt(i) == '1') {
        AlarmEntity a = new AlarmEntity();
        a.setAlarmType((int) alarms.charAt(i));
        l.add(a);
      }
    }
    return l;
  }

  private List<StatusEntity> parseStatus(int aInt, long occurenceId) {
    String status = Integer.toBinaryString(aInt);
    List<StatusEntity> l = new ArrayList<>();
    int i = 0, len = status.length();
    for (; i < len; i++) {
      StatusEntity s = new StatusEntity();
      s.setStatusId(i);
      s.setInfo(status.charAt(i)+"");
      l.add(s);
    }
    return l;
  }
  
  private void parseAdditionalInfo(ByteBuffer msg){
    
  }
}
