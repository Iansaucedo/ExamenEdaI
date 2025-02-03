public class Pixel {
  public String AsciiArray;
  public String color;

  public static final char NEGRO = '.'; // Ausencia de señal (NEGRO)
  public static final char BLANCO = '#'; // Máxima intensidad (BLANCO)
  public static final char CYAN = '+'; // Intensidad media-alta (CYAN)
  public static final char MAGENTA = '*'; // Intensidad media-alta (MAGENTA)

  public String getpixel() {
    if (AsciiArray != null && !AsciiArray.isEmpty()) {
      return AsciiArray;
    } else if (color != null) {
      switch (color.toLowerCase()) {
        case "n":
          return String.valueOf(NEGRO);
        case "b":
          return String.valueOf(BLANCO);
        case "c":
          return String.valueOf(CYAN);
        case "m":
          return String.valueOf(MAGENTA);
        default:
          return " ";
      }
    }
    return " ";
  }

  public String getColor() {
    return color;
  }

}
