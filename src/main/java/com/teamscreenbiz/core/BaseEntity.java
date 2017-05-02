package com.teamscreenbiz.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity {
  @Id
  @GeneratedValue(strategy =  GenerationType.AUTO)
  protected final Long id;

  @Version
  private Long version;

  protected BaseEntity() {
    id = null;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public Long getId() {
    return id;
  }

}
