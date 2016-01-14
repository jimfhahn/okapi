/*
 * Copyright (c) 1995-2015, Index Data
 * All rights reserved.
 * See the file LICENSE for details.
 */
package com.indexdata.okapi.conduit;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

public interface ModuleHandle {
  void start(Handler<AsyncResult<Void>> startFuture);

  void stop(Handler<AsyncResult<Void>> stopFuture);
}
