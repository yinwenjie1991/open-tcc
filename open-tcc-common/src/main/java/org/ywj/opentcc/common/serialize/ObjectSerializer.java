package org.ywj.opentcc.common.serialize;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-09
 */
public class ObjectSerializer<T extends Serializable> {

    public byte[] serialize(T object) {
        return SerializationUtils.serialize(object);
    }

    public T deserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        } else {
          return (T) SerializationUtils.deserialize(bytes);
        }
    }
}
