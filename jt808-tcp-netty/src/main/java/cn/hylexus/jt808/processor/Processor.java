/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hylexus.jt808.processor;
import cn.hylexus.jt808.vo.PackageData;
/**
 *
 * @author MingDi
 */
public interface Processor {
  public void process(PackageData req);
}
