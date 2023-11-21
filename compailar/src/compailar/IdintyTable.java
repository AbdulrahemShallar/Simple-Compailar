/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compailar;

import java.util.ArrayList;

/**
 *
 * @author Abd Alrahim Shalar
 */
public class IdintyTable {
  String name;
  String value;
  boolean isFormat;
  boolean isDelecate = false;
    
  public IdintyTable(String name,String value)
    {
        this.name = name;
        this.value = value;
        this.isFormat = !value.isEmpty();
        
    }
  
}
