package com.example.objectbox.entities;

import java.util.Collections;
import java.util.List;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.converter.PropertyConverter;

@Entity
public class CustomTypes {

    @Id public Long id;

    @Convert(converter = SimpleEnumConverter.class, dbType = Integer.class)
    public SimpleEnum customType;

    @Convert(converter = SimpleEnumListConverter.class, dbType = Integer.class)
    public List<SimpleEnum> customTypes;

    public enum SimpleEnum {
        DEFAULT(0);

        final int id;

        SimpleEnum(int id) {
            this.id = id;
        }
    }

    public static class SimpleEnumConverter implements PropertyConverter<SimpleEnum, Integer> {

        @Override
        public SimpleEnum convertToEntityProperty(Integer databaseValue) {
            return SimpleEnum.DEFAULT; // replace with useful implementation
        }

        @Override
        public Integer convertToDatabaseValue(SimpleEnum entityProperty) {
            return SimpleEnum.DEFAULT.id; // replace with useful implementation
        }
    }

    public static class SimpleEnumListConverter
            implements PropertyConverter<List<SimpleEnum>, Integer> {

        @Override
        public List<SimpleEnum> convertToEntityProperty(Integer databaseValue) {
            return Collections
                    .singletonList(SimpleEnum.DEFAULT); // replace with useful implementation
        }

        @Override
        public Integer convertToDatabaseValue(List<SimpleEnum> entityProperty) {
            return SimpleEnum.DEFAULT.id; // replace with useful implementation
        }
    }

}
