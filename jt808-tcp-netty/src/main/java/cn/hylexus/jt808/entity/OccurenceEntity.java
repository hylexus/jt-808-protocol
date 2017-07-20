/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hylexus.jt808.entity;

import java.nio.ByteBuffer;
import java.util.Date;

/**
 *
 * @author MingDi
 */
public class OccurenceEntity {
  private long id;
  private String deviceId;
  private ByteBuffer buffer;

  public void setId(long id) {
    this.id = id;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public void setTraceTtime(ByteBuffer buffer) {
    this.buffer = buffer;
  }
}
