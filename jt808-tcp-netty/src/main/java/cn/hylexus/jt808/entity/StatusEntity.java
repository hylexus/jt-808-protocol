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
public class StatusEntity extends Entity{
  private int status_id;
  private int occurence_id;
  private int statusType;
  private String info;

  public void setStatusId(int status_id) {
    this.status_id = status_id;
  }
  public void setOccurrencId(int occurence_id) {
    this.occurence_id = occurence_id;
  }
  public void setStatusType(int statusType) {
    this.statusType = statusType;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
  
  @Override
  public String toString() {
    return statusType + ":" +info;
  }
}
