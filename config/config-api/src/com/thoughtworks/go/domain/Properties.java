/*************************GO-LICENSE-START*********************************
 * Copyright 2014 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *************************GO-LICENSE-END***********************************/

package com.thoughtworks.go.domain;

import java.util.List;

import com.thoughtworks.go.util.json.Json;
import com.thoughtworks.go.util.json.JsonAware;
import com.thoughtworks.go.util.json.JsonMap;

public class Properties extends BaseCollection<Property> implements JsonAware {
    public Properties() {
    }

    public Properties(List<Property> items) {
        super(items);
    }

    public Properties(Property... items) {
        super(items);
    }

    public String getValue(String propertyName) {
        for (Property property : this) {
            if (property.getKey().equals(propertyName)) {
                return property.getValue();
            }
        }
        return null;
    }

    public Json toJson() {
        JsonMap jsonMap = new JsonMap();
        for (Property property : this) {
            jsonMap.put(property.getKey(), property.getValue());
        }
        return jsonMap;
    }

    public void setProperty(String key, String value) {
        for (Property property : this) {
            if (property.getKey().equals(key)) {
                property.setValue(value);
                return;
            }
        }
        this.add(new Property(key, value));
    }
}
