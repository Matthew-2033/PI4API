package DataLib.AutoMapper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AutoMapper<T> {

    private T object;

    private List<GenericProperties> properties;

    public AutoMapper(T object) {
        this.object = object;
    }

    private void setFilds() throws InstantiationException, IllegalAccessException {

        Class classObject = this.object.getClass();

        properties = new ArrayList<GenericProperties>();

        Field[] fields = classObject.getDeclaredFields();

        for (Field field : fields) {
            GenericProperties property = new GenericProperties(field);

            properties.add(property);
        }

    }

    public List<T> map(ResultSet resultSet) throws SQLException, InstantiationException, IllegalAccessException,
            NoSuchFieldException, SecurityException, IllegalArgumentException {

        setFilds();

        if (resultSet == null) {
            return null;
        }

        List<T> objects = new ArrayList<T>();

        while (resultSet.next()) {
            T instance = getInstance(resultSet, this.object);

            objects.add(instance);
        }

        return objects;
    }

    private T getInstance(ResultSet data, T object) throws InstantiationException, IllegalAccessException,
            NoSuchFieldException, SecurityException, IllegalArgumentException, SQLException {

        T instance = (T) object.getClass().newInstance();

        for (GenericProperties property : properties) {
            Field field = instance.getClass().getDeclaredField(property.name);

            field.setAccessible(true);

            try {
                switch (property.type) {
                    case "java.util.UUID" :
                        UUID guidValue = UUID.fromString(data.getString(property.name)); 
                        field.set(instance, guidValue);                    
                        break;
                    case "int":                    
                        int intValue = data.getInt(property.name);
                        field.set(instance, intValue);
                        break;
                        
                    case "Enum":     
                        Method setEnum = getMethodSetEnum(instance, field);
                        
                        int enumValue = data.getInt(property.name);    
                        setEnum.invoke(instance, enumValue);
                        break;                    
                    case "double":
                        field.set(instance, data.getDouble(property.name));
                        break;
                    case "long":
                        field.set(instance, data.getLong(property.name));
                        break;
                    case "java.lang.String":
                        field.set(instance, data.getString(property.name));
                        break;
                    case "boolean":
                        field.set(instance, data.getBoolean(property.name));
                        break;
                    case "java.time.LocalDate":
                        Date date = data.getDate(property.name);
    
                        field.set(instance, date.toLocalDate());
                        break;
                    case "java.time.LocalDateTime":
                        Timestamp dateTime = data.getTimestamp(property.name);
    
                        field.set(instance, dateTime.toLocalDateTime());
                        break;
                }
            } catch (Exception ex) {
                continue;
            }            
        }

        return instance;
    }

    private Method getMethodSetEnum(T object, Field field) throws NoSuchMethodException, SecurityException {

        String enumName = field.getType().getName();

        String classSplit[] = enumName.split("\\.");

        enumName = classSplit[classSplit.length - 1];

        Method method = object.getClass().getMethod("set" + enumName, int.class);

        return method;
    }

    private class GenericProperties {

        private String name;

        private String type;

        public GenericProperties(Field fields) {
            this.name = fields.getName();

            this.type = fields.getType().getName();

            if (this.type.toLowerCase().contains("enum")) {
                this.type = "Enum";
            }
        }
    }
}