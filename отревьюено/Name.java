package отревьюено;

/**
 * Представляет имя с фамилией, именем и отчеством.
 */
public class Name {
  private String lastName;
  private String firstName;
  private String patronymic;

  /**
   * Создает Name с фамилией, именем и отчеством.
   *
   * @param lastName фамилия
   * @param firstName имя
   * @param patronymic отчество
   */
  public Name(String lastName, String firstName, String patronymic) {
    setLastName(lastName);
    setFirstName(firstName);
    setPatronymic(patronymic);
  }

  /**
   * Перегруженный конструктор с двумя параметрами.
   *
   * @param lastName фамилия
   * @param firstName имя
   */
  public Name(String lastName, String firstName) {
    this(lastName, firstName, null);
  }

  /**
   * Перегруженный конструктор с одним параметром.
   *
   * @param lastName фамилия
   */
  public Name(String lastName) {
    this(lastName, null, null);  // firstName and patronymic will be null
  }

  /**
   * Устанавливает фамилию.
   *
   * @param lastName фамилия для установки
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Устанавливает имя.
   *
   * @param firstName имя для установки
   * @throws IllegalArgumentException если firstName пусто
   */
  public void setFirstName(String firstName) {
    if (firstName != null && firstName.trim().isEmpty()) {
      throw new IllegalArgumentException("Имя не может быть пустым.");
    }
    this.firstName = firstName != null ? firstName : "";
  }

  /**
   * Устанавливает отчество.
   *
   * @param patronymic отчество для установки
   */
  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic != null ? patronymic : "";
  }

  /**
   * Возвращает строковое представление Имени.
   *
   * @return строковое представление Имени
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    if (lastName != null && !lastName.isEmpty()) {
      sb.append(lastName);
    }

    if (firstName != null && !firstName.isEmpty()) {
      if (sb.length() > 0) {
        sb.append(" ");
      }
      sb.append(firstName);
    }

    if (patronymic != null && !patronymic.isEmpty()) {
      if (sb.length() > 0) {
        sb.append(" ");
      }
      sb.append(patronymic);
    }

    return sb.toString();
  }
}