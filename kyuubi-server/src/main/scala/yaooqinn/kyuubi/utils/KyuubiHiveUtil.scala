/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package yaooqinn.kyuubi.utils

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hive.conf.HiveConf
import org.apache.spark.{KyuubiSparkUtil, SparkConf}

object KyuubiHiveUtil {

  private val HIVE_PREFIX = "hive."
  private val METASTORE_PREFIX = "metastore."

  val URIS: String = HIVE_PREFIX + METASTORE_PREFIX + "uris"
  val METASTORE_PRINCIPAL: String = HIVE_PREFIX + METASTORE_PREFIX + "kerberos.principal"

  def hiveConf(conf: SparkConf): Configuration = {
    val hadoopConf = KyuubiSparkUtil.newConfiguration(conf)
    new HiveConf(hadoopConf, classOf[HiveConf])
  }

}
