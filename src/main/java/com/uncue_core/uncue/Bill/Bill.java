package com.uncue_core.uncue.Bill;

import com.uncue_core.uncue.LobArray.IntegerArray;
import com.uncue_core.uncue.LobArray.Map;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
public class Bill implements Serializable {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private int billId;
   @Column(nullable = false)
   private int saloonId;
   @Column(nullable = false)
   private int customerId;
   private int appointmentId;
   @Lob
   private Map product;
   private float finalAmount;
   @Lob
   private IntegerArray service;

}

