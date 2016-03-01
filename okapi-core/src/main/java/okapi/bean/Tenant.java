/*
 * Copyright (c) 2015-2016, Index Data
 * All rights reserved.
 * See the file LICENSE for details.
 */
package okapi.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tenant {

  @JsonProperty
  final private TenantDescriptor descriptor;

  @JsonProperty
  final private  Map<String,Boolean> enabled;

  @JsonIgnore
  private long timestamp;

  
  public Tenant(TenantDescriptor descriptor) {
    this.descriptor = descriptor;
    this.enabled = new HashMap<>();
    this.timestamp = 0;
  }
  
  public Tenant(TenantDescriptor descriptor, Map<String,Boolean> enabled) {
    this.descriptor = descriptor;
    this.enabled = enabled;
    this.timestamp = 0;
  }

  public Tenant() {
    this.descriptor = new TenantDescriptor();
    this.enabled = new HashMap<>();
    this.timestamp = 0;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }


  /**
   * Get the name.
   * The JsonIgnore tells Json not to encode the name as a top-level thing
   * @return
   */
  @JsonIgnore
  public String getName() {
    return descriptor.getName();
  }

  @JsonIgnore
  public String getId() {
    return descriptor.getId();
  }

  public TenantDescriptor getDescriptor() {
    return descriptor;
  }

  public Map<String,Boolean> getEnabled() {
    return enabled;
  }

  public void enableModule(String n) {
    enabled.put(n, true);
  }
  
  public boolean isEnabled(String m) {
    return enabled.getOrDefault(m, false);
  }

  public Set<String> listModules() {
     return enabled.keySet();
  }
}
