/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hylexus.jt808.entity;

import java.util.Date;

/**
 *
 * @author MingDi
 */
public class GPSEntity extends Entity {

  private long occId;

  private String deviceId;
  private String messageId;
  private double latitude;
  private double longtitude;
  private int altitude;
  private double speed;
  private double bearing;
  private Date traceTime;

  public Date getTraceTime() {
    return traceTime;
  }

  public void setTraceTime(Date traceTime) {
    this.traceTime = traceTime;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setOccId(long occId) {
    this.occId = occId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongtitude() {
    return longtitude;
  }

  public void setLongtitude(double longtitude) {
    this.longtitude = longtitude;
  }

  public int getAltitude() {
    return altitude;
  }

  public void setAltitude(int altitude) {
    this.altitude = altitude;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public double getBearing() {
    return bearing;
  }

  public void setBearing(double bearing) {
    this.bearing = bearing;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("device id = " + deviceId);
    sb.append(", message id = " + messageId);
    sb.append(", Trace time = " + traceTime.toGMTString());
    sb.append(", location = (" + this.latitude + "," + this.longtitude + ")");
    sb.append(", bearing = " + bearing);
    sb.append(", speed = " + speed);
    return sb.toString();
  }
}
