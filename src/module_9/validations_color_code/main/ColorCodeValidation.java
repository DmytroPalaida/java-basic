package module_9.validations_color_code.main;



public class ColorCodeValidation {

    public static boolean validateColorCode(String color) {
        if (color == null) {
            return false;
        }
        return color.matches("#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})"); // Дозволяє "#RGB" і "#RRGGBB"
    }
}





