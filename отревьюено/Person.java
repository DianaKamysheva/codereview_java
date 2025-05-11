package отревьюено;

/**
 * Представляет человека с именем и ростом.
 */
public class Person {
  private Object name;
  private int height;

  /**
   * Создает Person с именем (как Строку) и ростом.
   *
   * @param name имя человека
   * @param height рост человека
   */
  public Person(String name, int height) {
    setName(name);
    setHeight(height);
  }

  /**
   * Создает Person с именем (как объект Name) и ростом.
   *
   * @param name имя человека
   * @param height рост человека
   * @throws IllegalArgumentException если имя null
   */
  public Person(Name name, int height) {
    if (name == null) {
      throw new IllegalArgumentException("Имя не может быть null.");
    }
    this.name = name.toString();
    setHeight(height);
  }

  /**
   * Устанавливает имя человека.
   *
   * @param name имя для установки
   * @throws IllegalArgumentException если имя равно null
   */
  public void setName(Object name) {
    if (name == null) {
      throw new IllegalArgumentException("Имя не может быть null или пустым.");
    }
    this.name = name;
  }

  /**
   * Устанавливает рост человека.
   *
   * @param height высота для установки
   * @throws IllegalArgumentException если height не является положительным числом
   */
  public void setHeight(int height) {
    if (height <= 0) {
        throw new IllegalArgumentException("Рост должен быть положительным числом.");
    }
    this.height = height;
  }

  /**
   * Возвращает строковое представление Person.
   *
   * @return строковое представление Person
   */
  @Override
  public String toString() {
    return "Имя: " + name + ", Рост: " + height;
  }
}