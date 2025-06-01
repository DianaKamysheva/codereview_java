package Lab3.ru.kamysheva.math;

/**
 * Представляет дробь с числителем и знаменателем.
 * Обеспечивает выполнение базовых арифметических операций с дробями.
 */
public final class Fraction extends Number {
    /** Числитель дроби. */
    private final int numerator;

    /** Знаменатель дроби. */
    private final int denominator;

    /**
     * Создает дробь с указанными числителем и знаменателем.
     *
     * @param numerator числитель дроби
     * @param denominator знаменатель дроби
     * @throws IllegalArgumentException если знаменатель равен нулю
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }

        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Создает дробь с указанным числителем и знаменателем равным 1.
     *
     * @param numerator числитель дроби
     */
    public Fraction(int numerator) {
        this(numerator, 1);
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
     * Складывает эту дробь с другой дробью.
     *
     * @param other другая дробь для сложения
     * @return результат сложения в виде новой дроби
     */
    public Fraction sum(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Складывает эту дробь с целым числом.
     *
     * @param number целое число для сложения
     * @return результат сложения в виде новой дроби
     */
    public Fraction sum(int number) {
        return sum(new Fraction(number));
    }

    /**
     * Вычитает другую дробь из этой дроби.
     *
     * @param other другая дробь для вычитания
     * @return результат вычитания в виде новой дроби
     */
    public Fraction minus(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Вычитает целое число из этой дроби.
     *
     * @param number целое число для вычитания
     * @return результат вычитания в виде новой дроби
     */
    public Fraction minus(int number) {
        return minus(new Fraction(number));
    }

    /**
     * Умножает эту дробь на другую дробь.
     *
     * @param other другая дробь для умножения
     * @return результат умножения в виде новой дроби
     */
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Умножает эту дробь на целое число.
     *
     * @param number целое число для умножения
     * @return результат умножения в виде новой дроби
     */
    public Fraction multiply(int number) {
        return multiply(new Fraction(number));
    }

    /**
     * Делит эту дробь на другую дробь.
     *
     * @param other другая дробь для деления
     * @return результат деления в виде новой дроби
     * @throws IllegalArgumentException при попытке деления на ноль
     */
    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        return multiply(new Fraction(other.denominator, other.numerator));
    }

    /**
     * Делит эту дробь на целое число.
     *
     * @param number целое число для деления
     * @return результат деления в виде новой дроби
     * @throws IllegalArgumentException при попытке деления на ноль
     */
    public Fraction div(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        return div(new Fraction(number));
    }

    /**
     * Вычисляет наибольший общий делитель (НОД) двух целых чисел.
     *
     * @param a первое целое число
     * @param b второе целое число
     * @return наибольший общий делитель чисел a и b
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Возвращает значение этой дроби в виде int.
     *
     * @return значение этой дроби в виде int
     */
    @Override
    public int intValue() {
        return numerator / denominator;
    }

    /**
     * Возвращает значение этой дроби в виде long.
     *
     * @return значение этой дроби в виде long
     */
    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    /**
     * Возвращает значение этой дроби в виде float.
     *
     * @return значение этой дроби в виде float
     */
    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    /**
     * Возвращает значение этой дроби в виде double.
     *
     * @return значение этой дроби в виде double
     */
    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    /**
     * Возвращает значение этой дроби в виде byte.
     *
     * @return значение этой дроби в виде byte
     */
    @Override
    public byte byteValue() {
        return (byte) (numerator / denominator);
    }

    /**
     * Возвращает значение этой дроби в виде short.
     *
     * @return значение этой дроби в виде short
     */
    @Override
    public short shortValue() {
        return (short) (numerator / denominator);
    }

    /**
     * Возвращает копию этой дроби.
     *
     * @return копия этой дроби
     */
    @Override
    public Fraction clone() {
        return new Fraction(this.numerator, this.denominator);
    }
}