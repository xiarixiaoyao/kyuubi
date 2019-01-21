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

package yaooqinn.kyuubi

import org.apache.spark.{KyuubiConf, SparkConf, SparkFunSuite}
import org.apache.spark.KyuubiConf._

class KyuubiConfSuite extends SparkFunSuite {
  private val conf: SparkConf = new SparkConf()

  KyuubiConf.getAllDefaults.foreach { case (k, v) => conf.set(k, v) }
  test("implicits") {

    assert(conf.getOption(AUTHORIZATION_ENABLE).nonEmpty)
    assert(!conf.get(AUTHORIZATION_ENABLE).toBoolean)

    assert(conf.getOption(YARN_CONTAINER_TIMEOUT).nonEmpty)
    assert(conf.get(YARN_CONTAINER_TIMEOUT) === "60000ms")

    assert(conf.getOption(BACKEND_SESSION_WAIT_OTHER_TIMES).nonEmpty)
    assert(conf.get(BACKEND_SESSION_WAIT_OTHER_TIMES).toInt === 60)

    assert(conf.getOption(AUTHENTICATION_METHOD).nonEmpty)
    assert(conf.get(AUTHENTICATION_METHOD) === "NONE")
  }

}
