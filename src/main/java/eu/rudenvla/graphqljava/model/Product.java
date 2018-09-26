package eu.rudenvla.graphqljava.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Product {
  @Id
  @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
  private Long id;
  
  @Column(name = "NAME", unique = true, nullable = false)
  private String name;
  
  @Column(name = "PRICE", nullable = false)
  private BigDecimal price;
  
  @Column(name = "DESCRIPTION", nullable = false)
  private String description;
}

