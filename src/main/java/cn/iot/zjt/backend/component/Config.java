package cn.iot.zjt.backend.component;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * Configuration initialization.
 *
 * @version 2021/10/13
 */
public class Config {

  public static final String CONFIG_BASE = "conf/";
  public static final String CONFIG_FILE = "config.json";

  public static final String API_VERSION = "0.0.1";

  public static Future<JsonObject> initConfig(final Vertx vertx, final String path) {
    return Future.future(promise -> {
      ConfigStoreOptions configStore = new ConfigStoreOptions()
        .setType("file")
        .setConfig(new JsonObject().put("path", path));
      ConfigRetrieverOptions options = new ConfigRetrieverOptions()
        .addStore(configStore);
      ConfigRetriever
        .create(vertx, options)
        .getConfig(ar -> {
          if (ar.failed()) {
            promise.fail("Fail to get configuration file from " + path);
          }
          promise.complete(ar.result());
        });
    });
  }
}