package отревьюено;

/**
 * Представляет дробь с числителем и знаменателем.
 */
public class Fraction {
  private int numerator;
  private int denominator;

  /**
   * Создает дробь с заданными числителем и знаменателем.
   *
   * @param numerator числитель дроби
   * @param denominator знаменатель дроби
   * @throws IllegalArgumentException если знаменатель равен нулю
   */
  public Fraction(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Знаменатель не может равняться нулю.");
    }
    this.numerator = numerator;
    this.denominator = denominator;
    simplify();
  }

  /**
   * Добавляет еще одну дробь к этой дроби.
   *
   * @param other дробь для сложения
   * @return результирующая дробь
   * @throws IllegalArgumentException если other равно null
   */
  public Fraction add(Fraction other) {
    if (other == null) {
      throw new IllegalArgumentException("Дополнительная дробь не может быть null.");
    }
    return new Fraction(numerator * other.denominator + denominator * other.numerator,
        denominator * other.denominator);
  }

  /**
   * Вычитает другую дробь из этой дроби.
   *
   * @param other дробь для вычитания
   * @return результирующая дробь
   * @throws IllegalArgumentException если other равно null
   */
  public Fraction subtract(Fraction other) {
    if (other == null) {
      throw new IllegalArgumentException("Дополнительная дробь не может быть null.");
    }
    return new Fraction(numerator * other.denominator - denominator * other.numerator,
        denominator * other.denominator);
  }

  /**
   * Умножает эту дробь на другую дробь.
   *
   * @param other дробь, на которую нужно умножить
   * @return результирующая дробь
   * @throws IllegalArgumentException если other равен null
   */
  public Fraction multiply(Fraction other) {
    if (other == null) {
      throw new IllegalArgumentException("умножаемая дробь не может равняться null.");
    }
    return new Fraction(numerator * other.numerator, denominator * other.denominator);
  }

  /**
   * Делит эту дробь на другую дробь.
   *
   * @param other дробь для деления
   * @return результирующая дробь
   * @throws IllegalArgumentException если other равен null или имеет нулевой числитель
   */
  public Fraction divide(Fraction other) {
    if (other == null) {
      throw new IllegalArgumentException("Дополнительная дробь не может быть null.");
    }
    if (other.numerator == 0) {
      throw new IllegalArgumentException("Невозможно разделить на дробь с нулевым числителем.");
    }
    return new Fraction(numerator * other.denominator, denominator * other.numerator);
  }

  /**
   * Добавляет целое число к этой дроби.
   *
   * @param number целое число для сложения
   * @return результирующая дробь
   */
  public Fraction add(int number) {
    return new Fraction(numerator + denominator * number, denominator);
  }

  /**
   * Вычитает целое число из дроби.
   *
   * @param number целое число для вычитания
   * @return результирующая дробь
   */
  public Fraction subtract(int number) {
    return new Fraction(numerator - denominator * number, denominator);
  }

  /**
   * Умножает дробь на целое число.
   *
   * @param number целое число для умножения
   * @return результирующая дробь
   */
  public Fraction multiply(int number) {
    return new Fraction(numerator * number, denominator);
  }

  /**
   * Делит дробь на целое число.
   *
   * @param number целое число для деления
   * @return результирующая дробь
   * @throws IllegalArgumentException если число равно нулю
   */
  public Fraction divide(int number) {
    if (number == 0) {
      throw new IllegalArgumentException("Нельзя делить на ноль.");
    }
    return new Fraction(numerator, denominator * number);
  }

  /**
   * Возвращает строковое представление дроби.
   *
   * @return строковое представление дроби
   */
  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }

  /**
   * Упрощает дробь.
   */
  private void simplify() {
    int gcd = gcd(numerator, denominator);
    numerator /= gcd;
    denominator /= gcd;

    if (denominator < 0) {
      numerator *= -1;
      denominator *= -1;
    }
  }

  /**
   * Вычисляет наибольший общий делитель двух целых чисел.
   *
   * @param a первое целое число
   * @param b второе целое число
   * @return наибольший общий делитель
   */
  private int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}