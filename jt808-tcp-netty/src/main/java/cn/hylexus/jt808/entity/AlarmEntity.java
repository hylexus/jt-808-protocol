/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hylexus.jt808.entity;

/**
 *
 * @author MingDi
 */
public class AlarmEntity extends Entity{
  private int alarmType;
  private String info;
  
  public int getAlarmType() {
    return alarmType;
  }

  public void setAlarmType(int alarmType) {
    this.alarmType = alarmType;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}
