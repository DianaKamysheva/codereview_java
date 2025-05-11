package отревьюено;

/**
 * Основной класс для демонстрации функциональности классов Person, Name, City и Fraction.
 */
public class Main {
  /**
   * Основной метод для выполнения демонстрации.
   *
   * @param args аргументы командной строки
   */
  public static void main(String[] args) {
    // Задание 1.2
    Person cleopatra = new Person("Клеопатра", 152);
    Person pushkin = new Person("Пушкин", 167);
    Person vladimir = new Person("Владимир", 189);

    System.out.println("\nЗадание 1.2:\n");
    System.out.println(cleopatra);
    System.out.println(pushkin);
    System.out.println(vladimir);
    System.out.println();

    // Задание 1.3
    Name nameCleopatra = new Name("Клеопатра");
    Name namePushkin = new Name("Пушкин", "Александр", "Сергеевич");
    Name nameMayakovsky = new Name("Маяковский", "Владимир");

    System.out.println("\nЗадание 1.3:\n");
    System.out.println(nameCleopatra);
    System.out.println(namePushkin);
    System.out.println(nameMayakovsky);
    System.out.println();

    // Задание 2.2
    cleopatra.setName(nameCleopatra);
    pushkin.setName(namePushkin);
    vladimir.setName(nameMayakovsky);

    System.out.println("\nЗадание 2.2:\n");
    System.out.println(cleopatra);
    System.out.println(pushkin);
    System.out.println(vladimir);
    System.out.println();

    // Задание 3.3 & 4.8
    // Создание городов
    City a = new City("A");
    City b = new City("B");
    City c = new City("C");
    City d = new City("D");
    City e = new City("E");
    City f = new City("F");
    City g = new City("G");

    // Добавление маршрутов
    a.addRoute(b, 5);
    a.addRoute(d, 6);
    a.addRoute(f, 1);
    b.addRoute(a, 5);
    b.addRoute(c, 3);
    c.addRoute(b, 3);
    c.addRoute(d, 4);
    d.addRoute(c, 4);
    d.addRoute(e, 2);
    d.addRoute(a, 6);
    e.addRoute(f, 2);
    f.addRoute(e, 2);
    f.addRoute(b, 1);

    // Вывод информации о городе
    System.out.println("\nЗадание 3.3 и 4.8:\n");
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
    System.out.println(e);
    System.out.println(f);
    System.out.println(g);
    System.out.println();

    // Задание 5.5
    Fraction f1 = new Fraction(1, 3);
    Fraction f2 = new Fraction(2, 3);
    Fraction f3 = new Fraction(3, 2);

    System.out.println("\nЗадание 5.5:\n");
    // Примеры работы с дробными числами
    System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
    System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));
    System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
    System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
    // Примеры работы с целыми числами
    System.out.println(f1 + " + " + 5 + " = " + f1.add(5));
    System.out.println(f1 + " - " + 5 + " = " + f1.subtract(5));
    System.out.println(f1 + " * " + 5 + " = " + f1.multiply(5));
    System.out.println(f1 + " / " + 5 + " = " + f1.divide(5));

    // Расчет выражения f1.sum(f2).div(f3).minus(5)
    Fraction result = f1.add(f2).divide(f3).subtract(5);
    System.out.println("Желаемый пример: " + f1 + " + " + f2 + " / " + f3 + " - 5 = " + result);
    System.out.println();
  }
}
