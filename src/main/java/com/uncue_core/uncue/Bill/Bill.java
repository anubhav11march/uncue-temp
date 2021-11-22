package com.uncue_core.uncue.Bill;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;
@Entity
@Setter
@Getter
public class Bill {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private int billId;
   private int saloonId;
   private int customerId;
   private int appointmentId;
   @ElementCollection
   private Map<Integer,Integer> product;
   private int service[];

}

