package AnnotationsAndExceptions.Annotations;

public class User {
    @DataValidation(type = DataType.STRING_LENGTH, minLength = 3, maxLength = 50)
    private String username;

    @DataValidation(type = DataType.NUMERIC_RANGE, minValue = 18, maxValue = 100)
    private int age;

    @DataValidation(type = DataType.CUSTOM_REGEX, regex = "^[a-zA-Z0-9]+$")
    private String password;

    public User(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }

    public boolean validateData() {
        boolean isValid = true;
        for (java.lang.reflect.Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(DataValidation.class)) {
                DataValidation annotation = field.getAnnotation(DataValidation.class);
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(this);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e.getMessage());
                }
                switch (annotation.type()) {
                    case STRING_LENGTH:
                        if (value instanceof String) {
                            String strValue = (String) value;
                            if (strValue.length() < annotation.minLength() || strValue.length() > annotation.maxLength()) {
                                isValid = false;
                                System.out.println("Invalid length for field " + field.getName());
                            }
                        }
                        break;
                    case NUMERIC_RANGE:
                        if (value instanceof Integer) {
                            int intValue = (int) value;
                            if (intValue < annotation.minValue() || intValue > annotation.maxValue()) {
                                isValid = false;
                                System.out.println("Invalid range for field " + field.getName());
                            }
                        }
                        break;
                    case CUSTOM_REGEX:
                        if (value instanceof String) {
                            String strValue = (String) value;
                            if (!strValue.matches(annotation.regex())) {
                                isValid = false;
                                System.out.println("Invalid format for field " + field.getName());
                            }
                        }
                        break;
                }
            }
        }
        return isValid;
    }
}
